package com.guafindel.mvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.guafindel.mvc.domain.GuestMessage;
import com.guafindel.mvc.domain.GuestMessageList;

@Controller
public class GuestListController {

	@RequestMapping(value = "/guest/xmlList.xml")
	@ResponseBody
	public GuestMessageList xmlList() {
		
		return getMessageList();
	}

	private GuestMessageList getMessageList() {
		
		List<GuestMessage> message = new ArrayList<GuestMessage>();
		
		message.add(new GuestMessage(1, "안녕하세요", new Date()));
		message.add(new GuestMessage(2, "반갑습니다", new Date()));
		message.add(new GuestMessage(3, "또만납시다", new Date()));
		
		
		return new GuestMessageList(message);
	}
	
	
}
