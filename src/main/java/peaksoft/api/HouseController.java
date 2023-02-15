package peaksoft.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/house")
public class HouseController {
    @GetMapping
    public String getAllHouses(){
        return "index";
    }
    @GetMapping("/house/details")
    public String getDescription(){
        return "details";
    }
}
