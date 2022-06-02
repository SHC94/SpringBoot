package com.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.mapper.SpringBootMapper;
import com.springboot.vo.SpringBootVO;

@Service
public class SpringBootServiceImpl implements SpringBootService {

	@Autowired
	private SpringBootMapper springBootMapper;
	
	@Override
	public SpringBootVO selectSpringBootList() {
		SpringBootVO resultList = springBootMapper.selectSpringBootList(); 
		return resultList;
	}//end selectSpringBootList()

}//end class()
