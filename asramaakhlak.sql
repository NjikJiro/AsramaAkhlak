-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 31, 2025 at 04:36 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `asramaakhlak`
--

-- --------------------------------------------------------

--
-- Table structure for table `cctv`
--

CREATE TABLE `cctv` (
  `id_cctv` int(11) NOT NULL,
  `lokasi` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `galeri`
--

CREATE TABLE `galeri` (
  `id_galeri` int(11) NOT NULL,
  `nama_file` varchar(255) NOT NULL,
  `deskripsi` text DEFAULT NULL,
  `id_user` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `inventaris_asrama`
--

CREATE TABLE `inventaris_asrama` (
  `id_inventaris` int(11) NOT NULL,
  `nama_barang` varchar(100) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `kondisi` enum('Baik','Rusak','Perlu Perbaikan') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `log_kehadiran`
--

CREATE TABLE `log_kehadiran` (
  `id_log` int(11) NOT NULL,
  `waktu` datetime NOT NULL,
  `status` enum('Masuk','Keluar') NOT NULL,
  `id_user` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `pengaduan`
--

CREATE TABLE `pengaduan` (
  `id_pengaduan` int(11) NOT NULL,
  `isi` text NOT NULL,
  `status` enum('Diterima','Diproses','Selesai','Dibatalkan') NOT NULL DEFAULT 'Diterima',
  `id_user` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pengaduan`
--

INSERT INTO `pengaduan` (`id_pengaduan`, `isi`, `status`, `id_user`) VALUES
(1, 'Lampu kamar mati sejak semalam', 'Diterima', 1),
(2, 'AC kamar tidak dingin', 'Diproses', 2),
(3, 'Keran kamar mandi bocor', 'Diterima', 3),
(4, 'Pintu kamar rusak dan sulit dikunci', 'Selesai', 4),
(5, 'Wifi asrama lambat di lantai 2', 'Dibatalkan', 1),
(6, 'Yosep bau tai', 'Diterima', 1),
(7, 'sdsdasdasd', 'Diterima', 1);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id_user` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `kamar` varchar(20) DEFAULT NULL,
  `jurusan` varchar(100) DEFAULT NULL,
  `asal` varchar(100) DEFAULT NULL,
  `no_telepon` varchar(20) NOT NULL,
  `role` enum('Penghuni','Penjaga','Admin') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id_user`, `username`, `password`, `nama`, `kamar`, `jurusan`, `asal`, `no_telepon`, `role`) VALUES
(1, 'mhs001', 'mhs123', 'Adyadma Renjiro', 'A-12', 'Rekayasa Perangkat Lunak', 'Pekanbaru', '083333333333', 'Penghuni'),
(2, 'mhs002', 'mhs123', 'Yosep Batak', 'B-07', 'Informatika', 'Malang', '084444444444', 'Penghuni'),
(3, 'mhs003', 'mhs123', 'Rozi Imut', 'C-03', 'Sistem Informasi', 'Bandung', '085555555555', 'Penghuni'),
(4, 'ahmad01', '12345', 'Ahmad Fauzi', 'A101', 'Informatika', 'Surabaya', '081234567801', 'Penghuni'),
(5, 'budi02', '12345', 'Budi Santoso', 'A102', 'Sistem Informasi', 'Malang', '081234567802', 'Penghuni'),
(6, 'andi03', '12345', 'Andi Pratama', 'A103', 'Rekayasa Perangkat Lunak', 'Sidoarjo', '081234567803', 'Penghuni'),
(7, 'rizki04', '12345', 'Rizki Ramadhan', 'B201', 'Informatika', 'Gresik', '081234567804', 'Penghuni'),
(8, 'fajar05', '12345', 'Fajar Maulana', 'B202', 'Teknik Komputer', 'Lamongan', '081234567805', 'Penghuni'),
(9, 'dimas06', '12345', 'Dimas Saputra', 'B203', 'Sistem Informasi', 'Tuban', '081234567806', 'Penghuni'),
(10, 'admin01', 'admin123', 'Hendra Wijaya', '-', 'Manajemen Asrama', 'Surabaya', '081234567807', 'Admin'),
(11, 'admin02', 'admin123', 'Agus Setiawan', '-', 'Manajemen Asrama', 'Malang', '081234567808', 'Admin'),
(12, 'penjaga02', 'penjaga123', 'Eko Prasetyo', '-', 'Keamanan Asrama', 'Sidoarjo', '081234567810', 'Admin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cctv`
--
ALTER TABLE `cctv`
  ADD PRIMARY KEY (`id_cctv`);

--
-- Indexes for table `galeri`
--
ALTER TABLE `galeri`
  ADD PRIMARY KEY (`id_galeri`),
  ADD KEY `fk_galeri_user` (`id_user`);

--
-- Indexes for table `inventaris_asrama`
--
ALTER TABLE `inventaris_asrama`
  ADD PRIMARY KEY (`id_inventaris`);

--
-- Indexes for table `log_kehadiran`
--
ALTER TABLE `log_kehadiran`
  ADD PRIMARY KEY (`id_log`),
  ADD KEY `fk_log_user` (`id_user`);

--
-- Indexes for table `pengaduan`
--
ALTER TABLE `pengaduan`
  ADD PRIMARY KEY (`id_pengaduan`),
  ADD KEY `fk_pengaduan_user` (`id_user`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`),
  ADD UNIQUE KEY `username` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cctv`
--
ALTER TABLE `cctv`
  MODIFY `id_cctv` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `galeri`
--
ALTER TABLE `galeri`
  MODIFY `id_galeri` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `inventaris_asrama`
--
ALTER TABLE `inventaris_asrama`
  MODIFY `id_inventaris` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `log_kehadiran`
--
ALTER TABLE `log_kehadiran`
  MODIFY `id_log` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `pengaduan`
--
ALTER TABLE `pengaduan`
  MODIFY `id_pengaduan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `galeri`
--
ALTER TABLE `galeri`
  ADD CONSTRAINT `fk_galeri_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `log_kehadiran`
--
ALTER TABLE `log_kehadiran`
  ADD CONSTRAINT `fk_log_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `pengaduan`
--
ALTER TABLE `pengaduan`
  ADD CONSTRAINT `fk_pengaduan_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
