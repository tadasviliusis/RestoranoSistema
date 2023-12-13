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
-- Table structure for table `programelesklientai`
--

DROP TABLE IF EXISTS `programelesklientai`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `programelesklientai` (
  `ProgramelesKlientoID` int(11) NOT NULL AUTO_INCREMENT,
  `PrisijungimoVardas` varchar(255) DEFAULT NULL,
  `Slaptazodis` varchar(255) DEFAULT NULL,
  `ProgramelesID` int(11) DEFAULT NULL,
  `KlientoID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ProgramelesKlientoID`),
  KEY `FK_programelesklientai_klientai_KlientoID` (`KlientoID`),
  KEY `FK_programelesklientai_programele_ProgramelesID` (`ProgramelesID`),
  CONSTRAINT `FK_programelesklientai_klientai_KlientoID` FOREIGN KEY (`KlientoID`) REFERENCES `klientai` (`KlientoID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_programelesklientai_programele_ProgramelesID` FOREIGN KEY (`ProgramelesID`) REFERENCES `programele` (`ProgramelesID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `programelesklientai`
--

LOCK TABLES `programelesklientai` WRITE;
/*!40000 ALTER TABLE `programelesklientai` DISABLE KEYS */;
INSERT INTO `programelesklientai` VALUES (1,'tomas','samot',1,2),(5,'tadas','sadat',1,9),(6,'edgar','ragde',1,10),(7,'marija','ajiram',1,11),(8,'beata','ataeb',1,12);
/*!40000 ALTER TABLE `programelesklientai` ENABLE KEYS */;
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
