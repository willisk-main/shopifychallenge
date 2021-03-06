# Inventory Tracker

This is a simple inventory tracker that allows for CRUD operations through a REST API - specifications available [here](https://docs.google.com/document/d/1oO6BjQaskAn294iZ34094TIVOb5-kR7jgIcRNnLzFe8/edit?usp=sharing). In addition, this app allows one-click download of inventory items as a CSV file. It is written in Java and built using the [Spring Boot Framework](https://start.spring.io/) connected to a MySQL database. The application runs locally on port 8080; database on port 3306 - both default values. 

## Getting Started
**Install the following programs:**
- [IntelliJ IDEA Community](https://www.jetbrains.com/idea/download/?fromIDE=#section=windows) - Java integrated development environment (IDE)
- [Java 17 LTS](https://www.oracle.com/java/technologies/downloads/) - development environment for building applications
- [MySQL Community Server 8](https://dev.mysql.com/downloads/mysql/) - open-source relational database management system (RDBMS)
- [Postman](https://www.postman.com/downloads/) - REST API client

**Running the application:**
   1. Start a new MySQL server on localhost port 3306.
   2. Open the MySQL command line interface, login and create a new database with
      ```
      create database inventory;
      ```
   3. Download/unzip or clone the *shopifychallenge* package from github 
      ```
      git clone https://github.com/willisk-main/shopifychallenge.git
      ```
   4. In IntelliJ navigate to File->New->Project from Existing Source, select the `/shopify` folder inside the *shopifychallenge* folder, then select Maven. 
   5. Add MySQL login credentials in *application.properties* replacing the username *root* and the password *letmein*
      ```
      /shopify/src/main/resources/application.properties
      ```
   6. Run the java application located at 
      ```
      /shopify/src/main/java/com/willisk/shopify/ShopifyApplication.java
      ```
   7. Open Postman to begin making http requests.  

## REST API

**Quick Guide**

- **GET**  ```/all```
- **GET** ```/find/{id}```
-  **POST** ```/add```
-  **DELETE** ```/delete/{id}```
-  **PUT** ```/update```
- **GET** ```/csv```

**The following http requests will return a 200 status code if successful**

1. *Retrieve all* inventory items as a JSON object
    - **GET**  ```localhost:8080/inventory/all```


2. *Find* an existing item by id
    - **GET** ```localhost:8080/inventory/find/{id}```
    - Replace `{id}` with the integer value of the item being searched. The request will return an error if the id does not exist.


4. *Create* a new inventory item 
    - **POST** ```localhost:8080/inventory/add```
    - Include in the request body a JSON object with item details (name, description, price, quantity). The item id will be generated automatically with the request. 
      ```
      {
        "name": "Apple Watch 7",
        "description": "GPS+Cellular",
        "price": 449.99,
        "quantity": 19
      }
      ```

3. *Update* an existing item 
    - **PUT** ```localhost:8080/inventory/update```
    - Include a JSON body of the item being updated and make sure to include the id. A new item will be created if the id does not exist.
      ```
      {
        "id": 1
        "name": "Apple Watch 7",
        "description": "Space Grey, GPS",
        "price": 399.99,
        "quantity": 4
      }    
      ```
4. *Delete* an existing item 
    - **DELETE** ```localhost:8080/inventory/delete/{id}```
    - Replace `{id}` with the integer value of the item being deleted

5. *Retrieve all* inventory items in CSV format
    - **GET** ```localhost:8080/inventory/csv```

## One-Click CSV Download
**Download all inventory items with the click of a button**

- In a web browser navigate to `localhost:8080` and click the link labeled *Click Here* (download should begin automatically)
- CSV data will have the format ```id, name, description, price, quantity```
      
## Thank you for reading!
![alt text](https://cdn.shopify.com/s/files/1/0611/1605/5788/t/2/assets/shopify-internships-logo.svg?v=5409994561124683960 "Shopify Internships")
