package test.zakharanka.task03innerclass.dal.impl;

import by.zakharanka.task03innerclass.dal.JSONDal;
import by.zakharanka.task03innerclass.dal.exception.DalException;
import by.zakharanka.task03innerclass.dal.factory.DalFactory;
import by.zakharanka.task03innerclass.dal.impl.JSONDalImpl;
import by.zakharanka.task03innerclass.dal.util.FileResourcesUtils;
import by.zakharanka.task03innerclass.entity.Date;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;
import java.util.stream.Stream;

class JSONDalImplTest {
    private static Stream<Arguments> readDateFromJSONData(){
        return Stream.of(
                Arguments.of("json_dal_impl_test_data/date0301.json", new Date(3, 0)),
                Arguments.of("json_dal_impl_test_data/date0803.json", new Date(8, 3))
        );
    }

    @ParameterizedTest
    @MethodSource("readDateFromJSONData")
    void readDateFromJSONTest(String arg, Date expected) throws DalException {
        FileResourcesUtils fileResourcesUtils = new FileResourcesUtils();
        DalFactory dalFactory = DalFactory.getInstance();
        JSONDal jsonDal = dalFactory.getJSONFileDal();
        File file = fileResourcesUtils.getFileFromResource(arg);
        Assertions.assertEquals(expected, jsonDal.readDateFromJSON(file.getPath()));
    }

    private static Stream<Arguments> readDateFromJSONExceptionData(){
        return Stream.of(
                Arguments.of("json_dal_impl_test_data/incorrect_data.json")
        );
    }

    @ParameterizedTest
    @MethodSource("readDateFromJSONExceptionData")
    void readDateFromJSONExceptionTest(String arg) throws DalException {
        FileResourcesUtils fileResourcesUtils = new FileResourcesUtils();
        DalFactory dalFactory = DalFactory.getInstance();
        JSONDal jsonDal = dalFactory.getJSONFileDal();
        File file = fileResourcesUtils.getFileFromResource(arg);
        Assertions.assertThrows(DalException.class, () -> jsonDal.readDateFromJSON(file.getPath()));
    }

    private static Stream<Arguments> readYearFromJSONData(){
        return Stream.of(
                Arguments.of("json_dal_impl_test_data/year2022.json", 2022),
                Arguments.of("json_dal_impl_test_data/year0.json", 0)
        );
    }

    @ParameterizedTest
    @MethodSource("readYearFromJSONData")
    void readYearFromJSONTest(String arg, int expected) throws DalException {
        FileResourcesUtils fileResourcesUtils = new FileResourcesUtils();
        DalFactory dalFactory = DalFactory.getInstance();
        JSONDal jsonDal = dalFactory.getJSONFileDal();
        File file = fileResourcesUtils.getFileFromResource(arg);
        Assertions.assertEquals(expected, jsonDal.readYearFromJSON(file.getPath()));
    }

    private static Stream<Arguments> readYearFromJSONExceptionData(){
        return Stream.of(
                Arguments.of("json_dal_impl_test_data/incorrect_data.json", JSONDalImpl.ERROR)
        );
    }

    @ParameterizedTest
    @MethodSource("readYearFromJSONExceptionData")
    void readYearFromJSONExceptionTest(String arg, String expected) throws DalException {
        FileResourcesUtils fileResourcesUtils = new FileResourcesUtils();
        DalFactory dalFactory = DalFactory.getInstance();
        JSONDal jsonDal = dalFactory.getJSONFileDal();
        File file = fileResourcesUtils.getFileFromResource(arg);
        Assertions.assertThrows(DalException.class, () -> jsonDal.readYearFromJSON(file.getPath()));
    }

    private static Stream<Arguments> writeYearToJSONData(){
        return Stream.of(
                Arguments.of("json_dal_impl_test_data/write_year.json", 2022, 2022),
                Arguments.of("json_dal_impl_test_data/write_year.json", 0, 0),
                Arguments.of("json_dal_impl_test_data/write_year.json", -2022, -2022)
        );
    }

    @ParameterizedTest
    @MethodSource("writeYearToJSONData")
    void writeYearToJSONTest(String arg, int writeYear, int expected) throws DalException {
        FileResourcesUtils fileResourcesUtils = new FileResourcesUtils();
        DalFactory dalFactory = DalFactory.getInstance();
        JSONDal jsonDal = dalFactory.getJSONFileDal();
        File file = fileResourcesUtils.getFileFromResource(arg);
        jsonDal.writeYearToJSON(file.getPath(), writeYear);
        Assertions.assertEquals(expected, jsonDal.readYearFromJSON(file.getPath()));
    }

    private static Stream<Arguments> writeDateToJSONData(){
        return Stream.of(
                Arguments.of("json_dal_impl_test_data/write_date.json", new Date(1, 2), new Date(1, 2)),
                Arguments.of("json_dal_impl_test_data/write_date.json", new Date(25, 8), new Date(25, 8)),
                Arguments.of("json_dal_impl_test_data/write_date.json", new Date(33, 12), new Date(0, 0))
        );
    }

    @ParameterizedTest
    @MethodSource("writeDateToJSONData")
    void writeDateToJSONTest(String arg, Date writeDate, Date expected) throws DalException {
        FileResourcesUtils fileResourcesUtils = new FileResourcesUtils();
        DalFactory dalFactory = DalFactory.getInstance();
        JSONDal jsonDal = dalFactory.getJSONFileDal();
        File file = fileResourcesUtils.getFileFromResource(arg);
        jsonDal.writeDateToJSON(file.getPath(), writeDate);
        Assertions.assertEquals(expected, jsonDal.readDateFromJSON(file.getPath()));
    }
}
