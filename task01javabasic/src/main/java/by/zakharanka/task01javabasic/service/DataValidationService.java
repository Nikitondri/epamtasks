package by.zakharanka.task01javabasic.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashSet;

/**
 * class for data validation
 */
public class DataValidationService {

    static final Logger LOGGER = LogManager.getLogger(DataValidationService.class.getName());

    private void fillValidSet(HashSet<Character> setValid){
        for(char i = 'a'; i <= 'z'; i++){
            setValid.add(i);
        }
        for(char i = 'A'; i <= 'Z'; i++){
            setValid.add(i);
        }
        setValid.add('_');
    }

    private void addFillValidSet(HashSet<Character> setValid){
        for(char i = '0'; i <= '9'; i++){
            setValid.add(i);
        }
    }

    /**
     * if first {@code HashSet} object is filled letters and '_'
     * then check the first character of the checked string
     * then {@code HashSet} object is added numbers
     * then check the rest of the characters in the string
     * @see HashSet
     * @param str for check
     * @return boolean result
     */
    public boolean identifierValidation(String str){
        LOGGER.info("identifierValidation run");
        HashSet<Character> setValid = new HashSet<>();
        fillValidSet(setValid);
        char[] charArr = str.toCharArray();
        if(!setValid.contains(charArr[0])){
            return false;
        }
        addFillValidSet(setValid);
        for(char ch: charArr){
            if(!setValid.contains(ch)){
                return false;
            }
        }
        return true;
    }
}
