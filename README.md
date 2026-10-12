# Distributed Task Execution (Java)

This repository contains a small Java project that evolves from a simple client/server model to a master/slave distributed model for running image-processing tasks.

The main example is a **gray filter** applied to images.

## What is in this repository

- **ImageGrayFilter/**: standalone grayscale filter JAR example.
- **Version1/**: basic distributed execution with one Master and one User client.
- **Version2/**: improved architecture with Master + multiple Slaves + strategy-based task processing.

## How it works (general)

1. The user sends execution information (JAR path, options, input file).
2. The Master receives the request.
3. Depending on the version:
	- **Version1**: Master executes directly.
	- **Version2**: Master splits work and delegates processing to Slaves.
4. The processed result is returned to the user and saved as an output image.

## Requirements

- Java JDK (8+ recommended)
- Terminal/command line
- Valid test image and JAR files

## Quick start

- If you want a simple setup, start with **Version1**.
- If you want distributed processing with workers, use **Version2**.
- Follow the README inside each subfolder for exact compile and run steps.

## Notes

- Start the server components before launching the client.
- Make sure all components use matching port numbers.
- Use full file paths when entering JAR and input file locations.

