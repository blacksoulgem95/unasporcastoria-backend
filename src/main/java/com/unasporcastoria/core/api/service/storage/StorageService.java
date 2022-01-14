package com.unasporcastoria.core.api.service.storage;

import com.unasporcastoria.core.api.util.FileUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Paths;

public interface StorageService {

  String upload(String path, String filename, MultipartFile multipartFile);

  void deleteImageFromUrl(String imageUrl);

  default String getFullName(String filename, String path, MultipartFile multipartFile) throws IOException {
    // Extract the file name.
    String newFileName = FileUtils.generateFileName(multipartFile, filename);
    return Paths.get(path, newFileName).toString();
  }

}
