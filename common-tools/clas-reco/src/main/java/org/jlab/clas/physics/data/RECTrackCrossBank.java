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
public final class RECTrackCrossBank {

    public final short index;
    public final short pindex;
    public final byte detector;
    public final byte sector;
    public final byte layer;
    public final float c_x;
    public final float c_y;
    public final float c_z;
    public final float c_ux;
    public final float c_uy;
    public final float c_uz;
    public final short status;

    public RECTrackCrossBank(DataBank dbank, int irow) {
        index = dbank.getShort("index", irow);
        pindex = dbank.getShort("pindex", irow);
        detector = dbank.getByte("detector", irow);
        sector = dbank.getByte("sector", irow);
        layer = dbank.getByte("layer", irow);
        c_x = dbank.getFloat("c_x", irow);
        c_y = dbank.getFloat("c_y", irow);
        c_z = dbank.getFloat("c_z", irow);
        c_ux = dbank.getFloat("c_ux", irow);
        c_uy = dbank.getFloat("c_uy", irow);
        c_uz = dbank.getFloat("c_uz", irow);
        status = dbank.getShort("status", irow);
    }

    static public List<RECTrackCrossBank> getRECTrackCrossBanks(DataBank dataBank) {
        List<RECTrackCrossBank> banks = new ArrayList<>();
        for (int irow = 0; irow < dataBank.rows(); irow++) {
            banks.add(new RECTrackCrossBank(dataBank, irow));
        }
        return banks;
    }
}
