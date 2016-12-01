package com.sawyer.framework.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Results; 
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;

import com.sawyer.framework.domain.Demo;
import org.apache.ibatis.annotations.One; 

public interface DemoMappper
{

	@Select("select *from Demo where name = #{name}")
	public List<Demo> likeName(String name);

	@Select("select *from Demo where id = #{id}")
	public Demo getById(long id);

	@Select("select name from Demo where id = #{id}")
	public String getNameById(long id);
	
	@Select("select *from Demo where name = #{name}")
    @Results({  
        @Result(id=true,property="id",column="id"),  
        @Result(property="name",column="name"),  
        @Result(property="content",column="content"),  
        @Result(property="demoInfo",column="demo_id",one= @One(select="com.sawyer.framework.mapper.DemoMappper.getDemoInfo"))  
    })  
    public List<Demo> joinTest(String name);

}