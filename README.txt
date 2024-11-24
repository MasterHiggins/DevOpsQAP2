Golf Tournament API
Project Overview
This project provides an API for managing a golf tournament, including handling players and competitions. The API is built using Spring Boot and is configured to run in a Docker environment with a MySQL database.

Setup Instructions
Prerequisites
Install Docker and Docker Compose.

Install Java (JDK 22).

Install Maven.

Steps to Run the Project
Clone the Repository

Open a terminal and clone the repository:

sh
git clone https://github.com/yourusername/golf-tournament-api.git
cd golf-tournament-api
Build the Project

Use Maven to build the project:

sh
mvn clean install
Start Docker Containers

Ensure Docker is installed and running on your machine. Then start the services:

sh
docker-compose up --build
Access the API

The API will be accessible at http://localhost:8080.

Using the API
Players Endpoints
Get All Players

GET /api/players

Get Player by ID

GET /api/players/{id}

Create Player

POST /api/players

Example JSON Body:

json
{
    "name": "John Doe",
    "address": "123 Main St",
    "email": "john@example.com",
    "phone": "123-456-7890",
    "joinDate": "2023-01-01",
    "membershipPeriod": 12
}
Update Player

PUT /api/players/{id}

Example JSON Body:

json
{
    "name": "Jane Doe",
    "address": "456 Elm St",
    "email": "jane@example.com",
    "phone": "987-654-3210",
    "joinDate": "2023-02-01",
    "membershipPeriod": 24
}
Delete Player

DELETE /api/players/{id}

Competitions Endpoints
Get All Competitions

GET /api/competitions

Get Competition by ID

GET /api/competitions/{id}

Create Competition

POST /api/competitions

Example JSON Body:

json
{
    "start": "2023-03-01",
    "end": "2023-03-05",
    "venue": "Green Valley",
    "entryCost": 100.0,
    "prizeMoney": 5000.0
}
Update Competition

PUT /api/competitions/{id}

Example JSON Body:

json
{
    "start": "2023-04-01",
    "end": "2023-04-06",
    "venue": "Blue Lake",
    "entryCost": 150.0,
    "prizeMoney": 7500.0
}
Delete Competition

DELETE /api/competitions/{id}

Add Player to Competition

POST /api/competitions/{competitionId}/players/{playerId}

Remove Player from Competition

DELETE /api/competitions/{competitionId}/players/{playerId}