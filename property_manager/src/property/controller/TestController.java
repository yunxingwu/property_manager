package property.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	@RequestMapping("login.do")
	public String TestLogin(String username) {
		if ("hello".equals(username)) {
			return "success";
		}
		return "failed";

	}

	public static void main(String[] args) {
            String str = "fdsfd;fdfd;dfd;fd;fd;fdfd;";
            String [] s =str.split(";");
            for(int i = 0;i<s.length;i++){
            	System.out.println(s[i]);
            }
	}

}
