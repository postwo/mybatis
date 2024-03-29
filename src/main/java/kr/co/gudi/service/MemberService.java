package kr.co.gudi.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.gudi.dao.MemberDAO;
import kr.co.gudi.dto.MemberDTO;

@Service
public class MemberService {
	
	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired MemberDAO dao;
		
	public String join(HashMap<String, String> params) {
		int row = dao.insert(params);		
		return row > 0 ? "회원가입에 성공했습니다.":"회원가입에 실패 했습니다.";
	}

	public String login(String id, String pw) {		
		return dao.login(id,pw);
	}

	public ArrayList<MemberDTO> list() {		
		return dao.list();
	}

	public int del(String id) {		
		return dao.del(id);
	}

	public MemberDTO detail(String id) {
		return dao.detail(id);
	}

	public int update(HashMap<String, String> params) {
		return dao.update(params);
	}

}
