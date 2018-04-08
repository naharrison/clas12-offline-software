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
public final class RECVertDocaBank {

    public final short index1;
    public final short index2;
    public final float x;
    public final float y;
    public final float z;
    public final float x1;
    public final float y1;
    public final float z1;
    public final float cx1;
    public final float cy1;
    public final float cz1;
    public final float x2;
    public final float y2;
    public final float z2;
    public final float cx2;
    public final float cy2;
    public final float cz2;
    public final float r;

    public RECVertDocaBank(DataBank dbank, int irow) {
        index1 = dbank.getShort("index1", irow);
        index2 = dbank.getShort("index2", irow);
        x = dbank.getFloat("x", irow);
        y = dbank.getFloat("y", irow);
        z = dbank.getFloat("z", irow);
        x1 = dbank.getFloat("x1", irow);
        y1 = dbank.getFloat("y1", irow);
        z1 = dbank.getFloat("z1", irow);
        cx1 = dbank.getFloat("cx1", irow);
        cy1 = dbank.getFloat("cy1", irow);
        cz1 = dbank.getFloat("cz1", irow);
        x2 = dbank.getFloat("x2", irow);
        y2 = dbank.getFloat("y2", irow);
        z2 = dbank.getFloat("z2", irow);
        cx2 = dbank.getFloat("cx2", irow);
        cy2 = dbank.getFloat("cy2", irow);
        cz2 = dbank.getFloat("cz2", irow);
        r = dbank.getFloat("r", irow);
    }

    static public List<RECVertDocaBank> getRECVertDocaBanks(DataBank dataBank) {
        List<RECVertDocaBank> banks = new ArrayList<>();
        for (int irow = 0; irow < dataBank.rows(); irow++) {
            banks.add(new RECVertDocaBank(dataBank, irow));
        }
        return banks;
    }
}
