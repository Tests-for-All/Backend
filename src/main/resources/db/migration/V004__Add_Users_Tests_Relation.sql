ALTER TABLE tests
ADD COLUMN user_id INT;

ALTER TABLE tests
ADD CONSTRAINT fk_user_id
FOREIGN KEY (user_id)
REFERENCES users(id);

ALTER TABLE users
ADD COLUMN test_id INT;

ALTER TABLE users
ADD CONSTRAINT fk_test_id
FOREIGN KEY (test_id)
REFERENCES tests(id);
