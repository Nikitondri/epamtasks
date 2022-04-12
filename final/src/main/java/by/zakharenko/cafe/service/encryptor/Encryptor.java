package by.zakharenko.cafe.service.encryptor;

import by.zakharenko.cafe.service.exception.ServiceException;

public interface Encryptor {
    String encrypt(String plaintext) throws ServiceException;
}
