/**
 * 
 */
package com.biz.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import com.biz.model.Student;

import redis.clients.jedis.Jedis;

/**
 * @author TangPeng
 *
 */
public class StudentDao {

	Jedis jedis = new Jedis("120.78.151.219",6379);
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String SCORE = "score";
	
	public void addStudent(Student student) {
		
		
		
		
		String format = sdf.format(student.getBirthday());
		jedis.hset(student.getId(),"id", student.getId());
		jedis.hset(student.getId(),"name", student.getName());
		jedis.hset(student.getId(),"birthday", format);
		jedis.hset(student.getId(),"description", student.getDescription());
		jedis.hset(student.getId(),"avgscore", String.valueOf(student.getAvgscore()) );
		
		jedis.zadd(SCORE, (student.getAvgscore()), student.getId());
		
	}
	
	public void deleteStudent(String id) {
		
		jedis.del(id);
	}
	
	
	public void updateStudent(Student student) {
		
		String format = sdf.format(student.getBirthday());
		jedis.hset(student.getId(),"id", student.getId());
		jedis.hset(student.getId(),"name", student.getName());
		jedis.hset(student.getId(),"birthday", format);
		jedis.hset(student.getId(),"description", student.getDescription());
		jedis.hset(student.getId(),"avgscore", String.valueOf(student.getAvgscore()) );
		
	}
	
	
	public List<Student> selectStudent(int a) {
		Set<String> hkeys = jedis.keys("*");
		Student student = new Student();
		
		if ((jedis.zcard(SCORE) - a *10)< 10){
			jedis.zrevrange(SCORE, a*10, -1);
		}
		
		List<Student> list = new ArrayList<Student>();		
		Iterator<String> iterator = hkeys.iterator();
		while (iterator.hasNext()) {

			String next = iterator.next();
			String id = jedis.hget(next, "id");
			String name = jedis.hget(next, "name");
			String birthday = jedis.hget(next, "birthday");
			String description = jedis.hget(next, "description");
			String avgscore = jedis.hget(next, "avgscore");
			
			student.setId(id);
			student.setName(name);
			try {
				student.setBirthday(sdf.parse(birthday));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			student.setDescription(description);
			student.setAvgscore(Integer.parseInt(avgscore));
			list.add(student);
			
		}
		return list;
		
	}
	
	
}
