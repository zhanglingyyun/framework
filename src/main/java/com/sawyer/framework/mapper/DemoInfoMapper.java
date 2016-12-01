package com.sawyer.framework.mapper;

import org.apache.ibatis.annotations.Select;

import com.sawyer.framework.domain.DemoInfo;

public interface DemoInfoMapper {  
  
	@Select("select * from DemoInfo where demo_id = #{id}")
    public DemoInfo getDemoInfo(int id);  
}  