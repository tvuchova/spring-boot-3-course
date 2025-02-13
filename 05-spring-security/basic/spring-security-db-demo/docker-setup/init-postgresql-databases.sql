SELECT 'CREATE DATABASE testdb' WHERE NOT EXISTS (SELECT 1 FROM pg_database WHERE datname = 'testdb') \gexec
GRANT ALL PRIVILEGES ON DATABASE testdb TO "user";
