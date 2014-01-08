-- MySQL dump 10.13  Distrib 5.5.34, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: portfolio
-- ------------------------------------------------------
-- Server version	5.5.34-0ubuntu0.12.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `INSTRUMENT`
--

DROP TABLE IF EXISTS `INSTRUMENT`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `INSTRUMENT` (
  `ID` int(10) NOT NULL DEFAULT '0',
  `SYMBOL` varchar(64) NOT NULL,
  `DESCRIPTION` varchar(256) DEFAULT NULL,
  `INSTRUMENT_TYPE_ID` int(10) DEFAULT NULL,
  `MARKET_ID` int(10) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_INSTRUMENT_2` (`MARKET_ID`),
  KEY `FK_INSTRUMENT_1` (`INSTRUMENT_TYPE_ID`),
  CONSTRAINT `FK_INSTRUMENT_1` FOREIGN KEY (`INSTRUMENT_TYPE_ID`) REFERENCES `INSTRUMENT_TYPE` (`ID`),
  CONSTRAINT `FK_INSTRUMENT_2` FOREIGN KEY (`MARKET_ID`) REFERENCES `MARKET` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `INSTRUMENT`
--

LOCK TABLES `INSTRUMENT` WRITE;
/*!40000 ALTER TABLE `INSTRUMENT` DISABLE KEYS */;
/*!40000 ALTER TABLE `INSTRUMENT` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `INSTRUMENT_TYPE`
--

DROP TABLE IF EXISTS `INSTRUMENT_TYPE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `INSTRUMENT_TYPE` (
  `ID` int(10) NOT NULL DEFAULT '0',
  `NAME` varchar(128) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `INSTRUMENT_TYPE`
--

LOCK TABLES `INSTRUMENT_TYPE` WRITE;
/*!40000 ALTER TABLE `INSTRUMENT_TYPE` DISABLE KEYS */;
/*!40000 ALTER TABLE `INSTRUMENT_TYPE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `MARKET`
--

DROP TABLE IF EXISTS `MARKET`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `MARKET` (
  `ID` int(10) NOT NULL DEFAULT '0',
  `SHORT_CODE` varchar(32) NOT NULL,
  `DESCRIPTION` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MARKET`
--

LOCK TABLES `MARKET` WRITE;
/*!40000 ALTER TABLE `MARKET` DISABLE KEYS */;
/*!40000 ALTER TABLE `MARKET` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PORTFOLIO`
--

DROP TABLE IF EXISTS `PORTFOLIO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PORTFOLIO` (
  `ID` int(10) NOT NULL DEFAULT '0',
  `NAME` varchar(128) NOT NULL,
  `DESCRIPTION` varchar(256) DEFAULT NULL,
  `CREATE_DATE` datetime NOT NULL,
  `LAST_MODIFY_DATE` datetime NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PORTFOLIO`
--

LOCK TABLES `PORTFOLIO` WRITE;
/*!40000 ALTER TABLE `PORTFOLIO` DISABLE KEYS */;
/*!40000 ALTER TABLE `PORTFOLIO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PORTFOLIO_TRANSACTION`
--

DROP TABLE IF EXISTS `PORTFOLIO_TRANSACTION`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PORTFOLIO_TRANSACTION` (
  `ID` int(10) NOT NULL DEFAULT '0',
  `INSTRUMENT_ID` int(10) NOT NULL,
  `TRANSACTION_DATE` datetime NOT NULL,
  `PRICE` int(10) NOT NULL,
  `PRICE_UNIT` varchar(32) NOT NULL,
  `CURRENCY` varchar(16) NOT NULL,
  `QUANTITY` int(10) NOT NULL,
  `COMMISSION_STAMP_DUTY` int(10) DEFAULT NULL,
  `COMMISSION_DEAL_FEE` int(10) DEFAULT NULL,
  `PORTFOLIO_ID` int(10) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_PORTFOLIO_TRANSACTION_1` (`INSTRUMENT_ID`),
  KEY `FK_PORTFOLIO_TRANSACTION_2` (`PORTFOLIO_ID`),
  CONSTRAINT `FK_PORTFOLIO_TRANSACTION_1` FOREIGN KEY (`INSTRUMENT_ID`) REFERENCES `INSTRUMENT` (`ID`),
  CONSTRAINT `FK_PORTFOLIO_TRANSACTION_2` FOREIGN KEY (`PORTFOLIO_ID`) REFERENCES `PORTFOLIO` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PORTFOLIO_TRANSACTION`
--

LOCK TABLES `PORTFOLIO_TRANSACTION` WRITE;
/*!40000 ALTER TABLE `PORTFOLIO_TRANSACTION` DISABLE KEYS */;
/*!40000 ALTER TABLE `PORTFOLIO_TRANSACTION` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequences`
--

DROP TABLE IF EXISTS `hibernate_sequences`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequences` (
  `sequence_name` varchar(255) DEFAULT NULL,
  `sequence_next_hi_value` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequences`
--

LOCK TABLES `hibernate_sequences` WRITE;
/*!40000 ALTER TABLE `hibernate_sequences` DISABLE KEYS */;
INSERT INTO `hibernate_sequences` VALUES ('MARKET',2);
/*!40000 ALTER TABLE `hibernate_sequences` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-01-08 16:15:58