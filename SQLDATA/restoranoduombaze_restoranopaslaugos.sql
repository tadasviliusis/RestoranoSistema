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
-- Table structure for table `restoranopaslaugos`
--

DROP TABLE IF EXISTS `restoranopaslaugos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `restoranopaslaugos` (
  `PaslaugosID` int(11) NOT NULL AUTO_INCREMENT,
  `Pavadinimas` varchar(255) DEFAULT NULL,
  `Aprasymas` varchar(255) DEFAULT NULL,
  `Kaina` double DEFAULT NULL,
  PRIMARY KEY (`PaslaugosID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restoranopaslaugos`
--

LOCK TABLES `restoranopaslaugos` WRITE;
/*!40000 ALTER TABLE `restoranopaslaugos` DISABLE KEYS */;
INSERT INTO `restoranopaslaugos` VALUES (1,'Teminiai vakarai','Restorane gali buti rengiami tokie renginiai kaip „Meksikos fiesta naktis“, „Viduržemio juros regiono virtuves vakaras“ arba „Seafood Extravaganza“, kur meniu, dekoras ir atmosfera derinami su pasirinkta tema.',140),(2,'Gyvos muzikos ar pramogu naktys','Restorane gali buti gyvos muzikos pasirodymai arba pramogu vakarai, kad pagerintu vakarienes atmosfera. Tai gali buti gyvos grupes, solo muzikantai, džiazo ansambliai, stand-up komedijos ar net magai, teikiantys pramogas, kol sveciai megaujasi maistu.',200),(3,'Šeimos ar vaiku diena','Restoranas gali organizuoti šeimai skirtus renginius ar vaiku dienas su tokia veikla kaip veido piešimas, balionu menininkai, pasakojimai ar specialus meniu vaikams. Šie renginiai sukuria jaukia aplinka šeimoms ir skatina jas pietauti kartu.',135),(4,'Vyno degustacijos renginys','Vyno degustacijos renginys leidžia sveciams paragauti ivairiu vynu ir sužinoti apie ju skoni, kilme ir pora. Restoranai gali bendradarbiauti su vyno daryklomis ar vyno ekspertais, kad dalyviams suteiktu mokomosios ir malonios patirties.',210),(5,'Maisto gaminimo pamokos','Restoranas gali organizuoti maisto gaminimo pamokas, kuriose sveciai mokosi virimo techniku, receptu ir kulinariniu patarimu iš vireju. Šios sesijos apima konkretu patiekala arba gaminimo stiliu, leidžianti dalyviams tobulinti savo kulinarinius igudžius.',200);
/*!40000 ALTER TABLE `restoranopaslaugos` ENABLE KEYS */;
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
