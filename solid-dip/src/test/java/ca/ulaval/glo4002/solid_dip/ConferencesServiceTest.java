package ca.ulaval.glo4002.solid_dip;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ConferencesServiceTest {
    @Mock
    private ConferencesRepository repository;

    @InjectMocks
    private ConferencesService conferencesService;

    @Test
    public void canAddAConferenceAndPersistIt() {
        Conference conference = mock(Conference.class);
        conferencesService.addConference(conference);

        verify(repository).persist(conference);
    }

    @Test
    public void canListConferencesFromRepository() {
        final String clojureName = "clojure";
        final String clojureDescription = "description clojure";
        final String clojureSearchDescription = clojureName + " -- " + clojureDescription;

        Conference haskellConference = createAndAddConference("haskell", "description haskell");
        Conference clojureConference = createAndAddConference(clojureName, clojureDescription);
        Conference[] conferences = {haskellConference, clojureConference};
        willReturn(conferences).given(repository).findAll();

        String[] descriptions = conferencesService.searchConferences("clo");

        assertEquals(1, descriptions.length);
        assertEquals(clojureSearchDescription, descriptions[0]);
    }

    private Conference createAndAddConference(String name, String description) {
        Conference conference = mock(Conference.class);
        conference.name = name;
        conference.description = description;

        willReturn(conference).given(repository).findByName(name);

        return conference;
    }
}
