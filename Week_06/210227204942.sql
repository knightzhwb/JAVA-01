/*
MySQL Backup
Source Server Version: 5.7.17
Source Database: shopping
Date: 2021/2/27 20:49:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
--  Table structure for `t_address`
-- ----------------------------
DROP TABLE IF EXISTS `t_address`;
CREATE TABLE `t_address` (
  `id` int(11) NOT NULL COMMENT 'id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `address` varchar(255) NOT NULL COMMENT '地址',
  `postal_code` varchar(16) NOT NULL COMMENT '邮政编码',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_person` varchar(40) NOT NULL COMMENT '创建人',
  `update_person` varchar(40) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Table structure for `t_order`
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `order_no` varchar(32) CHARACTER SET utf8mb4 NOT NULL COMMENT '订单编号',
  `user_id` int(11) NOT NULL COMMENT '下单人id',
  `product_id` int(11) NOT NULL COMMENT '商品id',
  `receipt_address_id` int(11) NOT NULL COMMENT '收货地址id',
  `order_amount` decimal(10,2) NOT NULL COMMENT '订单金额',
  `status` varchar(16) NOT NULL COMMENT '订单状态(待支付、已支付、已取消、已退款、已收货)',
  `order_pay_time` bigint(20) NOT NULL DEFAULT '0' COMMENT '支付时间',
  `delete_status` varchar(16) NOT NULL COMMENT '删除状态(未删除、已删除、彻底删除)',
  `order_snapshot` int(11) NOT NULL COMMENT '订单快照',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_person` varchar(40) DEFAULT NULL COMMENT '创建人',
  `update_person` varchar(40) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`order_no`) USING BTREE,
  KEY `user_id` (`user_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Table structure for `t_product`
-- ----------------------------
DROP TABLE IF EXISTS `t_product`;
CREATE TABLE `t_product` (
  `id` int(11) NOT NULL COMMENT '商品id',
  `product_name` varchar(64) CHARACTER SET latin1 NOT NULL COMMENT '商品名称',
  `product_desc` varchar(255) CHARACTER SET latin1 NOT NULL DEFAULT '' COMMENT '商品描述',
  `num` int(11) NOT NULL COMMENT '商品数量',
  `price` decimal(10,2) NOT NULL COMMENT '商品价格',
  `type` int(11) NOT NULL COMMENT '商品类别',
  `is_in_stock` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否在售',
  `shipping` decimal(10,2) NOT NULL COMMENT '运费',
  `is_create_snapshot` tinyint(1) NOT NULL COMMENT '是否生成快照',
  `is_enabled` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否有效',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_person` varchar(40) DEFAULT NULL COMMENT '创建人',
  `update_person` varchar(40) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_name` varchar(24) DEFAULT NULL COMMENT '登录用户名',
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  `name` varchar(40) DEFAULT NULL COMMENT '昵称',
  `phone` varchar(255) DEFAULT NULL COMMENT '手机号',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `create_person` varchar(40) DEFAULT NULL COMMENT '创建人',
  `update_person` varchar(40) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `user_name` (`user_name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Records 
-- ----------------------------
