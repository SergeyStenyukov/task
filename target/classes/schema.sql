CREATE TABLE IF NOT EXISTS users(
id SERIAL PRIMARY KEY,
login varchar(30) UNIQUE NOT NULL,
password varchar (100) NOT NULL);

CREATE TABLE IF NOT EXISTS balances(
id SERIAL PRIMARY KEY,
type varchar(30),
amount numeric (20,5),
created_date datetime default CURRENT_TIMESTAMP,
user_id int REFERENCES users (id) ON DELETE SET NULL);
