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
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint NOT NULL,
  `created_at` datetime NOT NULL,
  `created_by` varchar(255) NOT NULL,
  `email_address` varchar(255) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `updated_at` datetime NOT NULL,
  `updated_by` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'2011-11-11 00:00:00','aaa','aa@gmail.com','admin1','admin2','2020-03-24 15:21:21','aaa'),(2,'2011-11-11 00:00:00','aaa','aa@gmail.com','a','b','2011-11-11 00:00:00','aaa'),(3,'2011-11-11 00:00:00','aaa','aa@gmail.com','a','b','2011-11-11 00:00:00','aaa'),(6,'2020-03-17 17:54:08','admin','admin@gmail.com','admin','admin','2020-03-17 17:54:08','admin'),(7,'2020-03-17 17:54:40','admin','admin@gmail.com','admin','admin','2020-03-17 17:54:40','admin'),(8,'2020-03-19 17:30:31','admin','admin@gmail.com','admin','admin','2020-03-19 17:30:31','admin'),(9,'2011-11-11 00:00:00','aaa','aa@gmail.com','a','b','2011-11-11 00:00:00','aaa'),(10,'2011-11-11 00:00:00','aaa','aa@gmail.com','a','b','2011-11-11 00:00:00','aaa'),(11,'2011-11-11 00:00:00','aaa','aa@gmail.com','a','b','2011-11-11 00:00:00','aaa'),(12,'2011-11-11 00:00:00','aaa','aa@gmail.com','a','b','2011-11-11 00:00:00','aaa'),(13,'2020-03-19 18:05:17','admin','admin@gmail.com','admin','admin','2020-03-19 18:05:17','admin'),(14,'2011-11-11 00:00:00','aaa','aa@gmail.com','a','b','2011-11-11 00:00:00','aaa'),(15,'2020-03-20 16:49:03','admin','admin@gmail.com','admin','admin','2020-03-20 16:49:03','admin'),(16,'2020-03-20 18:10:27','admin','admin@gmail.com','admin','admin','2020-03-20 18:10:27','admin'),(17,'2020-03-20 18:13:55','admin','admin@gmail.com','admin','admin','2020-03-20 18:13:55','admin'),(18,'2020-03-23 11:40:12','admin','admin@gmail.com','admin','admin','2020-03-23 11:40:12','admin'),(20,'2020-03-23 13:56:56','admin','admin@gmail.com','admin','admin','2020-03-23 13:56:56','admin'),(25,'2020-03-23 14:00:17','admin','admin@gmail.com','admin','admin','2020-03-23 14:00:17','admin'),(26,'2020-03-23 14:06:00','admin','admin@gmail.com','admin','admin','2020-03-23 14:06:00','admin'),(27,'2020-03-23 14:23:39','admin','admin@gmail.com','admin','admin','2020-03-23 14:23:39','admin'),(28,'2020-03-23 14:25:49','admin','admin@gmail.com','admin','admin','2020-03-23 14:25:49','admin'),(29,'2020-03-24 09:19:02','admin','admin@gmail.com','admin','admin','2020-03-24 09:19:02','admin'),(30,'2020-03-24 15:21:22','admin','admin@gmail.com','admin','admin','2020-03-24 15:21:22','admin');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-03-24 15:24:27
