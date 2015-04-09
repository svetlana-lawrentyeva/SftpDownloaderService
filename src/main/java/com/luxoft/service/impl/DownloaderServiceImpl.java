package com.luxoft.service.impl;

import com.luxoft.service.SftpPropertyReader;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Svetlana Lawrentyeva on 09.04.15.
 */
public class DownloaderServiceImpl implements com.luxoft.service.DownloaderService {

    private SftpPropertyReader sftpPropertyReader;

    @Override
    public File download(String fileName){
        String host = sftpPropertyReader.getHost();
        int port = Integer.parseInt(sftpPropertyReader.getPort());
        String directory = sftpPropertyReader.getDirectory();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(sftpPropertyReader.getLocalDirectory()).append("/").append(fileName);
        File file = new File(stringBuilder.toString());
        URL url = null;
        try {
            url = new URL("sftp", host, port, fileName);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            FileUtils.copyURLToFile(url, file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

}
