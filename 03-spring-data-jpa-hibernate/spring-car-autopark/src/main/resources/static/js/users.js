document.addEventListener("DOMContentLoaded", () => {
    const userForm = document.getElementById("user-form");
    const userList = document.getElementById("user-list");

    fetch("/users")
        .then(response => response.json())
        .then(users => {
            users.forEach(user => {
                const row = document.createElement("tr");
                row.innerHTML = `
                    <td>${user.name}</td>
                    <td>${user.email}</td>
                `;
                userList.appendChild(row);
            });
        });

    userForm.addEventListener("submit", event => {
        event.preventDefault();

        const formData = new FormData(userForm);
        const user = Object.fromEntries(formData.entries());

        fetch("/users", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(user),
        })
            .then(response => {
                if (response.ok) {
                    alert("User added successfully!");
                    location.reload();
                } else {
                    alert("Failed to add user.");
                }
            });
    });
});
