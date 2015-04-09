package com.luxoft.service.impl;

import com.luxoft.exception.Sha1InvalidFileException;
import com.luxoft.exception.UnZipException;
import com.luxoft.service.DownloaderService;
import com.luxoft.service.SaverService;
import com.luxoft.service.UnZipService;
import com.luxoft.service.ValidatorSha1Service;

import java.io.File;

/**
 * Created by Svetlana Lawrentyeva on 10.04.15.
 */
public class SftpDownloaderServiceImpl {
    private DownloaderService downloaderService;
    private ValidatorSha1Service validatorSha1Service;
    private UnZipService unZipService;
    private SaverService saverService;

    public String download(String fileName, FileType fileType, String sha1) throws Sha1InvalidFileException {
        File file = downloaderService.download(fileName);
        if(!validatorSha1Service.validate(file, sha1)){
            throw  new Sha1InvalidFileException();
        }
        if (unZipService.izValidZipFile(file)){
            try {
                file = unZipService.unzip(file);
            } catch (UnZipException e) {
                e.printStackTrace();
            }
        }
        return saverService.save(file);
    }

    public void setDownloaderService(DownloaderService downloaderService) {
        this.downloaderService = downloaderService;
    }

    public void setValidatorSha1Service(ValidatorSha1Service validatorSha1Service) {
        this.validatorSha1Service = validatorSha1Service;
    }

    public void setUnZipService(UnZipService unZipService) {
        this.unZipService = unZipService;
    }

    public void setSaverService(SaverService saverService) {
        this.saverService = saverService;
    }
}
