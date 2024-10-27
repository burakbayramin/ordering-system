# Ordering System Project

This project demonstrates microservices architecture while applying Clean Architecture, Hexagonal Architecture, and Domain-Driven Design (DDD) principles.

## Table of Contents
- [Overview](#overview)
- [Architectural Concepts](#architectural-concepts)
  - [Microservices with Spring Boot](#microservices-with-spring-boot)
  - [Clean Architecture](#clean-architecture)
  - [Hexagonal Architecture](#hexagonal-architecture)
  - [Domain-Driven Design](#domain-driven-design)
  - [Event-Driven Services with Apache Kafka](#event-driven-services-with-apache-kafka)
- [Architectural Patterns](#architectural-patterns)
  - [SAGA Pattern](#saga-pattern)
  - [Outbox Pattern](#outbox-pattern)
  - [CQRS Pattern](#cqrs-pattern)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
  - [Running the Services](#running-the-services)
- [Deployment](#deployment)
  - [Local Kubernetes with Docker Desktop](#local-kubernetes-with-docker-desktop)
  - [Kubernetes on Google Cloud with GKE](#kubernetes-on-google-cloud-with-gke)
- [Project Structure](#project-structure)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)

## Overview

Ordering System is a project that consists of four Java microservices developed with Spring Boot. Each microservice is structured according to Clean and Hexagonal Architecture principles and applies Domain-Driven Design in the domain layer.

Inter-service communication is handled asynchronously using Apache Kafka in an event-driven approach. This setup allows the implementation of architectural patterns like SAGA, Outbox, and CQRS. The project serves as an ideal example for those who want to learn and apply microservices architecture and related principles hands-on.

## Architectural Concepts

### Microservices with Spring Boot
- Develop independent, deployable services using Spring Boot
- Each service handles a specific business capability

### Clean Architecture
- Organize code to separate concerns effectively
- Ensure business logic is independent of frameworks and external agencies

### Hexagonal Architecture
- Use ports and adapters to decouple core business logic from external systems
- Facilitate easier testing and maintenance

### Domain-Driven Design
- Focus on the core domain and domain logic
- Create a shared language between technical and domain experts

### Event-Driven Services with Apache Kafka
- Use Apache Kafka for inter-service communication
- Enable asynchronous communication and scalability

## Architectural Patterns

### SAGA Pattern
- Manage data consistency across multiple microservices
- Implement distributed transactions

### Outbox Pattern
- Ensure reliable message delivery
- Use a transactional outbox to store messages

### CQRS Pattern
- Separate read and write models
- Optimize performance and scalability

## Technologies Used
- Java 17+
- Spring Boot
- Spring Data JPA
- Apache Kafka
- PostgreSQL
- Docker & Docker Compose
- Kubernetes
- Google Kubernetes Engine (GKE)

## Getting Started

### Prerequisites
- Java 17 or higher
- Docker Desktop
- Maven
- Kubernetes CLI (kubectl)
- Google Cloud SDK (for GKE deployment)

### Installation

1. Clone the repository
```bash
git clone https://github.com/burakbayramin/ordering-system.git
```

2. Navigate to the project directory
```bash
cd ordering-system
```

3. Build the services
```bash
mvn clean install
```

### Running the Services

**Using Docker Compose**
```bash
docker-compose up
```

**Running Individually**

Navigate to each service directory and run:
```bash
mvn spring-boot:run
```

## Deployment

### Local Kubernetes with Docker Desktop

1. Enable Kubernetes in Docker Desktop settings

2. Apply Kubernetes configurations
```bash
kubectl apply -f kubernetes/
```

## Contributing

Contributions are welcome! Please open an issue or submit a pull request for any improvements or fixes.

## License

This project is licensed under the MIT License. See the LICENSE file for details.

## Contact

For any questions or suggestions, please contact burakbyrmn@gmail.com