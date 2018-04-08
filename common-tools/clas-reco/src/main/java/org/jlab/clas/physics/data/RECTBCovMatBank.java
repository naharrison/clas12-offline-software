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
public final class RECTBCovMatBank {

    public final short index;
    public final float C11;
    public final float C12;
    public final float C13;
    public final float C14;
    public final float C15;
    public final float C22;
    public final float C23;
    public final float C24;
    public final float C25;
    public final float C33;
    public final float C34;
    public final float C35;
    public final float C44;
    public final float C45;
    public final float C55;

    RECTBCovMatBank(DataBank dbank, int irow) {
        index = dbank.getShort("index", irow);
        C11 = dbank.getFloat("C11", irow);
        C12 = dbank.getFloat("C12", irow);
        C13 = dbank.getFloat("C13", irow);
        C14 = dbank.getFloat("C14", irow);
        C15 = dbank.getFloat("C15", irow);
        C22 = dbank.getFloat("C22", irow);
        C23 = dbank.getFloat("C23", irow);
        C24 = dbank.getFloat("C24", irow);
        C25 = dbank.getFloat("C25", irow);
        C33 = dbank.getFloat("C33", irow);
        C34 = dbank.getFloat("C34", irow);
        C35 = dbank.getFloat("C35", irow);
        C44 = dbank.getFloat("C44", irow);
        C45 = dbank.getFloat("C45", irow);
        C55 = dbank.getFloat("C55", irow);
    }

    static public List<RECTBCovMatBank> getRECTBCovMatBanks(DataBank dataBank) {
        List<RECTBCovMatBank> banks = new ArrayList<>();
        for (int irow = 0; irow < dataBank.rows(); irow++) {
            banks.add(new RECTBCovMatBank(dataBank, irow));
        }
        return banks;
    }
}
