package com.unasporcastoria.core.api.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;

public abstract class FileUtils {

  public static boolean isImage(String contentType) {
    return "image".equals(contentType.toLowerCase().split("/")[0]);
  }

  public static File convertMultipartToFile(MultipartFile file) throws IOException {
    File convertedFile = new File(Objects.requireNonNull(file.getOriginalFilename()));
    FileOutputStream fileOutputStream = new FileOutputStream(convertedFile);
    fileOutputStream.write(file.getBytes());
    fileOutputStream.close();
    return convertedFile;
  }

  public static String generateFileName(MultipartFile multipartFile) {
    return generateFileName(multipartFile, null);
  }

  public static String generateFileName(MultipartFile multipartFile, String overrideFileName) {
    String ext = getExtensionByStringHandling(multipartFile.getOriginalFilename()).orElse("");
    return new Date().getTime() + "-" + Objects.requireNonNull(
        Optional.ofNullable(overrideFileName).orElse(
            getFileNameWithoutExtension(multipartFile.getOriginalFilename())
        )
    ).replace(" ", "_") + ext;
  }

  public static String getFileNameWithoutExtension(String filename) {
    String ext = getExtensionByStringHandling(filename).orElse("");
    return filename.substring(0, filename.length() - ext.length());
  }

  public static Optional<String> getExtensionByStringHandling(String filename) {
    return Optional.ofNullable(filename)
        .filter(f -> f.contains("."))
        .map(f -> f.substring(filename.lastIndexOf(".") + 1));
  }
}
