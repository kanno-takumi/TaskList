package part.time.clean_check;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController{
    @RequestMapping(value="/check-table")
    String check(){
        return "checktable";
    }
}
