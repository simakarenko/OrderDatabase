JDBC DAO робота з БД.

Можливості коду:

- додавання клієнта в базу даних;

1 user

1: add client  
2: view clients  
3: view count  
-> 1  
Enter client name: svitlana  
Enter client age: 20

2 user

1: add client  
2: view clients  
3: view count  
-> 1  
Enter client name: vasya  
Enter client age: 30

- вивід списку усіх клієнтів;

1: add client  
2: view clients  
3: view count  
-> 2  
Client{id=1, name='svitlana', age=20}  
Client{id=2, name='vasya', age=30}

- вивід id клієнта, який призначено автоматично при додаванні в базу;

1: add client  
2: view clients  
3: view count  
-> 3  
Count: 2
