/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50630
Source Host           : localhost:3306
Source Database       : jamayette

Target Server Type    : MYSQL
Target Server Version : 50630
File Encoding         : 65001

Date: 2018-07-11 11:18:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_article
-- ----------------------------
DROP TABLE IF EXISTS `tb_article`;
CREATE TABLE `tb_article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `content` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10006 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_article
-- ----------------------------
INSERT INTO `tb_article` VALUES ('10005', 'zookeeper_principle', 'Zookeeper选主原理', '2017-12-19 00:00:00', '1', '<p><span style=\"font-family:Georgia,serif\">Zookeeper原理<br />\r\nZookeeper虽然在配置文件中并没有指定master和slave。但是，zookeeper工作时，是有一个节点为leader，其他则为follower。Leader是通过内部的选举机制临时产生的</span></p>\r\n\r\n<p><span style=\"font-family:Georgia,serif\">Zookeeper的选举机制</span></p>\r\n\r\n<p><span style=\"font-family:Georgia,serif\">全新集群paxos：<br />\r\n以一个简单的例子来说明整个选举的过程.<br />\r\n假设有五台服务器组成的zookeeper集群,它们的id从1-5,同时它们都是最新启动的,也就是没有历史数据,在存放数据量这一点上,都是一样的.假设这些服务器依序启动,来看看会发生什么.<br />\r\n1) 服务器1启动,此时只有它一台服务器启动了,它发出去的报没有任何响应,所以它的选举状态一直是LOOKING状态<br />\r\n2) 服务器2启动,它与最开始启动的服务器1进行通信,互相交换自己的选举结果,由于两者都没有历史数据,所以id值较大的服务器2胜出,但是由于没有达到超过半数以上的服务器都同意选举它(这个例子中的半数以上是3),所以服务器1,2还是继续保持LOOKING状态.<br />\r\n3) 服务器3启动,根据前面的理论分析,服务器3成为服务器1,2,3中的老大,而与上面不同的是,此时有三台服务器选举了它,所以它成为了这次选举的leader.<br />\r\n4) 服务器4启动,根据前面的分析,理论上服务器4应该是服务器1,2,3,4中最大的,但是由于前面已经有半数以上的服务器选举了服务器3,所以它只能接收当小弟的命了.<br />\r\n5) 服务器5启动,同4一样,当小弟.</span></p>\r\n\r\n<p><br />\r\n<span style=\"font-family:Georgia,serif\">非全新集群的选举机制(数据恢复)：<br />\r\n那么，初始化的时候，是按照上述的说明进行选举的，但是当zookeeper运行了一段时间之后，有机器down掉，重新选举时，选举过程就相对复杂了。<br />\r\n需要加入数据id、leader id和逻辑时钟。<br />\r\n数据id：数据新的id就大，数据每次更新都会更新id。<br />\r\nLeader id：就是我们配置的myid中的值，每个机器一个。<br />\r\n逻辑时钟：这个值从0开始递增,每次选举对应一个值,也就是说: &nbsp;如果在同一次选举中,那么这个值应该是一致的 ; &nbsp;逻辑时钟值越大,说明这一次选举leader的进程更新.<br />\r\n选举的标准就变成：<br />\r\n&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;1、逻辑时钟小的选举结果被忽略，重新投票<br />\r\n&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;2、统一逻辑时钟后，数据id大的胜出<br />\r\n&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;3、数据id相同的情况下，leader id大的胜出<br />\r\n根据这个规则选出leader。</span></p>');

-- ----------------------------
-- Table structure for tb_book
-- ----------------------------
DROP TABLE IF EXISTS `tb_book`;
CREATE TABLE `tb_book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `author` varchar(255) DEFAULT NULL,
  `publish_year` varchar(255) DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `img_url` varchar(255) DEFAULT NULL,
  `intro_url` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30002 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_book
-- ----------------------------
INSERT INTO `tb_book` VALUES ('30001', 'Algorithms 4th Edition', 'Robert Sedgewick / Kevin Wayne', '2017', '很不错', 'https://img3.doubanio.com/lpic/s28322244.jpg', 'https://book.douban.com/subject/19952400/', '1');

-- ----------------------------
-- Table structure for tb_message
-- ----------------------------
DROP TABLE IF EXISTS `tb_message`;
CREATE TABLE `tb_message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `phone_number` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `tag` varchar(255) DEFAULT NULL,
  `send_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_message
-- ----------------------------
INSERT INTO `tb_message` VALUES ('7', '1212313213213212', '好的 ', '哈哈', '2018-07-11 11:09:08', '1');
INSERT INTO `tb_message` VALUES ('8', '1212313213213212', '好的 ', '哈哈', '2018-07-11 11:12:20', '1');
INSERT INTO `tb_message` VALUES ('9', '1212313213213212', '好的 ', '哈哈', '2018-07-11 11:12:30', '1');
INSERT INTO `tb_message` VALUES ('10', '1212313213213212', '好的 ', '哈哈', '2018-07-11 11:12:31', '1');
INSERT INTO `tb_message` VALUES ('11', '1212313213213212', '好的 ', '哈哈', '2018-07-11 11:12:59', '1');
INSERT INTO `tb_message` VALUES ('12', '1212313213213212', '好的 ', '哈哈', '2018-07-11 11:13:50', '1');

-- ----------------------------
-- Table structure for tb_movie
-- ----------------------------
DROP TABLE IF EXISTS `tb_movie`;
CREATE TABLE `tb_movie` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `artist` varchar(255) DEFAULT NULL,
  `on_year` varchar(255) DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20003 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_movie
-- ----------------------------
INSERT INTO `tb_movie` VALUES ('20002', 'Django Unchained', '被解救的姜戈', '汀·塔伦蒂诺', '2012', '<p><img alt=\"\" src=\"http://ozum2yyu0.bkt.clouddn.com/django.jpg\" style=\"height:355px; width:672px\" /></p>\r\n\r\n<p>精彩</p>\r\n', '1');

-- ----------------------------
-- Table structure for tb_thoughts
-- ----------------------------
DROP TABLE IF EXISTS `tb_thoughts`;
CREATE TABLE `tb_thoughts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `content` varchar(10000) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40002 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_thoughts
-- ----------------------------
INSERT INTO `tb_thoughts` VALUES ('40001', 'i_d_rather_be_lucky', 'I\'d rather be lucky than good', '<p><span style=\"font-size:16px\"><span style=\"font-family:Arial,Helvetica,sans-serif\">&nbsp; The man who said &quot;I&#39;d rather be lucky than good&quot; saw deeply into life. People are afraid to face how great a part of life is dependent on luck. It&#39;s scary to think so much&nbsp;is out of one&#39;s control. There are moments in a match when the ball hits the top of the net, and for a split second, it can either go forward or fall back. With a little luck, it goes forward, and you win. Or maybe it doesn&#39;t, and you lose.</span></span></p>\r\n', '2017-12-19 00:00:00', '1');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', 'jamayette', 'jamayetteauthentification');
