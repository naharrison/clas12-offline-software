package org.jlab.clas.physics.data;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import org.jlab.io.base.DataBank;
import org.jlab.io.base.DataEvent;

/**
 *
 * class for reconstructed particle with detector information
 *
 * @author kenjo
 *
 */
public final class RECHBDataParticle {

    public final RECHBParticleBank recParticle;
    public final List<RECHBCalorimeterBank> recCalorimeters;
    public final List<RECHBCherenkovBank> recCherenkovs;
    public final List<RECHBForwardTaggerBank> recForwardTaggers;
    public final List<RECHBScintillatorBank> recScintillators;
    public final List<RECHBTrackBank> recTracks;

    private RECHBDataParticle(RECHBParticleBank recParticle,
            List<RECHBCalorimeterBank> recCalorimeters,
            List<RECHBCherenkovBank> recCherenkovs,
            List<RECHBForwardTaggerBank> recForwardTaggers,
            List<RECHBScintillatorBank> recScintillators,
            List<RECHBTrackBank> recTracks) {
        this.recParticle = recParticle;
        this.recCalorimeters = Collections.unmodifiableList(recCalorimeters);
        this.recCherenkovs = Collections.unmodifiableList(recCherenkovs);
        this.recForwardTaggers = Collections.unmodifiableList(recForwardTaggers);
        this.recScintillators = Collections.unmodifiableList(recScintillators);
        this.recTracks = Collections.unmodifiableList(recTracks);
    }

    public static List<RECHBDataParticle> getRECHBDataParticles(DataEvent dataEv) {
        List<RECHBDataParticle.Builder> recBuilders = new ArrayList<>();

        if (dataEv.hasBank("RECHB::Particle")) {
            DataBank partBank = dataEv.getBank("RECHB::Particle");
            for (RECHBParticleBank recParticle : RECHBParticleBank.getRECHBParticleBanks(partBank)) {
                recBuilders.add(new RECHBDataParticle.Builder(recParticle));
            }
        }

        if (dataEv.hasBank("RECHB::Calorimeter")) {
            DataBank calBank = dataEv.getBank("RECHB::Calorimeter");
            for (RECHBCalorimeterBank recCal : RECHBCalorimeterBank.getRECHBCalorimeterBanks(calBank)) {
                if (recCal.pindex >= 0 && recCal.pindex < recBuilders.size()) {
                    recBuilders.get(recCal.pindex).addCalorimeterBank(recCal);
                }
            }
        }

        if (dataEv.hasBank("RECHB::Cherenkov")) {
            DataBank chBank = dataEv.getBank("RECHB::Cherenkov");
            for (RECHBCherenkovBank recCh : RECHBCherenkovBank.getRECHBCherenkovBanks(chBank)) {
                if (recCh.pindex >= 0 && recCh.pindex < recBuilders.size()) {
                    recBuilders.get(recCh.pindex).addCherenkovBank(recCh);
                }
            }
        }

        if (dataEv.hasBank("RECHB::ForwardTagger")) {
            DataBank ftBank = dataEv.getBank("RECHB::ForwardTagger");
            for (RECHBForwardTaggerBank recFT : RECHBForwardTaggerBank.getRECHBForwardTaggerBanks(ftBank)) {
                if (recFT.pindex >= 0 && recFT.pindex < recBuilders.size()) {
                    recBuilders.get(recFT.pindex).addForwardTaggerBank(recFT);
                }
            }
        }

        if (dataEv.hasBank("RECHB::Scintillator")) {
            DataBank scBank = dataEv.getBank("RECHB::Scintillator");
            for (RECHBScintillatorBank recSC : RECHBScintillatorBank.getRECHBScintillatorBanks(scBank)) {
                if (recSC.pindex >= 0 && recSC.pindex < recBuilders.size()) {
                    recBuilders.get(recSC.pindex).addScintillatorBank(recSC);
                }
            }
        }

        if (dataEv.hasBank("RECHB::Track")) {
            DataBank trkBank = dataEv.getBank("RECHB::Track");
            for (RECHBTrackBank recTrk : RECHBTrackBank.getRECHBTrackBanks(trkBank)) {
                if (recTrk.pindex >= 0 && recTrk.pindex < recBuilders.size()) {
                    recBuilders.get(recTrk.pindex).addTrackBank(recTrk);
                }
            }
        }

        List<RECHBDataParticle> recParticles = new ArrayList<>();
        for (RECHBDataParticle.Builder recB : recBuilders) {
            recParticles.add(recB.build());
        }

        return recParticles;
    }

    public static class Builder {

        private final RECHBParticleBank recParticleBank;
        private final List<RECHBCalorimeterBank> recCalorimeterBanks = new ArrayList<>();
        private final List<RECHBCherenkovBank> recCherenkovBanks = new ArrayList<>();
        private final List<RECHBForwardTaggerBank> recForwardTaggerBanks = new ArrayList<>();
        private final List<RECHBScintillatorBank> recScintillatorBanks = new ArrayList<>();
        private final List<RECHBTrackBank> recTrackBanks = new ArrayList<>();

        public Builder(RECHBParticleBank recParticleBank) {
            this.recParticleBank = recParticleBank;
        }

        public Builder addCalorimeterBank(RECHBCalorimeterBank recCalorimeterBank) {
            recCalorimeterBanks.add(recCalorimeterBank);
            return this;
        }

        public Builder addCherenkovBank(RECHBCherenkovBank recCherenkovBank) {
            recCherenkovBanks.add(recCherenkovBank);
            return this;
        }

        public Builder addForwardTaggerBank(RECHBForwardTaggerBank recForwardTaggerBank) {
            recForwardTaggerBanks.add(recForwardTaggerBank);
            return this;
        }

        public Builder addScintillatorBank(RECHBScintillatorBank recScintillatorBank) {
            recScintillatorBanks.add(recScintillatorBank);
            return this;
        }

        public Builder addTrackBank(RECHBTrackBank recTrackBank) {
            recTrackBanks.add(recTrackBank);
            return this;
        }

        public RECHBDataParticle build() {
            return new RECHBDataParticle(recParticleBank,
                    recCalorimeterBanks, recCherenkovBanks,
                    recForwardTaggerBanks, recScintillatorBanks, recTrackBanks);
        }
    }

}
