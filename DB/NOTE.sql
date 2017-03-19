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

ALTER TABLE `demo_web`.`note` 
CHANGE COLUMN `id` `id` INT(11) NOT NULL AUTO_INCREMENT ;


SELECT * FROM demo_web.note;
INSERT INTO `demo_web`.`note` ( `content`, `keyword`, `posttime`, `aid` ,`title`) VALUES ( '��Щ����£���̬���󷵻ص�����һ�㲻����ƴ�õ� HTML ���� JSON �� XML����֮�����������ƴ���ݾ��ڷ�������ƴ���ݡ��������Ӵ������������������� HTML �����㣬���� web ���䷽�棬���ڸ������ʹ�� JSON ������ XML��', '���', '2017-03-15 20:14:17', '2','json');

ALTER TABLE `demo_web`.`note` 
ADD COLUMN `title` VARCHAR(100) CHARACTER SET 'utf8' NOT NULL COMMENT '����' AFTER `aid`;

