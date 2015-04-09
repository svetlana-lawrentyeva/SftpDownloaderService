package com.luxoft.service;

import java.io.File;

/**
 * Created by Svetlana Lawrentyeva on 09.04.15.
 */
public interface ValidatorSha1Service {
    boolean validate(File file, String hashInput);
}
