CREATE TABLE clients (
    uuid UUID PRIMARY KEY DEFAULT gen_random_uuid(), -- Generate UUID by default
    cpf VARCHAR(11) NOT NULL,
    name VARCHAR(100) NOT NULL,
    tel VARCHAR(15),
    street VARCHAR(255),
    city VARCHAR(100),
    state VARCHAR(2),
    number INTEGER
);