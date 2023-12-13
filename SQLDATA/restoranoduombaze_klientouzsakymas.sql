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
-- Table structure for table `klientouzsakymas`
--

DROP TABLE IF EXISTS `klientouzsakymas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `klientouzsakymas` (
  `UzsakymoID` int(11) NOT NULL AUTO_INCREMENT,
  `Data` date DEFAULT NULL,
  `Laikas` time DEFAULT NULL,
  `Busena` varchar(255) DEFAULT NULL,
  `PristatymoID` int(11) DEFAULT NULL,
  `KlientoKuponoID` int(11) DEFAULT NULL,
  `RezervacijosID` int(11) DEFAULT NULL,
  `PaslaugosID` int(11) DEFAULT NULL,
  `KlientoID` int(11) DEFAULT NULL,
  PRIMARY KEY (`UzsakymoID`),
  KEY `FK_klientouzsakymas_klientai_KlientoID` (`KlientoID`),
  KEY `FK_klientouzsakymas_rezervacijos_RezervacijosID` (`RezervacijosID`),
  KEY `FK_klientouzsakymas_pristatymasinamus_PristatymoID` (`PristatymoID`),
  KEY `FK_klientouzsakymas_paslaugosuzsakymas_UzsakymoID` (`PaslaugosID`),
  KEY `FK_klientouzsakymas_klientokuponai_KlientoKuponoID` (`KlientoKuponoID`),
  CONSTRAINT `FK_klientouzsakymas_klientai_KlientoID` FOREIGN KEY (`KlientoID`) REFERENCES `klientai` (`KlientoID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_klientouzsakymas_klientokuponai_KlientoKuponoID` FOREIGN KEY (`KlientoKuponoID`) REFERENCES `klientokuponai` (`KlientoKuponoID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_klientouzsakymas_paslaugosuzsakymas_UzsakymoID` FOREIGN KEY (`PaslaugosID`) REFERENCES `paslaugosuzsakymas` (`UzsakymoID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_klientouzsakymas_pristatymasinamus_PristatymoID` FOREIGN KEY (`PristatymoID`) REFERENCES `pristatymasinamus` (`PristatymoID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_klientouzsakymas_rezervacijos_RezervacijosID` FOREIGN KEY (`RezervacijosID`) REFERENCES `rezervacijos` (`RezervacijosID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `klientouzsakymas`
--

LOCK TABLES `klientouzsakymas` WRITE;
/*!40000 ALTER TABLE `klientouzsakymas` DISABLE KEYS */;
INSERT INTO `klientouzsakymas` VALUES (1,'2023-05-12','16:00:00','Vykdoma',1,1,NULL,NULL,2),(2,'2023-04-12','10:00:00','Atlikta',NULL,NULL,4,NULL,11),(3,'2023-05-12','11:23:00','Atsauktas',NULL,NULL,NULL,1,9),(4,'2023-05-03','15:25:00','Atlikta',4,NULL,1,NULL,12),(5,'2023-02-07','17:45:06','Atlikta',NULL,NULL,3,NULL,10);
/*!40000 ALTER TABLE `klientouzsakymas` ENABLE KEYS */;
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
