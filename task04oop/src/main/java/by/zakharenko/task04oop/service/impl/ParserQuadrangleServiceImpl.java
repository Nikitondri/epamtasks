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

/** Parser for {@code Quadrangle} class */
public class ParserQuadrangleServiceImpl implements ParserService<Quadrangle> {
    private final Logger logger = LogManager.getLogger(ParserQuadrangleServiceImpl.class);

    /**
     * method that selects valid quads from a list of strings
     * where the parameters for the quad are separated by spaces
     * @see ValidatorQuadrangleServiceImpl
     * @see Quadrangle
     * @param lines List of strings received from reader classes for {@code Quadrangle}
     * @return list of correct {@code Quadrangle} objects
     */
    @Override
    public List<Quadrangle> parse(List<String> lines) {
        ValidatorService<Quadrangle> validatorService = ServiceFactory.getInstance().getValidatorQuadrangleService();
        List<String> correctLines = lines.stream().filter(validatorService::isCorrectLine).collect(Collectors.toList());
        logger.info("Correct lines: {}", correctLines.size());
        List<Quadrangle> list = new ArrayList<>();
        for(String line: correctLines){
            String[] params = line.split("\\s+");
            Quadrangle quadrangle = new Quadrangle(
                    params[0],
                    new Point(Double.parseDouble(params[1]), Double.parseDouble(params[2])),
                    new Point(Double.parseDouble(params[3]), Double.parseDouble(params[4])),
                    new Point(Double.parseDouble(params[5]), Double.parseDouble(params[6])),
                    new Point(Double.parseDouble(params[7]), Double.parseDouble(params[8]))
            );
            if(validatorService.isCorrectObject(quadrangle)){
                list.add(quadrangle);
            }
        }
        logger.info("Correct quadrangles: {}", list.size());
        return list;
    }
}
