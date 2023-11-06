# FullStackProject2

# README

## Application Full Stack avec Docker

Ce projet est une application Full Stack qui se compose d'un backend Spring Boot, d'un frontend React, et d'une base de données MySQL, tous conteneurisés à l'aide de Docker.

### Génération des Images Docker

1. **Backend Spring Boot :**
   - Pour générer l'image Docker pour le backend, nous avons utilisé un Dockerfile. Assurez-vous que le Dockerfile est correctement configuré pour votre application Spring Boot.
   - Exécutez la commande suivante dans le répertoire contenant le Dockerfile :
     ```bash
     docker build -t "fatinebahoum"/springdockerimage .
     ```

2. **Frontend React :**
   - Pour générer l'image Docker pour le frontend React, assurez-vous que le Dockerfile est correctement configuré pour votre application React.
   - Exécutez la commande suivante dans le répertoire contenant le Dockerfile :
     ```bash
     cd src/main/webapp/fullstackreact
     docker build -t "fatinebahoum"/frontenddockerimage .
     ```

### Pull de la Base de Données MySQL

Nous utilisons une image MySQL provenant de Docker Hub. Vous pouvez la tirer en exécutant la commande suivante :

```bash
docker pull mysql
```

### Docker Compose

Nous utilisons Docker Compose pour connecter les services et les exécuter dans un environnement global. Le fichier docker-compose.yml définit les services, les réseaux et les commandes d'exécution. Assurez-vous que le fichier docker-compose.yml est correctement configuré.

### Exécution de l'Application

Pour exécuter l'application, utilisez la commande suivante dans le répertoire contenant le fichier docker-compose.yml :

```bash
docker-compose up
```
En cas d'échec de demarrage du container spring, on le redemarre manuellement depuis docker desktop

Cela démarrera tous les services (backend, frontend, et MySQL) et les connectera dans un réseau Docker.
L'application sera disponible à l'adresse du frontend (par défaut : http://localhost:3000) une fois que tout est démarré.
