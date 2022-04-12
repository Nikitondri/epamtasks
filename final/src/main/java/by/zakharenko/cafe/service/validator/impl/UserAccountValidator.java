package by.zakharenko.cafe.service.validator.impl;

import by.zakharenko.cafe.entity.UserAccount;
import by.zakharenko.cafe.entity.enumeration.UserRole;
import by.zakharenko.cafe.service.validator.Validator;

public class UserAccountValidator implements Validator<UserAccount> {
    @Override
    public boolean isValid(UserAccount account) {
        String password = account.getPassword();
        String login = account.getLogin();
        UserRole role = account.getRole();
        return password != null && login != null && role != null && !password.isEmpty() && !login.isEmpty();
    }
}
