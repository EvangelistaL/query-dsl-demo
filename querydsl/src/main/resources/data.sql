INSERT INTO person (name, born_date)
VALUES
('Lucas Evangelista', '2000-12-12'),
('Roger Matos', '2000-12-12'),
('Flavio Souza', '1992-02-13'),
('Vinicius Costa', '1990-11-20'),
('Ana Celia', '1990-11-20'),
('Fernanda Santos', '2001-06-02'),
('Maria José', '1980-05-10');

INSERT INTO birth_place (state, city)
VALUES
('São Paulo', 'São Paulo'),
('Rio de Janeiro', 'Rio de Janeiro'),
('Minas Gerais', 'Belo Horizonte');

INSERT INTO person_birth_place (birth_place_id, person_id)
VALUES
(1, 1),
(2, 2),
(2, 3),
(1, 4),
(1, 5),
(3, 6),
(3, 7);