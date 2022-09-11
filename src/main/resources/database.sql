CREATE EXTENSION IF NOT EXISTS "pgcrypto";
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

DROP TABLE IF exists favorite_heroes_users;
DROP TABLE IF exists heroes;
DROP TABLE IF exists users;

CREATE TABLE users (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    full_name VARCHAR(128),
    name VARCHAR(64) UNIQUE,
    password VARCHAR(64),
    hierarchy VARCHAR(32)
);

CREATE TABLE heroes (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(128) NOT NULL UNIQUE
);

CREATE TABLE favorite_heroes_users (
    -- id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    user_id UUID NOT NULL,
    hero_id UUID NOT NULL,
    PRIMARY KEY (user_id, hero_id)
);
-- CREATE UNIQUE INDEX "rule_unique:favorite_heroes_users.user_hero" ON favorite_heroes_users(user_id, hero_id);