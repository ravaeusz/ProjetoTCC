CREATE TABLE users (
    us_id SERIAL PRIMARY KEY,
    us_name VARCHAR(100) NOT NULL,
    us_email VARCHAR(150) UNIQUE NOT NULL,
    us_password VARCHAR(255) NOT NULL,
    us_role VARCHAR(50) NOT NULL
);
