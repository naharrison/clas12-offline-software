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
public final class RECCherenkovBank {

    public final short index;
    public final short pindex;
    public final byte detector;
    public final byte sector;
    public final float nphe;
    public final float time;
    public final float path;
    public final float chi2;
    public final float x;
    public final float y;
    public final float z;
    public final float theta;
    public final float phi;
    public final float dtheta;
    public final float dphi;
    public final short status;

    public RECCherenkovBank(DataBank dbank, int irow) {
        index = dbank.getShort("index", irow);
        pindex = dbank.getShort("pindex", irow);
        detector = dbank.getByte("detector", irow);
        sector = dbank.getByte("sector", irow);
        nphe = dbank.getFloat("nphe", irow);
        time = dbank.getFloat("time", irow);
        path = dbank.getFloat("path", irow);
        chi2 = dbank.getFloat("chi2", irow);
        x = dbank.getFloat("x", irow);
        y = dbank.getFloat("y", irow);
        z = dbank.getFloat("z", irow);
        theta = dbank.getFloat("theta", irow);
        phi = dbank.getFloat("phi", irow);
        dtheta = dbank.getFloat("dtheta", irow);
        dphi = dbank.getFloat("dphi", irow);
        status = dbank.getShort("status", irow);
    }

    static public List<RECCherenkovBank> getRECCherenkovBanks(DataBank dataBank) {
        List<RECCherenkovBank> banks = new ArrayList<>();
        for (int irow = 0; irow < dataBank.rows(); irow++) {
            banks.add(new RECCherenkovBank(dataBank, irow));
        }
        return banks;
    }
}
