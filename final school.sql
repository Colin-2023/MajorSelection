-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: school
-- ------------------------------------------------------
-- Server version	8.0.20

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
-- Table structure for table `profession`
--

DROP TABLE IF EXISTS `profession`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `profession` (
  `id` int NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `classnum` varchar(45) DEFAULT NULL,
  `perclassnum` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profession`
--

LOCK TABLES `profession` WRITE;
/*!40000 ALTER TABLE `profession` DISABLE KEYS */;
INSERT INTO `profession` VALUES (1,'计算机科学与技术','1','2'),(2,'计算机科学与技术卓越工程师','2','2'),(3,'软件工程','1','2'),(4,'物联网工程','2','1');
/*!40000 ALTER TABLE `profession` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `id` int NOT NULL,
  `name` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `xuehao` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `code` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `time` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `major` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `choose1` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `choose2` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `choose3` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `choose4` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `choose5` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `class` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `jidian` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '绩点',
  PRIMARY KEY (`id`),
  UNIQUE KEY `xuehao_UNIQUE` (`xuehao`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'杨冀星','2018903789','123456','2018年','软件工程','计算机科学与技术','物联网工程','软件工程','计算机科学与技术卓越工程师','','4','3.45'),(2,'刘伟','2018902813','123456','2018年','物联网工程','物联网工程','计算机科学与技术卓越工程师','软件工程','计算机科学与技术','','5','3.61'),(3,'李宇航','2018902570','123456','2018年','计算机科学与技术','计算机科学与技术','计算机科学与技术卓越工程师','软件工程','物联网工程','','1','3.78'),(4,'王天祥','2018900937','123456','2018年','计算机科学与技术卓越工程师','计算机科学与技术卓越工程师','计算机科学与技术','物联网工程','软件工程','','3','3.75'),(5,'周俊伟','2018900656','123456','2018年','物联网工程','物联网工程','软件工程','计算机科学与技术','计算机科学与技术卓越工程师','','6','3.66'),(6,'张三','2018904565','123456','2018年','计算机科学与技术卓越工程师','计算机科学与技术卓越工程师','软件工程','物联网工程','计算机科学与技术','','3','3.01'),(7,'李四','2018902573','123456','2018年','计算机科学与技术','计算机科学与技术','计算机科学与技术卓越工程师','软件工程','物联网工程','','1','3.80'),(8,'王五','2018902586','123456','2018年','计算机科学与技术卓越工程师','计算机科学与技术卓越工程师','计算机科学与技术','物联网工程','软件工程','','2','3.56'),(9,'小李','2018902571','123456','2018年','软件工程','软件工程','计算机科学与技术','物联网工程','计算机科学与技术卓越工程师','','4','3.85'),(10,'小马','2018902576','123456','2018年','计算机科学与技术卓越工程师','计算机科学与技术卓越工程师','软件工程','物联网工程','计算机科学与技术','','2','3.76');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacher` (
  `id` int NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `zhigonghao` varchar(45) DEFAULT NULL,
  `code` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES (1,'杨冀星','2018240202','123456'),(2,'刘伟','2018240205','123456');
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-10-26  9:03:23
