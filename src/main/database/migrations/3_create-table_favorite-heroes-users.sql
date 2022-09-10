CREATE TABLE favorite_heroes_users (
    id SERIAL PRIMARY KEY,
    user_id BIGINT,
    hero_id BIGINT,
    
    CONSTRAINT fk_favorite_heroes_users_user FOREIGN KEY(user_id) REFERENCES users(id),
    CONSTRAINT fk_favorite_heroes_users_hero FOREIGN KEY(hero_id) REFERENCES heroes(id)
);