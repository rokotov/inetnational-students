delete from `student` where student_id>0;
delete from `hostel` where hostel_id>0;
delete from `groupe` where group_id>0;
delete from `course` where course_id>0;
delete from `speciality` where speciality_id>0;
delete from `faculty` where faculty_id>0;
delete from `country` where country_id>0;
delete from `user` where user_id>0;

/*******************************
		Страны
*******************************/
INSERT INTO `interstudents`.`country`
(`country_id`,
`country_name`,
`is_bad`)
VALUES
(1, 'Азербайджан', false),
(2, 'Россия', false),
(3, 'Грузия', false),
(4, 'Туркменистан', true),
(5, 'Нигерия', true),
(6, 'Венгрия', true),
(7, 'Украина', true),
(8, 'Польша', true),
(9, 'Китай', true),
(10, 'Турция', true);



/*******************************
		Курсы
*******************************/
INSERT INTO `interstudents`.`course`
(`course_id`,
`course_name`)
VALUES
(1, '0'),
(2, '1'),
(3, '2'),
(4, '3'),
(5, '4'),
(6, '5'),
(7, 'I'),
(8, 'II'),
(9, 'III'),
(10, 'A'),
(11, 'ПО');

/*******************************
		Общежития
*******************************/
INSERT INTO `interstudents`.`hostel`
(`hostel_id`,
`hostel_name`,
`address`)
VALUES
(1, 'общежитие №1', 'г. Могилев ул. Ленинская, 39'),
(2, 'общежитие №2', 'г. Могилев ул. Ленинская, 33'),
(3, 'общежитие №3', 'г. Могилев ул. Космонавтов, 21'),
(4, 'общежитие №4', 'г. Могилев ул. Комсомольская, 14'),
(5, 'общежитие №5', 'г. Могилев ул. К. Маркса, 2');

/*******************************
		Пользователи
*******************************/
INSERT INTO `interstudents`.`user`
(`user_id`,
`login`,
`password`,
`role`)
VALUES
(1,'admin','3b8193d9eb38699c660997a92fcc8a4e1c9a5c86a6171fc62b672e2e870f028b1e6c0066959ece6d','admin'),
(2,'user','5b2fbb19eb37842fa212d90a61195643df47598bdcc56033313389cabaa40c8f7f3014ff9a883faa','user');


