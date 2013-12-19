package it.ciavotta.Launcher.components;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;  
import org.springframework.validation.Validator;  

import it.ciavotta.Launcher.domain.UploadedFile;  
  
@Component("fileValidator")
public class FileValidator implements Validator {  
  
  
 @Override  
 public void validate(Object uploadedFile, Errors errors) {  
  
  UploadedFile file = (UploadedFile) uploadedFile;  
  
  if (file.getFile().getSize() == 0) {  
   errors.rejectValue("file", "uploadForm.salectFile", "Please select a file!");  
  }  
  
 }

@Override
public boolean supports(Class<?> arg0) {
	// TODO Auto-generated method stub
	return false;
}  
  
}  