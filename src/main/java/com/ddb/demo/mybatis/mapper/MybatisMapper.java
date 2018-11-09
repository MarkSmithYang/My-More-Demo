package com.ddb.demo.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.ddb.demo.mybatis.model.MybatisDemo;

@Mapper
public interface MybatisMapper {

	@Select("select * from mybatis_demo where id=#{id}")
	MybatisDemo findDemo(String id);

}
