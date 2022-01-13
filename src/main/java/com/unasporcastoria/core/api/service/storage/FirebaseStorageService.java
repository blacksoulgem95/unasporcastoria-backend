package com.unasporcastoria.core.api.service.storage;

import com.google.cloud.storage.Blob;

import com.google.cloud.storage.Bucket;
import com.unasporcastoria.core.api.exception.Error;
import com.unasporcastoria.core.api.exception.USSException;
import com.unasporcastoria.core.api.util.FileUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;

@Slf4j
@Service("firebaseStorage")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FirebaseStorageService implements StorageService {

  private final Bucket bucket;

  @Override
  public String upload(String path, String filename, MultipartFile multipartFile) {
    String fileUrl;
    try {
      // Get the file from MultipartFile.
      File file = FileUtils.convertMultipartToFile(multipartFile);

      fileUrl = getFullName(filename, path, multipartFile);

      bucket.create(fileUrl, new FileInputStream(file));

    } catch (Exception e) {

      // If IOException on conversion or any file manipulation, call exception.
      log.warn("Cannot upload image:", e);
      throw new USSException(Error.FILE_UPLOAD_ERROR, e.getMessage(), e);
    }
    return fileUrl;
  }

  @Override
  public void deleteImageFromUrl(String imageUrl) {
    try {
      Blob blob = bucket.get(imageUrl);
      blob.delete();
    } catch (Exception e) {
      log.warn("Cannot delete image:", e);
      throw new USSException(Error.FILE_UPLOAD_ERROR, e.getMessage(), e);
    }
  }
}
