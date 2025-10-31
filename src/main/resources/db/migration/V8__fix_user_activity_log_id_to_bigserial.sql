-- Fix the id column to be BIGSERIAL instead of SERIAL
ALTER TABLE user_activity_log DROP CONSTRAINT IF EXISTS user_activity_log_pkey;

-- Convert id column to bigint safely
ALTER TABLE user_activity_log
    ALTER COLUMN id TYPE BIGINT
        USING id::BIGINT;

-- Recreate a BIGSERIAL-style sequence if missing
DO $$
    BEGIN
        IF NOT EXISTS (SELECT 1 FROM pg_class WHERE relname = 'user_activity_log_id_seq') THEN
            CREATE SEQUENCE user_activity_log_id_seq;
        END IF;
    END $$;

-- Set the id column default to the new sequence
ALTER TABLE user_activity_log
    ALTER COLUMN id SET DEFAULT nextval('user_activity_log_id_seq');

-- Restore primary key constraint
ALTER TABLE user_activity_log ADD PRIMARY KEY (id);

-- Own sequence to table column
ALTER SEQUENCE user_activity_log_id_seq OWNED BY user_activity_log.id;

-- Optional: Add an index for faster lookups by user_uuid
CREATE INDEX IF NOT EXISTS idx_user_activity_user_uuid
    ON user_activity_log (user_uuid);
