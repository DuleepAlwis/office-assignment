package com.StudentManagementSystem.Service;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.StudentManagementSystem.entity.CourseContent;
import com.StudentManagementSystem.mapper.FileUploadMapper;

@Service
public class FileService {

	private FileUploadMapper fileMapper;
	
	@Value("${upload.path}")
    private String uploadPath;
	
	  public FileService(FileUploadMapper fileMapper) { 
		  this.fileMapper = fileMapper; 
	  }
	 
	public boolean saveFile(MultipartFile file,long csId) throws FileUploadException {
		 try {
			 Date date = Calendar.getInstance().getTime();  
			 DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh-mm-ss");  
			 String strDate = dateFormat.format(date);  
			 
	            Path root = Paths.get(uploadPath);
	            String pathToSave = csId+"_"+file.getOriginalFilename()+"_"+strDate;
	            Path resolve = root.resolve(pathToSave);
	            

	            if (resolve.toFile().exists()) {
	                throw new FileUploadException("File already exists: " + file.getOriginalFilename());
	            }
	            Files.copy(file.getInputStream(), resolve);
	            CourseContent cs = new CourseContent();
	            cs.setCourseId(csId);
	            cs.setDate(LocalDate.now());
	            cs.setFileName(file.getOriginalFilename());
	            cs.setLocation(String.valueOf(resolve));
	            this.fileMapper.saveFilePath(cs);
	            System.out.println(resolve);
	            return true;
	        } catch (Exception e) {
	            throw new FileUploadException("Could not store the file. Error: " + e.getMessage());
	            
	        }
	}
	
	public List<CourseContent> getFilesByCourseId(long csId){
		return this.fileMapper.getFilesByCourseID(csId);
	}
	
	public boolean removeFile(long fileId) {
		
		CourseContent cs = this.fileMapper.getFileById(fileId);
		 Path fileToDeletePath = Paths.get(cs.getLocation());
		 try {
			Files.delete(fileToDeletePath);
			System.out.println(fileId +" File deleted");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.fileMapper.removeFile(fileId);
	}
	
	public ResponseEntity downloadFile(long fileId) {
		
		CourseContent cs = this.fileMapper.getFileById(fileId);
		File file = new File(cs.getLocation());
        Path path = Paths.get(file.getAbsolutePath());
        System.out.println(file.getAbsolutePath());
        ByteArrayResource resource = null;
		try {
			resource = new ByteArrayResource(Files.readAllBytes(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return ResponseEntity.ok().headers(this.headers(cs.getFileName()))
              .contentLength(file.length())
                .contentType(MediaType
                 .parseMediaType("application/octet-stream"))
             .body(resource);
	}
	
	private HttpHeaders headers(String name) {

        HttpHeaders header = new HttpHeaders();
        header.add(HttpHeaders.CONTENT_DISPOSITION, 
                     "attachment; filename=" + name);
        header.add("Cache-Control", 
                     "no-cache, no-store, must-revalidate");
        header.add("Pragma", "no-cache");
        header.add("Expires", "0");
        return header;

    }
}
