create table COMMAND_DATA (
                              commandId INT primary key,
                              userId INT references USER_DATA(id),
                              productId INT[] references productsData(id)
);

INSERT INTO COMMAND_DATA(commandId, userId, productId) values (1,1,ARRAY[25,65,95,5]);
INSERT INTO COMMAND_DATA(commandId, userId, productId) values (2,65,ARRAY[68,45,92,7]);
INSERT INTO COMMAND_DATA(commandId, userId, productId) values (3,32,ARRAY[66,24,12,9]);
