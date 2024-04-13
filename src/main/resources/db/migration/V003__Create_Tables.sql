--CREATE SEQUENCE tags_seq
--    START WITH 1
--    INCREMENT BY 1
--    NO MINVALUE
--    NO MAXVALUE
--    CACHE 1;

--
--    START WITH 1
--    INCREMENT BY 1
--    NO MINVALUE
--    NO MAXVALUE
--    CACHE 1;

CREATE TABLE tags (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE tests (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE tests_tags (
    test_id INT,
    tag_id INT,
    PRIMARY KEY (test_id, tag_id),
    FOREIGN KEY (test_id) REFERENCES tests(id),
    FOREIGN KEY (tag_id) REFERENCES tags(id)
);
