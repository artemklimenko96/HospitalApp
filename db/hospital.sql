-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jan 25, 2017 at 02:17 PM
-- Server version: 10.1.16-MariaDB
-- PHP Version: 7.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hospital`
--

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `id` int(20) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `type` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`id`, `username`, `password`, `type`) VALUES
(5, 'a', 'a', 1),
(44, 'b', 'b', 0);

-- --------------------------------------------------------

--
-- Table structure for table `patient`
--

CREATE TABLE `patient` (
  `id` int(20) NOT NULL,
  `firstName` varchar(20) NOT NULL,
  `lastName` varchar(20) NOT NULL,
  `gender` tinyint(1) NOT NULL,
  `age` int(3) NOT NULL,
  `birthday` varchar(20) NOT NULL,
  `problem` text NOT NULL,
  `status` tinyint(1) NOT NULL,
  `room` int(10) NOT NULL,
  `assignedDoctor` int(20) NOT NULL,
  `vitalSignId` int(20) NOT NULL,
  `bloodPressure` int(8) NOT NULL,
  `breathRate` int(8) NOT NULL,
  `pulse` int(4) NOT NULL,
  `bodyTemp` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `patient`
--

INSERT INTO `patient` (`id`, `firstName`, `lastName`, `gender`, `age`, `birthday`, `problem`, `status`, `room`, `assignedDoctor`, `vitalSignId`, `bloodPressure`, `breathRate`, `pulse`, `bodyTemp`) VALUES
(3, 'three', 'fadf', 1, 45, '556-55', 'fgsdxhch', 1, 200, 123, 25, 85, 15, 65, 36),
(6, 'new', 'flow', 0, 45, '13-12-sfa', 'shalo', 0, 365, 5, 45, 34, 12, 76, 37),
(15, 'crazy', 'fast', 0, 30, '30-09-1996', 'Too fast', 0, 317, 5, 88, 120, 100, 30, 36),
(36, 'asf', 'asff', 1, 55, 'sfaf', 'afsfff', 1, 32, 25, 11, 25, 55, 77, 12),
(51, 'artem', 'klimeaaa', 0, 55, 'sfaf', 'afsfff', 0, 32, 5, 0, 0, 0, 0, 0),
(52, 'one', 'two ', 0, 44, 'ssf', 'asfaf', 0, 44, 5, 0, 0, 0, 0, 0),
(53, 'asf', 'fadg', 0, 22, 'birthdayhx', 'problem', 0, 58, 44, 0, 0, 0, 0, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `patient`
--
ALTER TABLE `patient`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=54;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
