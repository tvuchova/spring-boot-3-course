SELECT 'CREATE DATABASE cardb' WHERE NOT EXISTS (SELECT 1 FROM pg_database WHERE datname = 'cardb') \gexec
GRANT ALL PRIVILEGES ON DATABASE cardb TO "user";
