drop table if exists country;

drop table if exists course;

drop table if exists faculty;

drop table if exists groupe;

drop table if exists hostel;

drop table if exists speciality;

drop table if exists student;

drop table if exists user;

/*==============================================================*/
/* Table: country                                               */
/*==============================================================*/
create table country
(
   country_id           int not null,
   country_name         char(60),
   is_bad               bool,
   primary key (country_id)
);

/*==============================================================*/
/* Table: course                                                */
/*==============================================================*/
create table course
(
   course_id            int not null,
   course_name          char(20),
   primary key (course_id)
);

/*==============================================================*/
/* Table: faculty                                               */
/*==============================================================*/
create table faculty
(
   faculty_id           int not null,
   faculty_name         char(255),
   primary key (faculty_id)
);

/*==============================================================*/
/* Table: groupe                                                */
/*==============================================================*/
create table groupe
(
   group_id             int not null,
   speciality_id        int,
   course_id            int,
   group_name           char(60),
   primary key (group_id)
);

/*==============================================================*/
/* Table: hostel                                                */
/*==============================================================*/
create table hostel
(
   hostel_id            int not null,
   hostel_name          char(60),
   address              char(255),
   primary key (hostel_id)
);

/*==============================================================*/
/* Table: speciality                                            */
/*==============================================================*/
create table speciality
(
   speciality_id        int not null,
   faculty_id           int,
   speciality_name      char(255),
   primary key (speciality_id)
);

/*==============================================================*/
/* Table: student                                               */
/*==============================================================*/
create table student
(
   fio_latin            char(255),
   student_id           int not null,
   group_id             int,
   country_id           int,
   hostel_id            int,
   first_name           char(100),
   last_name            char(100),
   middle_name          char(100),
   registration_address char(255),
   registration_end_date date,
   graduated            char(255),
   receipt_date         date,
   vacation             char(255),
   vacation_start_date  date,
   vacation_end_date    date,
   line                 char(255),
   birth_date           date,
   birth_place          char(255),
   pasport_number       char(60),
   pasport_validity     date,
   gender               char(10),
   visa_number          char(60),
   visa_end_date        date,
   insurance_number     char(60),
   insurance_end_date   date,
   incoming_date        date,
   graduated_date       date,
   dismis_date          date,
   order_number         char(60),
   order_date           date,
   study_form           char(60),
   study_type           char(60),
   reason_dismis        char(255),
   income_type          char(60),
   inviting_part        char(60),
   invite_date          date,
   recovery             char(60),
   incoming_rb_date     date,
   note                 text,
   primary key (student_id)
);

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   user_id              int not null,
   login                char(255),
   password             char(255),
   role                 char(10),
   primary key (user_id)
);

alter table groupe add constraint FK_group_course foreign key (course_id)
      references course (course_id) on delete restrict on update restrict;

alter table groupe add constraint FK_group_speciality foreign key (speciality_id)
      references speciality (speciality_id) on delete restrict on update restrict;

alter table speciality add constraint FK_speciality_faculty foreign key (faculty_id)
      references faculty (faculty_id) on delete restrict on update restrict;

alter table student add constraint FK_student_counrty foreign key (country_id)
      references country (country_id) on delete restrict on update restrict;

alter table student add constraint FK_student_group foreign key (group_id)
      references groupe (group_id) on delete restrict on update restrict;

alter table student add constraint FK_student_hostel foreign key (hostel_id)
      references hostel (hostel_id) on delete restrict on update restrict;
