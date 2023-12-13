CREATE DATABASE  IF NOT EXISTS `restoranoduombaze` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `restoranoduombaze`;
-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: restoranoduombaze
-- ------------------------------------------------------
-- Server version	5.7.42-log

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
-- Table structure for table `pristatymasinamus`
--

DROP TABLE IF EXISTS `pristatymasinamus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pristatymasinamus` (
  `PristatymoID` int(11) NOT NULL AUTO_INCREMENT,
  `Adresas` varchar(255) DEFAULT NULL,
  `Kaina` double DEFAULT NULL,
  `Laikas` time DEFAULT NULL,
  `Data` date DEFAULT NULL,
  `TlNumeris` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`PristatymoID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pristatymasinamus`
--

LOCK TABLES `pristatymasinamus` WRITE;
/*!40000 ALTER TABLE `pristatymasinamus` DISABLE KEYS */;
INSERT INTO `pristatymasinamus` VALUES (1,'Vilnius, Verkiu g. 41',2,'17:00:00','2023-05-12','+37063901011'),(2,'Vilnius, Verkiu g. 41',2,'12:00:00','2023-04-05','+37063901011'),(3,'Nemencine, Laisves g. 1',1.45,'14:30:00','2023-05-04','+37067411235'),(4,'Vilnius, Kalvariju g. 14',2.1,'16:25:00','2023-05-03','+37068458123'),(5,'Vilnius, Pilies g. 12',1.95,'14:20:00','2023-02-15','+37068458123');
/*!40000 ALTER TABLE `pristatymasinamus` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-14 18:55:35
