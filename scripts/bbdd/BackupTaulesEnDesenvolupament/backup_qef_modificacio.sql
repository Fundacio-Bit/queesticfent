CREATE TABLE qef_modificacio
(
  modificacioid bigint NOT NULL DEFAULT nextval('qef_modificacio_seq'::regclass),
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
  CONSTRAINT qef_modificacio_pk PRIMARY KEY (modificacioid),
  CONSTRAINT qef_modific_accio_accioid_fk FOREIGN KEY (accioid)
      REFERENCES qef_accio (accioid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT qef_modific_entrada_entrada_fk FOREIGN KEY (entradaid)
      REFERENCES qef_entrada (entradaid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT qef_modific_projecte_newpro_fk FOREIGN KEY (newprojecteid)
      REFERENCES qef_projecte (projecteid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT qef_modific_projecte_oldpro_fk FOREIGN KEY (oldprojecteid)
      REFERENCES qef_projecte (projecteid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE qef_modificacio
  OWNER TO queesticfent;

-- Index: qef_modif_pk_i

-- DROP INDEX qef_modif_pk_i;

CREATE INDEX qef_modif_pk_i
  ON qef_modificacio
  USING btree
  (modificacioid);

-- Index: qef_modific_newprojecteid_fk_i

-- DROP INDEX qef_modific_newprojecteid_fk_i;

CREATE INDEX qef_modific_newprojecteid_fk_i
  ON qef_modificacio
  USING btree
  (newprojecteid);

-- Index: qef_modific_oldprojecteid_fk_i

-- DROP INDEX qef_modific_oldprojecteid_fk_i;

CREATE INDEX qef_modific_oldprojecteid_fk_i
  ON qef_modificacio
  USING btree
  (oldprojecteid);

-- Index: qef_modificacio_accioid_fk_i

-- DROP INDEX qef_modificacio_accioid_fk_i;

CREATE INDEX qef_modificacio_accioid_fk_i
  ON qef_modificacio
  USING btree
  (accioid);

-- Index: qef_modificacio_entradaid_fk_i

-- DROP INDEX qef_modificacio_entradaid_fk_i;

CREATE INDEX qef_modificacio_entradaid_fk_i
  ON qef_modificacio
  USING btree
  (entradaid);
