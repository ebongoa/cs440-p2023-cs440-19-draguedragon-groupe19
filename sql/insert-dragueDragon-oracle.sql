-- SCRIPT DRAGON 18/11/2021

INSERT INTO DRAGON(nom, sexe, longueur, ecailles, cracheFeu, enAmour) VALUES('Smeaghol', 'M', 152, 1857, 'O', 'Macho');
INSERT INTO DRAGON(nom, sexe, longueur, ecailles, cracheFeu, enAmour) VALUES('Birdurh', 'M', 258, 4787, 'N', 'Timide');
INSERT INTO DRAGON(nom, sexe, longueur, ecailles, cracheFeu, enAmour) VALUES('Negueth', 'F', 128, 1582, 'O', 'Sincere');
INSERT INTO DRAGON(nom, sexe, longueur, ecailles, cracheFeu, enAmour) VALUES('MissToc', 'F', 183, 2781, 'N', 'Volage');
INSERT INTO DRAGON(nom, sexe, longueur, ecailles, cracheFeu, enAmour) VALUES('Bolong', 'M', 213, 2754, 'O', 'Macho');
INSERT INTO DRAGON(nom, sexe, longueur, ecailles, cracheFeu, enAmour) VALUES('Miloch', 'M', 83, 718, 'O', 'Timide');
INSERT INTO DRAGON(nom, sexe, longueur, ecailles, cracheFeu, enAmour) VALUES('Nessie', 'M', 168, 1721, 'N', 'Macho');
INSERT INTO DRAGON(nom, sexe, longueur, ecailles, cracheFeu, enAmour) VALUES('Tarak', 'F', 123, 851, 'O', 'Timide');
INSERT INTO DRAGON(nom, sexe, longueur, ecailles, cracheFeu, enAmour) VALUES('Solong', 'M', 173, 1481, 'O', 'Timide');


INSERT INTO AMOURS(aimant, aime, force) VALUES('Smeaghol', 'Tarak', 'Passionne');
INSERT INTO AMOURS(aimant, aime, force) VALUES('Birdurh', 'Negueth', 'Beaucoup');
INSERT INTO AMOURS(aimant, aime, force) VALUES('Negueth', 'Miloch', 'A la folie');
INSERT INTO AMOURS(aimant, aime, force) VALUES('Miloch', 'Negueth', 'A la folie');
INSERT INTO AMOURS(aimant, aime, force) VALUES('Tarak', 'Bolong', 'Un peu');
INSERT INTO AMOURS(aimant, aime, force) VALUES('Bolong', 'Tarak', 'Beaucoup');
INSERT INTO AMOURS(aimant, aime, force) VALUES('Nessie', 'Tarak', 'Un peu');


INSERT INTO NOURRITURE(produit, calories) VALUES('Pomme', 7);
INSERT INTO NOURRITURE(produit, calories) VALUES('Cacahuete', 10);
INSERT INTO NOURRITURE(produit, calories) VALUES('Orange', 25);
INSERT INTO NOURRITURE(produit, calories) VALUES('Oeuf', 15);
INSERT INTO NOURRITURE(produit, calories) VALUES('Ver', 3);
INSERT INTO NOURRITURE(produit, calories) VALUES('Poisson', 35);


INSERT INTO REPAS(dragon, produit, quantite) VALUES('Smeaghol', 'Cacahuete', 1000);
INSERT INTO REPAS(dragon, produit, quantite) VALUES('Smeaghol', 'Pomme', 16);
INSERT INTO REPAS(dragon, produit, quantite) VALUES('Bolong', 'Oeuf', 4);
INSERT INTO REPAS(dragon, produit, quantite) VALUES('Negueth', 'Orange', 6);
INSERT INTO REPAS(dragon, produit, quantite) VALUES('Negueth', 'Oeuf', 1);
INSERT INTO REPAS(dragon, produit, quantite) VALUES('Miloch', 'Cacahuete', 100);
INSERT INTO REPAS(dragon, produit, quantite) VALUES('Tarak', 'Pomme', 10);
INSERT INTO REPAS(dragon, produit, quantite) VALUES('Tarak', 'Orange', 10);
INSERT INTO REPAS(dragon, produit, quantite) VALUES('Solong', 'Oeuf', 6);
INSERT INTO REPAS(dragon, produit, quantite) VALUES('Solong', 'Orange', 2);
INSERT INTO REPAS(dragon, produit, quantite) VALUES('Miloch', 'Ver', 53);
INSERT INTO REPAS(dragon, produit, quantite) VALUES('Nessie', 'Poisson', 20);
INSERT INTO REPAS(dragon, produit, quantite) VALUES('Solong', 'Poisson', 1);