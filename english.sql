/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : english

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 20/05/2021 09:10:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `adminId` int(0) NOT NULL AUTO_INCREMENT COMMENT 'ID号',
  `adminName` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '姓名',
  `sex` varchar(2) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '性别',
  `tel` varchar(11) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '电话号码',
  `email` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '电子邮箱',
  `pwd` varchar(16) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '密码',
  `cardId` varchar(18) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '身份证号',
  `role` varchar(1) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '角色(0管理员，1教师，2学生)',
  PRIMARY KEY (`adminId`) USING BTREE,
  INDEX `sex`(`sex`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9528 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '管理员信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (9527, '超级管理员', '男', '13658377857', '1253838283@qq.com', '123456', '3132', '0');

-- ----------------------------
-- Table structure for arrange
-- ----------------------------
DROP TABLE IF EXISTS `arrange`;
CREATE TABLE `arrange`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `age` int(0) NOT NULL,
  `gender` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `telephone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `orderTime` datetime(0) NULL DEFAULT NULL,
  `className` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of arrange
-- ----------------------------
INSERT INTO `arrange` VALUES (1, 'kzh', 21, '1', '123123', '2021-05-10 15:05:45', '初中', '1');
INSERT INTO `arrange` VALUES (2, 'yw', 22, '1', '213123', '2021-05-12 15:06:00', '高中', '0');
INSERT INTO `arrange` VALUES (3, 'wgw', 23, '1', '213123', '2021-05-03 15:06:33', '高中', '1');
INSERT INTO `arrange` VALUES (4, 'wqp', 22, '1', '12312312', '2021-05-15 16:00:00', '少儿', '0');
INSERT INTO `arrange` VALUES (5, 'wy', 22, '1', '123123123', '2021-05-15 16:00:00', '初中', '0');
INSERT INTO `arrange` VALUES (6, 'wyy', 22, '1', '123123123', '2021-05-15 16:00:00', '少儿', '0');
INSERT INTO `arrange` VALUES (7, 'avc', 22, '1', '213123213', '2021-05-15 16:00:00', '高中', '0');
INSERT INTO `arrange` VALUES (8, 'wwww', 22, '0', '2131231', '2021-05-25 16:00:00', '初中', '0');
INSERT INTO `arrange` VALUES (9, 'aaa', 21, '1', '11111', '2021-05-14 08:02:07', '2', '0');
INSERT INTO `arrange` VALUES (10, 'aaa', 21, '1', '18972363681', '2021-05-15 07:13:49', '1', '0');

-- ----------------------------
-- Table structure for banner
-- ----------------------------
DROP TABLE IF EXISTS `banner`;
CREATE TABLE `banner`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `title` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '标题',
  `imageUrl` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '图片地址',
  `linkUrl` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '链接地址',
  `sort` int(0) NULL DEFAULT 0 COMMENT '排序',
  `isDeleted` int(0) NULL DEFAULT NULL COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
  `gmtCreate` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `gmtModified` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `key` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_name`(`title`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '首页banner表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of banner
-- ----------------------------
INSERT INTO `banner` VALUES (13, '轮播图', 'https://training-english.oss-cn-beijing.aliyuncs.com/70qp.jpg', NULL, NULL, NULL, '2021-05-13 06:20:35', NULL, NULL);
INSERT INTO `banner` VALUES (15, '轮播图1', 'https://training-english.oss-cn-beijing.aliyuncs.com/iwso.jpg', NULL, NULL, NULL, '2021-05-13 06:20:55', NULL, NULL);
INSERT INTO `banner` VALUES (16, '轮播图2', 'https://training-english.oss-cn-beijing.aliyuncs.com/s0g8.jpg', NULL, NULL, NULL, '2021-05-13 06:21:06', NULL, NULL);
INSERT INTO `banner` VALUES (17, 'aaa', 'https://training-english.oss-cn-beijing.aliyuncs.com/500.jpg', NULL, NULL, NULL, '2021-05-15 07:07:20', NULL, NULL);

-- ----------------------------
-- Table structure for content
-- ----------------------------
DROP TABLE IF EXISTS `content`;
CREATE TABLE `content`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `title` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `link` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `grade` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `teacherid` int(0) NOT NULL,
  `beginTime` datetime(0) NULL DEFAULT NULL,
  `endTime` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (1, ' 少儿', 1, '2021-03-10 00:00:00', '2021-06-10 00:00:00');
INSERT INTO `course` VALUES (2, '初中', 2, '2021-03-01 00:00:00', '2021-08-01 00:00:00');
INSERT INTO `course` VALUES (3, '高中', 3, '2020-08-01 00:00:00', '2022-03-01 00:00:00');

-- ----------------------------
-- Table structure for exam_manage
-- ----------------------------
DROP TABLE IF EXISTS `exam_manage`;
CREATE TABLE `exam_manage`  (
  `examCode` int(0) NOT NULL AUTO_INCREMENT COMMENT '考试编号',
  `description` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '该次考试介绍',
  `source` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '课程名称',
  `paperId` int(0) NULL DEFAULT NULL COMMENT '试卷编号',
  `examDate` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '考试日期',
  `totalTime` int(0) NULL DEFAULT NULL COMMENT '持续时长',
  `grade` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '年级',
  `term` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '学期',
  `major` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '专业',
  `institute` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '学院',
  `totalScore` int(0) NULL DEFAULT NULL COMMENT '总分',
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '考试类型',
  `tips` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '考生须知',
  PRIMARY KEY (`examCode`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20190016 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '考试管理表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of exam_manage
-- ----------------------------
INSERT INTO `exam_manage` VALUES (20190001, '2019年上期期末考试', '奇怪的考试', 1001, '2019-03-21', 120, '2018', '1', '初中英语', '初中部', 100, '期末考试', '快乐千万条，学习第一条，平时不努力，考试两行泪。');
INSERT INTO `exam_manage` VALUES (20190002, '2019年上期期末考试', '奇怪的考试', 1002, '2019-03-07', 90, '2018', '2', '初中英语', '初中部', 100, '期末考试', '快乐千万条，学习第一条，平时不努力，考试两行泪。');
INSERT INTO `exam_manage` VALUES (20190003, '2018年下期期末考试', '奇怪的考试', 1003, '2019-02-27', 90, '2017', '1', '初中英语', '初中部', 100, '期末考试', '快乐千万条，学习第一条，平时不努力，考试两行泪。');
INSERT INTO `exam_manage` VALUES (20190005, '2018年上期期末考试', '奇怪的考试', 1004, '2019-03-14', 90, '2018', '1', '初中英语', '初中部', 100, '期末考试', '快乐千万条，学习第一条，平时不努力，考试两行泪。');
INSERT INTO `exam_manage` VALUES (20190006, '2017年上期期末考试', '奇怪的考试', 1005, '2019-03-21', 120, '2018', '1', '初中英语', '初中部', 100, '期末考试', '快乐千万条，学习第一条，平时不努力，考试两行泪。');
INSERT INTO `exam_manage` VALUES (20190007, '2018年上期期末考试', '奇怪的考试', 1006, '2019-03-13', 120, '2018', '2', '初中英语', '初中部', 100, '期末考试', '快乐千万条，学习第一条，平时不努力，考试两行泪。');
INSERT INTO `exam_manage` VALUES (20190008, '2018年下期期末考试', '奇怪的考试', 1007, '2019-03-13', 120, '2018', '1', '初中英语', '初中部', 100, '期末考试', '快乐千万条，学习第一条，平时不努力，考试两行泪。');
INSERT INTO `exam_manage` VALUES (20190009, '2018年上期期末考试', '奇怪的考试', 1008, '2019-03-07', 90, '2018', '1', '初中英语', '初中部', 100, '期末考试', '快乐千万条，学习第一条，平时不努力，考试两行泪。');
INSERT INTO `exam_manage` VALUES (20190013, '测试', '测试', 1009, '2019-04-24', 120, '2017', NULL, '测试', '测试', 100, '期末考试', '请不要带与考试无关的书籍。');
INSERT INTO `exam_manage` VALUES (20190015, 'aaa', 'aa', 1010, '2021-05-03', 100, '2', NULL, 'aaa', 'aaa', 123, 'dd', 'dd');

-- ----------------------------
-- Table structure for fill_question
-- ----------------------------
DROP TABLE IF EXISTS `fill_question`;
CREATE TABLE `fill_question`  (
  `questionId` int(0) NOT NULL AUTO_INCREMENT COMMENT '试题编号',
  `subject` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '考试科目',
  `question` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '试题内容',
  `answer` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '正确答案',
  `analysis` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '题目解析',
  `score` int(0) NULL DEFAULT 2 COMMENT '分数',
  `level` varchar(5) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '难度等级',
  `section` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '所属章节',
  PRIMARY KEY (`questionId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10029 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '填空题题库' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of fill_question
-- ----------------------------
INSERT INTO `fill_question` VALUES (10000, '宾语从句', '1.Jim told me____he didn\'t go fishing yesterday afternoon. (how, why)', 'why', NULL, 2, '3', NULL);
INSERT INTO `fill_question` VALUES (10001, '宾语从句', '2.Do you know____else is going to be on duty today?( who, whom)', 'who', NULL, 2, '1', NULL);
INSERT INTO `fill_question` VALUES (10002, '宾语从句', 'She said___it wouldn\'t matter much. ( that, if)', 'that', NULL, 2, '2', NULL);
INSERT INTO `fill_question` VALUES (10003, '宾语从句', 'He always thinks_____he can do better. ( how, who）', 'how', NULL, 2, '1', NULL);
INSERT INTO `fill_question` VALUES (10004, '宾语从句', 'I really don\'t know______ the bridge will be finished. (how long, how soon)', 'how soon', NULL, 2, '4', NULL);
INSERT INTO `fill_question` VALUES (10005, '宾语从句', '6.They don\'t know____to go or wait. (if， whether)', 'whether', NULL, 2, '1', NULL);
INSERT INTO `fill_question` VALUES (10006, '宾语从句', 'We are talking about___we\'ll go back tomorrow.(whether, if)', 'whether', NULL, 2, '1', NULL);
INSERT INTO `fill_question` VALUES (10007, '宾语从句', '.I was really surprised at____l saw. (where, what)', 'what', NULL, 2, '1', NULL);
INSERT INTO `fill_question` VALUES (10008, '宾语从句', ' I don\'t know____so many people are looking at him. (how, why)', 'why', NULL, 2, '1', NULL);
INSERT INTO `fill_question` VALUES (10009, '宾语从句', '.Do you know____you are studying for? (why, what)', 'what', NULL, 2, '1', NULL);
INSERT INTO `fill_question` VALUES (10010, '宾语从句', 'We are sure that he_____(go) to school tomorrow.', 'will go', NULL, 2, '1', NULL);
INSERT INTO `fill_question` VALUES (10011, '宾语从句', 'Do you know who_____ (be) the first man to walk on the moon?', 'was', NULL, 2, '1', NULL);
INSERT INTO `fill_question` VALUES (10012, '宾语从句', 'Could you tell me where the post office____(is)?', 'is', NULL, 2, '1', NULL);
INSERT INTO `fill_question` VALUES (10013, '宾语从句', 'Our father said that he_______(will) buy a new computer', 'would', NULL, 2, '2', NULL);
INSERT INTO `fill_question` VALUES (10014, '宾语从句', 'l hear that he_____(swim) in the sea yesterday', 'swam', NULL, 2, '1', NULL);
INSERT INTO `fill_question` VALUES (10015, '宾语从句', 'The little boy tells us where his father_____(work).He said that he___(finish) his work already.', 'works', NULL, 2, '1', NULL);
INSERT INTO `fill_question` VALUES (10016, '宾语从句', 'They thought they could____(hike) to the top of the mountain.He was glad that so many people____(help) him.', 'hike', NULL, 2, '1', NULL);
INSERT INTO `fill_question` VALUES (10017, '宾语从句', 'he doesn\'t know whether___(go) or wait.', 'to go', NULL, 2, '3', NULL);
INSERT INTO `fill_question` VALUES (10018, '宾语从句', 'He was glad that so many people____(help) him', 'helper', NULL, 2, '1', NULL);
INSERT INTO `fill_question` VALUES (10019, '宾语从句', 'she doesn\'t konw whether_____(go) or wait', 'to go', NULL, 2, '2', NULL);
INSERT INTO `fill_question` VALUES (10020, '宾语从句', 'I won\'t return the book to the llibrary because i _______(not finish) reading it', 'haven\'t finisher ', NULL, 2, '4', NULL);
INSERT INTO `fill_question` VALUES (10021, '宾语从句', 'As soon as he saw me he _____ to speak to me(stop)', 'stopped', NULL, 2, '3', NULL);
INSERT INTO `fill_question` VALUES (10022, '宾语从句', 'i hope he _____(come) back in a week', 'will come', NULL, 2, '3', NULL);
INSERT INTO `fill_question` VALUES (10023, '宾语从句', 'it _____(rain) hard when i got to the factory this moring', 'was raininng', NULL, 2, '5', NULL);
INSERT INTO `fill_question` VALUES (10024, '宾语从句', 'The old man told the children _____(not walk) in the rice fileds', 'not to talk', NULL, 2, '5', NULL);
INSERT INTO `fill_question` VALUES (10025, '宾语从句', 'He tole me he _______(help) her with her maths the next evening', 'would help', NULL, 2, '5', NULL);
INSERT INTO `fill_question` VALUES (10026, '宾语从句', 'She said they ______(know) each other for quite some time', 'had know', NULL, 2, '3', NULL);
INSERT INTO `fill_question` VALUES (10027, '宾语从句', 'If it  _____ (not rain) tomorrow, we ______(visit) the xxx', 'doesn\'t rain', NULL, 2, '5', NULL);
INSERT INTO `fill_question` VALUES (10028, '宾语从句', 'When I got to the cinema the film _____(bein)', 'had begun', NULL, 2, '5', NULL);

-- ----------------------------
-- Table structure for judge_question
-- ----------------------------
DROP TABLE IF EXISTS `judge_question`;
CREATE TABLE `judge_question`  (
  `questionId` int(0) NOT NULL AUTO_INCREMENT COMMENT '试题编号',
  `subject` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '考试科目',
  `question` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '试题内容',
  `answer` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '正确答案',
  `analysis` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '题目解析',
  `score` int(0) NULL DEFAULT 2 COMMENT '分数',
  `level` varchar(1) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '难度等级',
  `section` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '所属章节',
  PRIMARY KEY (`questionId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10014 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '判断题题库表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of judge_question
-- ----------------------------
INSERT INTO `judge_question` VALUES (10001, '宾语从句', 'I will be rich', 'T', NULL, 2, '1', '');
INSERT INTO `judge_question` VALUES (10002, '宾语从句', 'I will be rich', 'F', NULL, 2, '1', NULL);
INSERT INTO `judge_question` VALUES (10003, '宾语从句', 'I will be rich', 'F', NULL, 2, '1', NULL);
INSERT INTO `judge_question` VALUES (10004, '宾语从句', 'I will be rich', 'F', NULL, 2, '1', NULL);
INSERT INTO `judge_question` VALUES (10005, '宾语从句', 'I will be rich', 'T', NULL, 2, '2', NULL);
INSERT INTO `judge_question` VALUES (10006, '宾语从句', 'I will be rich', 'F', NULL, 2, '2', NULL);
INSERT INTO `judge_question` VALUES (10007, '宾语从句', 'I will be rich', 'T', NULL, 2, '2', NULL);
INSERT INTO `judge_question` VALUES (10008, '宾语从句', 'I will be rich', 'T', NULL, 2, '3', NULL);
INSERT INTO `judge_question` VALUES (10009, '宾语从句', 'I will be rich', 'T', NULL, 2, '4', NULL);
INSERT INTO `judge_question` VALUES (10010, '宾语从句', 'I will be rich', 'F', NULL, 2, '3', NULL);
INSERT INTO `judge_question` VALUES (10011, '宾语从句', 'I will be rich', 'T', NULL, 2, '2', NULL);
INSERT INTO `judge_question` VALUES (10012, '宾语从句', 'I will be rich', 'F', NULL, 2, '1', NULL);
INSERT INTO `judge_question` VALUES (10013, '奇怪的考试', 'aaa', 'T', 'aaaaaaaads', 2, '3', '');

-- ----------------------------
-- Table structure for links
-- ----------------------------
DROP TABLE IF EXISTS `links`;
CREATE TABLE `links`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `linkname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `linkaddress` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `logo` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of links
-- ----------------------------
INSERT INTO `links` VALUES (1, '武汉蜗牛学院', 'http://woniuxy.com/', NULL);
INSERT INTO `links` VALUES (2, '百度', 'https://www.baidu.com/', NULL);
INSERT INTO `links` VALUES (3, '阿里巴巴', 'https://www.1688.com/', NULL);
INSERT INTO `links` VALUES (4, '京东', 'https://www.jd.com/', NULL);
INSERT INTO `links` VALUES (5, '网易', 'https://www.163.com/', NULL);
INSERT INTO `links` VALUES (6, '网易邮箱', 'https://email.163.com/', NULL);
INSERT INTO `links` VALUES (7, '网易云音乐', 'https://music.163.com/', NULL);
INSERT INTO `links` VALUES (10, '饿了吗', 'www.ele.com', NULL);

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `account` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `password` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `gender` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `age` int(0) NOT NULL,
  `education` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `isfamous` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `telephone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `imageUrl` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES (1, 'kzh', '123', 'kzh', '1', 22, 'aaaa', 'y', '18972363681', '1', '\r\nhttps://training-english.oss-cn-beijing.aliyuncs.com/u%3D1485551783%2C740638640%26fm%3D26%26gp%3D0.jpg');
INSERT INTO `manager` VALUES (2, 'yw', '123', 'yw', '1', 21, 'aaaa', 'y', '11111111111', '0', '\r\nhttps://training-english.oss-cn-beijing.aliyuncs.com/u%3D1485551783%2C740638640%26fm%3D26%26gp%3D0.jpg');
INSERT INTO `manager` VALUES (3, 'wgw', '123', 'wgw', '1', 22, 'kladalkjdl', 'y', '111111111', '0', '\r\nhttps://training-english.oss-cn-beijing.aliyuncs.com/u%3D1485551783%2C740638640%26fm%3D26%26gp%3D0.jpg');
INSERT INTO `manager` VALUES (4, 'pyk', '123', 'pyk', '1', 22, 'asdasd', 'n', '111111111', '0', '\r\nhttps://training-english.oss-cn-beijing.aliyuncs.com/u%3D1485551783%2C740638640%26fm%3D26%26gp%3D0.jpg');
INSERT INTO `manager` VALUES (11, 'zxf', '123', '张雪峰', '1', 50, '牛的', 'y', '1231231', '0', '\r\nhttps://training-english.oss-cn-beijing.aliyuncs.com/u%3D1485551783%2C740638640%26fm%3D26%26gp%3D0.jpg');
INSERT INTO `manager` VALUES (14, 'sdada', '123', 'dada', '1', 11, 'wada', 'y', '23123', '0', '\r\nhttps://training-english.oss-cn-beijing.aliyuncs.com/u%3D1950782150%2C392775869%26fm%3D26%26gp%3D0.jpg');
INSERT INTO `manager` VALUES (15, 'aaa', '123', 'aaa', '1', 21, 'sadas', 'y', '21312', '0', '\r\nhttps://training-english.oss-cn-beijing.aliyuncs.com/u%3D1950782150%2C392775869%26fm%3D26%26gp%3D0.jpg');
INSERT INTO `manager` VALUES (17, 'aaa', '123', 'asd', '1', 21, 'adada', 'n', '2131231', '0', '\r\nhttps://training-english.oss-cn-beijing.aliyuncs.com/u%3D1950782150%2C392775869%26fm%3D26%26gp%3D0.jpg');
INSERT INTO `manager` VALUES (18, 'bba', '123', 'bbba', '1', 21, 'sada', 'y', 'sadasd', '0', '\r\nhttps://training-english.oss-cn-beijing.aliyuncs.com/u%3D1950782150%2C392775869%26fm%3D26%26gp%3D0.jpg');
INSERT INTO `manager` VALUES (21, 'admin', 'admin', '易大师', '1', 18, '清华', 'y', '18727441371', '0', 'https://training-english.oss-cn-beijing.aliyuncs.com/u%3D1485551783%2C740638640%26fm%3D26%26gp%3D0.jpg');
INSERT INTO `manager` VALUES (24, '赵云', '123', '赵子龙', '1', 18, '刘备', 'y', '12345', '0', '\r\nhttps://training-english.oss-cn-beijing.aliyuncs.com/u%3D1950782150%2C392775869%26fm%3D26%26gp%3D0.jpg');
INSERT INTO `manager` VALUES (25, '张飞', '123', '赵翼德', '1', 18, '刘备', 'y', '12345', '0', '\r\nhttps://training-english.oss-cn-beijing.aliyuncs.com/u%3D1950782150%2C392775869%26fm%3D26%26gp%3D0.jpg');
INSERT INTO `manager` VALUES (26, 'zs', '123', '张三', '1', 22, '清华', 'y', '125425896', '1', 'https://training-english.oss-cn-beijing.aliyuncs.com/u=1485551783,740638640&fm=26&gp=0.jpg');

-- ----------------------------
-- Table structure for manager_perms
-- ----------------------------
DROP TABLE IF EXISTS `manager_perms`;
CREATE TABLE `manager_perms`  (
  `managerid` int(0) NOT NULL,
  `permsid` int(0) NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of manager_perms
-- ----------------------------
INSERT INTO `manager_perms` VALUES (1, 1);
INSERT INTO `manager_perms` VALUES (1, 2);
INSERT INTO `manager_perms` VALUES (1, 3);
INSERT INTO `manager_perms` VALUES (1, 4);
INSERT INTO `manager_perms` VALUES (1, 5);
INSERT INTO `manager_perms` VALUES (1, 11);
INSERT INTO `manager_perms` VALUES (1, 12);
INSERT INTO `manager_perms` VALUES (1, 13);
INSERT INTO `manager_perms` VALUES (1, 14);
INSERT INTO `manager_perms` VALUES (1, 15);
INSERT INTO `manager_perms` VALUES (1, 16);
INSERT INTO `manager_perms` VALUES (1, 17);
INSERT INTO `manager_perms` VALUES (1, 18);
INSERT INTO `manager_perms` VALUES (1, 19);
INSERT INTO `manager_perms` VALUES (1, 20);
INSERT INTO `manager_perms` VALUES (1, 21);
INSERT INTO `manager_perms` VALUES (1, 22);
INSERT INTO `manager_perms` VALUES (1, 23);
INSERT INTO `manager_perms` VALUES (1, 24);
INSERT INTO `manager_perms` VALUES (1, 25);
INSERT INTO `manager_perms` VALUES (1, 31);
INSERT INTO `manager_perms` VALUES (1, 32);
INSERT INTO `manager_perms` VALUES (1, 33);
INSERT INTO `manager_perms` VALUES (1, 34);
INSERT INTO `manager_perms` VALUES (1, 35);
INSERT INTO `manager_perms` VALUES (1, 36);
INSERT INTO `manager_perms` VALUES (1, 37);
INSERT INTO `manager_perms` VALUES (1, 38);
INSERT INTO `manager_perms` VALUES (1, 39);
INSERT INTO `manager_perms` VALUES (1, 40);
INSERT INTO `manager_perms` VALUES (1, 41);
INSERT INTO `manager_perms` VALUES (1, 42);
INSERT INTO `manager_perms` VALUES (1, 43);
INSERT INTO `manager_perms` VALUES (1, 44);
INSERT INTO `manager_perms` VALUES (1, 45);
INSERT INTO `manager_perms` VALUES (1, 46);
INSERT INTO `manager_perms` VALUES (1, 47);
INSERT INTO `manager_perms` VALUES (1, 48);
INSERT INTO `manager_perms` VALUES (1, 49);
INSERT INTO `manager_perms` VALUES (1, 50);
INSERT INTO `manager_perms` VALUES (1, 51);
INSERT INTO `manager_perms` VALUES (1, 52);
INSERT INTO `manager_perms` VALUES (1, 53);
INSERT INTO `manager_perms` VALUES (1, 54);
INSERT INTO `manager_perms` VALUES (1, 55);
INSERT INTO `manager_perms` VALUES (1, 56);
INSERT INTO `manager_perms` VALUES (1, 57);
INSERT INTO `manager_perms` VALUES (1, 58);
INSERT INTO `manager_perms` VALUES (1, 59);
INSERT INTO `manager_perms` VALUES (1, 60);
INSERT INTO `manager_perms` VALUES (1, 61);
INSERT INTO `manager_perms` VALUES (1, 62);
INSERT INTO `manager_perms` VALUES (1, 63);
INSERT INTO `manager_perms` VALUES (1, 64);
INSERT INTO `manager_perms` VALUES (1, 65);
INSERT INTO `manager_perms` VALUES (1, 67);
INSERT INTO `manager_perms` VALUES (1, 68);
INSERT INTO `manager_perms` VALUES (1, 69);
INSERT INTO `manager_perms` VALUES (1, 70);
INSERT INTO `manager_perms` VALUES (1, 71);
INSERT INTO `manager_perms` VALUES (1, 72);
INSERT INTO `manager_perms` VALUES (1, 73);
INSERT INTO `manager_perms` VALUES (1, 74);
INSERT INTO `manager_perms` VALUES (1, 75);
INSERT INTO `manager_perms` VALUES (1, 76);
INSERT INTO `manager_perms` VALUES (2, 3);
INSERT INTO `manager_perms` VALUES (2, 5);
INSERT INTO `manager_perms` VALUES (2, 11);
INSERT INTO `manager_perms` VALUES (2, 12);
INSERT INTO `manager_perms` VALUES (2, 13);
INSERT INTO `manager_perms` VALUES (2, 14);
INSERT INTO `manager_perms` VALUES (2, 15);
INSERT INTO `manager_perms` VALUES (2, 1);
INSERT INTO `manager_perms` VALUES (2, 2);

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '留言编号',
  `title` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '标题',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '留言内容',
  `time` date NULL DEFAULT NULL COMMENT '留言时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 36 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '留言表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES (2, '晚上加班,这感觉非常的nice', '今天是星期一的晚上,下班后回到宿舍继续写我的毕业设计,看着项目功能日渐丰满好开心哦,你们也要元气满满哦！', '2019-03-18');
INSERT INTO `message` VALUES (15, '咸鱼', '我是一条咸鱼', '2019-03-18');
INSERT INTO `message` VALUES (16, '今天中午吃什么', '今天去吃莲藕排骨汤吧，虽然也不好吃，但这里真的没什么东西可以吃了', '2019-03-18');
INSERT INTO `message` VALUES (20, '这个网站不错', '博主大大好厉害，网页看着很清新呢，喜欢这样嘞风格。', '2019-03-18');
INSERT INTO `message` VALUES (21, '男孩子', '哇，这么可爱，那肯定是男孩子呀。', '2019-03-18');
INSERT INTO `message` VALUES (22, '好人', '你是个好人，可是我们不合适。', '2019-03-18');
INSERT INTO `message` VALUES (25, '小乔', '花会枯萎，爱永不凋零，小乔要努力变强。', '2019-03-18');
INSERT INTO `message` VALUES (26, '妲己', '妲己会一直爱主人，因为被设定成这样，来和妲己玩耍吧。', '2019-03-18');
INSERT INTO `message` VALUES (27, '土味情话', '妈妈从小对我讲，不要早恋，遇到你以后，我决定不听妈妈的话了。', '2019-03-31');
INSERT INTO `message` VALUES (35, '贝塔', '开坦克', '2019-09-05');

-- ----------------------------
-- Table structure for multi_question
-- ----------------------------
DROP TABLE IF EXISTS `multi_question`;
CREATE TABLE `multi_question`  (
  `questionId` int(0) NOT NULL AUTO_INCREMENT COMMENT '试题编号',
  `subject` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '考试科目',
  `question` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '问题题目',
  `answerA` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '选项A',
  `answerB` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '选项B',
  `answerC` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '选项C',
  `answerD` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '选项D',
  `rightAnswer` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '正确答案',
  `analysis` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '题目解析',
  `score` int(0) NULL DEFAULT 2 COMMENT '分数',
  `section` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '所属章节',
  `level` varchar(1) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '难度等级',
  PRIMARY KEY (`questionId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10041 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '选择题题库表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of multi_question
-- ----------------------------
INSERT INTO `multi_question` VALUES (10000, '宾语从句', 'I don\'t know _____ he will come tomorrow. _____he comes, I\'ll tell you', 'if;Whether', 'whether;Whether', 'if;That', 'if;If', 'D', NULL, 2, '应用层', '2');
INSERT INTO `multi_question` VALUES (10001, '宾语从句', 'I don\'t know ____ the day after tomorrow', 'When does he come', 'how will he come', 'if he comes', 'whether he\'ll come', 'D', NULL, 2, '应用层', '2');
INSERT INTO `multi_question` VALUES (10003, '宾语从句', 'Could you tell me ____ the nearest hospital is', 'what', 'how ', 'whether', 'where', 'D', NULL, 2, '应用层', '3');
INSERT INTO `multi_question` VALUES (10004, '宾语从句', 'Could you tell me _____ the radio without any help', 'how did he mend', 'what did he mend', 'how he mended', 'what he mended', 'C', NULL, 2, '应用层', '2');
INSERT INTO `multi_question` VALUES (10005, '宾语从句', 'I want to know _____', 'whom she is looking', 'whom is she looking after', 'whom she is looking', 'whom is she looking', 'D', NULL, 2, '应用层', '2');
INSERT INTO `multi_question` VALUES (10006, '宾语从句', 'Do you konw where _____ now', 'he lives', 'does he live', 'he lived', 'did he live', 'A', NULL, 2, '应用层', '2');
INSERT INTO `multi_question` VALUES (10007, '宾语从句', 'Do you konw what time ____', 'the tarin leafe', 'does the train leave', 'will the train leave', 'the train leaves', 'D', NULL, 2, '应用层', '3');
INSERT INTO `multi_question` VALUES (10008, '宾语从句', 'I don\'t know ___', 'how the two players are old', 'how old are the tow players', 'the two player sare how old', 'how old the two player are', 'D', NULL, 2, '传输层', '1');
INSERT INTO `multi_question` VALUES (10009, '宾语从句', 'The small children don\'t know', 'what is their stockings in', 'what is in their stockings', 'where is their stokings', 'what in their stockings', 'B', NULL, 2, '传输层', '2');
INSERT INTO `multi_question` VALUES (10010, '宾语从句', 'I can\'t understand', 'what doer Christmas mean', 'what Chrismas does mean', 'what mean Chritmas does', 'what Christmas means', 'D', NULL, 2, '传输层', '3');
INSERT INTO `multi_question` VALUES (10011, '宾语从句', 'Can you tell me ___ you were born,Betty', 'who', 'what', 'when', 'that', 'C', NULL, 2, '传输层', '2');
INSERT INTO `multi_question` VALUES (10012, '宾语从句', 'I don\'t know ____ they have passed the exam', 'what', 'if', 'when', 'where', 'B', NULL, 2, '传输层', '4');
INSERT INTO `multi_question` VALUES (10013, '宾语从句', 'I hardly understand,_____he has told me', 'that', 'what', 'which', 'who', 'B', NULL, 2, '传输层', '2');
INSERT INTO `multi_question` VALUES (10014, '宾语从句', 'She didn\'t know ____ back soon', 'whether he would be', 'if would he be', 'he will be', '', 'A', NULL, 2, '传输层', '3');
INSERT INTO `multi_question` VALUES (10015, '宾语从句', 'I don\'t know ____ he still lives here after so many years', 'whether', 'where', 'what', 'when', 'A', NULL, 2, '物理层', '4');
INSERT INTO `multi_question` VALUES (10016, '宾语从句', 'Do you know _____ they listened to yesterday evening', 'what', 'when', 'why', 'how', 'A', NULL, 2, '物理层', '1');
INSERT INTO `multi_question` VALUES (10017, '宾语从句', 'He asked me ____told me the accident', 'whom', 'which', 'who', 'whose', 'C', NULL, 2, '物理层', '2');
INSERT INTO `multi_question` VALUES (10018, '宾语从句', '以下关于时分多路复用概念的描述中，错误的是.(  ).', '时分多路复用将线路使用的时间分成多个时间片', '时分多路复用分为同步时分多路复用与统计时分多路复用', '时分多路复用使用“帧”与数据链路层“帧”的概念、作用是不同的', '统计时分多路复用将时间片预先分配给各个信道', 'D', NULL, 2, '物理层', '2');
INSERT INTO `multi_question` VALUES (10019, '宾语从句', '1000BASE-T标准支持的传输介质是（）', '双绞线', '同轴电缆', '光纤', '无线电', 'A', NULL, 2, '物理层', '1');
INSERT INTO `multi_question` VALUES (10020, '宾语从句', '一个以太网交换机，读取整个数据帧，对数据帧进行差错校验后再转发出去，这种交换方式称为 （）', '直通交换', '无碎片交换', '无差错交换', '存储转发交换', 'D', NULL, 2, '数据链路层', '2');
INSERT INTO `multi_question` VALUES (10021, '宾语从句', '关于VLAN，下面的描述中正确的是（）', '一个新的交换机没有配置VLAN', '通过配置VLAN减少了冲突域的数量', '一个VLAN不能跨越多个交换机', '各个VLAN属于不同的广播域', 'D', NULL, 2, '数据链路层', '2');
INSERT INTO `multi_question` VALUES (10022, '宾语从句', '以太网协议中使用物理地址作用是什么？', '.用于不同子网中的主机进行通信', '作为第二层设备的唯一标识', '用于区别第二层第三层的协议数据单元', '保存主机可检测未知的远程设备', 'B', NULL, 2, '数据链路层', '2');
INSERT INTO `multi_question` VALUES (10023, '宾语从句', '以太网采用的CSMA/CD协议，当冲突发生时要通过二进制指数后退算法计算后退延时， 关于这个算法，以下论述中错误的是 （）', '冲突次数越多，后退的时间越短', '平均后退次数的多少与负载大小有关', '后退时延的平均值与负载大小有关', '重发次数达到一定极限后放弃发送', 'A', NULL, 2, '数据链路层', '3');
INSERT INTO `multi_question` VALUES (10024, '宾语从句', '以下关于交换机获取与其端口连接设备的MAC地址的叙述中，正确的是（）', '交换机从路由表中提取设备的MAC地址', '交换机检查端口流入分组的源地址', '交换机之间互相交换地址表', '网络管理员手工输入设备的MAC地址', 'B', NULL, 2, '数据链路层', '2');
INSERT INTO `multi_question` VALUES (10025, '宾语从句', '如果G (x）为11010010，以下4个CRC校验比特序列中只有哪个可能是正确的 ？', '1101011001', '101011011', '11011011', '1011001', 'B', NULL, 2, '数据链路层', '1');
INSERT INTO `multi_question` VALUES (10026, '宾语从句', '以下关于Ethernet物理地址的描述中，错误的是', 'Ethernet物理地址又叫做MAC地址', '48位的Ethernet物理地址允许分配的地址数达到247个', '网卡的物理地址写入主机的EPROM中', '每一块网卡的物理地址在全世界是唯一的', 'C', NULL, 2, '数据链路层', '3');
INSERT INTO `multi_question` VALUES (10027, '宾语从句', '下列帧类型中，不属于HDLC帧类型的是（）', '信息帧', '确认帧', '监控帧', '无编号帧', 'B', NULL, 2, '数据链路层', '1');
INSERT INTO `multi_question` VALUES (10028, '宾语从句', '通过交换机连接的一组站点，关于它们的广播域和冲突域说法正确的是（）', '组成一个冲突域，但不是一个广播域', '组成一个广播域，但不是一个冲突域', '组成一个冲突域，也是一个广播域', '既不一个冲突域，也不是一个广播域', 'B', NULL, 2, '数据链路层', '3');
INSERT INTO `multi_question` VALUES (10029, '宾语从句', '数据链路层的数据单位是（）', '帧', '字节', '比特', '分组', 'A', NULL, 2, '数据链路层', '1');
INSERT INTO `multi_question` VALUES (10030, '宾语从句', 'LAN参考模型可分为物理层、（ ）', 'MAC，LLC等三层', 'LLC，MHS等三层', 'MAC，FTAM等三层', 'LLC，VT等三层', 'A', NULL, 2, '数据链路层', '3');
INSERT INTO `multi_question` VALUES (10031, '宾语从句', '测试', 'A', 'B', 'C', 'D', 'B', '解析', 2, '测试', '4');
INSERT INTO `multi_question` VALUES (10032, '宾语从句', 'DNS 服务器和DHCP服务器的作用是（）', 'A', 'B', 'C', 'D', 'B', '哦解析', 2, '网络层', '2');
INSERT INTO `multi_question` VALUES (10035, '宾语从句', 'aaa', 'aaaa', 'aaaa', 'aaa', 'aaa', '', 'sadasd', 2, '', '');
INSERT INTO `multi_question` VALUES (10036, '奇怪的考试', 'qqq', 'aaa', 'aa', 'aa', 'aa', '', 'aaa', 2, '', '');
INSERT INTO `multi_question` VALUES (10037, '奇怪的考试', 'qq', 'aa', 'aa', 'aa', 'aa', 'B', 'ddd', 2, 'sss', '1');
INSERT INTO `multi_question` VALUES (10038, '奇怪的考试', 'aaa', 'a', 'a', 'a', 'a', 'A', 'aaaaaa', 2, 'aa', '1');
INSERT INTO `multi_question` VALUES (10039, '奇怪的考试', 'eee', 'd', 's', 'd', 'x', 'B', 'zzzz', 2, 'ww', '2');
INSERT INTO `multi_question` VALUES (10040, '奇怪的考试', 'ss', 'ss', 's', 's', 'd', 'B', 'd', 2, '', '2');

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `title` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `image` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `log` int(0) NULL DEFAULT NULL,
  `day` datetime(0) NULL DEFAULT NULL,
  `cotent` varchar(300) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES (1, '植一棵树 种一个梦！', NULL, 2, '2021-05-13 15:19:34', '3月19日下午，在金山小学的支持下，海培英语联合金小家委会在奥山公园举行了一次公益植树活动。全校220个家庭，共600余人踊跃报名参加了本次活动。');
INSERT INTO `news` VALUES (2, '父母精彩沙龙篇', NULL, 1, '2021-05-13 15:19:34', ' 父母的爱是伟大的，在孩子心里，也是无所不在的。作为家长，都盼望孩子健康快乐成长，都在用尽所有的爱给到孩子最好的！');
INSERT INTO `news` VALUES (3, '教育资讯篇', NULL, 1, '2021-05-14 23:55:33', '作家龙应台说，家庭教育也是有“有效期”的，父母要在孩子最依赖自己的十年里用心教养，提供依靠。一旦孩子长到青春期，父母再怎么努力，也无法提供实质性的影响。父母如果在孩子需要的时候不用心教养，将来孩子再怎么叛逆，也只有摇头叹息的份儿。  不少父母在面对孩子时总是火急火燎，有话不能好好说，有事不能科学地办，不把孩子的成长规律当回事。就像得了感冒，不是按照生病的规律办事，而是一味地要求医生打吊针，希望今日生病明天就好了。');
INSERT INTO `news` VALUES (4, '精彩赛事（1）', NULL, 2, '2021-05-14 23:55:37', '台上十分钟，台下十年功”经过一段时间不懈的排练，孩子们今天终于登上了重庆赛区的舞台，现场气氛紧张热烈，又精彩纷呈，小P迫不及待想与大家分享，为海培孩子的点赞。');
INSERT INTO `news` VALUES (5, '英语沙龙', NULL, 2, '2021-05-14 23:55:35', '亲爱的伙伴们，还记得每月的英语沙龙带给我们的精彩瞬间吗？ 曾经的那些快乐的时光是否还记得吗?是否现在遗憾未能参加吗？不用遗憾，海培全新升级，包括原有的英语沙龙，我们现在叫它“英语文化角”，还是原来的价格，还是原有的外教，但我们也加入了完全新鲜的元素、创意新奇的主题，完全超乎你的想象！');
INSERT INTO `news` VALUES (13, '最新动态', NULL, 2, '2021-05-14 23:57:29', '对英语耳濡目染的你，是否真正了解英伦三岛背后的英语文化呢？［培养多角度思考问题的能力］，现代优秀教育的本质目的是让孩子意识到自己不可能做好每一件事，发现自己擅长的和不足的，能意识到这种不足是正常而且客观存在的，最后获得一颗健康的心灵。而国际化课堂中丰富的内容更能激发孩子的小宇宙。');
INSERT INTO `news` VALUES (14, '孩子共同欢乐季（1）', NULL, 1, '2021-05-14 00:01:32', ' 父母的爱是伟大的，在孩子心里，也是无所不在的。作为家长，都盼望孩子健康快乐成长，都在用尽所有的爱给到孩子最好的！');
INSERT INTO `news` VALUES (15, '孩子共同欢乐（2）', NULL, 1, '2021-05-27 00:01:36', ' 父母的爱是伟大的，在孩子心里，也是无所不在的。作为家长，都盼望孩子健康快乐成长，都在用尽所有的爱给到孩子最好的！');
INSERT INTO `news` VALUES (16, '孩子共同欢乐（3）', NULL, 1, '2021-05-15 00:01:38', ' 父母的爱是伟大的，在孩子心里，也是无所不在的。作为家长，都盼望孩子健康快乐成长，都在用尽所有的爱给到孩子最好的！');
INSERT INTO `news` VALUES (17, '孩子共同欢乐（4）', NULL, 1, '2021-05-15 00:01:39', ' 父母的爱是伟大的，在孩子心里，也是无所不在的。作为家长，都盼望孩子健康快乐成长，都在用尽所有的爱给到孩子最好的！');
INSERT INTO `news` VALUES (18, '孩子共同欢乐（5）', NULL, 1, '2021-05-27 00:01:41', ' 父母的爱是伟大的，在孩子心里，也是无所不在的。作为家长，都盼望孩子健康快乐成长，都在用尽所有的爱给到孩子最好的！');
INSERT INTO `news` VALUES (19, '精彩赛事（2）', NULL, NULL, NULL, '台上十分钟，台下十年功”经过一段时间不懈的排练，孩子们今天终于登上了重庆赛区的舞台，现场气氛紧张热烈，又精彩纷呈，小P迫不及待想与大家分享，为海培孩子的点赞。');
INSERT INTO `news` VALUES (20, '精彩赛事（2）', NULL, NULL, NULL, '台上十分钟，台下十年功”经过一段时间不懈的排练，孩子们今天终于登上了重庆赛区的舞台，现场气氛紧张热烈，又精彩纷呈，小P迫不及待想与大家分享，为海培孩子的点赞。');
INSERT INTO `news` VALUES (21, '精彩赛事（2）', NULL, NULL, NULL, '台上十分钟，台下十年功”经过一段时间不懈的排练，孩子们今天终于登上了重庆赛区的舞台，现场气氛紧张热烈，又精彩纷呈，小P迫不及待想与大家分享，为海培孩子的点赞。');
INSERT INTO `news` VALUES (22, '精彩赛事（2）', NULL, NULL, NULL, '台上十分钟，台下十年功”经过一段时间不懈的排练，孩子们今天终于登上了重庆赛区的舞台，现场气氛紧张热烈，又精彩纷呈，小P迫不及待想与大家分享，为海培孩子的点赞。');
INSERT INTO `news` VALUES (24, 'qqqqqqqqq', '', 1, '2021-05-30 16:00:00', 'qqq');
INSERT INTO `news` VALUES (25, '蜗牛今天', '', 1, '2021-05-27 16:00:00', '啊啊啊啊');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `userid` int(0) NOT NULL,
  `videoid` int(0) NOT NULL,
  `orderTime` datetime(0) NULL,
  `payType` char(1) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `videoname` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `log` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES (1, 1, 21, '2021-05-11 16:44:46', '2', '小学英语', '王五', 1);
INSERT INTO `orders` VALUES (2, 1, 21, '2021-05-26 16:00:00', '3', '初中英语入门', '王五', 1);
INSERT INTO `orders` VALUES (3, 22, 22, '2021-05-24 16:00:00', '2', '初中英语入门', '李四', 1);
INSERT INTO `orders` VALUES (4, 0, 0, '2021-05-25 16:00:00', '2', NULL, '王五', 0);
INSERT INTO `orders` VALUES (5, 0, 0, '2021-05-11 16:00:00', '1', NULL, NULL, 0);
INSERT INTO `orders` VALUES (6, 0, 0, '2021-05-14 08:01:48', '1', '我', '色粉', 0);
INSERT INTO `orders` VALUES (7, 0, 0, '2021-05-12 16:00:00', '', '我发个', '啊k', 0);
INSERT INTO `orders` VALUES (8, 0, 0, '2021-05-19 16:00:00', '1', '我', '啊', 0);
INSERT INTO `orders` VALUES (9, 0, 22, '2021-05-24 16:00:00', '', '初中英语', '雷军11', 1);
INSERT INTO `orders` VALUES (10, 1, 21, '2021-05-26 16:00:00', '3', '初中英语入门', '王五', 1);
INSERT INTO `orders` VALUES (11, 1, 21, '2021-05-26 16:00:00', '3', '初中英语入门', '王五', 1);
INSERT INTO `orders` VALUES (12, 0, 0, '2021-05-11 16:00:00', '1', '小学英语', '李四', 1);
INSERT INTO `orders` VALUES (13, 0, 0, '2021-05-12 16:00:00', '1', '我', '安慰', 1);
INSERT INTO `orders` VALUES (14, 0, 0, '2021-05-10 16:00:00', '1', '安慰', '安慰', 1);
INSERT INTO `orders` VALUES (15, 0, 0, '2021-05-18 16:00:00', '1', '请问', '2', 1);
INSERT INTO `orders` VALUES (16, 0, 0, '2021-05-18 16:00:00', '1', '请问', '4', 1);
INSERT INTO `orders` VALUES (17, 0, 0, '2021-05-11 16:00:00', '', '初中英语', '雷军', 1);
INSERT INTO `orders` VALUES (18, 0, 0, '2021-05-11 16:00:00', '', '初中英语的', '雷军', 0);
INSERT INTO `orders` VALUES (19, 0, 0, '2021-05-11 16:00:00', '2', '初中英语', '雷军', 0);
INSERT INTO `orders` VALUES (20, 0, 0, '2021-05-19 16:00:00', '1', '初中英语', '雷军', 0);

-- ----------------------------
-- Table structure for paper_manage
-- ----------------------------
DROP TABLE IF EXISTS `paper_manage`;
CREATE TABLE `paper_manage`  (
  `paperId` int(0) NULL DEFAULT NULL COMMENT '试卷编号',
  `questionType` int(0) NULL DEFAULT NULL COMMENT '题目类型',
  `questionId` int(0) NULL DEFAULT NULL COMMENT '题目编号'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '试卷管理表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of paper_manage
-- ----------------------------
INSERT INTO `paper_manage` VALUES (1001, 1, 10013);
INSERT INTO `paper_manage` VALUES (1001, 1, 10005);
INSERT INTO `paper_manage` VALUES (1001, 1, 10001);
INSERT INTO `paper_manage` VALUES (1001, 1, 10004);
INSERT INTO `paper_manage` VALUES (1001, 1, 10000);
INSERT INTO `paper_manage` VALUES (1001, 1, 10016);
INSERT INTO `paper_manage` VALUES (1001, 1, 10032);
INSERT INTO `paper_manage` VALUES (1001, 1, 10025);
INSERT INTO `paper_manage` VALUES (1001, 1, 10030);
INSERT INTO `paper_manage` VALUES (1001, 1, 10017);
INSERT INTO `paper_manage` VALUES (1001, 1, 10027);
INSERT INTO `paper_manage` VALUES (1001, 1, 10023);
INSERT INTO `paper_manage` VALUES (1001, 1, 10014);
INSERT INTO `paper_manage` VALUES (1001, 1, 10009);
INSERT INTO `paper_manage` VALUES (1001, 1, 10008);
INSERT INTO `paper_manage` VALUES (1001, 1, 10011);
INSERT INTO `paper_manage` VALUES (1001, 1, 10010);
INSERT INTO `paper_manage` VALUES (1001, 1, 10021);
INSERT INTO `paper_manage` VALUES (1001, 1, 10022);
INSERT INTO `paper_manage` VALUES (1001, 1, 10026);
INSERT INTO `paper_manage` VALUES (1001, 2, 10017);
INSERT INTO `paper_manage` VALUES (1001, 2, 10012);
INSERT INTO `paper_manage` VALUES (1001, 2, 10004);
INSERT INTO `paper_manage` VALUES (1001, 2, 10005);
INSERT INTO `paper_manage` VALUES (1001, 2, 10003);
INSERT INTO `paper_manage` VALUES (1001, 2, 10008);
INSERT INTO `paper_manage` VALUES (1001, 2, 10020);
INSERT INTO `paper_manage` VALUES (1001, 2, 10013);
INSERT INTO `paper_manage` VALUES (1001, 2, 10006);
INSERT INTO `paper_manage` VALUES (1001, 2, 10015);
INSERT INTO `paper_manage` VALUES (1001, 3, 10002);
INSERT INTO `paper_manage` VALUES (1001, 3, 10009);
INSERT INTO `paper_manage` VALUES (1001, 3, 10003);
INSERT INTO `paper_manage` VALUES (1001, 3, 10005);
INSERT INTO `paper_manage` VALUES (1001, 3, 10004);
INSERT INTO `paper_manage` VALUES (1001, 3, 10012);
INSERT INTO `paper_manage` VALUES (1001, 3, 10011);
INSERT INTO `paper_manage` VALUES (1001, 3, 10006);
INSERT INTO `paper_manage` VALUES (1001, 3, 10008);
INSERT INTO `paper_manage` VALUES (1001, 3, 10001);
INSERT INTO `paper_manage` VALUES (1001, 1, 10040);

-- ----------------------------
-- Table structure for perms
-- ----------------------------
DROP TABLE IF EXISTS `perms`;
CREATE TABLE `perms`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `link` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `parentid` int(0) NULL DEFAULT NULL,
  `type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `percode` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 77 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of perms
-- ----------------------------
INSERT INTO `perms` VALUES (1, '教师管理', 'teacher/manager', NULL, NULL, 'm', 'y', NULL);
INSERT INTO `perms` VALUES (2, '教师列表', 'teacher/list', 'teacher', 1, 'm', 'y', 'teacher:list');
INSERT INTO `perms` VALUES (3, '新增教师', 'teacher/add', 'teacher/add', 2, 'p', 'y', 'teacher:add');
INSERT INTO `perms` VALUES (4, '删除教师', 'teacher/delete', 'teacher/delete', 2, 'p', 'y', 'teacher:delete');
INSERT INTO `perms` VALUES (5, '修改教师', 'teacher/update', 'teacher/update', 2, 'p', 'y', 'teacher:update');
INSERT INTO `perms` VALUES (11, '学生管理', 'student/manager', NULL, NULL, 'm', 'y', NULL);
INSERT INTO `perms` VALUES (12, '学生列表', 'student/list', 'student', 11, 'm', 'y', 'student:list');
INSERT INTO `perms` VALUES (13, '新增学生', 'student/add', 'student/add', 12, 'p', 'y', 'student:add');
INSERT INTO `perms` VALUES (14, '删除学生', 'student/delete', 'student/delete', 12, 'p', 'y', 'student:delete');
INSERT INTO `perms` VALUES (15, '修改学生', 'student/update', 'student/update', 12, 'p', 'y', 'student:update');
INSERT INTO `perms` VALUES (16, '订单管理', 'order/manager', NULL, NULL, 'm', 'y', NULL);
INSERT INTO `perms` VALUES (17, '订单列表', 'order/list', 'order', 16, 'm', 'y', 'order:list');
INSERT INTO `perms` VALUES (18, '新增订单', 'order/add', 'order/add', 17, 'p', 'y', 'order:add');
INSERT INTO `perms` VALUES (19, '删除订单', 'order/delete', 'order/delete', 17, 'p', 'y', 'order:delete');
INSERT INTO `perms` VALUES (20, '修改订单', 'order/update', 'order/update', 17, 'p', 'y', 'order:update');
INSERT INTO `perms` VALUES (21, '用户管理', 'user/manager', '', NULL, 'm', 'y', NULL);
INSERT INTO `perms` VALUES (22, '用户列表', 'user/list', 'user', 21, 'm', 'y', 'user:list');
INSERT INTO `perms` VALUES (23, '新增用户', 'user/add', 'user/add', 22, 'p', 'y', 'user:add');
INSERT INTO `perms` VALUES (24, '删除用户', 'user/delete', 'user/delete', 22, 'p', 'y', 'user:delete');
INSERT INTO `perms` VALUES (25, '修改用户', 'user/update', 'user/update', 22, 'p', 'y', 'user:update');
INSERT INTO `perms` VALUES (31, '视频管理', 'video/manager', NULL, NULL, 'm', 'y', NULL);
INSERT INTO `perms` VALUES (32, '视频列表', 'video/list', 'video', 31, 'm', 'y', 'video:list');
INSERT INTO `perms` VALUES (33, '新增视频', 'video/add', 'addvideo', 31, 'm', 'y', 'video:add');
INSERT INTO `perms` VALUES (34, '删除视频', 'video/delete', 'video/delete', 32, 'p', 'y', 'video:delete');
INSERT INTO `perms` VALUES (35, '修改视频', 'video/update', 'video/update', 32, 'p', 'y', 'video:update');
INSERT INTO `perms` VALUES (36, '链接管理', 'link/manager', NULL, NULL, 'm', 'y', NULL);
INSERT INTO `perms` VALUES (37, '链接列表', 'link/list', 'link', 36, 'm', 'y', 'link:list');
INSERT INTO `perms` VALUES (38, '新增链接', 'link/add', 'link/add', 37, 'p', 'y', 'link:add');
INSERT INTO `perms` VALUES (39, '删除链接', 'link/delete', 'link/delete', 37, 'p', 'y', 'link:delete');
INSERT INTO `perms` VALUES (40, '修改链接', 'link/update', 'link/update', 37, 'p', 'y', 'link:update');
INSERT INTO `perms` VALUES (41, '问卷管理', 'survey/manager', NULL, NULL, 'm', 'y', NULL);
INSERT INTO `perms` VALUES (42, '问卷列表', 'survey/list', 'survey', 41, 'm', 'y', 'survey:list');
INSERT INTO `perms` VALUES (43, '新增问卷', 'survey/add', 'survey/add', 42, 'p', 'y', 'survey:add');
INSERT INTO `perms` VALUES (44, '删除问卷', 'survey/delete', 'survey/delete', 42, 'p', 'y', 'survey:delete');
INSERT INTO `perms` VALUES (45, '修改问卷', 'survey/update', 'survey/update', 42, 'p', 'y', 'survey:update');
INSERT INTO `perms` VALUES (46, '内容管理', 'content/manager', NULL, NULL, 'm', 'y', NULL);
INSERT INTO `perms` VALUES (47, '内容列表', 'content/list', 'content', 46, 'm', 'y', 'content:list');
INSERT INTO `perms` VALUES (48, '新增内容', 'content/add', 'content/add', 47, 'p', 'y', 'content:add');
INSERT INTO `perms` VALUES (49, '删除内容', 'content/delete', 'content/delete', 47, 'p', 'y', 'content:delete');
INSERT INTO `perms` VALUES (50, '修改内容', 'content/update', 'content/update', 47, 'p', 'y', 'content:update');
INSERT INTO `perms` VALUES (51, 'Banner管理', 'banner/manager', NULL, NULL, 'm', 'y', '');
INSERT INTO `perms` VALUES (52, 'Banner列表', 'banner/list', 'banner', 51, 'm', 'y', 'banner:list');
INSERT INTO `perms` VALUES (53, '添加Banner', 'banner/add', 'addbanner', 51, 'm', 'y', 'banner:add');
INSERT INTO `perms` VALUES (54, '修改Banner', 'banner/update', 'banner/update', 52, 'p', 'y', 'banner:update');
INSERT INTO `perms` VALUES (55, '删除Banner', 'banner/delete', 'banner/delete', 52, 'p', 'y', 'banner:delete');
INSERT INTO `perms` VALUES (56, '预约管理', 'arrange/manager', NULL, NULL, 'm', 'y', '');
INSERT INTO `perms` VALUES (57, '预约列表', 'arrange/list', 'arrange', 56, 'm', 'y', 'arrange:list');
INSERT INTO `perms` VALUES (58, '数据管理', 'echarts/manager', NULL, NULL, 'm', 'y', NULL);
INSERT INTO `perms` VALUES (59, '数据列表', 'echarts/list', 'echarts', 58, 'm', 'y', 'echarts:list');
INSERT INTO `perms` VALUES (60, '考试管理', 'exam/manager', NULL, NULL, 'm', 'y', NULL);
INSERT INTO `perms` VALUES (61, '考试查询', 'exam/list', 'exam', 60, 'm', 'y', 'exam:list');
INSERT INTO `perms` VALUES (62, '添加考试', 'exam/add', 'addexam', 60, 'm', 'y', 'exam:add');
INSERT INTO `perms` VALUES (63, '删除考试', 'exam/delete', 'exam/delete', 61, 'p', 'y', 'exam:delete');
INSERT INTO `perms` VALUES (64, '修改考试', 'exam/update', 'exam/update', 61, 'p', 'y', 'exam:update');
INSERT INTO `perms` VALUES (65, '题库管理', 'questionBank/manager', '', NULL, 'm', 'y', NULL);
INSERT INTO `perms` VALUES (66, '题库列表', 'questionBank/list', 'questionBank', 65, 'm', 'y', 'questionBank:list');
INSERT INTO `perms` VALUES (67, '题库列表', 'questionBank/list', 'questionBank', 65, 'm', 'y', 'questionBank:list');
INSERT INTO `perms` VALUES (68, '添加题目', 'questionBank/add', 'addquestion', 65, 'm', 'y', 'questionBank:add');
INSERT INTO `perms` VALUES (69, '成绩管理', 'score/manager', NULL, NULL, 'm', 'y', NULL);
INSERT INTO `perms` VALUES (70, '成绩列表', 'score/list', 'score', 69, 'm', 'y', 'score:list');
INSERT INTO `perms` VALUES (71, '分段成绩', 'partScore/list', 'partScore', 69, 'm', 'y', 'partScore:list');
INSERT INTO `perms` VALUES (72, '新闻管理', 'news/manager', NULL, NULL, 'm', 'y', NULL);
INSERT INTO `perms` VALUES (73, '新闻列表', 'news/list', 'news', 72, 'm', 'y', 'news:list');
INSERT INTO `perms` VALUES (74, '新增新闻', 'news/add', 'news/add', 73, 'p', 'y', 'news:add');
INSERT INTO `perms` VALUES (75, '删除新闻', 'news/delete', 'news/delete', 73, 'p', 'y', 'news:delete');
INSERT INTO `perms` VALUES (76, '修改新闻', 'news/update', 'news/update', 73, 'p', 'y', 'news:update');

-- ----------------------------
-- Table structure for replay
-- ----------------------------
DROP TABLE IF EXISTS `replay`;
CREATE TABLE `replay`  (
  `messageId` int(0) NULL DEFAULT NULL COMMENT '留言编号',
  `replayId` int(0) NOT NULL AUTO_INCREMENT COMMENT '回复编号',
  `replay` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '内容',
  `replayTime` date NULL DEFAULT NULL COMMENT '回复时间',
  PRIMARY KEY (`replayId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '回复表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of replay
-- ----------------------------
INSERT INTO `replay` VALUES (26, 3, '好呀，我来了，你别跑！', '2019-03-18');
INSERT INTO `replay` VALUES (22, 4, '心疼你2秒钟', '2019-03-18');
INSERT INTO `replay` VALUES (25, 5, '我也要变强', '2019-03-19');
INSERT INTO `replay` VALUES (25, 6, '俺也一样', '2019-03-19');
INSERT INTO `replay` VALUES (21, 7, '既然这样，那就迎男而上吧', '2019-03-19');
INSERT INTO `replay` VALUES (16, 8, '那条街确实没什么东西可以吃了。。。', '2019-03-19');
INSERT INTO `replay` VALUES (15, 9, '咸鱼其实还可以吃，而你,emmmm', '2019-03-19');
INSERT INTO `replay` VALUES (21, 11, '我不怕人多', '2019-03-19');
INSERT INTO `replay` VALUES (20, 12, '是嘞，还行。', '2019-03-19');
INSERT INTO `replay` VALUES (26, 13, '我也爱你ε=(´ο｀*)))唉', '2019-03-19');
INSERT INTO `replay` VALUES (27, 14, '你这个坏孩子', '2019-03-31');
INSERT INTO `replay` VALUES (33, 18, '是的，今天是周一。', '2019-04-14');
INSERT INTO `replay` VALUES (34, 19, '1111', '2019-04-16');
INSERT INTO `replay` VALUES (34, 20, '2222', '2019-04-16');
INSERT INTO `replay` VALUES (35, 21, '666', '2019-09-05');

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score`  (
  `scoreId` int(0) NOT NULL AUTO_INCREMENT COMMENT '分数编号',
  `examCode` int(0) NULL DEFAULT NULL COMMENT '考试编号',
  `studentId` int(0) NULL DEFAULT NULL COMMENT '学号',
  `subject` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '课程名称',
  `ptScore` int(0) NULL DEFAULT NULL COMMENT '平时成绩',
  `etScore` int(0) NULL DEFAULT NULL COMMENT '期末成绩',
  `score` int(0) NULL DEFAULT NULL COMMENT '总成绩',
  `answerDate` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '答题日期',
  PRIMARY KEY (`scoreId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 42 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '成绩管理表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES (4, 20190001, 1, '计算机网络', NULL, 70, NULL, '2019-04-03');
INSERT INTO `score` VALUES (14, 20190002, 1, '数据库理论', NULL, 78, NULL, '2019-04-20');
INSERT INTO `score` VALUES (15, 20190002, 1, '数据库理论', NULL, 80, NULL, '2019-04-20');
INSERT INTO `score` VALUES (16, 20190002, 1, '数据库理论', NULL, 83, NULL, '2019-04-20');
INSERT INTO `score` VALUES (17, 20190001, 2, '计算机网络', NULL, 74, NULL, '2021-05-15');
INSERT INTO `score` VALUES (18, 20190001, 2, '计算机网络', NULL, 70, NULL, '2021-05-15');
INSERT INTO `score` VALUES (19, 20190001, 2, '计算机网络', NULL, 86, NULL, '2021-05-15');
INSERT INTO `score` VALUES (20, 20190001, 3, '计算机网络', NULL, 90, NULL, '2021-05-15');
INSERT INTO `score` VALUES (21, 20190001, 3, '计算机网络', NULL, 92, NULL, '2021-05-15');
INSERT INTO `score` VALUES (22, 20190001, 4, '计算机网络', NULL, 80, NULL, '2021-05-15');
INSERT INTO `score` VALUES (23, 20190001, 6, '计算机网络', NULL, 90, NULL, '2021-05-15');
INSERT INTO `score` VALUES (24, 20190001, 4, '计算机网络', NULL, 88, NULL, '2021-05-15');
INSERT INTO `score` VALUES (27, 20190001, 5, '计算机网络', NULL, 80, NULL, '2021-05-15');
INSERT INTO `score` VALUES (30, 20190001, 5, '计算机网络', NULL, 0, NULL, '2021-05-15');
INSERT INTO `score` VALUES (31, 20190001, 5, '计算机网络', NULL, 0, NULL, '2019-09-06');
INSERT INTO `score` VALUES (32, 20190001, 7, '计算机网络', NULL, 0, NULL, '2021-05-14');
INSERT INTO `score` VALUES (33, 20190001, 7, '计算机网络', NULL, 0, NULL, '2021-05-14');
INSERT INTO `score` VALUES (34, 20190001, 8, '计算机网络', NULL, 0, NULL, '2021-05-14');
INSERT INTO `score` VALUES (35, 20190001, 8, '计算机网络', NULL, 0, NULL, '2021-05-14');
INSERT INTO `score` VALUES (36, 20190001, 9, '计算机网络', NULL, 0, NULL, '2021-05-14');
INSERT INTO `score` VALUES (37, 20190001, 9, '计算机网络', NULL, 0, NULL, '2021-05-14');
INSERT INTO `score` VALUES (38, 20190001, NULL, '奇怪的考试', NULL, 0, NULL, '2021-05-14');
INSERT INTO `score` VALUES (39, 20190001, 2, '奇怪的考试', NULL, 0, NULL, '2021-05-15');
INSERT INTO `score` VALUES (40, 20190001, 2, '奇怪的考试', NULL, 0, NULL, '2021-05-15');
INSERT INTO `score` VALUES (41, 20190001, 2, '奇怪的考试', NULL, 4, NULL, '2021-05-15');

-- ----------------------------
-- Table structure for showdyn
-- ----------------------------
DROP TABLE IF EXISTS `showdyn`;
CREATE TABLE `showdyn`  (
  `id` int(0) NOT NULL,
  `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `description` varchar(400) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `picture` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `studentId` int(0) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `studentName` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '姓名',
  `grade` varchar(4) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '年级',
  `major` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '专业',
  `clazz` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '班级',
  `institute` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '学院',
  `tel` varchar(11) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '电话号码',
  `email` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '电子邮件',
  `pwd` varchar(16) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '密码',
  `cardId` varchar(18) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '身份证号',
  `sex` varchar(2) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '性别',
  `role` varchar(1) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '2' COMMENT '角色(0管理员，1教师，2学生)',
  PRIMARY KEY (`studentId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20155009 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '学生信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (20154001, '隔壁老王', '2015', '初中英语', '2', '初中部', '13585439532', 'gblw@163.com', '123456', '3412312', '男', '2');
INSERT INTO `student` VALUES (20154084, '大咸鱼', '2015', '初中英语', '2', '初中部', '13658377857', '13658377857@sina.cn', '123456', '124123124535', '男', '2');
INSERT INTO `student` VALUES (20155003, '张大宝', '2015', '初中英语', '1', '初中部', '15583829425', '15583829425@163.com', '123456', '3242342', '男', '2');
INSERT INTO `student` VALUES (20155007, '翠花', '2015', '初中英语', '1', '初中部', '18734538457', '18734538457@163.com', '123456', '2423423', '女', '2');
INSERT INTO `student` VALUES (20155008, '小王', '2015', '初中英语', '2', '初中部', '15523619564', '15523619564@163.com', '123456', '500234199704022353', '男', '2');

-- ----------------------------
-- Table structure for students
-- ----------------------------
DROP TABLE IF EXISTS `students`;
CREATE TABLE `students`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `gender` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `age` int(0) NOT NULL,
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `pName` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `pPhone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `email` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `address` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `courseid` int(0) NOT NULL,
  `comment` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '整体评价：0-差，1-中，2-优',
  `avatar` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '学生状态：0-在读，1-休学，2-毕业',
  `evaluation` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '老师评语',
  `grade` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `major` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `clazz` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `institute` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `cardId` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of students
-- ----------------------------
INSERT INTO `students` VALUES (1, '贾冰', '1', 15, '1399965644', '贾步菊', '13888123456', '123456', NULL, '湖北省武汉市武昌区首义路', 1, '0', '/default.jpg', '0', NULL, '小学', '英语', '小1', 'happy学院', '');
INSERT INTO `students` VALUES (2, '许可', '1', 12, NULL, '沈继云', '15996633001', '123456', NULL, '湖北省武汉市东西湖区', 1, '1', '/default.jpg', '1', '加油啊冲冲冲', '小学', '英语', '小1', 'happy学院', '');
INSERT INTO `students` VALUES (3, '贾玲', '0', 10, NULL, '贾金金', '15888776630', '123456', NULL, '湖北省武汉市江夏区文化大道', 1, NULL, '/default.jpg', '0', NULL, '小学', '英语', '小2', 'happy学院', '');
INSERT INTO `students` VALUES (4, '张小斐', '0', 13, '15888333660', '张全福', NULL, '123456', 'zxf@163.com', '黑龙江省漠河市', 2, '1', '/default.jpg', '0', '不错继续努力', '初中', '英语', '高1', 'happy学院', '');
INSERT INTO `students` VALUES (6, '马丽', '1', 16, NULL, '马冬梅', '13233657897', '123445', 'mali@163.com', '吉林省长春市', 2, '2', '/default.jpg', '0', '公公公公', '初中', '英语', '高1', 'happy学院', '');
INSERT INTO `students` VALUES (7, '袁华', '1', 12, '17465741312', '袁术', '13546785633', '123456', NULL, '山东省威海市', 3, '1', '/default.jpg', '0', '太难了', '高中', '英语', '高2', 'happy学院', '');
INSERT INTO `students` VALUES (8, '雷飒飒', '0', 15, NULL, '雷佳丽', '18889963332', '123456', 'lll@163.com', '北京海淀区', 3, '0', '/default.jpg', '0', NULL, '高中', '英语', '高2', 'happy学院', '');
INSERT INTO `students` VALUES (9, '张三', '1', 20, '13886621232', NULL, NULL, '1234456', NULL, NULL, 3, NULL, '/default.jpg', '0', NULL, '高中', '英语', '高2', 'happy学院', '');
INSERT INTO `students` VALUES (13, '易武', '男', 20, '15999663333', NULL, NULL, '123456', NULL, NULL, 3, NULL, '/default.jpg', '0', NULL, '高中', '英语', '高2', 'happy学院', '');
INSERT INTO `students` VALUES (14, '赵四', '1', 30, '13999666333', NULL, NULL, '123456', NULL, NULL, 3, NULL, '/default.jpg', '0', NULL, '高中', '英语', '高3', 'happy学院', '');

-- ----------------------------
-- Table structure for survey
-- ----------------------------
DROP TABLE IF EXISTS `survey`;
CREATE TABLE `survey`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `sRemarks` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `tRemarks` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `suggestions` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `log` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of survey
-- ----------------------------
INSERT INTO `survey` VALUES (1, '1', 'sssss', '1', 1);
INSERT INTO `survey` VALUES (2, '2', '123 ', '123', 1);
INSERT INTO `survey` VALUES (3, '3', ' WA ', '123 ', 1);
INSERT INTO `survey` VALUES (4, '4', '12 ', '132 ', 0);
INSERT INTO `survey` VALUES (5, '', '', '安慰', 0);
INSERT INTO `survey` VALUES (6, '我特色', '安慰安慰人艾瑞网人', '安慰安慰人 ', 0);
INSERT INTO `survey` VALUES (7, '安慰人', '安慰', '爱疯舞', 0);
INSERT INTO `survey` VALUES (8, NULL, NULL, '艾尔', 1);
INSERT INTO `survey` VALUES (9, 'AA', 'AA', '啊 ', 0);
INSERT INTO `survey` VALUES (10, '退回的', 'PPP', '人很多', 0);
INSERT INTO `survey` VALUES (11, '安慰', '安慰', '安慰', 0);
INSERT INTO `survey` VALUES (12, '知道', '安慰', '安慰', 0);
INSERT INTO `survey` VALUES (13, 'aa', 'aa', 'aa', 1);
INSERT INTO `survey` VALUES (14, 'qq', 'qq', 'aa', 1);
INSERT INTO `survey` VALUES (15, NULL, NULL, 'ww', 1);
INSERT INTO `survey` VALUES (16, NULL, NULL, 'a ', 1);

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `teacherId` int(0) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `teacherName` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '姓名',
  `institute` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '学院',
  `sex` varchar(2) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '性别',
  `tel` varchar(11) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '电话号码',
  `email` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '邮箱',
  `pwd` varchar(16) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '密码',
  `cardId` varchar(18) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '身份证号',
  `type` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '职称',
  `role` varchar(1) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '角色（0管理员，1教师，2学生）',
  PRIMARY KEY (`teacherId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20081003 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '教师信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (20081001, '张', '软件工程学院', '男', '13598458442', '13598458442@163.com', '123456', '423423283498', '讲师', '1');
INSERT INTO `teacher` VALUES (20081002, '王大志', '软件工程学院', '男', '1231221312', '1231221312@163.com', '123456', '24241234', '讲师', '1');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `account` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `username` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `gender` char(1) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `age` int(0) NULL DEFAULT NULL,
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `pName` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `pPhone` varchar(11) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `email` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `address` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `courseid` int(0) NULL DEFAULT NULL,
  `comment` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `avatar` varchar(60) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, '雷军', '雷军', '1', 1, '1', '1', '1', '1', '1', '1', 1, '1', '1', '1');
INSERT INTO `users` VALUES (2, '许可', '许可', '1', 1, '1', '1', '1', '1', '1', '1', 1, '1', '1', '1');
INSERT INTO `users` VALUES (3, 'zhangsan', '许可', '0', 1, '1', '1', '1', '123456', '1', '1', 1, '1', '1', '1');

-- ----------------------------
-- Table structure for video
-- ----------------------------
DROP TABLE IF EXISTS `video`;
CREATE TABLE `video`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `videoSourceId` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `price` double NOT NULL,
  `description` varchar(400) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `title` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `teacherid` int(0) NOT NULL,
  `type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `courseid` int(0) NOT NULL,
  `createtime` datetime(0) NULL DEFAULT NULL,
  `imageUrl` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of video
-- ----------------------------
INSERT INTO `video` VALUES (21, '8cd9da3cb7f7411d9366b12312431de9', 10, '讲的非常好，建议直接购买', 'Java高级篇', 11, 'y', 1, '2021-05-10 12:48:17', 'https://training-english.oss-cn-beijing.aliyuncs.com/70qp.jpg');
INSERT INTO `video` VALUES (22, '30649ea8b7a84ade9f8d2bda929bcc6f', 0, '很好的视频', '少儿英语', 11, 'y', 1, '2021-05-11 11:33:05', 'https://training-english.oss-cn-beijing.aliyuncs.com/70qp.jpg');
INSERT INTO `video` VALUES (23, '2b553ba832084724bd2999693d092ecf', 0, '超级好的视频', '初中英语', 11, 'y', 1, '2021-05-11 11:39:07', 'https://training-english.oss-cn-beijing.aliyuncs.com/s0g8.jpg');
INSERT INTO `video` VALUES (24, '', 33.5, '权限英语视频', '英语新视野', 24, 'y', 1, '2021-05-15 06:01:03', 'https://training-english.oss-cn-beijing.aliyuncs.com/togeter.jpg');

SET FOREIGN_KEY_CHECKS = 1;
