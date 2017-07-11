package com.cand.source.controller.rest;

import java.io.IOError;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cand.source.utils.ImgTools;

@RestController
@RequestMapping("/img")
public class ImageController {

	private static final Logger logger = Logger.getLogger(ImageController.class);

	@Autowired
	ImgTools imgTools;

	@RequestMapping("/{login}")
	public void getProfileImg(@PathVariable("login") String id, HttpServletResponse response) {
		try {
			InputStream inputStream = imgTools.getStream(id);
			IOUtils.copy(inputStream, response.getOutputStream());
			response.flushBuffer();
			inputStream.close();
		} catch (IOError ex) {
			logger.error(ex.getMessage());
		} catch (IOException ex) {
			logger.error(ex.getMessage());
		}
	}
}
