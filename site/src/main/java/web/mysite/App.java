package  mysite;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Hello world!
 *
 */
@Controller
@EnableAutoConfiguration
public class App {

    @Resource
    private JdbcTemplate jdbcTemplate;
	@GetMapping("to_basic")
	private String jumpToBasic(Map<String, Object> map) {
		map.put("name", "昂首千秋远,笑傲风间,堪寻敌手共论剑,高处不胜寒");
		// TODO Auto-generated method stub
		return "/basic";

	}
	@GetMapping("/")
	private String basic(Map<String, Object> map) {
		map.put("name", "昂首千秋远,笑傲风间,堪寻敌手共论剑,高处不胜寒");
		// TODO Auto-generated method stub
		contextLoads();
		return "/index";

	}
	 public static void main(String[] args) throws Exception {
	        SpringApplication.run(App.class, args);
	    }
	 
	 
	 public void contextLoads() {
	        String sql = "select * from test_user";
	        List<Map<String, Object>> lst =  jdbcTemplate.queryForList(sql);
	           
	        for (Map<String, Object> user : lst) {
	        	System.out.println(user);
	        }
	    }
	 
	 
}
