package property.controller.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import property.entity.Manager;
import property.service.UserService;

@Controller
public class Login {
	@Autowired
	private UserService a;

	@RequestMapping("login.do")
	public String Testlogin(String username, String password) {
		Manager m = new Manager();
		m = a.checkLogin(username, password);
		if (m != null) {
			return "page/success";
		} else {
			return "page/failed";
		}

	}

}
