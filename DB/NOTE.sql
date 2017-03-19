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

ALTER TABLE `demo_web`.`note` 
CHANGE COLUMN `id` `id` INT(11) NOT NULL AUTO_INCREMENT ;


SELECT * FROM demo_web.note;
INSERT INTO `demo_web`.`note` ( `content`, `keyword`, `posttime`, `aid` ,`title`) VALUES ( '这些情况下，动态请求返回的数据一般不是已拼好的 HTML 就是 JSON 或 XML，总之不在浏览器端拼数据就在服务器端拼数据。不过，从传输量方面来看，返回 HTML 不划算，而在 web 传输方面，现在更多的是使用 JSON 而不是 XML。', '详解', '2017-03-15 20:14:17', '2','json');

ALTER TABLE `demo_web`.`note` 
ADD COLUMN `title` VARCHAR(100) CHARACTER SET 'utf8' NOT NULL COMMENT '标题' AFTER `aid`;

