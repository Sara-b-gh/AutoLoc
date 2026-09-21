package tn.esprit.autoloc.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClient;

    @Column(nullable = false, unique = true, length = 20)
    private String nom;

    @Column(nullable = false, unique = true, length = 20)
    private String prenom;

    @Column(nullable = false, unique = true, length = 220)
    private String email;

    @Column(nullable = false, unique = true, length = 20)
    private String telephone;

    @Column(nullable = false, unique = true, length = 20)
    private String numPermis;

    @Column(nullable = false)
    private LocalDate dateInscription;

}
