BEGIN;
INSERT INTO tags (name) VALUES ('Programming');
INSERT INTO tags (name) VALUES ('Data base');
COMMIT;

BEGIN;
INSERT INTO tests (name, user_id) VALUES ('Programming test in BSUIR', 1);
COMMIT;

BEGIN;
INSERT INTO tests_tags (test_id, tag_id) VALUES (1, 1);
INSERT INTO tests_tags (test_id, tag_id) VALUES (1, 2);
COMMIT;