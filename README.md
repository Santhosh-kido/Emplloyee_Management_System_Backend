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

<img width="1773" height="884" alt="image" src="https://github.com/user-attachments/assets/244ea700-c66a-484b-84ce-f7851899e828" />

## Searching Employee by Id
<img width="1816" height="881" alt="image" src="https://github.com/user-attachments/assets/4628e1dc-d76c-40a6-a36b-334cce3672d3" />

## Searching Employee by Name
Searching employees by partial name to retrieve all records that contain the entered text.

<img width="1784" height="882" alt="image" src="https://github.com/user-attachments/assets/df4e3358-c348-41aa-a0f0-f937b536b23d" />

## Updating Employee

## Before Updating

<img width="1759" height="879" alt="image" src="https://github.com/user-attachments/assets/38c839ec-7ae9-49a6-951a-f0e1817d4c0a" />
<img width="1761" height="885" alt="image" src="https://github.com/user-attachments/assets/925ff820-5231-42c5-b4a8-62f25036de57" />

## After Updating
<img width="1760" height="872" alt="image" src="https://github.com/user-attachments/assets/2d6e9693-8be6-4f0e-be2a-aedbba96402f" />

## Adding an Employee

<img width="1791" height="882" alt="image" src="https://github.com/user-attachments/assets/a20975fc-93ce-42e1-8773-10c22f65804c" />

<img width="1763" height="882" alt="image" src="https://github.com/user-attachments/assets/133092b6-6b77-4777-b389-39d45459c02c" />

## Deleting an Employee

<img width="1725" height="880" alt="image" src="https://github.com/user-attachments/assets/0623845d-bddf-43f4-95e7-5f4169440086" />
<img width="1769" height="883" alt="image" src="https://github.com/user-attachments/assets/d87252ef-2cec-44ed-998a-981269e3c5c2" />



## 👤 Author

**Santhosh**  
[GitHub](https://github.com/Santhosh-kido)  
[LinkedIn](https://www.linkedin.com/in/santhosh-r-b03226344/)

