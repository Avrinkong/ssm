package ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Locale;
@Controller
public class problemController {

    @Autowired
    private ApplicationContext context;
    @RequestMapping("problem")
    public ModelAndView  problem(){

        ModelAndView modelAndView = new ModelAndView();
        String message = context.getMessage("problem",null, Locale.US);
        System.out.println(message);
        modelAndView.addObject("problem",message);
        modelAndView.setViewName("guojihua");
        return modelAndView;
    }
}
