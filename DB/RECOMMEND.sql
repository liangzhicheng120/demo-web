CREATE TABLE `demo_web`.`recommend` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `clzss` VARCHAR(45) CHARACTER SET 'utf8' NOT NULL COMMENT '类别',
  `label` VARCHAR(45) CHARACTER SET 'utf8' NOT NULL COMMENT '标签',
  `nid` INT NOT NULL COMMENT '笔记id',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin
COMMENT = '推荐系统表';

ALTER TABLE `demo_web`.`recommend` 
ADD COLUMN `read` INT NULL COMMENT '阅读次数' AFTER `nid`,
ADD COLUMN `time` VARCHAR(45) CHARACTER SET 'utf8' NULL COMMENT '浏览时间' AFTER `read`;

ALTER TABLE `demo_web`.`recommend` 
CHANGE COLUMN `read` `read` INT(11) NOT NULL COMMENT '阅读次数' ,
CHANGE COLUMN `time` `time` VARCHAR(45) CHARACTER SET 'utf8' NOT NULL COMMENT '浏览时间' ;

ALTER TABLE `demo_web`.`recommend` 
CHANGE COLUMN `read` `read` INT(11) NOT NULL DEFAULT 0 COMMENT '阅读次数' ,
CHANGE COLUMN `time` `time` VARCHAR(45) CHARACTER SET 'utf8' NOT NULL DEFAULT 0 COMMENT '浏览时间' ;

ALTER TABLE `demo_web`.`recommend` 
CHANGE COLUMN `time` `time` BIGINT NOT NULL DEFAULT '0' COMMENT '浏览时间' ;

ALTER TABLE `demo_web`.`recommend` 
CHANGE COLUMN `read` `views` INT(11) NOT NULL DEFAULT '0' COMMENT '阅读次数' ,
CHANGE COLUMN `time` `cost` FLOAT NOT NULL DEFAULT '0' COMMENT '浏览时间' ;
ALTER TABLE `demo_web`.`recommend` 
CHANGE COLUMN `cost` `cost` DOUBLE NOT NULL DEFAULT '0' COMMENT '浏览时间' ;

