package com.guafindel.mvc.member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CookieController {

	@RequestMapping(value = "/cookie/makeForm")
	public String getMakeForm() {

		return "cookie/makeForm";
	}

	@RequestMapping("/cookie/makeCookie")
	public String makeCookie(@RequestParam(value = "cName", defaultValue = "none") String cookieName,
			@RequestParam(value = "cValue", defaultValue = "none") String cookieValue, HttpServletResponse response) {

		// 쿠키 생성
		Cookie cookie = new Cookie(cookieName, cookieValue);

		// 쿠키 전송
		response.addCookie(cookie);

		return "cookie/makeCookie";
	}

	@RequestMapping(value = "/cookie/viewCookie", method = RequestMethod.GET)
	public String selectCookie() {

		return "cookie/selectForm";
	}

	@RequestMapping(value = "/cookie/viewCookie", method = RequestMethod.POST)
	public String viewCookie(
			@CookieValue(value = "nicname", defaultValue = "none") String cValue,
			@RequestParam(value = "cName", required = false) String cName,
			HttpServletRequest request,
			Model model) {

		//model.addAttribute("cName", "nicname");
		//model.addAttribute("cValue", cValue);

		Cookie[] cookies = request.getCookies();

		for (int i = 0; i < cookies.length; i++) {
			if(cookies[i].getName().equals(cName)) {
				
				model.addAttribute("cName", cName);
				model.addAttribute("cValue", cValue);
			}
		}

		return "cookie/viewCookie";
	}
}
