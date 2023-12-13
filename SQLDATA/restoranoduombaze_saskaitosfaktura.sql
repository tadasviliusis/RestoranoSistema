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
-- Table structure for table `saskaitosfaktura`
--

DROP TABLE IF EXISTS `saskaitosfaktura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `saskaitosfaktura` (
  `SaskaitosID` int(11) NOT NULL,
  `Kaina` double DEFAULT NULL,
  `SumaBePVM` double DEFAULT NULL,
  `PVM` int(11) DEFAULT NULL,
  `Data` date DEFAULT NULL,
  `Laikas` time DEFAULT NULL,
  `UzsakymoID` int(11) DEFAULT NULL,
  PRIMARY KEY (`SaskaitosID`),
  KEY `FK_saskaitosfaktura_klientouzsakymas_UzsakymoID` (`UzsakymoID`),
  CONSTRAINT `FK_saskaitosfaktura_klientouzsakymas_UzsakymoID` FOREIGN KEY (`UzsakymoID`) REFERENCES `klientouzsakymas` (`UzsakymoID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `saskaitosfaktura`
--

LOCK TABLES `saskaitosfaktura` WRITE;
/*!40000 ALTER TABLE `saskaitosfaktura` DISABLE KEYS */;
INSERT INTO `saskaitosfaktura` VALUES (1,20,15.8,21,'2023-05-12','16:00:00',1),(2,15,11.85,21,'2023-04-12','10:00:00',2),(3,150,118.5,21,'2023-05-12','11:23:00',3),(4,16,12.64,21,'2023-05-03','15:25:00',4),(5,17,13.43,21,'2023-02-07','17:45:00',5);
/*!40000 ALTER TABLE `saskaitosfaktura` ENABLE KEYS */;
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
