package com.test.controller;

import com.sun.javafx.scene.layout.region.Margins;
import com.test.bean.Orders;
import com.test.bean.User;
import com.test.service.UserService;
import com.test.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

//
//    /**
//     * @ModelAttribute("user"): 指定user对象放在request中的key值;
//     * 如果不用这个注解，springmvc的会把user对象放在request中，默认名字就是POJO的类名（首字母小写）
//     */
//    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
//    public String insertUser(@ModelAttribute("user") User user,
//                             @RequestParam(value = "headImgFile", required = false) MultipartFile[] multipartFiles,
//                             HttpServletRequest request) throws IOException {
//
//        // 获得物理路径webapp所在路径
//        String pathRoot = request.getSession().getServletContext().getRealPath("");
//        System.out.println("根目录：" + pathRoot);
//
//        // 普通字段信息
//        System.out.println("普通字段信息：" + user);
//
//        // 处理上传的文件
//        for (MultipartFile file : multipartFiles) {
//            if (!file.isEmpty()) {
//                // 生成文件的名称
//                String uuid = UUID.randomUUID().toString();
//                // 获得文件的类型（如果不是图片可以禁止上传）
//                String contentType = file.getContentType();
//                System.out.println("上传文件类型：" + contentType);
//                // 获取文件的后缀名称
//                String suffix = contentType.substring(contentType.indexOf("/") + 1);
//                // 生成存放文件的文件夹（按年月分类，分类存放可以提高IO）
//                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//                String fileFolderName = sdf.format(new Date());
//                // 存放文件的基本目录
//                String baseDir = "/Users/lsx/Desktop/upload/";
//                String fileName = uuid + "." + suffix;
//                String pathName = baseDir + fileFolderName + "/" + fileName;
//                System.out.println("图片路径名：" + pathName);
//                File imgFile = new File(pathName);
//                if (!imgFile.exists()) {
//                    imgFile.mkdirs();
//                }
//                file.transferTo(imgFile);
//            }
//
//        }
//        return "userInfo";
//    }

    /**
     * @RequestBody ：用于将HTTP请求中的json数据转换为java对象
     * @ResponseBody ：用于将返回值转化成Java对象
     */
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public @ResponseBody User addUser(@RequestBody User user){
        System.out.println("提交的数据：" + user);

        return user;
    }

}
