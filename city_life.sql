/*
 Navicat Premium Data Transfer

 Source Server         : localhost-Mysql
 Source Server Type    : MySQL
 Source Server Version : 50731
 Source Host           : localhost:3306
 Source Schema         : city_life

 Target Server Type    : MySQL
 Target Server Version : 50731
 File Encoding         : 65001

 Date: 07/10/2020 09:27:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin`  (
  `id` int(11) NOT NULL,
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '管理员账户名',
  `pwd` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '管理员密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES (1, 'admin', 'admin');

-- ----------------------------
-- Table structure for t_company
-- ----------------------------
DROP TABLE IF EXISTS `t_company`;
CREATE TABLE `t_company`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '公司id',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '公司名称',
  `legal_rep` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '法人代表',
  `usd` decimal(10, 2) NULL DEFAULT NULL COMMENT '注册资金（美元）',
  `establish_time` date NULL DEFAULT NULL COMMENT '成立时间',
  `emp_type` smallint(1) NULL DEFAULT NULL COMMENT '企业类型（1-有限责任公司（中外合资））',
  `status` smallint(1) NULL DEFAULT NULL COMMENT '经营状态（0-开业）',
  `stage` smallint(1) NULL DEFAULT NULL COMMENT '公司阶段（0-已上市）',
  `scale` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '公司规模',
  `industry` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '公司行业方向',
  `web_site` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '公司网站首页',
  `logo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '公司logo',
  `abbreviation` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '公司简称',
  `audit` smallint(1) NULL DEFAULT NULL COMMENT '公司审核状态（0-审核中  1-审核成功  2-审核失败）',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_audit`(`audit`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_company
-- ----------------------------
INSERT INTO `t_company` VALUES (1, '软通动力信息技术（集团）有限公司', '刘天文', 3852.70, '2005-11-04', 1, 0, 2, '10000人以上', '计算机软件', 'http://www.isoftstone.com', 'group1/M00/00/00/wKgApF9qs3qAKITjAAAItY61HBI174.jpg', '软通动力', 1);
INSERT INTO `t_company` VALUES (6, '77', '77', 77.00, '2020-09-14', 1, 0, 5, '0-20人', '计算机软件', '77', 'group1/M00/00/00/wKgApF9usJyAKSOvAABUKGFjd8g821.jpg', '77', 1);
INSERT INTO `t_company` VALUES (7, '123', '123', 123.00, '2020-09-30', 1, 0, 2, '20-99人', '计算机软件', '123', 'group1/M00/00/00/wKgApF9uvWqAIsTuAACNnvGSkEY718.jpg', '123', 1);
INSERT INTO `t_company` VALUES (8, '444', '444', 444.00, '2020-09-24', 1, 0, 8, '100-499人', '智能硬件', '444', 'group1/M00/00/00/wKgApF9u5Q2AQtazAABUKGFjd8g257.jpg', '444', 0);
INSERT INTO `t_company` VALUES (9, '888', '888', 888.00, '2020-09-28', 1, 0, 8, '0-20人', '智能硬件', '888', 'group1/M00/00/00/wKgApF9u5mKAMnioAACNnvGSkEY088.jpg', '888', 1);
INSERT INTO `t_company` VALUES (10, '76', '76', 76.00, '2020-09-16', 1, 0, 6, '1000-9999人', '互联网', '76', 'group1/M00/00/00/wKgApF9u6DKASjnpAACNnvGSkEY701.jpg', '76', 0);
INSERT INTO `t_company` VALUES (11, '浙江大华技术股份有限公司', '傅利泉', 43997.99, '2001-03-12', 2, 0, 7, '1000-9999人', '计算机软件', 'http://www.dahuatech.com', 'group1/M00/00/00/wKgApF9xhy2ANuA3AAAm_CgGo7w081.jpg', '浙江大华', 1);
INSERT INTO `t_company` VALUES (13, '平安普惠投资咨询有限公司武汉太平洋分公司', '卢婧怡', 1000.00, '2013-06-05', 3, 0, 8, '10000人以上', '互联网金融', 'http://m.ph.com.cn/index.html', 'group1/M00/00/01/wKgApF90I06AAbVuAAARxO6LjmA631.jpg', '平安普惠信贷', 1);
INSERT INTO `t_company` VALUES (14, '耀方信息技术（上海）有限公司', '牟青', 25000.00, '2013-08-12', 3, 0, 8, '1000-9999人', '互联网', 'http://www.111.com.cn', 'group1/M00/00/01/wKgApF90NbeAU7IxAAAnHEK757Q283.jpg', '1药网', 1);
INSERT INTO `t_company` VALUES (15, '南京烽火软件科技有限公司', '汪洋', 2000.00, '2015-12-11', 3, 0, 7, '1000-9999人', '互联网', 'http://www.fhss.com.cn', 'group1/M00/00/01/wKgApF90NlGAF79fAAAUDQ-WLJE533.jpg', '南京烽火', 1);
INSERT INTO `t_company` VALUES (16, '测试', '测试', 100.00, '2020-10-05', 2, 0, 0, '100-499人', '计算机软件', 'http://localhost', 'group1/M00/00/01/wKgApF95_MiAIzZKAACNnvGSkEY418.jpg', '测试', 0);
INSERT INTO `t_company` VALUES (17, 'cscscs', 'cscscs', 100.00, '2020-09-07', 2, 0, 0, '20-99人', '移动互联网', 'http://localhost:9530/#/app', 'group1/M00/00/01/wKgApF96frCAc4UQAAAItY61HBI952.jpg', 'cscscs', 1);

-- ----------------------------
-- Table structure for t_company_apply
-- ----------------------------
DROP TABLE IF EXISTS `t_company_apply`;
CREATE TABLE `t_company_apply`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NULL DEFAULT NULL COMMENT '申请账户Id',
  `cid` int(11) NULL DEFAULT NULL COMMENT '申请公司Id',
  `apply_time` datetime(0) NULL DEFAULT NULL COMMENT '申请时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_company_apply
-- ----------------------------
INSERT INTO `t_company_apply` VALUES (1, 19, 11, '2020-09-28 00:00:00');
INSERT INTO `t_company_apply` VALUES (2, 19, 13, '2020-09-30 00:00:00');
INSERT INTO `t_company_apply` VALUES (3, 19, 14, '2020-09-30 00:00:00');
INSERT INTO `t_company_apply` VALUES (4, 19, 15, '2020-09-30 00:00:00');
INSERT INTO `t_company_apply` VALUES (5, 19, 16, '2020-10-05 00:00:00');
INSERT INTO `t_company_apply` VALUES (6, 19, 17, '2020-10-05 00:00:00');

-- ----------------------------
-- Table structure for t_company_describe
-- ----------------------------
DROP TABLE IF EXISTS `t_company_describe`;
CREATE TABLE `t_company_describe`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '公司介绍',
  `company_id` int(11) NULL DEFAULT NULL COMMENT '公司id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_company_describe
-- ----------------------------
INSERT INTO `t_company_describe` VALUES (1, '<div class=\"text\">\r\n                  软通动力信息技术（集团）有限公司： <br/><br/>软通动力信息技术（集团）有限公司（以下简称：软通动力）是中国领先的创新型软件及信息技术服务商，数字经济使能者。公司2001年成立于北京，立足中国，服务全球市场。经过17年发展，目前公司在全球36个城市设有90余个分支机构25个全球交付中心，员工总数60000+\r\n                </div>', 1);
INSERT INTO `t_company_describe` VALUES (2, '<p>12345</p>\n<p>666666</p>\n<p>77777</p>\n<p>888888888</p>\n<p>&nbsp;</p>', 6);
INSERT INTO `t_company_describe` VALUES (5, '<p>99999</p>\n<ol>\n<li>999999</li>\n<li>9999</li>\n</ol>\n<p>9999</p>\n<hr />\n<p>9999</p>\n<p>123</p>', 7);
INSERT INTO `t_company_describe` VALUES (6, '<p>333</p>\n<p>4444</p>\n<p>4444</p>\n<p>44444</p>\n<p>44444</p>\n<p>44444</p>\n<p>44444</p>', 8);
INSERT INTO `t_company_describe` VALUES (7, '<p>88888899</p>\n<p>88888899</p>', 9);
INSERT INTO `t_company_describe` VALUES (8, '<p>76</p>\n<p>76</p>\n<p>76</p>', 10);
INSERT INTO `t_company_describe` VALUES (9, '<p>（股票代码002236），公司拥有国家级博士后科研工作站、国家认定企业技术中心，相继与ADI、TI、ALTERA等建立了联合实验室，现已承接3项国家火炬计划项目、2项国家高技术产业化重大专项，1项国家科技重大专项课题，4项电子信息产业发展基金项目。2006-2010年连续5年被列入国家规划布局内重点软件企业，拥有及获得受理专利592项，其中拥有发明专利32项，连续12年荣获中国安防十大品牌，连续8年入选《A&amp;S》&ldquo;全球安防50强&rdquo;（2015年位列第五位），2014年IHS机构权威报告全球安防视频监控市场占有率位列第二，全球DVR市场占有率位列第二。是中国平安城市建设推荐品牌和中国安防最具影响力的品牌之一。</p>', 11);
INSERT INTO `t_company_describe` VALUES (10, '<p>平安普惠业务集群（以下简称&ldquo;平安普惠&rdquo;）是中国平安（集团）股份有限公司联营公司旗下成员，致力于以创新科技和完善风控，协助广大小微型企业主、个体工商户、普通工薪阶层获得专业借款服务，助力中国实体经济发展。<br />经过超十年快速发展，平安普惠在综合实力、公司治理等方面已成长为行业专业典范：拥有卓越的国际化管理团队，丰富信贷业务管理经验；通过人脸识别、微表情、人工智能技术、反欺诈扫描等创新信贷科技，不断提高风险管控能力，稳健领先的风险管理能力也使资产风险表现持续优化；多元借款方案为借款人提供定制化服务，也为普罗大众提供优质借款选择；同时，全线上申请流程以及线下顾问服务，不断提升服务体验。目前，平安普惠业务覆盖全国300余个城市，线上超7000人的远程团队7&times;24小时提供专业咨询服务，强大的外部商务合作能力，构建借款生态系统。平安普惠已累计服务客户超1000万。平安普惠将继续秉承客户普惠、产品普惠、渠道普惠、社会普惠四个驱动力，以&ldquo;责任金融、普惠借贷&rdquo;的品牌理念践行普惠金融。<br />未来，平安普惠将在平安3.0时代的背景下，不断加强普惠金融推广，致力于协助广大小微型企业主、个体工商户、普通工薪阶层获得更加优质的借款服务，打造全球最值得信赖的、客户首选的普惠金融品牌。</p>', 13);
INSERT INTO `t_company_describe` VALUES (11, '<p>1药网由于刚和刘峻岭于2010年创建，是中国互联网医药健康的领军企业，致力于用互联网模式和思维方式，解决中国大众&ldquo;看病难买药贵&rdquo;的现状。1药网的使命是用数字科技将患者与药品和医疗服务有机链接。1药网运用创新的互联网和IT技术提供在线诊疗和购药，缩减中间环节，优化供应链，为中国大众的就医买药提供完整的解决方案以及实惠和方便。<br />1药网旗下拥有：B2C医药平台&ldquo;1药网&rdquo;、互联网医院&ldquo;1诊&rdquo;，B2B医药平台&ldquo;1药城&rdquo;，通过创新的科技赋能的模式，全面实现B端和C端、线上和线下、自营和平台、医+药+保险的融合发展。1药网通过独特的以科技赋能商业去更好地服务大众（T2B2C）模式，打通线上线下零售终端，建立一体化的医药健康平台和生态圈，为医生、药店、医院、药企、药品流通商、保险企业等赋能。2018年，1药网成功登陆美国纳斯达克，成为中国互联网医药健康赴美上市第一股。</p>', 14);
INSERT INTO `t_company_describe` VALUES (12, '<p>中国信息通信科技集团有限公司由原武汉邮电科学研究院（烽火科技集团）和原电信科学技术研究院（大唐电信集团）联合重组而成，是国务院国资委直属中央企业。集团将致力于深入贯彻落实习总书记作出的 &ldquo;核心技术、关键技术、国之重器必须立足于自己&rdquo;等重要指示精神，坚持&ldquo;发展是第一要务、创新是第一动力、人才是第一资源&rdquo;的指导思想，全力打造世界一流的信息通信企业。<br />南京烽火星空通信发展有限公司（子公司南京烽火软件科技有限公司、南京烽火天地通信科技有限公司），是烽火通信科技股份有限公司的全资子公司，烽火通信是中国信科集团旗下上市公司。烽火星空从事面向互联网的网络信息安全、分布式大数据平台解决方案、人工智能研发。南京总部位于河西CBD新城科技园烽火科技大厦，在南京、杭州、北京、上海、广州、深圳、合肥、青岛、武汉、成都、重庆、乌鲁木齐、大连、沈阳、长春、贵阳、南宁、呼和浩特、天津、太原、石家庄、郑州等中心城市设有研发中心。拥有技术与市场的双重领先优势，业务范围覆盖全国，销售规模过二十亿。<br />烽火星空现有员工3000余人，已成为互联网信息安全和大数据平台解决方案领先的技术服务提供商，诚邀您加入！</p>', 15);
INSERT INTO `t_company_describe` VALUES (13, '<p>测试</p>', 16);
INSERT INTO `t_company_describe` VALUES (14, '<p>121212</p>', 17);

-- ----------------------------
-- Table structure for t_company_welfare
-- ----------------------------
DROP TABLE IF EXISTS `t_company_welfare`;
CREATE TABLE `t_company_welfare`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `company_id` int(11) NULL DEFAULT NULL COMMENT '公司Id',
  `welfare` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '公司福利',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_company_welfare
-- ----------------------------
INSERT INTO `t_company_welfare` VALUES (1, 1, '五险一金,定期体检,加班补助,年终奖,带薪年假,员工旅游,餐补,节日福利,零食下午茶');
INSERT INTO `t_company_welfare` VALUES (2, 6, '下午茶,带薪休假');
INSERT INTO `t_company_welfare` VALUES (3, 7, '999,9999,99999');
INSERT INTO `t_company_welfare` VALUES (4, 8, '4444,444,333');
INSERT INTO `t_company_welfare` VALUES (5, 9, '888,888,888,999');
INSERT INTO `t_company_welfare` VALUES (6, 10, '76,76,76,76');
INSERT INTO `t_company_welfare` VALUES (7, 11, '五险一金,补充医疗保险,定期体检,加班补助,年终奖股,股票期权,带薪年假,员工旅游');
INSERT INTO `t_company_welfare` VALUES (8, 13, '五险一金,补充医疗保险,定期体检');
INSERT INTO `t_company_welfare` VALUES (9, 14, '补充医疗保险,定期体检,年终奖,带薪年假');
INSERT INTO `t_company_welfare` VALUES (10, 15, '五险一金,补充医疗保险,年终奖');
INSERT INTO `t_company_welfare` VALUES (11, 16, '测试,测试');
INSERT INTO `t_company_welfare` VALUES (12, 17, 'cscs,cscs,cscs');

-- ----------------------------
-- Table structure for t_comstage
-- ----------------------------
DROP TABLE IF EXISTS `t_comstage`;
CREATE TABLE `t_comstage`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stage` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '公司阶段',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_comstage
-- ----------------------------
INSERT INTO `t_comstage` VALUES (1, '不限');
INSERT INTO `t_comstage` VALUES (2, '未融资');
INSERT INTO `t_comstage` VALUES (3, '天使轮');
INSERT INTO `t_comstage` VALUES (4, 'A轮');
INSERT INTO `t_comstage` VALUES (5, 'B轮');
INSERT INTO `t_comstage` VALUES (6, 'C轮');
INSERT INTO `t_comstage` VALUES (7, 'D轮及以上');
INSERT INTO `t_comstage` VALUES (8, '已上市');
INSERT INTO `t_comstage` VALUES (9, '不需要融资');

-- ----------------------------
-- Table structure for t_emptype
-- ----------------------------
DROP TABLE IF EXISTS `t_emptype`;
CREATE TABLE `t_emptype`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `emp_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '企业类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_emptype
-- ----------------------------
INSERT INTO `t_emptype` VALUES (1, '有限责任公司（中外合资）');
INSERT INTO `t_emptype` VALUES (2, '其他股份有限公司（上市）');
INSERT INTO `t_emptype` VALUES (3, '有限责任公司分公司（法人独资）');
INSERT INTO `t_emptype` VALUES (4, '有限责任公司（台港澳法人独资）');
INSERT INTO `t_emptype` VALUES (5, '有限责任公司（法人独资）');

-- ----------------------------
-- Table structure for t_industry
-- ----------------------------
DROP TABLE IF EXISTS `t_industry`;
CREATE TABLE `t_industry`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `industry` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '行业',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_industry
-- ----------------------------
INSERT INTO `t_industry` VALUES (1, '计算机软件');
INSERT INTO `t_industry` VALUES (2, '移动互联网');
INSERT INTO `t_industry` VALUES (3, '智能硬件');
INSERT INTO `t_industry` VALUES (4, '互联网');
INSERT INTO `t_industry` VALUES (5, '银行');
INSERT INTO `t_industry` VALUES (6, '互联网金融');

-- ----------------------------
-- Table structure for t_job_describe
-- ----------------------------
DROP TABLE IF EXISTS `t_job_describe`;
CREATE TABLE `t_job_describe`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '职位描述id',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '职位描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_job_describe
-- ----------------------------
INSERT INTO `t_job_describe` VALUES (1, '<div class=\"text\">\r\n                  华为云项目<br/>岗位说明：<br/>1.负责客户专业服务产品项目交付，特别上云迁移服务的技术交付工作。能独立针对客户中大规模，复杂、互联网架构的业务应用及数据上云迁移需求，进行调研评估，制定迁移方案，交付实施等工作；<br/>2.在客户上云迁移期间，负责客户迁移问题、需求的及时响应和快速处理；<br/>3.负责对客户上云迁移的项目管理，承担专业服务项目如迁移服务的客户满意度，做好客户管理、交付管理、收入管理等工作；<br/>4.协助售前架构师，提供业务上云技术支撑工作；<br/>5.负责问题总结和案例技术分享，承担团队技术能力成长工作。<br/>一、学历要求：<br/>全日制本科及以上学历，要求四年以上IT领域工作经验；<br/>能力优秀者可接受全日制专科学历。<br/>二、岗位要求：<br/>1.了解大中型企业业务场景，与企业的IT、应用架构、人员合作，针对客户现有IT架构进行梳理与分析，推动售前架构师所提供的设计方案的落地、实施和交付工作；<br/>2.根据客户业务需求，基于华为云技术架构，输出满足客户需求的服务解决方案；<br/>3.具备一定的P2V/V2V迁移经验，负责客户现有应用系统、数据往华为云上迁移技术的上云评估、实施方案的设计与实施；<br/>4.定期与重大客户深入的交流（现场或者远程），确保用户使用云上业务健康、稳定的运行，提升客户使用体验；；　<br/>5.拥有较强的抗压能力和执行力，勇于接受挑战，善于开拓创新，在高强度工作压力下保持乐观积极的工作态度及饱满的工作激情。<br/>三、技能要求（至少掌握以下技能中的4点）：<br/>1.熟悉主流数据库或者中间件，理解数据库原理，对主流数据库oracle、mysql、SQL server之一有维护或迁移或备份等项目经验。<br/>2.熟悉openstack等虚拟化架构及主流公有云服务，并能够清晰描述其工作原理和基础的架构逻辑，对AWS、腾讯云、阿里云等不同品牌的云服务区别，有一定认知；<br/>3.业界云提供商的资格认证；                                                                      <br/>4.具有丰富的企业级应用架构设计或云服务集成实施经验；<br/>5.熟悉python或go语言，能够熟练使用shell脚本语言；<br/>6.具备优秀的文档能力，能熟练编写技术文档；良好的沟通、协调及资源整合能力。<br/>注：有英语能力的可负责海外服务。<br/>工作地点：西安/深圳/廊坊均可。\r\n                </div>');
INSERT INTO `t_job_describe` VALUES (5, '<p>嵌入式linux应用开发，熟悉c++，熟悉常用调试手段，熟悉网络问题排查，有安防经验优先考虑</p>');
INSERT INTO `t_job_describe` VALUES (6, '<p>1. 专业提供客户融资解决方案；<br />2. 在目标市场建立并维护哈稳定的客户群，为符合客户做二次开发；<br />3. 负责渠道建设和维护工作，为目标市场搭建渠道体系；<br />4. 负责相应贷款产品的服务与品牌推广和团队管理合作。<br />任职资格：<br />1. 本科及以上学历，可接受优秀应届毕业生<br />2. 22-35周岁，普通话标准，男女不限<br />3. 不安于现状，敢于挑战高薪，承压能力强<br />4. 外向开朗，思维敏捷，善于观察，倾听和表达<br />5. 工作积极主动有责任感，细心谨慎注重团队协同<br />6. 有信贷经验、金融、地产、销售行业工作经验者可优先考虑<br />薪酬：<br />底薪（根据业绩可调）+ 业绩提成 + 激励奖金 + 六险二金 + 过节费 + 补贴<br />福利：<br />1、六险二金<br />公司依法为员工购买养老保险、医疗保险、失业保险、工伤保险，生育保险、意外险以及住房公积金和企业年金。另外，为激励员工公司设立了科学的评级制度，优秀员工可享受深圳市高级缴纳基数。<br />2、活动及奖励<br />部门旅游：公司有季度旅游及其他旅游激励。在平安，有你多得你不想去的带薪旅游。<br />部门活动：部门每月会不定期组织聚餐，爬山，唱K等活动。<br />现金及物资奖励：公司提供丰厚的现金奖励和物资奖励，随时等你来挑战。<br />3、完善的培训体系<br />培训系统一直以来是平安的骄傲，为金融行业输送了大量的人才。<br />公司为员工提供完善且深入的系统培训。 无论是从产品知识到市场分析，还是从商务礼仪到业务技巧、分享，我们能帮助你迅速专业地建立行业观，提升个人业务水平。<br />4、个人职业规划及发展<br />信贷经理&mdash;信贷主任&mdash;区域总监-分部总监<br />我们提供科学快速的晋升管理体系。只要你努力，就能获得广阔的晋升机会，迅速提拔进入管理层带领属于自己的团队。</p>');
INSERT INTO `t_job_describe` VALUES (7, '<p>网申渠道：career.fhss.com.cn<br />岗位职责：<br />1、Java web或Java后台开发工作。<br />任职要求：<br />1、 计算机通信类、理学类本科及以上学历；<br />2、 掌握Java语言，熟悉java相关开发框架，掌握一种数据库使用；<br />3、 对数据结构、算法、大数据、微服务有了解的优先。</p>');
INSERT INTO `t_job_describe` VALUES (8, '<p>网申渠道：career.fhss.com.cn<br />岗位职责：<br />1、Java web或Java后台开发工作。<br />任职要求：<br />1、 计算机通信类、理学类本科及以上学历；<br />2、 掌握Java语言，熟悉java相关开发框架，掌握一种数据库使用；<br />3、 对数据结构、算法、大数据、微服务有了解的优先。</p>');
INSERT INTO `t_job_describe` VALUES (9, '<p>网申渠道：career.fhss.com.cn<br />岗位职责：<br />1、Java web或Java后台开发工作。<br />任职要求：<br />1、 计算机通信类、理学类本科及以上学历；<br />2、 掌握Java语言，熟悉java相关开发框架，掌握一种数据库使用；<br />3、 对数据结构、算法、大数据、微服务有了解的优先。</p>');
INSERT INTO `t_job_describe` VALUES (10, '<p>网申渠道：career.fhss.com.cn<br />岗位职责：<br />1、Java web或Java后台开发工作。<br />任职要求：<br />1、 计算机通信类、理学类本科及以上学历；<br />2、 掌握Java语言，熟悉java相关开发框架，掌握一种数据库使用；<br />3、 对数据结构、算法、大数据、微服务有了解的优先。</p>');
INSERT INTO `t_job_describe` VALUES (11, '<p>网申渠道：career.fhss.com.cn<br />岗位职责：<br />1、Java web或Java后台开发工作。<br />任职要求：<br />1、 计算机通信类、理学类本科及以上学历；<br />2、 掌握Java语言，熟悉java相关开发框架，掌握一种数据库使用；<br />3、 对数据结构、算法、大数据、微服务有了解的优先。</p>');
INSERT INTO `t_job_describe` VALUES (12, '<p>【You need】&mdash;&mdash;工作内容<br />1、参与产品的开发和维护，完成从需求到设计、开发和上线等整个项目周期内的工作；<br />【We need】&mdash;&mdash;岗位需求<br />1、计算机、软件、通信等相关专业本科及以上学历；<br />2、热爱编程，基础扎实，熟悉掌握但不限于JAVA等编程语言中的一种或数种，有良好的编程习惯；<br />3、了解web前端开发的基础知识，会面向对象程序设计（OOP）与基本的设计模式，了解linux及基本操作命令；<br />4、掌握常用的数据结构、对算法有一定了解；<br />5、使用过Spring系列框架，并对Spring原理有一定的理解；<br />7、使用过关系型数据和非关系型数据库；<br />8、认真细致，踏实勤奋、具备独立工作和解决问题的能力、善于沟通，乐于合作，热衷新技术，善于总结分享，喜欢动手实践。<br />9、加分项<br />（1）有过相关商业化软件开发经验，在校期间积极参加过软件编程大赛或在开源框架中有过贡献；<br />（2）熟悉HTML5/JS/CSS等前端开发技术。</p>');
INSERT INTO `t_job_describe` VALUES (13, '<p>1）1药城的后台开发：采用分布式互联网技术进行服务端业务逻辑开发，给前端提供数据服务接口;<br />2）商家系统开放平台的研发，对接商家ERP系统。<br />3）2-3年java开发经验，熟悉常用的mvc框架，熟悉mysql数据库，有过分布式系统编程的尤佳，有dubbo或spring cloud的使用经验；<br />4）有一定的算法基础，对于常见的算法有自己的理解。<br />5）有责任心和正能量。<br />6）统招本科以上学历。</p>');
INSERT INTO `t_job_describe` VALUES (14, '<p>招聘要求<br />1、有大型项目开发经验（电商，医疗，教育等平台），有架构服务开发经验优先考虑；<br />2、具备扎实的Java编程基础，对各种开源的框架如Spring、ibatis、mybatis、dubbo，消息中间件，redis，Memcache等有深入的了解，对框架本身有过开发或重构者可优先考虑；<br />3、具备良好的识别和设计通用框架及模块的能力，具备系统调优、性能调优等技能，对疑难技术问题具备较强的排查能力；<br />4、对技术有激情，喜欢钻研，能快速接受和掌握新技术，有较强的独立、主动的学习能力，良好的沟通表达能力和团队协作能力；<br />5有一定的产品设计能力。<br />岗位职责：<br />1、负责集团架构层面的服务设计，研发以及技术支持；<br />2、负责分配的基础服务维护工作</p>');
INSERT INTO `t_job_describe` VALUES (15, '<p>岗位职责:：<br />1. 根据业务需求实现1药城电商平台的后台逻辑，对前端提供接口服务；<br />2. 开发电商交易/运营/销售支持的后台；<br />3. 参与项目需求分析，根据需求文档和设计文档完成代码编写、调试、测试和维护工作<br />任职要求：<br />1. 本科以上学历，5年及以上java开发经验;<br />2 有扎实的java基础，熟悉分布式系统开发，如dubbo，Spring Cloud，SpringBoot等；<br />2. 熟练常见的java开发框架，Spring MVC， Spring, Mybatis;<br />3. 熟练使用Mysql，Redis，并具备调优经验<br />4. 熟悉最基本的算法，能熟练应用；<br />5. 具有良好的沟通、协调能力，有较强的责任心和主人翁意识</p>');
INSERT INTO `t_job_describe` VALUES (16, '<p>1、负责软件设计、开发、测试、上线工作，参与项目前期的的需求分析。<br />2、能按时、独立、高质量地完成开发任务，对代码质量要求严格。<br />3、能解决复杂的技术问题，负责新技术的引入和推广。<br />任职资格:<br />1、本科及以上学历，计算机相关专业。<br />2、4年及以上java开发经验。<br />3、精通Java EE相关技术和框架（SSM、dubbo、springboot等）。<br />4、熟悉MYSQL或Oracle等数据库的使用，精通SQL调优，熟悉Redis。<br />5、熟悉Scrum敏捷开发、软件项目开发流程。<br />6、能承担工作压力、团队协作、主动性强。<br />7、有电商、供应链（WMS、TMS）相关项目经验者优先。</p>');
INSERT INTO `t_job_describe` VALUES (17, '<p>中山市德创智谷</p>');
INSERT INTO `t_job_describe` VALUES (18, '<p>cscscs</p>');

-- ----------------------------
-- Table structure for t_job_info
-- ----------------------------
DROP TABLE IF EXISTS `t_job_info`;
CREATE TABLE `t_job_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '职位名称',
  `salary` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '职位薪资',
  `company_id` int(11) NULL DEFAULT NULL COMMENT '公司id',
  `describe_id` int(11) NULL DEFAULT NULL COMMENT '职位描述id',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '工作地址',
  `update_time` timestamp(0) NULL DEFAULT NULL COMMENT '职位信息更新时间',
  `province` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '职位省份',
  `exp` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '职位经历要求',
  `degree` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '职位学历要求',
  `skill_tag` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '职位技能要求',
  `type` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '职业类型',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_name_salary_cpyid`(`name`, `salary`, `company_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_job_info
-- ----------------------------
INSERT INTO `t_job_info` VALUES (1, '技术服务工程师', '14-28K', 1, 1, '西安市 雁塔区 华为西安研究所 127', '2020-09-21 09:58:23', '西安', '5-10年', '本科', 'Java,后端开发,Linux,高性能,jvm原理', '112');
INSERT INTO `t_job_info` VALUES (4, '软件工程师', '11-22K', 11, 5, '杭州滨江区浙江大华技术股份有限公司(滨安路)', '2020-09-28 17:54:11', '浙江省 杭州市 滨江区', '3-5年', '本科', 'C++,linux,调试', '74');
INSERT INTO `t_job_info` VALUES (5, '电话客服', '10-11K', 13, 6, '武汉硚口区花样年·喜年中心3楼', '2020-09-30 14:26:45', '湖北省 武汉市 硚口区', '1年以内', '本科', '信贷经验', '86');
INSERT INTO `t_job_info` VALUES (6, '杭州-Java开发', '9-14K', 15, 7, '杭州市 上城区 近江时代大厦 近江时代大厦', '2020-09-30 15:41:32', '浙江省 杭州市 上城区', '应届生', '本科', '大数据,数据结构,微服务', '22');
INSERT INTO `t_job_info` VALUES (7, '武汉-Java开发', '7-12K', 15, 8, '武汉市 洪山区 南京烽火星空武汉研发中心 花山软件新城', '2020-09-30 15:42:20', '湖北省 武汉市 洪山区', '应届生', '本科', '数据结构,大数据,微服务', '22');
INSERT INTO `t_job_info` VALUES (8, '南京-Java开发', '8-13K', 15, 9, '南京市 建邺区 烽火科技大厦 云龙山路88号', '2020-09-30 15:42:44', '江苏省 南京市 建邺区', '应届生', '本科', '大数据,数据结构,微服务', '22');
INSERT INTO `t_job_info` VALUES (9, '成都-Java开发', '7-12K', 15, 10, '成都市 锦江区 航天科技大厦 707B', '2020-09-30 15:43:02', '四川省 成都市 锦江区', '应届生', '本科', '大数据,算法,微服务', '22');
INSERT INTO `t_job_info` VALUES (10, '广州-Java开发', '7-12K', 15, 11, '广州市 越秀区 高迅大厦 17楼', '2020-09-30 15:43:19', '广东省 广州市 越秀区', '应届生', '本科', '大数据,算法,数据结构', '22');
INSERT INTO `t_job_info` VALUES (11, 'Java开发校招生', '12-18K', 14, 12, '武汉市 洪山区 软件园6期E5栋', '2020-09-30 15:44:01', '湖北省 武汉市 洪山区', '应届生', '本科', 'OOP,Spring', '22');
INSERT INTO `t_job_info` VALUES (12, 'Java开发', '13-22K', 14, 13, '武汉市 洪山区 光谷e城E5栋 5楼', '2020-09-30 15:44:20', '湖北省 武汉市 洪山区', '5-10年', '本科', 'MVC,Mysql', '22');
INSERT INTO `t_job_info` VALUES (13, '高级java开发', '13-20K', 14, 14, '武汉市 洪山区 光谷e城E5栋 5楼东', '2020-09-30 15:44:37', '湖北省 武汉市 洪山区', '3-5年', '本科', 'Spring,Mybatis', '22');
INSERT INTO `t_job_info` VALUES (14, 'Java开发工程师', '20-30K', 14, 15, '武汉市 洪山区 光谷e城E5栋 E城E5栋5楼', '2020-09-30 15:45:08', '湖北省 武汉市 洪山区', '3-5年', '本科', 'dubbo,Spring', '22');
INSERT INTO `t_job_info` VALUES (15, '高级Java软件开发工程师', '15-20K', 14, 16, '武汉洪山区光谷e城E5栋', '2020-09-30 15:45:27', '湖北省 武汉市 洪山区', '5-10年', '本科', 'Java EE,敏捷开发', '22');
INSERT INTO `t_job_info` VALUES (16, '测试更新', '5-10K', 15, 17, '中山市德创智谷', '2020-10-05 00:53:42', '河北省 唐山市 古冶区', '在校生', '本科', '测试,重试次数', '1');
INSERT INTO `t_job_info` VALUES (17, '南京-Java开发', '8-13K', 15, 18, 'cscscs', '2020-10-05 10:04:28', '江苏省 南京市 建邺区', '应届生', '本科', '大数据,数据结构,微服务', '1');

-- ----------------------------
-- Table structure for t_job_template
-- ----------------------------
DROP TABLE IF EXISTS `t_job_template`;
CREATE TABLE `t_job_template`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NULL DEFAULT NULL COMMENT '所属用户id',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '职位名称',
  `salary` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '职位薪资',
  `province` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '职位省份',
  `exp` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '职位经历要求',
  `degree` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '职位学历要求',
  `skill_tag` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '职业技能要求',
  `used` smallint(1) NULL DEFAULT NULL COMMENT '是否启用（0 - 不启用  1 - 启用）',
  `type` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '职业类型',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_uid_name`(`uid`, `name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_job_template
-- ----------------------------
INSERT INTO `t_job_template` VALUES (1, 19, '开发测试', '20-44K', '上海市 市辖区 普陀区', '应届生', '博士', '架构,分析测试,算法', 1, NULL);
INSERT INTO `t_job_template` VALUES (2, 19, '高级/专家Android工程师', '20-40K', '浙江省 杭州市 上城区', '5-10年', '本科', '设计模式,OOM,Linux', 1, NULL);
INSERT INTO `t_job_template` VALUES (3, 19, '软件工程师', '11-22K', '浙江省 杭州市 滨江区', '3-5年', '本科', 'C++,linux,调试', 1, NULL);
INSERT INTO `t_job_template` VALUES (4, 19, '电话客服', '10-11K', '湖北省 武汉市 硚口区', '1年以内', '本科', '信贷经验', 1, NULL);
INSERT INTO `t_job_template` VALUES (5, 19, 'Java开发校招生', '12-18K', '湖北省 武汉市 洪山区', '应届生', '本科', 'OOP,Spring', 1, '22');
INSERT INTO `t_job_template` VALUES (6, 19, 'Java开发', '13-22K', '湖北省 武汉市 洪山区', '5-10年', '本科', 'MVC,Mysql', 1, '22');
INSERT INTO `t_job_template` VALUES (7, 19, '高级java开发', '13-20K', '湖北省 武汉市 洪山区', '3-5年', '本科', 'Spring,Mybatis', 1, '22');
INSERT INTO `t_job_template` VALUES (8, 19, 'Java开发工程师', '20-30K', '湖北省 武汉市 洪山区', '3-5年', '本科', 'dubbo,Spring', 1, '22');
INSERT INTO `t_job_template` VALUES (9, 19, '高级Java软件开发工程师', '15-20K', '湖北省 武汉市 洪山区', '5-10年', '本科', 'Java EE,敏捷开发', 1, '22');
INSERT INTO `t_job_template` VALUES (10, 19, '武汉-Java开发', '7-12K', '湖北省 武汉市 洪山区', '应届生', '本科', '数据结构,大数据,微服务', 1, '22');
INSERT INTO `t_job_template` VALUES (11, 19, '南京-Java开发', '8-13K', '江苏省 南京市 建邺区', '应届生', '本科', '大数据,数据结构,微服务', 1, '22');
INSERT INTO `t_job_template` VALUES (12, 19, '成都-Java开发', '7-12K', '四川省 成都市 锦江区', '应届生', '本科', '大数据,算法,微服务', 1, '22');
INSERT INTO `t_job_template` VALUES (13, 19, '广州-Java开发', '7-12K', '广东省 广州市 越秀区', '应届生', '本科', '大数据,算法,数据结构', 1, '22');
INSERT INTO `t_job_template` VALUES (14, 19, '杭州-Java开发', '9-14K', '浙江省 杭州市 上城区', '应届生', '本科', '大数据,数据结构,微服务', 1, '22');
INSERT INTO `t_job_template` VALUES (15, 19, '测试更新', '5-10K', '河北省 唐山市 古冶区', '在校生', '本科', '测试,重试次数', 1, NULL);
INSERT INTO `t_job_template` VALUES (16, 19, 'cscs', '5-10K', '河北省 秦皇岛市 北戴河区', '应届生', '大专', 'cscscs', 0, NULL);

-- ----------------------------
-- Table structure for t_media
-- ----------------------------
DROP TABLE IF EXISTS `t_media`;
CREATE TABLE `t_media`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `media_type` smallint(2) NULL DEFAULT NULL COMMENT '媒资类型（0 - 首页广告位左上图片，1 - 首页广告位右上图片，2 - 首页广告位左下图片，3 - 首页广告位右下图片，4 - 热招城市图片）',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '媒资url',
  `used` smallint(1) NULL DEFAULT NULL COMMENT '是否启用（0 - 不启用  1 - 启用）',
  `upload_time` datetime(0) NULL DEFAULT NULL COMMENT '上传时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_type_used`(`media_type`, `used`) USING BTREE,
  INDEX `idx_upload_time`(`upload_time`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_media
-- ----------------------------
INSERT INTO `t_media` VALUES (3, 4, 'group1/M00/00/00/wKgApF9qs3qAKITjAAAItY61HBI174.jpg', 1, '2020-09-23 19:36:29');
INSERT INTO `t_media` VALUES (14, 3, 'group1/M00/00/00/wKgApF9rNFeANIEYAACNnvGSkEY150.jpg', 1, '2020-09-23 19:41:11');
INSERT INTO `t_media` VALUES (15, 4, 'group1/M00/00/01/wKgApF95--WAUeYuAAFpx4ENrZE643.jpg', 0, '2020-10-05 00:44:21');
INSERT INTO `t_media` VALUES (16, 3, 'group1/M00/00/01/wKgApF96f3eAFMZmAAAnHEK757Q522.jpg', 0, '2020-10-05 10:05:44');

-- ----------------------------
-- Table structure for t_media_pdf
-- ----------------------------
DROP TABLE IF EXISTS `t_media_pdf`;
CREATE TABLE `t_media_pdf`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'PDF地址',
  `uid` int(11) NULL DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_media_pdf
-- ----------------------------
INSERT INTO `t_media_pdf` VALUES (11, 'group1/M00/00/01/wKgApF9x3TmAewh4AAZDtGx7kcQ920.pdf', 18);
INSERT INTO `t_media_pdf` VALUES (12, 'group1/M00/00/01/wKgApF9x3YqADN3nAAIkADu8KsQ275.doc', 18);
INSERT INTO `t_media_pdf` VALUES (13, 'group1/M00/00/01/wKgApF9x3Y-AFApnAAebY4y5emE32.docx', 18);
INSERT INTO `t_media_pdf` VALUES (14, 'group1/M00/00/01/wKgApF96BFiANjqBAAZDtGx7kcQ441.pdf', 20);

-- ----------------------------
-- Table structure for t_position_category
-- ----------------------------
DROP TABLE IF EXISTS `t_position_category`;
CREATE TABLE `t_position_category`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '职位分类名称',
  `parentid` int(11) NULL DEFAULT NULL COMMENT '上级职位id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_parentid`(`parentid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 130 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_position_category
-- ----------------------------
INSERT INTO `t_position_category` VALUES (1, '技术', 0);
INSERT INTO `t_position_category` VALUES (2, '后端开发', 1);
INSERT INTO `t_position_category` VALUES (3, '移动开发', 1);
INSERT INTO `t_position_category` VALUES (4, '测试', 1);
INSERT INTO `t_position_category` VALUES (5, '数据', 1);
INSERT INTO `t_position_category` VALUES (6, '项目管理', 1);
INSERT INTO `t_position_category` VALUES (7, '硬件开发', 1);
INSERT INTO `t_position_category` VALUES (8, '前端开发', 1);
INSERT INTO `t_position_category` VALUES (9, '通信', 1);
INSERT INTO `t_position_category` VALUES (10, '电子/半导体', 1);
INSERT INTO `t_position_category` VALUES (11, '人工智能', 1);
INSERT INTO `t_position_category` VALUES (12, '全栈工程师', 2);
INSERT INTO `t_position_category` VALUES (13, 'C++', 2);
INSERT INTO `t_position_category` VALUES (14, 'Perl', 2);
INSERT INTO `t_position_category` VALUES (15, 'Node.js', 2);
INSERT INTO `t_position_category` VALUES (16, '数据采集', 2);
INSERT INTO `t_position_category` VALUES (17, 'Python', 2);
INSERT INTO `t_position_category` VALUES (18, 'Golang', 2);
INSERT INTO `t_position_category` VALUES (19, 'Hadoop', 2);
INSERT INTO `t_position_category` VALUES (20, 'Delphi', 2);
INSERT INTO `t_position_category` VALUES (21, 'PHP', 2);
INSERT INTO `t_position_category` VALUES (22, 'Java', 2);
INSERT INTO `t_position_category` VALUES (23, 'C#', 2);
INSERT INTO `t_position_category` VALUES (24, '.NET', 2);
INSERT INTO `t_position_category` VALUES (25, 'Erlang', 2);
INSERT INTO `t_position_category` VALUES (26, 'GIS工程师', 2);
INSERT INTO `t_position_category` VALUES (27, '语音/视频/图形开发', 2);
INSERT INTO `t_position_category` VALUES (28, 'C', 2);
INSERT INTO `t_position_category` VALUES (29, 'Ruby', 2);
INSERT INTO `t_position_category` VALUES (30, 'UE4', 3);
INSERT INTO `t_position_category` VALUES (31, 'U3D', 3);
INSERT INTO `t_position_category` VALUES (32, '移动web前端', 3);
INSERT INTO `t_position_category` VALUES (33, 'JavaScript', 3);
INSERT INTO `t_position_category` VALUES (34, 'Flash开发', 3);
INSERT INTO `t_position_category` VALUES (35, 'Android', 3);
INSERT INTO `t_position_category` VALUES (36, 'COCOS2DX', 3);
INSERT INTO `t_position_category` VALUES (37, 'iOS', 3);
INSERT INTO `t_position_category` VALUES (38, '移动开发', 3);
INSERT INTO `t_position_category` VALUES (39, 'HTML5', 3);
INSERT INTO `t_position_category` VALUES (40, '测试工程师', 4);
INSERT INTO `t_position_category` VALUES (41, '移动端测试', 4);
INSERT INTO `t_position_category` VALUES (42, '功能测试', 4);
INSERT INTO `t_position_category` VALUES (43, 'DBA', 55);
INSERT INTO `t_position_category` VALUES (44, '系统工程师', 55);
INSERT INTO `t_position_category` VALUES (45, '系统管理员', 55);
INSERT INTO `t_position_category` VALUES (46, '数据开发', 5);
INSERT INTO `t_position_category` VALUES (47, '数据架构师', 5);
INSERT INTO `t_position_category` VALUES (48, '项目专员', 6);
INSERT INTO `t_position_category` VALUES (49, '项目经理', 6);
INSERT INTO `t_position_category` VALUES (50, '实施工程师', 6);
INSERT INTO `t_position_category` VALUES (51, 'ARM开发', 7);
INSERT INTO `t_position_category` VALUES (52, 'HTML5', 8);
INSERT INTO `t_position_category` VALUES (53, '电信交换工程师', 9);
INSERT INTO `t_position_category` VALUES (54, '\r\nFAE', 10);
INSERT INTO `t_position_category` VALUES (55, '运维/技术支持', 1);
INSERT INTO `t_position_category` VALUES (56, '算法工程师', 11);
INSERT INTO `t_position_category` VALUES (57, '产品', 0);
INSERT INTO `t_position_category` VALUES (58, '产品经理', 57);
INSERT INTO `t_position_category` VALUES (59, '高端产品职位', 57);
INSERT INTO `t_position_category` VALUES (60, '其他产品职位', 57);
INSERT INTO `t_position_category` VALUES (61, '移动产品经理', 58);
INSERT INTO `t_position_category` VALUES (62, '网页产品经理', 58);
INSERT INTO `t_position_category` VALUES (63, '数据产品经理', 58);
INSERT INTO `t_position_category` VALUES (64, '产品VP', 59);
INSERT INTO `t_position_category` VALUES (65, '产品总监', 59);
INSERT INTO `t_position_category` VALUES (66, '\r\n其他产品职位', 60);
INSERT INTO `t_position_category` VALUES (67, '设计', 0);
INSERT INTO `t_position_category` VALUES (68, '视觉/交互设计', 67);
INSERT INTO `t_position_category` VALUES (69, '游戏设计', 67);
INSERT INTO `t_position_category` VALUES (70, '用户研究', 67);
INSERT INTO `t_position_category` VALUES (71, '高端设计职位', 67);
INSERT INTO `t_position_category` VALUES (72, '非视觉设计', 67);
INSERT INTO `t_position_category` VALUES (73, '其他设计职位', 67);
INSERT INTO `t_position_category` VALUES (74, '网页设计师', 68);
INSERT INTO `t_position_category` VALUES (75, '游戏界面设计师', 69);
INSERT INTO `t_position_category` VALUES (76, '用户研究总监', 70);
INSERT INTO `t_position_category` VALUES (77, '视觉设计总监', 71);
INSERT INTO `t_position_category` VALUES (78, '照明设计', 72);
INSERT INTO `t_position_category` VALUES (79, '其他设计职位', 73);
INSERT INTO `t_position_category` VALUES (80, '运营', 0);
INSERT INTO `t_position_category` VALUES (81, '运营', 80);
INSERT INTO `t_position_category` VALUES (82, '编辑', 80);
INSERT INTO `t_position_category` VALUES (83, '客服', 80);
INSERT INTO `t_position_category` VALUES (84, '高端运营职位', 80);
INSERT INTO `t_position_category` VALUES (85, '其他运营职位', 80);
INSERT INTO `t_position_category` VALUES (86, '直播运营', 81);
INSERT INTO `t_position_category` VALUES (87, '内容编辑', 82);
INSERT INTO `t_position_category` VALUES (88, '客服专员', 83);
INSERT INTO `t_position_category` VALUES (89, '客服总监', 84);
INSERT INTO `t_position_category` VALUES (90, '其他运营职位', 85);
INSERT INTO `t_position_category` VALUES (91, '市场', 0);
INSERT INTO `t_position_category` VALUES (92, '政府事务', 91);
INSERT INTO `t_position_category` VALUES (93, '市场/营销', 91);
INSERT INTO `t_position_category` VALUES (94, '公关/媒介', 91);
INSERT INTO `t_position_category` VALUES (95, '会务/会展', 91);
INSERT INTO `t_position_category` VALUES (96, '广告', 91);
INSERT INTO `t_position_category` VALUES (97, '高端市场职位', 91);
INSERT INTO `t_position_category` VALUES (98, '其他市场职位', 91);
INSERT INTO `t_position_category` VALUES (99, '政策研究', 92);
INSERT INTO `t_position_category` VALUES (100, '商业数据分析', 93);
INSERT INTO `t_position_category` VALUES (101, '活动策划执行', 94);
INSERT INTO `t_position_category` VALUES (102, '会展活动销售', 95);
INSERT INTO `t_position_category` VALUES (103, '广告制作', 96);
INSERT INTO `t_position_category` VALUES (104, '创意总监', 97);
INSERT INTO `t_position_category` VALUES (105, '其他市场职位', 98);
INSERT INTO `t_position_category` VALUES (106, '人事/财务/行政', 0);
INSERT INTO `t_position_category` VALUES (107, '人力资源', 106);
INSERT INTO `t_position_category` VALUES (108, '行政', 106);
INSERT INTO `t_position_category` VALUES (109, '财务', 106);
INSERT INTO `t_position_category` VALUES (110, '法务', 106);
INSERT INTO `t_position_category` VALUES (111, '其他职能职位', 106);
INSERT INTO `t_position_category` VALUES (112, '薪资福利', 107);
INSERT INTO `t_position_category` VALUES (113, '行政主管', 108);
INSERT INTO `t_position_category` VALUES (114, '税务', 109);
INSERT INTO `t_position_category` VALUES (115, '律师', 110);
INSERT INTO `t_position_category` VALUES (116, '其他职能职务', 111);
INSERT INTO `t_position_category` VALUES (117, '高级管理', 0);
INSERT INTO `t_position_category` VALUES (118, '高级管理职位', 117);
INSERT INTO `t_position_category` VALUES (119, '副总裁/副总经理/VP', 118);
INSERT INTO `t_position_category` VALUES (120, '分公司/代表处负责人', 118);
INSERT INTO `t_position_category` VALUES (121, '销售', 0);
INSERT INTO `t_position_category` VALUES (122, '销售行政/商务', 121);
INSERT INTO `t_position_category` VALUES (123, '传媒', 0);
INSERT INTO `t_position_category` VALUES (124, '采编/写作/出版', 123);
INSERT INTO `t_position_category` VALUES (125, '金融', 0);
INSERT INTO `t_position_category` VALUES (126, '投融资', 125);
INSERT INTO `t_position_category` VALUES (127, '投资VP', 126);
INSERT INTO `t_position_category` VALUES (128, '编辑', 124);
INSERT INTO `t_position_category` VALUES (129, '销售运营', 122);

-- ----------------------------
-- Table structure for t_resume
-- ----------------------------
DROP TABLE IF EXISTS `t_resume`;
CREATE TABLE `t_resume`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '名字',
  `phone` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '联系方式',
  `sex` smallint(1) NULL DEFAULT NULL COMMENT '性别（0-女  1-男）',
  `birth` date NULL DEFAULT NULL COMMENT '生日',
  `position` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '期望工作位置',
  `guard` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '上岗方式',
  `direction` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '求职意向',
  `salary` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '期望薪资',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '照片',
  `work_exp` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '工作经历',
  `study_exp` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '教育经历',
  `evaluation` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '自我评价',
  `uid` int(11) NULL DEFAULT NULL COMMENT '所属用户id',
  `attach_time` date NULL DEFAULT NULL COMMENT '开始工作时间',
  `wxId` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '微信号',
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_resume
-- ----------------------------
INSERT INTO `t_resume` VALUES (10, '1234567', '1', 1, '1993-09-01', '河北省 保定市', '1', '1', '2k-9k', 'group1/M00/00/01/wKgApF9zTL6AfM62AAFpx4ENrZE932.jpg', '{\"comName\":\"cs1\",\"jobType\":\"cs1\",\"workContent\":\"cs1\",\"workResult\":\"cs\",\"workTime\":\"2020-09-01/2020-09-28\"}', '{\"degree\":\"本科\",\"major\":\"cs22\",\"schoolName\":\"cs22\",\"studyContent\":\"cs22\",\"studyTime\":\"2017-2021\"}', '少时', 18, '2020-09-24', '1', '1');
INSERT INTO `t_resume` VALUES (11, '1', '1', 0, '1999-11-04', '山西省 长治市', '1', '1', '2k-10k', NULL, NULL, NULL, NULL, 17, '2020-10-19', '1', '1');
INSERT INTO `t_resume` VALUES (13, 'cscs', '17680512647', 1, '1990-05-14', '山西省 晋城市', 'cs', '测试', '2k-10k', NULL, '{\"comName\":\"cscs\",\"jobType\":\"cs\",\"workContent\":\"cs\",\"workResult\":\"cs\",\"workTime\":\"2020-10-04/2020-10-19\"}', '{\"degree\":\"本科\",\"major\":\"cs\",\"schoolName\":\"cscs\",\"studyContent\":\"cs\",\"studyTime\":\"2011-2028\"}', 'cscs', 20, '2020-09-08', 'cs', 'cs');

-- ----------------------------
-- Table structure for t_resume_post
-- ----------------------------
DROP TABLE IF EXISTS `t_resume_post`;
CREATE TABLE `t_resume_post`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NULL DEFAULT NULL COMMENT '求职者id',
  `jobId` int(11) NULL DEFAULT NULL COMMENT '职位id',
  `companyId` int(11) NULL DEFAULT NULL COMMENT '公司id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_resume_post
-- ----------------------------
INSERT INTO `t_resume_post` VALUES (1, 17, 10, 15);
INSERT INTO `t_resume_post` VALUES (2, 18, 7, 15);
INSERT INTO `t_resume_post` VALUES (4, 17, 14, 14);
INSERT INTO `t_resume_post` VALUES (5, 20, 8, 15);
INSERT INTO `t_resume_post` VALUES (6, 20, 8, 15);

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户名（默认手机号）',
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '手机号',
  `pwd` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `rank` smallint(1) NOT NULL COMMENT '用户类型（0为求职者 1为公司）',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '邮箱地址',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_phone_rank`(`phone`, `rank`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (17, '18872427726', '18872427726', 'ZUIEWANGGUAN', 0, '452419829@qq.com');
INSERT INTO `t_user` VALUES (18, '17680512646', '17680512646', '12345678', 0, '452419829@qq.com');
INSERT INTO `t_user` VALUES (19, '17680512645', '17680512645', '12345678', 1, NULL);
INSERT INTO `t_user` VALUES (20, '17680512644', '17680512644', '12345678', 0, '452419829@qq.com');

SET FOREIGN_KEY_CHECKS = 1;
