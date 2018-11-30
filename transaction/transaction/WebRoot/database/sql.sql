//创建数据库
create database transaction default charset=utf8;
//使用数据库
use transaction;

//用户表  2014年10月7日有改动，请更新
DROP TABLE IF EXISTS `user`;
create table user
( 
	id varchar(40) primary key,
	username varchar(20) not null,
	password varchar(100) not null,
	realname varchar(10),
	email varchar(32) ,
	phone varchar(11) unique,
	createtime timestamp,
	address varchar(100)
	
);


/*
	若想进入后台添加功能，请现在数据库中管理员类型表和管理员表添加以下字段：
		name:      power:        description:       updatetime:        createtime:
		super a,b,c,d,e,f,g,h,i 拥有所有权限！！ 2014-04-04 16:06:36 2014-03-12 00:00:00
		<<<<<<<<---------------------------------------------------->>>>>>>>>>
		id:                                  name:    password:(密码是：123) type:     description:                       updatetime:        createtime:
		ce20587e-3e1f-47b6-a9c3-757dd8843ff3 admin ICy5YqxZB1uWSwcVLSNLcA==  super 啊哈哈哈~~~~我也是超级管理员！！！2014-04-04 00:00:00 2014-03-12 00:00:00
*/
//管理员类型表
DROP TABLE IF EXISTS `manager_type`;
create table manager_type(
	name varchar(10) primary key,
	power varchar(32) default null,
	description varchar(120),
	updatetime timestamp ,
    createtime timestamp 
);

//管理员表
DROP TABLE IF EXISTS `admin`;
create table admin
(
	id varchar(40) primary key,
    name varchar(32) not null,
	password varchar(40) not null,
	gender varchar(4),
	birthday date,
	email varchar(32) unique,
	phone char(11) unique,
	type varchar(10) not null,
	description varchar(223) ,
	updatetime datetime ,
	createtime datetime ,
	constraint fk_admin_manager_type foreign key (type) references manager_type(name)
);

//商品类型表
DROP TABLE IF EXISTS `productcategory`;
create table productcategory(
	id int(11) AUTO_INCREMENT primary key,
	name varchar(40) not null,	
	level int(11) DEFAULT NULL,
	pid int(11) DEFAULT NULL
);

//商品类型的添加
 INSERT INTO productcategory (id,name,level,pid) VALUES 
 (1,'手机、配件',1,NULL),
 (2,'手机',2,1),
 (3,'智能手机',3,2),
 (4,'非智能手机',3,2),
 
 (5,'音频配件',2,1),
 (6,'蓝牙耳机',3,5),
 (7,'有线耳机',3,5),
 (8,'耳机转接线',3,5),
 (9,'手机音箱',3,5),
 
 (10,'充电配件',2,1),
 (11,'标准电池',3,10),
 (12,'商务电池',3,10),
 (13,'充电器',3,10),
 (14,'移动电源',3,10),
 
 (15,'数据配件',2,1),
 (16,'存储卡',3,15),
 (17,'读卡器',3,15),
 (18,'数据线',3,15),
 
 (19,'手机饰品',2,1),
 (20,'手机保护膜',3,19),
 (21,'手机挂件',3,19),
 (22,'手机套',3,19),
 
 (23,'摄影影像',1,null),
 (24,'数码摄像',2,23),
 (25,'数码相机',3,24),
 (26,'单反相机',3,24),
 (27,'数码摄像机',3,24),
 
 (28,'单反配件',2,23),
 (29,'长焦镜头',3,28),
 (30,'广角镜头',3,28),
 (31,'微距镜头',3,28),
 (32,'三脚架',3,28),
 (33,'镜头布',3,28),
 (34,'单反其他配件',3,28),
 
 (35,'笔记本、台式机',1,null),
 (36,'便携式电脑',2,35),
 (37,'笔记本电脑',3,36),
 (38,'平板电脑',3,36),
 
 (39,'台式电脑',2,35),
 (40,'台式电脑',3,39),
 (41,'主机',3,39),
 (42,'显示器',3,39),
 
 (43,'书籍、学习资料',1,null),
 (44,'教材',2,43),
 (45,'本科教材',3,44),
 (46,'专科教材',3,44),
 
 (47,'辅助资料书',2,43),
 (48,'同步练习',3,47),
 (49,'阶段测试',3,47),
 (50,'复习类',3,47),
 
 (51,'文学书籍',2,43),
 (52,'小说',3,51),
 (53,'其他',3,51),
 
 (54,'随身影音',1,null),
 (55,'影音娱乐',2,54),
 (56,'MP3',3,55),
 (57,'MP4',3,55),
 (58,'MP5',3,55),
 (59,'复读机',3,55),
 (60,'录音笔',3,55),
 (61,'收录机',3,55),
 
 (62,'耳机/耳麦',2,54),
 (63,'耳机',3,62),
 (64,'耳麦',3,62),
 
 (65,'电脑配件',1,null),
 (66,'电脑内部配件',2,65),
 (67,'内存条',3,66),
 (68,'网卡',3,66),
 (69,'声卡',3,66),
 (70,'显卡',3,66),
 (71,'CPU',3,66),
 (72,'主板',3,66),
 (73,'硬盘',3,66),
 
 (74,'电脑外设配件',2,65),
 (75,'鼠标',3,74),
 (76,'键盘',3,74),
 (77,'电源',3,74),
 (78,'移动硬盘',3,74),
 (79,'U盘',3,74),
 (80,'电脑音箱',3,74),
 (81,'电脑包',3,74),
 (82,'摄像头',3,74),
 (83,'散热风扇',3,74),
 (84,'鼠标垫',3,74),
 (85,'电脑清洁工具',3,74),
 
 (86,'办公设备',1,null),
 (87,'常用办公设备',2,86),
 (88,'打印机',3,87),
 (89,'扫描仪',3,87),
 (90,'投影仪',3,87),
 (91,'复印机',3,87),
 (92,'传真机',3,87),
 
 (93,'网络设备',2,86),
 (94,'无线路由',3,93),
 (95,'有线路由',3,93),
 (96,'交换机',3,93),
 
 (97,'厨房用品',1,null),
 (98,'厨房小电器',2,97),
 (99,'电磁炉',3,98),
 (100,'电饭煲',3,98),
 (101,'微波炉',3,98),
 (102,'电水煲/电水壶',3,98),
 (103,'豆浆机',3,98),
 (104,'其他',3,98),
 
 (105,'厨房用具',2,97),
 (106,'餐具',3,105),
 (107,'锅具',3,105),
 (108,'杯',3,105),
 (109,'其他',3,105),
 
 (110,'日常生活用品',1,null),
 (111,'生活用品',2,110),
 (112,'凉席',3,111),
 (113,'蚊帐',3,111),
 (114,'盆子',3,111),
 (115,'水瓶',3,111),
 (116,'雨具',3,111),
 (117,'桌/椅',3,111),
 (118,'其他',3,111),
 
 (119,'日用电器',2,110),
 (120,'电风扇',3,119),
 (121,'台灯',3,119),
 (122,'电吹风',3,119),
 (123,'剃须刀',3,119),
 (124,'美容美发器',3,119),
 (125,'电热毯',3,119),
 (126,'电热袋',3,119),
 (127,'其他',3,119),
 
 (128,'服装鞋帽、箱包',1,null),
 (129,'服装配饰',2,128),
 (130,'帽子',3,129),
 (131,'眼镜',3,129),
 (132,'皮带',3,129),
 (133,'围巾',3,129),
 (134,'发饰',3,129),
 
 (135,'女装',2,128),
 (136,'衬衫',3,135),
 (137,'T恤',3,135),
 (138,'裙装',3,135),
 (139,'外套',3,135),
 (140,'运动装',3,135),
 (141,'休闲裤',3,135),
 (142,'牛仔裤',3,135),
 (143,'鞋',3,135),
 (144,'其他',3,135),
 
 (145,'箱包、钟表首饰',2,128),
 (146,'旅行箱',3,145),
 (147,'运动休闲包',3,145),
 (148,'手表',3,145),
 (149,'闹钟',3,145),
 (150,'耳环/耳钉/耳坠',3,145),
 (151,'手链/手镯',3,145),
 (152,'项链/吊坠',3,145),
 (153,'戒指',3,145),
 (154,'其他',3,145),
 
 (155,'户外用品',1,null),
 (156,'体育用品',2,155),
 (157,'乒乓球用品',3,156),
 (158,'羽毛球用品',3,156),
 (159,'篮球用品',3,156),
 (160,'足球用品',3,156),
 (161,'网球用品',3,156),
 (162,'排球用品',3,156),
 
 (163,'户外健身',2,155),
 (164,'自行车',3,163),
 (165,'电动车',3,163),
 (166,'健身器材',3,163);
 
//图片表
DROP TABLE IF EXISTS `uploadimage`;
CREATE TABLE `uploadimage` (
  id int(32) AUTO_INCREMENT primary key,
  path varchar(512) NOT NULL
);

//商品表 2014-11-15增加了一字段purchaser，商品买家
DROP TABLE IF EXISTS `product`;
create table product
(
  id int(32) AUTO_INCREMENT primary key,
  name varchar(120) not null,
  originalprice float,
  price float NOT NULL,
  description varchar(512) not null,
  uploadimage varchar(512) NOT NULL,
  categoryID int(11),
  clickcount int(11) default 0, 
  status varchar(8) default '上架',
  trading varchar(16),
  createtime datetime, 
  updatetime datetime ,
  publisher varchar(32) NOT NULL,
  purchaser varchar(32),
  recomend varchar(8),
  constraint product_fk_productcategory foreign key (categoryID) references productcategory(id)
);

//订单表
DROP TABLE IF EXISTS `orders`;
create table orders(
  ordernumber varchar(40) primary key,
  productid int(32) not null,
  productname varchar(120) not null,
  imagepath varchar(512)not null,
  seller varchar(40) not null,
  purchaser varchar(40) not null,
  buyertetlphone varchar(11) not null,
  address varchar(120) not null,
  trading varchar(12)not null,
  amount float(12) not null,
  orderstatus varchar(8) not null,
  placeordertime timestamp,
  explains varchar (122) default null
); 

//商品收藏  做于2014年10月12，请添加
create table collect
(
	productid int(32) not null,
	userid varchar(40) not null,
	primary key (productid,userid),
	constraint product_fk_collect foreign key (productid) references product(id),
	constraint user_fk_collect foreign key (userid) references user(id)
);
//新闻表
create table new(
	id varchar(40) primary key,
	title varchar(128) NOT NULL,
	content varchar(1000) NOT NULL,
	publisher varchar(32) NOT NULL,
	updatetime timestamp ,
    createtime timestamp 
); 

