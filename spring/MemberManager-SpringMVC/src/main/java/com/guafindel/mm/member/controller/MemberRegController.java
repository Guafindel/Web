package com.guafindel.mm.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.guafindel.mm.member.domain.RequestMemberRegist;
import com.guafindel.mm.member.service.MailSenderService;
import com.guafindel.mm.member.service.MemberRegService;

@Controller
@RequestMapping(value = "/member/regist")
public class MemberRegController {
	
	@Autowired
	private MemberRegService registService;
	
	@Autowired
	private MailSenderService mailSenderService;

	@RequestMapping(method = RequestMethod.GET)
	public String getForm() {
		
		return "member/registForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String memberRegist(
			RequestMemberRegist regist,
			HttpServletRequest request,
			Model model
			) {
		
		System.out.println(regist);
		
		model.addAttribute("rCnt", registService.memberInsert(request, regist));
		
		//mailSenderService.send(regist.getmId());
		
		return "member/regist";
	}
		
}
