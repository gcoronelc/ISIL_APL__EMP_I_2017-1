-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 01-06-2017 a las 15:04:04
-- Versión del servidor: 5.5.24-log
-- Versión de PHP: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `colegio`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE IF NOT EXISTS `empleado` (
  `IdEmp` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(60) NOT NULL,
  `Apellido` varchar(60) DEFAULT NULL,
  `DNI` varchar(20) NOT NULL,
  `Direccion` varchar(150) DEFAULT NULL,
  `Telefono` varchar(40) DEFAULT NULL,
  `Correo` varchar(100) NOT NULL,
  `Estado` int(11) NOT NULL,
  PRIMARY KEY (`IdEmp`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`IdEmp`, `Nombre`, `Apellido`, `DNI`, `Direccion`, `Telefono`, `Correo`, `Estado`) VALUES
(1, 'Miguel Eduardo', 'Lozano Zevallos', '70543710', 'Calle Berlin 473 - Miraflores', '906478210', 'mlozano@hotmail.com', 1),
(2, 'Franchesco', 'Sucasayre Reyes', '07415478', 'Av. La Encalada 837 - Santiago de Surco', '990645129', 'fsreyes@gmail.com', 1),
(3, 'Felix Victor', 'Anampa Lavado', '01247852', 'Av. Francisco Bolognesi 352 - Barranco', '984500174', 'fanampa@gmail.com', 0),
(4, 'Paola Ines', 'Cubillas Acuña', '70451285', 'Jirón El Galeón 344 - Santiago de Surco', '934512890', 'pcubillas@hotmail.com', 1),
(5, 'Eric Gustavo', 'Coronel Castillo', '04510597', 'Av. General Juan Antonio Pezet 1664 - San Isidro', '994512470', 'gcoronel@gmail.com', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `permiso`
--

CREATE TABLE IF NOT EXISTS `permiso` (
  `IdEmp` int(11) NOT NULL,
  `IdRol` int(11) NOT NULL,
  `Estado` int(11) NOT NULL,
  PRIMARY KEY (`IdEmp`,`IdRol`),
  KEY `FK_PERMISO_ROL` (`IdRol`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `permiso`
--

INSERT INTO `permiso` (`IdEmp`, `IdRol`, `Estado`) VALUES
(1, 1, 1),
(1, 2, 0),
(1, 3, 0),
(1, 4, 0),
(2, 1, 0),
(2, 2, 1),
(2, 3, 0),
(2, 4, 0),
(3, 1, 0),
(3, 2, 0),
(3, 3, 0),
(3, 4, 0),
(4, 1, 0),
(4, 2, 0),
(4, 3, 0),
(4, 4, 1),
(5, 1, 0),
(5, 2, 0),
(5, 3, 0),
(5, 4, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE IF NOT EXISTS `rol` (
  `IdRol` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(20) DEFAULT NULL,
  `Descripcion` varchar(200) NOT NULL,
  `Estado` int(11) NOT NULL,
  PRIMARY KEY (`IdRol`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`IdRol`, `Nombre`, `Descripcion`, `Estado`) VALUES
(1, 'Dirección', 'Tiene acceso a todos los módulos.', 1),
(2, 'Secretaría', 'Tiene acceso a ventas y Consultas', 1),
(3, 'Profesores', 'Tiene Acceso a Consultas', 1),
(4, 'Alumnos', 'Tiene acceso a Consultas y Reportes.', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `IdEmp` int(11) NOT NULL,
  `Usuario` varchar(20) NOT NULL,
  `Clave` varchar(40) NOT NULL,
  `Estado` int(11) NOT NULL,
  PRIMARY KEY (`IdEmp`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`IdEmp`, `Usuario`, `Clave`, `Estado`) VALUES
(1, 'Mlz896', '123456', 1),
(2, 'Fsr120', '123456', 1),
(3, 'Fal100', '123456', 1),
(4, 'Pca321', '123456', 1),
(5, 'Ecc001', '123456', 1);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
