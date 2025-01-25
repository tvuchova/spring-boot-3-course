SELECT 'CREATE DATABASE bookdb' WHERE NOT EXISTS (SELECT 1 FROM pg_database WHERE datname = 'bookdb') \gexec
GRANT ALL PRIVILEGES ON DATABASE bookdb TO "user";
