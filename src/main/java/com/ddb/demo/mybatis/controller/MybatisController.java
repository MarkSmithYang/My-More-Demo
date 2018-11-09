package com.ddb.demo.mybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ddb.demo.mybatis.model.MybatisDemo;
import com.ddb.demo.mybatis.service.MybatisService;

@RestController
public class MybatisController {
	
	@Autowired
	private MybatisService mybatisService;
	
	@GetMapping("mybatis")
	public MybatisDemo findDemo(@RequestParam String id) {
		MybatisDemo demo = mybatisService.findDemo(id);
		return demo;
	}
}
