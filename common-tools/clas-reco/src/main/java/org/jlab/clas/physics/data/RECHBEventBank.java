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
public final class RECHBEventBank {

    public final int NRUN;
    public final int NEVENT;
    public final float EVNTime;
    public final byte TYPE;
    public final short EvCAT;
    public final short NPGP;
    public final long TRG;
    public final float BCG;
    public final double LT;
    public final float STTime;
    public final float RFTime;
    public final byte Helic;
    public final float PTIME;

    RECHBEventBank(DataBank dbank, int irow) {
        NRUN = dbank.getInt("NRUN", irow);
        NEVENT = dbank.getInt("NEVENT", irow);
        EVNTime = dbank.getFloat("EVNTime", irow);
        TYPE = dbank.getByte("TYPE", irow);
        EvCAT = dbank.getShort("EvCAT", irow);
        NPGP = dbank.getShort("NPGP", irow);
        TRG = dbank.getLong("TRG", irow);
        BCG = dbank.getFloat("BCG", irow);
        LT = dbank.getDouble("LT", irow);
        STTime = dbank.getFloat("STTime", irow);
        RFTime = dbank.getFloat("RFTime", irow);
        Helic = dbank.getByte("Helic", irow);
        PTIME = dbank.getFloat("PTIME", irow);
    }

    static public List<RECHBEventBank> getRECHBEventBanks(DataBank dataBank) {
        List<RECHBEventBank> banks = new ArrayList<>();
        for (int irow = 0; irow < dataBank.rows(); irow++) {
            banks.add(new RECHBEventBank(dataBank, irow));
        }
        return banks;
    }
}
