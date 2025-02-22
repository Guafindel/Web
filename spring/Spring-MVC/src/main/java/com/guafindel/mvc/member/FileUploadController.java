package com.guafindel.mvc.member;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.guafindel.mvc.domain.Report;

@Controller
public class FileUploadController {

	String path = "/uploadfile";

	@RequestMapping(value = "/fileupload/uploadForm")
	public String getForm() {

		return "fileupload/uploadForm";
	}

	@RequestMapping(value = "/fileupload/upload1", method = RequestMethod.POST)
	public String upload1(@RequestParam(value = "sno", defaultValue = "none", required = true) String sno,
			@RequestParam(value = "report", defaultValue = "none", required = false) MultipartFile file, Model model,
			HttpServletRequest request) {

		model.addAttribute("sno", sno);
		model.addAttribute("fileName", file.getOriginalFilename());
		model.addAttribute("fileSize", file.getSize());

		// 파일 저장
		String dir = request.getSession().getServletContext().getRealPath(path);
		System.out.println(dir);

		try {
			if (!file.isEmpty() && file.getSize() > 0) {
				file.transferTo(new File(dir, sno + " _ " + file.getOriginalFilename()));

			}
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "fileupload/upload";
	}

	@RequestMapping(value = "/fileupload/upload2", method = RequestMethod.POST)
	public String upload2(MultipartHttpServletRequest request, Model model) {

		String sno = request.getParameter("sno");
		MultipartFile file = request.getFile("report");

		model.addAttribute("sno", sno);
		model.addAttribute("fileName", file.getOriginalFilename());
		model.addAttribute("fileSize", file.getSize());

		return "fileupload/upload";
	}

	@RequestMapping(value = "/fileupload/upload3", method = RequestMethod.POST)
	public String upload3(Report report) {

		return "fileupload/upload";
	}
}
