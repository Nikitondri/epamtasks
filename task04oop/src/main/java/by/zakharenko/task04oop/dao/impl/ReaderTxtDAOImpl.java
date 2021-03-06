package by.zakharenko.task04oop.dao.impl;

import by.zakharenko.task04oop.dao.ReaderDAO;
import by.zakharenko.task04oop.dao.exception.DAOException;
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

    /**
     * method that reads and returns data line by line from a TXT file
     * @param path the path to the file
     * @return List containing string lines from a file
     * @throws DAOException in case the file is not found
     */
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
