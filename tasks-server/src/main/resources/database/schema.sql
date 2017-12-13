CREATE TABLE users
(
  id bigserial NOT NULL,
  user_id character varying NOT NULL,
  given_name character varying,
  family_name character varying,
  email_id character varying,
  password character varying,
  active boolean,
  created_time timestamp without time zone,
  modified_time timestamp without time zone,
  CONSTRAINT users_pk PRIMARY KEY (id)
);

CREATE TABLE tasklists
(
  id bigserial NOT NULL,
  list_id character varying NOT NULL,
  title character varying,
  parent character varying,
  color character varying,
  type character varying,
  user_ref_id bigserial NOT NULL,
  trashed boolean,
  created_time timestamp without time zone,
  modified_time timestamp without time zone,
  trashed_time timestamp without time zone,
  CONSTRAINT tasklists_pk PRIMARY KEY (id),
  CONSTRAINT tasklists_users_fk FOREIGN KEY (user_ref_id)
    REFERENCES users (id) MATCH SIMPLE
    ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE tasks
(
  id bigserial NOT NULL,
  title character varying,
  tasklist_ref_id bigserial NOT NULL,
  type character varying,
  "position" character varying,
  status character varying,
  priority character varying,
  hidden boolean,
  completed_time timestamp without time zone,
  created_time timestamp without time zone,
  modified_time timestamp without time zone,
  CONSTRAINT task_pk PRIMARY KEY (id),
  CONSTRAINT tasks_tasklists_fk FOREIGN KEY (tasklist_ref_id)
    REFERENCES tasklists (id) MATCH SIMPLE
    ON UPDATE NO ACTION ON DELETE NO ACTION
);