const WebSocket = require('ws');

//create web socket connection
const ws = new WebSocket("ws://localhost:8080");
//listen events on the connection

//when connection is open, send a message to the server
ws.on("open", () => {
    console.log("Connected to WebSocket server");
    ws.send("Hello, Server!");
});

//when message is received from the server
ws.on("message", (data) => {
    console.log(`Received from server: ${data}`);
});

//when connection is closed
ws.on("close", () => {
    console.log("Disconnected from server");
});

ws.on("error", (err) => {
    console.error("WebSocket error:", err);
});
