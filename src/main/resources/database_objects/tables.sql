CREATE TABLE public.user_details (
	userid serial4 primary key,
	email varchar(64) unique,
	username varchar(64),
	"password" varchar(64)
);

create table blog (
blogid serial4 primary key,
userid serial4 not null,
title varchar(250),
"content" varchar(10000),
created_at timestamp DEFAULT current_timestamp
)

create table blog_likes (
likeid serial4 primary key,
blogid serial4,
likedBy serial4,
created_at timestamp DEFAULT current_timestamp
)


create table blog_comments (
commentid serial4 primary key,
blogid serial4,
userid serial4,
content varchar(500),
created_at timestamp DEFAULT current_timestamp
)

