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
public final class RECDataParticle {

    public final RECParticleBank recParticle;
    public final List<RECCalorimeterBank> recCalorimeters;
    public final List<RECCherenkovBank> recCherenkovs;
    public final List<RECForwardTaggerBank> recForwardTaggers;
    public final List<RECScintillatorBank> recScintillators;
    public final List<RECTrackBank> recTracks;

    private RECDataParticle(RECParticleBank recParticle,
            List<RECCalorimeterBank> recCalorimeters,
            List<RECCherenkovBank> recCherenkovs,
            List<RECForwardTaggerBank> recForwardTaggers,
            List<RECScintillatorBank> recScintillators,
            List<RECTrackBank> recTracks) {
        this.recParticle = recParticle;
        this.recCalorimeters = Collections.unmodifiableList(recCalorimeters);
        this.recCherenkovs = Collections.unmodifiableList(recCherenkovs);
        this.recForwardTaggers = Collections.unmodifiableList(recForwardTaggers);
        this.recScintillators = Collections.unmodifiableList(recScintillators);
        this.recTracks = Collections.unmodifiableList(recTracks);
    }

    public static List<RECDataParticle> getRECDataParticles(DataEvent dataEv) {
        List<RECDataParticle.Builder> recBuilders = new ArrayList<>();

        if (dataEv.hasBank("REC::Particle")) {
            DataBank partBank = dataEv.getBank("REC::Particle");
            for (RECParticleBank recParticle : RECParticleBank.getRECParticleBanks(partBank)) {
                recBuilders.add(new RECDataParticle.Builder(recParticle));
            }
        }

        if (dataEv.hasBank("REC::Calorimeter")) {
            DataBank calBank = dataEv.getBank("REC::Calorimeter");
            for (RECCalorimeterBank recCal : RECCalorimeterBank.getRECCalorimeterBanks(calBank)) {
                if (recCal.pindex >= 0 && recCal.pindex < recBuilders.size()) {
                    recBuilders.get(recCal.pindex).addCalorimeterBank(recCal);
                }
            }
        }

        if (dataEv.hasBank("REC::Cherenkov")) {
            DataBank chBank = dataEv.getBank("REC::Cherenkov");
            for (RECCherenkovBank recCh : RECCherenkovBank.getRECCherenkovBanks(chBank)) {
                if (recCh.pindex >= 0 && recCh.pindex < recBuilders.size()) {
                    recBuilders.get(recCh.pindex).addCherenkovBank(recCh);
                }
            }
        }

        if (dataEv.hasBank("REC::ForwardTagger")) {
            DataBank ftBank = dataEv.getBank("REC::ForwardTagger");
            for (RECForwardTaggerBank recFT : RECForwardTaggerBank.getRECForwardTaggerBanks(ftBank)) {
                if (recFT.pindex >= 0 && recFT.pindex < recBuilders.size()) {
                    recBuilders.get(recFT.pindex).addForwardTaggerBank(recFT);
                }
            }
        }

        if (dataEv.hasBank("REC::Scintillator")) {
            DataBank scBank = dataEv.getBank("REC::Scintillator");
            for (RECScintillatorBank recSC : RECScintillatorBank.getRECScintillatorBanks(scBank)) {
                if (recSC.pindex >= 0 && recSC.pindex < recBuilders.size()) {
                    recBuilders.get(recSC.pindex).addScintillatorBank(recSC);
                }
            }
        }

        if (dataEv.hasBank("REC::Track")) {
            DataBank trkBank = dataEv.getBank("REC::Track");
            for (RECTrackBank recTrk : RECTrackBank.getRECTrackBanks(trkBank)) {
                if (recTrk.pindex >= 0 && recTrk.pindex < recBuilders.size()) {
                    recBuilders.get(recTrk.pindex).addTrackBank(recTrk);
                }
            }
        }

        List<RECDataParticle> recParticles = new ArrayList<>();
        for (RECDataParticle.Builder recB : recBuilders) {
            recParticles.add(recB.build());
        }

        return recParticles;
    }

    public static class Builder {

        private final RECParticleBank recParticleBank;
        private final List<RECCalorimeterBank> recCalorimeterBanks = new ArrayList<>();
        private final List<RECCherenkovBank> recCherenkovBanks = new ArrayList<>();
        private final List<RECForwardTaggerBank> recForwardTaggerBanks = new ArrayList<>();
        private final List<RECScintillatorBank> recScintillatorBanks = new ArrayList<>();
        private final List<RECTrackBank> recTrackBanks = new ArrayList<>();

        public Builder(RECParticleBank recParticleBank) {
            this.recParticleBank = recParticleBank;
        }

        public Builder addCalorimeterBank(RECCalorimeterBank recCalorimeterBank) {
            recCalorimeterBanks.add(recCalorimeterBank);
            return this;
        }

        public Builder addCherenkovBank(RECCherenkovBank recCherenkovBank) {
            recCherenkovBanks.add(recCherenkovBank);
            return this;
        }

        public Builder addForwardTaggerBank(RECForwardTaggerBank recForwardTaggerBank) {
            recForwardTaggerBanks.add(recForwardTaggerBank);
            return this;
        }

        public Builder addScintillatorBank(RECScintillatorBank recScintillatorBank) {
            recScintillatorBanks.add(recScintillatorBank);
            return this;
        }

        public Builder addTrackBank(RECTrackBank recTrackBank) {
            recTrackBanks.add(recTrackBank);
            return this;
        }

        public RECDataParticle build() {
            return new RECDataParticle(recParticleBank,
                    recCalorimeterBanks, recCherenkovBanks,
                    recForwardTaggerBanks, recScintillatorBanks, recTrackBanks);
        }
    }

}
