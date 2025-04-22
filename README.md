# Population Dashboard

A simple dashboard web application built with Java Spring Boot (backend) and ReactJS (frontend), using PostgreSQL as the database.

---

## Tech Stack

- **Backend:** Java 21, Spring Boot, Spring Data JPA
- **Frontend:** ReactJS, Axios
- **Database:** PostgreSQL
- **Others:** Maven, Node.js

---

##  Getting Started

### Prerequisites

- Java 17+
- Node.js & npm
- PostgreSQL
- Maven

---

## PostgreSQL Setup

###  Step 1: Run this in your terminal to create the database, user, and grant permissions:

```bash
psql -U postgres -c "CREATE DATABASE population_db;"
psql -U postgres -c "CREATE USER admin WITH PASSWORD 'admin123';"
psql -U postgres -c "GRANT ALL PRIVILEGES ON DATABASE population_db TO admin;"
