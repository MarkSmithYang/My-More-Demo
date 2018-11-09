package com.ddb.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ddb.demo.model.MyMessages;
import com.ddb.demo.mybatis.service.MyMessagesService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("测试try--catch")
@RestController
public class MyMessagesController {
	
	@Autowired
	private MyMessagesService myMessagesService;

	@ApiOperation("测试try")
	@GetMapping("test")
	public String testTry() {
		List<MyMessages> list = new ArrayList<>();
		MyMessages msgs = new MyMessages();
		msgs.setDate("2018/05/3011");
		msgs.setMessages("我爱你们11");
		list.add(msgs);
		MyMessages myMessages = new MyMessages("2016/03/02", "老街");
		list.add(myMessages);
		String save = myMessagesService.save(list);
		return save;
	}
}
