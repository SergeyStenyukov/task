/* password testPASS */
INSERT INTO users (login, password) values ('petrov@gmail.com', '$2a$10$5WPW.kHYoHFLbwdgVDj3s.aYQAiipJ4FScGcHF3WuytMGdjl3oRlG');
INSERT INTO users (login, password) values ('sidorov@gmail.com', '$2a$10$5WPW.kHYoHFLbwdgVDj3s.aYQAiipJ4FScGcHF3WuytMGdjl3oRlG');
INSERT INTO users (login, password) values ('ivanov@gmail.com', '$2a$10$5WPW.kHYoHFLbwdgVDj3s.aYQAiipJ4FScGcHF3WuytMGdjl3oRlG');

INSERT INTO BALANCES (type, amount, user_id) values ('FREE', '232', 1);
INSERT INTO BALANCES (type, amount, user_id) values ('FREE', '111', 2);
INSERT INTO BALANCES (type, amount, user_id) values ('FIXED', '211', 2);
INSERT INTO BALANCES (type, amount, user_id) values ('FREE', '111', 3);
INSERT INTO BALANCES (type, amount, user_id) values ('FREE', '222', 3);
INSERT INTO BALANCES (type, amount, user_id) values ('FREE', '111', 3);
INSERT INTO BALANCES (type, amount, user_id) values ('FIXED', '0', 3);
INSERT INTO BALANCES (type, amount, user_id) values ('FIXED', '5', 3);
INSERT INTO BALANCES (type, amount, user_id) values ('FIXED', '10', 3);
INSERT INTO BALANCES (type, amount, user_id) values ('FIXED', '15', 3);
INSERT INTO BALANCES (type, amount, user_id) values ('FIXED', '20', 3);
INSERT INTO BALANCES (type, amount, user_id) values ('FIXED', '25', 3);
INSERT INTO BALANCES (type, amount, user_id) values ('FREE', '99', 3);