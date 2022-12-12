-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 12-12-2022 a las 23:18:00
-- Versión del servidor: 10.4.27-MariaDB
-- Versión de PHP: 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `squawk_db`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users`
--

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL,
  `nickname` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(320) NOT NULL,
  `profile_picture` varchar(500) NOT NULL DEFAULT 'assets/profile_pictures/default.webp',
  `user_type` tinyint(5) NOT NULL,
  `status` tinyint(5) NOT NULL,
  `birthday` date NOT NULL,
  `creation_date` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `users`
--

INSERT INTO `users` (`user_id`, `nickname`, `password`, `email`, `profile_picture`, `user_type`, `status`, `birthday`, `creation_date`) VALUES
(1, 'elenanito69', '1234', 'elenanito69@gmail.com', 'assets/profile_pictures\\maxresdefault.jpg', 1, 1, '1999-04-24', '2022-10-01'),
(2, 'Juan', 'juan1234!', 'juan@gmail.com', 'assets/profile_pictures\\juan.jpg', 3, 1, '2003-06-07', '2022-10-10'),
(4, 'Joseph', '1234', 'josephcavero@gmail.com', 'assets/profile_pictures\\joseph.jpg', 3, 1, '2002-12-12', '2022-10-12'),
(5, 'Leslly', '1234', 'lepope@gmail.com', 'assets/profile_pictures/default.webp', 3, 1, '1989-01-01', '2022-10-12'),
(6, 'paco', '1234', 'paco@gmail.com', 'assets/profile_pictures\\monito_viral.png', 1, 1, '2001-11-08', '2022-11-09'),
(7, 'Carlos', 'carlos123', 'carlos@gmail.com', 'assets/profile_pictures/default.webp', 1, 1, '2000-10-10', '2022-11-15'),
(8, 'Gianpierre', 'giampi123', 'giampierre@gmail.com', 'assets/profile_pictures/gian.jpg', 3, 1, '2001-12-20', '2022-11-15'),
(9, 'Hugo', 'hugo123', 'Hugo@gmail.com', 'assets/profile_pictures/default.webp', 1, 1, '1999-08-15', '2022-11-15'),
(10, 'Lucas', 'lucas123', 'Lucas@gmail.com', 'assets/profile_pictures/default.webp', 1, 1, '2000-04-30', '2022-11-15'),
(11, 'Sophia', 'sophia123', 'Sophia@gmail.com', 'ssets/profile_pictures/default.webp', 1, 1, '1999-05-21', '2022-11-15'),
(12, 'Mia', 'mia123', 'Mia@gmail.com', 'assets/profile_pictures/default.webp', 1, 1, '2003-06-16', '2022-11-15'),
(13, 'Alejandro', 'alejandro123', 'Alejandro@gmail.com', 'assets/profile_pictures/default.webp', 1, 1, '1998-10-02', '2022-11-15'),
(14, 'Daniel', 'daniel123', 'Daniel@gmail.com', 'assets/profile_pictures/default.webp', 1, 1, '2000-07-28', '2022-11-15'),
(15, 'Adonis', 'adonis123', 'Adonis@gmail.com', 'assets/profile_pictures/default.webp', 1, 1, '1996-08-15', '2022-11-15'),
(16, 'Olivia', 'olivia123', 'Olivia@gmail.com', 'assets/profile_pictures/default.webp', 1, 1, '2003-02-09', '2022-11-15'),
(17, 'Martina', 'martina123', 'Martina@gmail.com', 'assets/profile_pictures/default.webp', 1, 1, '1997-07-29', '2022-11-15'),
(18, 'Diego', 'diego123', 'Diego@gmail.com', 'assets/profile_pictures/default.webp', 1, 1, '2000-06-16', '2022-11-15'),
(19, 'Alfonso', 'alfonso123', 'Alfonso@gmail.com', 'assets/profile_pictures/default.webp', 1, 1, '2001-10-21', '2022-11-15'),
(20, 'Cesar', 'cesar123', 'Cesar@gmail.com', 'assets/profile_pictures/default.webp', 1, 1, '1999-08-03', '2022-11-15'),
(37, 'Sindell Leon', '123', 'sindell@gmail.com', 'assets/profile_pictures/sindell.jpg', 3, 1, '2002-07-20', '2022-12-08');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `user_id` (`user_id`),
  ADD UNIQUE KEY `email` (`email`),
  ADD UNIQUE KEY `nickname` (`nickname`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
