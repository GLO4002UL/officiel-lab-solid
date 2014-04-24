package ca.ulaval.glo4002.solid_lsp;

public class Car implements Vehicule {

    private int length;
    private int width;
    private String color;

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void setLength(int length) {
        this.length = length;
        this.width = length / 2;
    }

    public int getWidth() {
        return width;
    }

}
