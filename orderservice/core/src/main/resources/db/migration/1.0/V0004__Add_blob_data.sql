INSERT INTO BinaryObject(id, ModificationCounter, filesize, content, mimeType) VALUES (10, 0, 1150 ,'00000100010010100000010020006804000016000000280000001000000020000000010020000000000000040000000000000000000000000000000000000000000000000000000000000000000000000000ECBD48EFECBD48FFECBD48FFECBD48FFECBD48FFECBD48F90000000000000000000000000000000000000000000000000000000000000000ECBD48FAECBD48FFECBD48FFECBD48FFECBD48FFECBD48FFECBD48FFECBD48FFECBD48FFECBD48FF0000000000000000000000000000000000000000ECBD48FFECBD48FFECBD48FFECBD48FFECBD48FFECBD48FFECBD48FFECBD48FFECBD48FFECBD48FFECBD48FFECBD48FF000000000000000000000000ECBD48FAECBD48FFFFFFFFFFECBD48FFFFFFFFFFFFFFFFFFEEC35EFFFFFEFDFFFFFFFFFFFFFFFFFFFFFFFFFFEFC86BFFECBD48FFECBD48FF0000000000000000ECBD48FFECBD48FFF4D696FFECBD48FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFECBD48FFECBD48FF00000000ECBD48EFECBD48FFECBD48FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF1CB7FFFFFFFFFFFFFFFFFFFECBD48FFECBD48FFFFFFFFFFECBD48FFECBD48FFECBD48F9ECBD48FFECBD48FFECBD48FFFFFFFFFFFFFFFFFFFDF8EFFFECBD48FFFFFFFFFFFFFFFFFFFFFFFFFFECBD48FFECBD48FFFFFFFFFFECBD48FFECBD48FFECBD48FFECBD48FFECBD48FFECBD48FFECBD48FFFFFFFFFFFFFFFFFFFFFFFFFFECBD48FFECBD48FFFFFFFFFFFFFFFFFFFFFFFFFFECBD48FFECBD48FFECBD48FFECBD48FFECBD48FFECBD48FFECBD48FFECBD48FFFFFFFFFFFFFFFFFFFFFFFFFFECBD48FFECBD48FFECBD48FFECBD48FFECBD4AFFECBD48FFECBD48FFECBD48FFECBD48FFECBD48FFECBD48FFECBD48FFFFFFFFFFFEF9F3FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFECBD48FFECBD48FFECBD48FFECBD48F9ECBD48FFECBD48FFFFFFFFFFEEC45FFFECBD48FFF1CD7EFFFFFFFFFFFFFFFFFFFFFFFFFFEDC156FFFFFFFFFFFFFFFFFFECBD48FFECBD48FFECBD48EF00000000ECBD48FFECBD48FFFFFFFFFFFEF9F2FFECBD48FFFCF5E8FFFFFFFFFFFFFFFFFFFFFFFFFFECBD48FFFFFFFFFFFFFFFFFFECBD48FFECBD48FF0000000000000000ECBD48FFECBD48FFEFC769FFFFFFFFFFFFFFFFFFFFFFFFFFEEC35EFFEEC25CFFFFFFFFFFFFFFFFFFFFFFFFFFEFC86BFFECBD48FFECBD48FA000000000000000000000000ECBD48FFECBD48FFECBD48FFECBD48FFECBD48FFECBD48FFECBD48FFECBD48FFECBD48FFECBD48FFECBD48FFECBD48FF0000000000000000000000000000000000000000ECBD48FFECBD48FFECBD48FFECBD48FFECBD48FFECBD48FFECBD48FFECBD48FFECBD48FFECBD48FA0000000000000000000000000000000000000000000000000000000000000000ECBD48F9ECBD48FFECBD48FFECBD48FFECBD48FFECBD48EF0000000000000000000000000000000000000000F81F0000E0070000C003000080010000800100000000000000000000000000000000000000000000000000008001000080010000C0030000E0070000F81F0000', 'image/vnd.microsoft.icon');

-- *** Order ***
CREATE TABLE Orders (
  id BIGINT NOT NULL AUTO_INCREMENT,
  modificationCounter INTEGER NOT NULL,
  customerId BIGINT NOT NULL,
  paid BOOLEAN NOT NULL DEFAULT ((0)),
  totalPrice DECIMAL (16,10),
  orderDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT PK_Order PRIMARY KEY(id),
);


-- *** OrderItem ***
CREATE TABLE OrderItem (
  id BIGINT NOT NULL AUTO_INCREMENT,
  modificationCounter INTEGER NOT NULL,
  idOrder BIGINT NOT NULL,
  name VARCHAR (255) NOT NULL,
  price DECIMAL (16,10) NOT NULL,
  quantity INTEGER NOT NULL,
  productId BIGINT NOT NULL,
  CONSTRAINT PK_OrderItem PRIMARY KEY(id),
  CONSTRAINT FK_OrderItem_idOrder FOREIGN KEY(idOrder) REFERENCES Orders(id) NOCHECK
);

INSERT INTO Orders(id, modificationCounter, customerId, paid, totalPrice) VALUES (1, 1, 1, false, 1000.00);
INSERT INTO Orders(id, modificationCounter, customerId, paid, totalPrice) VALUES (2, 1, 2, true, 1200.00);


INSERT INTO OrderItem(id, modificationCounter, idOrder, name, price, quantity, productId) VALUES (1, 1, 1, 'MacBook', 1200.00, 10, 1);
INSERT INTO OrderItem(id, modificationCounter, idOrder, name, price, quantity, productId) VALUES (2, 1, 2, 'yy', 1204.00, 13, 2);

