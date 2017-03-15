CREATE TABLE `demo_web`.`user_info` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` VARCHAR(45) CHARACTER SET 'utf8' NOT NULL COMMENT '用户名',
  `password` VARCHAR(100) CHARACTER SET 'utf8' NOT NULL COMMENT '密码',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '注册用户信息';

INSERT INTO `demo_web`.`user_info` (`id`, `name`, `password`) VALUES ('1', 'admin', '123456');
INSERT INTO `demo_web`.`user_info` (`id`, `name`, `password`) VALUES ('2', 'lzc', '123456');
