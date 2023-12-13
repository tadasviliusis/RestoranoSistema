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
-- Table structure for table `paslaugosuzsakymas`
--

DROP TABLE IF EXISTS `paslaugosuzsakymas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `paslaugosuzsakymas` (
  `UzsakymoID` int(11) NOT NULL AUTO_INCREMENT,
  `Kaina` varchar(255) DEFAULT NULL,
  `Data` date DEFAULT NULL,
  `Laikas` time DEFAULT NULL,
  `RestoranoID` int(11) DEFAULT NULL,
  `PaslaugosID` int(11) DEFAULT NULL,
  PRIMARY KEY (`UzsakymoID`),
  KEY `FK_paslaugosuzsakymas_restoranopaslaugos_PaslaugosID` (`PaslaugosID`),
  KEY `FK_paslaugosuzsakymas_restoranotinklas_RestoranoID` (`RestoranoID`),
  CONSTRAINT `FK_paslaugosuzsakymas_restoranopaslaugos_PaslaugosID` FOREIGN KEY (`PaslaugosID`) REFERENCES `restoranopaslaugos` (`PaslaugosID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_paslaugosuzsakymas_restoranotinklas_RestoranoID` FOREIGN KEY (`RestoranoID`) REFERENCES `restoranotinklas` (`RestoranoID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paslaugosuzsakymas`
--

LOCK TABLES `paslaugosuzsakymas` WRITE;
/*!40000 ALTER TABLE `paslaugosuzsakymas` DISABLE KEYS */;
INSERT INTO `paslaugosuzsakymas` VALUES (1,'140','2023-05-17','17:00:00',1,1),(2,'135','2023-05-09','12:00:00',1,3),(3,'135','2023-05-23','11:00:00',2,3),(4,'210','2023-05-31','18:00:00',2,4),(5,'200','2023-05-24','19:00:00',1,2);
/*!40000 ALTER TABLE `paslaugosuzsakymas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-14 18:55:34
