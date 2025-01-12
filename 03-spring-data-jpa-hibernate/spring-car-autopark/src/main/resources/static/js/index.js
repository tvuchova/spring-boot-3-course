// js/index.js

const API_BASE_URL = "http://localhost:8090";

async function loadAllCars() {
    const carsTableBody = document.querySelector("#carsTable tbody");
    carsTableBody.innerHTML = "<tr><td colspan='4'>Loading...</td></tr>";

    try {
        const response = await fetch(`${API_BASE_URL}/cars`);
        if (!response.ok) {
            throw new Error("Failed to fetch cars.");
        }

        const cars = await response.json();
        carsTableBody.innerHTML = "";

        if (cars.length === 0) {
            carsTableBody.innerHTML = "<tr><td colspan='4'>No cars available.</td></tr>";
            return;
        }

        cars.forEach(car => {
            const row = document.createElement("tr");
            row.innerHTML = `
                <td>${car.id}</td>
                <td>${car.brand}</td>
                <td>${car.year}</td>
                <td>${car.price}</td>
            `;
            carsTableBody.appendChild(row);
        });
    } catch (error) {
        carsTableBody.innerHTML = `<tr><td colspan='4'>Error: ${error.message}</td></tr>`;
    }
}

document.getElementById("loadCarsBtn").addEventListener("click", loadAllCars);
