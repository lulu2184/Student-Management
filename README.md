# Student-Management

## Overview
A student management system programming with socket. Data is stored on server and client communicates with the server to get data.

## Usage
1. Buid the project  
2. Create a directory "server_data" at root directory of this project.
3. Run the server: java server/ServerTalk.class. It listens port 5858 by default.
4. Run the client: java client/UIMain.class

## Code Structure
### server
* ServerTalker: listen the port, read and write data to IO stream.
* RequestHandler: handle requests, generate response messages.

### client.backend
* ClientTalker: talk with the server, pass messages
* Controller: generate request message for each operation, pass to talker and deal with response messages.
* Paser: parse Student to String or parse String to Student.
* Student: class for a student including its student number, name, gender and photo image.