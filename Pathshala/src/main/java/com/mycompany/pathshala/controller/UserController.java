package com.mycompany.pathshala.controller;

import com.mycompany.pathshala.command.ClassCommand;
import com.mycompany.pathshala.command.LoginCommand;
import com.mycompany.pathshala.command.UserCommand;
import com.mycompany.pathshala.dao.ClassDao;
import com.mycompany.pathshala.dao.StudentDao;
import com.mycompany.pathshala.dao.UserDAO;
import com.mycompany.pathshala.domain.ClassRoom;
import com.mycompany.pathshala.domain.Student;
import com.mycompany.pathshala.domain.User;
import com.mycompany.pathshala.exception.UserBlockedException;
import com.mycompany.pathshala.services.UserService;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private ClassDao classDao;
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private StudentDao studentDao;

    
    @RequestMapping(value = {"/","/index"})
    public String index(Model m){
        //m.addAttribute("command", new LoginCommand());
        return "home";
    }
    
    @RequestMapping(value = {"/loginPage"})
    public String loginPage(Model m){
        //m.addAttribute("command", new LoginCommand());
        return "login_page";
    }
    
    @RequestMapping(value = {"/registrationPage"})
    public String registrationPage(Model m){
        //m.addAttribute("command", new LoginCommand());
        return "registration_page";
    }
    
    @RequestMapping(value = {"/contactUsPage"})
    public String contactUsPage(Model m){
        //m.addAttribute("command", new LoginCommand());
        return "contact_us_page";
    }
    
    @RequestMapping(value = {"/aboutUsPage"})
    public String aboutUsPage(Model m){
        //m.addAttribute("command", new LoginCommand());
        return "about_us_page";
    }
    
    @RequestMapping(value = {"/l"})
    public String lPage(@RequestParam("name") String name,@RequestParam("pass") String pass,Model m){
        //m.addAttribute("command", new LoginCommand());
        m.addAttribute("name", name);
        m.addAttribute("pass", pass);
        
        return "newjsp";
    }
    
    
    //Login
    
    @RequestMapping(value="/login")
    public String handleLogin(@RequestParam("name") String name,@RequestParam("pass") String pass, Model m, HttpSession session){
        LoginCommand cmd=new LoginCommand();
        cmd.setLoginName(name);
        cmd.setPassword(pass);
        try {
            
            User loggedInUser =  userService.login(cmd.getLoginName(),cmd.getPassword());
            if(loggedInUser == null){
                m.addAttribute("err","Login Failed! Enter valid username or password");
                return "index";
            }
            else{
        
                if(loggedInUser.getRole().equals(UserService.ROLE_ADMIN)){
                    //session.invalidate();
                    addUserInSession(loggedInUser, session);
                    return "redirect:admin/dashboard";
                }
                else if(loggedInUser.getRole().equals(UserService.ROLE_USER)){
                    //session.invalidate();
                    addUserInSession(loggedInUser, session);
                    return "redirect:user/dashboard";
                }
                else{
                    m.addAttribute("err","Invalid user role");
                    return "index";
                }
            }
        } catch (UserBlockedException ex) {
            //add error message and go back to login-form
            m.addAttribute("err", ex.getMessage());
            return "index"; // JSP - login form
        }
    }
    
    @RequestMapping(value ="/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:index?action=logout";
    }
    
     @RequestMapping(value ="/user/dashboard")
    public String userDashboard(){
        return "dashBoard_user";
    }
     @RequestMapping(value ="/admin/dashboard")
    public String adminDashboard(){
        return "dashboard_admin";
    }
    
    @RequestMapping(value ="/admin/users")
    public String getUserList(Model m){
        m.addAttribute("userList", userService.getUserList());
        return "users";
    }
    
    @RequestMapping(value = "/reg_form")
    public String registrationForm(Model m){
        UserCommand cmd = new UserCommand();
        m.addAttribute("command",cmd);
        return "reg_form";//JSP
    }
    
    
    @RequestMapping(value = "/register")
    public String registerUser(@RequestParam("name") String name,@RequestParam("pass") String pass,@RequestParam("address") String address,@RequestParam("phone") String phone,@RequestParam("uname") String uname,@RequestParam("email") String email,Model m){
        try{
        User user=new User(name, phone, email, address, uname, pass);
        
       user.setRole(UserService.ROLE_USER);
       user.setLoginStatus(UserService.LOGIN_STATUS_ACTIVE);
       userService.register(user);
        return "redirect:index?action=reg";
    }catch(DuplicateKeyException ex){
        
        ex.printStackTrace();
        m.addAttribute("err", "Username is already registered. Please selet another username");
        return "reg_form";//JSP
    }
    }
    
    
    private void addUserInSession(User u, HttpSession session){
        session.setAttribute("user", u);
        session.setAttribute("userId", u.getUserId());
        session.setAttribute("role", u.getRole());
        session.setAttribute("loginName", u.getLoginName());
    }

    @RequestMapping(value = "/admin/change_status")
    @ResponseBody
    public String changeLoginStatus(@RequestParam Integer userId, @RequestParam Integer loginStatus){
       try{ 
        userService.changeLoginStatus(userId, loginStatus);
        return "SUCCESS: Status Changed";
       }catch(Exception e){
           e.printStackTrace();
           return "ERROR: Unable to Change Status";
       }
    }
    
    @RequestMapping(value ="/user/dashboard/create_classroom")
    public String createClassroom(Model m){
        ClassCommand cmd=new ClassCommand();
        m.addAttribute("command",cmd);
        return "create_classroom";//JSP
    }
    
   @RequestMapping(value = "/user/dashboard/create_classroom/save")
    public String crateClassSave(@ModelAttribute("command") ClassCommand cmd,Model m){
     try{
         ClassRoom classRoom=cmd.getClassRoom();
         classDao.save(classRoom);
        return "redirect:/user/dashboard/classList";
    }catch(DuplicateKeyException ex){
        
        ex.printStackTrace();
        m.addAttribute("err", "Username is already registered. Please selet another username");
        return "dashBoard_user";//JSP
    }
    }
    
    @RequestMapping(value = {"/user/dashboard/classList"})
    public String classList(Model m,HttpSession session) {
        List<Student> students= studentDao.findByProperty("student_name", session.getAttribute("loginName"));
        List<ClassRoom> classes=new ArrayList<>();
        for(int i=0;i<students.size();i++){
            classes.add(classDao.findById(students.get(i).getCourse_id()));
        }
        //List<ClassRoom> classes= classDao.findAll();
        m.addAttribute("classes", classes);
        m.addAttribute("students", students);
        return "classList";
    }
    
    
    // manage
    @RequestMapping(value = {"/user/dashboard/editClassList"})
    public String editClassList(Model m, HttpServletRequest request) {
        m.addAttribute("cNo", request.getParameter("courseNo"));
        m.addAttribute("cName", request.getParameter("courseName"));
        m.addAttribute("id", request.getParameter("id"));
        
        List<Student> students= studentDao.findByProperty("course_id", request.getParameter("id"));
        m.addAttribute("students", students);
        return "class_manage";
    }
  
    @RequestMapping(value = {"/user/dashboard/addStudent"})
    public String addStudent(@RequestParam("u_id") String id,@RequestParam("student") String st, Model m, HttpServletRequest request) {
        m.addAttribute("st", st); 
        m.addAttribute("id", id); 
        
        try{
            User user = userDAO.findByName(st);
            studentDao.save(new Student(Integer.parseInt(id),st));
            return "redirect:/user/dashboard/editClassList";
            
        }
        catch(EmptyResultDataAccessException dataAccessException)
        {
            return "newjsp";
        }
    }
    
    
    // Enrolled Classlist
    @RequestMapping(value = {"/user/dashboard/myClassList"})
    public String myClassList(Model m,HttpSession session) {
        /*
        List<Student> students= studentDao.findByProperty("student_name", session.getAttribute("loginName"));
        List<ClassRoom> classes=new ArrayList<>();
        for(int i=0;i<students.size();i++){
            classes.add(classDao.findById(students.get(i).getCourse_id()));
        }
        //List<ClassRoom> classes= classDao.findAll();
        m.addAttribute("classes", classes);
        m.addAttribute("students", students);
        */
         List<ClassRoom> classes= classDao.findByProperty("instructor", session.getAttribute("userId"));
        //List<ClassRoom> classes= classDao.findAll();
        m.addAttribute("classes", classes);
        return "myClassList";
    }
    
    
    @RequestMapping(value = {"/user/dashboard/enrollManage"})
    public String editEnrollManageList(Model m, HttpServletRequest request) {
        m.addAttribute("cNo", request.getParameter("courseNo"));
        m.addAttribute("cName", request.getParameter("courseName"));
        m.addAttribute("id", request.getParameter("id"));
        
        List<Student> students= studentDao.findByProperty("course_id", request.getParameter("id"));
        m.addAttribute("students", students);
        return "enroll_manage";
    }
    
    //discussion
        @RequestMapping(value = {"/user/dashboard/disc"})
        public String discussionList(Model m, HttpServletRequest request) {
        
        return "enroll_manage";
    }
}