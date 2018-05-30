-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Хост: localhost
-- Время создания: Май 30 2018 г., 05:50
-- Версия сервера: 5.7.21-log
-- Версия PHP: 7.1.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `selection_committee_db`
--

-- --------------------------------------------------------

--
-- Структура таблицы `city`
--

CREATE TABLE `city` (
  `id` int(10) UNSIGNED NOT NULL COMMENT 'Идентификатор',
  `name` varchar(45) NOT NULL COMMENT 'Наименование',
  `country_id` int(10) UNSIGNED NOT NULL COMMENT 'Идентификатор страны, которой принадлежит город.'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Город';

--
-- Дамп данных таблицы `city`
--

INSERT INTO `city` (`id`, `name`, `country_id`) VALUES
(13, 'qwerty', 1),
(7, 'Брест', 1),
(8, 'Витебск', 1),
(5, 'Гомель', 1),
(10, 'Горки', 1),
(6, 'Гродно', 1),
(3, 'Киев', 3),
(14, 'Кличев', 1),
(9, 'Кричев', 1),
(1, 'Минск', 1),
(4, 'Могилёв', 1),
(2, 'Москва', 2);

-- --------------------------------------------------------

--
-- Структура таблицы `country`
--

CREATE TABLE `country` (
  `id` int(10) UNSIGNED NOT NULL COMMENT 'Идентификатор.',
  `name` varchar(45) NOT NULL COMMENT 'Наименование страны.'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Страна';

--
-- Дамп данных таблицы `country`
--

INSERT INTO `country` (`id`, `name`) VALUES
(1, 'Беларусь'),
(4, 'Китай'),
(2, 'Россия'),
(3, 'Украина');

-- --------------------------------------------------------

--
-- Структура таблицы `enrollee`
--

CREATE TABLE `enrollee` (
  `id` int(10) UNSIGNED NOT NULL COMMENT 'Идентификатор',
  `name` varchar(45) NOT NULL COMMENT 'Имя абитуриента',
  `surname` varchar(45) NOT NULL COMMENT 'Фамилия абитуриента.',
  `patronymic` varchar(45) DEFAULT NULL COMMENT 'Отчество абитуриента. (может быть null т.к абитуриент может быть из другой страны, где нет отчества)',
  `phone_number` char(13) NOT NULL COMMENT 'Номер телефона\nФормат: +375XX0000000',
  `faculty_id` int(10) UNSIGNED NOT NULL COMMENT 'Факультет, на который абитуриент подаёт документы.',
  `status_id` int(10) UNSIGNED NOT NULL COMMENT 'Статус абитуриента.',
  `user_id` int(10) UNSIGNED NOT NULL COMMENT 'Идентификатор пользователя, т.е аккаунт, к которому привязан абитуриент в системе.',
  `city_id` int(10) UNSIGNED NOT NULL COMMENT 'Город из которого приехал абитуриент.',
  `number_passport` varchar(45) NOT NULL COMMENT 'Номер паспорта',
  `average_certificate_score` tinyint(4) DEFAULT NULL COMMENT 'Средний балл аттеста.',
  `score_on_ct` smallint(6) DEFAULT NULL COMMENT 'Количество баллов, набранных абитуриентом на ЦТ по 3-ём предметам.',
  `info_message` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Абитуриент';

--
-- Дамп данных таблицы `enrollee`
--

INSERT INTO `enrollee` (`id`, `name`, `surname`, `patronymic`, `phone_number`, `faculty_id`, `status_id`, `user_id`, `city_id`, `number_passport`, `average_certificate_score`, `score_on_ct`, `info_message`) VALUES
(1, 'Сергей', 'Кудрявцев', 'Александрович', '+375297777777', 1, 2, 2, 10, 'KB1765705', 82, 264, NULL),
(2, 'Максим', 'Лебедев', 'Дмитриевич', '+375297575644', 1, 2, 3, 1, 'KB1765712', 75, 241, NULL),
(3, 'Екатерина', 'Васильева', 'Владимировна', '+375297575655', 2, 7, 4, 1, 'KB1985675', 54, 162, ''),
(4, 'Татьяна', 'Сидорова', 'Николаевна', '+275334455666', 5, 2, 5, 2, 'KB1765478', 100, 300, NULL),
(5, 'Надежда', 'Филипова', 'Васильевна', '+375297777779', 1, 2, 6, 3, 'KB1754789', 84, 278, NULL),
(6, 'Пётр', 'Стародубов', 'Николаевич', '+375296677888', 1, 2, 7, 4, 'KB3254785', 86, 291, NULL),
(7, 'Лилия', 'Лукашевич', 'Владимировна', '+375297575778', 2, 6, 8, 1, 'KB1764525', 89, 257, ''),
(8, 'Василий', 'Тихонов', 'Петрович', '+375296677899', 1, 7, 9, 7, 'KB1762145', 91, 200, 'Не хочу принимать'),
(9, 'Виктор', 'Новиков', 'Максимович', '+375297575688', 3, 6, 10, 2, 'KB1765425', 93, 285, NULL),
(10, 'Владимир', 'Тарасенко', 'Владиславович', '+375296677999', 2, 2, 11, 7, 'KB1712456', 96, 258, NULL),
(11, 'Алина', 'Поршнёва', 'Сергеевна', '+375297575333', 3, 2, 12, 6, 'KB1512456', 89, 257, NULL),
(12, 'Василий', 'Иванов', 'Александрович', '+375297575688', 1, 2, 13, 2, 'KB1763278', 97, 296, NULL),
(13, 'Екатерина', 'Петрова', 'Алексондровна', '+375449898777', 1, 2, 2, 1, 'KN1987564', 99, 260, NULL);

-- --------------------------------------------------------

--
-- Структура таблицы `enrollee_has_privilege`
--

CREATE TABLE `enrollee_has_privilege` (
  `enrollee_id` int(10) UNSIGNED NOT NULL COMMENT 'Идентификатор абитуриента.',
  `privilege_id` int(10) UNSIGNED NOT NULL COMMENT 'Идентификатор льготы.'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Таблица, получаемая из-за связи многи- ко-многим. Т.е. конкретная льгота у конкретного абитуриента.';

--
-- Дамп данных таблицы `enrollee_has_privilege`
--

INSERT INTO `enrollee_has_privilege` (`enrollee_id`, `privilege_id`) VALUES
(3, 1),
(8, 2),
(3, 3),
(1, 5),
(8, 5);

-- --------------------------------------------------------

--
-- Структура таблицы `enrollee_has_subject`
--

CREATE TABLE `enrollee_has_subject` (
  `enrollee_id` int(10) UNSIGNED NOT NULL COMMENT 'id Абитуриента',
  `subject_id` int(10) UNSIGNED NOT NULL COMMENT 'id Предмета'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Таблица, получаемая из-за связи многие- ко-многим. Т.е. конкретный предмет, который абитуриент сдавал на ЦТ,';

--
-- Дамп данных таблицы `enrollee_has_subject`
--

INSERT INTO `enrollee_has_subject` (`enrollee_id`, `subject_id`) VALUES
(1, 1),
(2, 1),
(3, 1),
(4, 1),
(5, 1),
(6, 1),
(7, 1),
(8, 1),
(9, 1),
(10, 1),
(11, 1),
(12, 1),
(2, 4),
(3, 4),
(4, 4),
(6, 4),
(9, 4),
(11, 4),
(12, 4),
(1, 5),
(5, 5),
(7, 5),
(8, 5),
(10, 5),
(1, 6),
(2, 6),
(3, 6),
(4, 6),
(5, 6),
(6, 6),
(7, 6),
(8, 6),
(9, 6),
(10, 6),
(11, 6),
(12, 6);

-- --------------------------------------------------------

--
-- Структура таблицы `faculty`
--

CREATE TABLE `faculty` (
  `id` int(10) UNSIGNED NOT NULL COMMENT 'Идентификатор.',
  `name` varchar(45) NOT NULL COMMENT 'Наименование факультета.',
  `budjet_count` smallint(6) NOT NULL COMMENT 'Количество бюджетных мест.',
  `total_count` smallint(6) NOT NULL COMMENT 'Общее количество мест. (т.е план набора: количество платных + бюджетных мест)',
  `passing_score_budjet` smallint(6) DEFAULT '100' COMMENT 'Проходной балл на бюджет. ',
  `passing_score_paid` smallint(6) DEFAULT '70' COMMENT 'Проходной балл на платное.',
  `image_path` varchar(255) DEFAULT 'images\\faculty\\default.png',
  `description` text,
  `finish_date` date NOT NULL COMMENT 'Дата окончания приёма документов',
  `is_finish` tinyint(1) NOT NULL DEFAULT '0' COMMENT 'Произведен ли расчёт после окончания приёмной комиссии'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Факультет, на который абитуриент подаёт документы.';

--
-- Дамп данных таблицы `faculty`
--

INSERT INTO `faculty` (`id`, `name`, `budjet_count`, `total_count`, `passing_score_budjet`, `passing_score_paid`, `image_path`, `description`, `finish_date`, `is_finish`) VALUES
(1, 'ФКСиС', 200, 500, 0, 0, 'images\\faculty\\1.png', 'Факультет компьютерных систем и сетей является одним из ведущих факультетов в Республике Беларусь по подготовке ИТ-специалистов. \r\n\r\nНа сегодняшний день на факультете обучаются более 1800 студентов по трем специальностям - \"Вычислительные машины, системы и сети\", \"Информатика\", \"Информатика и технологии программирования\", \"Программное обеспечение информационных технологий\". ', '2018-05-13', 0),
(2, 'ФИТУ', 150, 300, 0, 0, 'images\\faculty\\2.png', 'Факультет является ровесником университета. Сегодня - это крупный учебный и научный центр, в котором обучается более 1700 студентов, есть свои научные школы, функционирует магистратура, аспирантура и докторантура. Обучение ведется по четырем перспективным специальностям: \"Автоматизированные системы обработки информации\", \"Искусственный интеллект\", \"Информационные технологии и управление в технических системах\", \"Промышленная электроника\". \r\nНа ФИТУ готовят специалистов широкого профиля по IТ-технологиям, которые без труда займут достойное место на рынке труда. ', '2018-05-14', 0),
(3, 'ФКП', 100, 200, 0, 0, 'images\\faculty\\3.png', 'Основной образовательной деятельностью Факультета компьютерного проектирования (бывший конструкторско-технологический факультет) вот уже более 40 лет является подготовка по специальностям инженерного профиля, а также по востребованным, престижным и перспективным специальностям IT-области, с учетом мировых тенденций развития науки, техники и технологий. \r\n\r\nНаличие таких специалистов необходимо для деятельности различных компаний и предприятий электронной промышленности, способствует более эффективной работе субъектов малого и среднего бизнеса, а также обеспечивает высокий уровень конкуренто-способности национальной экономики страны на внутренних и внешних рынках. \r\n\r\nОбучение студентов ведется с использованием самого современного оборудования и программного обеспечения на базе созданных на факультете Международных, учебных и научно-производственных центров и лабораторий, а также на базе филиалов кафедр факультета на ведущих предприятиях Республики Беларусь. ', '2018-05-12', 0),
(4, 'ФРЭ', 130, 280, 0, 0, 'images/faculty/fre.jpg', 'Имеет богатую историю, был образован в 1964 г., когда создавался Минский радиотехнический институт. \r\n\r\nСовременная радиоинформационная система предназначена для извлечения, формирования, приема, передачи и обработки информации. Для решения названных задач необходимы специалисты, всесторонне подготовленные для работы с современными микро - и наноэлектронными устройствами, способные применить свои знания и талант для создания принципиально новых поколений информационных систем.', '2018-05-11', 1),
(5, 'ФТК', 100, 230, 0, 0, 'images/faculty/ftk.jpg', '\r\nИстория факультета берет начало в 1980 году, когда в структуре Минского радиотехнического института появился факультет электросвязи. Современное название факультет получил в результате своего преобразования в 2017 году, которое связано с формированием к настоящему времени новой отрасли - отрасли инфокоммуникаций. \r\n\r\nФакультет инфокоммуникаций обеспечивает современное образование для тех, кого влечет электроника и информатика, кто желает освоить инновационные электронные и информационные технологии в телекоммуникациях, кто стремиться быть востребованным в современных социальных и экономических условиях. \r\n\r\nСтуденты факультета получают глубокие знания в области информационно-коммуникационных технологий, имеют навыки разработки и внедрения новых технологий в инфокоммуникациях. Это делает наших выпускников конкурентоспособными в современных рыночных условиях и позволяет быстрее адаптироваться к решению приоритетных научно-технических задач, стоящих перед отраслью инфокоммуникаций. ', '2018-05-15', 0),
(6, 'ИЭФ', 100, 200, 0, 0, 'images/faculty/ief.jpg', 'Был открыт в 1994 г, (а в 2004 переименован в инженерно-экономический факультет). \r\n\r\nИнженерно-экономический факультет готовит специалистов, обладающих интегрированными знаниями в области экономики и современных информационных технологий, что выгодно отличает подготовленных на нашем факультете специалистов от выпускников экономических факультетов других учреждений образования Республики Беларусь. ', '2018-05-10', 1),
(7, 'Test', 12, 0, 100, 70, 'images\\faculty\\7.png', 'Test', '2018-04-01', 0),
(8, 'Test', 12, 0, 100, 70, 'images\\faculty\\8.png', 'Test', '2017-12-31', 0),
(9, 'Test1', 12, 0, 100, 70, 'images\\faculty\\default.png', 'Test', '2018-12-11', 0),
(10, 'Test2', 12, 27, 100, 70, 'images\\faculty\\default.png', 'Test', '2018-02-11', 0);

-- --------------------------------------------------------

--
-- Структура таблицы `faculty_has_subject`
--

CREATE TABLE `faculty_has_subject` (
  `faculty_id` int(10) UNSIGNED NOT NULL COMMENT 'Идентификатор факультета.',
  `subject_id` int(10) UNSIGNED NOT NULL COMMENT 'Идентификатор пользователя.'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Таблица, получаемая из-за связи многи- ко-многим. Т.е. конкретный предмет, который нужно сдавать, чтобы поступать на конкретный факультет.';

--
-- Дамп данных таблицы `faculty_has_subject`
--

INSERT INTO `faculty_has_subject` (`faculty_id`, `subject_id`) VALUES
(1, 1),
(2, 1),
(3, 1),
(4, 1),
(5, 1),
(6, 1),
(7, 1),
(9, 1),
(10, 1),
(1, 4),
(2, 4),
(3, 4),
(4, 4),
(5, 4),
(6, 4),
(9, 4),
(10, 4),
(1, 5),
(2, 5),
(3, 5),
(4, 5),
(5, 5),
(6, 5),
(10, 5),
(1, 6),
(2, 6),
(3, 6),
(4, 6),
(5, 6),
(9, 6),
(6, 11);

-- --------------------------------------------------------

--
-- Структура таблицы `privilege`
--

CREATE TABLE `privilege` (
  `id` int(10) UNSIGNED NOT NULL,
  `name` varchar(45) NOT NULL COMMENT 'Наименование льготы.'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Льготы, которыми обладает абитуриент (медаль, чернобыльский билет, потеря кормильца и т.д))';

--
-- Дамп данных таблицы `privilege`
--

INSERT INTO `privilege` (`id`, `name`) VALUES
(1, 'Чернобыльский билет'),
(2, 'Многодетная семья'),
(3, 'Неполная семья'),
(4, 'Золотая медаль'),
(5, 'Победитель республиканской олимпиады');

-- --------------------------------------------------------

--
-- Структура таблицы `status`
--

CREATE TABLE `status` (
  `id` int(10) UNSIGNED NOT NULL COMMENT 'Идентификатор.',
  `name` varchar(45) DEFAULT 'Зарегистрирован' COMMENT 'Наименование статуса.'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Статус абитуриента. (подал документы, принят на бюджет\\платное, не зачислен и т.д)';

--
-- Дамп данных таблицы `status`
--

INSERT INTO `status` (`id`, `name`) VALUES
(1, 'Зарегистрирован'),
(2, 'Бюджет'),
(3, 'Платное'),
(4, 'Приняты документы'),
(5, 'Не зачислен'),
(6, 'Поданы документы'),
(7, 'Документы отклонены');

-- --------------------------------------------------------

--
-- Структура таблицы `subject`
--

CREATE TABLE `subject` (
  `id` int(10) UNSIGNED NOT NULL,
  `name` varchar(45) NOT NULL COMMENT 'Наименование предмета.',
  `group_number` tinyint(4) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Предмет. Просто наименование предмета, по которому можно сдавать ЦТ. Нужна для того чтобы не хранить в таблице ct_subject имени предмета, т.к бы это занимало больше памяти.';

--
-- Дамп данных таблицы `subject`
--

INSERT INTO `subject` (`id`, `name`, `group_number`) VALUES
(1, 'Математика', 3),
(2, 'Химия', 4),
(3, 'Биология', 5),
(4, 'Русский язык', 1),
(5, 'Белорусский язык', 1),
(6, 'Физика', 6),
(7, 'Обществоведение', 7),
(8, 'История Беларуси', 8),
(9, 'География', 9),
(10, 'Всемирная история', 10),
(11, 'Английский язык', 2),
(12, 'Немецкий язык', 2),
(13, 'Французский язык', 2),
(14, 'Испанский язык', 2),
(15, 'Китайский язык', 2);

-- --------------------------------------------------------

--
-- Структура таблицы `user`
--

CREATE TABLE `user` (
  `id` int(10) UNSIGNED NOT NULL COMMENT 'Идентификатор',
  `login` varchar(45) NOT NULL COMMENT 'Логин пользователя',
  `hash_password` varchar(45) NOT NULL COMMENT 'Хеш пароля  пользователя.',
  `role` enum('admin','user') NOT NULL COMMENT 'Роль пользователя в системе. (админ\\пользователь)',
  `email` varchar(45) NOT NULL COMMENT 'Почта пользователя.',
  `is_blocked` tinyint(1) NOT NULL DEFAULT '0',
  `image_path` varchar(45) DEFAULT 'images/user/default.png'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Пользователь, зарегистрированный в системе.';

--
-- Дамп данных таблицы `user`
--

INSERT INTO `user` (`id`, `login`, `hash_password`, `role`, `email`, `is_blocked`, `image_path`) VALUES
(1, 'Olya', '1c73be17bbd9e027c6e6bdb9c9f47d87', 'admin', 'sichnenkoolga@gmail.com', 0, 'images\\user\\1.png'),
(2, 'Sergey', '81dc9bdb52d04dc20036dbd8313ed055', 'admin', 'sergey@gmail.com', 0, 'images\\user\\default.png	'),
(3, 'Maxim', '81dc9bdb52d04dc20036dbd8313ed055', 'admin', 'maxim@gmail.com', 1, 'images/user/default.png	'),
(4, 'Katya', '81dc9bdb52d04dc20036dbd8313ed055', 'user', 'katya@gmail.com', 0, 'images\\user\\4.png'),
(5, 'Tanya', '81dc9bdb52d04dc20036dbd8313ed055', 'user', 'tanya@gmail.com', 0, 'images/user/default.png	'),
(6, 'Nadya', '81dc9bdb52d04dc20036dbd8313ed055', 'admin', 'nadya@gmail.com', 0, 'images/user/default.png	'),
(7, 'Petya', '81dc9bdb52d04dc20036dbd8313ed055', 'user', 'petya@gmail.com', 0, 'images/user/default.png	'),
(8, 'Lilia', '81dc9bdb52d04dc20036dbd8313ed055', 'admin', 'lilia@gmail.com', 0, 'images/user/default.png	'),
(9, 'vasya', '81dc9bdb52d04dc20036dbd8313ed055', 'user', 'vasya@gmail.com', 0, 'images/user/default.png	'),
(10, 'vitya', '81dc9bdb52d04dc20036dbd8313ed055', 'user', 'vitya@yandex.ru', 0, 'images/user/default.png	'),
(11, 'Vova', '81dc9bdb52d04dc20036dbd8313ed055', 'user', 'vova@gmail.com', 0, 'images/user/default.png	'),
(12, 'alina', '81dc9bdb52d04dc20036dbd8313ed055', 'user', 'alina@gmail.com', 0, 'images/user/default.png	'),
(13, 'vasilii', '81dc9bdb52d04dc20036dbd8313ed055', 'user', 'vasilii@gmail.com', 0, 'images/user/default.png	'),
(14, 'test', '1c73be17bbd9e027c6e6bdb9c9f47d87', 'user', 'sichnenkoolga@gmail.com', 0, 'images/user/default.png');

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `city`
--
ALTER TABLE `city`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`name`,`country_id`) USING BTREE,
  ADD KEY `fk_city_country1_idx` (`country_id`);

--
-- Индексы таблицы `country`
--
ALTER TABLE `country`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`name`) USING BTREE;

--
-- Индексы таблицы `enrollee`
--
ALTER TABLE `enrollee`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `number_passport_UNIQUE` (`number_passport`),
  ADD KEY `fk_enrollee_faculty_idx` (`faculty_id`),
  ADD KEY `fk_enrollee_status1_idx` (`status_id`),
  ADD KEY `fk_enrollee_user1_idx` (`user_id`),
  ADD KEY `fk_enrollee_city1_idx` (`city_id`);

--
-- Индексы таблицы `enrollee_has_privilege`
--
ALTER TABLE `enrollee_has_privilege`
  ADD PRIMARY KEY (`enrollee_id`,`privilege_id`),
  ADD KEY `fk_enrollee_has_privilege_privilege1_idx` (`privilege_id`),
  ADD KEY `fk_enrollee_has_privilege_enrollee1_idx` (`enrollee_id`);

--
-- Индексы таблицы `enrollee_has_subject`
--
ALTER TABLE `enrollee_has_subject`
  ADD PRIMARY KEY (`enrollee_id`,`subject_id`),
  ADD KEY `fk_enrollee_has_subject_subject1_idx` (`subject_id`),
  ADD KEY `fk_enrollee_has_subject_enrollee1_idx` (`enrollee_id`);

--
-- Индексы таблицы `faculty`
--
ALTER TABLE `faculty`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `faculty_has_subject`
--
ALTER TABLE `faculty_has_subject`
  ADD PRIMARY KEY (`subject_id`,`faculty_id`),
  ADD KEY `fk_faculty_has_subject_subject1_idx` (`subject_id`),
  ADD KEY `fk_faculty_has_subject_faculty1_idx` (`faculty_id`);

--
-- Индексы таблицы `privilege`
--
ALTER TABLE `privilege`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `status`
--
ALTER TABLE `status`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `subject`
--
ALTER TABLE `subject`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `login_UNIQUE` (`login`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `city`
--
ALTER TABLE `city`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'Идентификатор', AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT для таблицы `country`
--
ALTER TABLE `country`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'Идентификатор.', AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT для таблицы `enrollee`
--
ALTER TABLE `enrollee`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'Идентификатор', AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT для таблицы `faculty`
--
ALTER TABLE `faculty`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'Идентификатор.', AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT для таблицы `privilege`
--
ALTER TABLE `privilege`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT для таблицы `status`
--
ALTER TABLE `status`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'Идентификатор.', AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT для таблицы `subject`
--
ALTER TABLE `subject`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT для таблицы `user`
--
ALTER TABLE `user`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'Идентификатор', AUTO_INCREMENT=15;

--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `city`
--
ALTER TABLE `city`
  ADD CONSTRAINT `fk_city_country1` FOREIGN KEY (`country_id`) REFERENCES `country` (`id`) ON UPDATE CASCADE;

--
-- Ограничения внешнего ключа таблицы `enrollee`
--
ALTER TABLE `enrollee`
  ADD CONSTRAINT `fk_enrollee_city1` FOREIGN KEY (`city_id`) REFERENCES `city` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_enrollee_faculty` FOREIGN KEY (`faculty_id`) REFERENCES `faculty` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_enrollee_status1` FOREIGN KEY (`status_id`) REFERENCES `status` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_enrollee_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON UPDATE CASCADE;

--
-- Ограничения внешнего ключа таблицы `enrollee_has_privilege`
--
ALTER TABLE `enrollee_has_privilege`
  ADD CONSTRAINT `fk_enrollee_has_privilege_enrollee1` FOREIGN KEY (`enrollee_id`) REFERENCES `enrollee` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_enrollee_has_privilege_privilege1` FOREIGN KEY (`privilege_id`) REFERENCES `privilege` (`id`) ON UPDATE NO ACTION;

--
-- Ограничения внешнего ключа таблицы `enrollee_has_subject`
--
ALTER TABLE `enrollee_has_subject`
  ADD CONSTRAINT `fk_enrollee_has_subject_enrollee1` FOREIGN KEY (`enrollee_id`) REFERENCES `enrollee` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_enrollee_has_subject_subject1` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Ограничения внешнего ключа таблицы `faculty_has_subject`
--
ALTER TABLE `faculty_has_subject`
  ADD CONSTRAINT `fk_faculty_has_subject_faculty1` FOREIGN KEY (`faculty_id`) REFERENCES `faculty` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_faculty_has_subject_subject1` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
