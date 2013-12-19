package it.ciavotta.Launcher.controller;

import java.io.File;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.io.InputStream;  
import java.io.OutputStream;  
  





import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.core.env.Environment;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;  
import org.springframework.validation.BindingResult;  
import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.multipart.MultipartFile;  
import org.springframework.web.servlet.ModelAndView;  
  





import it.ciavotta.Launcher.components.FileValidator;
import it.ciavotta.Launcher.domain.UploadedFile;  
  
@Controller  
public class UploadController {  
  
 @Autowired  
 FileValidator fileValidator;  
 
 @Autowired
 Environment environment;
 
 @Autowired
 ServletContext servletContext;
  
 @RequestMapping("/fileUploadForm")  
 public ModelAndView getUploadForm(  
   @ModelAttribute("uploadedFile") UploadedFile uploadedFile,  
   BindingResult result) {  
  return new ModelAndView("uploadForm");  
 }  
  
 @RequestMapping("/fileUpload")  
 public ModelAndView fileUploaded( @ModelAttribute("uploadedFile") UploadedFile uploadedFile,  
   BindingResult result, HttpServletRequest httpServletRequest) {  
  InputStream inputStream = null;  
  OutputStream outputStream = null;  
  
  MultipartFile file = uploadedFile.getFile();  
  fileValidator.validate(uploadedFile, result);  
  
  String fileName = file.getOriginalFilename();  
  
  if (result.hasErrors()) {  
   return new ModelAndView("uploadForm");  
  }  
  
  try {  
   inputStream = file.getInputStream();  
  
   String name = httpServletRequest.getUserPrincipal().getName();
   File dir = new File(servletContext.getRealPath("/resources/Experiments/") +"/"+name +"/");
   if (!dir.exists()) {
	   dir.mkdir();
   }
   
   File newFile = new File(dir.getAbsolutePath()+"/"+fileName);
   
   if (!newFile.exists()) {  
    newFile.createNewFile();  
   }  
   outputStream = new FileOutputStream(newFile);  
   int read = 0;  
   byte[] bytes = new byte[1024];  
  
   while ((read = inputStream.read(bytes)) != -1) {  
    outputStream.write(bytes, 0, read);  
   }  
   outputStream.close();
  } catch (IOException e) {  
   // TODO Auto-generated catch block  
   e.printStackTrace();  
  }  
  
  return new ModelAndView("showFile", "message", fileName);  
 }  
  
}  