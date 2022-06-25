/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 80029
Source Host           : localhost:3306
Source Database       : jdbcstudy

Target Server Type    : MYSQL
Target Server Version : 80029
File Encoding         : 65001

Date: 2022-06-24 16:21:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `CustomerPhone` char(11) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `CustomerPassword` char(20) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `CustomerName` char(20) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL,
  `CustomerID` char(18) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL,
  `CustomerSex` char(1) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL,
  `CustomerAge` char(5) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`CustomerPhone`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('12345654321', 'wewewe', '一条小团团', '12121212121', '1', '20');
INSERT INTO `customer` VALUES ('12345678901', '123456', '张四', '123456789123456789', '1', '21');
INSERT INTO `customer` VALUES ('12345678902', '2345678', '李四', '123456789987654321', '1', '22');
INSERT INTO `customer` VALUES ('12345678904', 'qwqwqw', '测试员3', '123456789012345678', null, '22');
INSERT INTO `customer` VALUES ('13643302615', 'wuwuwu', '测试员', null, null, '22');
INSERT INTO `customer` VALUES ('15032145680', '732zhao', '赵六', '130132456789045671', '0', '21');
INSERT INTO `customer` VALUES ('15032168451', '523wang', '王五', '130132200010262856', '0', '65');
INSERT INTO `customer` VALUES ('15075100853', '527wu', '吴迪呀', '130132200110157896', '1', '34');
INSERT INTO `customer` VALUES ('15075100888', 'weweewe', '二狗字', '15012121212120121', '0', '43');

-- ----------------------------
-- Table structure for feedback
-- ----------------------------
DROP TABLE IF EXISTS `feedback`;
CREATE TABLE `feedback` (
  `servicerid` char(20) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `customerid` char(20) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `Feedback_content` char(100) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `Feedback_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of feedback
-- ----------------------------
INSERT INTO `feedback` VALUES ('JD001', '12345654321', '空调太垃圾了', '2022-05-24');
INSERT INTO `feedback` VALUES ('JD002', '12345654321', '组员太摆了', '2022-05-24');
INSERT INTO `feedback` VALUES ('JD003', '12345654321', '上号太多了', '2022-05-24');
INSERT INTO `feedback` VALUES ('123', '12345654321', '怎么酒店不能上网，，我的评价是不如网吧', '2022-05-24');

-- ----------------------------
-- Table structure for guarantee_information
-- ----------------------------
DROP TABLE IF EXISTS `guarantee_information`;
CREATE TABLE `guarantee_information` (
  `guarantee_type` char(10) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `guarantee_information_content` char(100) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `guarantee_information_costs` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of guarantee_information
-- ----------------------------
INSERT INTO `guarantee_information` VALUES ('维修', '修空调', '100');
INSERT INTO `guarantee_information` VALUES ('维修', '冲网费', '10');
INSERT INTO `guarantee_information` VALUES ('维修', '换组员', '11000');
INSERT INTO `guarantee_information` VALUES ('维修', '买皮肤', '100000000');
INSERT INTO `guarantee_information` VALUES ('入住', '大床房一晚', '1000');

-- ----------------------------
-- Table structure for handel
-- ----------------------------
DROP TABLE IF EXISTS `handel`;
CREATE TABLE `handel` (
  `HotelStaffNo` char(5) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `OrderNo` char(10) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `RoomNo` char(5) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `Handeldate` date NOT NULL,
  PRIMARY KEY (`HotelStaffNo`,`OrderNo`,`RoomNo`) USING BTREE,
  KEY `FK_handel` (`RoomNo`) USING BTREE,
  KEY `FK_handel3` (`OrderNo`) USING BTREE,
  CONSTRAINT `handel_ibfk_1` FOREIGN KEY (`RoomNo`) REFERENCES `room` (`RoomNo`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `handel_ibfk_2` FOREIGN KEY (`HotelStaffNo`) REFERENCES `hotelstaff` (`HotelStaffNo`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `handel_ibfk_3` FOREIGN KEY (`OrderNo`) REFERENCES `roomorder` (`OrderNo`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of handel
-- ----------------------------
INSERT INTO `handel` VALUES ('12345', 'JD01', '1001', '2022-05-24');
INSERT INTO `handel` VALUES ('12345', 'JD010', '4003', '2022-05-27');
INSERT INTO `handel` VALUES ('12345', 'JD07', '4002', '2022-05-27');
INSERT INTO `handel` VALUES ('12345', 'JD09', '4001', '2022-05-24');
INSERT INTO `handel` VALUES ('JD001', 'JD011', '3001', '2022-05-26');
INSERT INTO `handel` VALUES ('JD001', 'JD03', '1002', '2022-05-18');
INSERT INTO `handel` VALUES ('JD001', 'JD05', '2001', '2022-05-03');

-- ----------------------------
-- Table structure for hoteladministrator
-- ----------------------------
DROP TABLE IF EXISTS `hoteladministrator`;
CREATE TABLE `hoteladministrator` (
  `hoteladministratorNo` char(5) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `hoteladministratorPassword` char(20) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`hoteladministratorNo`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of hoteladministrator
-- ----------------------------
INSERT INTO `hoteladministrator` VALUES ('123', '123');

-- ----------------------------
-- Table structure for hotelstaff
-- ----------------------------
DROP TABLE IF EXISTS `hotelstaff`;
CREATE TABLE `hotelstaff` (
  `HotelStaffNo` char(5) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `HotelStaffPassword` char(20) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `HotelStaffName` char(20) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `HotelStaffSex` char(1) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `HotelStaffPhone` char(11) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`HotelStaffNo`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of hotelstaff
-- ----------------------------
INSERT INTO `hotelstaff` VALUES ('12345', '1234567', '员工刘', '1', '15075100853');
INSERT INTO `hotelstaff` VALUES ('JD001', 'JD12345678', '员工赵', '1', '15075100259');
INSERT INTO `hotelstaff` VALUES ('JD002', 'JD23456789', '员工周', '0', '15204521075');
INSERT INTO `hotelstaff` VALUES ('JD003', 'JD1015wu', '员工吴', '1', '15702254852');

-- ----------------------------
-- Table structure for hotel_customer_service
-- ----------------------------
DROP TABLE IF EXISTS `hotel_customer_service`;
CREATE TABLE `hotel_customer_service` (
  `hotel_customer_serviceNo` char(5) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `hotel_customer_servicePassword` char(20) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `hotel_customer_serviceName` char(20) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `hotel_customer_serviceSex` char(1) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `hotel_customer_servicePhone` char(11) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`hotel_customer_serviceNo`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of hotel_customer_service
-- ----------------------------
INSERT INTO `hotel_customer_service` VALUES ('123', '123', '客服王', '1', '15075100853');
INSERT INTO `hotel_customer_service` VALUES ('JD001', 'JD12345678', '客服赵', '1', '15075100259');
INSERT INTO `hotel_customer_service` VALUES ('JD002', 'JD23456789', '客服周', '0', '15204521075');
INSERT INTO `hotel_customer_service` VALUES ('JD003', 'JD1015wu', '客服吴', '1', '15702254852');

-- ----------------------------
-- Table structure for hotel_finance_staff
-- ----------------------------
DROP TABLE IF EXISTS `hotel_finance_staff`;
CREATE TABLE `hotel_finance_staff` (
  `hotel_finance_staffNo` char(5) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `hotel_finance_staffPassword` char(20) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `hotel_finance_staffName` char(20) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `hotel_finance_staffSex` char(1) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `hotel_finance_staffPhone` char(11) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`hotel_finance_staffNo`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of hotel_finance_staff
-- ----------------------------
INSERT INTO `hotel_finance_staff` VALUES ('123', '123', '财务部王', '1', '15075100853');
INSERT INTO `hotel_finance_staff` VALUES ('JD001', 'JD12345678', '财务部赵', '1', '15075100259');
INSERT INTO `hotel_finance_staff` VALUES ('JD002', 'JD23456789', '财务部周', '0', '15204521075');
INSERT INTO `hotel_finance_staff` VALUES ('JD003', 'JD1015wu', '财务部吴', '1', '15702254852');

-- ----------------------------
-- Table structure for hotel_maintenance_staff
-- ----------------------------
DROP TABLE IF EXISTS `hotel_maintenance_staff`;
CREATE TABLE `hotel_maintenance_staff` (
  `hotel_maintenance_staffNo` char(5) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `hotel_maintenance_staffPassword` char(20) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `hotel_maintenance_staffName` char(20) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `hotel_maintenance_staffSex` char(1) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `hotel_maintenance_staffPhone` char(11) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`hotel_maintenance_staffNo`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of hotel_maintenance_staff
-- ----------------------------
INSERT INTO `hotel_maintenance_staff` VALUES ('123', '123', '维修人员王', '1', '15075100853');
INSERT INTO `hotel_maintenance_staff` VALUES ('JD001', 'JD12345678', '维修人员赵', '1', '15075100259');
INSERT INTO `hotel_maintenance_staff` VALUES ('JD002', 'JD23456789', '维修人员周', '0', '15204521075');
INSERT INTO `hotel_maintenance_staff` VALUES ('JD003', 'JD1015wu', '维修人员吴', '1', '15702254852');

-- ----------------------------
-- Table structure for maintenance_information
-- ----------------------------
DROP TABLE IF EXISTS `maintenance_information`;
CREATE TABLE `maintenance_information` (
  `RoomNo` char(5) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `hotel_maintenance_staffNo` char(20) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `Repair_content` char(100) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `Maintenance_costs` int NOT NULL,
  PRIMARY KEY (`RoomNo`,`hotel_maintenance_staffNo`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of maintenance_information
-- ----------------------------
INSERT INTO `maintenance_information` VALUES ('1001', '123', '电视坏了', '100');
INSERT INTO `maintenance_information` VALUES ('1002', '123', '空调坏了', '10');
INSERT INTO `maintenance_information` VALUES ('1003', '123', '酒店太垃圾了', '11000');
INSERT INTO `maintenance_information` VALUES ('1004', '123', '文档小子太少了', '100000000');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `out_trade_no` varchar(20) NOT NULL,
  `subject` varchar(20) NOT NULL,
  `total_amount` varchar(10) NOT NULL,
  `description` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`out_trade_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of order
-- ----------------------------

-- ----------------------------
-- Table structure for room
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room` (
  `RoomNo` char(5) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `RoomTypeNo` char(3) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `RoomStatus` int NOT NULL,
  `RoomFloor` char(5) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`RoomNo`) USING BTREE,
  KEY `FK_have` (`RoomTypeNo`) USING BTREE,
  CONSTRAINT `room_ibfk_1` FOREIGN KEY (`RoomTypeNo`) REFERENCES `roomtype` (`RoomTypeNo`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of room
-- ----------------------------
INSERT INTO `room` VALUES ('1001', '001', '0', '一楼东');
INSERT INTO `room` VALUES ('1002', '001', '1', '一楼西');
INSERT INTO `room` VALUES ('1003', '001', '1', '一楼北');
INSERT INTO `room` VALUES ('2001', '002', '1', '二楼东');
INSERT INTO `room` VALUES ('2002', '002', '1', '二楼西');
INSERT INTO `room` VALUES ('2003', '002', '1', '二楼北');
INSERT INTO `room` VALUES ('3001', '003', '0', '三楼东');
INSERT INTO `room` VALUES ('3002', '003', '1', '三楼西');
INSERT INTO `room` VALUES ('3003', '003', '1', '三楼北');
INSERT INTO `room` VALUES ('4001', '004', '0', '四楼东');
INSERT INTO `room` VALUES ('4002', '004', '1', '四楼西');
INSERT INTO `room` VALUES ('4003', '004', '0', '四楼北');

-- ----------------------------
-- Table structure for roomorder
-- ----------------------------
DROP TABLE IF EXISTS `roomorder`;
CREATE TABLE `roomorder` (
  `HotelstaffNo` char(10) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `OrderNo` char(10) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `CustomerPhone` char(11) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `inttime` date NOT NULL,
  `outtime` date NOT NULL,
  `RoomTypeName` char(5) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL,
  `OrderStatus` int DEFAULT NULL,
  PRIMARY KEY (`OrderNo`) USING BTREE,
  KEY `FK_place` (`CustomerPhone`) USING BTREE,
  CONSTRAINT `roomorder_ibfk_1` FOREIGN KEY (`CustomerPhone`) REFERENCES `customer` (`CustomerPhone`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of roomorder
-- ----------------------------
INSERT INTO `roomorder` VALUES ('12345', 'JD01', '12345654321', '2022-05-24', '2022-05-25', '单人房', '0');
INSERT INTO `roomorder` VALUES ('12345', 'JD010', '12345654321', '2022-05-31', '2022-06-02', '豪华房', '0');
INSERT INTO `roomorder` VALUES ('12345', 'JD011', '15032145680', '2022-05-26', '2022-05-27', '大床房', '0');
INSERT INTO `roomorder` VALUES ('12345', 'JD02', '12345678901', '2022-05-25', '2022-05-26', '单人房', '1');
INSERT INTO `roomorder` VALUES ('12345', 'JD03', '12345654321', '2022-05-18', '2022-05-19', '单人房', '2');
INSERT INTO `roomorder` VALUES ('12345', 'JD04', '12345678901', '2022-05-27', '2022-05-28', '单人房', '1');
INSERT INTO `roomorder` VALUES ('12345', 'JD05', '12345678902', '2022-05-03', '2022-05-04', '双人房', '2');
INSERT INTO `roomorder` VALUES ('12345', 'JD06', '15075100888', '2022-06-01', '2022-06-02', '双人房', '1');
INSERT INTO `roomorder` VALUES ('12345', 'JD07', '12345678904', '2022-06-02', '2022-06-03', '豪华房', '2');
INSERT INTO `roomorder` VALUES ('12345', 'JD08', '15075100853', '2022-05-31', '2022-06-01', '大床房', '1');
INSERT INTO `roomorder` VALUES ('12345', 'JD09', '15032168451', '2022-05-24', '2022-05-26', '豪华房', '0');

-- ----------------------------
-- Table structure for roomtype
-- ----------------------------
DROP TABLE IF EXISTS `roomtype`;
CREATE TABLE `roomtype` (
  `RoomTypeNo` char(3) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `RoomTypeName` char(5) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `RoomNumber` int NOT NULL,
  `RoomPrice` float(5,2) NOT NULL,
  PRIMARY KEY (`RoomTypeNo`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of roomtype
-- ----------------------------
INSERT INTO `roomtype` VALUES ('001', '单人房', '0', '110.00');
INSERT INTO `roomtype` VALUES ('002', '双人房', '2', '200.00');
INSERT INTO `roomtype` VALUES ('003', '大床房', '1', '180.00');
INSERT INTO `roomtype` VALUES ('004', '豪华房', '1', '400.00');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL,
  `nickname` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL,
  `age` int DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '1', '1', '1', '1', '1', '1');
INSERT INTO `user` VALUES ('2', '1', null, null, null, null, null);
INSERT INTO `user` VALUES ('3', '1', null, '1', '1', '男', '1');
INSERT INTO `user` VALUES ('4', '2', null, '2', '2', '女', '2');
INSERT INTO `user` VALUES ('5', '1', null, '2', '3', '4', '5');
INSERT INTO `user` VALUES ('6', '123', null, '1', '1', '男', '1');
INSERT INTO `user` VALUES ('7', '吴浦凡', null, '吴迪伢', '21', '男', '河北省');
