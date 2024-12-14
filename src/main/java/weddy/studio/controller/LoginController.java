package weddy.studio.controller;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Value("${kakao.client_id}")
    private String client_id;

    @Value("${kakao.redirect_uri}")
    private String redirect_uri;

    @GetMapping("/page")
    public String loginPage(Model model) {
        String location = "https://kauth.kakao.com/oauth/authorize?response_type=code&client_id="+client_id+"&redirect_uri="+redirect_uri;
        model.addAttribute("location", location);

        return "login";
    }
    //https://kauth.kakao.com/oauth/authorize?response_type=code&client_id=0699e50c84424b8dcd047eb46166c242&redirect_uri=http://localhost:8080/login/oauth2/code/kakao
    //http://localhost:8080/login/oauth2/code/kakao?
    //code=dcf0XjpiNy8oYa__AcPhUndqNHQMcf4SHnGduwxY2vlMasVeufFqKQAAAAQKPXQRAAABk8XHJQlb9Pmr5eg_ZA
}
