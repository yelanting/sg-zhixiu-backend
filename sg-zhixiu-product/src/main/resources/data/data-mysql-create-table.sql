DROP DATABASE IF EXISTS `sg_zhixiu_product`;
CREATE DATABASE `sg_zhixiu_product` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

use `sg_zhixiu_product`;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_config
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `ename` varchar(100) NOT NULL COMMENT '英文名',
  `cname` varchar(100) NOT NULL COMMENT '中文名',
  `quantity` bigint(16) NOT NULL COMMENT '数量',
  `description` varchar(100) COMMENT '描述',
  `sort` decimal(10,0) COMMENT '排序（升序）',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` tinyint(4) DEFAULT '0' COMMENT '是否删除  -1：已删除  0：正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='商品表';
