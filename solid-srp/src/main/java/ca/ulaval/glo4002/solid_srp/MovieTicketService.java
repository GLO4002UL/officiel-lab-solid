package ca.ulaval.glo4002.solid_srp;

public class MovieTicketService {

    private static final int MAXIMUM_AGE_CHILD_PRICE = 10;
    private TicketPrinter printer;

    public MovieTicketService(TicketPrinter printer) {
        this.printer = printer;
    }

    // TODO add : a flag to know if this is a student. Apply 10%.
    // TODO add : a flag to know whether the ticket should be printed or not.
    public void generateMovieTicket(int personAge) {
        if (personAge <= MAXIMUM_AGE_CHILD_PRICE) {
            print(new ChildMovieTicket());
        } else {
            print(new RegularMovieTicket());
        }
    }

    private void print(MovieTicket ticket) {
        printer.print(ticket);
    }
}
