package cn.com.chnsys.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.chnsys.pojo.User;
import cn.com.chnsys.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userservice;
	/**
	 * 日志打印
	 */
	private static Logger logger = LoggerFactory.getLogger(UserController.class);
	/**
	 * 登录
	 * @param user
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/login")
	public String login(User user,Model model,HttpSession session) throws Exception{
		System.out.println("===用户名==="+user.getName()+"====密码===="+user.getPwd());
		List<User> users = userservice.login(user);
		System.out.println(users.toString());
		if(users.size()>0){
			session.setAttribute("name", user.getName());
			return "/user/index";
		}
		return "/error";
	}
	/**
	 * 查询所有
	 * @param user
	 * @param model
	 * @return user
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String list(Model model){
		List<User> list = userservice.findAllUser();
		model.addAttribute("list", list);
		return "user/list";
	}
	/**
	 * 跳转到添加用户页面
	 * @return
	 */
	@RequestMapping("addUser")
	public void addUser(){}
	/**
	 * 新增用户
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping(method=RequestMethod.POST)
	public String addUser(User user,Model model){
			userservice.save(user);
			model.addAttribute("list", userservice.findAllUser());
			return "user/list";
	}
	/**
	 * 删除用户
	 * @param id
	 * @return 向前端发送消息 suc代表删除成功
	 */
	@ResponseBody
	@RequestMapping(method=RequestMethod.DELETE,value="{id}")
	public String delUser(@PathVariable("id") int id){
		System.out.println("========"+id);
		boolean flag = userservice.delUser(id);
		if(flag){
			return "suc";
		}
		return "/error";
	}
	/**
	 * 查看用户详情
	 * @param id
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET,value="{id}")
	public String view(@PathVariable("id")int id,Model model){
		User user = userservice.findById(id);
		model.addAttribute("user",user);
		return "user/view";
	}
	/**
	 * 跳转到更新界面
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("{id}/edit")
	public String toEdit(@PathVariable("id") int id,Model model){
		User user = userservice.findById(id);
		model.addAttribute("user", user);
		return "user/edit";
	}
	/**
	 * 更新用户
	 * @param user
	 * @return
	 */
	@ResponseBody
	@RequestMapping(method=RequestMethod.PUT,value="{id}",produces = "application/text; charset=utf-8")
	public String edit(@PathVariable("id") int id,@RequestBody String body,User user){
		System.out.println("body++++++++++++++"+body);
		String s[]=body.split("&");
		for(int i=0;i<s.length;i++){
			String u[]=s[i].split("=");
			for (int j = 0; j < u.length; j++) {
				if(u[j].equals("name")){
					user.setName(u[j+1]);
				}
				if(u[j].equals("pwd")){
					user.setPwd(u[j+1]);
				}
				if(u[j].endsWith("age")){
					int age =Integer.parseInt(u[j+1]);
					user.setAge(age);
				}
				if(u[j].equals("phone")){
					user.setPhone(u[j+1]);
				}
			}
		}
		userservice.updateUser(user);
		return "success";
	}
	/**
	 * 验证失败
	 * 更新用户(不使用@RequestBody)
	 */
	/*@RequestMapping(value="{id}",method=RequestMethod.PUT)
	public String edit(@PathVariable("id") int id,@RequestParam String name,@RequestParam String pwd,@RequestParam int age,@RequestParam String phone){
		System.out.println(id+name+pwd+age+phone);
		User user = new User();
		if(!name.isEmpty()){
			user.setName(name);
		}
		if(!pwd.isEmpty()){
			user.setPwd(pwd);
		}
		if(age>=0&&age<=120){
			user.setAge(age);
		}
		if(!phone.isEmpty()){
			user.setPhone(phone);
		}
		userservice.updateUser(user);
		return "success";
	}*/
}
