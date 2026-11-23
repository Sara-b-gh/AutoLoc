package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Maintenance;

import java.time.LocalDate;
import java.util.List;

public interface IMaintenanceService {
    Maintenance ajouterMaintenance(Maintenance maintenance);
    Maintenance modifierMaintenance(Maintenance maintenance);
    List<Maintenance> afficherToutesMaintenance();
    Maintenance afficherMaintenanceById(Long id);
    void supprimerMaintenance(Long id);
    List<Maintenance> retournerMaintenancesEntreDeuxDates(LocalDate dateDebut, LocalDate dateFin);
}
