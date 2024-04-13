--CREATE SEQUENCE questions_seq
--    START WITH 1
--    INCREMENT BY 1
--    NO MINVALUE
--    NO MAXVALUE
--    CACHE 1;
--
--
--    START WITH 1
--    INCREMENT BY 1
--    NO MINVALUE
--    NO MAXVALUE
--    CACHE 1;

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
    is_true BOOLEAN,
    question_id INT,
    FOREIGN KEY (question_id)
    REFERENCES questions(id)
);