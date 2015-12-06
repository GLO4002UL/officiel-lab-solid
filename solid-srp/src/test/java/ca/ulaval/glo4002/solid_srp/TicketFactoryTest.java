package ca.ulaval.glo4002.solid_srp;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TicketFactoryTest {

    private TicketFactory service;

    @Before
    public void setUp() {
        service = new TicketFactory();
    }

    @Test
    public void createsChildTicketForAgeUpTo10() {
        final int childAge = 9;

        MovieTicket ticket = service.createTicket(childAge, false);

        assertThat(ticket, instanceOf(ChildMovieTicket.class));
    }

    @Test
    public void createsChildTicketForAgeUpTo10Inclusive() {
        final int childAge = 10;

        MovieTicket ticket = service.createTicket(childAge, false);

        assertThat(ticket, instanceOf(ChildMovieTicket.class));
    }

    @Test
    public void createsAChildTicketIfUnder10EvenIfAStudent() {
        final int childAge = 10;

        MovieTicket ticket = service.createTicket(childAge, true);

        assertThat(ticket, instanceOf(ChildMovieTicket.class));
    }

    @Test
    public void createsAStudentTIcketIfNotUnder10AndIsAStudent() {
        final int notAChildAge = 20;

        MovieTicket ticket = service.createTicket(notAChildAge, true);

        assertThat(ticket, instanceOf(StudentMovieTicket.class));
    }

    @Test
    public void createsARegularTicketIfNotUnder10AndNotAStudent() {
        final int notAChildAge = 11;

        MovieTicket ticket = service.createTicket(notAChildAge, false);

        assertThat(ticket, instanceOf(RegularMovieTicket.class));
    }

}
