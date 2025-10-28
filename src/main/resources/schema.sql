CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS users (
    id UUID DEFAULT uuid_generate_v4(),
    login VARCHAR(512) NOT NULL,
    email VARCHAR(512) NOT NULL,
    password VARCHAR(256) NOT NULL,
    name VARCHAR(256),
    about TEXT,
    phone VARCHAR(20),
    avatar VARCHAR(2048) NOT NULL DEFAULT 'no_avatar.jpg',
    CONSTRAINT PK_USER PRIMARY KEY (id),
    CONSTRAINT FK_USER_EMAIL UNIQUE (email)
);

CREATE TABLE IF NOT EXISTS genres (
    id UUID DEFAULT uuid_generate_v4(),
    name VARCHAR(256),
    CONSTRAINT PK_GENRE PRIMARY KEY (id)
);