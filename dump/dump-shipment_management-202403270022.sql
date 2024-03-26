-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: shipment_management
-- ------------------------------------------------------
-- Server version	8.2.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cities`
--

DROP TABLE IF EXISTS `cities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cities` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `metric` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cities`
--

LOCK TABLES `cities` WRITE;
/*!40000 ALTER TABLE `cities` DISABLE KEYS */;
INSERT INTO `cities` VALUES (1,'Jakarta',0),(6,'Bandung',2),(8,'Semarang',6),(9,'Surabaya',10),(16,'Medan',-8);
/*!40000 ALTER TABLE `cities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customers` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `fullname` varchar(100) DEFAULT NULL,
  `return_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `password` varchar(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `customers_unique` (`username`),
  UNIQUE KEY `customers_unique_1` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES (1,'dummy@sms.id','112','customer dummy','-','b5a2c96250612366ea272ffac6d9744aaf4b45aacd96aa7cfcb931ee3b558259','dummy'),(6,'anya@sms.id','082257291200','Anya Fachri','Jl. Mantap Gaming','33939d07e25f54e6432ad3b382e8d3d9e68522b6c3ef868f5c00410308fb6805','anyafachri');
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `delivery_requests`
--

DROP TABLE IF EXISTS `delivery_requests`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `delivery_requests` (
  `id` int NOT NULL AUTO_INCREMENT,
  `sender_name` varchar(255) DEFAULT NULL,
  `sender_phone` varchar(20) DEFAULT NULL,
  `sender_address` varchar(255) DEFAULT NULL,
  `recipient_name` varchar(255) DEFAULT NULL,
  `recipient_phone` varchar(20) DEFAULT NULL,
  `recipient_address` varchar(255) DEFAULT NULL,
  `weight` float DEFAULT NULL,
  `is_fragile` tinyint(1) DEFAULT '0',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `cost` float DEFAULT NULL,
  `request_time` datetime DEFAULT NULL,
  `customer_id` int NOT NULL,
  `city_origin_id` int NOT NULL,
  `city_dest_id` int NOT NULL,
  `pickup_time_est` datetime DEFAULT NULL,
  `pickup_time` datetime DEFAULT NULL,
  `is_canceled` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `customer_id` (`customer_id`),
  KEY `city_origin_id` (`city_origin_id`),
  KEY `city_dest_id` (`city_dest_id`),
  CONSTRAINT `delivery_requests_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`id`),
  CONSTRAINT `delivery_requests_ibfk_2` FOREIGN KEY (`city_origin_id`) REFERENCES `cities` (`id`),
  CONSTRAINT `delivery_requests_ibfk_3` FOREIGN KEY (`city_dest_id`) REFERENCES `cities` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delivery_requests`
--

LOCK TABLES `delivery_requests` WRITE;
/*!40000 ALTER TABLE `delivery_requests` DISABLE KEYS */;
INSERT INTO `delivery_requests` VALUES (5,'Asrofil','0822','Jl. Jalan Jalan','Fachrul','1200','Jl, Leumpang',1.2,1,'Cilok',19000,'2024-03-26 01:58:15',6,1,6,NULL,NULL,0),(6,'Asrofil','0822','Jl. Sukabumi','Fachrul','0812','Jl. Bumisuka',3.6,1,'Kipas Angin',33000,'2024-03-26 10:11:09',6,1,8,NULL,NULL,0),(7,'Asrofil','0852','Jl. Soehat','Riidlo','0856','Jl. Sudirman',2.1,1,'Laptop',37000,'2024-03-26 10:13:23',6,6,16,NULL,NULL,0),(8,'Dummy','0821','Jl. Dummy','John Doe','0823','Jl. Doe',1.2,0,'This is a dummy desc',17000,'2024-03-27 00:18:40',1,8,1,NULL,NULL,0);
/*!40000 ALTER TABLE `delivery_requests` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `office_types`
--

DROP TABLE IF EXISTS `office_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `office_types` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `office_types`
--

LOCK TABLES `office_types` WRITE;
/*!40000 ALTER TABLE `office_types` DISABLE KEYS */;
INSERT INTO `office_types` VALUES (1,'HUB'),(2,'WAREHOUSE'),(3,'DC');
/*!40000 ALTER TABLE `office_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `package_deliveries`
--

DROP TABLE IF EXISTS `package_deliveries`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `package_deliveries` (
  `id` int NOT NULL AUTO_INCREMENT,
  `status` varchar(100) DEFAULT NULL,
  `delivery_req_id` int NOT NULL,
  `staff_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `package_deliveries_delivery_requests_FK` (`delivery_req_id`),
  KEY `package_deliveries_staff_FK` (`staff_id`),
  CONSTRAINT `package_deliveries_delivery_requests_FK` FOREIGN KEY (`delivery_req_id`) REFERENCES `delivery_requests` (`id`) ON DELETE RESTRICT,
  CONSTRAINT `package_deliveries_staff_FK` FOREIGN KEY (`staff_id`) REFERENCES `staff` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `package_deliveries`
--

LOCK TABLES `package_deliveries` WRITE;
/*!40000 ALTER TABLE `package_deliveries` DISABLE KEYS */;
/*!40000 ALTER TABLE `package_deliveries` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `package_histories`
--

DROP TABLE IF EXISTS `package_histories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `package_histories` (
  `id` int NOT NULL AUTO_INCREMENT,
  `time` date DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `metadata_url` varchar(255) DEFAULT NULL,
  `package_delivery_id` int NOT NULL,
  `staff_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `package_histories_ibfk_1` (`package_delivery_id`),
  KEY `package_histories_staff_FK` (`staff_id`),
  CONSTRAINT `package_histories_ibfk_1` FOREIGN KEY (`package_delivery_id`) REFERENCES `package_deliveries` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `package_histories_staff_FK` FOREIGN KEY (`staff_id`) REFERENCES `staff` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `package_histories`
--

LOCK TABLES `package_histories` WRITE;
/*!40000 ALTER TABLE `package_histories` DISABLE KEYS */;
/*!40000 ALTER TABLE `package_histories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff`
--

DROP TABLE IF EXISTS `staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `staff` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '-',
  `fullname` varchar(100) DEFAULT NULL,
  `office_city_id` int DEFAULT NULL,
  `office_type_id` int DEFAULT NULL,
  `password` varchar(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `staff_unique` (`email`,`phone`,`username`),
  KEY `staff_cities_FK` (`office_city_id`),
  KEY `staff_office_types_FK` (`office_type_id`),
  CONSTRAINT `staff_cities_FK` FOREIGN KEY (`office_city_id`) REFERENCES `cities` (`id`),
  CONSTRAINT `staff_office_types_FK` FOREIGN KEY (`office_type_id`) REFERENCES `office_types` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff`
--

LOCK TABLES `staff` WRITE;
/*!40000 ALTER TABLE `staff` DISABLE KEYS */;
INSERT INTO `staff` VALUES (1,'admin@admin.id','-','Admin',1,2,'8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918','admin'),(2,'admin_wh.jkt@sms.id','-','Admin JKT WH',1,2,'f149d5dfcd5032d2994a5ee49e9d164e454f90b77a651d97d4bd073c7754580d','admin_jkt_wh'),(3,'admin_hub.jkt@sms.id','-','Admin JKT Hub',1,1,'3d84828ff98cf3d3f974f118f8e5e7cc33a6c4feed7ba2f72407e00382ada458','admin_jkt_hub'),(4,'admin_hub.me@sms.id','-','Admin ME Hub',16,1,'4eaea8e3259bdf1bae0c82809b3bd98f0325098d96bc76936d6c7d63c3e35c59','admin_me_hub'),(5,'admin_wh.me@sms.id','-','Admin ME WH',16,2,'c284acc2569010d3c89f9ad6db5499996dba67a37bfe2cc06af9bc5accffc6a5','admin_me_wh'),(6,'admin_dc.me@sms.id','-','Admin ME DC',16,3,'96b5433c4589dd4a18cc17dfb4192f393fcf7daa5fbd92517effcd03ed93858c','admin_me_dc'),(7,'admin_dc.jkt@sms.id','-','Admin JKT DC',1,3,'ab1bfb6e4b72bd9dee230579b899c9634fd169665e3102b8180b3b89c008c9d8','admin_jkt_dc'),(8,'admin_hub.bdg@sms.id','-','Admin BDG Hub',6,1,'f8302f6125a5fdaec8c65621177a6ad76aea8f97ba1ccaebedf3c5acec69b195','admin_bdg_hub'),(9,'admin_wh.bdg@sms.id','-','Admin BDG WH',6,2,'0b546ed500ec8b2bf120eaf27695d8fe18cd6b8467bf566de0b49ce552cc7714','admin_bdg_wh'),(10,'admin_dc.bdg@sms.id','-','Admin BDG DC',6,3,'9d1a5ab9edbf5b79046a03c46f179867b3ae0ead2f29f7e73bf5191c1f67b65d','admin_bdg_dc'),(11,'admin_hub.sem@sms.id','-','Admin SEM Hub',8,1,'83c552203a6c1434c0cf05a3625d35df0de223f1fb09d78819745373b40ec80d','admin_sem_hub'),(12,'admin_wh.sem@sms.id','-','Admin SEM WH',8,2,'2d4807f31edc5a1c81f9c742a813d0866622e08a5c8ea3901bdaea8bed9bd7e0','admin_sem_wh'),(13,'admin_dc.sem@sms.id','-','Admin SEM DC',8,3,'91c58ecc66b4141e7e58011dc7f3e2a99c8c58153df60462f62bdf21587cb617','admin_sem_dc'),(14,'admin_hub.sby@sms.id','-','Admin SBY Hub',9,1,'a95005af58ca8f2fe4690fba49ace4bf6e2cfb3d7fd6c48009d08ab6a8ad43de','admin_sby_hub'),(15,'admin_wh.sby@sms.id','-','Admin SBY WH',9,2,'f180d0cba49b8b1832f88f05b7fa0c6a2fd3005b328e2bb87eb0bd9c07a2e347','admin_sby_wh'),(16,'admin_dc.sby@sms.id','-','Admin SBY DC',9,3,'092c5d840440bee5e8fb8b57e320c134d8540ccb12e75d37fc3a2bc1dc447a99','admin_sby_dc');
/*!40000 ALTER TABLE `staff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'shipment_management'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-03-27  0:22:35
