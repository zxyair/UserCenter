CREATE TABLE `user` (
                        `id` INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '用户唯一ID',
                        `nickname` VARCHAR(32) NOT NULL COMMENT '昵称',
                        `gender` TINYINT NOT NULL DEFAULT 0 COMMENT '性别（0未知，1男，2女）',
                        `birthday` DATE DEFAULT NULL COMMENT '生日',
                        `phone` VARCHAR(16) NOT NULL COMMENT '手机号',
                        `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间',
                        `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户信息表';

CREATE TABLE `user_game_record` (
                        `id` INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '记录唯一ID',
                        `user_id` BIGINT UNSIGNED NOT NULL COMMENT '用户ID',
                        `game_id` BIGINT UNSIGNED NOT NULL COMMENT '对局唯一ID',
                        `members` VARCHAR(255) NOT NULL COMMENT '对局成员（JSON字符串）',
                        `result` TINYINT NOT NULL COMMENT '胜负（1=胜，0=负，2=平/其他）',
                        `score_change` INT NOT NULL COMMENT '本局积分变化',
                        `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录时间',
                        PRIMARY KEY (`id`),
                        INDEX `idx_user_id` (`user_id`),
                        INDEX `idx_game_id` (`game_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户游戏记录表';

CREATE TABLE `user_score` (
                      `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '唯一ID',
                      `user_id` BIGINT UNSIGNED NOT NULL UNIQUE COMMENT '用户ID',
                      `score` INT NOT NULL DEFAULT 0 COMMENT '当前积分',
                      `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                      PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户积分表';