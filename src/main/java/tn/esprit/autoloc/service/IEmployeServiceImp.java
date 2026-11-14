package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.repository.EmployeRepository;
import tn.esprit.autoloc.repository.AgenceRepository;


import java.util.List;

@Service
@AllArgsConstructor
public class IEmployeServiceImp implements IEmployeService {

    private final EmployeRepository employeRepository;
    private final AgenceRepository agenceRepository;
    @Override
    public Employe ajouterEmploye(Employe employe) {
        return employeRepository.save(employe);
    }

    @Override
    public Employe modifierEmploye(Employe employe) {
        return employeRepository.save(employe);
    }

    @Override
    public List<Employe> afficherToutesEmploye() {
        return employeRepository.findAll();
    }

    @Override
    public Employe afficherEmployeById(Long id) {
        return employeRepository.findById(id).orElse(null);
    }

    @Override
    public void supprimerEmploye(Long id) {
        employeRepository.deleteById(id);

    }
    @Override
    @Transactional
    public Employe desaffecterEmploye(Long idEmploye) {

        Employe employe = employeRepository.findById(idEmploye).get();
        employe.setAgence(null);
        return employeRepository.save(employe);
    }

    @Override
    @Transactional
    public Employe affecterEmploye(Long idEmploye, Long idAgence) {

        Employe employe = employeRepository.findById(idEmploye).get();
        Agence agence = agenceRepository.findById(idAgence).get();
        employe.setAgence(agence);
        return employeRepository.save(employe);
    }
}
