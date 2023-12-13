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
-- Table structure for table `medziagos`
--

DROP TABLE IF EXISTS `medziagos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medziagos` (
  `MedziagosID` int(11) NOT NULL AUTO_INCREMENT,
  `Pavadinimas` varchar(255) DEFAULT NULL,
  `Kaina` double DEFAULT NULL,
  `Kiekis` int(11) DEFAULT NULL,
  `UzsakymoData` date DEFAULT NULL,
  `PristatymoData` date DEFAULT NULL,
  `SandelioID` int(11) DEFAULT NULL,
  `TiekejoID` int(11) DEFAULT NULL,
  PRIMARY KEY (`MedziagosID`),
  KEY `FK_medziagos_sandelis_SandelioID` (`SandelioID`),
  KEY `FK_medziagos_tiekejai_TiekejoID` (`TiekejoID`),
  CONSTRAINT `FK_medziagos_sandelis_SandelioID` FOREIGN KEY (`SandelioID`) REFERENCES `sandelis` (`SandelioID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_medziagos_tiekejai_TiekejoID` FOREIGN KEY (`TiekejoID`) REFERENCES `tiekejai` (`TiekejoID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medziagos`
--

LOCK TABLES `medziagos` WRITE;
/*!40000 ALTER TABLE `medziagos` DISABLE KEYS */;
INSERT INTO `medziagos` VALUES (1,'Puodai',30,15,'2023-02-01','2023-03-23',1,1),(2,'Bulves',200,400,'2023-05-10','2023-05-14',1,3),(3,'Vištienos krutineles',400,1000,'2023-05-10','2023-05-12',1,4),(4,'Morkos',150,145,'2023-05-08','2023-05-11',4,3),(5,'Kiaulienos kepsnys',250,500,'2023-05-01','2023-05-05',3,4);
/*!40000 ALTER TABLE `medziagos` ENABLE KEYS */;
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
