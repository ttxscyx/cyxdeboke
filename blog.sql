/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80033
Source Host           : localhost:3306
Source Database       : blog

Target Server Type    : MYSQL
Target Server Version : 80033
File Encoding         : 65001

Date: 2023-08-16 06:50:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `roles_id` int DEFAULT NULL,
  `remarks` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'cyx', 'root', 'F59BD65F7EDAFB087A81D4DCA06C4910', null, null);

-- ----------------------------
-- Table structure for `blog`
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `admin_id` int DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL,
  `commentabled` bit(1) DEFAULT NULL,
  `content` varchar(3000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `img1` varchar(50) DEFAULT NULL,
  `img2` varchar(50) DEFAULT NULL,
  `img3` varchar(50) DEFAULT NULL,
  `img4` varchar(50) DEFAULT NULL,
  `img5` varchar(50) DEFAULT NULL,
  `img6` varchar(50) DEFAULT NULL,
  `releasetime` datetime DEFAULT NULL,
  `modifytime` datetime DEFAULT NULL,
  `comment_id` int DEFAULT NULL,
  `comment_count` int DEFAULT NULL,
  `type_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of blog
-- ----------------------------
INSERT INTO `blog` VALUES ('44', '1', '123123', '', '13212321', '../blog/img/backimg1.jpg', null, null, null, null, null, '2023-06-02 19:30:27', '2023-06-02 19:30:27', null, '4', '1');
INSERT INTO `blog` VALUES ('50', '1', '123', '', '123123', '../blog/img/backimg1.jpg', null, null, null, null, null, '2023-06-03 18:19:49', '2023-06-03 18:19:49', null, '0', '1');
INSERT INTO `blog` VALUES ('51', '1', 'gdasg', '', 'fafds', '../blog/img/backimg1.jpg', null, null, null, null, null, '2023-06-03 18:20:28', '2023-06-03 18:20:28', null, '0', '1');
INSERT INTO `blog` VALUES ('52', '1', 'aged', '', 'aggaga', '../blog/img/backimg1.jpg', null, null, null, null, null, '2023-06-03 18:21:35', '2023-06-03 18:21:35', null, '0', '1');
INSERT INTO `blog` VALUES ('59', '1', '软路由梯子：一种低成本、高效率的上网方式', '', '一、软路由梯子费用\r\n软路由梯子是一款基于自己搭建、运营的梯子，因此费用相对较低。在硬件方面，只需要购买一台性能不高的路由器并安装相应的软件即可完成梯子的搭建，成本通常不超过500元人民币。在软件方面，大多数软路由梯子使用开源软件，用户只需要支付服务商的使用费用即可，一年的费用通常在100-300元之间。\r\n\r\n下面是软路由梯子购买所需的物品和估算的费用：\r\n```java\r\n- 一台路由器：100-300元\r\n- U盘：20-50元\r\n- TF卡：20-50元\r\n- 梯子软件：100-300元/年\r\n```\r\n总花费通常不超过500元，比专业梯子服务商的费用低得多。\r\n\r\n二、梯子路由器\r\n软路由梯子需要一台性能较好的路由器来完成搭建。随着智能家居的快速发展，市面上出现了一些专门提供软路由服务的路由器，如红米AC2100、网件R6400、华硕RT-AC86U等。这些路由器在性能和硬件配置上，都比一般家用路由器要高出不少。但是，用户也可以选择购买普通的家用路由器并安装相应的软件来完成搭建。\r\n\r\n下面是一些常用的梯子路由器：\r\n```java\r\n- 红米AC2100：约400元\r\n- 华硕RT-AC86U：约1200元\r\n- 腾达AC10：约150元\r\n- 联想S1：约200元\r\n```\r\n三、软路由梯子收费\r\n软路由梯子通常是通过月付或者年付的方式进行收费。但是，一些梯子服务商也会提供免费试用的服务。在选择软路由梯子时，用户需要注意服务商的收费模式，以及是否提供免费试用。\r\n\r\n以下是一些常用的软路由梯子服务商及其收费情况：\r\n```java\r\n- Shadowsocks：一般收费100-200元/年\r\n- V2Ray：一般收费100-300元/年\r\n- WireGuard：一般收费50-100元/月\r\n```\r\n四、软路由搭梯子教程\r\n搭建软路由梯子并不是难事，只需要简单的几步即可完成。以下是软路由搭梯子的基本步骤：\r\n\r\n第一步：准备工作\r\n\r\n购买一台性能较好的路由器，以及一些必要的U盘和TF卡。此外，还需要下载梯子软件、WinSCP工具和PuTTY工具。\r\n\r\n第二步：安装固件\r\n\r\n将路由器刷上第三方固件，一般可以选择OpenWrt或LEDE。具体的刷机方式和固件下载链接可以在各种社区论坛或官方网站上找到。\r\n\r\n第三步：安装梯子软件\r\n\r\n登录路由器后台，上传梯子软件，按照软件提供的配置说明进行配置即可。\r\n\r\n第四步：测试使用\r\n\r\n将电脑或手机连接到梯子所在的wifi，打开浏览器访问Google、YouTube等被封锁的网站，确认能够正常访问。\r\n\r\n五、软路由梯子设置教程\r\n软路由梯子的设置相对简单，只需要按照梯子提供商提供的教程进行配置即可。以下为常见的配置方法：\r\n\r\n方法一：手动配置\r\n\r\n手动配置方法适用于熟悉网络知识、有一定动手能力的用户。具体配置方法如下：\r\n```java\r\n- 手动设置服务器地址和端口；\r\n- 设置加密方式和密码；\r\n- 配置DNS服务器；\r\n- 配置本地代理。\r\n```\r\n方法二：自动配置\r\n\r\n自动配置方法适用于不懂网络知识、没有动手能力的用户。具体配置方法如下：\r\n```java\r\n- 下载配套软件；\r\n- 安装并打开软件；\r\n- 点击连接按钮，完成自动配置。\r\n```\r\n六、软路由梯子违法吗\r\n使用软路由梯子并不违法，但是使用梯子来访问非法网站或者从事违法活动，则是违法行为。因此，在使用软路由梯子时，需要遵守当地法律法规，合理使用。\r\n\r\n七、软路由梯子购买\r\n购买软路由梯子可以选择专业的梯子服务商或者自行搭建。以下是一些常见的梯子服务商和自行搭建的方法：\r\n\r\n方法一：购买梯子服务\r\n\r\n购买梯子服务需要选择一个可靠的服务商，通常可以选择付费或免费的服务。以下是一些常见的梯子服务商：\r\n```java\r\n- Shadowsocks：开源软件，有大量的第三方服务商提供服务；\r\n- V2Ray：开源软件，有一些大型服务商提供服务；\r\n- WireGuard：新型的开源VPN协议，目前可支持的客户端和服务端数量较少。\r\n```\r\n方法二：自行搭建\r\n\r\n自行搭建需要购买一台性能较好的路由器，并刷上第三方固件，然后再下载安装梯子软件进行配置即可。自行搭建需要一定的技术基础，但是相对来说自由度更高、更安全可靠。\r\n\r\n八、软路由梯子原理\r\n软路由梯子的原理可以简单理解为，通过在路由器上安装梯子软件，将用户的网络流量进行加密和转发，从而实现对网络访问的过滤和翻墙。\r\n\r\n通常的软路由梯子使用的是代理协议或VPN协议。代理协议通常使用的是Shadowsocks协议，它具有高效、灵活、安全的特点。VPN协议通常使用的是OpenVPN或L2TP/IPsec协议，它可以将用户的网络流量进行加密，并使用虚拟IP地址进行隐藏，从而实现网络隐私保护。\r\n\r\n九、软路由梯子推荐选取\r\n软路由梯子种类繁多，推荐选取时需要根据自己的需求、认可度、服务质量等因素进行综合考量。以下是一些口碑较好的软路由梯子：\r\n```java\r\n- Shadowsocks：开源软件，稳定可靠，具有较高的用户认可度；\r\n- V2Ray：开源软件，新型的代理协议，支持协议伪装，使用起来更加安全可靠；\r\n- WireGuard：开源VPN协议，拥有极高的安全性和传输速度。\r\n```\r\n总之，软路由梯子是一种低成本、高效率的上网方式，它的优点在于安全、便捷、高速。在使用软路由梯子时，我们需要选择合适的服务商或自行搭建，并遵守电信管理局的相关规定，合理、安全使用。\r\n\r\n本文搬运自:[https://www.python100.com/html/84067.html](https://www.python100.com/html/84067.html)\r\n', '../blog/img/backimg1.jpg', null, null, null, null, null, '2023-07-03 20:36:31', '2023-07-06 01:02:14', null, '0', '2');
INSERT INTO `blog` VALUES ('61', '1', 'Nginx常用基本命令', '', '1、启动Nginx服务器命令：\r\n```java\r\n去到sbin路径：cd /usr/local/nginx/sbin\r\n启动Nginx服务器: ./nginx\r\n```\r\n2查看Nginx 版本号命令：\r\n```java\r\n./nginx -v\r\n或\r\n./nginx -V\r\n```\r\n3、查看Nginx进程命令：\r\n\r\n`ps aux|grep nginx`\r\n\r\n4、检查Nginx配置文件是否正确命令：\r\n\r\n ` ./nginx -t `\r\n\r\n指定检测特定Nginx配置文件：-c表示configuration，指定配置文件\r\n\r\n` ./nginx -t -c /usr/local/nginx/conf/nginx.conf `\r\n\r\n5、Nginx服务器指定启动配置文件命令：\r\n\r\n ` ./nginx -c /usr/local/nginx/conf/nginx.conf `\r\n\r\n6、暴力停止Nginx服务器命令：\r\n\r\n` ./nginx -s stop `\r\n\r\n7、优雅停止Nginx服务器命令：\r\n\r\n` ./nginx -s quit `\r\n\r\n8、Nginx重新加载配置文件命令：\r\n\r\n` ./nginx -s reload `\r\n\r\n9、显示Nginx帮助信息\r\n\r\n` ./nginx -? `\r\n\r\n二、Nginx通过master发送信号的相关命令\r\n\r\n若在nginx.conf配置了pid文件存放路径则该文件存放的就是Nginx主进程号，如果没指定则放在nginx的logs目录下。有了pid文 件，我们就不用先查询Nginx的主进程号，而直接向Nginx发送信号了，命令如下：\r\n\r\nkill -信号类型 \'/usr/nginx/logs/nginx.pid\' （推荐）\r\n\r\n1、从容停止Nginx服务器命令：\r\n\r\n` kill -QUIT 主进程号 `\r\n\r\n2、快速停止Nginx服务器命令：\r\n\r\n` kill -TERM 主进程号 `\r\n\r\n3、强制停止Nginx服务器命令：\r\n\r\n` pkill -9 nginx `\r\n\r\n本文搬运自:[https://blog.csdn.net/GyaoG/article/details/118054247](https://blog.csdn.net/GyaoG/article/details/118054247 \"https://blog.csdn.net/GyaoG/article/details/118054247\")', '../blog/img/backimg1.jpg', null, null, null, null, null, '2023-08-14 00:48:14', '2023-08-15 16:33:34', null, '0', '2');

-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nickname` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `avatar` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `blog_id` bigint DEFAULT NULL,
  `parent_comment_id` bigint DEFAULT NULL,
  `admin_comment` bit(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=83 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1', '1', '1525292140@qq.com', '12414', null, '2023-06-02 17:39:07', '42', '-1', '');
INSERT INTO `comment` VALUES ('2', '12313', '1525292140@qq.com', '你好', null, '2023-06-02 17:39:25', '42', '1', '');
INSERT INTO `comment` VALUES ('3', '123123', '1525292140@qq.com', '你好', null, '2023-06-02 17:40:04', '42', '2', '');
INSERT INTO `comment` VALUES ('4', '123123', '1525292140@qq.com', '你好', null, '2023-06-02 17:40:11', '42', '2', '');
INSERT INTO `comment` VALUES ('5', '你好', '13@163.com', 'hello', null, '2023-06-02 17:42:18', '42', '1', '');
INSERT INTO `comment` VALUES ('6', '你好', '13@163.com', 'hello', null, '2023-06-02 17:42:24', '42', '1', '');
INSERT INTO `comment` VALUES ('7', '123', '15@193.com', 'hello', null, '2023-06-02 17:44:20', '43', '-1', '');
INSERT INTO `comment` VALUES ('8', '123', '15@163com', '123123', null, '2023-06-02 17:46:58', '43', '-1', '');
INSERT INTO `comment` VALUES ('9', '312', '15@163.com', '123312', null, '2023-06-02 18:00:24', '41', '-1', '');
INSERT INTO `comment` VALUES ('10', '13132', '1123123@163.com', '123123', null, '2023-06-02 18:03:14', '41', '-1', '');
INSERT INTO `comment` VALUES ('11', '132', '1123123@163.com', '132123', null, '2023-06-02 18:04:20', '41', '-1', '');
INSERT INTO `comment` VALUES ('12', '123', '15241741217@qq.com', '123123', null, '2023-06-02 18:19:39', '41', '-1', '');
INSERT INTO `comment` VALUES ('13', '411515', '1123123@163.com', '1231', null, '2023-06-02 18:27:49', '41', '-1', '');
INSERT INTO `comment` VALUES ('14', '14', '1123123@163.com', '413143', null, '2023-06-02 18:56:43', '41', '-1', '');
INSERT INTO `comment` VALUES ('15', '143', '1123123@163.com', '143134', null, '2023-06-02 18:58:15', '42', '-1', '');
INSERT INTO `comment` VALUES ('16', '14', '1525292140@qq.com', '1432341', null, '2023-06-02 18:59:26', '42', '-1', '');
INSERT INTO `comment` VALUES ('17', '1', '1525292140@qq.com', '141432', null, '2023-06-02 18:59:58', '42', '-1', '');
INSERT INTO `comment` VALUES ('18', '1', '1525292140@qq.com', '1423', null, '2023-06-02 19:02:33', '42', '-1', '');
INSERT INTO `comment` VALUES ('19', '你好', '1123123@163.com', '你好', null, '2023-06-02 19:02:55', '42', '-1', '');
INSERT INTO `comment` VALUES ('20', '你好', '15241741217@qq.com', '你还有', null, '2023-06-02 19:06:18', '42', '-1', '');
INSERT INTO `comment` VALUES ('21', '1', '1525292140@qq.com', '41214', null, '2023-06-02 19:08:36', '42', '-1', '');
INSERT INTO `comment` VALUES ('22', '132', '1525292140@qq.com', 'iawifeibgwanigknjg', null, '2023-06-02 19:09:28', '42', '-1', '');
INSERT INTO `comment` VALUES ('23', '123123', '1123123@163.com', 'agkjnnkjgankjgnkjlnlk', null, '2023-06-02 19:10:36', '42', '-1', '');
INSERT INTO `comment` VALUES ('24', '411515', '1123123@163.com', 'gakjnnkjgakjn', null, '2023-06-02 19:12:10', '42', '-1', '');
INSERT INTO `comment` VALUES ('25', '1', '1525292140@qq.com', 'hello', null, '2023-06-02 19:12:27', '43', '-1', '');
INSERT INTO `comment` VALUES ('26', '132', '1525292140@qq.com', '123123', null, '2023-06-02 19:32:24', '46', '-1', '');
INSERT INTO `comment` VALUES ('27', '132', '1525292140@qq.com', '123124214', null, '2023-06-02 19:33:34', '46', '-1', '');
INSERT INTO `comment` VALUES ('28', '132', '1525292140@qq.com', '143314', null, '2023-06-02 19:35:18', '46', '-1', '');
INSERT INTO `comment` VALUES ('29', '132', '1525292140@qq.com', '143341243', null, '2023-06-02 19:36:28', '46', '-1', '');
INSERT INTO `comment` VALUES ('30', '132', '1525292140@qq.com', '143341243', null, '2023-06-02 19:36:40', '46', '-1', '');
INSERT INTO `comment` VALUES ('31', '132', '1525292140@qq.com', '143341243', null, '2023-06-02 19:36:41', '46', '-1', '');
INSERT INTO `comment` VALUES ('32', '132', '1525292140@qq.com', '143341243', null, '2023-06-02 19:36:42', '46', '-1', '');
INSERT INTO `comment` VALUES ('33', '411515', '1525292140@qq.com', '412432341432', null, '2023-06-02 19:37:59', '46', '-1', '');
INSERT INTO `comment` VALUES ('34', '12123', '1525292140@qq.com', 'model.addAttribute(\"blog\", detailedBlog);', null, '2023-06-02 19:38:49', '46', '-1', '');
INSERT INTO `comment` VALUES ('35', '123132', '1525292140@qq.com', 'comment.getBlogId();', null, '2023-06-02 19:40:23', '46', '-1', '');
INSERT INTO `comment` VALUES ('36', '132', '1525292140@qq.com', 'Servlet.service() for servlet [dispatcherServlet] in context with path [] threw exception [Request processing failed; nested exception is java.lang.IllegalArgumentException: Model has no value for key \'id\'] with root cause', null, '2023-06-02 19:42:23', '46', '-1', '');
INSERT INTO `comment` VALUES ('37', '1', '1525292140@qq.com', '15513', null, '2023-06-02 19:44:15', '46', '-1', '');
INSERT INTO `comment` VALUES ('38', '12331', '1525292140@qq.com', 'model.addAttribute(\"comments\", comments);', null, '2023-06-02 19:46:59', '46', '-1', '');
INSERT INTO `comment` VALUES ('39', '123123', '1525292140@qq.com', '/footer/blogmessage', null, '2023-06-02 19:48:36', '46', '-1', '');
INSERT INTO `comment` VALUES ('40', '143', '1525292140@qq.com', '1423431', null, '2023-06-02 19:49:03', '46', '-1', '');
INSERT INTO `comment` VALUES ('41', '132', '1525292140@qq.com', '141212', null, '2023-06-02 19:50:02', '45', '-1', '');
INSERT INTO `comment` VALUES ('42', '411515', '1525292140@qq.com', '14142', null, '2023-06-02 19:51:31', '45', '-1', '');
INSERT INTO `comment` VALUES ('43', '132', '1524174117@qq.com', '142124', null, '2023-06-02 23:03:04', '44', '-1', '');
INSERT INTO `comment` VALUES ('44', '132', '1123123@163.com', '31213', null, '2023-06-02 23:03:20', '44', '-1', '');
INSERT INTO `comment` VALUES ('45', '1', '1525292140@qq.com', '123123', null, '2023-06-02 23:04:13', '44', '-1', '');
INSERT INTO `comment` VALUES ('46', '1', '1525292140@qq.com', '123123', null, '2023-06-02 23:05:17', '45', '42', '');
INSERT INTO `comment` VALUES ('47', '1', '1525292140@qq.com', '123123', null, '2023-06-02 23:05:24', '45', '-1', '');
INSERT INTO `comment` VALUES ('48', '1', '1572903508@qq.com', '1321321321321fasfas', null, '2023-06-02 23:06:46', '45', '-1', '');
INSERT INTO `comment` VALUES ('49', '123', '1123123@163.com', '123213', null, '2023-06-02 23:07:16', '44', '-1', '');
INSERT INTO `comment` VALUES ('50', '123', '1525292140@qq.com', '12312313', null, '2023-06-02 23:14:04', '45', '48', '');
INSERT INTO `comment` VALUES ('51', 'cyx', '1572903508@qq.com', '213123123', null, '2023-06-02 23:16:05', '47', '-1', '');
INSERT INTO `comment` VALUES ('52', 'cyx', '1525292140@qq.com', '2131231321', null, '2023-06-02 23:16:24', '47', '51', '');
INSERT INTO `comment` VALUES ('53', '14121', '1123123@163.com', '12312312', null, '2023-06-02 23:20:41', '45', '-1', '');
INSERT INTO `comment` VALUES ('54', '123123', '1524174117@qq.com', '123123', null, '2023-06-02 23:22:34', '47', '51', '');
INSERT INTO `comment` VALUES ('55', '12313', '1525292140@qq.com', '123123', null, '2023-06-02 23:23:11', '47', '-1', '');
INSERT INTO `comment` VALUES ('56', '123123', '1525292140@qq.com', '132123', null, '2023-06-02 23:23:32', '47', '55', '');
INSERT INTO `comment` VALUES ('57', '1241241', '1123123@163.com', '1234142142', null, '2023-06-02 23:24:02', '47', '-1', '');
INSERT INTO `comment` VALUES ('58', '1431432', '1525292140@qq.com', '13423142432', null, '2023-06-02 23:24:29', '47', '-1', '');
INSERT INTO `comment` VALUES ('59', '43143124312', '1525292140@qq.com', '14321324431', null, '2023-06-02 23:26:39', '47', '-1', '');
INSERT INTO `comment` VALUES ('60', '1', '1524174117@qq.com', 'jmnkgslmkdglakjs', null, '2023-06-02 23:26:51', '47', '59', '');
INSERT INTO `comment` VALUES ('61', '411515', '1123123@163.com', '123123', null, '2023-06-03 00:03:22', '48', '-1', '');
INSERT INTO `comment` VALUES ('62', '1', '1524174117@qq.com', '123', null, '2023-06-03 00:03:28', '48', '61', '');
INSERT INTO `comment` VALUES ('63', '123', '1123123@163.com', '123312', null, '2023-06-03 00:59:57', '45', '-1', '');
INSERT INTO `comment` VALUES ('64', '1', '1525292140@qq.com', '213312', null, '2023-06-03 01:00:25', '45', '63', '');
INSERT INTO `comment` VALUES ('65', '1312', '1123123@163.com', '213123', null, '2023-06-03 01:00:48', '45', '-1', '');
INSERT INTO `comment` VALUES ('66', '123', '1572903508@qq.com', '123123', null, '2023-06-03 01:01:01', '45', '-1', '');
INSERT INTO `comment` VALUES ('67', '213123', '1572903508@qq.com', '123123', null, '2023-06-03 01:01:19', '45', '65', '');
INSERT INTO `comment` VALUES ('68', '1', '1525292140@qq.com', '我23132', null, '2023-06-03 01:01:30', '45', '67', '');
INSERT INTO `comment` VALUES ('69', '132', '1525292140@qq.com', '123123', null, '2023-06-29 00:21:55', '58', '-1', '');
INSERT INTO `comment` VALUES ('70', 'cyx', '1525292140@qq.com', '321213', null, '2023-06-29 00:24:04', '58', '-1', '');
INSERT INTO `comment` VALUES ('71', '21', '1525292140@qq.com', '213213', null, '2023-06-29 00:24:52', '58', '-1', '');
INSERT INTO `comment` VALUES ('72', '31', '1123123@163.com', '13212', null, '2023-06-29 00:25:49', '58', '-1', '');
INSERT INTO `comment` VALUES ('73', 'cyx', '1524174117@qq.com', 'qweqwe', null, '2023-06-29 00:38:28', '58', '-1', '');
INSERT INTO `comment` VALUES ('74', 'cyx', '1525292140@qq.com', '123312', null, '2023-06-30 02:12:20', '58', '-1', '');
INSERT INTO `comment` VALUES ('75', 'cyx', '15241741217@qq.com', 'dffsdaf', null, '2023-06-30 02:13:20', '58', '74', '');
INSERT INTO `comment` VALUES ('76', '3412fa', '1524174117@qq.com', '123123', null, '2023-06-30 02:15:49', '58', '-1', '');
INSERT INTO `comment` VALUES ('77', '132', '1524174117@qq.com', '132', null, '2023-06-30 02:21:41', '58', '-1', '');
INSERT INTO `comment` VALUES ('78', 'cyx', '1524174117@qq.com', '132', null, '2023-06-30 02:21:50', '58', '-1', '');
INSERT INTO `comment` VALUES ('79', 'cyx', '1525292140@qq.com', '312213', null, '2023-06-30 02:22:25', '58', '-1', '');
INSERT INTO `comment` VALUES ('80', 'cyx', '1525292140@qq.com', '2342', null, '2023-06-30 02:23:33', '58', '-1', '');
INSERT INTO `comment` VALUES ('81', 'cyx', '1524174117@qq.com', '142124', null, '2023-06-30 02:29:32', '58', '-1', '');
INSERT INTO `comment` VALUES ('82', 'cyx', '1524174117@qq.com', '124142', null, '2023-06-30 02:33:23', '58', '-1', '');

-- ----------------------------
-- Table structure for `message`
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nickname` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `avatar` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `parent_message_id` bigint DEFAULT NULL,
  `admin_message` bit(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES ('1', '123', '1525292140@qq.com', '132', '../blog/img/me.jpg', '2023-06-03 21:15:07', '-1', '');
INSERT INTO `message` VALUES ('3', '1', '1572903508@qq.com', '123312', '../blog/img/me.jpg', '2023-06-03 21:31:59', '-1', '');
INSERT INTO `message` VALUES ('4', '123', '1524174117@qq.com', '132321', '../blog/img/me.jpg', '2023-06-03 21:32:16', '3', '');
INSERT INTO `message` VALUES ('7', '123', '1548415141@qq.com', '123', '../blog/img/me.jpg', '2023-07-29 23:53:12', '-1', '');
INSERT INTO `message` VALUES ('8', 'bsddas', '1525292140@qq.com', '123', '../blog/img/me.jpg', '2023-07-29 23:53:29', '-1', '');
INSERT INTO `message` VALUES ('9', 'dsf', '1548415141@qq.com', '123123', '../blog/img/me.jpg', '2023-07-29 23:53:52', '8', '');

-- ----------------------------
-- Table structure for `roles`
-- ----------------------------
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles` (
  `id` bigint NOT NULL,
  `name` varchar(10) DEFAULT NULL,
  `power` int DEFAULT NULL,
  `remarks` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of roles
-- ----------------------------

-- ----------------------------
-- Table structure for `type`
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of type
-- ----------------------------
INSERT INTO `type` VALUES ('1', '原创');
INSERT INTO `type` VALUES ('2', '搬运');
INSERT INTO `type` VALUES ('3', '翻译');
