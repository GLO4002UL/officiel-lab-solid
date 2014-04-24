package ca.ulaval.glo4002.solid_lsp;

public class Boat implements Vehicule {

    private int length;
    private String deckColor;
    private String cabinColor;

    @Override
    public void setColor(String color) {
        this.deckColor = color;
        this.cabinColor = "dark " + color;
    }

    @Override
    public void setLength(int length) {
        this.length = length;
    }

    public String getCabinColor() {
        return cabinColor;
    }

}
