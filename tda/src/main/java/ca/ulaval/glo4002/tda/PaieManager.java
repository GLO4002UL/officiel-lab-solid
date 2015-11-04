package ca.ulaval.glo4002.tda;

import java.util.List;

public class PaieManager {

    public void payerLesEmployes(Entreprise entreprise) {
        List<Employe> employes = EmployesManager.getInstance().getEmployes(entreprise);

        for (Employe employe : employes) {
            Paie paie;
            if (employe.getType() == TypeEmploye.HORAIRE) {
                double taux = employe.getTauxHoraire();
                double heures = employe.getHeuresTravaillees();
                paie = new Paie(taux * heures);
            } else {
                double salairePeriodique = employe.getSalaireAnnuel() / 52.0;
                paie = new Paie(salairePeriodique);
            }
            entreprise.getSystemePaie().payer(paie);
        }
    }
}
