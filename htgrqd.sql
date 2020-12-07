-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th12 07, 2020 lúc 09:23 AM
-- Phiên bản máy phục vụ: 10.4.11-MariaDB
-- Phiên bản PHP: 7.2.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `htgrqd`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `mucdoquantrong`
--

CREATE TABLE `mucdoquantrong` (
  `id` int(11) NOT NULL,
  `tenTrieuChung` varchar(20) NOT NULL,
  `tenXung` varchar(15) NOT NULL,
  `tamQuanTrong` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `mucdoquantrong`
--

INSERT INTO `mucdoquantrong` (`id`, `tenTrieuChung`, `tenXung`, `tamQuanTrong`) VALUES
(1, 'heat wind', 'Substantive', 0.3),
(2, 'heat wind', 'Stringy', 0.5),
(3, 'heat wind', 'Superficial', 0.4),
(4, 'primary Allergy', 'Substantive', 0.7),
(5, 'primary Allergy', 'Superficial', 0.5);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `pulse`
--

CREATE TABLE `pulse` (
  `ten` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `pulse`
--

INSERT INTO `pulse` (`ten`) VALUES
('Abrupt'),
('Deep'),
('Deficiency'),
('Faint'),
('Firm'),
('Full'),
('Hidden'),
('Hollow'),
('Irregular'),
('Irregulary Intermittent'),
('Large'),
('Long'),
('Rapid'),
('Regulary Intermittent'),
('Scattered'),
('Short'),
('Slippery'),
('Slow'),
('Small'),
('Soft'),
('Stringy'),
('Substantive'),
('Superficial'),
('Swift'),
('Tense'),
('Throbbing'),
('Tympanic'),
('Weak');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `rules`
--

CREATE TABLE `rules` (
  `id` int(11) NOT NULL,
  `id_trieuChung` int(11) NOT NULL,
  `tenXung` varchar(30) NOT NULL,
  `tay` varchar(5) NOT NULL,
  `vitri` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `rules`
--

INSERT INTO `rules` (`id`, `id_trieuChung`, `tenXung`, `tay`, `vitri`) VALUES
(1, 1, 'Substantive', 'left', 'cun'),
(2, 1, 'Stringy', 'left', 'cun'),
(3, 1, 'Superficial', 'left', 'cun'),
(10, 2, 'Stringy', 'left', 'cun'),
(11, 3, 'Substantive', 'left', 'cun'),
(12, 4, 'Superficial', 'left', 'cun'),
(13, 5, 'Substantive', 'left', 'cun'),
(14, 5, 'Stringy', 'left', 'cun'),
(15, 6, 'Substantive', 'left', 'cun'),
(16, 6, 'Superficial', 'left', 'cun');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `trieuchung`
--

CREATE TABLE `trieuchung` (
  `id` int(11) NOT NULL,
  `ten` varchar(30) NOT NULL,
  `weight` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `trieuchung`
--

INSERT INTO `trieuchung` (`id`, `ten`, `weight`) VALUES
(1, 'heat wind', 1),
(2, 'heat wind', 0.3),
(3, 'heat wind', 0.4),
(4, 'heat wind', 0.2),
(5, 'blood heart', 0.7),
(6, 'primary Allergy', 0.6);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `trieuchungds`
--

CREATE TABLE `trieuchungds` (
  `ten` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `trieuchungds`
--

INSERT INTO `trieuchungds` (`ten`) VALUES
('arm pain'),
('blood heart'),
('face paralytics'),
('heat wind'),
('primary Allergy'),
('voice loss');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `mucdoquantrong`
--
ALTER TABLE `mucdoquantrong`
  ADD PRIMARY KEY (`id`),
  ADD KEY `tenTrieuChung` (`tenTrieuChung`),
  ADD KEY `tenXung` (`tenXung`);

--
-- Chỉ mục cho bảng `pulse`
--
ALTER TABLE `pulse`
  ADD PRIMARY KEY (`ten`);

--
-- Chỉ mục cho bảng `rules`
--
ALTER TABLE `rules`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_trieuChung` (`id_trieuChung`),
  ADD KEY `id_xung` (`tenXung`);

--
-- Chỉ mục cho bảng `trieuchung`
--
ALTER TABLE `trieuchung`
  ADD PRIMARY KEY (`id`),
  ADD KEY `ten` (`ten`);

--
-- Chỉ mục cho bảng `trieuchungds`
--
ALTER TABLE `trieuchungds`
  ADD PRIMARY KEY (`ten`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `mucdoquantrong`
--
ALTER TABLE `mucdoquantrong`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `rules`
--
ALTER TABLE `rules`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT cho bảng `trieuchung`
--
ALTER TABLE `trieuchung`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `mucdoquantrong`
--
ALTER TABLE `mucdoquantrong`
  ADD CONSTRAINT `mucdoquantrong_ibfk_1` FOREIGN KEY (`tenXung`) REFERENCES `pulse` (`ten`),
  ADD CONSTRAINT `mucdoquantrong_ibfk_2` FOREIGN KEY (`tenTrieuChung`) REFERENCES `trieuchungds` (`ten`);

--
-- Các ràng buộc cho bảng `rules`
--
ALTER TABLE `rules`
  ADD CONSTRAINT `rules_ibfk_2` FOREIGN KEY (`id_trieuChung`) REFERENCES `trieuchung` (`id`),
  ADD CONSTRAINT `rules_ibfk_3` FOREIGN KEY (`tenXung`) REFERENCES `pulse` (`ten`);

--
-- Các ràng buộc cho bảng `trieuchung`
--
ALTER TABLE `trieuchung`
  ADD CONSTRAINT `trieuchung_ibfk_1` FOREIGN KEY (`ten`) REFERENCES `trieuchungds` (`ten`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
