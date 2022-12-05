-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 05-12-2022 a las 04:14:54
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
-- Estructura de tabla para la tabla `cuacks`
--

CREATE TABLE `cuacks` (
  `cuack_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `tag_id` int(11) NOT NULL,
  `content` varchar(320) NOT NULL,
  `img` varchar(500) NOT NULL,
  `product_url` varchar(2048) NOT NULL,
  `status` tinyint(5) NOT NULL,
  `title` varchar(255) NOT NULL,
  `creation_date` datetime NOT NULL DEFAULT current_timestamp(),
  `is_edited` tinyint(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `cuacks`
--

INSERT INTO `cuacks` (`cuack_id`, `user_id`, `tag_id`, `content`, `img`, `product_url`, `status`, `title`, `creation_date`, `is_edited`) VALUES
(1, 1, 4, 'Queria tranformarme en cannonball y no me dejaba. Encima me costo cerca de 200 lucas ps. Sufro 1 dia mas por no ser mi alien favorito.', 'https://http2.mlstatic.com/D_NQ_NP_901699-MPE45617090580_042021-O.webp', '\'https://articulo.mercadolibre.com.pe/MPE-444983006-reloj-omnitrix-ben-10-alien-forze-_JM#position=8&search_layout=stack&type=item&tracking_id=b1ad7e2d-f534-42f6-8e22-d12a91b6e1e7%27,%27OMNITRIX', 1, 'OMNITRIX inservible', '2022-11-15 13:23:25', 0),
(2, 17, 17, 'Compre este shampoo, pero solo me saca caspa y me maltrata el cabello, no lo recomiendo.', 'https://http2.mlstatic.com/D_NQ_NP_776237-MPE51280485948_082022-O.webp', 'https://articulo.mercadolibre.com.pe/MPE-438784598-shampoo-la-brasiliana-_JM?searchVariation=92239373264#searchVariation=92239373264&position=6&search_layout=grid&type=item&tracking_id=3418ce02-dff5-4176-8c6a-89743aade9b0', 1, 'Shampoo de mala calidad', '2021-11-09 16:29:24', 0),
(3, 19, 1, 'Compre un dispensador de cereales en mercado libre, no lo recomiendo, se atraca los cereales o demoran en caer y además tiene un precio injusto.', 'https://http2.mlstatic.com/D_NQ_NP_834299-MPE51170931508_082022-O.webp', 'https://articulo.mercadolibre.com.pe/MPE-601247764-dispensador-doble-para-cereales-_JM#position=6&search_layout=stack&type=item&tracking_id=9d6e5c7f-f83d-47d8-9851-6725866f3646', 1, 'Dispensador de cereales', '2022-11-21 18:36:39', 0),
(4, 2, 4, 'Robot musical para niños, super recomendado y a un buen precio', 'https://http2.mlstatic.com/D_NQ_NP_770271-MPE48088161248_112021-O.webp', 'https://cutt.ly/5MBvwA1', 1, 'Robot inteligente bailarin', '2022-11-19 20:30:21', 0),
(5, 1, 10, 'Compre este adorno de árbol a un precio extraordinario, se lo recomiendo, lo pueden encontrar en el siguiente link.', 'https://ae01.alicdn.com/kf/S5ee97fc2081444bba051c72001e19735Y/Plantas-artificiales-bons-i-maceta-de-rbol-peque-o-plantas-falsas-adornos-en-maceta-para-la.jpg_640x640.jpg', 'https://cutt.ly/rMBn7zN', 1, 'Adorno de Árbol artificial', '2022-08-17 20:46:59', 0),
(6, 6, 2, 'Zapatilla forum low de adidas originales comprados a un buen precio, son suaves y cómodos, super recomendado.', 'https://assets.adidas.com/images/w_600,f_auto,q_auto/d8e4783c60e54e18bb73acfd0104b9cc_9366/Zapatillas_Forum_Low_Blanco_FY7978.jpg', 'https://www.adidas.pe/zapatillas-forum-low/FY7978.html?cm_mmc=AdieSEM_Google_PLA-_-Always_On-_-Shopping-_-FY7978-0003-_-dv%3AeCom-_-cn%3AAlways_On-_-pc%3AB%C3%A1squet&cm_mmc=AdieSEM_Google_PLA-_-PMax-CatchAll-M-_--_--_-dv%3AeCom&cm_mmc1=PE&cm_mmc2=PLA-Multiple-B%C3%A1squet-Other-None-PE-LATAM-eCom-Paid_Search&cm_mmca1=PE&cm_mmca2=&gclid=Cj0KCQiA4OybBhCzARIsAIcfn9mfIMRC6FfHAjjcFM3XULvCwFe5tgVwYMpFtWaOAYvDCDdD_Q8d9YkaAo9wEALw_wcB&gclsrc=aw.ds', 1, 'Zapatilla Adidas', '2022-11-21 17:00:03', 0),
(7, 9, 4, 'Compre este perfume y tiene un aroma muy bajo, cada vez que me hecho solo tiene un aroma de 10 minutos después desaparece. No lo recomiendo.', 'https://http2.mlstatic.com/D_NQ_NP_756273-MLA51088086973_082022-O.webp', 'https://www.mercadolibre.com.pe/lbel-bleu-intense-eau-de-toilette-100ml-para-hombre/p/MPE3820250?pdp_filters=category:MPE1271#searchVariation=MPE3820250&position=1&search_layout=stack&type=product&tracking_id=118f65a1-1d49-4590-93a4-5def6d19e7e0', 1, 'Perfume Bleu Intense', '2022-05-10 17:02:38', 0),
(8, 13, 11, 'Si buscas un buen producto de limpieza, te recomiendo el limpiatodo POETT te deja un buen aroma en tu hogar y a precio accesible ', 'https://plazavea.vteximg.com.br/arquivos/ids/14237925-1000-1000/20236198.jpg', 'https://www.plazavea.com.pe/limpiador-poett-frescura-de-lavanda-botella-3-8l/p', 1, 'Limpiatodo poett', '2022-10-20 10:11:38', 0),
(9, 3, 14, 'Leche gloria descremada super recomendada,  aporta proteínas de alta calidad y minerales como el calcio y el fósforo.', 'https://plazavea.vteximg.com.br/arquivos/ids/561939-1000-1000/20198433.jpg', 'https://www.plazavea.com.pe/leche-gloria-uht-light-bolsa-900ml/p', 1, 'Leche Gloria UHT Light', '2022-06-15 05:23:34', 0),
(10, 15, 16, 'Si te gusta pintar, colores Prismacolor es tu mejor opcion, 150 lapices de colores a un gran precio.', 'https://http2.mlstatic.com/D_NQ_NP_853989-MPE50853562420_072022-O.webp', 'https://articulo.mercadolibre.com.pe/MPE-615502338-prismacolor-premier-150-lapices-de-colores-profesionales-_JM#position=1&search_layout=stack&type=item&tracking_id=6e91e0fb-233a-4246-8b9d-36c07b5fdf9b', 1, 'Colores PrismaColor', '2022-11-01 17:29:53', 0),
(11, 8, 12, 'Videojuego super recomendado si eres fan de pokemon, lo unico malo son los graficos, despues todo gucci. ', 'https://i.linio.com/p/e3a308aef95e65550b9eaed35228ffb6-product.webp', 'https://www.linio.com.pe/p/pokemon-scarlet-nintendo-switch-latam-oqd9yy?gclsrc=aw.ds&&adjust_t=1zira0_f1h7ws&adjust_google_network=x&adjust_google_placement=&adjust_campaign=LIPE-LAB-AO-INSTI-LOC00001-CatchAll-Ago22-GG-Pmax-Conversion-Smart&adjust_adgroup=&utm_term=&gclid=Cj0KCQiA4OybBhCzARIsAIcfn9lC_Lq64oW0IZT8QgE5m-cU9M7cQBoT0FJXIJ5KjPunRrXYfvDLA8YaArV1EALw_wcB', 1, 'Pokemon Scarlet', '2022-11-11 22:44:10', 0),
(12, 4, 17, 'Jabon Asepxia Carbón super recomendado para cuidar tu rostro o por si tienes granitos en la piel, puntos negros o manchas. A un increible precio para el alcance del bolsillo', 'https://dcuk1cxrnzjkh.cloudfront.net/imagesproducto/012230L.jpg', 'https://inkafarma.pe/producto/jabon-asepxia-carbon-detox/012230', 1, 'Jabon Asepxia Carbon', '2022-09-14 12:45:59', 0),
(13, 10, 11, 'Si tienes mal olor en los pies, te recomiendo este talco. Aparte de dejarte un buen aroma, te elimina las bacterias.', 'https://dcuk1cxrnzjkh.cloudfront.net/imagesproducto/011249L.jpg', 'https://inkafarma.pe/producto/talco-para-pies-triple-accion-isana/011249', 1, 'Talco para pies', '2022-04-13 13:49:11', 0),
(14, 12, 6, 'Compre estas sombras de Natura super mala, no la recomiendo, me comenzaron a salir manchas en el rostro.', 'https://staticpe.natura.com/sites/default/files/styles/medium/public/products/124005_1_7.jpg?itok=SxgDBIma', 'https://www.natura.com.pe/p/regalo-faces-sombras/124005pe', 1, 'Faces Sombras', '2022-08-10 21:54:03', 0),
(15, 13, 12, 'Buenas gente de Squawk, hoy vengo a recomendarle este grandioso juego en 4k a un increíble precio. De regalo un polo, cómpralo en el siguiente link.', 'https://plazavea.vteximg.com.br/arquivos/ids/16765004-1000-1000/image-79ac3230e4ec4418bc3105c1cac2d09e.jpg', 'https://www.plazavea.com.pe/god-of-war-ragnarok-polo-l-playstation-4-latam-100483567/p?gclid=Cj0KCQiA4OybBhCzARIsAIcfn9mqgJnaULmPAacgwRs029JMwOeGjYCCKCyZQlWrLjP0fu0iZ5C-GCoaAowoEALw_wcB', 1, 'God Of War Ragnarok', '2022-10-12 15:56:20', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dislike_cuack`
--

CREATE TABLE `dislike_cuack` (
  `dislike_id` int(11) NOT NULL,
  `cuack_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `like_cuack`
--

CREATE TABLE `like_cuack` (
  `like_id` int(11) NOT NULL,
  `cuack_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tags`
--

CREATE TABLE `tags` (
  `tag_id` int(11) NOT NULL,
  `description` varchar(320) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `tags`
--

INSERT INTO `tags` (`tag_id`, `description`) VALUES
(1, 'Electrodomesticos'),
(2, 'Vestimenta'),
(3, 'Perfumes'),
(4, 'Juguetes'),
(5, 'Cereales'),
(6, 'Cosmeticos'),
(7, 'Alimentos'),
(8, 'Refrescos'),
(9, 'Menajes'),
(10, 'Adornos'),
(11, 'Limpieza'),
(12, 'Videojuegos'),
(13, 'Discos'),
(14, 'Lacteos '),
(15, 'Medicina'),
(16, 'Utiles escolares'),
(17, 'Higiene Personal');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users`
--

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL,
  `nickname` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(320) NOT NULL,
  `profile_picture` varchar(500) NOT NULL DEFAULT '/Avance_Squawk_Maven/profile_pictures/default.webp',
  `user_type` tinyint(5) NOT NULL,
  `status` tinyint(5) NOT NULL,
  `birthday` date NOT NULL,
  `creation_date` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `users`
--

INSERT INTO `users` (`user_id`, `nickname`, `password`, `email`, `profile_picture`, `user_type`, `status`, `birthday`, `creation_date`) VALUES
(1, 'elenanito69', '1234', 'elenanito69@gmail.com', '/Avance_Squawk_Maven\\profile_pictures\\maxresdefault.jpg', 1, 1, '1999-04-24', '2022-10-01 00:00:00'),
(2, 'Juan', 'juan1234!', 'juan@gmail.com', '/Avance_Squawk_Maven\\profile_pictures\\juan.jpg', 3, 1, '2003-06-07', '2022-10-10 00:00:00'),
(3, 'Sindell', 'sindell1', 'sindell1@gmail.com', '/Avance_Squawk_Maven\\profile_pictures\\sindell.jpg', 3, 1, '2002-09-16', '2022-10-12 00:00:00'),
(4, 'Joseph', '1234', 'josephcavero@gmail.com', '/Avance_Squawk_Maven\\profile_pictures\\joseph.jpg', 3, 1, '2002-12-12', '2022-10-12 00:00:00'),
(5, 'Leslly1', '1234', 'lepope@gmail.com', '/Avance_Squawk_Maven/profile_pictures/default.webp', 3, 1, '1989-01-01', '2022-10-12 00:00:00'),
(6, 'paco', '1234', 'paco@gmail.com', '/Avance_Squawk_Maven\\profile_pictures\\monito_viral.png', 1, 1, '2001-11-08', '2022-11-09 00:00:00'),
(7, 'Carlos', 'carlos123', 'carlos@gmail.com', '/Avance_Squawk_Maven/profile_pictures/default.webp', 1, 1, '2000-10-10', '2022-11-15 00:00:00'),
(8, 'Gianpierre', 'giampi123', 'giampierre@gmail.com', '/Avance_Squawk_Maven/profile_pictures/gian.jpg', 3, 1, '2001-12-20', '2022-11-15 00:00:00'),
(9, 'Hugo', 'hugo123', 'Hugo@gmail.com', '/Avance_Squawk_Maven/profile_pictures/default.webp', 1, 1, '1999-08-15', '2022-11-15 00:00:00'),
(10, 'Lucas', 'lucas123', 'Lucas@gmail.com', '/Avance_Squawk_Maven/profile_pictures/default.webp', 1, 1, '2000-04-30', '2022-11-15 00:00:00'),
(11, 'Sophia', 'sophia123', 'Sophia@gmail.com', '/Avance_Squawk_Maven/profile_pictures/default.webp', 1, 1, '1999-05-21', '2022-11-15 00:00:00'),
(12, 'Mia', 'mia123', 'Mia@gmail.com', '/Avance_Squawk_Maven/profile_pictures/default.webp', 1, 1, '2003-06-16', '2022-11-15 00:00:00'),
(13, 'Alejandro', 'alejandro123', 'Alejandro@gmail.com', '/Avance_Squawk_Maven/profile_pictures/default.webp', 1, 1, '1998-10-02', '2022-11-15 00:00:00'),
(14, 'Daniel', 'daniel123', 'Daniel@gmail.com', '/Avance_Squawk_Maven/profile_pictures/default.webp', 1, 1, '2000-07-28', '2022-11-15 00:00:00'),
(15, 'Adonis', 'adonis123', 'Adonis@gmail.com', '/Avance_Squawk_Maven/profile_pictures/default.webp', 1, 1, '1996-08-15', '2022-11-15 00:00:00'),
(16, 'Olivia', 'olivia123', 'Olivia@gmail.com', '/Avance_Squawk_Maven/profile_pictures/default.webp', 1, 1, '2003-02-09', '2022-11-15 00:00:00'),
(17, 'Martina', 'martina123', 'Martina@gmail.com', '/Avance_Squawk_Maven/profile_pictures/default.webp', 1, 1, '1997-07-29', '2022-11-15 00:00:00'),
(18, 'Diego', 'diego123', 'Diego@gmail.com', '/Avance_Squawk_Maven/profile_pictures/default.webp', 1, 1, '2000-06-16', '2022-11-15 00:00:00'),
(19, 'Alfonso', 'alfonso123', 'Alfonso@gmail.com', '/Avance_Squawk_Maven/profile_pictures/default.webp', 1, 1, '2001-10-21', '2022-11-15 00:00:00'),
(20, 'Cesar', 'cesar123', 'Cesar@gmail.com', '/Avance_Squawk_Maven/profile_pictures/default.webp', 1, 1, '1999-08-03', '2022-11-15 00:00:00');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cuacks`
--
ALTER TABLE `cuacks`
  ADD PRIMARY KEY (`cuack_id`),
  ADD KEY `tag_id` (`tag_id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indices de la tabla `dislike_cuack`
--
ALTER TABLE `dislike_cuack`
  ADD PRIMARY KEY (`dislike_id`),
  ADD KEY `cuack_id` (`cuack_id`,`user_id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indices de la tabla `like_cuack`
--
ALTER TABLE `like_cuack`
  ADD PRIMARY KEY (`like_id`),
  ADD KEY `cuack_id` (`cuack_id`,`user_id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indices de la tabla `tags`
--
ALTER TABLE `tags`
  ADD PRIMARY KEY (`tag_id`);

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
-- AUTO_INCREMENT de la tabla `cuacks`
--
ALTER TABLE `cuacks`
  MODIFY `cuack_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de la tabla `dislike_cuack`
--
ALTER TABLE `dislike_cuack`
  MODIFY `dislike_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `like_cuack`
--
ALTER TABLE `like_cuack`
  MODIFY `like_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tags`
--
ALTER TABLE `tags`
  MODIFY `tag_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT de la tabla `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cuacks`
--
ALTER TABLE `cuacks`
  ADD CONSTRAINT `cuacks_ibfk_1` FOREIGN KEY (`tag_id`) REFERENCES `tags` (`tag_id`),
  ADD CONSTRAINT `cuacks_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`);

--
-- Filtros para la tabla `dislike_cuack`
--
ALTER TABLE `dislike_cuack`
  ADD CONSTRAINT `dislike_cuack_ibfk_1` FOREIGN KEY (`cuack_id`) REFERENCES `cuacks` (`cuack_id`),
  ADD CONSTRAINT `dislike_cuack_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`);

--
-- Filtros para la tabla `like_cuack`
--
ALTER TABLE `like_cuack`
  ADD CONSTRAINT `like_cuack_ibfk_1` FOREIGN KEY (`cuack_id`) REFERENCES `cuacks` (`cuack_id`),
  ADD CONSTRAINT `like_cuack_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
