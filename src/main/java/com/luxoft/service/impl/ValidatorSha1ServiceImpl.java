package com.luxoft.service.impl;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;
import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;

/**
 * Created by Svetlana Lawrentyeva on 09.04.15.
 */
public class ValidatorSha1ServiceImpl implements com.luxoft.service.ValidatorSha1Service {
    @Override
    public boolean validate(File file, String hashInput){
        String hashComputed = "";
        try {
            hashComputed = Files.hash(file, Hashing.sha1()).toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return hashInput.equals(hashComputed);
    }
}
