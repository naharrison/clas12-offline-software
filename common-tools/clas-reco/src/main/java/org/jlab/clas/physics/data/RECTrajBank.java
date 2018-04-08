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
public final class RECTrajBank {

    public final short detId;
    public final short trkId;
    public final byte q;
    public final float x;
    public final float y;
    public final float z;
    public final float px;
    public final float py;
    public final float pz;
    public final float pathlength;

    RECTrajBank(DataBank dbank, int irow) {
        detId = dbank.getShort("detId", irow);
        trkId = dbank.getShort("trkId", irow);
        q = dbank.getByte("q", irow);
        x = dbank.getFloat("x", irow);
        y = dbank.getFloat("y", irow);
        z = dbank.getFloat("z", irow);
        px = dbank.getFloat("px", irow);
        py = dbank.getFloat("py", irow);
        pz = dbank.getFloat("pz", irow);
        pathlength = dbank.getFloat("pathlength", irow);
    }

    static public List<RECTrajBank> getRECTrajBanks(DataBank dataBank) {
        List<RECTrajBank> banks = new ArrayList<>();
        for (int irow = 0; irow < dataBank.rows(); irow++) {
            banks.add(new RECTrajBank(dataBank, irow));
        }
        return banks;
    }
}
