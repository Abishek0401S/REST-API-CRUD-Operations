# REST-API-CRUD-Operations
Creating java REST API with Spring boot, Spring Data JPA, Junit, Mysql.

Java Rest API CRUD Operations using SpringBoot
This repository provides a sample Java REST API application built using Spring Boot that demonstrates CRUD (Create, Read, Update, Delete) operations on a simple resource. This README file will guide you through setting up, running, and using the application.

Agenta - Using springboot how can you create CRUD Operations of REST-API and how you can interact.

Prerequisities

Before you begin, ensure you have met the following requirements:

Java: Make sure you have Java 8 or higher installed.
Maven: This project uses Maven as the build tool. Make sure you have it installed
Mysql workbench: Choose either of the database like mongoDb etc, my system as compactible to mysql workbench
Server: Spring framework has inbuild tomcat server use any server you want

Getting Started

Follow these steps to get the project up and running on your local machine.

Build and Run

This will build the project and start the Spring Boot application. The API will be available at http://localhost:8080/api.

Application OverView

The Java Spring Boot CRUD API is a simple application that allows you to perform CRUD operations on a resource. In this example, we're managing a collection of items. You can add, retrieve, update, and delete items through the exposed API endpoints.

API Endpoints

The following API endpoints are available:

GET /api/items: Retrieve a list of all items.
GET /api/items/{id}: Retrieve a specific item by ID.
POST /api/items: Create a new item.
Request body should contain JSON data with item details.
PUT /api/items/{id}: Update an existing item by ID.
Request body should contain JSON data with item details.
DELETE /api/items/{id}: Delete an item by ID. For detailed usage and request/response examples, refer to the API documentation at /docs when the application is running.

Operations Done

Create
Update
Delete
Post
Exception handling
Unit Test (Junit Framework)

Deployment

Finally run the project by upping your server and your good to go!!!
