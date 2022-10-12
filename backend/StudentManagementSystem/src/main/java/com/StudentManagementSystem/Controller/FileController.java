package com.StudentManagementSystem.Controller;

import java.util.List;

import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.StudentManagementSystem.Service.FileService;
import com.StudentManagementSystem.entity.CourseContent;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping(value="/file")
public class FileController {

	@Autowired
	FileService fs;
	
	@PostMapping(value="/saveFile")
	public boolean saveFile(@RequestParam("file") MultipartFile file,@RequestParam("csId") long csId) {
		try {
			return this.fs.saveFile(file, csId);
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	@GetMapping(value="/getCourseFiles/{csId}")
	public List<CourseContent> getFilesByCourseId(@PathVariable("csId") long csId){
		return this.fs.getFilesByCourseId(csId);
	}
	
	@DeleteMapping(value="/removeFile/{fileId}")
	public boolean removeFile(@PathVariable("fileId") long fileId) {
		return this.fs.removeFile(fileId);
	}
	
	@GetMapping(value="/downloadFile/{fileId}")
	public ResponseEntity<Byte[]> downloadFile(@PathVariable("fileId") long fileId) {
		return this.fs.downloadFile(fileId);
	}
}
