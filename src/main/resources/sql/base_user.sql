CREATE TABLE `base_user` (
                             `id` varchar(36) NOT NULL,
                             `company_id` varchar(36) NOT NULL,
                             `name` varchar(10) NOT NULL,
                             `user_name` varchar(100) NOT NULL,
                             `password` varchar(100) NOT NULL,
                             `created_date_copy1` datetime DEFAULT CURRENT_TIMESTAMP,
                             `created_by` varchar(36) DEFAULT NULL,
                             `lastupdated_date` datetime DEFAULT CURRENT_TIMESTAMP,
                             `lastupdated_by` varchar(36) DEFAULT NULL,
                             `status` int(11) DEFAULT NULL,
                             `deleted` tinyint(1) DEFAULT '0',
                             PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
