ALTER TABLE qef_accions RENAME TO qef_accio;
ALTER TABLE qef_departaments RENAME TO qef_departament;
ALTER TABLE qef_festius RENAME TO qef_festiu;
ALTER TABLE qef_modificacionsqueesticfent RENAME TO qef_modificacioqueesticfent;
ALTER TABLE qef_projectes RENAME TO qef_projecte;
ALTER TABLE qef_usuaris RENAME TO qef_usuari;
ALTER TABLE qef_usuarisdepartament RENAME TO qef_usuaridepartament;


ALTER TABLE qef_personalprojecte DROP CONSTRAINT qef_persproj_projectes_pro_fk;
ALTER TABLE qef_personalprojecte ADD CONSTRAINT qef_persproj_qef_projecte_projecteid_fk  FOREIGN KEY (projecteid)  REFERENCES qef_projecte (projecteid);

CREATE SEQUENCE qef_accio_seq INCREMENT 1 START 1000;
ALTER TABLE qef_accio ALTER COLUMN accioid SET DEFAULT nextval('qef_accio_seq');
-- oracle ALTER TABLE qef_accio ALTER COLUMN accioid SET DEFAULT qef_accio_seq.nextval);

ALTER INDEX qef_accions_pk RENAME to qef_accio_pk;

CREATE SEQUENCE qef_departament_seq INCREMENT 1 START 1000;
ALTER TABLE qef_departament ALTER COLUMN departamentid SET DEFAULT nextval('qef_departament_seq');
-- oracle ALTER TABLE qef_departament ALTER COLUMN departamentid SET DEFAULT qef_departament_seq.nextval);

CREATE SEQUENCE qef_festiu_seq INCREMENT 1 START 1000;
ALTER TABLE qef_festiu ALTER COLUMN festiuid SET DEFAULT nextval('qef_festiu_seq');
-- oracle ALTER TABLE qef_festiu ALTER COLUMN festiuid SET DEFAULT qef_festiu_seq.nextval);

ALTER INDEX qef_festius_pk RENAME to qef_festiu_pk;



CREATE SEQUENCE qef_modificacioqueesticfen_seq INCREMENT 1 START 1000;
ALTER TABLE qef_modificacioqueesticfent ALTER COLUMN modificacioid SET DEFAULT nextval('qef_modificacioqueesticfen_seq');
-- oracle ALTER TABLE qef_modificacioqueesticfent ALTER COLUMN modificacioid SET DEFAULT qef_modificacioqueesticfen_seq.nextval);

CREATE SEQUENCE qef_projecte_seq INCREMENT 1 START 1000;
ALTER TABLE qef_projecte ALTER COLUMN projecteid SET DEFAULT nextval('qef_projecte_seq');
-- oracle ALTER TABLE qef_projecte ALTER COLUMN projecteid SET DEFAULT qef_projecte_seq.nextval);

ALTER INDEX qef_usuaris_pk RENAME to qef_usuari_pk;

CREATE SEQUENCE qef_usuaridepartament_seq INCREMENT 1 START 1000;
ALTER TABLE qef_usuaridepartament ALTER COLUMN usuaridepartamentid SET DEFAULT nextval('qef_usuaridepartament_seq');
-- oracle ALTER TABLE qef_usuaridepartament ALTER COLUMN usuaridepartamentid SET DEFAULT qef_usuaridepartament_seq.nextval);

ALTER TABLE qef_personalprojecte DROP CONSTRAINT qef_persproj_qef_projecte_projecteid_fk;
ALTER TABLE qef_personalprojecte ADD CONSTRAINT qef_persproj_qef_projecte_p_fk  FOREIGN KEY (projecteid)  REFERENCES qef_projecte (projecteid);

ALTER TABLE qef_modificacioqueesticfent DROP CONSTRAINT qef_modific_accions_accioid_fk;
ALTER TABLE qef_modificacioqueesticfent ADD CONSTRAINT qef_modifqef_accio_accioid_fk  FOREIGN KEY (accioid)  REFERENCES qef_accio (accioid);

ALTER TABLE qef_modificacioqueesticfent DROP CONSTRAINT qef_modific_projectes_proje_fk;
ALTER TABLE qef_modificacioqueesticfent ADD CONSTRAINT qef_modifqef_projecte_proje_fk  FOREIGN KEY (projecteid)  REFERENCES qef_projecte (projecteid);

ALTER TABLE qef_personalprojecte DROP CONSTRAINT qef_persproj_qef_projecte_p_fk;
ALTER TABLE qef_personalprojecte ADD CONSTRAINT qef_persproj_projecte_proje_fk  FOREIGN KEY (projecteid)  REFERENCES qef_projecte (projecteid);

ALTER TABLE qef_projecte DROP CONSTRAINT qef_projectes_departamen_d_fk;
ALTER TABLE qef_projecte ADD CONSTRAINT qef_projecte_departamen_departamentid_fk  FOREIGN KEY (departamentid)  REFERENCES qef_departament (departamentid);

ALTER TABLE qef_usuaridepartament DROP CONSTRAINT qef_usudep_usuaris_usuari_fk;
ALTER TABLE qef_usuaridepartament ADD CONSTRAINT qef_usudepart_usuari_usuari_fk  FOREIGN KEY (usuariid)  REFERENCES qef_usuari (usuariid);

ALTER TABLE qef_usuaridepartament DROP CONSTRAINT qef_usudep_departamen_depar_fk;
ALTER TABLE qef_usuaridepartament ADD CONSTRAINT qef_usudepart_departamen_departamentid_fk  FOREIGN KEY (departamentid)  REFERENCES qef_departament (departamentid);



-- ==== ERRORS EN TAULA ]Departament[:
ALTER INDEX qef_departaments_pk RENAME to qef_departament_pk;



-- ==== ERRORS EN TAULA ]ModificacioQueEsticFent[:
ALTER INDEX qef_modific_pk RENAME to qef_modificacioqueesticfent_pk;
ALTER INDEX qef_modific_accioid_fk_i RENAME to qef_modifqef_accioid_fk_i;
ALTER INDEX qef_modific_projecteid_fk_i RENAME to qef_modifqef_projecteid_fk_i;


-- ==== ERRORS EN TAULA ]Projecte[:
ALTER INDEX qef_projectes_pk RENAME to qef_projecte_pk;
ALTER TABLE qef_projecte DROP CONSTRAINT qef_projecte_departamen_departamentid_fk;
ALTER TABLE qef_projecte ADD CONSTRAINT qef_projecte_departamen_departamentid_fk  FOREIGN KEY (departamentid)  REFERENCES qef_departament (departamentid);
ALTER INDEX qef_projectes_departamen_fk_i RENAME to qef_projecte_departamentid_fk_i;


-- ==== ERRORS EN TAULA ]UsuariDepartament[:
ALTER INDEX qef_usudep_usuariid_fk_i RENAME to qef_usudepart_usuariid_fk_i;
ALTER TABLE qef_usuaridepartament DROP CONSTRAINT qef_usudepart_departamen_departamentid_fk;
ALTER TABLE qef_usuaridepartament ADD CONSTRAINT qef_usudepart_departamen_departamentid_fk  FOREIGN KEY (departamentid)  REFERENCES qef_departament (departamentid);
ALTER INDEX qef_usudep_departamentid_fk_i RENAME to qef_usudepart_departamentid_fk_i;
ALTER INDEX qef_usuarisdepartament_pk RENAME to qef_usuaridepartament_pk;

-- ==== ERRORS EN TAULA ]Projecte[:
ALTER TABLE qef_projecte DROP CONSTRAINT qef_projecte_departamen_departamentid_fk;
ALTER TABLE qef_projecte ADD CONSTRAINT qef_projecte_departamen_did_fk  FOREIGN KEY (departamentid)  REFERENCES qef_departament (departamentid);
ALTER INDEX qef_projecte_departamentid_fk_i RENAME to qef_projecte_depid_fk_i;

-- ==== ERRORS EN TAULA ]UsuariDepartament[:
ALTER TABLE qef_usuaridepartament DROP CONSTRAINT qef_usudepart_departamen_departamentid_fk;
ALTER TABLE qef_usuaridepartament ADD CONSTRAINT qef_usudepart_departamen_d_fk  FOREIGN KEY (departamentid)  REFERENCES qef_departament (departamentid);
ALTER INDEX qef_usudepart_departamentid_fk_i RENAME to qef_usudepart_depid_fk_i;


DROP SEQUENCE qef_usuarisdepartament_seq;
DROP SEQUENCE qef_departaments_seq;
DROP SEQUENCE qef_festius_seq;
DROP SEQUENCE qef_modificacionsqueesticfent_seq;
DROP SEQUENCE qef_accions_seq;
DROP SEQUENCE qef_projectes_seq;

