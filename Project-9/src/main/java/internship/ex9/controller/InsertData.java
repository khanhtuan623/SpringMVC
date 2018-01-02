package internship.ex9.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import practice.sv.bai1.ReadFile;
import practice.sv.bai1.Student;
import sv.practice.mysql.Insert;

@Controller
public class InsertData extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@RequestMapping(value = "/insertData", method = RequestMethod.POST)
	public String insertData(HttpServletRequest request){
	 FileItemFactory fileItemFactory = new DiskFileItemFactory();
     ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
     try {
         List<FileItem> fileItems = upload.parseRequest(request);
         for (FileItem fileItem : fileItems) {
         		
             if (!fileItem.isFormField()) {
                 String fileName = fileItem.getName();
                 if (!fileName.equals("")) {
                     String dirUrl = request.getServletContext().getRealPath("") + "files";
                     File dir = new File(dirUrl);

                     if (!dir.exists()) {
                         dir.mkdir();
                     }

                     String fileImg = dirUrl + File.separator + fileName;
                     File file = new File(fileImg);

                     try {
                         fileItem.write(file);
                         System.out.println("Insert Database Successful!");
                     } catch (Exception e) {
                         System.out.println("Fail!");
                         e.printStackTrace();
                     }
                         List<Student> students = ReadFile.listStudent(dirUrl + File.separator + fileName);
                         	Insert.insertInfo((ArrayList<Student>) students);
                 }
                 else{
                 	System.out.println("Upload UnSuccessful!");
                 }
             }
         }
     } catch (FileUploadException e) {
         e.printStackTrace();
     }
		return "Optione";
	}
}
