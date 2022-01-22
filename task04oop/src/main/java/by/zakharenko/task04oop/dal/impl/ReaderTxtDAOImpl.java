package by.zakharenko.task04oop.dal.impl;

import by.zakharenko.task04oop.dal.ReaderDAO;
import by.zakharenko.task04oop.dal.exception.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReaderTxtDAOImpl implements ReaderDAO {
    private static final Logger logger = LogManager.getLogger(ReaderTxtDAOImpl.class);

    @Override
    public List<String> readFile(String path) throws DAOException {
        try(Stream<String> lineStream = Files.lines(Paths.get(path))){
            List<String> lines = lineStream.collect(Collectors.toList());
            logger.info("Data has read successfully. Good lines: {}", lines.size());
            return lines;
        } catch (IOException e) {
            throw new DAOException("Non compliant path in ReaderTxtDAOImpl");
        }
    }
}
