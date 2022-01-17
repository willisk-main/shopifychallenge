# Inventory Tracker

This is a simple inventory tracker that allows for CRUD operations through a REST API. In addition, this app allows downloading of all the currently stored product items as a CSV file. It is built with Spring Boot and MySQL for the database. The application runs locally on port 8080 and the database on port 3306 - both default values. 

## Getting Started
**Install [IntelliJ](https://www.jetbrains.com/idea/download/?fromIDE=#section=windows), [MySQL](https://dev.mysql.com/downloads/mysql/) and [Postman](https://www.postman.com/downloads/)**
   1. Start a new MySQL server on localhost port 3306.
   3. Create new database named 'inventory' by typing `create database inventory;` in the MySQL command line interface.
   4. Unzip/extract or clone the *shopifychallenge* package from github `https://github.com/willisk-main/shopifychallenge.git`
   5. In IntelliJ navigate to File->New->Project from Existing Source, select the `/shopify` folder inside the *shopifychallenge* folder, then select Maven. 
   6. Add MySQL login credentials in the *application.properties* file located at `/shopify/src/main/resources/application.properties`  replacing the username *root* and the password *letmein*.
   7. Run the java application located at `/shopify/src/main/java/com/willisk/shopify/ShopifyApplication.java`
   8. Open Postman to begin making http requests.  

## REST API
**The following http requests will return a 200 status code if successful**

1. *Retrieve all* inventory items as a JSON file
    - **GET** request to `localhost:8080/inventory/all`


2. *Find* an existing item by id
    - **GET** request `localhost:8080/inventory/{id}`
    - Replace `{id}` with the integer value of the item being searched. The request will return an error if the id does not exist.


4. *Create* a new inventory item 
    - **POST** request to `localhost:8080/inventory/add`
    - Include a JSON body of the item being added. The id will be generated automatically. An example request body in JSON:
      ```
      {
        "name": "Apple Watch 7",
        "description": "GPS+Cellular",
        "price": 449.99,
        "quantity": 19
      }
      ```

3. *Update* an existing item 
    - **PUT** request to `localhost:8080/inventory/update`
    - Include a JSON body of the item being added and make sure to include the id. A new item will be created if the id does not exist.
    - An example JSON body of an item to update:
      ```
      {
        "id": 1
        "name": "Apple Watch 7",
        "description": "GPS+Cellular",
        "price": 399.99,
        "quantity": 4
      }    
      ```
4. *Delete* an existing item 
    - **DELETE** request to `localhost:8080/inventory/delete/{id}`
    - Replace {id} with the integer value of the item being deleted

5. *Download CSV* of all inventory items
    - **GET** request to `localhost:8080/inventory/csv`

## One-Click CSV Download
**Download all inventory items with the click of a button**

- Navigate to `localhost:8080` and click the link labeled *Click Here* (download should begin automatically)
- Navigating directly to `localhost:8080/inventory/csv` will also begin the download
- CSV data will have the following format
      <br/>&nbsp; `id, name, description, price, quantity`
