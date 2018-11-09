package com.ddb.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadFile {

	@RequestMapping("upload")
	public String upload(MultipartFile fileUpload) {
		if (fileUpload==null) {
			System.err.println("文件不能为空");
		}
		String filename = fileUpload.getOriginalFilename();
		//这种方式对于文件名含有多个点的时候并不适用
		//String nameSuffer = filename.substring(".".indexOf(filename));
		return "ok";
	}
}
