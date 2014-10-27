create sequence USER_ID_SEQ;

create table USERS(
  id integer not null default nextval('user_id_seq'),
  primary key(id),
  name text,
  login text,
  email text,
  passwd text
);

create sequence MESSAGE_ID_SEQ;

create table if not exists MESSAGES(
  id integer not null default nextval('message_id_seq'),
  primary key(id),
  text_message text,
  author text,
  time_created bigint
);

