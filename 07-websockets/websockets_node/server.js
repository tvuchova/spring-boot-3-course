const express = require("express");
const { createServer } = require("http");
const { Server } = require("socket.io");

const app = express();
const server = createServer(app);
const io = new Server(server);

io.on("connection", (socket) => {
    console.log("Client connected");

    socket.on("message", (msg) => {
        console.log(`Received: ${msg}`);
        socket.emit("message", `Echo: ${msg}`);
    });

    socket.on("disconnect", () => {
        console.log("Client disconnected");
    });
});

server.listen(3000, () => console.log("Server running on http://localhost:3000"));
