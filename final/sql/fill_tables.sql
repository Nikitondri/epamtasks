INSERT INTO `user_account` (
    `id`,
    `login`,
    `password`,
    `role`,
    `status`
) VALUES (
        2,
        'user1',
        '0a74cd16f336b3164dd8ee505561c257898b113089e3725dc171dba65f35000cda6447183448f2f09058b01c3dbceee3090ab75b587b517c9580aa517f7538af', /* SHA3-512 */
        'CLIENT',
        1
    ), (
        3,
        'worker1',
        'cef4509489fc442d21e67e39f978d4fe5c79833262925f04e6e5ff6e103a0b8bde87a4d0a098ded9544e62a258f5933cf13d908e351c4ca85815c43a8d309952', /* SHA3-512 */
        'WORKER',
        1
    );


INSERT INTO `dish_type`
(`id`, `name`)
VALUES
(1, 'SALAD'),
(2, 'SOUP'),
(3, 'HOT'),
(4, 'DRINK'),
(5, 'DESSERT');

INSERT INTO `dish`
(`id`, `name`, `cost`, `is_enable`, `type_id`, `dish_weight`, `description`, `picture_path`)
VALUES
(1, 'pasta', 15.50, 1, 3, 310, 'pasta', ''),
(2, 'orange juice', 3.00, 1, 4, 300, 'orange juice', '');

