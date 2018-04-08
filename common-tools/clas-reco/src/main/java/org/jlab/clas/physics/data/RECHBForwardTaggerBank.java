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
public final class RECHBForwardTaggerBank {

    public final short index;
    public final short pindex;
    public final byte detector;
    public final float energy;
    public final float time;
    public final float path;
    public final float chi2;
    public final float x;
    public final float y;
    public final float z;
    public final float dx;
    public final float dy;
    public final float radius;
    public final short size;
    public final short status;

    RECHBForwardTaggerBank(DataBank dbank, int irow) {
        index = dbank.getShort("index", irow);
        pindex = dbank.getShort("pindex", irow);
        detector = dbank.getByte("detector", irow);
        energy = dbank.getFloat("energy", irow);
        time = dbank.getFloat("time", irow);
        path = dbank.getFloat("path", irow);
        chi2 = dbank.getFloat("chi2", irow);
        x = dbank.getFloat("x", irow);
        y = dbank.getFloat("y", irow);
        z = dbank.getFloat("z", irow);
        dx = dbank.getFloat("dx", irow);
        dy = dbank.getFloat("dy", irow);
        radius = dbank.getFloat("radius", irow);
        size = dbank.getShort("size", irow);
        status = dbank.getShort("status", irow);
    }

    static public List<RECHBForwardTaggerBank> getRECHBForwardTaggerBanks(DataBank dataBank) {
        List<RECHBForwardTaggerBank> banks = new ArrayList<>();
        for (int irow = 0; irow < dataBank.rows(); irow++) {
            banks.add(new RECHBForwardTaggerBank(dataBank, irow));
        }
        return banks;
    }
}
