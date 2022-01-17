# Shopify 2022 Intern Challenge

This is a simple inventory tracker that allows for CRUD operations through a REST API. In addition, this app allows downloading of all the currently stored product items as a CSV file. 

It is built with Spring Boot using MySQL for the database. Ideally the application would be dockerized and deployed but for our purposes, this application runs locally on port 8080. This application requires a [MySQL database](https://dev.mysql.com/downloads/mysql/) named "inventory" running locally on port 3306 (default).

## Getting Started
**To get started:**
   1. Open the `/shopify` folder as an existing source in an IDE such as [IntelliJ](https://www.jetbrains.com/idea/download/?fromIDE=#section=windows). 
   2. Create a [MySql](https://dev.mysql.com/downloads/mysql/) database named "inventory" running on localhost:3306
   3. Add MySQL login credentials in the "application.properties" file in the maven project - located at    `src/main/resources/application.properties` in the /shopify folder. 
   4. Run the java application located at `shopify/src/main/java/com/willisk/shopify/ShopifyApplication.java`
   5. Open a REST client such as [Postman](https://www.postman.com/downloads/) to make http requests described in the next section.  

## REST API
**The following operations are possible and will return a 200 status code if successful:**

1. *Retrieve all* inventory items as a JSON file `.../inventory/all`
    - **GET** request to `localhost:8080/inventory/all`


2. *Find* an existing item by id `.../inventory/{id}`
    - **GET** request `localhost:8080/inventory/{id}`
    - Replace `{id}` with the integer value of the item being searched. The request will return an error if the id does not exist.


4. *Create* a new inventory item `.../inventory/add`
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

3. *Update* an existing item `.../inventory/update`
    - **PUT** request to `localhost:8080/inventory/update`
    - Include a JSON body of the item being added and make sure to include the id. The request will create a new item if the id does not exist.
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
4. *Delete* an existing item `.../inventory/delete/{id}`
    - **DELETE** request to `localhost:8080/inventory/delete/{id}`
    - Replace {id} with the integer value of the item being deleted

5. *Download CSV* of inventory items `.../inventory/csv`
    - **GET** request to `localhost:8080/inventory/csv`

## One-Click CSV Download
Download all inventory items as a CSV file with a click of a button:

- Navigate to `localhost:8080` and click the link labeled **Click Here** (download should begin automatically)
- Navigating directly to `localhost:8080/inventory/csv` will also begin the download
- CSV data will have the following format
      <br/>&nbsp; `id, name, description, price, quantity`
