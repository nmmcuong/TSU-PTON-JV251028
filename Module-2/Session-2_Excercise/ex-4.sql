CREATE TABLE users(
   id INTEGER PRIMARY KEY, 
   username VARCHAR(100) UNIQUE, 
   pass TEXT NOT NULL,
   statuss TEXT DEFAULT 'ACTIVE',
   CHECK(statuss = 'ACTIVE' OR statuss = 'INACTIVE')
);