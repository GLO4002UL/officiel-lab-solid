package ca.ulaval.glo4002.solid_isp;

import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class HumanResourcesServiceTest {

    private static final int HOURS_PER_WEEK = 35;

    private HumanResourcesService service;

    @Before
    public void createService() {
        service = new HumanResourcesService();
    }

    @Test
    public void canPayASeniorEmployee() {
        final int expectedNetSalary = 1400;
        final int weeklySalary = 2800;
        Person senior = mock(SeniorEmployee.class);
        willReturn(weeklySalary).given(senior).calculateSalary(HOURS_PER_WEEK);

        service.payCurrentWeek(senior);

        verify(senior).sendCheck(expectedNetSalary);
    }

    @Test
    public void canPayAJuniorEmployee() {
        final int expectedNetSalary = 525;
        final int weeklySalary = 1050;
        Person junior = mock(JuniorEmployee.class);
        willReturn(weeklySalary).given(junior).calculateSalary(HOURS_PER_WEEK);

        service.payCurrentWeek(junior);

        verify(junior).sendCheck(expectedNetSalary);
    }

    // @Test
    // public void canPayABoss() {
    // final int expectedNetSalary = 50000;
    // final int weeklySalary = 100000;
    // Person boss = mock(Boss.class);
    // willReturn(weeklySalary).given(boss).calculateSalary(HOURS_PER_WEEK);
    //
    // service.payCurrentWeek(boss);
    //
    // verify(boss).sendCheck(expectedNetSalary);
    // }

    @Test
    public void canPayBonusToSeniorEmployee() {
        final int bonus = 500;
        Person senior = mock(SeniorEmployee.class);

        service.payBonus(senior, bonus);

        verify(senior).sendCheck(bonus);
    }

    @Test
    public void canPayBonusToJuniorEmployee() {
        final int bonus = 500;
        Person junior = mock(JuniorEmployee.class);

        service.payBonus(junior, bonus);

        verify(junior).sendCheck(bonus);
    }

    // @Test
    // public void canPayBonusToBossEmployee() {
    // final int bonus = 500;
    // Person boss = mock(Boss.class);
    //
    // service.payBonus(boss, bonus);
    //
    // verify(boss).sendCheck(bonus);
    // }

    @Test
    public void canFireASeniorEmployee() {
        Person senior = mock(SeniorEmployee.class);

        service.fire(senior);

        verify(senior).fire();
    }

    @Test
    public void canFireAJuniorEmployee() {
        Person junior = mock(JuniorEmployee.class);

        service.fire(junior);

        verify(junior).fire();
    }

    // @Test
    // public void cannotFireBoss() {
    // Person boss = mock(Boss.class);
    //
    // /* This should NOT compile */
    // service.fire(boss);
    //
    // verify(boss).fire();
    // }
}
