let employeeToDelete = null;

// Show info popup
function showInfoPopup(title, message) {
    document.getElementById('infoTitle').textContent = title;
    document.getElementById('infoMessage').textContent = message;
    document.getElementById('infoModal').style.display = 'block';

}


// Perform search based on input values
function performSearch() {
    const idValue = document.getElementById('searchIdInput').value;
    const nameValue = document.getElementById('searchNameInput').value;

    if (idValue && nameValue) {
        showInfoPopup('Error', 'Please enter either ID or Name, not both');
        return;
    }
    if (idValue) {
        console.log('Searching employee by ID:', idValue);
        findEmployeeById(idValue);
        // Clear the input after search
        document.getElementById('searchIdInput').value = '';
    } else if (nameValue) {
        console.log('Searching employee by name:', nameValue);
        findEmployeeByName(nameValue);
        // Clear the input after search
        document.getElementById('searchNameInput').value = '';
    } else {
        showInfoPopup('Error', 'Please enter either an ID or Name to search');
    }
}

// Modal functions
function openAddEmployeeModal() {
    document.getElementById('addEmployeeModal').style.display = 'block';
}


function openUpdateEmployeeModal() {
    document.getElementById('updateEmployeeModal').style.display = 'block';
}

function openViewByIdModal() {
    document.getElementById('viewByIdModal').style.display = 'block';
}

function openSearchByNameModal() {
    document.getElementById('searchByNameModal').style.display = 'block';
}

function closeModal(modalId) {
    document.getElementById(modalId).style.display = 'none';
    // Clear form fields when closing
    const forms = document.querySelectorAll(`#${modalId} form`);
    forms.forEach(form => form.reset());
}

function closeInfoModal() {
    closeModal('infoModal');
    showEmployeeDetails();
}

// Close modal when clicking outside
window.onclick = function (event) {
    const modals = document.querySelectorAll('.modal');
    modals.forEach(modal => {
        if (event.target === modal) {
            modal.style.display = 'none';
        }
    });
}

// Delete confirmation
function confirmDelete(employeeId, employeeName) {
    employeeToDelete = employeeId;
    document.getElementById('deleteMessage').textContent =
        `Are you sure you want to delete ${employeeName}? This action cannot be undone.`;
    document.getElementById('deleteConfirmModal').style.display = 'block';
}

// Form submissions
document.getElementById('addEmployeeForm').addEventListener('submit', function (e) {
    e.preventDefault();

    const formData = {
        name: document.getElementById('addName').value,
        email: document.getElementById('addEmail').value,
        department: document.getElementById('addDepartment').value,
        salary: document.getElementById('addSalary').value
    };

    console.log('Adding employee:', formData);
    closeModal('addEmployeeModal');
});

document.getElementById('updateEmployeeForm').addEventListener('submit', function (e) {
    e.preventDefault();

    const formData = {
        id: document.getElementById('updateId').value,
        name: document.getElementById('updateName').value,
        email: document.getElementById('updateEmail').value,
        department: document.getElementById('updateDepartment').value,
        salary: document.getElementById('updateSalary').value
    };

    console.log('Updating employee:', formData);
    closeModal('updateEmployeeModal');
});



// Show employee details section
function showEmployeeDetails() {
    fetch('http://localhost:9090/get-employee', {
        method: 'GET',
        mode: 'cors',
        headers: {
            'Content-Type': 'application/json',
        }
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            const tbody = document.getElementById('employeeTableBody');
            tbody.innerHTML = ''; // Clear existing dummy data
            data.forEach(emp => renderEmployeeDetails(emp, tbody));
            ;
        })
        .catch(error => {
            console.error('Error fetching employees:', error);
        });
    document.getElementById('initialView').style.display = 'none';
    document.getElementById('employeeDetailsSection').style.display = 'block';
}


function addEmployee() {
    const employee = {
        empName: document.getElementById("addName").value,
        mail: document.getElementById("addEmail").value,
        dept: document.getElementById("addDepartment").value,
        salary: parseInt(document.getElementById("addSalary").value)
    };
    console.log(employee);
    fetch(`http://localhost:9090/add-employee`, {
        method: 'POST',
        mode: 'cors',
        headers: {
            'Content-Type': 'application/json',
        }, body: JSON.stringify(employee)
    })

        .then(response => {
            if (!response.ok) {
                throw new Error("Employee Already Exist!");
            }
            showInfoPopup('Success', 'Employee Added Successfully!!');
        })
        .catch(error => {
            showInfoPopup("Error", error.message);
        });
}

function deleteEmployee() {
    if (employeeToDelete) {
        fetch(`http://localhost:9090/delete-employee/${employeeToDelete}`, {
            method: 'DELETE',
            mode: 'cors',
            headers: {
                'Content-Type': 'application/json',
            }
        })
            .then(response => {
                if (!response.ok) {
                    throw new Error('unable to delete employee');
                }
                closeModal('deleteConfirmModal');
                showInfoPopup('Success', 'Employee Deleted Successfully!!');
                employeeToDelete = null;
            })
            .catch(error => {
                closeModal('deleteConfirmModal');
                showInfoPopup('Error', error.message);
                employeeToDelete = null;
            });
    }
}
function findEmployeeById(id) {
    fetch(`http://localhost:9090/get-employee/${id}`, {
        method: 'GET',
        mode: 'cors',
        headers: {
            'Content-Type': 'application/json',
        }
    })
        .then(response => {
            if (!response.ok) {
                throw new Error("Employee Not Found!");
            }
            return response.json();
        })
        .then(emp => {
            const tbody = document.getElementById('employeeTableBody');
            tbody.innerHTML = ''; // Clear existing dummy data
            renderEmployeeDetails(emp, tbody);
        })
        .catch(error => {
            showInfoPopup('Error', error.message);
        });
}

function findEmployeeByName(name) {
    fetch(`http://localhost:9090/search-by-name?name=${encodeURIComponent(name)}`, {
        method: 'GET',
        mode: 'cors',
        headers: {
            'Content-Type': 'application/json',
        }
    })
        .then(response => {
            if (!response.ok) {
                throw new Error("Employee Not Found!");
            }
            return response.json();
        })
        .then(data => {
            const tbody = document.getElementById('employeeTableBody');
            tbody.innerHTML = ''; // Clear existing dummy data

            // Check if data is an array or single object
            if (Array.isArray(data)) {
                data.forEach(emp => renderEmployeeDetails(emp, tbody));
            } else {
                renderEmployeeDetails(data, tbody);
            }
        })
        .catch(error => {
            showInfoPopup('Error', error.message);
        });
}

function editEmployee(employeeId) {

    console.log('Editing employee with ID:', employeeId);
    document.getElementById('updateEmployeeModal').style.display = 'block';
    fetch(`http://localhost:9090/get-employee/${employeeId}`, {
        method: 'GET',
        mode: 'cors',
        headers: {
            'Content-Type': 'application/json',
        }
    })
        .then(response => {
            if (!response.ok) {
                throw new Error("Employee Not Found!");
            }
            return response.json();
        })
        .then(emp => {
            // const updateForm = document.getElementById('updateEmployeeForm');
            document.getElementById('updateId').value = emp.empId;
            document.getElementById('updateName').value = emp.empName;
            document.getElementById('updateEmail').value = emp.mail;
            document.getElementById('updateDepartment').value = emp.dept;
            document.getElementById('updateSalary').value = emp.salary;

        })
        .catch(error => {
            showInfoPopup('Error', error.message);
        });
    }

// Function to update table with new data (you'll call this after backend operations)
function updateEmployeeTable(employees) {
     const employee = {
        empId: document.getElementById('updateId').value,
        empName:  document.getElementById('updateName').value,
        mail:  document.getElementById('updateEmail').value,
        dept:   document.getElementById('updateDepartment').value ,
        salary: parseInt( document.getElementById('updateSalary').value)
    };
    console.log(employee);
     fetch(`http://localhost:9090/update-emp`, {
        method: 'PUT',
        mode: 'cors',
        headers: {
            'Content-Type': 'application/json',
        },body:JSON.stringify(employee)
    })
    .then(response=>{
        if(!response.ok){
            throw new Error("Employee Already up to Date");
        }
        showInfoPopup('Success', 'Employee Updated Successfully.');
    })
    .catch(error=>{
        showInfoPopup('Error', error.message);
    });


    }


    function renderEmployeeDetails(emp, tbody) {
    // debugger;
    const row = document.createElement('tr');
    row.innerHTML = `
                            <td>${emp.empId}</td>
                            <td>${emp.empName}</td>
                            <td>${emp.mail}</td>
                            <td>${emp.dept}</td>
                            <td>${emp.salary ? emp.salary.toLocaleString() : 'N/A'}</td>
                            <td>${emp.joiningDt}</td>
                            <td>
                                <button class="edit-btn" onclick="editEmployee(${emp.empId})" title="Edit">✏️</button>
                                <span class="action-separator"></span>
                                <button class="delete-btn" onclick="confirmDelete(${emp.empId}, '${emp.empName}')" title="Delete">🗑️</button>
                            </td>
                        `;
    tbody.appendChild(row);
}

function validateFormFields() {
    const name = document.getElementById("addName").value.trim();
    const email = document.getElementById("addEmail").value.trim();
    const dept = document.getElementById("addDepartment").value.trim();
    const salary = document.getElementById("addSalary").value.trim();
    debugger;
    const isValid = name && email && dept && !isNaN(parseInt(salary));
    document.getElementById("submitBtn").disabled = !isValid;
}
