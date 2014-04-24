package ca.ulaval.glo4002.solid_dip;

import java.util.LinkedList;
import java.util.List;

public class ConferencesService {
    private ConferencesRepository repository;

    // Do not create two constructors.
    public ConferencesService(ConferencesRepository repository) {
        this.repository = repository;
    }

    public void addConference(Conference conference) {
        repository.persist(conference);
    }

    public String[] searchConferences(String keyword) {
        // This method is very sub-optimal. Do not change it though.
        List<String> descriptions = new LinkedList<>();
        for (Conference conference : repository.findAll()) {
            if (conference.name.contains(keyword)) {
                descriptions.add(displayConferenceByName(conference.name));
            }
        }

        return descriptions.toArray(new String[descriptions.size()]);
    }

    private String displayConferenceByName(String name) {
        Conference conference = repository.findByName(name);
        return conference.name + " -- " + conference.description;
    }
}
