package bf.kvill.spring_phone_book.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Entité Contact pour la base de données
@Entity
@Table(name = "contacts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contact
{
    // ID auto-généré
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nom de famille
    private String lastName;
    
    // Prénom
    private String firstName;

    // Numéro de téléphone unique
    @Column(unique = true)
    private String phoneNumber;

}
