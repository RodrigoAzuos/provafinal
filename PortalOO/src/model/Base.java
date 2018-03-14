package model;

import java.util.Date;

public class Base {

    private Date criadaEm;
    private Date editadaEm;

    public Base() {
        this.criadaEm = new Date(System.currentTimeMillis());
        }

    public void setEditadaEm() {
        this.editadaEm = new Date(System.currentTimeMillis());
    }

    public Date getCriadaEm() {
        return criadaEm;
    }

    public Date getEditadaEm() {
        return editadaEm;
    }
}
