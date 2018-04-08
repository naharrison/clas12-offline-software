package org.jlab.clas.physics.data;

import java.util.List;
import java.util.ArrayList;
import org.jlab.io.base.DataBank;

/**
 *
 * Data structure for HIPO banks generated from HIPO JSON files
 *
 * @author kenjo
 *
 */
public final class RECParticleBank {

    public final int pid;
    public final float px;
    public final float py;
    public final float pz;
    public final float vx;
    public final float vy;
    public final float vz;
    public final byte charge;
    public final float beta;
    public final float chi2pid;
    public final short status;

    public RECParticleBank(DataBank dbank, int irow) {
        pid = dbank.getInt("pid", irow);
        px = dbank.getFloat("px", irow);
        py = dbank.getFloat("py", irow);
        pz = dbank.getFloat("pz", irow);
        vx = dbank.getFloat("vx", irow);
        vy = dbank.getFloat("vy", irow);
        vz = dbank.getFloat("vz", irow);
        charge = dbank.getByte("charge", irow);
        beta = dbank.getFloat("beta", irow);
        chi2pid = dbank.getFloat("chi2pid", irow);
        status = dbank.getShort("status", irow);
    }

    static public List<RECParticleBank> getRECParticleBanks(DataBank dataBank) {
        List<RECParticleBank> banks = new ArrayList<>();
        for (int irow = 0; irow < dataBank.rows(); irow++) {
            banks.add(new RECParticleBank(dataBank, irow));
        }
        return banks;
    }
}
