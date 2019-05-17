package ssm.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ssm.model.Student;
import ssm.service.Study;

import java.util.List;

@Controller
public class loginController {
    @Autowired
    private  Study study;
    private Logger logger=Logger.getLogger(loginController.class);
    @RequestMapping(value = "/findByName",method = RequestMethod.POST)
    public String findByName(ModelMap model,Student student){
        logger.info("student is " +student.toString());
//
//       ApplicationContext applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(
//               ContextLoader.getCurrentWebApplicationContext().getServletContext());
//        Study study = (Study) applicationContext.getBean("studyImpl");
       // Study study = (Study) applicationContext.getBean("studyImpl");
        if (student.getStudent_Name()==null||student.getStudent_Name().trim().length()==0){
            model.addAttribute("message","登录错误");
            return "error";
        }
        if (student.getStudent_Qq()==null){
            model.addAttribute("message","登录错误");
            return "error";
        }
        List<Student> byName = study.findByName(student.getStudent_Name());
        for (Student student1:byName
             ) {
            if (student1.getStudent_Name().equals(student.getStudent_Name())){
                    if (student1.getStudent_Qq().equals(student.getStudent_Qq())){
                        model.addAttribute("message","登录成功");
                        return "success";
                }
            }
        }
        model.addAttribute("message","登录错误");
        return "error";
    }
}
