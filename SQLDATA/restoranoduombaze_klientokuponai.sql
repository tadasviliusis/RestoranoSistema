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
-- Table structure for table `klientokuponai`
--

DROP TABLE IF EXISTS `klientokuponai`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `klientokuponai` (
  `KlientoKuponoID` int(11) NOT NULL AUTO_INCREMENT,
  `Busena` varchar(255) DEFAULT NULL,
  `KuponoID` int(11) DEFAULT NULL,
  `KlientoID` int(11) DEFAULT NULL,
  PRIMARY KEY (`KlientoKuponoID`),
  KEY `FK_klientokuponai_nuolaidukuponai_KuponoID` (`KuponoID`),
  KEY `FK_klientokuponai_klientai_KlientoID` (`KlientoID`),
  CONSTRAINT `FK_klientokuponai_klientai_KlientoID` FOREIGN KEY (`KlientoID`) REFERENCES `klientai` (`KlientoID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_klientokuponai_nuolaidukuponai_KuponoID` FOREIGN KEY (`KuponoID`) REFERENCES `nuolaidukuponai` (`KuponoID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `klientokuponai`
--

LOCK TABLES `klientokuponai` WRITE;
/*!40000 ALTER TABLE `klientokuponai` DISABLE KEYS */;
INSERT INTO `klientokuponai` VALUES (1,'Nepanaudota',1,2),(3,'Nepanaudota',3,11),(4,'Panaudota',4,10),(5,'Nepanaudota',5,9),(6,'Nepanaudota',1,11);
/*!40000 ALTER TABLE `klientokuponai` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-14 18:55:36
