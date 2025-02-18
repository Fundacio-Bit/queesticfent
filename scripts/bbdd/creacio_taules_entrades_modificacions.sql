-- Sequence: qef_entrades_seq

-- DROP SEQUENCE qef_entrades_seq;

CREATE SEQUENCE qef_entrades_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1000
  CACHE 1;
ALTER TABLE qef_entrades_seq
  OWNER TO queesticfent;



  -- Sequence: qef_modificacions_seq

-- DROP SEQUENCE qef_modificacions_seq;

CREATE SEQUENCE qef_modificacions_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1000
  CACHE 1;
ALTER TABLE qef_modificacions_seq
  OWNER TO queesticfent;





-- Table: qef_modificacions

-- DROP TABLE qef_modificacions;

CREATE TABLE qef_modificacions
(
  modificacioid bigint NOT NULL DEFAULT nextval('qef_modificacions_seq'::regclass),
  entradaid bigint NOT NULL,
  accioid bigint NOT NULL,
  oldusuariid character varying(45) NOT NULL,
  oldprojecteid bigint,
  oldqueesticfentid bigint,
  olddada1 character varying(500) DEFAULT NULL::character varying,
  olddada2 character varying(500) DEFAULT NULL::character varying,
  olddata timestamp without time zone,
  newusuariid character varying(45) NOT NULL,
  newprojecteid bigint,
  newqueesticfentid bigint,
  newdada1 character varying(500) DEFAULT NULL::character varying,
  newdada2 character varying(500) DEFAULT NULL::character varying,
  newdata timestamp without time zone,
  CONSTRAINT qef_modificacions_pk PRIMARY KEY (modificacioid),
  CONSTRAINT qef_modif_accions_accioid_fk FOREIGN KEY (accioid)
      REFERENCES qef_accions (accioid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT qef_modif_entrades_entradai_fk FOREIGN KEY (entradaid)
      REFERENCES qef_entrades (entradaid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT qef_modif_projectes_newproj_fk FOREIGN KEY (newprojecteid)
      REFERENCES qef_projectes (projecteid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT qef_modif_projectes_oldproj_fk FOREIGN KEY (oldprojecteid)
      REFERENCES qef_projectes (projecteid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE qef_modificacions
  OWNER TO queesticfent;

-- Index: qef_modif_accioid_fk_i

-- DROP INDEX qef_modif_accioid_fk_i;

CREATE INDEX qef_modif_accioid_fk_i
  ON qef_modificacions
  USING btree
  (accioid);

-- Index: qef_modif_entradaid_fk_i

-- DROP INDEX qef_modif_entradaid_fk_i;

CREATE INDEX qef_modif_entradaid_fk_i
  ON qef_modificacions
  USING btree
  (entradaid);

-- Index: qef_modif_newproject_fk_i

-- DROP INDEX qef_modif_newproject_fk_i;

CREATE INDEX qef_modif_newproject_fk_i
  ON qef_modificacions
  USING btree
  (newprojecteid);

-- Index: qef_modif_oldproject_fk_i

-- DROP INDEX qef_modif_oldproject_fk_i;

CREATE INDEX qef_modif_oldproject_fk_i
  ON qef_modificacions
  USING btree
  (oldprojecteid);

-- Index: qef_modif_pk_i

-- DROP INDEX qef_modif_pk_i;

CREATE INDEX qef_modif_pk_i
  ON qef_modificacions
  USING btree
  (modificacioid);



-- Table: qef_entrades

-- DROP TABLE qef_entrades;

CREATE TABLE qef_entrades
(
  entradaid bigint NOT NULL DEFAULT nextval('qef_entrades_seq'::regclass),
  accioid bigint NOT NULL,
  usuariid character varying(45) NOT NULL,
  projecteid bigint,
  queesticfentid bigint,
  dada1 character varying(500),
  dada2 character varying(500),
  data time without time zone,
  CONSTRAINT qef_entrades_pk PRIMARY KEY (entradaid),
  CONSTRAINT qef_entrades_accions_accioi_fk FOREIGN KEY (accioid)
      REFERENCES qef_accions (accioid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT qef_entrades_projectes_pid_fk FOREIGN KEY (projecteid)
      REFERENCES qef_projectes (projecteid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE qef_entrades
  OWNER TO queesticfent;

-- Index: qef_entrad_pk_i

-- DROP INDEX qef_entrad_pk_i;

CREATE INDEX qef_entrad_pk_i
  ON qef_entrades
  USING btree
  (entradaid);

-- Index: qef_entrades_accioid_fk_i

-- DROP INDEX qef_entrades_accioid_fk_i;

CREATE INDEX qef_entrades_accioid_fk_i
  ON qef_entrades
  USING btree
  (accioid);

-- Index: qef_entrades_projecteid_fk_i

-- DROP INDEX qef_entrades_projecteid_fk_i;

CREATE INDEX qef_entrades_projecteid_fk_i
  ON qef_entrades
  USING btree
  (projecteid);


--
-- MODIFICACIO DE NOMS: ISSUE #21
--

CREATE SEQUENCE qef_modificacio_seq INCREMENT 1 START 1000;
ALTER TABLE qef_modificacio ALTER COLUMN modificacioid SET DEFAULT nextval('qef_modificacio_seq');
-- oracle ALTER TABLE qef_modificacio ALTER COLUMN modificacioid SET DEFAULT qef_modificacio_seq.nextval);

ALTER TABLE qef_modificacio DROP CONSTRAINT qef_modif_accions_accioid_fk;
ALTER TABLE qef_modificacio ADD CONSTRAINT qef_modific_accio_accioid_fk  FOREIGN KEY (accioid)  REFERENCES qef_accio (accioid);

ALTER TABLE qef_modificacio DROP CONSTRAINT qef_modif_projectes_newproj_fk;
ALTER TABLE qef_modificacio ADD CONSTRAINT qef_modific_projecte_newpro_fk  FOREIGN KEY (newprojecteid)  REFERENCES qef_projecte (projecteid);

ALTER TABLE qef_modificacio DROP CONSTRAINT qef_modif_entrades_entradai_fk;
ALTER TABLE qef_modificacio ADD CONSTRAINT qef_modific_entrada_entrada_fk  FOREIGN KEY (entradaid)  REFERENCES qef_entrada (entradaid);

ALTER TABLE qef_modificacio DROP CONSTRAINT qef_modif_projectes_oldproj_fk;
ALTER TABLE qef_modificacio ADD CONSTRAINT qef_modific_projecte_oldpro_fk  FOREIGN KEY (oldprojecteid)  REFERENCES qef_projecte (projecteid);