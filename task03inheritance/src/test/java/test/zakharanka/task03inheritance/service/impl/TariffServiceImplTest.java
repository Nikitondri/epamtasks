package test.zakharanka.task03inheritance.service.impl;

import by.zakharanka.task03inheritance.entity.ParametersList;
import by.zakharanka.task03inheritance.entity.tariff.ListTariff;
import by.zakharanka.task03inheritance.entity.tariff.Tariff;
import by.zakharanka.task03inheritance.service.TariffService;
import by.zakharanka.task03inheritance.service.creator.Creator;
import by.zakharanka.task03inheritance.service.creator.ParametersListCreator;
import by.zakharanka.task03inheritance.service.creator.TariffListCreator;
import by.zakharanka.task03inheritance.service.exception.ServiceException;
import by.zakharanka.task03inheritance.service.factory.ServiceFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Objects;
import java.util.stream.Stream;

class TariffServiceImplTest {

    private static Stream<Arguments> totalNumberClientsData(){
        return Stream.of(
                Arguments.of("tariff_service_impl_test_data/listTariff.json", "15"),
                Arguments.of("tariff_service_impl_test_data/InCorrectPath.json", "Error creator"),
                Arguments.of("tariff_service_impl_test_data/notClientList.json", "0")
        );
    }

    @ParameterizedTest
    @MethodSource("totalNumberClientsData")
    void totalNumberClientsTest(String arg, String expected){
        try {
            Creator<ListTariff<Tariff>> creator = new TariffListCreator();
            ListTariff<Tariff> list = creator.createFromFile(arg);
            ServiceFactory serviceFactory = ServiceFactory.getInstance();
            TariffService tariffService = serviceFactory.getTariffService();
            Assertions.assertEquals(Objects.requireNonNullElseGet(tariffService.totalNumberClients(list), String::new), expected);
        } catch (ServiceException e){
            Assertions.assertEquals(expected, e.getMessage());
        }
    }
}
