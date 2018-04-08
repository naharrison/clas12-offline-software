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
public final class RECHBTrackBank {

    public final short index;
    public final short pindex;
    public final byte detector;
    public final short status;
    public final byte q;
    public final float chi2;
    public final short NDF;
    public final float px_nomm;
    public final float py_nomm;
    public final float pz_nomm;
    public final float vx_nomm;
    public final float vy_nomm;
    public final float vz_nomm;
    public final float chi2_nomm;
    public final short NDF_nomm;

    public RECHBTrackBank(DataBank dbank, int irow) {
        index = dbank.getShort("index", irow);
        pindex = dbank.getShort("pindex", irow);
        detector = dbank.getByte("detector", irow);
        status = dbank.getShort("status", irow);
        q = dbank.getByte("q", irow);
        chi2 = dbank.getFloat("chi2", irow);
        NDF = dbank.getShort("NDF", irow);
        px_nomm = dbank.getFloat("px_nomm", irow);
        py_nomm = dbank.getFloat("py_nomm", irow);
        pz_nomm = dbank.getFloat("pz_nomm", irow);
        vx_nomm = dbank.getFloat("vx_nomm", irow);
        vy_nomm = dbank.getFloat("vy_nomm", irow);
        vz_nomm = dbank.getFloat("vz_nomm", irow);
        chi2_nomm = dbank.getFloat("chi2_nomm", irow);
        NDF_nomm = dbank.getShort("NDF_nomm", irow);
    }

    static public List<RECHBTrackBank> getRECHBTrackBanks(DataBank dataBank) {
        List<RECHBTrackBank> banks = new ArrayList<>();
        for (int irow = 0; irow < dataBank.rows(); irow++) {
            banks.add(new RECHBTrackBank(dataBank, irow));
        }
        return banks;
    }
}
