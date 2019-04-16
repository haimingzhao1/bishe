-- MySQL dump 10.13  Distrib 5.7.25, for macos10.14 (x86_64)
--
-- Host: localhost    Database: bishe
-- ------------------------------------------------------
-- Server version	5.7.25-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin_book`
--
use bishe;
DROP TABLE IF EXISTS `admin_book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin_book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `add_time` varchar(255) DEFAULT NULL,
  `book_id` int(11) DEFAULT NULL,
  `add_number` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_ID3` (`book_id`),
  CONSTRAINT `FK_ID3` FOREIGN KEY (`book_id`) REFERENCES `t_book` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin_book`
--

LOCK TABLES `admin_book` WRITE;
/*!40000 ALTER TABLE `admin_book` DISABLE KEYS */;
/*!40000 ALTER TABLE `admin_book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `b_sort`
--

DROP TABLE IF EXISTS `b_sort`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `b_sort` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sort_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `b_sort`
--

LOCK TABLES `b_sort` WRITE;
/*!40000 ALTER TABLE `b_sort` DISABLE KEYS */;
/*!40000 ALTER TABLE `b_sort` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `b_stock`
--

DROP TABLE IF EXISTS `b_stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `b_stock` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stock` int(11) DEFAULT NULL,
  `book_id` int(11) DEFAULT NULL,
  `admin_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_ID` (`book_id`),
  KEY `FK_ID1` (`admin_id`),
  CONSTRAINT `FK_ID` FOREIGN KEY (`book_id`) REFERENCES `t_book` (`id`),
  CONSTRAINT `FK_ID1` FOREIGN KEY (`admin_id`) REFERENCES `t_admin` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `b_stock`
--

LOCK TABLES `b_stock` WRITE;
/*!40000 ALTER TABLE `b_stock` DISABLE KEYS */;
/*!40000 ALTER TABLE `b_stock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_admin`
--

DROP TABLE IF EXISTS `t_admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(255) NOT NULL,
  `admin_pass` varchar(255) NOT NULL,
  `admin_phone` varchar(255) DEFAULT NULL,
  `job_number` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_admin`
--

LOCK TABLES `t_admin` WRITE;
/*!40000 ALTER TABLE `t_admin` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_book`
--

DROP TABLE IF EXISTS `t_book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `book_number` varchar(255) NOT NULL,
  `book_name` varchar(255) NOT NULL,
  `book_author` varchar(255) NOT NULL,
  `book_ press` varchar(255) NOT NULL,
  `book_createtime` varchar(255) DEFAULT NULL,
  `book_ summary` varchar(255) DEFAULT NULL,
  `book_remark` varchar(255) DEFAULT NULL,
  `ebook` varchar(255) DEFAULT NULL,
  `sort_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_ID4` (`sort_id`),
  CONSTRAINT `FK_ID4` FOREIGN KEY (`sort_id`) REFERENCES `b_sort` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_book`
--

LOCK TABLES `t_book` WRITE;
/*!40000 ALTER TABLE `t_book` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_borrow`
--

DROP TABLE IF EXISTS `t_borrow`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_borrow` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  `borrow_date` varchar(255) DEFAULT NULL,
  `also_date` varchar(255) DEFAULT NULL,
  `is_also` int(11) NOT NULL,
  `is_continue` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_ID5` (`user_id`),
  KEY `FK_ID6` (`book_id`),
  CONSTRAINT `FK_ID5` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`),
  CONSTRAINT `FK_ID6` FOREIGN KEY (`book_id`) REFERENCES `t_book` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_borrow`
--

LOCK TABLES `t_borrow` WRITE;
/*!40000 ALTER TABLE `t_borrow` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_borrow` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_discipline`
--

DROP TABLE IF EXISTS `t_discipline`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_discipline` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `discipline_name` int(11) NOT NULL,
  `discipline_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_ID2` (`discipline_id`),
  CONSTRAINT `FK_ID2` FOREIGN KEY (`discipline_id`) REFERENCES `t_discipline` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_discipline`
--

LOCK TABLES `t_discipline` WRITE;
/*!40000 ALTER TABLE `t_discipline` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_discipline` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user`
--

DROP TABLE IF EXISTS `t_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_number` varchar(255) NOT NULL,
  `stu_name` varchar(255) NOT NULL,
  `gender` int(11) DEFAULT NULL,
  `stu_phone` varchar(255) DEFAULT NULL,
  `discipline_id` int(11) NOT NULL,
  `count` int(11) DEFAULT NULL,
  `is_vip` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_ID7` (`discipline_id`),
  CONSTRAINT `FK_ID7` FOREIGN KEY (`discipline_id`) REFERENCES `t_discipline` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user`
--

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-16 15:12:06
