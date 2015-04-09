package com.luxoft.service;

/**
 * Created by Svetlana Lawrentyeva on 09.04.15.
 */
public interface SftpPropertyReader {
    String getHost();

    String getPort();

    String getDirectory();

    String getLocalDirectory();
}
