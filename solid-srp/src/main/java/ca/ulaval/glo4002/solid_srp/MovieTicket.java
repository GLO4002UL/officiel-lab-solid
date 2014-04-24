package ca.ulaval.glo4002.solid_srp;

public abstract class MovieTicket {

    private float price;

    public MovieTicket(float price) {
        this.price = price;
    }

    public float getPrice() {
        return price;
    }
}
