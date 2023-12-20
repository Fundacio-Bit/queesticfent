/*Eliminació d'usuaris innecessaris*/
DELETE FROM qef_grupsusuari WHERE usuariid NOT IN ('fbosch', 'anadal', 'ptrias', 'atrobat', 'jagarcia', 'mgonzalez', 'gdeignacio', 'jpernia', 'pvico');
DELETE FROM qef_usuarisdepartament WHERE usuariid NOT IN ('fbosch', 'anadal', 'ptrias', 'atrobat', 'jagarcia', 'mgonzalez', 'gdeignacio', 'jpernia', 'pvico');
DELETE FROM qef_usuaris WHERE usuariid NOT IN ('fbosch', 'anadal', 'ptrias', 'atrobat', 'jagarcia', 'mgonzalez', 'gdeignacio', 'jpernia', 'pvico');

/*Eliminació de projectes innecessaris*/
UPDATE qef_modificacionsqueesticfent SET projecteid = 28 WHERE NOT projecteid = 28;
DELETE FROM qef_personalprojecte WHERE projecteid != 28;
INSERT INTO qef_personalprojecte SELECT 8, 'jpernia', 28, 60, 50 WHERE NOT EXISTS (SELECT usuariid FROM qef_personalprojecte WHERE usuariid='jpernia');


DELETE FROM qef_projectes WHERE projecteid != 28;
DELETE FROM qef_usuarisdepartament WHERE departamentid != 1;
DELETE FROM qef_departaments WHERE nom != 'Govern Digital';

