# springboot-crud-dynamodb
A REST API where the user can create, delete, update and read elements from a DynamoDB table.

Resouce Paths.
- GET: http://localhost:8080/api/customer
- GET: http://localhost:8080/customer/{customerId}
- POST: http://localhost:8080/api/customer

JSON Body:

{
>"id": "custo5",\
"name": "Fabiola",\
"lastname": "Fernández",\
"email": "fabiof@email.com",\
"telephone": 444444,\
"orderDate": "15/01/24",\
"orderItemsDto": [
>>{
>>>"productId": "prod345",\
                "quantity": 5,\
                "cost": 9.99\
>>>
>>}
>
>]

}

- PUT: http://localhost:8080/api/customer

JSON Body (same as the previous one):

- DELETE: http://localhost:8080/customer/{customerId}
