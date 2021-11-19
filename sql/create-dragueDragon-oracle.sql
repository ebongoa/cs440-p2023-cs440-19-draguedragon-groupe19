-- SCRIPT DRAGON 18/11/2021

DROP TABLE REPAS;
DROP TABLE AMOURS;
DROP TABLE NOURRITURE;
DROP TABLE DRAGON;

CREATE TABLE DRAGON (
	nom VARCHAR2(25) PRIMARY KEY,
	sexe CHAR(1) CHECK (sexe IN ('M', 'F')),
	longueur NUMBER,
	ecailles NUMBER,
	cracheFeu CHAR(1) CHECK (cracheFeu IN ('O', 'N')),
	enAmour VARCHAR2(10)
);

CREATE TABLE AMOURS (
	aimant VARCHAR2(25),
	aime VARCHAR2(25),
	force VARCHAR2(10),
	CONSTRAINT pk_Amours PRIMARY KEY(aimant, aime),
	CONSTRAINT fk_Amours_Aimant FOREIGN KEY(aimant) REFERENCES Dragon(nom),
	CONSTRAINT fk_Amours_Aime FOREIGN KEY(aime) REFERENCES Dragon(nom)
);

CREATE TABLE NOURRITURE (
	produit VARCHAR2(25) PRIMARY KEY,
	calories NUMBER
);

CREATE TABLE REPAS (
	dragon VARCHAR2(25),
	produit VARCHAR2(25),
	quantite NUMBER,
	CONSTRAINT pk_Repas PRIMARY KEY(dragon, produit),
	CONSTRAINT fk_Repas_Dragon FOREIGN KEY(dragon) REFERENCES Dragon(nom),
	CONSTRAINT fk_Repas_Produit FOREIGN KEY(produit) REFERENCES Nourriture(produit)
);

