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
-- Table structure for table `restoranotinklas`
--

DROP TABLE IF EXISTS `restoranotinklas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `restoranotinklas` (
  `RestoranoID` int(11) NOT NULL AUTO_INCREMENT,
  `Adresas` varchar(255) DEFAULT NULL,
  `TlNumeris` varchar(255) DEFAULT NULL,
  `SandelioID` int(11) DEFAULT NULL,
  PRIMARY KEY (`RestoranoID`),
  KEY `FK_restoranotinklas_sandelis_SandelioID` (`SandelioID`),
  CONSTRAINT `FK_restoranotinklas_sandelis_SandelioID` FOREIGN KEY (`SandelioID`) REFERENCES `sandelis` (`SandelioID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restoranotinklas`
--

LOCK TABLES `restoranotinklas` WRITE;
/*!40000 ALTER TABLE `restoranotinklas` DISABLE KEYS */;
INSERT INTO `restoranotinklas` VALUES (1,'Vilnius, Zirmunu g. 12','+37062955102',1),(2,'Vilnius, Kalvariju g. 35','+37095800125',1),(3,'Vilnius, Karaliaus g. 30','+37064268421',3),(4,'Nemencine, Traku pr. 3','+37064561237',4),(5,'Vilnius, Mindaugo g. 16','+37069746150',3);
/*!40000 ALTER TABLE `restoranotinklas` ENABLE KEYS */;
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
