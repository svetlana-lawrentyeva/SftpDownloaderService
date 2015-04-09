package com.luxoft.service;

import com.luxoft.exception.UnZipException;

import java.io.File;

/**
 * Created by Svetlana Lawrentyeva on 09.04.15.
 */
public interface UnZipService {
    File unzip(File file) throws UnZipException;
    boolean izValidZipFile(File file);
}
