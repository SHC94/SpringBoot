package com.springboot.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.springboot.vo.SpringBootVO;

@Mapper
public interface SpringBootMapper {

	SpringBootVO selectSpringBootList();
	
}//end interface()
