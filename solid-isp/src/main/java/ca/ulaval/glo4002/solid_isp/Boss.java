package ca.ulaval.glo4002.solid_isp;

public class Boss implements Payable {

    @Override
    public int calculateSalary(int hours) {
        return 1000000;
    }

    @Override
    public void sendCheck(int amount) {
    }

}
