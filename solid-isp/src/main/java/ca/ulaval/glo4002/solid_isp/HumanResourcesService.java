package ca.ulaval.glo4002.solid_isp;

// TODO The boss now wants to be incorporated into the normal payroll system
// Create a new implementation of Person called Boss
// Uncomment the related tests
public class HumanResourcesService {

    private final static int HOURS_PER_WEEK = 35;

    public void payCurrentWeek(Payable person) {
        int rawSalary = person.calculateSalary(HOURS_PER_WEEK);
        int netSalary = removeTaxes(rawSalary);
        person.sendCheck(netSalary);
    }

    private int removeTaxes(int rawSalary) {
        return rawSalary / 2;
    }

    public void fire(Fireable person) {
        person.fire();
        removeFromPayroll();
    }

    private void removeFromPayroll() {
        // Not implement, not important for this example.
    }

    public void payBonus(Payable person, int amount) {
        person.sendCheck(amount);
    }

}
