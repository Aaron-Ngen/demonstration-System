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
        //上传文件默认名字
        String name = file.getOriginalFilename();
        //文件后缀截取
        String suffix = name.substring(name.lastIndexOf(".")+1);
        //随机字符串，自定义文件名
        String fileName = RandomID.randomString()+"."+suffix;
        //存储路径，绝对路径
        String filePath = "E:\\IntelliJ Idea-Pro\\demonstration-System\\demonstrationSystem-manager\\manager-web\\src\\main\\resources\\static\\image/";

        System.out.println("fileName:  "+fileName+" || "+"contentType:  "+contentType);
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
