package ca.ulaval.glo4002.solid_isp;

public class JuniorEmployee implements Person {

    private final static int HOURLY_WAGE = 30;

    @Override
    public int calculateSalary(int hours) {
        return hours * HOURLY_WAGE;
    }

    @Override
    public void sendCheck(int amount) {
        // Not important here.
    }

    @Override
    public void fire() {
        // Not important here
    }

}
