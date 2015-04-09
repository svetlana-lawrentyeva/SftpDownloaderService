package com.luxoft.service.impl;

import com.luxoft.exception.UnZipException;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.Collection;
import java.util.List;

/**
 * Created by Svetlana Lawrentyeva on 09.04.15.
 */
public class UnZipServiceImpl implements com.luxoft.service.UnZipService {
    @Override
    public File unzip(File file) throws UnZipException {
        String directory = file.getParent();
        String password = "password";

        try {
            ZipFile zipFile = new ZipFile(file);
            if (zipFile.isEncrypted()) {
                zipFile.setPassword(password);
            }
            zipFile.extractAll(directory);
            file.delete();
        } catch (ZipException e) {
            e.printStackTrace();
        }
        Collection<File> fileCollection = FileUtils.listFiles(new File(directory), null, false);
        if(fileCollection.size() != 1){
            throw new UnZipException();
        }
        File unZipFile = fileCollection.iterator().next();
        return unZipFile;
    }
    public boolean izValidZipFile(File file){
        ZipFile zipFile;
        boolean result = false;
        try {
            zipFile= new ZipFile(file);
            result = zipFile.isValidZipFile();
        } catch (ZipException e) {
            e.printStackTrace();
        }
        return result;
    }
}
