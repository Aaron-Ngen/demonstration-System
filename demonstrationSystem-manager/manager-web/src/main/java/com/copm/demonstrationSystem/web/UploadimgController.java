package com.copm.demonstrationSystem.web;

import com.copm.demonstrationSystem.util.FileUtil;
import com.copm.demonstrationSystem.util.RandomID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Yuan Baiyu
 * @Date: Created in 14:15 2018/4/9
 */
@Controller
public class UploadimgController {

    public static final Logger logger = LoggerFactory.getLogger(UploadimgController.class);

    //跳转到上传文件的页面
    @RequestMapping(value="/gouploadimg", method = RequestMethod.GET)
    public String goUploadImg(HttpServletRequest request) {

        String filePath = request.getSession().getServletContext().getRealPath("/");
        System.out.println("filePath:  "+filePath);
        logger.info("==========【controller已被扫描！】===========");
        //跳转到 public 目录下的 uploadimg.html
        return "uploadimg";
    }

    //处理文件上传
    @ResponseBody
    @RequestMapping(value="/testuploadimg", method = RequestMethod.POST)
    public String uploadImg(@RequestParam("file") MultipartFile file,
                     HttpServletRequest request) {
        String contentType = file.getContentType();
        String temp = file.getOriginalFilename();
        String name = file.getOriginalFilename();
        String suffix = name.substring(name.lastIndexOf(".")+1);
        String fileName = RandomID.randomString()+"."+suffix;
        String filePath = "E:\\IntelliJ Idea-Pro\\demonstration-System\\demonstrationSystem-manager\\manager-web\\src\\main\\resources\\static\\image/";
        System.out.println("fileName:  "+fileName);
        try {
            FileUtil.uploadFile(file.getBytes(), filePath, fileName);
        } catch (Exception e) {
            // TODO: handle exception
        }
        //返回json
        return fileName;
    }

    @RequestMapping("/index")
    public String turnJsp(HttpServletRequest request){
        String filePath = request.getContextPath();
        System.out.println(filePath);
        return "index";
    }
}
