--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.25
-- Dumped by pg_dump version 9.5.25

-- Started on 2025-02-18 12:47:58 UTC

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12361)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2248 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


--
-- TOC entry 181 (class 1259 OID 16386)
-- Name: qef_accions_seq; Type: SEQUENCE; Schema: public; Owner: queesticfent
--

CREATE SEQUENCE public.qef_accions_seq
    START WITH 1000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.qef_accions_seq OWNER TO queesticfent;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 182 (class 1259 OID 16388)
-- Name: qef_accions; Type: TABLE; Schema: public; Owner: queesticfent
--

CREATE TABLE public.qef_accions (
    accioid bigint DEFAULT nextval('public.qef_accions_seq'::regclass) NOT NULL,
    nom character varying(45) NOT NULL,
    nomllegenda character varying(45) NOT NULL,
    color character varying,
    descripcio character varying(500) DEFAULT NULL::character varying
);


ALTER TABLE public.qef_accions OWNER TO queesticfent;

--
-- TOC entry 183 (class 1259 OID 16396)
-- Name: qef_departaments_seq; Type: SEQUENCE; Schema: public; Owner: queesticfent
--

CREATE SEQUENCE public.qef_departaments_seq
    START WITH 1000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.qef_departaments_seq OWNER TO queesticfent;

--
-- TOC entry 184 (class 1259 OID 16398)
-- Name: qef_departaments; Type: TABLE; Schema: public; Owner: queesticfent
--

CREATE TABLE public.qef_departaments (
    departamentid bigint DEFAULT nextval('public.qef_departaments_seq'::regclass) NOT NULL,
    nom character varying(300) NOT NULL,
    coordinadorid character varying(200) NOT NULL,
    nomldap character varying(200) NOT NULL,
    descripcio character varying(3000)
);


ALTER TABLE public.qef_departaments OWNER TO queesticfent;

--
-- TOC entry 185 (class 1259 OID 16405)
-- Name: qef_festius_seq; Type: SEQUENCE; Schema: public; Owner: queesticfent
--

CREATE SEQUENCE public.qef_festius_seq
    START WITH 1000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.qef_festius_seq OWNER TO queesticfent;

--
-- TOC entry 186 (class 1259 OID 16407)
-- Name: qef_festius; Type: TABLE; Schema: public; Owner: queesticfent
--

CREATE TABLE public.qef_festius (
    festiuid bigint DEFAULT nextval('public.qef_festius_seq'::regclass) NOT NULL,
    nom character varying(300) NOT NULL,
    data date NOT NULL,
    descripcio character varying(2000) DEFAULT NULL::character varying
);


ALTER TABLE public.qef_festius OWNER TO queesticfent;

--
-- TOC entry 187 (class 1259 OID 16415)
-- Name: qef_fitxer_seq; Type: SEQUENCE; Schema: public; Owner: queesticfent
--

CREATE SEQUENCE public.qef_fitxer_seq
    START WITH 1000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.qef_fitxer_seq OWNER TO queesticfent;

--
-- TOC entry 188 (class 1259 OID 16417)
-- Name: qef_fitxer; Type: TABLE; Schema: public; Owner: queesticfent
--

CREATE TABLE public.qef_fitxer (
    fitxerid bigint DEFAULT nextval('public.qef_fitxer_seq'::regclass) NOT NULL,
    descripcio character varying(1000) DEFAULT NULL::character varying,
    mime character varying(255) NOT NULL,
    nom character varying(255) NOT NULL,
    tamany bigint NOT NULL
);


ALTER TABLE public.qef_fitxer OWNER TO queesticfent;

--
-- TOC entry 189 (class 1259 OID 16441)
-- Name: qef_idioma; Type: TABLE; Schema: public; Owner: queesticfent
--

CREATE TABLE public.qef_idioma (
    idiomaid character varying(5) NOT NULL,
    nom character varying(50) NOT NULL,
    suportat boolean DEFAULT true NOT NULL,
    ordre integer DEFAULT 0 NOT NULL
);


ALTER TABLE public.qef_idioma OWNER TO queesticfent;

--
-- TOC entry 190 (class 1259 OID 16454)
-- Name: qef_modificacionsqueesticfent_seq; Type: SEQUENCE; Schema: public; Owner: queesticfent
--

CREATE SEQUENCE public.qef_modificacionsqueesticfent_seq
    START WITH 1000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.qef_modificacionsqueesticfent_seq OWNER TO queesticfent;

--
-- TOC entry 191 (class 1259 OID 16456)
-- Name: qef_modificacionsqueesticfent; Type: TABLE; Schema: public; Owner: queesticfent
--

CREATE TABLE public.qef_modificacionsqueesticfent (
    modificacioid bigint DEFAULT nextval('public.qef_modificacionsqueesticfent_seq'::regclass) NOT NULL,
    accioid bigint NOT NULL,
    usuariid character varying(45) NOT NULL,
    projecteid bigint,
    queesticfentid bigint,
    dada1 character varying(500) DEFAULT NULL::character varying,
    dada2 character varying(500) DEFAULT NULL::character varying,
    data timestamp without time zone
);


ALTER TABLE public.qef_modificacionsqueesticfent OWNER TO queesticfent;

--
-- TOC entry 2249 (class 0 OID 0)
-- Dependencies: 191
-- Name: COLUMN qef_modificacionsqueesticfent.queesticfentid; Type: COMMENT; Schema: public; Owner: queesticfent
--

COMMENT ON COLUMN public.qef_modificacionsqueesticfent.queesticfentid IS '-1 significa nou';


--
-- TOC entry 192 (class 1259 OID 16465)
-- Name: qef_personalprojecte_seq; Type: SEQUENCE; Schema: public; Owner: queesticfent
--

CREATE SEQUENCE public.qef_personalprojecte_seq
    START WITH 1000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.qef_personalprojecte_seq OWNER TO queesticfent;

--
-- TOC entry 193 (class 1259 OID 16467)
-- Name: qef_personalprojecte; Type: TABLE; Schema: public; Owner: queesticfent
--

CREATE TABLE public.qef_personalprojecte (
    personalprojecteid bigint DEFAULT nextval('public.qef_personalprojecte_seq'::regclass) NOT NULL,
    usuariid character varying(50) NOT NULL,
    projecteid bigint NOT NULL,
    ordre bigint NOT NULL,
    percent smallint
);


ALTER TABLE public.qef_personalprojecte OWNER TO queesticfent;

--
-- TOC entry 194 (class 1259 OID 16471)
-- Name: qef_projectes_seq; Type: SEQUENCE; Schema: public; Owner: queesticfent
--

CREATE SEQUENCE public.qef_projectes_seq
    START WITH 1000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.qef_projectes_seq OWNER TO queesticfent;

--
-- TOC entry 195 (class 1259 OID 16473)
-- Name: qef_projectes; Type: TABLE; Schema: public; Owner: queesticfent
--

CREATE TABLE public.qef_projectes (
    projecteid bigint DEFAULT nextval('public.qef_projectes_seq'::regclass) NOT NULL,
    nom character varying(45) NOT NULL,
    departamentid bigint NOT NULL,
    descripcio character varying(500) DEFAULT NULL::character varying,
    actiu boolean NOT NULL,
    fromdata date NOT NULL,
    todata date
);


ALTER TABLE public.qef_projectes OWNER TO queesticfent;

--
-- TOC entry 196 (class 1259 OID 16481)
-- Name: qef_traduccio_seq; Type: SEQUENCE; Schema: public; Owner: queesticfent
--

CREATE SEQUENCE public.qef_traduccio_seq
    START WITH 1000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.qef_traduccio_seq OWNER TO queesticfent;

--
-- TOC entry 197 (class 1259 OID 16483)
-- Name: qef_traduccio; Type: TABLE; Schema: public; Owner: queesticfent
--

CREATE TABLE public.qef_traduccio (
    traduccioid bigint DEFAULT nextval('public.qef_traduccio_seq'::regclass) NOT NULL
);


ALTER TABLE public.qef_traduccio OWNER TO queesticfent;

--
-- TOC entry 198 (class 1259 OID 16487)
-- Name: qef_traducciomap; Type: TABLE; Schema: public; Owner: queesticfent
--

CREATE TABLE public.qef_traducciomap (
    traducciomapid bigint NOT NULL,
    idiomaid character varying(10) NOT NULL,
    valor character varying(4000)
);


ALTER TABLE public.qef_traducciomap OWNER TO queesticfent;

--
-- TOC entry 199 (class 1259 OID 16493)
-- Name: qef_usuaris; Type: TABLE; Schema: public; Owner: queesticfent
--

CREATE TABLE public.qef_usuaris (
    usuariid character varying(100) NOT NULL,
    nom character varying(100) NOT NULL,
    llinatge1 character varying(100) DEFAULT NULL::character varying,
    llinatge2 character varying(100) DEFAULT NULL::character varying,
    correu character varying(100) NOT NULL,
    descripcio character varying(100) DEFAULT NULL::character varying,
    extensio character varying(100) DEFAULT NULL::character varying,
    naixement date,
    telefoncasa character varying(100) DEFAULT NULL::character varying,
    telefonmobil character varying(100) DEFAULT NULL::character varying,
    contrasenya character varying(100)
);


ALTER TABLE public.qef_usuaris OWNER TO queesticfent;

--
-- TOC entry 200 (class 1259 OID 16505)
-- Name: qef_usuarisdepartament_seq; Type: SEQUENCE; Schema: public; Owner: queesticfent
--

CREATE SEQUENCE public.qef_usuarisdepartament_seq
    START WITH 1000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.qef_usuarisdepartament_seq OWNER TO queesticfent;

--
-- TOC entry 201 (class 1259 OID 16507)
-- Name: qef_usuarisdepartament; Type: TABLE; Schema: public; Owner: queesticfent
--

CREATE TABLE public.qef_usuarisdepartament (
    usuariid character varying(20) NOT NULL,
    departamentid bigint NOT NULL,
    usuaridepartamentid bigint DEFAULT nextval('public.qef_usuarisdepartament_seq'::regclass) NOT NULL
);


ALTER TABLE public.qef_usuarisdepartament OWNER TO queesticfent;

--
-- TOC entry 2077 (class 2606 OID 16512)
-- Name: qef_accions_pk; Type: CONSTRAINT; Schema: public; Owner: queesticfent
--

ALTER TABLE ONLY public.qef_accions
    ADD CONSTRAINT qef_accions_pk PRIMARY KEY (accioid);


--
-- TOC entry 2080 (class 2606 OID 16514)
-- Name: qef_departaments_pk; Type: CONSTRAINT; Schema: public; Owner: queesticfent
--

ALTER TABLE ONLY public.qef_departaments
    ADD CONSTRAINT qef_departaments_pk PRIMARY KEY (departamentid);


--
-- TOC entry 2084 (class 2606 OID 16516)
-- Name: qef_festius_pk; Type: CONSTRAINT; Schema: public; Owner: queesticfent
--

ALTER TABLE ONLY public.qef_festius
    ADD CONSTRAINT qef_festius_pk PRIMARY KEY (festiuid);


--
-- TOC entry 2086 (class 2606 OID 16518)
-- Name: qef_fitxer_pk; Type: CONSTRAINT; Schema: public; Owner: queesticfent
--

ALTER TABLE ONLY public.qef_fitxer
    ADD CONSTRAINT qef_fitxer_pk PRIMARY KEY (fitxerid);


--
-- TOC entry 2089 (class 2606 OID 16524)
-- Name: qef_idioma_pk; Type: CONSTRAINT; Schema: public; Owner: queesticfent
--

ALTER TABLE ONLY public.qef_idioma
    ADD CONSTRAINT qef_idioma_pk PRIMARY KEY (idiomaid);


--
-- TOC entry 2093 (class 2606 OID 16528)
-- Name: qef_modific_pk; Type: CONSTRAINT; Schema: public; Owner: queesticfent
--

ALTER TABLE ONLY public.qef_modificacionsqueesticfent
    ADD CONSTRAINT qef_modific_pk PRIMARY KEY (modificacioid);


--
-- TOC entry 2097 (class 2606 OID 16530)
-- Name: qef_personalprojecte_pk; Type: CONSTRAINT; Schema: public; Owner: queesticfent
--

ALTER TABLE ONLY public.qef_personalprojecte
    ADD CONSTRAINT qef_personalprojecte_pk PRIMARY KEY (personalprojecteid);


--
-- TOC entry 2102 (class 2606 OID 16532)
-- Name: qef_projectes_pk; Type: CONSTRAINT; Schema: public; Owner: queesticfent
--

ALTER TABLE ONLY public.qef_projectes
    ADD CONSTRAINT qef_projectes_pk PRIMARY KEY (projecteid);


--
-- TOC entry 2105 (class 2606 OID 16534)
-- Name: qef_traduccio_pk; Type: CONSTRAINT; Schema: public; Owner: queesticfent
--

ALTER TABLE ONLY public.qef_traduccio
    ADD CONSTRAINT qef_traduccio_pk PRIMARY KEY (traduccioid);


--
-- TOC entry 2110 (class 2606 OID 16536)
-- Name: qef_traducmap_pk; Type: CONSTRAINT; Schema: public; Owner: queesticfent
--

ALTER TABLE ONLY public.qef_traducciomap
    ADD CONSTRAINT qef_traducmap_pk PRIMARY KEY (traducciomapid, idiomaid);


--
-- TOC entry 2112 (class 2606 OID 16538)
-- Name: qef_usuaris_pk; Type: CONSTRAINT; Schema: public; Owner: queesticfent
--

ALTER TABLE ONLY public.qef_usuaris
    ADD CONSTRAINT qef_usuaris_pk PRIMARY KEY (usuariid);


--
-- TOC entry 2115 (class 2606 OID 16540)
-- Name: qef_usuarisdepartament_pk; Type: CONSTRAINT; Schema: public; Owner: queesticfent
--

ALTER TABLE ONLY public.qef_usuarisdepartament
    ADD CONSTRAINT qef_usuarisdepartament_pk PRIMARY KEY (usuaridepartamentid);


--
-- TOC entry 2078 (class 1259 OID 16541)
-- Name: qef_accions_pk_i; Type: INDEX; Schema: public; Owner: queesticfent
--

CREATE INDEX qef_accions_pk_i ON public.qef_accions USING btree (accioid);


--
-- TOC entry 2081 (class 1259 OID 16542)
-- Name: qef_departaments_pk_i; Type: INDEX; Schema: public; Owner: queesticfent
--

CREATE INDEX qef_departaments_pk_i ON public.qef_departaments USING btree (departamentid);


--
-- TOC entry 2082 (class 1259 OID 16543)
-- Name: qef_festiu_pk_i; Type: INDEX; Schema: public; Owner: queesticfent
--

CREATE INDEX qef_festiu_pk_i ON public.qef_festius USING btree (festiuid);


--
-- TOC entry 2087 (class 1259 OID 16544)
-- Name: qef_fitxer_pk_i; Type: INDEX; Schema: public; Owner: queesticfent
--

CREATE INDEX qef_fitxer_pk_i ON public.qef_fitxer USING btree (fitxerid);


--
-- TOC entry 2090 (class 1259 OID 16549)
-- Name: qef_idioma_pk_i; Type: INDEX; Schema: public; Owner: queesticfent
--

CREATE INDEX qef_idioma_pk_i ON public.qef_idioma USING btree (idiomaid);


--
-- TOC entry 2091 (class 1259 OID 16551)
-- Name: qef_modific_accioid_fk_i; Type: INDEX; Schema: public; Owner: queesticfent
--

CREATE INDEX qef_modific_accioid_fk_i ON public.qef_modificacionsqueesticfent USING btree (accioid);


--
-- TOC entry 2094 (class 1259 OID 16552)
-- Name: qef_modific_pk_i; Type: INDEX; Schema: public; Owner: queesticfent
--

CREATE INDEX qef_modific_pk_i ON public.qef_modificacionsqueesticfent USING btree (modificacioid);


--
-- TOC entry 2095 (class 1259 OID 16553)
-- Name: qef_modific_projecteid_fk_i; Type: INDEX; Schema: public; Owner: queesticfent
--

CREATE INDEX qef_modific_projecteid_fk_i ON public.qef_modificacionsqueesticfent USING btree (projecteid);


--
-- TOC entry 2098 (class 1259 OID 16554)
-- Name: qef_personalprojecte_pk_i; Type: INDEX; Schema: public; Owner: queesticfent
--

CREATE INDEX qef_personalprojecte_pk_i ON public.qef_personalprojecte USING btree (personalprojecteid);


--
-- TOC entry 2099 (class 1259 OID 16555)
-- Name: qef_persproj_projecteid_fk_i; Type: INDEX; Schema: public; Owner: queesticfent
--

CREATE INDEX qef_persproj_projecteid_fk_i ON public.qef_personalprojecte USING btree (projecteid);


--
-- TOC entry 2100 (class 1259 OID 16556)
-- Name: qef_projectes_departamen_fk_i; Type: INDEX; Schema: public; Owner: queesticfent
--

CREATE INDEX qef_projectes_departamen_fk_i ON public.qef_projectes USING btree (departamentid);


--
-- TOC entry 2103 (class 1259 OID 16557)
-- Name: qef_projectes_pk_i; Type: INDEX; Schema: public; Owner: queesticfent
--

CREATE INDEX qef_projectes_pk_i ON public.qef_projectes USING btree (projecteid);


--
-- TOC entry 2106 (class 1259 OID 16558)
-- Name: qef_traduccio_pk_i; Type: INDEX; Schema: public; Owner: queesticfent
--

CREATE INDEX qef_traduccio_pk_i ON public.qef_traduccio USING btree (traduccioid);


--
-- TOC entry 2107 (class 1259 OID 16559)
-- Name: qef_traducciomap_idiomaid_fk_i; Type: INDEX; Schema: public; Owner: queesticfent
--

CREATE INDEX qef_traducciomap_idiomaid_fk_i ON public.qef_traducciomap USING btree (idiomaid);


--
-- TOC entry 2108 (class 1259 OID 16560)
-- Name: qef_traducciomap_pk_i; Type: INDEX; Schema: public; Owner: queesticfent
--

CREATE INDEX qef_traducciomap_pk_i ON public.qef_traducciomap USING btree (traducciomapid);


--
-- TOC entry 2113 (class 1259 OID 16561)
-- Name: qef_usuaris_pk_i; Type: INDEX; Schema: public; Owner: queesticfent
--

CREATE INDEX qef_usuaris_pk_i ON public.qef_usuaris USING btree (usuariid);


--
-- TOC entry 2116 (class 1259 OID 16562)
-- Name: qef_usuarisdepartament_pk_i; Type: INDEX; Schema: public; Owner: queesticfent
--

CREATE INDEX qef_usuarisdepartament_pk_i ON public.qef_usuarisdepartament USING btree (usuaridepartamentid);


--
-- TOC entry 2117 (class 1259 OID 16563)
-- Name: qef_usudep_departamentid_fk_i; Type: INDEX; Schema: public; Owner: queesticfent
--

CREATE INDEX qef_usudep_departamentid_fk_i ON public.qef_usuarisdepartament USING btree (departamentid);


--
-- TOC entry 2118 (class 1259 OID 16564)
-- Name: qef_usudep_usuariid_fk_i; Type: INDEX; Schema: public; Owner: queesticfent
--

CREATE INDEX qef_usudep_usuariid_fk_i ON public.qef_usuarisdepartament USING btree (usuariid);


--
-- TOC entry 2119 (class 2606 OID 16575)
-- Name: qef_modific_accions_accioid_fk; Type: FK CONSTRAINT; Schema: public; Owner: queesticfent
--

ALTER TABLE ONLY public.qef_modificacionsqueesticfent
    ADD CONSTRAINT qef_modific_accions_accioid_fk FOREIGN KEY (accioid) REFERENCES public.qef_accions(accioid);


--
-- TOC entry 2120 (class 2606 OID 16580)
-- Name: qef_modific_projectes_proje_fk; Type: FK CONSTRAINT; Schema: public; Owner: queesticfent
--

ALTER TABLE ONLY public.qef_modificacionsqueesticfent
    ADD CONSTRAINT qef_modific_projectes_proje_fk FOREIGN KEY (projecteid) REFERENCES public.qef_projectes(projecteid);


--
-- TOC entry 2121 (class 2606 OID 16585)
-- Name: qef_persproj_projectes_pro_fk; Type: FK CONSTRAINT; Schema: public; Owner: queesticfent
--

ALTER TABLE ONLY public.qef_personalprojecte
    ADD CONSTRAINT qef_persproj_projectes_pro_fk FOREIGN KEY (projecteid) REFERENCES public.qef_projectes(projecteid);


--
-- TOC entry 2122 (class 2606 OID 16590)
-- Name: qef_projectes_departamen_d_fk; Type: FK CONSTRAINT; Schema: public; Owner: queesticfent
--

ALTER TABLE ONLY public.qef_projectes
    ADD CONSTRAINT qef_projectes_departamen_d_fk FOREIGN KEY (departamentid) REFERENCES public.qef_departaments(departamentid);


--
-- TOC entry 2123 (class 2606 OID 16595)
-- Name: qef_traducmap_traduccio_fk; Type: FK CONSTRAINT; Schema: public; Owner: queesticfent
--

ALTER TABLE ONLY public.qef_traducciomap
    ADD CONSTRAINT qef_traducmap_traduccio_fk FOREIGN KEY (traducciomapid) REFERENCES public.qef_traduccio(traduccioid);


--
-- TOC entry 2124 (class 2606 OID 16600)
-- Name: qef_usudep_departamen_depar_fk; Type: FK CONSTRAINT; Schema: public; Owner: queesticfent
--

ALTER TABLE ONLY public.qef_usuarisdepartament
    ADD CONSTRAINT qef_usudep_departamen_depar_fk FOREIGN KEY (departamentid) REFERENCES public.qef_departaments(departamentid);


--
-- TOC entry 2125 (class 2606 OID 16605)
-- Name: qef_usudep_usuaris_usuari_fk; Type: FK CONSTRAINT; Schema: public; Owner: queesticfent
--

ALTER TABLE ONLY public.qef_usuarisdepartament
    ADD CONSTRAINT qef_usudep_usuaris_usuari_fk FOREIGN KEY (usuariid) REFERENCES public.qef_usuaris(usuariid);


--
-- TOC entry 2247 (class 0 OID 0)
-- Dependencies: 7
-- Name: SCHEMA public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2025-02-18 12:48:07 UTC

--
-- PostgreSQL database dump complete
--

