-- Create PostgreSQL enum for Availability
CREATE TYPE availability_status AS ENUM (
    'COMING_SOON',
    'AVAILABLE',
    'LOW_STOCK'
);