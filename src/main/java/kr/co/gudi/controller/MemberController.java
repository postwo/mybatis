package kr.co.gudi.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.gudi.dto.MemberDTO;
import kr.co.gudi.service.MemberService;

@Controller
public class MemberController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired MemberService service;
	
	@RequestMapping(value="/")
	public String home() {
		return "index";
	}
	
	@RequestMapping(value="/joinForm")
	public String joinForm() {
		return "joinForm";
	}
	
	@RequestMapping(value="/join", method = RequestMethod.POST)
	public String join(@RequestParam HashMap<String, String> params, Model model) {
		logger.info("params : "+params);
		String msg = service.join(params);
		model.addAttribute("msg", msg);
		return "index";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String login(Model model, HttpSession session,
			@RequestParam String id, @RequestParam String pw) {
		String page = "index";

		logger.info(id+"/"+pw);
		String loginId = service.login(id,pw);
		logger.info("loginId : "+loginId);		
		
		if(loginId != null) {
			session.setAttribute("loginId", loginId);
			page = "redirect:/list";
		}else {
			model.addAttribute("msg", "아이디 또는 비밀번호를 확인 하세요");
		}		
		
		return page;
	}
		
	@RequestMapping(value="/list")
	public String list(Model model) {		
		ArrayList<MemberDTO> list = service.list();
		model.addAttribute("list",list);
		return "list";
	}
	
	@RequestMapping(value="/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("loginId");
		// redirect 를 사용 하면 /logout 요청이 남지 않는다.
		// 다만, 이경우 model 에 데이터를 실어나를 수 없다.
		return "redirect:/";
	}
	
	@RequestMapping(value="/del")
	public String del(@RequestParam String id) {
		int row = service.del(id);
		logger.info("삭제한 갯수 : "+row);
		return "redirect:/list";
	}
	
	@RequestMapping(value="/detail")
	public String detail(@RequestParam String id, Model model) {
		MemberDTO dto = service.detail(id);
		model.addAttribute("member", dto);
		return "detail";
	}
	
	@RequestMapping(value="/updateForm")
	public String updateForm(Model model, @RequestParam String id) {
		model.addAttribute("member", service.detail(id));
		return "updateForm";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(Model mode, @RequestParam HashMap<String, String> params) {
		logger.info("params : "+params);
		String page = "redirect:/updateForm?id="+params.get("id");		
		if(service.update(params)>0) {
			page = "redirect:/detail?id="+params.get("id");			
		}
		return page;
	}
	
	

}
