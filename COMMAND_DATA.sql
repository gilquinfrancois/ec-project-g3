create table COMMAND_DATA (
                              commandId INT primary key,
                              userId INT references USER_DATA(id),
                              productId INT references productsData(id)
);