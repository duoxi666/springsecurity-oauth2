/*
 Navicat Premium Data Transfer

 Source Server         : 服务器数据库
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : 192.168.10.12:3306
 Source Schema         : user-db

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 17/03/2022 16:44:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for authorities
-- ----------------------------
DROP TABLE IF EXISTS `authorities`;
CREATE TABLE `authorities`  (
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `authority` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  UNIQUE INDEX `ix_auth_username`(`username`, `authority`) USING BTREE,
  CONSTRAINT `fk_authorities_users` FOREIGN KEY (`username`) REFERENCES `users` (`username`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of authorities
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `rolename` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `rolememo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, 'USER', '普通用户');
INSERT INTO `sys_role` VALUES (2, 'ADMIN', '管理员');
INSERT INTO `sys_role` VALUES (3, 'READ', '只读');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `username` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密码',
  `realname` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '真实名称',
  `isenabled` int NULL DEFAULT NULL COMMENT '是否可用',
  `islock` int NULL DEFAULT NULL COMMENT '是否锁定',
  `isexpired` int NULL DEFAULT NULL COMMENT '是否过期',
  `iscredentials` int NULL DEFAULT NULL COMMENT '证书是否过期',
  `createtime` date NULL DEFAULT NULL COMMENT '创建时间',
  `logintime` date NULL DEFAULT NULL COMMENT '登录时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (4, 'zs', '$2a$10$a689xXZOD7aj8sIYNLzqE.R1eR87DTnOoMxybaaB1/BzRYanYtwKu', '张三', 1, 1, 1, 1, '2022-03-15', '2022-03-15');
INSERT INTO `sys_user` VALUES (5, 'lisi', '$2a$10$COKc5ntYtbCKEG478YeUQOr5bgXDSSbFd3fNZVTpQ5H9TZFNxl5Dm', '李四', 1, 1, 1, 1, '2022-03-15', '2022-03-15');
INSERT INTO `sys_user` VALUES (7, 'admin', '$2a$10$A2F1JRwd7/XsZvwx6hglGuhNw8Xqaw3zUAqjrYo.sgFmcLvN/IsWS', '管理员', 1, 1, 1, 1, '2022-03-15', '2022-03-15');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `userid` int NULL DEFAULT NULL COMMENT '用户id',
  `roleid` int NULL DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (1, 4, 1);
INSERT INTO `sys_user_role` VALUES (2, 7, 2);
INSERT INTO `sys_user_role` VALUES (3, 5, 3);

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of users
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
