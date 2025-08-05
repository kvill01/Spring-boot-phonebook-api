package bf.kvill.spring_phone_book.repository;

import bf.kvill.spring_phone_book.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Repository pour les opérations CRUD sur Contact
@Repository
public interface ContactRepository extends JpaRepository<Contact, Long>
{
    boolean existsByPhoneNumber(String phoneNumber);
}
