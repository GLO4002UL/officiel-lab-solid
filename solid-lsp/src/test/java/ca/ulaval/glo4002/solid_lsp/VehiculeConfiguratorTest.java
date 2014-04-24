package ca.ulaval.glo4002.solid_lsp;

import static org.junit.Assert.*;

import org.junit.Test;

// This is an integration test
public class VehiculeConfiguratorTest {

    @Test
    public void canConfigureABoat() {
        final String color = "blue";
        final String expectedCabinColor = "dark blue";
        Boat boat = new Boat();

        new VehiculeConfigurator(boat).withColor(color).withLength(50);

        assertEquals(expectedCabinColor, boat.getCabinColor());
    }

    @Test
    public void canConfigureACar() {
        final int length = 10;
        final int expectedWidth = 5;
        Car car = new Car();

        new VehiculeConfigurator(car).withColor("orange").withLength(length);

        assertEquals(expectedWidth, car.getWidth());
    }
}
