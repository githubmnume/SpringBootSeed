
#SQL File start
	#change to mycv
	use mycv;

    #drop table if exists
    drop  table IF EXISTS mycv.interview;
	#create table start
	CREATE TABLE `mycv`.`interview` (
	  `idinterview` INT NOT NULL auto_increment,
	  `in_du` VARCHAR(45)  NULL,
	  `in_line` VARCHAR(45)  NULL,
	  `in_owner` VARCHAR(45) NOT  NULL,
	  `in_position` VARCHAR(45)  NULL,
	  `in_status` VARCHAR(45) NOT NULL,
	  `in_comment` VARCHAR(200) NULL,
	  `in_date` DATETIME  NULL,
	  `cv_id` INT NOT NULL,
	  `in_last_update_id` VARCHAR(45) NOT NULL default 'interview',
      `in_last_update_date` TIMESTAMP NOT NULL  DEFAULT CURRENT_TIMESTAMP,
	  `in_enable` boolean NOT NULL default true,
	  PRIMARY KEY (`idinterview`))
	  COMMENT = 'interview details';

    #commit
	commit;
	#create table end
#SQL File end

