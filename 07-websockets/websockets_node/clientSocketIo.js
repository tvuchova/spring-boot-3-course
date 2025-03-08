const { io } = require("socket.io-client");

// Connect to the WebSocket server
const socket = io("http://localhost:3000");

socket.on("connect", () => {
    console.log("Connected to server");
    socket.emit("message", "Hello, Server!");
});

socket.on("message", (msg) => {
    console.log(`Received from server: ${msg}`);
});

socket.on("disconnect", () => {
    console.log("Disconnected from server");
});

socket.on("connect_error", (err) => {
    console.error("Connection error:", err);
});
