CREATE TABLE IF NOT EXISTS users (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(255) NOT NULL
);

-- Ensure id column uses auto-increment even if table already existed without it
ALTER TABLE users MODIFY COLUMN id BIGINT NOT NULL AUTO_INCREMENT;
