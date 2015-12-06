package ca.ulaval.glo4002.solid_srp;

import static org.mockito.BDDMockito.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MovieTicketServiceTest {

    private static final int ANY_AGE = 12;
    private static final boolean IS_STUDENT = true;

    @Mock
    private TicketPrinter printer;

    @Mock
    private TicketFactory factory;

    @Mock
    private MovieTicket generatedTicket;

    @InjectMocks
    private MovieTicketService service;

    @Before
    public void setUp() {
        willReturn(generatedTicket).given(factory).createTicket(anyInt(), anyBoolean());
    }

    @Test
    public void createsTheTicketUsingTheFactory() {
        boolean printTicket = true;

        service.generateMovieTicket(ANY_AGE, IS_STUDENT, printTicket);

        verify(factory).createTicket(ANY_AGE, IS_STUDENT);
    }

    @Test
    public void printsTheTicketIfRequested() {
        boolean printTicket = true;

        service.generateMovieTicket(ANY_AGE, IS_STUDENT, printTicket);

        verify(printer).print(generatedTicket);
    }

    @Test
    public void doesNotPrintTheTicketIfNotRequested() {
        boolean printTicket = false;

        service.generateMovieTicket(ANY_AGE, IS_STUDENT, printTicket);

        verify(printer, never()).print(generatedTicket);
    }
}
