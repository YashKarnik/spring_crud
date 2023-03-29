-- Users Table
CREATE TABLE public.users (
	id serial4 NOT NULL,
	username varchar(64) NOT NULL,
	user_password varchar(256) NOT NULL,
	CONSTRAINT users_pkey PRIMARY KEY (id),
	CONSTRAINT users_username_key UNIQUE (username)
);


