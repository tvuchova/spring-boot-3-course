// js/cars.js

const API_BASE_URL = "http://localhost:8090";

async function loadCars() {
    const carListBody = document.getElementById("car-list");
    carListBody.innerHTML = "<tr><td colspan='5'>Loading...</td></tr>";

    try {
        const response = await fetch(`${API_BASE_URL}/cars`);
        if (!response.ok) {
            throw new Error("Failed to load cars.");
        }

        const cars = await response.json();
        carListBody.innerHTML = "";

        if (cars.length === 0) {
            carListBody.innerHTML = "<tr><td colspan='5'>No cars available.</td></tr>";
            return;
        }

        cars.forEach(car => {
            const row = document.createElement("tr");
            row.innerHTML = `
                <td>${car.brand}</td>
                <td>${car.model}</td>
                <td>${car.manufactureYear}</td>
                <td>${car.mileage}</td>
                <td>${car.price}</td>
            `;
            carListBody.appendChild(row);
        });
    } catch (error) {
        carListBody.innerHTML = `<tr><td colspan='5'>Error: ${error.message}</td></tr>`;
    }
}

async function addCar(event) {
    event.preventDefault(); // Prevent form submission from reloading the page

    const carData = {
        brand: document.getElementById("brand").value,
        model: document.getElementById("model").value,
        manufactureYear: parseInt(document.getElementById("manufactureYear").value),
        mileage: parseInt(document.getElementById("mileage").value),
        price: parseFloat(document.getElementById("price").value)
    };

    try {
        const response = await fetch(`${API_BASE_URL}/cars`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(carData)
        });

        if (!response.ok) {
            throw new Error("Failed to add car.");
        }

        alert("Car added successfully!");
        event.target.reset();
        await loadCars();
    } catch (error) {
        alert(`Error: ${error.message}`);
    }
}


document.getElementById("car-form").addEventListener("submit", addCar);

document.getElementById('show-optional-fields').addEventListener('change', function () {
    const optionalFields = document.getElementById('optional-fields');
    if (this.checked) {
        optionalFields.classList.remove('hidden');
    } else {
        optionalFields.classList.add('hidden');
    }
});
window.addEventListener("DOMContentLoaded", loadCars);

