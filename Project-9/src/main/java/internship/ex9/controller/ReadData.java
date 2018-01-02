package internship.ex9.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import practice.sv.bai1.Student;
import sv.practice.mysql.JDBCStatement;

@Controller
public class ReadData {
    @RequestMapping(value = "/read", method = RequestMethod.POST)
    public String showRead(HttpServletRequest request){
        List<Student> listStudents = JDBCStatement.readData();
        request.setAttribute("listStudent", listStudents);
        return "Show";
    }
}