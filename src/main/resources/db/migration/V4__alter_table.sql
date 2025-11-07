-- V3__rename_columns_ranking.sql

ALTER TABLE ranking
    RENAME COLUMN id TO rk_id;

ALTER TABLE ranking
    RENAME COLUMN us_id TO rk_us_id;

ALTER TABLE ranking
    RENAME COLUMN pontos TO rk_pontos;

ALTER TABLE ranking
    RENAME COLUMN create_at TO rk_create_at;

ALTER TABLE ranking
    DROP CONSTRAINT fk_ranking_user;

ALTER TABLE ranking
    ADD CONSTRAINT fk_ranking_user
    FOREIGN KEY (rk_us_id)
    REFERENCES users(us_id)
    ON DELETE CASCADE;

