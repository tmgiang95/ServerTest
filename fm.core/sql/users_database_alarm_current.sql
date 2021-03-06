-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: users_database
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `alarm_current`
--

DROP TABLE IF EXISTS `alarm_current`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alarm_current` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `almid` int NOT NULL, --*
  `msg` varchar(500) NOT NULL, --
  `severity` int NOT NULL,
  `rptcnt` int NOT NULL, --
  `keygen` varchar(100) NOT NULL, --*
  `cretime` bigint NOT NULL,
  `lastchangetime` bigint NOT NULL, --
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alarm_current`
--

LOCK TABLES `alarm_current` WRITE;
/*!40000 ALTER TABLE `alarm_current` DISABLE KEYS */;
INSERT INTO `alarm_current` VALUES (9,123,'ALM_1111| node abc down',1,1,'1111_mss1',12345678,4567890),(10,123,'ALM_1111| node abc down',1,1,'1111_mss1',12345678,4567890),(11,123,'ALM_1111| node abc down',1,1,'1111_mss1',12345678,4567890),(12,123,'ALM_1111| node abc down',1,1,'1111_mss1',12345678,4567890),(14,123,'ALM_1111| node abc down',1,1,'1111_mss1',1584615917466,1584615917466),(21,2000,'ALM_1111| node abc down',1,1,'1111_mss1',1584946616556,1584946616556),(22,2000,'ALM_1111| node abc down',1,1,'1111_mss1',1584946633654,1584946633654),(23,2000,'ALM_1111| node abc down',1,1,'1111_mss1',1584946675219,1584946675219),(24,2000,'ALM_1111| node abc down',1,1,'1111_mss1',1584946698207,1584946698207),(31,2000,'ALM_1111| node abc down',1,1,'1111_mss1',1585038082345,1585038082345),(32,2000,'ALM_1111| node abc down',1,1,'1111_mss1',1585038125593,1585038125593),(33,2000,'ALM_1111| node abc down',1,1,'1111_mss1',1585038142704,1585038142704);
/*!40000 ALTER TABLE `alarm_current` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-03-24 15:24:26
