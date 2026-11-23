package tn.esprit.autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.autoloc.domain.CategorieVehicule;
import tn.esprit.autoloc.domain.StatutVehicule;
import tn.esprit.autoloc.domain.Vehicule;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface VehiculeRepository extends JpaRepository<Vehicule ,Long> {
    List<Vehicule> findByMarque(String marque);
    /* SELECT * FROM vehicule WHERE marque = ? */
    List<Vehicule> findByCategorie(CategorieVehicule categorie);
    List<Vehicule> findByStatut(StatutVehicule statut);
    List<Vehicule> findByMarqueContaining(String marque);
    List<Vehicule> findByModeleStartingWith(String modele);
    List<Vehicule> findByTarifJournalierGreaterThan(BigDecimal tarif);
    List<Vehicule> findByTarifJournalierLessThan(BigDecimal tarif);
    List<Vehicule> findByTarifJournalierGreaterThanEqual(BigDecimal tarif);
    List<Vehicule> findByMarqueAndStatut(String marque, StatutVehicule statut);
    List<Vehicule> findByCategorieIn(List<CategorieVehicule> categories);
    List<Vehicule> findByMarqueAndTarifJournalierLessThan(String marque, BigDecimal tarif);
    List<Vehicule> findByStatutOrderByTarifJournalierAsc(StatutVehicule statut);
    List<Vehicule> findAllByOrderByTarifJournalierDesc();
}
