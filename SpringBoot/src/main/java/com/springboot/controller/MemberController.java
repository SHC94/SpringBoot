package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.service.MemberService;
import com.springboot.vo.Member;

//스프링 컨테이너에
//@Controller가 붙은 MemberController 객체를 생성해서 넣어둠.
//스프링이 관리.
@Controller
public class MemberController {
	
	//의존성 주입 방법 3가지
	
//	1.필드 주입
//	@Autowired 
//	private final MemberService memberService;
//	수정 불가능.
	
//	2.setter 주입
//	private MemberService memberService;
//	public void setMemberService(MemberService memberService) {
//		this.memberService = memberService;
//	}
//	Public 하게 노출, 수정 시 문제 발생
	
//	3.생성자 주입
	private final MemberService memberService;
	
	//@Component Scan 패키지를 포함 하위 패키지의 @Component를 bean으로 등록
	//MemberController가 생성될 때 SpringBean으로 등록되어 있는 MemberService객체를 넣어줌. >>>>> DI
	@Autowired
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	//http://localhost:8080/members/new
	//url에 직접 입력하면 get방식..
	//조회
	@GetMapping("/members/new")
	public String createForm() {
		return "members/createMemberForm";
	}
	
	//데이터 전달
	@PostMapping("/members/new")
	public String create(MemberForm form) {
		Member member = new Member();
		member.setName(form.getName());
		System.out.println("member = " + member.getName());
		memberService.join(member);
		return "redirect:/";
	}
	
	@GetMapping("/members")
	public String list(Model model) {
		List<Member> members = memberService.findMembers();
		model.addAttribute("members", members);
		return "members/memberList";
	}
}//end class()
