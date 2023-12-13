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
-- Table structure for table `meniu`
--

DROP TABLE IF EXISTS `meniu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `meniu` (
  `PatiekaloID` int(11) NOT NULL AUTO_INCREMENT,
  `Pavadinimas` varchar(255) DEFAULT NULL,
  `Kaina` double DEFAULT NULL,
  `Aprasymas` varchar(255) DEFAULT NULL,
  `KategorijosID` int(11) DEFAULT NULL,
  `RestoranoID` int(11) DEFAULT NULL,
  PRIMARY KEY (`PatiekaloID`),
  KEY `FK_meniu_restoranotinklas_RestoranoID` (`RestoranoID`),
  KEY `FK_meniu_maistokategorijos_KategorijosID` (`KategorijosID`),
  CONSTRAINT `FK_meniu_maistokategorijos_KategorijosID` FOREIGN KEY (`KategorijosID`) REFERENCES `maistokategorijos` (`KategorijosID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_meniu_restoranotinklas_RestoranoID` FOREIGN KEY (`RestoranoID`) REFERENCES `restoranotinklas` (`RestoranoID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `meniu`
--

LOCK TABLES `meniu` WRITE;
/*!40000 ALTER TABLE `meniu` DISABLE KEYS */;
INSERT INTO `meniu` VALUES (1,'„Copycat Pink“ gerimas',2,'„Starbucks“ megejai džiaugiasi! Pasityciokite iš ju garsiojo „rožinio gerimo“ savo virtuveje naudodami ši paprasta recepta.',1,1),(2,'Lazanijos paplotelis',6.5,'Paprasta lazanijos pica.',5,1),(3,'Baileys surio pyragas',3,'Šis Baileys surio pyragas turi skania mokos skonio pluta ir itin kremini idara. Užpildytas švelniu šokoladiniu ganašu – dekadentiškas desertas, kuriam niekas negales atsispirti!',3,1),(4,'Spygliuotas limonadas',2,'Naminis limonadas, pagardintas romu – puikus atogražu aušintuvas karšta diena. Pagamina 1 dideli gerima arba 2 mažesnius.',1,1),(5,'Žaliosios deives salotos',3,'Paprastos romenu salotos su klasikiniu žaliu deives padažu, pagamintu iš majonezo, petražoliu, špinatu, baziliko, peletruno ir citrinos sulciu.',4,1),(6,'Oro gruzdintuve Vaflinis kiaušinis skyleje',4.5,'Klasikinis kiaušinis skyluteje gaminamas vaflio viduje, kad butu saldaus, sviestinio skonio ir traškumo.',2,1),(7,'Keptu bulviu sriuba',5.3,'Ši keptu bulviu sriuba yra tiršta, kremine ir puikus budas panaudoti likusias keptas bulves.',5,1),(8,'Makaronu salotos su naminiu padažu',6,'Naminis itališku makaronu salotu padažas pakelia šias paprastas makaronu salotas su daržovemis, suriu, pipirais ir alyvuogemis i visiškai nauja lygi! Patiekite iš karto arba paruoškite prie supakuotu pietu, iškylu ar vasaros kepsniu.',5,1),(9,'Havaju kumpio ir surio slankikliai',6.2,'Havajietiški slankikliai puikiai tinka pasivaišinti, norint ka nors idomaus ir lengvai pasidalyti.',5,1);
/*!40000 ALTER TABLE `meniu` ENABLE KEYS */;
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
