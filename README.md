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

```plaintext
Employee_Management_System/
├── frontend/                          # UI code and assets
│   ├── employee_management_system.html
│   ├── employee_management_system.css
│   └── employee_management_system.js
├── backend/                           # Spring Boot application
│   ├── src/
│   ├── pom.xml
│   └── application.properties
└── README.md                          # Project overview 
```

⚙️ Setup Instructions

🔧 Backend Setup

1. Navigate to the `backend/` folder.
2. Configure your PostgreSQL database in `application.properties`:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/employees
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
3. Run the spring application
   ```properties
   mvn spring-boot:run

🔧 Frontend Setup

1. Navigate to `frontend/` folder.
2. Open `employee_management_system`
3. Ensure the backend is running so the frontend can fetch data via API.

### 📂 API Endpoints

| Method | Endpoint                                            | Description                     |
|--------|-----------------------------------------------------|---------------------------------|
| GET    | `/get/employee`                                     | Fetch all employees             |
| POST   | `/add-employee`                                     | Add a new employee              |
| DELETE | `/delete-employee/${employeeToDelete}`              | Delete employee by ID           |
| GET    | `/get-employee/${id}`                               | Find employee by ID             |
| GET    | `/search-by-name?name=${encodeURIComponent(name)}`  | Search employee by name         |
| PUT    | `/update-emp/`                                      | Update employee details         |

## Display Employees

<img width="1809" height="881" alt="image" src="https://github.com/user-attachments/assets/47847ed2-0005-4c3c-b5e7-097a564c6807" />


## Searching Employee by Id

<img width="1791" height="884" alt="image" src="https://github.com/user-attachments/assets/8e6feee0-8f93-4879-9a60-ae8085a0355b" />

## Searching Employee by Name
Searching employees by partial name to retrieve all records that contain the entered text.

<img width="1825" height="889" alt="image" src="https://github.com/user-attachments/assets/bd197408-ff79-4268-beb3-0db9f88be306" />

## Updating Employee

## Before Updating

<img width="1787" height="884" alt="image" src="https://github.com/user-attachments/assets/293d03c0-c936-4532-8a2f-80f1d38eadc8" />

<img width="1749" height="891" alt="image" src="https://github.com/user-attachments/assets/c29564d3-8742-4a7e-a147-7d8587f33f7f" />

## After Updating


<img width="1764" height="882" alt="image" src="https://github.com/user-attachments/assets/660fae66-f432-4012-a19c-cbc47065aded" />

## Adding an Employee

<img width="1766" height="885" alt="image" src="https://github.com/user-attachments/assets/52086e88-5bca-4fc9-b605-26416ee7c2cb" />

## Deleting an Employee

<img width="1744" height="887" alt="image" src="https://github.com/user-attachments/assets/cce21f29-37d9-4c23-b073-414722e77948" />
<img width="1783" height="885" alt="image" src="https://github.com/user-attachments/assets/9ac5afb2-56ce-4977-b8f9-e0839b54e242" />


## 👤 Author

**Santhosh**  
[GitHub](https://github.com/Santhosh-kido)  
[LinkedIn](https://www.linkedin.com/in/santhosh-r-b03226344/)

