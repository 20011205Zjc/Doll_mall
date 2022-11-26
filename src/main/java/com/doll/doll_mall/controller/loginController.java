package com.doll.doll_mall.controller;

import com.doll.doll_mall.DollMallApplication;
import com.doll.doll_mall.pojo.Goods;
import com.doll.doll_mall.pojo.User;
import com.doll.doll_mall.service.GoodsService;
import com.doll.doll_mall.service.UserService;
import com.doll.doll_mall.utils.MD5Util;
import com.doll.doll_mall.utils.VerCodeGenerateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;

/**
 * Author: rj-2022-zjc-2000005955
 * Time:2022/11/3 18:35
 */
@Controller
public class loginController {

    /*验证码的生成*/
    //掉用验证码生成的工具类
    String code = VerCodeGenerateUtil.generateVerCode();
    @Autowired
    private UserService userService;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    JavaMailSenderImpl mailSender;

    /*用户打开网页看到的*/
    @RequestMapping("/")
    public String test(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        Object loginUser = session.getAttribute("loginUser");
        Object merchant = session.getAttribute("merchant");
        model.addAttribute("merchant",merchant);
        Object userId = session.getAttribute("userId");
        model.addAttribute("userId",userId);
        Object tx = session.getAttribute("tx");
        System.out.println(loginUser);
        if (loginUser != null){
            model.addAttribute("index",loginUser);
            model.addAttribute("tx",tx);
        }else {
            model.addAttribute("index","注册/登录");
        }

        List<Goods> allGoods = goodsService.getAllGoods();
        model.addAttribute("allGoods",allGoods);

        /*工具推荐来显示*/
        List<Goods> goodsByRecommend = goodsService.getGoodsByRecommend();
        model.addAttribute("goodsByRecommend",goodsByRecommend);

        List<Goods> goodsBySalesVolume = goodsService.getGoodsBySalesVolume();
        model.addAttribute("goodsBySalesVolume",goodsBySalesVolume);

        return "index";
    }

    /*到登录页*/
    @RequestMapping("/goLogin")
    public String goLogin(Model model){
        model.addAttribute("msg","请先登录！");
        return "user/login";
    }

    @RequestMapping("/main")
    public String main(){
        return "goods/main";
    }

    /*登录检查*/
    @RequestMapping("/login")
    public String login(String username, String password, Model model, HttpSession session){

        String pwd = MD5Util.getMD5(password);

        List<User> allUser = userService.getAllUser();
        for (User user : allUser) {
            if (Objects.equals(user.getUserName(), username) && Objects.equals(user.getUserPassword(), pwd)){
                model.addAttribute("username",username);
                Integer userId = user.getUserId();
                session.setAttribute("userId",userId);
                String userGender = user.getUserGender();

                if (Objects.equals(user.getRoles(), "root")){
                    model.addAttribute("root","控制台");
                }

                /*登录后把用户的角色放进去*/
                if (Objects.equals(user.getRoles(), "merchant")){
                    session.setAttribute("merchant","商家控制台");
                }

                /*得到用户的id*/
                session.setAttribute("userId",user.getUserId());

                if (Objects.equals(user.getHeadPhoto(), "") || user.getHeadPhoto() == null){
                if (Objects.equals(userGender, "男")){
                    session.setAttribute("tx","/static/img/nan.png");
                }else if (Objects.equals(userGender, "女")){
                    session.setAttribute("tx","/static/img/nv.png");
                }else {
                    session.setAttribute("tx","/static/img/ta.png");
                }
                }else {
                    session.setAttribute("tx",user.getHeadPhoto());
                }
                session.setAttribute("loginUser",username);
                return "redirect:/";
            }
        }
        model.addAttribute("msg","用户名或密码错误！");
        return "user/login";

    }

    /*到注册页*/
    @RequestMapping("/register")
    public String register(){
        System.out.println("执行力");
        return "user/register";
    }
    /*发送邮箱验证码*/
    @RequestMapping("/getCode")
    @ResponseBody
    public String getCode(String email) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper= new MimeMessageHelper(mimeMessage,true);
        System.out.println(code);
        //设置邮寄的标题
        helper.setSubject("您的验证码为："+code);
        //设置邮件的内容
        helper.setText("您好!您的验证码为："+"<br><h2>"+code+"</h2><br>"+"千万不要告诉别人哟",true);
        //邮件发接受者
        helper.setTo(email);
        //邮件的发送者
        helper.setFrom("3150982110@qq.com");
        mailSender.send(mimeMessage);
        return code;
    }

    /*ajax查询用户名是否存在*/
    @RequestMapping("/repeat")
    @ResponseBody
    public String repeat(String username){
        System.out.println(username);
        List<User> allUser = userService.getAllUser();
        for (User user : allUser) {
            if (Objects.equals(user.getUserName(), username)){
                return user.getUserName();
            }
        }
        return "1";
    }
    /*ajax查询邮箱是否存在*/

    @RequestMapping("/eml")
    @ResponseBody
    public String eml(String email){

        List<User> allUser = userService.getAllUser();
        for (User user : allUser) {
            if (Objects.equals(user.getUserEmail(), email)){
                return "邮箱已存在，请登录！";
            }
        }
        return "1";
    }

    /*注册*/
    @RequestMapping("/adduser")
    public String addUser(User user,Model model){
        System.out.println(2233);
        String password = MD5Util.getMD5(user.getUserPassword());
        user.setUserPassword(password);
        System.out.println("注册的用户输出："+user);
        userService.insertUser(user);
        model.addAttribute("user",user.getUserName());
        return "user/login";
    }

    /*验证验证码是否正确*/
    @RequestMapping("/YZCode")
    @ResponseBody
    public String ReturnCode(String getCode){
        System.out.println("验证码执行了！");
        if (Objects.equals(code, getCode)){
            System.out.println("验证码为："+getCode);
            return "1";
        }else {
            return "2";
        }
    }

    /*个人信息页*/
    @RequestMapping("/user")
    public String user(Model model,HttpServletRequest request){
        HttpSession session = request.getSession();
        int userId =(int)session.getAttribute("userId");
        System.out.println(userId);
        List<User> userById = userService.getUserById(userId);
        for (User user : userById) {
            String userName = user.getUserName();
            String userAge = user.getUserAge();
            String userGender = user.getUserGender();
            String userEmail = user.getUserEmail();
            String userPassword = user.getUserPassword();
            String headPhoto = user.getHeadPhoto();
            model.addAttribute("userPassword",userPassword);
            model.addAttribute("userId",userId);
            model.addAttribute("userName",userName);
            model.addAttribute("userAge",userAge);
            model.addAttribute("userGender",userGender);
            model.addAttribute("userEmail",userEmail);
            model.addAttribute("headPhoto",headPhoto);
        }
        System.out.println(userById);
        return "user/UserDate";
    }

    /*退出登录*/
    @RequestMapping("/out")
    public String outUser(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("loginUser");
        session.removeAttribute("merchant");
//        System.out.println(request.);
        return "redirect:/";
    }
}

