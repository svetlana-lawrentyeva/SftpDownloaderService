package com.luxoft.service.impl;

import com.google.common.io.InputSupplier;
import com.google.common.io.Resources;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

/**
 * Created by Svetlana Lawrentyeva on 09.04.15.
 */
public class SftpPropertyReaderImpl implements com.luxoft.service.SftpPropertyReader {

    private static final String HOST = "host";
    private static final String PORT = "port";
    private static final String DIRECTORY = "directory";
    private static final String LOCAL_DIRECTORY = "localDirectory";

    private Properties properties = new Properties();

    public SftpPropertyReaderImpl(String sftpProperties){
        URL url = Resources.getResource(sftpProperties);
        InputSupplier<InputStream> inputSupplier = Resources.newInputStreamSupplier(url);

        Properties properties = new Properties();
        try {
            properties.load(inputSupplier.getInput());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getHost(){
        return properties.getProperty(HOST);
    }
    @Override
    public String getPort(){
        return properties.getProperty(PORT);
    }
    @Override
    public String getDirectory(){
        return properties.getProperty(DIRECTORY);
    }
    @Override
    public String getLocalDirectory(){
        return properties.getProperty(LOCAL_DIRECTORY);
    }
}
