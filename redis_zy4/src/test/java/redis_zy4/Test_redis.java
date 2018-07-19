/**
 * 
 */
package redis_zy4;

import java.util.Date;

import org.junit.Test;

import com.biz.dao.StudentDao;
import com.biz.model.Student;

import redis.clients.jedis.Jedis;

/**
 * @author TangPeng
 *
 */
public class Test_redis {
	
	
	
	@Test
	public void name() {
		StudentDao studentDao = new StudentDao();
		studentDao.selectStudent();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StudentDao studentDao = new StudentDao();
		Student student = new Student("2", "李四", new Date(), "备注", 95);
		studentDao.addStudent(student);
		Jedis jedis = new Jedis("120.78.151.219",6379);
		System.out.println(jedis.hget(student.getId(), "name"));
		//jedis.set("1", "21");
		//System.out.println(jedis.get("1"));
		jedis.close();

	}

}
