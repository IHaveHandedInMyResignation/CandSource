package com.cand.source.utils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ImgTools {

	private static final Logger logger = Logger.getLogger(ImgTools.class);

	@Value("${store.image.prefix}")
	private String imgPrefix;

	@Value("${store.image.suffix}")
	private String imgSuffix;
	
	@Value("${store.image.default}")
	private String defaultPath;
	
	public InputStream getStream(String name) {
		String customPath = imgPrefix + name + imgSuffix;
		try {
			return (InputStream) new BufferedInputStream(new FileInputStream(customPath));
		} catch (FileNotFoundException e) {
			logger.debug("Image named " + name + " does not exist; PATH: " + customPath);
			try {
				return (InputStream) new BufferedInputStream(
						new FileInputStream(defaultPath));
			} catch (FileNotFoundException e2) {
				logger.debug("DEFAULT PROFILE IMAGE DOES NOT EXIST; PATH: " + defaultPath);
			}
		}
		return null;
	}
}
