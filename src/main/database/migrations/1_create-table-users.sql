CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(128),
    username VARCHAR(64),
    hierarchy VARCHAR(32)
);