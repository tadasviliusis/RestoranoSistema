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
-- Table structure for table `darbuotojai`
--

DROP TABLE IF EXISTS `darbuotojai`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `darbuotojai` (
  `DarbuotojoID` int(11) NOT NULL AUTO_INCREMENT,
  `Vardas` varchar(255) DEFAULT NULL,
  `Pavarde` varchar(255) DEFAULT NULL,
  `TlNumeris` varchar(255) DEFAULT NULL,
  `ElPastas` varchar(255) DEFAULT NULL,
  `Adresas` varchar(255) DEFAULT NULL,
  `DarboLaikoID` int(11) DEFAULT NULL,
  `RestoranoID` int(11) DEFAULT NULL,
  `PareigosID` int(11) DEFAULT NULL,
  PRIMARY KEY (`DarbuotojoID`),
  KEY `FK_darbuotojai_restoranotinklas_RestoranoID` (`RestoranoID`),
  KEY `FK_darbuotojai_darbuotojopareigos_PareigosID` (`PareigosID`),
  KEY `FK_darbuotojai_darbolaikas_DarboLaikoID` (`DarboLaikoID`),
  CONSTRAINT `FK_darbuotojai_darbolaikas_DarboLaikoID` FOREIGN KEY (`DarboLaikoID`) REFERENCES `darbolaikas` (`DarboLaikoID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_darbuotojai_darbuotojopareigos_PareigosID` FOREIGN KEY (`PareigosID`) REFERENCES `darbuotojopareigos` (`PareigosID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_darbuotojai_restoranotinklas_RestoranoID` FOREIGN KEY (`RestoranoID`) REFERENCES `restoranotinklas` (`RestoranoID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `darbuotojai`
--

LOCK TABLES `darbuotojai` WRITE;
/*!40000 ALTER TABLE `darbuotojai` DISABLE KEYS */;
INSERT INTO `darbuotojai` VALUES (1,'Katya','Katyauskinie','+37064561237','katya.katyusha@gmail.com','Vilnius, Žoles g. 15',5,1,3),(2,'Jonas','Jonauskas','+37069874563','jonas.jonauskas@gmail.com','Vilnius, Saules al. 56',1,1,1),(3,'Diana','Dianauskinie','+37060852085','diana.dianuk@gmail.com','Vilnius, Londono g. 23',2,1,1),(4,'Edvinas','Edvinauskas','+37065645645','edvinas.vinauksas@gmail.com','Vilnius, Alfonso pr. 63',3,1,4),(5,'Karolina','Karolinauskinie','+37069173791','karolinauskinie.karol@gmail.com','Vilnius, Ginklo al. 47',2,1,5);
/*!40000 ALTER TABLE `darbuotojai` ENABLE KEYS */;
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
