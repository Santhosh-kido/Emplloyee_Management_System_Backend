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
<img width="949" height="322" alt="image" src="https://github.com/user-attachments/assets/fd2c12e7-2e8d-4d5e-9ed1-6340b2c7a6b1" />


---

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
   ```mvn spring-boot:run

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


👤 Author
## 👤 Author

**Santhosh**  
[GitHub](https://github.com/your-username)  
[LinkedIn](https://www.linkedin.com/in/your-profile)

