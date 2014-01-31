CREATE DATABASE  IF NOT EXISTS `TravelDreamDB` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `TravelDreamDB`;
-- MySQL dump 10.13  Distrib 5.6.13, for osx10.6 (i386)
--
-- Host: localhost    Database: TravelDreamDB
-- ------------------------------------------------------
-- Server version	5.6.15

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
-- Table structure for table `GROUPS`
--

DROP TABLE IF EXISTS `GROUPS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `GROUPS` (
  `GROUPID` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `GROUPS`
--

LOCK TABLES `GROUPS` WRITE;
/*!40000 ALTER TABLE `GROUPS` DISABLE KEYS */;
INSERT INTO `GROUPS` VALUES ('user'),('admin');
/*!40000 ALTER TABLE `GROUPS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PRODUCTS`
--

DROP TABLE IF EXISTS `PRODUCTS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PRODUCTS` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `AEROP_ANDATA` varchar(255) DEFAULT NULL,
  `AEROP_RITORNO` varchar(255) DEFAULT NULL,
  `COD_ESCURSIONE` bigint(20) DEFAULT NULL,
  `COD_SOGGIORNO` bigint(20) DEFAULT NULL,
  `COD_VOLO` bigint(20) DEFAULT NULL,
  `DATA_ARRIVO` datetime DEFAULT NULL,
  `DATA_PARTENZA` datetime DEFAULT NULL,
  `DESCRIZIONE` varchar(255) DEFAULT NULL,
  `LUOGO` varchar(255) DEFAULT NULL,
  `NOME` varchar(255) NOT NULL,
  `PREZZO` int(11) NOT NULL,
  `TIPO` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PRODUCTS`
--

LOCK TABLES `PRODUCTS` WRITE;
/*!40000 ALTER TABLE `PRODUCTS` DISABLE KEYS */;
INSERT INTO `PRODUCTS` VALUES (1,'aa','aaa',NULL,NULL,NULL,'2015-03-04 00:00:00','2013-03-02 00:00:00','a',NULL,'aerop',200,'volo'),(3,NULL,NULL,NULL,NULL,NULL,'2015-02-03 00:00:00',NULL,'a','a','escursion',100,'escursione'),(4,NULL,NULL,2,NULL,1,NULL,NULL,NULL,NULL,'Prova',1000,'pacchetto'),(5,'lim','mil',NULL,NULL,NULL,'2015-10-02 08:02:00','2015-10-02 08:03:00','bb',NULL,'B',40,'volo'),(6,NULL,NULL,2,NULL,5,NULL,NULL,NULL,NULL,'Prova2',400,'pacchetto'),(7,NULL,NULL,NULL,NULL,NULL,'2015-03-02 00:00:00','2015-03-02 00:00:00','ca','da','bacca',23,'soggiorno'),(8,NULL,NULL,2,7,5,NULL,NULL,NULL,NULL,'Prova3',215,'pacchetto'),(9,NULL,NULL,2,7,1,NULL,NULL,NULL,NULL,'Prova3',323,'user'),(10,NULL,NULL,2,7,1,NULL,NULL,NULL,NULL,'Prova5',215,'user'),(11,NULL,NULL,NULL,NULL,NULL,'2015-03-04 00:00:00',NULL,'a','a','escursioneSpero',100,'escursione'),(12,NULL,NULL,11,7,5,NULL,NULL,NULL,NULL,'Pacchetto',2000,'pacchetto'),(13,NULL,NULL,3,7,5,NULL,NULL,NULL,NULL,'PacchettoMio',2000,'user'),(14,NULL,NULL,11,7,5,NULL,NULL,NULL,NULL,'Pacchetto',2000,'user'),(15,NULL,NULL,11,7,5,NULL,NULL,NULL,NULL,'Pacchettino',163,'user');
/*!40000 ALTER TABLE `PRODUCTS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `USERS`
--

DROP TABLE IF EXISTS `USERS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `USERS` (
  `USERID` varchar(255) NOT NULL,
  `COGNOME` varchar(255) DEFAULT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `NOME` varchar(255) DEFAULT NULL,
  `PASSWORD` varchar(255) NOT NULL,
  PRIMARY KEY (`USERID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USERS`
--

LOCK TABLES `USERS` WRITE;
/*!40000 ALTER TABLE `USERS` DISABLE KEYS */;
INSERT INTO `USERS` VALUES ('admin',NULL,NULL,NULL,'8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918'),('admin2','prova','@ha','administrator','8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918'),('admin3','dellea','aaa','fabio','4fc2b5673a201ad9b1fc03dcb346e1baad44351daa0503d5534b4dfdcc4332e0'),('GinLemon','Nabokov','VladN@gmail.com','Vladimir','09cc1b93ceee06fd6a91e9cfb15dce3aaa4bab266766ecab59b99bf92ade8094'),('nemesis910','Dellea','nemesis910@gmail.com','Fabio','11ede5bfd1d8d7c6f2b4c46dd69e4207205e832463751651b4f477d809e3477a'),('user','Dellea','foo@gmail.com','Fabio','04f8996da763b7a969b1028ee3007569eaf3a635486ddab211d512c85b9df8fb');
/*!40000 ALTER TABLE `USERS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `USER_GROUP`
--

DROP TABLE IF EXISTS `USER_GROUP`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `USER_GROUP` (
  `userId` varchar(255) DEFAULT NULL,
  `groupId` varchar(255) DEFAULT NULL,
  KEY `FK_USER_GROUP_userId` (`userId`),
  CONSTRAINT `FK_USER_GROUP_userId` FOREIGN KEY (`userId`) REFERENCES `USERS` (`USERID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USER_GROUP`
--

LOCK TABLES `USER_GROUP` WRITE;
/*!40000 ALTER TABLE `USER_GROUP` DISABLE KEYS */;
INSERT INTO `USER_GROUP` VALUES ('admin','admin'),('user','user'),('admin2','admin'),('nemesis910','user'),('admin3','admin'),('GinLemon','user');
/*!40000 ALTER TABLE `USER_GROUP` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `WISHLIST`
--

DROP TABLE IF EXISTS `WISHLIST`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `WISHLIST` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `IDPRODUCT` bigint(20) NOT NULL,
  `USER` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `WISHLIST`
--

LOCK TABLES `WISHLIST` WRITE;
/*!40000 ALTER TABLE `WISHLIST` DISABLE KEYS */;
INSERT INTO `WISHLIST` VALUES (3,16,'GinLemon'),(4,1,'GinLemon'),(5,4,'user'),(6,15,'user');
/*!40000 ALTER TABLE `WISHLIST` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-01-31 11:28:20
