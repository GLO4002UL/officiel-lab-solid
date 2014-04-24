package ca.ulaval.glo4002.solid_dip;

// TODO this class uses a repository with an HashMap.
// Since the Conference class implements equals, a linked list would be nice!
// Create ListConferencesRepository which implements ConferencesRepository. 
// Replace the repository in this main with the List one. Make sure the tests still pass!

// You can run this class to find all conferences with "is" in the title.
public class Main {

    public static void main(String[] args) {
        ConferencesRepository repository = createAndFillConferencesRepository();

        ConferencesService service = new ConferencesService(repository);

        for (String description : service.searchConferences("is")) {
            System.out.println("Found : " + description);
        }
    }

    private static ConferencesRepository createAndFillConferencesRepository() {
        Conference javascript = new Conference();
        javascript.name = "Javascript is nice!";
        javascript.description = "Learn javascript";

        Conference ruby = new Conference();
        ruby.name = "Ruby is cool too!";
        ruby.description = "Yay!";

        ConferencesRepository repository = new ConferencesRepository();
        repository.persist(javascript);
        repository.persist(ruby);

        return repository;
    }
}
