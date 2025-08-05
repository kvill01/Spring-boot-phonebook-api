package bf.kvill.spring_phone_book.controller;

import bf.kvill.spring_phone_book.exception.ContactNotFoundException;
import bf.kvill.spring_phone_book.model.Contact;
import bf.kvill.spring_phone_book.repository.ContactRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// Contrôleur REST pour l'API des contacts
@RestController
@RequestMapping("/api/contacts")
public class ContactController {
    
    private final ContactRepository repo;

    // Injection de dépendance
    public ContactController(ContactRepository repo) {
        this.repo = repo;
    }

    // POST /api/contacts - Créer un nouveau contact
    @PostMapping
    public ResponseEntity<Contact> createContact(@Valid @RequestBody Contact contact) {
        Contact savedContact = repo.save(contact);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedContact);
    }

    // GET /api/contacts - Récupérer tous les contacts
    @GetMapping
    public List<Contact> getAllContacts() {
        return repo.findAll();
    }


    // GET /api/contacts/{id} - Récupérer un contact par ID
    @GetMapping("/{id}")
    public ResponseEntity<Contact> getContact(@PathVariable Long id) {
        Optional<Contact> existingContact = repo.findById(id);
        // Retourner Contact
        return existingContact.map(ResponseEntity::ok).orElseThrow(() ->  new ContactNotFoundException("Contact not found"));
    }

    @GetMapping("/searchPhone")
    public ResponseEntity<List<Contact>> searchByphoneNumber(@RequestParam String phoneNumber) {
        List<Contact> results = repo.findContainingByPhoneNumber(phoneNumber);

        if (results.isEmpty()) {
            throw new ContactNotFoundException("No contact found with : " + phoneNumber);
        }

        return ResponseEntity.ok(results);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Contact>> searchByFirstName(@RequestParam String firstName) {
        List<Contact> results = repo.findByFirstNameContainingIgnoreCase(firstName);

        if (results.isEmpty()) {
            throw new ContactNotFoundException("No contact found with : " + firstName);
        }

        return ResponseEntity.ok(results);
    }

    @GetMapping("/searchName")
    public ResponseEntity<List<Contact>> searchByLastName (@RequestParam String lastName) {
        List<Contact> results = repo.findByLastNameContainingIgnoreCase(lastName);

        if (!results.isEmpty()){
            return ResponseEntity.ok(results);
        }

        throw new ContactNotFoundException("No contact found with : " + lastName);
    }

    // PUT /api/contacts/{id} - Mettre à jour un contact
    @PutMapping("/{id}")
    public ResponseEntity<Contact> updateContact(@PathVariable Long id, @Valid @RequestBody Contact contact) {
        Optional<Contact> updatedContact = repo.findById(id);
        if (updatedContact.isPresent()) {
            Contact c = updatedContact.get();
            c.setLastName(contact.getLastName());
            c.setFirstName(contact.getFirstName());
            c.setPhoneNumber(contact.getPhoneNumber());
            return ResponseEntity.ok(repo.save(c));
        }
        throw new ContactNotFoundException("Contact not found");
    }

    // DELETE /api/contacts/{id} - Supprimer un contact
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        throw new ContactNotFoundException("Contact not found");
    }

}
