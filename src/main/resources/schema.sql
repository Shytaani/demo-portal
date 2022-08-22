CREATE TABLE IF NOT EXISTS role(
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(32) NOT NULL
);

CREATE TABLE IF NOT EXISTS "user"(
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    user_name VARCHAR(128) NOT NULL,
    password VARCHAR(128) NOT NULL
);

CREATE TABLE IF NOT EXISTS user_role(
    user_id INTEGER,
    role_id INTEGER,
    CONSTRAINT pk_user_role PRIMARY KEY(user_id, role_id),
    CONSTRAINT fk_user_role_role_id FOREIGN KEY(role_id) REFERENCES role(id),
    CONSTRAINT fk_user_role_user_id FOREIGN KEY(user_id) REFERENCES "user"(id)
);
