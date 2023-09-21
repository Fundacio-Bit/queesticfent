

CREATE SEQUENCE qef_fitxer_seq INCREMENT 1  MINVALUE 1  MAXVALUE 9223372036854775807  START 1000;
CREATE SEQUENCE qef_traduccio_seq INCREMENT 1  MINVALUE 1  MAXVALUE 9223372036854775807  START 1000;

CREATE TABLE qef_fitxer (
    fitxerid bigint DEFAULT nextval('qef_fitxer_seq'::regclass) NOT NULL,
    descripcio character varying(1000) DEFAULT NULL::character varying,
    mime character varying(255) NOT NULL,
    nom character varying(255) NOT NULL,
    tamany bigint NOT NULL
);

CREATE TABLE qef_idioma (
    idiomaid character varying(5) NOT NULL,
    nom character varying(50) NOT NULL,
    suportat boolean DEFAULT true NOT NULL,
    ordre integer DEFAULT 0 NOT NULL
);

CREATE TABLE qef_traduccio (
    traduccioid bigint DEFAULT nextval('qef_traduccio_seq'::regclass) NOT NULL
);

CREATE TABLE qef_traducciomap (
    traducciomapid bigint NOT NULL,
    idiomaid character varying(10) NOT NULL,
    valor character varying(4000)
);

ALTER TABLE ONLY qef_fitxer
    ADD CONSTRAINT qef_fitxer_pk PRIMARY KEY (fitxerid);

ALTER TABLE ONLY qef_idioma
    ADD CONSTRAINT qef_idioma_pk PRIMARY KEY (idiomaid);

ALTER TABLE ONLY qef_traduccio
    ADD CONSTRAINT qef_traduccio_pk PRIMARY KEY (traduccioid);

ALTER TABLE ONLY qef_traducciomap
    ADD CONSTRAINT qef_traducmap_pk PRIMARY KEY (traducciomapid, idiomaid);

CREATE INDEX qef_fitxer_pk_i ON qef_fitxer USING btree (fitxerid);

CREATE INDEX qef_idioma_pk_i ON qef_idioma USING btree (idiomaid);

CREATE INDEX qef_traduccio_pk_i ON qef_traduccio USING btree (traduccioid);

CREATE INDEX qef_traducciomap_idiomaid_fk_i ON qef_traducciomap USING btree (idiomaid);

CREATE INDEX qef_traducciomap_pk_i ON qef_traducciomap USING btree (traducciomapid);

ALTER TABLE ONLY qef_traducciomap
    ADD CONSTRAINT qef_traducmap_traduccio_fk FOREIGN KEY (traducciomapid) REFERENCES qef_traduccio(traduccioid);

INSERT INTO qef_idioma(idiomaid, nom, ordre) VALUES ('ca', 'Català', 0);
INSERT INTO qef_idioma(idiomaid, nom, ordre) VALUES ('es', 'Castellano', 1);
INSERT INTO qef_idioma(idiomaid, nom, ordre) VALUES ('en', 'English', 2);
    
    
