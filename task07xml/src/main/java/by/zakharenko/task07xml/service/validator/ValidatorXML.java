package by.zakharenko.task07xml.service.validator;

import by.zakharenko.task07xml.service.exception.ServiceException;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class ValidatorXML extends DefaultHandler {

    public void validateXMLFile(InputStream inputStream, String schemaPath) throws ServiceException {
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try {
            Schema schema = schemaFactory.newSchema(new File(Objects.requireNonNull(getClass().getClassLoader().getResource(schemaPath)).getFile()));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(inputStream));
        } catch (SAXException | IOException e) {
            throw new ServiceException("File is invalid", e);
        }
    }
}
