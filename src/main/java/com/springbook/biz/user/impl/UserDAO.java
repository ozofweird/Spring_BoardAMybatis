package com.springbook.biz.user.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbook.biz.user.UserVO;

@Repository("userDAO")
public class UserDAO {
	
	@Autowired
	private SqlSession mybatis;

	public UserVO getUser(UserVO vo) {
		System.out.println("===> Mybatis�� getUser() ��� ó��");
		return mybatis.selectOne("UserDAO.getUser", vo);
	}

	
}
