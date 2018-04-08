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
public final class RECHBScintillatorBank {

    public final short index;
    public final short pindex;
    public final byte detector;
    public final byte sector;
    public final byte layer;
    public final short component;
    public final float energy;
    public final float time;
    public final float path;
    public final float chi2;
    public final float x;
    public final float y;
    public final float z;
    public final float hx;
    public final float hy;
    public final float hz;
    public final short status;

    public RECHBScintillatorBank(DataBank dbank, int irow) {
        index = dbank.getShort("index", irow);
        pindex = dbank.getShort("pindex", irow);
        detector = dbank.getByte("detector", irow);
        sector = dbank.getByte("sector", irow);
        layer = dbank.getByte("layer", irow);
        component = dbank.getShort("component", irow);
        energy = dbank.getFloat("energy", irow);
        time = dbank.getFloat("time", irow);
        path = dbank.getFloat("path", irow);
        chi2 = dbank.getFloat("chi2", irow);
        x = dbank.getFloat("x", irow);
        y = dbank.getFloat("y", irow);
        z = dbank.getFloat("z", irow);
        hx = dbank.getFloat("hx", irow);
        hy = dbank.getFloat("hy", irow);
        hz = dbank.getFloat("hz", irow);
        status = dbank.getShort("status", irow);
    }

    static public List<RECHBScintillatorBank> getRECHBScintillatorBanks(DataBank dataBank) {
        List<RECHBScintillatorBank> banks = new ArrayList<>();
        for (int irow = 0; irow < dataBank.rows(); irow++) {
            banks.add(new RECHBScintillatorBank(dataBank, irow));
        }
        return banks;
    }
}
