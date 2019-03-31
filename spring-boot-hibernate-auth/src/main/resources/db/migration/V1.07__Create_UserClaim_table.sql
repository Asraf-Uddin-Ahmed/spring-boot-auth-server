CREATE TABLE `user_claim` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `user_id` BIGINT(20) NOT NULL,
  `claim_type` VARCHAR(100) NOT NULL,
  `claim_value` VARCHAR(100) NOT NULL,
  INDEX `userClaim_userId_user_id_idx` (`user_id` ASC),
  PRIMARY KEY (`id`),
  CONSTRAINT `userClaim_userId_user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
