CREATE TABLE Order(
ordernumber NUMERIC(20) PRIMARY KEY AUTO_INCREMENT,
productcode VARCHAR(20),
CPF VARCHAR(20),
amount` VARCHAR(20),
date DATE,
value VARCHAR(20)
)



CREATE TABLE AUTITING (
IDENTIFIER SERIAL NOT NULL,
REGISTER_CODE NUMERIC(20) NOT NULL,
DATETIME TIMESTAMP NOT NULL,
CONSTRAINT auditing_pk PRIMARY KEY (IDENTIFIER)
);