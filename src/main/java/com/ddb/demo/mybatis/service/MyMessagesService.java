package com.ddb.demo.mybatis.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ddb.demo.exception.ParameterErrorException;
import com.ddb.demo.model.MyMessages;
import com.ddb.demo.mybatis.mapper.MyMessagesMapper;

/**
 * @Description: 我的消息
 * @author yangbiao
 * @date 2018年5月22日 下午4:53:54
 */
@Service
public class MyMessagesService {
	private static final Logger log = LoggerFactory.getLogger(MyMessagesService.class);

	@Autowired
	private MyMessagesMapper myMessagesMapper;

	/**
	 * @throws @Description:保存我的消息
	 * @return
	 */
//	@Transactional(rollbackFor=Exception.class)
	@Transactional
	public String save(List<MyMessages> list) {
		try {
			if (list!=null && !list.isEmpty()) {
						myMessagesMapper.save(list);
						throw new Exception();
//						myMessagesMapper.delete(list);
				}
		} catch (Exception e) {
			log.info("保存失败");
//			ParameterErrorException.message("哎呀,保存失败了");
			
			System.err.println("不要闹了");
		}
		System.err.println("wowowowowow 不要闹了");
		return "保存成功";
	}

}
