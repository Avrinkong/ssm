package ssm.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@Controller
public class localController implements ApplicationContextAware {

    @Autowired
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext arg0)
            throws BeansException {
        applicationContext = arg0;

    }

    @RequestMapping("guojihua2")
    public ModelAndView guojihua1(HttpServletRequest request, String langType) {
        // 返回的modelAndView
        ModelAndView modelAndView = new ModelAndView();

        org.apache.log4j.Logger logger= Logger.getLogger(loginController.class);
        // 判断语言类型，在页面显示不同的国际化版本
        String guojihua=null;

        if ("cn".equals(langType)) {

            // 配置本地信息
             guojihua = applicationContext.getMessage("guojihua", null, Locale.CHINA);

            logger.info(System.currentTimeMillis()+"1");
        } else if ("en".equals(langType)) {

           guojihua = applicationContext.getMessage("guojihua", null, Locale.US);
            logger.info(System.currentTimeMillis()+"2");
        }

        System.out.println(guojihua);
        logger.info(System.currentTimeMillis()+"4");
        // 后台保存值
        modelAndView.addObject("guojihua", guojihua);
        logger.info(System.currentTimeMillis()+"5");
        // 返回modelAndView
        modelAndView.setViewName("guojihua");
        logger.info(System.currentTimeMillis()+"6");
        return modelAndView;
    }
}
