INSERT INTO CLIENTS (email,surname,BIRTHDAY,MALE) VALUES ('user1@gmail.com','Кузнецов',CURDATE(), TRUE);
INSERT INTO CLIENTS (email,surname,BIRTHDAY,MALE) VALUES ('user2@gmail.com','Хорошилов',CURDATE(), TRUE);
INSERT INTO ORDERS (clientId,price,orderTime) VALUES (1,500,CURDATE());
INSERT INTO ORDERS (clientId,price,orderTime) VALUES (2,1500,CURDATE());
