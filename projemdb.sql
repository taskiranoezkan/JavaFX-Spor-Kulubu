-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 03 Haz 2022, 20:38:25
-- Sunucu sürümü: 10.4.24-MariaDB
-- PHP Sürümü: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `projemdb`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `branslar`
--

CREATE TABLE `branslar` (
  `id` int(11) NOT NULL,
  `brans_adi` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `ayrilan_tutar` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `tarih` varchar(50) COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `branslar`
--

INSERT INTO `branslar` (`id`, `brans_adi`, `ayrilan_tutar`, `tarih`) VALUES
(2, 'Futbol', '4500', '02.06.2022'),
(3, 'Basketbol', '7500', '02.06.2022'),
(27, 'voleybol', '5600', '02'),
(28, 'basketbol', '3700', '02'),
(29, 'yüzme', '8500', '05');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `istatistikler`
--

CREATE TABLE `istatistikler` (
  `id` int(11) NOT NULL,
  `brans` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `sezon` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `basari` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `parlayanoyuncu` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `puan` varchar(50) COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `istatistikler`
--

INSERT INTO `istatistikler` (`id`, `brans`, `sezon`, `basari`, `parlayanoyuncu`, `puan`) VALUES
(1, 'Voleybol', '2021-2022', 'en iyi oyuncu', 'Neslihan Darnel', '75'),
(17, 'Futbol', '2021', 'En iyi oyuncu', 'Halil', '90'),
(19, 'futbol', '2021', 'en iyi orta saha', 'kerem', '65'),
(20, 'futbol', '2021', 'en iyi oyunucu', 'kerem', '100'),
(21, 'futbol', '2022', 'oyun kuruucu', 'hakan', '89');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `login`
--

CREATE TABLE `login` (
  `id` int(100) NOT NULL,
  `isim` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `soyisim` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `kullanici_adi` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `sifre` varchar(50) COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `login`
--

INSERT INTO `login` (`id`, `isim`, `soyisim`, `kullanici_adi`, `sifre`) VALUES
(54, '', '', 'admin', '0000'),
(57, 'Özkan', 'Taşkıran', 'tskrn', '0000');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `oyuncular`
--

CREATE TABLE `oyuncular` (
  `id` int(11) NOT NULL,
  `brans_adi` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `oyuncu_adsoyad` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `cinsiyet` varchar(5) COLLATE utf8_turkish_ci NOT NULL,
  `yas` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `mevki` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `tarih` varchar(50) COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `oyuncular`
--

INSERT INTO `oyuncular` (`id`, `brans_adi`, `oyuncu_adsoyad`, `cinsiyet`, `yas`, `mevki`, `tarih`) VALUES
(1, 'Futbol', 'Semih Şentürk', 'Erkek', '22', 'Santrafor', '2.06.2022'),
(3, 'Basketbol', 'Hidayet Türkoğlu', 'Erkek', '22', 'Forvet', '02.06.2022'),
(4, 'Voleybol', 'Neslihan Darnel', 'Kadın', '22', 'Pasör Çaprazı', '02.06.2022'),
(5, 'Basketbol', 'Cedi Osman', 'Erkek', '22', 'Uzun Forvet', '02.12.2021'),
(13, 'Futbol', 'arda turan', 'erkek', '35', 'orta saha', '15'),
(14, 'voleybool', 'neslihan', 'kadın', '25', 'pasör', '45');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `oyunculargoster`
--

CREATE TABLE `oyunculargoster` (
  `id` int(11) NOT NULL,
  `brans` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `oyuncu` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `yas` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `mevki` varchar(50) COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `sponsorlar`
--

CREATE TABLE `sponsorlar` (
  `id` int(11) NOT NULL,
  `sponsor_adi` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `destek_oldugu_brans` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `gelir_beklentisi` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `tarih` varchar(50) COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `sponsorlar`
--

INSERT INTO `sponsorlar` (`id`, `sponsor_adi`, `destek_oldugu_brans`, `gelir_beklentisi`, `tarih`) VALUES
(1, 'Nike', 'Futbol', '10000', '02.06.2022'),
(3, 'Adidas', 'Futbol', '20000', '02.06.2022'),
(11, 'Ülker', 'Futbol', '750000', '01.01.1985'),
(12, 'Nef', 'Futbol', '5500', '02.02.02'),
(15, 'puma', 'basketbol', '4500', '65');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `teknikekipler`
--

CREATE TABLE `teknikekipler` (
  `id` int(11) NOT NULL,
  `brans_adi` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `rol` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `tarih` varchar(50) COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `teknikekipler`
--

INSERT INTO `teknikekipler` (`id`, `brans_adi`, `rol`, `tarih`) VALUES
(1, 'Voleybol', 'Koç', '02.06.2022'),
(8, 'basketbol', 'teknik direktör', '02.05.1999'),
(11, 'basketbol', 'koç', '09');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `yonetici`
--

CREATE TABLE `yonetici` (
  `id` int(100) NOT NULL,
  `ad_soyad` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `telefon` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `kullanici_adi` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `sifre` varchar(50) COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `yonetici`
--

INSERT INTO `yonetici` (`id`, `ad_soyad`, `telefon`, `kullanici_adi`, `sifre`) VALUES
(1, '', '', 'admin', '0000'),
(27, 'özkan taşkıran', '5655', 'tskrn', '1111');

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `branslar`
--
ALTER TABLE `branslar`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `istatistikler`
--
ALTER TABLE `istatistikler`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `oyuncular`
--
ALTER TABLE `oyuncular`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `oyunculargoster`
--
ALTER TABLE `oyunculargoster`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `sponsorlar`
--
ALTER TABLE `sponsorlar`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `teknikekipler`
--
ALTER TABLE `teknikekipler`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `yonetici`
--
ALTER TABLE `yonetici`
  ADD PRIMARY KEY (`id`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `branslar`
--
ALTER TABLE `branslar`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- Tablo için AUTO_INCREMENT değeri `istatistikler`
--
ALTER TABLE `istatistikler`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- Tablo için AUTO_INCREMENT değeri `login`
--
ALTER TABLE `login`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=58;

--
-- Tablo için AUTO_INCREMENT değeri `oyuncular`
--
ALTER TABLE `oyuncular`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- Tablo için AUTO_INCREMENT değeri `oyunculargoster`
--
ALTER TABLE `oyunculargoster`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Tablo için AUTO_INCREMENT değeri `sponsorlar`
--
ALTER TABLE `sponsorlar`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- Tablo için AUTO_INCREMENT değeri `teknikekipler`
--
ALTER TABLE `teknikekipler`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Tablo için AUTO_INCREMENT değeri `yonetici`
--
ALTER TABLE `yonetici`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
