CREATE TABLE IF NOT EXISTS population (
   id SERIAL PRIMARY KEY,
   country_name VARCHAR(255) NOT NULL,
   country_code VARCHAR(255) NOT NULL,
   year INT NOT NULL,
   value BIGINT NOT NULL
);

-- INSERT INTO population (country_name, country_code, year, value)
-- VALUES ('Aruba', 'ABW', 1960, 54922);

-- DELETE FROM population WHERE country_name='Aruba' AND year=1960;