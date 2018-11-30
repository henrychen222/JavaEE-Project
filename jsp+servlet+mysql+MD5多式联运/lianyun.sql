/*
Navicat MySQL Data Transfer

Source Server         : crm
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : lianyun

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2015-06-15 13:42:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for chuhuoren
-- ----------------------------
DROP TABLE IF EXISTS `chuhuoren`;
CREATE TABLE `chuhuoren` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `sex` varchar(50) NOT NULL,
  `age` int(11) NOT NULL,
  `telephone` varchar(50) NOT NULL,
  `address` varchar(100) NOT NULL,
  `shouhuorenAddress` varchar(100) NOT NULL,
  `productName` varchar(50) NOT NULL,
  `applyStatus` varchar(50) NOT NULL,
  `identity` varchar(100) DEFAULT NULL,
  `fujian` varchar(500) DEFAULT NULL,
  `fujianYuanshiming` varchar(500) DEFAULT NULL,
  `shouhuorenTel` varchar(50) DEFAULT NULL,
  `shouhuorenName` varchar(50) DEFAULT NULL,
  `fahuoStatus` varchar(50) DEFAULT NULL,
  `productFujian` varchar(500) DEFAULT NULL,
  `productFujianYuanshiming` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of chuhuoren
-- ----------------------------
INSERT INTO `chuhuoren` VALUES ('1434011601870', '张珊', '女', '25', '15123456789', '南京市江宁区天元东路338号', '美国洛杉矶市', '苹果电脑', '已申请', '342426199001010000', '/upload/1434011567197.jpg', 'zhangsan.jpg', '13245678901', '张晓东', '已发货', '/upload/1434011595185.jpg', 'apple.jpg');
INSERT INTO `chuhuoren` VALUES ('1434080284444', '李思', '男', '20', '18112345678', '上海', '伦敦', 'iphone', '已申请', '342426199001020001', '/upload/1434080178253.jpg', 'lisi.jpg', '13212345678', '李军', '已发货', '/upload/1434080258358.jpg', 'iphone.jpg');

-- ----------------------------
-- Table structure for huifu
-- ----------------------------
DROP TABLE IF EXISTS `huifu`;
CREATE TABLE `huifu` (
  `id` varchar(50) NOT NULL,
  `content` varchar(50) DEFAULT NULL,
  `shijian` varchar(500) DEFAULT NULL,
  `user_id` varchar(50) DEFAULT NULL,
  `shoujianren` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of huifu
-- ----------------------------
INSERT INTO `huifu` VALUES ('1433912970673', '好的，张三', '2015-06-10 13:09', '1433404405402', '张三');
INSERT INTO `huifu` VALUES ('1433918626173', '不用谢', '2015-06-10 14:43', '1433404405402', '张三');
INSERT INTO `huifu` VALUES ('1433919043154', '我现在忙，李四', '2015-06-10 14:50', '1433404405402', '李四');
INSERT INTO `huifu` VALUES ('1433921828766', '好的，王五', '2015-06-10 15:37', '1433404446646', '王五');

-- ----------------------------
-- Table structure for jingyingren
-- ----------------------------
DROP TABLE IF EXISTS `jingyingren`;
CREATE TABLE `jingyingren` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `zigezhengFujian` varchar(500) DEFAULT NULL,
  `jingyan` varchar(50) DEFAULT NULL,
  `sex` varchar(50) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `gongsi` varchar(50) DEFAULT NULL,
  `fujian` varchar(500) DEFAULT NULL,
  `fujianYuanshiming` varchar(500) DEFAULT NULL,
  `zigezhengFujianYuanshiming` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jingyingren
-- ----------------------------
INSERT INTO `jingyingren` VALUES ('1434079311621', '张先生', '/upload/1434079278919.jpg', '3', '男', '20', '南京航运', '/upload/1434079289843.jpg', 'zhangxiansheng.jpg', 'zigezheng.jpg');

-- ----------------------------
-- Table structure for liuyan
-- ----------------------------
DROP TABLE IF EXISTS `liuyan`;
CREATE TABLE `liuyan` (
  `id` varchar(50) NOT NULL,
  `content` varchar(50) DEFAULT NULL,
  `shijian` varchar(50) DEFAULT NULL,
  `user_id` varchar(50) DEFAULT NULL,
  `shoujianren` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of liuyan
-- ----------------------------
INSERT INTO `liuyan` VALUES ('1433908156012', '张医生，我需要你的帮扶服务', '2015-06-10 11:49', '1433388881538', '张医生');
INSERT INTO `liuyan` VALUES ('1433917817309', '谢谢', '2015-06-10 14:30', '1433388881538', '张医生');
INSERT INTO `liuyan` VALUES ('1433918982604', '我需要张医生帮助', '2015-06-10 14:49', '1433401113927', '张医生');
INSERT INTO `liuyan` VALUES ('1433921776677', '我需要李医生帮扶', '2015-06-10 15:36', '1433723851670', '李医生');

-- ----------------------------
-- Table structure for shouhuoren
-- ----------------------------
DROP TABLE IF EXISTS `shouhuoren`;
CREATE TABLE `shouhuoren` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `address` varchar(500) DEFAULT NULL,
  `tel` varchar(50) DEFAULT NULL,
  `productName` varchar(50) DEFAULT NULL,
  `shouhuoStatus` varchar(50) DEFAULT NULL,
  `fujian` varchar(500) DEFAULT NULL,
  `fujianYuanshiming` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shouhuoren
-- ----------------------------
INSERT INTO `shouhuoren` VALUES ('1434090095461', '张晓东', '美国洛杉矶市', '13245678901', '苹果电脑', '已收货', '/upload/1434090042636.jpg', 'zhangxiaodong.jpg');
INSERT INTO `shouhuoren` VALUES ('1434090421503', '李军', '伦敦', '13212345678', 'iphone', '未收货', '/upload/1434090376482.jpg', 'lijun.jpg');
INSERT INTO `shouhuoren` VALUES ('1434091302082', '1', '1', '1', '1', '已收货', '', '');

-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
  `userId` varchar(50) NOT NULL,
  `userName` varchar(50) DEFAULT NULL,
  `userPw` varchar(50) DEFAULT NULL,
  `gonghao` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `telephone` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES ('1', 'admin', 'xMpCOKC5I4INzFCab3WEmw==', 'admin111111', '刘亦菲', '13245678901');
INSERT INTO `t_admin` VALUES ('1433989400136', 'admin1', 'xMpCOKC5I4INzFCab3WEmw==', '1', '李小龙', '1');

-- ----------------------------
-- Table structure for t_news
-- ----------------------------
DROP TABLE IF EXISTS `t_news`;
CREATE TABLE `t_news` (
  `id` varchar(50) NOT NULL,
  `title` varchar(50) DEFAULT NULL,
  `content` varchar(500) DEFAULT NULL,
  `shijian` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_news
-- ----------------------------
INSERT INTO `t_news` VALUES ('1433991481224', '三港互通，多式联运', '     “长期以来，困扰物流产业发展的，一方面是经济的发展，工业化、信息化、城镇化的全面提速，产生了旺盛的物流服务需求。另一方面是物流效率依然不高。”在昨日的签约仪式上，传化集团董事长徐冠巨坦陈，特别是占货运总量70％以上的公路物流，与空运、海运、铁路运输，乃至公路客运相比，还缺少服务于物流的、对运力和货源进行有效对接和统一调度的基础设施和网络指挥体系，从而导致制造业和商贸企业因为得不到高效的现代物流服务，物流成本居高不下，转型升级受到制约。\r\n\r\n　　据测算，中国的物流成本远高于欧美国家。目前，中国社会物流总费用占到GDP的18%，而像美国这样的发达国家，一般都是8%左右。毋庸置疑的是，中国物流成本之重已经成为阻碍传统制造业以及第三产业发展的“绊脚石”。\r\n\r\n　　另一组数据显示：在中国干线公路物流领域，年市场份额为2.6万亿元，其中一半是企业自建物流，还有约一半是第三方物流。同时，中国95%以上的第三方物流公司小而散，加之地方割据严重，往往导致“货找不到车，车找不到货”，造成中国高达40%的卡车空载率。\r\n    								', '2015-06-11 10:58');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(50) NOT NULL,
  `loginname` varchar(50) NOT NULL,
  `loginpw` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `sex` varchar(50) NOT NULL,
  `age` int(11) NOT NULL,
  `del` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1433988100592', '张珊', 'xMpCOKC5I4INzFCab3WEmw==', '张珊', '男', '20', 'no');
INSERT INTO `user` VALUES ('1434079068722', '张先生', 'xMpCOKC5I4INzFCab3WEmw==', '张先生', '男', '20', 'no');
INSERT INTO `user` VALUES ('1434080141882', '李思', 'xMpCOKC5I4INzFCab3WEmw==', '李思', '女', '20', 'no');
INSERT INTO `user` VALUES ('1434089997307', '张晓东', 'xMpCOKC5I4INzFCab3WEmw==', '张晓东', '男', '20', 'no');
INSERT INTO `user` VALUES ('1434090445712', '李军', 'xMpCOKC5I4INzFCab3WEmw==', '李军', '男', '20', 'no');
INSERT INTO `user` VALUES ('1434091282765', '1', 'xMpCOKC5I4INzFCab3WEmw==', '1', '男', '20', 'no');

-- ----------------------------
-- Table structure for yunshu
-- ----------------------------
DROP TABLE IF EXISTS `yunshu`;
CREATE TABLE `yunshu` (
  `id` varchar(50) NOT NULL,
  `productName` varchar(50) DEFAULT NULL,
  `chuhuorenName` varchar(50) DEFAULT NULL,
  `shouhuorenName` varchar(50) DEFAULT NULL,
  `chuhuorenTel` varchar(50) DEFAULT NULL,
  `shouhuorenTel` varchar(50) DEFAULT NULL,
  `yunshuStyle` varchar(50) DEFAULT NULL,
  `feiyong` int(11) DEFAULT NULL,
  `shijian` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of yunshu
-- ----------------------------
INSERT INTO `yunshu` VALUES ('1434097711251', 'iphone', '李思', '李军', '18112345678', '13212345678', '海--陆运输', '6000', '2015-06-12 16:28');
INSERT INTO `yunshu` VALUES ('1434252315421', 'iphone', '李思', '李军', '18112345678', '13212345678', '海--空运输', '45000', '2015-06-14 11:25');
