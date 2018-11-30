package com.jd.export.util;

import java.io.ByteArrayOutputStream;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;


	 public class FileUploader {
		
				private static final Logger log = LoggerFactory
						.getLogger(FileUploader.class);
				static {
					Resource resource = new ClassPathResource("iepe.properties");
					try {
						Properties props = PropertiesLoaderUtils.loadProperties(resource);
						FORWARD_URL = props.get("FORWARD_URL_DOC").toString();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				private static String FORWARD_URL;

				private FileUploader() {

				}

				public static String upload(byte[] data, String fileExtendName) {
					try {
						String prefix = "------WebKitFormBoundaryK2SDjvH9N7SkmYlb\n"
								+ "Content-Disposition: form-data; name=\"name\"\n\n"
								+ "1."
								+ fileExtendName
								+ "\n"
								+ "Content-Disposition: form-data; name=\"localUrl\\n\n"
								+ "C:\\fakepath\\1."
								+ fileExtendName
								+ "\n"
								+ "------WebKitFormBoundaryK2SDjvH9N7SkmYlb\n"
								+ "Content-Disposition: form-data; name=\"file\"; filename=\"1."
								+ fileExtendName + "\"\n"
								+ "Content-Type: application/octet-stream\n\n";
						String suffix = "\n------WebKitFormBoundaryK2SDjvH9N7SkmYlb\n";
						String contentType = "multipart/form-data; boundary=----WebKitFormBoundaryK2SDjvH9N7SkmYlb";
						ByteArrayOutputStream baos = new ByteArrayOutputStream();
						baos.write(prefix.getBytes());
						baos.write(data);
						baos.write(suffix.getBytes());
						URL url = new URL(FORWARD_URL);
						HttpURLConnection huc = (HttpURLConnection) url.openConnection();
						huc.setDoInput(true);
						huc.setDoOutput(true);
						huc.setRequestProperty("Content-Type", contentType);
						OutputStream os = huc.getOutputStream();
						os.write(baos.toByteArray());
						os.close();
						baos.close();
						InputStream iss = huc.getInputStream();
						ByteArrayOutputStream oss = new ByteArrayOutputStream();
						int len;
						byte[] buf = new byte[10240];
						while ((len = iss.read(buf)) > 0) {
							oss.write(buf, 0, len);
						}
						iss.close();
						String result = oss.toString();
						oss.close();
						return result;
					} catch (Exception e) {
						log.error("上传文件失败！", e);
						return "";
					}
				}

				public static String upload(String data, String fileExtendName) {
					try {
						return upload(data.getBytes("utf-8"), fileExtendName);
					} catch (UnsupportedEncodingException e) {
						log.error("上传文件失败！", e);
						return "";
					}
				}
			}


