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
-- Table structure for table `virtuvesiranga`
--

DROP TABLE IF EXISTS `virtuvesiranga`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `virtuvesiranga` (
  `IrangosID` int(11) NOT NULL AUTO_INCREMENT,
  `Pavadinimas` varchar(255) DEFAULT NULL,
  `Kaina` varchar(255) DEFAULT NULL,
  `TiekejoID` int(11) DEFAULT NULL,
  `GarantijosID` int(11) DEFAULT NULL,
  `RestoranoID` int(11) DEFAULT NULL,
  PRIMARY KEY (`IrangosID`),
  KEY `FK_virtuvesiranga_irangosgarantija_GarantijosID` (`GarantijosID`),
  KEY `FK_virtuvesiranga_restoranotinklas_RestoranoID` (`RestoranoID`),
  KEY `FK_virtuvesiranga_tiekejai_TiekejoID` (`TiekejoID`),
  CONSTRAINT `FK_virtuvesiranga_irangosgarantija_GarantijosID` FOREIGN KEY (`GarantijosID`) REFERENCES `irangosgarantija` (`GarantijosID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_virtuvesiranga_restoranotinklas_RestoranoID` FOREIGN KEY (`RestoranoID`) REFERENCES `restoranotinklas` (`RestoranoID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_virtuvesiranga_tiekejai_TiekejoID` FOREIGN KEY (`TiekejoID`) REFERENCES `tiekejai` (`TiekejoID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `virtuvesiranga`
--

LOCK TABLES `virtuvesiranga` WRITE;
/*!40000 ALTER TABLE `virtuvesiranga` DISABLE KEYS */;
INSERT INTO `virtuvesiranga` VALUES (1,'Backyard Pro LPG60 60\" Stainless Steel Liquid Propane Outdoor Grill','1700',1,1,1),(2,'Avantco FF100 Liquid Propane 70-100 lb. Stainless Steel Tube Floor Fryer - 150,000 BTU','1200',1,2,1),(3,'Cooking Performance Group CH-SP-1 SlowPro Cook and Hold Oven - 208/240V, 2250/3000W','2500',1,3,2),(4,'Cooking Performance Group S60-N Natural Gas 10 Burner 60\" Range with 2 Standard Ovens - 360,000 BTU','2400',1,4,1),(5,'Galaxy GIWC18 Stainless Steel Countertop Wok Induction Range / Cooker - 120V, 1800W','200',1,5,2);
/*!40000 ALTER TABLE `virtuvesiranga` ENABLE KEYS */;
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
