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
public final class RECHBCalorimeterBank {

    public final short index;
    public final short pindex;
    public final byte detector;
    public final byte sector;
    public final byte layer;
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
    public final float lu;
    public final float lv;
    public final float lw;
    public final float du;
    public final float dv;
    public final float dw;
    public final float m2u;
    public final float m2v;
    public final float m2w;
    public final short status;

    RECHBCalorimeterBank(DataBank dbank, int irow) {
        index = dbank.getShort("index", irow);
        pindex = dbank.getShort("pindex", irow);
        detector = dbank.getByte("detector", irow);
        sector = dbank.getByte("sector", irow);
        layer = dbank.getByte("layer", irow);
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
        lu = dbank.getFloat("lu", irow);
        lv = dbank.getFloat("lv", irow);
        lw = dbank.getFloat("lw", irow);
        du = dbank.getFloat("du", irow);
        dv = dbank.getFloat("dv", irow);
        dw = dbank.getFloat("dw", irow);
        m2u = dbank.getFloat("m2u", irow);
        m2v = dbank.getFloat("m2v", irow);
        m2w = dbank.getFloat("m2w", irow);
        status = dbank.getShort("status", irow);
    }

    static public List<RECHBCalorimeterBank> getRECHBCalorimeterBanks(DataBank dataBank) {
        List<RECHBCalorimeterBank> banks = new ArrayList<>();
        for (int irow = 0; irow < dataBank.rows(); irow++) {
            banks.add(new RECHBCalorimeterBank(dataBank, irow));
        }
        return banks;
    }
}
