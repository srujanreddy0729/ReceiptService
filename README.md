# Receipt Processor
 
# Project Overview
This web service will be implemented in Java using Spring Boot to fulfill the API requirements. The application processes receipts, assigns unique IDs, calculates points based on the provided rules, and retrieves the awarded points.

# Key Features
**1.Endpoints:**
- POST /receipts/process: Accepts receipt JSON, generates a unique receipt ID, calculates points, and stores the result in memory.
- GET /receipts/{id}/points: Fetches the points awarded for the given receipt ID.

**2.In-Memory Storage:**
Uses a ConcurrentHashMap to store receipt data and associated points, ensuring thread safety.

**3.Point Calculation Rules:**
Implements all point calculation rules, including checking alphanumeric characters in the retailer name, total amount-based bonuses, and item description-based bonuses.

**4.Docker Support:**
The application will be containerized using Docker, allowing for easy deployment and execution without requiring additional dependencies.

# Docker Implementation

-To make the application portable and easy to run, we will create a Dockerfile that builds the Java application as a containerized service.

**Docker Commands to Build and Run**

Step 1: Build the Spring Boot Application
First, package the application using Maven:

--mvn clean package

This will generate a JAR file inside the target/ directory, e.g., receiptservie.jar.

Step 2: With the help of jar file we will create the dockerfile.

<img width="1396" alt="Screenshot 2025-02-12 at 3 42 57 PM" src="https://github.com/user-attachments/assets/a7abd6e8-b600-4470-9881-51dcaebba4ea" />


Step 3: Build the Docker Image from the dockerfile

--docker build -t myapp:v2 .

This command builds the Docker image and tags it as myapp.

Step 3: Run the Docker Container

--docker run -p 8080:8080 myapp:v2

This runs the container, making the application accessible on localhost:8080.


For more details, you can refer this github repository https://github.com/fetch-rewards/receipt-processor-challenge?tab=readme-ov-file#examples
     
