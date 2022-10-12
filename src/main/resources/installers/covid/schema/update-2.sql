--covid_vaccination
CREATE SEQUENCE covid_vaccination_id_seq;
CREATE TABLE public.covid_vaccination
(
    id bigint NOT NULL DEFAULT nextval('covid_vaccination_id_seq'),
    uuid character varying(100),
    patient_int bigint,
    patient_uuid bigint,
    facility_id int,
    facility_uuid character varying(100),
    visit_id bigint,
    visit_date timestamp,
    work_in_health_sector int,
    occupation integer,
    known_medical_condition integer,
    medical_condition integer,
    accept_vaccination integer,
    vaccine_id character varying(100),
    create_date timestamp,
    created_by int,
    update_date timestamp,
    updated_by int,
    PRIMARY KEY (id)
);
ALTER SEQUENCE covid_vaccination_id_seq OWNED BY covid_vaccination.id;


--covid_vaccination_dose
CREATE SEQUENCE covid_vaccination_dose_id_seq;
CREATE TABLE public.covid_vaccination_dose
(
    id bigint NOT NULL DEFAULT nextval('covid_vaccination_dose_id_seq'),
    uuid character varying(100),
    dose_number integer,
    vaccine integer,
    vaccine_date timestamp,
    location integer,
    vaccination_facility character varying(100),
    batch_no character varying(100),
    adverse_effect character varying(500),
    create_date timestamp,
    created_by int,
    update_date timestamp,
    updated_by int,
    vaccination_id bigint,
    PRIMARY KEY (id)
);
ALTER SEQUENCE covid_vaccination_dose_id_seq OWNED BY covid_vaccination_dose.id;


CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

insert into covid_codeset(uuid, name, category)values(uuid_generate_v4(), 'Positive', 'HIV STATUS');
insert into covid_codeset(uuid, name, category)values(uuid_generate_v4(), 'Negative', 'HIV STATUS');
insert into covid_codeset(uuid, name, category)values(uuid_generate_v4(), 'Unknown', 'HIV STATUS');

insert into covid_codeset(uuid, name, category)values(uuid_generate_v4(), 'Other Staff', 'OCCUPATION');

insert into covid_codeset(uuid, name, category)values(uuid_generate_v4(), 'Kidney Disease', 'MEDICAL CONDITION');

insert into covid_codeset(uuid, name, category)values(uuid_generate_v4(), 'AstraZeneca', 'VACCINE');

insert into covid_codeset(uuid, name, category)values(uuid_generate_v4(), 'Facility', 'LOCATION');