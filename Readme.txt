项目启动注意事项：

1、数据库配置：/resources/settings.properties
2、redis配置：/resources/redis.properties
3、项目登录页：/signin.jsp
4、登录使用用户名和密码：
username: admin@qq.com
password: 12345678

其他：
1、如果暂时不想使用redis，如何移除
1) applicationContext.xml里移除 <import resource="redis.xml" />
2) 修改RedisPool.java 类取消被spring管理
3）修改SysCacheService.java 类移除RedisPool.java的使用

2、如果想在正式环境使用，需要注意哪些
1）如果是集群部署，需要配置session共享，保证登录一次就可以，体验好
可以参考一下：http://blog.csdn.net/pingnanlee/article/details/68065535
2）确认一下项目里超级管理员的权限的规则
代码位置：SysCoreService.java类里的isSuperAdmin()
3）新增管理员的密码处理
SysUserService.java里的save() 方法里需要移除 password = "12345678";
同时，MailUtil里的发信参数要补全，并在SysUserService.java里的save()里 sysUserMapper.insertSelective(user) 之前调用
这是默认给的逻辑，可以根据项目实际情况调整


===========================================================================================
/*
Navicat MySQL Data Transfer

Source Server         : 阿里云数据库
Source Server Version : 50715
Source Host           : rm-uf6tw13vo2gio7511o.mysql.rds.aliyuncs.com:3306
Source Database       : gamemanage

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2018-06-21 16:47:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `bankcard_detail`
-- ----------------------------
DROP TABLE IF EXISTS `bankcard_detail`;
CREATE TABLE `bankcard_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '银行卡信息表',
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  `user_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '用户名',
  `role_type` int(11) DEFAULT NULL COMMENT '前后台类别，1为前台，2为后台',
  `roler` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '角色1服务商，2机构，3琴行，4老师,5家长，6学生',
  `opean_bank` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '开户行',
  `holder_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '持卡人姓名',
  `bankCard_num` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '银行卡卡号',
  `is_default` int(11) DEFAULT NULL COMMENT '是否为默认卡(1--为默认 0--不是默认)',
  `bankCard_type` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '银行卡类型',
  `telephone` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '预留手机号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=128 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of bankcard_detail
-- ----------------------------
INSERT INTO `bankcard_detail` VALUES ('102', '1', null, '2', null, null, '21', null, '0', null, null);
INSERT INTO `bankcard_detail` VALUES ('103', '1', 'Admin', '2', null, '上海', 'xiaoming', '12345677', '1', '中国银行', '151949491660');
INSERT INTO `bankcard_detail` VALUES ('104', '1', 'Admin', '2', null, '23', '23', '23', '0', '23', '23');
INSERT INTO `bankcard_detail` VALUES ('106', '1', 'Admin', '2', '权限管理员', '23423', '23423', '23423', '0', '23423', '23423');
INSERT INTO `bankcard_detail` VALUES ('107', '1', 'Admin', '2', '权限管理员', '333333', 'sdfds', '32423', '0', 'fgdfgdf', '22232');
INSERT INTO `bankcard_detail` VALUES ('108', '1', 'Admin', '2', '权限管理员', '234324', 'ewrw', '2342323', '0', 'weqw1', '234234');
INSERT INTO `bankcard_detail` VALUES ('111', '1', 'Admin', '2', '权限管理员', '上盖', '去微软', '3424234', '0', '农业', '151234234234');
INSERT INTO `bankcard_detail` VALUES ('112', '1', 'Admin', '2', '2', '北京', '爱爱爱爱', '3423423', '0', '招商银行', '34242342');
INSERT INTO `bankcard_detail` VALUES ('120', '15', 'lingbin', '2', '3', '上海虹口', '嗷嗷嗷', '1234567890', '0', '招商银行卡', '1234556534');
INSERT INTO `bankcard_detail` VALUES ('121', '15', 'lingbin', '2', '4', '13123', '23421', '213213', '0', '123', '123123');
INSERT INTO `bankcard_detail` VALUES ('124', '458', 'RicottaElmar2', '1', '4', '111111', '111', '11111', '0', '工商银行', '15292864264');
INSERT INTO `bankcard_detail` VALUES ('125', '458', 'RicottaElmar2', '1', '4', '1324', '132456', '46512584', '0', '工商银行', '15292864264');
INSERT INTO `bankcard_detail` VALUES ('126', '5', 'Admin2', '2', '2', 'sdf', 'sdf', '33333', '0', '44444', '15151');
INSERT INTO `bankcard_detail` VALUES ('127', '5', 'Admin2', '2', '2', '666666666', 'asd', '44444444444', '1', '565555555', '1111111');

-- ----------------------------
-- Table structure for `binding_application`
-- ----------------------------
DROP TABLE IF EXISTS `binding_application`;
CREATE TABLE `binding_application` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '绑定申请表',
  `from_user_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '发起申请人名称',
  `from_user_id` int(255) DEFAULT NULL COMMENT '发起申请者id  < ele_player表中id >',
  `to_user_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '接收申请者名称',
  `to_user_id` int(11) DEFAULT NULL COMMENT '接收申请者id  < ele_player表中id >',
  `create_time` datetime DEFAULT NULL COMMENT '申请时间',
  `handle_time` datetime DEFAULT NULL COMMENT '处理时间',
  `from_user_type` int(11) DEFAULT NULL COMMENT '发起申请绑定用户类型(0--老师 1--家长  2--学生)',
  `apply_state` int(11) DEFAULT '0' COMMENT '绑定申请的状态(0--未选择 1--已同意 2--已拒绝)',
  `is_delete` int(11) DEFAULT '0' COMMENT '是否删除绑定关系( 0--不删除  1--删除)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of binding_application
-- ----------------------------
INSERT INTO `binding_application` VALUES ('1', '小王', '1', '张老师', '1', '2018-05-25 15:29:10', '2018-05-26 15:29:14', '2', '0', '0');
INSERT INTO `binding_application` VALUES ('2', '张老师', '1', '小红', '2', '2018-05-25 15:30:02', '2018-05-30 15:30:05', '0', '0', '0');
INSERT INTO `binding_application` VALUES ('10', 'fan', '459', 'ly', '454', '2018-05-29 19:30:26', '2018-05-29 20:12:37', '0', '0', '1');
INSERT INTO `binding_application` VALUES ('11', 'fan', '459', 'ly', '454', '2018-05-29 20:00:00', '2018-05-29 20:12:33', '0', '1', '1');
INSERT INTO `binding_application` VALUES ('12', '123', '462', '454', '454', '2018-05-30 14:57:16', '2018-05-30 14:57:58', '1', '1', '1');
INSERT INTO `binding_application` VALUES ('14', '123', '462', '454', '454', '2018-05-30 15:53:40', null, '1', '0', '1');
INSERT INTO `binding_application` VALUES ('15', '123', '462', '454', '454', '2018-05-30 15:53:51', '2018-05-30 15:54:21', '1', '1', '1');
INSERT INTO `binding_application` VALUES ('16', 'ly', '454', '462', '462', '2018-05-30 16:01:26', '2018-05-30 16:02:14', '2', '1', '1');
INSERT INTO `binding_application` VALUES ('17', 'fan', '459', '454', '454', '2018-05-31 14:54:08', '2018-05-31 14:55:15', '0', '1', '1');
INSERT INTO `binding_application` VALUES ('18', 'ly', '454', '459', '459', '2018-05-31 15:01:59', '2018-05-31 15:02:14', '2', '1', '1');
INSERT INTO `binding_application` VALUES ('19', 'fan', '459', '454', '454', '2018-05-31 15:54:43', '2018-05-31 15:54:58', '0', '1', '1');
INSERT INTO `binding_application` VALUES ('20', 'ly', '454', '459', '459', '2018-05-31 15:55:38', '2018-05-31 15:55:52', '2', '1', '1');
INSERT INTO `binding_application` VALUES ('21', 'ly', '454', '462', '462', '2018-05-31 15:56:58', '2018-05-31 15:58:08', '2', '1', '1');
INSERT INTO `binding_application` VALUES ('22', '123', '462', '454', '454', '2018-05-31 15:59:12', '2018-05-31 15:59:29', '1', '1', '1');
INSERT INTO `binding_application` VALUES ('23', 'fan', '459', '454', '454', '2018-05-31 16:00:43', '2018-05-31 16:01:16', '0', '1', '1');
INSERT INTO `binding_application` VALUES ('24', 'RicottaElmar', '458', '454', '454', '2018-05-31 16:01:04', '2018-05-31 16:01:18', '0', '1', '1');
INSERT INTO `binding_application` VALUES ('25', 'fan', '459', '454', '454', '2018-05-31 17:53:47', '2018-05-31 17:54:56', '0', '2', '0');
INSERT INTO `binding_application` VALUES ('26', 'RicottaElmar', '458', '454', '454', '2018-05-31 17:54:29', '2018-05-31 17:54:43', '0', '1', '1');
INSERT INTO `binding_application` VALUES ('27', 'ly', '454', '458', '458', '2018-05-31 17:55:06', '2018-05-31 17:55:40', '2', '1', '1');
INSERT INTO `binding_application` VALUES ('28', 'ly', '454', '459', '459', '2018-05-31 17:55:20', '2018-05-31 17:56:34', '2', '1', '1');
INSERT INTO `binding_application` VALUES ('29', 'ly', '454', '462', '462', '2018-05-31 17:57:14', '2018-05-31 17:57:43', '2', '1', '1');
INSERT INTO `binding_application` VALUES ('30', 'aaa', '463', '454', '454', '2018-05-31 17:59:45', '2018-05-31 18:00:45', '1', '2', '0');
INSERT INTO `binding_application` VALUES ('31', '123', '462', '454', '454', '2018-05-31 18:00:21', '2018-05-31 18:00:34', '1', '1', '1');
INSERT INTO `binding_application` VALUES ('32', 'ly', '454', '462', '462', '2018-05-31 18:02:03', '2018-05-31 18:04:06', '2', '1', '1');
INSERT INTO `binding_application` VALUES ('33', 'ly', '454', '463', '463', '2018-05-31 18:02:09', '2018-05-31 18:02:38', '2', '1', '1');
INSERT INTO `binding_application` VALUES ('34', 'ly', '454', '123456', '123456', '2018-06-01 20:49:04', null, '2', '0', '0');
INSERT INTO `binding_application` VALUES ('35', '123', '462', '454', '454', '2018-06-05 14:15:27', '2018-06-05 14:15:41', '1', '1', '0');
INSERT INTO `binding_application` VALUES ('36', 'ly', '454', '459', '459', '2018-06-05 15:07:42', '2018-06-05 15:07:54', '2', '1', '0');
INSERT INTO `binding_application` VALUES ('37', '俞钦华', '476', '458', '458', '2018-06-07 21:16:33', '2018-06-07 21:17:24', '2', '1', '0');
INSERT INTO `binding_application` VALUES ('38', '俞钦华', '476', '462', '462', '2018-06-07 21:19:16', '2018-06-07 21:19:35', '2', '1', '0');
INSERT INTO `binding_application` VALUES ('39', '林永', '497', '496', '496', '2018-06-14 11:12:28', '2018-06-14 11:12:56', '2', '1', '0');
INSERT INTO `binding_application` VALUES ('40', '林永', '497', '455', '455', '2018-06-14 11:12:37', null, '2', '0', '0');
INSERT INTO `binding_application` VALUES ('41', '李勇', '496', '3333', '3333', '2018-06-14 11:24:46', null, '1', '0', '0');
INSERT INTO `binding_application` VALUES ('42', '李勇', '496', '497', '497', '2018-06-14 11:24:55', null, '1', '0', '0');
INSERT INTO `binding_application` VALUES ('43', '电风扇格式的', '494', '499', '499', '2018-06-14 19:18:05', '2018-06-14 19:18:49', '2', '1', '0');

-- ----------------------------
-- Table structure for `cms_adver`
-- ----------------------------
DROP TABLE IF EXISTS `cms_adver`;
CREATE TABLE `cms_adver` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'CMS广告内容管理',
  `column_name` int(11) DEFAULT '3' COMMENT '栏目分类名称(1--首页轮播图 2--教材库轮播图  3--没有内容)4,首页热门广告',
  `cover_picture` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '封面图片',
  `contant` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '广告内容()',
  `column_type` int(11) DEFAULT '0' COMMENT '栏目类型(1--教材 2--曲谱 3--广告 4--文本)',
  `founder` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `text_content` varchar(255) COLLATE utf8_bin DEFAULT 'null' COMMENT '文本--填写的文本标题,教材--教材id,曲谱--曲谱id,广告--链接',
  `type` int(11) DEFAULT NULL COMMENT 'CMS活动分类  1--滚动广告位  2--热门广告位',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of cms_adver
-- ----------------------------
INSERT INTO `cms_adver` VALUES ('22', '2', 'http://47.100.11.15/F/Image/null/1528877610479.jpg', '教材广告', '1', 'fan', '2018-06-13 14:17:33', '4', '1');
INSERT INTO `cms_adver` VALUES ('23', '2', 'http://47.100.11.15/F/Image/null/1528877634878.jpg', '曲谱广告', '2', 'fan', '2018-06-13 14:21:20', '107', '1');
INSERT INTO `cms_adver` VALUES ('24', '1', 'http://47.100.11.15/F/Image/null/1528891091370.jpg', '广告', '3', 'fan', '2018-06-13 14:30:20', 'www.baidu.com', '1');
INSERT INTO `cms_adver` VALUES ('25', '1', 'http://47.100.11.15/F/Image/null/1528891061382.jpg', '文本', '4', 'fan', '2018-06-13 14:34:34', 'hello', '1');
INSERT INTO `cms_adver` VALUES ('26', '4', 'http://47.100.11.15/F/Image/null/1529482145340.png', '曲谱广告', '2', 'wang', '2018-06-13 14:21:20', '107', '2');
INSERT INTO `cms_adver` VALUES ('27', '4', 'http://47.100.11.15/F/Image/null/1529481982527.png', '教材广告', '1', 'wang', '2018-06-13 14:37:15', '4', '2');
INSERT INTO `cms_adver` VALUES ('28', '4', 'http://47.100.11.15/F/Image/null/1529481911051.png', '广告', '3', 'wang', '2018-06-13 14:38:27', 'https://www.hao123.com/', '2');
INSERT INTO `cms_adver` VALUES ('29', '4', 'http://47.100.11.15/F/Image/null/1529482432569.png', '文本', '1', 'wang', '2018-06-13 14:39:28', '4', '2');
INSERT INTO `cms_adver` VALUES ('30', '1', 'http://47.100.11.15/F/Image/null/1529458466814.png', 'hello world', '4', '李勇', '2018-06-19 14:10:21', '颠三倒四', '1');
INSERT INTO `cms_adver` VALUES ('31', '1', 'http://47.100.11.15/F/Image/null/1529458542875.png', '', '1', '李勇', '2018-06-20 09:36:03', '7', '1');
INSERT INTO `cms_adver` VALUES ('32', '4', 'http://47.100.11.15/F/Image/null/1529482167243.png', '', '1', '孤鸿寡鹄', '2018-06-20 16:09:50', 'null', '1');

-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '评语管理(老师给学生简评--管理后台设置,前端直接使用)',
  `content` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '简评内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('28', '表现不错');
INSERT INTO `comment` VALUES ('29', '再接再厉');
INSERT INTO `comment` VALUES ('30', '再创辉煌');
INSERT INTO `comment` VALUES ('31', '好好学习');

-- ----------------------------
-- Table structure for `comment_parent_teacher`
-- ----------------------------
DROP TABLE IF EXISTS `comment_parent_teacher`;
CREATE TABLE `comment_parent_teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '家长对老师寄语',
  `piano_shop` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '琴行名',
  `parents_id` int(11) DEFAULT NULL COMMENT '家长id',
  `parents` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '家长姓名',
  `student_id` int(11) DEFAULT NULL COMMENT '学生id',
  `student` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '学生姓名',
  `teacher_id` int(11) DEFAULT NULL COMMENT '老师ID',
  `teacher` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '老师姓名',
  `comment` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '评论内容',
  `comment_time` datetime DEFAULT NULL COMMENT '评论时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of comment_parent_teacher
-- ----------------------------
INSERT INTO `comment_parent_teacher` VALUES ('7', '琴行名222', '1', '家长222', '1', '小2', '1', '老师222', 'aaa', '2018-05-24 12:24:40');
INSERT INTO `comment_parent_teacher` VALUES ('21', '琴行名111', '1', '家长222', '454', '小2', '7', '老师', '啊啊,天天向上', '2018-05-24 17:30:40');
INSERT INTO `comment_parent_teacher` VALUES ('26', '琴行2', '7', '家长22', '454', 'liyong', '7', null, '12342214324', '2018-06-05 15:09:36');
INSERT INTO `comment_parent_teacher` VALUES ('27', '琴行2', '5', '家长22', null, 'liyong', '1', '王老师', '12312312333333', '2018-06-05 15:12:29');
INSERT INTO `comment_parent_teacher` VALUES ('28', 'piano5', '4', '家长3', null, 'ly', '7', '家长4', '今天高考', '2018-06-06 11:00:14');
INSERT INTO `comment_parent_teacher` VALUES ('29', '琴行2', '4', '家长22', '454', 'liyong', '7', '王老师', 'kaikaiaaa', '2018-06-07 11:17:34');
INSERT INTO `comment_parent_teacher` VALUES ('30', '琴行2', null, '家长22', null, 'liyong', '1', '王老师', 'kaikaiaaa', '2018-06-07 11:18:49');
INSERT INTO `comment_parent_teacher` VALUES ('31', '琴行2', '4', '家长22', '454', 'liyong', '7', '王老师', 'kaikaiaaa', '2018-06-07 11:20:33');
INSERT INTO `comment_parent_teacher` VALUES ('32', '琴行2', '4', '家长22', '454', 'liyong', '7', '王老师', '123345567', '2018-06-07 11:25:43');

-- ----------------------------
-- Table structure for `comment_teac_to_stu`
-- ----------------------------
DROP TABLE IF EXISTS `comment_teac_to_stu`;
CREATE TABLE `comment_teac_to_stu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '评语信息(详细信息--老师对学生评论)',
  `piano_shop` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '琴行',
  `teacher_id` int(11) DEFAULT NULL COMMENT '老师id',
  `teacher` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '老师姓名',
  `student_id` int(11) DEFAULT NULL COMMENT '学生id',
  `student` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '学生姓名',
  `parent_id` int(11) DEFAULT NULL COMMENT '家长id',
  `parent` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '家长姓名',
  `comment` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '简评内容,以|分割简评id<关联comment表>',
  `start_level` int(11) DEFAULT NULL COMMENT '星级(0---5)',
  `comment_time` datetime DEFAULT NULL COMMENT '点评时间',
  `comment_detail` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '评论细节',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of comment_teac_to_stu
-- ----------------------------
INSERT INTO `comment_teac_to_stu` VALUES ('4', '琴行名111', '3', '老师1111', '1', '小名', '1', '家长111', '28|29|30', '3', '2018-05-24 17:33:17', '好好学习');
INSERT INTO `comment_teac_to_stu` VALUES ('22', '琴行2', '7', null, '454', 'liyong', null, null, '31', '2', '2018-06-05 11:13:40', '22223');
INSERT INTO `comment_teac_to_stu` VALUES ('24', '琴行2', '7', null, '454', 'liyong', null, null, '30', '2', '2018-06-05 12:09:34', '1111111');
INSERT INTO `comment_teac_to_stu` VALUES ('25', '琴行2', '7', '王老师', '454', 'liyong', '4', '家长22', '28|29', '5', '2018-06-06 17:14:02', '');
INSERT INTO `comment_teac_to_stu` VALUES ('26', '琴行2', '7', '王老师', '454', 'liyong', '4', '家长22', '30|31', '5', '2018-06-06 17:14:06', '');

-- ----------------------------
-- Table structure for `consumption_detail`
-- ----------------------------
DROP TABLE IF EXISTS `consumption_detail`;
CREATE TABLE `consumption_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '消费明细表',
  `user_id` int(11) DEFAULT NULL COMMENT '6个表对应的用户id',
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '店名/姓名',
  `role` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '角色0总管理，1服务商，2机构，3琴行，4老师，5家长，6学生',
  `consumption_money` decimal(10,2) DEFAULT NULL COMMENT '消费金额',
  `consumption_detail` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '消费详情',
  `rest_money` decimal(10,2) DEFAULT NULL COMMENT '剩余余额',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of consumption_detail
-- ----------------------------
INSERT INTO `consumption_detail` VALUES ('1', '1', 'fgg', '1', '232.00', '购买皮肤:皮肤1', '33.00', '2018-05-22 18:27:18');
INSERT INTO `consumption_detail` VALUES ('2', '1', null, '2', '18.00', '购买皮肤:皮肤2', '0.00', '2018-05-22 18:27:20');
INSERT INTO `consumption_detail` VALUES ('3', '1', null, '3', '20.00', '购买皮肤:皮肤3', null, '2018-05-24 18:28:24');
INSERT INTO `consumption_detail` VALUES ('4', '1', 'fgg', '4', '232.00', '购买皮肤:皮肤1', '33.00', '2018-05-24 18:27:18');
INSERT INTO `consumption_detail` VALUES ('5', '2', null, '3', '18.00', '购买皮肤:皮肤2', '0.00', '2018-05-22 18:27:20');
INSERT INTO `consumption_detail` VALUES ('6', '2', null, '4', '20.00', '购买皮肤:皮肤3', null, '2018-05-24 18:28:24');

-- ----------------------------
-- Table structure for `count_record`
-- ----------------------------
DROP TABLE IF EXISTS `count_record`;
CREATE TABLE `count_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '计数器记录表',
  `user_id` int(11) NOT NULL COMMENT '用户ID  学生、老师、家长',
  `user_account` varchar(30) DEFAULT NULL COMMENT '用户账号 手机号/ID',
  `user_role` varchar(30) DEFAULT NULL COMMENT '该用户角色',
  `user_nick` varchar(30) DEFAULT NULL COMMENT '用户昵称',
  `piano_shop` varchar(30) DEFAULT NULL COMMENT '所属琴行',
  `teacher` varchar(30) DEFAULT NULL COMMENT '所属老师',
  `count_time` varchar(255) DEFAULT NULL COMMENT '前端发来的练习时间',
  `counter_speed` varchar(255) DEFAULT NULL COMMENT '前端发来的练习速度',
  `counter_count` int(11) DEFAULT NULL COMMENT '前端发来的打击数',
  `record_time` datetime DEFAULT NULL COMMENT '记录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of count_record
-- ----------------------------
INSERT INTO `count_record` VALUES ('1', '458', '17680251245', '1', '1', '1', '0', '3', '2', '296', '2018-05-31 14:24:37');
INSERT INTO `count_record` VALUES ('2', '458', '17680251245', '2', '1', '1', '0', '3', '6', '244', '2018-05-31 14:24:37');
INSERT INTO `count_record` VALUES ('3', '458', '17680251245', '1', '1', '1', '1', '1', '10', '105', '2018-05-31 14:24:37');
INSERT INTO `count_record` VALUES ('4', '458', '17680251245', '1', '1', '1', '1', '3', '10', '145', '2018-05-31 14:24:37');
INSERT INTO `count_record` VALUES ('5', '458', '17680251245', '1', '1', '1', '0', '3', '4', '90', '2018-05-31 14:24:37');
INSERT INTO `count_record` VALUES ('6', '458', '17680251245', '1', '1', '1', '0', '3', '2', '296', '2018-05-31 14:24:37');
INSERT INTO `count_record` VALUES ('7', '458', '17680251245', '2', '1', '1', '0', '3', '6', '244', '2018-05-31 14:24:37');
INSERT INTO `count_record` VALUES ('8', '458', '17680251245', '1', '1', '1', '1', '1', '10', '105', '2018-05-31 14:24:37');
INSERT INTO `count_record` VALUES ('9', '458', '17680251245', '1', '1', '1', '1', '3', '10', '145', '2018-05-31 14:24:37');
INSERT INTO `count_record` VALUES ('10', '458', '17680251245', '1', '1', '1', '0', '3', '4', '90', '2018-05-31 14:24:37');
INSERT INTO `count_record` VALUES ('11', '458', '17680251245', '1', '1', '1', '0', '3', '2', '296', '2018-05-31 14:24:37');
INSERT INTO `count_record` VALUES ('12', '458', '17680251245', '2', '1', '1', '0', '3', '6', '244', '2018-05-31 14:24:37');
INSERT INTO `count_record` VALUES ('13', '458', '17680251245', '1', '1', '1', '1', '1', '10', '105', '2018-05-31 14:24:37');
INSERT INTO `count_record` VALUES ('14', '458', '17680251245', '1', '1', '1', '1', '3', '10', '145', '2018-05-31 14:24:37');
INSERT INTO `count_record` VALUES ('15', '458', '17680251245', '1', '1', '1', '0', '3', '4', '90', '2018-05-31 14:24:37');
INSERT INTO `count_record` VALUES ('16', '458', '17680251245', '1', '1', '1', '0', '3', '2', '296', '2018-05-31 14:24:37');
INSERT INTO `count_record` VALUES ('17', '458', '17680251245', '2', '1', '1', '0', '3', '6', '244', '2018-05-31 14:24:37');
INSERT INTO `count_record` VALUES ('18', '458', '17680251245', '1', '1', '1', '1', '1', '10', '105', '2018-05-31 14:24:37');
INSERT INTO `count_record` VALUES ('19', '458', '17680251245', '1', '1', '1', '1', '3', '10', '145', '2018-05-31 14:24:37');
INSERT INTO `count_record` VALUES ('20', '458', '17680251245', '1', '1', '1', '0', '3', '4', '90', '2018-05-31 14:24:37');
INSERT INTO `count_record` VALUES ('21', '458', '17680251245', '1', '1', '1', '0', '3', '2', '296', '2018-05-31 14:24:37');
INSERT INTO `count_record` VALUES ('22', '458', '17680251245', '2', '1', '1', '0', '3', '6', '244', '2018-05-31 14:24:37');
INSERT INTO `count_record` VALUES ('23', '458', '17680251245', '1', '1', '1', '1', '1', '10', '105', '2018-05-31 14:24:37');
INSERT INTO `count_record` VALUES ('24', '458', '17680251245', '1', '1', '1', '1', '3', '10', '145', '2018-05-31 14:24:37');
INSERT INTO `count_record` VALUES ('25', '458', '17680251245', '1', '1', '1', '0', '3', '4', '90', '2018-05-31 14:24:37');
INSERT INTO `count_record` VALUES ('26', '458', '17680251245', '1', '1', '1', '0', '3', '2', '296', '2018-05-31 14:24:37');
INSERT INTO `count_record` VALUES ('27', '458', '17680251245', '2', '1', '1', '0', '3', '6', '244', '2018-05-31 14:24:37');
INSERT INTO `count_record` VALUES ('28', '458', '17680251245', '1', '1', '1', '1', '1', '10', '105', '2018-05-31 14:24:37');
INSERT INTO `count_record` VALUES ('29', '458', '17680251245', '1', '1', '1', '1', '3', '10', '145', '2018-05-31 14:24:37');
INSERT INTO `count_record` VALUES ('30', '458', '17680251245', '1', '1', '1', '0', '3', '4', '90', '2018-05-31 14:24:37');
INSERT INTO `count_record` VALUES ('31', '458', '17680251245', '1', '1', '1', '0', '3', '2', '296', '2018-05-31 14:24:37');
INSERT INTO `count_record` VALUES ('32', '458', '17680251245', '2', '1', '1', '0', '3', '6', '244', '2018-05-31 14:24:37');
INSERT INTO `count_record` VALUES ('33', '458', '17680251245', '1', '1', '1', '1', '1', '10', '105', '2018-05-31 14:24:37');
INSERT INTO `count_record` VALUES ('34', '458', '17680251245', '1', '1', '1', '1', '3', '10', '145', '2018-05-31 14:24:37');
INSERT INTO `count_record` VALUES ('35', '458', '17680251245', '1', '1', '1', '0', '3', '4', '90', '2018-05-31 14:24:37');
INSERT INTO `count_record` VALUES ('36', '458', '17680251245', '1', '1', '1', '0', '3', '2', '296', '2018-05-31 14:24:37');
INSERT INTO `count_record` VALUES ('37', '458', '17680251245', '2', '1', '1', '0', '3', '6', '244', '2018-05-31 14:24:37');
INSERT INTO `count_record` VALUES ('38', '458', '17680251245', '1', '1', '1', '1', '1', '10', '105', '2018-05-31 14:24:37');
INSERT INTO `count_record` VALUES ('39', '458', '17680251245', '1', '1', '1', '1', '3', '10', '145', '2018-05-31 14:24:37');
INSERT INTO `count_record` VALUES ('40', '458', '17680251245', '1', '1', '1', '0', '3', '4', '90', '2018-05-31 14:24:37');
INSERT INTO `count_record` VALUES ('41', '458', '17680251245', '1', '1', '1', '0', '3', '2', '296', '2018-05-31 14:24:37');
INSERT INTO `count_record` VALUES ('42', '458', '17680251245', '2', '1', '1', '0', '3', '6', '244', '2018-05-31 14:24:37');
INSERT INTO `count_record` VALUES ('43', '458', '17680251245', '1', '1', '1', '1', '1', '10', '105', '2018-05-31 14:24:37');
INSERT INTO `count_record` VALUES ('44', '458', '17680251245', '1', '1', '1', '1', '3', '10', '145', '2018-05-31 14:24:37');
INSERT INTO `count_record` VALUES ('45', '458', '17680251245', '1', '1', '1', '0', '3', '4', '90', '2018-05-31 14:24:37');

-- ----------------------------
-- Table structure for `difficulty_set`
-- ----------------------------
DROP TABLE IF EXISTS `difficulty_set`;
CREATE TABLE `difficulty_set` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '难度设置表',
  `diffity_level` int(11) DEFAULT NULL COMMENT '难度水平',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of difficulty_set
-- ----------------------------
INSERT INTO `difficulty_set` VALUES ('3', '1');
INSERT INTO `difficulty_set` VALUES ('5', '2');
INSERT INTO `difficulty_set` VALUES ('6', '3');

-- ----------------------------
-- Table structure for `elec_login`
-- ----------------------------
DROP TABLE IF EXISTS `elec_login`;
CREATE TABLE `elec_login` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '登陆信息表',
  `player_id` int(11) DEFAULT NULL COMMENT '用户id',
  `login_time` datetime DEFAULT NULL COMMENT '登陆时间',
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of elec_login
-- ----------------------------
INSERT INTO `elec_login` VALUES ('1', '459', '2018-06-08 18:00:46');
INSERT INTO `elec_login` VALUES ('2', '480', '2018-06-08 18:04:01');
INSERT INTO `elec_login` VALUES ('3', '458', '2018-06-08 18:08:17');
INSERT INTO `elec_login` VALUES ('4', '454', '2018-06-08 19:03:09');
INSERT INTO `elec_login` VALUES ('5', '462', '2018-06-08 19:58:00');
INSERT INTO `elec_login` VALUES ('6', '459', '2018-06-11 12:03:26');
INSERT INTO `elec_login` VALUES ('7', '454', '2018-06-11 12:04:25');
INSERT INTO `elec_login` VALUES ('8', '462', '2018-06-11 12:05:21');
INSERT INTO `elec_login` VALUES ('9', '476', '2018-06-11 12:14:30');
INSERT INTO `elec_login` VALUES ('10', '482', '2018-06-11 16:34:20');
INSERT INTO `elec_login` VALUES ('11', '485', '2018-06-11 21:32:22');
INSERT INTO `elec_login` VALUES ('12', '458', '2018-06-11 22:06:49');
INSERT INTO `elec_login` VALUES ('13', '454', '2018-06-12 09:44:44');
INSERT INTO `elec_login` VALUES ('14', '459', '2018-06-12 10:10:14');
INSERT INTO `elec_login` VALUES ('15', '487', '2018-06-12 10:11:20');
INSERT INTO `elec_login` VALUES ('16', '488', '2018-06-12 10:49:34');
INSERT INTO `elec_login` VALUES ('17', '462', '2018-06-12 10:55:09');
INSERT INTO `elec_login` VALUES ('18', '481', '2018-06-12 11:03:35');
INSERT INTO `elec_login` VALUES ('19', '458', '2018-06-12 14:11:14');
INSERT INTO `elec_login` VALUES ('20', '454', '2018-06-13 10:26:36');
INSERT INTO `elec_login` VALUES ('21', '462', '2018-06-13 10:47:33');
INSERT INTO `elec_login` VALUES ('22', '491', '2018-06-13 11:08:30');
INSERT INTO `elec_login` VALUES ('23', '487', '2018-06-13 11:08:55');
INSERT INTO `elec_login` VALUES ('24', '481', '2018-06-13 11:20:21');
INSERT INTO `elec_login` VALUES ('25', '492', '2018-06-13 12:01:29');
INSERT INTO `elec_login` VALUES ('26', '495', '2018-06-13 18:23:29');
INSERT INTO `elec_login` VALUES ('27', '494', '2018-06-13 18:28:39');
INSERT INTO `elec_login` VALUES ('28', '495', '2018-06-14 10:26:43');
INSERT INTO `elec_login` VALUES ('29', '496', '2018-06-14 11:04:42');
INSERT INTO `elec_login` VALUES ('30', '494', '2018-06-14 11:05:40');
INSERT INTO `elec_login` VALUES ('31', '497', '2018-06-14 11:11:50');
INSERT INTO `elec_login` VALUES ('32', '462', '2018-06-14 12:28:37');
INSERT INTO `elec_login` VALUES ('33', '454', '2018-06-14 14:09:26');
INSERT INTO `elec_login` VALUES ('34', '499', '2018-06-14 19:14:00');
INSERT INTO `elec_login` VALUES ('35', '454', '2018-06-15 10:40:30');
INSERT INTO `elec_login` VALUES ('36', '501', '2018-06-15 10:51:53');
INSERT INTO `elec_login` VALUES ('37', '502', '2018-06-15 11:36:19');
INSERT INTO `elec_login` VALUES ('38', '481', '2018-06-16 08:32:43');
INSERT INTO `elec_login` VALUES ('39', '454', '2018-06-19 10:05:09');
INSERT INTO `elec_login` VALUES ('40', '502', '2018-06-19 10:20:19');
INSERT INTO `elec_login` VALUES ('41', '462', '2018-06-19 10:25:34');
INSERT INTO `elec_login` VALUES ('42', '458', '2018-06-19 10:56:03');
INSERT INTO `elec_login` VALUES ('43', '504', '2018-06-19 11:59:17');
INSERT INTO `elec_login` VALUES ('44', '494', '2018-06-19 14:12:24');
INSERT INTO `elec_login` VALUES ('45', '458', '2018-06-20 09:44:37');
INSERT INTO `elec_login` VALUES ('46', '454', '2018-06-20 09:50:12');
INSERT INTO `elec_login` VALUES ('47', '508', '2018-06-20 10:25:46');
INSERT INTO `elec_login` VALUES ('48', '494', '2018-06-20 10:42:27');
INSERT INTO `elec_login` VALUES ('49', '462', '2018-06-20 11:55:40');
INSERT INTO `elec_login` VALUES ('50', '511', '2018-06-20 16:11:35');
INSERT INTO `elec_login` VALUES ('51', '459', '2018-06-20 17:21:35');
INSERT INTO `elec_login` VALUES ('52', '462', '2018-06-21 10:00:04');
INSERT INTO `elec_login` VALUES ('53', '458', '2018-06-21 10:06:55');
INSERT INTO `elec_login` VALUES ('54', '494', '2018-06-21 10:41:27');
INSERT INTO `elec_login` VALUES ('55', '454', '2018-06-21 11:17:18');
INSERT INTO `elec_login` VALUES ('56', '463', '2018-06-21 16:19:42');

-- ----------------------------
-- Table structure for `elec_player`
-- ----------------------------
DROP TABLE IF EXISTS `elec_player`;
CREATE TABLE `elec_player` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'APP玩家表(学生，家长，老师，琴行等)',
  `player_id` int(11) DEFAULT NULL COMMENT '玩家ID，管理老师表ID、机构表ID',
  `name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `nickname` varchar(255) DEFAULT NULL COMMENT '用户昵称（第三方共用）',
  `is_qiyong` int(11) DEFAULT '1' COMMENT '该账号是否启用 0-不启用，1-启用',
  `is_lookallMusic` int(11) DEFAULT '0' COMMENT '是否能查看所属机构下所有曲谱 0-不能，1-可以',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `sex` int(11) DEFAULT '0' COMMENT '性别：0-男，1-女',
  `brithday` varchar(50) DEFAULT NULL COMMENT '生日',
  `phone` varchar(255) DEFAULT NULL COMMENT '手机号',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `role_type` int(11) DEFAULT '0' COMMENT '身份：1-学生，2-家长，3-老师，4-琴行',
  `create_time` datetime DEFAULT NULL COMMENT '注册时间',
  `score` int(11) DEFAULT '0' COMMENT '积分',
  `xiongzhang` int(11) DEFAULT '0' COMMENT '熊掌数',
  `rank` varchar(50) DEFAULT '1' COMMENT '等级',
  `province` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `area` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `wx_openid` varchar(255) DEFAULT NULL COMMENT '微信-openid',
  `wx_unionid` varchar(255) DEFAULT NULL,
  `wx_head` varchar(255) DEFAULT NULL COMMENT '微信头像地址',
  `qq_openid` varchar(255) DEFAULT NULL COMMENT 'QQ-openid',
  `qq_unionid` varchar(255) DEFAULT NULL,
  `qq_head` varchar(255) DEFAULT NULL,
  `sina_openid` varchar(255) DEFAULT NULL COMMENT '新浪-openid',
  `sina_unionid` varchar(255) DEFAULT NULL COMMENT 'qq-头像地址',
  `sina_head` varchar(255) DEFAULT NULL COMMENT '新浪-头像地址',
  `headurl` varchar(255) DEFAULT NULL COMMENT '头像地址-用户自己上传的',
  `isComplete` int(11) DEFAULT '0' COMMENT '是否完善信息：0-未完善，1-已完善',
  `type` varchar(255) DEFAULT '1' COMMENT '游戏类型，''项目类别：0-电子琴，1-电鼓，2-古筝,用,隔开''',
  `referee_id` varchar(50) DEFAULT NULL COMMENT '推荐人',
  PRIMARY KEY (`id`),
  KEY `teacher_key` (`player_id`)
) ENGINE=InnoDB AUTO_INCREMENT=512 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of elec_player
-- ----------------------------
INSERT INTO `elec_player` VALUES ('454', '454', 'ly', 'ly', '1', '0', '1', '1', '2018-6-20', '17680251245', '25D55AD283AA400AF464C76D713C07AD', '1', '2018-05-16 10:19:52', '3', '2000', '8', null, '上海', null, '上海浦东', '123', null, null, '123', null, null, null, null, null, 'http://thirdwx.qlogo.cn/mmopen/vi_32/7RPgn1iaGgvptiaz2PIxMvSlakLsxCWKwObbVeIqwuVIFeFMq9tceLkJubumaQu9plntsZc8QHTwR3ibYVOlSbVGQ/132', '0', '架子鼓', '');
INSERT INTO `elec_player` VALUES ('455', '6', 'name', 'nic', '1', '0', null, '0', null, '', 'E10ADC3949BA59ABBE56E057F20F883E', '1', '2018-05-17 20:13:04', '300', '2000', '1', null, '上海 长宁区', null, '详细地址', null, null, null, null, null, null, null, null, null, null, '0', '架子鼓', null);
INSERT INTO `elec_player` VALUES ('456', '518', '123', '123', '1', '0', null, '0', null, '', 'E10ADC3949BA59ABBE56E057F20F883E', '1', '2018-05-17 20:30:03', '400', '2000', '1', null, '4545', null, '64546', null, null, null, null, null, null, null, null, null, null, '0', '架子鼓', null);
INSERT INTO `elec_player` VALUES ('457', '5', '312', '123', '1', '0', null, '0', null, '', '96E79218965EB72C92A549DD5A330112', '1', '2018-05-17 20:41:32', '100', '2000', '1', null, '湖南 长沙', null, 'changshagn', null, null, null, null, null, null, null, null, null, null, '0', '架子鼓', null);
INSERT INTO `elec_player` VALUES ('458', '3', 'RicottaElmar2', 'RicottaElmar2', '1', '0', '17', '0', '2001-7-10', '15292864264', '25D55AD283AA400AF464C76D713C07AD', '3', '2018-05-18 20:44:29', '3', '1793', '1', null, '河南 许昌 襄城县', null, '123', null, null, null, null, null, null, null, null, null, 'http://thirdwx.qlogo.cn/mmopen/vi_32/7RPgn1iaGgvptiaz2PIxMvSlakLsxCWKwObbVeIqwuVIFeFMq9tceLkJubumaQu9plntsZc8QHTwR3ibYVOlSbVGQ/132', '0', '架子鼓', '');
INSERT INTO `elec_player` VALUES ('459', '7', 'fan', 'fan', '1', '0', '6', '0', '2013-3-6', '17621829059', '25D55AD283AA400AF464C76D713C07AD', '3', '2018-05-24 10:49:50', '3', '0', '1', null, '吉林 长春', null, '新年放假', null, null, null, null, null, null, null, null, null, 'http://47.100.11.15/F//Image/8fc4ec4cccb10a393e2f7679b5d414b7.png', '0', '架子鼓', '');
INSERT INTO `elec_player` VALUES ('460', '8', 'zx', 'ww', '1', '0', null, '0', null, '', 'E10ADC3949BA59ABBE56E057F20F883E', '1', '2018-05-17 20:30:03', '6000', '2000', '1', null, '4545', null, '64546', null, null, null, null, null, null, null, null, null, null, '0', '架子鼓', null);
INSERT INTO `elec_player` VALUES ('461', '461', 'ww', 'ee', '1', '0', null, '0', null, '', '96E79218965EB72C92A549DD5A330112', '1', '2018-05-17 20:41:32', '6000', '2000', '1', null, '湖南 长沙', null, 'changshagn', null, null, null, null, null, null, null, null, null, null, '0', '架子鼓', null);
INSERT INTO `elec_player` VALUES ('462', '4', '123', 'yggdra', '1', '0', '1', '0', '2018-6-4', '17699406195', 'EF15E747228D814B036FA9EB554D7255', '2', '2018-05-30 14:50:48', '3', '0', '1', null, '新疆 乌鲁木齐 沙依巴克区', null, '123', null, null, null, null, null, null, null, null, null, null, '0', '架子鼓', null);
INSERT INTO `elec_player` VALUES ('463', '5', 'aaa', 'aaa', '1', '0', '24', '0', null, '17858969502', '25D55AD283AA400AF464C76D713C07AD', '2', '2018-05-31 17:29:16', '3', '0', '1', null, '上海 浦东新区', null, '123', null, null, null, null, null, null, null, null, null, null, '0', '架子鼓', null);
INSERT INTO `elec_player` VALUES ('464', '7', '王老师', null, '1', '0', null, '0', null, null, '44', '0', null, '345', '0', '1', null, null, null, null, null, null, null, null, null, null, null, null, null, '', '0', '1', null);
INSERT INTO `elec_player` VALUES ('465', '8', '22', null, '1', '0', null, '0', null, '23', '213', '0', null, '567', '0', '1', null, null, null, null, null, null, null, null, null, null, null, null, null, '', '0', '1', null);
INSERT INTO `elec_player` VALUES ('466', '9', '12', null, '1', '0', null, '0', null, '12', '12', '0', null, '435', '0', '1', null, null, null, null, null, null, null, null, null, null, null, null, null, '', '0', '1', null);
INSERT INTO `elec_player` VALUES ('467', '10', '66', null, '1', '0', null, '0', null, '66', '66', '0', null, '455', '0', '1', null, null, null, null, null, null, null, null, null, null, null, null, null, 'http://192.168.1.69/F/Image/null/1528164355125.png', '0', '1', null);
INSERT INTO `elec_player` VALUES ('468', '11', '21', null, '1', '0', null, '0', null, '12', '12', '3', null, '4351', '0', '1', null, null, null, null, null, null, null, null, null, null, null, null, null, '', '0', '1', null);
INSERT INTO `elec_player` VALUES ('470', null, null, '菲翔 音符', '1', '0', null, '0', null, null, '$2a$10$1stsAL6PHnQ0yE3LabOlYuop5AmmSOKGd2iF2BNI7PhMVmxUw1C2W', '0', '2018-06-07 09:42:05', '0', '0', '1', '', '', null, null, 'o-biU0YOVMwlBgaCod1ZtT6ncjkE', 'ofadLwUOJ-2H4SxqailprMwAgSlA', 'http://thirdwx.qlogo.cn/mmopen/vi_32/k4KZvbsRdDJo0dd4za9aooNM7ptF2ZU5hGE4wIBGoWkER5Zypcic3K7I1Q09LwibVqawaMwdicpAbibechM9HfqeLA/132', null, null, null, null, null, null, null, '0', '1', null);
INSERT INTO `elec_player` VALUES ('474', '6', '1', '1', '1', '0', null, '0', null, '1', 'C81E728D9D4C2F636F067F89CC14862C', '2', '2018-06-07 14:12:02', '0', '0', '1', null, '1北京', null, '1', null, null, null, null, null, null, null, null, null, null, '1', '架子鼓', null);
INSERT INTO `elec_player` VALUES ('475', null, '1', null, null, null, null, null, null, '', 'c4ca4238a0b923820dcc509a6f75849b', '3', '2018-06-07 19:58:01', '0', null, null, null, '1', null, '1', null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `elec_player` VALUES ('476', '496', '俞钦华', 'yu', '1', '0', '24', '0', '1994-8-30', '', 'E10ADC3949BA59ABBE56E057F20F883E', '1', '2018-06-07 20:34:04', '3', '0', '1', null, '江苏 南通 海门市', null, '三和', null, null, null, null, null, null, null, null, null, null, '1', '架子鼓', null);
INSERT INTO `elec_player` VALUES ('480', '499', 'ly', '人生#如梦℃', '1', '0', '10', '0', '2008-12-31', '', '$2a$10$9ZqkI/gsldeXddaBOLiUVuhlsFNVCc0plemHbWAkicVeG3hNmPJDa', '1', '2018-06-08 17:32:34', '3', '0', '1', null, '湖南 长沙', null, 'ssssws', null, null, null, 'B0054356FB5D56C1825B4C30C504196B', '1106262879', null, null, null, null, null, '1', '架子鼓', null);
INSERT INTO `elec_player` VALUES ('481', '500', 'test', 'test', '1', '0', null, '0', null, '13676548289', 'E10ADC3949BA59ABBE56E057F20F883E', '1', '2018-06-09 10:00:36', '3', '0', '1', null, '北京 东城区', null, 'sdf', null, null, null, null, null, null, null, null, null, null, '1', '架子鼓', null);
INSERT INTO `elec_player` VALUES ('483', '24', '士大夫但是', null, '1', '0', null, '0', null, '1519449166', 'E196EF15AB8090AB268DD4C7B24501AA', '3', null, '99', '0', '1', null, null, null, null, null, null, 'http://47.100.11.15/F/Image/null/1529477826320.png', null, null, 'http://47.100.11.15/F/Image/null/1529477826320.png', null, null, null, 'http://192.168.1.71/F//Image/null/1528712278996.png', '0', '1', '55');
INSERT INTO `elec_player` VALUES ('484', '14', 'sdf', null, '1', '0', null, '0', null, 'dsfss', '6FBFD5E68D3306E51350BEA0232F8FA5', '3', null, '0', '0', '1', null, null, null, null, null, null, null, null, null, null, null, null, null, 'http://192.168.1.71/F//Image/null/1528714417367.png', '0', '1', null);
INSERT INTO `elec_player` VALUES ('486', '15', '李海生', null, '1', '0', null, '0', null, '17908478864', '202CB962AC59075B964B07152D234B70', '3', null, '0', '0', '1', null, null, null, null, null, null, null, null, null, null, null, null, null, '', '0', '1', null);
INSERT INTO `elec_player` VALUES ('488', null, null, 'fansen', '1', '0', null, '1', null, null, '$2a$10$XLZkMObS.quhloNGHWYU0OXrBQ2MNi76Gy8aVgVQdA1jkaQcS4Nci', '0', '2018-06-12 10:49:34', '3', '0', '1', 'Heilongjiang', 'Harbin', null, null, 'o-biU0TAw36QVxJHrbU3B4j5OBTM', 'ofadLwTkh_2zUc_6H3gOEo2xcDc4', 'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83epjRibGOIgg6zrjicjuExTibf7ZNnc7ADj9tLTicwUiar3UY0ibDFrUekul1OrmSENmkd2oBfgSwEv6Nudw/132', null, null, null, null, null, null, null, '0', '1', null);
INSERT INTO `elec_player` VALUES ('489', '16', '李老师', null, '1', '0', null, '0', null, '15194491660', 'ECCBC87E4B5CE2FE28308FD9F2A7BAF3', '3', null, '0', '0', '1', null, null, null, null, null, null, null, null, null, null, null, null, null, 'http://47.100.11.15/F/Image/null/1528805165369.png', '0', '1', null);
INSERT INTO `elec_player` VALUES ('490', '17', '22', null, '1', '0', null, '0', null, '22', 'C81E728D9D4C2F636F067F89CC14862C', '3', null, '0', '0', '1', null, null, null, null, null, null, null, null, null, null, null, null, null, '', '0', '1', null);
INSERT INTO `elec_player` VALUES ('491', null, null, 'fansen', '1', '0', null, '0', null, null, '$2a$10$ebVc04Vvms1mGNGnfYXM5uSMf38.i38TO3misDbc4QEo3QMe375ue', '0', '2018-06-13 11:08:30', '3', '0', '1', null, null, null, null, null, null, null, '8EC7355AA5F9A23CE7796A36065B4CA7', '1106262879', null, null, null, null, null, '0', '1', null);
INSERT INTO `elec_player` VALUES ('492', null, null, 'Heisenberg', '1', '0', null, '1', null, null, '$2a$10$CKM6lGT3NWVHQUaJHhxXvOucpTv5qWMa2gf1atAiW.Gp8/C3TySde', '0', '2018-06-13 12:01:29', '3', '0', '1', 'Shanghai', '', null, null, 'oVCjN0XX4j_EWstZQmP9C-I9uEOM', 'oFhwN1FzXL6OMcTr9cjWjCC6FplA', 'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eqlH3Xs2LKiczjyNTpDPOwhicM3ia9VGc5qaFzfia8nrkpnL3sOm2WcxN6QUkBKMibXwpRN2FotfVhQcEQ/132', null, null, null, null, null, null, null, '0', '1', null);
INSERT INTO `elec_player` VALUES ('493', '18', 'sf', null, '1', '0', null, '0', null, '15194491660', '0CC175B9C0F1B6A831C399E269772661', '3', null, '0', '0', '1', null, null, null, null, null, null, null, null, null, null, null, null, null, '', '0', '1', null);
INSERT INTO `elec_player` VALUES ('494', '511', '盘！@#￥%aa', 'fbhg', '1', '0', '1', '0', '2018-6-8', '13177143948', 'CFCD208495D565EF66E7DFF9F98764DA', '1', '2018-06-13 17:01:35', '3', '0', '1', null, '河南 开封 鼓楼区', null, 'dfsfgsf', null, null, null, null, null, null, null, null, null, 'http://47.100.11.15/F/Image/b46504c7dcabf28da3e9c43be3b3fae3.png', '1', '架子鼓', null);
INSERT INTO `elec_player` VALUES ('497', '513', '林永', '林永', '1', '0', null, '0', null, '', 'E10ADC3949BA59ABBE56E057F20F883E', '1', '2018-06-14 11:11:37', '3', '0', '1', null, '河南 洛阳 老城区', null, '士大夫十分低调', null, null, null, null, null, null, null, null, null, null, '1', '架子鼓', null);
INSERT INTO `elec_player` VALUES ('499', '9', '法国海军', '的身份和', '1', '0', null, '0', null, '18516760024', 'CFCD208495D565EF66E7DFF9F98764DA', '2', '2018-06-14 19:13:30', '3', '0', '1', null, '北京 东城区', null, '十多个活生生的', null, null, null, null, null, null, null, null, null, null, '1', '架子鼓', null);
INSERT INTO `elec_player` VALUES ('501', null, null, '快刀小子', '1', '0', null, '1', null, null, '$2a$10$1T.MnlVBFLxn6K6qtt.rteQsKMiwInH340DekqDDtvEU44P.jQoVC', '0', '2018-06-15 10:51:52', '3', '0', '1', 'Shaanxi', 'Baoji', null, null, 'oVCjN0Q0iK4-PwBVFQDD_2mwsIxA', 'oFhwN1IgtjHd-OmWiLX8m5sbOmCg', 'http://thirdwx.qlogo.cn/mmopen/vi_32/4Jv2ibQpLNWmBpZpB8acbZmHUrQq6YlibgPTiacHebgEEIgtahldp1qAicgfPicmAMvV6JYeZ8umqD1P0QYzaDHZliaw/132', null, null, null, null, null, null, null, '0', '1', null);
INSERT INTO `elec_player` VALUES ('503', '10', '2222', '222', '1', '0', null, '0', null, '151944916601', '202CB962AC59075B964B07152D234B70', '4', null, '0', '0', '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '1', null);
INSERT INTO `elec_player` VALUES ('510', '25', '俞钦华', null, '1', '0', null, '0', null, '17680251245', '202CB962AC59075B964B07152D234B70', '3', null, '0', '0', '1', null, null, null, null, null, null, null, null, null, null, null, null, null, 'http://47.100.11.15/F/Image/null/1529469125393.png', '0', '1', null);
INSERT INTO `elec_player` VALUES ('511', '517', '反对法', '打发打发', '1', '0', null, '0', null, '15821941486', '202CB962AC59075B964B07152D234B70', '1', '2018-06-20 16:11:28', '3', '0', '1', null, '黑龙江 大庆 红岗区', null, '烦烦烦方法', null, null, null, null, null, null, null, null, null, null, '1', '架子鼓', '66');

-- ----------------------------
-- Table structure for `gameintegration_set`
-- ----------------------------
DROP TABLE IF EXISTS `gameintegration_set`;
CREATE TABLE `gameintegration_set` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '游戏积分管理',
  `type_id` int(11) DEFAULT NULL COMMENT '游戏积分类别id,1打地鼠简单模式单机,2一般模式单机,3困难模式单机,4简单模式pk胜利,5一般模式pk胜利,6困难模式pk胜利,7游戏结束分享',
  `content` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '积分内容',
  `value` decimal(10,0) DEFAULT NULL COMMENT '奖励积分数值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of gameintegration_set
-- ----------------------------
INSERT INTO `gameintegration_set` VALUES ('1', '1', '打地鼠简单模式单机', '23');
INSERT INTO `gameintegration_set` VALUES ('2', '2', '打地鼠一般模式单机', '12');
INSERT INTO `gameintegration_set` VALUES ('3', '3', '打地鼠困难模式单机', '235');
INSERT INTO `gameintegration_set` VALUES ('4', '4', '打地鼠简单模式pk胜利', '22');
INSERT INTO `gameintegration_set` VALUES ('5', '5', '打地鼠一般模式pk胜利', '5');
INSERT INTO `gameintegration_set` VALUES ('6', '6', '打地鼠困难模式pk胜利', '45');
INSERT INTO `gameintegration_set` VALUES ('7', '7', '游戏结束分享', '34');

-- ----------------------------
-- Table structure for `game_detail`
-- ----------------------------
DROP TABLE IF EXISTS `game_detail`;
CREATE TABLE `game_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '游戏信息表',
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `pirce` decimal(10,0) DEFAULT NULL COMMENT '游戏价格(熊掌)',
  `discount` decimal(10,0) DEFAULT NULL COMMENT '优惠金额',
  `dicount_use` int(11) DEFAULT NULL COMMENT '是否启用优惠(1--开启 0--关闭)',
  `free_count` int(11) DEFAULT NULL COMMENT '免费次数',
  `status` int(11) DEFAULT NULL COMMENT '状态(1--上架  0--下架)',
  `play_count` int(11) DEFAULT NULL COMMENT '使用次数',
  `last_play_time` datetime DEFAULT NULL COMMENT '最后使用时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `on_shelf_time` datetime DEFAULT NULL COMMENT '上架时间',
  `off_shelf_time` datetime DEFAULT NULL COMMENT '下架时间',
  `founder` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of game_detail
-- ----------------------------
INSERT INTO `game_detail` VALUES ('1', 'aa', '32', '21', '0', '23', '1', '21', '2018-05-21 13:45:55', '2018-05-22 14:02:37', '2018-05-22 14:02:32', '2018-05-22 14:02:37', '22');
INSERT INTO `game_detail` VALUES ('2', 's', '2', '2', '0', '2', '0', '0', null, '2018-05-22 13:58:58', '2018-05-22 13:58:49', '2018-05-22 13:58:58', '2');
INSERT INTO `game_detail` VALUES ('3', '112sf', '2333', '123', '0', '123', '0', '0', null, '2018-05-21 14:27:12', '2018-05-21 14:26:55', '2018-05-21 14:27:12', '123');
INSERT INTO `game_detail` VALUES ('4', 'cd', '44', '44', '0', '44', '0', '0', null, '2018-05-22 13:56:43', '2018-05-21 14:27:51', '2018-05-22 13:56:43', '44');
INSERT INTO `game_detail` VALUES ('5', '2121', '12', '12', '0', '12', '1', '0', null, '2018-06-21 14:37:44', '2018-06-21 14:37:44', '2018-05-22 14:07:53', '12');
INSERT INTO `game_detail` VALUES ('7', 'w3rw', '23', '23', '0', '23', '1', '0', null, '2018-05-22 14:17:30', '2018-05-22 14:17:30', '2018-05-22 14:27:35', '232');

-- ----------------------------
-- Table structure for `game_grade`
-- ----------------------------
DROP TABLE IF EXISTS `game_grade`;
CREATE TABLE `game_grade` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '玩家等级表',
  `grade_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '等级名称',
  `min_score` int(11) DEFAULT NULL COMMENT '最小积分值',
  `max_score` int(11) DEFAULT NULL COMMENT '最大积分值',
  `grade_remarks` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '玩家等级备注',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of game_grade
-- ----------------------------
INSERT INTO `game_grade` VALUES ('1', '青铜', '0', '100', '青铜段位', '2018-05-28 15:15:32');
INSERT INTO `game_grade` VALUES ('2', '白金', '101', '200', '白银段位', '2018-05-28 15:15:55');
INSERT INTO `game_grade` VALUES ('3', '黄金', '201', '300', '黄金段位', '2018-05-28 15:16:37');

-- ----------------------------
-- Table structure for `homework_datail`
-- ----------------------------
DROP TABLE IF EXISTS `homework_datail`;
CREATE TABLE `homework_datail` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '作业信息表',
  `teacher_id` int(11) DEFAULT NULL COMMENT '老师id',
  `teacher_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '老师姓名',
  `opera_id` int(11) DEFAULT NULL COMMENT '曲谱id',
  `stu_id` int(11) DEFAULT NULL COMMENT '学生id',
  `student` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '学生姓名',
  `parent` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '家长姓名',
  `homework_detail` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '作业明细',
  `state` int(11) DEFAULT NULL COMMENT '状态 0-未完成 1-进行中 2-已完成',
  `practice` int(11) DEFAULT NULL COMMENT '练习次数',
  `send_time` datetime DEFAULT NULL COMMENT '布置时间',
  `want_finish_time` datetime DEFAULT NULL COMMENT '要求完成时间',
  `finish_time` datetime DEFAULT NULL COMMENT '完成时间',
  `belonto_piano` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '琴行',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of homework_datail
-- ----------------------------
INSERT INTO `homework_datail` VALUES ('1', '1', 'we', '27', '458', 'w', 'ee', 'ewfewfe', '1', null, '2018-05-21 16:53:53', '2018-05-28 12:00:00', '2018-05-07 10:31:59', 'wewe');
INSERT INTO `homework_datail` VALUES ('3', '6', null, '57', '4', null, null, null, '0', '10', '2018-05-21 16:53:53', '2018-05-28 12:00:00', null, null);
INSERT INTO `homework_datail` VALUES ('17', '7', 'fan', '57', '454', 'liyong', null, null, '0', '1', '2018-06-05 00:00:00', '2018-06-05 00:00:00', null, null);

-- ----------------------------
-- Table structure for `income_detail`
-- ----------------------------
DROP TABLE IF EXISTS `income_detail`;
CREATE TABLE `income_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '收入明细表',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id，4个表对应的id',
  `user_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '用户姓名',
  `role` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '角色0总管理，1服务商，2机构，3琴行，4老师',
  `consump_type` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '消费类型1琴行创建2曲谱讲解3皮肤收入4教材收入5游戏收入',
  `income_money` decimal(10,0) DEFAULT NULL COMMENT '收入金额',
  `account_balance` decimal(10,0) DEFAULT NULL COMMENT '账户余额',
  `create_time` datetime DEFAULT NULL COMMENT '时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=107 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of income_detail
-- ----------------------------
INSERT INTO `income_detail` VALUES ('100', '1', '1212', '1', '1', '12', '12', '2018-05-18 15:57:10');
INSERT INTO `income_detail` VALUES ('101', '2', '232', '2', '2', '23', '2', '2018-06-09 17:40:27');
INSERT INTO `income_detail` VALUES ('102', '3', 'wew', '3', '2', '2', '2', '2018-05-27 12:22:25');
INSERT INTO `income_detail` VALUES ('103', '1', '121', '1', '3', '40', '2', '2018-05-02 16:50:02');
INSERT INTO `income_detail` VALUES ('104', '1', '121', '2', '4', '23', '2', '2018-06-01 16:56:18');
INSERT INTO `income_detail` VALUES ('105', '2', null, '4', '1', '12', '5', '2018-06-07 09:37:15');
INSERT INTO `income_detail` VALUES ('106', '1', null, '2', '1', '2', '6', '2018-06-06 09:38:07');

-- ----------------------------
-- Table structure for `integration_set`
-- ----------------------------
DROP TABLE IF EXISTS `integration_set`;
CREATE TABLE `integration_set` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '积分管理表',
  `type_id` int(11) DEFAULT NULL COMMENT '积分管理类别id,1通关奖励积分,2练习奖励,3每日登陆,4分享奖励,5购买曲谱',
  `content` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '积分内容',
  `value` decimal(10,0) DEFAULT NULL COMMENT '奖励积分数值',
  `top_values` decimal(10,0) DEFAULT NULL COMMENT '基础练习评分在多少以上获得奖励',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of integration_set
-- ----------------------------
INSERT INTO `integration_set` VALUES ('1', '1', '通关积分', '3', null);
INSERT INTO `integration_set` VALUES ('2', '2', '练习奖励', '142', '4');
INSERT INTO `integration_set` VALUES ('3', '3', '每日登陆', '52', null);
INSERT INTO `integration_set` VALUES ('4', '4', '分享奖励', '23', '12');
INSERT INTO `integration_set` VALUES ('5', '5', '购买曲谱', '45', null);

-- ----------------------------
-- Table structure for `learnbook_detail`
-- ----------------------------
DROP TABLE IF EXISTS `learnbook_detail`;
CREATE TABLE `learnbook_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '教材信息表',
  `learnBook_id` int(11) DEFAULT NULL COMMENT '教材id',
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '教材名',
  `pianoshop_role` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '曲谱权限,0表示不允许其他琴行,-1表示全部琴行,选择使用中竖线分割琴行id',
  `summary` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '简介',
  `author` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '作者',
  `cover_picture` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '封面图片',
  `opern_num` int(11) DEFAULT '0' COMMENT '谱曲数',
  `is_recommend` int(11) DEFAULT '0' COMMENT '是否设为推荐教材(0--不推荐  1--推荐)',
  `is_anthor` int(11) DEFAULT '0' COMMENT '是否设置作者教材(1--是  0--否)',
  `use_permission` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '教材使用权限(保存对应id--"1|2|3")',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of learnbook_detail
-- ----------------------------
INSERT INTO `learnbook_detail` VALUES ('4', null, '教材1', '0', '你好', '小王', 'http://47.100.11.15/F/Image/null/1528876957280.jpg', '8', '1', '0', null);
INSERT INTO `learnbook_detail` VALUES ('7', null, '教材2', '0', '这是一个初学者教材77', '小黄', 'http://47.100.11.15/F/Image/null/1528876571682.jpg', '12', '0', '0', null);
INSERT INTO `learnbook_detail` VALUES ('8', null, '教材3', '0', '这是一个初学者教材988', '小张', 'http://47.100.11.15/F/Image/null/1528876970861.jpg', '8', '0', '0', null);
INSERT INTO `learnbook_detail` VALUES ('9', null, '教材4', null, '这是一个初学者教材99', 'fansen', 'http://106.14.25.203/F/Image/jiaocai.jpg', '1', '0', '0', null);
INSERT INTO `learnbook_detail` VALUES ('10', null, '教材5', null, '这是一个初学者教材22', '大黄', 'http://106.14.25.203/F/Image/jiaocai.jpg', '2', '0', '0', null);
INSERT INTO `learnbook_detail` VALUES ('11', null, '教材6', null, '这是一个初学者教材33', '大白', 'http://106.14.25.203/F/Image/jiaocai.jpg', '4', '0', '0', null);
INSERT INTO `learnbook_detail` VALUES ('12', null, '教材7', '0', '这是一个初学者教材555', '胜多负少', 'http://106.14.25.203/F/Image/jiaocai.jpg', '2', null, '1', null);
INSERT INTO `learnbook_detail` VALUES ('19', null, 'dsfs', '2|4', 'sdfdsfdfsf', 'sdf', 'http://106.14.25.203/F/Image/jiaocai.jpg', null, null, null, null);
INSERT INTO `learnbook_detail` VALUES ('21', null, 'sdfs', '-1', 'sfsdfsdf', 'sdf', 'http://106.14.25.203/F/Image/jiaocai.jpg', null, null, null, null);
INSERT INTO `learnbook_detail` VALUES ('22', null, 'sdf1', '0', 'wewewewe1', 'sdf1', 'http://47.100.11.15/F/Image/null/1529393289812.png', null, '1', '1', null);
INSERT INTO `learnbook_detail` VALUES ('23', null, '1111', null, 'erwerwerw', '2222', 'http://106.14.25.203/F/Image/jiaocai.jpg', null, null, null, null);
INSERT INTO `learnbook_detail` VALUES ('24', null, '1232111', null, 'sdfsdfs1111', '3211111', 'http://106.14.25.203/F/Image/jiaocai.jpg', '2', '0', '0', null);
INSERT INTO `learnbook_detail` VALUES ('25', null, 'sdfs', null, 'sdfdsfs', 'sdf', 'http://106.14.25.203/F/Image/jiaocai.jpg', '0', '1', '1', null);

-- ----------------------------
-- Table structure for `learnbook_set`
-- ----------------------------
DROP TABLE IF EXISTS `learnbook_set`;
CREATE TABLE `learnbook_set` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '教材设置',
  `learnBook_num` decimal(10,0) DEFAULT NULL COMMENT '谱曲默认免费最大个数',
  `teacer_buy_book` decimal(10,0) DEFAULT NULL COMMENT '老师购买教材的最大数量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of learnbook_set
-- ----------------------------
INSERT INTO `learnbook_set` VALUES ('1', '10', '5');

-- ----------------------------
-- Table structure for `learnbook_stage`
-- ----------------------------
DROP TABLE IF EXISTS `learnbook_stage`;
CREATE TABLE `learnbook_stage` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '教材阶段管理',
  `stage` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '阶段类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of learnbook_stage
-- ----------------------------
INSERT INTO `learnbook_stage` VALUES ('20', '初级');
INSERT INTO `learnbook_stage` VALUES ('22', '中级');
INSERT INTO `learnbook_stage` VALUES ('23', '高级');

-- ----------------------------
-- Table structure for `learnbook_style`
-- ----------------------------
DROP TABLE IF EXISTS `learnbook_style`;
CREATE TABLE `learnbook_style` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '教材风格',
  `style` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '风格类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of learnbook_style
-- ----------------------------
INSERT INTO `learnbook_style` VALUES ('1', '爵士');
INSERT INTO `learnbook_style` VALUES ('3', '摇滚');
INSERT INTO `learnbook_style` VALUES ('4', '重金属');
INSERT INTO `learnbook_style` VALUES ('5', '婉约');
INSERT INTO `learnbook_style` VALUES ('6', '儿童');
INSERT INTO `learnbook_style` VALUES ('7', '天籁之音');
INSERT INTO `learnbook_style` VALUES ('8', '小桥流水');
INSERT INTO `learnbook_style` VALUES ('9', '放荡不羁');

-- ----------------------------
-- Table structure for `membership_dues`
-- ----------------------------
DROP TABLE IF EXISTS `membership_dues`;
CREATE TABLE `membership_dues` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '会费缴纳信息表',
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '名称',
  `user_id` int(11) DEFAULT NULL COMMENT '3个表的id',
  `role` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '角色1服务商，2机构，3琴行，',
  `amount` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '会费金额',
  `time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '应该缴纳日期',
  `reality_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '实际缴纳日期',
  `two_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '下次缴纳会费的时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of membership_dues
-- ----------------------------
INSERT INTO `membership_dues` VALUES ('1', '哈哈', '1', '2', '12', '2018-06-12 17:37:00', '2018-06-12 17:37:00', '2018-06-24 17:33:32');
INSERT INTO `membership_dues` VALUES ('2', '得到', '1', '1', '22', '2018-06-12 17:37:15', '2018-06-12 17:37:15', '2018-06-24 17:33:33');
INSERT INTO `membership_dues` VALUES ('3', '1所属', '1', '3', '22', '2018-06-12 17:33:33', '2018-06-12 17:33:33', '2018-06-12 17:33:33');
INSERT INTO `membership_dues` VALUES ('4', '是的', '1', '3', '11', '2018-06-12 17:33:34', '2018-06-12 17:33:34', '2018-06-12 17:33:34');
INSERT INTO `membership_dues` VALUES ('5', '啊啊', '1', '3', '2', '2018-06-12 17:33:35', '2018-06-12 17:33:35', '2018-06-12 17:33:35');
INSERT INTO `membership_dues` VALUES ('6', '预约', '1', '1', '1', '2018-06-12 17:37:11', '2018-06-12 17:37:11', '2018-06-29 17:33:37');
INSERT INTO `membership_dues` VALUES ('7', '水电费', '1', '1', '22', '2018-06-24 17:44:50', '2018-06-27 17:44:55', '2018-06-01 17:44:58');

-- ----------------------------
-- Table structure for `opera_calssify`
-- ----------------------------
DROP TABLE IF EXISTS `opera_calssify`;
CREATE TABLE `opera_calssify` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '曲谱分类表(分类名称不能重复,分类下有曲谱时不能删除)',
  `classify_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '分类名称',
  `is_delete` int(11) DEFAULT '0' COMMENT '是否删除(0--不删除  1--删除)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of opera_calssify
-- ----------------------------
INSERT INTO `opera_calssify` VALUES ('1', '车载音乐', '1');
INSERT INTO `opera_calssify` VALUES ('2', '爵士乐', '0');
INSERT INTO `opera_calssify` VALUES ('3', '123', '1');
INSERT INTO `opera_calssify` VALUES ('4', '234', '1');
INSERT INTO `opera_calssify` VALUES ('5', '钢琴曲', '1');
INSERT INTO `opera_calssify` VALUES ('6', '钢琴曲123', '1');
INSERT INTO `opera_calssify` VALUES ('7', '小提琴', '1');
INSERT INTO `opera_calssify` VALUES ('8', '峰曲', '1');
INSERT INTO `opera_calssify` VALUES ('9', '峰曲21', '1');
INSERT INTO `opera_calssify` VALUES ('10', '大提琴', '1');
INSERT INTO `opera_calssify` VALUES ('11', '10:大提琴', '1');
INSERT INTO `opera_calssify` VALUES ('12', '234', '1');
INSERT INTO `opera_calssify` VALUES ('13', '456', '1');
INSERT INTO `opera_calssify` VALUES ('14', '444', '1');
INSERT INTO `opera_calssify` VALUES ('15', '666', '1');
INSERT INTO `opera_calssify` VALUES ('16', '777', '1');
INSERT INTO `opera_calssify` VALUES ('17', 'df', '1');
INSERT INTO `opera_calssify` VALUES ('18', 'xiao', '1');
INSERT INTO `opera_calssify` VALUES ('19', 'sdf', '1');
INSERT INTO `opera_calssify` VALUES ('20', 'sdfg', '1');
INSERT INTO `opera_calssify` VALUES ('21', 'yd#', '1');
INSERT INTO `opera_calssify` VALUES ('22', 'fdh', '1');
INSERT INTO `opera_calssify` VALUES ('23', 'sfg', '1');
INSERT INTO `opera_calssify` VALUES ('24', 'dfg', '1');
INSERT INTO `opera_calssify` VALUES ('25', 'dfgg', '1');
INSERT INTO `opera_calssify` VALUES ('26', 'wwww', '1');
INSERT INTO `opera_calssify` VALUES ('27', 'zzzz', '1');
INSERT INTO `opera_calssify` VALUES ('28', 'zxcvz', '1');
INSERT INTO `opera_calssify` VALUES ('29', 'zxvbvcvb', '1');
INSERT INTO `opera_calssify` VALUES ('30', 'xzcvb', '1');
INSERT INTO `opera_calssify` VALUES ('31', 'zxcv', '0');
INSERT INTO `opera_calssify` VALUES ('32', '是是是', '0');

-- ----------------------------
-- Table structure for `opera_detail`
-- ----------------------------
DROP TABLE IF EXISTS `opera_detail`;
CREATE TABLE `opera_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '曲谱信息表',
  `learnBook_id` int(11) DEFAULT NULL COMMENT '教材id',
  `learnBook_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '曲谱教材名',
  `pianoshop_role` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '曲谱权限,0表示不允许其他琴行,-1表示全部琴行,选择使用中竖线分割琴行id',
  `style` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '风格',
  `apply_stage` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '适用阶段',
  `opera_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '曲谱名称',
  `author` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '作者',
  `is_get_score` int(11) DEFAULT NULL COMMENT '是否获得积分(1--是  0--否)',
  `is_open` int(11) DEFAULT NULL COMMENT '是否公开',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `downlaod_amount` int(11) DEFAULT NULL COMMENT '下载次数',
  `saled_amount` int(11) DEFAULT NULL COMMENT '出售次数',
  `income` decimal(10,2) DEFAULT NULL COMMENT '收入',
  `is_used` int(11) DEFAULT NULL COMMENT '是否启用',
  `explain_price` decimal(10,2) DEFAULT NULL COMMENT '讲解价格',
  `price_used` int(11) DEFAULT NULL COMMENT '讲解价格是否启用 0-启用 1-不启用',
  `difficulty` int(11) DEFAULT NULL COMMENT '难度(app游戏中 0--简单 1--一般  2--困难)',
  `cover_picture` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '封面图片',
  `explain_picture` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '讲解图片',
  `explain_video` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '讲解视频',
  `music_score` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '乐谱',
  `music` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '音乐的地址',
  `music_score_midi` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '乐谱midi',
  `profile` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '配置文件',
  `edit_time` datetime DEFAULT NULL COMMENT '最后编辑时间',
  `classfiy_id` int(11) DEFAULT NULL COMMENT '曲谱对应的上级分类id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=110 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of opera_detail
-- ----------------------------
INSERT INTO `opera_detail` VALUES ('107', '4', '教材1', '0', '爵士', '初级', '菊次郎的秋天', '李勇', '0', '0', '2018-06-20 15:33:06', null, null, null, '0', '-1.00', '1', '1', 'http://192.168.1.71/F/Video/12345678/1529396344028.jpg', null, '', 'http://47.100.11.15/F/Image/12345678/1528777518039.png', 'http://47.100.11.15/F/Video/12345678/1528777526690.mp3', null, 'http://47.100.11.15/F/Video/12345678/1528777521911.json', '2018-06-20 15:33:06', null);
INSERT INTO `opera_detail` VALUES ('108', '7', '教材2', '-1', '爵士123', '223', '菊次郎的秋天', '林永', '1', '0', '2018-06-12 14:12:27', null, null, null, '0', '0.00', '1', '1', 'http://47.100.11.15/F/Image/12345678/1528783901158.png', null, '', 'http://47.100.11.15/F/Image/12345678/1528783837515.png', 'http://47.100.11.15/F/Video/12345678/1528783848967.mp3', null, 'http://47.100.11.15/F/Video/12345678/1528783841512.json', '2018-06-12 14:11:45', null);
INSERT INTO `opera_detail` VALUES ('109', '8', '教材3', '-1', '爵士123', '223', '直到世界尽头', 'ly', '0', '0', '2018-06-12 14:24:20', null, null, null, '0', '-1.00', '1', '1', 'http://47.100.11.15/F/Image/12345678/1528784586749.png', null, '', 'http://47.100.11.15/F/Image/12345678/1528784446431.png', 'http://47.100.11.15/F/Video/12345678/1528784466518.mp3', null, 'http://47.100.11.15/F/Video/12345678/1528784453901.json', '2018-06-12 14:23:12', null);

-- ----------------------------
-- Table structure for `opera_explain_picture`
-- ----------------------------
DROP TABLE IF EXISTS `opera_explain_picture`;
CREATE TABLE `opera_explain_picture` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '曲谱讲解图片表(1对n关系)',
  `opera_id` int(11) DEFAULT NULL COMMENT '曲谱id',
  `explain_picture` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '讲解图片',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=123 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of opera_explain_picture
-- ----------------------------
INSERT INTO `opera_explain_picture` VALUES ('1', '1', 'sss');
INSERT INTO `opera_explain_picture` VALUES ('2', '1', 'sss');
INSERT INTO `opera_explain_picture` VALUES ('3', '1', 'sss');
INSERT INTO `opera_explain_picture` VALUES ('4', '1', 'www');
INSERT INTO `opera_explain_picture` VALUES ('5', '1', 'sss');
INSERT INTO `opera_explain_picture` VALUES ('6', '1', 'www');
INSERT INTO `opera_explain_picture` VALUES ('7', '1', 'sss');
INSERT INTO `opera_explain_picture` VALUES ('8', '1', 'www');
INSERT INTO `opera_explain_picture` VALUES ('9', '1', 'sss');
INSERT INTO `opera_explain_picture` VALUES ('10', '1', 'www');
INSERT INTO `opera_explain_picture` VALUES ('11', '1', 'http://192.168.1.66/F/Image/sss/1525751611280.png');
INSERT INTO `opera_explain_picture` VALUES ('12', '1', 'http://192.168.1.66/F/Image/sss/1525751611280.png');
INSERT INTO `opera_explain_picture` VALUES ('13', '1', 'http://192.168.1.66/F/Image/sss/1525751611280.png');
INSERT INTO `opera_explain_picture` VALUES ('14', '1', 'http://192.168.1.66/F/Image/sss/1525766479593.png');
INSERT INTO `opera_explain_picture` VALUES ('15', '1', 'http://192.168.1.66/F/Image/sss/1525766694468.png');
INSERT INTO `opera_explain_picture` VALUES ('16', '1', 'http://192.168.1.66/F/Image/sss/1525768905543.png');
INSERT INTO `opera_explain_picture` VALUES ('17', '1', 'http://192.168.1.66/F/Image/sss/1525751611280.png');
INSERT INTO `opera_explain_picture` VALUES ('18', '1', 'http://192.168.1.66/F/Image/sss/1525751611280.png');
INSERT INTO `opera_explain_picture` VALUES ('19', '1', 'http://192.168.1.66/F/Image/sss/1525769621658.png');
INSERT INTO `opera_explain_picture` VALUES ('20', '1', '');
INSERT INTO `opera_explain_picture` VALUES ('21', '1', '');
INSERT INTO `opera_explain_picture` VALUES ('22', '1', '');
INSERT INTO `opera_explain_picture` VALUES ('23', '53', '');
INSERT INTO `opera_explain_picture` VALUES ('24', '54', 'http://106.14.25.203/F/Image/12345678/1526025621368.png');
INSERT INTO `opera_explain_picture` VALUES ('25', '55', 'http://106.14.25.203/F/Image/12345678/1526029105215.png');
INSERT INTO `opera_explain_picture` VALUES ('26', '56', 'http://106.14.25.203/F/Image/12345678/1526029298920.png');
INSERT INTO `opera_explain_picture` VALUES ('27', '57', 'http://106.14.25.203/F/Image/12345678/1526030736049.png');
INSERT INTO `opera_explain_picture` VALUES ('28', '58', 'http://106.14.25.203/F/Image/12345678/1526033446091.png');
INSERT INTO `opera_explain_picture` VALUES ('29', '59', '');
INSERT INTO `opera_explain_picture` VALUES ('30', '59', '');
INSERT INTO `opera_explain_picture` VALUES ('31', '59', '');
INSERT INTO `opera_explain_picture` VALUES ('32', '57', 'http://106.14.25.203/F/Image/12345678/1526030736049.png');
INSERT INTO `opera_explain_picture` VALUES ('33', '62', '');
INSERT INTO `opera_explain_picture` VALUES ('34', '62', '');
INSERT INTO `opera_explain_picture` VALUES ('35', '62', '');
INSERT INTO `opera_explain_picture` VALUES ('36', '62', '');
INSERT INTO `opera_explain_picture` VALUES ('37', '62', '');
INSERT INTO `opera_explain_picture` VALUES ('38', '62', '');
INSERT INTO `opera_explain_picture` VALUES ('39', '62', '');
INSERT INTO `opera_explain_picture` VALUES ('40', '62', '');
INSERT INTO `opera_explain_picture` VALUES ('41', '57', 'http://106.14.25.203/F/Image/12345678/1526030736049.png');
INSERT INTO `opera_explain_picture` VALUES ('42', '57', 'http://106.14.25.203/F/Image/12345678/1526030736049.png');
INSERT INTO `opera_explain_picture` VALUES ('43', '57', 'http://106.14.25.203/F/Image/12345678/1526030736049.png');
INSERT INTO `opera_explain_picture` VALUES ('44', '57', 'http://106.14.25.203/F/Image/12345678/1526030736049.png');
INSERT INTO `opera_explain_picture` VALUES ('45', '57', 'http://106.14.25.203/F/Image/12345678/1526030736049.png');
INSERT INTO `opera_explain_picture` VALUES ('46', '57', 'http://106.14.25.203/F/Image/12345678/1526030736049.png');
INSERT INTO `opera_explain_picture` VALUES ('47', '57', 'http://106.14.25.203/F/Image/12345678/1526030736049.png');
INSERT INTO `opera_explain_picture` VALUES ('48', '57', 'http://106.14.25.203/F/Image/12345678/1526030736049.png');
INSERT INTO `opera_explain_picture` VALUES ('49', '57', 'http://106.14.25.203/F/Image/12345678/1526030736049.png');
INSERT INTO `opera_explain_picture` VALUES ('50', '57', 'http://106.14.25.203/F/Image/12345678/1526030736049.png');
INSERT INTO `opera_explain_picture` VALUES ('51', '62', '');
INSERT INTO `opera_explain_picture` VALUES ('52', '62', '');
INSERT INTO `opera_explain_picture` VALUES ('53', '62', '');
INSERT INTO `opera_explain_picture` VALUES ('54', '62', '');
INSERT INTO `opera_explain_picture` VALUES ('55', '62', '');
INSERT INTO `opera_explain_picture` VALUES ('56', '62', '');
INSERT INTO `opera_explain_picture` VALUES ('57', '62', '');
INSERT INTO `opera_explain_picture` VALUES ('58', null, '');
INSERT INTO `opera_explain_picture` VALUES ('59', null, '');
INSERT INTO `opera_explain_picture` VALUES ('60', null, '');
INSERT INTO `opera_explain_picture` VALUES ('61', null, '');
INSERT INTO `opera_explain_picture` VALUES ('62', null, '');
INSERT INTO `opera_explain_picture` VALUES ('63', null, '');
INSERT INTO `opera_explain_picture` VALUES ('64', null, '');
INSERT INTO `opera_explain_picture` VALUES ('65', null, '');
INSERT INTO `opera_explain_picture` VALUES ('66', null, '');
INSERT INTO `opera_explain_picture` VALUES ('67', null, '');
INSERT INTO `opera_explain_picture` VALUES ('68', null, '');
INSERT INTO `opera_explain_picture` VALUES ('69', null, '');
INSERT INTO `opera_explain_picture` VALUES ('70', '76', '');
INSERT INTO `opera_explain_picture` VALUES ('71', '76', '');
INSERT INTO `opera_explain_picture` VALUES ('72', '76', '');
INSERT INTO `opera_explain_picture` VALUES ('73', '76', '');
INSERT INTO `opera_explain_picture` VALUES ('74', '76', '');
INSERT INTO `opera_explain_picture` VALUES ('75', '76', '');
INSERT INTO `opera_explain_picture` VALUES ('76', '76', '');
INSERT INTO `opera_explain_picture` VALUES ('77', null, '');
INSERT INTO `opera_explain_picture` VALUES ('78', null, '');
INSERT INTO `opera_explain_picture` VALUES ('79', null, '');
INSERT INTO `opera_explain_picture` VALUES ('80', null, '');
INSERT INTO `opera_explain_picture` VALUES ('81', null, '');
INSERT INTO `opera_explain_picture` VALUES ('82', null, '');
INSERT INTO `opera_explain_picture` VALUES ('83', null, '');
INSERT INTO `opera_explain_picture` VALUES ('84', null, '');
INSERT INTO `opera_explain_picture` VALUES ('85', null, '');
INSERT INTO `opera_explain_picture` VALUES ('86', null, '');
INSERT INTO `opera_explain_picture` VALUES ('87', null, '');
INSERT INTO `opera_explain_picture` VALUES ('88', null, '');
INSERT INTO `opera_explain_picture` VALUES ('89', null, '');
INSERT INTO `opera_explain_picture` VALUES ('90', null, '');
INSERT INTO `opera_explain_picture` VALUES ('91', null, '');
INSERT INTO `opera_explain_picture` VALUES ('92', null, '');
INSERT INTO `opera_explain_picture` VALUES ('93', null, '');
INSERT INTO `opera_explain_picture` VALUES ('94', null, '');
INSERT INTO `opera_explain_picture` VALUES ('95', null, '');
INSERT INTO `opera_explain_picture` VALUES ('96', null, '');
INSERT INTO `opera_explain_picture` VALUES ('97', null, '');
INSERT INTO `opera_explain_picture` VALUES ('98', null, '');
INSERT INTO `opera_explain_picture` VALUES ('99', null, '');
INSERT INTO `opera_explain_picture` VALUES ('100', null, '');
INSERT INTO `opera_explain_picture` VALUES ('101', null, '');
INSERT INTO `opera_explain_picture` VALUES ('102', '105', '');
INSERT INTO `opera_explain_picture` VALUES ('103', '105', '');
INSERT INTO `opera_explain_picture` VALUES ('104', '105', '');
INSERT INTO `opera_explain_picture` VALUES ('105', '106', '');
INSERT INTO `opera_explain_picture` VALUES ('106', '106', '');
INSERT INTO `opera_explain_picture` VALUES ('107', '106', '');
INSERT INTO `opera_explain_picture` VALUES ('108', '106', '');
INSERT INTO `opera_explain_picture` VALUES ('109', '106', '');
INSERT INTO `opera_explain_picture` VALUES ('110', '106', '');
INSERT INTO `opera_explain_picture` VALUES ('111', '106', '');
INSERT INTO `opera_explain_picture` VALUES ('112', '107', '');
INSERT INTO `opera_explain_picture` VALUES ('113', '108', '');
INSERT INTO `opera_explain_picture` VALUES ('114', '109', '');
INSERT INTO `opera_explain_picture` VALUES ('115', '109', '');
INSERT INTO `opera_explain_picture` VALUES ('116', '107', '');
INSERT INTO `opera_explain_picture` VALUES ('117', '107', '');
INSERT INTO `opera_explain_picture` VALUES ('118', '107', '');
INSERT INTO `opera_explain_picture` VALUES ('119', '107', '');
INSERT INTO `opera_explain_picture` VALUES ('120', '107', 'http://192.168.1.71/F/Image/12345678/1529479831373.png');
INSERT INTO `opera_explain_picture` VALUES ('121', '107', 'http://192.168.1.71/F/Image/12345678/1529479831373.png');
INSERT INTO `opera_explain_picture` VALUES ('122', '107', 'http://192.168.1.71/F/Image/12345678/1529479831373.png');

-- ----------------------------
-- Table structure for `opera_owner`
-- ----------------------------
DROP TABLE IF EXISTS `opera_owner`;
CREATE TABLE `opera_owner` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '曲谱购买者关系表',
  `opera_id` int(11) DEFAULT NULL COMMENT '曲谱id',
  `owner_id` int(11) DEFAULT NULL COMMENT '购买者id',
  `is_delete` int(11) DEFAULT '0' COMMENT '是否删除该记录(0--不删除  1--删除)',
  `expiry_time` datetime DEFAULT NULL COMMENT '到期时间',
  `classify_id` int(11) DEFAULT '-1' COMMENT '所属分类id(  -1  --  代表无分类)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of opera_owner
-- ----------------------------
INSERT INTO `opera_owner` VALUES ('1', '107', '454', '0', '2018-06-30 14:17:02', '2');
INSERT INTO `opera_owner` VALUES ('2', '108', '454', '0', '2018-07-01 11:22:59', '2');
INSERT INTO `opera_owner` VALUES ('3', '107', '2', '0', '2018-05-29 11:23:16', '2');
INSERT INTO `opera_owner` VALUES ('9', '109', '7', '0', '2018-06-14 18:41:06', '2');

-- ----------------------------
-- Table structure for `opera_price`
-- ----------------------------
DROP TABLE IF EXISTS `opera_price`;
CREATE TABLE `opera_price` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '曲谱-价格关系表',
  `opera_id` int(11) DEFAULT NULL COMMENT '曲谱id外键',
  `price` decimal(10,2) DEFAULT NULL COMMENT '曲谱价格',
  `deadline` int(11) DEFAULT NULL COMMENT '期限<以月份为单位>',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `is_special` int(11) DEFAULT NULL COMMENT '是否是特价(1--是  0---不是特价)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=125 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of opera_price
-- ----------------------------
INSERT INTO `opera_price` VALUES ('55', '1', '2.00', '1', '2018-05-08 18:19:15', '0');
INSERT INTO `opera_price` VALUES ('56', '1', '3.00', '1', '2018-05-08 18:36:54', '0');
INSERT INTO `opera_price` VALUES ('57', '53', '4.00', '1', '2018-05-08 18:46:09', '0');
INSERT INTO `opera_price` VALUES ('58', '54', '1.00', '1', '2018-05-11 16:00:56', '0');
INSERT INTO `opera_price` VALUES ('59', '55', '2.00', '1', '2018-05-11 16:58:42', '0');
INSERT INTO `opera_price` VALUES ('60', '56', '3.00', '1', '2018-05-11 17:02:11', '0');
INSERT INTO `opera_price` VALUES ('61', '57', '4.00', '1', '2018-05-11 17:25:39', '0');
INSERT INTO `opera_price` VALUES ('62', '58', '5.00', '1', '2018-05-11 18:10:50', '0');
INSERT INTO `opera_price` VALUES ('63', '59', '6.00', '1', '2018-05-11 18:45:35', '0');
INSERT INTO `opera_price` VALUES ('65', '60', '50.00', '1', '2018-05-24 16:42:24', '1');
INSERT INTO `opera_price` VALUES ('66', '60', '100.00', '1', '2018-05-25 09:54:26', '0');
INSERT INTO `opera_price` VALUES ('67', '61', '100.00', '1', '2018-05-25 10:07:00', '1');
INSERT INTO `opera_price` VALUES ('68', '61', '200.00', '1', '2018-05-25 10:07:27', '0');
INSERT INTO `opera_price` VALUES ('69', '62', '1.00', '1', '2018-05-28 10:40:22', '0');
INSERT INTO `opera_price` VALUES ('70', '27', '100.00', '1', '2018-05-24 14:16:43', '1');
INSERT INTO `opera_price` VALUES ('71', '27', '200.00', '1', '2018-05-24 14:17:01', '0');
INSERT INTO `opera_price` VALUES ('72', null, '1.00', '1', '2018-06-01 18:44:19', '0');
INSERT INTO `opera_price` VALUES ('73', null, '1.00', '1', '2018-06-01 18:44:25', '0');
INSERT INTO `opera_price` VALUES ('74', null, '500.00', '1', '2018-06-08 20:16:27', '0');
INSERT INTO `opera_price` VALUES ('75', null, '500.00', '1', '2018-06-08 20:16:28', '0');
INSERT INTO `opera_price` VALUES ('76', null, '500.00', '1', '2018-06-08 20:16:29', '0');
INSERT INTO `opera_price` VALUES ('77', null, '500.00', '1', '2018-06-08 20:16:30', '0');
INSERT INTO `opera_price` VALUES ('78', null, '500.00', '1', '2018-06-08 20:16:34', '0');
INSERT INTO `opera_price` VALUES ('79', null, '500.00', '1', '2018-06-08 20:16:56', '0');
INSERT INTO `opera_price` VALUES ('80', null, '0.00', '1199', '2018-06-08 20:43:34', '0');
INSERT INTO `opera_price` VALUES ('81', null, '0.00', '1199', '2018-06-08 20:50:25', '0');
INSERT INTO `opera_price` VALUES ('82', null, '0.00', '1199', '2018-06-08 20:50:27', '0');
INSERT INTO `opera_price` VALUES ('83', null, '0.00', '1199', '2018-06-08 20:50:27', '0');
INSERT INTO `opera_price` VALUES ('84', null, '0.00', '1189', '2018-06-11 11:36:52', '0');
INSERT INTO `opera_price` VALUES ('85', null, '0.00', '1189', '2018-06-11 11:36:52', '1');
INSERT INTO `opera_price` VALUES ('86', null, '0.00', '1189', '2018-06-11 11:36:54', '0');
INSERT INTO `opera_price` VALUES ('87', null, '0.00', '1189', '2018-06-11 11:36:54', '1');
INSERT INTO `opera_price` VALUES ('88', null, '0.00', '1189', '2018-06-11 11:36:54', '0');
INSERT INTO `opera_price` VALUES ('89', null, '0.00', '1189', '2018-06-11 11:36:54', '1');
INSERT INTO `opera_price` VALUES ('90', null, '0.00', '1189', '2018-06-11 11:36:57', '0');
INSERT INTO `opera_price` VALUES ('91', null, '0.00', '1189', '2018-06-11 11:36:57', '1');
INSERT INTO `opera_price` VALUES ('92', null, '0.00', '1189', '2018-06-11 11:36:57', '0');
INSERT INTO `opera_price` VALUES ('93', null, '0.00', '1189', '2018-06-11 11:36:57', '1');
INSERT INTO `opera_price` VALUES ('94', null, '0.00', '1189', '2018-06-11 11:36:57', '0');
INSERT INTO `opera_price` VALUES ('95', null, '0.00', '1189', '2018-06-11 11:36:57', '1');
INSERT INTO `opera_price` VALUES ('96', null, '0.00', '1189', '2018-06-11 11:36:58', '0');
INSERT INTO `opera_price` VALUES ('97', null, '0.00', '1189', '2018-06-11 11:36:58', '1');
INSERT INTO `opera_price` VALUES ('98', null, '0.00', '1189', '2018-06-11 11:36:58', '0');
INSERT INTO `opera_price` VALUES ('99', null, '0.00', '1189', '2018-06-11 11:36:58', '1');
INSERT INTO `opera_price` VALUES ('100', null, '0.00', '1189', '2018-06-11 11:37:02', '0');
INSERT INTO `opera_price` VALUES ('101', null, '0.00', '1189', '2018-06-11 11:37:02', '1');
INSERT INTO `opera_price` VALUES ('102', null, '0.00', '1189', '2018-06-11 11:37:03', '0');
INSERT INTO `opera_price` VALUES ('103', null, '0.00', '1189', '2018-06-11 11:37:03', '1');
INSERT INTO `opera_price` VALUES ('104', null, '0.00', '1189', '2018-06-11 11:37:03', '0');
INSERT INTO `opera_price` VALUES ('105', null, '0.00', '1189', '2018-06-11 11:37:03', '1');
INSERT INTO `opera_price` VALUES ('106', '64', '50.00', '1189', '2018-06-11 11:42:16', '1');
INSERT INTO `opera_price` VALUES ('107', '64', '100.00', '1189', '2018-06-11 11:42:17', '0');
INSERT INTO `opera_price` VALUES ('108', '76', '50.00', '1189', '2018-06-11 11:42:17', '1');
INSERT INTO `opera_price` VALUES ('109', '76', '100.00', '1189', '2018-06-11 11:42:17', '0');
INSERT INTO `opera_price` VALUES ('110', '95', '0.00', '1189', '2018-06-11 11:42:18', '0');
INSERT INTO `opera_price` VALUES ('111', '97', '50.00', '1199', '2018-06-11 15:38:13', '1');
INSERT INTO `opera_price` VALUES ('112', '97', '100.00', '1199', '2018-06-11 15:38:16', '0');
INSERT INTO `opera_price` VALUES ('113', null, '0.00', '1', '2018-06-11 21:42:19', '0');
INSERT INTO `opera_price` VALUES ('114', null, '0.00', '1', '2018-06-11 21:42:19', '0');
INSERT INTO `opera_price` VALUES ('115', '100', '0.00', '1', '2018-06-11 21:42:20', '0');
INSERT INTO `opera_price` VALUES ('116', null, '0.00', '1', '2018-06-11 21:52:52', '0');
INSERT INTO `opera_price` VALUES ('117', null, '0.00', '1', '2018-06-11 21:52:53', '0');
INSERT INTO `opera_price` VALUES ('118', null, '1.00', '1', '2018-06-11 21:55:48', '0');
INSERT INTO `opera_price` VALUES ('119', null, '0.00', '1', '2018-06-12 09:50:46', '0');
INSERT INTO `opera_price` VALUES ('120', '105', '1.00', '1', '2018-06-12 10:06:27', '0');
INSERT INTO `opera_price` VALUES ('121', '106', '0.00', '1', '2018-06-12 10:41:51', '0');
INSERT INTO `opera_price` VALUES ('122', '107', '0.00', '1', '2018-06-12 12:26:51', '0');
INSERT INTO `opera_price` VALUES ('123', '108', '0.00', '1', '2018-06-12 14:11:45', '0');
INSERT INTO `opera_price` VALUES ('124', '109', '0.00', '1', '2018-06-12 14:23:08', '0');

-- ----------------------------
-- Table structure for `organization`
-- ----------------------------
DROP TABLE IF EXISTS `organization`;
CREATE TABLE `organization` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '机构信息表',
  `organize_id` int(11) DEFAULT NULL COMMENT '机构ID',
  `organize_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '机构名',
  `serviceProvider_id` int(11) DEFAULT NULL COMMENT '所属服务商id',
  `contacts` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '联系人',
  `disable` int(11) DEFAULT NULL COMMENT '是否停用该账号(1--停用  0--不停用)',
  `telephone` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '手机号',
  `piano_shop_num` int(11) DEFAULT NULL COMMENT '琴行总数',
  `member_num` int(11) DEFAULT NULL COMMENT '会员总数',
  `learnBook_num` int(11) DEFAULT NULL COMMENT '教材数',
  `operaBook_num` int(11) DEFAULT NULL COMMENT '曲谱数',
  `boss_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '法人名字',
  `boos_telephone` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '法人电话',
  `income` decimal(11,2) DEFAULT NULL COMMENT '收入',
  `area` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '区域',
  `detail_address` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '详细地址',
  `remind` int(11) DEFAULT NULL COMMENT '一键提醒(1--开启  0--关闭)',
  `fengmian_picture` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '封面图片',
  `IDCard_picture` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '身份证图片',
  `withdraw_balance` decimal(11,2) DEFAULT NULL COMMENT '可提现余额',
  `balance` decimal(11,2) DEFAULT NULL COMMENT '余额',
  `register_time` datetime DEFAULT NULL COMMENT '注册时间',
  `member_time` datetime DEFAULT NULL COMMENT '会员时间',
  `examine_time` datetime DEFAULT NULL COMMENT '审核时间',
  `auditor` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '审核人',
  `organize_type` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '机构类型',
  `divide_money_rate` decimal(11,2) DEFAULT NULL COMMENT '分成比例',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `business_license_picture` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '营业执照图片',
  `log_out` int(11) DEFAULT '0' COMMENT '是否注销(1--注销  0--未注销)',
  `head_url` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT 'icoin--机构图标',
  `consump_money` decimal(10,2) DEFAULT NULL COMMENT '消费金额',
  `recharge_money` decimal(10,2) DEFAULT NULL COMMENT '充值金额',
  `organize_scope` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '机构规模',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of organization
-- ----------------------------
INSERT INTO `organization` VALUES ('1', '1', '机构1', '1', '小明', '1', '12334535435', '2', '2', '2', '2', null, '123435435', '100.00', '10|10|10', '西城新区', '1', null, 'http://106.14.25.203/F/Image/12345678/1526030729031.png', '11.00', '11.00', '2018-04-03 18:39:59', '2018-04-05 18:40:05', '2018-04-11 18:40:18', '大明', '大', '0.50', '2018-04-14 18:41:40', 'http://106.14.25.203/F/Image/12345678/1526030729031.png', '0', 'http://47.100.11.15/F/Image/org1.jpg', '345.00', '1.00', '规模500人');
INSERT INTO `organization` VALUES ('2', '2', '机构22', '1', '小王', '1', '666666666', '3', '2', '3', '2', '22', '77777777', '200.00', '10|160|1373', '浦东新区', '1', '', 'http://h5.9shadow.com/F//pengHuaImg/7dadeaecf9f242c9995a9a014d90b4fd.png', '11.00', '20.00', '2018-05-03 18:28:10', '2018-05-05 18:28:15', '2018-05-06 18:28:18', 'qqq', 'da', '0.60', '2018-05-16 18:28:34', 'http://47.100.11.15/F/Image/null/1529412838235.png', '0', 'http://47.100.11.15/F/Image/org2.jpg', '32.00', '2.00', '规模500人');
INSERT INTO `organization` VALUES ('3', '3', '机构3', '1', '小红s', '1', '222222222223', '23', '23', '23', '23', 'aa', '2132142154353', '20.00', '12|181|1558', '西城新区1', '1', 'http://47.100.11.15/F/Image/null/1529551169753.png', 'http://106.14.25.203/F/Image/12345678/1526030729031.png', '50.00', '20.00', '2018-05-18 18:30:20', '2018-05-01 18:30:46', '2018-05-04 18:30:49', 'sfds', 's', '0.60', '2018-05-17 18:30:58', 'http://106.14.25.203/F/Image/12345678/1526030729031.png', '0', 'http://47.100.11.15/F/Image/org3.jpg', '500.00', '200.00', '规模500人');
INSERT INTO `organization` VALUES ('4', '4', '机构4', '1', '小张', '0', '3234324342', '23', '33', '10', '35', null, '3242342', '200.00', '上海', '浦东新区', '1', null, 'http://106.14.25.203/F/Video/12345678/1526035447123.jpg', '60.00', '100.00', '2018-05-01 10:30:09', '2018-05-22 10:30:12', '2018-05-19 10:30:15', 'dfa', 'sfdf', '0.70', '2018-05-22 10:30:31', 'http://106.14.25.203/F/Video/12345678/1526035447123.jpg', '0', 'http://47.100.11.15/F/Image/org3.jpg', '100.00', '50.00', '规模500人');
INSERT INTO `organization` VALUES ('5', '5', '机构5', '1', '小李', '0', '3243424342', '30', '25', '10', '50', null, '43534535', '30.00', '广州', '西城新区', '1', null, 'http://h5.9shadow.com/F//pengHuaImg/31ef9aca3b5342af83d80c8420493ba0.png', '100.00', '50.00', '2018-05-01 10:36:37', '2018-05-18 10:36:40', '2018-05-09 10:36:44', 'ddd', 'dd', '0.60', '2018-05-22 10:36:54', 'http://h5.9shadow.com/F//pengHuaImg/31ef9aca3b5342af83d80c8420493ba0.png', '0', 'http://47.100.11.15/F/Image/org2.jpg', '50.00', '100.00', '规模500人');
INSERT INTO `organization` VALUES ('6', null, '3333', null, '44444', null, '22222222', null, null, null, null, null, null, null, '6666', '777777', null, null, 'http://192.168.1.69/F/Image/null/1528362886220.png', null, null, null, null, null, null, null, null, null, 'http://192.168.1.69/F/Image/null/1528362892077.png', '0', 'http://47.100.11.15/F/Image/org1.jpg', null, null, null);
INSERT INTO `organization` VALUES ('7', null, 'aaaaa', null, 'aaa', null, '333333', null, null, null, null, null, null, null, '33', '333333', null, null, '', null, null, null, null, null, null, null, null, null, '', '0', 'http://47.100.11.15/F/Image/org2.jpg', null, null, null);
INSERT INTO `organization` VALUES ('9', null, 'sfd', null, 'sfdsfs', null, '15194491660', null, null, null, null, null, null, null, 'sddsfs', 'ssss', null, null, '', null, null, null, null, null, null, null, null, null, '', '0', 'http://47.100.11.15/F/Image/org3.jpg', null, null, null);
INSERT INTO `organization` VALUES ('10', null, 'aaaa', null, 'aa', null, '15194491660', null, null, null, null, null, null, null, 'aa', 'aa', null, null, '', null, null, null, null, null, null, null, null, null, '', '0', 'http://47.100.11.15/F/Image/org1.jpg', null, null, null);
INSERT INTO `organization` VALUES ('11', null, 'dfg', null, 'dfg', null, '15194491660', null, null, null, null, null, null, null, 'dfg', 'dfdsf', null, null, 'http://192.168.1.71/F/Image/null/1528685939604.png', null, null, null, null, null, null, null, null, null, 'http://192.168.1.71/F/Image/null/1528685941820.png', '0', 'http://47.100.11.15/F/Image/org2.jpg', null, null, null);
INSERT INTO `organization` VALUES ('12', null, 'fdg', null, 'dfg', null, '17608478864', null, null, null, null, null, null, null, 'dfg', 'dgdg', null, null, 'http://192.168.1.71/F/Image/null/1528767608244.png', null, null, null, null, null, null, null, null, null, 'http://192.168.1.71/F/Image/null/1528767611225.png', '0', 'http://47.100.11.15/F/Image/org2.jpg', null, null, null);
INSERT INTO `organization` VALUES ('13', null, '的广泛地', null, '公告', null, '15821941486', null, null, null, null, null, null, null, '滚滚滚', '哈哈哈', null, null, 'http://47.100.11.15/F/Image/null/1528772330085.png', null, null, null, null, null, null, null, null, null, 'http://47.100.11.15/F/Image/null/1528772334493.png', '0', 'http://47.100.11.15/F/Image/org1.jpg', null, null, null);
INSERT INTO `organization` VALUES ('14', null, '第三方的', null, '的身份', null, '17621829059', null, null, null, null, null, null, null, '上海', '御桥', null, null, 'http://47.100.11.15/F/Image/null/1528774920129.png', null, null, null, null, null, null, null, null, null, 'http://47.100.11.15/F/Image/null/1528774923470.png', '0', 'http://47.100.11.15/F/Image/org3.jpg', null, null, null);

-- ----------------------------
-- Table structure for `organization_textbook`
-- ----------------------------
DROP TABLE IF EXISTS `organization_textbook`;
CREATE TABLE `organization_textbook` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '机构和教材关系表',
  `organization_id` int(11) DEFAULT NULL COMMENT '机构id',
  `textbook_id` int(11) DEFAULT NULL COMMENT '教材id',
  `is_delete` int(11) DEFAULT NULL COMMENT '是否删除(0--不删除 1--删除)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of organization_textbook
-- ----------------------------

-- ----------------------------
-- Table structure for `parameters_set`
-- ----------------------------
DROP TABLE IF EXISTS `parameters_set`;
CREATE TABLE `parameters_set` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '参数设置表',
  `name` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '参数名',
  `value` decimal(10,2) DEFAULT NULL COMMENT '参数值',
  `type` int(11) DEFAULT NULL COMMENT '参数值:1免手续费提现最少,2不满金额手续费,3琴行创建老师消耗，4熊掌充换现金比例',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of parameters_set
-- ----------------------------
INSERT INTO `parameters_set` VALUES ('1', '免手续费提现最少', '100.00', '1');
INSERT INTO `parameters_set` VALUES ('2', '不满金额手续费', '2.00', '2');
INSERT INTO `parameters_set` VALUES ('3', '琴行创建老师消耗', '22.00', '3');
INSERT INTO `parameters_set` VALUES ('4', '熊掌充换现金比例', '33.00', '4');

-- ----------------------------
-- Table structure for `parameter_set`
-- ----------------------------
DROP TABLE IF EXISTS `parameter_set`;
CREATE TABLE `parameter_set` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '参数设置',
  `content` decimal(10,0) DEFAULT NULL COMMENT '具体参数值',
  `type` int(11) DEFAULT NULL COMMENT '1--服务商会费 2-机构会费 3-琴行会费  4,会员试用时间5,会费纳税周期6,逾期可提现金额扣除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of parameter_set
-- ----------------------------
INSERT INTO `parameter_set` VALUES ('1', '500', '1');
INSERT INTO `parameter_set` VALUES ('2', '400', '2');
INSERT INTO `parameter_set` VALUES ('3', '300', '3');
INSERT INTO `parameter_set` VALUES ('4', '10', '4');
INSERT INTO `parameter_set` VALUES ('5', '6', '5');
INSERT INTO `parameter_set` VALUES ('6', '10', '6');

-- ----------------------------
-- Table structure for `parents`
-- ----------------------------
DROP TABLE IF EXISTS `parents`;
CREATE TABLE `parents` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '家长信息表',
  `parent_id` int(11) DEFAULT NULL COMMENT '家长ID',
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '家长姓名',
  `teacher_id` int(11) DEFAULT NULL COMMENT '老师编号',
  `referee_id` int(11) DEFAULT NULL COMMENT '推荐人ID',
  `gender` int(11) DEFAULT NULL COMMENT '1-- 男  0--女',
  `children_num` int(11) DEFAULT NULL COMMENT '孩子数',
  `member_level` int(11) DEFAULT NULL COMMENT '会员等级',
  `telephone` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '手机号',
  `area` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '区域',
  `address` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '详细地址',
  `remind` int(11) DEFAULT NULL COMMENT '一键提醒(1--开启 0--关闭)',
  `state` int(11) DEFAULT NULL COMMENT '状态(1-- 正常  0--锁定)',
  `register_time` datetime DEFAULT NULL COMMENT '注册时间',
  `last_log_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `head_url` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '用户头像',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of parents
-- ----------------------------
INSERT INTO `parents` VALUES ('1', '1', '家长111', '1', '23', '1', '3', '2', '32324354545', 'dfadfadf', 'dfafd vvvvvv', '1', '1', '2018-04-04 19:00:57', '2018-04-17 19:01:02', null);
INSERT INTO `parents` VALUES ('2', '2', 'ly', '1', '23', '1', '3', '2', '32324354545', 'dfadfadf', 'dfafd vvvvvv', '1', '1', '2018-04-04 19:00:57', '2018-04-17 19:01:02', 'http://h5.9shadow.com/F//pengHuaImg/7d9e5f668d7945b18da47fc5aafad116.png');
INSERT INTO `parents` VALUES ('4', null, '王家长', '2', null, null, null, null, '17699406195', '新疆 乌鲁木齐 沙依巴克区', '123', null, null, '2018-05-30 14:50:48', null, 'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eq9J0Yn1Ver1dTk12fKybfiaa7TKpC439exDG3L3C5IjfUWreN7ibnQicVicHr90oaPIibznJ52Lxb27EA/132');
INSERT INTO `parents` VALUES ('6', null, null, '1', '1', null, null, null, '15221351482', '1北京', '1', null, null, '2018-06-07 14:12:02', null, null);
INSERT INTO `parents` VALUES ('7', '3', '家长22', '1', '23', '1', '2', '2', '32324354545', 'dfadfadf', 'dfafd vvvvvv', '1', '1', '2018-04-04 19:00:57', '2018-04-17 19:01:02', 'http://h5.9shadow.com/F//pengHuaImg/7d9e5f668d7945b18da47fc5aafad116.png');
INSERT INTO `parents` VALUES ('8', null, '李勇', null, null, null, null, null, '15821941486', '河南 开封 顺河区', '都是对的多所', null, null, '2018-06-14 11:04:20', null, null);
INSERT INTO `parents` VALUES ('9', null, '法国海军', null, null, null, null, null, '18516760024', '河南 信阳 固始县', '北京 东城', null, '0', '2018-06-14 19:13:30', null, null);

-- ----------------------------
-- Table structure for `phone_code`
-- ----------------------------
DROP TABLE IF EXISTS `phone_code`;
CREATE TABLE `phone_code` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '手机验证码表',
  `phone` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '手机号',
  `code` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '验证码',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `expired_time` datetime DEFAULT NULL COMMENT '过期时间',
  `other` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '其他',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=91 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of phone_code
-- ----------------------------
INSERT INTO `phone_code` VALUES ('1', '17680251245', '325325', '2018-05-16 10:07:31', '2018-05-16 10:17:31', null);
INSERT INTO `phone_code` VALUES ('16', '13676548289', '815953', '2018-06-05 09:09:54', '2018-06-05 09:19:54', null);
INSERT INTO `phone_code` VALUES ('17', '15821941486', '724542', '2018-06-06 10:38:54', '2018-06-06 10:48:54', null);
INSERT INTO `phone_code` VALUES ('18', '15221351482', '134664', '2018-06-07 10:19:35', '2018-06-08 10:29:35', null);
INSERT INTO `phone_code` VALUES ('21', '15194491660', '666666', '2018-06-07 19:40:50', '2018-06-23 19:50:50', null);
INSERT INTO `phone_code` VALUES ('22', '15821941486', '325645', '2018-06-07 20:31:42', '2018-06-07 20:41:42', null);
INSERT INTO `phone_code` VALUES ('23', '15821941486', '785481', '2018-06-07 21:05:43', '2018-06-07 21:15:43', null);
INSERT INTO `phone_code` VALUES ('24', '15773803298', '233394', '2018-06-08 16:44:02', '2018-06-08 16:54:02', null);
INSERT INTO `phone_code` VALUES ('25', '15773803298', '834872', '2018-06-08 17:23:25', '2018-06-18 17:33:25', null);
INSERT INTO `phone_code` VALUES ('26', '13676548289', '455745', '2018-06-09 09:59:50', '2018-06-09 10:09:50', null);
INSERT INTO `phone_code` VALUES ('27', '15194491660', '563718', '2018-06-11 10:30:00', '2018-06-11 10:40:00', null);
INSERT INTO `phone_code` VALUES ('28', '15194491660', '115267', '2018-06-11 10:30:39', '2018-06-11 10:40:39', null);
INSERT INTO `phone_code` VALUES ('29', '15292864264', '169413', '2018-06-11 10:40:46', '2018-06-11 10:50:46', null);
INSERT INTO `phone_code` VALUES ('30', '15194491660', '876875', '2018-06-11 10:41:30', '2018-06-17 10:51:30', null);
INSERT INTO `phone_code` VALUES ('31', '15292864264', '891724', '2018-06-11 11:06:48', '2018-06-11 11:16:48', null);
INSERT INTO `phone_code` VALUES ('32', '15292864264', '124271', '2018-06-11 11:10:34', '2018-06-11 11:20:34', null);
INSERT INTO `phone_code` VALUES ('33', '18262817579', '764376', '2018-06-11 13:54:46', '2018-06-11 14:04:46', null);
INSERT INTO `phone_code` VALUES ('34', '15821941486', '372839', '2018-06-11 13:57:30', '2018-06-11 14:07:30', null);
INSERT INTO `phone_code` VALUES ('35', '15821941486', '199611', '2018-06-11 14:05:33', '2018-06-11 14:15:33', null);
INSERT INTO `phone_code` VALUES ('36', '15821941486', '734444', '2018-06-11 19:25:54', '2018-06-11 19:35:54', null);
INSERT INTO `phone_code` VALUES ('37', '15821941486', '439679', '2018-06-11 20:23:32', '2018-06-11 20:33:32', null);
INSERT INTO `phone_code` VALUES ('38', '15821941486', '131794', '2018-06-11 21:21:51', '2018-06-11 21:31:51', null);
INSERT INTO `phone_code` VALUES ('39', '15821941486', '776145', '2018-06-11 21:31:20', '2018-06-11 21:41:20', null);
INSERT INTO `phone_code` VALUES ('40', '17608478864', '137319', '2018-06-12 09:39:48', '2018-06-12 09:49:48', null);
INSERT INTO `phone_code` VALUES ('41', '15821941486', '733527', '2018-06-12 09:42:22', '2018-06-12 09:52:22', null);
INSERT INTO `phone_code` VALUES ('42', '15821941486', '914385', '2018-06-12 10:03:44', '2018-06-12 10:13:44', null);
INSERT INTO `phone_code` VALUES ('43', '15821941486', '149296', '2018-06-12 10:07:24', '2018-06-12 10:17:24', null);
INSERT INTO `phone_code` VALUES ('44', '15821941486', '877691', '2018-06-12 10:46:29', '2018-06-12 10:56:29', null);
INSERT INTO `phone_code` VALUES ('45', '15821941486', '576671', '2018-06-12 10:58:19', '2018-06-12 11:08:19', null);
INSERT INTO `phone_code` VALUES ('46', '17621829059', '815887', '2018-06-12 11:41:12', '2018-06-12 11:51:12', null);
INSERT INTO `phone_code` VALUES ('47', '15194491660', '422856', '2018-06-13 15:06:58', '2018-06-13 15:16:58', null);
INSERT INTO `phone_code` VALUES ('48', '13177143948', '541626', '2018-06-13 15:38:39', '2018-06-13 15:48:39', null);
INSERT INTO `phone_code` VALUES ('49', '15194491660', '125756', '2018-06-13 16:03:21', '2018-06-13 16:13:21', null);
INSERT INTO `phone_code` VALUES ('50', '13177143948', '295569', '2018-06-13 16:03:55', '2018-06-13 16:13:55', null);
INSERT INTO `phone_code` VALUES ('51', '13177143948', '261718', '2018-06-13 16:46:54', '2018-06-13 16:56:54', null);
INSERT INTO `phone_code` VALUES ('52', '13177143948', '277991', '2018-06-13 16:49:58', '2018-06-13 16:59:58', null);
INSERT INTO `phone_code` VALUES ('53', '13177143948', '181261', '2018-06-13 16:59:11', '2018-06-13 17:09:11', null);
INSERT INTO `phone_code` VALUES ('54', '18516760024', '734616', '2018-06-13 17:22:33', '2018-06-13 17:32:33', null);
INSERT INTO `phone_code` VALUES ('55', '15821941486', '196235', '2018-06-13 18:02:37', '2018-06-13 18:12:37', null);
INSERT INTO `phone_code` VALUES ('56', '15821941486', '711959', '2018-06-13 18:21:39', '2018-06-13 18:31:39', null);
INSERT INTO `phone_code` VALUES ('57', '15821941486', '589427', '2018-06-14 10:32:33', '2018-06-14 10:42:33', null);
INSERT INTO `phone_code` VALUES ('58', '15821941486', '358825', '2018-06-14 10:41:06', '2018-06-14 10:51:06', null);
INSERT INTO `phone_code` VALUES ('59', '15821941486', '693212', '2018-06-14 10:55:54', '2018-06-14 11:05:54', null);
INSERT INTO `phone_code` VALUES ('60', '15821941486', '511156', '2018-06-14 11:03:24', '2018-06-14 11:13:24', null);
INSERT INTO `phone_code` VALUES ('61', '15221351482', '115133', '2018-06-14 11:10:26', '2018-06-14 11:20:26', null);
INSERT INTO `phone_code` VALUES ('62', '15194491660', '555864', '2018-06-14 15:52:16', '2018-06-14 16:02:16', null);
INSERT INTO `phone_code` VALUES ('63', '15221351482', '883638', '2018-06-14 16:42:37', '2018-06-14 16:52:37', null);
INSERT INTO `phone_code` VALUES ('64', '15221351482', '788458', '2018-06-14 16:51:24', '2018-06-14 17:01:24', null);
INSERT INTO `phone_code` VALUES ('65', '15221351482', '523248', '2018-06-14 16:53:46', '2018-06-14 17:03:46', null);
INSERT INTO `phone_code` VALUES ('66', '15194491660', '212366', '2018-06-14 19:05:03', '2018-06-14 19:15:03', null);
INSERT INTO `phone_code` VALUES ('67', '18516760024', '538319', '2018-06-14 19:12:24', '2018-06-14 19:22:24', null);
INSERT INTO `phone_code` VALUES ('68', '15221351482', '246781', '2018-06-14 20:35:35', '2018-06-14 20:45:35', null);
INSERT INTO `phone_code` VALUES ('69', '15821941486', '434342', '2018-06-14 20:37:32', '2018-06-14 20:47:32', null);
INSERT INTO `phone_code` VALUES ('70', '15821941486', '781797', '2018-06-15 11:35:04', '2018-06-15 11:45:04', null);
INSERT INTO `phone_code` VALUES ('71', '15194491660', '339885', '2018-06-19 10:45:34', '2018-06-19 10:55:34', null);
INSERT INTO `phone_code` VALUES ('72', '15194491660', '128421', '2018-06-19 10:55:23', '2018-06-19 11:05:23', null);
INSERT INTO `phone_code` VALUES ('73', '15821941486', '594172', '2018-06-19 11:53:25', '2018-06-19 12:03:25', null);
INSERT INTO `phone_code` VALUES ('74', '15821941486', '332351', '2018-06-19 14:50:25', '2018-06-19 15:00:25', null);
INSERT INTO `phone_code` VALUES ('75', '15821941486', '242479', '2018-06-19 15:27:32', '2018-06-19 15:37:32', null);
INSERT INTO `phone_code` VALUES ('76', '15821941486', '624278', '2018-06-19 15:30:07', '2018-06-19 15:40:07', null);
INSERT INTO `phone_code` VALUES ('77', '151944916601', '214119', '2018-06-19 15:49:52', '2018-06-19 15:59:52', null);
INSERT INTO `phone_code` VALUES ('78', '15194491660', '953467', '2018-06-19 15:52:32', '2018-06-19 16:02:32', null);
INSERT INTO `phone_code` VALUES ('79', '15821941486', '837534', '2018-06-19 17:48:29', '2018-06-19 17:58:29', null);
INSERT INTO `phone_code` VALUES ('80', '15821941486', '417639', '2018-06-19 17:50:26', '2018-06-19 18:00:26', null);
INSERT INTO `phone_code` VALUES ('81', '15821941486', '689577', '2018-06-20 09:39:25', '2018-06-20 09:49:25', null);
INSERT INTO `phone_code` VALUES ('82', '15221351482', '217844', '2018-06-20 09:45:21', '2018-06-20 09:55:21', null);
INSERT INTO `phone_code` VALUES ('83', '15821941486', '967841', '2018-06-20 10:24:36', '2018-06-20 10:34:36', null);
INSERT INTO `phone_code` VALUES ('84', '15821941486', '432841', '2018-06-20 11:20:01', '2018-06-20 11:30:01', null);
INSERT INTO `phone_code` VALUES ('85', '15221351482', '897293', '2018-06-20 11:22:29', '2018-06-20 11:32:29', null);
INSERT INTO `phone_code` VALUES ('86', '15821941486', '299628', '2018-06-20 11:25:19', '2018-06-20 11:35:19', null);
INSERT INTO `phone_code` VALUES ('87', '15821941486', '522599', '2018-06-20 11:40:51', '2018-06-20 11:50:51', null);
INSERT INTO `phone_code` VALUES ('88', '15821941486', '331473', '2018-06-20 11:55:18', '2018-06-20 12:05:18', null);
INSERT INTO `phone_code` VALUES ('89', '17680251245', '573499', '2018-06-20 12:31:32', '2018-06-20 12:41:32', null);
INSERT INTO `phone_code` VALUES ('90', '15821941486', '466663', '2018-06-20 16:10:48', '2018-06-20 16:20:48', null);

-- ----------------------------
-- Table structure for `piano_shop`
-- ----------------------------
DROP TABLE IF EXISTS `piano_shop`;
CREATE TABLE `piano_shop` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '琴行信息表',
  `piano_shop_id` int(11) DEFAULT NULL COMMENT '琴行ID',
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '琴行名',
  `contacts` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '联系人',
  `belongto_orginaze` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '琴行所属机构名',
  `belongto_orginazeID` int(11) DEFAULT NULL COMMENT '琴行所属机构ID',
  `telephone` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '手机号',
  `create_teacher_totalNum` int(11) DEFAULT NULL COMMENT '创建老师总数',
  `now_teacherNum` int(11) DEFAULT NULL COMMENT '现有老师数',
  `free_teaherNum` int(11) DEFAULT NULL COMMENT '免费老师数',
  `student_num` int(11) DEFAULT '0' COMMENT '在校学生数',
  `legal_name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '法人姓名',
  `boss_telephone` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '法人电话',
  `income_money` decimal(10,2) DEFAULT '0.00' COMMENT '分红总收入',
  `consump_money` decimal(10,2) DEFAULT '0.00' COMMENT '消费金额',
  `area` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '区域',
  `address` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '详细地址',
  `remind` int(11) DEFAULT NULL COMMENT '一键开启',
  `state` int(11) DEFAULT '1' COMMENT '状态(1--锁定  0--解锁  2 不通过)',
  `integral` int(11) DEFAULT '0' COMMENT '积分',
  `fengmian_picture` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '封面图片',
  `IDcard_picture` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '身份证图片',
  `business_license_picture` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '营业执照图片',
  `transition_picture` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '过渡界面图片',
  `recharge_num` decimal(10,2) DEFAULT '0.00' COMMENT '充值总额',
  `withdrawals_balance` decimal(10,2) DEFAULT '0.00' COMMENT '可提现金额',
  `register_time` datetime DEFAULT NULL COMMENT '注册时间',
  `memeber_time` datetime DEFAULT NULL COMMENT '会员时间',
  `examine_time` datetime DEFAULT NULL COMMENT '审核时间',
  `auditor` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '审核人',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `piano_shop_scale` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '琴行规模',
  `shop_scale_id` int(11) DEFAULT NULL COMMENT '琴行规模对应ID',
  `piano_shop_type` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '琴行类别',
  `divide_money_rate` decimal(10,2) DEFAULT NULL COMMENT '分成比例',
  `promoter_rate` decimal(10,2) DEFAULT NULL COMMENT '推广员分成比',
  `log_out` int(11) DEFAULT '0' COMMENT '是否注销(1--注销  0--未注销)',
  `balance` decimal(10,2) DEFAULT '0.00' COMMENT '余额',
  `head_url` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '琴行图标---icon',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of piano_shop
-- ----------------------------
INSERT INTO `piano_shop` VALUES ('1', '1', '钢琴室ss', '小红', '大琴行', '1', '123456789', '20', '10', '5', '30', '是的', '789456789', '2365.00', '235.00', '15|226|1910', '浦东新区1', '1', '1', '23', null, 'http://47.100.11.15/F/Image/null/1529492694455.png', 'http://47.100.11.15/F/Image/null/1529551218074.png', 'http://47.100.11.15/F/Image/null/1529570619826.jpg', '100.00', '17.00', '2018-04-04 17:35:08', '2018-04-06 17:35:15', '2018-04-08 17:35:20', '小红', '2018-04-16 17:35:36', '100', '1', 'dfadf', '0.50', '0.10', '0', '100.00', 'http://47.100.11.15/F/Image/5.jpg');
INSERT INTO `piano_shop` VALUES ('2', '2', '钢琴室2', 'FE', '34', '1', null, null, null, null, null, null, null, null, null, '10|10|10', null, null, '0', null, null, null, null, 'http://47.100.11.15/F/Image/1.jpg', null, null, null, null, null, null, null, null, null, null, null, null, '0', null, 'http://47.100.11.15/F/Image/97.jpg');
INSERT INTO `piano_shop` VALUES ('3', null, '钢琴室', '小红', '大琴行', null, '15194491660', '20', '10', '5', '30', 'ss', '789456789', '2365.00', '235.00', '11|167|1434', '浦东新区', '1', '1', '23', '', 'dfadfafdfa', 'dfadafdf', null, '100.00', '50.00', '2018-04-04 17:35:08', '2018-04-06 17:35:15', '2018-04-08 17:35:20', '小红', '2018-04-16 17:35:36', '100', '1', 'dfadf', '0.50', '0.10', '0', '100.00', 'http://47.100.11.15/F/Image/2.jpg');
INSERT INTO `piano_shop` VALUES ('4', null, 'aaaaaa', null, null, '1', null, null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, null, 'http://47.100.11.15/F/Image/null/1528885483618.png', null, null, null, null, null, null, null, null, null, null, null, null, '0', null, 'http://47.100.11.15/F/Image/1.jpg');
INSERT INTO `piano_shop` VALUES ('5', null, 'bbbbbb', null, null, '5', null, null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', null, null);
INSERT INTO `piano_shop` VALUES ('8', null, '1', '1', null, '1', '1', null, null, null, null, '1', '1', null, null, '1', '1', null, '0', null, null, '\"http://47.100.10.151:8080/F//Image/39e7d967d72ef1cd89589d4d6e797e16.png\"', '\"http://47.100.10.151:8080/F//Image/35c524565170502706fc7e5dc52a31e4.png\"', null, null, null, null, null, null, null, null, '1', null, '架子鼓', null, null, null, null, null);
INSERT INTO `piano_shop` VALUES ('10', null, '李勇', '身份输入法', null, null, '3434345645', null, null, null, null, '人的托管人', '1585569965', null, null, '河南 安阳 殷都区', '规范化的反复听', null, '0', null, null, 'http://47.100.11.15/F/Image/d290ea29b254aebdd951ca7fb679656e.png', 'http://47.100.11.15/F/Image/377e4fa3582de5502b8703e65d0a232d.png', null, null, null, null, null, null, null, null, '发放', null, '架子鼓', null, null, null, null, null);
INSERT INTO `piano_shop` VALUES ('11', null, '大风琴行', '俞钦华', null, null, '15821941486', null, null, null, null, '俞钦华', '15821941486', null, null, '江苏 无锡 宜兴市', '御桥', null, '0', null, null, 'http://47.100.11.15/F/Image/6ea21945b36af8f78f4ad1d9a5665f64.png', 'http://47.100.11.15/F/Image/d5e311c8e22bcb9958a6f8c68f1f89f6.png', null, null, null, null, null, null, null, null, '25', null, '架子鼓', null, null, null, null, null);
INSERT INTO `piano_shop` VALUES ('12', null, '民生琴行', '俞钦华', null, '0', '15821941486', null, null, null, null, '俞钦华', '15821941486', null, null, '江苏 常州 戚墅堰区', '得瑟得瑟', null, '0', null, null, 'http://47.100.11.15/F/Image/5631fa1201d34dc142eb2021e06480d6.png', 'http://47.100.11.15/F/Image/7516cfe277d3ba99f4cae5c65e4f480.png', null, null, null, null, null, null, null, null, '55', null, '架子鼓', null, null, null, null, null);
INSERT INTO `piano_shop` VALUES ('13', null, '哈哈哈', '交换机', null, null, '15252525252', null, null, null, null, '好看就看', '15895252582', null, null, '河南 洛阳 涧西区', '好久好久好久', null, '0', null, null, 'http://47.100.11.15/F/Image/e514f2e95ce29edf61a1c8283d5bd947.png', 'http://47.100.11.15/F/Image/317ae72b74d3c02e5f0e848f5ec09510.png', null, null, null, null, null, null, null, null, '25', null, '架子鼓', null, null, null, null, null);
INSERT INTO `piano_shop` VALUES ('14', null, '海门琴行', '李勇', null, null, '15821941486', null, null, null, null, '林永', '15254952555', null, null, '黑龙江 大兴安岭 塔河县', '范德萨发达', null, '0', null, null, 'http://47.100.11.15/F/Image/15207cec1010d380a8c84ad50a00b7dd.png', 'http://47.100.11.15/F/Image/f147cbbb6025aa5211a91621a71408d6.png', null, null, null, null, null, null, null, null, '15', null, '架子鼓', null, null, null, null, null);

-- ----------------------------
-- Table structure for `piano_shop_scale`
-- ----------------------------
DROP TABLE IF EXISTS `piano_shop_scale`;
CREATE TABLE `piano_shop_scale` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '琴行规模信息表',
  `type` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '琴行规模类型',
  `max_teacher_num` int(11) DEFAULT NULL COMMENT '最大老师数量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of piano_shop_scale
-- ----------------------------

-- ----------------------------
-- Table structure for `player_classify`
-- ----------------------------
DROP TABLE IF EXISTS `player_classify`;
CREATE TABLE `player_classify` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'app玩家新建分类表---分类id',
  `player_id` int(11) DEFAULT NULL COMMENT '玩家id',
  `classify_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '分类名称(不能相同)',
  `is_delete` int(11) DEFAULT '0' COMMENT '是否删除标志位(0--不删除 1---删除)',
  `opera_count` int(11) DEFAULT '0' COMMENT '分类下曲谱数目',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of player_classify
-- ----------------------------

-- ----------------------------
-- Table structure for `player_opera`
-- ----------------------------
DROP TABLE IF EXISTS `player_opera`;
CREATE TABLE `player_opera` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键 玩家-曲谱表',
  `player_id` int(11) DEFAULT NULL COMMENT '玩家id外键',
  `opera_id` int(11) DEFAULT NULL COMMENT '曲谱id外键',
  `price_id` int(11) DEFAULT NULL COMMENT '价格表id',
  `cratetime` datetime DEFAULT NULL COMMENT '购买时间',
  `expiretime` datetime DEFAULT NULL COMMENT '到期时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of player_opera
-- ----------------------------
INSERT INTO `player_opera` VALUES ('1', '1', '1', '1', '2018-04-27 14:33:53', '2018-04-27 17:33:55');

-- ----------------------------
-- Table structure for `practice_integral`
-- ----------------------------
DROP TABLE IF EXISTS `practice_integral`;
CREATE TABLE `practice_integral` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '联系积分表',
  `practice_score` decimal(10,0) DEFAULT NULL COMMENT '联系评分',
  `get_integral` decimal(10,0) DEFAULT NULL COMMENT '获得积分',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of practice_integral
-- ----------------------------

-- ----------------------------
-- Table structure for `recharge_detail`
-- ----------------------------
DROP TABLE IF EXISTS `recharge_detail`;
CREATE TABLE `recharge_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '充值明细信息表',
  `trad_no` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '订单号',
  `user_id` int(11) DEFAULT NULL COMMENT '6个表的用户ID',
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '姓名',
  `role` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '角色0总管理，1服务商，2机构，3琴行，4老师,5家长，6学生',
  `before_recharge` decimal(10,0) DEFAULT NULL COMMENT '充值前金额',
  `after_recharge` decimal(10,0) DEFAULT NULL COMMENT '剩余余额',
  `recharge_money` decimal(10,0) DEFAULT NULL COMMENT '充值金额',
  `state` int(11) DEFAULT NULL COMMENT '支付状态0已支付1未支付',
  `recharge_object` decimal(10,0) DEFAULT NULL COMMENT '到账金额',
  `recharge_type` int(11) DEFAULT NULL COMMENT '支付方式(1--微信 2--支付宝)',
  `recharge_time` datetime DEFAULT NULL COMMENT '充值时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of recharge_detail
-- ----------------------------
INSERT INTO `recharge_detail` VALUES ('1', null, '1', 'dfsf', '1', '12', '24', '23', null, '2', '1', '2018-05-24 08:28:58');
INSERT INTO `recharge_detail` VALUES ('2', null, '1', '2fgf', '2', '23', '45', '26', null, '2', '2', '2018-05-24 12:28:58');
INSERT INTO `recharge_detail` VALUES ('3', null, '1', '3', '3', '12', '24', '23', null, '2', '1', '2018-05-24 05:28:28');
INSERT INTO `recharge_detail` VALUES ('4', null, '1', '2fgf', '2', '23', '45', '26', null, '2', '2', '2018-04-25 15:28:58');
INSERT INTO `recharge_detail` VALUES ('5', '061511251413396', '1', 'Admin3', '1', null, null, '23', null, null, '2', '2018-06-15 11:25:15');
INSERT INTO `recharge_detail` VALUES ('6', '061511271119602', '1', 'Admin3', '1', null, null, '11', null, null, '2', '2018-06-15 11:27:12');
INSERT INTO `recharge_detail` VALUES ('7', '061511425193088', '1', 'Admin1', '1', null, null, '23', null, null, '2', '2018-06-15 11:42:52');
INSERT INTO `recharge_detail` VALUES ('8', '06151144241224', '1', 'Admin1', '1', null, null, '333', null, null, '2', '2018-06-15 11:44:24');
INSERT INTO `recharge_detail` VALUES ('9', '06151145351064', '1', 'Admin1', '1', null, null, '23', null, null, '2', '2018-06-15 11:45:35');
INSERT INTO `recharge_detail` VALUES ('10', '061511473912974', '1', 'Admin2', '1', null, null, '11', null, null, '2', '2018-06-15 11:47:40');
INSERT INTO `recharge_detail` VALUES ('11', '06151151586023', '1', 'Admin2', '1', null, null, '23', null, null, '1', '2018-06-15 11:51:59');
INSERT INTO `recharge_detail` VALUES ('12', '061511531214353', '1', 'Admin2', '1', null, null, '23', null, null, '2', '2018-06-15 11:53:30');
INSERT INTO `recharge_detail` VALUES ('13', '06151201242228', '1', 'Admin2', '1', null, null, '23', null, null, '2', '2018-06-15 12:02:41');
INSERT INTO `recharge_detail` VALUES ('14', '061514054215784', '1', 'Admin1', '1', null, null, '200', null, null, '1', '2018-06-15 14:05:43');
INSERT INTO `recharge_detail` VALUES ('15', '06152238541313', '1', 'Admin', '0', null, null, '100', null, null, '1', '2018-06-15 22:38:54');
INSERT INTO `recharge_detail` VALUES ('16', '06152241511180', '1', 'Admin', '0', null, null, '11', null, null, '1', '2018-06-15 22:41:51');
INSERT INTO `recharge_detail` VALUES ('17', '06152242019008', '1', 'Admin', '0', null, null, '333', null, null, '2', '2018-06-15 22:42:02');
INSERT INTO `recharge_detail` VALUES ('18', '06190955401698', '1', 'Admin1', '1', null, null, '333', null, null, '1', '2018-06-19 09:55:41');
INSERT INTO `recharge_detail` VALUES ('19', '061909561211697', '1', 'Admin1', '1', null, null, '333', null, null, '2', '2018-06-19 09:56:13');
INSERT INTO `recharge_detail` VALUES ('20', '061913555915482', '1', 'Admin', '0', null, null, '23', null, null, '1', '2018-06-19 13:56:00');
INSERT INTO `recharge_detail` VALUES ('21', '06191403038075', '1', 'Admin', '0', null, null, '968', null, null, '2', '2018-06-19 14:03:04');
INSERT INTO `recharge_detail` VALUES ('22', '06191616338786', '1', 'Admin', '0', null, null, '968', null, null, '1', '2018-06-19 16:16:33');
INSERT INTO `recharge_detail` VALUES ('23', '061918432063943', '454', 'ly', '6', null, null, '10', '1', null, '1', '2018-06-19 18:43:21');
INSERT INTO `recharge_detail` VALUES ('24', '061918451313037', '454', 'ly', '6', null, null, '10', '1', null, '0', '2018-06-19 18:45:13');
INSERT INTO `recharge_detail` VALUES ('25', '06191845241642', '454', 'ly', '6', null, null, '10', '1', null, '0', '2018-06-19 18:45:24');
INSERT INTO `recharge_detail` VALUES ('26', '06191847331592', '454', 'ly', '6', null, null, '10', '1', null, '0', '2018-06-19 18:47:34');
INSERT INTO `recharge_detail` VALUES ('27', '061918475618628', '454', 'ly', '6', null, null, '10', '1', null, '0', '2018-06-19 18:47:57');
INSERT INTO `recharge_detail` VALUES ('28', '061918491414820', '454', 'ly', '6', null, null, '10', '1', null, '0', '2018-06-19 18:49:14');
INSERT INTO `recharge_detail` VALUES ('29', '06191850002505', '454', 'ly', '6', null, null, '10', '1', null, '1', '2018-06-19 18:50:00');
INSERT INTO `recharge_detail` VALUES ('30', '061918510585614', '454', 'ly', '6', null, null, '10', '1', null, '0', '2018-06-19 18:51:05');
INSERT INTO `recharge_detail` VALUES ('31', '06191851321377', '454', 'ly', '6', null, null, '10', '1', null, '1', '2018-06-19 18:51:33');
INSERT INTO `recharge_detail` VALUES ('32', '061919041256442', '4', '123', '5', null, null, '10', '1', null, '1', '2018-06-19 19:04:12');
INSERT INTO `recharge_detail` VALUES ('33', '06191904218446', '4', '123', '5', null, null, '10', '1', null, '0', '2018-06-19 19:04:22');
INSERT INTO `recharge_detail` VALUES ('34', '061919063914894', '454', 'ly', '6', null, null, '10', '1', null, '0', '2018-06-19 19:06:39');
INSERT INTO `recharge_detail` VALUES ('35', '06191906581152', '4', '123', '5', null, null, '10', '1', null, '1', '2018-06-19 19:06:59');
INSERT INTO `recharge_detail` VALUES ('36', '061919180511627', '3', 'RicottaElmar2', '4', null, null, '10', '1', null, '1', '2018-06-19 19:18:05');
INSERT INTO `recharge_detail` VALUES ('37', '061919194116900', '454', 'ly', '6', null, null, '10', '1', null, '0', '2018-06-19 19:19:42');
INSERT INTO `recharge_detail` VALUES ('38', '061919194215005', '3', 'RicottaElmar2', '4', null, null, '10', '1', null, '1', '2018-06-19 19:19:43');
INSERT INTO `recharge_detail` VALUES ('39', '061919194720645', '454', 'ly', '6', null, null, '10', '1', null, '0', '2018-06-19 19:19:47');
INSERT INTO `recharge_detail` VALUES ('40', '06191923271397', '454', 'ly', '6', null, null, '10', '1', null, '1', '2018-06-19 19:23:28');
INSERT INTO `recharge_detail` VALUES ('41', '06191923522312', '454', 'ly', '6', null, null, '10', '1', null, '0', '2018-06-19 19:23:53');
INSERT INTO `recharge_detail` VALUES ('42', '061919242215571', '454', 'ly', '6', null, null, '10', '1', null, '0', '2018-06-19 19:24:23');
INSERT INTO `recharge_detail` VALUES ('43', '06191924421276', '454', 'ly', '6', null, null, '10', '1', null, '1', '2018-06-19 19:24:42');
INSERT INTO `recharge_detail` VALUES ('44', '06191929022056', '454', 'ly', '6', null, null, '10', '1', null, '1', '2018-06-19 19:29:03');
INSERT INTO `recharge_detail` VALUES ('45', '06191929076271', '3', 'RicottaElmar2', '4', null, null, '10', '1', null, '1', '2018-06-19 19:29:08');
INSERT INTO `recharge_detail` VALUES ('46', '06191929121235', '454', 'ly', '6', null, null, '10', '1', null, '0', '2018-06-19 19:29:12');
INSERT INTO `recharge_detail` VALUES ('47', '06191935231185', '454', 'ly', '6', null, null, '10', '1', null, '0', '2018-06-19 19:35:24');
INSERT INTO `recharge_detail` VALUES ('48', '06191935371193', '454', 'ly', '6', null, null, '10', '1', null, '0', '2018-06-19 19:35:38');
INSERT INTO `recharge_detail` VALUES ('49', '06191936301292', '454', 'ly', '6', null, null, '10', '1', null, '0', '2018-06-19 19:36:31');
INSERT INTO `recharge_detail` VALUES ('50', '061919415930560', '454', 'ly', '6', null, null, '10', '1', null, '0', '2018-06-19 19:41:59');
INSERT INTO `recharge_detail` VALUES ('51', '06191943581666', '454', 'ly', '6', null, null, '10', '1', null, '1', '2018-06-19 19:43:58');
INSERT INTO `recharge_detail` VALUES ('52', '061919460710258', '454', 'ly', '6', null, null, '10', '1', null, '0', '2018-06-19 19:46:08');
INSERT INTO `recharge_detail` VALUES ('53', '062009444730228', '3', 'RicottaElmar2', '4', null, null, '10', '1', null, '1', '2018-06-20 09:44:47');
INSERT INTO `recharge_detail` VALUES ('54', '06200945101182', '3', 'RicottaElmar2', '4', null, null, '10', '1', null, '0', '2018-06-20 09:45:11');
INSERT INTO `recharge_detail` VALUES ('55', '06200945181606', '3', 'RicottaElmar2', '4', null, null, '10', '1', null, '1', '2018-06-20 09:45:19');
INSERT INTO `recharge_detail` VALUES ('56', '062009464343107', '3', 'RicottaElmar2', '4', null, null, '1', '1', null, '1', '2018-06-20 09:46:44');

-- ----------------------------
-- Table structure for `recharge_package`
-- ----------------------------
DROP TABLE IF EXISTS `recharge_package`;
CREATE TABLE `recharge_package` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '充值套餐信息表',
  `recharge_monry` decimal(10,0) DEFAULT NULL COMMENT '套餐人民币',
  `recharge_object` decimal(10,0) DEFAULT NULL COMMENT '套餐熊掌',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of recharge_package
-- ----------------------------
INSERT INTO `recharge_package` VALUES ('16', '1', '1');
INSERT INTO `recharge_package` VALUES ('17', '30', '30');
INSERT INTO `recharge_package` VALUES ('18', '99', '100');
INSERT INTO `recharge_package` VALUES ('19', '298', '300');
INSERT INTO `recharge_package` VALUES ('20', '588', '600');
INSERT INTO `recharge_package` VALUES ('22', '968', '1000');

-- ----------------------------
-- Table structure for `score_set`
-- ----------------------------
DROP TABLE IF EXISTS `score_set`;
CREATE TABLE `score_set` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '积分列表(积分套餐列表)',
  `title` varchar(50) DEFAULT NULL COMMENT '获取积分的途径',
  `score` varchar(20) DEFAULT NULL COMMENT '该途径获得多少积分  青铜|白银|黄金|钻石',
  `baseEx` varchar(50) DEFAULT NULL COMMENT '基础练习平均评分在多少，才能获得基础练习奖励',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of score_set
-- ----------------------------
INSERT INTO `score_set` VALUES ('1', '每日登陆', '3', null);
INSERT INTO `score_set` VALUES ('2', '通关积分', '5|8|10|21', null);
INSERT INTO `score_set` VALUES ('3', '练习奖励', '11', '51');
INSERT INTO `score_set` VALUES ('4', '分享奖励', '10', '');

-- ----------------------------
-- Table structure for `service_provider`
-- ----------------------------
DROP TABLE IF EXISTS `service_provider`;
CREATE TABLE `service_provider` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '服务商信息表',
  `provider_id` int(11) DEFAULT NULL COMMENT '服务商id',
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '服务商名称',
  `contacts` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '联系人',
  `is_disable` int(11) DEFAULT NULL COMMENT '是否停用(1--开启停用  0--不停用)',
  `telephone` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '手机号',
  `organiztion_num` int(11) DEFAULT NULL COMMENT '区域机构总数',
  `piano_shop_num` int(11) DEFAULT NULL COMMENT '区域琴行总数',
  `boss_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '法人名字',
  `boss_telephone` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '法人电法',
  `income` decimal(10,2) DEFAULT NULL COMMENT '收入',
  `area` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '区域',
  `address` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '详细地址',
  `remind` int(11) DEFAULT NULL COMMENT '提醒',
  `state` int(11) DEFAULT NULL COMMENT '状态',
  `fengmian_picture` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '封面图片',
  `IDcard_picture` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '身份证照片',
  `business_license_picture` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '营业执照',
  `balance` decimal(10,2) DEFAULT NULL COMMENT '充值余额',
  `withdraw_balance` decimal(10,2) DEFAULT NULL COMMENT '可提现余额分润余额',
  `register_time` datetime DEFAULT NULL,
  `memeber_time` datetime DEFAULT NULL,
  `examine_time` datetime DEFAULT NULL COMMENT '审核时间',
  `divide_money_rate` decimal(10,2) DEFAULT NULL COMMENT '分成比例',
  `last_login_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of service_provider
-- ----------------------------
INSERT INTO `service_provider` VALUES ('1', '1', '14', '小明2', '0', '1234355656', '11', '12', 'aaa', '1232323231', '2343.00', '?15|226|1911', '大V发的噶非官方1', '1', '1', 'http://47.100.11.15/F/Image/null/1529551152786.png', 'http://47.100.11.15/F/Image/null/1529477826320.png', 'http://47.100.11.15/F/Image/null/1529478012983.png', '23.00', '-10.00', '2018-04-03 10:03:24', '2018-04-06 10:03:36', '2018-04-14 10:04:08', '0.50', '2018-04-16 10:04:21');
INSERT INTO `service_provider` VALUES ('2', null, '11133', '333', null, '222', null, null, '113', '444', null, '?10|148|1254', '6666', null, '0', '', 'http://192.168.1.69/F/Image/null/1528360185668.png', 'http://192.168.1.69/F/Image/null/1528360190721.png', null, null, null, null, null, null, null);
INSERT INTO `service_provider` VALUES ('3', null, 'xxx', 'tttt', null, '87654321', null, null, null, '12345678', null, '22?10|148|1255', '33', null, null, null, 'http://192.168.1.69/F/Image/null/1528361074789.png', 'http://192.168.1.69/F/Image/null/1528361077766.png', null, null, null, null, null, null, null);
INSERT INTO `service_provider` VALUES ('4', null, '1111111', '222222', null, '15194491661', null, null, null, '22', null, '2', '2', null, null, null, 'http://192.168.1.69/F/Image/null/1528361358409.png', 'http://192.168.1.69/F/Image/null/1528361360530.png', null, null, null, null, null, null, null);
INSERT INTO `service_provider` VALUES ('5', null, 'ewr', 'wer', null, '34dg', null, null, null, 'we', null, 'wer', 'wer', null, null, null, '', '', null, null, null, null, null, null, null);
INSERT INTO `service_provider` VALUES ('6', null, '242', '242', null, '324234', null, null, null, '24', null, '24', '234', null, null, null, '', '', null, null, null, null, null, null, null);
INSERT INTO `service_provider` VALUES ('7', null, '234', '234', null, '3242', null, null, null, '234', null, '242', '234', null, null, null, '', '', null, null, null, null, null, null, null);
INSERT INTO `service_provider` VALUES ('8', null, 'sd35423532', '34534', null, '15194491661', null, null, null, '3453', null, '345345', '534534', null, null, null, '', '', null, null, null, null, null, null, null);
INSERT INTO `service_provider` VALUES ('9', null, 'sdfds', 'sdfdfs', null, '15194491661', null, null, null, 'sdfds', null, 'sdfds', 'sdfdsfs', null, null, null, '', '', null, null, null, null, null, null, null);
INSERT INTO `service_provider` VALUES ('11', null, 'ertr', 'ert', null, '15194491661', null, null, null, 'ert', null, 'ert?10|160|1373', 'ertsdfd', null, null, null, '', '', null, null, null, null, null, null, null);
INSERT INTO `service_provider` VALUES ('12', null, null, '小明', null, '1234355656', '11', '12', null, '1232323231', null, 'sdf', '大V发的噶非官方', null, '0', null, '吃不测试版', 'dsfdfds', null, null, null, null, null, null, null);
INSERT INTO `service_provider` VALUES ('13', null, '111', '111', null, '15194491661', null, null, null, '11', null, '111', 'sfdsfsfs', null, null, null, '', '', null, null, null, null, null, null, null);
INSERT INTO `service_provider` VALUES ('14', null, null, 'sss', null, '15194491661', null, null, null, 'sssd', null, 'fssdfs', null, null, null, null, '', '', null, null, null, null, null, null, null);
INSERT INTO `service_provider` VALUES ('15', null, null, 'aa', null, '15194491661', null, null, null, 'sd', null, 'sdfsdf', null, null, null, null, '', '', null, null, null, null, null, null, null);
INSERT INTO `service_provider` VALUES ('16', null, 'ewrw', 'ewr', null, '15194491661', null, null, null, 'wer', null, 'sfdsf', 'sdfdsfds', null, null, null, 'http://192.168.1.71/F/Image/null/1528685656331.png', 'http://192.168.1.71/F/Image/null/1528685658079.png', null, null, null, null, null, null, null);
INSERT INTO `service_provider` VALUES ('17', null, '摇一摇', '俞钦华', null, '15194491661', null, null, null, '12345678985', null, '上海 浦东', '御桥', null, null, null, 'http://47.100.11.15/F/Image/null/1528771639878.png', 'http://47.100.11.15/F/Image/null/1528771644844.png', null, null, null, null, null, null, null);
INSERT INTO `service_provider` VALUES ('18', null, '服务商1', '啦啦啦', null, '15194491661', null, null, null, '电风扇', null, '10|10|10?15|226|1910', '222', null, null, null, 'http://47.100.11.15/F/Image/null/1528871055644.png', 'http://47.100.11.15/F/Image/null/1528871057308.png', null, null, null, null, null, null, null);
INSERT INTO `service_provider` VALUES ('19', null, '啊啊啊', '啊', null, '15194491661', null, null, null, '啊啊', null, '10|149|1267', '啊啊啊', null, null, null, 'http://47.100.11.15/F/Image/null/1528871475376.png', 'http://47.100.11.15/F/Image/null/1528871477578.png', null, null, null, null, null, null, null);
INSERT INTO `service_provider` VALUES ('20', null, '海门服务', '俞钦华', null, '15821941486', null, null, null, '15221351482', null, '11|170|1458', '该换个房间', null, '0', null, 'http://47.100.11.15/F/Image/null/1529465164880.png', 'http://47.100.11.15/F/Image/null/1529465174122.png', null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for `share_profit`
-- ----------------------------
DROP TABLE IF EXISTS `share_profit`;
CREATE TABLE `share_profit` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '分润设置',
  `game_profit` decimal(10,0) DEFAULT NULL COMMENT '游戏分润',
  `learnBook_profit` decimal(10,0) DEFAULT NULL COMMENT '购买教材分润',
  `skin_profit` decimal(10,0) DEFAULT NULL COMMENT '皮肤分润',
  `create_teacher_profit` decimal(10,0) DEFAULT NULL COMMENT '琴行创建老师分润',
  `role` int(11) DEFAULT NULL COMMENT '角色(1-服务商 2-机构 3-琴行 4-老师 5-推荐人)',
  `opera_explain` decimal(10,0) DEFAULT NULL COMMENT '曲谱讲解',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of share_profit
-- ----------------------------
INSERT INTO `share_profit` VALUES ('100', '11', '12', '13', '14', '1', '15');
INSERT INTO `share_profit` VALUES ('101', '20', '20', '20', '20', '2', '8');
INSERT INTO `share_profit` VALUES ('102', '20', '20', '20', '20', '3', '9');
INSERT INTO `share_profit` VALUES ('103', '10', '10', '10', '10', '4', '7');
INSERT INTO `share_profit` VALUES ('104', '30', '30', '30', '30', '5', '6');

-- ----------------------------
-- Table structure for `skin_detail`
-- ----------------------------
DROP TABLE IF EXISTS `skin_detail`;
CREATE TABLE `skin_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '皮肤信息表',
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `type` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '类型',
  `style` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '风格',
  `price_1` decimal(10,0) DEFAULT NULL COMMENT '皮肤价格(熊掌)',
  `price_2` decimal(10,0) DEFAULT NULL COMMENT '价格(积分)',
  `price_choice` int(11) DEFAULT NULL COMMENT '仅限熊掌(1--开启 0--关闭)',
  `discount_1` decimal(10,0) DEFAULT NULL COMMENT '优惠价格(熊掌)',
  `discount_2` decimal(10,0) DEFAULT NULL COMMENT '优惠价格(积分)',
  `discount_choice` int(11) DEFAULT NULL COMMENT '仅限熊掌(1--开启 0--关闭)',
  `discount_use` int(11) DEFAULT NULL COMMENT '是否启用优惠(1--开启  0--关闭)',
  `purchase_time` int(11) DEFAULT NULL COMMENT '购买次数',
  `last_buy_time` datetime DEFAULT NULL COMMENT '最后购买时间',
  `status` int(11) DEFAULT NULL COMMENT '状态(1--上架  0--下架)',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `off_shelf_time` datetime DEFAULT NULL COMMENT '下架时间',
  `on_shelf_time` datetime DEFAULT NULL COMMENT '上架时间',
  `founder` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '创建人',
  `skin_picture` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '皮肤图片',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of skin_detail
-- ----------------------------
INSERT INTO `skin_detail` VALUES ('3', '666', '107', '9', '666', '66', '1', '66', '66', '0', '0', '0', null, '1', null, '2018-05-21 11:21:18', '2018-05-22 13:51:58', '6632', 'http://h5.9shadow.com/F//pengHuaImg/db600dd32d704589b9a30390d61cd70f.png');
INSERT INTO `skin_detail` VALUES ('4', '22', '107', '11', '12', '13', '0', '14', '15', '0', '1', '0', null, '0', '2018-05-21 09:55:04', '2018-05-22 14:41:22', '2018-05-21 11:48:12', 'LLer', 'http://h5.9shadow.com/F//pengHuaImg/3e89138309fc4293acd5086f4cbd9eaf.png');
INSERT INTO `skin_detail` VALUES ('5', '2321', '103', '5', '23', '23', '0', '23', '23', '0', '1', '0', null, '1', '2018-05-22 14:37:05', '2018-05-22 14:37:05', '2018-05-22 14:41:50', '23', 'http://h5.9shadow.com/F//pengHuaImg/c94b4d5ee6754b13b20964e15e01dc57.png');
INSERT INTO `skin_detail` VALUES ('7', '3254324', '4', '2', '23', '23', '0', null, null, '0', '0', '0', null, '1', '2018-05-22 14:56:20', null, '2018-05-22 14:56:20', '23', 'http://h5.9shadow.com/F//pengHuaImg/c94b4d5ee6754b13b20964e15e01dc57.png');

-- ----------------------------
-- Table structure for `skin_style`
-- ----------------------------
DROP TABLE IF EXISTS `skin_style`;
CREATE TABLE `skin_style` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '皮肤风格',
  `style_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '皮肤风格名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of skin_style
-- ----------------------------
INSERT INTO `skin_style` VALUES ('2', 'bb22æ');
INSERT INTO `skin_style` VALUES ('3', 'cc');
INSERT INTO `skin_style` VALUES ('4', 'aaaaaaaa');
INSERT INTO `skin_style` VALUES ('5', 'bbbbbb');
INSERT INTO `skin_style` VALUES ('6', 'ccccccccccccccccc');
INSERT INTO `skin_style` VALUES ('7', 'eeeeeeeeeeeeeeeeeeeeeee');
INSERT INTO `skin_style` VALUES ('8', 'aaaaaaaaaaaaaaaaaaaaaa');
INSERT INTO `skin_style` VALUES ('10', 'azzzzzzzzzzzz');
INSERT INTO `skin_style` VALUES ('11', 'ttttttttttttttt');

-- ----------------------------
-- Table structure for `skin_type`
-- ----------------------------
DROP TABLE IF EXISTS `skin_type`;
CREATE TABLE `skin_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '皮肤类型',
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '皮肤类型名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=111 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of skin_type
-- ----------------------------
INSERT INTO `skin_type` VALUES ('4', 'å°æ¸æ°');
INSERT INTO `skin_type` VALUES ('102', '555555');
INSERT INTO `skin_type` VALUES ('103', '45454');
INSERT INTO `skin_type` VALUES ('104', '454545454');
INSERT INTO `skin_type` VALUES ('105', 'sss');
INSERT INTO `skin_type` VALUES ('106', '4564');
INSERT INTO `skin_type` VALUES ('107', 'ww');
INSERT INTO `skin_type` VALUES ('108', 'drfgd');
INSERT INTO `skin_type` VALUES ('109', '皮肤类型123');
INSERT INTO `skin_type` VALUES ('110', '0');

-- ----------------------------
-- Table structure for `song_record`
-- ----------------------------
DROP TABLE IF EXISTS `song_record`;
CREATE TABLE `song_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '学生音乐记录表',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `user_account` varchar(30) DEFAULT NULL COMMENT '用户账号',
  `user_role` varchar(30) DEFAULT NULL COMMENT '用户角色',
  `user_nick` varchar(30) DEFAULT NULL COMMENT '用户昵称',
  `piano_shop` varchar(30) DEFAULT NULL COMMENT '所属琴行',
  `teacher` varchar(30) DEFAULT NULL COMMENT '所属老师',
  `user_type` int(11) NOT NULL DEFAULT '1' COMMENT '用户类型：0：老师；1：学生；2：家长；3：机构',
  `song_id` int(11) NOT NULL COMMENT '曲目编号',
  `difficulty` int(11) DEFAULT NULL COMMENT '难度(歌曲本身难度-几乎固定)',
  `playspeed` int(11) DEFAULT NULL COMMENT '练习模式,(0 练习 1 青铜 2 白银 3黄金 4钻石)',
  `success` int(11) DEFAULT NULL COMMENT '0 失败,1成功',
  `times` int(11) DEFAULT NULL COMMENT '练习时长,累计时长计算用',
  `record_time` timestamp NULL DEFAULT NULL COMMENT '记录时间',
  `first_param` int(11) DEFAULT NULL COMMENT '练习模式下的时间s/其他模式下的错误数',
  `second_param` double(11,2) DEFAULT NULL COMMENT '练习模式下的速度/其他模式下的正确数',
  `third_param` int(11) DEFAULT NULL COMMENT '练习模式下的分数/其他模式下的分数',
  `combo` int(11) DEFAULT NULL COMMENT '连击数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of song_record
-- ----------------------------
INSERT INTO `song_record` VALUES ('1', '458', null, '1', '1234', null, '453', '1', '57', '3', '2', '1', '8', '2018-05-21 16:53:53', '200', '300.00', '200', '58');
INSERT INTO `song_record` VALUES ('2', '458', null, '1', '1234', null, '453', '1', '57', '3', '2', '1', '8', '2018-05-21 17:53:53', '200', '300.00', '200', '58');
INSERT INTO `song_record` VALUES ('3', '453', null, '1', '1234', null, '453', '1', '57', '3', '2', '1', '8', '2018-05-21 18:53:53', '200', '300.00', '200', '58');
INSERT INTO `song_record` VALUES ('4', '458', null, '1', '1234', null, '453', '1', '59', '3', '2', '1', '8', '2018-05-21 19:53:00', '200', '300.00', '200', '58');
INSERT INTO `song_record` VALUES ('5', '458', null, '1', '1234', null, '453', '1', '59', '3', '2', '1', '8', '2018-05-21 20:53:53', '200', '300.00', '200', '58');
INSERT INTO `song_record` VALUES ('6', '458', null, '1', '1234', null, '453', '1', '57', '1', '2', '0', '8', '2018-05-31 11:10:10', '185', '273.00', '210', '77');
INSERT INTO `song_record` VALUES ('7', '458', null, '1', '1234', null, '453', '1', '59', '1', '3', '0', '3', '2018-06-01 10:35:20', '268', '242.00', '107', '36');
INSERT INTO `song_record` VALUES ('8', '458', null, '1', '1234', null, '453', '1', '57', '2', '1', '1', '4', '2018-06-01 10:35:20', '17', '75.00', '23', '63');
INSERT INTO `song_record` VALUES ('9', '458', null, '1', '1234', null, '453', '1', '57', '3', '2', '1', '8', '2018-05-21 16:53:53', '200', '300.00', '200', '58');
INSERT INTO `song_record` VALUES ('10', '458', null, '1', '1234', null, '453', '1', '57', '3', '2', '1', '8', '2018-05-21 17:53:53', '200', '300.00', '200', '58');
INSERT INTO `song_record` VALUES ('11', '453', null, '1', '1234', null, '453', '1', '57', '3', '2', '1', '8', '2018-05-21 18:53:53', '200', '300.00', '200', '58');
INSERT INTO `song_record` VALUES ('12', '458', null, '1', '1234', null, '453', '1', '27', '3', '2', '1', '8', '2018-05-21 19:53:00', '200', '300.00', '200', '58');
INSERT INTO `song_record` VALUES ('13', '458', null, '1', '1234', null, '453', '1', '27', '3', '2', '1', '8', '2018-05-21 20:53:53', '200', '300.00', '200', '58');
INSERT INTO `song_record` VALUES ('14', '458', null, '1', '1234', null, '453', '1', '57', '1', '2', '0', '8', '2018-05-31 11:10:10', '185', '273.00', '210', '77');
INSERT INTO `song_record` VALUES ('15', '458', null, '1', '1234', null, '453', '1', '82', '1', '3', '0', '3', '2018-06-01 10:35:20', '268', '242.00', '107', '36');
INSERT INTO `song_record` VALUES ('16', '458', null, '1', '1234', null, '453', '1', '69', '2', '1', '1', '4', '2018-06-01 10:35:20', '17', '75.00', '23', '63');
INSERT INTO `song_record` VALUES ('17', '458', null, '1', '1234', null, '453', '1', '57', '3', '2', '1', '8', '2018-05-21 16:53:53', '200', '300.00', '200', '58');
INSERT INTO `song_record` VALUES ('18', '458', null, '1', '1234', null, '453', '1', '57', '3', '2', '1', '8', '2018-05-21 17:53:53', '200', '300.00', '200', '58');
INSERT INTO `song_record` VALUES ('19', '453', null, '1', '1234', null, '453', '1', '57', '3', '2', '1', '8', '2018-05-21 18:53:53', '200', '300.00', '200', '58');
INSERT INTO `song_record` VALUES ('20', '458', null, '1', '1234', null, '453', '1', '27', '3', '2', '1', '8', '2018-05-21 19:53:00', '200', '300.00', '200', '58');
INSERT INTO `song_record` VALUES ('21', '458', null, '1', '1234', null, '453', '1', '27', '3', '2', '1', '8', '2018-05-21 20:53:53', '200', '300.00', '200', '58');
INSERT INTO `song_record` VALUES ('22', '458', null, '1', '1234', null, '453', '1', '57', '1', '2', '0', '8', '2018-05-31 11:10:10', '185', '273.00', '210', '77');
INSERT INTO `song_record` VALUES ('23', '458', null, '1', '1234', null, '453', '1', '82', '1', '3', '0', '3', '2018-06-01 10:35:20', '268', '242.00', '107', '36');
INSERT INTO `song_record` VALUES ('24', '458', null, '1', '1234', null, '453', '1', '69', '2', '1', '1', '4', '2018-06-01 10:35:20', '17', '75.00', '23', '63');
INSERT INTO `song_record` VALUES ('25', '458', null, '1', '1234', null, '453', '1', '57', '3', '2', '1', '8', '2018-05-21 16:53:53', '200', '300.00', '200', '58');
INSERT INTO `song_record` VALUES ('26', '458', null, '1', '1234', null, '453', '1', '57', '3', '2', '1', '8', '2018-05-21 17:53:53', '200', '300.00', '200', '58');
INSERT INTO `song_record` VALUES ('27', '453', null, '1', '1234', null, '453', '1', '57', '3', '2', '1', '8', '2018-05-21 18:53:53', '200', '300.00', '200', '58');
INSERT INTO `song_record` VALUES ('28', '458', null, '1', '1234', null, '453', '1', '27', '3', '2', '1', '8', '2018-05-21 19:53:00', '200', '300.00', '200', '58');
INSERT INTO `song_record` VALUES ('29', '458', null, '1', '1234', null, '453', '1', '27', '3', '2', '1', '8', '2018-05-21 20:53:53', '200', '300.00', '200', '58');
INSERT INTO `song_record` VALUES ('30', '458', null, '1', '1234', null, '453', '1', '57', '1', '2', '0', '8', '2018-05-31 11:10:10', '185', '273.00', '210', '77');
INSERT INTO `song_record` VALUES ('31', '458', null, '1', '1234', null, '453', '1', '82', '1', '3', '0', '3', '2018-06-01 10:35:20', '268', '242.00', '107', '36');
INSERT INTO `song_record` VALUES ('32', '458', null, '1', '1234', null, '453', '1', '69', '2', '1', '1', '4', '2018-06-01 10:35:20', '17', '75.00', '23', '63');
INSERT INTO `song_record` VALUES ('33', '458', null, '1', '1234', null, '453', '1', '57', '3', '2', '1', '8', '2018-05-21 16:53:53', '200', '300.00', '200', '58');
INSERT INTO `song_record` VALUES ('34', '458', null, '1', '1234', null, '453', '1', '57', '3', '2', '1', '8', '2018-05-21 17:53:53', '200', '300.00', '200', '58');
INSERT INTO `song_record` VALUES ('35', '453', null, '1', '1234', null, '453', '1', '57', '3', '2', '1', '8', '2018-05-21 18:53:53', '200', '300.00', '200', '58');
INSERT INTO `song_record` VALUES ('36', '458', null, '1', '1234', null, '453', '1', '27', '3', '2', '1', '8', '2018-05-21 19:53:00', '200', '300.00', '200', '58');
INSERT INTO `song_record` VALUES ('37', '458', null, '1', '1234', null, '453', '1', '27', '3', '2', '1', '8', '2018-05-21 20:53:53', '200', '300.00', '200', '58');
INSERT INTO `song_record` VALUES ('38', '458', null, '1', '1234', null, '453', '1', '57', '1', '2', '0', '8', '2018-05-31 11:10:10', '185', '273.00', '210', '77');
INSERT INTO `song_record` VALUES ('39', '458', null, '1', '1234', null, '453', '1', '82', '1', '3', '0', '3', '2018-06-01 10:35:20', '268', '242.00', '107', '36');
INSERT INTO `song_record` VALUES ('40', '458', null, '1', '1234', null, '453', '1', '69', '2', '1', '1', '4', '2018-06-01 10:35:20', '17', '75.00', '23', '63');
INSERT INTO `song_record` VALUES ('41', '458', null, '1', '1234', null, '453', '1', '57', '3', '2', '1', '8', '2018-05-21 16:53:53', '200', '300.00', '200', '58');
INSERT INTO `song_record` VALUES ('42', '458', null, '1', '1234', null, '453', '1', '57', '3', '2', '1', '8', '2018-05-21 17:53:53', '200', '300.00', '200', '58');
INSERT INTO `song_record` VALUES ('43', '453', null, '1', '1234', null, '453', '1', '57', '3', '2', '1', '8', '2018-05-21 18:53:53', '200', '300.00', '200', '58');
INSERT INTO `song_record` VALUES ('44', '458', null, '1', '1234', null, '453', '1', '27', '3', '2', '1', '8', '2018-05-21 19:53:00', '200', '300.00', '200', '58');
INSERT INTO `song_record` VALUES ('45', '458', null, '1', '1234', null, '453', '1', '27', '3', '2', '1', '8', '2018-05-21 20:53:53', '200', '300.00', '200', '58');
INSERT INTO `song_record` VALUES ('46', '458', null, '1', '1234', null, '453', '1', '57', '1', '2', '0', '8', '2018-05-31 11:10:10', '185', '273.00', '210', '77');
INSERT INTO `song_record` VALUES ('47', '458', null, '1', '1234', null, '453', '1', '82', '1', '3', '0', '3', '2018-06-01 10:35:20', '268', '242.00', '107', '36');
INSERT INTO `song_record` VALUES ('48', '458', null, '1', '1234', null, '453', '1', '69', '2', '1', '1', '4', '2018-06-01 10:35:20', '17', '75.00', '23', '63');
INSERT INTO `song_record` VALUES ('49', '458', null, '1', '1234', null, '453', '1', '57', '3', '2', '1', '8', '2018-05-21 16:53:53', '200', '300.00', '200', '58');
INSERT INTO `song_record` VALUES ('50', '458', null, '1', '1234', null, '453', '1', '57', '3', '2', '1', '8', '2018-05-21 17:53:53', '200', '300.00', '200', '58');
INSERT INTO `song_record` VALUES ('51', '453', null, '1', '1234', null, '453', '1', '57', '3', '2', '1', '8', '2018-05-21 18:53:53', '200', '300.00', '200', '58');
INSERT INTO `song_record` VALUES ('52', '458', null, '1', '1234', null, '453', '1', '27', '3', '2', '1', '8', '2018-05-21 19:53:00', '200', '300.00', '200', '58');
INSERT INTO `song_record` VALUES ('53', '458', null, '1', '1234', null, '453', '1', '27', '3', '2', '1', '8', '2018-05-21 20:53:53', '200', '300.00', '200', '58');
INSERT INTO `song_record` VALUES ('54', '458', null, '1', '1234', null, '453', '1', '57', '1', '2', '0', '8', '2018-05-31 11:10:10', '185', '273.00', '210', '77');
INSERT INTO `song_record` VALUES ('55', '458', null, '1', '1234', null, '453', '1', '82', '1', '3', '0', '3', '2018-06-01 10:35:20', '268', '242.00', '107', '36');
INSERT INTO `song_record` VALUES ('56', '458', null, '1', '1234', null, '453', '1', '69', '2', '1', '1', '4', '2018-06-01 10:35:20', '17', '75.00', '23', '63');

-- ----------------------------
-- Table structure for `students`
-- ----------------------------
DROP TABLE IF EXISTS `students`;
CREATE TABLE `students` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '学生信息表',
  `stundent_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '学生姓名',
  `stundent_id` bigint(11) DEFAULT NULL COMMENT '学生ID -- <该字段暂时不使用>',
  `referee_id` int(11) DEFAULT NULL COMMENT '推荐人ID',
  `gender` int(11) DEFAULT NULL COMMENT '1--男 0--女',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `parent_id` int(11) DEFAULT NULL COMMENT '家长ID',
  `parent_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '家长姓名',
  `teacher_id` int(11) DEFAULT NULL COMMENT '老师ID',
  `teacher_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '老师姓名',
  `member_level` int(11) DEFAULT NULL COMMENT '会员等级',
  `telephone` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '手机号',
  `area` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '区域',
  `address` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '详细地址',
  `remind` int(11) DEFAULT NULL COMMENT '一键提醒',
  `state` int(11) DEFAULT NULL COMMENT '状态',
  `score` int(11) DEFAULT NULL COMMENT '积分',
  `game_score` int(11) DEFAULT NULL COMMENT '游戏积分',
  `balance` int(11) DEFAULT NULL COMMENT '限额',
  `register_time` datetime DEFAULT NULL COMMENT '注册时间',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `head_url` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '学生头像',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=518 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of students
-- ----------------------------
INSERT INTO `students` VALUES ('1', '小名', '1', '1', '1', '12', '4', '家长222', '3', '老师1111', '2', '1235434654', 'vvvvvvv', 'dfdfdfdgregrg', '1', '1', '23', '123', '500', '2018-04-03 11:59:22', '2018-04-18 11:59:27', null);
INSERT INTO `students` VALUES ('2', '小2', '2', null, null, null, '4', '家长222', '3', '老师222', null, '17680251245', '上海', '上海浦东', null, null, null, null, '500', '2018-05-16 10:19:52', null, null);
INSERT INTO `students` VALUES ('3', null, '1', '11', null, null, '454', null, '454', '12345', null, '15221351482', '上海 长宁区', '详细地址', null, null, null, null, '500', '2018-05-17 20:13:04', null, null);
INSERT INTO `students` VALUES ('4', null, null, '656', null, null, null, null, '4656', null, null, '15221351482', '4545', '64546', null, null, null, null, '500', '2018-05-17 20:30:03', null, null);
INSERT INTO `students` VALUES ('5', null, null, '88', null, null, null, null, '888', null, null, '15221351482', '湖南 长沙', 'changshagn', null, null, null, null, '500', '2018-05-17 20:41:32', null, null);
INSERT INTO `students` VALUES ('6', null, null, '123', null, null, null, null, '123', 'ly', null, '15292864264', '上海 浦东新区', '123', null, null, null, null, '500', '2018-05-18 20:44:29', null, null);
INSERT INTO `students` VALUES ('7', null, null, null, null, null, null, null, '2', null, null, '17621829059', '吉林 长春', '新年放假', null, null, null, null, null, '2018-05-24 10:49:50', null, null);
INSERT INTO `students` VALUES ('9', 'fff', null, null, null, null, null, null, '2', null, null, null, null, '北京 东城区,十多个活生生的11', null, '0', null, null, null, null, null, null);
INSERT INTO `students` VALUES ('454', 'liyong', null, null, '1', null, '4', '家长22', '7', '王老师', null, null, null, null, null, null, '23', null, null, null, null, 'http://h5.9shadow.com/F//pengHuaImg/94856c5899314c0eae182340190881b9.png');
INSERT INTO `students` VALUES ('461', 'lin', null, null, '1', null, null, null, '7', null, null, null, null, null, null, null, '23', null, null, null, null, 'http://h5.9shadow.com/F//pengHuaImg/94856c5899314c0eae182340190881b9.png');
INSERT INTO `students` VALUES ('464', null, null, null, null, null, null, null, '1', null, null, '17699406195', '新疆乌鲁木齐 天山区', '123', null, null, null, null, null, '2018-05-30 14:41:30', null, null);
INSERT INTO `students` VALUES ('465', null, null, null, null, null, null, null, '1', null, null, '17699406195', '新疆乌鲁木齐 天山区', '123', null, null, null, null, null, '2018-05-30 14:41:36', null, null);
INSERT INTO `students` VALUES ('466', null, null, null, null, null, null, null, '1', null, null, '17699406195', '新疆乌鲁木齐 天山区', '123', null, null, null, null, null, '2018-05-30 14:41:40', null, null);
INSERT INTO `students` VALUES ('467', null, null, null, null, null, null, null, '1', null, null, '17699406195', '新疆乌鲁木齐 天山区', '123', null, null, null, null, null, '2018-05-30 14:41:52', null, null);
INSERT INTO `students` VALUES ('468', null, null, null, null, null, null, null, '1', null, null, '17699406195', '新疆乌鲁木齐 天山区', '123', null, null, null, null, null, '2018-05-30 14:41:53', null, null);
INSERT INTO `students` VALUES ('469', null, null, null, null, null, null, null, '1', null, null, '17699406195', '新疆乌鲁木齐 天山区', '123', null, null, null, null, null, '2018-05-30 14:41:53', null, null);
INSERT INTO `students` VALUES ('470', null, null, null, null, null, null, null, '1', null, null, '17699406195', '新疆乌鲁木齐 天山区', '123', null, null, null, null, null, '2018-05-30 14:41:53', null, null);
INSERT INTO `students` VALUES ('471', null, null, null, null, null, null, null, '1', null, null, '17699406195', '新疆乌鲁木齐 天山区', '123', null, null, null, null, null, '2018-05-30 14:41:53', null, null);
INSERT INTO `students` VALUES ('472', null, null, null, null, null, null, null, '1', null, null, '17699406195', '新疆乌鲁木齐 天山区', '123', null, null, null, null, null, '2018-05-30 14:41:54', null, null);
INSERT INTO `students` VALUES ('473', null, null, null, null, null, null, null, '1', null, null, '17699406195', '新疆乌鲁木齐 天山区', '123', null, null, null, null, null, '2018-05-30 14:41:56', null, null);
INSERT INTO `students` VALUES ('474', null, null, null, null, null, null, null, '1', null, null, '17699406195', '新疆乌鲁木齐 天山区', '123', null, null, null, null, null, '2018-05-30 14:41:56', null, null);
INSERT INTO `students` VALUES ('475', null, null, null, null, null, null, null, '1', null, null, '17699406195', '新疆乌鲁木齐 天山区', '123', null, null, null, null, null, '2018-05-30 14:41:56', null, null);
INSERT INTO `students` VALUES ('476', null, null, null, null, null, null, null, '1', null, null, '17699406195', '新疆乌鲁木齐 天山区', '123', null, null, null, null, null, '2018-05-30 14:41:57', null, null);
INSERT INTO `students` VALUES ('477', null, null, null, null, null, null, null, '1', null, null, '17699406195', '新疆 乌鲁木齐 天山区', '123', null, null, null, null, null, '2018-05-30 14:42:47', null, null);
INSERT INTO `students` VALUES ('478', null, null, null, null, null, null, null, '1', null, null, '17699406195', '新疆 乌鲁木齐 天山区', '123', null, null, null, null, null, '2018-05-30 14:43:14', null, null);
INSERT INTO `students` VALUES ('479', null, null, null, null, null, null, null, '1', null, null, '17699406195', '新疆 乌鲁木齐 天山区', '123', null, null, null, null, null, '2018-05-30 14:43:15', null, null);
INSERT INTO `students` VALUES ('480', null, null, null, null, null, null, null, '1', null, null, '17699406195', '新疆 乌鲁木齐 天山区', '123', null, null, null, null, null, '2018-05-30 14:43:16', null, null);
INSERT INTO `students` VALUES ('481', null, null, null, null, null, null, null, '1', null, null, '17699406195', '新疆 乌鲁木齐 天山区', '123', null, null, null, null, null, '2018-05-30 14:43:16', null, null);
INSERT INTO `students` VALUES ('482', null, null, null, null, null, null, null, '1', null, null, '17699406195', '新疆 乌鲁木齐 天山区', '123', null, null, null, null, null, '2018-05-30 14:43:16', null, null);
INSERT INTO `students` VALUES ('483', null, null, null, null, null, null, null, '2', null, null, '17699406195', '新疆 乌鲁木齐 天山区', '123', null, null, null, null, null, '2018-05-30 14:43:17', null, null);
INSERT INTO `students` VALUES ('484', null, null, null, null, null, null, null, '2', null, null, '17699406195', '新疆 乌鲁木齐 天山区', '123', null, null, null, null, null, '2018-05-30 14:43:17', null, null);
INSERT INTO `students` VALUES ('485', null, null, null, null, null, null, null, '2', null, null, '17699406195', '新疆 乌鲁木齐 天山区', '123', null, null, null, null, null, '2018-05-30 14:43:17', null, null);
INSERT INTO `students` VALUES ('486', null, null, null, null, null, null, null, '2', null, null, '17699406195', '新疆 乌鲁木齐 天山区', '123', null, null, null, null, null, '2018-05-30 14:43:17', null, null);
INSERT INTO `students` VALUES ('487', null, null, null, null, null, null, null, '2', null, null, '17699406195', '新疆 乌鲁木齐 天山区', '123', null, null, null, null, null, '2018-05-30 14:43:17', null, null);
INSERT INTO `students` VALUES ('488', null, null, null, null, null, null, null, '2', null, null, '17699406195', '新疆 乌鲁木齐 天山区', '123', null, null, null, null, null, '2018-05-30 14:43:18', null, null);
INSERT INTO `students` VALUES ('489', null, null, '123456', null, null, null, null, '147258', null, null, '15821941486', '江苏 南通 海门市', '一样一样', null, null, null, null, null, '2018-06-01 21:18:42', null, null);
INSERT INTO `students` VALUES ('490', null, null, '123456', null, null, null, null, '147258', null, null, '15821941486', '江苏 南通 海门市', '一样一样', null, null, null, null, null, '2018-06-01 21:18:50', null, null);
INSERT INTO `students` VALUES ('491', null, null, '123456', null, null, null, null, '147258', null, null, '15821941486', '江苏 南通 海门市', '一样一样', null, null, null, null, null, '2018-06-01 21:18:52', null, null);
INSERT INTO `students` VALUES ('492', null, null, '123456', null, null, null, null, '147258', null, null, '15821941486', '江苏 南通 海门市', '一样一样', null, null, null, null, null, '2018-06-01 21:19:05', null, null);
INSERT INTO `students` VALUES ('493', null, null, null, null, null, null, null, '2', null, null, '15821941486', '江苏 南通 海门市', '一样一样', null, null, null, null, null, '2018-06-01 21:19:21', null, null);
INSERT INTO `students` VALUES ('494', null, null, null, null, null, null, null, '2', null, null, '13676548289', '浙江 温州 鹿城区', '123123', null, null, null, null, null, '2018-06-05 09:11:33', null, null);
INSERT INTO `students` VALUES ('495', null, null, '1', null, null, null, null, '1', null, null, '15221351482', '北京', '1', null, null, null, null, null, '2018-06-07 14:09:28', null, null);
INSERT INTO `students` VALUES ('496', null, null, null, null, null, null, null, null, null, null, '15821941486', '江苏 南通 海门市', '三和', null, null, null, null, null, '2018-06-07 20:34:04', null, null);
INSERT INTO `students` VALUES ('497', null, null, null, null, null, null, null, null, null, null, '15773803298', '北京 东城区', '123', null, null, null, null, null, '2018-06-08 16:47:19', null, null);
INSERT INTO `students` VALUES ('499', 'ly', null, null, null, null, null, null, null, null, null, '15773803298', '北京 东城区', 'ssssws', null, null, null, null, null, '2018-06-08 17:32:34', null, null);
INSERT INTO `students` VALUES ('500', null, null, null, null, null, null, null, null, null, null, '13676548289', '北京 东城区', 'sdf', null, null, null, null, null, '2018-06-09 10:00:36', null, null);
INSERT INTO `students` VALUES ('501', null, null, '21212', null, null, null, null, '21221', null, null, '15821941486', '江苏 南通 海门市', '三和镇', null, null, null, null, null, '2018-06-11 14:06:32', null, null);
INSERT INTO `students` VALUES ('502', null, null, null, null, null, null, null, null, null, null, '15821941486', '北京', '花花', null, null, null, null, null, '2018-06-11 19:28:49', null, null);
INSERT INTO `students` VALUES ('503', null, null, null, null, null, null, null, null, null, null, '15821941486', '北京 东城区', '花花', null, null, null, null, null, '2018-06-11 19:29:47', null, null);
INSERT INTO `students` VALUES ('504', null, null, null, null, null, null, null, null, null, null, '15821941486', '北京 东城区', '花花', null, null, null, null, null, '2018-06-11 19:29:54', null, null);
INSERT INTO `students` VALUES ('505', null, null, null, null, null, null, null, null, null, null, '15821941486', '北京 东城区', '御桥路', null, null, null, null, null, '2018-06-11 20:24:25', null, null);
INSERT INTO `students` VALUES ('506', null, null, null, null, null, null, null, null, null, null, '15821941486', '北京 东城区', '御桥路', null, null, null, null, null, '2018-06-11 20:24:49', null, null);
INSERT INTO `students` VALUES ('507', null, null, null, null, null, null, null, null, null, null, '15821941486', '北京 东城区', '御桥路', null, null, null, null, null, '2018-06-11 20:24:52', null, null);
INSERT INTO `students` VALUES ('509', '林勇', null, null, null, null, null, null, null, null, null, '15821941486', '湖北 武汉 江岸区', '汉口', null, null, null, null, null, '2018-06-11 21:32:08', null, null);
INSERT INTO `students` VALUES ('510', '俞钦华', null, null, null, null, null, null, null, null, null, '15821941486', '北京 东城区', '渔樵', null, null, null, null, null, '2018-06-12 10:11:09', null, null);
INSERT INTO `students` VALUES ('511', '电风扇格式的', null, null, null, null, null, null, null, null, null, '13177143948', '北京 东城区', 'dfsfgsf', null, null, null, null, null, '2018-06-13 17:01:35', null, null);
INSERT INTO `students` VALUES ('512', '第三方', null, null, null, null, null, null, null, null, null, '15821941486', '黑龙江 大兴安岭 塔河县', '对方答复', null, null, null, null, null, '2018-06-13 18:23:18', null, null);
INSERT INTO `students` VALUES ('513', '林永', null, null, null, null, null, null, null, null, null, '15221351482', '河南 洛阳 老城区', '士大夫十分低调', null, null, null, null, null, '2018-06-14 11:11:37', null, null);
INSERT INTO `students` VALUES ('514', '俞钦华', null, null, null, null, null, null, null, null, null, '15821941486', '黑龙江 大兴安岭 塔河县', '第三方的', null, null, null, null, null, '2018-06-15 11:36:10', null, null);
INSERT INTO `students` VALUES ('515', '反对反对', null, null, null, null, null, null, null, null, null, '15821941486', '湖北 鄂州 华容区', '手动阀手动阀', null, null, null, null, null, '2018-06-19 11:59:14', null, null);
INSERT INTO `students` VALUES ('516', '俞钦华', null, null, null, null, null, null, null, null, null, '15821941486', '江西 吉安 吉州区', '而非的地方12', null, null, null, null, null, '2018-06-20 10:25:36', null, null);
INSERT INTO `students` VALUES ('517', '反对法', null, null, null, null, null, null, null, null, null, '15821941486', '河南 信阳 固始县', '烦烦烦方法1', null, '0', null, null, null, '2018-06-20 16:11:28', null, null);

-- ----------------------------
-- Table structure for `sys_acl`
-- ----------------------------
DROP TABLE IF EXISTS `sys_acl`;
CREATE TABLE `sys_acl` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '权限id',
  `code` varchar(20) NOT NULL DEFAULT '' COMMENT '权限码',
  `name` varchar(20) NOT NULL DEFAULT '' COMMENT '权限名称',
  `acl_module_id` int(11) NOT NULL DEFAULT '0' COMMENT '权限所在的权限模块id',
  `url` varchar(100) NOT NULL DEFAULT '' COMMENT '请求的url, 可以填正则表达式',
  `type` int(11) NOT NULL DEFAULT '3' COMMENT '类型，1：菜单，2：按钮，3：其他',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '状态，1：正常，0：冻结',
  `seq` int(11) NOT NULL DEFAULT '0' COMMENT '权限在当前模块下的顺序，由小到大',
  `remark` varchar(200) DEFAULT '' COMMENT '备注',
  `operator` varchar(20) NOT NULL DEFAULT '' COMMENT '操作者',
  `operate_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次更新时间',
  `operate_ip` varchar(20) NOT NULL DEFAULT '' COMMENT '最后一个更新者的ip地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=85 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sys_acl
-- ----------------------------
INSERT INTO `sys_acl` VALUES ('7', '20171015212907_36', '进入权限管理页', '7', '/sys/aclModule/acl.page', '1', '1', '1', '', 'Admin', '2017-10-15 21:29:07', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_acl` VALUES ('8', '20171015212938_27', '进入角色管理页', '8', '/sys/role/role.page', '1', '1', '1', '', 'Admin', '2017-10-16 17:49:38', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_acl` VALUES ('9', '20171015213009_0', '进入用户管理页', '9', '/sys/dept/dept.page', '1', '1', '1', '', 'Admin', '2017-10-15 21:30:09', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_acl` VALUES ('10', '20171016230429_8', '进入权限更新记录页面', '11', '/sys/log/log.page', '1', '1', '1', '', 'Admin', '2017-10-16 23:04:49', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_acl` VALUES ('12', '20180326182037_92', '游戏记录查看', '6', '/game/getll.page', '1', '1', '1', '', 'Admin', '2018-03-26 18:20:38', '127.0.0.1');
INSERT INTO `sys_acl` VALUES ('13', '20180326182138_79', '游戏记录查看', '17', '/get/gameManage.page', '1', '1', '1', '游戏记录查看', 'Admin', '2018-04-02 15:07:06', '127.0.0.1');
INSERT INTO `sys_acl` VALUES ('16', '20180327105408_83', '琴行规模', '18', '/get/getPianoScope.page', '1', '1', '2', '琴行规模', 'Admin', '2018-03-27 15:33:13', '127.0.0.1');
INSERT INTO `sys_acl` VALUES ('19', '20180327111023_83', '机构管理', '12', '/get/getOrganization', '1', '1', '3', '机构管理', 'Admin', '2018-03-27 11:10:23', '127.0.0.1');
INSERT INTO `sys_acl` VALUES ('20', '20180327111524_97', '家长管理', '21', '/get/getParent.page', '1', '1', '5', '家长管理', 'Admin', '2018-03-27 12:01:45', '127.0.0.1');
INSERT INTO `sys_acl` VALUES ('21', '20180327111646_13', '机构管理', '19', '/get/getOrginazList.page', '1', '1', '3', '机构管理', 'Admin', '2018-03-27 16:27:54', '127.0.0.1');
INSERT INTO `sys_acl` VALUES ('22', '20180327112546_17', '琴行管理', '20', '/get/getPianoList.page', '1', '1', '4', '琴行管理', 'Admin', '2018-03-27 19:03:58', '127.0.0.1');
INSERT INTO `sys_acl` VALUES ('23', '20180327115223_98', '学生管理', '22', '/get/getStudent.page', '1', '1', '1', '学生管理', 'Admin', '2018-03-28 11:45:34', '127.0.0.1');
INSERT INTO `sys_acl` VALUES ('25', '20180327121039_64', '老师管理', '23', '/get/getTeacher.page', '1', '1', '7', '老师管理', 'Admin', '2018-03-28 14:15:43', '127.0.0.1');
INSERT INTO `sys_acl` VALUES ('26', '20180327121456_59', '待审核会员', '24', '/get/getAuditMember.page', '1', '1', '8', '待审核会员', 'Admin', '2018-03-28 14:40:14', '127.0.0.1');
INSERT INTO `sys_acl` VALUES ('27', '20180327141452_42', '充值明细', '26', '/get/getRechargeDetail.page', '1', '1', '1', '充值明细', 'Admin', '2018-03-27 14:19:17', '127.0.0.1');
INSERT INTO `sys_acl` VALUES ('28', '20180327141844_2', '充值管理', '27', '/get/rechargeManagement.page', '1', '1', '2', '充值管理', 'Admin', '2018-03-29 10:50:36', '127.0.0.1');
INSERT INTO `sys_acl` VALUES ('29', '20180327142652_14', '消费明细', '29', '/get/getConsumDetail.page', '1', '1', '1', '消费明细', 'Admin', '2018-03-27 14:26:52', '127.0.0.1');
INSERT INTO `sys_acl` VALUES ('30', '20180328175622_48', '添加老师', '30', '/get/addTeacher.page', '1', '1', '1', '', 'Admin', '2018-03-28 17:56:23', '127.0.0.1');
INSERT INTO `sys_acl` VALUES ('31', '20180328200837_44', '作业管理', '33', '/get/taskManagement.page', '1', '1', '1', '作业管理', 'Admin', '2018-03-29 11:27:52', '127.0.0.1');
INSERT INTO `sys_acl` VALUES ('32', '20180329110135_66', '评语管理', '34', '/get/commentManagement.page', '1', '1', '2', '评语管理', 'Admin', '2018-03-29 11:28:32', '127.0.0.1');
INSERT INTO `sys_acl` VALUES ('33', '20180329113436_17', '学生点评', '35', '/get/studentComment', '1', '1', '1', '学生点评', 'Admin', '2018-03-29 12:04:03', '127.0.0.1');
INSERT INTO `sys_acl` VALUES ('34', '20180329120143_77', '家长给老师的寄语', '37', '/get/parentCommentTeacher', '1', '1', '1', '家长给老师的寄语', 'Admin', '2018-03-29 12:02:19', '127.0.0.1');
INSERT INTO `sys_acl` VALUES ('38', '20180329141959_92', '热门广告位', '42', '/get/popularAdverment.page', '1', '1', '1', '热门广告位', 'Admin', '2018-03-29 14:20:50', '127.0.0.1');
INSERT INTO `sys_acl` VALUES ('41', '20180329154936_70', '栏目管理', '6', '/get/columnManagement.page', '1', '1', '1', '栏目管理', 'Admin', '2018-03-29 15:49:36', '127.0.0.1');
INSERT INTO `sys_acl` VALUES ('42', '20180329155347_83', '栏目管理', '45', '/get/columnManagement.page', '1', '1', '1', '栏目管理', 'Admin', '2018-03-29 15:53:47', '127.0.0.1');
INSERT INTO `sys_acl` VALUES ('43', '20180329164545_26', '阶段管理', '47', '/get/stageManagement.page', '1', '1', '1', '阶段管理', 'Admin', '2018-03-29 16:57:54', '192.168.1.66');
INSERT INTO `sys_acl` VALUES ('44', '20180329165207_75', '风格管理', '48', '/get/styleManagement.page', '1', '1', '1', '风格管理', 'Admin', '2018-03-29 16:58:03', '192.168.1.66');
INSERT INTO `sys_acl` VALUES ('45', '20180329165736_87', '教材管理', '49', '/get/learnBookManagement.page', '1', '1', '1', '教材管理', 'Admin', '2018-03-29 16:57:37', '192.168.1.66');
INSERT INTO `sys_acl` VALUES ('46', '20180329170044_79', '曲谱管理', '50', '/get/seeOpera', '1', '1', '1', '曲谱管理', 'Admin', '2018-04-02 14:35:43', '127.0.0.1');
INSERT INTO `sys_acl` VALUES ('47', '20180329184800_82', '提现审批', '52', '/get/withdrawExamine', '1', '1', '1', '提现审批', 'Admin', '2018-03-29 18:48:00', '127.0.0.1');
INSERT INTO `sys_acl` VALUES ('48', '20180330161228_5', '分润设置', '6', '/get/shareProfitSetting.page', '1', '1', '1', '分润设置', 'Admin', '2018-03-30 16:12:28', '127.0.0.1');
INSERT INTO `sys_acl` VALUES ('49', '20180330161326_73', '分润设置', '54', '/get/shareProfitSetting.page', '1', '1', '1', '分润设置', 'Admin', '2018-03-30 16:13:26', '127.0.0.1');
INSERT INTO `sys_acl` VALUES ('50', '20180330163859_74', '银行卡', '55', '/get/bankCardDetail.page', '1', '1', '1', '银行卡', 'Admin', '2018-03-30 16:38:59', '127.0.0.1');
INSERT INTO `sys_acl` VALUES ('51', '20180330164126_5', '收入明细', '6', '/get/incomeDetail.page', '1', '1', '1', '收入明细', 'Admin', '2018-03-30 16:41:27', '127.0.0.1');
INSERT INTO `sys_acl` VALUES ('52', '20180330164219_86', '收入明细', '56', '/get/incomeDetail.page', '1', '1', '1', '收入明细', 'Admin', '2018-03-30 16:42:19', '127.0.0.1');
INSERT INTO `sys_acl` VALUES ('53', '20180330171128_53', '余额提现申请', '57', '/get/withdrawApply', '1', '1', '1', '余额提现申请', 'Admin', '2018-03-30 17:11:29', '127.0.0.1');
INSERT INTO `sys_acl` VALUES ('54', '20180330180513_65', '服务商管理', '58', '/get/serviceProviderManage', '1', '1', '1', '服务商管理', 'Admin', '2018-03-30 18:05:13', '127.0.0.1');
INSERT INTO `sys_acl` VALUES ('55', '20180402094309_53', '皮肤类型', '60', '/get/skinType', '1', '1', '1', '皮肤类型', 'Admin', '2018-04-02 09:47:07', '127.0.0.1');
INSERT INTO `sys_acl` VALUES ('56', '20180402094421_64', '皮肤管理', '62', '/get/skinManage', '1', '1', '1', '皮肤类型', 'Admin', '2018-04-02 09:44:21', '127.0.0.1');
INSERT INTO `sys_acl` VALUES ('57', '20180402094654_7', '皮肤风格', '61', '/get/skinStyle', '1', '1', '1', '皮肤风格', 'Admin', '2018-04-02 09:46:55', '127.0.0.1');
INSERT INTO `sys_acl` VALUES ('58', '20180402094826_98', '游戏管理', '63', '/get/gameManage', '1', '1', '1', '游戏管理', 'Admin', '2018-04-02 09:48:27', '127.0.0.1');
INSERT INTO `sys_acl` VALUES ('59', '20180402111639_82', '发送系统消息', '65', '/get/sendSysMessage', '1', '1', '1', '发送系统消息', 'Admin', '2018-04-02 11:16:40', '127.0.0.1');
INSERT INTO `sys_acl` VALUES ('60', '20180402111730_0', '已发送消息列表', '66', '/get/messageList', '1', '1', '1', '已发送消息列表', 'Admin', '2018-04-02 11:17:30', '127.0.0.1');
INSERT INTO `sys_acl` VALUES ('61', '20180402114233_0', '会费设置', '68', '/get/memberFee', '1', '1', '1', '会费设置', 'Admin', '2018-04-02 11:49:36', '127.0.0.1');
INSERT INTO `sys_acl` VALUES ('62', '20180402114505_0', '手续费设置', '69', '/get/serviceFee', '1', '1', '1', '会费设置', 'Admin', '2018-04-02 11:45:06', '127.0.0.1');
INSERT INTO `sys_acl` VALUES ('63', '20180402114612_2', '难度设置', '70', '/get/difficultySet', '1', '1', '1', '难度设置', 'Admin', '2018-04-02 11:46:13', '127.0.0.1');
INSERT INTO `sys_acl` VALUES ('64', '20180402114744_6', '教材设置', '71', '/get/textbookSet', '1', '1', '1', '教材设置', 'Admin', '2018-04-02 11:47:44', '127.0.0.1');
INSERT INTO `sys_acl` VALUES ('65', '20180402151151_19', '栏目管理', '41', '/get/columnManagement.page', '1', '1', '1', '/get/columnManagement.page', 'Admin', '2018-04-02 15:11:51', '127.0.0.1');
INSERT INTO `sys_acl` VALUES ('66', '20180403155840_35', '滚动广告-栏目管理', '43', '/get/getAds', '1', '1', '1', '滚动广告-栏目管理', 'Admin', '2018-04-03 15:58:41', '220.248.65.234');
INSERT INTO `sys_acl` VALUES ('67', '20180522151627_35', '分润统计报表', '53', '/get/ShareProfitCount', '1', '1', '5', '分润统计报', 'Admin', '2018-05-22 15:16:28', '127.0.0.1');
INSERT INTO `sys_acl` VALUES ('68', '20180522152133_73', '分润统计报表', '74', '/get/shareProfitCount', '1', '1', '1', '分润统计报表', 'Admin', '2018-05-22 15:24:02', '127.0.0.1');
INSERT INTO `sys_acl` VALUES ('69', '20180523180848_14', '积分管理', '76', '/get/integrationSet', '1', '1', '1', '积分管理', 'Admin', '2018-05-23 18:10:18', '127.0.0.1');
INSERT INTO `sys_acl` VALUES ('70', '20180523181107_2', '游戏积分管理', '77', '/get/gameintegrationSet', '1', '1', '1', '游戏积分管理', 'Admin', '2018-05-23 18:11:07', '127.0.0.1');
INSERT INTO `sys_acl` VALUES ('71', '20180606115301_32', '的方式', '79', '1dfsfsfsfsdfd', '1', '0', '1', '胜丰沙', 'Admin', '2018-06-06 12:25:06', '127.0.0.1');
INSERT INTO `sys_acl` VALUES ('72', '20180606122233_28', '积分获取记录', '79', '/get/getUserScoreDetail', '1', '1', '1', '积分获取记录', 'Admin', '2018-06-06 12:22:33', '127.0.0.1');
INSERT INTO `sys_acl` VALUES ('73', '20180606152151_75', '充值中心', '80', '/get/rechargeCenter', '1', '1', '1', '充值中心', 'Admin', '2018-06-14 19:52:09', '127.0.0.1');
INSERT INTO `sys_acl` VALUES ('74', '20180607153051_90', '增加服务商', '6', '/get/addService', '1', '1', '1', '增加服务商', 'Admin', '2018-06-07 15:30:52', '127.0.0.1');
INSERT INTO `sys_acl` VALUES ('75', '20180607153240_41', '增加服务商', '81', '/get/addService', '1', '1', '1', '增加服务商', 'Admin', '2018-06-07 15:32:41', '127.0.0.1');
INSERT INTO `sys_acl` VALUES ('76', '20180607153320_17', '增加机构', '82', '/get/addOrganization', '1', '1', '1', '增加机构', 'Admin', '2018-06-07 15:33:20', '127.0.0.1');
INSERT INTO `sys_acl` VALUES ('77', '20180608171831_76', '修改密码', '84', '/get/updatePassword', '1', '1', '1', '修改密码', 'Admin', '2018-06-08 17:18:32', '127.0.0.1');
INSERT INTO `sys_acl` VALUES ('78', '20180611172531_33', '计数器记录', '85', ' 	/get/getCountRecord', '1', '1', '1', '计数器记录', 'Admin2', '2018-06-11 17:25:32', '127.0.0.1');
INSERT INTO `sys_acl` VALUES ('79', '20180611180142_65', '基础练习记录', '86', '/get/getSongRecord', '1', '1', '1', '基础练习记录', 'Admin2', '2018-06-11 18:01:42', '127.0.0.1');
INSERT INTO `sys_acl` VALUES ('80', '20180612094830_48', '会费缴纳详情', '6', '/get/getMembershipDues', '1', '1', '1', '会费缴纳详情', 'Admin', '2018-06-12 09:48:30', '127.0.0.1');
INSERT INTO `sys_acl` VALUES ('81', '20180612094922_38', '会费缴纳详情', '88', '/get/getMembershipDues', '1', '1', '1', '会费缴纳详情', 'Admin', '2018-06-12 09:49:23', '127.0.0.1');
INSERT INTO `sys_acl` VALUES ('82', '20180612145434_80', '我的账户', '90', '/get/getMyUserXinxi', '1', '1', '1', '我的账户', 'Admin', '2018-06-12 14:54:34', '127.0.0.1');
INSERT INTO `sys_acl` VALUES ('83', '20180613165558_97', '过渡界面上传图片', '92', '/get/uploadPicture', '1', '1', '1', '过渡界面上传图片', 'Admin3', '2018-06-13 16:55:58', '127.0.0.1');
INSERT INTO `sys_acl` VALUES ('84', '20180614144223_57', '机构绑定琴行', '93', '/get/addOrganizationByPianoShop', '1', '1', '1', '机构绑定琴行', 'Admin1', '2018-06-14 14:46:26', '127.0.0.1');

-- ----------------------------
-- Table structure for `sys_acl_module`
-- ----------------------------
DROP TABLE IF EXISTS `sys_acl_module`;
CREATE TABLE `sys_acl_module` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '权限模块id',
  `name` varchar(20) NOT NULL DEFAULT '' COMMENT '权限模块名称',
  `parent_id` int(11) NOT NULL DEFAULT '0' COMMENT '上级权限模块id',
  `level` varchar(200) NOT NULL DEFAULT '' COMMENT '权限模块层级',
  `seq` int(11) NOT NULL DEFAULT '0' COMMENT '权限模块在当前层级下的顺序，由小到大',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '状态，1：正常，0：冻结',
  `remark` varchar(200) DEFAULT '' COMMENT '备注',
  `operator` varchar(20) NOT NULL DEFAULT '' COMMENT '操作者',
  `operate_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次操作时间',
  `operate_ip` varchar(20) NOT NULL DEFAULT '' COMMENT '最后一次更新操作者的ip地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=94 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_acl_module
-- ----------------------------
INSERT INTO `sys_acl_module` VALUES ('6', '权限管理', '0', '0', '1', '1', '', 'Admin', '2018-03-26 12:11:20', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES ('7', '权限管理', '6', '0.6', '1', '1', '', 'Admin', '2017-10-15 21:27:57', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_acl_module` VALUES ('8', '角色管理', '6', '0.6', '2', '1', '', 'Admin', '2017-10-15 21:28:22', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_acl_module` VALUES ('9', '用户管理', '6', '0.6', '2', '1', '', 'Admin', '2017-10-15 21:28:36', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_acl_module` VALUES ('11', '权限更新记录管理', '6', '0.6', '4', '1', '', 'Admin', '2017-10-16 23:04:07', '0:0:0:0:0:0:0:1');
INSERT INTO `sys_acl_module` VALUES ('12', '会员管理', '0', '0', '2', '1', '会员管理', 'Admin', '2018-03-26 12:11:34', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES ('13', '学生等级', '12', '0.12', '1', '1', '学生等级', 'Admin', '2018-03-27 10:52:32', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES ('16', '游戏管理', '0', '0', '15', '1', '游戏管理', 'Admin', '2018-06-13 20:47:26', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES ('17', '游戏记录查看', '16', '0.16', '1', '1', '', 'Admin', '2018-03-26 18:19:45', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES ('18', '琴行规模', '12', '0.12', '1', '1', '琴行规模', 'Admin', '2018-03-27 15:53:44', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES ('19', '机构管理', '12', '0.12', '3', '1', '机构管理', 'Admin', '2018-03-27 10:59:41', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES ('20', '琴行管理', '12', '0.12', '4', '1', '琴行管理', 'Admin', '2018-03-27 11:11:47', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES ('21', '家长管理', '12', '0.12', '5', '1', '家长管理', 'Admin', '2018-03-27 11:14:04', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES ('22', '学生管理', '12', '0.12', '6', '1', '学生管理', 'Admin', '2018-03-27 11:51:15', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES ('23', '老师管理', '12', '0.12', '7', '1', '老师管理', 'Admin', '2018-03-27 11:59:14', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES ('24', '待审核会员', '12', '0.12', '8', '1', '待审核会员', 'Admin', '2018-03-27 12:12:42', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES ('25', '充值', '0', '0', '4', '1', '充值', 'Admin', '2018-03-27 14:11:25', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES ('26', '充值明细', '25', '0.25', '1', '1', '充值明细', 'Admin', '2018-03-27 14:12:33', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES ('27', '充值管理', '25', '0.25', '2', '1', '充值管理', 'Admin', '2018-03-27 14:15:39', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES ('28', '消费', '0', '0', '5', '1', '消费', 'Admin', '2018-03-27 14:21:30', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES ('29', '消费明细', '28', '0.28', '1', '1', '消费明细', 'Admin', '2018-03-27 14:25:46', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES ('30', '添加老师', '12', '0.12', '11', '1', '添加老师', 'Admin', '2018-06-07 15:29:43', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES ('31', '教务系统', '0', '0', '6', '1', '教务系统', 'Admin', '2018-03-29 11:25:54', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES ('32', '服务商管理', '0', '0', '7', '1', '服务商管理', 'Admin', '2018-03-29 11:26:08', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES ('33', '作业管理', '31', '0.31', '1', '1', '作业管理', 'Admin', '2018-03-29 11:27:34', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES ('34', '评语管理', '31', '0.31', '2', '1', '评语管理', 'Admin', '2018-03-29 11:28:22', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES ('35', '学生点评', '31', '0.31', '3', '1', '学生点评', 'Admin', '2018-03-29 11:33:43', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES ('36', '家长给老师的寄语', '0', '0', '7', '1', '家长给老师的寄语', 'Admin', '2018-03-29 12:01:00', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES ('37', '家长给老师的寄语', '36', '0.36', '1', '1', '家长给老师的寄语', 'Admin', '2018-03-29 12:02:08', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES ('38', 'CMS管理', '0', '0', '8', '1', 'CMS管理', 'Admin', '2018-03-29 14:09:10', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES ('41', '滚动广告位', '38', '0.38', '1', '1', '滚动广告位', 'Admin', '2018-03-29 14:11:40', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES ('42', '热门广告位', '38', '0.38', '1', '1', '热门广告位', 'Admin', '2018-03-29 14:12:28', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES ('43', '栏目管理', '41', '0.38.41', '1', '1', '滚动广告--栏目管理', 'Admin', '2018-03-29 14:58:25', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES ('44', '内容管理', '41', '0.38.41', '1', '1', '滚动广告位-内容管理', 'Admin', '2018-03-29 14:59:31', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES ('45', '栏目管理', '42', '0.38.42', '1', '1', '热门广告 --内容管理', 'Admin', '2018-03-29 15:48:52', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES ('46', '教材管理', '0', '0', '10', '1', '教材管理', 'Admin', '2018-03-29 16:43:27', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES ('47', '阶段管理', '46', '0.46', '1', '1', '阶段管理', 'Admin', '2018-03-29 16:44:18', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES ('48', '风格管理', '46', '0.46', '2', '1', '风格管理', 'Admin', '2018-03-29 16:49:39', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES ('49', '教材管理', '46', '0.46', '3', '1', '教材管理', 'Admin', '2018-03-29 16:50:15', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES ('50', '曲谱管理', '46', '0.46', '4', '1', '曲谱管理', 'Admin', '2018-03-29 16:51:05', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES ('51', '提现管理', '0', '0', '11', '1', '提现管理', 'Admin', '2018-03-29 18:46:16', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES ('52', '提现审批', '51', '0.51', '1', '1', '提现审批', 'Admin', '2018-03-29 18:46:38', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES ('53', '分润系统', '0', '0', '12', '1', '分润系统', 'Admin', '2018-03-29 19:02:09', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES ('54', '分润设置', '53', '0.53', '1', '1', '分润设置', 'Admin', '2018-03-30 16:11:00', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES ('55', '银行卡', '53', '0.53', '2', '1', '银行卡', 'Admin', '2018-03-30 16:37:23', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES ('56', '收入明细', '53', '0.53', '3', '1', '收入明细', 'Admin', '2018-03-30 16:40:22', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES ('57', '余额提现申请', '53', '0.53', '4', '1', '余额提现申请', 'Admin', '2018-03-30 16:44:23', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES ('58', '服务商管理', '12', '0.12', '2', '1', '服务商管理', 'Admin', '2018-03-30 18:01:45', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES ('59', '商城管理', '0', '0', '14', '1', '商城管理', 'lingbin', '2018-05-25 19:41:47', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES ('60', '皮肤类型', '59', '0.59', '1', '1', '皮肤类型', 'Admin', '2018-04-02 09:42:09', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES ('61', '皮肤风格', '59', '0.59', '2', '1', '皮肤风格', 'Admin', '2018-03-30 19:32:33', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES ('62', '皮肤管理', '59', '0.59', '1', '1', '皮肤管理', 'Admin', '2018-03-30 19:33:00', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES ('63', '游戏管理', '59', '0.59', '4', '0', '游戏管理', 'Admin', '2018-06-13 20:49:30', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES ('64', '消息管理', '0', '0', '15', '1', '消息管理', 'Admin', '2018-05-23 18:06:57', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES ('65', '发送系统消息', '64', '0.64', '1', '1', '发送系统消息', 'Admin', '2018-04-02 11:14:45', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES ('66', '已发送消息列表', '64', '0.64', '2', '1', '已发送消息列表', 'Admin', '2018-04-02 11:15:27', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES ('67', '参数设置', '0', '0', '20', '1', '参数设置', 'Admin', '2018-05-23 18:06:18', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES ('68', '会费设置', '67', '0.67', '1', '1', '会费设置', 'Admin', '2018-04-02 11:36:58', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES ('69', '手续费设置', '67', '0.67', '2', '1', '手续费设置', 'Admin', '2018-04-02 11:37:33', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES ('70', '难度设置', '67', '0.67', '3', '1', '难度设置', 'Admin', '2018-04-02 11:38:06', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES ('71', '教材设置', '67', '0.67', '4', '1', '教材设置', 'Admin', '2018-04-02 11:39:19', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES ('72', '区域管理', '67', '0.67', '5', '1', '区域管理', 'Admin', '2018-04-02 11:39:56', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES ('74', '分润统计报表', '53', '0.53', '5', '1', '分润统计报表', 'Admin', '2018-05-22 15:20:13', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES ('75', '积分管理', '0', '0', '19', '1', '积分管理', 'Admin', '2018-05-23 18:06:31', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES ('76', '积分管理', '75', '0.75', '1', '1', '积分管理', 'Admin', '2018-05-23 18:09:28', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES ('77', '游戏积分管理', '75', '0.75', '2', '1', '游戏积分管理', 'Admin', '2018-05-23 18:09:56', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES ('78', '积分记录管理', '0', '0', '18', '1', '积分记录管理', 'Admin', '2018-06-06 11:44:29', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES ('79', '积分获取记录', '78', '0.78', '1', '1', '积分获取记录', 'Admin', '2018-06-06 12:27:13', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES ('80', '充值中心', '25', '0.25', '3', '1', '充值中心', 'Admin', '2018-06-06 15:19:47', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES ('81', '增加服务商', '12', '0.12', '9', '1', '增加服务商', 'Admin', '2018-06-07 15:28:25', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES ('82', '增加机构', '12', '0.12', '10', '1', '增加机构', 'Admin', '2018-06-07 15:29:30', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES ('83', '个人中心', '0', '0', '22', '1', '个人中心', 'Admin', '2018-06-08 17:11:36', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES ('84', '修改账户密码', '83', '0.83', '1', '1', '修改账户密码', 'Admin', '2018-06-08 17:12:42', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES ('85', '计数器记录', '78', '0.78', '3', '1', '计数器记录', 'Admin2', '2018-06-11 16:29:36', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES ('86', '基础练习记录', '78', '0.78', '4', '1', '基础练习记录', 'Admin2', '2018-06-11 17:59:23', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES ('87', '会费缴纳', '0', '0', '23', '1', '会费缴纳', 'Admin3', '2018-06-12 09:45:45', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES ('88', '会费缴纳详情', '87', '0.87', '1', '1', '会费缴纳详情', 'Admin', '2018-06-11 20:01:16', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES ('90', '我的账户', '53', '0.53', '7', '1', '我的账户', 'Admin', '2018-06-12 14:53:42', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES ('91', '过渡界面管理', '0', '0', '29', '1', '过渡界面管理', 'Admin3', '2018-06-13 16:48:25', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES ('92', '过渡界面上传图片', '91', '0.91', '1', '1', '过渡界面上传图片', 'Admin3', '2018-06-13 16:50:15', '127.0.0.1');
INSERT INTO `sys_acl_module` VALUES ('93', '机构绑定琴行', '12', '0.12', '10', '1', '机构绑定琴行', 'Admin', '2018-06-14 14:38:42', '127.0.0.1');

-- ----------------------------
-- Table structure for `sys_dept`
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户组id',
  `name` varchar(20) NOT NULL DEFAULT '' COMMENT '用户组名称',
  `parent_id` int(11) NOT NULL DEFAULT '0' COMMENT '上级用户组id',
  `level` varchar(200) NOT NULL DEFAULT '' COMMENT '用户组层级',
  `seq` int(11) NOT NULL DEFAULT '0' COMMENT '部门在当前层级下的顺序，由小到大',
  `remark` varchar(200) DEFAULT '' COMMENT '备注',
  `operator` varchar(20) NOT NULL DEFAULT '' COMMENT '操作者',
  `operate_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次操作时间',
  `operate_ip` varchar(20) NOT NULL DEFAULT '' COMMENT '最后一次更新操作者的ip地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES ('1', '技术', '0', '0', '1', '技术部', 'Admin', '2018-03-25 18:14:47', '127.0.0.1');
INSERT INTO `sys_dept` VALUES ('12', '客服', '0', '0', '4', '', 'Admin', '2018-03-25 18:14:53', '127.0.0.1');
INSERT INTO `sys_dept` VALUES ('13', '测试', '0', '0', '1', '', 'Admin', '2018-03-25 18:14:40', '127.0.0.1');

-- ----------------------------
-- Table structure for `sys_log`
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` int(11) NOT NULL DEFAULT '0' COMMENT '权限更新的类型，1：部门，2：用户，3：权限模块，4：权限，5：角色，6：角色用户关系，7：角色权限关系',
  `target_id` int(11) NOT NULL COMMENT '基于type后指定的对象id，比如用户、权限、角色等表的主键',
  `old_value` text COMMENT '旧值',
  `new_value` text COMMENT '新值',
  `operator` varchar(20) NOT NULL DEFAULT '' COMMENT '操作者',
  `operate_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次更新的时间',
  `operate_ip` varchar(20) NOT NULL DEFAULT '' COMMENT '最后一次更新者的ip地址',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '当前是否复原过，0：没有，1：复原过',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=328 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES ('2', '1', '12', '', '{\"id\":12,\"name\":\"客服部\",\"parentId\":0,\"level\":\"0\",\"seq\":3,\"operator\":\"Admin\",\"operateTime\":1508166002610,\"operateIp\":\"0:0:0:0:0:0:0:1\"}', 'Admin', '2017-10-16 23:00:03', '0:0:0:0:0:0:0:1', '1');
INSERT INTO `sys_log` VALUES ('3', '1', '12', '{\"id\":12,\"name\":\"客服部\",\"parentId\":0,\"level\":\"0\",\"seq\":3,\"operator\":\"Admin\",\"operateTime\":1508166003000,\"operateIp\":\"0:0:0:0:0:0:0:1\"}', '{\"id\":12,\"name\":\"客服部\",\"parentId\":0,\"level\":\"0\",\"seq\":4,\"operator\":\"Admin\",\"operateTime\":1508166009313,\"operateIp\":\"0:0:0:0:0:0:0:1\"}', 'Admin', '2017-10-16 23:00:09', '0:0:0:0:0:0:0:1', '1');
INSERT INTO `sys_log` VALUES ('4', '2', '4', '', '{\"id\":4,\"username\":\"Kate\",\"telephone\":\"13144445555\",\"mail\":\"kate@qq.com\",\"password\":\"25D55AD283AA400AF464C76D713C07AD\",\"deptId\":1,\"status\":1,\"operator\":\"Admin\",\"operateTime\":1508166166297,\"operateIp\":\"0:0:0:0:0:0:0:1\"}', 'Admin', '2017-10-16 23:02:46', '0:0:0:0:0:0:0:1', '1');
INSERT INTO `sys_log` VALUES ('5', '2', '4', '{\"id\":4,\"username\":\"Kate\",\"telephone\":\"13144445555\",\"mail\":\"kate@qq.com\",\"password\":\"25D55AD283AA400AF464C76D713C07AD\",\"deptId\":1,\"status\":1,\"operator\":\"Admin\",\"operateTime\":1508166166000,\"operateIp\":\"0:0:0:0:0:0:0:1\"}', '{\"id\":4,\"username\":\"Kate\",\"telephone\":\"13144445555\",\"mail\":\"kate@qq.com\",\"deptId\":1,\"status\":1,\"remark\":\"sss\",\"operator\":\"Admin\",\"operateTime\":1508166171320,\"operateIp\":\"0:0:0:0:0:0:0:1\"}', 'Admin', '2017-10-16 23:02:51', '0:0:0:0:0:0:0:1', '1');
INSERT INTO `sys_log` VALUES ('6', '3', '10', '', '{\"id\":10,\"name\":\"运维管理\",\"parentId\":0,\"level\":\"0\",\"seq\":5,\"status\":1,\"operator\":\"Admin\",\"operateTime\":1508166212527,\"operateIp\":\"0:0:0:0:0:0:0:1\"}', 'Admin', '2017-10-16 23:03:33', '0:0:0:0:0:0:0:1', '1');
INSERT INTO `sys_log` VALUES ('7', '3', '10', '{\"id\":10,\"name\":\"运维管理\",\"parentId\":0,\"level\":\"0\",\"seq\":5,\"status\":1,\"operator\":\"Admin\",\"operateTime\":1508166213000,\"operateIp\":\"0:0:0:0:0:0:0:1\"}', '{\"id\":10,\"name\":\"运维管理\",\"parentId\":0,\"level\":\"0\",\"seq\":6,\"status\":1,\"operator\":\"Admin\",\"operateTime\":1508166217376,\"operateIp\":\"0:0:0:0:0:0:0:1\"}', 'Admin', '2017-10-16 23:03:37', '0:0:0:0:0:0:0:1', '1');
INSERT INTO `sys_log` VALUES ('8', '3', '11', '', '{\"id\":11,\"name\":\"权限更新记录管理\",\"parentId\":6,\"level\":\"0.6\",\"seq\":4,\"status\":1,\"operator\":\"Admin\",\"operateTime\":1508166246805,\"operateIp\":\"0:0:0:0:0:0:0:1\"}', 'Admin', '2017-10-16 23:04:07', '0:0:0:0:0:0:0:1', '1');
INSERT INTO `sys_log` VALUES ('9', '4', '10', '', '{\"id\":10,\"code\":\"20171016230429_8\",\"name\":\"进入权限更新记录页面\",\"aclModuleId\":1,\"url\":\"/sys/log/log.page\",\"type\":1,\"status\":1,\"seq\":1,\"operator\":\"Admin\",\"operateTime\":1508166269419,\"operateIp\":\"0:0:0:0:0:0:0:1\"}', 'Admin', '2017-10-16 23:04:29', '0:0:0:0:0:0:0:1', '1');
INSERT INTO `sys_log` VALUES ('10', '4', '10', '{\"id\":10,\"code\":\"20171016230429_8\",\"name\":\"进入权限更新记录页面\",\"aclModuleId\":1,\"url\":\"/sys/log/log.page\",\"type\":1,\"status\":1,\"seq\":1,\"operator\":\"Admin\",\"operateTime\":1508166269000,\"operateIp\":\"0:0:0:0:0:0:0:1\"}', '{\"id\":10,\"name\":\"进入权限更新记录页面\",\"aclModuleId\":11,\"url\":\"/sys/log/log.page\",\"type\":1,\"status\":1,\"seq\":1,\"operator\":\"Admin\",\"operateTime\":1508166288589,\"operateIp\":\"0:0:0:0:0:0:0:1\"}', 'Admin', '2017-10-16 23:04:49', '0:0:0:0:0:0:0:1', '1');
INSERT INTO `sys_log` VALUES ('11', '5', '5', '', '{\"id\":5,\"name\":\"运维管理员\",\"type\":1,\"status\":1,\"operator\":\"Admin\",\"operateTime\":1508166301130,\"operateIp\":\"0:0:0:0:0:0:0:1\"}', 'Admin', '2017-10-16 23:05:01', '0:0:0:0:0:0:0:1', '1');
INSERT INTO `sys_log` VALUES ('12', '5', '5', '{\"id\":5,\"name\":\"运维管理员\",\"type\":1,\"status\":1,\"operator\":\"Admin\",\"operateTime\":1508166301000,\"operateIp\":\"0:0:0:0:0:0:0:1\"}', '{\"id\":5,\"name\":\"运维管理员\",\"type\":1,\"status\":1,\"remark\":\"运维\",\"operator\":\"Admin\",\"operateTime\":1508166307317,\"operateIp\":\"0:0:0:0:0:0:0:1\"}', 'Admin', '2017-10-16 23:05:07', '0:0:0:0:0:0:0:1', '1');
INSERT INTO `sys_log` VALUES ('13', '6', '4', '[7,8,9]', '[7,8,9,10]', 'Admin', '2017-10-16 23:34:39', '0:0:0:0:0:0:0:1', '1');
INSERT INTO `sys_log` VALUES ('14', '7', '4', '[1]', '[1,4]', 'Admin', '2017-10-16 23:34:44', '0:0:0:0:0:0:0:1', '1');
INSERT INTO `sys_log` VALUES ('15', '2', '5', '', '{\"id\":5,\"username\":\"服务员A\",\"telephone\":\"18677778888\",\"mail\":\"service@qq.com\",\"password\":\"25D55AD283AA400AF464C76D713C07AD\",\"deptId\":12,\"status\":1,\"operator\":\"Admin\",\"operateTime\":1508170918338,\"operateIp\":\"0:0:0:0:0:0:0:1\"}', 'Admin', '2017-10-17 00:21:58', '0:0:0:0:0:0:0:1', '1');
INSERT INTO `sys_log` VALUES ('16', '2', '5', '{\"id\":5,\"username\":\"服务员A\",\"telephone\":\"18677778888\",\"mail\":\"service@qq.com\",\"password\":\"25D55AD283AA400AF464C76D713C07AD\",\"deptId\":12,\"status\":1,\"operator\":\"Admin\",\"operateTime\":1508170918000,\"operateIp\":\"0:0:0:0:0:0:0:1\"}', '{\"id\":5,\"username\":\"服务员B\",\"telephone\":\"18677778888\",\"mail\":\"service@qq.com\",\"deptId\":12,\"status\":1,\"operator\":\"Admin\",\"operateTime\":1508170924698,\"operateIp\":\"0:0:0:0:0:0:0:1\"}', 'Admin', '2017-10-17 00:22:05', '0:0:0:0:0:0:0:1', '1');
INSERT INTO `sys_log` VALUES ('17', '2', '5', '{\"id\":5,\"username\":\"服务员B\",\"telephone\":\"18677778888\",\"mail\":\"service@qq.com\",\"password\":\"25D55AD283AA400AF464C76D713C07AD\",\"deptId\":12,\"status\":1,\"operator\":\"Admin\",\"operateTime\":1508170925000,\"operateIp\":\"0:0:0:0:0:0:0:1\"}', '{\"id\":5,\"username\":\"服务员A\",\"telephone\":\"18677778888\",\"mail\":\"service@qq.com\",\"password\":\"25D55AD283AA400AF464C76D713C07AD\",\"deptId\":12,\"status\":1,\"operator\":\"Admin\",\"operateTime\":1508170934791,\"operateIp\":\"0:0:0:0:0:0:0:1\"}', 'Admin', '2017-10-17 00:22:15', '0:0:0:0:0:0:0:1', '1');
INSERT INTO `sys_log` VALUES ('18', '1', '12', '{\"id\":12,\"name\":\"客服部\",\"parentId\":0,\"level\":\"0\",\"seq\":4,\"operator\":\"Admin\",\"operateTime\":1508166009000,\"operateIp\":\"0:0:0:0:0:0:0:1\"}', '{\"id\":12,\"name\":\"客服部A\",\"parentId\":0,\"level\":\"0\",\"seq\":4,\"operator\":\"Admin\",\"operateTime\":1508170966051,\"operateIp\":\"0:0:0:0:0:0:0:1\"}', 'Admin', '2017-10-17 00:22:46', '0:0:0:0:0:0:0:1', '1');
INSERT INTO `sys_log` VALUES ('19', '1', '12', '{\"id\":12,\"name\":\"客服部A\",\"parentId\":0,\"level\":\"0\",\"seq\":4,\"operator\":\"Admin\",\"operateTime\":1508170966000,\"operateIp\":\"0:0:0:0:0:0:0:1\"}', '{\"id\":12,\"name\":\"客服部\",\"parentId\":0,\"level\":\"0\",\"seq\":4,\"operator\":\"Admin\",\"operateTime\":1508170975242,\"operateIp\":\"0:0:0:0:0:0:0:1\"}', 'Admin', '2017-10-17 00:22:55', '0:0:0:0:0:0:0:1', '1');
INSERT INTO `sys_log` VALUES ('20', '5', '5', '{\"id\":5,\"name\":\"运维管理员\",\"type\":1,\"status\":1,\"remark\":\"运维\",\"operator\":\"Admin\",\"operateTime\":1508166307000,\"operateIp\":\"0:0:0:0:0:0:0:1\"}', '{\"id\":5,\"name\":\"运维管理员A\",\"type\":1,\"status\":1,\"remark\":\"运维\",\"operator\":\"Admin\",\"operateTime\":1508170997531,\"operateIp\":\"0:0:0:0:0:0:0:1\"}', 'Admin', '2017-10-17 00:23:18', '0:0:0:0:0:0:0:1', '1');
INSERT INTO `sys_log` VALUES ('21', '5', '5', '{\"id\":5,\"name\":\"运维管理员A\",\"type\":1,\"status\":1,\"remark\":\"运维\",\"operator\":\"Admin\",\"operateTime\":1508170998000,\"operateIp\":\"0:0:0:0:0:0:0:1\"}', '{\"id\":5,\"name\":\"运维管理员\",\"type\":1,\"status\":1,\"remark\":\"运维\",\"operator\":\"Admin\",\"operateTime\":1508171007651,\"operateIp\":\"0:0:0:0:0:0:0:1\"}', 'Admin', '2017-10-17 00:23:28', '0:0:0:0:0:0:0:1', '1');
INSERT INTO `sys_log` VALUES ('22', '7', '4', '[1,4]', '[1,4,2,3,5]', 'Admin', '2017-10-17 00:23:53', '0:0:0:0:0:0:0:1', '1');
INSERT INTO `sys_log` VALUES ('23', '7', '4', '[1,4,2,3,5]', '[1,4]', 'Admin', '2017-10-17 00:24:04', '0:0:0:0:0:0:0:1', '1');
INSERT INTO `sys_log` VALUES ('24', '6', '5', '[]', '[7,8,9,10]', 'Admin', '2017-10-17 00:24:23', '0:0:0:0:0:0:0:1', '1');
INSERT INTO `sys_log` VALUES ('25', '6', '5', '[7,8,9,10]', '[]', 'Admin', '2017-10-17 00:24:34', '0:0:0:0:0:0:0:1', '1');
INSERT INTO `sys_log` VALUES ('26', '7', '4', '[1,4]', '[1]', 'Admin', '2018-03-24 23:01:24', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('27', '2', '6', '', '{\"id\":6,\"username\":\"zhang\",\"telephone\":\"18326917091\",\"mail\":\"zhang@qqq.com\",\"password\":\"25D55AD283AA400AF464C76D713C07AD\",\"deptId\":1,\"status\":1,\"remark\":\"cehi\",\"operator\":\"Admin\",\"operateTime\":1521904202989,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-24 23:10:03', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('28', '7', '4', '[1]', '[1,6]', 'Admin', '2018-03-24 23:13:41', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('29', '7', '4', '[1,6]', '[1]', 'zhang', '2018-03-24 23:44:44', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('30', '7', '4', '[1]', '[1,6]', 'Admin', '2018-03-25 12:09:40', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('31', '6', '4', '[7,8,9,10]', '[1,2,3,4,5,6,7,8,9,10]', 'Admin', '2018-03-25 14:13:20', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('32', '3', '12', '', '{\"id\":12,\"name\":\"会员管理\",\"parentId\":0,\"level\":\"0\",\"seq\":1,\"status\":1,\"remark\":\"会员管理\",\"operator\":\"Admin\",\"operateTime\":1521958453629,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-25 14:14:14', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('33', '4', '11', '', '{\"id\":11,\"code\":\"20180325141606_80\",\"name\":\"查看所有会员信息\",\"aclModuleId\":12,\"url\":\"/sys/getUser\",\"type\":1,\"status\":1,\"seq\":1,\"operator\":\"Admin\",\"operateTime\":1521958566012,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-25 14:16:06', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('34', '3', '13', '', '{\"id\":13,\"name\":\"所有会员信息\",\"parentId\":12,\"level\":\"0.12\",\"seq\":1,\"status\":1,\"operator\":\"Admin\",\"operateTime\":1521958688637,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-25 14:18:09', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('35', '4', '11', '{\"id\":11,\"code\":\"20180325141606_80\",\"name\":\"查看所有会员信息\",\"aclModuleId\":12,\"url\":\"/sys/getUser\",\"type\":1,\"status\":1,\"seq\":1,\"operator\":\"Admin\",\"operateTime\":1521958566000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":11,\"name\":\"查看所有会员信息\",\"aclModuleId\":13,\"url\":\"/sys/getUser\",\"type\":1,\"status\":1,\"seq\":1,\"operator\":\"Admin\",\"operateTime\":1521958699163,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-25 14:18:19', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('36', '1', '13', '', '{\"id\":13,\"name\":\"测试\",\"parentId\":0,\"level\":\"0\",\"seq\":1,\"operator\":\"Admin\",\"operateTime\":1521972880053,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-25 18:14:40', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('37', '1', '1', '{\"id\":1,\"name\":\"技术部\",\"parentId\":0,\"level\":\"0\",\"seq\":1,\"remark\":\"技术部\",\"operator\":\"system\",\"operateTime\":1507677700000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":1,\"name\":\"技术\",\"parentId\":0,\"level\":\"0\",\"seq\":1,\"remark\":\"技术部\",\"operator\":\"Admin\",\"operateTime\":1521972886750,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-25 18:14:47', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('38', '1', '12', '{\"id\":12,\"name\":\"客服部\",\"parentId\":0,\"level\":\"0\",\"seq\":4,\"operator\":\"Admin\",\"operateTime\":1508170975000,\"operateIp\":\"0:0:0:0:0:0:0:1\"}', '{\"id\":12,\"name\":\"客服\",\"parentId\":0,\"level\":\"0\",\"seq\":4,\"operator\":\"Admin\",\"operateTime\":1521972893197,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-25 18:14:53', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('39', '6', '5', '[]', '[7,8,9,10]', 'Admin', '2018-03-25 18:15:15', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('40', '7', '5', '[]', '[2]', 'Admin', '2018-03-25 18:22:25', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('41', '7', '5', '[2]', '[]', 'Admin', '2018-03-25 18:22:33', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('42', '2', '7', '', '{\"id\":7,\"username\":\"测试管理员\",\"telephone\":\"18018581072\",\"mail\":\"ceshi@qq.com\",\"password\":\"D0FB920DB99F4054DF948E177DB3E69D\",\"deptId\":13,\"status\":1,\"remark\":\"aaa\",\"operator\":\"Admin\",\"operateTime\":1521981996291,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-25 20:46:37', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('43', '2', '7', '{\"id\":7,\"username\":\"测试管理员\",\"telephone\":\"18018581072\",\"mail\":\"ceshi@qq.com\",\"password\":\"D0FB920DB99F4054DF948E177DB3E69D\",\"deptId\":13,\"status\":1,\"remark\":\"aaa\",\"operator\":\"Admin\",\"operateTime\":1521981996000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":7,\"username\":\"测试管理员\",\"telephone\":\"18018581072\",\"mail\":\"ceshi@qq.com\",\"deptId\":13,\"status\":1,\"remark\":\"ceshi987654321\",\"operator\":\"Admin\",\"operateTime\":1521982796378,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-25 20:59:56', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('44', '2', '7', '{\"id\":7,\"username\":\"测试管理员\",\"telephone\":\"18018581072\",\"mail\":\"ceshi@qq.com\",\"password\":\"D0FB920DB99F4054DF948E177DB3E69D\",\"deptId\":13,\"status\":1,\"remark\":\"ceshi987654321\",\"operator\":\"Admin\",\"operateTime\":1521982796000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":7,\"username\":\"测试管理员\",\"telephone\":\"18018581072\",\"mail\":\"ceshi@qq.com\",\"password\":\"ceshi987654321\",\"deptId\":13,\"status\":1,\"remark\":\"ceshi987654321\",\"operator\":\"Admin\",\"operateTime\":1521984423323,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-25 21:27:03', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('45', '2', '7', '{\"id\":7,\"username\":\"测试管理员\",\"telephone\":\"18018581072\",\"mail\":\"ceshi@qq.com\",\"password\":\"ceshi987654321\",\"deptId\":13,\"status\":1,\"remark\":\"ceshi987654321\",\"operator\":\"Admin\",\"operateTime\":1521984423000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":7,\"username\":\"测试管理员\",\"telephone\":\"18018581072\",\"mail\":\"ceshi@qq.com\",\"password\":\"BA00662F5B53D8A3FDC3A4156226805C\",\"deptId\":13,\"status\":1,\"remark\":\"ceshi987654321\",\"operator\":\"Admin\",\"operateTime\":1521985164617,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-25 21:39:25', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('46', '3', '14', '', '{\"id\":14,\"name\":\"ces\",\"parentId\":13,\"level\":\"0.12.13\",\"seq\":1,\"status\":1,\"operator\":\"Admin\",\"operateTime\":1521994064821,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-26 00:07:45', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('47', '3', '15', '', '{\"id\":15,\"name\":\"权限测试1\",\"parentId\":7,\"level\":\"0.6.7\",\"seq\":1,\"status\":1,\"operator\":\"Admin\",\"operateTime\":1521994105131,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-26 00:08:25', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('48', '6', '5', '[7,8,9,10]', '[]', 'zhang', '2018-03-26 11:19:13', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('49', '6', '5', '[]', '[7,8,9,10]', 'Admin', '2018-03-26 12:05:59', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('50', '7', '5', '[]', '[6]', 'Admin', '2018-03-26 12:06:25', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('51', '7', '4', '[1,6]', '[1]', 'zhang', '2018-03-26 12:07:46', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('52', '7', '5', '[6]', '[]', 'zhang', '2018-03-26 12:09:36', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('53', '3', '6', '{\"id\":6,\"name\":\"权限管理\",\"parentId\":0,\"level\":\"0\",\"seq\":4,\"status\":1,\"operator\":\"Admin\",\"operateTime\":1508074057000,\"operateIp\":\"0:0:0:0:0:0:0:1\"}', '{\"id\":6,\"name\":\"权限管理\",\"parentId\":0,\"level\":\"0\",\"seq\":1,\"status\":1,\"operator\":\"Admin\",\"operateTime\":1522037480187,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-26 12:11:20', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('54', '3', '12', '{\"id\":12,\"name\":\"会员管理\",\"parentId\":0,\"level\":\"0\",\"seq\":1,\"status\":1,\"remark\":\"会员管理\",\"operator\":\"Admin\",\"operateTime\":1521958454000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":12,\"name\":\"会员管理\",\"parentId\":0,\"level\":\"0\",\"seq\":2,\"status\":1,\"remark\":\"会员管理\",\"operator\":\"Admin\",\"operateTime\":1522037494485,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-26 12:11:34', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('55', '5', '3', '{\"id\":3,\"name\":\"公告管理员\",\"type\":1,\"status\":1,\"operator\":\"Admin\",\"operateTime\":1508041150000,\"operateIp\":\"0:0:0:0:0:0:0:1\"}', '{\"id\":3,\"name\":\"会员管理员\",\"type\":1,\"status\":1,\"operator\":\"Admin\",\"operateTime\":1522037540524,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-26 12:12:21', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('56', '6', '3', '[]', '[11]', 'Admin', '2018-03-26 12:12:34', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('57', '6', '4', '[1,2,3,4,5,6,7,8,9,10]', '[7,8,9,10,11]', 'Admin', '2018-03-26 12:12:42', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('58', '7', '3', '[]', '[6]', 'Admin', '2018-03-26 12:12:57', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('59', '6', '3', '[11]', '[7,8,9,10]', 'Admin', '2018-03-26 17:05:53', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('60', '3', '16', '', '{\"id\":16,\"name\":\"游戏管理\",\"parentId\":0,\"level\":\"0\",\"seq\":1,\"status\":1,\"remark\":\"游戏管理\",\"operator\":\"Admin\",\"operateTime\":1522059571376,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-26 18:19:31', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('61', '3', '17', '', '{\"id\":17,\"name\":\"游戏记录查看\",\"parentId\":16,\"level\":\"0.16\",\"seq\":1,\"status\":1,\"operator\":\"Admin\",\"operateTime\":1522059584682,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-26 18:19:45', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('62', '4', '12', '', '{\"id\":12,\"code\":\"20180326182037_92\",\"name\":\"游戏记录查看\",\"aclModuleId\":6,\"url\":\"/game/getll.page\",\"type\":1,\"status\":1,\"seq\":1,\"operator\":\"Admin\",\"operateTime\":1522059637548,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-26 18:20:38', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('63', '4', '13', '', '{\"id\":13,\"code\":\"20180326182138_79\",\"name\":\"游戏记录查看\",\"aclModuleId\":17,\"url\":\"/game/getall.page\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"1\",\"operator\":\"Admin\",\"operateTime\":1522059698627,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-26 18:21:39', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('64', '6', '4', '[7,8,9,10,11]', '[12,7,8,9,10,11]', 'Admin', '2018-03-26 18:21:51', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('65', '2', '8', '', '{\"id\":8,\"username\":\"fansen\",\"telephone\":\"17621829059\",\"mail\":\"fansen@qq.com\",\"password\":\"0C22E7E9E90E422BCF5FDF576D2C0FB2\",\"deptId\":1,\"status\":1,\"remark\":\"fansen\",\"operator\":\"Admin\",\"operateTime\":1522060844129,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-26 18:40:44', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('66', '2', '8', '{\"id\":8,\"username\":\"fansen\",\"telephone\":\"17621829059\",\"mail\":\"fansen@qq.com\",\"password\":\"0C22E7E9E90E422BCF5FDF576D2C0FB2\",\"deptId\":1,\"status\":1,\"remark\":\"fansen\",\"operator\":\"Admin\",\"operateTime\":1522060844000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":8,\"username\":\"fansen\",\"telephone\":\"17621829059\",\"mail\":\"fansen@qq.com\",\"password\":\"0C22E7E9E90E422BCF5FDF576D2C0FB2\",\"deptId\":1,\"status\":1,\"remark\":\"fansen@qq.com\",\"operator\":\"Admin\",\"operateTime\":1522060871035,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-26 18:41:11', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('67', '4', '14', '', '{\"id\":14,\"code\":\"20180327104409_45\",\"name\":\"学生等级\",\"aclModuleId\":12,\"url\":\"/sys/getStudentGrade\",\"type\":1,\"status\":1,\"seq\":2,\"remark\":\"查看学生等级\",\"operator\":\"Admin\",\"operateTime\":1522118649986,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-27 10:44:10', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('68', '4', '15', '', '{\"id\":15,\"code\":\"20180327104638_2\",\"name\":\"琴行规模\",\"aclModuleId\":12,\"url\":\"/sys/getPianoScale\",\"type\":1,\"status\":1,\"seq\":2,\"remark\":\"查看琴行规模\",\"operator\":\"Admin\",\"operateTime\":1522118798201,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-27 10:46:38', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('69', '3', '13', '{\"id\":13,\"name\":\"所有会员信息\",\"parentId\":12,\"level\":\"0.12\",\"seq\":1,\"status\":1,\"operator\":\"Admin\",\"operateTime\":1521958689000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":13,\"name\":\"学生等级\",\"parentId\":12,\"level\":\"0.12\",\"seq\":1,\"status\":1,\"remark\":\"学生等级\",\"operator\":\"Admin\",\"operateTime\":1522119152084,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-27 10:52:32', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('70', '4', '11', '{\"id\":11,\"code\":\"20180325141606_80\",\"name\":\"查看所有会员信息\",\"aclModuleId\":13,\"url\":\"/sys/getUser\",\"type\":1,\"status\":1,\"seq\":1,\"operator\":\"Admin\",\"operateTime\":1521958699000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":11,\"name\":\"学生等级\",\"aclModuleId\":13,\"url\":\"/sys/getUser\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"学生等级\",\"operator\":\"Admin\",\"operateTime\":1522119168859,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-27 10:52:49', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('71', '3', '18', '', '{\"id\":18,\"name\":\"琴行规模\",\"parentId\":12,\"level\":\"0.12\",\"seq\":1,\"status\":1,\"remark\":\"琴行规模\",\"operator\":\"Admin\",\"operateTime\":1522119190022,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-27 10:53:10', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('72', '4', '16', '', '{\"id\":16,\"code\":\"20180327105408_83\",\"name\":\"琴行规模\",\"aclModuleId\":18,\"url\":\"/get/getss.page\",\"type\":1,\"status\":1,\"seq\":2,\"remark\":\"琴行规模\",\"operator\":\"Admin\",\"operateTime\":1522119248527,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-27 10:54:09', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('73', '6', '4', '[12,7,8,9,10,11]', '[12,7,8,9,10,14,15,11,16]', 'Admin', '2018-03-27 10:54:24', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('74', '3', '19', '', '{\"id\":19,\"name\":\"机构管理\",\"parentId\":12,\"level\":\"0.12\",\"seq\":3,\"status\":1,\"remark\":\"机构管理\",\"operator\":\"Admin\",\"operateTime\":1522119580521,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-27 10:59:41', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('75', '4', '17', '', '{\"id\":17,\"code\":\"20180327110555_81\",\"name\":\"琴行管理\",\"aclModuleId\":6,\"url\":\"/game/getOrganization.page\",\"type\":1,\"status\":1,\"seq\":4,\"remark\":\"琴行管理\",\"operator\":\"Admin\",\"operateTime\":1522119955641,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-27 11:05:56', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('76', '4', '18', '', '{\"id\":18,\"code\":\"20180327110815_34\",\"name\":\"机构管理\",\"aclModuleId\":6,\"url\":\"/get/getOrganization\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"机构管理\",\"operator\":\"Admin\",\"operateTime\":1522120095474,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-27 11:08:15', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('77', '4', '19', '', '{\"id\":19,\"code\":\"20180327111023_83\",\"name\":\"机构管理\",\"aclModuleId\":12,\"url\":\"/get/getOrganization\",\"type\":1,\"status\":1,\"seq\":3,\"remark\":\"机构管理\",\"operator\":\"Admin\",\"operateTime\":1522120223236,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-27 11:10:23', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('78', '3', '20', '', '{\"id\":20,\"name\":\"琴行管理\",\"parentId\":12,\"level\":\"0.12\",\"seq\":4,\"status\":1,\"remark\":\"琴行管理\",\"operator\":\"Admin\",\"operateTime\":1522120307314,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-27 11:11:47', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('79', '3', '21', '', '{\"id\":21,\"name\":\"家长管理\",\"parentId\":12,\"level\":\"0.12\",\"seq\":5,\"status\":1,\"remark\":\"家长管理\",\"operator\":\"Admin\",\"operateTime\":1522120443580,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-27 11:14:04', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('80', '4', '20', '', '{\"id\":20,\"code\":\"20180327111524_97\",\"name\":\"家长管理\",\"aclModuleId\":21,\"url\":\"/get/getParent\",\"type\":1,\"status\":1,\"seq\":5,\"remark\":\"家长管理\",\"operator\":\"Admin\",\"operateTime\":1522120524195,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-27 11:15:24', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('81', '4', '21', '', '{\"id\":21,\"code\":\"20180327111646_13\",\"name\":\"机构管理\",\"aclModuleId\":19,\"url\":\"/get/getOtiganiza\",\"type\":1,\"status\":1,\"seq\":3,\"remark\":\"机构管理\",\"operator\":\"Admin\",\"operateTime\":1522120606493,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-27 11:16:47', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('82', '4', '21', '{\"id\":21,\"code\":\"20180327111646_13\",\"name\":\"机构管理\",\"aclModuleId\":19,\"url\":\"/get/getOtiganiza\",\"type\":1,\"status\":1,\"seq\":3,\"remark\":\"机构管理\",\"operator\":\"Admin\",\"operateTime\":1522120606000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":21,\"name\":\"机构管理\",\"aclModuleId\":19,\"url\":\"/get/getOtiganiza.page\",\"type\":1,\"status\":1,\"seq\":3,\"remark\":\"机构管理\",\"operator\":\"Admin\",\"operateTime\":1522120621267,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-27 11:17:01', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('83', '4', '22', '', '{\"id\":22,\"code\":\"20180327112546_17\",\"name\":\"琴行管理\",\"aclModuleId\":20,\"url\":\"/get/getpiano.page\",\"type\":1,\"status\":1,\"seq\":4,\"remark\":\"琴行管理\",\"operator\":\"Admin\",\"operateTime\":1522121146555,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-27 11:25:47', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('84', '3', '22', '', '{\"id\":22,\"name\":\"学生管理\",\"parentId\":12,\"level\":\"0.12\",\"seq\":6,\"status\":1,\"remark\":\"学生管理\",\"operator\":\"Admin\",\"operateTime\":1522122674577,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-27 11:51:15', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('85', '4', '23', '', '{\"id\":23,\"code\":\"20180327115223_98\",\"name\":\"学生管理\",\"aclModuleId\":22,\"url\":\"/get/studentManage\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"学生管理\",\"operator\":\"Admin\",\"operateTime\":1522122743222,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-27 11:52:23', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('86', '3', '23', '', '{\"id\":23,\"name\":\"老师管理\",\"parentId\":12,\"level\":\"0.12\",\"seq\":7,\"status\":1,\"remark\":\"老师管理\",\"operator\":\"Admin\",\"operateTime\":1522123154277,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-27 11:59:14', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('87', '4', '20', '{\"id\":20,\"code\":\"20180327111524_97\",\"name\":\"家长管理\",\"aclModuleId\":21,\"url\":\"/get/getParent\",\"type\":1,\"status\":1,\"seq\":5,\"remark\":\"家长管理\",\"operator\":\"Admin\",\"operateTime\":1522120524000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":20,\"name\":\"家长管理\",\"aclModuleId\":21,\"url\":\"/get/getParent.page\",\"type\":1,\"status\":1,\"seq\":5,\"remark\":\"家长管理\",\"operator\":\"Admin\",\"operateTime\":1522123305261,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-27 12:01:45', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('88', '4', '23', '{\"id\":23,\"code\":\"20180327115223_98\",\"name\":\"学生管理\",\"aclModuleId\":22,\"url\":\"/get/studentManage\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"学生管理\",\"operator\":\"Admin\",\"operateTime\":1522122743000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":23,\"name\":\"学生管理\",\"aclModuleId\":22,\"url\":\"/get/studentManage.page\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"学生管理\",\"operator\":\"Admin\",\"operateTime\":1522123314254,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-27 12:01:54', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('89', '4', '24', '', '{\"id\":24,\"code\":\"20180327120413_45\",\"name\":\"老师管理\",\"aclModuleId\":6,\"url\":\"/get/teacherManage\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"老师管理\",\"operator\":\"Admin\",\"operateTime\":1522123453668,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-27 12:04:14', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('90', '4', '25', '', '{\"id\":25,\"code\":\"20180327121039_64\",\"name\":\"老师管理\",\"aclModuleId\":23,\"url\":\"/get/teacherManage\",\"type\":1,\"status\":1,\"seq\":7,\"remark\":\"老师管理\",\"operator\":\"Admin\",\"operateTime\":1522123839268,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-27 12:10:39', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('91', '3', '24', '', '{\"id\":24,\"name\":\"待审核会员\",\"parentId\":12,\"level\":\"0.12\",\"seq\":8,\"status\":1,\"remark\":\"待审核会员\",\"operator\":\"Admin\",\"operateTime\":1522123961576,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-27 12:12:42', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('92', '4', '26', '', '{\"id\":26,\"code\":\"20180327121456_59\",\"name\":\"待审核会员\",\"aclModuleId\":24,\"url\":\"/get/toAuditMember\",\"type\":1,\"status\":1,\"seq\":8,\"remark\":\"待审核会员\",\"operator\":\"Admin\",\"operateTime\":1522124096399,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-27 12:14:56', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('93', '3', '25', '', '{\"id\":25,\"name\":\"充值\",\"parentId\":0,\"level\":\"0\",\"seq\":4,\"status\":1,\"remark\":\"充值\",\"operator\":\"Admin\",\"operateTime\":1522131085274,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-27 14:11:25', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('94', '3', '26', '', '{\"id\":26,\"name\":\"充值明细\",\"parentId\":25,\"level\":\"0.25\",\"seq\":1,\"status\":1,\"remark\":\"充值明细\",\"operator\":\"Admin\",\"operateTime\":1522131152988,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-27 14:12:33', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('95', '4', '27', '', '{\"id\":27,\"code\":\"20180327141452_42\",\"name\":\"充值明细\",\"aclModuleId\":26,\"url\":\"/get/getRechargeDetail\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"充值明细\",\"operator\":\"Admin\",\"operateTime\":1522131292956,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-27 14:14:53', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('96', '3', '27', '', '{\"id\":27,\"name\":\"充值管理\",\"parentId\":25,\"level\":\"0.25\",\"seq\":2,\"status\":1,\"remark\":\"充值管理\",\"operator\":\"Admin\",\"operateTime\":1522131339141,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-27 14:15:39', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('97', '4', '28', '', '{\"id\":28,\"code\":\"20180327141844_2\",\"name\":\"充值管理\",\"aclModuleId\":27,\"url\":\"/get/rechargeManage.page\",\"type\":1,\"status\":1,\"seq\":2,\"remark\":\"充值管理\",\"operator\":\"Admin\",\"operateTime\":1522131524445,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-27 14:18:44', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('98', '4', '27', '{\"id\":27,\"code\":\"20180327141452_42\",\"name\":\"充值明细\",\"aclModuleId\":26,\"url\":\"/get/getRechargeDetail\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"充值明细\",\"operator\":\"Admin\",\"operateTime\":1522131293000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":27,\"name\":\"充值明细\",\"aclModuleId\":26,\"url\":\"/get/getRechargeDetail.page\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"充值明细\",\"operator\":\"Admin\",\"operateTime\":1522131556727,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-27 14:19:17', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('99', '4', '26', '{\"id\":26,\"code\":\"20180327121456_59\",\"name\":\"待审核会员\",\"aclModuleId\":24,\"url\":\"/get/toAuditMember\",\"type\":1,\"status\":1,\"seq\":8,\"remark\":\"待审核会员\",\"operator\":\"Admin\",\"operateTime\":1522124096000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":26,\"name\":\"待审核会员\",\"aclModuleId\":24,\"url\":\"/get/toAuditMember.page\",\"type\":1,\"status\":1,\"seq\":8,\"remark\":\"待审核会员\",\"operator\":\"Admin\",\"operateTime\":1522131578935,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-27 14:19:39', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('100', '4', '25', '{\"id\":25,\"code\":\"20180327121039_64\",\"name\":\"老师管理\",\"aclModuleId\":23,\"url\":\"/get/teacherManage\",\"type\":1,\"status\":1,\"seq\":7,\"remark\":\"老师管理\",\"operator\":\"Admin\",\"operateTime\":1522123839000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":25,\"name\":\"老师管理\",\"aclModuleId\":23,\"url\":\"/get/teacherManage.page\",\"type\":1,\"status\":1,\"seq\":7,\"remark\":\"老师管理\",\"operator\":\"Admin\",\"operateTime\":1522131595829,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-27 14:19:56', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('101', '3', '28', '', '{\"id\":28,\"name\":\"消费\",\"parentId\":0,\"level\":\"0\",\"seq\":5,\"status\":1,\"remark\":\"消费\",\"operator\":\"Admin\",\"operateTime\":1522131690307,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-27 14:21:30', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('102', '3', '29', '', '{\"id\":29,\"name\":\"消费明细\",\"parentId\":28,\"level\":\"0.28\",\"seq\":1,\"status\":1,\"remark\":\"消费明细\",\"operator\":\"Admin\",\"operateTime\":1522131946465,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-27 14:25:46', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('103', '4', '29', '', '{\"id\":29,\"code\":\"20180327142652_14\",\"name\":\"消费明细\",\"aclModuleId\":29,\"url\":\"/get/getConsumDetail.page\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"消费明细\",\"operator\":\"Admin\",\"operateTime\":1522132012376,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-27 14:26:52', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('104', '4', '16', '{\"id\":16,\"code\":\"20180327105408_83\",\"name\":\"琴行规模\",\"aclModuleId\":18,\"url\":\"/get/getss.page\",\"type\":1,\"status\":1,\"seq\":2,\"remark\":\"琴行规模\",\"operator\":\"Admin\",\"operateTime\":1522119249000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":16,\"name\":\"琴行规模\",\"aclModuleId\":18,\"url\":\"/get/getPianoScope.page\",\"type\":1,\"status\":1,\"seq\":2,\"remark\":\"琴行规模\",\"operator\":\"Admin\",\"operateTime\":1522135993455,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-27 15:33:13', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('105', '3', '18', '{\"id\":18,\"name\":\"琴行规模\",\"parentId\":12,\"level\":\"0.12\",\"seq\":1,\"status\":1,\"remark\":\"琴行规模\",\"operator\":\"Admin\",\"operateTime\":1522119190000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":18,\"name\":\"琴行规模\",\"parentId\":12,\"level\":\"0.12\",\"seq\":1,\"status\":1,\"remark\":\"琴行规模\",\"operator\":\"Admin\",\"operateTime\":1522137223872,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-27 15:53:44', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('106', '4', '21', '{\"id\":21,\"code\":\"20180327111646_13\",\"name\":\"机构管理\",\"aclModuleId\":19,\"url\":\"/get/getOtiganiza.page\",\"type\":1,\"status\":1,\"seq\":3,\"remark\":\"机构管理\",\"operator\":\"Admin\",\"operateTime\":1522120621000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":21,\"name\":\"机构管理\",\"aclModuleId\":19,\"url\":\"/get/getOrginazList.page\",\"type\":1,\"status\":1,\"seq\":3,\"remark\":\"机构管理\",\"operator\":\"Admin\",\"operateTime\":1522139273538,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-27 16:27:54', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('107', '4', '22', '{\"id\":22,\"code\":\"20180327112546_17\",\"name\":\"琴行管理\",\"aclModuleId\":20,\"url\":\"/get/getpiano.page\",\"type\":1,\"status\":1,\"seq\":4,\"remark\":\"琴行管理\",\"operator\":\"Admin\",\"operateTime\":1522121147000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":22,\"name\":\"琴行管理\",\"aclModuleId\":20,\"url\":\"/get/getOrginazDetail.page\",\"type\":1,\"status\":1,\"seq\":4,\"remark\":\"琴行管理\",\"operator\":\"Admin\",\"operateTime\":1522141664221,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-27 17:07:44', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('108', '4', '22', '{\"id\":22,\"code\":\"20180327112546_17\",\"name\":\"琴行管理\",\"aclModuleId\":20,\"url\":\"/get/getOrginazDetail.page\",\"type\":1,\"status\":1,\"seq\":4,\"remark\":\"琴行管理\",\"operator\":\"Admin\",\"operateTime\":1522141664000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":22,\"name\":\"琴行管理\",\"aclModuleId\":20,\"url\":\"/get/getPianoList.page\",\"type\":1,\"status\":1,\"seq\":4,\"remark\":\"琴行管理\",\"operator\":\"Admin\",\"operateTime\":1522148637502,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-27 19:03:58', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('109', '4', '23', '{\"id\":23,\"code\":\"20180327115223_98\",\"name\":\"学生管理\",\"aclModuleId\":22,\"url\":\"/get/studentManage.page\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"学生管理\",\"operator\":\"Admin\",\"operateTime\":1522123314000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":23,\"name\":\"学生管理\",\"aclModuleId\":22,\"url\":\"/get/getStudent.page\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"学生管理\",\"operator\":\"Admin\",\"operateTime\":1522208734331,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-28 11:45:34', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('110', '4', '25', '{\"id\":25,\"code\":\"20180327121039_64\",\"name\":\"老师管理\",\"aclModuleId\":23,\"url\":\"/get/teacherManage.page\",\"type\":1,\"status\":1,\"seq\":7,\"remark\":\"老师管理\",\"operator\":\"Admin\",\"operateTime\":1522131596000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":25,\"name\":\"老师管理\",\"aclModuleId\":23,\"url\":\"/get/teacherList.page\",\"type\":1,\"status\":1,\"seq\":7,\"remark\":\"老师管理\",\"operator\":\"Admin\",\"operateTime\":1522211115667,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-28 12:25:16', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('111', '4', '25', '{\"id\":25,\"code\":\"20180327121039_64\",\"name\":\"老师管理\",\"aclModuleId\":23,\"url\":\"/get/teacherList.page\",\"type\":1,\"status\":1,\"seq\":7,\"remark\":\"老师管理\",\"operator\":\"Admin\",\"operateTime\":1522211116000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":25,\"name\":\"老师管理\",\"aclModuleId\":23,\"url\":\"/get/teacher.page\",\"type\":1,\"status\":1,\"seq\":7,\"remark\":\"老师管理\",\"operator\":\"Admin\",\"operateTime\":1522217626142,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-28 14:13:46', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('112', '4', '25', '{\"id\":25,\"code\":\"20180327121039_64\",\"name\":\"老师管理\",\"aclModuleId\":23,\"url\":\"/get/teacher.page\",\"type\":1,\"status\":1,\"seq\":7,\"remark\":\"老师管理\",\"operator\":\"Admin\",\"operateTime\":1522217626000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":25,\"name\":\"老师管理\",\"aclModuleId\":23,\"url\":\"/get/getTeacher.page\",\"type\":1,\"status\":1,\"seq\":7,\"remark\":\"老师管理\",\"operator\":\"Admin\",\"operateTime\":1522217705486,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-28 14:15:06', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('113', '4', '25', '{\"id\":25,\"code\":\"20180327121039_64\",\"name\":\"老师管理\",\"aclModuleId\":23,\"url\":\"/get/getTeacher.page\",\"type\":1,\"status\":1,\"seq\":7,\"remark\":\"老师管理\",\"operator\":\"Admin\",\"operateTime\":1522217705000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":25,\"name\":\"老师管理\",\"aclModuleId\":23,\"url\":\"/get/getTeacher.page\",\"type\":1,\"status\":1,\"seq\":7,\"remark\":\"老师管理\",\"operator\":\"Admin\",\"operateTime\":1522217743424,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-28 14:15:43', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('114', '4', '26', '{\"id\":26,\"code\":\"20180327121456_59\",\"name\":\"待审核会员\",\"aclModuleId\":24,\"url\":\"/get/toAuditMember.page\",\"type\":1,\"status\":1,\"seq\":8,\"remark\":\"待审核会员\",\"operator\":\"Admin\",\"operateTime\":1522131579000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":26,\"name\":\"待审核会员\",\"aclModuleId\":24,\"url\":\"/get/getAuditMember.page\",\"type\":1,\"status\":1,\"seq\":8,\"remark\":\"待审核会员\",\"operator\":\"Admin\",\"operateTime\":1522219213919,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-28 14:40:14', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('115', '3', '30', '', '{\"id\":30,\"name\":\"添加老师\",\"parentId\":12,\"level\":\"0.12\",\"seq\":9,\"status\":1,\"remark\":\"添加老师\",\"operator\":\"Admin\",\"operateTime\":1522230912802,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-28 17:55:13', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('116', '4', '30', '', '{\"id\":30,\"code\":\"20180328175622_48\",\"name\":\"添加老师\",\"aclModuleId\":30,\"url\":\"/get/addTeacher.page\",\"type\":1,\"status\":1,\"seq\":1,\"operator\":\"Admin\",\"operateTime\":1522230982640,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-28 17:56:23', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('117', '3', '31', '', '{\"id\":31,\"name\":\"教务系统\",\"parentId\":0,\"level\":\"0\",\"seq\":6,\"status\":1,\"remark\":\"教务系统\",\"operator\":\"Admin\",\"operateTime\":1522238821616,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-28 20:07:02', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('118', '4', '31', '', '{\"id\":31,\"code\":\"20180328200837_44\",\"name\":\"作业管理\",\"aclModuleId\":31,\"url\":\"/get/taskManagement\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"作业管理\",\"operator\":\"Admin\",\"operateTime\":1522238917453,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-28 20:08:38', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('119', '4', '28', '{\"id\":28,\"code\":\"20180327141844_2\",\"name\":\"充值管理\",\"aclModuleId\":27,\"url\":\"/get/rechargeManage.page\",\"type\":1,\"status\":1,\"seq\":2,\"remark\":\"充值管理\",\"operator\":\"Admin\",\"operateTime\":1522131524000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":28,\"name\":\"充值管理\",\"aclModuleId\":27,\"url\":\"/get/rechargeManagement.page\",\"type\":1,\"status\":1,\"seq\":2,\"remark\":\"充值管理\",\"operator\":\"Admin\",\"operateTime\":1522291835747,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-29 10:50:36', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('120', '3', '32', '', '{\"id\":32,\"name\":\"服务商管理\",\"parentId\":0,\"level\":\"0\",\"seq\":7,\"status\":1,\"remark\":\"服务商管理\",\"operator\":\"Admin\",\"operateTime\":1522292197549,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-29 10:56:38', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('121', '4', '32', '', '{\"id\":32,\"code\":\"20180329110135_66\",\"name\":\"评语管理\",\"aclModuleId\":31,\"url\":\"/get/commentManagement.page\",\"type\":1,\"status\":1,\"seq\":2,\"remark\":\"评语管理\",\"operator\":\"Admin\",\"operateTime\":1522292495591,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-29 11:01:36', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('122', '4', '31', '{\"id\":31,\"code\":\"20180328200837_44\",\"name\":\"作业管理\",\"aclModuleId\":31,\"url\":\"/get/taskManagement\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"作业管理\",\"operator\":\"Admin\",\"operateTime\":1522238917000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":31,\"name\":\"作业管理\",\"aclModuleId\":31,\"url\":\"/get/taskManagement.page\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"作业管理\",\"operator\":\"Admin\",\"operateTime\":1522292512321,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-29 11:01:52', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('123', '3', '31', '{\"id\":31,\"name\":\"教务系统\",\"parentId\":0,\"level\":\"0\",\"seq\":6,\"status\":1,\"remark\":\"教务系统\",\"operator\":\"Admin\",\"operateTime\":1522238822000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":31,\"name\":\"教务系统\",\"parentId\":0,\"level\":\"0\",\"seq\":6,\"status\":1,\"remark\":\"教务系统\",\"operator\":\"Admin\",\"operateTime\":1522293954436,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-29 11:25:54', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('124', '3', '32', '{\"id\":32,\"name\":\"服务商管理\",\"parentId\":0,\"level\":\"0\",\"seq\":7,\"status\":1,\"remark\":\"服务商管理\",\"operator\":\"Admin\",\"operateTime\":1522292198000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":32,\"name\":\"服务商管理\",\"parentId\":0,\"level\":\"0\",\"seq\":7,\"status\":1,\"remark\":\"服务商管理\",\"operator\":\"Admin\",\"operateTime\":1522293967786,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-29 11:26:08', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('125', '3', '33', '', '{\"id\":33,\"name\":\"作业管理\",\"parentId\":31,\"level\":\"0.31\",\"seq\":1,\"status\":1,\"remark\":\"作业管理\",\"operator\":\"Admin\",\"operateTime\":1522294054200,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-29 11:27:34', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('126', '4', '31', '{\"id\":31,\"code\":\"20180328200837_44\",\"name\":\"作业管理\",\"aclModuleId\":31,\"url\":\"/get/taskManagement.page\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"作业管理\",\"operator\":\"Admin\",\"operateTime\":1522292512000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":31,\"name\":\"作业管理\",\"aclModuleId\":33,\"url\":\"/get/taskManagement.page\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"作业管理\",\"operator\":\"Admin\",\"operateTime\":1522294072450,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-29 11:27:52', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('127', '3', '34', '', '{\"id\":34,\"name\":\"评语管理\",\"parentId\":31,\"level\":\"0.31\",\"seq\":2,\"status\":1,\"remark\":\"评语管理\",\"operator\":\"Admin\",\"operateTime\":1522294102257,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-29 11:28:22', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('128', '4', '32', '{\"id\":32,\"code\":\"20180329110135_66\",\"name\":\"评语管理\",\"aclModuleId\":31,\"url\":\"/get/commentManagement.page\",\"type\":1,\"status\":1,\"seq\":2,\"remark\":\"评语管理\",\"operator\":\"Admin\",\"operateTime\":1522292496000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":32,\"name\":\"评语管理\",\"aclModuleId\":34,\"url\":\"/get/commentManagement.page\",\"type\":1,\"status\":1,\"seq\":2,\"remark\":\"评语管理\",\"operator\":\"Admin\",\"operateTime\":1522294112395,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-29 11:28:32', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('129', '3', '35', '', '{\"id\":35,\"name\":\"学生点评\",\"parentId\":31,\"level\":\"0.31\",\"seq\":3,\"status\":1,\"remark\":\"学生点评\",\"operator\":\"Admin\",\"operateTime\":1522294422621,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-29 11:33:43', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('130', '4', '33', '', '{\"id\":33,\"code\":\"20180329113436_17\",\"name\":\"学生点评\",\"aclModuleId\":35,\"url\":\"/get/studentComment\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"学生点评\",\"operator\":\"Admin\",\"operateTime\":1522294476578,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-29 11:34:37', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('131', '3', '36', '', '{\"id\":36,\"name\":\"家长给老师的寄语\",\"parentId\":0,\"level\":\"0\",\"seq\":7,\"status\":1,\"remark\":\"家长给老师的寄语\",\"operator\":\"Admin\",\"operateTime\":1522296060081,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-29 12:01:00', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('132', '4', '34', '', '{\"id\":34,\"code\":\"20180329120143_77\",\"name\":\"家长给老师的寄语\",\"aclModuleId\":36,\"url\":\"/get/parentCommentTeacher\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"家长给老师的寄语\",\"operator\":\"Admin\",\"operateTime\":1522296103965,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-29 12:01:44', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('133', '3', '37', '', '{\"id\":37,\"name\":\"家长给老师的寄语\",\"parentId\":36,\"level\":\"0.36\",\"seq\":1,\"status\":1,\"remark\":\"家长给老师的寄语\",\"operator\":\"Admin\",\"operateTime\":1522296128289,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-29 12:02:08', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('134', '4', '34', '{\"id\":34,\"code\":\"20180329120143_77\",\"name\":\"家长给老师的寄语\",\"aclModuleId\":36,\"url\":\"/get/parentCommentTeacher\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"家长给老师的寄语\",\"operator\":\"Admin\",\"operateTime\":1522296104000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":34,\"name\":\"家长给老师的寄语\",\"aclModuleId\":37,\"url\":\"/get/parentCommentTeacher\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"家长给老师的寄语\",\"operator\":\"Admin\",\"operateTime\":1522296139163,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-29 12:02:19', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('135', '4', '33', '{\"id\":33,\"code\":\"20180329113436_17\",\"name\":\"学生点评\",\"aclModuleId\":35,\"url\":\"/get/studentComment\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"学生点评\",\"operator\":\"Admin\",\"operateTime\":1522294477000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":33,\"name\":\"学生点评\",\"aclModuleId\":35,\"url\":\"/get/studentComment\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"学生点评\",\"operator\":\"Admin\",\"operateTime\":1522296242548,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-29 12:04:03', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('136', '3', '38', '', '{\"id\":38,\"name\":\"CMS管理\",\"parentId\":0,\"level\":\"0\",\"seq\":1,\"status\":1,\"remark\":\"CMS管理\",\"operator\":\"Admin\",\"operateTime\":1522303732547,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-29 14:08:53', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('137', '3', '38', '{\"id\":38,\"name\":\"CMS管理\",\"parentId\":0,\"level\":\"0\",\"seq\":1,\"status\":1,\"remark\":\"CMS管理\",\"operator\":\"Admin\",\"operateTime\":1522303733000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":38,\"name\":\"CMS管理\",\"parentId\":0,\"level\":\"0\",\"seq\":8,\"status\":1,\"remark\":\"CMS管理\",\"operator\":\"Admin\",\"operateTime\":1522303749531,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-29 14:09:10', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('138', '3', '39', '', '{\"id\":39,\"name\":\"栏目管理\",\"parentId\":38,\"level\":\"0.38\",\"seq\":1,\"status\":1,\"remark\":\"栏目管理\",\"operator\":\"Admin\",\"operateTime\":1522303805080,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-29 14:10:05', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('139', '3', '40', '', '{\"id\":40,\"name\":\"内容管理\",\"parentId\":38,\"level\":\"0.38\",\"seq\":1,\"status\":1,\"remark\":\"内容管理\",\"operator\":\"Admin\",\"operateTime\":1522303826486,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-29 14:10:27', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('140', '3', '41', '', '{\"id\":41,\"name\":\"滚动广告位\",\"parentId\":38,\"level\":\"0.38\",\"seq\":1,\"status\":1,\"remark\":\"滚动广告位\",\"operator\":\"Admin\",\"operateTime\":1522303900488,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-29 14:11:41', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('141', '3', '42', '', '{\"id\":42,\"name\":\"热门广告位\",\"parentId\":38,\"level\":\"0.38\",\"seq\":1,\"status\":1,\"remark\":\"热门广告位\",\"operator\":\"Admin\",\"operateTime\":1522303948280,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-29 14:12:28', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('142', '4', '35', '', '{\"id\":35,\"code\":\"20180329141444_93\",\"name\":\"栏目管理\",\"aclModuleId\":39,\"url\":\"/get/columnManagement\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"热门广告位\",\"operator\":\"Admin\",\"operateTime\":1522304084911,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-29 14:14:45', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('143', '4', '36', '', '{\"id\":36,\"code\":\"20180329141559_93\",\"name\":\"内容管理\",\"aclModuleId\":40,\"url\":\"/get/contentManagement\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"内容管理\",\"operator\":\"Admin\",\"operateTime\":1522304159957,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-29 14:16:00', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('144', '4', '37', '', '{\"id\":37,\"code\":\"20180329141722_36\",\"name\":\"滚动广告位\",\"aclModuleId\":41,\"url\":\"/get/rollingAdverment.page\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"滚动广告位\",\"operator\":\"Admin\",\"operateTime\":1522304242273,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-29 14:17:22', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('145', '4', '36', '{\"id\":36,\"code\":\"20180329141559_93\",\"name\":\"内容管理\",\"aclModuleId\":40,\"url\":\"/get/contentManagement\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"内容管理\",\"operator\":\"Admin\",\"operateTime\":1522304160000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":36,\"name\":\"内容管理\",\"aclModuleId\":40,\"url\":\"/get/contentManagement.page\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"内容管理\",\"operator\":\"Admin\",\"operateTime\":1522304254178,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-29 14:17:34', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('146', '4', '35', '{\"id\":35,\"code\":\"20180329141444_93\",\"name\":\"栏目管理\",\"aclModuleId\":39,\"url\":\"/get/columnManagement\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"热门广告位\",\"operator\":\"Admin\",\"operateTime\":1522304085000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":35,\"name\":\"栏目管理\",\"aclModuleId\":39,\"url\":\"/get/columnManagement.page\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"热门广告位\",\"operator\":\"Admin\",\"operateTime\":1522304270234,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-29 14:17:50', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('147', '4', '38', '', '{\"id\":38,\"code\":\"20180329141959_92\",\"name\":\"热门广告位\",\"aclModuleId\":42,\"url\":\"/get/popularAdverment\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"热门广告位\",\"operator\":\"Admin\",\"operateTime\":1522304399094,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-29 14:19:59', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('148', '4', '38', '{\"id\":38,\"code\":\"20180329141959_92\",\"name\":\"热门广告位\",\"aclModuleId\":42,\"url\":\"/get/popularAdverment\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"热门广告位\",\"operator\":\"Admin\",\"operateTime\":1522304399000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":38,\"name\":\"热门广告位\",\"aclModuleId\":42,\"url\":\"/get/popularAdverment.page\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"热门广告位\",\"operator\":\"Admin\",\"operateTime\":1522304449553,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-29 14:20:50', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('149', '3', '43', '', '{\"id\":43,\"name\":\"栏目管理\",\"parentId\":41,\"level\":\"0.38.41\",\"seq\":1,\"status\":1,\"remark\":\"滚动广告--栏目管理\",\"operator\":\"Admin\",\"operateTime\":1522306704903,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-29 14:58:25', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('150', '3', '44', '', '{\"id\":44,\"name\":\"内容管理\",\"parentId\":41,\"level\":\"0.38.41\",\"seq\":1,\"status\":1,\"remark\":\"滚动广告位-内容管理\",\"operator\":\"Admin\",\"operateTime\":1522306770666,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-29 14:59:31', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('151', '4', '39', '', '{\"id\":39,\"code\":\"20180329152853_14\",\"name\":\"栏目管理\",\"aclModuleId\":43,\"url\":\"/get/columnManagement.page\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"栏目管理\",\"operator\":\"Admin\",\"operateTime\":1522308533672,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-29 15:28:54', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('152', '4', '40', '', '{\"id\":40,\"code\":\"20180329153034_96\",\"name\":\"内容管理\",\"aclModuleId\":44,\"url\":\"/get/contentManagement.page\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"内容管理\",\"operator\":\"Admin\",\"operateTime\":1522308634488,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-29 15:30:35', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('153', '3', '45', '', '{\"id\":45,\"name\":\"栏目管理\",\"parentId\":42,\"level\":\"0.38.42\",\"seq\":1,\"status\":1,\"remark\":\"热门广告 --内容管理\",\"operator\":\"Admin\",\"operateTime\":1522309732295,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-29 15:48:52', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('154', '4', '41', '', '{\"id\":41,\"code\":\"20180329154936_70\",\"name\":\"栏目管理\",\"aclModuleId\":6,\"url\":\"/get/columnManagement.page\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"栏目管理\",\"operator\":\"Admin\",\"operateTime\":1522309776298,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-29 15:49:36', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('155', '4', '42', '', '{\"id\":42,\"code\":\"20180329155347_83\",\"name\":\"栏目管理\",\"aclModuleId\":45,\"url\":\"/get/columnManagement.page\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"栏目管理\",\"operator\":\"Admin\",\"operateTime\":1522310027464,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-29 15:53:47', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('156', '3', '46', '', '{\"id\":46,\"name\":\"教材管理\",\"parentId\":0,\"level\":\"0\",\"seq\":10,\"status\":1,\"remark\":\"教材管理\",\"operator\":\"Admin\",\"operateTime\":1522313006692,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-29 16:43:27', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('157', '3', '47', '', '{\"id\":47,\"name\":\"阶段管理\",\"parentId\":46,\"level\":\"0.46\",\"seq\":1,\"status\":1,\"remark\":\"阶段管理\",\"operator\":\"Admin\",\"operateTime\":1522313057579,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-29 16:44:18', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('158', '4', '43', '', '{\"id\":43,\"code\":\"20180329164545_26\",\"name\":\"阶段管理\",\"aclModuleId\":47,\"url\":\"/get/stageManagement\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"阶段管理\",\"operator\":\"Admin\",\"operateTime\":1522313145130,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-29 16:45:45', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('159', '3', '48', '', '{\"id\":48,\"name\":\"风格管理\",\"parentId\":46,\"level\":\"0.46\",\"seq\":2,\"status\":1,\"remark\":\"风格管理\",\"operator\":\"Admin\",\"operateTime\":1522313379234,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-29 16:49:39', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('160', '3', '49', '', '{\"id\":49,\"name\":\"教材管理\",\"parentId\":46,\"level\":\"0.46\",\"seq\":3,\"status\":1,\"remark\":\"教材管理\",\"operator\":\"Admin\",\"operateTime\":1522313415342,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-29 16:50:15', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('161', '3', '50', '', '{\"id\":50,\"name\":\"曲谱管理\",\"parentId\":46,\"level\":\"0.46\",\"seq\":4,\"status\":1,\"remark\":\"曲谱管理\",\"operator\":\"Admin\",\"operateTime\":1522313465369,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-29 16:51:05', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('162', '4', '44', '', '{\"id\":44,\"code\":\"20180329165207_75\",\"name\":\"风格管理\",\"aclModuleId\":48,\"url\":\"/get/styleManagement\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"风格管理\",\"operator\":\"Admin\",\"operateTime\":1522313527320,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-29 16:52:07', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('163', '4', '45', '', '{\"id\":45,\"code\":\"20180329165736_87\",\"name\":\"教材管理\",\"aclModuleId\":49,\"url\":\"/get/learnBookManagement.page\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"教材管理\",\"operator\":\"Admin\",\"operateTime\":1522313856991,\"operateIp\":\"192.168.1.66\"}', 'Admin', '2018-03-29 16:57:37', '192.168.1.66', '1');
INSERT INTO `sys_log` VALUES ('164', '4', '43', '{\"id\":43,\"code\":\"20180329164545_26\",\"name\":\"阶段管理\",\"aclModuleId\":47,\"url\":\"/get/stageManagement\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"阶段管理\",\"operator\":\"Admin\",\"operateTime\":1522313145000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":43,\"name\":\"阶段管理\",\"aclModuleId\":47,\"url\":\"/get/stageManagement.page\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"阶段管理\",\"operator\":\"Admin\",\"operateTime\":1522313873931,\"operateIp\":\"192.168.1.66\"}', 'Admin', '2018-03-29 16:57:54', '192.168.1.66', '1');
INSERT INTO `sys_log` VALUES ('165', '4', '44', '{\"id\":44,\"code\":\"20180329165207_75\",\"name\":\"风格管理\",\"aclModuleId\":48,\"url\":\"/get/styleManagement\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"风格管理\",\"operator\":\"Admin\",\"operateTime\":1522313527000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":44,\"name\":\"风格管理\",\"aclModuleId\":48,\"url\":\"/get/styleManagement.page\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"风格管理\",\"operator\":\"Admin\",\"operateTime\":1522313882964,\"operateIp\":\"192.168.1.66\"}', 'Admin', '2018-03-29 16:58:03', '192.168.1.66', '1');
INSERT INTO `sys_log` VALUES ('166', '4', '46', '', '{\"id\":46,\"code\":\"20180329170044_79\",\"name\":\"曲谱管理\",\"aclModuleId\":50,\"url\":\"/get/operaManagement\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"曲谱管理\",\"operator\":\"Admin\",\"operateTime\":1522314044233,\"operateIp\":\"192.168.1.66\"}', 'Admin', '2018-03-29 17:00:44', '192.168.1.66', '1');
INSERT INTO `sys_log` VALUES ('167', '3', '51', '', '{\"id\":51,\"name\":\"提现管理\",\"parentId\":0,\"level\":\"0\",\"seq\":11,\"status\":1,\"remark\":\"提现管理\",\"operator\":\"Admin\",\"operateTime\":1522320376451,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-29 18:46:17', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('168', '3', '52', '', '{\"id\":52,\"name\":\"提现审批\",\"parentId\":51,\"level\":\"0.51\",\"seq\":1,\"status\":1,\"remark\":\"提现审批\",\"operator\":\"Admin\",\"operateTime\":1522320398389,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-29 18:46:38', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('169', '4', '47', '', '{\"id\":47,\"code\":\"20180329184800_82\",\"name\":\"提现审批\",\"aclModuleId\":52,\"url\":\"/get/withdrawExamine\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"提现审批\",\"operator\":\"Admin\",\"operateTime\":1522320480486,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-29 18:48:01', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('170', '3', '53', '', '{\"id\":53,\"name\":\"分润系统\",\"parentId\":0,\"level\":\"0\",\"seq\":12,\"status\":1,\"remark\":\"分润系统\",\"operator\":\"Admin\",\"operateTime\":1522321329171,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-29 19:02:09', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('171', '3', '54', '', '{\"id\":54,\"name\":\"分润设置\",\"parentId\":53,\"level\":\"0.53\",\"seq\":1,\"status\":1,\"remark\":\"分润设置\",\"operator\":\"Admin\",\"operateTime\":1522397459682,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-30 16:11:00', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('172', '4', '48', '', '{\"id\":48,\"code\":\"20180330161228_5\",\"name\":\"分润设置\",\"aclModuleId\":6,\"url\":\"/get/shareProfitSetting.page\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"分润设置\",\"operator\":\"Admin\",\"operateTime\":1522397548441,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-30 16:12:28', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('173', '4', '49', '', '{\"id\":49,\"code\":\"20180330161326_73\",\"name\":\"分润设置\",\"aclModuleId\":54,\"url\":\"/get/shareProfitSetting.page\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"分润设置\",\"operator\":\"Admin\",\"operateTime\":1522397606403,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-30 16:13:26', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('174', '3', '55', '', '{\"id\":55,\"name\":\"银行卡\",\"parentId\":53,\"level\":\"0.53\",\"seq\":2,\"status\":1,\"remark\":\"银行卡\",\"operator\":\"Admin\",\"operateTime\":1522399043107,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-30 16:37:23', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('175', '4', '50', '', '{\"id\":50,\"code\":\"20180330163859_74\",\"name\":\"银行卡\",\"aclModuleId\":55,\"url\":\"/get/bankCardDetail.page\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"银行卡\",\"operator\":\"Admin\",\"operateTime\":1522399139175,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-30 16:38:59', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('176', '3', '56', '', '{\"id\":56,\"name\":\"收入明细\",\"parentId\":53,\"level\":\"0.53\",\"seq\":3,\"status\":1,\"remark\":\"收入明细\",\"operator\":\"Admin\",\"operateTime\":1522399222029,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-30 16:40:22', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('177', '4', '51', '', '{\"id\":51,\"code\":\"20180330164126_5\",\"name\":\"收入明细\",\"aclModuleId\":6,\"url\":\"/get/incomeDetail.page\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"收入明细\",\"operator\":\"Admin\",\"operateTime\":1522399286729,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-30 16:41:27', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('178', '4', '52', '', '{\"id\":52,\"code\":\"20180330164219_86\",\"name\":\"收入明细\",\"aclModuleId\":56,\"url\":\"/get/incomeDetail.page\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"收入明细\",\"operator\":\"Admin\",\"operateTime\":1522399339353,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-30 16:42:19', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('179', '3', '57', '', '{\"id\":57,\"name\":\"余额提现申请\",\"parentId\":53,\"level\":\"0.53\",\"seq\":4,\"status\":1,\"remark\":\"余额提现申请\",\"operator\":\"Admin\",\"operateTime\":1522399462585,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-30 16:44:23', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('180', '4', '53', '', '{\"id\":53,\"code\":\"20180330171128_53\",\"name\":\"余额提现申请\",\"aclModuleId\":57,\"url\":\"/get/withdrawApply\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"余额提现申请\",\"operator\":\"Admin\",\"operateTime\":1522401088923,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-30 17:11:29', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('181', '3', '58', '', '{\"id\":58,\"name\":\"服务商管理\",\"parentId\":12,\"level\":\"0.12\",\"seq\":3,\"status\":1,\"remark\":\"服务商管理\",\"operator\":\"Admin\",\"operateTime\":1522404069774,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-30 18:01:10', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('182', '3', '58', '{\"id\":58,\"name\":\"服务商管理\",\"parentId\":12,\"level\":\"0.12\",\"seq\":3,\"status\":1,\"remark\":\"服务商管理\",\"operator\":\"Admin\",\"operateTime\":1522404070000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":58,\"name\":\"服务商管理\",\"parentId\":12,\"level\":\"0.12\",\"seq\":2,\"status\":1,\"remark\":\"服务商管理\",\"operator\":\"Admin\",\"operateTime\":1522404105030,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-30 18:01:45', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('183', '4', '54', '', '{\"id\":54,\"code\":\"20180330180513_65\",\"name\":\"服务商管理\",\"aclModuleId\":58,\"url\":\"/get/serviceProviderManage\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"服务商管理\",\"operator\":\"Admin\",\"operateTime\":1522404313396,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-30 18:05:13', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('184', '6', '4', '[12,7,8,9,10,14,15,11,16]', '[12,41,48,51,7,8,9,10,13,19,11,16,54,21,22,20,23,25,26,30,27,28,29,31,32,33,34,38,42,43,44,45,46,47,49,50,52,53]', 'Admin', '2018-03-30 19:04:54', '223.167.98.156', '1');
INSERT INTO `sys_log` VALUES ('185', '6', '3', '[7,8,9,10]', '[7,8,9,10,34,38,42]', 'Admin', '2018-03-30 19:06:16', '223.167.98.156', '1');
INSERT INTO `sys_log` VALUES ('186', '3', '59', '', '{\"id\":59,\"name\":\"商城管理\",\"parentId\":0,\"level\":\"0\",\"seq\":13,\"status\":1,\"remark\":\"商城管理\",\"operator\":\"Admin\",\"operateTime\":1522409466934,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-30 19:31:07', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('187', '3', '60', '', '{\"id\":60,\"name\":\"皮肤类型\",\"parentId\":59,\"level\":\"0.59\",\"seq\":1,\"status\":1,\"remark\":\"皮肤类型\",\"operator\":\"Admin\",\"operateTime\":1522409509889,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-30 19:31:50', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('188', '3', '61', '', '{\"id\":61,\"name\":\"皮肤风格\",\"parentId\":59,\"level\":\"0.59\",\"seq\":2,\"status\":1,\"remark\":\"皮肤风格\",\"operator\":\"Admin\",\"operateTime\":1522409552616,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-30 19:32:33', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('189', '3', '62', '', '{\"id\":62,\"name\":\"皮肤管理\",\"parentId\":59,\"level\":\"0.59\",\"seq\":1,\"status\":1,\"remark\":\"皮肤管理\",\"operator\":\"Admin\",\"operateTime\":1522409579865,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-30 19:33:00', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('190', '3', '63', '', '{\"id\":63,\"name\":\"游戏管理\",\"parentId\":59,\"level\":\"0.59\",\"seq\":4,\"status\":1,\"remark\":\"游戏管理\",\"operator\":\"Admin\",\"operateTime\":1522409630832,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-03-30 19:33:51', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('191', '3', '59', '{\"id\":59,\"name\":\"商城管理\",\"parentId\":0,\"level\":\"0\",\"seq\":13,\"status\":1,\"remark\":\"商城管理\",\"operator\":\"Admin\",\"operateTime\":1522409467000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":59,\"name\":\"商城管理\",\"parentId\":0,\"level\":\"0\",\"seq\":13,\"status\":1,\"remark\":\"商城管理\",\"operator\":\"Admin\",\"operateTime\":1522633311154,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-04-02 09:41:51', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('192', '3', '60', '{\"id\":60,\"name\":\"皮肤类型\",\"parentId\":59,\"level\":\"0.59\",\"seq\":1,\"status\":1,\"remark\":\"皮肤类型\",\"operator\":\"Admin\",\"operateTime\":1522409510000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":60,\"name\":\"皮肤类型\",\"parentId\":59,\"level\":\"0.59\",\"seq\":1,\"status\":1,\"remark\":\"皮肤类型\",\"operator\":\"Admin\",\"operateTime\":1522633328991,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-04-02 09:42:09', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('193', '4', '55', '', '{\"id\":55,\"code\":\"20180402094309_53\",\"name\":\"皮肤类型\",\"aclModuleId\":60,\"url\":\"/get/skinStyle\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"皮肤类型\",\"operator\":\"Admin\",\"operateTime\":1522633389427,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-04-02 09:43:09', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('194', '4', '56', '', '{\"id\":56,\"code\":\"20180402094421_64\",\"name\":\"皮肤管理\",\"aclModuleId\":62,\"url\":\"/get/skinManage\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"皮肤类型\",\"operator\":\"Admin\",\"operateTime\":1522633461153,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-04-02 09:44:21', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('195', '4', '55', '{\"id\":55,\"code\":\"20180402094309_53\",\"name\":\"皮肤类型\",\"aclModuleId\":60,\"url\":\"/get/skinStyle\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"皮肤类型\",\"operator\":\"Admin\",\"operateTime\":1522633389000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":55,\"name\":\"皮肤类型\",\"aclModuleId\":60,\"url\":\"/get/skinTyple\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"皮肤类型\",\"operator\":\"Admin\",\"operateTime\":1522633568330,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-04-02 09:46:08', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('196', '4', '57', '', '{\"id\":57,\"code\":\"20180402094654_7\",\"name\":\"皮肤风格\",\"aclModuleId\":61,\"url\":\"/get/skinStyle\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"皮肤风格\",\"operator\":\"Admin\",\"operateTime\":1522633614943,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-04-02 09:46:55', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('197', '4', '55', '{\"id\":55,\"code\":\"20180402094309_53\",\"name\":\"皮肤类型\",\"aclModuleId\":60,\"url\":\"/get/skinTyple\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"皮肤类型\",\"operator\":\"Admin\",\"operateTime\":1522633568000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":55,\"name\":\"皮肤类型\",\"aclModuleId\":60,\"url\":\"/get/skinType\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"皮肤类型\",\"operator\":\"Admin\",\"operateTime\":1522633627301,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-04-02 09:47:07', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('198', '4', '58', '', '{\"id\":58,\"code\":\"20180402094826_98\",\"name\":\"游戏管理\",\"aclModuleId\":63,\"url\":\"/get/gameManage\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"游戏管理\",\"operator\":\"Admin\",\"operateTime\":1522633706976,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-04-02 09:48:27', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('199', '3', '64', '', '{\"id\":64,\"name\":\"消息管理\",\"parentId\":0,\"level\":\"0\",\"seq\":14,\"status\":1,\"remark\":\"消息管理\",\"operator\":\"Admin\",\"operateTime\":1522638858214,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-04-02 11:14:18', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('200', '3', '65', '', '{\"id\":65,\"name\":\"发送系统消息\",\"parentId\":64,\"level\":\"0.64\",\"seq\":1,\"status\":1,\"remark\":\"发送系统消息\",\"operator\":\"Admin\",\"operateTime\":1522638885060,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-04-02 11:14:45', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('201', '3', '66', '', '{\"id\":66,\"name\":\"已发送消息列表\",\"parentId\":64,\"level\":\"0.64\",\"seq\":2,\"status\":1,\"remark\":\"已发送消息列表\",\"operator\":\"Admin\",\"operateTime\":1522638927162,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-04-02 11:15:27', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('202', '4', '59', '', '{\"id\":59,\"code\":\"20180402111639_82\",\"name\":\"发送系统消息\",\"aclModuleId\":65,\"url\":\"/get/sendSysMessage\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"发送系统消息\",\"operator\":\"Admin\",\"operateTime\":1522638999515,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-04-02 11:16:40', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('203', '4', '60', '', '{\"id\":60,\"code\":\"20180402111730_0\",\"name\":\"已发送消息列表\",\"aclModuleId\":66,\"url\":\"/get/messageList\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"已发送消息列表\",\"operator\":\"Admin\",\"operateTime\":1522639050052,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-04-02 11:17:30', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('204', '3', '67', '', '{\"id\":67,\"name\":\"参数设置\",\"parentId\":0,\"level\":\"0\",\"seq\":15,\"status\":1,\"remark\":\"参数设置\",\"operator\":\"Admin\",\"operateTime\":1522640194814,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-04-02 11:36:35', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('205', '3', '68', '', '{\"id\":68,\"name\":\"会费设置\",\"parentId\":67,\"level\":\"0.67\",\"seq\":1,\"status\":1,\"remark\":\"会费设置\",\"operator\":\"Admin\",\"operateTime\":1522640218004,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-04-02 11:36:58', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('206', '3', '69', '', '{\"id\":69,\"name\":\"手续费设置\",\"parentId\":67,\"level\":\"0.67\",\"seq\":2,\"status\":1,\"remark\":\"手续费设置\",\"operator\":\"Admin\",\"operateTime\":1522640252985,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-04-02 11:37:33', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('207', '3', '70', '', '{\"id\":70,\"name\":\"难度设置\",\"parentId\":67,\"level\":\"0.67\",\"seq\":3,\"status\":1,\"remark\":\"难度设置\",\"operator\":\"Admin\",\"operateTime\":1522640286288,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-04-02 11:38:06', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('208', '3', '71', '', '{\"id\":71,\"name\":\"教材设置\",\"parentId\":67,\"level\":\"0.67\",\"seq\":4,\"status\":1,\"remark\":\"教材设置\",\"operator\":\"Admin\",\"operateTime\":1522640359338,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-04-02 11:39:19', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('209', '3', '72', '', '{\"id\":72,\"name\":\"区域管理\",\"parentId\":67,\"level\":\"0.67\",\"seq\":5,\"status\":1,\"remark\":\"区域管理\",\"operator\":\"Admin\",\"operateTime\":1522640395581,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-04-02 11:39:56', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('210', '4', '61', '', '{\"id\":61,\"code\":\"20180402114233_0\",\"name\":\"会费设置\",\"aclModuleId\":68,\"url\":\"/get/MemberFee\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"会费设置\",\"operator\":\"Admin\",\"operateTime\":1522640553554,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-04-02 11:42:34', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('211', '4', '62', '', '{\"id\":62,\"code\":\"20180402114505_0\",\"name\":\"手续费设置\",\"aclModuleId\":69,\"url\":\"/get/serviceFee\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"会费设置\",\"operator\":\"Admin\",\"operateTime\":1522640705604,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-04-02 11:45:06', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('212', '4', '63', '', '{\"id\":63,\"code\":\"20180402114612_2\",\"name\":\"难度设置\",\"aclModuleId\":70,\"url\":\"/get/difficultySet\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"难度设置\",\"operator\":\"Admin\",\"operateTime\":1522640772779,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-04-02 11:46:13', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('213', '4', '64', '', '{\"id\":64,\"code\":\"20180402114744_6\",\"name\":\"教材设置\",\"aclModuleId\":71,\"url\":\"/get/textbookSet\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"教材设置\",\"operator\":\"Admin\",\"operateTime\":1522640864080,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-04-02 11:47:44', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('214', '4', '61', '{\"id\":61,\"code\":\"20180402114233_0\",\"name\":\"会费设置\",\"aclModuleId\":68,\"url\":\"/get/MemberFee\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"会费设置\",\"operator\":\"Admin\",\"operateTime\":1522640554000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":61,\"name\":\"会费设置\",\"aclModuleId\":68,\"url\":\"/get/memberFee\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"会费设置\",\"operator\":\"Admin\",\"operateTime\":1522640976314,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-04-02 11:49:36', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('215', '4', '46', '{\"id\":46,\"code\":\"20180329170044_79\",\"name\":\"曲谱管理\",\"aclModuleId\":50,\"url\":\"/get/operaManagement\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"曲谱管理\",\"operator\":\"Admin\",\"operateTime\":1522314044000,\"operateIp\":\"192.168.1.66\"}', '{\"id\":46,\"name\":\"曲谱管理\",\"aclModuleId\":50,\"url\":\"/get/seeOpera\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"曲谱管理\",\"operator\":\"Admin\",\"operateTime\":1522650942999,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-04-02 14:35:43', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('216', '4', '13', '{\"id\":13,\"code\":\"20180326182138_79\",\"name\":\"游戏记录查看\",\"aclModuleId\":17,\"url\":\"/game/getall.page\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"1\",\"operator\":\"Admin\",\"operateTime\":1522059699000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":13,\"name\":\"游戏记录查看\",\"aclModuleId\":17,\"url\":\"/game/gameManage.page\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"1\",\"operator\":\"Admin\",\"operateTime\":1522652517801,\"operateIp\":\"192.168.1.66\"}', 'Admin', '2018-04-02 15:01:58', '192.168.1.66', '1');
INSERT INTO `sys_log` VALUES ('217', '4', '13', '{\"id\":13,\"code\":\"20180326182138_79\",\"name\":\"游戏记录查看\",\"aclModuleId\":17,\"url\":\"/game/gameManage.page\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"1\",\"operator\":\"Admin\",\"operateTime\":1522652518000,\"operateIp\":\"192.168.1.66\"}', '{\"id\":13,\"name\":\"游戏记录查看\",\"aclModuleId\":17,\"url\":\"/get/gameManage.page\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"游戏记录查看\",\"operator\":\"Admin\",\"operateTime\":1522652825690,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-04-02 15:07:06', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('218', '4', '65', '', '{\"id\":65,\"code\":\"20180402151151_19\",\"name\":\"栏目管理\",\"aclModuleId\":41,\"url\":\"/get/columnManagement.page\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"/get/columnManagement.page\",\"operator\":\"Admin\",\"operateTime\":1522653111416,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-04-02 15:11:51', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('219', '4', '66', '', '{\"id\":66,\"code\":\"20180403155840_35\",\"name\":\"滚动广告-栏目管理\",\"aclModuleId\":43,\"url\":\"/get/getAds\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"滚动广告-栏目管理\",\"operator\":\"Admin\",\"operateTime\":1522742320605,\"operateIp\":\"220.248.65.234\"}', 'Admin', '2018-04-03 15:58:41', '220.248.65.234', '1');
INSERT INTO `sys_log` VALUES ('220', '5', '6', '', '{\"id\":6,\"name\":\"fansen\",\"type\":1,\"status\":1,\"operator\":\"Admin\",\"operateTime\":1525745195255,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-05-08 10:06:35', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('221', '6', '6', '[]', '[43,44,45,46]', 'Admin', '2018-05-08 10:06:55', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('222', '5', '7', '', '{\"id\":7,\"name\":\"fansen\",\"type\":1,\"status\":1,\"remark\":\"fansen\",\"operator\":\"Admin\",\"operateTime\":1525745335280,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-05-08 10:08:55', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('223', '5', '4', '{\"id\":4,\"name\":\"权限管理员\",\"type\":1,\"status\":1,\"operator\":\"Admin\",\"operateTime\":1508074236000,\"operateIp\":\"0:0:0:0:0:0:0:1\"}', '{\"id\":4,\"name\":\"editor\",\"type\":1,\"status\":1,\"remark\":\"电鼓编辑器\",\"operator\":\"Admin\",\"operateTime\":1525832640488,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-05-09 10:24:01', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('224', '5', '4', '{\"id\":4,\"name\":\"editor\",\"type\":1,\"status\":1,\"remark\":\"电鼓编辑器\",\"operator\":\"Admin\",\"operateTime\":1525832640000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":4,\"name\":\"权限管理员\",\"type\":1,\"status\":1,\"remark\":\"权限管理员\",\"operator\":\"Admin\",\"operateTime\":1525832739282,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-05-09 10:25:39', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('225', '2', '10', '', '{\"id\":10,\"username\":\"eleDrumEditer\",\"telephone\":\"12345678\",\"mail\":\"123456@qq.com\",\"password\":\"44BF025D27EEA66336E5C1133C3827F7\",\"deptId\":1,\"status\":1,\"remark\":\"电鼓编辑器角色  123456password\",\"operator\":\"Admin\",\"operateTime\":1525832978066,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-05-09 10:29:38', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('226', '6', '3', '[7,8,9,10,34,38,42]', '[7,8,9,10,34,38,42,43,44,45,46]', 'Admin', '2018-05-09 10:42:22', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('227', '7', '3', '[6]', '[6,10]', 'Admin', '2018-05-09 10:42:31', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('228', '4', '67', '', '{\"id\":67,\"code\":\"20180522151627_35\",\"name\":\"分润统计报表\",\"aclModuleId\":53,\"url\":\"/get/ShareProfitCount\",\"type\":1,\"status\":1,\"seq\":5,\"remark\":\"分润统计报\",\"operator\":\"Admin\",\"operateTime\":1526973387564,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-05-22 15:16:28', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('229', '3', '73', '', '{\"id\":73,\"name\":\"分润统计报表\",\"parentId\":54,\"level\":\"0.53.54\",\"seq\":5,\"status\":1,\"remark\":\"分润统计报表\",\"operator\":\"Admin\",\"operateTime\":1526973560274,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-05-22 15:19:20', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('230', '3', '74', '', '{\"id\":74,\"name\":\"分润统计报表\",\"parentId\":53,\"level\":\"0.53\",\"seq\":5,\"status\":1,\"remark\":\"分润统计报表\",\"operator\":\"Admin\",\"operateTime\":1526973612609,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-05-22 15:20:13', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('231', '4', '68', '', '{\"id\":68,\"code\":\"20180522152133_73\",\"name\":\"请求\",\"aclModuleId\":74,\"url\":\"/get/deafasfasfsdf\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"2\",\"operator\":\"Admin\",\"operateTime\":1526973693404,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-05-22 15:21:33', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('232', '4', '68', '{\"id\":68,\"code\":\"20180522152133_73\",\"name\":\"请求\",\"aclModuleId\":74,\"url\":\"/get/deafasfasfsdf\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"2\",\"operator\":\"Admin\",\"operateTime\":1526973693000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":68,\"name\":\"分润统计报表\",\"aclModuleId\":74,\"url\":\"/get/shareProfitCount\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"分润统计报表\",\"operator\":\"Admin\",\"operateTime\":1526973841535,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-05-22 15:24:02', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('233', '3', '75', '', '{\"id\":75,\"name\":\"积分管理\",\"parentId\":0,\"level\":\"0\",\"seq\":1,\"status\":1,\"remark\":\"积分管理\",\"operator\":\"Admin\",\"operateTime\":1527069798518,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-05-23 18:03:19', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('234', '3', '67', '{\"id\":67,\"name\":\"参数设置\",\"parentId\":0,\"level\":\"0\",\"seq\":15,\"status\":1,\"remark\":\"参数设置\",\"operator\":\"Admin\",\"operateTime\":1522640195000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":67,\"name\":\"参数设置\",\"parentId\":0,\"level\":\"0\",\"seq\":20,\"status\":1,\"remark\":\"参数设置\",\"operator\":\"Admin\",\"operateTime\":1527069978128,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-05-23 18:06:18', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('235', '3', '75', '{\"id\":75,\"name\":\"积分管理\",\"parentId\":0,\"level\":\"0\",\"seq\":1,\"status\":1,\"remark\":\"积分管理\",\"operator\":\"Admin\",\"operateTime\":1527069799000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":75,\"name\":\"积分管理\",\"parentId\":0,\"level\":\"0\",\"seq\":19,\"status\":1,\"remark\":\"积分管理\",\"operator\":\"Admin\",\"operateTime\":1527069990649,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-05-23 18:06:31', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('236', '3', '16', '{\"id\":16,\"name\":\"游戏管理\",\"parentId\":0,\"level\":\"0\",\"seq\":1,\"status\":1,\"remark\":\"游戏管理\",\"operator\":\"Admin\",\"operateTime\":1522059571000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":16,\"name\":\"游戏管理\",\"parentId\":0,\"level\":\"0\",\"seq\":18,\"status\":1,\"remark\":\"游戏管理\",\"operator\":\"Admin\",\"operateTime\":1527069996399,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-05-23 18:06:36', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('237', '3', '64', '{\"id\":64,\"name\":\"消息管理\",\"parentId\":0,\"level\":\"0\",\"seq\":14,\"status\":1,\"remark\":\"消息管理\",\"operator\":\"Admin\",\"operateTime\":1522638858000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":64,\"name\":\"消息管理\",\"parentId\":0,\"level\":\"0\",\"seq\":15,\"status\":1,\"remark\":\"消息管理\",\"operator\":\"Admin\",\"operateTime\":1527070017047,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-05-23 18:06:57', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('238', '3', '16', '{\"id\":16,\"name\":\"游戏管理\",\"parentId\":0,\"level\":\"0\",\"seq\":18,\"status\":1,\"remark\":\"游戏管理\",\"operator\":\"Admin\",\"operateTime\":1527069996000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":16,\"name\":\"游戏管理\",\"parentId\":0,\"level\":\"0\",\"seq\":14,\"status\":1,\"remark\":\"游戏管理\",\"operator\":\"Admin\",\"operateTime\":1527070022887,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-05-23 18:07:03', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('239', '3', '59', '{\"id\":59,\"name\":\"商城管理\",\"parentId\":0,\"level\":\"0\",\"seq\":13,\"status\":1,\"remark\":\"商城管理\",\"operator\":\"Admin\",\"operateTime\":1522633311000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":59,\"name\":\"商城管理\",\"parentId\":0,\"level\":\"0\",\"seq\":1,\"status\":1,\"remark\":\"商城管理\",\"operator\":\"Admin\",\"operateTime\":1527070035287,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-05-23 18:07:15', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('240', '4', '69', '', '{\"id\":69,\"code\":\"20180523180848_14\",\"name\":\"积分管理\",\"aclModuleId\":75,\"url\":\"/get/integrationSet\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"积分管理\",\"operator\":\"Admin\",\"operateTime\":1527070128803,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-05-23 18:08:49', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('241', '3', '76', '', '{\"id\":76,\"name\":\"积分管理\",\"parentId\":75,\"level\":\"0.75\",\"seq\":1,\"status\":1,\"remark\":\"积分管理\",\"operator\":\"Admin\",\"operateTime\":1527070168484,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-05-23 18:09:28', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('242', '3', '77', '', '{\"id\":77,\"name\":\"游戏积分管理\",\"parentId\":75,\"level\":\"0.75\",\"seq\":2,\"status\":1,\"remark\":\"游戏积分管理\",\"operator\":\"Admin\",\"operateTime\":1527070195658,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-05-23 18:09:56', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('243', '4', '69', '{\"id\":69,\"code\":\"20180523180848_14\",\"name\":\"积分管理\",\"aclModuleId\":75,\"url\":\"/get/integrationSet\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"积分管理\",\"operator\":\"Admin\",\"operateTime\":1527070129000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":69,\"name\":\"积分管理\",\"aclModuleId\":76,\"url\":\"/get/integrationSet\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"积分管理\",\"operator\":\"Admin\",\"operateTime\":1527070217864,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-05-23 18:10:18', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('244', '4', '70', '', '{\"id\":70,\"code\":\"20180523181107_2\",\"name\":\"游戏积分管理\",\"aclModuleId\":77,\"url\":\"/get/gameintegrationSet\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"游戏积分管理\",\"operator\":\"Admin\",\"operateTime\":1527070267453,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-05-23 18:11:07', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('245', '2', '11', '', '{\"id\":11,\"username\":\"总管理\",\"telephone\":\"6666666666\",\"mail\":\"66666666@qq.com\",\"password\":\"257A734DE75D8302DE97FCBEF0AD68A6\",\"deptId\":1,\"status\":1,\"remark\":\"密码6666663333\",\"operator\":\"Admin\",\"operateTime\":1527220416317,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-05-25 11:53:36', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('246', '6', '4', '[12,41,48,51,7,8,9,10,13,19,11,16,54,21,22,20,23,25,26,30,27,28,29,31,32,33,34,38,42,43,44,45,46,47,49,50,52,53]', '[55,56,57,58,27,28,31,32,33,34,38,42,43,44,45,46,47,49,50,52,53,13]', 'Admin', '2018-05-25 11:54:36', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('247', '7', '4', '[1,2]', '[1,11]', 'Admin', '2018-05-25 11:54:59', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('248', '5', '8', '', '{\"id\":8,\"name\":\"老师管理\",\"type\":1,\"status\":1,\"operator\":\"Admin\",\"operateTime\":1527247762346,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-05-25 19:29:23', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('249', '6', '8', '[]', '[12,41,48,51,7,8,9,10,55,56,57,58,19,11,16,54,21,22,20,23,25,26,30,27,28,29,31,32,33,34,65,66,38,42,43,44,45,46,47,67,49,50,52,53,68,13,59,60,69,70,61,62,63,64]', 'Admin', '2018-05-25 19:29:49', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('250', '7', '8', '[]', '[15]', 'Admin', '2018-05-25 19:29:56', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('251', '3', '59', '{\"id\":59,\"name\":\"商城管理\",\"parentId\":0,\"level\":\"0\",\"seq\":1,\"status\":1,\"remark\":\"商城管理\",\"operator\":\"Admin\",\"operateTime\":1527070035000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":59,\"name\":\"商城管理\",\"parentId\":0,\"level\":\"0\",\"seq\":14,\"status\":1,\"remark\":\"商城管理\",\"operator\":\"lingbin\",\"operateTime\":1527248507283,\"operateIp\":\"127.0.0.1\"}', 'lingbin', '2018-05-25 19:41:47', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('252', '3', '16', '{\"id\":16,\"name\":\"游戏管理\",\"parentId\":0,\"level\":\"0\",\"seq\":14,\"status\":1,\"remark\":\"游戏管理\",\"operator\":\"Admin\",\"operateTime\":1527070023000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":16,\"name\":\"游戏管理\",\"parentId\":0,\"level\":\"0\",\"seq\":7,\"status\":1,\"remark\":\"游戏管理\",\"operator\":\"lingbin\",\"operateTime\":1527248531667,\"operateIp\":\"127.0.0.1\"}', 'lingbin', '2018-05-25 19:42:12', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('253', '3', '78', '', '{\"id\":78,\"name\":\"积分记录管理\",\"parentId\":0,\"level\":\"0\",\"seq\":18,\"status\":1,\"remark\":\"积分记录管理\",\"operator\":\"Admin\",\"operateTime\":1528256669417,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-06-06 11:44:30', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('254', '3', '79', '', '{\"id\":79,\"name\":\"积分记录\",\"parentId\":78,\"level\":\"0.78\",\"seq\":1,\"status\":1,\"remark\":\"积分记录\",\"operator\":\"Admin\",\"operateTime\":1528257060603,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-06-06 11:51:01', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('255', '4', '71', '', '{\"id\":71,\"code\":\"20180606115301_32\",\"name\":\"的方式\",\"aclModuleId\":79,\"url\":\"1dfsfsfsfsdfd\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"胜丰沙\",\"operator\":\"Admin\",\"operateTime\":1528257181437,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-06-06 11:53:01', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('256', '4', '72', '', '{\"id\":72,\"code\":\"20180606122233_28\",\"name\":\"积分获取记录\",\"aclModuleId\":79,\"url\":\"/get/getUserScoreDetail\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"积分获取记录\",\"operator\":\"Admin\",\"operateTime\":1528258953338,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-06-06 12:22:34', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('257', '4', '71', '{\"id\":71,\"code\":\"20180606115301_32\",\"name\":\"的方式\",\"aclModuleId\":79,\"url\":\"1dfsfsfsfsdfd\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"胜丰沙\",\"operator\":\"Admin\",\"operateTime\":1528257181000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":71,\"name\":\"的方式\",\"aclModuleId\":79,\"url\":\"1dfsfsfsfsdfd\",\"type\":1,\"status\":0,\"seq\":1,\"remark\":\"胜丰沙\",\"operator\":\"Admin\",\"operateTime\":1528259106118,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-06-06 12:25:06', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('258', '3', '79', '{\"id\":79,\"name\":\"积分记录\",\"parentId\":78,\"level\":\"0.78\",\"seq\":1,\"status\":1,\"remark\":\"积分获取记录\",\"operator\":\"Admin\",\"operateTime\":1528257061000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":79,\"name\":\"积分获取记录\",\"parentId\":78,\"level\":\"0.78\",\"seq\":1,\"status\":1,\"remark\":\"积分获取记录\",\"operator\":\"Admin\",\"operateTime\":1528259233234,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-06-06 12:27:13', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('259', '3', '80', '', '{\"id\":80,\"name\":\"充值中心\",\"parentId\":25,\"level\":\"0.25\",\"seq\":3,\"status\":1,\"remark\":\"充值中心\",\"operator\":\"Admin\",\"operateTime\":1528269586693,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-06-06 15:19:47', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('260', '4', '73', '', '{\"id\":73,\"code\":\"20180606152151_75\",\"name\":\"充值中心\",\"aclModuleId\":80,\"url\":\"/get/pay.page\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"充值中心\",\"operator\":\"Admin\",\"operateTime\":1528269711326,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-06-06 15:21:51', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('261', '4', '73', '{\"id\":73,\"code\":\"20180606152151_75\",\"name\":\"充值中心\",\"aclModuleId\":80,\"url\":\"/get/Paypage\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"充值中心\",\"operator\":\"Admin\",\"operateTime\":1528269711000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":73,\"name\":\"充值中心\",\"aclModuleId\":80,\"url\":\"/get/Paypage.page\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"充值中心\",\"operator\":\"Admin\",\"operateTime\":1528270625329,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-06-06 15:37:06', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('262', '4', '73', '{\"id\":73,\"code\":\"20180606152151_75\",\"name\":\"充值中心\",\"aclModuleId\":80,\"url\":\"/get/Paypage.page\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"充值中心\",\"operator\":\"Admin\",\"operateTime\":1528270625000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":73,\"name\":\"充值中心\",\"aclModuleId\":80,\"url\":\"/withdrawDetail/Paypage.page\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"充值中心\",\"operator\":\"Admin\",\"operateTime\":1528276436559,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-06-06 17:13:57', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('263', '4', '73', '{\"id\":73,\"code\":\"20180606152151_75\",\"name\":\"充值中心\",\"aclModuleId\":80,\"url\":\"/withdrawDetail/Paypage.page\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"充值中心\",\"operator\":\"Admin\",\"operateTime\":1528276437000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":73,\"name\":\"充值中心\",\"aclModuleId\":80,\"url\":\"/get/Paypage.page\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"充值中心\",\"operator\":\"Admin\",\"operateTime\":1528276636736,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-06-06 17:17:17', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('264', '4', '73', '{\"id\":73,\"code\":\"20180606152151_75\",\"name\":\"充值中心\",\"aclModuleId\":80,\"url\":\"/get/Paypage.page\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"充值中心\",\"operator\":\"Admin\",\"operateTime\":1528276637000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":73,\"name\":\"充值中心\",\"aclModuleId\":80,\"url\":\"/get/recharge.page\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"充值中心\",\"operator\":\"Admin\",\"operateTime\":1528277161252,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-06-06 17:26:01', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('265', '3', '81', '', '{\"id\":81,\"name\":\"增加服务商\",\"parentId\":12,\"level\":\"0.12\",\"seq\":9,\"status\":1,\"remark\":\"增加服务商\",\"operator\":\"Admin\",\"operateTime\":1528356504601,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-06-07 15:28:25', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('266', '3', '30', '{\"id\":30,\"name\":\"添加老师\",\"parentId\":12,\"level\":\"0.12\",\"seq\":9,\"status\":1,\"remark\":\"添加老师\",\"operator\":\"Admin\",\"operateTime\":1522230913000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":30,\"name\":\"添加老师\",\"parentId\":12,\"level\":\"0.12\",\"seq\":10,\"status\":1,\"remark\":\"添加老师\",\"operator\":\"Admin\",\"operateTime\":1528356515418,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-06-07 15:28:35', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('267', '3', '82', '', '{\"id\":82,\"name\":\"增加机构\",\"parentId\":12,\"level\":\"0.12\",\"seq\":10,\"status\":1,\"remark\":\"增加机构\",\"operator\":\"Admin\",\"operateTime\":1528356570187,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-06-07 15:29:30', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('268', '3', '30', '{\"id\":30,\"name\":\"添加老师\",\"parentId\":12,\"level\":\"0.12\",\"seq\":10,\"status\":1,\"remark\":\"添加老师\",\"operator\":\"Admin\",\"operateTime\":1528356515000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":30,\"name\":\"添加老师\",\"parentId\":12,\"level\":\"0.12\",\"seq\":11,\"status\":1,\"remark\":\"添加老师\",\"operator\":\"Admin\",\"operateTime\":1528356582917,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-06-07 15:29:43', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('269', '4', '74', '', '{\"id\":74,\"code\":\"20180607153051_90\",\"name\":\"增加服务商\",\"aclModuleId\":6,\"url\":\"/get/addService\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"增加服务商\",\"operator\":\"Admin\",\"operateTime\":1528356651548,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-06-07 15:30:52', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('270', '4', '75', '', '{\"id\":75,\"code\":\"20180607153240_41\",\"name\":\"增加服务商\",\"aclModuleId\":81,\"url\":\"/get/addService\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"增加服务商\",\"operator\":\"Admin\",\"operateTime\":1528356760713,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-06-07 15:32:41', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('271', '4', '76', '', '{\"id\":76,\"code\":\"20180607153320_17\",\"name\":\"增加机构\",\"aclModuleId\":82,\"url\":\"/get/addOrganization\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"增加机构\",\"operator\":\"Admin\",\"operateTime\":1528356800197,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-06-07 15:33:20', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('272', '7', '3', '[6,10]', '[6,10,18]', 'Admin', '2018-06-07 16:54:31', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('273', '5', '9', '', '{\"id\":9,\"name\":\"琴行\",\"type\":1,\"status\":1,\"remark\":\"琴行\",\"operator\":\"Admin\",\"operateTime\":1528363785104,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-06-07 17:29:45', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('274', '6', '9', '[]', '[20,23,25,30,27,29,31,33,34,50,52,53,68]', 'Admin', '2018-06-08 16:40:07', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('275', '7', '9', '[]', '[2]', 'Admin', '2018-06-08 16:44:55', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('276', '5', '8', '{\"id\":8,\"name\":\"老师管理\",\"type\":1,\"status\":1,\"operator\":\"Admin\",\"operateTime\":1527247762000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":8,\"name\":\"老师管理\",\"type\":1,\"status\":0,\"operator\":\"Admin\",\"operateTime\":1528447903145,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-06-08 16:51:43', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('277', '5', '4', '{\"id\":4,\"name\":\"权限管理员\",\"type\":1,\"status\":1,\"remark\":\"权限管理员\",\"operator\":\"Admin\",\"operateTime\":1525832739000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":4,\"name\":\"权限管理员\",\"type\":1,\"status\":0,\"remark\":\"权限管理员\",\"operator\":\"Admin\",\"operateTime\":1528447907399,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-06-08 16:51:47', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('278', '5', '3', '{\"id\":3,\"name\":\"会员管理员\",\"type\":1,\"status\":1,\"operator\":\"Admin\",\"operateTime\":1522037541000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":3,\"name\":\"会员管理员\",\"type\":1,\"status\":0,\"operator\":\"Admin\",\"operateTime\":1528447912664,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-06-08 16:51:53', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('279', '7', '9', '[2]', '[2,24]', 'Admin4', '2018-06-08 16:58:14', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('280', '5', '9', '{\"id\":9,\"name\":\"琴行\",\"type\":1,\"status\":1,\"remark\":\"琴行\",\"operator\":\"Admin\",\"operateTime\":1528363785000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":9,\"name\":\"机构\",\"type\":1,\"status\":1,\"remark\":\"琴行\",\"operator\":\"Admin\",\"operateTime\":1528448396979,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-06-08 16:59:57', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('281', '5', '10', '', '{\"id\":10,\"name\":\"服务商\",\"type\":1,\"status\":1,\"operator\":\"Admin\",\"operateTime\":1528448418955,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-06-08 17:00:19', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('282', '5', '9', '{\"id\":9,\"name\":\"机构\",\"type\":1,\"status\":1,\"remark\":\"琴行\",\"operator\":\"Admin\",\"operateTime\":1528448397000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":9,\"name\":\"琴行\",\"type\":1,\"status\":1,\"remark\":\"琴行\",\"operator\":\"Admin\",\"operateTime\":1528448443697,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-06-08 17:00:44', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('283', '5', '11', '', '{\"id\":11,\"name\":\"机构\",\"type\":1,\"status\":1,\"operator\":\"Admin\",\"operateTime\":1528448453505,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-06-08 17:00:54', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('284', '5', '12', '', '{\"id\":12,\"name\":\"总管理\",\"type\":1,\"status\":1,\"operator\":\"Admin\",\"operateTime\":1528448464232,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-06-08 17:01:04', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('285', '5', '9', '{\"id\":9,\"name\":\"琴行\",\"type\":1,\"status\":1,\"remark\":\"琴行\",\"operator\":\"Admin\",\"operateTime\":1528448444000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":9,\"name\":\"总管理1\",\"type\":1,\"status\":1,\"operator\":\"Admin\",\"operateTime\":1528448550424,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-06-08 17:02:30', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('286', '5', '12', '{\"id\":12,\"name\":\"总管理\",\"type\":1,\"status\":1,\"operator\":\"Admin\",\"operateTime\":1528448464000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":12,\"name\":\"琴行\",\"type\":1,\"status\":1,\"operator\":\"Admin\",\"operateTime\":1528448560343,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-06-08 17:02:40', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('287', '5', '9', '{\"id\":9,\"name\":\"总管理1\",\"type\":1,\"status\":1,\"operator\":\"Admin\",\"operateTime\":1528448550000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":9,\"name\":\"总管理\",\"type\":1,\"status\":1,\"operator\":\"Admin\",\"operateTime\":1528448566823,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-06-08 17:02:47', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('288', '6', '9', '[20,23,25,30,27,29,31,33,34,50,52,53,68]', '[12,41,48,51,74,7,8,9,10,19,11,16,54,21,22,20,23,25,26,75,76,30,27,28,73,29,31,32,33,13,34,65,66,38,42,43,44,45,46,47,67,49,50,52,53,68,55,56,57,58,59,60,72,69,70,61,62,63,64]', 'Admin', '2018-06-08 17:03:22', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('289', '6', '10', '[]', '[19,11,16,54,21,22,20,23,25,26,75,76,30,50,52,53,68]', 'Admin', '2018-06-08 17:04:21', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('290', '6', '10', '[19,11,16,54,21,22,20,23,25,26,75,76,30,50,52,53,68]', '[21,22,20,23,25,50,52,53,68]', 'Admin', '2018-06-08 17:05:22', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('291', '6', '11', '[]', '[22,20,23,25,27,29,31,33,43,44,45,46,50,52,53,68]', 'Admin', '2018-06-08 17:06:55', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('292', '6', '12', '[]', '[20,23,25,27,29,31,33,34,50,52,53,68]', 'Admin', '2018-06-08 17:08:15', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('293', '3', '83', '', '{\"id\":83,\"name\":\"个人中心\",\"parentId\":0,\"level\":\"0\",\"seq\":22,\"status\":1,\"remark\":\"个人中心\",\"operator\":\"Admin\",\"operateTime\":1528449096292,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-06-08 17:11:36', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('294', '3', '84', '', '{\"id\":84,\"name\":\"修改账户密码\",\"parentId\":83,\"level\":\"0.83\",\"seq\":1,\"status\":1,\"remark\":\"修改账户密码\",\"operator\":\"Admin\",\"operateTime\":1528449162172,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-06-08 17:12:42', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('295', '4', '77', '', '{\"id\":77,\"code\":\"20180608171831_76\",\"name\":\"修改密码\",\"aclModuleId\":84,\"url\":\"/get/updatePassword\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"修改密码\",\"operator\":\"Admin\",\"operateTime\":1528449511999,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-06-08 17:18:32', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('296', '3', '85', '', '{\"id\":85,\"name\":\"计数器记录\",\"parentId\":78,\"level\":\"0.78\",\"seq\":3,\"status\":1,\"remark\":\"计数器记录\",\"operator\":\"Admin2\",\"operateTime\":1528705776225,\"operateIp\":\"127.0.0.1\"}', 'Admin2', '2018-06-11 16:29:37', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('297', '4', '78', '', '{\"id\":78,\"code\":\"20180611172531_33\",\"name\":\"计数器记录\",\"aclModuleId\":85,\"url\":\" \\t/get/getCountRecord\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"计数器记录\",\"operator\":\"Admin2\",\"operateTime\":1528709131744,\"operateIp\":\"127.0.0.1\"}', 'Admin2', '2018-06-11 17:25:32', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('298', '3', '86', '', '{\"id\":86,\"name\":\"基础练习记录\",\"parentId\":78,\"level\":\"0.78\",\"seq\":4,\"status\":1,\"remark\":\"基础练习记录\",\"operator\":\"Admin2\",\"operateTime\":1528711163071,\"operateIp\":\"127.0.0.1\"}', 'Admin2', '2018-06-11 17:59:23', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('299', '4', '79', '', '{\"id\":79,\"code\":\"20180611180142_65\",\"name\":\"基础练习记录\",\"aclModuleId\":86,\"url\":\"/get/getSongRecord\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"基础练习记录\",\"operator\":\"Admin2\",\"operateTime\":1528711302178,\"operateIp\":\"127.0.0.1\"}', 'Admin2', '2018-06-11 18:01:42', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('300', '3', '87', '', '{\"id\":87,\"name\":\"会费缴纳\",\"parentId\":0,\"level\":\"0\",\"seq\":27,\"status\":1,\"remark\":\"会费缴纳\",\"operator\":\"Admin\",\"operateTime\":1528718434301,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-06-11 20:00:35', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('301', '3', '88', '', '{\"id\":88,\"name\":\"会费缴纳详情\",\"parentId\":87,\"level\":\"0.87\",\"seq\":1,\"status\":1,\"remark\":\"会费缴纳详情\",\"operator\":\"Admin\",\"operateTime\":1528718476079,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-06-11 20:01:16', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('302', '3', '89', '', '{\"id\":89,\"name\":\"会费缴纳详情2\",\"parentId\":87,\"level\":\"0.87\",\"seq\":1,\"status\":1,\"remark\":\"会费缴纳详情\",\"operator\":\"Admin3\",\"operateTime\":1528767872473,\"operateIp\":\"127.0.0.1\"}', 'Admin3', '2018-06-12 09:44:33', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('303', '3', '87', '{\"id\":87,\"name\":\"会费缴纳\",\"parentId\":0,\"level\":\"0\",\"seq\":27,\"status\":1,\"remark\":\"会费缴纳\",\"operator\":\"Admin\",\"operateTime\":1528718434000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":87,\"name\":\"会费缴纳\",\"parentId\":0,\"level\":\"0\",\"seq\":23,\"status\":1,\"remark\":\"会费缴纳\",\"operator\":\"Admin3\",\"operateTime\":1528767945351,\"operateIp\":\"127.0.0.1\"}', 'Admin3', '2018-06-12 09:45:45', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('304', '4', '80', '', '{\"id\":80,\"code\":\"20180612094830_48\",\"name\":\"会费缴纳详情\",\"aclModuleId\":6,\"url\":\"/get/getMembershipDues\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"会费缴纳详情\",\"operator\":\"Admin\",\"operateTime\":1528768110102,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-06-12 09:48:30', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('305', '4', '81', '', '{\"id\":81,\"code\":\"20180612094922_38\",\"name\":\"会费缴纳详情\",\"aclModuleId\":88,\"url\":\"/get/getMembershipDues\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"会费缴纳详情\",\"operator\":\"Admin\",\"operateTime\":1528768162546,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-06-12 09:49:23', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('306', '3', '90', '', '{\"id\":90,\"name\":\"我的账户\",\"parentId\":53,\"level\":\"0.53\",\"seq\":7,\"status\":1,\"remark\":\"我的账户\",\"operator\":\"Admin\",\"operateTime\":1528786422410,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-06-12 14:53:43', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('307', '4', '82', '', '{\"id\":82,\"code\":\"20180612145434_80\",\"name\":\"我的账户\",\"aclModuleId\":90,\"url\":\"/get/getMyUserXinxi\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"我的账户\",\"operator\":\"Admin\",\"operateTime\":1528786474372,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-06-12 14:54:34', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('308', '6', '11', '[22,20,23,25,27,29,31,33,43,44,45,46,50,52,53,68]', '[22,20,23,25,27,29,31,33,43,44,45,46,50,52,53,68,82,77]', 'Admin', '2018-06-12 17:02:07', '223.166.74.163', '1');
INSERT INTO `sys_log` VALUES ('309', '5', '10', '{\"id\":10,\"name\":\"服务商\",\"type\":1,\"status\":1,\"operator\":\"Admin\",\"operateTime\":1528448419000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":10,\"name\":\"服务商\",\"type\":1,\"status\":1,\"operator\":\"Admin\",\"operateTime\":1528794420294,\"operateIp\":\"223.166.74.163\"}', 'Admin', '2018-06-12 17:07:00', '223.166.74.163', '1');
INSERT INTO `sys_log` VALUES ('310', '7', '10', '[]', '[39]', 'Admin', '2018-06-12 17:08:45', '223.166.74.163', '1');
INSERT INTO `sys_log` VALUES ('311', '7', '11', '[]', '[39]', 'Admin', '2018-06-12 17:09:30', '223.166.74.163', '1');
INSERT INTO `sys_log` VALUES ('312', '3', '91', '', '{\"id\":91,\"name\":\"过渡界面管理\",\"parentId\":0,\"level\":\"0\",\"seq\":29,\"status\":1,\"remark\":\"过渡界面管理\",\"operator\":\"Admin3\",\"operateTime\":1528879705305,\"operateIp\":\"127.0.0.1\"}', 'Admin3', '2018-06-13 16:48:26', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('313', '3', '92', '', '{\"id\":92,\"name\":\"过渡界面管理\",\"parentId\":91,\"level\":\"0.91\",\"seq\":1,\"status\":1,\"remark\":\"过渡界面管理\",\"operator\":\"Admin3\",\"operateTime\":1528879751267,\"operateIp\":\"127.0.0.1\"}', 'Admin3', '2018-06-13 16:49:11', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('314', '3', '92', '{\"id\":92,\"name\":\"过渡界面管理\",\"parentId\":91,\"level\":\"0.91\",\"seq\":1,\"status\":1,\"remark\":\"过渡界面管理\",\"operator\":\"Admin3\",\"operateTime\":1528879751000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":92,\"name\":\"过渡界面上传图片\",\"parentId\":91,\"level\":\"0.91\",\"seq\":1,\"status\":1,\"remark\":\"过渡界面上传图片\",\"operator\":\"Admin3\",\"operateTime\":1528879814710,\"operateIp\":\"127.0.0.1\"}', 'Admin3', '2018-06-13 16:50:15', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('315', '4', '83', '', '{\"id\":83,\"code\":\"20180613165558_97\",\"name\":\"过渡界面上传图片\",\"aclModuleId\":92,\"url\":\"/get/uploadPicture\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"过渡界面上传图片\",\"operator\":\"Admin3\",\"operateTime\":1528880158224,\"operateIp\":\"127.0.0.1\"}', 'Admin3', '2018-06-13 16:55:58', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('316', '6', '9', '[12,41,48,51,74,7,8,9,10,19,11,16,54,21,22,20,23,25,26,75,76,30,27,28,73,29,31,32,33,13,34,65,66,38,42,43,44,45,46,47,67,49,50,52,53,68,55,56,57,58,59,60,72,69,70,61,62,63,64]', '[12,41,48,51,74,7,8,9,10,19,16,54,21,22,20,23,25,26,75,76,30,27,28,73,29,31,32,33,13,34,65,66,38,42,43,44,45,46,47,67,49,50,52,53,68,55,56,57,59,60,72,69,70,61,62,63,64]', 'Admin', '2018-06-13 20:45:54', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('317', '6', '11', '[22,20,23,25,27,29,31,33,43,44,45,46,50,52,53,68,82,77]', '[22,20,23,25,27,29,31,33,43,44,45,50,52,53,68,82,77]', 'Admin', '2018-06-13 20:46:08', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('318', '6', '11', '[22,20,23,25,27,29,31,33,43,44,45,50,52,53,68,82,77]', '[22,20,23,25,27,29,31,33,43,44,45,46,50,52,53,68,82,77]', 'Admin', '2018-06-13 20:46:15', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('319', '3', '63', '{\"id\":63,\"name\":\"游戏管理\",\"parentId\":59,\"level\":\"0.59\",\"seq\":4,\"status\":1,\"remark\":\"游戏管理\",\"operator\":\"Admin\",\"operateTime\":1522409631000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":63,\"name\":\"游戏管理\",\"parentId\":59,\"level\":\"0.59\",\"seq\":4,\"status\":0,\"remark\":\"游戏管理\",\"operator\":\"Admin\",\"operateTime\":1528894010213,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-06-13 20:46:50', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('320', '3', '16', '{\"id\":16,\"name\":\"游戏管理\",\"parentId\":0,\"level\":\"0\",\"seq\":7,\"status\":1,\"remark\":\"游戏管理\",\"operator\":\"lingbin\",\"operateTime\":1527248532000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":16,\"name\":\"游戏管理\",\"parentId\":0,\"level\":\"0\",\"seq\":15,\"status\":1,\"remark\":\"游戏管理\",\"operator\":\"Admin\",\"operateTime\":1528894045874,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-06-13 20:47:26', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('321', '3', '63', '{\"id\":63,\"name\":\"游戏管理\",\"parentId\":59,\"level\":\"0.59\",\"seq\":4,\"status\":0,\"remark\":\"游戏管理\",\"operator\":\"Admin\",\"operateTime\":1528894010000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":63,\"name\":\"游戏管理\",\"parentId\":59,\"level\":\"0.59\",\"seq\":4,\"status\":0,\"remark\":\"游戏管理\",\"operator\":\"Admin\",\"operateTime\":1528894170188,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-06-13 20:49:30', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('322', '3', '93', '', '{\"id\":93,\"name\":\"机构绑定琴行\",\"parentId\":12,\"level\":\"0.12\",\"seq\":10,\"status\":1,\"remark\":\"机构绑定琴行\",\"operator\":\"Admin\",\"operateTime\":1528958322070,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-06-14 14:38:42', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('323', '4', '84', '', '{\"id\":84,\"code\":\"20180614144223_57\",\"name\":\"机构绑定琴行\",\"aclModuleId\":93,\"url\":\"/get/addOrganizationByPianoShopaddOrganizationByPianoShop\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"机构绑定琴行\",\"operator\":\"Admin\",\"operateTime\":1528958543646,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-06-14 14:42:24', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('324', '4', '84', '{\"id\":84,\"code\":\"20180614144223_57\",\"name\":\"机构绑定琴行\",\"aclModuleId\":93,\"url\":\"/get/addOrganizationByPianoShopaddOrganizationByPianoShop\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"机构绑定琴行\",\"operator\":\"Admin\",\"operateTime\":1528958544000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":84,\"name\":\"机构绑定琴行\",\"aclModuleId\":93,\"url\":\"/get/addOrganizationByPianoShop\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"机构绑定琴行\",\"operator\":\"Admin1\",\"operateTime\":1528958786199,\"operateIp\":\"127.0.0.1\"}', 'Admin1', '2018-06-14 14:46:26', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('325', '4', '73', '{\"id\":73,\"code\":\"20180606152151_75\",\"name\":\"充值中心\",\"aclModuleId\":80,\"url\":\"/get/recharge.page\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"充值中心\",\"operator\":\"Admin\",\"operateTime\":1528277161000,\"operateIp\":\"127.0.0.1\"}', '{\"id\":73,\"name\":\"充值中心\",\"aclModuleId\":80,\"url\":\"/get/rechargeCenter\",\"type\":1,\"status\":1,\"seq\":1,\"remark\":\"充值中心\",\"operator\":\"Admin\",\"operateTime\":1528977128901,\"operateIp\":\"127.0.0.1\"}', 'Admin', '2018-06-14 19:52:09', '127.0.0.1', '1');
INSERT INTO `sys_log` VALUES ('326', '5', '13', '', '{\"id\":13,\"name\":\"鲁某某\",\"type\":1,\"status\":1,\"remark\":\"10111\",\"operator\":\"Admin\",\"operateTime\":1529563135984,\"operateIp\":\"220.248.67.25\"}', 'Admin', '2018-06-21 14:38:56', '220.248.67.25', '1');
INSERT INTO `sys_log` VALUES ('327', '5', '13', '{\"id\":13,\"name\":\"鲁某某\",\"type\":1,\"status\":1,\"remark\":\"10111\",\"operator\":\"Admin\",\"operateTime\":1529563136000,\"operateIp\":\"220.248.67.25\"}', '{\"id\":13,\"name\":\"家长\",\"type\":1,\"status\":0,\"operator\":\"Admin\",\"operateTime\":1529563595105,\"operateIp\":\"220.248.67.25\"}', 'Admin', '2018-06-21 14:46:35', '220.248.67.25', '1');

-- ----------------------------
-- Table structure for `sys_message`
-- ----------------------------
DROP TABLE IF EXISTS `sys_message`;
CREATE TABLE `sys_message` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '系统信息表',
  `content` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '系统消息内容',
  `message_type` int(11) DEFAULT NULL COMMENT '消息类型(1--个人  2--系统消息)',
  `object_id` int(11) DEFAULT NULL COMMENT '消息对象的id,全体成员时为-1.',
  `message_object` varchar(11) COLLATE utf8_bin DEFAULT NULL COMMENT '消息对象(玩家昵称,全体会员)',
  `send_time` datetime DEFAULT NULL COMMENT '发送时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=121 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of sys_message
-- ----------------------------
INSERT INTO `sys_message` VALUES ('102', '242424', '2', '-1', '全体会员', '2018-05-17 14:04:11');
INSERT INTO `sys_message` VALUES ('104', '43434343', '2', '-1', '全体会员', '2018-05-17 14:35:11');
INSERT INTO `sys_message` VALUES ('106', '是的不是的', '2', '-1', '全体会员', '2018-05-17 14:35:56');
INSERT INTO `sys_message` VALUES ('107', '是的不是的123', '2', '-1', '全体会员', '2018-05-17 14:39:17');
INSERT INTO `sys_message` VALUES ('108', 'sdfsdf', '2', '2', '全体会员', '2018-05-18 10:06:49');
INSERT INTO `sys_message` VALUES ('109', '是的不是的123', '2', '-1', '全体会员', '2018-05-18 10:07:01');
INSERT INTO `sys_message` VALUES ('112', '123', '2', '-1', '全体会员', '2018-05-20 18:51:53');
INSERT INTO `sys_message` VALUES ('113', '123', '2', '1', '全体会员', '2018-05-20 18:52:11');
INSERT INTO `sys_message` VALUES ('114', '123', '2', '-1', '全体会员', '2018-05-21 17:54:36');
INSERT INTO `sys_message` VALUES ('115', 'aa', '2', '-1', '全体会员', '2018-05-22 11:27:12');
INSERT INTO `sys_message` VALUES ('116', 'aa', '2', '-1', '全体会员', '2018-05-22 11:27:25');
INSERT INTO `sys_message` VALUES ('117', 'aa', '2', '-1', '全体会员', '2018-05-22 11:29:54');
INSERT INTO `sys_message` VALUES ('118', 'aa', '2', '-1', '全体会员', '2018-05-22 15:03:58');
INSERT INTO `sys_message` VALUES ('119', 'aa', '2', '-1', '全体会员', '2018-06-04 16:26:15');
INSERT INTO `sys_message` VALUES ('120', '李勇', '2', '-1', '全体会员', '2018-06-07 21:11:11');

-- ----------------------------
-- Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `name` varchar(20) NOT NULL,
  `type` int(11) NOT NULL DEFAULT '1' COMMENT '角色的类型，1：管理员角色，2：其他',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '状态，1：可用，0：冻结',
  `remark` varchar(200) DEFAULT '' COMMENT '备注',
  `operator` varchar(20) NOT NULL DEFAULT '' COMMENT '操作者',
  `operate_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次更新的时间',
  `operate_ip` varchar(20) NOT NULL DEFAULT '' COMMENT '最后一次更新者的ip地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('9', '总管理', '1', '1', '', 'Admin', '2018-06-08 17:02:47', '127.0.0.1');
INSERT INTO `sys_role` VALUES ('10', '服务商', '1', '1', '', 'Admin', '2018-06-12 17:07:00', '223.166.74.163');
INSERT INTO `sys_role` VALUES ('11', '机构', '1', '1', '', 'Admin', '2018-06-08 17:00:54', '127.0.0.1');
INSERT INTO `sys_role` VALUES ('12', '琴行', '1', '1', '', 'Admin', '2018-06-08 17:02:40', '127.0.0.1');
INSERT INTO `sys_role` VALUES ('13', '家长', '1', '0', '', 'Admin', '2018-06-21 14:46:35', '220.248.67.25');

-- ----------------------------
-- Table structure for `sys_role_acl`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_acl`;
CREATE TABLE `sys_role_acl` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL COMMENT '角色id',
  `acl_id` int(11) NOT NULL COMMENT '权限id',
  `operator` varchar(20) NOT NULL DEFAULT '' COMMENT '操作者',
  `operate_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次更新的时间',
  `operate_ip` varchar(200) NOT NULL DEFAULT '' COMMENT '最后一次更新者的ip',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=432 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sys_role_acl
-- ----------------------------
INSERT INTO `sys_role_acl` VALUES ('31', '5', '7', 'Admin', '2018-03-26 12:05:59', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('32', '5', '8', 'Admin', '2018-03-26 12:05:59', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('33', '5', '9', 'Admin', '2018-03-26 12:05:59', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('34', '5', '10', 'Admin', '2018-03-26 12:05:59', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('105', '6', '43', 'Admin', '2018-05-08 10:06:55', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('106', '6', '44', 'Admin', '2018-05-08 10:06:55', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('107', '6', '45', 'Admin', '2018-05-08 10:06:55', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('108', '6', '46', 'Admin', '2018-05-08 10:06:55', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('109', '3', '7', 'Admin', '2018-05-09 10:42:22', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('110', '3', '8', 'Admin', '2018-05-09 10:42:22', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('111', '3', '9', 'Admin', '2018-05-09 10:42:22', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('112', '3', '10', 'Admin', '2018-05-09 10:42:22', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('113', '3', '34', 'Admin', '2018-05-09 10:42:22', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('114', '3', '38', 'Admin', '2018-05-09 10:42:22', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('115', '3', '42', 'Admin', '2018-05-09 10:42:22', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('116', '3', '43', 'Admin', '2018-05-09 10:42:22', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('117', '3', '44', 'Admin', '2018-05-09 10:42:22', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('118', '3', '45', 'Admin', '2018-05-09 10:42:22', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('119', '3', '46', 'Admin', '2018-05-09 10:42:22', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('120', '4', '55', 'Admin', '2018-05-25 11:54:36', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('121', '4', '56', 'Admin', '2018-05-25 11:54:36', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('122', '4', '57', 'Admin', '2018-05-25 11:54:36', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('123', '4', '58', 'Admin', '2018-05-25 11:54:36', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('124', '4', '27', 'Admin', '2018-05-25 11:54:36', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('125', '4', '28', 'Admin', '2018-05-25 11:54:36', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('126', '4', '31', 'Admin', '2018-05-25 11:54:36', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('127', '4', '32', 'Admin', '2018-05-25 11:54:36', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('128', '4', '33', 'Admin', '2018-05-25 11:54:36', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('129', '4', '34', 'Admin', '2018-05-25 11:54:36', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('130', '4', '38', 'Admin', '2018-05-25 11:54:36', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('131', '4', '42', 'Admin', '2018-05-25 11:54:36', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('132', '4', '43', 'Admin', '2018-05-25 11:54:36', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('133', '4', '44', 'Admin', '2018-05-25 11:54:36', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('134', '4', '45', 'Admin', '2018-05-25 11:54:36', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('135', '4', '46', 'Admin', '2018-05-25 11:54:36', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('136', '4', '47', 'Admin', '2018-05-25 11:54:36', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('137', '4', '49', 'Admin', '2018-05-25 11:54:36', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('138', '4', '50', 'Admin', '2018-05-25 11:54:36', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('139', '4', '52', 'Admin', '2018-05-25 11:54:36', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('140', '4', '53', 'Admin', '2018-05-25 11:54:36', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('141', '4', '13', 'Admin', '2018-05-25 11:54:36', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('142', '8', '12', 'Admin', '2018-05-25 19:29:49', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('143', '8', '41', 'Admin', '2018-05-25 19:29:49', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('144', '8', '48', 'Admin', '2018-05-25 19:29:49', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('145', '8', '51', 'Admin', '2018-05-25 19:29:49', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('146', '8', '7', 'Admin', '2018-05-25 19:29:49', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('147', '8', '8', 'Admin', '2018-05-25 19:29:49', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('148', '8', '9', 'Admin', '2018-05-25 19:29:49', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('149', '8', '10', 'Admin', '2018-05-25 19:29:49', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('150', '8', '55', 'Admin', '2018-05-25 19:29:49', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('151', '8', '56', 'Admin', '2018-05-25 19:29:49', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('152', '8', '57', 'Admin', '2018-05-25 19:29:49', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('153', '8', '58', 'Admin', '2018-05-25 19:29:49', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('154', '8', '19', 'Admin', '2018-05-25 19:29:49', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('155', '8', '11', 'Admin', '2018-05-25 19:29:49', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('156', '8', '16', 'Admin', '2018-05-25 19:29:49', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('157', '8', '54', 'Admin', '2018-05-25 19:29:49', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('158', '8', '21', 'Admin', '2018-05-25 19:29:49', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('159', '8', '22', 'Admin', '2018-05-25 19:29:49', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('160', '8', '20', 'Admin', '2018-05-25 19:29:49', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('161', '8', '23', 'Admin', '2018-05-25 19:29:49', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('162', '8', '25', 'Admin', '2018-05-25 19:29:49', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('163', '8', '26', 'Admin', '2018-05-25 19:29:49', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('164', '8', '30', 'Admin', '2018-05-25 19:29:49', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('165', '8', '27', 'Admin', '2018-05-25 19:29:49', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('166', '8', '28', 'Admin', '2018-05-25 19:29:49', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('167', '8', '29', 'Admin', '2018-05-25 19:29:49', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('168', '8', '31', 'Admin', '2018-05-25 19:29:49', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('169', '8', '32', 'Admin', '2018-05-25 19:29:49', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('170', '8', '33', 'Admin', '2018-05-25 19:29:49', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('171', '8', '34', 'Admin', '2018-05-25 19:29:49', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('172', '8', '65', 'Admin', '2018-05-25 19:29:49', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('173', '8', '66', 'Admin', '2018-05-25 19:29:49', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('174', '8', '38', 'Admin', '2018-05-25 19:29:49', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('175', '8', '42', 'Admin', '2018-05-25 19:29:49', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('176', '8', '43', 'Admin', '2018-05-25 19:29:49', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('177', '8', '44', 'Admin', '2018-05-25 19:29:49', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('178', '8', '45', 'Admin', '2018-05-25 19:29:49', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('179', '8', '46', 'Admin', '2018-05-25 19:29:49', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('180', '8', '47', 'Admin', '2018-05-25 19:29:49', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('181', '8', '67', 'Admin', '2018-05-25 19:29:49', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('182', '8', '49', 'Admin', '2018-05-25 19:29:49', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('183', '8', '50', 'Admin', '2018-05-25 19:29:49', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('184', '8', '52', 'Admin', '2018-05-25 19:29:49', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('185', '8', '53', 'Admin', '2018-05-25 19:29:49', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('186', '8', '68', 'Admin', '2018-05-25 19:29:49', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('187', '8', '13', 'Admin', '2018-05-25 19:29:49', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('188', '8', '59', 'Admin', '2018-05-25 19:29:49', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('189', '8', '60', 'Admin', '2018-05-25 19:29:49', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('190', '8', '69', 'Admin', '2018-05-25 19:29:49', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('191', '8', '70', 'Admin', '2018-05-25 19:29:49', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('192', '8', '61', 'Admin', '2018-05-25 19:29:49', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('193', '8', '62', 'Admin', '2018-05-25 19:29:49', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('194', '8', '63', 'Admin', '2018-05-25 19:29:49', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('195', '8', '64', 'Admin', '2018-05-25 19:29:49', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('285', '10', '21', 'Admin', '2018-06-08 17:05:22', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('286', '10', '22', 'Admin', '2018-06-08 17:05:22', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('287', '10', '20', 'Admin', '2018-06-08 17:05:22', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('288', '10', '23', 'Admin', '2018-06-08 17:05:22', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('289', '10', '25', 'Admin', '2018-06-08 17:05:22', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('290', '10', '50', 'Admin', '2018-06-08 17:05:22', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('291', '10', '52', 'Admin', '2018-06-08 17:05:22', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('292', '10', '53', 'Admin', '2018-06-08 17:05:22', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('293', '10', '68', 'Admin', '2018-06-08 17:05:22', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('310', '12', '20', 'Admin', '2018-06-08 17:08:15', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('311', '12', '23', 'Admin', '2018-06-08 17:08:15', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('312', '12', '25', 'Admin', '2018-06-08 17:08:15', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('313', '12', '27', 'Admin', '2018-06-08 17:08:15', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('314', '12', '29', 'Admin', '2018-06-08 17:08:15', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('315', '12', '31', 'Admin', '2018-06-08 17:08:15', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('316', '12', '33', 'Admin', '2018-06-08 17:08:15', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('317', '12', '34', 'Admin', '2018-06-08 17:08:15', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('318', '12', '50', 'Admin', '2018-06-08 17:08:15', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('319', '12', '52', 'Admin', '2018-06-08 17:08:15', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('320', '12', '53', 'Admin', '2018-06-08 17:08:15', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('321', '12', '68', 'Admin', '2018-06-08 17:08:15', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('340', '9', '12', 'Admin', '2018-06-13 20:45:54', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('341', '9', '41', 'Admin', '2018-06-13 20:45:54', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('342', '9', '48', 'Admin', '2018-06-13 20:45:54', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('343', '9', '51', 'Admin', '2018-06-13 20:45:54', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('344', '9', '74', 'Admin', '2018-06-13 20:45:54', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('345', '9', '7', 'Admin', '2018-06-13 20:45:54', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('346', '9', '8', 'Admin', '2018-06-13 20:45:54', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('347', '9', '9', 'Admin', '2018-06-13 20:45:54', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('348', '9', '10', 'Admin', '2018-06-13 20:45:54', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('349', '9', '19', 'Admin', '2018-06-13 20:45:54', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('350', '9', '16', 'Admin', '2018-06-13 20:45:54', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('351', '9', '54', 'Admin', '2018-06-13 20:45:54', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('352', '9', '21', 'Admin', '2018-06-13 20:45:54', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('353', '9', '22', 'Admin', '2018-06-13 20:45:54', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('354', '9', '20', 'Admin', '2018-06-13 20:45:54', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('355', '9', '23', 'Admin', '2018-06-13 20:45:54', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('356', '9', '25', 'Admin', '2018-06-13 20:45:54', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('357', '9', '26', 'Admin', '2018-06-13 20:45:54', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('358', '9', '75', 'Admin', '2018-06-13 20:45:54', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('359', '9', '76', 'Admin', '2018-06-13 20:45:54', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('360', '9', '30', 'Admin', '2018-06-13 20:45:54', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('361', '9', '27', 'Admin', '2018-06-13 20:45:54', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('362', '9', '28', 'Admin', '2018-06-13 20:45:54', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('363', '9', '73', 'Admin', '2018-06-13 20:45:54', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('364', '9', '29', 'Admin', '2018-06-13 20:45:54', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('365', '9', '31', 'Admin', '2018-06-13 20:45:54', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('366', '9', '32', 'Admin', '2018-06-13 20:45:54', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('367', '9', '33', 'Admin', '2018-06-13 20:45:54', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('368', '9', '13', 'Admin', '2018-06-13 20:45:54', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('369', '9', '34', 'Admin', '2018-06-13 20:45:54', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('370', '9', '65', 'Admin', '2018-06-13 20:45:54', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('371', '9', '66', 'Admin', '2018-06-13 20:45:54', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('372', '9', '38', 'Admin', '2018-06-13 20:45:54', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('373', '9', '42', 'Admin', '2018-06-13 20:45:54', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('374', '9', '43', 'Admin', '2018-06-13 20:45:54', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('375', '9', '44', 'Admin', '2018-06-13 20:45:54', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('376', '9', '45', 'Admin', '2018-06-13 20:45:54', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('377', '9', '46', 'Admin', '2018-06-13 20:45:54', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('378', '9', '47', 'Admin', '2018-06-13 20:45:54', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('379', '9', '67', 'Admin', '2018-06-13 20:45:54', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('380', '9', '49', 'Admin', '2018-06-13 20:45:54', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('381', '9', '50', 'Admin', '2018-06-13 20:45:54', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('382', '9', '52', 'Admin', '2018-06-13 20:45:54', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('383', '9', '53', 'Admin', '2018-06-13 20:45:54', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('384', '9', '68', 'Admin', '2018-06-13 20:45:54', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('385', '9', '55', 'Admin', '2018-06-13 20:45:54', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('386', '9', '56', 'Admin', '2018-06-13 20:45:54', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('387', '9', '57', 'Admin', '2018-06-13 20:45:54', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('388', '9', '59', 'Admin', '2018-06-13 20:45:54', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('389', '9', '60', 'Admin', '2018-06-13 20:45:54', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('390', '9', '72', 'Admin', '2018-06-13 20:45:54', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('391', '9', '69', 'Admin', '2018-06-13 20:45:54', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('392', '9', '70', 'Admin', '2018-06-13 20:45:54', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('393', '9', '61', 'Admin', '2018-06-13 20:45:54', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('394', '9', '62', 'Admin', '2018-06-13 20:45:54', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('395', '9', '63', 'Admin', '2018-06-13 20:45:54', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('396', '9', '64', 'Admin', '2018-06-13 20:45:54', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('414', '11', '22', 'Admin', '2018-06-13 20:46:15', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('415', '11', '20', 'Admin', '2018-06-13 20:46:15', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('416', '11', '23', 'Admin', '2018-06-13 20:46:15', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('417', '11', '25', 'Admin', '2018-06-13 20:46:15', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('418', '11', '27', 'Admin', '2018-06-13 20:46:15', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('419', '11', '29', 'Admin', '2018-06-13 20:46:15', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('420', '11', '31', 'Admin', '2018-06-13 20:46:15', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('421', '11', '33', 'Admin', '2018-06-13 20:46:15', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('422', '11', '43', 'Admin', '2018-06-13 20:46:15', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('423', '11', '44', 'Admin', '2018-06-13 20:46:15', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('424', '11', '45', 'Admin', '2018-06-13 20:46:15', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('425', '11', '46', 'Admin', '2018-06-13 20:46:15', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('426', '11', '50', 'Admin', '2018-06-13 20:46:15', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('427', '11', '52', 'Admin', '2018-06-13 20:46:15', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('428', '11', '53', 'Admin', '2018-06-13 20:46:15', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('429', '11', '68', 'Admin', '2018-06-13 20:46:15', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('430', '11', '82', 'Admin', '2018-06-13 20:46:15', '127.0.0.1');
INSERT INTO `sys_role_acl` VALUES ('431', '11', '77', 'Admin', '2018-06-13 20:46:15', '127.0.0.1');

-- ----------------------------
-- Table structure for `sys_role_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_user`;
CREATE TABLE `sys_role_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL COMMENT '角色id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `operator` varchar(20) NOT NULL DEFAULT '' COMMENT '操作者',
  `operate_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次更新的时间',
  `operate_ip` varchar(20) NOT NULL DEFAULT '' COMMENT '最后一次更新者的ip地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sys_role_user
-- ----------------------------
INSERT INTO `sys_role_user` VALUES ('31', '4', '1', 'Admin', '2018-05-25 11:54:58', '127.0.0.1');
INSERT INTO `sys_role_user` VALUES ('32', '4', '11', 'Admin', '2018-05-25 11:54:58', '127.0.0.1');
INSERT INTO `sys_role_user` VALUES ('33', '8', '15', 'Admin', '2018-05-25 19:29:56', '127.0.0.1');
INSERT INTO `sys_role_user` VALUES ('34', '3', '6', 'Admin', '2018-06-07 16:54:31', '127.0.0.1');
INSERT INTO `sys_role_user` VALUES ('35', '3', '10', 'Admin', '2018-06-07 16:54:31', '127.0.0.1');
INSERT INTO `sys_role_user` VALUES ('36', '3', '18', 'Admin', '2018-06-07 16:54:31', '127.0.0.1');
INSERT INTO `sys_role_user` VALUES ('38', '9', '2', 'Admin4', '2018-06-08 16:58:14', '127.0.0.1');
INSERT INTO `sys_role_user` VALUES ('39', '9', '24', 'Admin4', '2018-06-08 16:58:14', '127.0.0.1');
INSERT INTO `sys_role_user` VALUES ('40', '10', '39', 'Admin', '2018-06-12 17:08:45', '223.166.74.163');
INSERT INTO `sys_role_user` VALUES ('41', '11', '39', 'Admin', '2018-06-12 17:09:30', '223.166.74.163');

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(20) NOT NULL DEFAULT '' COMMENT '用户名称',
  `telephone` varchar(13) NOT NULL DEFAULT '' COMMENT '手机号',
  `mail` varchar(20) NOT NULL DEFAULT '' COMMENT '邮箱',
  `password` varchar(40) NOT NULL DEFAULT '' COMMENT '加密后的密码',
  `dept_id` int(11) NOT NULL DEFAULT '0' COMMENT '用户所在部门的id',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '状态，1：正常，0：冻结状态，2：删除',
  `remark` varchar(200) DEFAULT '' COMMENT '备注',
  `operator` varchar(20) NOT NULL DEFAULT '' COMMENT '操作者',
  `operate_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次更新时间',
  `operate_ip` varchar(20) NOT NULL DEFAULT '' COMMENT '最后一次更新者的ip地址',
  `xinxi_type` int(11) DEFAULT NULL COMMENT '信息表类别0总管理1服务商，2机构，3琴行，4老师',
  `xinxi_id` int(11) DEFAULT NULL COMMENT '信息表id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'Admin', '18612344321', 'admin@qq.com', '25D55AD283AA400AF464C76D713C07AD', '1', '1', 'admin', 'system', '2017-10-13 08:46:16', '127.0.0.1', '0', '1');
INSERT INTO `sys_user` VALUES ('2', 'Admin4', '13188889999', 'admin4@qq.com', '25D55AD283AA400AF464C76D713C07AD', '1', '1', 'jimin.zheng', 'Admin', '2017-10-14 14:45:19', '127.0.0.1', '4', '1');
INSERT INTO `sys_user` VALUES ('4', 'Admin3', '13144445555', 'admin3@qq.com', '25D55AD283AA400AF464C76D713C07AD', '1', '1', 'sss', 'Admin', '2017-10-16 23:02:51', '0:0:0:0:0:0:0:1', '3', '1');
INSERT INTO `sys_user` VALUES ('5', 'Admin2', '18677778888', 'admin2@qq.com', '25D55AD283AA400AF464C76D713C07AD', '1', '1', '', 'Admin', '2017-10-17 00:22:15', '0:0:0:0:0:0:0:1', '2', '1');
INSERT INTO `sys_user` VALUES ('6', 'Admin1', '18326917091', 'admin1@qq.com', '25D55AD283AA400AF464C76D713C07AD', '1', '1', 'cehi', 'Admin', '2018-03-24 23:10:03', '127.0.0.1', '1', '1');
INSERT INTO `sys_user` VALUES ('7', '测试管理员', '18018581072', 'ceshi@qq.com', 'BA00662F5B53D8A3FDC3A4156226805C', '13', '1', 'ceshi987654321', 'Admin', '2018-03-25 21:39:25', '127.0.0.1', null, null);
INSERT INTO `sys_user` VALUES ('10', 'eleDrumEditer', '12345678', '123456@qq.com', '44BF025D27EEA66336E5C1133C3827F7', '1', '1', '电鼓编辑器角色  123456password', 'Admin', '2018-05-09 10:29:38', '127.0.0.1', null, null);
INSERT INTO `sys_user` VALUES ('11', '总管理', '6666666666', '66666666@qq.com', '257A734DE75D8302DE97FCBEF0AD68A6', '1', '1', '密码6666663333', 'Admin', '2018-05-25 11:53:36', '127.0.0.1', null, null);
INSERT INTO `sys_user` VALUES ('12', 'aaaa', '15194491660', '1234567890@qq.com', 'E807F1FCF82D132F9BB018CA6738A19F', '1', '1', 'ssss', 'Admin', '2018-05-25 15:38:49', '127.0.0.1', '1', '2');
INSERT INTO `sys_user` VALUES ('13', 'erew', '15194491661', '654321@qq.com', '6FB42DA0E32E07B61C9F0251FE627A9C', '1', '1', 'fssf', 'Admin', '2018-05-25 15:46:42', '127.0.0.1', null, null);
INSERT INTO `sys_user` VALUES ('14', 'aaaa', '15194491662', '23454543@qq.com', 'A7332E210AC7D565C220DCCD89702DCF', '1', '1', 'dsfsdfdsfs', 'Admin', '2018-05-25 15:59:48', '127.0.0.1', '2', '2');
INSERT INTO `sys_user` VALUES ('15', 'lingbin', '1519449166', 'lingbin@qq.com', 'E807F1FCF82D132F9BB018CA6738A19F', '1', '1', '2342', 'Admin', '2018-05-25 19:24:57', '127.0.0.1', '3', '1');
INSERT INTO `sys_user` VALUES ('16', '111', '222', '', '', '0', '1', '', '', '2018-06-07 16:30:14', '', '1', '2');
INSERT INTO `sys_user` VALUES ('17', 'xxx', '87654321', '', '', '0', '1', '', '', '2018-06-07 16:44:46', '', '1', '3');
INSERT INTO `sys_user` VALUES ('18', '222222', '11111111', '', '1BBD886460827015E5D605ED44252251', '0', '1', '', '', '2018-06-07 16:49:49', '', '1', '4');
INSERT INTO `sys_user` VALUES ('19', '44444', '22222222', '', 'BAE5E3208A3C700E3DB642B6631E95B9', '0', '1', '', '', '2018-06-07 17:14:53', '', '2', '6');
INSERT INTO `sys_user` VALUES ('20', 'wer', '34dg', '', 'A8021061AB6279CED648C7F5318F6B5A', '0', '1', '', '', '2018-06-07 18:40:47', '', '1', '5');
INSERT INTO `sys_user` VALUES ('21', '242', '324234', '', 'CD6A1A15421189DE23D7309FEEBFF8D7', '0', '1', '', '', '2018-06-07 18:47:44', '', '1', '6');
INSERT INTO `sys_user` VALUES ('22', '234', '3242', '', '032DD17B77FAB7D51A476C5FF2B5659C', '0', '1', '', '', '2018-06-07 18:48:44', '', '1', '7');
INSERT INTO `sys_user` VALUES ('23', '1', '15221351482', '', 'c4ca4238a0b923820dcc509a6f75849b', '1', '1', '', 'admin', '2018-06-07 19:57:52', '127.0.0.1', '3', '8');
INSERT INTO `sys_user` VALUES ('24', 'aaa', '333333', '', '25D55AD283AA400AF464C76D713C07AD', '0', '1', '', '', '2018-06-08 16:57:46', '', '2', '7');
INSERT INTO `sys_user` VALUES ('25', 'ert', '151944991660', '', '42F4C591AA906B3332C60590BB3937A8', '0', '1', '', '', '2018-06-08 19:52:17', '', '2', '8');
INSERT INTO `sys_user` VALUES ('26', '34534', '15194491660', '', '5C8A8738D837C0F6C72C913075C01204', '0', '1', '', '', '2018-06-08 20:21:53', '', '1', '8');
INSERT INTO `sys_user` VALUES ('27', 'sdfdfs', '15194491660', '', '5C8A8738D837C0F6C72C913075C01204', '0', '1', '', '', '2018-06-08 21:07:17', '', '1', '9');
INSERT INTO `sys_user` VALUES ('28', 'ret', '15194491660', '', '5C8A8738D837C0F6C72C913075C01204', '0', '1', '', '', '2018-06-11 10:04:15', '', '1', '10');
INSERT INTO `sys_user` VALUES ('29', 'ert', '15194491660', '', '5C8A8738D837C0F6C72C913075C01204', '0', '1', '', '', '2018-06-11 10:07:35', '', '1', '11');
INSERT INTO `sys_user` VALUES ('30', 'sdf', '15194491660', '', '5C8A8738D837C0F6C72C913075C01204', '0', '1', '', '', '2018-06-11 10:41:40', '', '1', '12');
INSERT INTO `sys_user` VALUES ('31', '111', '15194491660', '', '5C8A8738D837C0F6C72C913075C01204', '0', '1', '', '', '2018-06-11 10:44:48', '', '1', '13');
INSERT INTO `sys_user` VALUES ('32', 'sss', '15194491660', '', '5C8A8738D837C0F6C72C913075C01204', '0', '1', '', '', '2018-06-11 10:45:36', '', '1', '14');
INSERT INTO `sys_user` VALUES ('33', 'aa', '15194491660', '', '5C8A8738D837C0F6C72C913075C01204', '0', '1', '', '', '2018-06-11 10:47:09', '', '1', '15');
INSERT INTO `sys_user` VALUES ('34', 'sfdsfs', '15194491660', '', '5C8A8738D837C0F6C72C913075C01204', '0', '1', '', '', '2018-06-11 10:52:57', '', '2', '9');
INSERT INTO `sys_user` VALUES ('35', 'ewr', '15194491660', '', '5C8A8738D837C0F6C72C913075C01204', '0', '1', '', '', '2018-06-11 10:54:15', '', '1', '16');
INSERT INTO `sys_user` VALUES ('36', 'aa', '15194491660', '', '5C8A8738D837C0F6C72C913075C01204', '0', '1', '', '', '2018-06-11 10:56:59', '', '2', '10');
INSERT INTO `sys_user` VALUES ('37', 'dfg', '15194491660', '', '5C8A8738D837C0F6C72C913075C01204', '0', '1', '', '', '2018-06-11 10:58:59', '', '2', '11');
INSERT INTO `sys_user` VALUES ('38', 'dfg', '17608478864', '', '10BB0ABD2DF2FF9BC567B9A0F7B5AE09', '0', '1', '', '', '2018-06-12 09:40:31', '', '2', '12');
INSERT INTO `sys_user` VALUES ('39', '俞钦华', '15821941486', '', 'CD2E050D063206D5AE4F4503EA5E3094', '0', '1', '', '', '2018-06-12 10:47:46', '', '1', '17');
INSERT INTO `sys_user` VALUES ('41', '的身份', '17621829059', '', 'B916EEAAAD0257A221AC84385FD144D2', '0', '1', '', '', '2018-06-12 11:42:05', '', '2', '14');
INSERT INTO `sys_user` VALUES ('42', '啦啦啦', '15194491660', '', '5C8A8738D837C0F6C72C913075C01204', '0', '1', '', '', '2018-06-13 14:26:58', '', '1', '18');
INSERT INTO `sys_user` VALUES ('43', '啊', '15194491660', '', '5C8A8738D837C0F6C72C913075C01204', '0', '1', '', '', '2018-06-13 14:31:27', '', '1', '19');
INSERT INTO `sys_user` VALUES ('44', '1', '15221351482', '', '202cb962ac59075b964b07152d234b70', '1', '1', '', 'admin', '2018-06-14 16:54:18', '127.0.0.1', '3', null);
INSERT INTO `sys_user` VALUES ('45', '李勇', '15221351482', '', '202cb962ac59075b964b07152d234b70', '1', '1', '', 'admin', '2018-06-14 20:38:02', '127.0.0.1', '3', null);
INSERT INTO `sys_user` VALUES ('46', '2222', '151944916601', '', '', '0', '1', '', '', '2018-06-15 17:53:47', '', '3', null);
INSERT INTO `sys_user` VALUES ('47', '2222', '151944916601', '', '202CB962AC59075B964B07152D234B70', '0', '1', '', '', '2018-06-15 17:57:47', '', '3', '10');
INSERT INTO `sys_user` VALUES ('48', '大风琴行', '15821941486', '', '202cb962ac59075b964b07152d234b70', '1', '1', '', 'admin', '2018-06-19 15:31:09', '127.0.0.1', '3', null);
INSERT INTO `sys_user` VALUES ('49', '民生琴行', '15821941486', '', '202cb962ac59075b964b07152d234b70', '1', '1', '', 'admin', '2018-06-19 17:51:01', '127.0.0.1', '3', null);
INSERT INTO `sys_user` VALUES ('50', '哈哈哈', '15821941486', '', '202cb962ac59075b964b07152d234b70', '1', '1', '', 'admin', '2018-06-20 09:46:05', '127.0.0.1', '3', null);
INSERT INTO `sys_user` VALUES ('51', '海门琴行', '15821941486', '', '202cb962ac59075b964b07152d234b70', '1', '1', '', 'admin', '2018-06-20 11:23:10', '127.0.0.1', '3', null);
INSERT INTO `sys_user` VALUES ('52', '俞钦华', '15821941486', '', 'CD2E050D063206D5AE4F4503EA5E3094', '0', '1', '', '', '2018-06-20 11:26:18', '', '1', '20');

-- ----------------------------
-- Table structure for `teacher`
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '老师信息表',
  `teacher_id` int(11) DEFAULT NULL COMMENT '老师id',
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '老师姓名',
  `work_type` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '就职类型(兼职,全职)',
  `belongto_piano_shop` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '所属琴行',
  `belongto_piano_shopID` int(11) DEFAULT NULL COMMENT '老师所属琴行id',
  `telephone` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '手机号',
  `member_level` int(11) DEFAULT NULL COMMENT '会员等级',
  `state` int(11) DEFAULT NULL COMMENT '状态(0--正常  1--锁定)',
  `score` decimal(11,2) DEFAULT NULL COMMENT '积分',
  `income` decimal(11,2) DEFAULT NULL COMMENT '收入',
  `area` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '区域',
  `address` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '详细地址',
  `remind` int(11) DEFAULT NULL COMMENT '提醒(1--开启  0--关闭)',
  `recharge` decimal(11,2) DEFAULT NULL COMMENT '充值',
  `is_default_teacher` int(11) DEFAULT NULL COMMENT '是否为琴行默认老师(1--是  0--不是)',
  `game_score` decimal(11,2) DEFAULT NULL COMMENT '游戏积分',
  `IDcard_picture` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '身份证图片',
  `balance` decimal(11,2) DEFAULT NULL COMMENT '充值余额',
  `withdraw_balance` decimal(11,2) DEFAULT NULL COMMENT '可提现余额',
  `divide_money_rate` decimal(11,2) DEFAULT NULL COMMENT '分成比例',
  `divide_money_income` decimal(11,2) DEFAULT NULL COMMENT '分红收入',
  `register_time` datetime DEFAULT NULL COMMENT '注册时间',
  `member_time` datetime DEFAULT NULL COMMENT '会员时间',
  `examine_time` datetime DEFAULT NULL COMMENT '审核时间',
  `auditor` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '审核人',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `work_place` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '工作单位',
  `head_url` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '老师头像',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1', '1', '老师111', '兼职', '钢琴室2', '1', '12354524', '12', '1', '12.00', '3544.00', 'vbfb', 'ddgffgaf', '1', '1.00', '1', '232.00', 'dadfdsffsfd', '232.00', null, '0.50', '3234.00', '2018-04-01 14:31:10', '2018-04-04 14:31:15', '2018-04-05 14:31:19', 'dfdfdf', '2018-04-18 14:31:29', 'dfad', 'dfadff');
INSERT INTO `teacher` VALUES ('2', null, '', 'wew', '钢琴室', '2', 'wew', null, '0', null, null, 'we', 'we', null, null, null, null, 'we', null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `teacher` VALUES ('3', '3', '老师111', '兼职', '钢琴室2', '1', '12354524', '12', '1', '12.00', '3544.00', 'vbfb', 'ddgffgaf', '1', '1.00', '1', '232.00', 'dadfdsffsfd', '232.00', null, '0.50', '3234.00', '2018-04-01 14:31:10', '2018-04-04 14:31:15', '2018-04-05 14:31:19', 'dfdfdf', '2018-04-18 14:31:29', 'dfad', 'dfadff');
INSERT INTO `teacher` VALUES ('6', null, '11', '66', null, '1', '22', null, null, null, null, '88', '99', null, null, null, null, null, null, null, null, null, null, null, null, null, null, '77', null);
INSERT INTO `teacher` VALUES ('7', '7', '王老师', '全职', '琴行2', '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 'http://h5.9shadow.com/F//pengHuaImg/8e92665659d340eab9213bb94393e890.png');
INSERT INTO `teacher` VALUES ('8', null, '22', '23', null, '1', '23', null, null, null, null, '213', '23', null, null, null, null, null, null, null, null, null, null, null, null, null, null, '123', null);
INSERT INTO `teacher` VALUES ('9', null, '12', '12', null, '1', '12', null, null, null, null, '12', '12', null, null, null, null, null, null, null, null, null, null, null, null, null, null, '12', null);
INSERT INTO `teacher` VALUES ('10', null, '66', '66', null, '1', '66', null, null, null, null, '66', '66', null, null, null, null, null, null, null, null, null, null, null, null, null, null, '66', null);
INSERT INTO `teacher` VALUES ('11', null, '21', '112', null, '1', '12', null, null, null, null, '12', '12', null, null, null, null, null, null, null, null, null, null, null, null, null, null, '12', null);
INSERT INTO `teacher` VALUES ('12', null, '1', null, '1', '8', '15221351482', null, '0', null, null, '1', '1', '1', null, '0', null, null, null, null, null, null, '2018-06-07 19:57:58', null, null, null, null, null, null);
INSERT INTO `teacher` VALUES ('13', null, '士大夫但是', '士大夫', null, '5', '1519449166', null, null, null, null, '士大夫', '士大夫', null, null, null, null, null, null, null, null, null, null, null, null, null, null, '的说法', null);
INSERT INTO `teacher` VALUES ('14', null, 'sdf', 'sdf', null, '3', 'dsfss', null, '0', null, null, 'sdf', 'sdf', null, null, null, null, null, null, null, null, null, null, null, null, null, null, 'sdf', null);
INSERT INTO `teacher` VALUES ('15', null, '李海生', '啊啊', null, '8', '17908478864', null, null, null, null, '23', '233321', null, null, null, null, null, null, null, null, null, null, null, null, null, null, 'jishu', null);
INSERT INTO `teacher` VALUES ('16', null, '李老师', '教师', null, '5', '15194491661', null, null, null, null, '上海', '232', null, null, null, null, null, null, null, null, null, null, null, null, null, null, '教师部', null);
INSERT INTO `teacher` VALUES ('17', null, '22', '2', null, '1', '22', null, null, null, null, '2', '2', null, null, null, null, null, null, null, null, null, null, null, null, null, null, '22', null);
INSERT INTO `teacher` VALUES ('18', null, 'sf', 'dsf', null, '1', '15194491662', null, null, null, null, '10|150|1282', 'sfs', null, null, null, null, null, null, null, null, null, null, null, null, null, null, 's', null);
INSERT INTO `teacher` VALUES ('20', null, '一套统一', null, '李勇', '10', '15821941486', null, '0', null, null, '黑龙江 大兴安岭 漠河县', '成功过', '1', null, '0', null, null, null, null, null, null, '2018-06-14 20:38:03', null, null, null, null, null, null);
INSERT INTO `teacher` VALUES ('21', null, '俞钦华', null, '大风琴行', null, '15821941486', null, '0', null, null, '宁夏 固原 西吉县', '渔樵', '1', null, '0', null, null, null, null, null, null, '2018-06-19 15:31:09', null, null, null, null, null, null);
INSERT INTO `teacher` VALUES ('22', null, '俞钦华', null, '民生琴行', null, '15821941486', null, '0', null, null, '黑龙江 大庆 红岗区', '非官方', '1', null, '0', null, null, null, null, null, null, '2018-06-19 17:51:01', null, null, null, null, null, null);
INSERT INTO `teacher` VALUES ('23', null, '看就看', null, '哈哈哈', null, '15221351482', null, '0', null, null, '黑龙江 大庆 红岗区', '第三方', '1', null, '0', null, null, null, null, null, null, '2018-06-20 09:46:05', null, null, null, null, null, null);
INSERT INTO `teacher` VALUES ('24', null, '与i牵牛花', null, '海门琴行', null, '15221351482', null, '1', null, null, '河南 信阳 固始县', '湖南 张家界 武陵源', '1', null, '0', null, '', null, null, null, null, '2018-06-20 11:23:10', null, null, null, null, null, null);
INSERT INTO `teacher` VALUES ('25', null, '俞钦华', '兼职', null, '1', '17680251245', null, null, null, null, '15|223|1887', '打地鼠', null, null, null, null, null, null, null, null, null, null, null, null, null, null, '上海', null);

-- ----------------------------
-- Table structure for `user_score`
-- ----------------------------
DROP TABLE IF EXISTS `user_score`;
CREATE TABLE `user_score` (
  `ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '用户积分记录表  (只是记录积分，积分在play表中)',
  `player_id` int(11) DEFAULT NULL COMMENT '用户id',
  `nickname` varchar(255) DEFAULT NULL COMMENT '用户昵称',
  `gradeNum` varchar(20) DEFAULT NULL COMMENT '现拥有的积分数量-与天数无关',
  `info` int(20) DEFAULT NULL COMMENT '积分来源 1-每日登陆、2-通关(4个类别)、3-练习、4-分享,5购买曲谱',
  `num` varchar(20) DEFAULT NULL COMMENT '新获多少积分',
  `time` datetime DEFAULT NULL COMMENT '获得积分的时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=701 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_score
-- ----------------------------
INSERT INTO `user_score` VALUES ('675', '458', '1', '1', '1', '5', '2018-06-21 10:06:55');
INSERT INTO `user_score` VALUES ('676', '458', '2', '2', '2', '5', '2018-05-21 09:24:11');
INSERT INTO `user_score` VALUES ('677', '458', '3', '3', '3', '3', '2018-05-21 09:24:19');
INSERT INTO `user_score` VALUES ('678', '459', 'fan', null, '1', '3', '2018-06-20 17:21:36');
INSERT INTO `user_score` VALUES ('679', '480', '人生#如梦℃', null, '1', '3', '2018-06-08 18:04:01');
INSERT INTO `user_score` VALUES ('680', '454', 'ly', null, '1', '3', '2018-06-21 11:17:18');
INSERT INTO `user_score` VALUES ('681', '462', 'yggdra', null, '1', '3', '2018-06-21 10:00:04');
INSERT INTO `user_score` VALUES ('682', '476', 'yu', null, '1', '3', '2018-06-11 12:14:30');
INSERT INTO `user_score` VALUES ('683', '482', '俞钦华', null, '1', '3', '2018-06-11 16:34:20');
INSERT INTO `user_score` VALUES ('684', '485', '林永', null, '1', '3', '2018-06-11 21:32:23');
INSERT INTO `user_score` VALUES ('685', '487', 'yuqinhua', null, '1', '3', '2018-06-13 11:08:55');
INSERT INTO `user_score` VALUES ('686', '488', 'fansen', null, '1', '3', '2018-06-12 10:49:34');
INSERT INTO `user_score` VALUES ('687', '481', 'test', null, '1', '3', '2018-06-16 08:32:43');
INSERT INTO `user_score` VALUES ('688', '491', 'fansen', null, '1', '3', '2018-06-13 11:08:30');
INSERT INTO `user_score` VALUES ('689', '492', 'Heisenberg', null, '1', '3', '2018-06-13 12:01:29');
INSERT INTO `user_score` VALUES ('690', '495', '我特务', null, '1', '3', '2018-06-14 10:26:43');
INSERT INTO `user_score` VALUES ('691', '494', 'fbhg', null, '1', '3', '2018-06-21 10:41:27');
INSERT INTO `user_score` VALUES ('692', '496', '多岁的', null, '1', '3', '2018-06-14 11:04:42');
INSERT INTO `user_score` VALUES ('693', '497', '林永', null, '1', '3', '2018-06-14 11:11:50');
INSERT INTO `user_score` VALUES ('694', '499', '的身份和', null, '1', '3', '2018-06-14 19:14:00');
INSERT INTO `user_score` VALUES ('695', '501', '快刀小子', null, '1', '3', '2018-06-15 10:51:53');
INSERT INTO `user_score` VALUES ('696', '502', '嗯嗯', null, '1', '3', '2018-06-19 10:20:19');
INSERT INTO `user_score` VALUES ('697', '504', '烦烦烦', null, '1', '3', '2018-06-19 11:59:17');
INSERT INTO `user_score` VALUES ('698', '508', '对方的', null, '1', '3', '2018-06-20 10:25:46');
INSERT INTO `user_score` VALUES ('699', '511', '打发打发', null, '1', '3', '2018-06-20 16:11:35');
INSERT INTO `user_score` VALUES ('700', '463', 'aaa', null, '1', '3', '2018-06-21 16:19:42');

-- ----------------------------
-- Table structure for `version`
-- ----------------------------
DROP TABLE IF EXISTS `version`;
CREATE TABLE `version` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'app版本号',
  `version_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '版本名称',
  `version_url` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `operator_time` datetime DEFAULT NULL COMMENT '操作时间',
  `version_type` int(11) DEFAULT NULL COMMENT '所属平台(0--安卓  1--IOS 2--PC)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of version
-- ----------------------------
INSERT INTO `version` VALUES ('1', '1.0', 'www.baidu.com', '2018-06-14 10:32:06', '0');
INSERT INTO `version` VALUES ('2', '1.0', 'www.baidu.com', '2018-06-08 10:32:35', '1');
INSERT INTO `version` VALUES ('3', '1.0', 'www.baidu.com', '2018-06-14 10:53:59', '2');

-- ----------------------------
-- Table structure for `waiting_member`
-- ----------------------------
DROP TABLE IF EXISTS `waiting_member`;
CREATE TABLE `waiting_member` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '待审核会员',
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '待审核会员名称',
  `contacts` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '联系人',
  `telephone` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '手机号',
  `boos_telephone` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '法人电话',
  `area` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '区域',
  `address` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '详细地址',
  `IDcard_picture` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '身份证图片',
  `business_license_picture` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '营业执照',
  `is_pass` int(11) DEFAULT NULL COMMENT '是否通过(1--通过   0--未通过)',
  `boss_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '法人姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of waiting_member
-- ----------------------------
INSERT INTO `waiting_member` VALUES ('1', '待审核会员1', '联系人one', '176666324342', '176666634234', '上海浦东新区', '御桥路88号', 'http://h5.9shadow.com/F//pengHuaImg/66256a5f53bc4b028b98347f5dc38bab.png', 'http://h5.9shadow.com/F//pengHuaImg/c94b4d5ee6754b13b20964e15e01dc57.png', '0', 'bossli');

-- ----------------------------
-- Table structure for `witdraw_detail`
-- ----------------------------
DROP TABLE IF EXISTS `witdraw_detail`;
CREATE TABLE `witdraw_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '提现申请表',
  `number` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '单号',
  `user_id` int(11) DEFAULT NULL COMMENT '4个表对应的用户id',
  `role` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '角色0总管理，1服务商，2机构，3琴行，4老师',
  `role_type` int(11) DEFAULT NULL COMMENT '前后台类别表，1为前台，2为后台',
  `username` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '用户名',
  `withdraw_object` decimal(10,0) DEFAULT NULL COMMENT '提现熊掌',
  `account_money` decimal(10,2) DEFAULT NULL COMMENT '到账的金额',
  `withdraw_time` datetime DEFAULT NULL COMMENT '提现时间',
  `bank_account` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '银行卡账号',
  `stage` int(11) DEFAULT NULL COMMENT '状态阶段 0-审核中 1-已结算',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=145 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of witdraw_detail
-- ----------------------------
INSERT INTO `witdraw_detail` VALUES ('100', '12', '1', '1', '2', null, '12', '12.00', '2018-05-25 14:07:41', '123154561', '1');
INSERT INTO `witdraw_detail` VALUES ('101', '113', '1', '1', '2', null, '11', '1.00', '2018-05-25 11:30:33', '121314141', '1');
INSERT INTO `witdraw_detail` VALUES ('102', '1234', '1', '1', '2', null, '10', '1.00', '2018-05-27 11:30:37', '12151', '1');
INSERT INTO `witdraw_detail` VALUES ('103', null, '1', '1', '2', null, '12', '1.00', '2018-05-15 11:30:43', '121314', '1');
INSERT INTO `witdraw_detail` VALUES ('104', null, '1', '1', '2', null, '12', '1.00', '2018-05-28 11:30:49', '1314141', '1');
INSERT INTO `witdraw_detail` VALUES ('105', null, '1', '1', '2', null, '12', '1.00', '2018-06-27 11:30:46', null, '1');
INSERT INTO `witdraw_detail` VALUES ('106', null, '1', '2', '2', null, null, '0.00', '2018-05-26 11:30:54', null, '1');
INSERT INTO `witdraw_detail` VALUES ('107', null, '1', '2', '2', null, null, null, '2018-05-18 11:30:51', null, '1');
INSERT INTO `witdraw_detail` VALUES ('108', null, '1', '2', '2', null, null, null, '2018-05-19 11:30:57', null, '1');
INSERT INTO `witdraw_detail` VALUES ('109', null, '1', '2', '2', null, null, null, '2018-05-29 11:31:00', null, '0');
INSERT INTO `witdraw_detail` VALUES ('110', null, '1', '2', '2', null, null, null, '2018-05-31 11:31:02', null, '1');
INSERT INTO `witdraw_detail` VALUES ('111', null, '1', '2', '2', null, null, null, '2018-04-25 11:31:05', null, '0');
INSERT INTO `witdraw_detail` VALUES ('112', null, '1', '2', '2', null, null, null, '2018-05-08 11:31:08', null, '1');
INSERT INTO `witdraw_detail` VALUES ('113', null, '1', '2', '2', null, null, null, '2018-05-02 11:31:11', null, '0');
INSERT INTO `witdraw_detail` VALUES ('114', '152715827802270', '1', '2', '2', 'RicottaElmar', '2000', null, '2018-05-24 18:37:58', '500.00', '0');
INSERT INTO `witdraw_detail` VALUES ('115', '152715855442777', '1', '2', '2', 'RicottaElmar', '20000', '5000.00', '2018-05-24 18:42:34', '42142142152', '0');
INSERT INTO `witdraw_detail` VALUES ('116', '152715861069201', '1', '2', '2', 'RicottaElmar', '2000', '500.00', '2018-05-24 18:43:31', '42142142152', '0');
INSERT INTO `witdraw_detail` VALUES ('117', '152715862370676', '1', '2', '2', 'RicottaElmar', '200', '50.00', '2018-05-24 18:43:44', '42142142152', '0');
INSERT INTO `witdraw_detail` VALUES ('118', '152722961875746', '1', '2', '2', 'RicottaElmar', '12222', '3055.00', '2018-05-25 14:26:59', '14141421424', '0');
INSERT INTO `witdraw_detail` VALUES ('119', '152722965030595', '1', '3', '2', 'RicottaElmar', '12', '3.00', '2018-05-25 14:27:30', '14141421424', '0');
INSERT INTO `witdraw_detail` VALUES ('120', '152724486544645', '1', '3', '2', 'Admin', '10', '9.00', '2018-05-25 18:41:05', '2323', '0');
INSERT INTO `witdraw_detail` VALUES ('121', '152724493981070', '1', '3', '2', 'Admin', '10', '9.00', '2018-05-25 18:42:20', '2323', '0');
INSERT INTO `witdraw_detail` VALUES ('122', '152724495534510', '1', '3', '2', 'Admin', '10', '9.00', '2018-05-25 18:42:35', '中国银行12345677', '0');
INSERT INTO `witdraw_detail` VALUES ('123', '152724506254801', '1', '3', '2', 'Admin', '10', '9.00', '2018-05-25 18:44:23', '中国银行12345677', '0');
INSERT INTO `witdraw_detail` VALUES ('124', '152724712872641', '1', '4', '2', 'Admin', '11', '10.00', '2018-05-25 19:18:49', '3423423', '0');
INSERT INTO `witdraw_detail` VALUES ('125', '152724808701356', '1', '4', '2', 'lingbin', '45', '44.00', '2018-05-25 19:34:47', '1234567890', '1');
INSERT INTO `witdraw_detail` VALUES ('126', '152724962393230', '1', '4', '2', 'lingbin', '42', '41.00', '2018-05-25 20:00:24', '213213', '0');
INSERT INTO `witdraw_detail` VALUES ('127', '152808519550166', '1', '4', null, 'RicottaElmar', '10000', '9900.00', '2018-06-04 12:06:36', '1123123', '1');
INSERT INTO `witdraw_detail` VALUES ('128', '152809820028260', '1', '4', null, 'RicottaElmar2', '123', '121.00', '2018-06-04 15:43:20', '1234567890852', '0');
INSERT INTO `witdraw_detail` VALUES ('129', '152809936678677', '1', '4', null, 'RicottaElmar2', '2000', '1980.00', '2018-06-04 16:02:47', '1234567890852', '0');
INSERT INTO `witdraw_detail` VALUES ('130', '152809964763102', '1', '4', null, 'RicottaElmar2', '200', '198.00', '2018-06-04 16:07:28', '1234567890852', '1');
INSERT INTO `witdraw_detail` VALUES ('131', '152833758498904', '1', '4', null, 'Admin', '2321', '2785.00', '2018-06-07 10:13:05', '12345677', '0');
INSERT INTO `witdraw_detail` VALUES ('132', '152842149971357', '1', null, '2', 'Admin', '7', '8.00', '2018-06-08 09:31:40', '23423', '0');
INSERT INTO `witdraw_detail` VALUES ('133', '152842336692306', '1', null, '2', 'Admin', '1', '1.00', '2018-06-08 10:02:47', '2342323', '0');
INSERT INTO `witdraw_detail` VALUES ('134', '152842667908184', '1', '1', '2', 'Admin', '11', '13.00', '2018-06-08 10:57:59', '12345677', '0');
INSERT INTO `witdraw_detail` VALUES ('135', '152868706831605', '458', null, '1', 'RicottaElmar2', '1', '1.00', '2018-06-11 11:17:48', '11111', '0');
INSERT INTO `witdraw_detail` VALUES ('136', '152868719372169', '458', null, '1', 'RicottaElmar2', '1', '1.00', '2018-06-11 11:19:54', '11111', '0');
INSERT INTO `witdraw_detail` VALUES ('137', '152868788716383', '458', null, '1', 'RicottaElmar2', '1', '1.00', '2018-06-11 11:31:27', '11111', '0');
INSERT INTO `witdraw_detail` VALUES ('138', '152868810369050', '458', null, '1', 'RicottaElmar2', '1', '1.00', '2018-06-11 11:35:04', '11111', '0');
INSERT INTO `witdraw_detail` VALUES ('139', '152868832718745', '458', null, '1', 'RicottaElmar2', '1', '1.00', '2018-06-11 11:38:47', '11111', '0');
INSERT INTO `witdraw_detail` VALUES ('140', '152868854907067', '458', null, '1', 'RicottaElmar2', '1', '1.00', '2018-06-11 11:42:29', '11111', '0');
INSERT INTO `witdraw_detail` VALUES ('141', '152868871001633', '458', null, '1', 'RicottaElmar2', '1', '1.00', '2018-06-11 11:45:10', '11111', '0');
INSERT INTO `witdraw_detail` VALUES ('142', '152869925834204', '1', '2', '2', 'Admin2', '12', '264.00', '2018-06-11 14:40:58', '33333', '0');
INSERT INTO `witdraw_detail` VALUES ('143', '152869932206065', '1', '2', '2', 'Admin2', '12', '264.00', '2018-06-11 14:42:02', '33333', '0');
INSERT INTO `witdraw_detail` VALUES ('144', '152870487313441', '1', '2', '2', 'Admin2', '1', '0.05', '2018-06-11 16:14:33', '33333', '0');

-- ----------------------------
-- Table structure for `zn_area`
-- ----------------------------
DROP TABLE IF EXISTS `zn_area`;
CREATE TABLE `zn_area` (
  `id` varchar(30) NOT NULL COMMENT '区域本身编号',
  `area_name` varchar(50) DEFAULT NULL COMMENT '区域名称',
  `area_type` varchar(10) DEFAULT NULL COMMENT '区域类型',
  `area_cede` varchar(30) DEFAULT NULL COMMENT '区域编码',
  `area_parent` varchar(30) DEFAULT NULL COMMENT '所属上级',
  `num` varchar(255) DEFAULT NULL COMMENT '前端使用次数',
  PRIMARY KEY (`id`),
  KEY `glm_Reference_1118` (`area_parent`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='省市区表';

-- ----------------------------
-- Records of zn_area
-- ----------------------------
INSERT INTO `zn_area` VALUES ('1', '北京', '1', '1', '0', null);
INSERT INTO `zn_area` VALUES ('10', '河南', '1', '10', '0', null);
INSERT INTO `zn_area` VALUES ('100', '崇左', '2', '100', '6', '21');
INSERT INTO `zn_area` VALUES ('1000', '台江县', '3', '1000', '114', null);
INSERT INTO `zn_area` VALUES ('1001', '黎平县', '3', '1001', '114', null);
INSERT INTO `zn_area` VALUES ('1002', '榕江县', '3', '1002', '114', null);
INSERT INTO `zn_area` VALUES ('1003', '从江县', '3', '1003', '114', null);
INSERT INTO `zn_area` VALUES ('1004', '雷山县', '3', '1004', '114', null);
INSERT INTO `zn_area` VALUES ('1005', '麻江县', '3', '1005', '114', null);
INSERT INTO `zn_area` VALUES ('1006', '丹寨县', '3', '1006', '114', null);
INSERT INTO `zn_area` VALUES ('1007', '都匀市', '3', '1007', '115', null);
INSERT INTO `zn_area` VALUES ('1008', '福泉市', '3', '1008', '115', null);
INSERT INTO `zn_area` VALUES ('1009', '荔波县', '3', '1009', '115', null);
INSERT INTO `zn_area` VALUES ('101', '防城港', '2', '101', '6', '3');
INSERT INTO `zn_area` VALUES ('1010', '贵定县', '3', '1010', '115', null);
INSERT INTO `zn_area` VALUES ('1011', '瓮安县', '3', '1011', '115', null);
INSERT INTO `zn_area` VALUES ('1012', '独山县', '3', '1012', '115', null);
INSERT INTO `zn_area` VALUES ('1013', '平塘县', '3', '1013', '115', null);
INSERT INTO `zn_area` VALUES ('1014', '罗甸县', '3', '1014', '115', null);
INSERT INTO `zn_area` VALUES ('1015', '长顺县', '3', '1015', '115', null);
INSERT INTO `zn_area` VALUES ('1016', '龙里县', '3', '1016', '115', null);
INSERT INTO `zn_area` VALUES ('1017', '惠水县', '3', '1017', '115', null);
INSERT INTO `zn_area` VALUES ('1018', '三都县', '3', '1018', '115', null);
INSERT INTO `zn_area` VALUES ('1019', '兴义市', '3', '1019', '116', null);
INSERT INTO `zn_area` VALUES ('102', '贵港', '2', '102', '6', '231');
INSERT INTO `zn_area` VALUES ('1020', '兴仁县', '3', '1020', '116', null);
INSERT INTO `zn_area` VALUES ('1021', '普安县', '3', '1021', '116', null);
INSERT INTO `zn_area` VALUES ('1022', '晴隆县', '3', '1022', '116', null);
INSERT INTO `zn_area` VALUES ('1023', '贞丰县', '3', '1023', '116', null);
INSERT INTO `zn_area` VALUES ('1024', '望谟县', '3', '1024', '116', null);
INSERT INTO `zn_area` VALUES ('1025', '册亨县', '3', '1025', '116', null);
INSERT INTO `zn_area` VALUES ('1026', '安龙县', '3', '1026', '116', null);
INSERT INTO `zn_area` VALUES ('1027', '铜仁市', '3', '1027', '117', null);
INSERT INTO `zn_area` VALUES ('1028', '江口县', '3', '1028', '117', null);
INSERT INTO `zn_area` VALUES ('1029', '石阡县', '3', '1029', '117', null);
INSERT INTO `zn_area` VALUES ('103', '河池', '2', '103', '6', '123');
INSERT INTO `zn_area` VALUES ('1030', '思南县', '3', '1030', '117', null);
INSERT INTO `zn_area` VALUES ('1031', '德江县', '3', '1031', '117', null);
INSERT INTO `zn_area` VALUES ('1032', '玉屏县', '3', '1032', '117', null);
INSERT INTO `zn_area` VALUES ('1033', '印江县', '3', '1033', '117', null);
INSERT INTO `zn_area` VALUES ('1034', '沿河县', '3', '1034', '117', null);
INSERT INTO `zn_area` VALUES ('1035', '松桃县', '3', '1035', '117', null);
INSERT INTO `zn_area` VALUES ('1036', '万山特区', '3', '1036', '117', null);
INSERT INTO `zn_area` VALUES ('1037', '红花岗区', '3', '1037', '118', null);
INSERT INTO `zn_area` VALUES ('1038', '务川县', '3', '1038', '118', null);
INSERT INTO `zn_area` VALUES ('1039', '道真县', '3', '1039', '118', null);
INSERT INTO `zn_area` VALUES ('104', '贺州', '2', '104', '6', '345');
INSERT INTO `zn_area` VALUES ('1040', '汇川区', '3', '1040', '118', '45');
INSERT INTO `zn_area` VALUES ('1041', '赤水市', '3', '1041', '118', null);
INSERT INTO `zn_area` VALUES ('1042', '仁怀市', '3', '1042', '118', null);
INSERT INTO `zn_area` VALUES ('1043', '遵义县', '3', '1043', '118', null);
INSERT INTO `zn_area` VALUES ('1044', '桐梓县', '3', '1044', '118', null);
INSERT INTO `zn_area` VALUES ('1045', '绥阳县', '3', '1045', '118', null);
INSERT INTO `zn_area` VALUES ('1046', '正安县', '3', '1046', '118', null);
INSERT INTO `zn_area` VALUES ('1047', '凤冈县', '3', '1047', '118', null);
INSERT INTO `zn_area` VALUES ('1048', '湄潭县', '3', '1048', '118', null);
INSERT INTO `zn_area` VALUES ('1049', '余庆县', '3', '1049', '118', null);
INSERT INTO `zn_area` VALUES ('105', '来宾', '2', '105', '6', '435');
INSERT INTO `zn_area` VALUES ('1050', '习水县', '3', '1050', '118', null);
INSERT INTO `zn_area` VALUES ('1053', '秀英区', '3', '1053', '119', null);
INSERT INTO `zn_area` VALUES ('1054', '龙华区', '3', '1054', '119', null);
INSERT INTO `zn_area` VALUES ('1055', '琼山区', '3', '1055', '119', null);
INSERT INTO `zn_area` VALUES ('1056', '美兰区', '3', '1056', '119', null);
INSERT INTO `zn_area` VALUES ('1057', '市区', '3', '1057', '136', null);
INSERT INTO `zn_area` VALUES ('1058', '洋浦开发区', '3', '1058', '136', null);
INSERT INTO `zn_area` VALUES ('1059', '那大镇', '3', '1059', '136', null);
INSERT INTO `zn_area` VALUES ('106', '柳州', '2', '106', '6', null);
INSERT INTO `zn_area` VALUES ('1060', '王五镇', '3', '1060', '136', null);
INSERT INTO `zn_area` VALUES ('1061', '雅星镇', '3', '1061', '136', null);
INSERT INTO `zn_area` VALUES ('1062', '大成镇', '3', '1062', '136', null);
INSERT INTO `zn_area` VALUES ('1063', '中和镇', '3', '1063', '136', null);
INSERT INTO `zn_area` VALUES ('1064', '峨蔓镇', '3', '1064', '136', null);
INSERT INTO `zn_area` VALUES ('1065', '南丰镇', '3', '1065', '136', null);
INSERT INTO `zn_area` VALUES ('1066', '白马井镇', '3', '1066', '136', null);
INSERT INTO `zn_area` VALUES ('1067', '兰洋镇', '3', '1067', '136', null);
INSERT INTO `zn_area` VALUES ('1068', '和庆镇', '3', '1068', '136', null);
INSERT INTO `zn_area` VALUES ('1069', '海头镇', '3', '1069', '136', null);
INSERT INTO `zn_area` VALUES ('107', '钦州', '2', '107', '6', null);
INSERT INTO `zn_area` VALUES ('1070', '排浦镇', '3', '1070', '136', null);
INSERT INTO `zn_area` VALUES ('1071', '东成镇', '3', '1071', '136', null);
INSERT INTO `zn_area` VALUES ('1072', '光村镇', '3', '1072', '136', null);
INSERT INTO `zn_area` VALUES ('1073', '木棠镇', '3', '1073', '136', null);
INSERT INTO `zn_area` VALUES ('1074', '新州镇', '3', '1074', '136', null);
INSERT INTO `zn_area` VALUES ('1075', '三都镇', '3', '1075', '136', null);
INSERT INTO `zn_area` VALUES ('1077', '长安区', '3', '1077', '137', null);
INSERT INTO `zn_area` VALUES ('1078', '桥东区', '3', '1078', '137', null);
INSERT INTO `zn_area` VALUES ('1079', '桥西区', '3', '1079', '137', null);
INSERT INTO `zn_area` VALUES ('108', '梧州', '2', '108', '6', null);
INSERT INTO `zn_area` VALUES ('1080', '新华区', '3', '1080', '137', null);
INSERT INTO `zn_area` VALUES ('1081', '裕华区', '3', '1081', '137', null);
INSERT INTO `zn_area` VALUES ('1082', '井陉矿区', '3', '1082', '137', null);
INSERT INTO `zn_area` VALUES ('1083', '高新区', '3', '1083', '137', null);
INSERT INTO `zn_area` VALUES ('1084', '辛集市', '3', '1084', '137', null);
INSERT INTO `zn_area` VALUES ('1085', '藁城市', '3', '1085', '137', null);
INSERT INTO `zn_area` VALUES ('1086', '晋州市', '3', '1086', '137', null);
INSERT INTO `zn_area` VALUES ('1087', '新乐市', '3', '1087', '137', null);
INSERT INTO `zn_area` VALUES ('1088', '鹿泉区', '3', '1088', '137', null);
INSERT INTO `zn_area` VALUES ('1089', '井陉县', '3', '1089', '137', null);
INSERT INTO `zn_area` VALUES ('109', '玉林', '2', '109', '6', null);
INSERT INTO `zn_area` VALUES ('1090', '正定县', '3', '1090', '137', null);
INSERT INTO `zn_area` VALUES ('1091', '栾城区', '3', '1091', '137', null);
INSERT INTO `zn_area` VALUES ('1092', '行唐县', '3', '1092', '137', null);
INSERT INTO `zn_area` VALUES ('1093', '灵寿县', '3', '1093', '137', null);
INSERT INTO `zn_area` VALUES ('1094', '高邑县', '3', '1094', '137', null);
INSERT INTO `zn_area` VALUES ('1095', '深泽县', '3', '1095', '137', null);
INSERT INTO `zn_area` VALUES ('1096', '赞皇县', '3', '1096', '137', null);
INSERT INTO `zn_area` VALUES ('1097', '无极县', '3', '1097', '137', null);
INSERT INTO `zn_area` VALUES ('1098', '平山县', '3', '1098', '137', null);
INSERT INTO `zn_area` VALUES ('1099', '元氏县', '3', '1099', '137', null);
INSERT INTO `zn_area` VALUES ('11', '黑龙江', '1', '11', '0', null);
INSERT INTO `zn_area` VALUES ('110', '贵阳', '2', '110', '7', null);
INSERT INTO `zn_area` VALUES ('1100', '赵县', '3', '1100', '137', null);
INSERT INTO `zn_area` VALUES ('1101', '新市区', '3', '1101', '138', null);
INSERT INTO `zn_area` VALUES ('1102', '南市区', '3', '1102', '138', null);
INSERT INTO `zn_area` VALUES ('1103', '北市区', '3', '1103', '138', null);
INSERT INTO `zn_area` VALUES ('1104', '涿州市', '3', '1104', '138', null);
INSERT INTO `zn_area` VALUES ('1105', '定州市', '3', '1105', '138', null);
INSERT INTO `zn_area` VALUES ('1106', '安国市', '3', '1106', '138', null);
INSERT INTO `zn_area` VALUES ('1107', '高碑店市', '3', '1107', '138', null);
INSERT INTO `zn_area` VALUES ('1108', '满城县', '3', '1108', '138', null);
INSERT INTO `zn_area` VALUES ('1109', '清苑县', '3', '1109', '138', null);
INSERT INTO `zn_area` VALUES ('111', '安顺', '2', '111', '7', null);
INSERT INTO `zn_area` VALUES ('1110', '涞水县', '3', '1110', '138', null);
INSERT INTO `zn_area` VALUES ('1111', '阜平县', '3', '1111', '138', null);
INSERT INTO `zn_area` VALUES ('1112', '徐水县', '3', '1112', '138', null);
INSERT INTO `zn_area` VALUES ('1113', '定兴县', '3', '1113', '138', null);
INSERT INTO `zn_area` VALUES ('1114', '唐县', '3', '1114', '138', null);
INSERT INTO `zn_area` VALUES ('1115', '高阳县', '3', '1115', '138', null);
INSERT INTO `zn_area` VALUES ('1116', '容城县', '3', '1116', '138', null);
INSERT INTO `zn_area` VALUES ('1117', '涞源县', '3', '1117', '138', null);
INSERT INTO `zn_area` VALUES ('1118', '望都县', '3', '1118', '138', null);
INSERT INTO `zn_area` VALUES ('1119', '安新县', '3', '1119', '138', null);
INSERT INTO `zn_area` VALUES ('112', '毕节', '2', '112', '7', null);
INSERT INTO `zn_area` VALUES ('1120', '易县', '3', '1120', '138', null);
INSERT INTO `zn_area` VALUES ('1121', '曲阳县', '3', '1121', '138', null);
INSERT INTO `zn_area` VALUES ('1122', '蠡县', '3', '1122', '138', null);
INSERT INTO `zn_area` VALUES ('1123', '顺平县', '3', '1123', '138', null);
INSERT INTO `zn_area` VALUES ('1124', '博野县', '3', '1124', '138', null);
INSERT INTO `zn_area` VALUES ('1125', '雄县', '3', '1125', '138', null);
INSERT INTO `zn_area` VALUES ('1126', '运河区', '3', '1126', '139', null);
INSERT INTO `zn_area` VALUES ('1127', '新华区', '3', '1127', '139', null);
INSERT INTO `zn_area` VALUES ('1128', '泊头市', '3', '1128', '139', null);
INSERT INTO `zn_area` VALUES ('1129', '任丘市', '3', '1129', '139', null);
INSERT INTO `zn_area` VALUES ('113', '六盘水', '2', '113', '7', null);
INSERT INTO `zn_area` VALUES ('1130', '黄骅市', '3', '1130', '139', null);
INSERT INTO `zn_area` VALUES ('1131', '河间市', '3', '1131', '139', null);
INSERT INTO `zn_area` VALUES ('1132', '沧县', '3', '1132', '139', null);
INSERT INTO `zn_area` VALUES ('1133', '青县', '3', '1133', '139', null);
INSERT INTO `zn_area` VALUES ('1134', '东光县', '3', '1134', '139', null);
INSERT INTO `zn_area` VALUES ('1135', '海兴县', '3', '1135', '139', null);
INSERT INTO `zn_area` VALUES ('1136', '盐山县', '3', '1136', '139', null);
INSERT INTO `zn_area` VALUES ('1137', '肃宁县', '3', '1137', '139', null);
INSERT INTO `zn_area` VALUES ('1138', '南皮县', '3', '1138', '139', null);
INSERT INTO `zn_area` VALUES ('1139', '吴桥县', '3', '1139', '139', null);
INSERT INTO `zn_area` VALUES ('114', '黔东南', '2', '114', '7', null);
INSERT INTO `zn_area` VALUES ('1140', '献县', '3', '1140', '139', null);
INSERT INTO `zn_area` VALUES ('1141', '孟村县', '3', '1141', '139', null);
INSERT INTO `zn_area` VALUES ('1142', '双桥区', '3', '1142', '140', null);
INSERT INTO `zn_area` VALUES ('1143', '双滦区', '3', '1143', '140', null);
INSERT INTO `zn_area` VALUES ('1144', '鹰手营子矿区', '3', '1144', '140', null);
INSERT INTO `zn_area` VALUES ('1145', '承德县', '3', '1145', '140', null);
INSERT INTO `zn_area` VALUES ('1146', '兴隆县', '3', '1146', '140', null);
INSERT INTO `zn_area` VALUES ('1147', '平泉县', '3', '1147', '140', null);
INSERT INTO `zn_area` VALUES ('1148', '滦平县', '3', '1148', '140', null);
INSERT INTO `zn_area` VALUES ('1149', '隆化县', '3', '1149', '140', null);
INSERT INTO `zn_area` VALUES ('115', '黔南', '2', '115', '7', null);
INSERT INTO `zn_area` VALUES ('1150', '丰宁县', '3', '1150', '140', null);
INSERT INTO `zn_area` VALUES ('1151', '宽城县', '3', '1151', '140', null);
INSERT INTO `zn_area` VALUES ('1152', '围场县', '3', '1152', '140', null);
INSERT INTO `zn_area` VALUES ('1153', '丛台区', '3', '1153', '141', null);
INSERT INTO `zn_area` VALUES ('1154', '复兴区', '3', '1154', '141', null);
INSERT INTO `zn_area` VALUES ('1155', '邯山区', '3', '1155', '141', null);
INSERT INTO `zn_area` VALUES ('1156', '峰峰矿区', '3', '1156', '141', null);
INSERT INTO `zn_area` VALUES ('1157', '武安市', '3', '1157', '141', null);
INSERT INTO `zn_area` VALUES ('1158', '邯郸县', '3', '1158', '141', null);
INSERT INTO `zn_area` VALUES ('1159', '临漳县', '3', '1159', '141', null);
INSERT INTO `zn_area` VALUES ('116', '黔西南', '2', '116', '7', null);
INSERT INTO `zn_area` VALUES ('1160', '成安县', '3', '1160', '141', null);
INSERT INTO `zn_area` VALUES ('1161', '大名县', '3', '1161', '141', null);
INSERT INTO `zn_area` VALUES ('1162', '涉县', '3', '1162', '141', null);
INSERT INTO `zn_area` VALUES ('1163', '磁县', '3', '1163', '141', null);
INSERT INTO `zn_area` VALUES ('1164', '肥乡县', '3', '1164', '141', null);
INSERT INTO `zn_area` VALUES ('1165', '永年县', '3', '1165', '141', null);
INSERT INTO `zn_area` VALUES ('1166', '邱县', '3', '1166', '141', null);
INSERT INTO `zn_area` VALUES ('1167', '鸡泽县', '3', '1167', '141', null);
INSERT INTO `zn_area` VALUES ('1168', '广平县', '3', '1168', '141', null);
INSERT INTO `zn_area` VALUES ('1169', '馆陶县', '3', '1169', '141', null);
INSERT INTO `zn_area` VALUES ('117', '铜仁', '2', '117', '7', null);
INSERT INTO `zn_area` VALUES ('1170', '魏县', '3', '1170', '141', null);
INSERT INTO `zn_area` VALUES ('1171', '曲周县', '3', '1171', '141', null);
INSERT INTO `zn_area` VALUES ('1172', '桃城区', '3', '1172', '142', null);
INSERT INTO `zn_area` VALUES ('1173', '冀州市', '3', '1173', '142', null);
INSERT INTO `zn_area` VALUES ('1174', '深州市', '3', '1174', '142', null);
INSERT INTO `zn_area` VALUES ('1175', '枣强县', '3', '1175', '142', null);
INSERT INTO `zn_area` VALUES ('1176', '武邑县', '3', '1176', '142', null);
INSERT INTO `zn_area` VALUES ('1177', '武强县', '3', '1177', '142', null);
INSERT INTO `zn_area` VALUES ('1178', '饶阳县', '3', '1178', '142', null);
INSERT INTO `zn_area` VALUES ('1179', '安平县', '3', '1179', '142', null);
INSERT INTO `zn_area` VALUES ('118', '遵义', '2', '118', '7', null);
INSERT INTO `zn_area` VALUES ('1180', '故城县', '3', '1180', '142', null);
INSERT INTO `zn_area` VALUES ('1181', '景县', '3', '1181', '142', null);
INSERT INTO `zn_area` VALUES ('1182', '阜城县', '3', '1182', '142', null);
INSERT INTO `zn_area` VALUES ('1183', '安次区', '3', '1183', '143', null);
INSERT INTO `zn_area` VALUES ('1184', '广阳区', '3', '1184', '143', null);
INSERT INTO `zn_area` VALUES ('1185', '霸州市', '3', '1185', '143', null);
INSERT INTO `zn_area` VALUES ('1186', '三河市', '3', '1186', '143', null);
INSERT INTO `zn_area` VALUES ('1187', '固安县', '3', '1187', '143', null);
INSERT INTO `zn_area` VALUES ('1188', '永清县', '3', '1188', '143', null);
INSERT INTO `zn_area` VALUES ('1189', '香河县', '3', '1189', '143', null);
INSERT INTO `zn_area` VALUES ('119', '海口', '2', '119', '8', null);
INSERT INTO `zn_area` VALUES ('1190', '大城县', '3', '1190', '143', null);
INSERT INTO `zn_area` VALUES ('1191', '文安县', '3', '1191', '143', null);
INSERT INTO `zn_area` VALUES ('1192', '大厂县', '3', '1192', '143', null);
INSERT INTO `zn_area` VALUES ('1193', '海港区', '3', '1193', '144', null);
INSERT INTO `zn_area` VALUES ('1194', '山海关区', '3', '1194', '144', null);
INSERT INTO `zn_area` VALUES ('1195', '北戴河区', '3', '1195', '144', null);
INSERT INTO `zn_area` VALUES ('1196', '昌黎县', '3', '1196', '144', null);
INSERT INTO `zn_area` VALUES ('1197', '抚宁县', '3', '1197', '144', null);
INSERT INTO `zn_area` VALUES ('1198', '卢龙县', '3', '1198', '144', null);
INSERT INTO `zn_area` VALUES ('1199', '青龙县', '3', '1199', '144', null);
INSERT INTO `zn_area` VALUES ('12', '湖北', '1', '12', '0', null);
INSERT INTO `zn_area` VALUES ('120', '三亚', '2', '120', '8', null);
INSERT INTO `zn_area` VALUES ('1200', '路北区', '3', '1200', '145', null);
INSERT INTO `zn_area` VALUES ('1201', '路南区', '3', '1201', '145', null);
INSERT INTO `zn_area` VALUES ('1202', '古冶区', '3', '1202', '145', null);
INSERT INTO `zn_area` VALUES ('1203', '开平区', '3', '1203', '145', null);
INSERT INTO `zn_area` VALUES ('1204', '丰南区', '3', '1204', '145', null);
INSERT INTO `zn_area` VALUES ('1205', '丰润区', '3', '1205', '145', null);
INSERT INTO `zn_area` VALUES ('1206', '遵化市', '3', '1206', '145', null);
INSERT INTO `zn_area` VALUES ('1207', '迁安市', '3', '1207', '145', null);
INSERT INTO `zn_area` VALUES ('1208', '滦县', '3', '1208', '145', null);
INSERT INTO `zn_area` VALUES ('1209', '滦南县', '3', '1209', '145', null);
INSERT INTO `zn_area` VALUES ('121', '白沙县', '2', '121', '8', null);
INSERT INTO `zn_area` VALUES ('1210', '乐亭县', '3', '1210', '145', null);
INSERT INTO `zn_area` VALUES ('1211', '迁西县', '3', '1211', '145', null);
INSERT INTO `zn_area` VALUES ('1212', '玉田县', '3', '1212', '145', null);
INSERT INTO `zn_area` VALUES ('1213', '唐海县', '3', '1213', '145', null);
INSERT INTO `zn_area` VALUES ('1214', '桥东区', '3', '1214', '146', null);
INSERT INTO `zn_area` VALUES ('1215', '桥西区', '3', '1215', '146', null);
INSERT INTO `zn_area` VALUES ('1216', '南宫市', '3', '1216', '146', null);
INSERT INTO `zn_area` VALUES ('1217', '沙河市', '3', '1217', '146', null);
INSERT INTO `zn_area` VALUES ('1218', '邢台县', '3', '1218', '146', null);
INSERT INTO `zn_area` VALUES ('1219', '临城县', '3', '1219', '146', null);
INSERT INTO `zn_area` VALUES ('122', '保亭县', '2', '122', '8', null);
INSERT INTO `zn_area` VALUES ('1220', '内丘县', '3', '1220', '146', null);
INSERT INTO `zn_area` VALUES ('1221', '柏乡县', '3', '1221', '146', null);
INSERT INTO `zn_area` VALUES ('1222', '隆尧县', '3', '1222', '146', null);
INSERT INTO `zn_area` VALUES ('1223', '任县', '3', '1223', '146', null);
INSERT INTO `zn_area` VALUES ('1224', '南和县', '3', '1224', '146', null);
INSERT INTO `zn_area` VALUES ('1225', '宁晋县', '3', '1225', '146', null);
INSERT INTO `zn_area` VALUES ('1226', '巨鹿县', '3', '1226', '146', null);
INSERT INTO `zn_area` VALUES ('1227', '新河县', '3', '1227', '146', null);
INSERT INTO `zn_area` VALUES ('1228', '广宗县', '3', '1228', '146', null);
INSERT INTO `zn_area` VALUES ('1229', '平乡县', '3', '1229', '146', null);
INSERT INTO `zn_area` VALUES ('123', '昌江县', '2', '123', '8', null);
INSERT INTO `zn_area` VALUES ('1230', '威县', '3', '1230', '146', null);
INSERT INTO `zn_area` VALUES ('1231', '清河县', '3', '1231', '146', null);
INSERT INTO `zn_area` VALUES ('1232', '临西县', '3', '1232', '146', null);
INSERT INTO `zn_area` VALUES ('1233', '桥西区', '3', '1233', '147', null);
INSERT INTO `zn_area` VALUES ('1234', '桥东区', '3', '1234', '147', null);
INSERT INTO `zn_area` VALUES ('1235', '宣化区', '3', '1235', '147', null);
INSERT INTO `zn_area` VALUES ('1236', '下花园区', '3', '1236', '147', null);
INSERT INTO `zn_area` VALUES ('1237', '宣化县', '3', '1237', '147', null);
INSERT INTO `zn_area` VALUES ('1238', '张北县', '3', '1238', '147', null);
INSERT INTO `zn_area` VALUES ('1239', '康保县', '3', '1239', '147', null);
INSERT INTO `zn_area` VALUES ('124', '澄迈县', '2', '124', '8', null);
INSERT INTO `zn_area` VALUES ('1240', '沽源县', '3', '1240', '147', null);
INSERT INTO `zn_area` VALUES ('1241', '尚义县', '3', '1241', '147', null);
INSERT INTO `zn_area` VALUES ('1242', '蔚县', '3', '1242', '147', null);
INSERT INTO `zn_area` VALUES ('1243', '阳原县', '3', '1243', '147', null);
INSERT INTO `zn_area` VALUES ('1244', '怀安县', '3', '1244', '147', null);
INSERT INTO `zn_area` VALUES ('1245', '万全县', '3', '1245', '147', null);
INSERT INTO `zn_area` VALUES ('1246', '怀来县', '3', '1246', '147', null);
INSERT INTO `zn_area` VALUES ('1247', '涿鹿县', '3', '1247', '147', null);
INSERT INTO `zn_area` VALUES ('1248', '赤城县', '3', '1248', '147', null);
INSERT INTO `zn_area` VALUES ('1249', '崇礼县', '3', '1249', '147', null);
INSERT INTO `zn_area` VALUES ('125', '定安县', '2', '125', '8', null);
INSERT INTO `zn_area` VALUES ('1250', '金水区', '3', '1250', '148', null);
INSERT INTO `zn_area` VALUES ('1251', '邙山区', '3', '1251', '148', null);
INSERT INTO `zn_area` VALUES ('1252', '二七区', '3', '1252', '148', null);
INSERT INTO `zn_area` VALUES ('1253', '管城区', '3', '1253', '148', null);
INSERT INTO `zn_area` VALUES ('1254', '中原区', '3', '1254', '148', null);
INSERT INTO `zn_area` VALUES ('1255', '上街区', '3', '1255', '148', null);
INSERT INTO `zn_area` VALUES ('1256', '惠济区', '3', '1256', '148', null);
INSERT INTO `zn_area` VALUES ('1257', '郑东新区', '3', '1257', '148', null);
INSERT INTO `zn_area` VALUES ('1258', '经济技术开发区', '3', '1258', '148', null);
INSERT INTO `zn_area` VALUES ('1259', '高新开发区', '3', '1259', '148', null);
INSERT INTO `zn_area` VALUES ('126', '东方', '2', '126', '8', null);
INSERT INTO `zn_area` VALUES ('1260', '出口加工区', '3', '1260', '148', null);
INSERT INTO `zn_area` VALUES ('1261', '巩义市', '3', '1261', '148', null);
INSERT INTO `zn_area` VALUES ('1262', '荥阳市', '3', '1262', '148', null);
INSERT INTO `zn_area` VALUES ('1263', '新密市', '3', '1263', '148', null);
INSERT INTO `zn_area` VALUES ('1264', '新郑市', '3', '1264', '148', null);
INSERT INTO `zn_area` VALUES ('1265', '登封市', '3', '1265', '148', null);
INSERT INTO `zn_area` VALUES ('1266', '中牟县', '3', '1266', '148', null);
INSERT INTO `zn_area` VALUES ('1267', '西工区', '3', '1267', '149', null);
INSERT INTO `zn_area` VALUES ('1268', '老城区', '3', '1268', '149', null);
INSERT INTO `zn_area` VALUES ('1269', '涧西区', '3', '1269', '149', null);
INSERT INTO `zn_area` VALUES ('127', '乐东县', '2', '127', '8', null);
INSERT INTO `zn_area` VALUES ('1270', '瀍河回族区', '3', '1270', '149', null);
INSERT INTO `zn_area` VALUES ('1271', '洛龙区', '3', '1271', '149', null);
INSERT INTO `zn_area` VALUES ('1272', '吉利区', '3', '1272', '149', null);
INSERT INTO `zn_area` VALUES ('1273', '偃师市', '3', '1273', '149', null);
INSERT INTO `zn_area` VALUES ('1274', '孟津县', '3', '1274', '149', null);
INSERT INTO `zn_area` VALUES ('1275', '新安县', '3', '1275', '149', null);
INSERT INTO `zn_area` VALUES ('1276', '栾川县', '3', '1276', '149', null);
INSERT INTO `zn_area` VALUES ('1277', '嵩县', '3', '1277', '149', null);
INSERT INTO `zn_area` VALUES ('1278', '汝阳县', '3', '1278', '149', null);
INSERT INTO `zn_area` VALUES ('1279', '宜阳县', '3', '1279', '149', null);
INSERT INTO `zn_area` VALUES ('128', '临高县', '2', '128', '8', null);
INSERT INTO `zn_area` VALUES ('1280', '洛宁县', '3', '1280', '149', null);
INSERT INTO `zn_area` VALUES ('1281', '伊川县', '3', '1281', '149', null);
INSERT INTO `zn_area` VALUES ('1282', '鼓楼区', '3', '1282', '150', null);
INSERT INTO `zn_area` VALUES ('1283', '龙亭区', '3', '1283', '150', null);
INSERT INTO `zn_area` VALUES ('1284', '顺河区', '3', '1284', '150', null);
INSERT INTO `zn_area` VALUES ('1285', '金明区', '3', '1285', '150', null);
INSERT INTO `zn_area` VALUES ('1286', '禹王台区', '3', '1286', '150', null);
INSERT INTO `zn_area` VALUES ('1287', '杞县', '3', '1287', '150', null);
INSERT INTO `zn_area` VALUES ('1288', '通许县', '3', '1288', '150', null);
INSERT INTO `zn_area` VALUES ('1289', '尉氏县', '3', '1289', '150', null);
INSERT INTO `zn_area` VALUES ('129', '陵水县', '2', '129', '8', null);
INSERT INTO `zn_area` VALUES ('1290', '开封县', '3', '1290', '150', null);
INSERT INTO `zn_area` VALUES ('1291', '兰考县', '3', '1291', '150', null);
INSERT INTO `zn_area` VALUES ('1292', '北关区', '3', '1292', '151', null);
INSERT INTO `zn_area` VALUES ('1293', '文峰区', '3', '1293', '151', null);
INSERT INTO `zn_area` VALUES ('1294', '殷都区', '3', '1294', '151', null);
INSERT INTO `zn_area` VALUES ('1295', '龙安区', '3', '1295', '151', null);
INSERT INTO `zn_area` VALUES ('1296', '林州市', '3', '1296', '151', null);
INSERT INTO `zn_area` VALUES ('1297', '安阳县', '3', '1297', '151', null);
INSERT INTO `zn_area` VALUES ('1298', '汤阴县', '3', '1298', '151', null);
INSERT INTO `zn_area` VALUES ('1299', '滑县', '3', '1299', '151', null);
INSERT INTO `zn_area` VALUES ('13', '湖南', '1', '13', '0', null);
INSERT INTO `zn_area` VALUES ('130', '琼海', '2', '130', '8', null);
INSERT INTO `zn_area` VALUES ('1300', '内黄县', '3', '1300', '151', null);
INSERT INTO `zn_area` VALUES ('1301', '淇滨区', '3', '1301', '152', null);
INSERT INTO `zn_area` VALUES ('1302', '山城区', '3', '1302', '152', null);
INSERT INTO `zn_area` VALUES ('1303', '鹤山区', '3', '1303', '152', null);
INSERT INTO `zn_area` VALUES ('1304', '浚县', '3', '1304', '152', null);
INSERT INTO `zn_area` VALUES ('1305', '淇县', '3', '1305', '152', null);
INSERT INTO `zn_area` VALUES ('1306', '济源市', '3', '1306', '153', null);
INSERT INTO `zn_area` VALUES ('1307', '解放区', '3', '1307', '154', null);
INSERT INTO `zn_area` VALUES ('1308', '中站区', '3', '1308', '154', null);
INSERT INTO `zn_area` VALUES ('1309', '马村区', '3', '1309', '154', null);
INSERT INTO `zn_area` VALUES ('131', '琼中', '2', '131', '8', null);
INSERT INTO `zn_area` VALUES ('1310', '山阳区', '3', '1310', '154', null);
INSERT INTO `zn_area` VALUES ('1311', '沁阳市', '3', '1311', '154', null);
INSERT INTO `zn_area` VALUES ('1312', '孟州市', '3', '1312', '154', null);
INSERT INTO `zn_area` VALUES ('1313', '修武县', '3', '1313', '154', null);
INSERT INTO `zn_area` VALUES ('1314', '博爱县', '3', '1314', '154', null);
INSERT INTO `zn_area` VALUES ('1315', '武陟县', '3', '1315', '154', null);
INSERT INTO `zn_area` VALUES ('1316', '温县', '3', '1316', '154', null);
INSERT INTO `zn_area` VALUES ('1317', '卧龙区', '3', '1317', '155', null);
INSERT INTO `zn_area` VALUES ('1318', '宛城区', '3', '1318', '155', null);
INSERT INTO `zn_area` VALUES ('1319', '邓州市', '3', '1319', '155', null);
INSERT INTO `zn_area` VALUES ('132', '屯昌县', '2', '132', '8', null);
INSERT INTO `zn_area` VALUES ('1320', '南召县', '3', '1320', '155', null);
INSERT INTO `zn_area` VALUES ('1321', '方城县', '3', '1321', '155', null);
INSERT INTO `zn_area` VALUES ('1322', '西峡县', '3', '1322', '155', null);
INSERT INTO `zn_area` VALUES ('1323', '镇平县', '3', '1323', '155', null);
INSERT INTO `zn_area` VALUES ('1324', '内乡县', '3', '1324', '155', null);
INSERT INTO `zn_area` VALUES ('1325', '淅川县', '3', '1325', '155', null);
INSERT INTO `zn_area` VALUES ('1326', '社旗县', '3', '1326', '155', null);
INSERT INTO `zn_area` VALUES ('1327', '唐河县', '3', '1327', '155', null);
INSERT INTO `zn_area` VALUES ('1328', '新野县', '3', '1328', '155', null);
INSERT INTO `zn_area` VALUES ('1329', '桐柏县', '3', '1329', '155', null);
INSERT INTO `zn_area` VALUES ('133', '万宁', '2', '133', '8', null);
INSERT INTO `zn_area` VALUES ('1330', '新华区', '3', '1330', '156', null);
INSERT INTO `zn_area` VALUES ('1331', '卫东区', '3', '1331', '156', null);
INSERT INTO `zn_area` VALUES ('1332', '湛河区', '3', '1332', '156', null);
INSERT INTO `zn_area` VALUES ('1333', '石龙区', '3', '1333', '156', null);
INSERT INTO `zn_area` VALUES ('1334', '舞钢市', '3', '1334', '156', null);
INSERT INTO `zn_area` VALUES ('1335', '汝州市', '3', '1335', '156', null);
INSERT INTO `zn_area` VALUES ('1336', '宝丰县', '3', '1336', '156', null);
INSERT INTO `zn_area` VALUES ('1337', '叶县', '3', '1337', '156', null);
INSERT INTO `zn_area` VALUES ('1338', '鲁山县', '3', '1338', '156', null);
INSERT INTO `zn_area` VALUES ('1339', '郏县', '3', '1339', '156', null);
INSERT INTO `zn_area` VALUES ('134', '文昌', '2', '134', '8', null);
INSERT INTO `zn_area` VALUES ('1340', '湖滨区', '3', '1340', '157', null);
INSERT INTO `zn_area` VALUES ('1341', '义马市', '3', '1341', '157', null);
INSERT INTO `zn_area` VALUES ('1342', '灵宝市', '3', '1342', '157', null);
INSERT INTO `zn_area` VALUES ('1343', '渑池县', '3', '1343', '157', null);
INSERT INTO `zn_area` VALUES ('1344', '陕县', '3', '1344', '157', null);
INSERT INTO `zn_area` VALUES ('1345', '卢氏县', '3', '1345', '157', null);
INSERT INTO `zn_area` VALUES ('1346', '梁园区', '3', '1346', '158', null);
INSERT INTO `zn_area` VALUES ('1347', '睢阳区', '3', '1347', '158', null);
INSERT INTO `zn_area` VALUES ('1348', '永城市', '3', '1348', '158', null);
INSERT INTO `zn_area` VALUES ('1349', '民权县', '3', '1349', '158', null);
INSERT INTO `zn_area` VALUES ('135', '五指山', '2', '135', '8', null);
INSERT INTO `zn_area` VALUES ('1350', '睢县', '3', '1350', '158', null);
INSERT INTO `zn_area` VALUES ('1351', '宁陵县', '3', '1351', '158', null);
INSERT INTO `zn_area` VALUES ('1352', '虞城县', '3', '1352', '158', null);
INSERT INTO `zn_area` VALUES ('1353', '柘城县', '3', '1353', '158', null);
INSERT INTO `zn_area` VALUES ('1354', '夏邑县', '3', '1354', '158', null);
INSERT INTO `zn_area` VALUES ('1355', '卫滨区', '3', '1355', '159', null);
INSERT INTO `zn_area` VALUES ('1356', '红旗区', '3', '1356', '159', null);
INSERT INTO `zn_area` VALUES ('1357', '凤泉区', '3', '1357', '159', null);
INSERT INTO `zn_area` VALUES ('1358', '牧野区', '3', '1358', '159', null);
INSERT INTO `zn_area` VALUES ('1359', '卫辉市', '3', '1359', '159', null);
INSERT INTO `zn_area` VALUES ('136', '儋州', '2', '136', '8', null);
INSERT INTO `zn_area` VALUES ('1360', '辉县市', '3', '1360', '159', null);
INSERT INTO `zn_area` VALUES ('1361', '新乡县', '3', '1361', '159', null);
INSERT INTO `zn_area` VALUES ('1362', '获嘉县', '3', '1362', '159', null);
INSERT INTO `zn_area` VALUES ('1363', '原阳县', '3', '1363', '159', null);
INSERT INTO `zn_area` VALUES ('1364', '延津县', '3', '1364', '159', null);
INSERT INTO `zn_area` VALUES ('1365', '封丘县', '3', '1365', '159', null);
INSERT INTO `zn_area` VALUES ('1366', '长垣县', '3', '1366', '159', null);
INSERT INTO `zn_area` VALUES ('1367', '浉河区', '3', '1367', '160', null);
INSERT INTO `zn_area` VALUES ('1368', '平桥区', '3', '1368', '160', null);
INSERT INTO `zn_area` VALUES ('1369', '罗山县', '3', '1369', '160', null);
INSERT INTO `zn_area` VALUES ('137', '石家庄', '2', '137', '9', null);
INSERT INTO `zn_area` VALUES ('1370', '光山县', '3', '1370', '160', null);
INSERT INTO `zn_area` VALUES ('1371', '新县', '3', '1371', '160', null);
INSERT INTO `zn_area` VALUES ('1372', '商城县', '3', '1372', '160', null);
INSERT INTO `zn_area` VALUES ('1373', '固始县', '3', '1373', '160', null);
INSERT INTO `zn_area` VALUES ('1374', '潢川县', '3', '1374', '160', null);
INSERT INTO `zn_area` VALUES ('1375', '淮滨县', '3', '1375', '160', null);
INSERT INTO `zn_area` VALUES ('1376', '息县', '3', '1376', '160', null);
INSERT INTO `zn_area` VALUES ('1377', '魏都区', '3', '1377', '161', null);
INSERT INTO `zn_area` VALUES ('1378', '禹州市', '3', '1378', '161', null);
INSERT INTO `zn_area` VALUES ('1379', '长葛市', '3', '1379', '161', null);
INSERT INTO `zn_area` VALUES ('138', '保定', '2', '138', '9', null);
INSERT INTO `zn_area` VALUES ('1380', '许昌县', '3', '1380', '161', null);
INSERT INTO `zn_area` VALUES ('1381', '鄢陵县', '3', '1381', '161', null);
INSERT INTO `zn_area` VALUES ('1382', '襄城县', '3', '1382', '161', null);
INSERT INTO `zn_area` VALUES ('1383', '川汇区', '3', '1383', '162', null);
INSERT INTO `zn_area` VALUES ('1384', '项城市', '3', '1384', '162', null);
INSERT INTO `zn_area` VALUES ('1385', '扶沟县', '3', '1385', '162', null);
INSERT INTO `zn_area` VALUES ('1386', '西华县', '3', '1386', '162', null);
INSERT INTO `zn_area` VALUES ('1387', '商水县', '3', '1387', '162', null);
INSERT INTO `zn_area` VALUES ('1388', '沈丘县', '3', '1388', '162', null);
INSERT INTO `zn_area` VALUES ('1389', '郸城县', '3', '1389', '162', null);
INSERT INTO `zn_area` VALUES ('139', '沧州', '2', '139', '9', null);
INSERT INTO `zn_area` VALUES ('1390', '淮阳县', '3', '1390', '162', null);
INSERT INTO `zn_area` VALUES ('1391', '太康县', '3', '1391', '162', null);
INSERT INTO `zn_area` VALUES ('1392', '鹿邑县', '3', '1392', '162', null);
INSERT INTO `zn_area` VALUES ('1393', '驿城区', '3', '1393', '163', null);
INSERT INTO `zn_area` VALUES ('1394', '西平县', '3', '1394', '163', null);
INSERT INTO `zn_area` VALUES ('1395', '上蔡县', '3', '1395', '163', null);
INSERT INTO `zn_area` VALUES ('1396', '平舆县', '3', '1396', '163', null);
INSERT INTO `zn_area` VALUES ('1397', '正阳县', '3', '1397', '163', null);
INSERT INTO `zn_area` VALUES ('1398', '确山县', '3', '1398', '163', null);
INSERT INTO `zn_area` VALUES ('1399', '泌阳县', '3', '1399', '163', null);
INSERT INTO `zn_area` VALUES ('14', '吉林', '1', '14', '0', null);
INSERT INTO `zn_area` VALUES ('140', '承德', '2', '140', '9', null);
INSERT INTO `zn_area` VALUES ('1400', '汝南县', '3', '1400', '163', null);
INSERT INTO `zn_area` VALUES ('1401', '遂平县', '3', '1401', '163', null);
INSERT INTO `zn_area` VALUES ('1402', '新蔡县', '3', '1402', '163', null);
INSERT INTO `zn_area` VALUES ('1403', '郾城区', '3', '1403', '164', null);
INSERT INTO `zn_area` VALUES ('1404', '源汇区', '3', '1404', '164', null);
INSERT INTO `zn_area` VALUES ('1405', '召陵区', '3', '1405', '164', null);
INSERT INTO `zn_area` VALUES ('1406', '舞阳县', '3', '1406', '164', null);
INSERT INTO `zn_area` VALUES ('1407', '临颍县', '3', '1407', '164', null);
INSERT INTO `zn_area` VALUES ('1408', '华龙区', '3', '1408', '165', null);
INSERT INTO `zn_area` VALUES ('1409', '清丰县', '3', '1409', '165', null);
INSERT INTO `zn_area` VALUES ('141', '邯郸', '2', '141', '9', null);
INSERT INTO `zn_area` VALUES ('1410', '南乐县', '3', '1410', '165', null);
INSERT INTO `zn_area` VALUES ('1411', '范县', '3', '1411', '165', null);
INSERT INTO `zn_area` VALUES ('1412', '台前县', '3', '1412', '165', null);
INSERT INTO `zn_area` VALUES ('1413', '濮阳县', '3', '1413', '165', null);
INSERT INTO `zn_area` VALUES ('1414', '道里区', '3', '1414', '166', null);
INSERT INTO `zn_area` VALUES ('1415', '南岗区', '3', '1415', '166', null);
INSERT INTO `zn_area` VALUES ('1417', '平房区', '3', '1417', '166', null);
INSERT INTO `zn_area` VALUES ('1418', '香坊区', '3', '1418', '166', null);
INSERT INTO `zn_area` VALUES ('142', '衡水', '2', '142', '9', null);
INSERT INTO `zn_area` VALUES ('1420', '道外区', '3', '1420', '166', null);
INSERT INTO `zn_area` VALUES ('1421', '阿城区', '3', '1421', '166', null);
INSERT INTO `zn_area` VALUES ('1422', '呼兰区', '3', '1422', '166', null);
INSERT INTO `zn_area` VALUES ('1423', '松北区', '3', '1423', '166', null);
INSERT INTO `zn_area` VALUES ('1424', '尚志市', '3', '1424', '166', null);
INSERT INTO `zn_area` VALUES ('1425', '双城市', '3', '1425', '166', null);
INSERT INTO `zn_area` VALUES ('1426', '五常市', '3', '1426', '166', null);
INSERT INTO `zn_area` VALUES ('1427', '方正县', '3', '1427', '166', null);
INSERT INTO `zn_area` VALUES ('1428', '宾县', '3', '1428', '166', null);
INSERT INTO `zn_area` VALUES ('1429', '依兰县', '3', '1429', '166', null);
INSERT INTO `zn_area` VALUES ('143', '廊坊', '2', '143', '9', null);
INSERT INTO `zn_area` VALUES ('1430', '巴彦县', '3', '1430', '166', null);
INSERT INTO `zn_area` VALUES ('1431', '通河县', '3', '1431', '166', null);
INSERT INTO `zn_area` VALUES ('1432', '木兰县', '3', '1432', '166', null);
INSERT INTO `zn_area` VALUES ('1433', '延寿县', '3', '1433', '166', null);
INSERT INTO `zn_area` VALUES ('1434', '萨尔图区', '3', '1434', '167', null);
INSERT INTO `zn_area` VALUES ('1435', '红岗区', '3', '1435', '167', null);
INSERT INTO `zn_area` VALUES ('1436', '龙凤区', '3', '1436', '167', null);
INSERT INTO `zn_area` VALUES ('1437', '让胡路区', '3', '1437', '167', null);
INSERT INTO `zn_area` VALUES ('1438', '大同区', '3', '1438', '167', null);
INSERT INTO `zn_area` VALUES ('1439', '肇州县', '3', '1439', '167', null);
INSERT INTO `zn_area` VALUES ('144', '秦皇岛', '2', '144', '9', null);
INSERT INTO `zn_area` VALUES ('1440', '肇源县', '3', '1440', '167', null);
INSERT INTO `zn_area` VALUES ('1441', '林甸县', '3', '1441', '167', null);
INSERT INTO `zn_area` VALUES ('1442', '杜尔伯特', '3', '1442', '167', null);
INSERT INTO `zn_area` VALUES ('1443', '呼玛县', '3', '1443', '168', null);
INSERT INTO `zn_area` VALUES ('1444', '漠河县', '3', '1444', '168', null);
INSERT INTO `zn_area` VALUES ('1445', '塔河县', '3', '1445', '168', null);
INSERT INTO `zn_area` VALUES ('1446', '兴山区', '3', '1446', '169', null);
INSERT INTO `zn_area` VALUES ('1447', '工农区', '3', '1447', '169', null);
INSERT INTO `zn_area` VALUES ('1448', '南山区', '3', '1448', '169', null);
INSERT INTO `zn_area` VALUES ('1449', '兴安区', '3', '1449', '169', null);
INSERT INTO `zn_area` VALUES ('145', '唐山', '2', '145', '9', null);
INSERT INTO `zn_area` VALUES ('1450', '向阳区', '3', '1450', '169', null);
INSERT INTO `zn_area` VALUES ('1451', '东山区', '3', '1451', '169', null);
INSERT INTO `zn_area` VALUES ('1452', '萝北县', '3', '1452', '169', null);
INSERT INTO `zn_area` VALUES ('1453', '绥滨县', '3', '1453', '169', null);
INSERT INTO `zn_area` VALUES ('1454', '爱辉区', '3', '1454', '170', null);
INSERT INTO `zn_area` VALUES ('1455', '五大连池市', '3', '1455', '170', null);
INSERT INTO `zn_area` VALUES ('1456', '北安市', '3', '1456', '170', null);
INSERT INTO `zn_area` VALUES ('1457', '嫩江县', '3', '1457', '170', null);
INSERT INTO `zn_area` VALUES ('1458', '逊克县', '3', '1458', '170', null);
INSERT INTO `zn_area` VALUES ('1459', '孙吴县', '3', '1459', '170', null);
INSERT INTO `zn_area` VALUES ('146', '邢台', '2', '146', '9', null);
INSERT INTO `zn_area` VALUES ('1460', '鸡冠区', '3', '1460', '171', null);
INSERT INTO `zn_area` VALUES ('1461', '恒山区', '3', '1461', '171', null);
INSERT INTO `zn_area` VALUES ('1462', '城子河区', '3', '1462', '171', null);
INSERT INTO `zn_area` VALUES ('1463', '滴道区', '3', '1463', '171', null);
INSERT INTO `zn_area` VALUES ('1464', '梨树区', '3', '1464', '171', null);
INSERT INTO `zn_area` VALUES ('1465', '虎林市', '3', '1465', '171', null);
INSERT INTO `zn_area` VALUES ('1466', '密山市', '3', '1466', '171', null);
INSERT INTO `zn_area` VALUES ('1467', '鸡东县', '3', '1467', '171', null);
INSERT INTO `zn_area` VALUES ('1468', '前进区', '3', '1468', '172', null);
INSERT INTO `zn_area` VALUES ('1469', '郊区', '3', '1469', '172', null);
INSERT INTO `zn_area` VALUES ('147', '张家口', '2', '147', '9', null);
INSERT INTO `zn_area` VALUES ('1470', '向阳区', '3', '1470', '172', null);
INSERT INTO `zn_area` VALUES ('1471', '东风区', '3', '1471', '172', null);
INSERT INTO `zn_area` VALUES ('1472', '同江市', '3', '1472', '172', null);
INSERT INTO `zn_area` VALUES ('1473', '富锦市', '3', '1473', '172', null);
INSERT INTO `zn_area` VALUES ('1474', '桦南县', '3', '1474', '172', null);
INSERT INTO `zn_area` VALUES ('1475', '桦川县', '3', '1475', '172', null);
INSERT INTO `zn_area` VALUES ('1476', '汤原县', '3', '1476', '172', null);
INSERT INTO `zn_area` VALUES ('1477', '抚远县', '3', '1477', '172', null);
INSERT INTO `zn_area` VALUES ('1478', '爱民区', '3', '1478', '173', null);
INSERT INTO `zn_area` VALUES ('1479', '东安区', '3', '1479', '173', null);
INSERT INTO `zn_area` VALUES ('148', '郑州', '2', '148', '10', null);
INSERT INTO `zn_area` VALUES ('1480', '阳明区', '3', '1480', '173', null);
INSERT INTO `zn_area` VALUES ('1481', '西安区', '3', '1481', '173', null);
INSERT INTO `zn_area` VALUES ('1482', '绥芬河市', '3', '1482', '173', null);
INSERT INTO `zn_area` VALUES ('1483', '海林市', '3', '1483', '173', null);
INSERT INTO `zn_area` VALUES ('1484', '宁安市', '3', '1484', '173', null);
INSERT INTO `zn_area` VALUES ('1485', '穆棱市', '3', '1485', '173', null);
INSERT INTO `zn_area` VALUES ('1486', '东宁县', '3', '1486', '173', null);
INSERT INTO `zn_area` VALUES ('1487', '林口县', '3', '1487', '173', null);
INSERT INTO `zn_area` VALUES ('1488', '桃山区', '3', '1488', '174', null);
INSERT INTO `zn_area` VALUES ('1489', '新兴区', '3', '1489', '174', null);
INSERT INTO `zn_area` VALUES ('149', '洛阳', '2', '149', '10', null);
INSERT INTO `zn_area` VALUES ('1490', '茄子河区', '3', '1490', '174', null);
INSERT INTO `zn_area` VALUES ('1491', '勃利县', '3', '1491', '174', null);
INSERT INTO `zn_area` VALUES ('1492', '龙沙区', '3', '1492', '175', null);
INSERT INTO `zn_area` VALUES ('1493', '昂昂溪区', '3', '1493', '175', null);
INSERT INTO `zn_area` VALUES ('1494', '铁锋区', '3', '1494', '175', null);
INSERT INTO `zn_area` VALUES ('1495', '建华区', '3', '1495', '175', null);
INSERT INTO `zn_area` VALUES ('1496', '富拉尔基区', '3', '1496', '175', null);
INSERT INTO `zn_area` VALUES ('1497', '碾子山区', '3', '1497', '175', null);
INSERT INTO `zn_area` VALUES ('1498', '梅里斯达斡尔族区', '3', '1498', '175', null);
INSERT INTO `zn_area` VALUES ('1499', '讷河市', '3', '1499', '175', null);
INSERT INTO `zn_area` VALUES ('15', '江苏', '1', '15', '0', null);
INSERT INTO `zn_area` VALUES ('150', '开封', '2', '150', '10', null);
INSERT INTO `zn_area` VALUES ('1500', '龙江县', '3', '1500', '175', null);
INSERT INTO `zn_area` VALUES ('1501', '依安县', '3', '1501', '175', null);
INSERT INTO `zn_area` VALUES ('1502', '泰来县', '3', '1502', '175', null);
INSERT INTO `zn_area` VALUES ('1503', '甘南县', '3', '1503', '175', null);
INSERT INTO `zn_area` VALUES ('1504', '富裕县', '3', '1504', '175', null);
INSERT INTO `zn_area` VALUES ('1505', '克山县', '3', '1505', '175', null);
INSERT INTO `zn_area` VALUES ('1506', '克东县', '3', '1506', '175', null);
INSERT INTO `zn_area` VALUES ('1507', '拜泉县', '3', '1507', '175', null);
INSERT INTO `zn_area` VALUES ('1508', '尖山区', '3', '1508', '176', null);
INSERT INTO `zn_area` VALUES ('1509', '岭东区', '3', '1509', '176', null);
INSERT INTO `zn_area` VALUES ('151', '安阳', '2', '151', '10', null);
INSERT INTO `zn_area` VALUES ('1510', '四方台区', '3', '1510', '176', null);
INSERT INTO `zn_area` VALUES ('1511', '宝山区', '3', '1511', '176', null);
INSERT INTO `zn_area` VALUES ('1512', '集贤县', '3', '1512', '176', null);
INSERT INTO `zn_area` VALUES ('1513', '友谊县', '3', '1513', '176', null);
INSERT INTO `zn_area` VALUES ('1514', '宝清县', '3', '1514', '176', null);
INSERT INTO `zn_area` VALUES ('1515', '饶河县', '3', '1515', '176', null);
INSERT INTO `zn_area` VALUES ('1516', '北林区', '3', '1516', '177', null);
INSERT INTO `zn_area` VALUES ('1517', '安达市', '3', '1517', '177', null);
INSERT INTO `zn_area` VALUES ('1518', '肇东市', '3', '1518', '177', null);
INSERT INTO `zn_area` VALUES ('1519', '海伦市', '3', '1519', '177', null);
INSERT INTO `zn_area` VALUES ('152', '鹤壁', '2', '152', '10', null);
INSERT INTO `zn_area` VALUES ('1520', '望奎县', '3', '1520', '177', null);
INSERT INTO `zn_area` VALUES ('1521', '兰西县', '3', '1521', '177', null);
INSERT INTO `zn_area` VALUES ('1522', '青冈县', '3', '1522', '177', null);
INSERT INTO `zn_area` VALUES ('1523', '庆安县', '3', '1523', '177', null);
INSERT INTO `zn_area` VALUES ('1524', '明水县', '3', '1524', '177', null);
INSERT INTO `zn_area` VALUES ('1525', '绥棱县', '3', '1525', '177', null);
INSERT INTO `zn_area` VALUES ('1526', '伊春区', '3', '1526', '178', null);
INSERT INTO `zn_area` VALUES ('1527', '带岭区', '3', '1527', '178', null);
INSERT INTO `zn_area` VALUES ('1528', '南岔区', '3', '1528', '178', null);
INSERT INTO `zn_area` VALUES ('1529', '金山屯区', '3', '1529', '178', null);
INSERT INTO `zn_area` VALUES ('153', '济源', '2', '153', '10', null);
INSERT INTO `zn_area` VALUES ('1530', '西林区', '3', '1530', '178', null);
INSERT INTO `zn_area` VALUES ('1531', '美溪区', '3', '1531', '178', null);
INSERT INTO `zn_area` VALUES ('1532', '乌马河区', '3', '1532', '178', null);
INSERT INTO `zn_area` VALUES ('1533', '翠峦区', '3', '1533', '178', null);
INSERT INTO `zn_area` VALUES ('1534', '友好区', '3', '1534', '178', null);
INSERT INTO `zn_area` VALUES ('1535', '上甘岭区', '3', '1535', '178', null);
INSERT INTO `zn_area` VALUES ('1536', '五营区', '3', '1536', '178', null);
INSERT INTO `zn_area` VALUES ('1537', '红星区', '3', '1537', '178', null);
INSERT INTO `zn_area` VALUES ('1538', '新青区', '3', '1538', '178', null);
INSERT INTO `zn_area` VALUES ('1539', '汤旺河区', '3', '1539', '178', null);
INSERT INTO `zn_area` VALUES ('154', '焦作', '2', '154', '10', null);
INSERT INTO `zn_area` VALUES ('1540', '乌伊岭区', '3', '1540', '178', null);
INSERT INTO `zn_area` VALUES ('1541', '铁力市', '3', '1541', '178', null);
INSERT INTO `zn_area` VALUES ('1542', '嘉荫县', '3', '1542', '178', null);
INSERT INTO `zn_area` VALUES ('1543', '江岸区', '3', '1543', '179', null);
INSERT INTO `zn_area` VALUES ('1544', '武昌区', '3', '1544', '179', null);
INSERT INTO `zn_area` VALUES ('1545', '江汉区', '3', '1545', '179', null);
INSERT INTO `zn_area` VALUES ('1546', '硚口区', '3', '1546', '179', null);
INSERT INTO `zn_area` VALUES ('1547', '汉阳区', '3', '1547', '179', null);
INSERT INTO `zn_area` VALUES ('1548', '青山区', '3', '1548', '179', null);
INSERT INTO `zn_area` VALUES ('1549', '洪山区', '3', '1549', '179', null);
INSERT INTO `zn_area` VALUES ('155', '南阳', '2', '155', '10', null);
INSERT INTO `zn_area` VALUES ('1550', '东西湖区', '3', '1550', '179', null);
INSERT INTO `zn_area` VALUES ('1551', '汉南区', '3', '1551', '179', null);
INSERT INTO `zn_area` VALUES ('1552', '蔡甸区', '3', '1552', '179', null);
INSERT INTO `zn_area` VALUES ('1553', '江夏区', '3', '1553', '179', null);
INSERT INTO `zn_area` VALUES ('1554', '黄陂区', '3', '1554', '179', null);
INSERT INTO `zn_area` VALUES ('1555', '新洲区', '3', '1555', '179', null);
INSERT INTO `zn_area` VALUES ('1556', '经济开发区', '3', '1556', '179', null);
INSERT INTO `zn_area` VALUES ('1558', '鄂城区', '3', '1558', '181', null);
INSERT INTO `zn_area` VALUES ('1559', '华容区', '3', '1559', '181', null);
INSERT INTO `zn_area` VALUES ('156', '平顶山', '2', '156', '10', null);
INSERT INTO `zn_area` VALUES ('1560', '梁子湖区', '3', '1560', '181', null);
INSERT INTO `zn_area` VALUES ('1561', '黄州区', '3', '1561', '182', null);
INSERT INTO `zn_area` VALUES ('1562', '麻城市', '3', '1562', '182', null);
INSERT INTO `zn_area` VALUES ('1563', '武穴市', '3', '1563', '182', null);
INSERT INTO `zn_area` VALUES ('1564', '团风县', '3', '1564', '182', null);
INSERT INTO `zn_area` VALUES ('1565', '红安县', '3', '1565', '182', null);
INSERT INTO `zn_area` VALUES ('1566', '罗田县', '3', '1566', '182', null);
INSERT INTO `zn_area` VALUES ('1567', '英山县', '3', '1567', '182', null);
INSERT INTO `zn_area` VALUES ('1568', '浠水县', '3', '1568', '182', null);
INSERT INTO `zn_area` VALUES ('1569', '蕲春县', '3', '1569', '182', null);
INSERT INTO `zn_area` VALUES ('157', '三门峡', '2', '157', '10', null);
INSERT INTO `zn_area` VALUES ('1570', '黄梅县', '3', '1570', '182', null);
INSERT INTO `zn_area` VALUES ('1571', '黄石港区', '3', '1571', '183', null);
INSERT INTO `zn_area` VALUES ('1572', '西塞山区', '3', '1572', '183', null);
INSERT INTO `zn_area` VALUES ('1573', '下陆区', '3', '1573', '183', null);
INSERT INTO `zn_area` VALUES ('1574', '铁山区', '3', '1574', '183', null);
INSERT INTO `zn_area` VALUES ('1575', '大冶市', '3', '1575', '183', null);
INSERT INTO `zn_area` VALUES ('1576', '阳新县', '3', '1576', '183', null);
INSERT INTO `zn_area` VALUES ('1577', '东宝区', '3', '1577', '184', null);
INSERT INTO `zn_area` VALUES ('1578', '掇刀区', '3', '1578', '184', null);
INSERT INTO `zn_area` VALUES ('1579', '钟祥市', '3', '1579', '184', null);
INSERT INTO `zn_area` VALUES ('158', '商丘', '2', '158', '10', null);
INSERT INTO `zn_area` VALUES ('1580', '京山县', '3', '1580', '184', null);
INSERT INTO `zn_area` VALUES ('1581', '沙洋县', '3', '1581', '184', null);
INSERT INTO `zn_area` VALUES ('1582', '沙市区', '3', '1582', '185', null);
INSERT INTO `zn_area` VALUES ('1583', '荆州区', '3', '1583', '185', null);
INSERT INTO `zn_area` VALUES ('1584', '石首市', '3', '1584', '185', null);
INSERT INTO `zn_area` VALUES ('1585', '洪湖市', '3', '1585', '185', null);
INSERT INTO `zn_area` VALUES ('1586', '松滋市', '3', '1586', '185', null);
INSERT INTO `zn_area` VALUES ('1587', '公安县', '3', '1587', '185', null);
INSERT INTO `zn_area` VALUES ('1588', '监利县', '3', '1588', '185', null);
INSERT INTO `zn_area` VALUES ('1589', '江陵县', '3', '1589', '185', null);
INSERT INTO `zn_area` VALUES ('159', '新乡', '2', '159', '10', null);
INSERT INTO `zn_area` VALUES ('1590', '潜江市', '3', '1590', '186', null);
INSERT INTO `zn_area` VALUES ('1592', '张湾区', '3', '1592', '188', null);
INSERT INTO `zn_area` VALUES ('1593', '茅箭区', '3', '1593', '188', null);
INSERT INTO `zn_area` VALUES ('1594', '丹江口市', '3', '1594', '188', null);
INSERT INTO `zn_area` VALUES ('1595', '郧县', '3', '1595', '188', null);
INSERT INTO `zn_area` VALUES ('1596', '郧西县', '3', '1596', '188', null);
INSERT INTO `zn_area` VALUES ('1597', '竹山县', '3', '1597', '188', null);
INSERT INTO `zn_area` VALUES ('1598', '竹溪县', '3', '1598', '188', null);
INSERT INTO `zn_area` VALUES ('1599', '房县', '3', '1599', '188', null);
INSERT INTO `zn_area` VALUES ('16', '江西', '1', '16', '0', null);
INSERT INTO `zn_area` VALUES ('160', '信阳', '2', '160', '10', null);
INSERT INTO `zn_area` VALUES ('1600', '曾都区', '3', '1600', '189', null);
INSERT INTO `zn_area` VALUES ('1601', '广水市', '3', '1601', '189', null);
INSERT INTO `zn_area` VALUES ('1602', '天门市', '3', '1602', '190', null);
INSERT INTO `zn_area` VALUES ('1603', '咸安区', '3', '1603', '191', null);
INSERT INTO `zn_area` VALUES ('1604', '赤壁市', '3', '1604', '191', null);
INSERT INTO `zn_area` VALUES ('1605', '嘉鱼县', '3', '1605', '191', null);
INSERT INTO `zn_area` VALUES ('1606', '通城县', '3', '1606', '191', null);
INSERT INTO `zn_area` VALUES ('1607', '崇阳县', '3', '1607', '191', null);
INSERT INTO `zn_area` VALUES ('1608', '通山县', '3', '1608', '191', null);
INSERT INTO `zn_area` VALUES ('1609', '襄城区', '3', '1609', '192', null);
INSERT INTO `zn_area` VALUES ('161', '许昌', '2', '161', '10', null);
INSERT INTO `zn_area` VALUES ('1610', '樊城区', '3', '1610', '192', null);
INSERT INTO `zn_area` VALUES ('1611', '襄州区', '3', '1611', '192', null);
INSERT INTO `zn_area` VALUES ('1612', '老河口市', '3', '1612', '192', null);
INSERT INTO `zn_area` VALUES ('1613', '枣阳市', '3', '1613', '192', null);
INSERT INTO `zn_area` VALUES ('1614', '宜城市', '3', '1614', '192', null);
INSERT INTO `zn_area` VALUES ('1615', '南漳县', '3', '1615', '192', null);
INSERT INTO `zn_area` VALUES ('1616', '谷城县', '3', '1616', '192', null);
INSERT INTO `zn_area` VALUES ('1617', '保康县', '3', '1617', '192', null);
INSERT INTO `zn_area` VALUES ('1618', '孝南区', '3', '1618', '193', null);
INSERT INTO `zn_area` VALUES ('1619', '应城市', '3', '1619', '193', null);
INSERT INTO `zn_area` VALUES ('162', '周口', '2', '162', '10', null);
INSERT INTO `zn_area` VALUES ('1620', '安陆市', '3', '1620', '193', null);
INSERT INTO `zn_area` VALUES ('1621', '汉川市', '3', '1621', '193', null);
INSERT INTO `zn_area` VALUES ('1622', '孝昌县', '3', '1622', '193', null);
INSERT INTO `zn_area` VALUES ('1623', '大悟县', '3', '1623', '193', null);
INSERT INTO `zn_area` VALUES ('1624', '云梦县', '3', '1624', '193', null);
INSERT INTO `zn_area` VALUES ('1625', '长阳县', '3', '1625', '194', null);
INSERT INTO `zn_area` VALUES ('1626', '五峰县', '3', '1626', '194', null);
INSERT INTO `zn_area` VALUES ('1627', '西陵区', '3', '1627', '194', null);
INSERT INTO `zn_area` VALUES ('1628', '伍家岗区', '3', '1628', '194', null);
INSERT INTO `zn_area` VALUES ('1629', '点军区', '3', '1629', '194', null);
INSERT INTO `zn_area` VALUES ('163', '驻马店', '2', '163', '10', null);
INSERT INTO `zn_area` VALUES ('1630', '猇亭区', '3', '1630', '194', null);
INSERT INTO `zn_area` VALUES ('1631', '夷陵区', '3', '1631', '194', null);
INSERT INTO `zn_area` VALUES ('1632', '宜都市', '3', '1632', '194', null);
INSERT INTO `zn_area` VALUES ('1633', '当阳市', '3', '1633', '194', null);
INSERT INTO `zn_area` VALUES ('1634', '枝江市', '3', '1634', '194', null);
INSERT INTO `zn_area` VALUES ('1635', '远安县', '3', '1635', '194', null);
INSERT INTO `zn_area` VALUES ('1636', '兴山县', '3', '1636', '194', null);
INSERT INTO `zn_area` VALUES ('1637', '秭归县', '3', '1637', '194', null);
INSERT INTO `zn_area` VALUES ('1638', '恩施市', '3', '1638', '195', null);
INSERT INTO `zn_area` VALUES ('1639', '利川市', '3', '1639', '195', null);
INSERT INTO `zn_area` VALUES ('164', '漯河', '2', '164', '10', null);
INSERT INTO `zn_area` VALUES ('1640', '建始县', '3', '1640', '195', null);
INSERT INTO `zn_area` VALUES ('1641', '巴东县', '3', '1641', '195', null);
INSERT INTO `zn_area` VALUES ('1642', '宣恩县', '3', '1642', '195', null);
INSERT INTO `zn_area` VALUES ('1643', '咸丰县', '3', '1643', '195', null);
INSERT INTO `zn_area` VALUES ('1644', '来凤县', '3', '1644', '195', null);
INSERT INTO `zn_area` VALUES ('1645', '鹤峰县', '3', '1645', '195', null);
INSERT INTO `zn_area` VALUES ('1646', '岳麓区', '3', '1646', '196', null);
INSERT INTO `zn_area` VALUES ('1647', '芙蓉区', '3', '1647', '196', null);
INSERT INTO `zn_area` VALUES ('1648', '天心区', '3', '1648', '196', null);
INSERT INTO `zn_area` VALUES ('1649', '开福区', '3', '1649', '196', null);
INSERT INTO `zn_area` VALUES ('165', '濮阳', '2', '165', '10', null);
INSERT INTO `zn_area` VALUES ('1650', '雨花区', '3', '1650', '196', null);
INSERT INTO `zn_area` VALUES ('1651', '开发区', '3', '1651', '196', null);
INSERT INTO `zn_area` VALUES ('1652', '浏阳市', '3', '1652', '196', null);
INSERT INTO `zn_area` VALUES ('1653', '长沙县', '3', '1653', '196', null);
INSERT INTO `zn_area` VALUES ('1654', '望城县', '3', '1654', '196', null);
INSERT INTO `zn_area` VALUES ('1655', '宁乡县', '3', '1655', '196', null);
INSERT INTO `zn_area` VALUES ('1656', '永定区', '3', '1656', '197', null);
INSERT INTO `zn_area` VALUES ('1657', '武陵源区', '3', '1657', '197', null);
INSERT INTO `zn_area` VALUES ('1658', '慈利县', '3', '1658', '197', null);
INSERT INTO `zn_area` VALUES ('1659', '桑植县', '3', '1659', '197', null);
INSERT INTO `zn_area` VALUES ('166', '哈尔滨', '2', '166', '11', null);
INSERT INTO `zn_area` VALUES ('1660', '武陵区', '3', '1660', '198', null);
INSERT INTO `zn_area` VALUES ('1661', '鼎城区', '3', '1661', '198', null);
INSERT INTO `zn_area` VALUES ('1662', '津市市', '3', '1662', '198', null);
INSERT INTO `zn_area` VALUES ('1663', '安乡县', '3', '1663', '198', null);
INSERT INTO `zn_area` VALUES ('1664', '汉寿县', '3', '1664', '198', null);
INSERT INTO `zn_area` VALUES ('1665', '澧县', '3', '1665', '198', null);
INSERT INTO `zn_area` VALUES ('1666', '临澧县', '3', '1666', '198', null);
INSERT INTO `zn_area` VALUES ('1667', '桃源县', '3', '1667', '198', null);
INSERT INTO `zn_area` VALUES ('1668', '石门县', '3', '1668', '198', null);
INSERT INTO `zn_area` VALUES ('1669', '北湖区', '3', '1669', '199', null);
INSERT INTO `zn_area` VALUES ('167', '大庆', '2', '167', '11', null);
INSERT INTO `zn_area` VALUES ('1670', '苏仙区', '3', '1670', '199', null);
INSERT INTO `zn_area` VALUES ('1671', '资兴市', '3', '1671', '199', null);
INSERT INTO `zn_area` VALUES ('1672', '桂阳县', '3', '1672', '199', null);
INSERT INTO `zn_area` VALUES ('1673', '宜章县', '3', '1673', '199', null);
INSERT INTO `zn_area` VALUES ('1674', '永兴县', '3', '1674', '199', null);
INSERT INTO `zn_area` VALUES ('1675', '嘉禾县', '3', '1675', '199', null);
INSERT INTO `zn_area` VALUES ('1676', '临武县', '3', '1676', '199', null);
INSERT INTO `zn_area` VALUES ('1677', '汝城县', '3', '1677', '199', null);
INSERT INTO `zn_area` VALUES ('1678', '桂东县', '3', '1678', '199', null);
INSERT INTO `zn_area` VALUES ('1679', '安仁县', '3', '1679', '199', null);
INSERT INTO `zn_area` VALUES ('168', '大兴安岭', '2', '168', '11', null);
INSERT INTO `zn_area` VALUES ('1680', '雁峰区', '3', '1680', '200', null);
INSERT INTO `zn_area` VALUES ('1681', '珠晖区', '3', '1681', '200', null);
INSERT INTO `zn_area` VALUES ('1682', '石鼓区', '3', '1682', '200', null);
INSERT INTO `zn_area` VALUES ('1683', '蒸湘区', '3', '1683', '200', null);
INSERT INTO `zn_area` VALUES ('1684', '南岳区', '3', '1684', '200', null);
INSERT INTO `zn_area` VALUES ('1685', '耒阳市', '3', '1685', '200', null);
INSERT INTO `zn_area` VALUES ('1686', '常宁市', '3', '1686', '200', null);
INSERT INTO `zn_area` VALUES ('1687', '衡阳县', '3', '1687', '200', null);
INSERT INTO `zn_area` VALUES ('1688', '衡南县', '3', '1688', '200', null);
INSERT INTO `zn_area` VALUES ('1689', '衡山县', '3', '1689', '200', null);
INSERT INTO `zn_area` VALUES ('169', '鹤岗', '2', '169', '11', null);
INSERT INTO `zn_area` VALUES ('1690', '衡东县', '3', '1690', '200', null);
INSERT INTO `zn_area` VALUES ('1691', '祁东县', '3', '1691', '200', null);
INSERT INTO `zn_area` VALUES ('1692', '鹤城区', '3', '1692', '201', null);
INSERT INTO `zn_area` VALUES ('1693', '靖州县', '3', '1693', '201', null);
INSERT INTO `zn_area` VALUES ('1694', '麻阳县', '3', '1694', '201', null);
INSERT INTO `zn_area` VALUES ('1695', '通道县', '3', '1695', '201', null);
INSERT INTO `zn_area` VALUES ('1696', '新晃县', '3', '1696', '201', null);
INSERT INTO `zn_area` VALUES ('1697', '芷江县', '3', '1697', '201', null);
INSERT INTO `zn_area` VALUES ('1698', '沅陵县', '3', '1698', '201', null);
INSERT INTO `zn_area` VALUES ('1699', '辰溪县', '3', '1699', '201', null);
INSERT INTO `zn_area` VALUES ('17', '辽宁', '1', '17', '0', null);
INSERT INTO `zn_area` VALUES ('170', '黑河', '2', '170', '11', null);
INSERT INTO `zn_area` VALUES ('1700', '溆浦县', '3', '1700', '201', null);
INSERT INTO `zn_area` VALUES ('1701', '中方县', '3', '1701', '201', null);
INSERT INTO `zn_area` VALUES ('1702', '会同县', '3', '1702', '201', null);
INSERT INTO `zn_area` VALUES ('1703', '洪江市', '3', '1703', '201', null);
INSERT INTO `zn_area` VALUES ('1704', '娄星区', '3', '1704', '202', null);
INSERT INTO `zn_area` VALUES ('1705', '冷水江市', '3', '1705', '202', null);
INSERT INTO `zn_area` VALUES ('1706', '涟源市', '3', '1706', '202', null);
INSERT INTO `zn_area` VALUES ('1707', '双峰县', '3', '1707', '202', null);
INSERT INTO `zn_area` VALUES ('1708', '新化县', '3', '1708', '202', null);
INSERT INTO `zn_area` VALUES ('1709', '城步县', '3', '1709', '203', null);
INSERT INTO `zn_area` VALUES ('171', '鸡西', '2', '171', '11', null);
INSERT INTO `zn_area` VALUES ('1710', '双清区', '3', '1710', '203', null);
INSERT INTO `zn_area` VALUES ('1711', '大祥区', '3', '1711', '203', null);
INSERT INTO `zn_area` VALUES ('1712', '北塔区', '3', '1712', '203', null);
INSERT INTO `zn_area` VALUES ('1713', '武冈市', '3', '1713', '203', null);
INSERT INTO `zn_area` VALUES ('1714', '邵东县', '3', '1714', '203', null);
INSERT INTO `zn_area` VALUES ('1715', '新邵县', '3', '1715', '203', null);
INSERT INTO `zn_area` VALUES ('1716', '邵阳县', '3', '1716', '203', null);
INSERT INTO `zn_area` VALUES ('1717', '隆回县', '3', '1717', '203', null);
INSERT INTO `zn_area` VALUES ('1718', '洞口县', '3', '1718', '203', null);
INSERT INTO `zn_area` VALUES ('1719', '绥宁县', '3', '1719', '203', null);
INSERT INTO `zn_area` VALUES ('172', '佳木斯', '2', '172', '11', null);
INSERT INTO `zn_area` VALUES ('1720', '新宁县', '3', '1720', '203', null);
INSERT INTO `zn_area` VALUES ('1721', '岳塘区', '3', '1721', '204', null);
INSERT INTO `zn_area` VALUES ('1722', '雨湖区', '3', '1722', '204', null);
INSERT INTO `zn_area` VALUES ('1723', '湘乡市', '3', '1723', '204', null);
INSERT INTO `zn_area` VALUES ('1724', '韶山市', '3', '1724', '204', null);
INSERT INTO `zn_area` VALUES ('1725', '湘潭县', '3', '1725', '204', null);
INSERT INTO `zn_area` VALUES ('1726', '吉首市', '3', '1726', '205', null);
INSERT INTO `zn_area` VALUES ('1727', '泸溪县', '3', '1727', '205', null);
INSERT INTO `zn_area` VALUES ('1728', '凤凰县', '3', '1728', '205', null);
INSERT INTO `zn_area` VALUES ('1729', '花垣县', '3', '1729', '205', null);
INSERT INTO `zn_area` VALUES ('173', '牡丹江', '2', '173', '11', null);
INSERT INTO `zn_area` VALUES ('1730', '保靖县', '3', '1730', '205', null);
INSERT INTO `zn_area` VALUES ('1731', '古丈县', '3', '1731', '205', null);
INSERT INTO `zn_area` VALUES ('1732', '永顺县', '3', '1732', '205', null);
INSERT INTO `zn_area` VALUES ('1733', '龙山县', '3', '1733', '205', null);
INSERT INTO `zn_area` VALUES ('1734', '赫山区', '3', '1734', '206', null);
INSERT INTO `zn_area` VALUES ('1735', '资阳区', '3', '1735', '206', null);
INSERT INTO `zn_area` VALUES ('1736', '沅江市', '3', '1736', '206', null);
INSERT INTO `zn_area` VALUES ('1737', '南县', '3', '1737', '206', null);
INSERT INTO `zn_area` VALUES ('1738', '桃江县', '3', '1738', '206', null);
INSERT INTO `zn_area` VALUES ('1739', '安化县', '3', '1739', '206', null);
INSERT INTO `zn_area` VALUES ('174', '七台河', '2', '174', '11', null);
INSERT INTO `zn_area` VALUES ('1740', '江华县', '3', '1740', '207', null);
INSERT INTO `zn_area` VALUES ('1741', '冷水滩区', '3', '1741', '207', null);
INSERT INTO `zn_area` VALUES ('1742', '零陵区', '3', '1742', '207', null);
INSERT INTO `zn_area` VALUES ('1743', '祁阳县', '3', '1743', '207', null);
INSERT INTO `zn_area` VALUES ('1744', '东安县', '3', '1744', '207', null);
INSERT INTO `zn_area` VALUES ('1745', '双牌县', '3', '1745', '207', null);
INSERT INTO `zn_area` VALUES ('1746', '道县', '3', '1746', '207', null);
INSERT INTO `zn_area` VALUES ('1747', '江永县', '3', '1747', '207', null);
INSERT INTO `zn_area` VALUES ('1748', '宁远县', '3', '1748', '207', null);
INSERT INTO `zn_area` VALUES ('1749', '蓝山县', '3', '1749', '207', null);
INSERT INTO `zn_area` VALUES ('175', '齐齐哈尔', '2', '175', '11', null);
INSERT INTO `zn_area` VALUES ('1750', '新田县', '3', '1750', '207', null);
INSERT INTO `zn_area` VALUES ('1751', '岳阳楼区', '3', '1751', '208', null);
INSERT INTO `zn_area` VALUES ('1752', '君山区', '3', '1752', '208', null);
INSERT INTO `zn_area` VALUES ('1753', '云溪区', '3', '1753', '208', null);
INSERT INTO `zn_area` VALUES ('1754', '汨罗市', '3', '1754', '208', null);
INSERT INTO `zn_area` VALUES ('1755', '临湘市', '3', '1755', '208', null);
INSERT INTO `zn_area` VALUES ('1756', '岳阳县', '3', '1756', '208', null);
INSERT INTO `zn_area` VALUES ('1757', '华容县', '3', '1757', '208', null);
INSERT INTO `zn_area` VALUES ('1758', '湘阴县', '3', '1758', '208', null);
INSERT INTO `zn_area` VALUES ('1759', '平江县', '3', '1759', '208', null);
INSERT INTO `zn_area` VALUES ('176', '双鸭山', '2', '176', '11', null);
INSERT INTO `zn_area` VALUES ('1760', '天元区', '3', '1760', '209', null);
INSERT INTO `zn_area` VALUES ('1761', '荷塘区', '3', '1761', '209', null);
INSERT INTO `zn_area` VALUES ('1762', '芦淞区', '3', '1762', '209', null);
INSERT INTO `zn_area` VALUES ('1763', '石峰区', '3', '1763', '209', null);
INSERT INTO `zn_area` VALUES ('1764', '醴陵市', '3', '1764', '209', null);
INSERT INTO `zn_area` VALUES ('1765', '株洲县', '3', '1765', '209', null);
INSERT INTO `zn_area` VALUES ('1766', '攸县', '3', '1766', '209', null);
INSERT INTO `zn_area` VALUES ('1767', '茶陵县', '3', '1767', '209', null);
INSERT INTO `zn_area` VALUES ('1768', '炎陵县', '3', '1768', '209', null);
INSERT INTO `zn_area` VALUES ('1769', '朝阳区', '3', '1769', '210', null);
INSERT INTO `zn_area` VALUES ('177', '绥化', '2', '177', '11', null);
INSERT INTO `zn_area` VALUES ('1770', '宽城区', '3', '1770', '210', null);
INSERT INTO `zn_area` VALUES ('1771', '二道区', '3', '1771', '210', null);
INSERT INTO `zn_area` VALUES ('1772', '南关区', '3', '1772', '210', null);
INSERT INTO `zn_area` VALUES ('1773', '绿园区', '3', '1773', '210', null);
INSERT INTO `zn_area` VALUES ('1774', '双阳区', '3', '1774', '210', null);
INSERT INTO `zn_area` VALUES ('1775', '净月潭开发区', '3', '1775', '210', null);
INSERT INTO `zn_area` VALUES ('1776', '高新技术开发区', '3', '1776', '210', null);
INSERT INTO `zn_area` VALUES ('1777', '经济技术开发区', '3', '1777', '210', null);
INSERT INTO `zn_area` VALUES ('1778', '汽车产业开发区', '3', '1778', '210', null);
INSERT INTO `zn_area` VALUES ('1779', '德惠市', '3', '1779', '210', null);
INSERT INTO `zn_area` VALUES ('178', '伊春', '2', '178', '11', null);
INSERT INTO `zn_area` VALUES ('1780', '九台市', '3', '1780', '210', null);
INSERT INTO `zn_area` VALUES ('1781', '榆树市', '3', '1781', '210', null);
INSERT INTO `zn_area` VALUES ('1782', '农安县', '3', '1782', '210', null);
INSERT INTO `zn_area` VALUES ('1783', '船营区', '3', '1783', '211', null);
INSERT INTO `zn_area` VALUES ('1784', '昌邑区', '3', '1784', '211', null);
INSERT INTO `zn_area` VALUES ('1785', '龙潭区', '3', '1785', '211', null);
INSERT INTO `zn_area` VALUES ('1786', '丰满区', '3', '1786', '211', null);
INSERT INTO `zn_area` VALUES ('1787', '蛟河市', '3', '1787', '211', null);
INSERT INTO `zn_area` VALUES ('1788', '桦甸市', '3', '1788', '211', null);
INSERT INTO `zn_area` VALUES ('1789', '舒兰市', '3', '1789', '211', null);
INSERT INTO `zn_area` VALUES ('179', '武汉', '2', '179', '12', null);
INSERT INTO `zn_area` VALUES ('1790', '磐石市', '3', '1790', '211', null);
INSERT INTO `zn_area` VALUES ('1791', '永吉县', '3', '1791', '211', null);
INSERT INTO `zn_area` VALUES ('1792', '洮北区', '3', '1792', '212', null);
INSERT INTO `zn_area` VALUES ('1793', '洮南市', '3', '1793', '212', null);
INSERT INTO `zn_area` VALUES ('1794', '大安市', '3', '1794', '212', null);
INSERT INTO `zn_area` VALUES ('1795', '镇赉县', '3', '1795', '212', null);
INSERT INTO `zn_area` VALUES ('1796', '通榆县', '3', '1796', '212', null);
INSERT INTO `zn_area` VALUES ('1797', '江源区', '3', '1797', '213', null);
INSERT INTO `zn_area` VALUES ('1798', '八道江区', '3', '1798', '213', null);
INSERT INTO `zn_area` VALUES ('1799', '长白县', '3', '1799', '213', null);
INSERT INTO `zn_area` VALUES ('18', '内蒙古', '1', '18', '0', null);
INSERT INTO `zn_area` VALUES ('180', '仙桃', '2', '180', '12', null);
INSERT INTO `zn_area` VALUES ('1800', '临江市', '3', '1800', '213', null);
INSERT INTO `zn_area` VALUES ('1801', '抚松县', '3', '1801', '213', null);
INSERT INTO `zn_area` VALUES ('1802', '靖宇县', '3', '1802', '213', null);
INSERT INTO `zn_area` VALUES ('1803', '龙山区', '3', '1803', '214', null);
INSERT INTO `zn_area` VALUES ('1804', '西安区', '3', '1804', '214', null);
INSERT INTO `zn_area` VALUES ('1805', '东丰县', '3', '1805', '214', null);
INSERT INTO `zn_area` VALUES ('1806', '东辽县', '3', '1806', '214', null);
INSERT INTO `zn_area` VALUES ('1807', '铁西区', '3', '1807', '215', null);
INSERT INTO `zn_area` VALUES ('1808', '铁东区', '3', '1808', '215', null);
INSERT INTO `zn_area` VALUES ('1809', '伊通县', '3', '1809', '215', null);
INSERT INTO `zn_area` VALUES ('181', '鄂州', '2', '181', '12', null);
INSERT INTO `zn_area` VALUES ('1810', '公主岭市', '3', '1810', '215', null);
INSERT INTO `zn_area` VALUES ('1811', '双辽市', '3', '1811', '215', null);
INSERT INTO `zn_area` VALUES ('1812', '梨树县', '3', '1812', '215', null);
INSERT INTO `zn_area` VALUES ('1813', '前郭尔罗斯', '3', '1813', '216', null);
INSERT INTO `zn_area` VALUES ('1814', '宁江区', '3', '1814', '216', null);
INSERT INTO `zn_area` VALUES ('1815', '长岭县', '3', '1815', '216', null);
INSERT INTO `zn_area` VALUES ('1816', '乾安县', '3', '1816', '216', null);
INSERT INTO `zn_area` VALUES ('1817', '扶余市', '3', '1817', '216', null);
INSERT INTO `zn_area` VALUES ('1818', '东昌区', '3', '1818', '217', null);
INSERT INTO `zn_area` VALUES ('1819', '二道江区', '3', '1819', '217', null);
INSERT INTO `zn_area` VALUES ('182', '黄冈', '2', '182', '12', null);
INSERT INTO `zn_area` VALUES ('1820', '梅河口市', '3', '1820', '217', null);
INSERT INTO `zn_area` VALUES ('1821', '集安市', '3', '1821', '217', null);
INSERT INTO `zn_area` VALUES ('1822', '通化县', '3', '1822', '217', null);
INSERT INTO `zn_area` VALUES ('1823', '辉南县', '3', '1823', '217', null);
INSERT INTO `zn_area` VALUES ('1824', '柳河县', '3', '1824', '217', null);
INSERT INTO `zn_area` VALUES ('1825', '延吉市', '3', '1825', '218', null);
INSERT INTO `zn_area` VALUES ('1826', '图们市', '3', '1826', '218', null);
INSERT INTO `zn_area` VALUES ('1827', '敦化市', '3', '1827', '218', null);
INSERT INTO `zn_area` VALUES ('1828', '珲春市', '3', '1828', '218', null);
INSERT INTO `zn_area` VALUES ('1829', '龙井市', '3', '1829', '218', null);
INSERT INTO `zn_area` VALUES ('183', '黄石', '2', '183', '12', null);
INSERT INTO `zn_area` VALUES ('1830', '和龙市', '3', '1830', '218', null);
INSERT INTO `zn_area` VALUES ('1831', '安图县', '3', '1831', '218', null);
INSERT INTO `zn_area` VALUES ('1832', '汪清县', '3', '1832', '218', null);
INSERT INTO `zn_area` VALUES ('1833', '玄武区', '3', '1833', '219', null);
INSERT INTO `zn_area` VALUES ('1834', '鼓楼区', '3', '1834', '219', null);
INSERT INTO `zn_area` VALUES ('1835', '白下区', '3', '1835', '219', null);
INSERT INTO `zn_area` VALUES ('1836', '建邺区', '3', '1836', '219', null);
INSERT INTO `zn_area` VALUES ('1837', '秦淮区', '3', '1837', '219', null);
INSERT INTO `zn_area` VALUES ('1838', '雨花台区', '3', '1838', '219', null);
INSERT INTO `zn_area` VALUES ('1839', '下关区', '3', '1839', '219', null);
INSERT INTO `zn_area` VALUES ('184', '荆门', '2', '184', '12', null);
INSERT INTO `zn_area` VALUES ('1840', '栖霞区', '3', '1840', '219', null);
INSERT INTO `zn_area` VALUES ('1841', '浦口区', '3', '1841', '219', null);
INSERT INTO `zn_area` VALUES ('1842', '江宁区', '3', '1842', '219', null);
INSERT INTO `zn_area` VALUES ('1843', '六合区', '3', '1843', '219', null);
INSERT INTO `zn_area` VALUES ('1844', '溧水区', '3', '1844', '219', null);
INSERT INTO `zn_area` VALUES ('1845', '高淳县', '3', '1845', '219', null);
INSERT INTO `zn_area` VALUES ('1846', '姑苏区', '3', '1846', '220', null);
INSERT INTO `zn_area` VALUES ('1849', '虎丘区', '3', '1849', '220', null);
INSERT INTO `zn_area` VALUES ('185', '荆州', '2', '185', '12', null);
INSERT INTO `zn_area` VALUES ('1850', '吴中区', '3', '1850', '220', null);
INSERT INTO `zn_area` VALUES ('1851', '相城区', '3', '1851', '220', null);
INSERT INTO `zn_area` VALUES ('1852', '苏州工业园区', '3', '1852', '220', null);
INSERT INTO `zn_area` VALUES ('1853', '昆山市', '3', '1853', '220', null);
INSERT INTO `zn_area` VALUES ('1854', '常熟市', '3', '1854', '220', null);
INSERT INTO `zn_area` VALUES ('1855', '张家港市', '3', '1855', '220', null);
INSERT INTO `zn_area` VALUES ('1856', '塔城市', '3', '1856', '365', null);
INSERT INTO `zn_area` VALUES ('186', '潜江', '2', '186', '12', null);
INSERT INTO `zn_area` VALUES ('1867', '吴江区', '3', '1867', '220', null);
INSERT INTO `zn_area` VALUES ('1868', '太仓市', '3', '1868', '220', null);
INSERT INTO `zn_area` VALUES ('1869', '崇安区', '3', '1869', '221', null);
INSERT INTO `zn_area` VALUES ('187', '神农架林区', '2', '187', '12', null);
INSERT INTO `zn_area` VALUES ('1870', '北塘区', '3', '1870', '221', null);
INSERT INTO `zn_area` VALUES ('1871', '南长区', '3', '1871', '221', null);
INSERT INTO `zn_area` VALUES ('1872', '锡山区', '3', '1872', '221', null);
INSERT INTO `zn_area` VALUES ('1873', '惠山区', '3', '1873', '221', null);
INSERT INTO `zn_area` VALUES ('1874', '滨湖区', '3', '1874', '221', null);
INSERT INTO `zn_area` VALUES ('1875', '新区', '3', '1875', '221', null);
INSERT INTO `zn_area` VALUES ('1876', '江阴市', '3', '1876', '221', null);
INSERT INTO `zn_area` VALUES ('1877', '宜兴市', '3', '1877', '221', null);
INSERT INTO `zn_area` VALUES ('1878', '天宁区', '3', '1878', '222', null);
INSERT INTO `zn_area` VALUES ('1879', '钟楼区', '3', '1879', '222', null);
INSERT INTO `zn_area` VALUES ('188', '十堰', '2', '188', '12', null);
INSERT INTO `zn_area` VALUES ('1880', '戚墅堰区', '3', '1880', '222', null);
INSERT INTO `zn_area` VALUES ('1881', '郊区', '3', '1881', '222', null);
INSERT INTO `zn_area` VALUES ('1882', '新北区', '3', '1882', '222', null);
INSERT INTO `zn_area` VALUES ('1883', '武进区', '3', '1883', '222', null);
INSERT INTO `zn_area` VALUES ('1884', '溧阳市', '3', '1884', '222', null);
INSERT INTO `zn_area` VALUES ('1885', '金坛区', '3', '1885', '222', null);
INSERT INTO `zn_area` VALUES ('1886', '清河区', '3', '1886', '223', null);
INSERT INTO `zn_area` VALUES ('1887', '清浦区', '3', '1887', '223', null);
INSERT INTO `zn_area` VALUES ('1888', '楚州区', '3', '1888', '223', null);
INSERT INTO `zn_area` VALUES ('1889', '淮阴区', '3', '1889', '223', null);
INSERT INTO `zn_area` VALUES ('189', '随州', '2', '189', '12', null);
INSERT INTO `zn_area` VALUES ('1890', '涟水县', '3', '1890', '223', null);
INSERT INTO `zn_area` VALUES ('1891', '洪泽县', '3', '1891', '223', null);
INSERT INTO `zn_area` VALUES ('1892', '盱眙县', '3', '1892', '223', null);
INSERT INTO `zn_area` VALUES ('1893', '金湖县', '3', '1893', '223', null);
INSERT INTO `zn_area` VALUES ('1894', '新浦区', '3', '1894', '224', null);
INSERT INTO `zn_area` VALUES ('1895', '连云区', '3', '1895', '224', null);
INSERT INTO `zn_area` VALUES ('1896', '海州区', '3', '1896', '224', null);
INSERT INTO `zn_area` VALUES ('1897', '赣榆县', '3', '1897', '224', null);
INSERT INTO `zn_area` VALUES ('1898', '东海县', '3', '1898', '224', null);
INSERT INTO `zn_area` VALUES ('1899', '灌云县', '3', '1899', '224', null);
INSERT INTO `zn_area` VALUES ('19', '宁夏', '1', '19', '0', null);
INSERT INTO `zn_area` VALUES ('190', '天门', '2', '190', '12', null);
INSERT INTO `zn_area` VALUES ('1900', '灌南县', '3', '1900', '224', null);
INSERT INTO `zn_area` VALUES ('1901', '崇川区', '3', '1901', '225', null);
INSERT INTO `zn_area` VALUES ('1902', '港闸区', '3', '1902', '225', null);
INSERT INTO `zn_area` VALUES ('1903', '经济开发区', '3', '1903', '225', null);
INSERT INTO `zn_area` VALUES ('1904', '启东市', '3', '1904', '225', null);
INSERT INTO `zn_area` VALUES ('1905', '如皋市', '3', '1905', '225', null);
INSERT INTO `zn_area` VALUES ('1906', '通州区', '3', '1906', '225', null);
INSERT INTO `zn_area` VALUES ('1907', '海门市', '3', '1907', '225', null);
INSERT INTO `zn_area` VALUES ('1908', '海安县', '3', '1908', '225', null);
INSERT INTO `zn_area` VALUES ('1909', '如东县', '3', '1909', '225', null);
INSERT INTO `zn_area` VALUES ('191', '咸宁', '2', '191', '12', null);
INSERT INTO `zn_area` VALUES ('1910', '宿城区', '3', '1910', '226', null);
INSERT INTO `zn_area` VALUES ('1911', '宿豫区', '3', '1911', '226', null);
INSERT INTO `zn_area` VALUES ('1912', '宿豫县', '3', '1912', '226', null);
INSERT INTO `zn_area` VALUES ('1913', '沭阳县', '3', '1913', '226', null);
INSERT INTO `zn_area` VALUES ('1914', '泗阳县', '3', '1914', '226', null);
INSERT INTO `zn_area` VALUES ('1915', '泗洪县', '3', '1915', '226', null);
INSERT INTO `zn_area` VALUES ('1916', '海陵区', '3', '1916', '227', null);
INSERT INTO `zn_area` VALUES ('1917', '高港区', '3', '1917', '227', null);
INSERT INTO `zn_area` VALUES ('1918', '兴化市', '3', '1918', '227', null);
INSERT INTO `zn_area` VALUES ('1919', '靖江市', '3', '1919', '227', null);
INSERT INTO `zn_area` VALUES ('192', '襄阳', '2', '192', '12', null);
INSERT INTO `zn_area` VALUES ('1920', '泰兴市', '3', '1920', '227', null);
INSERT INTO `zn_area` VALUES ('1921', '姜堰区', '3', '1921', '227', null);
INSERT INTO `zn_area` VALUES ('1922', '云龙区', '3', '1922', '228', null);
INSERT INTO `zn_area` VALUES ('1923', '鼓楼区', '3', '1923', '228', null);
INSERT INTO `zn_area` VALUES ('1924', '九里区', '3', '1924', '228', null);
INSERT INTO `zn_area` VALUES ('1925', '贾汪区', '3', '1925', '228', null);
INSERT INTO `zn_area` VALUES ('1926', '泉山区', '3', '1926', '228', null);
INSERT INTO `zn_area` VALUES ('1927', '新沂市', '3', '1927', '228', null);
INSERT INTO `zn_area` VALUES ('1928', '邳州市', '3', '1928', '228', null);
INSERT INTO `zn_area` VALUES ('1929', '丰县', '3', '1929', '228', null);
INSERT INTO `zn_area` VALUES ('193', '孝感', '2', '193', '12', null);
INSERT INTO `zn_area` VALUES ('1930', '沛县', '3', '1930', '228', null);
INSERT INTO `zn_area` VALUES ('1931', '铜山区', '3', '1931', '228', null);
INSERT INTO `zn_area` VALUES ('1932', '睢宁县', '3', '1932', '228', null);
INSERT INTO `zn_area` VALUES ('1933', '城区', '3', '1933', '229', null);
INSERT INTO `zn_area` VALUES ('1934', '亭湖区', '3', '1934', '229', null);
INSERT INTO `zn_area` VALUES ('1935', '盐都区', '3', '1935', '229', null);
INSERT INTO `zn_area` VALUES ('1937', '东台市', '3', '1937', '229', null);
INSERT INTO `zn_area` VALUES ('1938', '大丰区', '3', '1938', '229', null);
INSERT INTO `zn_area` VALUES ('1939', '响水县', '3', '1939', '229', null);
INSERT INTO `zn_area` VALUES ('194', '宜昌', '2', '194', '12', null);
INSERT INTO `zn_area` VALUES ('1940', '滨海县', '3', '1940', '229', null);
INSERT INTO `zn_area` VALUES ('1941', '阜宁县', '3', '1941', '229', null);
INSERT INTO `zn_area` VALUES ('1942', '射阳县', '3', '1942', '229', null);
INSERT INTO `zn_area` VALUES ('1943', '建湖县', '3', '1943', '229', null);
INSERT INTO `zn_area` VALUES ('1944', '广陵区', '3', '1944', '230', null);
INSERT INTO `zn_area` VALUES ('1945', '维扬区', '3', '1945', '230', null);
INSERT INTO `zn_area` VALUES ('1946', '邗江区', '3', '1946', '230', null);
INSERT INTO `zn_area` VALUES ('1947', '仪征市', '3', '1947', '230', null);
INSERT INTO `zn_area` VALUES ('1948', '高邮市', '3', '1948', '230', null);
INSERT INTO `zn_area` VALUES ('1949', '江都市', '3', '1949', '230', null);
INSERT INTO `zn_area` VALUES ('195', '恩施', '2', '195', '12', null);
INSERT INTO `zn_area` VALUES ('1950', '宝应县', '3', '1950', '230', null);
INSERT INTO `zn_area` VALUES ('1951', '京口区', '3', '1951', '231', null);
INSERT INTO `zn_area` VALUES ('1952', '润州区', '3', '1952', '231', null);
INSERT INTO `zn_area` VALUES ('1953', '丹徒区', '3', '1953', '231', null);
INSERT INTO `zn_area` VALUES ('1954', '丹阳市', '3', '1954', '231', null);
INSERT INTO `zn_area` VALUES ('1955', '扬中市', '3', '1955', '231', null);
INSERT INTO `zn_area` VALUES ('1956', '句容市', '3', '1956', '231', null);
INSERT INTO `zn_area` VALUES ('1957', '东湖区', '3', '1957', '232', null);
INSERT INTO `zn_area` VALUES ('1958', '西湖区', '3', '1958', '232', null);
INSERT INTO `zn_area` VALUES ('1959', '青云谱区', '3', '1959', '232', null);
INSERT INTO `zn_area` VALUES ('196', '长沙', '2', '196', '13', null);
INSERT INTO `zn_area` VALUES ('1960', '湾里区', '3', '1960', '232', null);
INSERT INTO `zn_area` VALUES ('1961', '青山湖区', '3', '1961', '232', null);
INSERT INTO `zn_area` VALUES ('1962', '红谷滩新区', '3', '1962', '232', null);
INSERT INTO `zn_area` VALUES ('1963', '昌北区', '3', '1963', '232', null);
INSERT INTO `zn_area` VALUES ('1964', '高新区', '3', '1964', '232', null);
INSERT INTO `zn_area` VALUES ('1965', '南昌县', '3', '1965', '232', null);
INSERT INTO `zn_area` VALUES ('1966', '新建县', '3', '1966', '232', null);
INSERT INTO `zn_area` VALUES ('1967', '安义县', '3', '1967', '232', null);
INSERT INTO `zn_area` VALUES ('1968', '进贤县', '3', '1968', '232', null);
INSERT INTO `zn_area` VALUES ('1969', '临川区', '3', '1969', '233', null);
INSERT INTO `zn_area` VALUES ('197', '张家界', '2', '197', '13', null);
INSERT INTO `zn_area` VALUES ('1970', '南城县', '3', '1970', '233', null);
INSERT INTO `zn_area` VALUES ('1971', '黎川县', '3', '1971', '233', null);
INSERT INTO `zn_area` VALUES ('1972', '南丰县', '3', '1972', '233', null);
INSERT INTO `zn_area` VALUES ('1973', '崇仁县', '3', '1973', '233', null);
INSERT INTO `zn_area` VALUES ('1974', '乐安县', '3', '1974', '233', null);
INSERT INTO `zn_area` VALUES ('1975', '宜黄县', '3', '1975', '233', null);
INSERT INTO `zn_area` VALUES ('1976', '金溪县', '3', '1976', '233', null);
INSERT INTO `zn_area` VALUES ('1977', '资溪县', '3', '1977', '233', null);
INSERT INTO `zn_area` VALUES ('1978', '东乡县', '3', '1978', '233', null);
INSERT INTO `zn_area` VALUES ('1979', '广昌县', '3', '1979', '233', null);
INSERT INTO `zn_area` VALUES ('198', '常德', '2', '198', '13', null);
INSERT INTO `zn_area` VALUES ('1980', '章贡区', '3', '1980', '234', null);
INSERT INTO `zn_area` VALUES ('1981', '于都县', '3', '1981', '234', null);
INSERT INTO `zn_area` VALUES ('1982', '瑞金市', '3', '1982', '234', null);
INSERT INTO `zn_area` VALUES ('1983', '南康市', '3', '1983', '234', null);
INSERT INTO `zn_area` VALUES ('1984', '赣县', '3', '1984', '234', null);
INSERT INTO `zn_area` VALUES ('1985', '信丰县', '3', '1985', '234', null);
INSERT INTO `zn_area` VALUES ('1986', '大余县', '3', '1986', '234', null);
INSERT INTO `zn_area` VALUES ('1987', '上犹县', '3', '1987', '234', null);
INSERT INTO `zn_area` VALUES ('1988', '崇义县', '3', '1988', '234', null);
INSERT INTO `zn_area` VALUES ('1989', '安远县', '3', '1989', '234', null);
INSERT INTO `zn_area` VALUES ('199', '郴州', '2', '199', '13', null);
INSERT INTO `zn_area` VALUES ('1990', '龙南县', '3', '1990', '234', null);
INSERT INTO `zn_area` VALUES ('1991', '定南县', '3', '1991', '234', null);
INSERT INTO `zn_area` VALUES ('1992', '全南县', '3', '1992', '234', null);
INSERT INTO `zn_area` VALUES ('1993', '宁都县', '3', '1993', '234', null);
INSERT INTO `zn_area` VALUES ('1994', '兴国县', '3', '1994', '234', null);
INSERT INTO `zn_area` VALUES ('1995', '会昌县', '3', '1995', '234', null);
INSERT INTO `zn_area` VALUES ('1996', '寻乌县', '3', '1996', '234', null);
INSERT INTO `zn_area` VALUES ('1997', '石城县', '3', '1997', '234', null);
INSERT INTO `zn_area` VALUES ('1998', '安福县', '3', '1998', '235', null);
INSERT INTO `zn_area` VALUES ('1999', '吉州区', '3', '1999', '235', null);
INSERT INTO `zn_area` VALUES ('2', '安徽', '1', '2', '0', null);
INSERT INTO `zn_area` VALUES ('20', '青海', '1', '20', '0', null);
INSERT INTO `zn_area` VALUES ('200', '衡阳', '2', '200', '13', null);
INSERT INTO `zn_area` VALUES ('2000', '青原区', '3', '2000', '235', null);
INSERT INTO `zn_area` VALUES ('2001', '井冈山市', '3', '2001', '235', null);
INSERT INTO `zn_area` VALUES ('2002', '吉安县', '3', '2002', '235', null);
INSERT INTO `zn_area` VALUES ('2003', '吉水县', '3', '2003', '235', null);
INSERT INTO `zn_area` VALUES ('2004', '峡江县', '3', '2004', '235', null);
INSERT INTO `zn_area` VALUES ('2005', '新干县', '3', '2005', '235', null);
INSERT INTO `zn_area` VALUES ('2006', '永丰县', '3', '2006', '235', null);
INSERT INTO `zn_area` VALUES ('2007', '泰和县', '3', '2007', '235', null);
INSERT INTO `zn_area` VALUES ('2008', '遂川县', '3', '2008', '235', null);
INSERT INTO `zn_area` VALUES ('2009', '万安县', '3', '2009', '235', null);
INSERT INTO `zn_area` VALUES ('201', '怀化', '2', '201', '13', null);
INSERT INTO `zn_area` VALUES ('2010', '永新县', '3', '2010', '235', null);
INSERT INTO `zn_area` VALUES ('2011', '珠山区', '3', '2011', '236', null);
INSERT INTO `zn_area` VALUES ('2012', '昌江区', '3', '2012', '236', null);
INSERT INTO `zn_area` VALUES ('2013', '乐平市', '3', '2013', '236', null);
INSERT INTO `zn_area` VALUES ('2014', '浮梁县', '3', '2014', '236', null);
INSERT INTO `zn_area` VALUES ('2015', '浔阳区', '3', '2015', '237', null);
INSERT INTO `zn_area` VALUES ('2016', '庐山区', '3', '2016', '237', null);
INSERT INTO `zn_area` VALUES ('2017', '瑞昌市', '3', '2017', '237', null);
INSERT INTO `zn_area` VALUES ('2018', '九江县', '3', '2018', '237', null);
INSERT INTO `zn_area` VALUES ('2019', '武宁县', '3', '2019', '237', null);
INSERT INTO `zn_area` VALUES ('202', '娄底', '2', '202', '13', null);
INSERT INTO `zn_area` VALUES ('2020', '修水县', '3', '2020', '237', null);
INSERT INTO `zn_area` VALUES ('2021', '永修县', '3', '2021', '237', null);
INSERT INTO `zn_area` VALUES ('2022', '德安县', '3', '2022', '237', null);
INSERT INTO `zn_area` VALUES ('2023', '星子县', '3', '2023', '237', null);
INSERT INTO `zn_area` VALUES ('2024', '都昌县', '3', '2024', '237', null);
INSERT INTO `zn_area` VALUES ('2025', '湖口县', '3', '2025', '237', null);
INSERT INTO `zn_area` VALUES ('2026', '彭泽县', '3', '2026', '237', null);
INSERT INTO `zn_area` VALUES ('2027', '安源区', '3', '2027', '238', null);
INSERT INTO `zn_area` VALUES ('2028', '湘东区', '3', '2028', '238', null);
INSERT INTO `zn_area` VALUES ('2029', '莲花县', '3', '2029', '238', null);
INSERT INTO `zn_area` VALUES ('203', '邵阳', '2', '203', '13', null);
INSERT INTO `zn_area` VALUES ('2030', '芦溪县', '3', '2030', '238', null);
INSERT INTO `zn_area` VALUES ('2031', '上栗县', '3', '2031', '238', null);
INSERT INTO `zn_area` VALUES ('2032', '信州区', '3', '2032', '239', null);
INSERT INTO `zn_area` VALUES ('2033', '德兴市', '3', '2033', '239', null);
INSERT INTO `zn_area` VALUES ('2034', '上饶县', '3', '2034', '239', null);
INSERT INTO `zn_area` VALUES ('2035', '广丰县', '3', '2035', '239', null);
INSERT INTO `zn_area` VALUES ('2036', '玉山县', '3', '2036', '239', null);
INSERT INTO `zn_area` VALUES ('2037', '铅山县', '3', '2037', '239', null);
INSERT INTO `zn_area` VALUES ('2038', '横峰县', '3', '2038', '239', null);
INSERT INTO `zn_area` VALUES ('2039', '弋阳县', '3', '2039', '239', null);
INSERT INTO `zn_area` VALUES ('204', '湘潭', '2', '204', '13', null);
INSERT INTO `zn_area` VALUES ('2040', '余干县', '3', '2040', '239', null);
INSERT INTO `zn_area` VALUES ('2041', '鄱阳县', '3', '2041', '239', null);
INSERT INTO `zn_area` VALUES ('2042', '万年县', '3', '2042', '239', null);
INSERT INTO `zn_area` VALUES ('2043', '婺源县', '3', '2043', '239', null);
INSERT INTO `zn_area` VALUES ('2044', '渝水区', '3', '2044', '240', null);
INSERT INTO `zn_area` VALUES ('2045', '分宜县', '3', '2045', '240', null);
INSERT INTO `zn_area` VALUES ('2046', '袁州区', '3', '2046', '241', null);
INSERT INTO `zn_area` VALUES ('2047', '丰城市', '3', '2047', '241', null);
INSERT INTO `zn_area` VALUES ('2048', '樟树市', '3', '2048', '241', null);
INSERT INTO `zn_area` VALUES ('2049', '高安市', '3', '2049', '241', null);
INSERT INTO `zn_area` VALUES ('205', '湘西', '2', '205', '13', null);
INSERT INTO `zn_area` VALUES ('2050', '奉新县', '3', '2050', '241', null);
INSERT INTO `zn_area` VALUES ('2051', '万载县', '3', '2051', '241', null);
INSERT INTO `zn_area` VALUES ('2052', '上高县', '3', '2052', '241', null);
INSERT INTO `zn_area` VALUES ('2053', '宜丰县', '3', '2053', '241', null);
INSERT INTO `zn_area` VALUES ('2054', '靖安县', '3', '2054', '241', null);
INSERT INTO `zn_area` VALUES ('2055', '铜鼓县', '3', '2055', '241', null);
INSERT INTO `zn_area` VALUES ('2056', '月湖区', '3', '2056', '242', null);
INSERT INTO `zn_area` VALUES ('2057', '贵溪市', '3', '2057', '242', null);
INSERT INTO `zn_area` VALUES ('2058', '余江县', '3', '2058', '242', null);
INSERT INTO `zn_area` VALUES ('2059', '沈河区', '3', '2059', '243', null);
INSERT INTO `zn_area` VALUES ('206', '益阳', '2', '206', '13', null);
INSERT INTO `zn_area` VALUES ('2060', '皇姑区', '3', '2060', '243', null);
INSERT INTO `zn_area` VALUES ('2061', '和平区', '3', '2061', '243', null);
INSERT INTO `zn_area` VALUES ('2062', '大东区', '3', '2062', '243', null);
INSERT INTO `zn_area` VALUES ('2063', '铁西区', '3', '2063', '243', null);
INSERT INTO `zn_area` VALUES ('2064', '苏家屯区', '3', '2064', '243', null);
INSERT INTO `zn_area` VALUES ('2065', '东陵区', '3', '2065', '243', null);
INSERT INTO `zn_area` VALUES ('2066', '沈北新区', '3', '2066', '243', null);
INSERT INTO `zn_area` VALUES ('2067', '于洪区', '3', '2067', '243', null);
INSERT INTO `zn_area` VALUES ('2068', '浑南新区', '3', '2068', '243', null);
INSERT INTO `zn_area` VALUES ('2069', '新民市', '3', '2069', '243', null);
INSERT INTO `zn_area` VALUES ('207', '永州', '2', '207', '13', null);
INSERT INTO `zn_area` VALUES ('2070', '辽中县', '3', '2070', '243', null);
INSERT INTO `zn_area` VALUES ('2071', '康平县', '3', '2071', '243', null);
INSERT INTO `zn_area` VALUES ('2072', '法库县', '3', '2072', '243', null);
INSERT INTO `zn_area` VALUES ('2073', '西岗区', '3', '2073', '244', null);
INSERT INTO `zn_area` VALUES ('2074', '中山区', '3', '2074', '244', null);
INSERT INTO `zn_area` VALUES ('2075', '沙河口区', '3', '2075', '244', null);
INSERT INTO `zn_area` VALUES ('2076', '甘井子区', '3', '2076', '244', null);
INSERT INTO `zn_area` VALUES ('2077', '旅顺口区', '3', '2077', '244', null);
INSERT INTO `zn_area` VALUES ('2078', '金州区', '3', '2078', '244', null);
INSERT INTO `zn_area` VALUES ('2079', '开发区', '3', '2079', '244', null);
INSERT INTO `zn_area` VALUES ('208', '岳阳', '2', '208', '13', null);
INSERT INTO `zn_area` VALUES ('2080', '瓦房店市', '3', '2080', '244', null);
INSERT INTO `zn_area` VALUES ('2081', '普兰店市', '3', '2081', '244', null);
INSERT INTO `zn_area` VALUES ('2082', '庄河市', '3', '2082', '244', null);
INSERT INTO `zn_area` VALUES ('2083', '长海县', '3', '2083', '244', null);
INSERT INTO `zn_area` VALUES ('2084', '铁东区', '3', '2084', '245', null);
INSERT INTO `zn_area` VALUES ('2085', '铁西区', '3', '2085', '245', null);
INSERT INTO `zn_area` VALUES ('2086', '立山区', '3', '2086', '245', null);
INSERT INTO `zn_area` VALUES ('2087', '千山区', '3', '2087', '245', null);
INSERT INTO `zn_area` VALUES ('2088', '岫岩县', '3', '2088', '245', null);
INSERT INTO `zn_area` VALUES ('2089', '海城市', '3', '2089', '245', null);
INSERT INTO `zn_area` VALUES ('209', '株洲', '2', '209', '13', null);
INSERT INTO `zn_area` VALUES ('2090', '台安县', '3', '2090', '245', null);
INSERT INTO `zn_area` VALUES ('2091', '本溪县', '3', '2091', '246', null);
INSERT INTO `zn_area` VALUES ('2092', '平山区', '3', '2092', '246', null);
INSERT INTO `zn_area` VALUES ('2093', '明山区', '3', '2093', '246', null);
INSERT INTO `zn_area` VALUES ('2094', '溪湖区', '3', '2094', '246', null);
INSERT INTO `zn_area` VALUES ('2095', '南芬区', '3', '2095', '246', null);
INSERT INTO `zn_area` VALUES ('2096', '桓仁县', '3', '2096', '246', null);
INSERT INTO `zn_area` VALUES ('2097', '双塔区', '3', '2097', '247', null);
INSERT INTO `zn_area` VALUES ('2098', '龙城区', '3', '2098', '247', null);
INSERT INTO `zn_area` VALUES ('2099', '喀喇沁左翼蒙古族自治县', '3', '2099', '247', null);
INSERT INTO `zn_area` VALUES ('21', '山东', '1', '21', '0', null);
INSERT INTO `zn_area` VALUES ('210', '长春', '2', '210', '14', null);
INSERT INTO `zn_area` VALUES ('2100', '北票市', '3', '2100', '247', null);
INSERT INTO `zn_area` VALUES ('2101', '凌源市', '3', '2101', '247', null);
INSERT INTO `zn_area` VALUES ('2102', '朝阳县', '3', '2102', '247', null);
INSERT INTO `zn_area` VALUES ('2103', '建平县', '3', '2103', '247', null);
INSERT INTO `zn_area` VALUES ('2104', '振兴区', '3', '2104', '248', null);
INSERT INTO `zn_area` VALUES ('2105', '元宝区', '3', '2105', '248', null);
INSERT INTO `zn_area` VALUES ('2106', '振安区', '3', '2106', '248', null);
INSERT INTO `zn_area` VALUES ('2107', '宽甸县', '3', '2107', '248', null);
INSERT INTO `zn_area` VALUES ('2108', '东港市', '3', '2108', '248', null);
INSERT INTO `zn_area` VALUES ('2109', '凤城市', '3', '2109', '248', null);
INSERT INTO `zn_area` VALUES ('211', '吉林市', '2', '211', '14', null);
INSERT INTO `zn_area` VALUES ('2110', '顺城区', '3', '2110', '249', null);
INSERT INTO `zn_area` VALUES ('2111', '新抚区', '3', '2111', '249', null);
INSERT INTO `zn_area` VALUES ('2112', '东洲区', '3', '2112', '249', null);
INSERT INTO `zn_area` VALUES ('2113', '望花区', '3', '2113', '249', null);
INSERT INTO `zn_area` VALUES ('2114', '清原县', '3', '2114', '249', null);
INSERT INTO `zn_area` VALUES ('2115', '新宾县', '3', '2115', '249', null);
INSERT INTO `zn_area` VALUES ('2116', '抚顺县', '3', '2116', '249', null);
INSERT INTO `zn_area` VALUES ('2117', '市辖区', '3', '2117', '250', null);
INSERT INTO `zn_area` VALUES ('2118', '海州区', '3', '2118', '250', null);
INSERT INTO `zn_area` VALUES ('2119', '新邱区', '3', '2119', '250', null);
INSERT INTO `zn_area` VALUES ('212', '白城', '2', '212', '14', null);
INSERT INTO `zn_area` VALUES ('2120', '太平区', '3', '2120', '250', null);
INSERT INTO `zn_area` VALUES ('2121', '清河门区', '3', '2121', '250', null);
INSERT INTO `zn_area` VALUES ('2122', '细河区', '3', '2122', '250', null);
INSERT INTO `zn_area` VALUES ('2123', '彰武县', '3', '2123', '250', null);
INSERT INTO `zn_area` VALUES ('2124', '龙港区', '3', '2124', '251', null);
INSERT INTO `zn_area` VALUES ('2125', '南票区', '3', '2125', '251', null);
INSERT INTO `zn_area` VALUES ('2126', '连山区', '3', '2126', '251', null);
INSERT INTO `zn_area` VALUES ('2127', '兴城市', '3', '2127', '251', null);
INSERT INTO `zn_area` VALUES ('2128', '绥中县', '3', '2128', '251', null);
INSERT INTO `zn_area` VALUES ('2129', '建昌县', '3', '2129', '251', null);
INSERT INTO `zn_area` VALUES ('213', '白山', '2', '213', '14', null);
INSERT INTO `zn_area` VALUES ('2130', '太和区', '3', '2130', '252', null);
INSERT INTO `zn_area` VALUES ('2131', '古塔区', '3', '2131', '252', null);
INSERT INTO `zn_area` VALUES ('2132', '凌河区', '3', '2132', '252', null);
INSERT INTO `zn_area` VALUES ('2133', '凌海市', '3', '2133', '252', null);
INSERT INTO `zn_area` VALUES ('2134', '北镇市', '3', '2134', '252', null);
INSERT INTO `zn_area` VALUES ('2135', '黑山县', '3', '2135', '252', null);
INSERT INTO `zn_area` VALUES ('2136', '义县', '3', '2136', '252', null);
INSERT INTO `zn_area` VALUES ('2137', '白塔区', '3', '2137', '253', null);
INSERT INTO `zn_area` VALUES ('2138', '文圣区', '3', '2138', '253', null);
INSERT INTO `zn_area` VALUES ('2139', '宏伟区', '3', '2139', '253', null);
INSERT INTO `zn_area` VALUES ('214', '辽源', '2', '214', '14', null);
INSERT INTO `zn_area` VALUES ('2140', '太子河区', '3', '2140', '253', null);
INSERT INTO `zn_area` VALUES ('2141', '弓长岭区', '3', '2141', '253', null);
INSERT INTO `zn_area` VALUES ('2142', '灯塔市', '3', '2142', '253', null);
INSERT INTO `zn_area` VALUES ('2143', '辽阳县', '3', '2143', '253', null);
INSERT INTO `zn_area` VALUES ('2144', '双台子区', '3', '2144', '254', null);
INSERT INTO `zn_area` VALUES ('2145', '兴隆台区', '3', '2145', '254', null);
INSERT INTO `zn_area` VALUES ('2146', '大洼县', '3', '2146', '254', null);
INSERT INTO `zn_area` VALUES ('2147', '盘山县', '3', '2147', '254', null);
INSERT INTO `zn_area` VALUES ('2148', '银州区', '3', '2148', '255', null);
INSERT INTO `zn_area` VALUES ('2149', '清河区', '3', '2149', '255', null);
INSERT INTO `zn_area` VALUES ('215', '四平', '2', '215', '14', null);
INSERT INTO `zn_area` VALUES ('2150', '调兵山市', '3', '2150', '255', null);
INSERT INTO `zn_area` VALUES ('2151', '开原市', '3', '2151', '255', null);
INSERT INTO `zn_area` VALUES ('2152', '铁岭县', '3', '2152', '255', null);
INSERT INTO `zn_area` VALUES ('2153', '西丰县', '3', '2153', '255', null);
INSERT INTO `zn_area` VALUES ('2154', '昌图县', '3', '2154', '255', null);
INSERT INTO `zn_area` VALUES ('2155', '站前区', '3', '2155', '256', null);
INSERT INTO `zn_area` VALUES ('2156', '西市区', '3', '2156', '256', null);
INSERT INTO `zn_area` VALUES ('2157', '鲅鱼圈区', '3', '2157', '256', null);
INSERT INTO `zn_area` VALUES ('2158', '老边区', '3', '2158', '256', null);
INSERT INTO `zn_area` VALUES ('2159', '盖州市', '3', '2159', '256', null);
INSERT INTO `zn_area` VALUES ('216', '松原', '2', '216', '14', null);
INSERT INTO `zn_area` VALUES ('2160', '大石桥市', '3', '2160', '256', null);
INSERT INTO `zn_area` VALUES ('2161', '回民区', '3', '2161', '257', null);
INSERT INTO `zn_area` VALUES ('2162', '玉泉区', '3', '2162', '257', null);
INSERT INTO `zn_area` VALUES ('2163', '新城区', '3', '2163', '257', null);
INSERT INTO `zn_area` VALUES ('2164', '赛罕区', '3', '2164', '257', null);
INSERT INTO `zn_area` VALUES ('2165', '清水河县', '3', '2165', '257', null);
INSERT INTO `zn_area` VALUES ('2166', '土默特左旗', '3', '2166', '257', null);
INSERT INTO `zn_area` VALUES ('2167', '托克托县', '3', '2167', '257', null);
INSERT INTO `zn_area` VALUES ('2168', '和林格尔县', '3', '2168', '257', null);
INSERT INTO `zn_area` VALUES ('2169', '武川县', '3', '2169', '257', null);
INSERT INTO `zn_area` VALUES ('217', '通化', '2', '217', '14', null);
INSERT INTO `zn_area` VALUES ('2170', '阿拉善左旗', '3', '2170', '258', null);
INSERT INTO `zn_area` VALUES ('2171', '阿拉善右旗', '3', '2171', '258', null);
INSERT INTO `zn_area` VALUES ('2172', '额济纳旗', '3', '2172', '258', null);
INSERT INTO `zn_area` VALUES ('2173', '临河区', '3', '2173', '259', null);
INSERT INTO `zn_area` VALUES ('2174', '五原县', '3', '2174', '259', null);
INSERT INTO `zn_area` VALUES ('2175', '磴口县', '3', '2175', '259', null);
INSERT INTO `zn_area` VALUES ('2176', '乌拉特前旗', '3', '2176', '259', null);
INSERT INTO `zn_area` VALUES ('2177', '乌拉特中旗', '3', '2177', '259', null);
INSERT INTO `zn_area` VALUES ('2178', '乌拉特后旗', '3', '2178', '259', null);
INSERT INTO `zn_area` VALUES ('2179', '杭锦后旗', '3', '2179', '259', null);
INSERT INTO `zn_area` VALUES ('218', '延边', '2', '218', '14', null);
INSERT INTO `zn_area` VALUES ('2180', '昆都仑区', '3', '2180', '260', null);
INSERT INTO `zn_area` VALUES ('2181', '青山区', '3', '2181', '260', null);
INSERT INTO `zn_area` VALUES ('2182', '东河区', '3', '2182', '260', null);
INSERT INTO `zn_area` VALUES ('2183', '九原区', '3', '2183', '260', null);
INSERT INTO `zn_area` VALUES ('2184', '石拐区', '3', '2184', '260', null);
INSERT INTO `zn_area` VALUES ('2185', '白云鄂博', '3', '2185', '260', null);
INSERT INTO `zn_area` VALUES ('2186', '土默特右旗', '3', '2186', '260', null);
INSERT INTO `zn_area` VALUES ('2187', '固阳县', '3', '2187', '260', null);
INSERT INTO `zn_area` VALUES ('2188', '达尔罕茂明安联合旗', '3', '2188', '260', null);
INSERT INTO `zn_area` VALUES ('2189', '红山区', '3', '2189', '261', null);
INSERT INTO `zn_area` VALUES ('219', '南京', '2', '219', '15', null);
INSERT INTO `zn_area` VALUES ('2190', '元宝山区', '3', '2190', '261', null);
INSERT INTO `zn_area` VALUES ('2191', '松山区', '3', '2191', '261', null);
INSERT INTO `zn_area` VALUES ('2192', '阿鲁科尔沁旗', '3', '2192', '261', null);
INSERT INTO `zn_area` VALUES ('2193', '巴林左旗', '3', '2193', '261', null);
INSERT INTO `zn_area` VALUES ('2194', '巴林右旗', '3', '2194', '261', null);
INSERT INTO `zn_area` VALUES ('2195', '林西县', '3', '2195', '261', null);
INSERT INTO `zn_area` VALUES ('2196', '克什克腾旗', '3', '2196', '261', null);
INSERT INTO `zn_area` VALUES ('2197', '翁牛特旗', '3', '2197', '261', null);
INSERT INTO `zn_area` VALUES ('2198', '喀喇沁旗', '3', '2198', '261', null);
INSERT INTO `zn_area` VALUES ('2199', '宁城县', '3', '2199', '261', null);
INSERT INTO `zn_area` VALUES ('22', '山西', '1', '22', '0', null);
INSERT INTO `zn_area` VALUES ('220', '苏州', '2', '220', '15', null);
INSERT INTO `zn_area` VALUES ('2200', '敖汉旗', '3', '2200', '261', null);
INSERT INTO `zn_area` VALUES ('2201', '东胜区', '3', '2201', '262', null);
INSERT INTO `zn_area` VALUES ('2202', '达拉特旗', '3', '2202', '262', null);
INSERT INTO `zn_area` VALUES ('2203', '准格尔旗', '3', '2203', '262', null);
INSERT INTO `zn_area` VALUES ('2204', '鄂托克前旗', '3', '2204', '262', null);
INSERT INTO `zn_area` VALUES ('2205', '鄂托克旗', '3', '2205', '262', null);
INSERT INTO `zn_area` VALUES ('2206', '杭锦旗', '3', '2206', '262', null);
INSERT INTO `zn_area` VALUES ('2207', '乌审旗', '3', '2207', '262', null);
INSERT INTO `zn_area` VALUES ('2208', '伊金霍洛旗', '3', '2208', '262', null);
INSERT INTO `zn_area` VALUES ('2209', '海拉尔区', '3', '2209', '263', null);
INSERT INTO `zn_area` VALUES ('221', '无锡', '2', '221', '15', null);
INSERT INTO `zn_area` VALUES ('2210', '莫力达瓦', '3', '2210', '263', null);
INSERT INTO `zn_area` VALUES ('2211', '满洲里市', '3', '2211', '263', null);
INSERT INTO `zn_area` VALUES ('2212', '牙克石市', '3', '2212', '263', null);
INSERT INTO `zn_area` VALUES ('2213', '扎兰屯市', '3', '2213', '263', null);
INSERT INTO `zn_area` VALUES ('2214', '额尔古纳市', '3', '2214', '263', null);
INSERT INTO `zn_area` VALUES ('2215', '根河市', '3', '2215', '263', null);
INSERT INTO `zn_area` VALUES ('2216', '阿荣旗', '3', '2216', '263', null);
INSERT INTO `zn_area` VALUES ('2217', '鄂伦春自治旗', '3', '2217', '263', null);
INSERT INTO `zn_area` VALUES ('2218', '鄂温克族自治旗', '3', '2218', '263', null);
INSERT INTO `zn_area` VALUES ('2219', '陈巴尔虎旗', '3', '2219', '263', null);
INSERT INTO `zn_area` VALUES ('222', '常州', '2', '222', '15', null);
INSERT INTO `zn_area` VALUES ('2220', '新巴尔虎左旗', '3', '2220', '263', null);
INSERT INTO `zn_area` VALUES ('2221', '新巴尔虎右旗', '3', '2221', '263', null);
INSERT INTO `zn_area` VALUES ('2222', '科尔沁区', '3', '2222', '264', null);
INSERT INTO `zn_area` VALUES ('2223', '霍林郭勒市', '3', '2223', '264', null);
INSERT INTO `zn_area` VALUES ('2224', '科尔沁左翼中旗', '3', '2224', '264', null);
INSERT INTO `zn_area` VALUES ('2225', '科尔沁左翼后旗', '3', '2225', '264', null);
INSERT INTO `zn_area` VALUES ('2226', '开鲁县', '3', '2226', '264', null);
INSERT INTO `zn_area` VALUES ('2227', '库伦旗', '3', '2227', '264', null);
INSERT INTO `zn_area` VALUES ('2228', '奈曼旗', '3', '2228', '264', null);
INSERT INTO `zn_area` VALUES ('2229', '扎鲁特旗', '3', '2229', '264', null);
INSERT INTO `zn_area` VALUES ('223', '淮安', '2', '223', '15', null);
INSERT INTO `zn_area` VALUES ('2230', '海勃湾区', '3', '2230', '265', null);
INSERT INTO `zn_area` VALUES ('2231', '乌达区', '3', '2231', '265', null);
INSERT INTO `zn_area` VALUES ('2232', '海南区', '3', '2232', '265', null);
INSERT INTO `zn_area` VALUES ('2233', '化德县', '3', '2233', '266', null);
INSERT INTO `zn_area` VALUES ('2234', '集宁区', '3', '2234', '266', null);
INSERT INTO `zn_area` VALUES ('2235', '丰镇市', '3', '2235', '266', null);
INSERT INTO `zn_area` VALUES ('2236', '卓资县', '3', '2236', '266', null);
INSERT INTO `zn_area` VALUES ('2237', '商都县', '3', '2237', '266', null);
INSERT INTO `zn_area` VALUES ('2238', '兴和县', '3', '2238', '266', null);
INSERT INTO `zn_area` VALUES ('2239', '凉城县', '3', '2239', '266', null);
INSERT INTO `zn_area` VALUES ('224', '连云港', '2', '224', '15', null);
INSERT INTO `zn_area` VALUES ('2240', '察哈尔右翼前旗', '3', '2240', '266', null);
INSERT INTO `zn_area` VALUES ('2241', '察哈尔右翼中旗', '3', '2241', '266', null);
INSERT INTO `zn_area` VALUES ('2242', '察哈尔右翼后旗', '3', '2242', '266', null);
INSERT INTO `zn_area` VALUES ('2243', '四子王旗', '3', '2243', '266', null);
INSERT INTO `zn_area` VALUES ('2244', '二连浩特市', '3', '2244', '267', null);
INSERT INTO `zn_area` VALUES ('2245', '锡林浩特市', '3', '2245', '267', null);
INSERT INTO `zn_area` VALUES ('2246', '阿巴嘎旗', '3', '2246', '267', null);
INSERT INTO `zn_area` VALUES ('2247', '苏尼特左旗', '3', '2247', '267', null);
INSERT INTO `zn_area` VALUES ('2248', '苏尼特右旗', '3', '2248', '267', null);
INSERT INTO `zn_area` VALUES ('2249', '东乌珠穆沁旗', '3', '2249', '267', null);
INSERT INTO `zn_area` VALUES ('225', '南通', '2', '225', '15', null);
INSERT INTO `zn_area` VALUES ('2250', '西乌珠穆沁旗', '3', '2250', '267', null);
INSERT INTO `zn_area` VALUES ('2251', '太仆寺旗', '3', '2251', '267', null);
INSERT INTO `zn_area` VALUES ('2252', '镶黄旗', '3', '2252', '267', null);
INSERT INTO `zn_area` VALUES ('2253', '正镶白旗', '3', '2253', '267', null);
INSERT INTO `zn_area` VALUES ('2254', '正蓝旗', '3', '2254', '267', null);
INSERT INTO `zn_area` VALUES ('2255', '多伦县', '3', '2255', '267', null);
INSERT INTO `zn_area` VALUES ('2256', '乌兰浩特市', '3', '2256', '268', null);
INSERT INTO `zn_area` VALUES ('2257', '阿尔山市', '3', '2257', '268', null);
INSERT INTO `zn_area` VALUES ('2258', '科尔沁右翼前旗', '3', '2258', '268', null);
INSERT INTO `zn_area` VALUES ('2259', '科尔沁右翼中旗', '3', '2259', '268', null);
INSERT INTO `zn_area` VALUES ('226', '宿迁', '2', '226', '15', null);
INSERT INTO `zn_area` VALUES ('2260', '扎赉特旗', '3', '2260', '268', null);
INSERT INTO `zn_area` VALUES ('2261', '突泉县', '3', '2261', '268', null);
INSERT INTO `zn_area` VALUES ('2262', '西夏区', '3', '2262', '269', null);
INSERT INTO `zn_area` VALUES ('2263', '金凤区', '3', '2263', '269', null);
INSERT INTO `zn_area` VALUES ('2264', '兴庆区', '3', '2264', '269', null);
INSERT INTO `zn_area` VALUES ('2265', '灵武市', '3', '2265', '269', null);
INSERT INTO `zn_area` VALUES ('2266', '永宁县', '3', '2266', '269', null);
INSERT INTO `zn_area` VALUES ('2267', '贺兰县', '3', '2267', '269', null);
INSERT INTO `zn_area` VALUES ('2268', '原州区', '3', '2268', '270', null);
INSERT INTO `zn_area` VALUES ('227', '泰州', '2', '227', '15', null);
INSERT INTO `zn_area` VALUES ('2270', '西吉县', '3', '2270', '270', null);
INSERT INTO `zn_area` VALUES ('2271', '隆德县', '3', '2271', '270', null);
INSERT INTO `zn_area` VALUES ('2272', '泾源县', '3', '2272', '270', null);
INSERT INTO `zn_area` VALUES ('2273', '彭阳县', '3', '2273', '270', null);
INSERT INTO `zn_area` VALUES ('2274', '惠农区', '3', '2274', '271', null);
INSERT INTO `zn_area` VALUES ('2275', '大武口区', '3', '2275', '271', null);
INSERT INTO `zn_area` VALUES ('2276', '惠农区', '3', '2276', '271', null);
INSERT INTO `zn_area` VALUES ('2277', '陶乐县', '3', '2277', '271', null);
INSERT INTO `zn_area` VALUES ('2278', '平罗县', '3', '2278', '271', null);
INSERT INTO `zn_area` VALUES ('2279', '利通区', '3', '2279', '272', null);
INSERT INTO `zn_area` VALUES ('228', '徐州', '2', '228', '15', null);
INSERT INTO `zn_area` VALUES ('2281', '青铜峡市', '3', '2281', '272', null);
INSERT INTO `zn_area` VALUES ('2283', '盐池县', '3', '2283', '272', null);
INSERT INTO `zn_area` VALUES ('2284', '同心县', '3', '2284', '272', null);
INSERT INTO `zn_area` VALUES ('2285', '沙坡头区', '3', '2285', '273', null);
INSERT INTO `zn_area` VALUES ('2286', '海原县', '3', '2286', '273', null);
INSERT INTO `zn_area` VALUES ('2287', '中宁县', '3', '2287', '273', null);
INSERT INTO `zn_area` VALUES ('2288', '城中区', '3', '2288', '274', null);
INSERT INTO `zn_area` VALUES ('2289', '城东区', '3', '2289', '274', null);
INSERT INTO `zn_area` VALUES ('229', '盐城', '2', '229', '15', null);
INSERT INTO `zn_area` VALUES ('2290', '城西区', '3', '2290', '274', null);
INSERT INTO `zn_area` VALUES ('2291', '城北区', '3', '2291', '274', null);
INSERT INTO `zn_area` VALUES ('2292', '湟中县', '3', '2292', '274', null);
INSERT INTO `zn_area` VALUES ('2293', '湟源县', '3', '2293', '274', null);
INSERT INTO `zn_area` VALUES ('2294', '大通县', '3', '2294', '274', null);
INSERT INTO `zn_area` VALUES ('2295', '玛沁县', '3', '2295', '275', null);
INSERT INTO `zn_area` VALUES ('2296', '班玛县', '3', '2296', '275', null);
INSERT INTO `zn_area` VALUES ('2297', '甘德县', '3', '2297', '275', null);
INSERT INTO `zn_area` VALUES ('2298', '达日县', '3', '2298', '275', null);
INSERT INTO `zn_area` VALUES ('2299', '久治县', '3', '2299', '275', null);
INSERT INTO `zn_area` VALUES ('23', '陕西', '1', '23', '0', null);
INSERT INTO `zn_area` VALUES ('230', '扬州', '2', '230', '15', null);
INSERT INTO `zn_area` VALUES ('2300', '玛多县', '3', '2300', '275', null);
INSERT INTO `zn_area` VALUES ('2301', '海晏县', '3', '2301', '276', null);
INSERT INTO `zn_area` VALUES ('2302', '祁连县', '3', '2302', '276', null);
INSERT INTO `zn_area` VALUES ('2303', '刚察县', '3', '2303', '276', null);
INSERT INTO `zn_area` VALUES ('2304', '门源县', '3', '2304', '276', null);
INSERT INTO `zn_area` VALUES ('2305', '平安县', '3', '2305', '277', null);
INSERT INTO `zn_area` VALUES ('2306', '乐都县', '3', '2306', '277', null);
INSERT INTO `zn_area` VALUES ('2307', '民和县', '3', '2307', '277', null);
INSERT INTO `zn_area` VALUES ('2308', '互助县', '3', '2308', '277', null);
INSERT INTO `zn_area` VALUES ('2309', '化隆县', '3', '2309', '277', null);
INSERT INTO `zn_area` VALUES ('231', '镇江', '2', '231', '15', null);
INSERT INTO `zn_area` VALUES ('2310', '循化县', '3', '2310', '277', null);
INSERT INTO `zn_area` VALUES ('2311', '共和县', '3', '2311', '278', null);
INSERT INTO `zn_area` VALUES ('2312', '同德县', '3', '2312', '278', null);
INSERT INTO `zn_area` VALUES ('2313', '贵德县', '3', '2313', '278', null);
INSERT INTO `zn_area` VALUES ('2314', '兴海县', '3', '2314', '278', null);
INSERT INTO `zn_area` VALUES ('2315', '贵南县', '3', '2315', '278', null);
INSERT INTO `zn_area` VALUES ('2316', '德令哈市', '3', '2316', '279', null);
INSERT INTO `zn_area` VALUES ('2317', '格尔木市', '3', '2317', '279', null);
INSERT INTO `zn_area` VALUES ('2318', '乌兰县', '3', '2318', '279', null);
INSERT INTO `zn_area` VALUES ('2319', '都兰县', '3', '2319', '279', null);
INSERT INTO `zn_area` VALUES ('232', '南昌', '2', '232', '16', null);
INSERT INTO `zn_area` VALUES ('2320', '天峻县', '3', '2320', '279', null);
INSERT INTO `zn_area` VALUES ('2321', '同仁县', '3', '2321', '280', null);
INSERT INTO `zn_area` VALUES ('2322', '尖扎县', '3', '2322', '280', null);
INSERT INTO `zn_area` VALUES ('2323', '泽库县', '3', '2323', '280', null);
INSERT INTO `zn_area` VALUES ('2324', '河南蒙古族自治县', '3', '2324', '280', null);
INSERT INTO `zn_area` VALUES ('2325', '玉树县', '3', '2325', '281', null);
INSERT INTO `zn_area` VALUES ('2326', '杂多县', '3', '2326', '281', null);
INSERT INTO `zn_area` VALUES ('2327', '称多县', '3', '2327', '281', null);
INSERT INTO `zn_area` VALUES ('2328', '治多县', '3', '2328', '281', null);
INSERT INTO `zn_area` VALUES ('2329', '囊谦县', '3', '2329', '281', null);
INSERT INTO `zn_area` VALUES ('233', '抚州', '2', '233', '16', null);
INSERT INTO `zn_area` VALUES ('2330', '曲麻莱县', '3', '2330', '281', null);
INSERT INTO `zn_area` VALUES ('2331', '市中区', '3', '2331', '282', null);
INSERT INTO `zn_area` VALUES ('2332', '历下区', '3', '2332', '282', null);
INSERT INTO `zn_area` VALUES ('2333', '天桥区', '3', '2333', '282', null);
INSERT INTO `zn_area` VALUES ('2334', '槐荫区', '3', '2334', '282', null);
INSERT INTO `zn_area` VALUES ('2335', '历城区', '3', '2335', '282', null);
INSERT INTO `zn_area` VALUES ('2336', '长清区', '3', '2336', '282', null);
INSERT INTO `zn_area` VALUES ('2337', '章丘市', '3', '2337', '282', null);
INSERT INTO `zn_area` VALUES ('2338', '平阴县', '3', '2338', '282', null);
INSERT INTO `zn_area` VALUES ('2339', '济阳县', '3', '2339', '282', null);
INSERT INTO `zn_area` VALUES ('234', '赣州', '2', '234', '16', null);
INSERT INTO `zn_area` VALUES ('2340', '商河县', '3', '2340', '282', null);
INSERT INTO `zn_area` VALUES ('2341', '市南区', '3', '2341', '283', null);
INSERT INTO `zn_area` VALUES ('2342', '市北区', '3', '2342', '283', null);
INSERT INTO `zn_area` VALUES ('2343', '城阳区', '3', '2343', '283', null);
INSERT INTO `zn_area` VALUES ('2344', '四方区', '3', '2344', '283', null);
INSERT INTO `zn_area` VALUES ('2345', '李沧区', '3', '2345', '283', null);
INSERT INTO `zn_area` VALUES ('2346', '黄岛区', '3', '2346', '283', null);
INSERT INTO `zn_area` VALUES ('2347', '崂山区', '3', '2347', '283', null);
INSERT INTO `zn_area` VALUES ('2348', '胶州市', '3', '2348', '283', null);
INSERT INTO `zn_area` VALUES ('2349', '即墨市', '3', '2349', '283', null);
INSERT INTO `zn_area` VALUES ('235', '吉安', '2', '235', '16', null);
INSERT INTO `zn_area` VALUES ('2350', '平度市', '3', '2350', '283', null);
INSERT INTO `zn_area` VALUES ('2351', '胶南市', '3', '2351', '283', null);
INSERT INTO `zn_area` VALUES ('2352', '莱西市', '3', '2352', '283', null);
INSERT INTO `zn_area` VALUES ('2353', '滨城区', '3', '2353', '284', null);
INSERT INTO `zn_area` VALUES ('2354', '惠民县', '3', '2354', '284', null);
INSERT INTO `zn_area` VALUES ('2355', '阳信县', '3', '2355', '284', null);
INSERT INTO `zn_area` VALUES ('2356', '无棣县', '3', '2356', '284', null);
INSERT INTO `zn_area` VALUES ('2357', '沾化县', '3', '2357', '284', null);
INSERT INTO `zn_area` VALUES ('2358', '博兴县', '3', '2358', '284', null);
INSERT INTO `zn_area` VALUES ('2359', '邹平县', '3', '2359', '284', null);
INSERT INTO `zn_area` VALUES ('236', '景德镇', '2', '236', '16', null);
INSERT INTO `zn_area` VALUES ('2360', '德城区', '3', '2360', '285', null);
INSERT INTO `zn_area` VALUES ('2361', '陵县', '3', '2361', '285', null);
INSERT INTO `zn_area` VALUES ('2362', '乐陵市', '3', '2362', '285', null);
INSERT INTO `zn_area` VALUES ('2363', '禹城市', '3', '2363', '285', null);
INSERT INTO `zn_area` VALUES ('2364', '宁津县', '3', '2364', '285', null);
INSERT INTO `zn_area` VALUES ('2365', '庆云县', '3', '2365', '285', null);
INSERT INTO `zn_area` VALUES ('2366', '临邑县', '3', '2366', '285', null);
INSERT INTO `zn_area` VALUES ('2367', '齐河县', '3', '2367', '285', null);
INSERT INTO `zn_area` VALUES ('2368', '平原县', '3', '2368', '285', null);
INSERT INTO `zn_area` VALUES ('2369', '夏津县', '3', '2369', '285', null);
INSERT INTO `zn_area` VALUES ('237', '九江', '2', '237', '16', null);
INSERT INTO `zn_area` VALUES ('2370', '武城县', '3', '2370', '285', null);
INSERT INTO `zn_area` VALUES ('2371', '东营区', '3', '2371', '286', null);
INSERT INTO `zn_area` VALUES ('2372', '河口区', '3', '2372', '286', null);
INSERT INTO `zn_area` VALUES ('2373', '垦利县', '3', '2373', '286', null);
INSERT INTO `zn_area` VALUES ('2374', '利津县', '3', '2374', '286', null);
INSERT INTO `zn_area` VALUES ('2375', '广饶县', '3', '2375', '286', null);
INSERT INTO `zn_area` VALUES ('2376', '牡丹区', '3', '2376', '287', null);
INSERT INTO `zn_area` VALUES ('2377', '曹县', '3', '2377', '287', null);
INSERT INTO `zn_area` VALUES ('2378', '单县', '3', '2378', '287', null);
INSERT INTO `zn_area` VALUES ('2379', '成武县', '3', '2379', '287', null);
INSERT INTO `zn_area` VALUES ('238', '萍乡', '2', '238', '16', null);
INSERT INTO `zn_area` VALUES ('2380', '巨野县', '3', '2380', '287', null);
INSERT INTO `zn_area` VALUES ('2381', '郓城县', '3', '2381', '287', null);
INSERT INTO `zn_area` VALUES ('2382', '鄄城县', '3', '2382', '287', null);
INSERT INTO `zn_area` VALUES ('2383', '定陶县', '3', '2383', '287', null);
INSERT INTO `zn_area` VALUES ('2384', '东明县', '3', '2384', '287', null);
INSERT INTO `zn_area` VALUES ('2385', '市中区', '3', '2385', '288', null);
INSERT INTO `zn_area` VALUES ('2386', '任城区', '3', '2386', '288', null);
INSERT INTO `zn_area` VALUES ('2387', '曲阜市', '3', '2387', '288', null);
INSERT INTO `zn_area` VALUES ('2388', '兖州市', '3', '2388', '288', null);
INSERT INTO `zn_area` VALUES ('2389', '邹城市', '3', '2389', '288', null);
INSERT INTO `zn_area` VALUES ('239', '上饶', '2', '239', '16', null);
INSERT INTO `zn_area` VALUES ('2390', '微山县', '3', '2390', '288', null);
INSERT INTO `zn_area` VALUES ('2391', '鱼台县', '3', '2391', '288', null);
INSERT INTO `zn_area` VALUES ('2392', '金乡县', '3', '2392', '288', null);
INSERT INTO `zn_area` VALUES ('2393', '嘉祥县', '3', '2393', '288', null);
INSERT INTO `zn_area` VALUES ('2394', '汶上县', '3', '2394', '288', null);
INSERT INTO `zn_area` VALUES ('2395', '泗水县', '3', '2395', '288', null);
INSERT INTO `zn_area` VALUES ('2396', '梁山县', '3', '2396', '288', null);
INSERT INTO `zn_area` VALUES ('2397', '莱城区', '3', '2397', '289', null);
INSERT INTO `zn_area` VALUES ('2398', '钢城区', '3', '2398', '289', null);
INSERT INTO `zn_area` VALUES ('2399', '东昌府区', '3', '2399', '290', null);
INSERT INTO `zn_area` VALUES ('24', '上海', '1', '24', '0', null);
INSERT INTO `zn_area` VALUES ('240', '新余', '2', '240', '16', null);
INSERT INTO `zn_area` VALUES ('2400', '临清市', '3', '2400', '290', null);
INSERT INTO `zn_area` VALUES ('2401', '阳谷县', '3', '2401', '290', null);
INSERT INTO `zn_area` VALUES ('2402', '莘县', '3', '2402', '290', null);
INSERT INTO `zn_area` VALUES ('2403', '茌平县', '3', '2403', '290', null);
INSERT INTO `zn_area` VALUES ('2404', '东阿县', '3', '2404', '290', null);
INSERT INTO `zn_area` VALUES ('2405', '冠县', '3', '2405', '290', null);
INSERT INTO `zn_area` VALUES ('2406', '高唐县', '3', '2406', '290', null);
INSERT INTO `zn_area` VALUES ('2407', '兰山区', '3', '2407', '291', null);
INSERT INTO `zn_area` VALUES ('2408', '罗庄区', '3', '2408', '291', null);
INSERT INTO `zn_area` VALUES ('2409', '河东区', '3', '2409', '291', null);
INSERT INTO `zn_area` VALUES ('241', '宜春', '2', '241', '16', null);
INSERT INTO `zn_area` VALUES ('2410', '沂南县', '3', '2410', '291', null);
INSERT INTO `zn_area` VALUES ('2411', '郯城县', '3', '2411', '291', null);
INSERT INTO `zn_area` VALUES ('2412', '沂水县', '3', '2412', '291', null);
INSERT INTO `zn_area` VALUES ('2413', '兰陵县', '3', '2413', '291', null);
INSERT INTO `zn_area` VALUES ('2414', '费县', '3', '2414', '291', null);
INSERT INTO `zn_area` VALUES ('2415', '平邑县', '3', '2415', '291', null);
INSERT INTO `zn_area` VALUES ('2416', '莒南县', '3', '2416', '291', null);
INSERT INTO `zn_area` VALUES ('2417', '蒙阴县', '3', '2417', '291', null);
INSERT INTO `zn_area` VALUES ('2418', '临沭县', '3', '2418', '291', null);
INSERT INTO `zn_area` VALUES ('2419', '东港区', '3', '2419', '292', null);
INSERT INTO `zn_area` VALUES ('242', '鹰潭', '2', '242', '16', null);
INSERT INTO `zn_area` VALUES ('2420', '岚山区', '3', '2420', '292', null);
INSERT INTO `zn_area` VALUES ('2421', '五莲县', '3', '2421', '292', null);
INSERT INTO `zn_area` VALUES ('2422', '莒县', '3', '2422', '292', null);
INSERT INTO `zn_area` VALUES ('2423', '泰山区', '3', '2423', '293', null);
INSERT INTO `zn_area` VALUES ('2424', '岱岳区', '3', '2424', '293', null);
INSERT INTO `zn_area` VALUES ('2425', '新泰市', '3', '2425', '293', null);
INSERT INTO `zn_area` VALUES ('2426', '肥城市', '3', '2426', '293', null);
INSERT INTO `zn_area` VALUES ('2427', '宁阳县', '3', '2427', '293', null);
INSERT INTO `zn_area` VALUES ('2428', '东平县', '3', '2428', '293', null);
INSERT INTO `zn_area` VALUES ('2429', '荣成市', '3', '2429', '294', null);
INSERT INTO `zn_area` VALUES ('243', '沈阳', '2', '243', '17', null);
INSERT INTO `zn_area` VALUES ('2430', '乳山市', '3', '2430', '294', null);
INSERT INTO `zn_area` VALUES ('2431', '环翠区', '3', '2431', '294', null);
INSERT INTO `zn_area` VALUES ('2432', '文登市', '3', '2432', '294', null);
INSERT INTO `zn_area` VALUES ('2433', '潍城区', '3', '2433', '295', null);
INSERT INTO `zn_area` VALUES ('2434', '寒亭区', '3', '2434', '295', null);
INSERT INTO `zn_area` VALUES ('2435', '坊子区', '3', '2435', '295', null);
INSERT INTO `zn_area` VALUES ('2436', '奎文区', '3', '2436', '295', null);
INSERT INTO `zn_area` VALUES ('2437', '青州市', '3', '2437', '295', null);
INSERT INTO `zn_area` VALUES ('2438', '诸城市', '3', '2438', '295', null);
INSERT INTO `zn_area` VALUES ('2439', '寿光市', '3', '2439', '295', null);
INSERT INTO `zn_area` VALUES ('244', '大连', '2', '244', '17', null);
INSERT INTO `zn_area` VALUES ('2440', '安丘市', '3', '2440', '295', null);
INSERT INTO `zn_area` VALUES ('2441', '高密市', '3', '2441', '295', null);
INSERT INTO `zn_area` VALUES ('2442', '昌邑市', '3', '2442', '295', null);
INSERT INTO `zn_area` VALUES ('2443', '临朐县', '3', '2443', '295', null);
INSERT INTO `zn_area` VALUES ('2444', '昌乐县', '3', '2444', '295', null);
INSERT INTO `zn_area` VALUES ('2445', '芝罘区', '3', '2445', '296', null);
INSERT INTO `zn_area` VALUES ('2446', '福山区', '3', '2446', '296', null);
INSERT INTO `zn_area` VALUES ('2447', '牟平区', '3', '2447', '296', null);
INSERT INTO `zn_area` VALUES ('2448', '莱山区', '3', '2448', '296', null);
INSERT INTO `zn_area` VALUES ('2449', '开发区', '3', '2449', '296', null);
INSERT INTO `zn_area` VALUES ('245', '鞍山', '2', '245', '17', null);
INSERT INTO `zn_area` VALUES ('2450', '龙口市', '3', '2450', '296', null);
INSERT INTO `zn_area` VALUES ('2451', '莱阳市', '3', '2451', '296', null);
INSERT INTO `zn_area` VALUES ('2452', '莱州市', '3', '2452', '296', null);
INSERT INTO `zn_area` VALUES ('2453', '蓬莱市', '3', '2453', '296', null);
INSERT INTO `zn_area` VALUES ('2454', '招远市', '3', '2454', '296', null);
INSERT INTO `zn_area` VALUES ('2455', '栖霞市', '3', '2455', '296', null);
INSERT INTO `zn_area` VALUES ('2456', '海阳市', '3', '2456', '296', null);
INSERT INTO `zn_area` VALUES ('2457', '长岛县', '3', '2457', '296', null);
INSERT INTO `zn_area` VALUES ('2458', '市中区', '3', '2458', '297', null);
INSERT INTO `zn_area` VALUES ('2459', '山亭区', '3', '2459', '297', null);
INSERT INTO `zn_area` VALUES ('246', '本溪', '2', '246', '17', null);
INSERT INTO `zn_area` VALUES ('2460', '峄城区', '3', '2460', '297', null);
INSERT INTO `zn_area` VALUES ('2461', '台儿庄区', '3', '2461', '297', null);
INSERT INTO `zn_area` VALUES ('2462', '薛城区', '3', '2462', '297', null);
INSERT INTO `zn_area` VALUES ('2463', '滕州市', '3', '2463', '297', null);
INSERT INTO `zn_area` VALUES ('2464', '张店区', '3', '2464', '298', null);
INSERT INTO `zn_area` VALUES ('2465', '临淄区', '3', '2465', '298', null);
INSERT INTO `zn_area` VALUES ('2466', '淄川区', '3', '2466', '298', null);
INSERT INTO `zn_area` VALUES ('2467', '博山区', '3', '2467', '298', null);
INSERT INTO `zn_area` VALUES ('2468', '周村区', '3', '2468', '298', null);
INSERT INTO `zn_area` VALUES ('2469', '桓台县', '3', '2469', '298', null);
INSERT INTO `zn_area` VALUES ('247', '朝阳', '2', '247', '17', null);
INSERT INTO `zn_area` VALUES ('2470', '高青县', '3', '2470', '298', null);
INSERT INTO `zn_area` VALUES ('2471', '沂源县', '3', '2471', '298', null);
INSERT INTO `zn_area` VALUES ('2472', '杏花岭区', '3', '2472', '299', null);
INSERT INTO `zn_area` VALUES ('2473', '小店区', '3', '2473', '299', null);
INSERT INTO `zn_area` VALUES ('2474', '迎泽区', '3', '2474', '299', null);
INSERT INTO `zn_area` VALUES ('2475', '尖草坪区', '3', '2475', '299', null);
INSERT INTO `zn_area` VALUES ('2476', '万柏林区', '3', '2476', '299', null);
INSERT INTO `zn_area` VALUES ('2477', '晋源区', '3', '2477', '299', null);
INSERT INTO `zn_area` VALUES ('2478', '高新开发区', '3', '2478', '299', null);
INSERT INTO `zn_area` VALUES ('2479', '民营经济开发区', '3', '2479', '299', null);
INSERT INTO `zn_area` VALUES ('248', '丹东', '2', '248', '17', null);
INSERT INTO `zn_area` VALUES ('2480', '经济技术开发区', '3', '2480', '299', null);
INSERT INTO `zn_area` VALUES ('2481', '清徐县', '3', '2481', '299', null);
INSERT INTO `zn_area` VALUES ('2482', '阳曲县', '3', '2482', '299', null);
INSERT INTO `zn_area` VALUES ('2483', '娄烦县', '3', '2483', '299', null);
INSERT INTO `zn_area` VALUES ('2484', '古交市', '3', '2484', '299', null);
INSERT INTO `zn_area` VALUES ('2485', '城区', '3', '2485', '300', null);
INSERT INTO `zn_area` VALUES ('2486', '郊区', '3', '2486', '300', null);
INSERT INTO `zn_area` VALUES ('2487', '沁县', '3', '2487', '300', null);
INSERT INTO `zn_area` VALUES ('2488', '潞城市', '3', '2488', '300', null);
INSERT INTO `zn_area` VALUES ('2489', '长治县', '3', '2489', '300', null);
INSERT INTO `zn_area` VALUES ('249', '抚顺', '2', '249', '17', null);
INSERT INTO `zn_area` VALUES ('2490', '襄垣县', '3', '2490', '300', null);
INSERT INTO `zn_area` VALUES ('2491', '屯留县', '3', '2491', '300', null);
INSERT INTO `zn_area` VALUES ('2492', '平顺县', '3', '2492', '300', null);
INSERT INTO `zn_area` VALUES ('2493', '黎城县', '3', '2493', '300', null);
INSERT INTO `zn_area` VALUES ('2494', '壶关县', '3', '2494', '300', null);
INSERT INTO `zn_area` VALUES ('2495', '长子县', '3', '2495', '300', null);
INSERT INTO `zn_area` VALUES ('2496', '武乡县', '3', '2496', '300', null);
INSERT INTO `zn_area` VALUES ('2497', '沁源县', '3', '2497', '300', null);
INSERT INTO `zn_area` VALUES ('2498', '城区', '3', '2498', '301', null);
INSERT INTO `zn_area` VALUES ('2499', '矿区', '3', '2499', '301', null);
INSERT INTO `zn_area` VALUES ('25', '四川', '1', '25', '0', null);
INSERT INTO `zn_area` VALUES ('250', '阜新', '2', '250', '17', null);
INSERT INTO `zn_area` VALUES ('2500', '南郊区', '3', '2500', '301', null);
INSERT INTO `zn_area` VALUES ('2501', '新荣区', '3', '2501', '301', null);
INSERT INTO `zn_area` VALUES ('2502', '阳高县', '3', '2502', '301', null);
INSERT INTO `zn_area` VALUES ('2503', '天镇县', '3', '2503', '301', null);
INSERT INTO `zn_area` VALUES ('2504', '广灵县', '3', '2504', '301', null);
INSERT INTO `zn_area` VALUES ('2505', '灵丘县', '3', '2505', '301', null);
INSERT INTO `zn_area` VALUES ('2506', '浑源县', '3', '2506', '301', null);
INSERT INTO `zn_area` VALUES ('2507', '左云县', '3', '2507', '301', null);
INSERT INTO `zn_area` VALUES ('2508', '大同县', '3', '2508', '301', null);
INSERT INTO `zn_area` VALUES ('2509', '城区', '3', '2509', '302', null);
INSERT INTO `zn_area` VALUES ('251', '葫芦岛', '2', '251', '17', null);
INSERT INTO `zn_area` VALUES ('2510', '高平市', '3', '2510', '302', null);
INSERT INTO `zn_area` VALUES ('2511', '沁水县', '3', '2511', '302', null);
INSERT INTO `zn_area` VALUES ('2512', '阳城县', '3', '2512', '302', null);
INSERT INTO `zn_area` VALUES ('2513', '陵川县', '3', '2513', '302', null);
INSERT INTO `zn_area` VALUES ('2514', '泽州县', '3', '2514', '302', null);
INSERT INTO `zn_area` VALUES ('2515', '榆次区', '3', '2515', '303', null);
INSERT INTO `zn_area` VALUES ('2516', '介休市', '3', '2516', '303', null);
INSERT INTO `zn_area` VALUES ('2517', '榆社县', '3', '2517', '303', null);
INSERT INTO `zn_area` VALUES ('2518', '左权县', '3', '2518', '303', null);
INSERT INTO `zn_area` VALUES ('2519', '和顺县', '3', '2519', '303', null);
INSERT INTO `zn_area` VALUES ('252', '锦州', '2', '252', '17', null);
INSERT INTO `zn_area` VALUES ('2520', '昔阳县', '3', '2520', '303', null);
INSERT INTO `zn_area` VALUES ('2521', '寿阳县', '3', '2521', '303', null);
INSERT INTO `zn_area` VALUES ('2522', '太谷县', '3', '2522', '303', null);
INSERT INTO `zn_area` VALUES ('2523', '祁县', '3', '2523', '303', null);
INSERT INTO `zn_area` VALUES ('2524', '平遥县', '3', '2524', '303', null);
INSERT INTO `zn_area` VALUES ('2525', '灵石县', '3', '2525', '303', null);
INSERT INTO `zn_area` VALUES ('2526', '尧都区', '3', '2526', '304', null);
INSERT INTO `zn_area` VALUES ('2527', '侯马市', '3', '2527', '304', null);
INSERT INTO `zn_area` VALUES ('2528', '霍州市', '3', '2528', '304', null);
INSERT INTO `zn_area` VALUES ('2529', '曲沃县', '3', '2529', '304', null);
INSERT INTO `zn_area` VALUES ('253', '辽阳', '2', '253', '17', null);
INSERT INTO `zn_area` VALUES ('2530', '翼城县', '3', '2530', '304', null);
INSERT INTO `zn_area` VALUES ('2531', '襄汾县', '3', '2531', '304', null);
INSERT INTO `zn_area` VALUES ('2532', '洪洞县', '3', '2532', '304', null);
INSERT INTO `zn_area` VALUES ('2533', '吉县', '3', '2533', '304', null);
INSERT INTO `zn_area` VALUES ('2534', '安泽县', '3', '2534', '304', null);
INSERT INTO `zn_area` VALUES ('2535', '浮山县', '3', '2535', '304', null);
INSERT INTO `zn_area` VALUES ('2536', '古县', '3', '2536', '304', null);
INSERT INTO `zn_area` VALUES ('2537', '乡宁县', '3', '2537', '304', null);
INSERT INTO `zn_area` VALUES ('2538', '大宁县', '3', '2538', '304', null);
INSERT INTO `zn_area` VALUES ('2539', '隰县', '3', '2539', '304', null);
INSERT INTO `zn_area` VALUES ('254', '盘锦', '2', '254', '17', null);
INSERT INTO `zn_area` VALUES ('2540', '永和县', '3', '2540', '304', null);
INSERT INTO `zn_area` VALUES ('2541', '蒲县', '3', '2541', '304', null);
INSERT INTO `zn_area` VALUES ('2542', '汾西县', '3', '2542', '304', null);
INSERT INTO `zn_area` VALUES ('2543', '离石市', '3', '2543', '305', null);
INSERT INTO `zn_area` VALUES ('2544', '离石区', '3', '2544', '305', null);
INSERT INTO `zn_area` VALUES ('2545', '孝义市', '3', '2545', '305', null);
INSERT INTO `zn_area` VALUES ('2546', '汾阳市', '3', '2546', '305', null);
INSERT INTO `zn_area` VALUES ('2547', '文水县', '3', '2547', '305', null);
INSERT INTO `zn_area` VALUES ('2548', '交城县', '3', '2548', '305', null);
INSERT INTO `zn_area` VALUES ('2549', '兴县', '3', '2549', '305', null);
INSERT INTO `zn_area` VALUES ('255', '铁岭', '2', '255', '17', null);
INSERT INTO `zn_area` VALUES ('2550', '临县', '3', '2550', '305', null);
INSERT INTO `zn_area` VALUES ('2551', '柳林县', '3', '2551', '305', null);
INSERT INTO `zn_area` VALUES ('2552', '石楼县', '3', '2552', '305', null);
INSERT INTO `zn_area` VALUES ('2553', '岚县', '3', '2553', '305', null);
INSERT INTO `zn_area` VALUES ('2554', '方山县', '3', '2554', '305', null);
INSERT INTO `zn_area` VALUES ('2555', '中阳县', '3', '2555', '305', null);
INSERT INTO `zn_area` VALUES ('2556', '交口县', '3', '2556', '305', null);
INSERT INTO `zn_area` VALUES ('2557', '朔城区', '3', '2557', '306', null);
INSERT INTO `zn_area` VALUES ('2558', '平鲁区', '3', '2558', '306', null);
INSERT INTO `zn_area` VALUES ('2559', '山阴县', '3', '2559', '306', null);
INSERT INTO `zn_area` VALUES ('256', '营口', '2', '256', '17', null);
INSERT INTO `zn_area` VALUES ('2560', '应县', '3', '2560', '306', null);
INSERT INTO `zn_area` VALUES ('2561', '右玉县', '3', '2561', '306', null);
INSERT INTO `zn_area` VALUES ('2562', '怀仁县', '3', '2562', '306', null);
INSERT INTO `zn_area` VALUES ('2563', '忻府区', '3', '2563', '307', null);
INSERT INTO `zn_area` VALUES ('2564', '原平市', '3', '2564', '307', null);
INSERT INTO `zn_area` VALUES ('2565', '定襄县', '3', '2565', '307', null);
INSERT INTO `zn_area` VALUES ('2566', '五台县', '3', '2566', '307', null);
INSERT INTO `zn_area` VALUES ('2567', '代县', '3', '2567', '307', null);
INSERT INTO `zn_area` VALUES ('2568', '繁峙县', '3', '2568', '307', null);
INSERT INTO `zn_area` VALUES ('2569', '宁武县', '3', '2569', '307', null);
INSERT INTO `zn_area` VALUES ('257', '呼和浩特', '2', '257', '18', null);
INSERT INTO `zn_area` VALUES ('2570', '静乐县', '3', '2570', '307', null);
INSERT INTO `zn_area` VALUES ('2571', '神池县', '3', '2571', '307', null);
INSERT INTO `zn_area` VALUES ('2572', '五寨县', '3', '2572', '307', null);
INSERT INTO `zn_area` VALUES ('2573', '岢岚县', '3', '2573', '307', null);
INSERT INTO `zn_area` VALUES ('2574', '河曲县', '3', '2574', '307', null);
INSERT INTO `zn_area` VALUES ('2575', '保德县', '3', '2575', '307', null);
INSERT INTO `zn_area` VALUES ('2576', '偏关县', '3', '2576', '307', null);
INSERT INTO `zn_area` VALUES ('2577', '城区', '3', '2577', '308', null);
INSERT INTO `zn_area` VALUES ('2578', '矿区', '3', '2578', '308', null);
INSERT INTO `zn_area` VALUES ('2579', '郊区', '3', '2579', '308', null);
INSERT INTO `zn_area` VALUES ('258', '阿拉善盟', '2', '258', '18', null);
INSERT INTO `zn_area` VALUES ('2580', '平定县', '3', '2580', '308', null);
INSERT INTO `zn_area` VALUES ('2581', '盂县', '3', '2581', '308', null);
INSERT INTO `zn_area` VALUES ('2582', '盐湖区', '3', '2582', '309', null);
INSERT INTO `zn_area` VALUES ('2583', '永济市', '3', '2583', '309', null);
INSERT INTO `zn_area` VALUES ('2584', '河津市', '3', '2584', '309', null);
INSERT INTO `zn_area` VALUES ('2585', '临猗县', '3', '2585', '309', null);
INSERT INTO `zn_area` VALUES ('2586', '万荣县', '3', '2586', '309', null);
INSERT INTO `zn_area` VALUES ('2587', '闻喜县', '3', '2587', '309', null);
INSERT INTO `zn_area` VALUES ('2588', '稷山县', '3', '2588', '309', null);
INSERT INTO `zn_area` VALUES ('2589', '新绛县', '3', '2589', '309', null);
INSERT INTO `zn_area` VALUES ('259', '巴彦淖尔', '2', '259', '18', null);
INSERT INTO `zn_area` VALUES ('2590', '绛县', '3', '2590', '309', null);
INSERT INTO `zn_area` VALUES ('2591', '垣曲县', '3', '2591', '309', null);
INSERT INTO `zn_area` VALUES ('2592', '夏县', '3', '2592', '309', null);
INSERT INTO `zn_area` VALUES ('2593', '平陆县', '3', '2593', '309', null);
INSERT INTO `zn_area` VALUES ('2594', '芮城县', '3', '2594', '309', null);
INSERT INTO `zn_area` VALUES ('2595', '莲湖区', '3', '2595', '310', null);
INSERT INTO `zn_area` VALUES ('2596', '新城区', '3', '2596', '310', null);
INSERT INTO `zn_area` VALUES ('2597', '碑林区', '3', '2597', '310', null);
INSERT INTO `zn_area` VALUES ('2598', '雁塔区', '3', '2598', '310', null);
INSERT INTO `zn_area` VALUES ('2599', '灞桥区', '3', '2599', '310', null);
INSERT INTO `zn_area` VALUES ('26', '天津', '1', '26', '0', null);
INSERT INTO `zn_area` VALUES ('260', '包头', '2', '260', '18', null);
INSERT INTO `zn_area` VALUES ('2600', '未央区', '3', '2600', '310', null);
INSERT INTO `zn_area` VALUES ('2601', '阎良区', '3', '2601', '310', null);
INSERT INTO `zn_area` VALUES ('2602', '临潼区', '3', '2602', '310', null);
INSERT INTO `zn_area` VALUES ('2603', '长安区', '3', '2603', '310', null);
INSERT INTO `zn_area` VALUES ('2604', '蓝田县', '3', '2604', '310', null);
INSERT INTO `zn_area` VALUES ('2605', '周至县', '3', '2605', '310', null);
INSERT INTO `zn_area` VALUES ('2606', '户县', '3', '2606', '310', null);
INSERT INTO `zn_area` VALUES ('2607', '高陵县', '3', '2607', '310', null);
INSERT INTO `zn_area` VALUES ('2608', '汉滨区', '3', '2608', '311', null);
INSERT INTO `zn_area` VALUES ('2609', '汉阴县', '3', '2609', '311', null);
INSERT INTO `zn_area` VALUES ('261', '赤峰', '2', '261', '18', null);
INSERT INTO `zn_area` VALUES ('2610', '石泉县', '3', '2610', '311', null);
INSERT INTO `zn_area` VALUES ('2611', '宁陕县', '3', '2611', '311', null);
INSERT INTO `zn_area` VALUES ('2612', '紫阳县', '3', '2612', '311', null);
INSERT INTO `zn_area` VALUES ('2613', '岚皋县', '3', '2613', '311', null);
INSERT INTO `zn_area` VALUES ('2614', '平利县', '3', '2614', '311', null);
INSERT INTO `zn_area` VALUES ('2615', '镇坪县', '3', '2615', '311', null);
INSERT INTO `zn_area` VALUES ('2616', '旬阳县', '3', '2616', '311', null);
INSERT INTO `zn_area` VALUES ('2617', '白河县', '3', '2617', '311', null);
INSERT INTO `zn_area` VALUES ('2618', '陈仓区', '3', '2618', '312', null);
INSERT INTO `zn_area` VALUES ('2619', '渭滨区', '3', '2619', '312', null);
INSERT INTO `zn_area` VALUES ('262', '鄂尔多斯', '2', '262', '18', null);
INSERT INTO `zn_area` VALUES ('2620', '金台区', '3', '2620', '312', null);
INSERT INTO `zn_area` VALUES ('2621', '凤翔县', '3', '2621', '312', null);
INSERT INTO `zn_area` VALUES ('2622', '岐山县', '3', '2622', '312', null);
INSERT INTO `zn_area` VALUES ('2623', '扶风县', '3', '2623', '312', null);
INSERT INTO `zn_area` VALUES ('2624', '眉县', '3', '2624', '312', null);
INSERT INTO `zn_area` VALUES ('2625', '陇县', '3', '2625', '312', null);
INSERT INTO `zn_area` VALUES ('2626', '千阳县', '3', '2626', '312', null);
INSERT INTO `zn_area` VALUES ('2627', '麟游县', '3', '2627', '312', null);
INSERT INTO `zn_area` VALUES ('2628', '凤县', '3', '2628', '312', null);
INSERT INTO `zn_area` VALUES ('2629', '太白县', '3', '2629', '312', null);
INSERT INTO `zn_area` VALUES ('263', '呼伦贝尔', '2', '263', '18', null);
INSERT INTO `zn_area` VALUES ('2630', '汉台区', '3', '2630', '313', null);
INSERT INTO `zn_area` VALUES ('2631', '南郑县', '3', '2631', '313', null);
INSERT INTO `zn_area` VALUES ('2632', '城固县', '3', '2632', '313', null);
INSERT INTO `zn_area` VALUES ('2633', '洋县', '3', '2633', '313', null);
INSERT INTO `zn_area` VALUES ('2634', '西乡县', '3', '2634', '313', null);
INSERT INTO `zn_area` VALUES ('2635', '勉县', '3', '2635', '313', null);
INSERT INTO `zn_area` VALUES ('2636', '宁强县', '3', '2636', '313', null);
INSERT INTO `zn_area` VALUES ('2637', '略阳县', '3', '2637', '313', null);
INSERT INTO `zn_area` VALUES ('2638', '镇巴县', '3', '2638', '313', null);
INSERT INTO `zn_area` VALUES ('2639', '留坝县', '3', '2639', '313', null);
INSERT INTO `zn_area` VALUES ('264', '通辽', '2', '264', '18', null);
INSERT INTO `zn_area` VALUES ('2640', '佛坪县', '3', '2640', '313', null);
INSERT INTO `zn_area` VALUES ('2641', '商州区', '3', '2641', '314', null);
INSERT INTO `zn_area` VALUES ('2642', '洛南县', '3', '2642', '314', null);
INSERT INTO `zn_area` VALUES ('2643', '丹凤县', '3', '2643', '314', null);
INSERT INTO `zn_area` VALUES ('2644', '商南县', '3', '2644', '314', null);
INSERT INTO `zn_area` VALUES ('2645', '山阳县', '3', '2645', '314', null);
INSERT INTO `zn_area` VALUES ('2646', '镇安县', '3', '2646', '314', null);
INSERT INTO `zn_area` VALUES ('2647', '柞水县', '3', '2647', '314', null);
INSERT INTO `zn_area` VALUES ('2648', '耀州区', '3', '2648', '315', null);
INSERT INTO `zn_area` VALUES ('2649', '王益区', '3', '2649', '315', null);
INSERT INTO `zn_area` VALUES ('265', '乌海', '2', '265', '18', null);
INSERT INTO `zn_area` VALUES ('2650', '印台区', '3', '2650', '315', null);
INSERT INTO `zn_area` VALUES ('2651', '宜君县', '3', '2651', '315', null);
INSERT INTO `zn_area` VALUES ('2652', '临渭区', '3', '2652', '316', null);
INSERT INTO `zn_area` VALUES ('2653', '韩城市', '3', '2653', '316', null);
INSERT INTO `zn_area` VALUES ('2654', '华阴市', '3', '2654', '316', null);
INSERT INTO `zn_area` VALUES ('2655', '华县', '3', '2655', '316', null);
INSERT INTO `zn_area` VALUES ('2656', '潼关县', '3', '2656', '316', null);
INSERT INTO `zn_area` VALUES ('2657', '大荔县', '3', '2657', '316', null);
INSERT INTO `zn_area` VALUES ('2658', '合阳县', '3', '2658', '316', null);
INSERT INTO `zn_area` VALUES ('2659', '澄城县', '3', '2659', '316', null);
INSERT INTO `zn_area` VALUES ('266', '乌兰察布', '2', '266', '18', null);
INSERT INTO `zn_area` VALUES ('2660', '蒲城县', '3', '2660', '316', null);
INSERT INTO `zn_area` VALUES ('2661', '白水县', '3', '2661', '316', null);
INSERT INTO `zn_area` VALUES ('2662', '富平县', '3', '2662', '316', null);
INSERT INTO `zn_area` VALUES ('2663', '秦都区', '3', '2663', '317', null);
INSERT INTO `zn_area` VALUES ('2664', '渭城区', '3', '2664', '317', null);
INSERT INTO `zn_area` VALUES ('2665', '杨陵区', '3', '2665', '317', null);
INSERT INTO `zn_area` VALUES ('2666', '兴平市', '3', '2666', '317', null);
INSERT INTO `zn_area` VALUES ('2667', '三原县', '3', '2667', '317', null);
INSERT INTO `zn_area` VALUES ('2668', '泾阳县', '3', '2668', '317', null);
INSERT INTO `zn_area` VALUES ('2669', '乾县', '3', '2669', '317', null);
INSERT INTO `zn_area` VALUES ('267', '锡林郭勒', '2', '267', '18', null);
INSERT INTO `zn_area` VALUES ('2670', '礼泉县', '3', '2670', '317', null);
INSERT INTO `zn_area` VALUES ('2671', '永寿县', '3', '2671', '317', null);
INSERT INTO `zn_area` VALUES ('2672', '彬县', '3', '2672', '317', null);
INSERT INTO `zn_area` VALUES ('2673', '长武县', '3', '2673', '317', null);
INSERT INTO `zn_area` VALUES ('2674', '旬邑县', '3', '2674', '317', null);
INSERT INTO `zn_area` VALUES ('2675', '淳化县', '3', '2675', '317', null);
INSERT INTO `zn_area` VALUES ('2676', '武功县', '3', '2676', '317', null);
INSERT INTO `zn_area` VALUES ('2677', '吴起县', '3', '2677', '318', null);
INSERT INTO `zn_area` VALUES ('2678', '宝塔区', '3', '2678', '318', null);
INSERT INTO `zn_area` VALUES ('2679', '延长县', '3', '2679', '318', null);
INSERT INTO `zn_area` VALUES ('268', '兴安盟', '2', '268', '18', null);
INSERT INTO `zn_area` VALUES ('2680', '延川县', '3', '2680', '318', null);
INSERT INTO `zn_area` VALUES ('2681', '子长县', '3', '2681', '318', null);
INSERT INTO `zn_area` VALUES ('2682', '安塞县', '3', '2682', '318', null);
INSERT INTO `zn_area` VALUES ('2683', '志丹县', '3', '2683', '318', null);
INSERT INTO `zn_area` VALUES ('2684', '甘泉县', '3', '2684', '318', null);
INSERT INTO `zn_area` VALUES ('2685', '富县', '3', '2685', '318', null);
INSERT INTO `zn_area` VALUES ('2686', '洛川县', '3', '2686', '318', null);
INSERT INTO `zn_area` VALUES ('2687', '宜川县', '3', '2687', '318', null);
INSERT INTO `zn_area` VALUES ('2688', '黄龙县', '3', '2688', '318', null);
INSERT INTO `zn_area` VALUES ('2689', '黄陵县', '3', '2689', '318', null);
INSERT INTO `zn_area` VALUES ('269', '银川', '2', '269', '19', null);
INSERT INTO `zn_area` VALUES ('2690', '榆阳区', '3', '2690', '319', null);
INSERT INTO `zn_area` VALUES ('2691', '神木县', '3', '2691', '319', null);
INSERT INTO `zn_area` VALUES ('2692', '府谷县', '3', '2692', '319', null);
INSERT INTO `zn_area` VALUES ('2693', '横山县', '3', '2693', '319', null);
INSERT INTO `zn_area` VALUES ('2694', '靖边县', '3', '2694', '319', null);
INSERT INTO `zn_area` VALUES ('2695', '定边县', '3', '2695', '319', null);
INSERT INTO `zn_area` VALUES ('2696', '绥德县', '3', '2696', '319', null);
INSERT INTO `zn_area` VALUES ('2697', '米脂县', '3', '2697', '319', null);
INSERT INTO `zn_area` VALUES ('2698', '佳县', '3', '2698', '319', null);
INSERT INTO `zn_area` VALUES ('2699', '吴堡县', '3', '2699', '319', null);
INSERT INTO `zn_area` VALUES ('27', '西藏', '1', '27', '0', null);
INSERT INTO `zn_area` VALUES ('270', '固原', '2', '270', '19', null);
INSERT INTO `zn_area` VALUES ('2700', '清涧县', '3', '2700', '319', null);
INSERT INTO `zn_area` VALUES ('2701', '子洲县', '3', '2701', '319', null);
INSERT INTO `zn_area` VALUES ('2702', '长宁区', '2', '2702', '24', null);
INSERT INTO `zn_area` VALUES ('2704', '闵行区', '2', '2704', '24', null);
INSERT INTO `zn_area` VALUES ('2705', '徐汇区', '2', '2705', '24', null);
INSERT INTO `zn_area` VALUES ('2706', '浦东新区', '2', '2706', '24', null);
INSERT INTO `zn_area` VALUES ('2707', '杨浦区', '2', '2707', '24', null);
INSERT INTO `zn_area` VALUES ('2708', '普陀区', '2', '2708', '24', null);
INSERT INTO `zn_area` VALUES ('2709', '静安区', '2', '2709', '24', null);
INSERT INTO `zn_area` VALUES ('271', '石嘴山', '2', '271', '19', null);
INSERT INTO `zn_area` VALUES ('2711', '虹口区', '2', '2711', '24', null);
INSERT INTO `zn_area` VALUES ('2712', '黄浦区', '2', '2712', '24', null);
INSERT INTO `zn_area` VALUES ('2714', '松江区', '2', '2714', '24', null);
INSERT INTO `zn_area` VALUES ('2715', '嘉定区', '2', '2715', '24', null);
INSERT INTO `zn_area` VALUES ('2716', '宝山区', '2', '2716', '24', null);
INSERT INTO `zn_area` VALUES ('2717', '青浦区', '2', '2717', '24', null);
INSERT INTO `zn_area` VALUES ('2718', '金山区', '2', '2718', '24', null);
INSERT INTO `zn_area` VALUES ('2719', '奉贤区', '2', '2719', '24', null);
INSERT INTO `zn_area` VALUES ('272', '吴忠', '2', '272', '19', null);
INSERT INTO `zn_area` VALUES ('2720', '崇明区', '2', '2720', '24', null);
INSERT INTO `zn_area` VALUES ('2721', '青羊区', '3', '2721', '321', null);
INSERT INTO `zn_area` VALUES ('2722', '锦江区', '3', '2722', '321', null);
INSERT INTO `zn_area` VALUES ('2723', '金牛区', '3', '2723', '321', null);
INSERT INTO `zn_area` VALUES ('2724', '武侯区', '3', '2724', '321', null);
INSERT INTO `zn_area` VALUES ('2725', '成华区', '3', '2725', '321', null);
INSERT INTO `zn_area` VALUES ('2726', '龙泉驿区', '3', '2726', '321', null);
INSERT INTO `zn_area` VALUES ('2727', '青白江区', '3', '2727', '321', null);
INSERT INTO `zn_area` VALUES ('2728', '新都区', '3', '2728', '321', null);
INSERT INTO `zn_area` VALUES ('2729', '温江区', '3', '2729', '321', null);
INSERT INTO `zn_area` VALUES ('273', '中卫', '2', '273', '19', null);
INSERT INTO `zn_area` VALUES ('2730', '高新区', '3', '2730', '321', null);
INSERT INTO `zn_area` VALUES ('2731', '高新西区', '3', '2731', '321', null);
INSERT INTO `zn_area` VALUES ('2732', '都江堰市', '3', '2732', '321', null);
INSERT INTO `zn_area` VALUES ('2733', '彭州市', '3', '2733', '321', null);
INSERT INTO `zn_area` VALUES ('2734', '邛崃市', '3', '2734', '321', null);
INSERT INTO `zn_area` VALUES ('2735', '崇州市', '3', '2735', '321', null);
INSERT INTO `zn_area` VALUES ('2736', '金堂县', '3', '2736', '321', null);
INSERT INTO `zn_area` VALUES ('2737', '双流县', '3', '2737', '321', null);
INSERT INTO `zn_area` VALUES ('2738', '郫县', '3', '2738', '321', null);
INSERT INTO `zn_area` VALUES ('2739', '大邑县', '3', '2739', '321', null);
INSERT INTO `zn_area` VALUES ('274', '西宁', '2', '274', '20', null);
INSERT INTO `zn_area` VALUES ('2740', '蒲江县', '3', '2740', '321', null);
INSERT INTO `zn_area` VALUES ('2741', '新津县', '3', '2741', '321', null);
INSERT INTO `zn_area` VALUES ('275', '果洛', '2', '275', '20', null);
INSERT INTO `zn_area` VALUES ('2752', '涪城区', '3', '2752', '322', null);
INSERT INTO `zn_area` VALUES ('2753', '游仙区', '3', '2753', '322', null);
INSERT INTO `zn_area` VALUES ('2754', '江油市', '3', '2754', '322', null);
INSERT INTO `zn_area` VALUES ('2755', '盐亭县', '3', '2755', '322', null);
INSERT INTO `zn_area` VALUES ('2756', '三台县', '3', '2756', '322', null);
INSERT INTO `zn_area` VALUES ('2757', '平武县', '3', '2757', '322', null);
INSERT INTO `zn_area` VALUES ('2758', '安县', '3', '2758', '322', null);
INSERT INTO `zn_area` VALUES ('2759', '梓潼县', '3', '2759', '322', null);
INSERT INTO `zn_area` VALUES ('276', '海北', '2', '276', '20', null);
INSERT INTO `zn_area` VALUES ('2760', '北川县', '3', '2760', '322', null);
INSERT INTO `zn_area` VALUES ('2761', '马尔康县', '3', '2761', '323', null);
INSERT INTO `zn_area` VALUES ('2762', '汶川县', '3', '2762', '323', null);
INSERT INTO `zn_area` VALUES ('2763', '理县', '3', '2763', '323', null);
INSERT INTO `zn_area` VALUES ('2764', '茂县', '3', '2764', '323', null);
INSERT INTO `zn_area` VALUES ('2765', '松潘县', '3', '2765', '323', null);
INSERT INTO `zn_area` VALUES ('2766', '九寨沟县', '3', '2766', '323', null);
INSERT INTO `zn_area` VALUES ('2767', '金川县', '3', '2767', '323', null);
INSERT INTO `zn_area` VALUES ('2768', '小金县', '3', '2768', '323', null);
INSERT INTO `zn_area` VALUES ('2769', '黑水县', '3', '2769', '323', null);
INSERT INTO `zn_area` VALUES ('277', '海东', '2', '277', '20', null);
INSERT INTO `zn_area` VALUES ('2770', '壤塘县', '3', '2770', '323', null);
INSERT INTO `zn_area` VALUES ('2771', '阿坝县', '3', '2771', '323', null);
INSERT INTO `zn_area` VALUES ('2772', '若尔盖县', '3', '2772', '323', null);
INSERT INTO `zn_area` VALUES ('2773', '红原县', '3', '2773', '323', null);
INSERT INTO `zn_area` VALUES ('2774', '巴州区', '3', '2774', '324', null);
INSERT INTO `zn_area` VALUES ('2775', '通江县', '3', '2775', '324', null);
INSERT INTO `zn_area` VALUES ('2776', '南江县', '3', '2776', '324', null);
INSERT INTO `zn_area` VALUES ('2777', '平昌县', '3', '2777', '324', null);
INSERT INTO `zn_area` VALUES ('2778', '通川区', '3', '2778', '325', null);
INSERT INTO `zn_area` VALUES ('2779', '万源市', '3', '2779', '325', null);
INSERT INTO `zn_area` VALUES ('278', '海南州', '2', '278', '20', null);
INSERT INTO `zn_area` VALUES ('2780', '达川区', '3', '2780', '325', null);
INSERT INTO `zn_area` VALUES ('2781', '宣汉县', '3', '2781', '325', null);
INSERT INTO `zn_area` VALUES ('2782', '开江县', '3', '2782', '325', null);
INSERT INTO `zn_area` VALUES ('2783', '大竹县', '3', '2783', '325', null);
INSERT INTO `zn_area` VALUES ('2784', '渠县', '3', '2784', '325', null);
INSERT INTO `zn_area` VALUES ('2785', '旌阳区', '3', '2785', '326', null);
INSERT INTO `zn_area` VALUES ('2786', '广汉市', '3', '2786', '326', null);
INSERT INTO `zn_area` VALUES ('2787', '什邡市', '3', '2787', '326', null);
INSERT INTO `zn_area` VALUES ('2788', '绵竹市', '3', '2788', '326', null);
INSERT INTO `zn_area` VALUES ('2789', '罗江县', '3', '2789', '326', null);
INSERT INTO `zn_area` VALUES ('279', '海西', '2', '279', '20', null);
INSERT INTO `zn_area` VALUES ('2790', '中江县', '3', '2790', '326', null);
INSERT INTO `zn_area` VALUES ('2791', '康定县', '3', '2791', '327', null);
INSERT INTO `zn_area` VALUES ('2792', '丹巴县', '3', '2792', '327', null);
INSERT INTO `zn_area` VALUES ('2793', '泸定县', '3', '2793', '327', null);
INSERT INTO `zn_area` VALUES ('2794', '炉霍县', '3', '2794', '327', null);
INSERT INTO `zn_area` VALUES ('2795', '九龙县', '3', '2795', '327', null);
INSERT INTO `zn_area` VALUES ('2796', '甘孜县', '3', '2796', '327', null);
INSERT INTO `zn_area` VALUES ('2797', '雅江县', '3', '2797', '327', null);
INSERT INTO `zn_area` VALUES ('2798', '新龙县', '3', '2798', '327', null);
INSERT INTO `zn_area` VALUES ('2799', '道孚县', '3', '2799', '327', null);
INSERT INTO `zn_area` VALUES ('28', '新疆', '1', '28', '0', null);
INSERT INTO `zn_area` VALUES ('280', '黄南', '2', '280', '20', null);
INSERT INTO `zn_area` VALUES ('2800', '白玉县', '3', '2800', '327', null);
INSERT INTO `zn_area` VALUES ('2801', '理塘县', '3', '2801', '327', null);
INSERT INTO `zn_area` VALUES ('2802', '德格县', '3', '2802', '327', null);
INSERT INTO `zn_area` VALUES ('2803', '乡城县', '3', '2803', '327', null);
INSERT INTO `zn_area` VALUES ('2804', '石渠县', '3', '2804', '327', null);
INSERT INTO `zn_area` VALUES ('2805', '稻城县', '3', '2805', '327', null);
INSERT INTO `zn_area` VALUES ('2806', '色达县', '3', '2806', '327', null);
INSERT INTO `zn_area` VALUES ('2807', '巴塘县', '3', '2807', '327', null);
INSERT INTO `zn_area` VALUES ('2808', '得荣县', '3', '2808', '327', null);
INSERT INTO `zn_area` VALUES ('2809', '广安区', '3', '2809', '328', null);
INSERT INTO `zn_area` VALUES ('281', '玉树', '2', '281', '20', null);
INSERT INTO `zn_area` VALUES ('2810', '华蓥市', '3', '2810', '328', null);
INSERT INTO `zn_area` VALUES ('2811', '岳池县', '3', '2811', '328', null);
INSERT INTO `zn_area` VALUES ('2812', '武胜县', '3', '2812', '328', null);
INSERT INTO `zn_area` VALUES ('2813', '邻水县', '3', '2813', '328', null);
INSERT INTO `zn_area` VALUES ('2814', '利州区', '3', '2814', '329', null);
INSERT INTO `zn_area` VALUES ('2815', '元坝区', '3', '2815', '329', null);
INSERT INTO `zn_area` VALUES ('2816', '朝天区', '3', '2816', '329', null);
INSERT INTO `zn_area` VALUES ('2817', '旺苍县', '3', '2817', '329', null);
INSERT INTO `zn_area` VALUES ('2818', '青川县', '3', '2818', '329', null);
INSERT INTO `zn_area` VALUES ('2819', '剑阁县', '3', '2819', '329', null);
INSERT INTO `zn_area` VALUES ('282', '济南', '2', '282', '21', null);
INSERT INTO `zn_area` VALUES ('2820', '苍溪县', '3', '2820', '329', null);
INSERT INTO `zn_area` VALUES ('2821', '峨眉山市', '3', '2821', '330', null);
INSERT INTO `zn_area` VALUES ('2823', '犍为县', '3', '2823', '330', null);
INSERT INTO `zn_area` VALUES ('2824', '井研县', '3', '2824', '330', null);
INSERT INTO `zn_area` VALUES ('2825', '夹江县', '3', '2825', '330', null);
INSERT INTO `zn_area` VALUES ('2826', '沐川县', '3', '2826', '330', null);
INSERT INTO `zn_area` VALUES ('2827', '峨边县', '3', '2827', '330', null);
INSERT INTO `zn_area` VALUES ('2828', '马边县', '3', '2828', '330', null);
INSERT INTO `zn_area` VALUES ('2829', '西昌市', '3', '2829', '331', null);
INSERT INTO `zn_area` VALUES ('283', '青岛', '2', '283', '21', null);
INSERT INTO `zn_area` VALUES ('2830', '盐源县', '3', '2830', '331', null);
INSERT INTO `zn_area` VALUES ('2831', '德昌县', '3', '2831', '331', null);
INSERT INTO `zn_area` VALUES ('2832', '会理县', '3', '2832', '331', null);
INSERT INTO `zn_area` VALUES ('2833', '会东县', '3', '2833', '331', null);
INSERT INTO `zn_area` VALUES ('2834', '宁南县', '3', '2834', '331', null);
INSERT INTO `zn_area` VALUES ('2835', '普格县', '3', '2835', '331', null);
INSERT INTO `zn_area` VALUES ('2836', '布拖县', '3', '2836', '331', null);
INSERT INTO `zn_area` VALUES ('2837', '金阳县', '3', '2837', '331', null);
INSERT INTO `zn_area` VALUES ('2838', '昭觉县', '3', '2838', '331', null);
INSERT INTO `zn_area` VALUES ('2839', '喜德县', '3', '2839', '331', null);
INSERT INTO `zn_area` VALUES ('284', '滨州', '2', '284', '21', null);
INSERT INTO `zn_area` VALUES ('2840', '冕宁县', '3', '2840', '331', null);
INSERT INTO `zn_area` VALUES ('2841', '越西县', '3', '2841', '331', null);
INSERT INTO `zn_area` VALUES ('2842', '甘洛县', '3', '2842', '331', null);
INSERT INTO `zn_area` VALUES ('2843', '美姑县', '3', '2843', '331', null);
INSERT INTO `zn_area` VALUES ('2844', '雷波县', '3', '2844', '331', null);
INSERT INTO `zn_area` VALUES ('2845', '木里县', '3', '2845', '331', null);
INSERT INTO `zn_area` VALUES ('2846', '东坡区', '3', '2846', '332', null);
INSERT INTO `zn_area` VALUES ('2847', '仁寿县', '3', '2847', '332', null);
INSERT INTO `zn_area` VALUES ('2848', '彭山县', '3', '2848', '332', null);
INSERT INTO `zn_area` VALUES ('2849', '洪雅县', '3', '2849', '332', null);
INSERT INTO `zn_area` VALUES ('285', '德州', '2', '285', '21', null);
INSERT INTO `zn_area` VALUES ('2850', '丹棱县', '3', '2850', '332', null);
INSERT INTO `zn_area` VALUES ('2851', '青神县', '3', '2851', '332', null);
INSERT INTO `zn_area` VALUES ('2852', '阆中市', '3', '2852', '333', null);
INSERT INTO `zn_area` VALUES ('2853', '南部县', '3', '2853', '333', null);
INSERT INTO `zn_area` VALUES ('2854', '营山县', '3', '2854', '333', null);
INSERT INTO `zn_area` VALUES ('2855', '蓬安县', '3', '2855', '333', null);
INSERT INTO `zn_area` VALUES ('2856', '仪陇县', '3', '2856', '333', null);
INSERT INTO `zn_area` VALUES ('2857', '顺庆区', '3', '2857', '333', null);
INSERT INTO `zn_area` VALUES ('2858', '高坪区', '3', '2858', '333', null);
INSERT INTO `zn_area` VALUES ('2859', '嘉陵区', '3', '2859', '333', null);
INSERT INTO `zn_area` VALUES ('286', '东营', '2', '286', '21', null);
INSERT INTO `zn_area` VALUES ('2860', '西充县', '3', '2860', '333', null);
INSERT INTO `zn_area` VALUES ('2861', '市中区', '3', '2861', '334', null);
INSERT INTO `zn_area` VALUES ('2862', '东兴区', '3', '2862', '334', null);
INSERT INTO `zn_area` VALUES ('2863', '威远县', '3', '2863', '334', null);
INSERT INTO `zn_area` VALUES ('2864', '资中县', '3', '2864', '334', null);
INSERT INTO `zn_area` VALUES ('2865', '隆昌县', '3', '2865', '334', null);
INSERT INTO `zn_area` VALUES ('2866', '东区', '3', '2866', '335', null);
INSERT INTO `zn_area` VALUES ('2867', '西区', '3', '2867', '335', null);
INSERT INTO `zn_area` VALUES ('2868', '仁和区', '3', '2868', '335', null);
INSERT INTO `zn_area` VALUES ('2869', '米易县', '3', '2869', '335', null);
INSERT INTO `zn_area` VALUES ('287', '菏泽', '2', '287', '21', null);
INSERT INTO `zn_area` VALUES ('2870', '盐边县', '3', '2870', '335', null);
INSERT INTO `zn_area` VALUES ('2871', '船山区', '3', '2871', '336', null);
INSERT INTO `zn_area` VALUES ('2872', '安居区', '3', '2872', '336', null);
INSERT INTO `zn_area` VALUES ('2873', '蓬溪县', '3', '2873', '336', null);
INSERT INTO `zn_area` VALUES ('2874', '射洪县', '3', '2874', '336', null);
INSERT INTO `zn_area` VALUES ('2875', '大英县', '3', '2875', '336', null);
INSERT INTO `zn_area` VALUES ('2876', '雨城区', '3', '2876', '337', null);
INSERT INTO `zn_area` VALUES ('2877', '名山县', '3', '2877', '337', null);
INSERT INTO `zn_area` VALUES ('2878', '荥经县', '3', '2878', '337', null);
INSERT INTO `zn_area` VALUES ('2879', '汉源县', '3', '2879', '337', null);
INSERT INTO `zn_area` VALUES ('288', '济宁', '2', '288', '21', null);
INSERT INTO `zn_area` VALUES ('2880', '石棉县', '3', '2880', '337', null);
INSERT INTO `zn_area` VALUES ('2881', '天全县', '3', '2881', '337', null);
INSERT INTO `zn_area` VALUES ('2882', '芦山县', '3', '2882', '337', null);
INSERT INTO `zn_area` VALUES ('2883', '宝兴县', '3', '2883', '337', null);
INSERT INTO `zn_area` VALUES ('2884', '翠屏区', '3', '2884', '338', null);
INSERT INTO `zn_area` VALUES ('2885', '宜宾县', '3', '2885', '338', null);
INSERT INTO `zn_area` VALUES ('2886', '南溪县', '3', '2886', '338', null);
INSERT INTO `zn_area` VALUES ('2887', '江安县', '3', '2887', '338', null);
INSERT INTO `zn_area` VALUES ('2888', '长宁县', '3', '2888', '338', null);
INSERT INTO `zn_area` VALUES ('2889', '高县', '3', '2889', '338', null);
INSERT INTO `zn_area` VALUES ('289', '莱芜', '2', '289', '21', null);
INSERT INTO `zn_area` VALUES ('2890', '珙县', '3', '2890', '338', null);
INSERT INTO `zn_area` VALUES ('2891', '筠连县', '3', '2891', '338', null);
INSERT INTO `zn_area` VALUES ('2892', '兴文县', '3', '2892', '338', null);
INSERT INTO `zn_area` VALUES ('2893', '屏山县', '3', '2893', '338', null);
INSERT INTO `zn_area` VALUES ('2894', '雁江区', '3', '2894', '339', null);
INSERT INTO `zn_area` VALUES ('2895', '简阳市', '3', '2895', '321', null);
INSERT INTO `zn_area` VALUES ('2896', '安岳县', '3', '2896', '339', null);
INSERT INTO `zn_area` VALUES ('2897', '乐至县', '3', '2897', '339', null);
INSERT INTO `zn_area` VALUES ('2898', '大安区', '3', '2898', '340', null);
INSERT INTO `zn_area` VALUES ('2899', '自流井区', '3', '2899', '340', null);
INSERT INTO `zn_area` VALUES ('29', '云南', '1', '29', '0', null);
INSERT INTO `zn_area` VALUES ('290', '聊城', '2', '290', '21', null);
INSERT INTO `zn_area` VALUES ('2900', '贡井区', '3', '2900', '340', null);
INSERT INTO `zn_area` VALUES ('2901', '沿滩区', '3', '2901', '340', null);
INSERT INTO `zn_area` VALUES ('2902', '荣县', '3', '2902', '340', null);
INSERT INTO `zn_area` VALUES ('2903', '富顺县', '3', '2903', '340', null);
INSERT INTO `zn_area` VALUES ('2904', '江阳区', '3', '2904', '341', null);
INSERT INTO `zn_area` VALUES ('2905', '纳溪区', '3', '2905', '341', null);
INSERT INTO `zn_area` VALUES ('2906', '龙马潭区', '3', '2906', '341', null);
INSERT INTO `zn_area` VALUES ('2907', '泸县', '3', '2907', '341', null);
INSERT INTO `zn_area` VALUES ('2908', '合江县', '3', '2908', '341', null);
INSERT INTO `zn_area` VALUES ('2909', '叙永县', '3', '2909', '341', null);
INSERT INTO `zn_area` VALUES ('291', '临沂', '2', '291', '21', null);
INSERT INTO `zn_area` VALUES ('2910', '古蔺县', '3', '2910', '341', null);
INSERT INTO `zn_area` VALUES ('2911', '和平区', '2', '2911', '26', null);
INSERT INTO `zn_area` VALUES ('2912', '河西区', '2', '2912', '26', null);
INSERT INTO `zn_area` VALUES ('2913', '南开区', '2', '2913', '26', null);
INSERT INTO `zn_area` VALUES ('2914', '河北区', '2', '2914', '26', null);
INSERT INTO `zn_area` VALUES ('2915', '河东区', '2', '2915', '26', null);
INSERT INTO `zn_area` VALUES ('2916', '红桥区', '2', '2916', '26', null);
INSERT INTO `zn_area` VALUES ('2917', '东丽区', '2', '2917', '26', null);
INSERT INTO `zn_area` VALUES ('2918', '津南区', '2', '2918', '26', null);
INSERT INTO `zn_area` VALUES ('2919', '西青区', '2', '2919', '26', null);
INSERT INTO `zn_area` VALUES ('292', '日照', '2', '292', '21', null);
INSERT INTO `zn_area` VALUES ('2920', '北辰区', '2', '2920', '26', null);
INSERT INTO `zn_area` VALUES ('2921', '塘沽区', '2', '2921', '26', null);
INSERT INTO `zn_area` VALUES ('2922', '汉沽区', '2', '2922', '26', null);
INSERT INTO `zn_area` VALUES ('2923', '大港区', '2', '2923', '26', null);
INSERT INTO `zn_area` VALUES ('2924', '武清区', '2', '2924', '26', null);
INSERT INTO `zn_area` VALUES ('2925', '宝坻区', '2', '2925', '26', null);
INSERT INTO `zn_area` VALUES ('2926', '滨海新区', '2', '2926', '26', null);
INSERT INTO `zn_area` VALUES ('2927', '宁河区', '2', '2927', '26', null);
INSERT INTO `zn_area` VALUES ('2928', '静海区', '2', '2928', '26', null);
INSERT INTO `zn_area` VALUES ('2929', '蓟州区', '2', '2929', '26', null);
INSERT INTO `zn_area` VALUES ('293', '泰安', '2', '293', '21', null);
INSERT INTO `zn_area` VALUES ('2930', '城关区', '3', '2930', '343', null);
INSERT INTO `zn_area` VALUES ('2931', '林周县', '3', '2931', '343', null);
INSERT INTO `zn_area` VALUES ('2932', '当雄县', '3', '2932', '343', null);
INSERT INTO `zn_area` VALUES ('2933', '尼木县', '3', '2933', '343', null);
INSERT INTO `zn_area` VALUES ('2934', '曲水县', '3', '2934', '343', null);
INSERT INTO `zn_area` VALUES ('2935', '堆龙德庆县', '3', '2935', '343', null);
INSERT INTO `zn_area` VALUES ('2936', '达孜县', '3', '2936', '343', null);
INSERT INTO `zn_area` VALUES ('2937', '墨竹工卡县', '3', '2937', '343', null);
INSERT INTO `zn_area` VALUES ('2938', '噶尔县', '3', '2938', '344', null);
INSERT INTO `zn_area` VALUES ('2939', '普兰县', '3', '2939', '344', null);
INSERT INTO `zn_area` VALUES ('294', '威海', '2', '294', '21', null);
INSERT INTO `zn_area` VALUES ('2940', '札达县', '3', '2940', '344', null);
INSERT INTO `zn_area` VALUES ('2941', '日土县', '3', '2941', '344', null);
INSERT INTO `zn_area` VALUES ('2942', '革吉县', '3', '2942', '344', null);
INSERT INTO `zn_area` VALUES ('2943', '改则县', '3', '2943', '344', null);
INSERT INTO `zn_area` VALUES ('2944', '措勤县', '3', '2944', '344', null);
INSERT INTO `zn_area` VALUES ('2945', '昌都县', '3', '2945', '345', null);
INSERT INTO `zn_area` VALUES ('2946', '江达县', '3', '2946', '345', null);
INSERT INTO `zn_area` VALUES ('2947', '贡觉县', '3', '2947', '345', null);
INSERT INTO `zn_area` VALUES ('2948', '类乌齐县', '3', '2948', '345', null);
INSERT INTO `zn_area` VALUES ('2949', '丁青县', '3', '2949', '345', null);
INSERT INTO `zn_area` VALUES ('295', '潍坊', '2', '295', '21', null);
INSERT INTO `zn_area` VALUES ('2950', '察雅县', '3', '2950', '345', null);
INSERT INTO `zn_area` VALUES ('2951', '八宿县', '3', '2951', '345', null);
INSERT INTO `zn_area` VALUES ('2952', '左贡县', '3', '2952', '345', null);
INSERT INTO `zn_area` VALUES ('2953', '芒康县', '3', '2953', '345', null);
INSERT INTO `zn_area` VALUES ('2954', '洛隆县', '3', '2954', '345', null);
INSERT INTO `zn_area` VALUES ('2955', '边坝县', '3', '2955', '345', null);
INSERT INTO `zn_area` VALUES ('2956', '林芝县', '3', '2956', '346', null);
INSERT INTO `zn_area` VALUES ('2957', '工布江达县', '3', '2957', '346', null);
INSERT INTO `zn_area` VALUES ('2958', '米林县', '3', '2958', '346', null);
INSERT INTO `zn_area` VALUES ('2959', '墨脱县', '3', '2959', '346', null);
INSERT INTO `zn_area` VALUES ('296', '烟台', '2', '296', '21', null);
INSERT INTO `zn_area` VALUES ('2960', '波密县', '3', '2960', '346', null);
INSERT INTO `zn_area` VALUES ('2961', '察隅县', '3', '2961', '346', null);
INSERT INTO `zn_area` VALUES ('2962', '朗县', '3', '2962', '346', null);
INSERT INTO `zn_area` VALUES ('2963', '那曲县', '3', '2963', '347', null);
INSERT INTO `zn_area` VALUES ('2964', '嘉黎县', '3', '2964', '347', null);
INSERT INTO `zn_area` VALUES ('2965', '比如县', '3', '2965', '347', null);
INSERT INTO `zn_area` VALUES ('2966', '聂荣县', '3', '2966', '347', null);
INSERT INTO `zn_area` VALUES ('2967', '安多县', '3', '2967', '347', null);
INSERT INTO `zn_area` VALUES ('2968', '申扎县', '3', '2968', '347', null);
INSERT INTO `zn_area` VALUES ('2969', '索县', '3', '2969', '347', null);
INSERT INTO `zn_area` VALUES ('297', '枣庄', '2', '297', '21', null);
INSERT INTO `zn_area` VALUES ('2970', '班戈县', '3', '2970', '347', null);
INSERT INTO `zn_area` VALUES ('2971', '巴青县', '3', '2971', '347', null);
INSERT INTO `zn_area` VALUES ('2972', '尼玛县', '3', '2972', '347', null);
INSERT INTO `zn_area` VALUES ('2973', '日喀则市', '3', '2973', '348', null);
INSERT INTO `zn_area` VALUES ('2974', '南木林县', '3', '2974', '348', null);
INSERT INTO `zn_area` VALUES ('2975', '江孜县', '3', '2975', '348', null);
INSERT INTO `zn_area` VALUES ('2976', '定日县', '3', '2976', '348', null);
INSERT INTO `zn_area` VALUES ('2977', '萨迦县', '3', '2977', '348', null);
INSERT INTO `zn_area` VALUES ('2978', '拉孜县', '3', '2978', '348', null);
INSERT INTO `zn_area` VALUES ('2979', '昂仁县', '3', '2979', '348', null);
INSERT INTO `zn_area` VALUES ('298', '淄博', '2', '298', '21', null);
INSERT INTO `zn_area` VALUES ('2980', '谢通门县', '3', '2980', '348', null);
INSERT INTO `zn_area` VALUES ('2981', '白朗县', '3', '2981', '348', null);
INSERT INTO `zn_area` VALUES ('2982', '仁布县', '3', '2982', '348', null);
INSERT INTO `zn_area` VALUES ('2983', '康马县', '3', '2983', '348', null);
INSERT INTO `zn_area` VALUES ('2984', '定结县', '3', '2984', '348', null);
INSERT INTO `zn_area` VALUES ('2985', '仲巴县', '3', '2985', '348', null);
INSERT INTO `zn_area` VALUES ('2986', '亚东县', '3', '2986', '348', null);
INSERT INTO `zn_area` VALUES ('2987', '吉隆县', '3', '2987', '348', null);
INSERT INTO `zn_area` VALUES ('2988', '聂拉木县', '3', '2988', '348', null);
INSERT INTO `zn_area` VALUES ('2989', '萨嘎县', '3', '2989', '348', null);
INSERT INTO `zn_area` VALUES ('299', '太原', '2', '299', '22', null);
INSERT INTO `zn_area` VALUES ('2990', '岗巴县', '3', '2990', '348', null);
INSERT INTO `zn_area` VALUES ('2991', '乃东县', '3', '2991', '349', null);
INSERT INTO `zn_area` VALUES ('2992', '扎囊县', '3', '2992', '349', null);
INSERT INTO `zn_area` VALUES ('2993', '贡嘎县', '3', '2993', '349', null);
INSERT INTO `zn_area` VALUES ('2994', '桑日县', '3', '2994', '349', null);
INSERT INTO `zn_area` VALUES ('2995', '琼结县', '3', '2995', '349', null);
INSERT INTO `zn_area` VALUES ('2996', '曲松县', '3', '2996', '349', null);
INSERT INTO `zn_area` VALUES ('2997', '措美县', '3', '2997', '349', null);
INSERT INTO `zn_area` VALUES ('2998', '洛扎县', '3', '2998', '349', null);
INSERT INTO `zn_area` VALUES ('2999', '加查县', '3', '2999', '349', null);
INSERT INTO `zn_area` VALUES ('3', '福建', '1', '3', '0', null);
INSERT INTO `zn_area` VALUES ('30', '浙江', '1', '30', '0', null);
INSERT INTO `zn_area` VALUES ('300', '长治', '2', '300', '22', null);
INSERT INTO `zn_area` VALUES ('3000', '隆子县', '3', '3000', '349', null);
INSERT INTO `zn_area` VALUES ('3001', '错那县', '3', '3001', '349', null);
INSERT INTO `zn_area` VALUES ('3002', '浪卡子县', '3', '3002', '349', null);
INSERT INTO `zn_area` VALUES ('3003', '天山区', '3', '3003', '350', null);
INSERT INTO `zn_area` VALUES ('3004', '沙依巴克区', '3', '3004', '350', null);
INSERT INTO `zn_area` VALUES ('3005', '新市区', '3', '3005', '350', null);
INSERT INTO `zn_area` VALUES ('3006', '水磨沟区', '3', '3006', '350', null);
INSERT INTO `zn_area` VALUES ('3007', '头屯河区', '3', '3007', '350', null);
INSERT INTO `zn_area` VALUES ('3008', '达坂城区', '3', '3008', '350', null);
INSERT INTO `zn_area` VALUES ('3009', '米东区', '3', '3009', '350', null);
INSERT INTO `zn_area` VALUES ('301', '大同', '2', '301', '22', null);
INSERT INTO `zn_area` VALUES ('3010', '乌鲁木齐县', '3', '3010', '350', null);
INSERT INTO `zn_area` VALUES ('3011', '阿克苏市', '3', '3011', '351', null);
INSERT INTO `zn_area` VALUES ('3012', '温宿县', '3', '3012', '351', null);
INSERT INTO `zn_area` VALUES ('3013', '库车县', '3', '3013', '351', null);
INSERT INTO `zn_area` VALUES ('3014', '沙雅县', '3', '3014', '351', null);
INSERT INTO `zn_area` VALUES ('3015', '新和县', '3', '3015', '351', null);
INSERT INTO `zn_area` VALUES ('3016', '拜城县', '3', '3016', '351', null);
INSERT INTO `zn_area` VALUES ('3017', '乌什县', '3', '3017', '351', null);
INSERT INTO `zn_area` VALUES ('3018', '阿瓦提县', '3', '3018', '351', null);
INSERT INTO `zn_area` VALUES ('3019', '柯坪县', '3', '3019', '351', null);
INSERT INTO `zn_area` VALUES ('302', '晋城', '2', '302', '22', null);
INSERT INTO `zn_area` VALUES ('3020', '阿拉尔市', '3', '3020', '352', null);
INSERT INTO `zn_area` VALUES ('3021', '库尔勒', '3', '3021', '353', null);
INSERT INTO `zn_area` VALUES ('3022', '轮台县', '3', '3022', '353', null);
INSERT INTO `zn_area` VALUES ('3023', '尉犁县', '3', '3023', '353', null);
INSERT INTO `zn_area` VALUES ('3024', '若羌县', '3', '3024', '353', null);
INSERT INTO `zn_area` VALUES ('3025', '且末县', '3', '3025', '353', null);
INSERT INTO `zn_area` VALUES ('3026', '焉耆县', '3', '3026', '353', null);
INSERT INTO `zn_area` VALUES ('3027', '和静县', '3', '3027', '353', null);
INSERT INTO `zn_area` VALUES ('3028', '和硕县', '3', '3028', '353', null);
INSERT INTO `zn_area` VALUES ('3029', '博湖县', '3', '3029', '353', null);
INSERT INTO `zn_area` VALUES ('303', '晋中', '2', '303', '22', null);
INSERT INTO `zn_area` VALUES ('3030', '博乐市', '3', '3030', '354', null);
INSERT INTO `zn_area` VALUES ('3031', '精河县', '3', '3031', '354', null);
INSERT INTO `zn_area` VALUES ('3032', '温泉县', '3', '3032', '354', null);
INSERT INTO `zn_area` VALUES ('3033', '呼图壁县', '3', '3033', '355', null);
INSERT INTO `zn_area` VALUES ('3034', '米泉市', '3', '3034', '355', null);
INSERT INTO `zn_area` VALUES ('3035', '昌吉市', '3', '3035', '355', null);
INSERT INTO `zn_area` VALUES ('3036', '阜康市', '3', '3036', '355', null);
INSERT INTO `zn_area` VALUES ('3037', '玛纳斯县', '3', '3037', '355', null);
INSERT INTO `zn_area` VALUES ('3038', '奇台县', '3', '3038', '355', null);
INSERT INTO `zn_area` VALUES ('3039', '吉木萨尔县', '3', '3039', '355', null);
INSERT INTO `zn_area` VALUES ('304', '临汾', '2', '304', '22', null);
INSERT INTO `zn_area` VALUES ('3040', '木垒县', '3', '3040', '355', null);
INSERT INTO `zn_area` VALUES ('3041', '哈密市', '3', '3041', '356', null);
INSERT INTO `zn_area` VALUES ('3042', '伊吾县', '3', '3042', '356', null);
INSERT INTO `zn_area` VALUES ('3043', '巴里坤', '3', '3043', '356', null);
INSERT INTO `zn_area` VALUES ('3044', '和田市', '3', '3044', '357', null);
INSERT INTO `zn_area` VALUES ('3045', '和田县', '3', '3045', '357', null);
INSERT INTO `zn_area` VALUES ('3046', '墨玉县', '3', '3046', '357', null);
INSERT INTO `zn_area` VALUES ('3047', '皮山县', '3', '3047', '357', null);
INSERT INTO `zn_area` VALUES ('3048', '洛浦县', '3', '3048', '357', null);
INSERT INTO `zn_area` VALUES ('3049', '策勒县', '3', '3049', '357', null);
INSERT INTO `zn_area` VALUES ('305', '吕梁', '2', '305', '22', null);
INSERT INTO `zn_area` VALUES ('3050', '于田县', '3', '3050', '357', null);
INSERT INTO `zn_area` VALUES ('3051', '民丰县', '3', '3051', '357', null);
INSERT INTO `zn_area` VALUES ('3052', '喀什市', '3', '3052', '358', null);
INSERT INTO `zn_area` VALUES ('3053', '疏附县', '3', '3053', '358', null);
INSERT INTO `zn_area` VALUES ('3054', '疏勒县', '3', '3054', '358', null);
INSERT INTO `zn_area` VALUES ('3055', '英吉沙县', '3', '3055', '358', null);
INSERT INTO `zn_area` VALUES ('3056', '泽普县', '3', '3056', '358', null);
INSERT INTO `zn_area` VALUES ('3057', '莎车县', '3', '3057', '358', null);
INSERT INTO `zn_area` VALUES ('3058', '叶城县', '3', '3058', '358', null);
INSERT INTO `zn_area` VALUES ('3059', '麦盖提县', '3', '3059', '358', null);
INSERT INTO `zn_area` VALUES ('306', '朔州', '2', '306', '22', null);
INSERT INTO `zn_area` VALUES ('3060', '岳普湖县', '3', '3060', '358', null);
INSERT INTO `zn_area` VALUES ('3061', '伽师县', '3', '3061', '358', null);
INSERT INTO `zn_area` VALUES ('3062', '巴楚县', '3', '3062', '358', null);
INSERT INTO `zn_area` VALUES ('3063', '塔什库尔干', '3', '3063', '358', null);
INSERT INTO `zn_area` VALUES ('3064', '克拉玛依市', '3', '3064', '359', null);
INSERT INTO `zn_area` VALUES ('3065', '阿图什市', '3', '3065', '360', null);
INSERT INTO `zn_area` VALUES ('3066', '阿克陶县', '3', '3066', '360', null);
INSERT INTO `zn_area` VALUES ('3067', '阿合奇县', '3', '3067', '360', null);
INSERT INTO `zn_area` VALUES ('3068', '乌恰县', '3', '3068', '360', null);
INSERT INTO `zn_area` VALUES ('3069', '石河子市', '3', '3069', '361', null);
INSERT INTO `zn_area` VALUES ('307', '忻州', '2', '307', '22', null);
INSERT INTO `zn_area` VALUES ('3071', '吐鲁番市', '3', '3071', '363', null);
INSERT INTO `zn_area` VALUES ('3072', '鄯善县', '3', '3072', '363', null);
INSERT INTO `zn_area` VALUES ('3073', '托克逊县', '3', '3073', '363', null);
INSERT INTO `zn_area` VALUES ('3075', '阿勒泰', '3', '3075', '365', null);
INSERT INTO `zn_area` VALUES ('3076', '和布克赛尔', '3', '3076', '365', null);
INSERT INTO `zn_area` VALUES ('3077', '伊宁市', '3', '3077', '365', null);
INSERT INTO `zn_area` VALUES ('3078', '布尔津县', '3', '3078', '365', null);
INSERT INTO `zn_area` VALUES ('3079', '奎屯市', '3', '3079', '365', null);
INSERT INTO `zn_area` VALUES ('308', '阳泉', '2', '308', '22', null);
INSERT INTO `zn_area` VALUES ('3080', '乌苏市', '3', '3080', '365', null);
INSERT INTO `zn_area` VALUES ('3081', '额敏县', '3', '3081', '365', null);
INSERT INTO `zn_area` VALUES ('3082', '富蕴县', '3', '3082', '365', null);
INSERT INTO `zn_area` VALUES ('3083', '伊宁县', '3', '3083', '365', null);
INSERT INTO `zn_area` VALUES ('3084', '福海县', '3', '3084', '365', null);
INSERT INTO `zn_area` VALUES ('3085', '霍城县', '3', '3085', '365', null);
INSERT INTO `zn_area` VALUES ('3086', '沙湾县', '3', '3086', '365', null);
INSERT INTO `zn_area` VALUES ('3087', '巩留县', '3', '3087', '365', null);
INSERT INTO `zn_area` VALUES ('3088', '哈巴河县', '3', '3088', '365', null);
INSERT INTO `zn_area` VALUES ('3089', '托里县', '3', '3089', '365', null);
INSERT INTO `zn_area` VALUES ('309', '运城', '2', '309', '22', null);
INSERT INTO `zn_area` VALUES ('3090', '青河县', '3', '3090', '365', null);
INSERT INTO `zn_area` VALUES ('3091', '新源县', '3', '3091', '365', null);
INSERT INTO `zn_area` VALUES ('3092', '裕民县', '3', '3092', '365', null);
INSERT INTO `zn_area` VALUES ('3094', '吉木乃县', '3', '3094', '365', null);
INSERT INTO `zn_area` VALUES ('3095', '昭苏县', '3', '3095', '365', null);
INSERT INTO `zn_area` VALUES ('3096', '特克斯县', '3', '3096', '365', null);
INSERT INTO `zn_area` VALUES ('3097', '尼勒克县', '3', '3097', '365', null);
INSERT INTO `zn_area` VALUES ('3098', '察布查尔', '3', '3098', '365', null);
INSERT INTO `zn_area` VALUES ('3099', '盘龙区', '3', '3099', '366', null);
INSERT INTO `zn_area` VALUES ('31', '重庆', '1', '31', '0', null);
INSERT INTO `zn_area` VALUES ('310', '西安', '2', '310', '23', null);
INSERT INTO `zn_area` VALUES ('3100', '五华区', '3', '3100', '366', null);
INSERT INTO `zn_area` VALUES ('3101', '官渡区', '3', '3101', '366', null);
INSERT INTO `zn_area` VALUES ('3102', '西山区', '3', '3102', '366', null);
INSERT INTO `zn_area` VALUES ('3103', '东川区', '3', '3103', '366', null);
INSERT INTO `zn_area` VALUES ('3104', '安宁市', '3', '3104', '366', null);
INSERT INTO `zn_area` VALUES ('3105', '呈贡县', '3', '3105', '366', null);
INSERT INTO `zn_area` VALUES ('3106', '晋宁县', '3', '3106', '366', null);
INSERT INTO `zn_area` VALUES ('3107', '富民县', '3', '3107', '366', null);
INSERT INTO `zn_area` VALUES ('3108', '宜良县', '3', '3108', '366', null);
INSERT INTO `zn_area` VALUES ('3109', '嵩明县', '3', '3109', '366', null);
INSERT INTO `zn_area` VALUES ('311', '安康', '2', '311', '23', null);
INSERT INTO `zn_area` VALUES ('3110', '石林县', '3', '3110', '366', null);
INSERT INTO `zn_area` VALUES ('3111', '禄劝县', '3', '3111', '366', null);
INSERT INTO `zn_area` VALUES ('3112', '寻甸县', '3', '3112', '366', null);
INSERT INTO `zn_area` VALUES ('3113', '兰坪县', '3', '3113', '367', null);
INSERT INTO `zn_area` VALUES ('3114', '泸水县', '3', '3114', '367', null);
INSERT INTO `zn_area` VALUES ('3115', '福贡县', '3', '3115', '367', null);
INSERT INTO `zn_area` VALUES ('3116', '贡山县', '3', '3116', '367', null);
INSERT INTO `zn_area` VALUES ('3117', '宁洱县', '3', '3117', '368', null);
INSERT INTO `zn_area` VALUES ('3118', '思茅区', '3', '3118', '368', null);
INSERT INTO `zn_area` VALUES ('3119', '墨江县', '3', '3119', '368', null);
INSERT INTO `zn_area` VALUES ('312', '宝鸡', '2', '312', '23', null);
INSERT INTO `zn_area` VALUES ('3120', '景东县', '3', '3120', '368', null);
INSERT INTO `zn_area` VALUES ('3121', '景谷县', '3', '3121', '368', null);
INSERT INTO `zn_area` VALUES ('3122', '镇沅县', '3', '3122', '368', null);
INSERT INTO `zn_area` VALUES ('3123', '江城县', '3', '3123', '368', null);
INSERT INTO `zn_area` VALUES ('3124', '孟连县', '3', '3124', '368', null);
INSERT INTO `zn_area` VALUES ('3125', '澜沧县', '3', '3125', '368', null);
INSERT INTO `zn_area` VALUES ('3126', '西盟县', '3', '3126', '368', null);
INSERT INTO `zn_area` VALUES ('3127', '古城区', '3', '3127', '369', null);
INSERT INTO `zn_area` VALUES ('3128', '宁蒗县', '3', '3128', '369', null);
INSERT INTO `zn_area` VALUES ('3129', '玉龙县', '3', '3129', '369', null);
INSERT INTO `zn_area` VALUES ('313', '汉中', '2', '313', '23', null);
INSERT INTO `zn_area` VALUES ('3130', '永胜县', '3', '3130', '369', null);
INSERT INTO `zn_area` VALUES ('3131', '华坪县', '3', '3131', '369', null);
INSERT INTO `zn_area` VALUES ('3132', '隆阳区', '3', '3132', '370', null);
INSERT INTO `zn_area` VALUES ('3133', '施甸县', '3', '3133', '370', null);
INSERT INTO `zn_area` VALUES ('3134', '腾冲县', '3', '3134', '370', null);
INSERT INTO `zn_area` VALUES ('3135', '龙陵县', '3', '3135', '370', null);
INSERT INTO `zn_area` VALUES ('3136', '昌宁县', '3', '3136', '370', null);
INSERT INTO `zn_area` VALUES ('3137', '楚雄市', '3', '3137', '371', null);
INSERT INTO `zn_area` VALUES ('3138', '双柏县', '3', '3138', '371', null);
INSERT INTO `zn_area` VALUES ('3139', '牟定县', '3', '3139', '371', null);
INSERT INTO `zn_area` VALUES ('314', '商洛', '2', '314', '23', null);
INSERT INTO `zn_area` VALUES ('3140', '南华县', '3', '3140', '371', null);
INSERT INTO `zn_area` VALUES ('3141', '姚安县', '3', '3141', '371', null);
INSERT INTO `zn_area` VALUES ('3142', '大姚县', '3', '3142', '371', null);
INSERT INTO `zn_area` VALUES ('3143', '永仁县', '3', '3143', '371', null);
INSERT INTO `zn_area` VALUES ('3144', '元谋县', '3', '3144', '371', null);
INSERT INTO `zn_area` VALUES ('3145', '武定县', '3', '3145', '371', null);
INSERT INTO `zn_area` VALUES ('3146', '禄丰县', '3', '3146', '371', null);
INSERT INTO `zn_area` VALUES ('3147', '大理市', '3', '3147', '372', null);
INSERT INTO `zn_area` VALUES ('3148', '祥云县', '3', '3148', '372', null);
INSERT INTO `zn_area` VALUES ('3149', '宾川县', '3', '3149', '372', null);
INSERT INTO `zn_area` VALUES ('315', '铜川', '2', '315', '23', null);
INSERT INTO `zn_area` VALUES ('3150', '弥渡县', '3', '3150', '372', null);
INSERT INTO `zn_area` VALUES ('3151', '永平县', '3', '3151', '372', null);
INSERT INTO `zn_area` VALUES ('3152', '云龙县', '3', '3152', '372', null);
INSERT INTO `zn_area` VALUES ('3153', '洱源县', '3', '3153', '372', null);
INSERT INTO `zn_area` VALUES ('3154', '剑川县', '3', '3154', '372', null);
INSERT INTO `zn_area` VALUES ('3155', '鹤庆县', '3', '3155', '372', null);
INSERT INTO `zn_area` VALUES ('3156', '漾濞县', '3', '3156', '372', null);
INSERT INTO `zn_area` VALUES ('3157', '南涧县', '3', '3157', '372', null);
INSERT INTO `zn_area` VALUES ('3158', '巍山县', '3', '3158', '372', null);
INSERT INTO `zn_area` VALUES ('3159', '潞西市', '3', '3159', '373', null);
INSERT INTO `zn_area` VALUES ('316', '渭南', '2', '316', '23', null);
INSERT INTO `zn_area` VALUES ('3160', '瑞丽市', '3', '3160', '373', null);
INSERT INTO `zn_area` VALUES ('3161', '梁河县', '3', '3161', '373', null);
INSERT INTO `zn_area` VALUES ('3162', '盈江县', '3', '3162', '373', null);
INSERT INTO `zn_area` VALUES ('3163', '陇川县', '3', '3163', '373', null);
INSERT INTO `zn_area` VALUES ('3164', '香格里拉县', '3', '3164', '374', null);
INSERT INTO `zn_area` VALUES ('3165', '德钦县', '3', '3165', '374', null);
INSERT INTO `zn_area` VALUES ('3166', '维西县', '3', '3166', '374', null);
INSERT INTO `zn_area` VALUES ('3167', '泸西县', '3', '3167', '375', null);
INSERT INTO `zn_area` VALUES ('3168', '蒙自市', '3', '3168', '375', null);
INSERT INTO `zn_area` VALUES ('3169', '个旧市', '3', '3169', '375', null);
INSERT INTO `zn_area` VALUES ('317', '咸阳', '2', '317', '23', null);
INSERT INTO `zn_area` VALUES ('3170', '开远市', '3', '3170', '375', null);
INSERT INTO `zn_area` VALUES ('3171', '绿春县', '3', '3171', '375', null);
INSERT INTO `zn_area` VALUES ('3172', '建水县', '3', '3172', '375', null);
INSERT INTO `zn_area` VALUES ('3173', '石屏县', '3', '3173', '375', null);
INSERT INTO `zn_area` VALUES ('3174', '弥勒县', '3', '3174', '375', null);
INSERT INTO `zn_area` VALUES ('3175', '元阳县', '3', '3175', '375', null);
INSERT INTO `zn_area` VALUES ('3176', '红河县', '3', '3176', '375', null);
INSERT INTO `zn_area` VALUES ('3177', '金平县', '3', '3177', '375', null);
INSERT INTO `zn_area` VALUES ('3178', '河口县', '3', '3178', '375', null);
INSERT INTO `zn_area` VALUES ('3179', '屏边县', '3', '3179', '375', null);
INSERT INTO `zn_area` VALUES ('318', '延安', '2', '318', '23', null);
INSERT INTO `zn_area` VALUES ('3180', '临翔区', '3', '3180', '376', null);
INSERT INTO `zn_area` VALUES ('3181', '凤庆县', '3', '3181', '376', null);
INSERT INTO `zn_area` VALUES ('3182', '云县', '3', '3182', '376', null);
INSERT INTO `zn_area` VALUES ('3183', '永德县', '3', '3183', '376', null);
INSERT INTO `zn_area` VALUES ('3184', '镇康县', '3', '3184', '376', null);
INSERT INTO `zn_area` VALUES ('3185', '双江县', '3', '3185', '376', null);
INSERT INTO `zn_area` VALUES ('3186', '耿马县', '3', '3186', '376', null);
INSERT INTO `zn_area` VALUES ('3187', '沧源县', '3', '3187', '376', null);
INSERT INTO `zn_area` VALUES ('3188', '麒麟区', '3', '3188', '377', null);
INSERT INTO `zn_area` VALUES ('3189', '宣威市', '3', '3189', '377', null);
INSERT INTO `zn_area` VALUES ('319', '榆林', '2', '319', '23', null);
INSERT INTO `zn_area` VALUES ('3190', '马龙县', '3', '3190', '377', null);
INSERT INTO `zn_area` VALUES ('3191', '陆良县', '3', '3191', '377', null);
INSERT INTO `zn_area` VALUES ('3192', '师宗县', '3', '3192', '377', null);
INSERT INTO `zn_area` VALUES ('3193', '罗平县', '3', '3193', '377', null);
INSERT INTO `zn_area` VALUES ('3194', '富源县', '3', '3194', '377', null);
INSERT INTO `zn_area` VALUES ('3195', '会泽县', '3', '3195', '377', null);
INSERT INTO `zn_area` VALUES ('3196', '沾益县', '3', '3196', '377', null);
INSERT INTO `zn_area` VALUES ('3197', '文山县', '3', '3197', '378', null);
INSERT INTO `zn_area` VALUES ('3198', '砚山县', '3', '3198', '378', null);
INSERT INTO `zn_area` VALUES ('3199', '西畴县', '3', '3199', '378', null);
INSERT INTO `zn_area` VALUES ('32', '香港', '1', '32', '0', null);
INSERT INTO `zn_area` VALUES ('3200', '麻栗坡县', '3', '3200', '378', null);
INSERT INTO `zn_area` VALUES ('3201', '马关县', '3', '3201', '378', null);
INSERT INTO `zn_area` VALUES ('3202', '丘北县', '3', '3202', '378', null);
INSERT INTO `zn_area` VALUES ('3203', '广南县', '3', '3203', '378', null);
INSERT INTO `zn_area` VALUES ('3204', '富宁县', '3', '3204', '378', null);
INSERT INTO `zn_area` VALUES ('3205', '景洪市', '3', '3205', '379', null);
INSERT INTO `zn_area` VALUES ('3206', '勐海县', '3', '3206', '379', null);
INSERT INTO `zn_area` VALUES ('3207', '勐腊县', '3', '3207', '379', null);
INSERT INTO `zn_area` VALUES ('3208', '红塔区', '3', '3208', '380', null);
INSERT INTO `zn_area` VALUES ('3209', '江川县', '3', '3209', '380', null);
INSERT INTO `zn_area` VALUES ('321', '成都', '2', '321', '25', null);
INSERT INTO `zn_area` VALUES ('3210', '澄江县', '3', '3210', '380', null);
INSERT INTO `zn_area` VALUES ('3211', '通海县', '3', '3211', '380', null);
INSERT INTO `zn_area` VALUES ('3212', '华宁县', '3', '3212', '380', null);
INSERT INTO `zn_area` VALUES ('3213', '易门县', '3', '3213', '380', null);
INSERT INTO `zn_area` VALUES ('3214', '峨山县', '3', '3214', '380', null);
INSERT INTO `zn_area` VALUES ('3215', '新平县', '3', '3215', '380', null);
INSERT INTO `zn_area` VALUES ('3216', '元江县', '3', '3216', '380', null);
INSERT INTO `zn_area` VALUES ('3217', '昭阳区', '3', '3217', '381', null);
INSERT INTO `zn_area` VALUES ('3218', '鲁甸县', '3', '3218', '381', null);
INSERT INTO `zn_area` VALUES ('3219', '巧家县', '3', '3219', '381', null);
INSERT INTO `zn_area` VALUES ('322', '绵阳', '2', '322', '25', null);
INSERT INTO `zn_area` VALUES ('3220', '盐津县', '3', '3220', '381', null);
INSERT INTO `zn_area` VALUES ('3221', '大关县', '3', '3221', '381', null);
INSERT INTO `zn_area` VALUES ('3222', '永善县', '3', '3222', '381', null);
INSERT INTO `zn_area` VALUES ('3223', '绥江县', '3', '3223', '381', null);
INSERT INTO `zn_area` VALUES ('3224', '镇雄县', '3', '3224', '381', null);
INSERT INTO `zn_area` VALUES ('3225', '彝良县', '3', '3225', '381', null);
INSERT INTO `zn_area` VALUES ('3226', '威信县', '3', '3226', '381', null);
INSERT INTO `zn_area` VALUES ('3227', '水富县', '3', '3227', '381', null);
INSERT INTO `zn_area` VALUES ('3228', '西湖区', '3', '3228', '382', null);
INSERT INTO `zn_area` VALUES ('3229', '上城区', '3', '3229', '382', null);
INSERT INTO `zn_area` VALUES ('323', '阿坝', '2', '323', '25', null);
INSERT INTO `zn_area` VALUES ('3230', '下城区', '3', '3230', '382', null);
INSERT INTO `zn_area` VALUES ('3231', '拱墅区', '3', '3231', '382', null);
INSERT INTO `zn_area` VALUES ('3232', '滨江区', '3', '3232', '382', null);
INSERT INTO `zn_area` VALUES ('3233', '江干区', '3', '3233', '382', null);
INSERT INTO `zn_area` VALUES ('3234', '萧山区', '3', '3234', '382', null);
INSERT INTO `zn_area` VALUES ('3235', '余杭区', '3', '3235', '382', null);
INSERT INTO `zn_area` VALUES ('3237', '建德市', '3', '3237', '382', null);
INSERT INTO `zn_area` VALUES ('3238', '富阳区', '3', '3238', '382', null);
INSERT INTO `zn_area` VALUES ('3239', '临安市', '3', '3239', '382', null);
INSERT INTO `zn_area` VALUES ('324', '巴中', '2', '324', '25', null);
INSERT INTO `zn_area` VALUES ('3240', '桐庐县', '3', '3240', '382', null);
INSERT INTO `zn_area` VALUES ('3241', '淳安县', '3', '3241', '382', null);
INSERT INTO `zn_area` VALUES ('3242', '吴兴区', '3', '3242', '383', null);
INSERT INTO `zn_area` VALUES ('3243', '南浔区', '3', '3243', '383', null);
INSERT INTO `zn_area` VALUES ('3244', '德清县', '3', '3244', '383', null);
INSERT INTO `zn_area` VALUES ('3245', '长兴县', '3', '3245', '383', null);
INSERT INTO `zn_area` VALUES ('3246', '安吉县', '3', '3246', '383', null);
INSERT INTO `zn_area` VALUES ('3247', '南湖区', '3', '3247', '384', null);
INSERT INTO `zn_area` VALUES ('3248', '秀洲区', '3', '3248', '384', null);
INSERT INTO `zn_area` VALUES ('3249', '海宁市', '3', '3249', '384', null);
INSERT INTO `zn_area` VALUES ('325', '达州', '2', '325', '25', null);
INSERT INTO `zn_area` VALUES ('3250', '嘉善县', '3', '3250', '384', null);
INSERT INTO `zn_area` VALUES ('3251', '平湖市', '3', '3251', '384', null);
INSERT INTO `zn_area` VALUES ('3252', '桐乡市', '3', '3252', '384', null);
INSERT INTO `zn_area` VALUES ('3253', '海盐县', '3', '3253', '384', null);
INSERT INTO `zn_area` VALUES ('3254', '婺城区', '3', '3254', '385', null);
INSERT INTO `zn_area` VALUES ('3255', '金东区', '3', '3255', '385', null);
INSERT INTO `zn_area` VALUES ('3256', '兰溪市', '3', '3256', '385', null);
INSERT INTO `zn_area` VALUES ('3257', '义乌市', '3', '3257', '385', null);
INSERT INTO `zn_area` VALUES ('3258', '阜新县', '3', '3258', '250', null);
INSERT INTO `zn_area` VALUES ('3259', '加格达奇区', '3', '3259', '168', null);
INSERT INTO `zn_area` VALUES ('326', '德阳', '2', '326', '25', null);
INSERT INTO `zn_area` VALUES ('3260', '松岭区', '3', '3260', '168', null);
INSERT INTO `zn_area` VALUES ('3261', '新林区', '3', '3261', '168', null);
INSERT INTO `zn_area` VALUES ('3262', '呼中区', '3', '3262', '168', null);
INSERT INTO `zn_area` VALUES ('3263', '麻山区', '3', '3263', '171', null);
INSERT INTO `zn_area` VALUES ('3264', '东阳市', '3', '3264', '385', null);
INSERT INTO `zn_area` VALUES ('3265', '永康市', '3', '3265', '385', null);
INSERT INTO `zn_area` VALUES ('3266', '武义县', '3', '3266', '385', null);
INSERT INTO `zn_area` VALUES ('3267', '浦江县', '3', '3267', '385', null);
INSERT INTO `zn_area` VALUES ('3268', '磐安县', '3', '3268', '385', null);
INSERT INTO `zn_area` VALUES ('3269', '莲都区', '3', '3269', '386', null);
INSERT INTO `zn_area` VALUES ('327', '甘孜', '2', '327', '25', null);
INSERT INTO `zn_area` VALUES ('3270', '龙泉市', '3', '3270', '386', null);
INSERT INTO `zn_area` VALUES ('3271', '青田县', '3', '3271', '386', null);
INSERT INTO `zn_area` VALUES ('3272', '缙云县', '3', '3272', '386', null);
INSERT INTO `zn_area` VALUES ('3273', '遂昌县', '3', '3273', '386', null);
INSERT INTO `zn_area` VALUES ('3274', '松阳县', '3', '3274', '386', null);
INSERT INTO `zn_area` VALUES ('3275', '云和县', '3', '3275', '386', null);
INSERT INTO `zn_area` VALUES ('3276', '庆元县', '3', '3276', '386', null);
INSERT INTO `zn_area` VALUES ('3277', '景宁县', '3', '3277', '386', null);
INSERT INTO `zn_area` VALUES ('3278', '海曙区', '3', '3278', '387', null);
INSERT INTO `zn_area` VALUES ('3279', '江东区', '3', '3279', '387', null);
INSERT INTO `zn_area` VALUES ('328', '广安', '2', '328', '25', null);
INSERT INTO `zn_area` VALUES ('3280', '江北区', '3', '3280', '387', null);
INSERT INTO `zn_area` VALUES ('3281', '镇海区', '3', '3281', '387', null);
INSERT INTO `zn_area` VALUES ('3282', '北仑区', '3', '3282', '387', null);
INSERT INTO `zn_area` VALUES ('3283', '鄞州区', '3', '3283', '387', null);
INSERT INTO `zn_area` VALUES ('3284', '余姚市', '3', '3284', '387', null);
INSERT INTO `zn_area` VALUES ('3285', '慈溪市', '3', '3285', '387', null);
INSERT INTO `zn_area` VALUES ('3286', '奉化区', '3', '3286', '387', null);
INSERT INTO `zn_area` VALUES ('3287', '象山县', '3', '3287', '387', null);
INSERT INTO `zn_area` VALUES ('3288', '宁海县', '3', '3288', '387', null);
INSERT INTO `zn_area` VALUES ('3289', '越城区', '3', '3289', '388', null);
INSERT INTO `zn_area` VALUES ('329', '广元', '2', '329', '25', null);
INSERT INTO `zn_area` VALUES ('3290', '上虞区', '3', '3290', '388', null);
INSERT INTO `zn_area` VALUES ('3291', '嵊州市', '3', '3291', '388', null);
INSERT INTO `zn_area` VALUES ('3292', '绍兴县', '3', '3292', '388', null);
INSERT INTO `zn_area` VALUES ('3293', '新昌县', '3', '3293', '388', null);
INSERT INTO `zn_area` VALUES ('3294', '诸暨市', '3', '3294', '388', null);
INSERT INTO `zn_area` VALUES ('3295', '椒江区', '3', '3295', '389', null);
INSERT INTO `zn_area` VALUES ('3296', '黄岩区', '3', '3296', '389', null);
INSERT INTO `zn_area` VALUES ('3297', '路桥区', '3', '3297', '389', null);
INSERT INTO `zn_area` VALUES ('3298', '温岭市', '3', '3298', '389', null);
INSERT INTO `zn_area` VALUES ('3299', '临海市', '3', '3299', '389', null);
INSERT INTO `zn_area` VALUES ('33', '澳门', '1', '33', '0', null);
INSERT INTO `zn_area` VALUES ('330', '乐山', '2', '330', '25', null);
INSERT INTO `zn_area` VALUES ('3300', '玉环县', '3', '3300', '389', null);
INSERT INTO `zn_area` VALUES ('3301', '三门县', '3', '3301', '389', null);
INSERT INTO `zn_area` VALUES ('3302', '天台县', '3', '3302', '389', null);
INSERT INTO `zn_area` VALUES ('3303', '仙居县', '3', '3303', '389', null);
INSERT INTO `zn_area` VALUES ('3304', '鹿城区', '3', '3304', '390', null);
INSERT INTO `zn_area` VALUES ('3305', '龙湾区', '3', '3305', '390', null);
INSERT INTO `zn_area` VALUES ('3306', '瓯海区', '3', '3306', '390', null);
INSERT INTO `zn_area` VALUES ('3307', '瑞安市', '3', '3307', '390', null);
INSERT INTO `zn_area` VALUES ('3308', '乐清市', '3', '3308', '390', null);
INSERT INTO `zn_area` VALUES ('3309', '洞头区', '3', '3309', '390', null);
INSERT INTO `zn_area` VALUES ('331', '凉山', '2', '331', '25', null);
INSERT INTO `zn_area` VALUES ('3310', '永嘉县', '3', '3310', '390', null);
INSERT INTO `zn_area` VALUES ('3311', '平阳县', '3', '3311', '390', null);
INSERT INTO `zn_area` VALUES ('3312', '苍南县', '3', '3312', '390', null);
INSERT INTO `zn_area` VALUES ('3313', '文成县', '3', '3313', '390', null);
INSERT INTO `zn_area` VALUES ('3314', '泰顺县', '3', '3314', '390', null);
INSERT INTO `zn_area` VALUES ('3315', '定海区', '3', '3315', '391', null);
INSERT INTO `zn_area` VALUES ('3316', '普陀区', '3', '3316', '391', null);
INSERT INTO `zn_area` VALUES ('3317', '岱山县', '3', '3317', '391', null);
INSERT INTO `zn_area` VALUES ('3318', '嵊泗县', '3', '3318', '391', null);
INSERT INTO `zn_area` VALUES ('3319', '衢江区', '3', '3319', '392', null);
INSERT INTO `zn_area` VALUES ('332', '眉山', '2', '332', '25', null);
INSERT INTO `zn_area` VALUES ('3320', '江山市', '3', '3320', '392', null);
INSERT INTO `zn_area` VALUES ('3321', '常山县', '3', '3321', '392', null);
INSERT INTO `zn_area` VALUES ('3322', '开化县', '3', '3322', '392', null);
INSERT INTO `zn_area` VALUES ('3323', '龙游县', '3', '3323', '392', null);
INSERT INTO `zn_area` VALUES ('3324', '合川区', '2', '3324', '31', null);
INSERT INTO `zn_area` VALUES ('3325', '江津区', '2', '3325', '31', null);
INSERT INTO `zn_area` VALUES ('3326', '南川区', '2', '3326', '31', null);
INSERT INTO `zn_area` VALUES ('3327', '永川区', '2', '3327', '31', null);
INSERT INTO `zn_area` VALUES ('3328', '南岸区', '2', '3328', '31', null);
INSERT INTO `zn_area` VALUES ('3329', '渝北区', '2', '3329', '31', null);
INSERT INTO `zn_area` VALUES ('333', '南充', '2', '333', '25', null);
INSERT INTO `zn_area` VALUES ('3330', '万盛区', '2', '3330', '31', null);
INSERT INTO `zn_area` VALUES ('3331', '大渡口区', '2', '3331', '31', null);
INSERT INTO `zn_area` VALUES ('3332', '万州区', '2', '3332', '31', null);
INSERT INTO `zn_area` VALUES ('3333', '北碚区', '2', '3333', '31', null);
INSERT INTO `zn_area` VALUES ('3334', '沙坪坝区', '2', '3334', '31', null);
INSERT INTO `zn_area` VALUES ('3335', '巴南区', '2', '3335', '31', null);
INSERT INTO `zn_area` VALUES ('3336', '涪陵区', '2', '3336', '31', null);
INSERT INTO `zn_area` VALUES ('3337', '江北区', '2', '3337', '31', null);
INSERT INTO `zn_area` VALUES ('3338', '九龙坡区', '2', '3338', '31', null);
INSERT INTO `zn_area` VALUES ('3339', '渝中区', '2', '3339', '31', null);
INSERT INTO `zn_area` VALUES ('334', '内江', '2', '334', '25', null);
INSERT INTO `zn_area` VALUES ('3340', '黔江区', '2', '3340', '31', null);
INSERT INTO `zn_area` VALUES ('3341', '长寿区', '2', '3341', '31', null);
INSERT INTO `zn_area` VALUES ('3342', '双桥区', '2', '3342', '31', null);
INSERT INTO `zn_area` VALUES ('3343', '綦江区', '2', '3343', '31', null);
INSERT INTO `zn_area` VALUES ('3344', '潼南区', '2', '3344', '31', null);
INSERT INTO `zn_area` VALUES ('3345', '铜梁区', '2', '3345', '31', null);
INSERT INTO `zn_area` VALUES ('3346', '大足县', '2', '3346', '31', null);
INSERT INTO `zn_area` VALUES ('3347', '荣昌区', '2', '3347', '31', null);
INSERT INTO `zn_area` VALUES ('3348', '璧山区', '2', '3348', '31', null);
INSERT INTO `zn_area` VALUES ('3349', '垫江县', '2', '3349', '31', null);
INSERT INTO `zn_area` VALUES ('335', '攀枝花', '2', '335', '25', null);
INSERT INTO `zn_area` VALUES ('3350', '武隆县', '2', '3350', '31', null);
INSERT INTO `zn_area` VALUES ('3351', '丰都县', '2', '3351', '31', null);
INSERT INTO `zn_area` VALUES ('3352', '城口县', '2', '3352', '31', null);
INSERT INTO `zn_area` VALUES ('3353', '梁平县', '2', '3353', '31', null);
INSERT INTO `zn_area` VALUES ('3354', '开县', '2', '3354', '31', null);
INSERT INTO `zn_area` VALUES ('3355', '巫溪县', '2', '3355', '31', null);
INSERT INTO `zn_area` VALUES ('3356', '巫山县', '2', '3356', '31', null);
INSERT INTO `zn_area` VALUES ('3357', '奉节县', '2', '3357', '31', null);
INSERT INTO `zn_area` VALUES ('3358', '云阳县', '2', '3358', '31', null);
INSERT INTO `zn_area` VALUES ('3359', '忠县', '2', '3359', '31', null);
INSERT INTO `zn_area` VALUES ('336', '遂宁', '2', '336', '25', null);
INSERT INTO `zn_area` VALUES ('3360', '石柱县', '2', '3360', '31', null);
INSERT INTO `zn_area` VALUES ('3361', '彭水县', '2', '3361', '31', null);
INSERT INTO `zn_area` VALUES ('3362', '酉阳县', '2', '3362', '31', null);
INSERT INTO `zn_area` VALUES ('3363', '秀山县', '2', '3363', '31', null);
INSERT INTO `zn_area` VALUES ('3364', '沙田区', '2', '3364', '32', null);
INSERT INTO `zn_area` VALUES ('3365', '东区', '2', '3365', '32', null);
INSERT INTO `zn_area` VALUES ('3366', '观塘区', '2', '3366', '32', null);
INSERT INTO `zn_area` VALUES ('3367', '黄大仙区', '2', '3367', '32', null);
INSERT INTO `zn_area` VALUES ('3368', '九龙城区', '2', '3368', '32', null);
INSERT INTO `zn_area` VALUES ('3369', '屯门区', '2', '3369', '32', null);
INSERT INTO `zn_area` VALUES ('337', '雅安', '2', '337', '25', null);
INSERT INTO `zn_area` VALUES ('3370', '葵青区', '2', '3370', '32', null);
INSERT INTO `zn_area` VALUES ('3371', '元朗区', '2', '3371', '32', null);
INSERT INTO `zn_area` VALUES ('3372', '深水埗区', '2', '3372', '32', null);
INSERT INTO `zn_area` VALUES ('3373', '西贡区', '2', '3373', '32', null);
INSERT INTO `zn_area` VALUES ('3374', '大埔区', '2', '3374', '32', null);
INSERT INTO `zn_area` VALUES ('3375', '湾仔区', '2', '3375', '32', null);
INSERT INTO `zn_area` VALUES ('3376', '油尖旺区', '2', '3376', '32', null);
INSERT INTO `zn_area` VALUES ('3377', '北区', '2', '3377', '32', null);
INSERT INTO `zn_area` VALUES ('3378', '南区', '2', '3378', '32', null);
INSERT INTO `zn_area` VALUES ('3379', '荃湾区', '2', '3379', '32', null);
INSERT INTO `zn_area` VALUES ('338', '宜宾', '2', '338', '25', null);
INSERT INTO `zn_area` VALUES ('3380', '中西区', '2', '3380', '32', null);
INSERT INTO `zn_area` VALUES ('3381', '离岛区', '2', '3381', '32', null);
INSERT INTO `zn_area` VALUES ('3383', '台北', '2', '3383', '34', null);
INSERT INTO `zn_area` VALUES ('3384', '高雄', '2', '3384', '34', null);
INSERT INTO `zn_area` VALUES ('3385', '基隆', '2', '3385', '34', null);
INSERT INTO `zn_area` VALUES ('3386', '台中', '2', '3386', '34', null);
INSERT INTO `zn_area` VALUES ('3387', '台南', '2', '3387', '34', null);
INSERT INTO `zn_area` VALUES ('3388', '新竹', '2', '3388', '34', null);
INSERT INTO `zn_area` VALUES ('3389', '嘉义', '2', '3389', '34', null);
INSERT INTO `zn_area` VALUES ('339', '资阳', '2', '339', '25', null);
INSERT INTO `zn_area` VALUES ('3390', '宜兰县', '2', '3390', '34', null);
INSERT INTO `zn_area` VALUES ('3391', '桃园县', '2', '3391', '34', null);
INSERT INTO `zn_area` VALUES ('3392', '苗栗县', '2', '3392', '34', null);
INSERT INTO `zn_area` VALUES ('3393', '彰化县', '2', '3393', '34', null);
INSERT INTO `zn_area` VALUES ('3394', '南投县', '2', '3394', '34', null);
INSERT INTO `zn_area` VALUES ('3395', '云林县', '2', '3395', '34', null);
INSERT INTO `zn_area` VALUES ('3396', '屏东县', '2', '3396', '34', null);
INSERT INTO `zn_area` VALUES ('3397', '台东县', '2', '3397', '34', null);
INSERT INTO `zn_area` VALUES ('3398', '花莲县', '2', '3398', '34', null);
INSERT INTO `zn_area` VALUES ('3399', '澎湖县', '2', '3399', '34', null);
INSERT INTO `zn_area` VALUES ('34', '台湾', '1', '34', '0', null);
INSERT INTO `zn_area` VALUES ('340', '自贡', '2', '340', '25', null);
INSERT INTO `zn_area` VALUES ('3400', '合肥', '2', '3400', '2', null);
INSERT INTO `zn_area` VALUES ('3401', '庐阳区', '3', '3401', '3400', null);
INSERT INTO `zn_area` VALUES ('3402', '瑶海区', '3', '3402', '3400', null);
INSERT INTO `zn_area` VALUES ('3403', '蜀山区', '3', '3403', '3400', null);
INSERT INTO `zn_area` VALUES ('3404', '包河区', '3', '3404', '3400', null);
INSERT INTO `zn_area` VALUES ('3405', '长丰县', '3', '3405', '3400', null);
INSERT INTO `zn_area` VALUES ('3406', '肥东县', '3', '3406', '3400', null);
INSERT INTO `zn_area` VALUES ('3407', '肥西县', '3', '3407', '3400', null);
INSERT INTO `zn_area` VALUES ('3408', '马来西亚', '2', '3408', '51', null);
INSERT INTO `zn_area` VALUES ('3409', '印度尼西亚', '2', '3409', '51', null);
INSERT INTO `zn_area` VALUES ('341', '泸州', '2', '341', '25', null);
INSERT INTO `zn_area` VALUES ('3410', '菲律宾', '2', '3410', '51', null);
INSERT INTO `zn_area` VALUES ('3411', '新加坡', '2', '3411', '51', null);
INSERT INTO `zn_area` VALUES ('3412', '泰国', '2', '3412', '51', null);
INSERT INTO `zn_area` VALUES ('3413', '关岛', '2', '3413', '51', null);
INSERT INTO `zn_area` VALUES ('3414', '文莱', '2', '3414', '51', null);
INSERT INTO `zn_area` VALUES ('3415', '日本', '2', '3415', '51', null);
INSERT INTO `zn_area` VALUES ('3416', '韩国', '2', '3416', '51', null);
INSERT INTO `zn_area` VALUES ('3417', '越南', '2', '3417', '51', null);
INSERT INTO `zn_area` VALUES ('3418', '朝鲜', '2', '3418', '51', null);
INSERT INTO `zn_area` VALUES ('3419', '柬埔寨', '2', '3419', '51', null);
INSERT INTO `zn_area` VALUES ('3420', '老挝', '2', '3420', '51', null);
INSERT INTO `zn_area` VALUES ('3421', '孟加拉国', '2', '3421', '51', null);
INSERT INTO `zn_area` VALUES ('3422', '土耳其', '2', '3422', '51', null);
INSERT INTO `zn_area` VALUES ('3423', '印度', '2', '3423', '51', null);
INSERT INTO `zn_area` VALUES ('3424', '巴基斯坦', '2', '3424', '51', null);
INSERT INTO `zn_area` VALUES ('3425', '斯里兰卡', '2', '3425', '51', null);
INSERT INTO `zn_area` VALUES ('3426', '马尔代夫', '2', '3426', '51', null);
INSERT INTO `zn_area` VALUES ('3427', '黎巴嫩', '2', '3427', '51', null);
INSERT INTO `zn_area` VALUES ('3428', '约旦', '2', '3428', '51', null);
INSERT INTO `zn_area` VALUES ('3429', '叙利亚', '2', '3429', '51', null);
INSERT INTO `zn_area` VALUES ('343', '拉萨', '2', '343', '27', null);
INSERT INTO `zn_area` VALUES ('3430', '伊拉克', '2', '3430', '51', null);
INSERT INTO `zn_area` VALUES ('3431', '科威特', '2', '3431', '51', null);
INSERT INTO `zn_area` VALUES ('3432', '沙特阿拉伯', '2', '3432', '51', null);
INSERT INTO `zn_area` VALUES ('3433', '也门', '2', '3433', '51', null);
INSERT INTO `zn_area` VALUES ('3434', '阿曼', '2', '3434', '51', null);
INSERT INTO `zn_area` VALUES ('3435', '阿拉伯联合酋长国', '2', '3435', '51', null);
INSERT INTO `zn_area` VALUES ('3436', '以色列', '2', '3436', '51', null);
INSERT INTO `zn_area` VALUES ('3437', '巴林', '2', '3437', '51', null);
INSERT INTO `zn_area` VALUES ('3438', '卡塔尔', '2', '3438', '51', null);
INSERT INTO `zn_area` VALUES ('3439', '不丹', '2', '3439', '51', null);
INSERT INTO `zn_area` VALUES ('344', '阿里', '2', '344', '27', null);
INSERT INTO `zn_area` VALUES ('3440', '蒙古', '2', '3440', '51', null);
INSERT INTO `zn_area` VALUES ('3441', '尼泊尔', '2', '3441', '51', null);
INSERT INTO `zn_area` VALUES ('3442', '伊朗', '2', '3442', '51', null);
INSERT INTO `zn_area` VALUES ('3443', '阿富汗', '2', '3443', '51', null);
INSERT INTO `zn_area` VALUES ('3444', '美国', '2', '3444', '51', null);
INSERT INTO `zn_area` VALUES ('3445', '加拿大', '2', '3445', '51', null);
INSERT INTO `zn_area` VALUES ('3446', '中途岛', '2', '3446', '51', null);
INSERT INTO `zn_area` VALUES ('3447', '威克岛', '2', '3447', '51', null);
INSERT INTO `zn_area` VALUES ('3448', '夏威夷', '2', '3448', '51', null);
INSERT INTO `zn_area` VALUES ('3449', '安圭拉岛', '2', '3449', '51', null);
INSERT INTO `zn_area` VALUES ('345', '昌都', '2', '345', '27', null);
INSERT INTO `zn_area` VALUES ('3450', '维尔京群岛', '2', '3450', '51', null);
INSERT INTO `zn_area` VALUES ('3451', '特立尼达和多巴哥', '2', '3451', '51', null);
INSERT INTO `zn_area` VALUES ('3452', '圣卢西亚', '2', '3452', '51', null);
INSERT INTO `zn_area` VALUES ('3453', '圣克里斯托费和尼维斯', '2', '3453', '51', null);
INSERT INTO `zn_area` VALUES ('3454', '波多黎各', '2', '3454', '51', null);
INSERT INTO `zn_area` VALUES ('3455', '蒙特塞拉特岛', '2', '3455', '51', null);
INSERT INTO `zn_area` VALUES ('3456', '牙买加', '2', '3456', '51', null);
INSERT INTO `zn_area` VALUES ('3457', '格林纳达', '2', '3457', '51', null);
INSERT INTO `zn_area` VALUES ('3458', '多米尼加共和国', '2', '3458', '51', null);
INSERT INTO `zn_area` VALUES ('3459', '开曼群岛', '2', '3459', '51', null);
INSERT INTO `zn_area` VALUES ('346', '林芝', '2', '346', '27', null);
INSERT INTO `zn_area` VALUES ('3460', '百慕大群岛', '2', '3460', '51', null);
INSERT INTO `zn_area` VALUES ('3461', '安提瓜和巴布达', '2', '3461', '51', null);
INSERT INTO `zn_area` VALUES ('3462', '巴哈马', '2', '3462', '51', null);
INSERT INTO `zn_area` VALUES ('3463', '巴巴多斯', '2', '3463', '51', null);
INSERT INTO `zn_area` VALUES ('3464', '特克斯和凯科斯群岛', '2', '3464', '51', null);
INSERT INTO `zn_area` VALUES ('3465', '阿拉斯加', '2', '3465', '51', null);
INSERT INTO `zn_area` VALUES ('3466', '法罗群岛', '2', '3466', '51', null);
INSERT INTO `zn_area` VALUES ('3467', '格陵兰岛', '2', '3467', '51', null);
INSERT INTO `zn_area` VALUES ('3468', '伯利兹', '2', '3468', '51', null);
INSERT INTO `zn_area` VALUES ('3469', '危地马拉', '2', '3469', '51', null);
INSERT INTO `zn_area` VALUES ('347', '那曲', '2', '347', '27', null);
INSERT INTO `zn_area` VALUES ('3470', '萨尔瓦多', '2', '3470', '51', null);
INSERT INTO `zn_area` VALUES ('3471', '洪都拉斯', '2', '3471', '51', null);
INSERT INTO `zn_area` VALUES ('3472', '尼加拉瓜', '2', '3472', '51', null);
INSERT INTO `zn_area` VALUES ('3473', '哥斯达黎加', '2', '3473', '51', null);
INSERT INTO `zn_area` VALUES ('3474', '巴拿马', '2', '3474', '51', null);
INSERT INTO `zn_area` VALUES ('3475', '海地', '2', '3475', '51', null);
INSERT INTO `zn_area` VALUES ('3476', '墨西哥', '2', '3476', '51', null);
INSERT INTO `zn_area` VALUES ('3477', '古巴', '2', '3477', '51', null);
INSERT INTO `zn_area` VALUES ('3478', '福克兰群岛', '2', '3478', '51', null);
INSERT INTO `zn_area` VALUES ('3479', '秘鲁', '2', '3479', '51', null);
INSERT INTO `zn_area` VALUES ('348', '日喀则', '2', '348', '27', null);
INSERT INTO `zn_area` VALUES ('3480', '阿根延', '2', '3480', '51', null);
INSERT INTO `zn_area` VALUES ('3481', '巴西', '2', '3481', '51', null);
INSERT INTO `zn_area` VALUES ('3482', '智利', '2', '3482', '51', null);
INSERT INTO `zn_area` VALUES ('3483', '哥伦比亚', '2', '3483', '51', null);
INSERT INTO `zn_area` VALUES ('3484', '委内瑞拉', '2', '3484', '51', null);
INSERT INTO `zn_area` VALUES ('3485', '玻利维亚', '2', '3485', '51', null);
INSERT INTO `zn_area` VALUES ('3486', '圭亚那', '2', '3486', '51', null);
INSERT INTO `zn_area` VALUES ('3487', '厄瓜多尔', '2', '3487', '51', null);
INSERT INTO `zn_area` VALUES ('3488', '法属圭亚那', '2', '3488', '51', null);
INSERT INTO `zn_area` VALUES ('3489', '巴拉圭', '2', '3489', '51', null);
INSERT INTO `zn_area` VALUES ('349', '山南', '2', '349', '27', null);
INSERT INTO `zn_area` VALUES ('3490', '马提尼克', '2', '3490', '51', null);
INSERT INTO `zn_area` VALUES ('3491', '苏里南', '2', '3491', '51', null);
INSERT INTO `zn_area` VALUES ('3492', '乌拉圭', '2', '3492', '51', null);
INSERT INTO `zn_area` VALUES ('3493', '荷属安的列斯群岛', '2', '3493', '51', null);
INSERT INTO `zn_area` VALUES ('3494', '圣文森特和格林纳丁斯', '2', '3494', '51', null);
INSERT INTO `zn_area` VALUES ('3495', '俄罗斯', '2', '3495', '51', null);
INSERT INTO `zn_area` VALUES ('3496', '希腊', '2', '3496', '51', null);
INSERT INTO `zn_area` VALUES ('3497', '荷兰', '2', '3497', '51', null);
INSERT INTO `zn_area` VALUES ('3498', '比利时', '2', '3498', '51', null);
INSERT INTO `zn_area` VALUES ('3499', '法国', '2', '3499', '51', null);
INSERT INTO `zn_area` VALUES ('35', '安庆', '2', '35', '2', null);
INSERT INTO `zn_area` VALUES ('350', '乌鲁木齐', '2', '350', '28', null);
INSERT INTO `zn_area` VALUES ('3500', '摩纳哥', '2', '3500', '51', null);
INSERT INTO `zn_area` VALUES ('3501', '安道尔', '2', '3501', '51', null);
INSERT INTO `zn_area` VALUES ('3502', '西班牙', '2', '3502', '51', null);
INSERT INTO `zn_area` VALUES ('3503', '加那利群岛', '2', '3503', '51', null);
INSERT INTO `zn_area` VALUES ('3504', '直布罗陀', '2', '3504', '51', null);
INSERT INTO `zn_area` VALUES ('3505', '葡萄牙', '2', '3505', '51', null);
INSERT INTO `zn_area` VALUES ('3506', '卢森保', '2', '3506', '51', null);
INSERT INTO `zn_area` VALUES ('3507', '爱尔兰', '2', '3507', '51', null);
INSERT INTO `zn_area` VALUES ('3508', '冰岛', '2', '3508', '51', null);
INSERT INTO `zn_area` VALUES ('3509', '阿尔巴尼亚', '2', '3509', '51', null);
INSERT INTO `zn_area` VALUES ('351', '阿克苏', '2', '351', '28', null);
INSERT INTO `zn_area` VALUES ('3510', '马耳他', '2', '3510', '51', null);
INSERT INTO `zn_area` VALUES ('3511', '塞浦路斯', '2', '3511', '51', null);
INSERT INTO `zn_area` VALUES ('3512', '芬兰', '2', '3512', '51', null);
INSERT INTO `zn_area` VALUES ('3513', '保加利亚', '2', '3513', '51', null);
INSERT INTO `zn_area` VALUES ('3514', '匈牙利', '2', '3514', '51', null);
INSERT INTO `zn_area` VALUES ('3515', '德国', '2', '3515', '51', null);
INSERT INTO `zn_area` VALUES ('3516', '南斯拉夫', '2', '3516', '51', null);
INSERT INTO `zn_area` VALUES ('3517', '意大利', '2', '3517', '51', null);
INSERT INTO `zn_area` VALUES ('3518', '圣马力诺', '2', '3518', '51', null);
INSERT INTO `zn_area` VALUES ('3519', '梵蒂冈', '2', '3519', '51', null);
INSERT INTO `zn_area` VALUES ('352', '阿拉尔', '2', '352', '28', null);
INSERT INTO `zn_area` VALUES ('3520', '罗马尼亚', '2', '3520', '51', null);
INSERT INTO `zn_area` VALUES ('3521', '瑞士', '2', '3521', '51', null);
INSERT INTO `zn_area` VALUES ('3522', '列士敦士登', '2', '3522', '51', null);
INSERT INTO `zn_area` VALUES ('3523', '奥地利', '2', '3523', '51', null);
INSERT INTO `zn_area` VALUES ('3524', '英国', '2', '3524', '51', null);
INSERT INTO `zn_area` VALUES ('3525', '丹麦', '2', '3525', '51', null);
INSERT INTO `zn_area` VALUES ('3526', '瑞典', '2', '3526', '51', null);
INSERT INTO `zn_area` VALUES ('3527', '挪威', '2', '3527', '51', null);
INSERT INTO `zn_area` VALUES ('3528', '法兰', '2', '3528', '51', null);
INSERT INTO `zn_area` VALUES ('3529', '埃及', '2', '3529', '51', null);
INSERT INTO `zn_area` VALUES ('353', '巴音郭楞', '2', '353', '28', null);
INSERT INTO `zn_area` VALUES ('3530', '摩洛哥', '2', '3530', '51', null);
INSERT INTO `zn_area` VALUES ('3531', '阿尔及利亚', '2', '3531', '51', null);
INSERT INTO `zn_area` VALUES ('3532', '突尼斯', '2', '3532', '51', null);
INSERT INTO `zn_area` VALUES ('3533', '利比亚', '2', '3533', '51', null);
INSERT INTO `zn_area` VALUES ('3534', '冈比亚', '2', '3534', '51', null);
INSERT INTO `zn_area` VALUES ('3535', '塞内加尔', '2', '3535', '51', null);
INSERT INTO `zn_area` VALUES ('3536', '毛里塔尼亚', '2', '3536', '51', null);
INSERT INTO `zn_area` VALUES ('3537', '马里', '2', '3537', '51', null);
INSERT INTO `zn_area` VALUES ('3538', '几内亚', '2', '3538', '51', null);
INSERT INTO `zn_area` VALUES ('3539', '科特迪瓦', '2', '3539', '51', null);
INSERT INTO `zn_area` VALUES ('354', '博尔塔拉', '2', '354', '28', null);
INSERT INTO `zn_area` VALUES ('3540', '布基纳法索', '2', '3540', '51', null);
INSERT INTO `zn_area` VALUES ('3541', '尼日尔', '2', '3541', '51', null);
INSERT INTO `zn_area` VALUES ('3542', '多哥', '2', '3542', '51', null);
INSERT INTO `zn_area` VALUES ('3543', '贝宁', '2', '3543', '51', null);
INSERT INTO `zn_area` VALUES ('3544', '毛里求斯', '2', '3544', '51', null);
INSERT INTO `zn_area` VALUES ('3545', '利比里亚', '2', '3545', '51', null);
INSERT INTO `zn_area` VALUES ('3546', '塞拉利昂', '2', '3546', '51', null);
INSERT INTO `zn_area` VALUES ('3547', '加纳', '2', '3547', '51', null);
INSERT INTO `zn_area` VALUES ('3548', '尼日利亚', '2', '3548', '51', null);
INSERT INTO `zn_area` VALUES ('3549', '乍得', '2', '3549', '51', null);
INSERT INTO `zn_area` VALUES ('355', '昌吉', '2', '355', '28', null);
INSERT INTO `zn_area` VALUES ('3550', '中非', '2', '3550', '51', null);
INSERT INTO `zn_area` VALUES ('3551', '喀麦隆', '2', '3551', '51', null);
INSERT INTO `zn_area` VALUES ('3552', '佛得角', '2', '3552', '51', null);
INSERT INTO `zn_area` VALUES ('3553', '圣多美和普林西比', '2', '3553', '51', null);
INSERT INTO `zn_area` VALUES ('3554', '赤道几内亚', '2', '3554', '51', null);
INSERT INTO `zn_area` VALUES ('3555', '加蓬', '2', '3555', '51', null);
INSERT INTO `zn_area` VALUES ('3556', '刚果', '2', '3556', '51', null);
INSERT INTO `zn_area` VALUES ('3557', '扎伊尔', '2', '3557', '51', null);
INSERT INTO `zn_area` VALUES ('3558', '安哥拉', '2', '3558', '51', null);
INSERT INTO `zn_area` VALUES ('3559', '几内亚比绍', '2', '3559', '51', null);
INSERT INTO `zn_area` VALUES ('356', '哈密', '2', '356', '28', null);
INSERT INTO `zn_area` VALUES ('3560', '阿森松', '2', '3560', '51', null);
INSERT INTO `zn_area` VALUES ('3561', '塞舌尔', '2', '3561', '51', null);
INSERT INTO `zn_area` VALUES ('3562', '苏丹', '2', '3562', '51', null);
INSERT INTO `zn_area` VALUES ('3563', '卢旺达', '2', '3563', '51', null);
INSERT INTO `zn_area` VALUES ('3564', '埃塞俄比亚', '2', '3564', '51', null);
INSERT INTO `zn_area` VALUES ('3565', '索马里', '2', '3565', '51', null);
INSERT INTO `zn_area` VALUES ('3566', '吉布提', '2', '3566', '51', null);
INSERT INTO `zn_area` VALUES ('3567', '肯尼亚', '2', '3567', '51', null);
INSERT INTO `zn_area` VALUES ('3568', '坦桑尼亚', '2', '3568', '51', null);
INSERT INTO `zn_area` VALUES ('3569', '乌干达', '2', '3569', '51', null);
INSERT INTO `zn_area` VALUES ('357', '和田', '2', '357', '28', null);
INSERT INTO `zn_area` VALUES ('3570', '布隆迪', '2', '3570', '51', null);
INSERT INTO `zn_area` VALUES ('3571', '莫桑比克', '2', '3571', '51', null);
INSERT INTO `zn_area` VALUES ('3572', '赞比亚', '2', '3572', '51', null);
INSERT INTO `zn_area` VALUES ('3573', '马达加斯加', '2', '3573', '51', null);
INSERT INTO `zn_area` VALUES ('3574', '留尼旺岛', '2', '3574', '51', null);
INSERT INTO `zn_area` VALUES ('3575', '津巴布韦', '2', '3575', '51', null);
INSERT INTO `zn_area` VALUES ('3576', '纳米比亚', '2', '3576', '51', null);
INSERT INTO `zn_area` VALUES ('3577', '马拉维', '2', '3577', '51', null);
INSERT INTO `zn_area` VALUES ('3578', '莱索托', '2', '3578', '51', null);
INSERT INTO `zn_area` VALUES ('3579', '博茨瓦纳', '2', '3579', '51', null);
INSERT INTO `zn_area` VALUES ('358', '喀什', '2', '358', '28', null);
INSERT INTO `zn_area` VALUES ('3580', '斯威士兰', '2', '3580', '51', null);
INSERT INTO `zn_area` VALUES ('3581', '科摩罗', '2', '3581', '51', null);
INSERT INTO `zn_area` VALUES ('3582', '南非', '2', '3582', '51', null);
INSERT INTO `zn_area` VALUES ('3583', '圣赫勒拿', '2', '3583', '51', null);
INSERT INTO `zn_area` VALUES ('3584', '阿鲁巴岛', '2', '3584', '51', null);
INSERT INTO `zn_area` VALUES ('3585', '澳大利亚', '2', '3585', '51', null);
INSERT INTO `zn_area` VALUES ('3586', '新西兰', '2', '3586', '51', null);
INSERT INTO `zn_area` VALUES ('3587', '马里亚纳群岛', '2', '3587', '51', null);
INSERT INTO `zn_area` VALUES ('3588', '科科斯岛', '2', '3588', '51', null);
INSERT INTO `zn_area` VALUES ('3589', '诺福克岛', '2', '3589', '51', null);
INSERT INTO `zn_area` VALUES ('359', '克拉玛依', '2', '359', '28', null);
INSERT INTO `zn_area` VALUES ('3590', '圣庭岛', '2', '3590', '51', null);
INSERT INTO `zn_area` VALUES ('3591', '瑙鲁', '2', '3591', '51', null);
INSERT INTO `zn_area` VALUES ('3592', '巴布亚新几内亚', '2', '3592', '51', null);
INSERT INTO `zn_area` VALUES ('3593', '汤加', '2', '3593', '51', null);
INSERT INTO `zn_area` VALUES ('3594', '所罗门群岛', '2', '3594', '51', null);
INSERT INTO `zn_area` VALUES ('3595', '瓦努阿图', '2', '3595', '51', null);
INSERT INTO `zn_area` VALUES ('3596', '斐济', '2', '3596', '51', null);
INSERT INTO `zn_area` VALUES ('3597', '科克群岛', '2', '3597', '51', null);
INSERT INTO `zn_area` VALUES ('3598', '纽埃岛', '2', '3598', '51', null);
INSERT INTO `zn_area` VALUES ('3599', '东萨摩亚', '2', '3599', '51', null);
INSERT INTO `zn_area` VALUES ('36', '蚌埠', '2', '36', '2', null);
INSERT INTO `zn_area` VALUES ('360', '克孜勒苏', '2', '360', '28', null);
INSERT INTO `zn_area` VALUES ('3600', '西萨摩亚', '2', '3600', '51', null);
INSERT INTO `zn_area` VALUES ('3601', '基里巴斯', '2', '3601', '51', null);
INSERT INTO `zn_area` VALUES ('3602', '新喀里多尼亚群岛', '2', '3602', '51', null);
INSERT INTO `zn_area` VALUES ('3603', '图瓦卢', '2', '3603', '51', null);
INSERT INTO `zn_area` VALUES ('3604', '法属波里尼西亚', '2', '3604', '51', null);
INSERT INTO `zn_area` VALUES ('3605', '白俄罗斯', '2', '3605', '51', null);
INSERT INTO `zn_area` VALUES ('3606', '波兰', '2', '3606', '51', null);
INSERT INTO `zn_area` VALUES ('3607', '土库曼斯坦', '2', '3607', '51', null);
INSERT INTO `zn_area` VALUES ('3608', '乌克兰', '2', '3608', '51', null);
INSERT INTO `zn_area` VALUES ('3609', '乌兹别克斯坦', '2', '3609', '51', null);
INSERT INTO `zn_area` VALUES ('361', '石河子', '2', '361', '28', null);
INSERT INTO `zn_area` VALUES ('3610', '摩尔多瓦', '2', '3610', '51', null);
INSERT INTO `zn_area` VALUES ('3611', '缅甸', '2', '3611', '51', null);
INSERT INTO `zn_area` VALUES ('3612', '克罗地亚', '2', '3612', '51', null);
INSERT INTO `zn_area` VALUES ('3613', '爱沙尼亚', '2', '3613', '51', null);
INSERT INTO `zn_area` VALUES ('3614', '哈萨克斯坦', '2', '3614', '51', null);
INSERT INTO `zn_area` VALUES ('3615', '吉尔吉斯斯坦', '2', '3615', '51', null);
INSERT INTO `zn_area` VALUES ('3616', '拉脱维亚', '2', '3616', '51', null);
INSERT INTO `zn_area` VALUES ('3617', '列支敦士登', '2', '3617', '51', null);
INSERT INTO `zn_area` VALUES ('3618', '捷克', '2', '3618', '51', null);
INSERT INTO `zn_area` VALUES ('3619', '立陶宛', '2', '3619', '51', null);
INSERT INTO `zn_area` VALUES ('362', '图木舒克', '2', '362', '28', null);
INSERT INTO `zn_area` VALUES ('3620', '卢森堡', '2', '3620', '51', null);
INSERT INTO `zn_area` VALUES ('3621', '帕劳', '2', '3621', '51', null);
INSERT INTO `zn_area` VALUES ('3622', '斯洛文尼亚', '2', '3622', '51', null);
INSERT INTO `zn_area` VALUES ('3623', '格鲁吉亚', '2', '3623', '51', null);
INSERT INTO `zn_area` VALUES ('3624', '塔吉克斯坦', '2', '3624', '51', null);
INSERT INTO `zn_area` VALUES ('3625', '波黑', '2', '3625', '51', null);
INSERT INTO `zn_area` VALUES ('3626', '阿根廷', '2', '3626', '51', null);
INSERT INTO `zn_area` VALUES ('3627', '阿塞拜疆', '2', '3627', '51', null);
INSERT INTO `zn_area` VALUES ('3628', '刚果(金)', '2', '3628', '51', null);
INSERT INTO `zn_area` VALUES ('3629', '刚果(布)', '2', '3629', '51', null);
INSERT INTO `zn_area` VALUES ('363', '吐鲁番', '2', '363', '28', null);
INSERT INTO `zn_area` VALUES ('3630', '美属萨摩亚', '2', '3630', '51', null);
INSERT INTO `zn_area` VALUES ('3631', '亚美尼亚', '2', '3631', '51', null);
INSERT INTO `zn_area` VALUES ('3632', '多米尼克', '2', '3632', '51', null);
INSERT INTO `zn_area` VALUES ('3633', '多米尼加', '2', '3633', '51', null);
INSERT INTO `zn_area` VALUES ('3634', '塞尔维亚', '2', '3634', '51', null);
INSERT INTO `zn_area` VALUES ('3635', '斯洛伐克', '2', '3635', '51', null);
INSERT INTO `zn_area` VALUES ('3636', '马绍尔群岛', '2', '3636', '51', null);
INSERT INTO `zn_area` VALUES ('3637', '密克罗尼西亚', '2', '3637', '51', null);
INSERT INTO `zn_area` VALUES ('3638', '黑山', '2', '3638', '51', null);
INSERT INTO `zn_area` VALUES ('3639', '纽埃', '2', '3639', '51', null);
INSERT INTO `zn_area` VALUES ('364', '五家渠', '2', '364', '28', null);
INSERT INTO `zn_area` VALUES ('3640', '厄立特里亚', '2', '3640', '51', null);
INSERT INTO `zn_area` VALUES ('3641', '萨摩亚', '2', '3641', '51', null);
INSERT INTO `zn_area` VALUES ('3642', '市中区', '3', '3642', '330', null);
INSERT INTO `zn_area` VALUES ('3643', '五通桥区', '3', '3643', '330', null);
INSERT INTO `zn_area` VALUES ('3644', '沙湾区', '3', '3644', '330', null);
INSERT INTO `zn_area` VALUES ('3645', '金口河区', '3', '3645', '330', null);
INSERT INTO `zn_area` VALUES ('3646', '开发区', '3', '3646', '330', null);
INSERT INTO `zn_area` VALUES ('3647', '柯城区', '3', '3647', '392', null);
INSERT INTO `zn_area` VALUES ('3648', '长城区', '3', '3648', '65', null);
INSERT INTO `zn_area` VALUES ('3649', '镜铁区', '3', '3649', '65', null);
INSERT INTO `zn_area` VALUES ('365', '伊犁', '2', '365', '28', null);
INSERT INTO `zn_area` VALUES ('3650', '马其顿', '2', '3650', '51', null);
INSERT INTO `zn_area` VALUES ('3651', '东帝汶', '2', '3651', '51', null);
INSERT INTO `zn_area` VALUES ('3652', '巴勒斯坦', '2', '3652', '51', null);
INSERT INTO `zn_area` VALUES ('3653', '南苏丹', '2', '3653', '51', null);
INSERT INTO `zn_area` VALUES ('3654', '圣基茨和尼维斯', '2', '3654', '51', null);
INSERT INTO `zn_area` VALUES ('3655', '南沙区', '3', '3655', '75', null);
INSERT INTO `zn_area` VALUES ('3656', '随县', '3', '3656', '189', null);
INSERT INTO `zn_area` VALUES ('3657', '北屯', '2', '3657', '28', null);
INSERT INTO `zn_area` VALUES ('3658', '柯桥区', '3', '3658', '388', null);
INSERT INTO `zn_area` VALUES ('3659', '仲恺区', '3', '3659', '81', null);
INSERT INTO `zn_area` VALUES ('366', '昆明', '2', '366', '29', null);
INSERT INTO `zn_area` VALUES ('3661', '三沙', '2', '3661', '8', null);
INSERT INTO `zn_area` VALUES ('3662', '鼎湖区', '3', '3662', '93', null);
INSERT INTO `zn_area` VALUES ('3663', '端州区', '3', '3663', '93', null);
INSERT INTO `zn_area` VALUES ('3664', '双河', '3', '3664', '354', null);
INSERT INTO `zn_area` VALUES ('3665', '新北', '2', '3665', '34', null);
INSERT INTO `zn_area` VALUES ('367', '怒江', '2', '367', '29', null);
INSERT INTO `zn_area` VALUES ('368', '普洱', '2', '368', '29', null);
INSERT INTO `zn_area` VALUES ('369', '丽江', '2', '369', '29', null);
INSERT INTO `zn_area` VALUES ('37', '巢湖市', '3', '37', '3400', null);
INSERT INTO `zn_area` VALUES ('370', '保山', '2', '370', '29', null);
INSERT INTO `zn_area` VALUES ('371', '楚雄', '2', '371', '29', null);
INSERT INTO `zn_area` VALUES ('372', '大理', '2', '372', '29', null);
INSERT INTO `zn_area` VALUES ('373', '德宏', '2', '373', '29', null);
INSERT INTO `zn_area` VALUES ('374', '迪庆', '2', '374', '29', null);
INSERT INTO `zn_area` VALUES ('375', '红河', '2', '375', '29', null);
INSERT INTO `zn_area` VALUES ('376', '临沧', '2', '376', '29', null);
INSERT INTO `zn_area` VALUES ('377', '曲靖', '2', '377', '29', null);
INSERT INTO `zn_area` VALUES ('378', '文山', '2', '378', '29', null);
INSERT INTO `zn_area` VALUES ('379', '西双版纳', '2', '379', '29', null);
INSERT INTO `zn_area` VALUES ('38', '池州', '2', '38', '2', null);
INSERT INTO `zn_area` VALUES ('380', '玉溪', '2', '380', '29', null);
INSERT INTO `zn_area` VALUES ('381', '昭通', '2', '381', '29', null);
INSERT INTO `zn_area` VALUES ('382', '杭州', '2', '382', '30', null);
INSERT INTO `zn_area` VALUES ('383', '湖州', '2', '383', '30', null);
INSERT INTO `zn_area` VALUES ('384', '嘉兴', '2', '384', '30', null);
INSERT INTO `zn_area` VALUES ('385', '金华', '2', '385', '30', null);
INSERT INTO `zn_area` VALUES ('386', '丽水', '2', '386', '30', null);
INSERT INTO `zn_area` VALUES ('387', '宁波', '2', '387', '30', null);
INSERT INTO `zn_area` VALUES ('388', '绍兴', '2', '388', '30', null);
INSERT INTO `zn_area` VALUES ('389', '台州', '2', '389', '30', null);
INSERT INTO `zn_area` VALUES ('39', '滁州', '2', '39', '2', null);
INSERT INTO `zn_area` VALUES ('390', '温州', '2', '390', '30', null);
INSERT INTO `zn_area` VALUES ('391', '舟山', '2', '391', '30', null);
INSERT INTO `zn_area` VALUES ('392', '衢州', '2', '392', '30', null);
INSERT INTO `zn_area` VALUES ('397', '迎江区', '3', '397', '35', null);
INSERT INTO `zn_area` VALUES ('398', '大观区', '3', '398', '35', null);
INSERT INTO `zn_area` VALUES ('399', '宜秀区', '3', '399', '35', null);
INSERT INTO `zn_area` VALUES ('4', '甘肃', '1', '4', '0', null);
INSERT INTO `zn_area` VALUES ('40', '阜阳', '2', '40', '2', null);
INSERT INTO `zn_area` VALUES ('400', '桐城市', '3', '400', '35', null);
INSERT INTO `zn_area` VALUES ('401', '怀宁县', '3', '401', '35', null);
INSERT INTO `zn_area` VALUES ('402', '枞阳县', '3', '402', '47', null);
INSERT INTO `zn_area` VALUES ('403', '潜山县', '3', '403', '35', null);
INSERT INTO `zn_area` VALUES ('404', '太湖县', '3', '404', '35', null);
INSERT INTO `zn_area` VALUES ('405', '宿松县', '3', '405', '35', null);
INSERT INTO `zn_area` VALUES ('406', '望江县', '3', '406', '35', null);
INSERT INTO `zn_area` VALUES ('407', '岳西县', '3', '407', '35', null);
INSERT INTO `zn_area` VALUES ('41', '淮北', '2', '41', '2', null);
INSERT INTO `zn_area` VALUES ('412', '怀远县', '3', '412', '36', null);
INSERT INTO `zn_area` VALUES ('413', '五河县', '3', '413', '36', null);
INSERT INTO `zn_area` VALUES ('414', '固镇县', '3', '414', '36', null);
INSERT INTO `zn_area` VALUES ('416', '庐江县', '3', '416', '3400', null);
INSERT INTO `zn_area` VALUES ('417', '无为县', '3', '417', '48', null);
INSERT INTO `zn_area` VALUES ('418', '含山县', '3', '418', '45', null);
INSERT INTO `zn_area` VALUES ('419', '和县', '3', '419', '45', null);
INSERT INTO `zn_area` VALUES ('42', '淮南', '2', '42', '2', null);
INSERT INTO `zn_area` VALUES ('420', '贵池区', '3', '420', '38', null);
INSERT INTO `zn_area` VALUES ('421', '东至县', '3', '421', '38', null);
INSERT INTO `zn_area` VALUES ('422', '石台县', '3', '422', '38', null);
INSERT INTO `zn_area` VALUES ('423', '青阳县', '3', '423', '38', null);
INSERT INTO `zn_area` VALUES ('424', '琅琊区', '3', '424', '39', null);
INSERT INTO `zn_area` VALUES ('425', '南谯区', '3', '425', '39', null);
INSERT INTO `zn_area` VALUES ('426', '天长市', '3', '426', '39', null);
INSERT INTO `zn_area` VALUES ('427', '明光市', '3', '427', '39', null);
INSERT INTO `zn_area` VALUES ('428', '来安县', '3', '428', '39', null);
INSERT INTO `zn_area` VALUES ('429', '全椒县', '3', '429', '39', null);
INSERT INTO `zn_area` VALUES ('43', '黄山', '2', '43', '2', null);
INSERT INTO `zn_area` VALUES ('430', '定远县', '3', '430', '39', null);
INSERT INTO `zn_area` VALUES ('431', '凤阳县', '3', '431', '39', null);
INSERT INTO `zn_area` VALUES ('432', '蚌山区', '3', '432', '36', null);
INSERT INTO `zn_area` VALUES ('433', '龙子湖区', '3', '433', '36', null);
INSERT INTO `zn_area` VALUES ('434', '禹会区', '3', '434', '36', null);
INSERT INTO `zn_area` VALUES ('435', '淮上区', '3', '435', '36', null);
INSERT INTO `zn_area` VALUES ('436', '颍州区', '3', '436', '40', null);
INSERT INTO `zn_area` VALUES ('437', '颍东区', '3', '437', '40', null);
INSERT INTO `zn_area` VALUES ('438', '颍泉区', '3', '438', '40', null);
INSERT INTO `zn_area` VALUES ('439', '界首市', '3', '439', '40', null);
INSERT INTO `zn_area` VALUES ('44', '六安', '2', '44', '2', null);
INSERT INTO `zn_area` VALUES ('440', '临泉县', '3', '440', '40', null);
INSERT INTO `zn_area` VALUES ('441', '太和县', '3', '441', '40', null);
INSERT INTO `zn_area` VALUES ('442', '阜南县', '3', '442', '40', null);
INSERT INTO `zn_area` VALUES ('443', '颍上县', '3', '443', '40', null);
INSERT INTO `zn_area` VALUES ('444', '相山区', '3', '444', '41', null);
INSERT INTO `zn_area` VALUES ('445', '杜集区', '3', '445', '41', null);
INSERT INTO `zn_area` VALUES ('446', '烈山区', '3', '446', '41', null);
INSERT INTO `zn_area` VALUES ('447', '濉溪县', '3', '447', '41', null);
INSERT INTO `zn_area` VALUES ('448', '田家庵区', '3', '448', '42', null);
INSERT INTO `zn_area` VALUES ('449', '大通区', '3', '449', '42', null);
INSERT INTO `zn_area` VALUES ('45', '马鞍山', '2', '45', '2', null);
INSERT INTO `zn_area` VALUES ('450', '谢家集区', '3', '450', '42', null);
INSERT INTO `zn_area` VALUES ('451', '八公山区', '3', '451', '42', null);
INSERT INTO `zn_area` VALUES ('452', '潘集区', '3', '452', '42', null);
INSERT INTO `zn_area` VALUES ('453', '凤台县', '3', '453', '42', null);
INSERT INTO `zn_area` VALUES ('454', '屯溪区', '3', '454', '43', null);
INSERT INTO `zn_area` VALUES ('455', '黄山区', '3', '455', '43', null);
INSERT INTO `zn_area` VALUES ('456', '徽州区', '3', '456', '43', null);
INSERT INTO `zn_area` VALUES ('457', '歙县', '3', '457', '43', null);
INSERT INTO `zn_area` VALUES ('458', '休宁县', '3', '458', '43', null);
INSERT INTO `zn_area` VALUES ('459', '黟县', '3', '459', '43', null);
INSERT INTO `zn_area` VALUES ('46', '宿州', '2', '46', '2', null);
INSERT INTO `zn_area` VALUES ('460', '祁门县', '3', '460', '43', null);
INSERT INTO `zn_area` VALUES ('461', '金安区', '3', '461', '44', null);
INSERT INTO `zn_area` VALUES ('462', '裕安区', '3', '462', '44', null);
INSERT INTO `zn_area` VALUES ('463', '寿县', '3', '463', '44', null);
INSERT INTO `zn_area` VALUES ('464', '霍邱县', '3', '464', '44', null);
INSERT INTO `zn_area` VALUES ('465', '舒城县', '3', '465', '44', null);
INSERT INTO `zn_area` VALUES ('466', '金寨县', '3', '466', '44', null);
INSERT INTO `zn_area` VALUES ('467', '霍山县', '3', '467', '44', null);
INSERT INTO `zn_area` VALUES ('468', '雨山区', '3', '468', '45', null);
INSERT INTO `zn_area` VALUES ('469', '花山区', '3', '469', '45', null);
INSERT INTO `zn_area` VALUES ('47', '铜陵', '2', '47', '2', null);
INSERT INTO `zn_area` VALUES ('470', '金家庄区', '3', '470', '45', null);
INSERT INTO `zn_area` VALUES ('471', '当涂县', '3', '471', '45', null);
INSERT INTO `zn_area` VALUES ('472', '埇桥区', '3', '472', '46', null);
INSERT INTO `zn_area` VALUES ('473', '砀山县', '3', '473', '46', null);
INSERT INTO `zn_area` VALUES ('474', '萧县', '3', '474', '46', null);
INSERT INTO `zn_area` VALUES ('475', '灵璧县', '3', '475', '46', null);
INSERT INTO `zn_area` VALUES ('476', '泗县', '3', '476', '46', null);
INSERT INTO `zn_area` VALUES ('477', '铜官区', '3', '477', '47', null);
INSERT INTO `zn_area` VALUES ('479', '郊区', '3', '479', '47', null);
INSERT INTO `zn_area` VALUES ('48', '芜湖', '2', '48', '2', null);
INSERT INTO `zn_area` VALUES ('480', '义安区', '3', '480', '47', null);
INSERT INTO `zn_area` VALUES ('481', '镜湖区', '3', '481', '48', null);
INSERT INTO `zn_area` VALUES ('482', '弋江区', '3', '482', '48', null);
INSERT INTO `zn_area` VALUES ('483', '鸠江区', '3', '483', '48', null);
INSERT INTO `zn_area` VALUES ('484', '三山区', '3', '484', '48', null);
INSERT INTO `zn_area` VALUES ('485', '芜湖县', '3', '485', '48', null);
INSERT INTO `zn_area` VALUES ('486', '繁昌县', '3', '486', '48', null);
INSERT INTO `zn_area` VALUES ('487', '南陵县', '3', '487', '48', null);
INSERT INTO `zn_area` VALUES ('488', '宣州区', '3', '488', '49', null);
INSERT INTO `zn_area` VALUES ('489', '宁国市', '3', '489', '49', null);
INSERT INTO `zn_area` VALUES ('49', '宣城', '2', '49', '2', null);
INSERT INTO `zn_area` VALUES ('490', '郎溪县', '3', '490', '49', null);
INSERT INTO `zn_area` VALUES ('491', '广德县', '3', '491', '49', null);
INSERT INTO `zn_area` VALUES ('492', '泾县', '3', '492', '49', null);
INSERT INTO `zn_area` VALUES ('493', '绩溪县', '3', '493', '49', null);
INSERT INTO `zn_area` VALUES ('494', '旌德县', '3', '494', '49', null);
INSERT INTO `zn_area` VALUES ('495', '涡阳县', '3', '495', '50', null);
INSERT INTO `zn_area` VALUES ('496', '蒙城县', '3', '496', '50', null);
INSERT INTO `zn_area` VALUES ('497', '利辛县', '3', '497', '50', null);
INSERT INTO `zn_area` VALUES ('498', '谯城区', '3', '498', '50', null);
INSERT INTO `zn_area` VALUES ('499', '东城区', '2', '499', '1', null);
INSERT INTO `zn_area` VALUES ('5', '广东', '1', '5', '0', null);
INSERT INTO `zn_area` VALUES ('50', '亳州', '2', '50', '2', null);
INSERT INTO `zn_area` VALUES ('500', '西城区', '2', '500', '1', null);
INSERT INTO `zn_area` VALUES ('501', '海淀区', '2', '501', '1', null);
INSERT INTO `zn_area` VALUES ('502', '朝阳区', '2', '502', '1', null);
INSERT INTO `zn_area` VALUES ('505', '丰台区', '2', '505', '1', null);
INSERT INTO `zn_area` VALUES ('506', '石景山区', '2', '506', '1', null);
INSERT INTO `zn_area` VALUES ('507', '房山区', '2', '507', '1', null);
INSERT INTO `zn_area` VALUES ('508', '门头沟区', '2', '508', '1', null);
INSERT INTO `zn_area` VALUES ('509', '通州区', '2', '509', '1', null);
INSERT INTO `zn_area` VALUES ('51', '国外', '1', '51', '0', null);
INSERT INTO `zn_area` VALUES ('510', '顺义区', '2', '510', '1', null);
INSERT INTO `zn_area` VALUES ('511', '昌平区', '2', '511', '1', null);
INSERT INTO `zn_area` VALUES ('512', '怀柔区', '2', '512', '1', null);
INSERT INTO `zn_area` VALUES ('513', '平谷区', '2', '513', '1', null);
INSERT INTO `zn_area` VALUES ('514', '大兴区', '2', '514', '1', null);
INSERT INTO `zn_area` VALUES ('515', '密云县', '2', '515', '1', null);
INSERT INTO `zn_area` VALUES ('516', '延庆县', '2', '516', '1', null);
INSERT INTO `zn_area` VALUES ('517', '鼓楼区', '3', '517', '52', null);
INSERT INTO `zn_area` VALUES ('518', '台江区', '3', '518', '52', null);
INSERT INTO `zn_area` VALUES ('519', '仓山区', '3', '519', '52', null);
INSERT INTO `zn_area` VALUES ('52', '福州', '2', '52', '3', null);
INSERT INTO `zn_area` VALUES ('520', '马尾区', '3', '520', '52', null);
INSERT INTO `zn_area` VALUES ('521', '晋安区', '3', '521', '52', null);
INSERT INTO `zn_area` VALUES ('522', '福清市', '3', '522', '52', null);
INSERT INTO `zn_area` VALUES ('523', '长乐市', '3', '523', '52', null);
INSERT INTO `zn_area` VALUES ('524', '闽侯县', '3', '524', '52', null);
INSERT INTO `zn_area` VALUES ('525', '连江县', '3', '525', '52', null);
INSERT INTO `zn_area` VALUES ('526', '罗源县', '3', '526', '52', null);
INSERT INTO `zn_area` VALUES ('527', '闽清县', '3', '527', '52', null);
INSERT INTO `zn_area` VALUES ('528', '永泰县', '3', '528', '52', null);
INSERT INTO `zn_area` VALUES ('529', '平潭县', '3', '529', '52', null);
INSERT INTO `zn_area` VALUES ('53', '龙岩', '2', '53', '3', null);
INSERT INTO `zn_area` VALUES ('530', '新罗区', '3', '530', '53', null);
INSERT INTO `zn_area` VALUES ('531', '漳平市', '3', '531', '53', null);
INSERT INTO `zn_area` VALUES ('532', '长汀县', '3', '532', '53', null);
INSERT INTO `zn_area` VALUES ('533', '永定县', '3', '533', '53', null);
INSERT INTO `zn_area` VALUES ('534', '上杭县', '3', '534', '53', null);
INSERT INTO `zn_area` VALUES ('535', '武平县', '3', '535', '53', null);
INSERT INTO `zn_area` VALUES ('536', '连城县', '3', '536', '53', null);
INSERT INTO `zn_area` VALUES ('537', '延平区', '3', '537', '54', null);
INSERT INTO `zn_area` VALUES ('538', '邵武市', '3', '538', '54', null);
INSERT INTO `zn_area` VALUES ('539', '武夷山市', '3', '539', '54', null);
INSERT INTO `zn_area` VALUES ('54', '南平', '2', '54', '3', null);
INSERT INTO `zn_area` VALUES ('540', '建瓯市', '3', '540', '54', null);
INSERT INTO `zn_area` VALUES ('541', '建阳市', '3', '541', '54', null);
INSERT INTO `zn_area` VALUES ('542', '顺昌县', '3', '542', '54', null);
INSERT INTO `zn_area` VALUES ('543', '浦城县', '3', '543', '54', null);
INSERT INTO `zn_area` VALUES ('544', '光泽县', '3', '544', '54', null);
INSERT INTO `zn_area` VALUES ('545', '松溪县', '3', '545', '54', null);
INSERT INTO `zn_area` VALUES ('546', '政和县', '3', '546', '54', null);
INSERT INTO `zn_area` VALUES ('547', '蕉城区', '3', '547', '55', null);
INSERT INTO `zn_area` VALUES ('548', '福安市', '3', '548', '55', null);
INSERT INTO `zn_area` VALUES ('549', '福鼎市', '3', '549', '55', null);
INSERT INTO `zn_area` VALUES ('55', '宁德', '2', '55', '3', null);
INSERT INTO `zn_area` VALUES ('550', '霞浦县', '3', '550', '55', null);
INSERT INTO `zn_area` VALUES ('551', '古田县', '3', '551', '55', null);
INSERT INTO `zn_area` VALUES ('552', '屏南县', '3', '552', '55', null);
INSERT INTO `zn_area` VALUES ('553', '寿宁县', '3', '553', '55', null);
INSERT INTO `zn_area` VALUES ('554', '周宁县', '3', '554', '55', null);
INSERT INTO `zn_area` VALUES ('555', '柘荣县', '3', '555', '55', null);
INSERT INTO `zn_area` VALUES ('556', '城厢区', '3', '556', '56', null);
INSERT INTO `zn_area` VALUES ('557', '涵江区', '3', '557', '56', null);
INSERT INTO `zn_area` VALUES ('558', '荔城区', '3', '558', '56', null);
INSERT INTO `zn_area` VALUES ('559', '秀屿区', '3', '559', '56', null);
INSERT INTO `zn_area` VALUES ('56', '莆田', '2', '56', '3', null);
INSERT INTO `zn_area` VALUES ('560', '仙游县', '3', '560', '56', null);
INSERT INTO `zn_area` VALUES ('561', '鲤城区', '3', '561', '57', null);
INSERT INTO `zn_area` VALUES ('562', '丰泽区', '3', '562', '57', null);
INSERT INTO `zn_area` VALUES ('563', '洛江区', '3', '563', '57', null);
INSERT INTO `zn_area` VALUES ('564', '清濛开发区', '3', '564', '57', null);
INSERT INTO `zn_area` VALUES ('565', '泉港区', '3', '565', '57', null);
INSERT INTO `zn_area` VALUES ('566', '石狮市', '3', '566', '57', null);
INSERT INTO `zn_area` VALUES ('567', '晋江市', '3', '567', '57', null);
INSERT INTO `zn_area` VALUES ('568', '南安市', '3', '568', '57', null);
INSERT INTO `zn_area` VALUES ('569', '惠安县', '3', '569', '57', null);
INSERT INTO `zn_area` VALUES ('57', '泉州', '2', '57', '3', null);
INSERT INTO `zn_area` VALUES ('570', '安溪县', '3', '570', '57', null);
INSERT INTO `zn_area` VALUES ('571', '永春县', '3', '571', '57', null);
INSERT INTO `zn_area` VALUES ('572', '德化县', '3', '572', '57', null);
INSERT INTO `zn_area` VALUES ('573', '金门县', '3', '573', '57', null);
INSERT INTO `zn_area` VALUES ('574', '梅列区', '3', '574', '58', null);
INSERT INTO `zn_area` VALUES ('575', '三元区', '3', '575', '58', null);
INSERT INTO `zn_area` VALUES ('576', '永安市', '3', '576', '58', null);
INSERT INTO `zn_area` VALUES ('577', '明溪县', '3', '577', '58', null);
INSERT INTO `zn_area` VALUES ('578', '清流县', '3', '578', '58', null);
INSERT INTO `zn_area` VALUES ('579', '宁化县', '3', '579', '58', null);
INSERT INTO `zn_area` VALUES ('58', '三明', '2', '58', '3', null);
INSERT INTO `zn_area` VALUES ('580', '大田县', '3', '580', '58', null);
INSERT INTO `zn_area` VALUES ('581', '尤溪县', '3', '581', '58', null);
INSERT INTO `zn_area` VALUES ('582', '沙县', '3', '582', '58', null);
INSERT INTO `zn_area` VALUES ('583', '将乐县', '3', '583', '58', null);
INSERT INTO `zn_area` VALUES ('584', '泰宁县', '3', '584', '58', null);
INSERT INTO `zn_area` VALUES ('585', '建宁县', '3', '585', '58', null);
INSERT INTO `zn_area` VALUES ('586', '思明区', '3', '586', '59', null);
INSERT INTO `zn_area` VALUES ('587', '海沧区', '3', '587', '59', null);
INSERT INTO `zn_area` VALUES ('588', '湖里区', '3', '588', '59', null);
INSERT INTO `zn_area` VALUES ('589', '集美区', '3', '589', '59', null);
INSERT INTO `zn_area` VALUES ('59', '厦门', '2', '59', '3', null);
INSERT INTO `zn_area` VALUES ('590', '同安区', '3', '590', '59', null);
INSERT INTO `zn_area` VALUES ('591', '翔安区', '3', '591', '59', null);
INSERT INTO `zn_area` VALUES ('592', '芗城区', '3', '592', '60', null);
INSERT INTO `zn_area` VALUES ('593', '龙文区', '3', '593', '60', null);
INSERT INTO `zn_area` VALUES ('594', '龙海市', '3', '594', '60', null);
INSERT INTO `zn_area` VALUES ('595', '云霄县', '3', '595', '60', null);
INSERT INTO `zn_area` VALUES ('596', '漳浦县', '3', '596', '60', null);
INSERT INTO `zn_area` VALUES ('597', '诏安县', '3', '597', '60', null);
INSERT INTO `zn_area` VALUES ('598', '长泰县', '3', '598', '60', null);
INSERT INTO `zn_area` VALUES ('599', '东山县', '3', '599', '60', null);
INSERT INTO `zn_area` VALUES ('6', '广西', '1', '6', '0', null);
INSERT INTO `zn_area` VALUES ('60', '漳州', '2', '60', '3', null);
INSERT INTO `zn_area` VALUES ('600', '南靖县', '3', '600', '60', null);
INSERT INTO `zn_area` VALUES ('601', '平和县', '3', '601', '60', null);
INSERT INTO `zn_area` VALUES ('602', '华安县', '3', '602', '60', null);
INSERT INTO `zn_area` VALUES ('603', '皋兰县', '3', '603', '61', null);
INSERT INTO `zn_area` VALUES ('604', '城关区', '3', '604', '61', null);
INSERT INTO `zn_area` VALUES ('605', '七里河区', '3', '605', '61', null);
INSERT INTO `zn_area` VALUES ('606', '西固区', '3', '606', '61', null);
INSERT INTO `zn_area` VALUES ('607', '安宁区', '3', '607', '61', null);
INSERT INTO `zn_area` VALUES ('608', '红古区', '3', '608', '61', null);
INSERT INTO `zn_area` VALUES ('609', '永登县', '3', '609', '61', null);
INSERT INTO `zn_area` VALUES ('61', '兰州', '2', '61', '4', null);
INSERT INTO `zn_area` VALUES ('610', '榆中县', '3', '610', '61', null);
INSERT INTO `zn_area` VALUES ('611', '白银区', '3', '611', '62', null);
INSERT INTO `zn_area` VALUES ('612', '平川区', '3', '612', '62', null);
INSERT INTO `zn_area` VALUES ('613', '会宁县', '3', '613', '62', null);
INSERT INTO `zn_area` VALUES ('614', '景泰县', '3', '614', '62', null);
INSERT INTO `zn_area` VALUES ('615', '靖远县', '3', '615', '62', null);
INSERT INTO `zn_area` VALUES ('616', '临洮县', '3', '616', '63', null);
INSERT INTO `zn_area` VALUES ('617', '陇西县', '3', '617', '63', null);
INSERT INTO `zn_area` VALUES ('618', '通渭县', '3', '618', '63', null);
INSERT INTO `zn_area` VALUES ('619', '渭源县', '3', '619', '63', null);
INSERT INTO `zn_area` VALUES ('62', '白银', '2', '62', '4', null);
INSERT INTO `zn_area` VALUES ('620', '漳县', '3', '620', '63', null);
INSERT INTO `zn_area` VALUES ('621', '岷县', '3', '621', '63', null);
INSERT INTO `zn_area` VALUES ('622', '安定区', '3', '622', '63', null);
INSERT INTO `zn_area` VALUES ('623', '安定区', '3', '623', '63', null);
INSERT INTO `zn_area` VALUES ('624', '合作市', '3', '624', '64', null);
INSERT INTO `zn_area` VALUES ('625', '临潭县', '3', '625', '64', null);
INSERT INTO `zn_area` VALUES ('626', '卓尼县', '3', '626', '64', null);
INSERT INTO `zn_area` VALUES ('627', '舟曲县', '3', '627', '64', null);
INSERT INTO `zn_area` VALUES ('628', '迭部县', '3', '628', '64', null);
INSERT INTO `zn_area` VALUES ('629', '玛曲县', '3', '629', '64', null);
INSERT INTO `zn_area` VALUES ('63', '定西', '2', '63', '4', null);
INSERT INTO `zn_area` VALUES ('630', '碌曲县', '3', '630', '64', null);
INSERT INTO `zn_area` VALUES ('631', '夏河县', '3', '631', '64', null);
INSERT INTO `zn_area` VALUES ('632', '雄关区', '3', '632', '65', null);
INSERT INTO `zn_area` VALUES ('633', '金川区', '3', '633', '66', null);
INSERT INTO `zn_area` VALUES ('634', '永昌县', '3', '634', '66', null);
INSERT INTO `zn_area` VALUES ('635', '肃州区', '3', '635', '67', null);
INSERT INTO `zn_area` VALUES ('636', '玉门市', '3', '636', '67', null);
INSERT INTO `zn_area` VALUES ('637', '敦煌市', '3', '637', '67', null);
INSERT INTO `zn_area` VALUES ('638', '金塔县', '3', '638', '67', null);
INSERT INTO `zn_area` VALUES ('639', '瓜州县', '3', '639', '67', null);
INSERT INTO `zn_area` VALUES ('64', '甘南州', '2', '64', '4', null);
INSERT INTO `zn_area` VALUES ('640', '肃北县', '3', '640', '67', null);
INSERT INTO `zn_area` VALUES ('641', '阿克塞', '3', '641', '67', null);
INSERT INTO `zn_area` VALUES ('642', '临夏市', '3', '642', '68', null);
INSERT INTO `zn_area` VALUES ('643', '临夏县', '3', '643', '68', null);
INSERT INTO `zn_area` VALUES ('644', '康乐县', '3', '644', '68', null);
INSERT INTO `zn_area` VALUES ('645', '永靖县', '3', '645', '68', null);
INSERT INTO `zn_area` VALUES ('646', '广河县', '3', '646', '68', null);
INSERT INTO `zn_area` VALUES ('647', '和政县', '3', '647', '68', null);
INSERT INTO `zn_area` VALUES ('648', '东乡族自治县', '3', '648', '68', null);
INSERT INTO `zn_area` VALUES ('649', '积石山', '3', '649', '68', null);
INSERT INTO `zn_area` VALUES ('65', '嘉峪关', '2', '65', '4', null);
INSERT INTO `zn_area` VALUES ('650', '成县', '3', '650', '69', null);
INSERT INTO `zn_area` VALUES ('651', '徽县', '3', '651', '69', null);
INSERT INTO `zn_area` VALUES ('652', '康县', '3', '652', '69', null);
INSERT INTO `zn_area` VALUES ('653', '礼县', '3', '653', '69', null);
INSERT INTO `zn_area` VALUES ('654', '两当县', '3', '654', '69', null);
INSERT INTO `zn_area` VALUES ('655', '文县', '3', '655', '69', null);
INSERT INTO `zn_area` VALUES ('656', '西和县', '3', '656', '69', null);
INSERT INTO `zn_area` VALUES ('657', '宕昌县', '3', '657', '69', null);
INSERT INTO `zn_area` VALUES ('658', '武都区', '3', '658', '69', null);
INSERT INTO `zn_area` VALUES ('659', '崇信县', '3', '659', '70', null);
INSERT INTO `zn_area` VALUES ('66', '金昌', '2', '66', '4', null);
INSERT INTO `zn_area` VALUES ('660', '华亭县', '3', '660', '70', null);
INSERT INTO `zn_area` VALUES ('661', '静宁县', '3', '661', '70', null);
INSERT INTO `zn_area` VALUES ('662', '灵台县', '3', '662', '70', null);
INSERT INTO `zn_area` VALUES ('663', '崆峒区', '3', '663', '70', null);
INSERT INTO `zn_area` VALUES ('664', '庄浪县', '3', '664', '70', null);
INSERT INTO `zn_area` VALUES ('665', '泾川县', '3', '665', '70', null);
INSERT INTO `zn_area` VALUES ('666', '合水县', '3', '666', '71', null);
INSERT INTO `zn_area` VALUES ('667', '华池县', '3', '667', '71', null);
INSERT INTO `zn_area` VALUES ('668', '环县', '3', '668', '71', null);
INSERT INTO `zn_area` VALUES ('669', '宁县', '3', '669', '71', null);
INSERT INTO `zn_area` VALUES ('67', '酒泉', '2', '67', '4', null);
INSERT INTO `zn_area` VALUES ('670', '庆城县', '3', '670', '71', null);
INSERT INTO `zn_area` VALUES ('671', '西峰区', '3', '671', '71', null);
INSERT INTO `zn_area` VALUES ('672', '镇原县', '3', '672', '71', null);
INSERT INTO `zn_area` VALUES ('673', '正宁县', '3', '673', '71', null);
INSERT INTO `zn_area` VALUES ('674', '甘谷县', '3', '674', '72', null);
INSERT INTO `zn_area` VALUES ('675', '秦安县', '3', '675', '72', null);
INSERT INTO `zn_area` VALUES ('676', '清水县', '3', '676', '72', null);
INSERT INTO `zn_area` VALUES ('677', '秦州区', '3', '677', '72', null);
INSERT INTO `zn_area` VALUES ('678', '麦积区', '3', '678', '72', null);
INSERT INTO `zn_area` VALUES ('679', '武山县', '3', '679', '72', null);
INSERT INTO `zn_area` VALUES ('68', '临夏', '2', '68', '4', null);
INSERT INTO `zn_area` VALUES ('680', '张家川', '3', '680', '72', null);
INSERT INTO `zn_area` VALUES ('681', '古浪县', '3', '681', '73', null);
INSERT INTO `zn_area` VALUES ('682', '民勤县', '3', '682', '73', null);
INSERT INTO `zn_area` VALUES ('683', '天祝县', '3', '683', '73', null);
INSERT INTO `zn_area` VALUES ('684', '凉州区', '3', '684', '73', null);
INSERT INTO `zn_area` VALUES ('685', '高台县', '3', '685', '74', null);
INSERT INTO `zn_area` VALUES ('686', '临泽县', '3', '686', '74', null);
INSERT INTO `zn_area` VALUES ('687', '民乐县', '3', '687', '74', null);
INSERT INTO `zn_area` VALUES ('688', '山丹县', '3', '688', '74', null);
INSERT INTO `zn_area` VALUES ('689', '肃南县', '3', '689', '74', null);
INSERT INTO `zn_area` VALUES ('69', '陇南', '2', '69', '4', null);
INSERT INTO `zn_area` VALUES ('690', '甘州区', '3', '690', '74', null);
INSERT INTO `zn_area` VALUES ('691', '从化区', '3', '691', '75', null);
INSERT INTO `zn_area` VALUES ('692', '天河区', '3', '692', '75', null);
INSERT INTO `zn_area` VALUES ('694', '白云区', '3', '694', '75', null);
INSERT INTO `zn_area` VALUES ('695', '海珠区', '3', '695', '75', null);
INSERT INTO `zn_area` VALUES ('696', '荔湾区', '3', '696', '75', null);
INSERT INTO `zn_area` VALUES ('697', '越秀区', '3', '697', '75', null);
INSERT INTO `zn_area` VALUES ('698', '黄埔区', '3', '698', '75', null);
INSERT INTO `zn_area` VALUES ('699', '番禺区', '3', '699', '75', null);
INSERT INTO `zn_area` VALUES ('7', '贵州', '1', '7', '0', null);
INSERT INTO `zn_area` VALUES ('70', '平凉', '2', '70', '4', null);
INSERT INTO `zn_area` VALUES ('700', '花都区', '3', '700', '75', null);
INSERT INTO `zn_area` VALUES ('701', '增城区', '3', '701', '75', null);
INSERT INTO `zn_area` VALUES ('704', '福田区', '3', '704', '76', null);
INSERT INTO `zn_area` VALUES ('705', '罗湖区', '3', '705', '76', null);
INSERT INTO `zn_area` VALUES ('706', '南山区', '3', '706', '76', null);
INSERT INTO `zn_area` VALUES ('707', '宝安区', '3', '707', '76', null);
INSERT INTO `zn_area` VALUES ('708', '龙岗区', '3', '708', '76', null);
INSERT INTO `zn_area` VALUES ('709', '盐田区', '3', '709', '76', null);
INSERT INTO `zn_area` VALUES ('71', '庆阳', '2', '71', '4', null);
INSERT INTO `zn_area` VALUES ('710', '湘桥区', '3', '710', '77', null);
INSERT INTO `zn_area` VALUES ('711', '潮安县', '3', '711', '77', null);
INSERT INTO `zn_area` VALUES ('712', '饶平县', '3', '712', '77', null);
INSERT INTO `zn_area` VALUES ('713', '南城区', '3', '713', '78', null);
INSERT INTO `zn_area` VALUES ('714', '东城区', '3', '714', '78', null);
INSERT INTO `zn_area` VALUES ('715', '万江区', '3', '715', '78', null);
INSERT INTO `zn_area` VALUES ('716', '莞城区', '3', '716', '78', null);
INSERT INTO `zn_area` VALUES ('717', '石龙镇', '3', '717', '78', null);
INSERT INTO `zn_area` VALUES ('718', '虎门镇', '3', '718', '78', null);
INSERT INTO `zn_area` VALUES ('719', '麻涌镇', '3', '719', '78', null);
INSERT INTO `zn_area` VALUES ('72', '天水', '2', '72', '4', null);
INSERT INTO `zn_area` VALUES ('720', '道滘镇', '3', '720', '78', null);
INSERT INTO `zn_area` VALUES ('721', '石碣镇', '3', '721', '78', null);
INSERT INTO `zn_area` VALUES ('722', '沙田镇', '3', '722', '78', null);
INSERT INTO `zn_area` VALUES ('723', '望牛墩镇', '3', '723', '78', null);
INSERT INTO `zn_area` VALUES ('724', '洪梅镇', '3', '724', '78', null);
INSERT INTO `zn_area` VALUES ('725', '茶山镇', '3', '725', '78', null);
INSERT INTO `zn_area` VALUES ('726', '寮步镇', '3', '726', '78', null);
INSERT INTO `zn_area` VALUES ('727', '大岭山镇', '3', '727', '78', null);
INSERT INTO `zn_area` VALUES ('728', '大朗镇', '3', '728', '78', null);
INSERT INTO `zn_area` VALUES ('729', '黄江镇', '3', '729', '78', null);
INSERT INTO `zn_area` VALUES ('73', '武威', '2', '73', '4', null);
INSERT INTO `zn_area` VALUES ('730', '樟木头', '3', '730', '78', null);
INSERT INTO `zn_area` VALUES ('731', '凤岗镇', '3', '731', '78', null);
INSERT INTO `zn_area` VALUES ('732', '塘厦镇', '3', '732', '78', null);
INSERT INTO `zn_area` VALUES ('733', '谢岗镇', '3', '733', '78', null);
INSERT INTO `zn_area` VALUES ('734', '厚街镇', '3', '734', '78', null);
INSERT INTO `zn_area` VALUES ('735', '清溪镇', '3', '735', '78', null);
INSERT INTO `zn_area` VALUES ('736', '常平镇', '3', '736', '78', null);
INSERT INTO `zn_area` VALUES ('737', '桥头镇', '3', '737', '78', null);
INSERT INTO `zn_area` VALUES ('738', '横沥镇', '3', '738', '78', null);
INSERT INTO `zn_area` VALUES ('739', '东坑镇', '3', '739', '78', null);
INSERT INTO `zn_area` VALUES ('74', '张掖', '2', '74', '4', null);
INSERT INTO `zn_area` VALUES ('740', '企石镇', '3', '740', '78', null);
INSERT INTO `zn_area` VALUES ('741', '石排镇', '3', '741', '78', null);
INSERT INTO `zn_area` VALUES ('742', '长安镇', '3', '742', '78', null);
INSERT INTO `zn_area` VALUES ('743', '中堂镇', '3', '743', '78', null);
INSERT INTO `zn_area` VALUES ('744', '高埗镇', '3', '744', '78', null);
INSERT INTO `zn_area` VALUES ('745', '禅城区', '3', '745', '79', null);
INSERT INTO `zn_area` VALUES ('746', '南海区', '3', '746', '79', null);
INSERT INTO `zn_area` VALUES ('747', '顺德区', '3', '747', '79', null);
INSERT INTO `zn_area` VALUES ('748', '三水区', '3', '748', '79', null);
INSERT INTO `zn_area` VALUES ('749', '高明区', '3', '749', '79', null);
INSERT INTO `zn_area` VALUES ('75', '广州', '2', '75', '5', null);
INSERT INTO `zn_area` VALUES ('750', '东源县', '3', '750', '80', null);
INSERT INTO `zn_area` VALUES ('751', '和平县', '3', '751', '80', null);
INSERT INTO `zn_area` VALUES ('752', '源城区', '3', '752', '80', null);
INSERT INTO `zn_area` VALUES ('753', '连平县', '3', '753', '80', null);
INSERT INTO `zn_area` VALUES ('754', '龙川县', '3', '754', '80', null);
INSERT INTO `zn_area` VALUES ('755', '紫金县', '3', '755', '80', null);
INSERT INTO `zn_area` VALUES ('756', '惠阳区', '3', '756', '81', null);
INSERT INTO `zn_area` VALUES ('757', '惠城区', '3', '757', '81', null);
INSERT INTO `zn_area` VALUES ('758', '大亚湾', '3', '758', '81', null);
INSERT INTO `zn_area` VALUES ('759', '博罗县', '3', '759', '81', null);
INSERT INTO `zn_area` VALUES ('76', '深圳', '2', '76', '5', null);
INSERT INTO `zn_area` VALUES ('760', '惠东县', '3', '760', '81', null);
INSERT INTO `zn_area` VALUES ('761', '龙门县', '3', '761', '81', null);
INSERT INTO `zn_area` VALUES ('762', '江海区', '3', '762', '82', null);
INSERT INTO `zn_area` VALUES ('763', '蓬江区', '3', '763', '82', null);
INSERT INTO `zn_area` VALUES ('764', '新会区', '3', '764', '82', null);
INSERT INTO `zn_area` VALUES ('765', '台山市', '3', '765', '82', null);
INSERT INTO `zn_area` VALUES ('766', '开平市', '3', '766', '82', null);
INSERT INTO `zn_area` VALUES ('767', '鹤山市', '3', '767', '82', null);
INSERT INTO `zn_area` VALUES ('768', '恩平市', '3', '768', '82', null);
INSERT INTO `zn_area` VALUES ('769', '榕城区', '3', '769', '83', null);
INSERT INTO `zn_area` VALUES ('77', '潮州', '2', '77', '5', null);
INSERT INTO `zn_area` VALUES ('770', '普宁市', '3', '770', '83', null);
INSERT INTO `zn_area` VALUES ('771', '揭东县', '3', '771', '83', null);
INSERT INTO `zn_area` VALUES ('772', '揭西县', '3', '772', '83', null);
INSERT INTO `zn_area` VALUES ('773', '惠来县', '3', '773', '83', null);
INSERT INTO `zn_area` VALUES ('774', '茂南区', '3', '774', '84', null);
INSERT INTO `zn_area` VALUES ('775', '茂港区', '3', '775', '84', null);
INSERT INTO `zn_area` VALUES ('776', '高州市', '3', '776', '84', null);
INSERT INTO `zn_area` VALUES ('777', '化州市', '3', '777', '84', null);
INSERT INTO `zn_area` VALUES ('778', '信宜市', '3', '778', '84', null);
INSERT INTO `zn_area` VALUES ('779', '电白县', '3', '779', '84', null);
INSERT INTO `zn_area` VALUES ('78', '东莞', '2', '78', '5', null);
INSERT INTO `zn_area` VALUES ('780', '梅县', '3', '780', '85', null);
INSERT INTO `zn_area` VALUES ('781', '梅江区', '3', '781', '85', null);
INSERT INTO `zn_area` VALUES ('782', '兴宁市', '3', '782', '85', null);
INSERT INTO `zn_area` VALUES ('783', '大埔县', '3', '783', '85', null);
INSERT INTO `zn_area` VALUES ('784', '丰顺县', '3', '784', '85', null);
INSERT INTO `zn_area` VALUES ('785', '五华县', '3', '785', '85', null);
INSERT INTO `zn_area` VALUES ('786', '平远县', '3', '786', '85', null);
INSERT INTO `zn_area` VALUES ('787', '蕉岭县', '3', '787', '85', null);
INSERT INTO `zn_area` VALUES ('788', '清城区', '3', '788', '86', null);
INSERT INTO `zn_area` VALUES ('789', '英德市', '3', '789', '86', null);
INSERT INTO `zn_area` VALUES ('79', '佛山', '2', '79', '5', null);
INSERT INTO `zn_area` VALUES ('790', '连州市', '3', '790', '86', null);
INSERT INTO `zn_area` VALUES ('791', '佛冈县', '3', '791', '86', null);
INSERT INTO `zn_area` VALUES ('792', '阳山县', '3', '792', '86', null);
INSERT INTO `zn_area` VALUES ('793', '清新县', '3', '793', '86', null);
INSERT INTO `zn_area` VALUES ('794', '连山县', '3', '794', '86', null);
INSERT INTO `zn_area` VALUES ('795', '连南县', '3', '795', '86', null);
INSERT INTO `zn_area` VALUES ('796', '南澳县', '3', '796', '87', null);
INSERT INTO `zn_area` VALUES ('797', '潮阳区', '3', '797', '87', null);
INSERT INTO `zn_area` VALUES ('798', '澄海区', '3', '798', '87', null);
INSERT INTO `zn_area` VALUES ('799', '龙湖区', '3', '799', '87', null);
INSERT INTO `zn_area` VALUES ('8', '海南', '1', '8', '0', null);
INSERT INTO `zn_area` VALUES ('80', '河源', '2', '80', '5', null);
INSERT INTO `zn_area` VALUES ('800', '金平区', '3', '800', '87', null);
INSERT INTO `zn_area` VALUES ('801', '濠江区', '3', '801', '87', null);
INSERT INTO `zn_area` VALUES ('802', '潮南区', '3', '802', '87', null);
INSERT INTO `zn_area` VALUES ('803', '城区', '3', '803', '88', null);
INSERT INTO `zn_area` VALUES ('804', '陆丰市', '3', '804', '88', null);
INSERT INTO `zn_area` VALUES ('805', '海丰县', '3', '805', '88', null);
INSERT INTO `zn_area` VALUES ('806', '陆河县', '3', '806', '88', null);
INSERT INTO `zn_area` VALUES ('807', '曲江区', '3', '807', '89', null);
INSERT INTO `zn_area` VALUES ('808', '浈江区', '3', '808', '89', null);
INSERT INTO `zn_area` VALUES ('809', '武江区', '3', '809', '89', null);
INSERT INTO `zn_area` VALUES ('81', '惠州', '2', '81', '5', null);
INSERT INTO `zn_area` VALUES ('810', '曲江区', '3', '810', '89', null);
INSERT INTO `zn_area` VALUES ('811', '乐昌市', '3', '811', '89', null);
INSERT INTO `zn_area` VALUES ('812', '南雄市', '3', '812', '89', null);
INSERT INTO `zn_area` VALUES ('813', '始兴县', '3', '813', '89', null);
INSERT INTO `zn_area` VALUES ('814', '仁化县', '3', '814', '89', null);
INSERT INTO `zn_area` VALUES ('815', '翁源县', '3', '815', '89', null);
INSERT INTO `zn_area` VALUES ('816', '新丰县', '3', '816', '89', null);
INSERT INTO `zn_area` VALUES ('817', '乳源县', '3', '817', '89', null);
INSERT INTO `zn_area` VALUES ('818', '江城区', '3', '818', '90', null);
INSERT INTO `zn_area` VALUES ('819', '阳春市', '3', '819', '90', null);
INSERT INTO `zn_area` VALUES ('82', '江门', '2', '82', '5', null);
INSERT INTO `zn_area` VALUES ('820', '阳西县', '3', '820', '90', null);
INSERT INTO `zn_area` VALUES ('821', '阳东县', '3', '821', '90', null);
INSERT INTO `zn_area` VALUES ('822', '云城区', '3', '822', '91', null);
INSERT INTO `zn_area` VALUES ('823', '罗定市', '3', '823', '91', null);
INSERT INTO `zn_area` VALUES ('824', '新兴县', '3', '824', '91', null);
INSERT INTO `zn_area` VALUES ('825', '郁南县', '3', '825', '91', null);
INSERT INTO `zn_area` VALUES ('826', '云安县', '3', '826', '91', null);
INSERT INTO `zn_area` VALUES ('827', '赤坎区', '3', '827', '92', null);
INSERT INTO `zn_area` VALUES ('828', '霞山区', '3', '828', '92', null);
INSERT INTO `zn_area` VALUES ('829', '坡头区', '3', '829', '92', null);
INSERT INTO `zn_area` VALUES ('83', '揭阳', '2', '83', '5', null);
INSERT INTO `zn_area` VALUES ('830', '麻章区', '3', '830', '92', null);
INSERT INTO `zn_area` VALUES ('831', '廉江市', '3', '831', '92', null);
INSERT INTO `zn_area` VALUES ('832', '雷州市', '3', '832', '92', null);
INSERT INTO `zn_area` VALUES ('833', '吴川市', '3', '833', '92', null);
INSERT INTO `zn_area` VALUES ('834', '遂溪县', '3', '834', '92', null);
INSERT INTO `zn_area` VALUES ('835', '徐闻县', '3', '835', '92', null);
INSERT INTO `zn_area` VALUES ('837', '高要区', '3', '837', '93', null);
INSERT INTO `zn_area` VALUES ('838', '四会市', '3', '838', '93', null);
INSERT INTO `zn_area` VALUES ('839', '广宁县', '3', '839', '93', null);
INSERT INTO `zn_area` VALUES ('84', '茂名', '2', '84', '5', null);
INSERT INTO `zn_area` VALUES ('840', '怀集县', '3', '840', '93', null);
INSERT INTO `zn_area` VALUES ('841', '封开县', '3', '841', '93', null);
INSERT INTO `zn_area` VALUES ('842', '德庆县', '3', '842', '93', null);
INSERT INTO `zn_area` VALUES ('843', '石岐街道', '3', '843', '94', null);
INSERT INTO `zn_area` VALUES ('844', '东区街道', '3', '844', '94', null);
INSERT INTO `zn_area` VALUES ('845', '西区街道', '3', '845', '94', null);
INSERT INTO `zn_area` VALUES ('846', '环城街道', '3', '846', '94', null);
INSERT INTO `zn_area` VALUES ('847', '中山港街道', '3', '847', '94', null);
INSERT INTO `zn_area` VALUES ('848', '五桂山街道', '3', '848', '94', null);
INSERT INTO `zn_area` VALUES ('849', '香洲区', '3', '849', '95', null);
INSERT INTO `zn_area` VALUES ('85', '梅州', '2', '85', '5', null);
INSERT INTO `zn_area` VALUES ('850', '斗门区', '3', '850', '95', null);
INSERT INTO `zn_area` VALUES ('851', '金湾区', '3', '851', '95', null);
INSERT INTO `zn_area` VALUES ('852', '邕宁区', '3', '852', '96', null);
INSERT INTO `zn_area` VALUES ('853', '青秀区', '3', '853', '96', null);
INSERT INTO `zn_area` VALUES ('854', '兴宁区', '3', '854', '96', null);
INSERT INTO `zn_area` VALUES ('855', '良庆区', '3', '855', '96', null);
INSERT INTO `zn_area` VALUES ('856', '西乡塘区', '3', '856', '96', null);
INSERT INTO `zn_area` VALUES ('857', '江南区', '3', '857', '96', null);
INSERT INTO `zn_area` VALUES ('858', '武鸣县', '3', '858', '96', null);
INSERT INTO `zn_area` VALUES ('859', '隆安县', '3', '859', '96', null);
INSERT INTO `zn_area` VALUES ('86', '清远', '2', '86', '5', null);
INSERT INTO `zn_area` VALUES ('860', '马山县', '3', '860', '96', null);
INSERT INTO `zn_area` VALUES ('861', '上林县', '3', '861', '96', null);
INSERT INTO `zn_area` VALUES ('862', '宾阳县', '3', '862', '96', null);
INSERT INTO `zn_area` VALUES ('863', '横县', '3', '863', '96', null);
INSERT INTO `zn_area` VALUES ('864', '秀峰区', '3', '864', '97', null);
INSERT INTO `zn_area` VALUES ('865', '叠彩区', '3', '865', '97', null);
INSERT INTO `zn_area` VALUES ('866', '象山区', '3', '866', '97', null);
INSERT INTO `zn_area` VALUES ('867', '七星区', '3', '867', '97', null);
INSERT INTO `zn_area` VALUES ('868', '雁山区', '3', '868', '97', null);
INSERT INTO `zn_area` VALUES ('869', '阳朔县', '3', '869', '97', null);
INSERT INTO `zn_area` VALUES ('87', '汕头', '2', '87', '5', null);
INSERT INTO `zn_area` VALUES ('870', '临桂县', '3', '870', '97', null);
INSERT INTO `zn_area` VALUES ('871', '灵川县', '3', '871', '97', null);
INSERT INTO `zn_area` VALUES ('872', '全州县', '3', '872', '97', null);
INSERT INTO `zn_area` VALUES ('873', '平乐县', '3', '873', '97', null);
INSERT INTO `zn_area` VALUES ('874', '兴安县', '3', '874', '97', null);
INSERT INTO `zn_area` VALUES ('875', '灌阳县', '3', '875', '97', null);
INSERT INTO `zn_area` VALUES ('876', '荔浦县', '3', '876', '97', null);
INSERT INTO `zn_area` VALUES ('877', '资源县', '3', '877', '97', null);
INSERT INTO `zn_area` VALUES ('878', '永福县', '3', '878', '97', null);
INSERT INTO `zn_area` VALUES ('879', '龙胜县', '3', '879', '97', null);
INSERT INTO `zn_area` VALUES ('88', '汕尾', '2', '88', '5', null);
INSERT INTO `zn_area` VALUES ('880', '恭城县', '3', '880', '97', null);
INSERT INTO `zn_area` VALUES ('881', '右江区', '3', '881', '98', null);
INSERT INTO `zn_area` VALUES ('882', '凌云县', '3', '882', '98', null);
INSERT INTO `zn_area` VALUES ('883', '平果县', '3', '883', '98', null);
INSERT INTO `zn_area` VALUES ('884', '西林县', '3', '884', '98', null);
INSERT INTO `zn_area` VALUES ('885', '乐业县', '3', '885', '98', null);
INSERT INTO `zn_area` VALUES ('886', '德保县', '3', '886', '98', null);
INSERT INTO `zn_area` VALUES ('887', '田林县', '3', '887', '98', null);
INSERT INTO `zn_area` VALUES ('888', '田阳县', '3', '888', '98', null);
INSERT INTO `zn_area` VALUES ('889', '靖西县', '3', '889', '98', null);
INSERT INTO `zn_area` VALUES ('89', '韶关', '2', '89', '5', null);
INSERT INTO `zn_area` VALUES ('890', '田东县', '3', '890', '98', null);
INSERT INTO `zn_area` VALUES ('891', '那坡县', '3', '891', '98', null);
INSERT INTO `zn_area` VALUES ('892', '隆林县', '3', '892', '98', null);
INSERT INTO `zn_area` VALUES ('893', '海城区', '3', '893', '99', null);
INSERT INTO `zn_area` VALUES ('894', '银海区', '3', '894', '99', null);
INSERT INTO `zn_area` VALUES ('895', '铁山港区', '3', '895', '99', null);
INSERT INTO `zn_area` VALUES ('896', '合浦县', '3', '896', '99', null);
INSERT INTO `zn_area` VALUES ('897', '江州区', '3', '897', '100', null);
INSERT INTO `zn_area` VALUES ('898', '凭祥市', '3', '898', '100', null);
INSERT INTO `zn_area` VALUES ('899', '宁明县', '3', '899', '100', null);
INSERT INTO `zn_area` VALUES ('9', '河北', '1', '9', '0', null);
INSERT INTO `zn_area` VALUES ('90', '阳江', '2', '90', '5', null);
INSERT INTO `zn_area` VALUES ('900', '扶绥县', '3', '900', '100', null);
INSERT INTO `zn_area` VALUES ('901', '龙州县', '3', '901', '100', null);
INSERT INTO `zn_area` VALUES ('902', '大新县', '3', '902', '100', null);
INSERT INTO `zn_area` VALUES ('903', '天等县', '3', '903', '100', null);
INSERT INTO `zn_area` VALUES ('904', '港口区', '3', '904', '101', null);
INSERT INTO `zn_area` VALUES ('905', '防城区', '3', '905', '101', null);
INSERT INTO `zn_area` VALUES ('906', '东兴市', '3', '906', '101', null);
INSERT INTO `zn_area` VALUES ('907', '上思县', '3', '907', '101', null);
INSERT INTO `zn_area` VALUES ('908', '港北区', '3', '908', '102', null);
INSERT INTO `zn_area` VALUES ('909', '港南区', '3', '909', '102', null);
INSERT INTO `zn_area` VALUES ('91', '云浮', '2', '91', '5', null);
INSERT INTO `zn_area` VALUES ('910', '覃塘区', '3', '910', '102', null);
INSERT INTO `zn_area` VALUES ('911', '桂平市', '3', '911', '102', null);
INSERT INTO `zn_area` VALUES ('912', '平南县', '3', '912', '102', null);
INSERT INTO `zn_area` VALUES ('913', '金城江区', '3', '913', '103', null);
INSERT INTO `zn_area` VALUES ('914', '宜州市', '3', '914', '103', null);
INSERT INTO `zn_area` VALUES ('915', '天峨县', '3', '915', '103', null);
INSERT INTO `zn_area` VALUES ('916', '凤山县', '3', '916', '103', null);
INSERT INTO `zn_area` VALUES ('917', '南丹县', '3', '917', '103', null);
INSERT INTO `zn_area` VALUES ('918', '东兰县', '3', '918', '103', null);
INSERT INTO `zn_area` VALUES ('919', '都安县', '3', '919', '103', null);
INSERT INTO `zn_area` VALUES ('92', '湛江', '2', '92', '5', null);
INSERT INTO `zn_area` VALUES ('920', '罗城县', '3', '920', '103', null);
INSERT INTO `zn_area` VALUES ('921', '巴马县', '3', '921', '103', null);
INSERT INTO `zn_area` VALUES ('922', '环江县', '3', '922', '103', null);
INSERT INTO `zn_area` VALUES ('923', '大化县', '3', '923', '103', null);
INSERT INTO `zn_area` VALUES ('924', '八步区', '3', '924', '104', null);
INSERT INTO `zn_area` VALUES ('925', '钟山县', '3', '925', '104', null);
INSERT INTO `zn_area` VALUES ('926', '昭平县', '3', '926', '104', null);
INSERT INTO `zn_area` VALUES ('927', '富川县', '3', '927', '104', null);
INSERT INTO `zn_area` VALUES ('928', '兴宾区', '3', '928', '105', null);
INSERT INTO `zn_area` VALUES ('929', '合山市', '3', '929', '105', null);
INSERT INTO `zn_area` VALUES ('93', '肇庆', '2', '93', '5', null);
INSERT INTO `zn_area` VALUES ('930', '象州县', '3', '930', '105', null);
INSERT INTO `zn_area` VALUES ('931', '武宣县', '3', '931', '105', null);
INSERT INTO `zn_area` VALUES ('932', '忻城县', '3', '932', '105', null);
INSERT INTO `zn_area` VALUES ('933', '金秀县', '3', '933', '105', null);
INSERT INTO `zn_area` VALUES ('934', '城中区', '3', '934', '106', null);
INSERT INTO `zn_area` VALUES ('935', '鱼峰区', '3', '935', '106', null);
INSERT INTO `zn_area` VALUES ('936', '柳北区', '3', '936', '106', null);
INSERT INTO `zn_area` VALUES ('937', '柳南区', '3', '937', '106', null);
INSERT INTO `zn_area` VALUES ('938', '柳江县', '3', '938', '106', null);
INSERT INTO `zn_area` VALUES ('939', '柳城县', '3', '939', '106', null);
INSERT INTO `zn_area` VALUES ('94', '中山', '2', '94', '5', null);
INSERT INTO `zn_area` VALUES ('940', '鹿寨县', '3', '940', '106', null);
INSERT INTO `zn_area` VALUES ('941', '融安县', '3', '941', '106', null);
INSERT INTO `zn_area` VALUES ('942', '融水县', '3', '942', '106', null);
INSERT INTO `zn_area` VALUES ('943', '三江县', '3', '943', '106', null);
INSERT INTO `zn_area` VALUES ('944', '钦南区', '3', '944', '107', null);
INSERT INTO `zn_area` VALUES ('945', '钦北区', '3', '945', '107', null);
INSERT INTO `zn_area` VALUES ('946', '灵山县', '3', '946', '107', null);
INSERT INTO `zn_area` VALUES ('947', '浦北县', '3', '947', '107', null);
INSERT INTO `zn_area` VALUES ('948', '万秀区', '3', '948', '108', null);
INSERT INTO `zn_area` VALUES ('949', '蝶山区', '3', '949', '108', null);
INSERT INTO `zn_area` VALUES ('95', '珠海', '2', '95', '5', null);
INSERT INTO `zn_area` VALUES ('950', '长洲区', '3', '950', '108', null);
INSERT INTO `zn_area` VALUES ('951', '岑溪市', '3', '951', '108', null);
INSERT INTO `zn_area` VALUES ('952', '苍梧县', '3', '952', '108', null);
INSERT INTO `zn_area` VALUES ('953', '藤县', '3', '953', '108', null);
INSERT INTO `zn_area` VALUES ('954', '蒙山县', '3', '954', '108', null);
INSERT INTO `zn_area` VALUES ('955', '玉州区', '3', '955', '109', null);
INSERT INTO `zn_area` VALUES ('956', '北流市', '3', '956', '109', null);
INSERT INTO `zn_area` VALUES ('957', '容县', '3', '957', '109', null);
INSERT INTO `zn_area` VALUES ('958', '陆川县', '3', '958', '109', null);
INSERT INTO `zn_area` VALUES ('959', '博白县', '3', '959', '109', null);
INSERT INTO `zn_area` VALUES ('96', '南宁', '2', '96', '6', null);
INSERT INTO `zn_area` VALUES ('960', '兴业县', '3', '960', '109', null);
INSERT INTO `zn_area` VALUES ('961', '南明区', '3', '961', '110', null);
INSERT INTO `zn_area` VALUES ('962', '云岩区', '3', '962', '110', null);
INSERT INTO `zn_area` VALUES ('963', '花溪区', '3', '963', '110', null);
INSERT INTO `zn_area` VALUES ('964', '乌当区', '3', '964', '110', null);
INSERT INTO `zn_area` VALUES ('965', '白云区', '3', '965', '110', null);
INSERT INTO `zn_area` VALUES ('966', '小河区', '3', '966', '110', null);
INSERT INTO `zn_area` VALUES ('967', '金阳新区', '3', '967', '110', null);
INSERT INTO `zn_area` VALUES ('968', '新天园区', '3', '968', '110', null);
INSERT INTO `zn_area` VALUES ('969', '清镇市', '3', '969', '110', null);
INSERT INTO `zn_area` VALUES ('97', '桂林', '2', '97', '6', null);
INSERT INTO `zn_area` VALUES ('970', '开阳县', '3', '970', '110', null);
INSERT INTO `zn_area` VALUES ('971', '修文县', '3', '971', '110', null);
INSERT INTO `zn_area` VALUES ('972', '息烽县', '3', '972', '110', null);
INSERT INTO `zn_area` VALUES ('973', '西秀区', '3', '973', '111', null);
INSERT INTO `zn_area` VALUES ('974', '关岭县', '3', '974', '111', null);
INSERT INTO `zn_area` VALUES ('975', '镇宁县', '3', '975', '111', null);
INSERT INTO `zn_area` VALUES ('976', '紫云县', '3', '976', '111', null);
INSERT INTO `zn_area` VALUES ('977', '平坝县', '3', '977', '111', null);
INSERT INTO `zn_area` VALUES ('978', '普定县', '3', '978', '111', null);
INSERT INTO `zn_area` VALUES ('979', '七星关区', '3', '979', '112', null);
INSERT INTO `zn_area` VALUES ('98', '百色', '2', '98', '6', null);
INSERT INTO `zn_area` VALUES ('980', '大方县', '3', '980', '112', null);
INSERT INTO `zn_area` VALUES ('981', '黔西县', '3', '981', '112', null);
INSERT INTO `zn_area` VALUES ('982', '金沙县', '3', '982', '112', null);
INSERT INTO `zn_area` VALUES ('983', '织金县', '3', '983', '112', null);
INSERT INTO `zn_area` VALUES ('984', '纳雍县', '3', '984', '112', null);
INSERT INTO `zn_area` VALUES ('985', '赫章县', '3', '985', '112', null);
INSERT INTO `zn_area` VALUES ('986', '威宁县', '3', '986', '112', null);
INSERT INTO `zn_area` VALUES ('987', '钟山区', '3', '987', '113', null);
INSERT INTO `zn_area` VALUES ('988', '六枝特区', '3', '988', '113', null);
INSERT INTO `zn_area` VALUES ('989', '水城县', '3', '989', '113', null);
INSERT INTO `zn_area` VALUES ('99', '北海', '2', '99', '6', null);
INSERT INTO `zn_area` VALUES ('990', '盘县', '3', '990', '113', null);
INSERT INTO `zn_area` VALUES ('991', '凯里市', '3', '991', '114', null);
INSERT INTO `zn_area` VALUES ('992', '黄平县', '3', '992', '114', null);
INSERT INTO `zn_area` VALUES ('993', '施秉县', '3', '993', '114', null);
INSERT INTO `zn_area` VALUES ('994', '三穗县', '3', '994', '114', null);
INSERT INTO `zn_area` VALUES ('995', '镇远县', '3', '995', '114', null);
INSERT INTO `zn_area` VALUES ('996', '岑巩县', '3', '996', '114', null);
INSERT INTO `zn_area` VALUES ('997', '天柱县', '3', '997', '114', null);
INSERT INTO `zn_area` VALUES ('998', '锦屏县', '3', '998', '114', null);
INSERT INTO `zn_area` VALUES ('999', '剑河县', '3', '999', '114', null);



