package com.lockbull.composer.item_capsule;

public class Item_intials {
    private String iText;
    private int iPrice;
    private String iUnit;

    public Item_intials(String iText, int iPrice, String iUnit) {
        this.iText = iText;
        this.iPrice = iPrice;
        this.iUnit = iUnit;
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

    public void setiText(String iText) {
        this.iText = iText;
    }

    public void setiPrice(int iPrice) {
        this.iPrice = iPrice;
    }

    public void setiUnit(String iUnit) {
        this.iUnit = iUnit;
    }
    @Override
    public String toString(){
        return iText;
    }
}
