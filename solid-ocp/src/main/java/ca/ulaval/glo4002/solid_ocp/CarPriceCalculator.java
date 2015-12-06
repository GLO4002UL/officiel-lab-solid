package ca.ulaval.glo4002.solid_ocp;

public class CarPriceCalculator {

    // TODO : Hummer has gone environment-friendly!
    // They now have an EcoHummer, which has no pollution tax.
    public int calculatePrice(Car car) {
        return car.getPrice() + car.calculatePolutionTax();
    }
}
