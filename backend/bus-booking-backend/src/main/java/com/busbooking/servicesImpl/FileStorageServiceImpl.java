package com.busbooking.servicesImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.busbooking.services.FileStorageService;

@Service
public class FileStorageServiceImpl
        implements FileStorageService {

    @Value("${file.upload-dir}")
    private String uploadDir;

    @Override
    public String saveFile(
            MultipartFile file,
            String folder) {

        try {

            Path folderPath = Paths.get(uploadDir, folder);

            if (!Files.exists(folderPath)) {

                Files.createDirectories(folderPath);

            }

            String originalFileName =
                    file.getOriginalFilename();

            String extension = "";

            if (originalFileName != null &&
                    originalFileName.contains(".")) {

                extension =
                        originalFileName.substring(
                                originalFileName.lastIndexOf("."));

            }

            String fileName =
                    UUID.randomUUID() + extension;

            Path destination =
                    folderPath.resolve(fileName);

            Files.copy(
                    file.getInputStream(),
                    destination,
                    StandardCopyOption.REPLACE_EXISTING);

            return "uploads/" + folder + "/" + fileName;

        }

        catch (IOException ex) {

            throw new RuntimeException(
                    "Unable to save file",
                    ex);

        }

    }

}