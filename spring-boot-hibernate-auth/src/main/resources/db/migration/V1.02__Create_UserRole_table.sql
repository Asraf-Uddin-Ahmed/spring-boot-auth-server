CREATE TABLE `user_role` (
  `user_id` BIGINT NOT NULL,
  `role_id` BIGINT NOT NULL,
  PRIMARY KEY (`user_id`, `role_id`),
  INDEX `userRole_roleId_role_id_idx` (`role_id` ASC),
  CONSTRAINT `userRole_userId_user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `userRole_roleId_role_id`
    FOREIGN KEY (`role_id`)
    REFERENCES `role` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
