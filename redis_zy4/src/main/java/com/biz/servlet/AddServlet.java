package com.biz.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biz.dao.StudentDao;
import com.biz.model.Student;

@WebServlet("/add")
public class AddServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String birthday = req.getParameter("birthday");
		String description = req.getParameter("description");
		String avgscore = req.getParameter("avgscore");
		
		Student student = new Student();
		student.setId(id);
		student.setName(name);
		student.setDescription(description);
		student.setAvgscore(Integer.parseInt(avgscore));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			student.setBirthday(sdf.parse(birthday));
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		StudentDao studentDao = new StudentDao();
		studentDao.addStudent(student);
		
	}

	
}
