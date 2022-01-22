package test.zakharenko.task04oop.dal.impl;

import by.zakharenko.task04oop.dal.ReaderDAO;
import by.zakharenko.task04oop.dal.exception.DAOException;
import by.zakharenko.task04oop.dal.factory.DAOFactory;
import by.zakharenko.task04oop.dal.util.FileResourcesUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;
import java.util.stream.Stream;

public class ReaderTxtDAOImplTest {

    public static Stream<Arguments> findLengthData(){
        return Stream.of(
                Arguments.of("testfiles/test_file.txt", 3),
                Arguments.of("testfiles/test_file1.txt", 4)
        );
    }

    @ParameterizedTest
    @MethodSource("findLengthData")
    void findLengthTest(String path, int expected) throws DAOException {
        FileResourcesUtils fileResourcesUtils = new FileResourcesUtils();
        ReaderDAO readerTxt = DAOFactory.getInstance().getReaderTxtDAO();
        File file = fileResourcesUtils.getFileFromResource(path);
        Assertions.assertEquals(expected, readerTxt.readFile(file.getPath()).size());
    }

}
