# Application de Gestion de Campagnes et Dons

Cette application Spring Boot permet de gérer des campagnes de collecte de dons et d'enregistrer les dons associés à ces campagnes.Realiser par Rim KAJJOUNE

## Fonctionnalités

- Gestion des campagnes de collecte de dons
- Enregistrement des dons pour une campagne
- Consultation des campagnes actives
- Validation des données
- Gestion des erreurs

## Structure du Projet

```
src/main/java/com/example/controle/
├── controller/
│   └── DonController.java         # API REST
├── dto/
│   └── DonDTO.java                # DTO pour les dons
├── exception/
│   └── GlobalExceptionHandler.java # Gestionnaire d'erreurs global
├── model/
│   ├── Campagne.java              # Entité Campagne
│   └── Don.java                   # Entité Don
├── projection/
│   └── CampagneResume.java        # Projection pour les campagnes actives
├── repository/
│   ├── CampagneRepository.java    # Repository pour Campagne
│   └── DonRepository.java         # Repository pour Don
└── service/
    ├── ServiceCampagne.java       # Service pour les campagnes
    └── ServiceDon.java            # Service pour les dons
```

## API REST

### Campagnes

- `GET /api/campagnes/actives` : Récupère la liste des campagnes actives

### Dons

- `POST /api/campagnes/{id}/dons` : Enregistre un don pour une campagne

## Modèles de Données

### Campagne

```json
{
  "id": 1,
  "nom": "Campagne Test",
  "objectifMontant": 1000.00,
  "dateDebut": "2023-01-01",
  "dateFin": "2023-12-31"
}
```

### Don

```json
{
  "id": 1,
  "nomCampagne": "Campagne Test",
  "nomDonateur": "John Doe",
  "montant": 100.00,
  "date": "2023-06-15"
}
```

## Technologies Utilisées

- Java 17
- Spring Boot 3.4.4
- Spring Data JPA
- H2 Database
- Lombok
- Maven

## Prérequis

- JDK 17 ou supérieur
- Maven 3.6 ou supérieur

## Installation et Exécution

1. Cloner le dépôt
2. Naviguer vers le répertoire du projet
3. Exécuter `mvn clean install`
4. Exécuter `mvn spring-boot:run`

L'application sera accessible à l'adresse `http://localhost:8080`.

## Tests

L'application inclut des tests unitaires et d'intégration :

- Tests unitaires pour les services
- Tests d'intégration pour l'API REST

Pour exécuter les tests : `mvn test`

## Validation des Données

L'application valide les données entrantes :

- Le nom de la campagne est obligatoire
- L'objectif de montant doit être positif
- Les dates de début et de fin sont obligatoires
- Le nom du donateur est obligatoire
- Le montant du don doit être positif
- La date du don est obligatoire

## Gestion des Erreurs

L'application gère les erreurs suivantes :

- Ressource non trouvée (404)
- Données invalides (400)
- Violations de contraintes (400)

## Licence

Ce projet est sous licence MIT. 