create database universidad;
use universidad;

--
-- Estructura de tabla para la tabla `misters`
--

CREATE TABLE `misters` (
  `id_mister` int NOT NULL,
  `fk_id_sub` int DEFAULT NULL,
  `name_mister` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `lastname_mister` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `direction_mister` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `phone_mister` varchar(10) COLLATE utf8mb4_general_ci NOT NULL,
  `birth_mister` varchar(8) COLLATE utf8mb4_general_ci NOT NULL,
  `category_mister` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `fk_id_session_m` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `misters`
--

INSERT INTO `misters` (`id_mister`, `fk_id_sub`, `name_mister`, `lastname_mister`, `direction_mister`, `phone_mister`, `birth_mister`, `category_mister`, `fk_id_session_m`) VALUES
(1, NULL, 'Esmeralda', 'Nunez', 'Cerro de las noas', '8714261515', '21121985', 'Math', NULL),
(2, NULL, 'Carlos', 'Ulloa', 'Marias julietas', '521364857', '18021978', 'Cine', NULL),
(3, NULL, 'Lina', 'Martinez', 'Las palmas', '8714141210', '18041956', 'Programation', NULL),
(4, NULL, 'Maria', 'Castillo', 'Nazas', '8711653256', '11032000', 'Math', NULL),
(5, NULL, 'Jorge', 'Perez', 'Maria de las antonietas', '8714965321', '19052001', 'Programation', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `notes`
--

CREATE TABLE `notes` (
  `fk_id_student` int(11) NOT NULL,
  `fk_id_sub` int(11) NOT NULL,
  `score_notes` int(3) DEFAULT NULL,
  `fk_id_session_n` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `permissions`
--

CREATE TABLE `permissions` (
  `id_permission` int(11) NOT NULL,
  `name_permission` varchar(255) DEFAULT NULL,
  `acces_permission` char(255) DEFAULT NULL,
  `fk_id_role_p` int(11) DEFAULT NULL,
  `fk_id_session_p` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `roles`
--

CREATE TABLE `roles` (
  `id_role` int(11) NOT NULL,
  `name_role` varchar(32) NOT NULL,
  `fk_id_session_r` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `roles`
--

INSERT INTO `roles` (`id_role`, `name_role`, `fk_id_session_r`) VALUES
(1, 'Beta', NULL),
(2, 'Omega', NULL),
(3, 'Alpha', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rolesusers`
--

CREATE TABLE `rolesusers` (
  `id_roleUser` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `asignament_roleUser` datetime NOT NULL,
  `vig_rolUser` datetime NOT NULL,
  `fk_id_session_ru` int(11) NOT NULL,
  `fk_id_role_ru` int(11) NOT NULL,
  `fk_id_user_ru` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sessions`
--

CREATE TABLE `sessions` (
  `id_session` int(11) NOT NULL,
  `start_session` datetime DEFAULT NULL,
  `endAct_session` datetime DEFAULT NULL,
  `ip_session` varchar(15) DEFAULT NULL,
  `fk_id_user` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `sessions`
--

INSERT INTO `sessions` (`id_session`, `start_session`, `endAct_session`, `ip_session`, `fk_id_user`) VALUES
(1, '2022-11-16 21:23:44', '2023-12-31 21:23:44', '1.198.1.2.5', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `students`
--

CREATE TABLE `students` (
  `id_student` int(11) NOT NULL,
  `name_student` varchar(50) DEFAULT NULL,
  `lastname_student` varchar(80) DEFAULT NULL,
  `birth_student` int(11) DEFAULT NULL,
  `direction_student` varchar(150) DEFAULT NULL,
  `phone_student` varchar(10) DEFAULT NULL,
  `fk_id_session_student` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `students`
--

INSERT INTO `students` (`id_student`, `name_student`, `lastname_student`, `birth_student`, `direction_student`, `phone_student`, `fk_id_session_student`) VALUES
(18452623, 'Gustavo', 'Bravo', 12122001, 'Tecnologico', '8714121214', NULL),
(20130251, 'Denisse', 'Castillo', 122212003, 'Fondo de bikini', '8529630215', NULL),
(20130252, 'Amelia', 'Castillo', 122212003, 'Merca de luz', '8714256315', NULL),
(20130837, 'Brianna', 'Medrano', 12212002, 'Bahia de las almejas', '8714852903', NULL),
(20151418, 'Arturo', 'Mendoza', 15061998, 'Paseo del tecnologico', '8711115262', NULL),
(2013854675, 'Cornelio', 'Medrano', 23012001, 'La ventana', '8745623189', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `subjects`
--

CREATE TABLE `subjects` (
  `id_sub` int(11) NOT NULL,
  `name_sub` varchar(80) NOT NULL,
  `fk_id_session_subject` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users`
--

CREATE TABLE `users` (
  `id_user` int(11) NOT NULL,
  `login_user` varchar(255) DEFAULT NULL,
  `password_user` varchar(32) DEFAULT NULL,
  `fk_id_session` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `users`
--

INSERT INTO `users` (`id_user`, `login_user`, `password_user`, `fk_id_session`) VALUES
(1, 'Admin', 'Admin1', NULL),
(2, 'Manager', 'Manager1', NULL),
(3, 'Supervisor', 'Supervisor1', 1);


--
-- Índices para tablas volcadas
--

-- PRUEBASSSSS

INSERT INTO `notes` (`fk_id_student`, `fk_id_sub`, `score_notes`, `fk_id_session_n`) VALUES
(18452623, 112, 100, 1);

INSERT INTO `subjects` (`id_sub`, `name_sub`, `fk_id_session_subject`) VALUES
(112, 'Taller de Bases de Datos', 1);


INSERT INTO `users` (`id_user`, `login_user`, `password_user`) VALUES
(4, 'Ulloa', 'jcarlos');


--
-- Indices de la tabla `misters`
--
ALTER TABLE `misters`
  ADD PRIMARY KEY (`id_mister`),
  ADD KEY `fk_id_sub` (`fk_id_sub`),
  ADD KEY `fk_id_session_m` (`fk_id_session_m`);

--
-- Indices de la tabla `notes`
--
ALTER TABLE `notes`
  ADD KEY `fk_id_student` (`fk_id_student`),
  ADD KEY `fk_id_sub` (`fk_id_sub`),
  ADD KEY `fk_id_session_n` (`fk_id_session_n`);

--
-- Indices de la tabla `permissions`
--
ALTER TABLE `permissions`
  ADD PRIMARY KEY (`id_permission`),
  ADD KEY `fk_id_session_p` (`fk_id_session_p`),
  ADD KEY `fk_id_role_p` (`fk_id_role_p`);

--
-- Indices de la tabla `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id_role`),
  ADD KEY `fk_id_session_r` (`fk_id_session_r`);

--
-- Indices de la tabla `rolesusers`
--
ALTER TABLE `rolesusers`
  ADD PRIMARY KEY (`id_roleUser`),
  ADD KEY `fk_id_session_ru` (`fk_id_session_ru`),
  ADD KEY `fk_id_role_ru` (`fk_id_role_ru`),
  ADD KEY `fk_id_user_ru` (`fk_id_user_ru`);

--
-- Indices de la tabla `sessions`
--
ALTER TABLE `sessions`
  ADD PRIMARY KEY (`id_session`),
  ADD KEY `fk_id_user` (`fk_id_user`);

--
-- Indices de la tabla `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`id_student`),
  ADD KEY `fk_id_session_student` (`fk_id_session_student`);

--
-- Indices de la tabla `subjects`
--
ALTER TABLE `subjects`
  ADD PRIMARY KEY (`id_sub`),
  ADD KEY `fk_id_session_subject` (`fk_id_session_subject`);

--
-- Indices de la tabla `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id_user`),
  ADD KEY `fk_id_session` (`fk_id_session`);

--
-- Restricciones para tablas volcadas
-- 

--
-- Filtros para la tabla `misters`
--
ALTER TABLE `misters`
  ADD CONSTRAINT `fk_id_session_m` FOREIGN KEY (`fk_id_session_m`) REFERENCES `sessions` (`id_session`),
  ADD CONSTRAINT `misters_ibfk_1` FOREIGN KEY (`fk_id_sub`) REFERENCES `subjects` (`id_sub`);

select *
from subjects;
-- Filtros para la tabla `notes`
--
ALTER TABLE `notes`
  ADD CONSTRAINT `fk_id_session_n` FOREIGN KEY (`fk_id_session_n`) REFERENCES `sessions` (`id_session`),
  ADD CONSTRAINT `notes_ibfk_1` FOREIGN KEY (`fk_id_student`) REFERENCES `students` (`id_student`),
  ADD CONSTRAINT `notes_ibfk_2` FOREIGN KEY (`fk_id_sub`) REFERENCES `subjects` (`id_sub`);

--
-- Filtros para la tabla `permissions`
--
ALTER TABLE `permissions`
  ADD CONSTRAINT `fk_id_role_p` FOREIGN KEY (`fk_id_role_p`) REFERENCES `roles` (`id_role`),
  ADD CONSTRAINT `fk_id_session_p` FOREIGN KEY (`fk_id_session_p`) REFERENCES `sessions` (`id_session`);

--
-- Filtros para la tabla `roles`
--
ALTER TABLE `roles`
  ADD CONSTRAINT `fk_id_session_r` FOREIGN KEY (`fk_id_session_r`) REFERENCES `sessions` (`id_session`);

--
-- Filtros para la tabla `rolesusers`
--
ALTER TABLE `rolesusers`
  ADD CONSTRAINT `fk_id_role_ru` FOREIGN KEY (`fk_id_role_ru`) REFERENCES `roles` (`id_role`),
  ADD CONSTRAINT `fk_id_session_ru` FOREIGN KEY (`fk_id_session_ru`) REFERENCES `sessions` (`id_session`),
  ADD CONSTRAINT `fk_id_user_ru` FOREIGN KEY (`fk_id_user_ru`) REFERENCES `users` (`id_user`);

--
-- Filtros para la tabla `sessions`
--
ALTER TABLE `sessions`
  ADD CONSTRAINT `fk_id_user` FOREIGN KEY (`fk_id_user`) REFERENCES `users` (`id_user`);

--
-- Filtros para la tabla `students`
--
ALTER TABLE `students`
  ADD CONSTRAINT `fk_id_session_student` FOREIGN KEY (`fk_id_session_student`) REFERENCES `sessions` (`id_session`);

--
-- Filtros para la tabla `subjects`
--
ALTER TABLE `subjects`
  ADD CONSTRAINT `fk_id_session_subject` FOREIGN KEY (`fk_id_session_subject`) REFERENCES `sessions` (`id_session`);

--
-- Filtros para la tabla `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `fk_id_session` FOREIGN KEY (`fk_id_session`) REFERENCES `sessions` (`id_session`);

ALTER TABLE rolesusers
DROP COLUMN id_user;

ALTER TABLE rolesusers
MODIFY COLUMN asignament_roleUser VARCHAR(50),
MODIFY COLUMN vig_rolUser VARCHAR(50); 

ALTER TABLE sessions
MODIFY COLUMN start_session VARCHAR(50),
MODIFY COLUMN endAct_session VARCHAR(50);

-- Vista para mostrar los Maestros que imparten la misma materia

CREATE VIEW MaestrosX
AS
SELECT mis.name_mister, mis.lastname_mister, mis.fk_id_sub, sub.name_sub
FROM misters as mis
INNER JOIN subjects AS sub ON (mis.fk_id_sub = sub.id_sub);

-- Function

DELIMITER //

CREATE FUNCTION PromedioAlumno(student_id INT)
RETURNS INT
DETERMINISTIC
BEGIN
    DECLARE promedio INT;
    
    SELECT AVG(score_notes)
    INTO promedio
    FROM notes
    WHERE fk_id_student = student_id;

    RETURN IFNULL(promedio, 0);
END;
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateMisters`(
	id_mister_java INT,
    fk_id_sub INT,
    name_mister VARCHAR(50),
    lastname_mister VARCHAR(100),
    direction_mister VARCHAR(100),
    phone_mister VARCHAR(10),
    birth_mister VARCHAR(8),
    category_mister VARCHAR(50),
    fk_id_session_m INT
)
BEGIN
	UPDATE misters
    SET
		fk_id_sub = fk_id_sub,
        name_mister = name_mister,
        lastname_mister = lastname_mister,
        direction_mister = direction_mister,
        phone_mister = phone_mister,
        birth_mister = birth_mister,
        category_mister = category_mister,
        fk_id_session_m = fk_id_session_m
	WHERE
		id_mister = id_mister_java;
END$$
DELIMITER ;

-- Trigger
DELIMITER //

CREATE TRIGGER CheckPermissionAccess
BEFORE INSERT ON permissions
FOR EACH ROW
BEGIN
    DECLARE access_allowed BOOL;
    
    IF NEW.acces_permission IN ('read', 'write') THEN
        SET access_allowed = TRUE;
    ELSE
        SET access_allowed = FALSE;
    END IF;
    
    IF NOT access_allowed THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Acceso_Permiso Invalido. Valores permitidos: read, write';
    END IF;
END;
//

DELIMITER ;

-- Procedures #1
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateMisters`(
	id_mister_java INT,
    fk_id_sub INT,
    name_mister VARCHAR(50),
    lastname_mister VARCHAR(100),
    direction_mister VARCHAR(100),
    phone_mister VARCHAR(10),
    birth_mister VARCHAR(8),
    category_mister VARCHAR(50),
    fk_id_session_m INT
)
BEGIN
	UPDATE misters
    SET
		fk_id_sub = fk_id_sub,
        name_mister = name_mister,
        lastname_mister = lastname_mister,
        direction_mister = direction_mister,
        phone_mister = phone_mister,
        birth_mister = birth_mister,
        category_mister = category_mister,
        fk_id_session_m = fk_id_session_m
	WHERE
		id_mister = id_mister_java;
END$$
DELIMITER ;

-- Procedures #2

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateNotes`(
	fk_id_student_java INT,
    fk_id_sub_java INT,
    score_notes_java INT,
    fk_id_session_n_java INT
)
BEGIN
	UPDATE notes
    SET
        fk_id_sub = fk_id_sub_java,
        score_notes = score_notes_java,
        fk_id_session_n = fk_id_session_n_java
	WHERE
		fk_id_student = fk_id_student_java;
END$$
DELIMITER ;

-- Procedures #3

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `updatePermissions`(
	id_permission_java INT,
    name_permission VARCHAR(255),
    acces_permission CHAR(255),
    fk_id_role_p INT,
    fk_id_session_p INT
)
BEGIN
	UPDATE permissions
    SET
        name_permission = name_permission,
        acces_permission = acces_permission,
        fk_id_role_p = fk_id_role_p,
        fk_id_session_p = fk_id_session_p
	WHERE
		id_permission = id_permission_java;
END$$
DELIMITER ;

-- Procedures #4

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateRoles`(
	id_role_java INT,
    name_role VARCHAR(32),
    fk_id_session_r INT
)
BEGIN
	UPDATE roles
    SET
        id_role = id_role,
        name_role = name_role,
        fk_id_session_r = fk_id_session_r
	WHERE
		id_role = id_role_java;
END$$
DELIMITER ;

-- Procedures #5

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateRoleusers`(
	id_roleUser_java INT,
    asignament_roleUser VARCHAR(50),
    vig_rolUser VARCHAR(50),
    fk_id_session_ru INT,
    fk_id_role_ru INT,
    fk_id_user_ru INT
)
BEGIN
	UPDATE rolesusers
    SET
		id_roleUser = id_roleUser_java,
		asignament_roleUser = asignament_roleUser,
        vig_rolUser = vig_rolUser,
        fk_id_session_ru = fk_id_session_ru,
        fk_id_role_ru = fk_id_role_ru,
        fk_id_user_ru = fk_id_user_ru;

END$$
DELIMITER ;

-- Procedures #6

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateSessions`(
	id_session_java INT,
    start_session VARCHAR(50),
    endAct_session VARCHAR(50),
    ip_session VARCHAR(15),
    fk_id_user INT
)
BEGIN
	UPDATE sessions
    SET
        start_session = start_session,
        endAct_session = endAct_session,
        ip_session = ip_session,
        fk_id_user = fk_id_user
	WHERE
		id_session = id_session_java;
END$$
DELIMITER ;

-- Procedures #7

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateStudents`(
	id_student_java INT,
    name_student VARCHAR(50),
    lastname_student VARCHAR(80),
    birth_student INT,
    direction_student VARCHAR(150),
    phone_student VARCHAR(10),
    fk_id_session_student INT
)
BEGIN
	UPDATE students
    SET
        name_student = name_student,
        lastname_student = lastname_student,
        birth_student = birth_student,
        direction_student = direction_student,
        phone_student = phone_student,
        fk_id_session_student = fk_id_session_student
	WHERE
		id_student = id_student_java;
END$$
DELIMITER ;

-- Procedures #8

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateSubjects`(
	id_sub_java INT,
    name_sub VARCHAR(80),
    fk_id_session_subject INT
)
BEGIN
	UPDATE subjects
    SET
        name_sub = name_sub,
        fk_id_session_subject = fk_id_session_subject
	WHERE
		id_sub = id_sub_java;
END$$
DELIMITER ;

-- Procedures #9

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateUsers`(
	id_user_java INT,
    login_user VARCHAR(255),
    password_user VARCHAR(32),
    fk_id_session INT
)
BEGIN
	UPDATE users
    SET
        login_user = login_user,
        password_user = password_user,
        fk_id_session = fk_id_session
	WHERE
		id_user = id_user_java;
END$$
DELIMITER ;



