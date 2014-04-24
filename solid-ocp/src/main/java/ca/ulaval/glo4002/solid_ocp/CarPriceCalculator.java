package ca.ulaval.glo4002.solid_ocp;

public class CarPriceCalculator {

    private static final int POLLUTION_TAX = 1000;

    // TODO : Hummer has gone environment-friendly!
    // They now have an EcoHummer, which has no pollution tax.
    public int calculatePrice(Car car) {
        return car.getPrice() + calculatePolutionTax(car);
    }

    private int calculatePolutionTax(Car car) {
        if (car instanceof Hummer) {
            return POLLUTION_TAX;
        }
        return 0;
    }
}
