CREATE TABLE ranking (
    id SERIAL PRIMARY KEY,
    us_id BIGINT NOT NULL,
    pontos INTEGER,
    create_at DATE DEFAULT CURRENT_DATE,
    CONSTRAINT fk_ranking_user FOREIGN KEY (us_id) REFERENCES users(us_id) ON DELETE CASCADE
);
