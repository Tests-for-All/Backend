CREATE TABLE questions (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    details VARCHAR(255),
    test_id INT,
    FOREIGN KEY (test_id)
    REFERENCES tests(id)
);

CREATE TABLE answers (
    id SERIAL PRIMARY KEY,
    text VARCHAR(255),
    is_true BIT,
    question_id INT,
    FOREIGN KEY (question_id)
    REFERENCES questions(id)
);