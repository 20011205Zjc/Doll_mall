package com.doll.doll_mall.controller;

import com.doll.doll_mall.pojo.User;
import com.doll.doll_mall.service.UserService;
import com.doll.doll_mall.utils.QiniuUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * Author: rj-2022-zjc-2000005955
 * Time:2022/11/8 9:38
 */
@Controller
public class updateUserController {
    @Autowired
    private UserService userService;

    /**
     * 修改用户信息
     * @param user
     * @param request
     * @return 最后转发请求到用户信息页
     */
    @RequestMapping("/getUser")
    public String update(User user,HttpServletRequest request){
        userService.updateUserByIf(user);
        HttpSession session = request.getSession();
        session.removeAttribute("tx");
        session.setAttribute("tx",user.getHeadPhoto());
        session.removeAttribute("loginUser");
        session.setAttribute("loginUser",user.getUserName());
        return "redirect:/user";
    }

    /*图片上传并回显*/

    /**
     * 图片上传并回显
     * @param file
     * @param
     * @return 返回的是img的src属性也就是图片在七牛云的外连接
     */
    @RequestMapping("/PhotoUp")
    @ResponseBody
    public String Photo(MultipartFile file){
        String originalFilename = file.getOriginalFilename();
        String substring = originalFilename.substring(originalFilename.lastIndexOf("."));//取出图片的后缀名
        String fileName = UUID.randomUUID().toString() + substring;//UUID加后缀名
        //将图片上传到七牛云
        try {
            QiniuUtils.upload2Qiniu(file.getBytes(),fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        return "http://zjc-img.online/"+fileName;
        return "http://rknousjbx.hd-bkt.clouddn.com/"+fileName;
    }

    /*ajax查询用户的信息*/
    @RequestMapping("/getU")
    @ResponseBody
    public String getU(Object userId){
        int id = (int)userId;
        List<User> userById = userService.getUserById(id);
        System.out.println("图片："+userById);
        for (User user : userById) {
            String headPhoto = user.getHeadPhoto();
            System.out.println(headPhoto);
            return headPhoto;
        }
        return null;
    }

}
