package test.zakharenko.task07xml.service.factory;

import by.zakharenko.task07xml.service.ParseService;
import by.zakharenko.task07xml.service.factory.ServiceFactory;
import by.zakharenko.task07xml.service.impl.ParseServiceImpl;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ServiceFactoryTest {

    @Test
    public void getParseServiceTest(){
        ParseService parseService = ServiceFactory.getInstance().getParseService();
        assertTrue(parseService instanceof ParseServiceImpl);
    }
}
