package ssm.controller;

import com.github.pagehelper.PageInfo;
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
@RequestMapping("Student")
public class addController {
    @Autowired
    private Study study;
    private org.apache.log4j.Logger logger= Logger.getLogger(loginController.class);
    @RequestMapping(value = "addStudent",method = RequestMethod.POST)
    public String addStudent(ModelMap model, Student student) {

        int i = study.addStudent(student);
        if (i > 0) {
            model.addAttribute("message","添加成功");
            return "success";
        }
        model.addAttribute("message","添加失败");
        return "error";
    }

    @RequestMapping(value = "deleteStudent")
    public String deleteStudent(ModelMap model,Integer student_Id ){
        boolean delete = study.delete(student_Id);
        if (delete){
            model.addAttribute("message","删除成功");
            return "success";
        }
        model.addAttribute("message","删除失败");
        return "error";
    }

    @RequestMapping(value = "updateStudent",method = RequestMethod.POST)
    public String updateStudent(ModelMap model,Student student){
        boolean update = study.update(student);
        if (update){
            model.addAttribute("message","修改成功");
            return "success";
        }
        model.addAttribute("message","修改失败");
        return "error";
    }

    @RequestMapping(value = "findAllStudent",method = RequestMethod.POST)
    public String findAllStudent(ModelMap model,int currentPage,int pageSize){



        PageInfo<Student> byPage = study.findByPage(currentPage,pageSize);
        logger.info(byPage.getEndRow());
        logger.info(byPage.getTotal());
        List<Student> list = byPage.getList();

        if((currentPage+pageSize-1)<=byPage.getTotal()){
            model.addAttribute("byPage",byPage);
            model.addAttribute("list",list);
            model.addAttribute("message","查询成功");
            return "find";
        }
        model.addAttribute("message","查询失败");
        return "error";
    }

    @RequestMapping(value = "findAll",method = RequestMethod.POST)
    public String findAll(ModelMap model,int currPage,int pageSize){

        int total = study.queryCount();
        int totalPage = (int) Math.ceil(total / pageSize)+1;
        model.addAttribute("total",total);
        model.addAttribute("totalPage",totalPage);
        model.addAttribute("currPage",currPage);
        model.addAttribute("pageSize",pageSize);
        if (currPage<1||pageSize>40){
            model.addAttribute("message","message");
            return "error";
        }
        if (totalPage<currPage){
            model.addAttribute("message","message");
            return "error";
        }
        List<Student> list = study.findAll(currPage, pageSize);
        model.addAttribute("list",list);
        return "show";
    }

  /*  @RequestMapping("/")
    public  String log(){
        return "login";
    }*/
}
