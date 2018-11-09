package com.ddb.demo.mybatis.service;

import java.sql.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.ddb.demo.mybatis.mapper.MybatisMapper;
import com.ddb.demo.mybatis.model.MybatisDemo;

@Service
public class MybatisService {
	
	@Autowired
	private MybatisMapper mybatisMapper;

	public MybatisDemo findDemo(String id) {
		if (StringUtils.isNotBlank(id)) {
			MybatisDemo demo = mybatisMapper.findDemo(id);
			return demo;
		}
		return null;
	}

//	@Scheduled(cron="0/3 1/1 * * * ? ")
	public void name() {
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.err.println("mini: "+new Date(System.currentTimeMillis()));
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.err.println("jiujijhu: "+new Date(System.currentTimeMillis()));
			}
		}).start();
		System.err.println("hahah: "+new Date(System.currentTimeMillis()));
	}

}
