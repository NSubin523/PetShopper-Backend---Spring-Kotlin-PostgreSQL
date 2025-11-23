-- Needed for gen_random_uuid()
CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE inventory (
                           uuid UUID PRIMARY KEY DEFAULT gen_random_uuid(),

                           category_id UUID NOT NULL,

                           name VARCHAR(255) NOT NULL,
                           description TEXT,
                           image_url TEXT NOT NULL,
                           located_at VARCHAR(255),

                           zip_code VARCHAR(10) NOT NULL,
                           price_min NUMERIC(10,2) NOT NULL,
                           price_max NUMERIC(10,2) NOT NULL,

                           age INTEGER,
                           gender VARCHAR(20),

                           availability availability_status NOT NULL,

                           available_date TIMESTAMP NOT NULL,
                           is_adopted BOOLEAN NOT NULL,

                           created_at TIMESTAMP NOT NULL DEFAULT now(),
                           updated_at TIMESTAMP NOT NULL DEFAULT now()
);

-- Helpful indexes
CREATE INDEX idx_inventory_category_id ON inventory (category_id);
CREATE INDEX idx_inventory_zip_code ON inventory (zip_code);
CREATE INDEX idx_inventory_availability ON inventory (availability);
CREATE INDEX idx_inventory_available_date ON inventory (available_date);