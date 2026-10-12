================================================

# Version 2 - Distributed Task Execution System

================================================

## Overview
Version 2 is a distributed Java application that splits heavy tasks across one or more Slaves and merges the final result for the user.

The system has three main parts:

- Master: receives user requests and coordinates the work
- Slave: processes the assigned task
- User: submits the task and receives the final result

## Project Structure

```text
src/
├── shared/             # Common TaskMessage DTO for network communication
├── strategy/           # Processing strategies used by the Slave
├── master/             # Master server and task coordination code
├── slave/              # Slave worker code
├── user/               # User client application
└── test_jars/          # Sample JAR files and input images
```

## How to Compile

Open a terminal in the `src` folder and run:

```bash
javac shared/*.java strategy/*.java master/*.java slave/*.java user/*.java
```

This will compile all classes used by Version 2.

## How to Run the Server

In the first terminal, start the Master with:

```bash
java master.Master 5000 6000
```

The Master listens on:

- `5000` for user connections
- `6000` for Slave connections

## How to Run the Slaves

Open one terminal for each Slave and run:

```bash
java slave.Slave localhost 6000
```

If the Master is on another machine, replace `localhost` with the Master IP address.

## How to Run the Client

Open another terminal and run:

```bash
java user.UserClient localhost 5000
```

You will be asked to enter:

- Master Jar path
- Master Option
- Slave Jar path
- Slave Option
- File path

## Output

After execution, the processed image is saved as a file named like:

```bash
FinalResult_<timestamp>.jpg
```

## Test Files

You can use the sample files in `test_jars/`:

- Master Jar path: `test_jars/SplitProcessMerge.jar`
- Master Option: `2`
- Slave Jar path: `test_jars/FiltersV2.jar`
- Slave Option: `gray`
- File path: `test_jars/picpic.jpg`

## Notes

- Make sure the port number is the same in the server and client.
- Keep the Master running while clients and Slaves are connected.
- Enter file paths carefully to avoid errors.