package com.springboot.project.service;

import org.apache.commons.io.FilenameUtils;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.UUID;
import java.util.stream.Stream;

@Service // để java hiểu đây là service
public class ImageStorageService implements IStorageService {
    private final Path storageFolder = Paths.get("uploads");

    public ImageStorageService() {
        try {
            Files.createDirectories(storageFolder);
        } catch (IOException e) {
            throw new RuntimeException("Cannot initialize storage", e);
        }
    }

    public boolean isImageFile(MultipartFile file) {
        String fileExtension = FilenameUtils.getExtension(file.getOriginalFilename());
        return Arrays.asList(new String[]{
                "png", "jpg", "jpeg", "bmp"
        }).contains(fileExtension.trim().toLowerCase());
    }

    @Override
    public String storeFile(MultipartFile file) {
        try {
            if (file.isEmpty()) {
                throw new RuntimeException("Fail to store empty file.");
            }
            if (!isImageFile(file)) {
                throw new RuntimeException("You can only upload image file");
            }
            float fileSizeImageUpload = file.getSize() / 1_000_000.0f;
            System.out.println(fileSizeImageUpload);
            if (fileSizeImageUpload > 5.0f) {
                throw new RuntimeException("File must be < 5.0 MB");
            }
            // file must be rename
            String fileExtension = FilenameUtils.getExtension(file.getOriginalFilename());
            String generateFilename = UUID.randomUUID().toString().replace("-", "");
            generateFilename = generateFilename + "." + fileExtension;
            Path destinationFilePath = this.storageFolder.resolve(Paths.get(generateFilename)).normalize().toAbsolutePath();
            if (!destinationFilePath.getParent().equals(this.storageFolder.toAbsolutePath())) {
                throw new RuntimeException("Cannot store file outside current directory.");
            }
            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, destinationFilePath, StandardCopyOption.REPLACE_EXISTING);
            }
            return generateFilename;
        } catch (IOException ex) {
            throw new RuntimeException("Failed to store file.", ex);
        }
    }

    @Override
    public Stream<Path> loadAll() {
        return null;
    }

    @Override
    public byte[] readFileContent(String fileName) {
        try {
            Path file = storageFolder.resolve(fileName);
            org.springframework.core.io.Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                byte[] bytes = StreamUtils.copyToByteArray(resource.getInputStream());
                return bytes;
            } else {
                throw new RuntimeException("Could not read file: " + fileName);
            }
        } catch (IOException e) {
            throw new RuntimeException("Could not read file: " + fileName, e);
        }
    }

    @Override
    public void deleteAllFiles() {

    }
}
