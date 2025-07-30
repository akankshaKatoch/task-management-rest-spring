# 📝 Task Management REST API – Spring Boot Project

A simple RESTful Task Management API built with Spring Boot. This project is developed in **two phases**:

---

## 🚀 Phase 1: Basic CRUD Functionality

In this phase, a basic Spring Boot REST API was created to manage tasks. The API supports the following operations:

- ✅ Create Task
- 📋 Get All Tasks
- 🔍 Get Task by ID
- ✏️ Update Task
- ❌ Delete Task

### 🛠️ Tech Stack

- **Java**
- **Spring Boot**
- **Spring Web**
- **Spring Data JPA**
- **H2 Database** (in-memory for easy testing)
- **Postman** or **Command Line (Bash)** for API testing

> Sample screenshots included using Bash terminal for testing API endpoints.

---

## 🤖 Phase 2: LLM / OpenAI NLP Integration (In Progress)

This phase aims to enhance the application by integrating OpenAI’s GPT model to enable natural language task creation and smart task suggestions.

### 🔮 Planned Features:

- Natural Language Input → Structured Task
- Smart Task Prioritization
- Task Summary Generator
- Daily Task Digest via NLP

> 🧠 Example: User says “Remind me to call the client on Monday,” and the system creates a task with title, due date, and default priority.

---

## 📁 Folder Structure

src/
├── controller/
├── service/
├── model/
├── repository/
└── application.properties


---

## 📦 How to Run

1. Clone the repository
2. Run `mvn clean install`
3. Launch the app with `mvn spring-boot:run`
4. Access endpoints via Postman or terminal

---


## 📬 Future Enhancements

- Frontend React/Angular UI
- Token-based authentication (JWT)
- MongoDB integration for persistence
- CI/CD integration (GitHub Actions)

---

## 👩‍💻 Author

Akanksha Katoch

---