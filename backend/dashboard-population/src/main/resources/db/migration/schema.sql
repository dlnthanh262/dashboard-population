CREATE TABLE IF NOT EXISTS population (
                                               id SERIAL PRIMARY KEY,
                                               year INT NOT NULL,
                                               country VARCHAR(255) NOT NULL,
    population BIGINT NOT NULL
    );

INSERT INTO population (year, country, population)
VALUES
    (2020, 'Vietnam', 97338579),
    (2020, 'USA', 331002651),
    (2020, 'India', 1380004385);