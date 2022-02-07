package test.zakharanka.task03inheritance.service.impl;

import by.zakharanka.task03inheritance.entity.Client;
import by.zakharanka.task03inheritance.entity.ParametersList;
import by.zakharanka.task03inheritance.entity.tariff.LimitTariff;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

class TariffServiceImplTest {

    private static Stream<Arguments> totalNumberClientsData(){
        return Stream.of(
                Arguments.of("tariff_service_impl_test_data/listTariff.json", "14"),
                Arguments.of("tariff_service_impl_test_data/notClientList.json", "0")
        );
    }

    @ParameterizedTest
    @MethodSource("totalNumberClientsData")
    void totalNumberClientsTest(String arg, String expected) throws ServiceException {
        Creator<ListTariff<Tariff>> creator = new TariffListCreator();
        ListTariff<Tariff> list = creator.createFromFile(arg);
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        TariffService tariffService = serviceFactory.getTariffService();
        Assertions.assertEquals(Objects.requireNonNullElseGet(tariffService.totalNumberClients(list), String::new), expected);
    }

    private static Stream<Arguments> findTariffData(){
        List<Client> listClient = new ArrayList<>();
        listClient.add(new Client("Nikita", 6525166, "tariffLimit1"));
        ListTariff<Tariff> list = new ListTariff<>();
        list.addTariff(new LimitTariff("tariffLimit1", listClient, 550, 500, 500, 300, 2, 2, 3));
        return Stream.of(
                Arguments.of("tariff_service_impl_test_data/listTariff.json", "tariff_service_impl_test_data/parameters.json",  list.toString()),
                Arguments.of("tariff_service_impl_test_data/listTariff.json", "tariff_service_impl_test_data/notCorrectParameters.json",  "class java.util.ArrayList:\n\n"));
    }

    @ParameterizedTest
    @MethodSource("findTariffData")
    void findTariffTest(String arg, String path, String expected) throws ServiceException {
        Creator<ListTariff<Tariff>> creator = new TariffListCreator();
        Creator<ParametersList> parametersListCreator = new ParametersListCreator();
        ListTariff<Tariff> list = creator.createFromFile(arg);
        ParametersList parametersList = parametersListCreator.createFromFile(path);
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        TariffService tariffService = serviceFactory.getTariffService();
        Assertions.assertEquals(Objects.requireNonNullElseGet(tariffService.findTariff(list, parametersList), String::new), expected);
    }
}
