package com.busbooking.services;

import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {

    String saveFile(
            MultipartFile file,
            String folder
    );

}