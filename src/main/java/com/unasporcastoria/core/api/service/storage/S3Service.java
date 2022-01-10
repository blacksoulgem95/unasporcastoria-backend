package com.unasporcastoria.core.api.service.storage;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.unasporcastoria.core.api.exception.Error;
import com.unasporcastoria.core.api.exception.USSException;
import com.unasporcastoria.core.api.util.FileUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

@Slf4j
@Service
public class S3Service implements StorageService {
    private final AmazonS3 s3;
    private final String bucket;
    private final String endpoint;

    public S3Service(AmazonS3 s3, @Value("${cloud.aws.s3.bucket}") String bucket, @Value("${cloud.aws.s3.endpoint}") String endpoint) {
        this.s3 = s3;
        this.bucket = bucket;
        this.endpoint = endpoint;
    }

    /**
     * @param path     folder path in the bucket
     * @param filename file name without extension
     * @param filename the file to upload
     * @return a string with the full url (without protocol) to the image
     */
    public String upload(String path, String filename, MultipartFile multipartFile) {
        String fileUrl;
        try {
            // Get the file from MultipartFile.
            File file = FileUtils.convertMultipartToFile(multipartFile);

            var filePath = getFullName(filename, path, multipartFile);

            // Upload file.
            var request = new PutObjectRequest(
                    bucket, filePath, file
            );

            s3.putObject(request);

            // Delete the file and get the File Url.
            file.delete();
            fileUrl = endpoint.concat(filePath);
        } catch (IOException e) {

            // If IOException on conversion or any file manipulation, call exception.
            log.warn("Cannot upload image:", e);
            throw new USSException(Error.FILE_UPLOAD_ERROR, e.getMessage(), e);
        }

        return fileUrl;
    }

    public void deleteImageFromUrl(String imageUrl) {
        var file = imageUrl.replace(endpoint, "");
        s3.deleteObject(bucket, file);
    }
}
