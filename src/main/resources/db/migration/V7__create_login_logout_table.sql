CREATE TABLE user_activity_log (
                                   id SERIAL PRIMARY KEY,
                                   user_uuid UUID NOT NULL REFERENCES users(uuid) ON DELETE CASCADE,
                                   event_type VARCHAR(20) NOT NULL CHECK (event_type IN ('LOGIN', 'LOGOUT')),
                                   event_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
