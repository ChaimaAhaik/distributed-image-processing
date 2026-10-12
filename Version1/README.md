
# Version 1 - Distributed Task Execution System

## Overview
Version 1 is a simple client-server Java application. A user sends a JAR file and an input file to the Master, the Master runs the JAR dynamically, and the processed result is returned to the user.

## Project Structure
```text
version1/
├── src/
│   ├── shared/
│   │   └── TaskMessage.java
│   ├── master/
│   │   ├── MasterServer.java
│   │   ├── ClientHandler.java
│   │   └── JarExecutor.java
│   └── user/
│       └── UserClient.java
├── bin/          # generated after compilation
└── README.md
```

## Compile
Open a terminal in the project root and run:

```bash
javac -d bin src/shared/*.java src/master/*.java src/user/*.java
```

This creates the compiled classes in the `bin` folder.

## Run the Server
Start the Master server with:

```bash
java -cp bin master.MasterServer 5000
```

The server will wait for client connections.

## Run the Client
Open another terminal and run:

```bash
java -cp bin user.UserClient 127.0.0.1 5000
```

Then enter:
- JAR path: full path to the JAR file
- Option: for example, `gray`
- File path: full path to the input file

## Output
After execution:
- The Master runs the selected JAR with the input file.
- The processed result is sent back to the client.
- The client saves the result as `Result_Output.jpg` in the project root.

## Requirements
- Java JDK installed
- Windows OS tested
- A JAR file that produces an output file

## Notes
- Use the same port number in the server and client.
- Keep the server running while the client is executing.
- Enter file paths manually to avoid hidden characters.
