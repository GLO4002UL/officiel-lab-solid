package ca.ulaval.glo4002.solid_srp;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MovieTicketServiceTest {

    @Mock
    private TicketPrinter printer;

    @InjectMocks
    private MovieTicketService service;

    @Test
    public void canPrintAChildTicket() {
        final int childAge = 9;

        service.generateMovieTicket(childAge);

        verify(printer).print(isA(ChildMovieTicket.class));
    }

    @Test
    public void canPrintARegularTicket() {
        final int notAChildAge = 11;

        service.generateMovieTicket(notAChildAge);

        verify(printer).print(isA(RegularMovieTicket.class));
    }
}
