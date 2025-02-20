SELECT 'CREATE DATABASE spring' WHERE NOT EXISTS (SELECT 1 FROM pg_database WHERE datname = 'spring') \gexec
GRANT ALL PRIVILEGES ON DATABASE spring TO "root";
