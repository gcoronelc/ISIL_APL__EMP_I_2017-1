-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 29-06-2017 a las 09:04:22
-- Versión del servidor: 10.1.21-MariaDB
-- Versión de PHP: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `colegiodb`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `año`
--

CREATE TABLE `año` (
  `AÑO` char(4) NOT NULL,
  `CUOTA_MENS` double NOT NULL,
  `CUOTA_ING` double NOT NULL,
  `FEC_INI` date NOT NULL,
  `FEC_FIN` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `año`
--

INSERT INTO `año` (`AÑO`, `CUOTA_MENS`, `CUOTA_ING`, `FEC_INI`, `FEC_FIN`) VALUES
('2016', 800, 1000, '2016-03-15', '2016-12-08'),
('2017', 900, 1200, '2017-03-15', '2017-12-08');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `IDEMP` int(11) NOT NULL,
  `USUARIO` varchar(30) DEFAULT NULL,
  `CLAVE` varchar(30) DEFAULT NULL,
  `NOMBRE_EMP` varchar(30) DEFAULT NULL,
  `APELLIDO_EMP` varchar(30) DEFAULT NULL,
  `CORREO` varchar(40) DEFAULT NULL,
  `IDPER` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`IDEMP`, `USUARIO`, `CLAVE`, `NOMBRE_EMP`, `APELLIDO_EMP`, `CORREO`, `IDPER`) VALUES
(1, 'cbejarano', '123456', 'CHRISTIAN', 'BEJARANO', 'CGBM@HOTMAIL.COM', 1),
(4, 'pachito', '456', 'PANCHO', 'VARGAS', 'pachito@gmail.com', 1),
(5, 'cbus', '123', 'cesar', 'bustamante', 'cbus@gmail.com', 2),
(6, 'leoncito', '123', 'leon', 'cabel', 'leoc@gmail.com', 0),
(7, 'cperez', '123', 'juan', 'perez', 'jperez@gmail.com', 2),
(8, 'nati456', '456', 'nataniel', 'sanchez', 'natus@gmail.com', 2),
(9, 'mangel', '123456', 'miguel', 'angel', 'ang@gmail.com', 2),
(10, 'cesar', '123456', 'cesar', 'nalvarte', 'csar@gmail.com', 1),
(11, 'pape', '456', 'prueba', 'pruebaAp', 'jcarlos@gmail.com', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estudiante`
--

CREATE TABLE `estudiante` (
  `IDEST` int(11) NOT NULL,
  `NOMBRE_EST` varchar(30) DEFAULT NULL,
  `APELLIDO_EST` varchar(30) DEFAULT NULL,
  `APODERADO` varchar(60) DEFAULT NULL,
  `CORREO_APO` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `estudiante`
--

INSERT INTO `estudiante` (`IDEST`, `NOMBRE_EST`, `APELLIDO_EST`, `APODERADO`, `CORREO_APO`) VALUES
(1, 'CESAR', 'MALAGA', 'AGUSTO MALAGA', 'AMALAGA@GMAIL.COM'),
(2, 'CAROLINA', 'ZOLA', 'HECTOR ZOLA', 'HZOLA@HOTMAIL.COM'),
(3, 'MAURICIO', 'CRUZ', 'SERGIO CRUZ', 'SCRUZ@GMAIL.COM'),
(4, 'LUIS', 'COTRINA', 'JORGE COTRINA', 'JCOTRI@HOTMAIL.COM'),
(5, 'GERMAN', 'CARBAJAL', 'NORMA CARBAJAL', 'NCARBA@GMAIL.COM'),
(6, 'CLAUDIA', 'FALERO', 'ITALO FALERO', 'IFALERO@GMAIL.COM'),
(7, 'CRISTIAN', 'TORRES', 'VICTOR TORRES', 'VTORRES@GMAIL.COM'),
(8, 'daniel', 'curais', 'Sergio Malaga', 'sg@hotmail.com'),
(9, 'diego', 'alonso', 'juan alvarez', 'jalvarez@gmail.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `matricula`
--

CREATE TABLE `matricula` (
  `IDMAT` int(11) NOT NULL,
  `IDEST` int(11) NOT NULL,
  `FEC_MATRICULA` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `matricula`
--

INSERT INTO `matricula` (`IDMAT`, `IDEST`, `FEC_MATRICULA`) VALUES
(1, 1, '2017-01-10'),
(2, 2, '2017-02-10'),
(3, 3, '2017-02-10'),
(4, 4, '2017-01-08'),
(5, 5, '2017-01-12'),
(6, 6, '2017-01-15'),
(7, 7, '2017-02-16');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `menu`
--

CREATE TABLE `menu` (
  `IDMENU` int(11) NOT NULL,
  `MENU` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `menu`
--

INSERT INTO `menu` (`IDMENU`, `MENU`) VALUES
(1, 'SEGURIDAD'),
(2, 'PLANIFICACION'),
(3, 'VENTAS'),
(4, 'REPORTES');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `nivel`
--

CREATE TABLE `nivel` (
  `IDNIVEL` int(11) NOT NULL,
  `NIVEL` char(1) DEFAULT NULL,
  `DES_NIVEL` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `nivel`
--

INSERT INTO `nivel` (`IDNIVEL`, `NIVEL`, `DES_NIVEL`) VALUES
(1, '1', 'PRIMARIA'),
(2, '2', 'SECUNDARIA');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pago`
--

CREATE TABLE `pago` (
  `IDPAGO` int(11) NOT NULL,
  `ID_TP` int(11) NOT NULL,
  `MONTO` double NOT NULL,
  `MORA` double NOT NULL,
  `FEC_PAGO` datetime DEFAULT NULL,
  `FEC_VENCIM` datetime DEFAULT NULL,
  `IDEST` int(11) NOT NULL,
  `IDMAT` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `pago`
--

INSERT INTO `pago` (`IDPAGO`, `ID_TP`, `MONTO`, `MORA`, `FEC_PAGO`, `FEC_VENCIM`, `IDEST`, `IDMAT`) VALUES
(1, 2, 700, 0, '2017-01-10 00:00:00', '2017-03-01 00:00:00', 1, 1),
(2, 2, 700, 0, '2017-02-10 00:00:00', '2017-03-01 00:00:00', 2, 2),
(3, 2, 700, 0, '2017-02-10 00:00:00', '2017-03-01 00:00:00', 3, 3),
(4, 2, 700, 0, '2017-01-08 00:00:00', '2017-03-01 00:00:00', 4, 4),
(5, 2, 700, 0, '2017-01-12 00:00:00', '2017-03-01 00:00:00', 5, 5),
(6, 2, 700, 0, '2017-01-15 00:00:00', '2017-03-01 00:00:00', 6, 6),
(7, 2, 700, 0, '2017-02-16 00:00:00', '2017-03-01 00:00:00', 7, 7),
(8, 2, 700, 0, '2017-06-25 15:10:15', '2017-06-25 15:10:15', 1, 1),
(9, 2, 700, 0, NULL, NULL, 2, 2),
(10, 2, 700, 0, NULL, NULL, 2, 2),
(11, 2, 700, 0, NULL, NULL, 2, 2),
(12, 2, 700, 0, NULL, NULL, 2, 2),
(13, 3, 700, 0, NULL, NULL, 2, 3),
(14, 2, 700, 0, '2017-06-05 00:00:00', '2017-06-05 00:00:00', 2, 2),
(15, 2, 800, 0, '2017-06-05 00:00:00', '2017-06-05 00:00:00', 2, 2),
(16, 3, 500, 0, '2017-06-01 00:00:00', '2017-06-20 00:00:00', 1, 2),
(17, 2, 800, 0, '2017-06-05 00:00:00', '2017-06-05 00:00:00', 2, 2),
(18, 2, 100, 0, '2017-06-05 00:00:00', '2017-06-05 00:00:00', 2, 2),
(19, 1, 1000, 0, '2017-06-05 00:00:00', '2017-06-05 00:00:00', 1, 2),
(20, 1, 1500, 0, '2025-07-17 00:00:00', '2027-08-17 00:00:00', 1, 2),
(21, 1, 1500, 0, '2017-05-10 00:00:00', '2017-06-01 00:00:00', 1, 2),
(22, 1, 3000, 0, '2017-05-10 00:00:00', '2017-06-01 00:00:00', 1, 2),
(23, 1, 900, 0, '2017-07-03 00:00:00', '2007-07-04 00:00:00', 1, 2),
(24, 1, 900, 0, '2017-07-03 00:00:00', '2007-07-04 00:00:00', 1, 2),
(25, 1, 950, 0, '2017-07-03 00:00:00', '2007-07-04 00:00:00', 1, 2),
(26, 2, 100, 0, '2017-06-05 00:00:00', '2017-06-05 00:00:00', 2, 2),
(27, 2, 100, 0, '2017-06-05 00:00:00', '2017-06-05 00:00:00', 2, 2),
(29, 1, 10, 0, '2017-07-03 00:00:00', '2007-08-10 00:00:00', 5, 4),
(30, 2, 100, 0, '2017-06-05 00:00:00', '2017-06-05 00:00:00', 2, 2),
(31, 1, 100, 0, '2017-01-10 00:00:00', '2017-07-03 00:00:00', 1, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `permiso`
--

CREATE TABLE `permiso` (
  `IDPER` int(11) NOT NULL,
  `IDMENU` int(11) NOT NULL,
  `IDEMP` int(11) NOT NULL,
  `TIPO` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `permiso`
--

INSERT INTO `permiso` (`IDPER`, `IDMENU`, `IDEMP`, `TIPO`) VALUES
(1, 1, 1, 'administrador'),
(2, 2, 5, 'secretaria');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `salon`
--

CREATE TABLE `salon` (
  `IDSALON` int(11) NOT NULL,
  `SALON` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `salon`
--

INSERT INTO `salon` (`IDSALON`, `SALON`) VALUES
(1, '101'),
(2, '102'),
(3, '103'),
(4, '104'),
(5, '105'),
(6, '106'),
(7, '201'),
(8, '202'),
(9, '203'),
(10, '204'),
(11, '205');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `seccion`
--

CREATE TABLE `seccion` (
  `IDSEC` int(11) NOT NULL,
  `IDNIVEL` int(11) NOT NULL,
  `IDSALON` int(11) NOT NULL,
  `AÑO` char(4) NOT NULL,
  `GRADO` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `seccion`
--

INSERT INTO `seccion` (`IDSEC`, `IDNIVEL`, `IDSALON`, `AÑO`, `GRADO`) VALUES
(1, 1, 1, '2017', '1'),
(2, 1, 2, '2017', '2'),
(3, 1, 3, '2017', '3'),
(4, 1, 4, '2017', '4'),
(5, 1, 5, '2017', '5'),
(6, 1, 6, '2017', '6'),
(7, 2, 7, '2017', '1'),
(8, 2, 8, '2017', '2'),
(9, 2, 9, '2017', '3'),
(10, 2, 10, '2017', '4'),
(11, 2, 11, '2017', '5');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_pago`
--

CREATE TABLE `tipo_pago` (
  `ID_TP` int(11) NOT NULL,
  `CONCEPTO` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tipo_pago`
--

INSERT INTO `tipo_pago` (`ID_TP`, `CONCEPTO`) VALUES
(1, 'CUOTA INGRESO'),
(2, 'MATRICULA'),
(3, 'CUOTA MARZO'),
(4, 'CUOTA ABRIL'),
(5, 'CUOTA MAYO'),
(6, 'CUOTA JUNIO'),
(7, 'CUOTA JULIO'),
(8, 'CUOTA AGOSTO'),
(9, 'CUOTA SETIEMBRE'),
(10, 'CUOTA OCTUBRE'),
(11, 'CUOTA NOVIEMBRE'),
(12, 'CUOTA DICIEMBRE');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `año`
--
ALTER TABLE `año`
  ADD PRIMARY KEY (`AÑO`);

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`IDEMP`);

--
-- Indices de la tabla `estudiante`
--
ALTER TABLE `estudiante`
  ADD PRIMARY KEY (`IDEST`);

--
-- Indices de la tabla `matricula`
--
ALTER TABLE `matricula`
  ADD PRIMARY KEY (`IDMAT`),
  ADD KEY `IDEST` (`IDEST`);

--
-- Indices de la tabla `menu`
--
ALTER TABLE `menu`
  ADD PRIMARY KEY (`IDMENU`);

--
-- Indices de la tabla `nivel`
--
ALTER TABLE `nivel`
  ADD PRIMARY KEY (`IDNIVEL`);

--
-- Indices de la tabla `pago`
--
ALTER TABLE `pago`
  ADD PRIMARY KEY (`IDPAGO`),
  ADD KEY `ID_TP` (`ID_TP`),
  ADD KEY `IDEST` (`IDEST`),
  ADD KEY `IDMAT` (`IDMAT`);

--
-- Indices de la tabla `permiso`
--
ALTER TABLE `permiso`
  ADD PRIMARY KEY (`IDPER`),
  ADD KEY `IDMENU` (`IDMENU`),
  ADD KEY `IDEMP` (`IDEMP`);

--
-- Indices de la tabla `salon`
--
ALTER TABLE `salon`
  ADD PRIMARY KEY (`IDSALON`);

--
-- Indices de la tabla `seccion`
--
ALTER TABLE `seccion`
  ADD PRIMARY KEY (`IDSEC`),
  ADD KEY `IDNIVEL` (`IDNIVEL`),
  ADD KEY `IDSALON` (`IDSALON`),
  ADD KEY `AÑO` (`AÑO`);

--
-- Indices de la tabla `tipo_pago`
--
ALTER TABLE `tipo_pago`
  ADD PRIMARY KEY (`ID_TP`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `empleado`
--
ALTER TABLE `empleado`
  MODIFY `IDEMP` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT de la tabla `estudiante`
--
ALTER TABLE `estudiante`
  MODIFY `IDEST` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT de la tabla `matricula`
--
ALTER TABLE `matricula`
  MODIFY `IDMAT` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT de la tabla `menu`
--
ALTER TABLE `menu`
  MODIFY `IDMENU` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `nivel`
--
ALTER TABLE `nivel`
  MODIFY `IDNIVEL` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `pago`
--
ALTER TABLE `pago`
  MODIFY `IDPAGO` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;
--
-- AUTO_INCREMENT de la tabla `permiso`
--
ALTER TABLE `permiso`
  MODIFY `IDPER` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT de la tabla `salon`
--
ALTER TABLE `salon`
  MODIFY `IDSALON` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT de la tabla `seccion`
--
ALTER TABLE `seccion`
  MODIFY `IDSEC` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT de la tabla `tipo_pago`
--
ALTER TABLE `tipo_pago`
  MODIFY `ID_TP` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `matricula`
--
ALTER TABLE `matricula`
  ADD CONSTRAINT `matricula_ibfk_1` FOREIGN KEY (`IDEST`) REFERENCES `estudiante` (`IDEST`);

--
-- Filtros para la tabla `pago`
--
ALTER TABLE `pago`
  ADD CONSTRAINT `pago_ibfk_1` FOREIGN KEY (`ID_TP`) REFERENCES `tipo_pago` (`ID_TP`),
  ADD CONSTRAINT `pago_ibfk_2` FOREIGN KEY (`IDEST`) REFERENCES `estudiante` (`IDEST`),
  ADD CONSTRAINT `pago_ibfk_3` FOREIGN KEY (`IDMAT`) REFERENCES `matricula` (`IDMAT`);

--
-- Filtros para la tabla `permiso`
--
ALTER TABLE `permiso`
  ADD CONSTRAINT `permiso_ibfk_1` FOREIGN KEY (`IDMENU`) REFERENCES `menu` (`IDMENU`),
  ADD CONSTRAINT `permiso_ibfk_2` FOREIGN KEY (`IDEMP`) REFERENCES `empleado` (`IDEMP`);

--
-- Filtros para la tabla `seccion`
--
ALTER TABLE `seccion`
  ADD CONSTRAINT `seccion_ibfk_1` FOREIGN KEY (`IDNIVEL`) REFERENCES `nivel` (`IDNIVEL`),
  ADD CONSTRAINT `seccion_ibfk_2` FOREIGN KEY (`IDSALON`) REFERENCES `salon` (`IDSALON`),
  ADD CONSTRAINT `seccion_ibfk_3` FOREIGN KEY (`AÑO`) REFERENCES `año` (`AÑO`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
