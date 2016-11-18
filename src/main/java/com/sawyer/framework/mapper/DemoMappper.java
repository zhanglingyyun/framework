package com.sawyer.framework.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.sawyer.framework.domain.Demo;

public interface DemoMappper
{

	@Select("select *from Demo where name = #{name}")
	public List<Demo> likeName(String name);

	@Select("select *from Demo where id = #{id}")
	public Demo getById(long id);

	@Select("select name from Demo where id = #{id}")
	public String getNameById(long id);

}