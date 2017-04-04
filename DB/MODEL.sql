CREATE TABLE `demo_web`.`model` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT 'c词库id',
  `clazz` VARCHAR(45) CHARACTER SET 'utf8' NOT NULL COMMENT '类型',
  `keyword` LONGTEXT CHARACTER SET 'utf8' NOT NULL COMMENT '关键词',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin
COMMENT = '贝叶斯模型词库';
