CREATE DATABASE `db_international_students` /*!40100 DEFAULT CHARACTER SET utf8 */;

CREATE TABLE `faculty` (
  `faculty_id` int(11) NOT NULL AUTO_INCREMENT,
  `faculty_name` varchar(30) NOT NULL,
  PRIMARY KEY (`faculty_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

CREATE TABLE `speciality` (
  `speciality_id` int(11) NOT NULL AUTO_INCREMENT,
  `speciality_name` varchar(60) NOT NULL,
  `faculty_id` int(11) NOT NULL,
  PRIMARY KEY (`speciality_id`),
  KEY `speciality_faculty_fk` (`faculty_id`),
  CONSTRAINT `speciality_faculty_fk` FOREIGN KEY (`faculty_id`) REFERENCES `faculty` (`faculty_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

CREATE TABLE `group` (
  `group_id` int(11) NOT NULL AUTO_INCREMENT,
  `group_name` varchar(30) NOT NULL,
  `speciality_id` int(11) NOT NULL,
  PRIMARY KEY (`group_id`),
  KEY `group_fk1_idx` (`speciality_id`),
  CONSTRAINT `group_speciality_fk` FOREIGN KEY (`speciality_id`) REFERENCES `speciality` (`speciality_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `country` (
  `country_id` int(11) NOT NULL AUTO_INCREMENT,
  `country_name` varchar(45) NOT NULL,
  PRIMARY KEY (`country_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `course` (
  `course_id` int(11) NOT NULL AUTO_INCREMENT,
  `course_name` varchar(45) NOT NULL,
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `student` (
  `student_id` int(11) NOT NULL AUTO_INCREMENT,
  `group_id` int(11) NOT NULL,
  `country_id` int(11) NOT NULL,
  `course_id` int(11) NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `midle_name` varchar(45) NOT NULL,
  `fio_latin` varchar(45) NOT NULL,
  `study_form` varchar(45) NOT NULL,
  `registration_address` varchar(45) NOT NULL,
  `registration_deadline` date NOT NULL,
  `order_number` int(11) NOT NULL,
  `birth_date` date NOT NULL,
  `birth_place` varchar(45) NOT NULL,
  `passport number` varchar(10) NOT NULL,
  `passport_validity` date NOT NULL,
  `graduated` varchar(45) NOT NULL,
  PRIMARY KEY (`student_id`),
  KEY `student_fk1_idx` (`group_id`),
  KEY `student_country_fk_idx` (`country_id`),
  KEY `student_course_fk_idx` (`course_id`),
  CONSTRAINT `student_country_fk` FOREIGN KEY (`country_id`) REFERENCES `country` (`country_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `student_group_fk` FOREIGN KEY (`group_id`) REFERENCES `groups` (`group_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `studetn_course_fk` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `student_add_info` (
  `student_add_info_id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) NOT NULL,
  PRIMARY KEY (`student_add_info_id`),
  KEY `student_add_info_student_fk_idx` (`student_id`),
  CONSTRAINT `student_add_info_student_fk` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
