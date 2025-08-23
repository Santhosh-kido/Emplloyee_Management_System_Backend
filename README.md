# Employee Management System

A full-stack web application to manage employee records with Create, Read, Update, and Delete (CRUD) operations. Built using Spring Boot for the backend, PostgreSQL for data storage, and HTML/CSS/JavaScript for the frontend. Designed with a responsive UI and pop-up feedback for better user experience.

---

## 🚀 Features

- Add new employees with name, email, and Department
- View all employee records in a dynamic table
- Update employee details via pop-up form
- Delete employees with confirmation alerts
- RESTful API integration between frontend and backend
- Error handling and validation
- PostgreSQL database integration

---

## 🧰 Tech Stack

- **Backend**: Spring Boot, Java, PostgreSQL
- **Frontend**: HTML, CSS, JavaScript
- **Tools**: Maven, Postman, Git

---

## 📁 Folder Structure

Employee_Management_System/
├── frontend/               # HTML, CSS, JS for UI
├── backend/
│   ├── src/main/java/com/example/employees/
│   │   ├── controller/     # REST endpoints
│   │   ├── entity/         # JPA models
│   │   ├── repository/     # DB access layer
│   │   ├── response/       # Custom response classes
│   │   └── service/
│   │       └── impl/       # Business logic
│   ├── resources/
│   │   ├── application.properties
│   │   └── static/
│   └── pom.xml
├── README.md
└── .gitignore

