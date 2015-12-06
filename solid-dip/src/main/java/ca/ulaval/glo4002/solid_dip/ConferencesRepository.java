package ca.ulaval.glo4002.solid_dip;

public interface ConferencesRepository {

    Conference findByName(String name);

    void persist(Conference conference);

    Conference[] findAll();

}
