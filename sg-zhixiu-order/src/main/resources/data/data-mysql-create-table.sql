DROP DATABASE IF EXISTS `sg_zhixiu_order`;
CREATE DATABASE `sg_zhixiu_order` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

use `sg_zhixiu_order`;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_config
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `number` bigint(32) NOT NULL COMMENT '订单数量',
  `product_id` bigint(32) NOT NULL COMMENT '商品id',
  `user_id` bigint(32) COMMENT '用户id',
  `description` varchar(100)  COMMENT '描述',
  `sort` decimal(10,0) COMMENT '排序（升序）',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` tinyint(4) DEFAULT '0' COMMENT '是否删除  -1：已删除  0：正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='订单';
