package com.ddb.demo.mybatis.mapper;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ddb.demo.model.MyMessages;


/**
* @Description: 我的消息
* @author yangbiao
* @date 2018年5月22日 下午4:52:56
*/ 
public interface MyMessagesMapper extends JpaRepository<MyMessages, String>{

}
