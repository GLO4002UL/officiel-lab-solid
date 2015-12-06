package ca.ulaval.glo4002.solid_dip;

import java.util.LinkedList;
import java.util.List;

public class LinkedListConferencesRepository implements ConferencesRepository {

    public List<Conference> conferences = new LinkedList<>();

    public void persist(Conference conference) {
        conferences.add(conference);
    }

    public Conference findByName(String name) {
        return conferences.stream().filter((c) -> c.name.equals(name)).findFirst().get();
    }

    public Conference[] findAll() {
        return conferences.toArray(new Conference[conferences.size()]);
    }
}
