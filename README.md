# SECURIN_ASSESSMENT_BACKEND_JAVA
# Delhi Weather Data API

## Project Overview

This project is a Spring Boot REST API that processes nearly 20 years of historical Delhi weather data from a CSV file and stores it in a MySQL database for structured querying and analysis.

The application performs automatic CSV ingestion at startup, transforms raw data into structured entities using JPA (Hibernate ORM), and exposes REST endpoints to retrieve filtered weather data and monthly temperature statistics.

### Key Features
- Automatic CSV data ingestion on application startup
- Safe parsing and null handling for missing values
- Storage using MySQL with JPA/Hibernate
- REST APIs for:
  - Weather by date
  - Weather by month (across all years)
  - Monthly temperature statistics (min, max, median)

### Tech Stack
- Java 17+
- Spring Boot
- Spring Data JPA (Hibernate)
- MySQL
- Maven
---


