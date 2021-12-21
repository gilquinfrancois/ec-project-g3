create table IF NOT EXISTS COMMAND_DATA (
<<<<<<< HEAD
                                            commandId INT primary key,
                                            userId INT,
                                            productId INT[]
=======
                              commandId INT primary key,
                              userId INT references USER_DATA(id),
                              productId INT[] references productsData(id)
>>>>>>> c32a480ce0bfae26a465e7a9926cd855c870df2c
);

INSERT INTO COMMAND_DATA(commandId, userId, productId) values (1,1,ARRAY[25,65,95,5]);
INSERT INTO COMMAND_DATA(commandId, userId, productId) values (2,65,ARRAY[68,45,92,7]);
INSERT INTO COMMAND_DATA(commandId, userId, productId) values (3,32,ARRAY[66,24,12,9]);
