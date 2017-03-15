CREATE TABLE `demo_web`.`note` (
  `id` INT NOT NULL,
  `content` MEDIUMTEXT CHARACTER SET 'utf8' NOT NULL COMMENT '文本内容',
  `keyword` VARCHAR(100) CHARACTER SET 'utf8' NULL COMMENT '关键词',
  `posttime` DATETIME NOT NULL,
  `aid` INT NOT NULL COMMENT '账号id',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '笔记内容';
