package it.ciavotta.Launcher.domain;

import org.springframework.web.multipart.MultipartFile;  

public class UploadedFile {  
  
 private MultipartFile file;  
  
 public MultipartFile getFile() {  
  return file;  
 }  
  
 public void setFile(MultipartFile file) {  
  this.file = file;  
 }  
}  