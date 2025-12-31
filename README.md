# Microservices Communication Study: RestTemplate vs Feign vs WebClient

This project demonstrates a comparative study of different synchronous HTTP communication methods in a Spring Boot microservices architecture. It integrates **Eureka Discovery Service** for service registration and discovery.

## 👤 Author
**AMDJAR Abdelwahid**

---

## 🚀 Technologies Stack
- **Framework:** Spring Boot 3.x
- **Service Discovery:** Netflix Eureka
- **HTTP Clients:**
  - **RestTemplate:** Traditional synchronous client.
  - **OpenFeign:** Declarative REST client.
  - **WebClient:** Modern, non-blocking client (used synchronously here).
- **Build Tool:** Maven

---

## 🏗️ Architecture Overview
The project is divided into three main components:
1. **discovery-service**: Eureka Server that acts as a service registry.
2. **service-voiture**: A microservice managing car data (Inventory).
3. **service-client**: A microservice that consumes car data using different HTTP clients.

---

## 🛠️ Getting Started

### 1. Launch Discovery Service
```bash
cd discovery-service
mvn spring-boot:run
```
Registry URL: `http://localhost:8761`

### 2. Launch Microservices
```bash
# In separate terminals
cd service-voiture
mvn spring-boot:run

cd service-client
mvn spring-boot:run
```

---

## 📡 API Endpoints

### Service Voiture (Provider)
- `GET /api/cars/byClient/{clientId}` - Retrieve car details by client ID.

### Service Client (Consumer)
- `GET /api/clients/{id}/car/rest` - Fetch car using **RestTemplate**.
- `GET /api/clients/{id}/car/feign` - Fetch car using **OpenFeign**.
- `GET /api/clients/{id}/car/webclient` - Fetch car using **WebClient**.

---

## 📊 Comparison Summary

| Client | Approach | Best For | Status |
| :--- | :--- | :--- | :--- |
| **RestTemplate** | Imperative | Simple legacy projects | Maintenance Mode |
| **OpenFeign** | Declarative | Clean, interface-based code | Highly Recommended |
| **WebClient** | Reactive/Functional | High performance, modern apps | Future-proof |

---

