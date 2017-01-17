/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50553
Source Host           : localhost:3306
Source Database       : mybatis-plus

Target Server Type    : MYSQL
Target Server Version : 50553
File Encoding         : 65001

Date: 2017-01-17 17:02:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_id` int(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) DEFAULT NULL,
  `user_age` int(10) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=125 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('2', '2', '2');
INSERT INTO `t_user` VALUES ('3', '3', '3');
INSERT INTO `t_user` VALUES ('4', '4', '4');
INSERT INTO `t_user` VALUES ('5', '5', '5');
INSERT INTO `t_user` VALUES ('6', '6', '6');
INSERT INTO `t_user` VALUES ('7', '7', '7');
INSERT INTO `t_user` VALUES ('8', '8', '8');
INSERT INTO `t_user` VALUES ('9', '9', '9');
INSERT INTO `t_user` VALUES ('10', '10', '10');
INSERT INTO `t_user` VALUES ('11', '11', '11');
INSERT INTO `t_user` VALUES ('12', '12', '12');
INSERT INTO `t_user` VALUES ('123', '张三', '24');
INSERT INTO `t_user` VALUES ('124', '李四', '18');
