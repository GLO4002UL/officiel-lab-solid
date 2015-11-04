package ca.ulaval.glo4002.tda;

import java.util.List;

public class EmployesManager {

    private static EmployesManager instance;

    public static EmployesManager getInstance() {
        if (instance == null) {
            instance = new EmployesManager();
        }

        return instance;
    }

    public List<Employe> getEmployes(Entreprise entreprise) {
        return entreprise.getEmployes();
    }
}
