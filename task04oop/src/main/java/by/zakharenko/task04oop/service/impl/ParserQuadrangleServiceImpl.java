package by.zakharenko.task04oop.service.impl;

import by.zakharenko.task04oop.entity.Point;
import by.zakharenko.task04oop.entity.Quadrangle;
import by.zakharenko.task04oop.service.ParserService;
import by.zakharenko.task04oop.service.ValidatorService;
import by.zakharenko.task04oop.service.factory.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ParserQuadrangleServiceImpl implements ParserService<Quadrangle> {
    private final Logger logger = LogManager.getLogger(ParserQuadrangleServiceImpl.class);

    @Override
    public List<Quadrangle> parse(List<String> lines) {
        ValidatorService validatorService = ServiceFactory.getInstance().getValidatorQuadrangleService();
        List<String> correctLines = lines.stream().filter(validatorService::isCorrectLine).collect(Collectors.toList());
        logger.info("Correct lines: {}", correctLines.size());
        List<Quadrangle> list = new ArrayList<>();
        for(String line: correctLines){
            String[] params = line.split("\\s+");
            list.add(new Quadrangle(
                    params[0],
                    new Point(Double.parseDouble(params[1]), Double.parseDouble(params[2])),
                    new Point(Double.parseDouble(params[3]), Double.parseDouble(params[4])),
                    new Point(Double.parseDouble(params[5]), Double.parseDouble(params[6])),
                    new Point(Double.parseDouble(params[7]), Double.parseDouble(params[8]))
            ));
        }
        logger.trace("Successfully parse");
        return list;
    }
}
