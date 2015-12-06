package ca.ulaval.glo4002.solid_srp;

public class TicketFactory {
    private static final int MAXIMUM_AGE_CHILD_PRICE = 10;

    public MovieTicket createTicket(int age, boolean isStudent) {
        if (age <= MAXIMUM_AGE_CHILD_PRICE) {
            return new ChildMovieTicket();
        } else if (isStudent) {
            return new StudentMovieTicket();
        } else {
            return new RegularMovieTicket();
        }
    }

}
