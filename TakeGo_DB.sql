-- phpMyAdmin SQL Dump
-- version 4.6.6
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jan 25, 2018 at 10:18 AM
-- Server version: 5.5.52-MariaDB
-- PHP Version: 5.6.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `TakeGo_DB`
--

-- --------------------------------------------------------

--
-- Table structure for table `branch_table`
--

CREATE TABLE `branch_table` (
  `branchNumber` int(30) NOT NULL,
  `parking_spaces` int(255) NOT NULL,
  `city` varchar(30) NOT NULL,
  `street` varchar(30) NOT NULL,
  `number` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=hebrew;

--
-- Dumping data for table `branch_table`
--

INSERT INTO `branch_table` (`branchNumber`, `parking_spaces`, `city`, `street`, `number`) VALUES
(123, 540, 'Jerusalem', 'Beit HaDfus', 23),
(468, 212, 'Tel Aviv', 'azriel', 6),
(911, 666, 'Haifa', 'Herzel', 19),
(34243, 874, 'Jerusalem', 'Yafo', 3);

-- --------------------------------------------------------

--
-- Table structure for table `carModel_table`
--

CREATE TABLE `carModel_table` (
  `modelCode` varchar(30) NOT NULL,
  `company` varchar(30) NOT NULL,
  `modelName` varchar(30) NOT NULL,
  `EngineCapacity` varchar(30) NOT NULL,
  `gear` enum('AUTOMATIC','MANUAL') NOT NULL DEFAULT 'MANUAL',
  `SeatingCapacity` int(30) NOT NULL,
  `DoorsNumber` int(20) NOT NULL,
  `emptyMass` varchar(30) NOT NULL,
  `fuel` varchar(30) NOT NULL,
  `engine_type` varchar(30) NOT NULL,
  `turbo` enum('YES','NO') NOT NULL DEFAULT 'NO',
  `Lighted_makeup_mirror` enum('YES','NO') NOT NULL DEFAULT 'NO',
  `Digital_radio` enum('YES','NO') NOT NULL DEFAULT 'NO',
  `Panorama` enum('YES','NO') NOT NULL DEFAULT 'NO',
  `Driver_airbag` enum('YES','NO') NOT NULL DEFAULT 'NO',
  `Emergency_brake_assist` enum('YES','NO') NOT NULL DEFAULT 'NO',
  `Total_max_power` varchar(30) NOT NULL DEFAULT 'NO'
) ENGINE=InnoDB DEFAULT CHARSET=hebrew;

--
-- Dumping data for table `carModel_table`
--

INSERT INTO `carModel_table` (`modelCode`, `company`, `modelName`, `EngineCapacity`, `gear`, `SeatingCapacity`, `DoorsNumber`, `emptyMass`, `fuel`, `engine_type`, `turbo`, `Lighted_makeup_mirror`, `Digital_radio`, `Panorama`, `Driver_airbag`, `Emergency_brake_assist`, `Total_max_power`) VALUES
('121212', 'Honda', 'Honda Civic Tourer Elegance ', '104 Kw', 'MANUAL', 5, 5, '1188 kg', 'petrol', 'fuel engine', 'NO', 'YES', 'NO', 'NO', 'NO', 'NO', '104 Kw '),
('3147676', 'Mazda', 'Mazda MX-5 RF SkyActiv-G', '96 kW', 'MANUAL', 2, 2, '950 kg', 'petrol', 'fuel engine', 'NO', 'NO', 'NO', 'NO', 'YES', 'NO', '96 Kw'),
('3456', 'Audi', 'Audi R8 Coupe 5.2 FSI quattro ', '397 Kw ', 'AUTOMATIC', 2, 2, '1570 kg', 'petrol', 'fuel engine', 'YES', 'YES', 'NO', 'YES', 'YES', 'YES', '397 Kw '),
('87u', 'Alfa Romeo', 'o Alfa Romeo Stelvio 2.0T  ', '147 Kw ', 'MANUAL', 5, 5, 'dd', 'dgcgg', '1635 kg', 'YES', 'YES', 'NO', 'YES', 'YES', 'YES', '147 Kw '),
('8989', 'kia', 'Kia Picanto 1.0 CVVT ', '94 Nm', 'AUTOMATIC', 5, 3, '825 kg', 'petrol', 'fuel engine', 'NO', 'NO', 'NO', 'NO', 'YES', 'NO', '51 Kw '),
('91111', 'Skoda', 'Skoda Yeti Outdoor', '200 Nm', 'MANUAL', 5, 5, '1295 kg', 'petrol', 'fuel engine', 'YES', 'YES', 'NO', 'NO', 'NO', 'YES', '92 Kw');

-- --------------------------------------------------------

--
-- Table structure for table `car_table`
--

CREATE TABLE `car_table` (
  `carNumber` int(30) NOT NULL,
  `branchNumber` int(30) NOT NULL,
  `modelType` varchar(30) NOT NULL,
  `mileage` float NOT NULL,
  `occupied` enum('YES','NO') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=hebrew;

--
-- Dumping data for table `car_table`
--

INSERT INTO `car_table` (`carNumber`, `branchNumber`, `modelType`, `mileage`, `occupied`) VALUES
(1, 911, 'Isuzu', 1.4, 'YES'),
(2, 911, 'Citroen', 2.8, 'YES'),
(3, 123, 'Mazda', 7, 'YES'),
(7, 911, 'Lexus 4sw', 26.6, 'YES'),
(8, 123, 'Subaru', 65, 'YES'),
(9, 468, 'o Alfa Romeo Stelvio 2.0T  ', 9, 'YES'),
(56, 468, 'Citroen', 0, 'YES'),
(88, 468, 'Mercedes', 16.8, 'YES'),
(98, 911, 'Isuzu', 3.5, 'NO'),
(99, 468, 'Volvo', 12.9, 'YES'),
(136, 123, 'BMW', 4.9, 'YES'),
(223, 911, 'kia', 3.5, 'NO'),
(267, 468, 'Mercedes', 3.5, 'YES'),
(342, 911, 'Isuzu 2', 3.5, 'NO'),
(373, 911, 'Hyunday', 0, 'NO'),
(464, 911, 'Audi R8 Coupe 5.2 FSI quattro ', 0.9, 'YES'),
(475, 911, 'kia picanto', 3, 'YES'),
(544, 468, 'kia', 5.6, 'NO'),
(666, 911, 'Honda Civic Tourer Elegance ', 0, 'YES'),
(874, 468, 'Hyundai I20 Coupe', 7, 'YES'),
(877, 911, 'Isuzu', 0, 'NO'),
(998, 123, 'Citroen 2w3', 4.2, 'NO'),
(1112, 911, 'Kia Sportage', 7, 'NO'),
(3147, 123, 'Lexus', 2.8, 'NO'),
(3774, 123, 'Isuzu', 0, 'NO'),
(4345, 911, 'Kia', 0, 'NO'),
(9098, 911, 'Isuzu', 0, 'NO'),
(9646, 123, 'Kia picanto', 0, 'NO'),
(9656, 468, 'Kia 2w3', 23.8, 'YES'),
(12345, 911, 'Dodge', 2.8, 'NO'),
(36998, 123, 'Kia', 0, 'NO'),
(54576, 911, 'BMW 530d', 68.6, 'NO'),
(67543, 911, 'Kia', 0, 'NO'),
(90854, 911, 'Toyota', 0, 'NO'),
(99899, 123, 'Citroen 2w3', 99993, 'NO'),
(123456, 911, 'Citroen', 8, 'NO'),
(224335, 911, 'Kia', 5.6, 'NO'),
(678997, 911, 'kia', 0, 'NO'),
(1234567, 34243, 'BMW', 99998.6, 'YES'),
(12345678, 34243, 'Sedan', 8, 'YES'),
(13572322, 123, 'Mercedes', 0.7, 'NO'),
(123456789, 911, 'SUV', 8, 'YES'),
(2147483647, 911, 'hg', 4.2, 'NO');

-- --------------------------------------------------------

--
-- Table structure for table `client_table`
--

CREATE TABLE `client_table` (
  `_id` int(20) NOT NULL,
  `firstName` varchar(25) NOT NULL,
  `lastName` varchar(25) NOT NULL,
  `phoneNumber` varchar(12) NOT NULL,
  `mail` varchar(50) NOT NULL,
  `cardNumber` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=hebrew;

--
-- Dumping data for table `client_table`
--

INSERT INTO `client_table` (`_id`, `firstName`, `lastName`, `phoneNumber`, `mail`, `cardNumber`) VALUES
(124, 'Shani', 'Perez', '98', 'Aa@gmail.com', '34'),
(911, 'Shira', 'Cohen', '0509967543', 'cohen@gmail.com', '768'),
(1232, 'Shirly', 'ohanona', '0509975358', 'shirli@gmail.com', '112434'),
(12124, 'Shirly', 'Levi', '0908', 'S@gmail.com', '8'),
(28976, 'Michal', 'Levi', '0547865675', 'michal@gmail.com', '90876'),
(98866, 'Chani', 'Shpiner', '54898', 'chani23@gmail.com', '977887'),
(788788, 'Dani', 'Dekel', '6998', 'dani.34@gmail.com', '56'),
(989654, 'Avital', 'Nakash', '98', 'Avi@gmail.com', '3432');

-- --------------------------------------------------------

--
-- Table structure for table `course_table`
--

CREATE TABLE `course_table` (
  `_id` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `minGrade` tinyint(4) NOT NULL,
  `required` enum('false','true') NOT NULL DEFAULT 'false',
  `lecturerId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=hebrew;

--
-- Dumping data for table `course_table`
--

INSERT INTO `course_table` (`_id`, `name`, `minGrade`, `required`, `lecturerId`) VALUES
(101, 'java', 60, 'false', NULL),
(102, 'c++', 65, 'true', 444),
(103, 'OOP', 60, 'true', 444);

-- --------------------------------------------------------

--
-- Table structure for table `lecturer_table`
--

CREATE TABLE `lecturer_table` (
  `_id` int(11) NOT NULL,
  `name` varchar(25) NOT NULL,
  `phone` varchar(12) NOT NULL,
  `seniority` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=hebrew;

--
-- Dumping data for table `lecturer_table`
--

INSERT INTO `lecturer_table` (`_id`, `name`, `phone`, `seniority`) VALUES
(444, 'Shlomo', '0544434434', 1),
(666, 'Oshri', '0501341341', 8);

-- --------------------------------------------------------

--
-- Table structure for table `Login`
--

CREATE TABLE `Login` (
  `clientNumber` int(10) NOT NULL,
  `User` varchar(30) NOT NULL,
  `Password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Login`
--

INSERT INTO `Login` (`clientNumber`, `User`, `Password`) VALUES
(124, 'Shani', '876'),
(911, 'Shira', '147336'),
(1232, 'Sho', '147336'),
(12124, 'SA', '1'),
(28976, 'Mi', '6776'),
(98866, 'chani', '888'),
(989654, 'avit', '98'),
(314793912, '123', '123'),
(314793913, '123', '123'),
(314793914, '123', '123'),
(314793915, '123', '123'),
(314793916, '123', '123'),
(314793917, '123', '123'),
(314793918, '123', '123'),
(314793919, '123', '123'),
(314793920, '123', '123'),
(314793921, '123', '123'),
(314793922, '123', '123'),
(314793923, '123', '123'),
(314793924, '123', '123'),
(314793925, '123', '123'),
(314793926, '123', '123');

-- --------------------------------------------------------

--
-- Table structure for table `order_table`
--

CREATE TABLE `order_table` (
  `orderNumber` int(30) NOT NULL,
  `clientNumber` int(30) NOT NULL,
  `order` enum('OPEN','CLOSE') NOT NULL DEFAULT 'OPEN',
  `carNumber` int(30) NOT NULL,
  `rental_srart_date` varchar(30) NOT NULL,
  `rental_end_date` varchar(30) NOT NULL,
  `mileage_start_value` float NOT NULL,
  `mileage_end_value` float NOT NULL,
  `fuel_filling` enum('YES','NO') NOT NULL DEFAULT 'NO',
  `quantity_of_fuel` float DEFAULT NULL,
  `payment` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=hebrew;

--
-- Dumping data for table `order_table`
--

INSERT INTO `order_table` (`orderNumber`, `clientNumber`, `order`, `carNumber`, `rental_srart_date`, `rental_end_date`, `mileage_start_value`, `mileage_end_value`, `fuel_filling`, `quantity_of_fuel`, `payment`) VALUES
(87878911, 1232, 'CLOSE', 544, '01/22/2018 22:07:54', '01/22/2018 22:08:05', 0, 3.5, 'YES', 0, 0.06),
(87878912, 98866, 'CLOSE', 544, '01/22/2018 22:09:56', '01/22/2018 22:10:16', 3.5, 2.8, 'YES', 1, -6.08),
(87878913, 1232, 'CLOSE', 544, '01/23/2018 07:37:55', '01/23/2018 07:39:14', 2.8, 3.5, 'YES', 2, -12.03),
(87878914, 1232, 'CLOSE', 544, '01/23/2018 08:03:32', '01/23/2018 08:04:42', 3.5, 99999.3, 'YES', 2, 11770.7),
(87878915, 1232, 'CLOSE', 544, '01/23/2018 22:33:27', '01/23/2018 22:33:41', 99999.3, 5.6, 'YES', 0, -2356.52),
(87878916, 1232, 'CLOSE', 223, '01/23/2018 23:25:14', '01/23/2018 23:25:25', 0, 3.5, 'YES', 1, -6);

-- --------------------------------------------------------

--
-- Table structure for table `studentCourse_table`
--

CREATE TABLE `studentCourse_table` (
  `_id` int(11) NOT NULL,
  `studentId` int(11) NOT NULL,
  `courseId` int(11) NOT NULL,
  `regDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=hebrew;

--
-- Dumping data for table `studentCourse_table`
--

INSERT INTO `studentCourse_table` (`_id`, `studentId`, `courseId`, `regDate`) VALUES
(1, 1123, 101, '2014-02-12'),
(2, 1123, 102, '2014-02-12'),
(3, 4563, 101, '2014-03-13'),
(4, 5656, 103, '2014-12-13'),
(5, 5656, 101, '2014-12-15'),
(6, 1123, 101, '2014-12-15');

-- --------------------------------------------------------

--
-- Table structure for table `student_table`
--

CREATE TABLE `student_table` (
  `_id` int(11) NOT NULL,
  `name` varchar(25) NOT NULL,
  `phone` varchar(12) NOT NULL,
  `year` enum('a','b','c','d') NOT NULL DEFAULT 'a'
) ENGINE=InnoDB DEFAULT CHARSET=hebrew;

--
-- Dumping data for table `student_table`
--

INSERT INTO `student_table` (`_id`, `name`, `phone`, `year`) VALUES
(99, 'toto', '911', 'a'),
(345, 'Shirly', '0509975358', ''),
(999, 'trytry', '224', 'a'),
(1123, 'student 1', '054123', 'b'),
(4545, 'shushu', '676767', 'c'),
(4563, 'student 2', '050123', 'b'),
(5566, 'hjhhh', '7877', 'a'),
(5656, 'student 3', '050334', 'a'),
(7878, 'hjhj', '87878', 'a'),
(88887, 'hjh', '4444', 'a'),
(877788, 'jhhghhff', '909', 'a');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `branch_table`
--
ALTER TABLE `branch_table`
  ADD PRIMARY KEY (`branchNumber`);

--
-- Indexes for table `carModel_table`
--
ALTER TABLE `carModel_table`
  ADD PRIMARY KEY (`modelCode`);

--
-- Indexes for table `car_table`
--
ALTER TABLE `car_table`
  ADD PRIMARY KEY (`carNumber`),
  ADD KEY `car_table_ibfk_1` (`branchNumber`);

--
-- Indexes for table `client_table`
--
ALTER TABLE `client_table`
  ADD PRIMARY KEY (`_id`);

--
-- Indexes for table `course_table`
--
ALTER TABLE `course_table`
  ADD PRIMARY KEY (`_id`),
  ADD KEY `lecturerId` (`lecturerId`);

--
-- Indexes for table `lecturer_table`
--
ALTER TABLE `lecturer_table`
  ADD PRIMARY KEY (`_id`);

--
-- Indexes for table `Login`
--
ALTER TABLE `Login`
  ADD PRIMARY KEY (`clientNumber`);

--
-- Indexes for table `order_table`
--
ALTER TABLE `order_table`
  ADD PRIMARY KEY (`orderNumber`);

--
-- Indexes for table `studentCourse_table`
--
ALTER TABLE `studentCourse_table`
  ADD PRIMARY KEY (`_id`),
  ADD KEY `studentId` (`studentId`),
  ADD KEY `courseId` (`courseId`);

--
-- Indexes for table `student_table`
--
ALTER TABLE `student_table`
  ADD PRIMARY KEY (`_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `branch_table`
--
ALTER TABLE `branch_table`
  MODIFY `branchNumber` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=224332;
--
-- AUTO_INCREMENT for table `car_table`
--
ALTER TABLE `car_table`
  MODIFY `carNumber` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2147483648;
--
-- AUTO_INCREMENT for table `client_table`
--
ALTER TABLE `client_table`
  MODIFY `_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2147483648;
--
-- AUTO_INCREMENT for table `course_table`
--
ALTER TABLE `course_table`
  MODIFY `_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=104;
--
-- AUTO_INCREMENT for table `lecturer_table`
--
ALTER TABLE `lecturer_table`
  MODIFY `_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=667;
--
-- AUTO_INCREMENT for table `Login`
--
ALTER TABLE `Login`
  MODIFY `clientNumber` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=314793927;
--
-- AUTO_INCREMENT for table `order_table`
--
ALTER TABLE `order_table`
  MODIFY `orderNumber` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=87878917;
--
-- AUTO_INCREMENT for table `studentCourse_table`
--
ALTER TABLE `studentCourse_table`
  MODIFY `_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `student_table`
--
ALTER TABLE `student_table`
  MODIFY `_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=877789;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `car_table`
--
ALTER TABLE `car_table`
  ADD CONSTRAINT `car_table_ibfk_1` FOREIGN KEY (`branchNumber`) REFERENCES `branch_table` (`branchNumber`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `course_table`
--
ALTER TABLE `course_table`
  ADD CONSTRAINT `course_table_ibfk_1` FOREIGN KEY (`lecturerId`) REFERENCES `lecturer_table` (`_id`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Constraints for table `studentCourse_table`
--
ALTER TABLE `studentCourse_table`
  ADD CONSTRAINT `studentCourse_table_ibfk_2` FOREIGN KEY (`courseId`) REFERENCES `course_table` (`_id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `studentCourse_table_ibfk_1` FOREIGN KEY (`studentId`) REFERENCES `student_table` (`_id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
