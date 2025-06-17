package com.s3.examples.service;

import java.io.IOException;
import java.io.InputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.util.IOUtils;

@Service
public class BucketService {

	@Autowired
	private FileStore fileStore;

	public String createBucket(String bucketName) {
		return fileStore.createBucket(bucketName);
	}

	public String uploadFile(MultipartFile file, String bucketName) {
		if (file.isEmpty()) {
			throw new IllegalStateException("Cannot upload empty file");
		}
		try {
			fileStore.uploadFiletoBucket(file, bucketName);
		} catch (Exception e) {
			throw new IllegalStateException("Failed to upload file", e);
		}
		return "File Uploaded Successfully";
	}

	public String deleteBucket(String bucketName) {
		fileStore.deleteBucket(bucketName);
		return "Bucket deleted successfully";
	}

	public String deleteFile(String bucketName, String fileName) {
		fileStore.deletFile(bucketName,fileName);
		return "File deleted successfully";
	}

}
