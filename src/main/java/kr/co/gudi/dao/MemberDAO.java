package kr.co.gudi.dao;

import java.util.ArrayList;
import java.util.HashMap;

import kr.co.gudi.dto.MemberDTO;

public interface MemberDAO {

	int insert(HashMap<String, String> params);

	String login(String id, String pw);

	ArrayList<MemberDTO> list();

	int del(String id);

	MemberDTO detail(String id);

	int update(HashMap<String, String> params);

}
