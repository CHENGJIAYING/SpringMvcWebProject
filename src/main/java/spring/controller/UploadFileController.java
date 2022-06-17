package spring.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import spring.model.Picture;
import spring.model.PictureService;

@Controller
public class UploadFileController {
	
	@GetMapping("/uploadmain.controller")
	public String processMainAction() {
		return "uploadFile";
	}
	
	@PostMapping("/uploadfile.controller")
	@ResponseBody
	public String processAction(HttpServletRequest request, @RequestParam("myFiles") MultipartFile mf) throws IOException {
		String fileName = mf.getOriginalFilename();
		byte[] bytes = mf.getBytes();
		
		String saveDir = "c:/temp/upload";
		File saveFileDir = new File(saveDir);
		
		if(!saveFileDir.exists()) {
			saveFileDir.mkdirs();
		}
		
		String saveFilePath = saveDir + "/" + fileName; 
		
		File saveFile = new File(saveFileDir, fileName);
		//File saveFile = new File(saveFilePath);
		
		mf.transferTo(saveFile);
		
		if(fileName!=null && fileName.length()!=0) {
			saveFile(fileName, bytes);
		}
		
		return "saveFile:" + saveFile;
	}	
	
	@Autowired
	private PictureService pService;

	private void saveFile(String fileName, byte[] bytes) {
		Picture picture = new Picture(fileName, bytes);
		pService.insert(picture);
	}

}
