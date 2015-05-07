drop table if exists Course;

drop table if exists country;

drop table if exists education_info;

drop table if exists faculty;

drop table if exists groupe;

drop table if exists hostel;

drop table if exists personal_info;

drop table if exists speciality;

drop table if exists student;

drop table if exists user;

/*==============================================================*/
/* Table: Course                                                */
/*==============================================================*/
create table Course
(
   course_id            int not null,
   course_name          char(20),
   primary key (course_id)
);

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
/* Table: education_info                                        */
/*==============================================================*/
create table education_info
(
   education_info_id    int not null,
   incoming_date        date,
   graduated_date       date,
   dismis_date          date,
   order_number         char(10),
   study_form           char(60),
   study_type           char(60),
   reason_dismis        char(60),
   income_type          char(60),
   inviting_part        char(60),
   invite_date          date,
   incoming_rb_date     date,
   primary key (education_info_id)
);

/*==============================================================*/
/* Table: faculty                                               */
/*==============================================================*/
create table faculty
(
   faculty_id           int not null,
   faculty_name         char(60),
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
/* Table: personal_info                                         */
/*==============================================================*/
create table personal_info
(
   personal_info_id     int not null,
   birth_date           date,
   birth_place          char(255),
   pasport_number       char(60),
   pasport_validity     date,
   gender               char(10),
   visa_number          char(60),
   visa_end_date        date,
   insurance_number     char(60),
   insurance_end_date   date,
   primary key (personal_info_id)
);

/*==============================================================*/
/* Table: speciality                                            */
/*==============================================================*/
create table speciality
(
   speciality_id        int not null,
   faculty_id           int,
   speciality_name      char(60),
   primary key (speciality_id)
);

/*==============================================================*/
/* Table: student                                               */
/*==============================================================*/
create table student
(
   student_id           int not null,
   group_id             int,
   country_id           int,
   personal_info_id     int not null,
   education_info_id    int not null,
   hostel_id            int,
   course               char(10),
   first_name           char(60),
   last_name            char(60),
   middle_name          char(60),
   fio_latin            char(255),
   registration_address char(255),
   registration_end_date date,
   graduated            char(60),
   receipt_date         date,
   vacation             char(10),
   vacation_start_date  date,
   vacation_end_date    date,
   line                 char(60),
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
      references Course (course_id) on delete restrict on update restrict;

alter table groupe add constraint FK_group_speciality foreign key (speciality_id)
      references speciality (speciality_id) on delete restrict on update restrict;

alter table speciality add constraint FK_speciality_faculty foreign key (faculty_id)
      references faculty (faculty_id) on delete restrict on update restrict;

alter table student add constraint FK_student_counrty foreign key (country_id)
      references country (country_id) on delete restrict on update restrict;

alter table student add constraint FK_student_education_info foreign key (education_info_id)
      references education_info (education_info_id) on delete restrict on update restrict;

alter table student add constraint FK_student_group foreign key (group_id)
      references groupe (group_id) on delete restrict on update restrict;

alter table student add constraint FK_student_hostel foreign key (hostel_id)
      references hostel (hostel_id) on delete restrict on update restrict;

alter table student add constraint FK_student_personal_info foreign key (personal_info_id)
      references personal_info (personal_info_id) on delete restrict on update restrict;
