package by.zakharanka.task03inheritance.service.generator;

import by.zakharanka.task03inheritance.dal.JSONDal;
import by.zakharanka.task03inheritance.dal.exception.DalException;
import by.zakharanka.task03inheritance.dal.factory.DalFactory;
import by.zakharanka.task03inheritance.entity.Client;
import by.zakharanka.task03inheritance.entity.tariff.*;
import by.zakharanka.task03inheritance.service.exception.ServiceException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TariffListGenerator implements Generator{
    private static final String PATH = "src/main/resources/data/RandomParametersTariff.json";


    @Override
    public void generateRandomDataToFile() throws ServiceException {
        try{
            DalFactory dalFactory = DalFactory.getInstance();
            JSONDal jsonDal = dalFactory.getJSONFileDal();
            GenerateAllTariffs generateAllTariffs = new GenerateAllTariffs();
            jsonDal.writeTariffsToJSON(PATH, generateAllTariffs.generateData());
        } catch (DalException e){
            throw new ServiceException("Error generator");
        }
    }

    public static class GenerateAllTariffs {

        private static final int MAX_TARIFFS = 10;
        private static final int MAX_CLIENTS = 20;
        private final Random random = new Random();

        public AllTariffs generateData() {
            return new AllTariffs(
                    generateLimitTariffList(),
                    generateFullUnlimitedTariffList(),
                    generateChildTariffList(),
                    generatePensionTariffList(),
                    generateUnlimitedInternetTariffList(),
                    generateUnlimitedMinTariffList()
            );
        }

        private Client generateClient() {
            return new Client(
                    Names.getName(random.nextInt(Names.size())).name(),
                    (long) (random.nextInt(8999999)) + 1000000,
                    Tariffs.getTariff(random.nextInt(Tariffs.size())).name());
        }

        private List<Client> generateListClients() {
            List<Client> list = new ArrayList<>();
            for (int i = 0; i < (random.nextInt(MAX_CLIENTS)); i++) {
                list.add(generateClient());
            }
            return list;
        }

        private ListTariff<ChildTariff> generateChildTariffList() {
            ListTariff<ChildTariff> listTariff = new ListTariff<>();
            for (int i = 0; i < random.nextInt(MAX_TARIFFS); i++) {
                listTariff.addTariff(new ChildTariff(
                        Tariffs.getTariff(random.nextInt(Tariffs.size())).name(),
                        generateListClients(),
                        (random.nextInt(899)) + 100,
                        (random.nextInt(899)) + 100,
                        (random.nextInt(899)) + 100,
                        (random.nextInt(899)) + 100,
                        (random.nextInt(1)) + 10,
                        (random.nextInt(1)) + 10,
                        (random.nextInt(1)) + 10,
                        generateClient(),
                        generateClient()
                ));
            }
            return listTariff;
        }

        private ListTariff<PensionTariff> generatePensionTariffList() {
            ListTariff<PensionTariff> listTariff = new ListTariff<>();
            for (int i = 0; i < random.nextInt(MAX_TARIFFS); i++) {
                listTariff.addTariff(new PensionTariff(
                        Tariffs.getTariff(random.nextInt(Tariffs.size())).name(),
                        generateListClients(),
                        (random.nextInt(899)) + 100,
                        (random.nextInt(899)) + 100,
                        (random.nextInt(899)) + 100,
                        (random.nextInt(899)) + 100,
                        (random.nextInt(1)) + 10,
                        (random.nextInt(1)) + 10,
                        (random.nextInt(1)) + 10,
                        generateListClients()
                ));
            }
            return listTariff;
        }

        private ListTariff<LimitTariff> generateLimitTariffList() {
            ListTariff<LimitTariff> listTariff = new ListTariff<>();
            for (int i = 0; i < random.nextInt(MAX_TARIFFS); i++) {
                listTariff.addTariff(new LimitTariff(
                        Tariffs.getTariff(random.nextInt(Tariffs.size())).name(),
                        generateListClients(),
                        (random.nextInt(899)) + 100,
                        (random.nextInt(899)) + 100,
                        (random.nextInt(899)) + 100,
                        (random.nextInt(899)) + 100,
                        (random.nextInt(1)) + 10,
                        (random.nextInt(1)) + 10,
                        (random.nextInt(1)) + 10
                ));
            }
            return listTariff;
        }

        private ListTariff<FullUnlimitedTariff> generateFullUnlimitedTariffList() {
            ListTariff<FullUnlimitedTariff> listTariff = new ListTariff<>();
            for (int i = 0; i < random.nextInt(MAX_TARIFFS); i++) {
                listTariff.addTariff(new FullUnlimitedTariff(
                        Tariffs.getTariff(random.nextInt(Tariffs.size())).name(),
                        generateListClients(),
                        (random.nextInt(899)) + 100,
                        (random.nextInt(899)) + 100
                ));
            }
            return listTariff;
        }

        private ListTariff<UnlimitedInternetTariff> generateUnlimitedInternetTariffList() {
            ListTariff<UnlimitedInternetTariff> listTariff = new ListTariff<>();
            for (int i = 0; i < random.nextInt(MAX_TARIFFS); i++) {
                listTariff.addTariff(new UnlimitedInternetTariff(
                        Tariffs.getTariff(random.nextInt(Tariffs.size())).name(),
                        generateListClients(),
                        (random.nextInt(899)) + 100,
                        (random.nextInt(899)) + 100,
                        (random.nextInt(899)) + 100,
                        (random.nextInt(1)) + 10,
                        (random.nextInt(1)) + 10
                ));
            }
            return listTariff;
        }

        private ListTariff<UnlimitedMinTariff> generateUnlimitedMinTariffList() {
            ListTariff<UnlimitedMinTariff> listTariff = new ListTariff<>();
            for (int i = 0; i < random.nextInt(MAX_TARIFFS); i++) {
                listTariff.addTariff(new UnlimitedMinTariff(
                        Tariffs.getTariff(random.nextInt(Tariffs.size())).name(),
                        generateListClients(),
                        (random.nextInt(899)) + 100,
                        (random.nextInt(899)) + 100,
                        (random.nextInt(899)) + 100,
                        (random.nextInt(1)) + 10,
                        (random.nextInt(1)) + 10
                ));
            }
            return listTariff;
        }
    }
}
