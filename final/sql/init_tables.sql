INSERT INTO `user_account` (
    `id`,
    `login`,
    `password`,
    `role`,
    `status`
) VALUES (
             1,
             'admin',
             '5a38afb1a18d408e6cd367f9db91e2ab9bce834cdad3da24183cc174956c20ce35dd39c2bd36aae907111ae3d6ada353f7697a5f1a8fc567aae9e4ca41a9d19d', /* SHA3-512 */
             'ADMIN',
             1
         );