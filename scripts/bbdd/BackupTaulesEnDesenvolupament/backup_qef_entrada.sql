-- Table: qef_entrada

-- DROP TABLE qef_entrada;

CREATE TABLE qef_entrada
(
  entradaid bigint NOT NULL DEFAULT nextval('qef_entrada_seq'::regclass),
  accioid bigint NOT NULL,
  usuariid character varying(45) NOT NULL,
  projecteid bigint,
  queesticfentid bigint,
  dada1 character varying(500),
  dada2 character varying(500),
  data timestamp without time zone,
  CONSTRAINT qef_entrada_pk PRIMARY KEY (entradaid),
  CONSTRAINT qef_entrada_accio_accioid_fk FOREIGN KEY (accioid)
      REFERENCES qef_accio (accioid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT qef_entrada_projecte_projec_fk FOREIGN KEY (projecteid)
      REFERENCES qef_projecte (projecteid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE qef_entrada
  OWNER TO queesticfent;

-- Index: qef_entrad_pk_i

-- DROP INDEX qef_entrad_pk_i;

CREATE INDEX qef_entrad_pk_i
  ON qef_entrada
  USING btree
  (entradaid);

-- Index: qef_entrada_accioid_fk_i

-- DROP INDEX qef_entrada_accioid_fk_i;

CREATE INDEX qef_entrada_accioid_fk_i
  ON qef_entrada
  USING btree
  (accioid);

-- Index: qef_entrada_projecteid_fk_i

-- DROP INDEX qef_entrada_projecteid_fk_i;

CREATE INDEX qef_entrada_projecteid_fk_i
  ON qef_entrada
  USING btree
  (projecteid);

