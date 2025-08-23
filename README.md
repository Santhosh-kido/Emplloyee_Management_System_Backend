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

## Display Employees

<img width="1915" height="886" alt="image" src="https://github.com/user-attachments/assets/43fb2561-dba2-4c06-ab05-99d7050625ba" />

## Searching Employee by Id

<img width="1905" height="876" alt="image" src="https://github.com/user-attachments/assets/2a7c1888-afc0-4870-80dd-9d5621269eed" />

## Searching Employee by Name
Searching employees by partial name to retrieve all records that contain the entered text.

<img width="1907" height="885" alt="image" src="https://github.com/user-attachments/assets/fe8d1799-e50e-4180-9c24-9ebbe6b61e31" />

## Updating Employee
## Before Updating

<img width="1885" height="882" alt="image" src="https://github.com/user-attachments/assets/a35b97dc-7ba1-48d6-addf-911111fd53f6" />
<img width="1600" height="881" alt="image" src="https://github.com/user-attachments/assets/fc362c5a-a76c-4226-be3a-2bc9853a0094" />

## Adding an Employee

<img width="1865" height="880" alt="image" src="https://github.com/user-attachments/assets/5af53be5-a979-4f26-ba49-25319b94e932" />

## After Updating

<img width="1658" height="878" alt="image" src="https://github.com/user-attachments/assets/1fe5947f-db53-4e5d-97bb-3f8dd3da7283" />

## Deleting an Employee

<img width="1821" height="884" alt="image" src="https://github.com/user-attachments/assets/d034e64e-fff0-4ca3-b920-b76802027b90" />
<img width="1844" height="886" alt="image" src="https://github.com/user-attachments/assets/f61bdab1-7996-43bd-9512-2e3998fc62c3" />

## 👤 Author

**Santhosh**  
[GitHub](https://github.com/Santhosh-kido)  
[LinkedIn](https://www.linkedin.com/in/santhosh-r-b03226344/)

