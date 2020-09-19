package com.lockbull.composer.item_capsule;

public class Compose_Item_intials {
    private String iText;
    private int iPrice;
    private String iUnit;
    private String iqty;
    private float efprice;

    public Compose_Item_intials(String iText, int iPrice, String iUnit, String iqty, float efprice) {
        this.iText = iText;
        this.iPrice = iPrice;
        this.iUnit = iUnit;
        this.iqty = iqty;
        this.efprice = efprice;
    }

    public String getiText() {
        return iText;
    }

    public int getiPrice() {
        return iPrice;
    }

    public String getiUnit() {
        return iUnit;
    }

    public String getIqty() {
        return iqty;
    }

    public float getEfprice() {
        return efprice;
    }

    @Override
    public String toString(){
        return iText;
    }
}
