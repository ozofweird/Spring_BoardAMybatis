package com.springbook.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {
	
	@RequestMapping(value="logout.do")
	public String handleRequest(HttpSession session) {
	
		// �������� ����� ���� ��ü ���� ����
		session.invalidate();

		return "login.jsp";
	}
}
