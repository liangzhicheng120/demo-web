CREATE TABLE `demo_web`.`model` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT 'c词库id',
  `clazz` VARCHAR(45) CHARACTER SET 'utf8' NOT NULL COMMENT '类型',
  `keyword` LONGTEXT CHARACTER SET 'utf8' NOT NULL COMMENT '关键词',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin
COMMENT = '贝叶斯模型词库';

ALTER TABLE `demo_web`.`model` 
CHANGE COLUMN `clazz` `label` VARCHAR(45) CHARACTER SET 'utf8' NOT NULL COMMENT '标签' ,
ADD COLUMN `clzss` VARCHAR(45) CHARACTER SET 'utf8' NOT NULL COMMENT '类型' AFTER `keyword`;

ALTER TABLE `demo_web`.`model` 
ADD COLUMN `newword` VARCHAR(45) CHARACTER SET 'utf8' NOT NULL AFTER `clzss`;


ALTER TABLE `demo_web`.`model` 
ADD COLUMN `mid` VARCHAR(45) CHARACTER SET 'utf8' NOT NULL COMMENT 'clzss经hamcmd5加密得到' AFTER `newword`;


