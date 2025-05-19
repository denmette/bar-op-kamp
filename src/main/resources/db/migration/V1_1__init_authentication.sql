CREATE TABLE users (
    id CHAR(26) PRIMARY KEY,
    email VARCHAR(255) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    enabled BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT now()
);

CREATE TABLE user_camp_permissions (
    user_id CHAR(26) NOT NULL,
    camp_id CHAR(26) NOT NULL,
    role VARCHAR(50) NOT NULL,
    PRIMARY KEY (user_id, camp_id),
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (camp_id) REFERENCES camps(id)
);

CREATE TABLE volunteer_auth_token (
    id CHAR(26) PRIMARY KEY,
    token CHAR(26) NOT NULL UNIQUE,
    volunteer_id CHAR(26) NOT NULL,
    camp_id CHAR(26) NOT NULL,
    pincode_hash VARCHAR(255) NOT NULL,
    expires_at TIMESTAMP NOT NULL,
    used BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (camp_id) REFERENCES camps(id)
);
