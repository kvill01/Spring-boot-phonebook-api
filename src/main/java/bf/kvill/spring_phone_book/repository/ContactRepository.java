package bf.kvill.spring_phone_book.repository;

import bf.kvill.spring_phone_book.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// Repository pour les opérations CRUD sur Contact
@Repository
public interface ContactRepository extends JpaRepository<Contact, Long>
{
    boolean existsByPhoneNumber(String phoneNumber);

    // Recherche par prénom, sans tenir compte de la casse
    List<Contact> findByFirstNameContainingIgnoreCase(String firstName);

    List<Contact> findByLastNameContainingIgnoreCase(String lastName);

}
