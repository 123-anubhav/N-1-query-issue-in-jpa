Here are the structural SQL queries to generate these tables inside your NPlusOneQuery database:

-- 1. Create the Customer Table
CREATE TABLE Customer (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          name VARCHAR(255) NOT NULL
);

-- 2. Create the Address Table with a Foreign Key referencing Customer
CREATE TABLE Address (
                         addressId INT AUTO_INCREMENT PRIMARY KEY,
                         address VARCHAR(255) NOT NULL,
                         customer_id INT,
                         FOREIGN KEY (customer_id) REFERENCES Customer(id) ON DELETE CASCADE
);
