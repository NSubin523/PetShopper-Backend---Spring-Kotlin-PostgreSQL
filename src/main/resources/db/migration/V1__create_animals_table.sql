CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE animals(
  id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
  type VARCHAR(50) UNIQUE NOT NULL,
  description TEXT,
  is_available BOOLEAN DEFAULT false,
  image_url TEXT,
  created_at TIMESTAMP DEFAULT NOW(),
  updated_at TIMESTAMP DEFAULT NOW()
);