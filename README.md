# Landon Hotel Application

## Project Overview
This project enhances the Landon Hotel scheduling application by implementing multithreaded welcome messages displayed in English and French, displaying reservation prices in multiple currency formats, and converting presentation times between different time zones. 
The application uses a Java Spring back end and an Angular front end. The project also demonstrates how to package the application into a Docker image, run it in a container, and prepare it for deployment to a cloud service provider.

## Technologies Used
-	**Java:** Back end development, multithreading, resource bundles, and time zone conversion.
-	**Spring Boot:** Application framework for the Java back end.
-	**Angular:** Front end development and reservation interface.
-	**Docker:** Application containerization and deployment preparation.
-	**GitLab:** Source code management and version control.
-	**Amazon Web Services (AWS):** Proposed cloud deployment platform.

## Project Features
### 1. Multithreading
The application supports English and French welcome messages using Java resource bundles.
-	English resource bundle: translation_en_US.properties
-	French resource bundle: translation_fr_CA.properties

Each resource bundle contains a welcome message in its respective language. Separate Java threads load and display the messages, demonstrating multithreading.

### 2. Multiple Currency Display
The reservation interface displays prices in three currencies on separate lines:
-	**U.S. dollars (USD): $**
-	**Canadian dollars (CAD): C$**
-	**Euros (EUR): €**

The application displays the reservation price using the specified currency formats.

### 3. Time Zone Conversion
A Java method converts presentation times among the following time zones:
- **Eastern Time (ET)**
- **Mountain Time (MT)**
- **Coordinated Universal Time (UTC)**

The application displays the scheduled time for an online, live presentation at the Landon Hotel in hours and minutes for all three time zones.

### 4. Docker Containerization
The project includes a Dockerfile intended to package the application and its required components into a Docker image.
The Docker workflow includes:
1.	Building the Docker image from the application source code.
2.	Running the image in a Docker container.
3.	Assigning the container a name.
4.	Verifying that the application runs inside the container.
5.	Committing and pushing the final Dockerfile and project changes to GitLab.

### 5. Proposed Cloud Deployment Plan
The application can be deployed to a cloud platform that supports Docker containers and Java-based applications.
Proposed cloud provider: Amazon Web Services (AWS).
A potential deployment approach is to use Amazon Elastic Container Registry (Amazon ECR) to store the Docker image and Amazon Elastic Container Service (Amazon ECS) to run and manage the container.
The deployment process would include:
1.	Build and test the Docker image locally.
2.	Push the image to Amazon ECR.
3.	Configure an Amazon ECS service to run the container.
4.	Configure networking, security rules, and environment variables as required.
5.	Set up logging, monitoring, and application health checks.
6.	Configure access to the Angular front end and Spring back end.
7.	Verify that the deployed application is accessible and that all required features work correctly.

## Getting Started
## Prerequisites
Install the following tools before building and running the application:
-	Java Development Kit (JDK)
-	Maven
-	Node.js and npm
-	Docker Desktop or Docker Engine
-	Git
-	An IDE such as IntelliJ IDEA or Eclipse

## Clone the Repository
Clone the project from GitHub:
```
git clone <https://github.com/EB48/Java-project.git>
```

## Build the Docker Image
From the directory containing the Dockerfile, run:
```
docker build -t landon-hotel .
```
This command builds a Docker image named landon-hotel.

## Run the Docker Container
```
docker run -d --name landon-hotel-container -p 8080:8080 landon-hotel
```
This command starts the container in detached mode and maps port 8080 on the host to port 8080 in the container. 

## Verify the Container Is Running
Check the container status:
```
docker ps
```
View the container logs:
```
docker logs landon-hotel-container
```
If the application exposes its interface on port 8080, open the following address in a browser:
```
http://localhost:8080
```
