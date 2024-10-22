-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: allanimals
-- ------------------------------------------------------
-- Server version	8.0.39

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
-- Table structure for table `allanimals`
--

DROP TABLE IF EXISTS `allanimals`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `allanimals` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(15) DEFAULT NULL,
  `type_id` int DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `commands` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `allanimals`
--

LOCK TABLES `allanimals` WRITE;
/*!40000 ALTER TABLE `allanimals` DISABLE KEYS */;
INSERT INTO `allanimals` VALUES (1,'Tom',1,'2022-06-21','Eat, Sit, Stay'),(2,'Lukky',1,'2023-01-15','Walk, Eat'),(3,'Frido',2,'2024-01-20','Stay, Roll, Roll'),(4,'Buddy',2,'2021-08-04','Speak, Stay, Wait'),(5,'Oliver',2,'2023-11-23','Stay, Roll, Paw'),(6,'Hammy',3,'2024-08-12','Spin, Roll'),(7,'Slippy',3,'2022-04-16','Roll, Hide'),(8,'Thandy',4,'2019-02-18','Trot, Canter, Gallop'),(9,'Mandy',4,'2023-07-19','Walk, Run'),(10,'Storm',4,'2022-01-27','Trot, Jump'),(11,'Zakky',6,'2019-03-24','Walk, Bray, Kick, Sleep'),(12,'Burritos',6,'2022-01-17','Walk, Run'),(13,'Groza',4,'2020-11-02','Run, Gallop, Walk'),(14,'Staff',2,'2023-03-28','Walk, Wait');
/*!40000 ALTER TABLE `allanimals` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-10-23  1:59:21
