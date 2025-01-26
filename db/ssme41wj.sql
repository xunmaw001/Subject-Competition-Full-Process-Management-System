-- MySQL dump 10.13  Distrib 5.7.31, for Linux (x86_64)
--
-- Host: localhost    Database: ssme41wj
-- ------------------------------------------------------
-- Server version	5.7.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `ssme41wj`
--

/*!40000 DROP DATABASE IF EXISTS `ssme41wj`*/;

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `ssme41wj` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `ssme41wj`;

--
-- Table structure for table `config`
--

DROP TABLE IF EXISTS `config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) NOT NULL COMMENT '配置参数名称',
  `value` varchar(100) DEFAULT NULL COMMENT '配置参数值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='配置文件';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `config`
--

LOCK TABLES `config` WRITE;
/*!40000 ALTER TABLE `config` DISABLE KEYS */;
INSERT INTO `config` VALUES (1,'picture1','upload/picture1.jpg'),(2,'picture2','upload/picture2.jpg'),(3,'picture3','upload/picture3.jpg');
/*!40000 ALTER TABLE `config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discusshuojiangzhanshi`
--

DROP TABLE IF EXISTS `discusshuojiangzhanshi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `discusshuojiangzhanshi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `refid` bigint(20) NOT NULL COMMENT '关联表id',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `avatarurl` longtext COMMENT '头像',
  `nickname` varchar(200) DEFAULT NULL COMMENT '用户名',
  `content` longtext NOT NULL COMMENT '评论内容',
  `reply` longtext COMMENT '回复内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='获奖展示评论表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discusshuojiangzhanshi`
--

LOCK TABLES `discusshuojiangzhanshi` WRITE;
/*!40000 ALTER TABLE `discusshuojiangzhanshi` DISABLE KEYS */;
/*!40000 ALTER TABLE `discusshuojiangzhanshi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discussjingsaixinxi`
--

DROP TABLE IF EXISTS `discussjingsaixinxi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `discussjingsaixinxi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `refid` bigint(20) NOT NULL COMMENT '关联表id',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `avatarurl` longtext COMMENT '头像',
  `nickname` varchar(200) DEFAULT NULL COMMENT '用户名',
  `content` longtext NOT NULL COMMENT '评论内容',
  `reply` longtext COMMENT '回复内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='竞赛信息评论表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discussjingsaixinxi`
--

LOCK TABLES `discussjingsaixinxi` WRITE;
/*!40000 ALTER TABLE `discussjingsaixinxi` DISABLE KEYS */;
/*!40000 ALTER TABLE `discussjingsaixinxi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exampaper`
--

DROP TABLE IF EXISTS `exampaper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exampaper` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `name` varchar(200) NOT NULL COMMENT '模拟训练名称',
  `time` int(11) NOT NULL COMMENT '考试时长(分钟)',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '模拟训练状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1681137491357 DEFAULT CHARSET=utf8 COMMENT='模拟训练表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exampaper`
--

LOCK TABLES `exampaper` WRITE;
/*!40000 ALTER TABLE `exampaper` DISABLE KEYS */;
INSERT INTO `exampaper` VALUES (1,'2023-04-10 14:27:07','十万个为什么',60,1),(1681137491356,'2023-04-10 14:38:10','学科竞赛全流程',60,1);
/*!40000 ALTER TABLE `exampaper` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `examquestion`
--

DROP TABLE IF EXISTS `examquestion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `examquestion` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `paperid` bigint(20) NOT NULL COMMENT '所属模拟训练id（外键）',
  `papername` varchar(200) NOT NULL COMMENT '模拟训练名称',
  `questionname` varchar(200) NOT NULL COMMENT '试题名称',
  `options` longtext COMMENT '选项，json字符串',
  `score` bigint(20) DEFAULT '0' COMMENT '分值',
  `answer` varchar(200) DEFAULT NULL COMMENT '正确答案',
  `analysis` longtext COMMENT '答案解析',
  `type` bigint(20) DEFAULT '0' COMMENT '试题类型，0：单选题 1：多选题 2：判断题 3：填空题（暂不考虑多项填空）',
  `sequence` bigint(20) DEFAULT '100' COMMENT '试题排序，值越大排越前面',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1681137542204 DEFAULT CHARSET=utf8 COMMENT='试题表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `examquestion`
--

LOCK TABLES `examquestion` WRITE;
/*!40000 ALTER TABLE `examquestion` DISABLE KEYS */;
INSERT INTO `examquestion` VALUES (1,'2023-04-10 14:27:07',1,'十万个为什么','下面动物不属于昆虫的是（）。','[{\"text\":\"A.苍蝇\",\"code\":\"A\"},{\"text\":\"B.蜜蜂\",\"code\":\"B\"},{\"text\":\"C.蜂鸟\",\"code\":\"C\"}]',20,'C','蜂鸟',0,1),(2,'2023-04-10 14:27:07',1,'十万个为什么','油着火后可以用水扑灭。','[{\"text\":\"A.对\",\"code\":\"A\"},{\"text\":\"B.错\",\"code\":\"B\"}]',20,'B','油着火后不可以用水扑灭',2,2),(3,'2023-04-10 14:27:07',1,'十万个为什么','地球是个球体，中间是（ ）。','[]',30,'赤道','赤道',3,3),(4,'2023-04-10 14:27:07',1,'十万个为什么','下面动物中会流汗的有（ ）。','[{\"text\":\"A.马\",\"code\":\"A\"},{\"text\":\"B.猫\",\"code\":\"B\"},{\"text\":\"C.狗\",\"code\":\"C\"}]',30,'A,B','狗不会流汗',1,4),(1681137524108,'2023-04-10 14:38:43',1681137491356,'学科竞赛全流程','学科竞赛全流程','[{\"text\":\"A.11\",\"code\":\"A\"},{\"text\":\"B.22\",\"code\":\"B\"},{\"text\":\"C.33\",\"code\":\"C\"},{\"text\":\"D.44\",\"code\":\"D\"}]',10,'A','学科竞赛全流程',0,1),(1681137542203,'2023-04-10 14:39:01',1681137491356,'学科竞赛全流程','学科竞赛全流程','[{\"text\":\"A.对\",\"code\":\"A\"},{\"text\":\"B.错\",\"code\":\"B\"}]',10,'A','学科竞赛全流程',2,2);
/*!40000 ALTER TABLE `examquestion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `examrecord`
--

DROP TABLE IF EXISTS `examrecord`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `examrecord` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `username` varchar(200) DEFAULT NULL COMMENT '用户名',
  `paperid` bigint(20) NOT NULL COMMENT '模拟训练id（外键）',
  `papername` varchar(200) NOT NULL COMMENT '模拟训练名称',
  `questionid` bigint(20) NOT NULL COMMENT '试题id（外键）',
  `questionname` varchar(200) NOT NULL COMMENT '试题名称',
  `options` longtext COMMENT '选项，json字符串',
  `score` bigint(20) DEFAULT '0' COMMENT '分值',
  `answer` varchar(200) DEFAULT NULL COMMENT '正确答案',
  `analysis` longtext COMMENT '答案解析',
  `myscore` bigint(20) NOT NULL DEFAULT '0' COMMENT '试题得分',
  `myanswer` varchar(200) DEFAULT NULL COMMENT '考生答案',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1681137590922 DEFAULT CHARSET=utf8 COMMENT='考试记录表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `examrecord`
--

LOCK TABLES `examrecord` WRITE;
/*!40000 ALTER TABLE `examrecord` DISABLE KEYS */;
INSERT INTO `examrecord` VALUES (1681137308951,'2023-04-10 14:35:08',1681137284226,'王强',1,'十万个为什么',1,'下面动物不属于昆虫的是（）。','[{\"text\":\"A.苍蝇\",\"code\":\"A\"},{\"text\":\"B.蜜蜂\",\"code\":\"B\"},{\"text\":\"C.蜂鸟\",\"code\":\"C\"}]',20,'C','蜂鸟',20,'C'),(1681137310760,'2023-04-10 14:35:10',1681137284226,'王强',1,'十万个为什么',2,'油着火后可以用水扑灭。','[{\"text\":\"A.对\",\"code\":\"A\"},{\"text\":\"B.错\",\"code\":\"B\"}]',20,'B','油着火后不可以用水扑灭',0,'A'),(1681137314473,'2023-04-10 14:35:14',1681137284226,'王强',1,'十万个为什么',3,'地球是个球体，中间是（ ）。','[]',30,'赤道','赤道',30,'赤道'),(1681137318469,'2023-04-10 14:35:17',1681137284226,'王强',1,'十万个为什么',4,'下面动物中会流汗的有（ ）。','[{\"text\":\"A.马\",\"code\":\"A\"},{\"text\":\"B.猫\",\"code\":\"B\"},{\"text\":\"C.狗\",\"code\":\"C\"}]',30,'A,B','狗不会流汗',0,'A'),(1681137589146,'2023-04-10 14:39:48',1681137284226,'王强',1681137491356,'学科竞赛全流程',1681137524108,'学科竞赛全流程','[{\"text\":\"A.11\",\"code\":\"A\"},{\"text\":\"B.22\",\"code\":\"B\"},{\"text\":\"C.33\",\"code\":\"C\"},{\"text\":\"D.44\",\"code\":\"D\"}]',10,'A','学科竞赛全流程',10,'A'),(1681137590921,'2023-04-10 14:39:50',1681137284226,'王强',1681137491356,'学科竞赛全流程',1681137542203,'学科竞赛全流程','[{\"text\":\"A.对\",\"code\":\"A\"},{\"text\":\"B.错\",\"code\":\"B\"}]',10,'A','学科竞赛全流程',0,'B');
/*!40000 ALTER TABLE `examrecord` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `guizetongzhi`
--

DROP TABLE IF EXISTS `guizetongzhi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `guizetongzhi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `biaoti` varchar(200) NOT NULL COMMENT '标题',
  `tupian` longtext COMMENT '图片',
  `tongzhineirong` longtext NOT NULL COMMENT '通知内容',
  `fabushijian` date DEFAULT NULL COMMENT '发布时间',
  `faburen` varchar(200) DEFAULT NULL COMMENT '发布人',
  `userid` bigint(20) DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1681137477256 DEFAULT CHARSET=utf8 COMMENT='规则通知';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `guizetongzhi`
--

LOCK TABLES `guizetongzhi` WRITE;
/*!40000 ALTER TABLE `guizetongzhi` DISABLE KEYS */;
INSERT INTO `guizetongzhi` VALUES (71,'2023-04-10 14:27:07','标题1','upload/guizetongzhi_tupian1.jpg,upload/guizetongzhi_tupian2.jpg,upload/guizetongzhi_tupian3.jpg','通知内容1','2023-04-10','发布人1',1),(72,'2023-04-10 14:27:07','标题2','upload/guizetongzhi_tupian2.jpg,upload/guizetongzhi_tupian3.jpg,upload/guizetongzhi_tupian4.jpg','通知内容2','2023-04-10','发布人2',2),(73,'2023-04-10 14:27:07','标题3','upload/guizetongzhi_tupian3.jpg,upload/guizetongzhi_tupian4.jpg,upload/guizetongzhi_tupian5.jpg','通知内容3','2023-04-10','发布人3',3),(74,'2023-04-10 14:27:07','标题4','upload/guizetongzhi_tupian4.jpg,upload/guizetongzhi_tupian5.jpg,upload/guizetongzhi_tupian6.jpg','通知内容4','2023-04-10','发布人4',4),(75,'2023-04-10 14:27:07','标题5','upload/guizetongzhi_tupian5.jpg,upload/guizetongzhi_tupian6.jpg,upload/guizetongzhi_tupian7.jpg','通知内容5','2023-04-10','发布人5',5),(76,'2023-04-10 14:27:07','标题6','upload/guizetongzhi_tupian6.jpg,upload/guizetongzhi_tupian7.jpg,upload/guizetongzhi_tupian8.jpg','通知内容6','2023-04-10','发布人6',6),(77,'2023-04-10 14:27:07','标题7','upload/guizetongzhi_tupian7.jpg,upload/guizetongzhi_tupian8.jpg,upload/guizetongzhi_tupian9.jpg','通知内容7','2023-04-10','发布人7',7),(78,'2023-04-10 14:27:07','标题8','upload/guizetongzhi_tupian8.jpg,upload/guizetongzhi_tupian9.jpg,upload/guizetongzhi_tupian10.jpg','通知内容8','2023-04-10','发布人8',8),(1681137477255,'2023-04-10 14:37:56','学科竞赛全流程','upload/1681137467744.jpeg','<p>学科竞赛全流程学科竞赛全流程学科竞赛全流程学科竞赛全流程学科竞赛全流程学科竞赛全流程学科竞赛全流程学科竞赛全流程学科竞赛全流程学科竞赛全流程学科竞赛全流程学科竞赛全流程学科竞赛全流程学科竞赛全流程学科竞赛全流程学科竞赛全流程学科竞赛全流程</p>','2023-04-10','陈红',1681137352223);
/*!40000 ALTER TABLE `guizetongzhi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `huojiangzhanshi`
--

DROP TABLE IF EXISTS `huojiangzhanshi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `huojiangzhanshi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `jingsaimingcheng` varchar(200) NOT NULL COMMENT '竞赛名称',
  `fengmian` longtext COMMENT '封面',
  `jingsaileixing` varchar(200) NOT NULL COMMENT '竞赛类型',
  `jingsairiqi` date DEFAULT NULL COMMENT '竞赛日期',
  `huojiangmingdan` longtext NOT NULL COMMENT '获奖名单',
  `huojiangzhanshi` longtext NOT NULL COMMENT '获奖展示',
  `fabushijian` datetime DEFAULT NULL COMMENT '发布时间',
  `thumbsupnum` int(11) DEFAULT '0' COMMENT '赞',
  `crazilynum` int(11) DEFAULT '0' COMMENT '踩',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1681137702456 DEFAULT CHARSET=utf8 COMMENT='获奖展示';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `huojiangzhanshi`
--

LOCK TABLES `huojiangzhanshi` WRITE;
/*!40000 ALTER TABLE `huojiangzhanshi` DISABLE KEYS */;
INSERT INTO `huojiangzhanshi` VALUES (61,'2023-04-10 14:27:07','竞赛名称1','upload/huojiangzhanshi_fengmian1.jpg,upload/huojiangzhanshi_fengmian2.jpg,upload/huojiangzhanshi_fengmian3.jpg','个人赛','2023-04-10','获奖名单1','获奖展示1','2023-04-10 22:27:07',1,1),(62,'2023-04-10 14:27:07','竞赛名称2','upload/huojiangzhanshi_fengmian2.jpg,upload/huojiangzhanshi_fengmian3.jpg,upload/huojiangzhanshi_fengmian4.jpg','个人赛','2023-04-10','获奖名单2','获奖展示2','2023-04-10 22:27:07',2,2),(63,'2023-04-10 14:27:07','竞赛名称3','upload/huojiangzhanshi_fengmian3.jpg,upload/huojiangzhanshi_fengmian4.jpg,upload/huojiangzhanshi_fengmian5.jpg','个人赛','2023-04-10','获奖名单3','获奖展示3','2023-04-10 22:27:07',3,3),(64,'2023-04-10 14:27:07','竞赛名称4','upload/huojiangzhanshi_fengmian4.jpg,upload/huojiangzhanshi_fengmian5.jpg,upload/huojiangzhanshi_fengmian6.jpg','个人赛','2023-04-10','获奖名单4','获奖展示4','2023-04-10 22:27:07',4,4),(65,'2023-04-10 14:27:07','竞赛名称5','upload/huojiangzhanshi_fengmian5.jpg,upload/huojiangzhanshi_fengmian6.jpg,upload/huojiangzhanshi_fengmian7.jpg','个人赛','2023-04-10','获奖名单5','获奖展示5','2023-04-10 22:27:07',5,5),(66,'2023-04-10 14:27:07','竞赛名称6','upload/huojiangzhanshi_fengmian6.jpg,upload/huojiangzhanshi_fengmian7.jpg,upload/huojiangzhanshi_fengmian8.jpg','个人赛','2023-04-10','获奖名单6','获奖展示6','2023-04-10 22:27:07',6,6),(67,'2023-04-10 14:27:07','竞赛名称7','upload/huojiangzhanshi_fengmian7.jpg,upload/huojiangzhanshi_fengmian8.jpg,upload/huojiangzhanshi_fengmian9.jpg','个人赛','2023-04-10','获奖名单7','获奖展示7','2023-04-10 22:27:07',7,7),(68,'2023-04-10 14:27:07','竞赛名称8','upload/huojiangzhanshi_fengmian8.jpg,upload/huojiangzhanshi_fengmian9.jpg,upload/huojiangzhanshi_fengmian10.jpg','个人赛','2023-04-10','获奖名单8','获奖展示8','2023-04-10 22:27:07',8,8),(1681137702455,'2023-04-10 14:41:42','流程管理系统的设','upload/1681137683363.jpeg','个人赛','2023-04-27','学科竞赛全流程学科竞赛全流程学科竞赛全流程学科竞赛全流程学科竞赛全流程学科竞赛全流程学科竞赛全流程学科竞赛全流程学科竞赛全流程','<p>赛全流程学科竞赛全流程学科竞赛全流程学科竞赛全流程学科竞赛全流程学科竞赛全流程学科竞赛全流程学科竞赛全流程学科竞赛全流程赛全流程学科竞赛全流程学科竞赛全流程学科竞赛全流程学科竞赛全流程学科竞赛全流程学科竞赛全流程学科竞赛全流程学科竞赛全流程</p>','2023-04-10 22:39:58',0,0);
/*!40000 ALTER TABLE `huojiangzhanshi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jiaoshi`
--

DROP TABLE IF EXISTS `jiaoshi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jiaoshi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `jiaoshigonghao` varchar(200) NOT NULL COMMENT '教师工号',
  `mima` varchar(200) NOT NULL COMMENT '密码',
  `touxiang` longtext COMMENT '头像',
  `jiaoshixingming` varchar(200) DEFAULT NULL COMMENT '教师姓名',
  `xingbie` varchar(200) DEFAULT NULL COMMENT '性别',
  `lianxidianhua` varchar(200) DEFAULT NULL COMMENT '联系电话',
  `youxiang` varchar(200) DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`),
  UNIQUE KEY `jiaoshigonghao` (`jiaoshigonghao`)
) ENGINE=InnoDB AUTO_INCREMENT=1681137352224 DEFAULT CHARSET=utf8 COMMENT='教师';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jiaoshi`
--

LOCK TABLES `jiaoshi` WRITE;
/*!40000 ALTER TABLE `jiaoshi` DISABLE KEYS */;
INSERT INTO `jiaoshi` VALUES (11,'2023-04-10 14:27:07','教师工号1','123456','upload/jiaoshi_touxiang1.jpg','教师姓名1','男','13823888881','773890001@qq.com'),(12,'2023-04-10 14:27:07','教师工号2','123456','upload/jiaoshi_touxiang2.jpg','教师姓名2','男','13823888882','773890002@qq.com'),(13,'2023-04-10 14:27:07','教师工号3','123456','upload/jiaoshi_touxiang3.jpg','教师姓名3','男','13823888883','773890003@qq.com'),(14,'2023-04-10 14:27:07','教师工号4','123456','upload/jiaoshi_touxiang4.jpg','教师姓名4','男','13823888884','773890004@qq.com'),(15,'2023-04-10 14:27:07','教师工号5','123456','upload/jiaoshi_touxiang5.jpg','教师姓名5','男','13823888885','773890005@qq.com'),(16,'2023-04-10 14:27:07','教师工号6','123456','upload/jiaoshi_touxiang6.jpg','教师姓名6','男','13823888886','773890006@qq.com'),(17,'2023-04-10 14:27:07','教师工号7','123456','upload/jiaoshi_touxiang7.jpg','教师姓名7','男','13823888887','773890007@qq.com'),(18,'2023-04-10 14:27:07','教师工号8','123456','upload/jiaoshi_touxiang8.jpg','教师姓名8','男','13823888888','773890008@qq.com'),(1681137352223,'2023-04-10 14:35:52','002','002','upload/1681137343864.jpeg','陈红','女','13823855552','');
/*!40000 ALTER TABLE `jiaoshi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jingsaibaoming`
--

DROP TABLE IF EXISTS `jingsaibaoming`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jingsaibaoming` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `baomingbianhao` varchar(200) DEFAULT NULL COMMENT '报名编号',
  `jingsaimingcheng` varchar(200) DEFAULT NULL COMMENT '竞赛名称',
  `jingsaileixing` varchar(200) DEFAULT NULL COMMENT '竞赛类型',
  `jingsaishijian` varchar(200) DEFAULT NULL COMMENT '竞赛时间',
  `jingsaididian` varchar(200) DEFAULT NULL COMMENT '竞赛地点',
  `baomingshijian` datetime DEFAULT NULL COMMENT '报名时间',
  `xuehao` varchar(200) DEFAULT NULL COMMENT '学号',
  `xueshengxingming` varchar(200) DEFAULT NULL COMMENT '学生姓名',
  `shoujihaoma` varchar(200) DEFAULT NULL COMMENT '手机号码',
  `crossuserid` bigint(20) DEFAULT NULL COMMENT '跨表用户id',
  `crossrefid` bigint(20) DEFAULT NULL COMMENT '跨表主键id',
  `sfsh` varchar(200) DEFAULT '待审核' COMMENT '是否审核',
  `shhf` longtext COMMENT '审核回复',
  `userid` bigint(20) DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`id`),
  UNIQUE KEY `baomingbianhao` (`baomingbianhao`)
) ENGINE=InnoDB AUTO_INCREMENT=1681137575550 DEFAULT CHARSET=utf8 COMMENT='竞赛报名';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jingsaibaoming`
--

LOCK TABLES `jingsaibaoming` WRITE;
/*!40000 ALTER TABLE `jingsaibaoming` DISABLE KEYS */;
INSERT INTO `jingsaibaoming` VALUES (41,'2023-04-10 14:27:07','1111111111','竞赛名称1','竞赛类型1','竞赛时间1','竞赛地点1','2023-04-10 22:27:07','学号1','学生姓名1','手机号码1',1,1,'是','',1),(42,'2023-04-10 14:27:07','2222222222','竞赛名称2','竞赛类型2','竞赛时间2','竞赛地点2','2023-04-10 22:27:07','学号2','学生姓名2','手机号码2',2,2,'是','',2),(43,'2023-04-10 14:27:07','3333333333','竞赛名称3','竞赛类型3','竞赛时间3','竞赛地点3','2023-04-10 22:27:07','学号3','学生姓名3','手机号码3',3,3,'是','',3),(44,'2023-04-10 14:27:07','4444444444','竞赛名称4','竞赛类型4','竞赛时间4','竞赛地点4','2023-04-10 22:27:07','学号4','学生姓名4','手机号码4',4,4,'是','',4),(45,'2023-04-10 14:27:07','5555555555','竞赛名称5','竞赛类型5','竞赛时间5','竞赛地点5','2023-04-10 22:27:07','学号5','学生姓名5','手机号码5',5,5,'是','',5),(46,'2023-04-10 14:27:07','6666666666','竞赛名称6','竞赛类型6','竞赛时间6','竞赛地点6','2023-04-10 22:27:07','学号6','学生姓名6','手机号码6',6,6,'是','',6),(47,'2023-04-10 14:27:07','7777777777','竞赛名称7','竞赛类型7','竞赛时间7','竞赛地点7','2023-04-10 22:27:07','学号7','学生姓名7','手机号码7',7,7,'是','',7),(48,'2023-04-10 14:27:07','8888888888','竞赛名称8','竞赛类型8','竞赛时间8','竞赛地点8','2023-04-10 22:27:07','学号8','学生姓名8','手机号码8',8,8,'是','',8),(1681137575549,'2023-04-10 14:39:34','1681137498322','流程管理系统的设','个人赛','2023-04-28 09:00:00','流程管理系统的设','2023-04-10 22:38:18','001','王强','13823877774',1681137284226,1681137402055,'是','报名成功',1681137284226);
/*!40000 ALTER TABLE `jingsaibaoming` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jingsaichengji`
--

DROP TABLE IF EXISTS `jingsaichengji`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jingsaichengji` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `jingsaimingcheng` varchar(200) NOT NULL COMMENT '竞赛名称',
  `jingsaichengji` float NOT NULL COMMENT '竞赛成绩',
  `dengjiriqi` date DEFAULT NULL COMMENT '登记日期',
  `beizhu` varchar(200) DEFAULT NULL COMMENT '备注',
  `xuehao` varchar(200) DEFAULT NULL COMMENT '学号',
  `xueshengxingming` varchar(200) DEFAULT NULL COMMENT '学生姓名',
  `jiaoshigonghao` varchar(200) DEFAULT NULL COMMENT '教师工号',
  `jiaoshixingming` varchar(200) DEFAULT NULL COMMENT '教师姓名',
  `userid` bigint(20) DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1681137723586 DEFAULT CHARSET=utf8 COMMENT='竞赛成绩';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jingsaichengji`
--

LOCK TABLES `jingsaichengji` WRITE;
/*!40000 ALTER TABLE `jingsaichengji` DISABLE KEYS */;
INSERT INTO `jingsaichengji` VALUES (51,'2023-04-10 14:27:07','竞赛名称1',1,'2023-04-10','备注1','学号1','学生姓名1','教师工号1','教师姓名1',1),(52,'2023-04-10 14:27:07','竞赛名称2',2,'2023-04-10','备注2','学号2','学生姓名2','教师工号2','教师姓名2',2),(53,'2023-04-10 14:27:07','竞赛名称3',3,'2023-04-10','备注3','学号3','学生姓名3','教师工号3','教师姓名3',3),(54,'2023-04-10 14:27:07','竞赛名称4',4,'2023-04-10','备注4','学号4','学生姓名4','教师工号4','教师姓名4',4),(55,'2023-04-10 14:27:07','竞赛名称5',5,'2023-04-10','备注5','学号5','学生姓名5','教师工号5','教师姓名5',5),(56,'2023-04-10 14:27:07','竞赛名称6',6,'2023-04-10','备注6','学号6','学生姓名6','教师工号6','教师姓名6',6),(57,'2023-04-10 14:27:07','竞赛名称7',7,'2023-04-10','备注7','学号7','学生姓名7','教师工号7','教师姓名7',7),(58,'2023-04-10 14:27:07','竞赛名称8',8,'2023-04-10','备注8','学号8','学生姓名8','教师工号8','教师姓名8',8),(1681137723585,'2023-04-10 14:42:03','流程管理系统的设',90,'2023-04-10','','001','王强','002','陈红',NULL);
/*!40000 ALTER TABLE `jingsaichengji` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jingsaijingfei`
--

DROP TABLE IF EXISTS `jingsaijingfei`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jingsaijingfei` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `jingsaimingcheng` varchar(200) NOT NULL COMMENT '竞赛名称',
  `canyurenshu` varchar(200) NOT NULL COMMENT '参与人数',
  `jingsaijingfei` float NOT NULL COMMENT '竞赛经费',
  `jingfeixiangqing` longtext NOT NULL COMMENT '经费详情',
  `dengjishijian` datetime DEFAULT NULL COMMENT '登记时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1681137651724 DEFAULT CHARSET=utf8 COMMENT='竞赛经费';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jingsaijingfei`
--

LOCK TABLES `jingsaijingfei` WRITE;
/*!40000 ALTER TABLE `jingsaijingfei` DISABLE KEYS */;
INSERT INTO `jingsaijingfei` VALUES (81,'2023-04-10 14:27:07','竞赛名称1','参与人数1',1,'经费详情1','2023-04-10 22:27:07'),(82,'2023-04-10 14:27:07','竞赛名称2','参与人数2',12,'<p>经费详情2</p>','2023-04-10 22:27:07'),(83,'2023-04-10 14:27:07','竞赛名称3','参与人数3',3,'经费详情3','2023-04-10 22:27:07'),(84,'2023-04-10 14:27:07','竞赛名称4','参与人数4',4,'经费详情4','2023-04-10 22:27:07'),(85,'2023-04-10 14:27:07','竞赛名称5','参与人数5',7,'<p>经费详情5</p>','2023-04-10 22:27:07'),(86,'2023-04-10 14:27:07','竞赛名称6','参与人数6',6,'经费详情6','2023-04-10 22:27:07'),(87,'2023-04-10 14:27:07','竞赛名称7','参与人数7',7,'经费详情7','2023-04-10 22:27:07'),(88,'2023-04-10 14:27:07','竞赛名称8','参与人数8',8,'经费详情8','2023-04-10 22:27:07'),(1681137651723,'2023-04-10 14:40:51','流程管理系统的设','18',20,'<p>学科竞赛全流程</p><p>输入经费详情</p>','2023-04-10 22:39:22');
/*!40000 ALTER TABLE `jingsaijingfei` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jingsaixinxi`
--

DROP TABLE IF EXISTS `jingsaixinxi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jingsaixinxi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `jingsaimingcheng` varchar(200) NOT NULL COMMENT '竞赛名称',
  `jingsaileixing` varchar(200) NOT NULL COMMENT '竞赛类型',
  `jingsaitupian` longtext COMMENT '竞赛图片',
  `jingsaiguize` longtext COMMENT '竞赛规则',
  `jingsairenshu` int(11) NOT NULL COMMENT '竞赛人数',
  `jingsaishijian` datetime NOT NULL COMMENT '竞赛时间',
  `jingsaididian` varchar(200) DEFAULT NULL COMMENT '竞赛地点',
  `jingsaijieshao` longtext COMMENT '竞赛介绍',
  `reversetime` datetime DEFAULT NULL COMMENT '倒计结束时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1681137402056 DEFAULT CHARSET=utf8 COMMENT='竞赛信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jingsaixinxi`
--

LOCK TABLES `jingsaixinxi` WRITE;
/*!40000 ALTER TABLE `jingsaixinxi` DISABLE KEYS */;
INSERT INTO `jingsaixinxi` VALUES (31,'2023-04-10 14:27:07','竞赛名称1','个人赛','upload/jingsaixinxi_jingsaitupian1.jpg,upload/jingsaixinxi_jingsaitupian2.jpg,upload/jingsaixinxi_jingsaitupian3.jpg','竞赛规则1',1,'2023-04-10 22:27:07','竞赛地点1','竞赛介绍1','2023-04-11 00:00:00'),(32,'2023-04-10 14:27:07','竞赛名称2','个人赛','upload/jingsaixinxi_jingsaitupian2.jpg,upload/jingsaixinxi_jingsaitupian3.jpg,upload/jingsaixinxi_jingsaitupian4.jpg','竞赛规则2',2,'2023-04-10 22:27:07','竞赛地点2','竞赛介绍2','2023-04-11 00:00:00'),(33,'2023-04-10 14:27:07','竞赛名称3','个人赛','upload/jingsaixinxi_jingsaitupian3.jpg,upload/jingsaixinxi_jingsaitupian4.jpg,upload/jingsaixinxi_jingsaitupian5.jpg','竞赛规则3',3,'2023-04-10 22:27:07','竞赛地点3','竞赛介绍3','2023-04-11 00:00:00'),(34,'2023-04-10 14:27:07','竞赛名称4','个人赛','upload/jingsaixinxi_jingsaitupian4.jpg,upload/jingsaixinxi_jingsaitupian5.jpg,upload/jingsaixinxi_jingsaitupian6.jpg','竞赛规则4',4,'2023-04-10 22:27:07','竞赛地点4','竞赛介绍4','2023-04-11 00:00:00'),(35,'2023-04-10 14:27:07','竞赛名称5','个人赛','upload/jingsaixinxi_jingsaitupian5.jpg,upload/jingsaixinxi_jingsaitupian6.jpg,upload/jingsaixinxi_jingsaitupian7.jpg','竞赛规则5',5,'2023-04-10 22:27:07','竞赛地点5','竞赛介绍5','2023-04-11 00:00:00'),(36,'2023-04-10 14:27:07','竞赛名称6','个人赛','upload/jingsaixinxi_jingsaitupian6.jpg,upload/jingsaixinxi_jingsaitupian7.jpg,upload/jingsaixinxi_jingsaitupian8.jpg','竞赛规则6',6,'2023-04-10 22:27:07','竞赛地点6','竞赛介绍6','2023-04-11 00:00:00'),(37,'2023-04-10 14:27:07','竞赛名称7','个人赛','upload/jingsaixinxi_jingsaitupian7.jpg,upload/jingsaixinxi_jingsaitupian8.jpg,upload/jingsaixinxi_jingsaitupian9.jpg','竞赛规则7',7,'2023-04-10 22:27:07','竞赛地点7','竞赛介绍7','2023-04-11 00:00:00'),(38,'2023-04-10 14:27:07','竞赛名称8','个人赛','upload/jingsaixinxi_jingsaitupian8.jpg,upload/jingsaixinxi_jingsaitupian9.jpg,upload/jingsaixinxi_jingsaitupian10.jpg','竞赛规则8',8,'2023-04-10 22:27:07','竞赛地点8','竞赛介绍8','2023-04-11 00:00:00'),(1681137402055,'2023-04-10 14:36:41','流程管理系统的设','个人赛','upload/1681137367717.jpeg','流程管理系统的设流程管理系统的设流程管理系统的设流程管理系统的设流程管理系统的设流程管理系统的设流程管理系统的设流程管理系统的设流程管理系统的设流程管理系统的设流程管理系统的设流程管理系统的设流程管理系统的设',20,'2023-04-28 09:00:00','流程管理系统的设','<p>管理系统的设流程管理系统的设流程管理系统的设流程管理系统的设流程管理系统的设流程管理系统的设流程管理系统的设流程管理系统的设流程管理系统的设流程管理系统的设流程管理系统的设流程管理系统的设流程管理系统的设管理系统的设流程管理系统的设流程管理系统的设流程管理系统的设流程管理系统的设流程管理系统的设流程管理系统的设流程管理系统的设流程管理系统的设流程管理系统的设流程管理系统的设流程管理系统的设流程管理系统的设管理系统的设流程管理系统的设流程管理系统的设流程管理系统的设流程管理系统的设流程管理系统的设流程管理系统的设流程管理系统的设流程管理系统的设流程管理系统的设流程管理系统的设流程管理系统的设流程管理系统的设管理系统的设流程管理系统的设流程管理系统的设流程管理系统的设流程管理系统的设流程管理系统的设流程管理系统的设流程管理系统的设流程管理系统的设流程管理系统的设流程管理系统的设流程管理系统的设流程管理系统的设</p>','2023-04-20 00:00:00');
/*!40000 ALTER TABLE `jingsaixinxi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `storeup`
--

DROP TABLE IF EXISTS `storeup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `storeup` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `refid` bigint(20) DEFAULT NULL COMMENT '商品id',
  `tablename` varchar(200) DEFAULT NULL COMMENT '表名',
  `name` varchar(200) NOT NULL COMMENT '名称',
  `picture` longtext NOT NULL COMMENT '图片',
  `type` varchar(200) DEFAULT '1' COMMENT '类型(1:收藏,21:赞,22:踩,31:竞拍参与,41:关注)',
  `inteltype` varchar(200) DEFAULT NULL COMMENT '推荐类型',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1681137570677 DEFAULT CHARSET=utf8 COMMENT='收藏表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `storeup`
--

LOCK TABLES `storeup` WRITE;
/*!40000 ALTER TABLE `storeup` DISABLE KEYS */;
INSERT INTO `storeup` VALUES (1681137570676,'2023-04-10 14:39:29',1681137284226,1681137402055,'jingsaixinxi','流程管理系统的设','upload/1681137367717.jpeg','1',NULL,NULL);
/*!40000 ALTER TABLE `storeup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `token`
--

DROP TABLE IF EXISTS `token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `token` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `tablename` varchar(100) DEFAULT NULL COMMENT '表名',
  `role` varchar(100) DEFAULT NULL COMMENT '角色',
  `token` varchar(200) NOT NULL COMMENT '密码',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  `expiratedtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '过期时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='token表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `token`
--

LOCK TABLES `token` WRITE;
/*!40000 ALTER TABLE `token` DISABLE KEYS */;
INSERT INTO `token` VALUES (1,21,'学号1','xuesheng','学生','vsc5tqgmy4an6ytcx1wntmn41ayg5mkk','2023-04-10 14:30:23','2023-04-10 15:30:23'),(2,11,'教师工号1','jiaoshi','管理员','7fhn7llq1f366f79pyope6ipectrjbrx','2023-04-10 14:30:47','2023-04-10 15:30:48'),(3,1,'admin','users','管理员','fb0cjxz7pmy3ffi2j3xivy0vw1iacjha','2023-04-10 14:31:18','2023-04-10 15:44:23'),(4,1681137284226,'001','xuesheng','学生','3u68kjjq3lhp2hf3vznfn8im13ug3gib','2023-04-10 14:34:55','2023-04-10 15:42:24'),(5,1681137352223,'002','jiaoshi','管理员','znpbbt20jkds4p4i5ozkb9tfo38v3cn4','2023-04-10 14:37:29','2023-04-10 15:41:54');
/*!40000 ALTER TABLE `token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `role` varchar(100) DEFAULT '管理员' COMMENT '角色',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'admin','admin','管理员','2023-04-10 14:27:07');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `xuesheng`
--

DROP TABLE IF EXISTS `xuesheng`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `xuesheng` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `xuehao` varchar(200) NOT NULL COMMENT '学号',
  `mima` varchar(200) NOT NULL COMMENT '密码',
  `xueshengxingming` varchar(200) NOT NULL COMMENT '学生姓名',
  `touxiang` longtext COMMENT '头像',
  `xingbie` varchar(200) DEFAULT NULL COMMENT '性别',
  `shoujihaoma` varchar(200) DEFAULT NULL COMMENT '手机号码',
  `youxiang` varchar(200) DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`),
  UNIQUE KEY `xuehao` (`xuehao`)
) ENGINE=InnoDB AUTO_INCREMENT=1681137284227 DEFAULT CHARSET=utf8 COMMENT='学生';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `xuesheng`
--

LOCK TABLES `xuesheng` WRITE;
/*!40000 ALTER TABLE `xuesheng` DISABLE KEYS */;
INSERT INTO `xuesheng` VALUES (21,'2023-04-10 14:27:07','学号1','123456','学生姓名1','upload/xuesheng_touxiang1.jpg','男','13823888881','773890001@qq.com'),(22,'2023-04-10 14:27:07','学号2','123456','学生姓名2','upload/xuesheng_touxiang2.jpg','男','13823888882','773890002@qq.com'),(23,'2023-04-10 14:27:07','学号3','123456','学生姓名3','upload/xuesheng_touxiang3.jpg','男','13823888883','773890003@qq.com'),(24,'2023-04-10 14:27:07','学号4','123456','学生姓名4','upload/xuesheng_touxiang4.jpg','男','13823888884','773890004@qq.com'),(25,'2023-04-10 14:27:07','学号5','123456','学生姓名5','upload/xuesheng_touxiang5.jpg','男','13823888885','773890005@qq.com'),(26,'2023-04-10 14:27:07','学号6','123456','学生姓名6','upload/xuesheng_touxiang6.jpg','男','13823888886','773890006@qq.com'),(27,'2023-04-10 14:27:07','学号7','123456','学生姓名7','upload/xuesheng_touxiang7.jpg','男','13823888887','773890007@qq.com'),(28,'2023-04-10 14:27:07','学号8','123456','学生姓名8','upload/xuesheng_touxiang8.jpg','男','13823888888','773890008@qq.com'),(1681137284226,'2023-04-10 14:34:44','001','001','王强','upload/1681137278722.jpeg','男','13823877774',NULL);
/*!40000 ALTER TABLE `xuesheng` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-18 15:42:22
