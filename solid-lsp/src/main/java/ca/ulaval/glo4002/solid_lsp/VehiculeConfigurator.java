package ca.ulaval.glo4002.solid_lsp;

// TODO The client would like to be able to configure the wheel size.
// Add method withWheelSize(int).
public class VehiculeConfigurator {

    private Vehicule vehicule;

    public VehiculeConfigurator(Vehicule vehicule) {
        this.vehicule = vehicule;
    }

    public VehiculeConfigurator withColor(String color) {
        vehicule.setColor(color);
        return this;
    }

    public VehiculeConfigurator withLength(int length) {
        vehicule.setLength(length);
        return this;
    }
}
