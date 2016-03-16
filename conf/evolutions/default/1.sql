
# --- !Ups
create table "characters" ("character_id" INTEGER NOT NULL PRIMARY KEY,"name" CHAR(32) NOT NULL,"feature" VARCHAR NOT NULL);
create table "companies" ("company_id" INTEGER NOT NULL,"name" VARCHAR NOT NULL);
create table "users" ("user_id" INTEGER DEFAULT null,"name" VARCHAR NOT NULL,"company_id" INTEGER NOT NULL);

# --- !Downs
drop table "characters";
drop table "companies";
drop table "users";