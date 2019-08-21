/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : localhost:3306
 Source Schema         : jamayette

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 21/08/2019 14:40:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for life
-- ----------------------------
DROP TABLE IF EXISTS `life`;
CREATE TABLE `life`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `content` varchar(10000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_time` timestamp(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of life
-- ----------------------------
INSERT INTO `life` VALUES (1, 'i_d_rather_be_lucky', 'I\'d rather be lucky than good', '<p><span style=\"font-size:16px\"><span style=\"font-family:Arial,Helvetica,sans-serif\">&nbsp; The man who said &quot;I&#39;d rather be lucky than good&quot; saw deeply into life. People are afraid to face how great a part of life is dependent on luck. It&#39;s scary to think so much&nbsp;is out of one&#39;s control. There are moments in a match when the ball hits the top of the net, and for a split second, it can either go forward or fall back. With a little luck, it goes forward, and you win. Or maybe it doesn&#39;t, and you lose.</span></span></p>\r\n', '2019-08-20 10:15:06', '1');

-- ----------------------------
-- Table structure for subject
-- ----------------------------
DROP TABLE IF EXISTS `subject`;
CREATE TABLE `subject`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `publish_year` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `comment` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `img_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `intro_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of subject
-- ----------------------------
INSERT INTO `subject` VALUES (1, 'Algorithms 4th Edition', 'Robert Sedgewick / Kevin Wayne', '2017', '很不错', 'https://img3.doubanio.com/lpic/s28322244.jpg', 'https://book.douban.com/subject/19952400/', 1);

-- ----------------------------
-- Table structure for tech
-- ----------------------------
DROP TABLE IF EXISTS `tech`;
CREATE TABLE `tech`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '文章ID',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '文章名(英文访问路径)',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文章标题',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文章内容',
  `status` int(11) NOT NULL DEFAULT 0 COMMENT '文章状态0隐藏1显示',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tech
-- ----------------------------
INSERT INTO `tech` VALUES (1, 'zookeeper_principle', 'Zookeeper选主原理', '<p><span style=\"font-family:Georgia,serif\">Zookeeper原理<br />\r\nZookeeper虽然在配置文件中并没有指定master和slave。但是，zookeeper工作时，是有一个节点为leader，其他则为follower。Leader是通过内部的选举机制临时产生的</span></p>\r\n\r\n<p><span style=\"font-family:Georgia,serif\">Zookeeper的选举机制</span></p>\r\n\r\n<p><span style=\"font-family:Georgia,serif\">全新集群paxos：<br />\r\n以一个简单的例子来说明整个选举的过程.<br />\r\n假设有五台服务器组成的zookeeper集群,它们的id从1-5,同时它们都是最新启动的,也就是没有历史数据,在存放数据量这一点上,都是一样的.假设这些服务器依序启动,来看看会发生什么.<br />\r\n1) 服务器1启动,此时只有它一台服务器启动了,它发出去的报没有任何响应,所以它的选举状态一直是LOOKING状态<br />\r\n2) 服务器2启动,它与最开始启动的服务器1进行通信,互相交换自己的选举结果,由于两者都没有历史数据,所以id值较大的服务器2胜出,但是由于没有达到超过半数以上的服务器都同意选举它(这个例子中的半数以上是3),所以服务器1,2还是继续保持LOOKING状态.<br />\r\n3) 服务器3启动,根据前面的理论分析,服务器3成为服务器1,2,3中的老大,而与上面不同的是,此时有三台服务器选举了它,所以它成为了这次选举的leader.<br />\r\n4) 服务器4启动,根据前面的分析,理论上服务器4应该是服务器1,2,3,4中最大的,但是由于前面已经有半数以上的服务器选举了服务器3,所以它只能接收当小弟的命了.<br />\r\n5) 服务器5启动,同4一样,当小弟.</span></p>\r\n\r\n<p><br />\r\n<span style=\"font-family:Georgia,serif\">非全新集群的选举机制(数据恢复)：<br />\r\n那么，初始化的时候，是按照上述的说明进行选举的，但是当zookeeper运行了一段时间之后，有机器down掉，重新选举时，选举过程就相对复杂了。<br />\r\n需要加入数据id、leader id和逻辑时钟。<br />\r\n数据id：数据新的id就大，数据每次更新都会更新id。<br />\r\nLeader id：就是我们配置的myid中的值，每个机器一个。<br />\r\n逻辑时钟：这个值从0开始递增,每次选举对应一个值,也就是说: &nbsp;如果在同一次选举中,那么这个值应该是一致的 ; &nbsp;逻辑时钟值越大,说明这一次选举leader的进程更新.<br />\r\n选举的标准就变成：<br />\r\n&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;1、逻辑时钟小的选举结果被忽略，重新投票<br />\r\n&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;2、统一逻辑时钟后，数据id大的胜出<br />\r\n&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;3、数据id相同的情况下，leader id大的胜出<br />\r\n根据这个规则选出leader。</span></p>', 1, '2017-12-19 00:00:00');
INSERT INTO `tech` VALUES (10006, 'code_and_life', 'Code & life', '<p>code and life&nbsp;<img src=\"http://jamayette.cn-sh2.ufileos.com/1566369525464\" style=\"max-width: 100%;\"><img src=\"http://jamayette.cn-sh2.ufileos.com/1566369525656\" style=\"max-width: 100%;\"><img src=\"http://jamayette.cn-sh2.ufileos.com/1566369525770\" style=\"max-width: 100%;\"></p>', 0, '1994-10-26 00:00:00');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'jamayette', 'jamayetteauthentification');

SET FOREIGN_KEY_CHECKS = 1;
