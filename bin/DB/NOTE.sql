CREATE TABLE `demo_web`.`note` (
  `id` INT NOT NULL,
  `content` MEDIUMTEXT CHARACTER SET 'utf8' NOT NULL COMMENT '�ı�����',
  `keyword` VARCHAR(100) CHARACTER SET 'utf8' NULL COMMENT '�ؼ���',
  `posttime` DATETIME NOT NULL,
  `aid` INT NOT NULL COMMENT '�˺�id',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '�ʼ�����';
