DROP TABLE IF exists favorite_heroes_users;
DROP TABLE IF exists heroes;
DROP TABLE IF exists users;

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(128),
    username VARCHAR(64),
    hierarchy VARCHAR(32)
);

CREATE TABLE heroes (
    id SERIAL PRIMARY KEY,
    name VARCHAR(128) NOT NULL
);

CREATE TABLE favorite_heroes_users (
    id SERIAL PRIMARY KEY,
    user_id BIGINT,
    hero_id BIGINT,
    
    CONSTRAINT fk_favorite_heroes_users_user FOREIGN KEY(user_id) REFERENCES users(id),
    CONSTRAINT fk_favorite_heroes_users_hero FOREIGN KEY(hero_id) REFERENCES heroes(id)
);