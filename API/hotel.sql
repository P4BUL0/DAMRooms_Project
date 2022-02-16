-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 14-02-2022 a las 12:36:51
-- Versión del servidor: 10.4.21-MariaDB
-- Versión de PHP: 8.0.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `hotel`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `dni` varchar(255) NOT NULL,
  `apellidos` varchar(255) DEFAULT NULL,
  `dirección` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `telefono` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`dni`, `apellidos`, `dirección`, `nombre`, `telefono`) VALUES
('48781825K', 'Guijarro', 'Mi casa', 'Pablo', 677426876),
('99999999A', 'Ortega Boix', 'Calle Castelar n37', 'Lazaro', 111111111);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `habitaciones`
--

CREATE TABLE `habitaciones` (
  `numero` bigint(20) NOT NULL,
  `caracteristicas` varchar(255) DEFAULT NULL,
  `importe_noche` float DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL,
  `reservas_id_reserva` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `habitaciones`
--

INSERT INTO `habitaciones` (`numero`, `caracteristicas`, `importe_noche`, `tipo`, `reservas_id_reserva`) VALUES
(1, 'Grande', 150, 'Suit', NULL),
(2, 'Grande', 50, 'Individual', NULL),
(3, 'Grande', 130.5, 'Suit', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reserva`
--

CREATE TABLE `reserva` (
  `id_reserva` bigint(20) NOT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `fecha_fin` date DEFAULT NULL,
  `fecha_inicio` date DEFAULT NULL,
  `importe_total` float DEFAULT NULL,
  `cliente_dni` varchar(255) NOT NULL,
  `numero_habitacion` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `reserva`
--

INSERT INTO `reserva` (`id_reserva`, `estado`, `fecha_fin`, `fecha_inicio`, `importe_total`, `cliente_dni`, `numero_habitacion`) VALUES
(1, 'Pendiente', '2022-03-08', '2022-01-05', 3100, '99999999A', 1),
(2, 'Pendiente', '2022-01-16', '2022-01-05', 1435.5, '99999999A', 2);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`dni`);

--
-- Indices de la tabla `habitaciones`
--
ALTER TABLE `habitaciones`
  ADD PRIMARY KEY (`numero`),
  ADD KEY `FKgabg45syo2f5pweso1xrq52y2` (`reservas_id_reserva`);

--
-- Indices de la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD PRIMARY KEY (`id_reserva`),
  ADD KEY `FKc8xdoitc0gxdcrd0xbn57yp8s` (`cliente_dni`),
  ADD KEY `FKio374r8dmpowktd8ebikwy0fm` (`numero_habitacion`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `habitaciones`
--
ALTER TABLE `habitaciones`
  MODIFY `numero` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `reserva`
--
ALTER TABLE `reserva`
  MODIFY `id_reserva` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `habitaciones`
--
ALTER TABLE `habitaciones`
  ADD CONSTRAINT `FKgabg45syo2f5pweso1xrq52y2` FOREIGN KEY (`reservas_id_reserva`) REFERENCES `reserva` (`id_reserva`);

--
-- Filtros para la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD CONSTRAINT `FKc8xdoitc0gxdcrd0xbn57yp8s` FOREIGN KEY (`cliente_dni`) REFERENCES `clientes` (`dni`),
  ADD CONSTRAINT `FKio374r8dmpowktd8ebikwy0fm` FOREIGN KEY (`numero_habitacion`) REFERENCES `habitaciones` (`numero`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
