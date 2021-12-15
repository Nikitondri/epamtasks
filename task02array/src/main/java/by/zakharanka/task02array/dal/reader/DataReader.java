package by.zakharanka.task02array.dal.reader;

import java.io.File;

public abstract class DataReader {

    protected File file;

    protected DataReader(String path) {
        file = new File(path);
    }

    private boolean isEmptyFile(){
        return file.length() == 0;
    }

    private boolean isExistFile(){
        return file.exists();
    }

    public boolean isCorrectPath(){
        return isExistFile() && !isEmptyFile();
    }


}
