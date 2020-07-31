/*
 Navicat Premium Data Transfer

 Source Server         : Test
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost:3306
 Source Schema         : siliuji

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : 65001

 Date: 31/07/2020 15:24:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cetfour
-- ----------------------------
DROP TABLE IF EXISTS `cetfour`;
CREATE TABLE `cetfour`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '四级报名id',
  `name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '报名人姓名',
  `sex` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `faculty` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '院系',
  `profession` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '专业',
  `stuid` int(10) NULL DEFAULT NULL COMMENT '学号',
  `state` int(10) NULL DEFAULT NULL COMMENT '报名状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cetfour
-- ----------------------------
INSERT INTO `cetfour` VALUES (1, '张三', '男', '机械学院', '自动化专业', 123, 2);

-- ----------------------------
-- Table structure for cetsix
-- ----------------------------
DROP TABLE IF EXISTS `cetsix`;
CREATE TABLE `cetsix`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '六级报名id',
  `name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '报名人姓名',
  `sex` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `faculty` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '院系',
  `profession` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '专业',
  `stuid` int(10) NULL DEFAULT NULL COMMENT '学号',
  `state` int(10) NULL DEFAULT NULL COMMENT '报名状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cetsix
-- ----------------------------
INSERT INTO `cetsix` VALUES (1, '撒带发', '男', '多收分', '撒带发', 123, 2);

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `desc` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES (1, '学生', '查看自己的个人信息及报名', 1);
INSERT INTO `department` VALUES (2, '超级管理员', '拥有所有的权限', 1);

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `telephone` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `hiredate` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '入职时间',
  `state` int(11) NULL DEFAULT NULL COMMENT '状态 离职-0在职-1',
  `deptID` int(11) NULL DEFAULT NULL COMMENT '部门ID',
  `roleID` int(11) NULL DEFAULT NULL COMMENT '角色ID',
  `stuid` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '学号',
  `loginID` int(11) NULL DEFAULT NULL,
  `portrait` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES (1, '张三', '18523649853', '2018-09-16 00:00:00', 1, 1, 1, '123', 1, '/images/1.jpg');
INSERT INTO `employee` VALUES (2, '李四', '15645685122', '2018-09-15 00:00:00', 1, 2, 2, '456', 2, '/images/2.jpg');
INSERT INTO `employee` VALUES (3, '王五', '123456789', '2018-09-16 00:00:00', 1, 1, 1, '789', 3, '/images/3.jpg');
INSERT INTO `employee` VALUES (9, '周杰伦', '13071787522', '2018-09-18 00:05:00', 3, 1, 1, '1111', 4, '/images/4.jpg');

-- ----------------------------
-- Table structure for exatime
-- ----------------------------
DROP TABLE IF EXISTS `exatime`;
CREATE TABLE `exatime`  (
  `id` int(10) NOT NULL,
  `type` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '考试类别',
  `starttime` datetime(6) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '开始时间',
  `stoptime` datetime(6) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '结束时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of exatime
-- ----------------------------
INSERT INTO `exatime` VALUES (1, '四级考试报名时间安排', '2010-08-07 04:21:54.000000', '2021-04-22 12:00:29.000000');
INSERT INTO `exatime` VALUES (2, '六级考试报名时间安排', '2019-04-02 08:00:00.000000', '2020-07-09 08:00:00.000000');

-- ----------------------------
-- Table structure for login
-- ----------------------------
DROP TABLE IF EXISTS `login`;
CREATE TABLE `login`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of login
-- ----------------------------
INSERT INTO `login` VALUES (1, '123', '123');
INSERT INTO `login` VALUES (2, '456', '456');
INSERT INTO `login` VALUES (3, '789', '789');
INSERT INTO `login` VALUES (4, '1111', '1111');

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公告名字',
  `content` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公告内容',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES (1, '疫情期间四六级报名通知', '★ 报名条件★\n\n1．全日制普通本科、研究生在校学生；\n\n2．各类全日制成人本科、专科在校学生；\n\n3．欢迎报名');

-- ----------------------------
-- Table structure for perinfo
-- ----------------------------
DROP TABLE IF EXISTS `perinfo`;
CREATE TABLE `perinfo`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `sex` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `faculty` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '院系',
  `profession` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '专业',
  `stuid` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学号',
  `fourresults` int(10) NULL DEFAULT NULL COMMENT '四级成绩',
  `sixresults` int(10) NULL DEFAULT NULL COMMENT '六级成绩',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of perinfo
-- ----------------------------
INSERT INTO `perinfo` VALUES (1, '张三', '男', '大数据学院', '大数据分析', '123', 426, NULL);
INSERT INTO `perinfo` VALUES (2, '李四', '男', '英语学院', '专业英语', '456', NULL, NULL);
INSERT INTO `perinfo` VALUES (3, '王五', '男', '工程学院', '土木工程', '789', NULL, NULL);
INSERT INTO `perinfo` VALUES (4, '周杰伦', '男', '音乐学院', '民谣', '1111', NULL, NULL);

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parentid` int(11) NULL DEFAULT NULL,
  `url` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `desc` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES (1, 0, 'persionInfo.html', '个人中心', '');
INSERT INTO `permission` VALUES (2, 1, '', '', '');
INSERT INTO `permission` VALUES (3, 0, 'fourEnglish.html', '四级报名', '');
INSERT INTO `permission` VALUES (5, 3, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (6, 0, 'sixEnglish.html', '六级报名', '');
INSERT INTO `permission` VALUES (7, 6, '', '', '');
INSERT INTO `permission` VALUES (8, 0, 'admincetfour.html', '四级报名信息', '');
INSERT INTO `permission` VALUES (10, 8, '', '', '');
INSERT INTO `permission` VALUES (11, 0, 'admincetsix.html', '六级报名信息', '六级报名信息');
INSERT INTO `permission` VALUES (12, 11, '', '', '');
INSERT INTO `permission` VALUES (14, 0, 'adminnotice.html', '公告管理', NULL);
INSERT INTO `permission` VALUES (15, 14, NULL, '', '');
INSERT INTO `permission` VALUES (16, 0, 'adminexatime.html', '考试时间安排', '');
INSERT INTO `permission` VALUES (17, 16, '', '', '');
INSERT INTO `permission` VALUES (18, 0, 'updatePwd.html', '修改密码', NULL);
INSERT INTO `permission` VALUES (19, 18, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for reqmsg
-- ----------------------------
DROP TABLE IF EXISTS `reqmsg`;
CREATE TABLE `reqmsg`  (
  `req_id` int(3) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `req_time` date NULL DEFAULT NULL COMMENT '请求时间',
  `ware_houseId` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '仓库号',
  `entity_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '实体编号',
  `device_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '设备编号',
  PRIMARY KEY (`req_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of reqmsg
-- ----------------------------
INSERT INTO `reqmsg` VALUES (1, '2020-07-15', '0023', '23', '4');

-- ----------------------------
-- Table structure for role_per
-- ----------------------------
DROP TABLE IF EXISTS `role_per`;
CREATE TABLE `role_per`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rid` int(11) NULL DEFAULT NULL,
  `pid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of role_per
-- ----------------------------
INSERT INTO `role_per` VALUES (1, 1, 2);
INSERT INTO `role_per` VALUES (2, 1, 5);
INSERT INTO `role_per` VALUES (3, 1, 7);
INSERT INTO `role_per` VALUES (4, 2, 10);
INSERT INTO `role_per` VALUES (5, 2, 12);
INSERT INTO `role_per` VALUES (6, 2, 15);
INSERT INTO `role_per` VALUES (7, 2, 17);
INSERT INTO `role_per` VALUES (8, 1, 19);

SET FOREIGN_KEY_CHECKS = 1;
