CREATE EXTENSION IF NOT EXISTS "pgcrypto";
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

DROP TABLE IF exists favorite_heroes_users;
DROP TABLE IF exists heroes;
DROP TABLE IF exists users;

CREATE TABLE users (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(128),
    username VARCHAR(64),
    hierarchy VARCHAR(32)
);

CREATE TABLE heroes (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(128) NOT NULL
);

CREATE TABLE favorite_heroes_users (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    user_id UUID NOT NULL,
    hero_id UUID NOT NULL,
    
    CONSTRAINT fk_favorite_heroes_users_user FOREIGN KEY(user_id) REFERENCES users(id),
    CONSTRAINT fk_favorite_heroes_users_hero FOREIGN KEY(hero_id) REFERENCES heroes(id)
);