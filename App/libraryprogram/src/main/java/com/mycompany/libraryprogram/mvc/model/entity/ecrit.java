package com.mycompany.libraryprogram.mvc.model.entity;

import java.util.Date;

public class ecrit {
    private int issn_e;
    private int id_au;
    
    

    public ecrit(int issn_e, int id_au) {
        this.issn_e = issn_e;
        this.id_au = id_au;
    }

    public int getIssn_e() {
        return issn_e;
    }

    public void setIssn_e(int issn_e) {
        this.issn_e = issn_e;
    }

    public int getId_au() {
        return id_au;
    }

    public void setId_au(int id_au) {
        this.id_au = id_au;
    }
    
    
}
