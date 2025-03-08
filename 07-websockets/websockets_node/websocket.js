//npm install ws
const WebSocket = require('ws');

//create server
const server = new WebSocket.Server({ port: 8080 });
//wait for connection of clients
server.on('connection', (ws) => {
    console.log('Client connected');
   //when message is received, send it back
    ws.on('message', (message) => {
        console.log(`Received: ${message}`);
        ws.send(`Echo: ${message}`);
    });

    ws.on('close', () => {
        console.log('Client disconnected');
    });
});

console.log("WebSocket server running on ws://localhost:8080");
