-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: quanlyxekhach
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment` (
  `id` int NOT NULL AUTO_INCREMENT,
  `content` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `garageId` int NOT NULL,
  `userId` int NOT NULL,
  `created_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_comment_garage_idx` (`garageId`),
  KEY `fk_comment_user_idx` (`userId`),
  CONSTRAINT `fk_comment_garage` FOREIGN KEY (`garageId`) REFERENCES `garage` (`id`),
  CONSTRAINT `fk_comment_user` FOREIGN KEY (`userId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (1,'Nhà xe chất lượng',4,1,'2022-08-11 00:00:00'),(2,'Phục vụ tận tình',4,1,'2022-10-11 00:00:00'),(3,'Chất lượng 5 sao',4,1,'2022-08-11 00:00:00'),(4,'Chất lượng tuyệt vời',4,1,'2022-08-22 00:00:00'),(5,'Nhà xe chu đáo',4,1,'2022-08-22 00:00:00'),(6,'Nhà xe tận tâm',4,1,'2022-08-22 00:00:00'),(7,'Nhà xe tốt',4,1,'2022-08-22 00:00:00'),(8,'Nhà xe phục vụ 5 sao',4,1,'2022-08-22 00:00:00'),(9,'test',4,1,'2022-08-22 00:00:00'),(10,'test 2',4,1,'2022-08-22 00:00:00'),(11,'test 3',4,1,'2022-08-22 00:00:00'),(12,'test 4',4,1,'2022-08-22 00:00:00'),(13,'tét 5',4,1,'2022-08-22 00:00:00'),(14,'test 6',4,1,'2022-08-22 00:00:00'),(15,'test 7',4,1,'2022-08-22 00:00:00'),(16,'test 8',4,1,'2022-08-22 00:00:00'),(17,'test 8',4,1,'2022-08-22 00:00:00'),(18,'test 98',4,1,'2022-08-22 00:00:00'),(19,'test 90',4,1,'2022-08-22 00:00:00'),(20,'test 901',4,1,'2022-08-22 00:00:00'),(21,'test 123',4,1,'2022-08-22 00:00:00'),(22,'Nhà xe tốt',2,1,'2022-08-24 00:00:00'),(23,'Xe tootys',4,3,'2022-08-24 00:00:00');
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `garage`
--

DROP TABLE IF EXISTS `garage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `garage` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `thumbnail` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `isActive` bit(1) NOT NULL,
  `isAllowed` bit(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `garage`
--

LOCK TABLES `garage` WRITE;
/*!40000 ALTER TABLE `garage` DISABLE KEYS */;
INSERT INTO `garage` VALUES (1,'Nhà xe Bảy Tàu','https://res.cloudinary.com/dwgjmgf6o/image/upload/v1661172802/L%E1%BA%ADp%20tr%C3%ACnh%20Java/Garage_Thumbnail/baytau_xrqp5w.jpg',_binary '',_binary ''),(2,'Nhà xe Phương Trang','https://res.cloudinary.com/dwgjmgf6o/image/upload/v1661172732/L%E1%BA%ADp%20tr%C3%ACnh%20Java/Garage_Thumbnail/futa_aeslfq.jpg',_binary '',_binary ''),(3,'Nhà xe Thành Bưởi','https://res.cloudinary.com/dwgjmgf6o/image/upload/v1661172972/L%E1%BA%ADp%20tr%C3%ACnh%20Java/Garage_Thumbnail/thanhbuoi_qmlek2.jpg',_binary '',_binary ''),(4,'Nhà xe Bảy Tàu','https://res.cloudinary.com/dwgjmgf6o/image/upload/v1661172802/L%E1%BA%ADp%20tr%C3%ACnh%20Java/Garage_Thumbnail/baytau_xrqp5w.jpg',_binary '\0',_binary ''),(6,'Nhà xe chưa đăng ký','https://res.cloudinary.com/dwgjmgf6o/image/upload/v1661588018/wklf9igkqaa2glnk1gub.jpg',_binary '\0',_binary ''),(7,'Nhà xe chưa đăng ký','https://res.cloudinary.com/dwgjmgf6o/image/upload/v1661588085/gbmyyzu8fmxqf415k4li.jpg',_binary '\0',_binary '\0');
/*!40000 ALTER TABLE `garage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `location`
--

DROP TABLE IF EXISTS `location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `location` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location`
--

LOCK TABLES `location` WRITE;
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
/*!40000 ALTER TABLE `location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_detail`
--

DROP TABLE IF EXISTS `order_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_detail` (
  `id` int NOT NULL AUTO_INCREMENT,
  `orderId` int NOT NULL,
  `routeId` int NOT NULL,
  `unit_price` decimal(10,0) NOT NULL,
  `num` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_orderdetail_saleorder_idx` (`orderId`),
  KEY `fk_orderdetail_route_idx` (`routeId`),
  CONSTRAINT `fk_orderdetail_route` FOREIGN KEY (`routeId`) REFERENCES `route` (`id`),
  CONSTRAINT `fk_orderdetail_saleorder` FOREIGN KEY (`orderId`) REFERENCES `sale_order` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_detail`
--

LOCK TABLES `order_detail` WRITE;
/*!40000 ALTER TABLE `order_detail` DISABLE KEYS */;
INSERT INTO `order_detail` VALUES (12,14,1,300000,1),(13,14,1,300000,1),(14,14,1,300000,1),(15,15,1,300000,1),(16,15,1,300000,1),(17,16,1,300000,1),(18,17,1,300000,1),(19,17,1,300000,1),(20,18,1,300000,1),(21,19,1,300000,2),(22,19,1,300000,1),(23,19,1,300000,2),(24,20,1,300000,1),(25,20,1,300000,1),(26,20,1,300000,1),(27,20,1,300000,1),(28,21,1,300000,1),(29,21,1,300000,2),(30,21,1,300000,2),(31,22,1,300000,1),(32,22,1,300000,1),(33,24,1,300000,1),(34,24,1,300000,1),(35,24,1,300000,1),(36,25,1,300000,1),(37,25,1,300000,1),(38,26,8,300000,1),(39,26,8,300000,1),(40,27,2,275000,1),(41,27,2,275000,1),(42,28,2,275000,1),(43,28,2,275000,1);
/*!40000 ALTER TABLE `order_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `route`
--

DROP TABLE IF EXISTS `route`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `route` (
  `id` int NOT NULL AUTO_INCREMENT,
  `departure` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `destination` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `thumbnail` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `price` decimal(10,0) NOT NULL,
  `garageId` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_route_garage_idx` (`garageId`),
  CONSTRAINT `fk_route_garage` FOREIGN KEY (`garageId`) REFERENCES `garage` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `route`
--

LOCK TABLES `route` WRITE;
/*!40000 ALTER TABLE `route` DISABLE KEYS */;
INSERT INTO `route` VALUES (1,'Sài Gòn','Đà Lạt','https://res.cloudinary.com/dwgjmgf6o/image/upload/v1659806269/L%E1%BA%ADp%20tr%C3%ACnh%20Java/Route_Thumbnail/saigon_dalat_qks4wb.png',300000,1),(2,'Sài Gòn','Nha Trang','https://res.cloudinary.com/dwgjmgf6o/image/upload/v1659806408/L%E1%BA%ADp%20tr%C3%ACnh%20Java/Route_Thumbnail/saigon_nhatrang_flb7lv.png',275000,1),(3,'Sài Gòn','Đà Nẵng','https://res.cloudinary.com/dwgjmgf6o/image/upload/v1659806412/L%E1%BA%ADp%20tr%C3%ACnh%20Java/Route_Thumbnail/saigon_danang_byxzyi.png',395000,1),(8,'Sài Gòn','Đà Lạt','https://res.cloudinary.com/dwgjmgf6o/image/upload/v1659806269/L%E1%BA%ADp%20tr%C3%ACnh%20Java/Route_Thumbnail/saigon_dalat_qks4wb.png',300000,2);
/*!40000 ALTER TABLE `route` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sale_order`
--

DROP TABLE IF EXISTS `sale_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sale_order` (
  `id` int NOT NULL AUTO_INCREMENT,
  `amount` decimal(10,0) NOT NULL,
  `created_date` datetime NOT NULL,
  `userId` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_saleorder_user_idx` (`userId`),
  CONSTRAINT `fk_saleorder_user` FOREIGN KEY (`userId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sale_order`
--

LOCK TABLES `sale_order` WRITE;
/*!40000 ALTER TABLE `sale_order` DISABLE KEYS */;
INSERT INTO `sale_order` VALUES (14,900000,'2022-08-25 00:00:00',1),(15,600000,'2022-08-26 00:00:00',1),(16,300000,'2022-08-27 00:00:00',1),(17,600000,'2022-08-27 00:00:00',1),(18,300000,'2022-08-27 00:00:00',1),(19,900000,'2022-08-27 00:00:00',1),(20,1200000,'2022-08-27 00:00:00',1),(21,900000,'2022-08-27 00:00:00',1),(22,600000,'2022-08-27 00:00:00',1),(23,0,'2022-08-27 00:00:00',1),(24,900000,'2022-08-27 00:00:00',1),(25,600000,'2022-08-28 00:00:00',1),(26,600000,'2022-08-28 00:00:00',1),(27,550000,'2022-08-28 00:00:00',1),(28,550000,'2022-08-28 00:00:00',1);
/*!40000 ALTER TABLE `sale_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seat`
--

DROP TABLE IF EXISTS `seat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seat` (
  `id` int NOT NULL AUTO_INCREMENT,
  `code` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `isEmpty` tinyint NOT NULL,
  `isBooked` tinyint NOT NULL,
  `isBooking` tinyint NOT NULL,
  `tripId` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_seat_trip_idx` (`tripId`),
  CONSTRAINT `fk_seat_trip` FOREIGN KEY (`tripId`) REFERENCES `trip` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seat`
--

LOCK TABLES `seat` WRITE;
/*!40000 ALTER TABLE `seat` DISABLE KEYS */;
INSERT INTO `seat` VALUES (1,'A01',1,0,0,1),(2,'A02',1,0,0,1),(3,'A03',1,0,0,1),(4,'A04',1,0,0,1),(5,'A05',1,0,0,1),(6,'A06',1,0,0,1),(7,'B01',1,0,0,1),(8,'B02',1,0,0,1),(9,'B03',1,0,0,1),(10,'B04',1,0,0,1),(11,'B05',1,0,0,1),(12,'B06',1,0,0,1),(24,'A01',1,0,0,2),(25,'A02',1,0,0,2),(26,'A03',1,0,0,2),(27,'A04',1,0,0,2),(28,'A05',1,0,0,2),(29,'A06',1,0,0,2),(30,'B01',1,0,0,2),(31,'B02',1,0,0,2),(32,'B03',1,0,0,2),(33,'B04',1,0,0,2),(34,'B05',1,0,0,2),(35,'B06',1,0,0,2),(36,'A01',1,0,0,5),(37,'A02',1,0,0,5),(38,'A03',1,0,0,5),(39,'A04',1,0,0,5),(40,'A05',1,0,0,5),(41,'A06',1,0,0,5),(42,'B01',1,0,0,5),(43,'B02',1,0,0,5),(44,'B03',1,0,0,5),(45,'B04',1,0,0,5),(46,'B05',1,0,0,5),(47,'B06',1,0,0,5),(48,'A01',1,0,0,6),(49,'A02',1,0,0,6),(50,'A03',1,0,0,6),(51,'A04',1,0,0,6),(52,'A05',1,0,0,6),(53,'A06',1,0,0,6),(54,'B01',1,0,0,6),(55,'B02',1,0,0,6),(56,'B03',1,0,0,6),(57,'B04',1,0,0,6),(58,'B05',1,0,0,6),(59,'B06',1,0,0,6),(60,'A01',1,0,0,7),(61,'A02',1,0,0,7),(62,'A03',1,0,0,7),(63,'A04',1,0,0,7),(64,'A05',1,0,0,7),(65,'A06',1,0,0,7),(66,'B01',1,0,0,7),(67,'B02',1,0,0,7),(68,'B03',1,0,0,7),(69,'B04',1,0,0,7),(70,'B05',1,0,0,7),(71,'B06',1,0,0,7);
/*!40000 ALTER TABLE `seat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trip`
--

DROP TABLE IF EXISTS `trip`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trip` (
  `id` int NOT NULL AUTO_INCREMENT,
  `start_time` time NOT NULL,
  `route_id` int NOT NULL,
  `departure_date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_trip_route_idx` (`route_id`),
  CONSTRAINT `fk_trip_route` FOREIGN KEY (`route_id`) REFERENCES `route` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trip`
--

LOCK TABLES `trip` WRITE;
/*!40000 ALTER TABLE `trip` DISABLE KEYS */;
INSERT INTO `trip` VALUES (1,'16:00:00',1,'2022-08-12 00:00:00'),(2,'16:30:00',1,'2022-08-12 00:00:00'),(5,'13:39:00',2,'2022-08-12 00:00:00'),(6,'13:46:00',2,'2022-08-12 00:00:00'),(7,'13:46:00',8,'2022-08-12 00:00:00');
/*!40000 ALTER TABLE `trip` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `last_name` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `role` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `user_name` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `phone` int NOT NULL,
  `email` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `active` bit(1) NOT NULL,
  `avatar` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Hiếu','Nguyễn Đức','ADMIN','hieund','12345',123456789,'hieutk200301@gmail.com',_binary '',''),(3,'nguyen','anh','ADMIN','nva','$2a$10$ONMud4HzdJ8nJllg1Hwj/O0b5Hk2LZQjd8MmOey0CWQMzeKZNd.Fe',123456789,'nguyena@gmail.com',_binary '',''),(10,'Nguyen ','Duc Hieu','ADMIN','hieuadmin','$2a$10$TR7fRc4H94flCchjrxoA9.KcNbjkOx3TpG5xEH6i5AJXovhrq1Qgm',392737598,'hieu@gmail.com',_binary '','https://res.cloudinary.com/dwgjmgf6o/image/upload/v1661589357/e6mtlhd8uxqyo4gbqqlf.jpg'),(11,'Nguyen Duc','Hieu','USER','hieuuser1','$2a$10$tIdvjcPr3lA9walGstCqd.WZgcBH0dPrFvsazsJsNr69lEDAJlwIq',123456789,'hieu123@gmail.com',_binary '','https://res.cloudinary.com/dwgjmgf6o/image/upload/v1661590142/csuhv3fkcovp9x7szrum.jpg'),(12,'Nguyen Duc','Hieu','GARAGE_OWNER','hieunhaxe','$2a$10$.3uLqj.v7W0ks//iEJg2iu2DSnBacDxKb6dYKwiacCpgugOCNtcmS',123456789,'hieunhaxe@gmail.com',_binary '','https://res.cloudinary.com/dwgjmgf6o/image/upload/v1661590624/ejmvq7ii5h0djiigmzee.png');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-28 13:17:56
