CREATE TABLE student (
                         id BIGINT PRIMARY KEY,
                         name VARCHAR(255) NOT NULL
);

CREATE TABLE course (
                        id BIGINT PRIMARY KEY,
                        name VARCHAR(255) NOT NULL
);

CREATE TABLE passport (
                          id BIGINT PRIMARY KEY,
                          number VARCHAR(50) NOT NULL
);

CREATE TABLE review (
                        id BIGINT PRIMARY KEY,
                        rating INT NOT NULL,
                        description VARCHAR(255) NOT NULL
);
