-- phpMyAdmin SQL Dump
-- version 5.2.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Waktu pembuatan: 18 Jul 2026 pada 12.11
-- Versi server: 10.4.32-MariaDB
-- Versi PHP: 8.4.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Basis data: `db_pengaduan`
--

DELIMITER $$
--
-- Prosedur
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `tambah_pengaduan` (IN `p_nama_pelapor` VARCHAR(100), IN `p_isi_pengaduan` TEXT)   BEGIN
    INSERT INTO pengaduan (nama_pelapor, isi_pengaduan, status)
    VALUES (p_nama_pelapor, p_isi_pengaduan, 'Baru');
END$$

--
-- Fungsi
--
CREATE DEFINER=`root`@`localhost` FUNCTION `total_pengaduan` () RETURNS INT(11) DETERMINISTIC BEGIN
    DECLARE jumlah INT;
    SELECT COUNT(*) INTO jumlah FROM pengaduan;
    RETURN jumlah;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Struktur dari tabel `pengaduan`
--

CREATE TABLE `pengaduan` (
  `id_pengaduan` int(11) NOT NULL,
  `nama_pelapor` varchar(100) NOT NULL,
  `isi_pengaduan` text NOT NULL,
  `status` varchar(20) DEFAULT 'Baru'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `pengaduan`
--

INSERT INTO `pengaduan` (`id_pengaduan`, `nama_pelapor`, `isi_pengaduan`, `status`) VALUES
(2, 'Rudi', 'pohon tumbang ke jalan raya', 'Diproses'),
(3, 'Siti Aminah', 'longsor dekat sungai mataram', 'Baru'),
(5, 'shelva ', 'jembatan putus', 'Baru');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tanggapan`
--

CREATE TABLE `tanggapan` (
  `id_tanggapan` int(11) NOT NULL,
  `id_pengaduan` int(11) NOT NULL,
  `isi_tanggapan` text NOT NULL,
  `tanggal_tanggapan` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `tanggapan`
--

INSERT INTO `tanggapan` (`id_tanggapan`, `id_pengaduan`, `isi_tanggapan`, `tanggal_tanggapan`) VALUES
(4, 2, 'minggu depan akan ada pengaspalan', '2026-07-18 10:07:35'),
(5, 2, 'pemadam kebakaran akan segera datang', '2026-07-18 11:53:35');

--
-- Trigger `tanggapan`
--
DELIMITER $$
CREATE TRIGGER `trg_update_status` AFTER INSERT ON `tanggapan` FOR EACH ROW BEGIN
    UPDATE pengaduan
    SET status = 'Diproses'
    WHERE id_pengaduan = NEW.id_pengaduan;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Stand-in struktur untuk tampilan `v_data_pengaduan`
-- (Lihat di bawah untuk tampilan aktual)
--
CREATE TABLE `v_data_pengaduan` (
`id_pengaduan` int(11)
,`nama_pelapor` varchar(100)
,`isi_pengaduan` text
,`status` varchar(20)
,`isi_tanggapan` text
,`tanggal_tanggapan` timestamp
);

--
-- Indeks untuk tabel yang dibuang
--

--
-- Indeks untuk tabel `pengaduan`
--
ALTER TABLE `pengaduan`
  ADD PRIMARY KEY (`id_pengaduan`);

--
-- Indeks untuk tabel `tanggapan`
--
ALTER TABLE `tanggapan`
  ADD PRIMARY KEY (`id_tanggapan`),
  ADD KEY `id_pengaduan` (`id_pengaduan`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `pengaduan`
--
ALTER TABLE `pengaduan`
  MODIFY `id_pengaduan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT untuk tabel `tanggapan`
--
ALTER TABLE `tanggapan`
  MODIFY `id_tanggapan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

-- --------------------------------------------------------

--
-- Struktur untuk view `v_data_pengaduan`
--
DROP TABLE IF EXISTS `v_data_pengaduan`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_data_pengaduan`  AS SELECT `p`.`id_pengaduan` AS `id_pengaduan`, `p`.`nama_pelapor` AS `nama_pelapor`, `p`.`isi_pengaduan` AS `isi_pengaduan`, `p`.`status` AS `status`, `t`.`isi_tanggapan` AS `isi_tanggapan`, `t`.`tanggal_tanggapan` AS `tanggal_tanggapan` FROM (`pengaduan` `p` left join `tanggapan` `t` on(`p`.`id_pengaduan` = `t`.`id_pengaduan`)) ORDER BY `p`.`id_pengaduan` ASC ;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `tanggapan`
--
ALTER TABLE `tanggapan`
  ADD CONSTRAINT `tanggapan_ibfk_1` FOREIGN KEY (`id_pengaduan`) REFERENCES `pengaduan` (`id_pengaduan`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
