package bf.kvill.spring_phone_book.controller;

import bf.kvill.spring_phone_book.model.Contact;
import bf.kvill.spring_phone_book.repository.ContactRepository;
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

    // GET /api/contacts - Récupérer tous les contacts
    @GetMapping
    public List<Contact> getAllContacts() {
        return repo.findAll();
    }

    // POST /api/contacts - Créer un nouveau contact
    @PostMapping
    public ResponseEntity<Contact> createContact(@RequestBody Contact contact) {
        Contact savedContact = repo.save(contact);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedContact);
    }

    // GET /api/contacts/{id} - Récupérer un contact par ID
    @GetMapping ("/{id}")
    public ResponseEntity<Optional<Contact>> getContact(@PathVariable Long id) {
        Optional<Contact> existingContact = repo.findById(id);
        if (existingContact.isPresent()){
            return ResponseEntity.ok(existingContact);
        }
        return ResponseEntity.notFound().build();
    }

    // PUT /api/contacts/{id} - Mettre à jour un contact
    @PutMapping("/{id}")
    public ResponseEntity<Contact> updateContact(@PathVariable Long id, @RequestBody Contact contact) {
        Optional<Contact> updatedContact = repo.findById(id);
        if (updatedContact.isPresent()) {
            Contact c = updatedContact.get();
            c.setLastName(contact.getLastName());
            c.setFirstName(contact.getFirstName());
            c.setPhoneNumber(contact.getPhoneNumber());
            return ResponseEntity.ok(repo.save(c));
        }
        return ResponseEntity.notFound().build();
    }

    // DELETE /api/contacts/{id} - Supprimer un contact
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
