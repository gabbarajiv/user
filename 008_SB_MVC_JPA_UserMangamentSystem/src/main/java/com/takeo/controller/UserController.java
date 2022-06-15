package com.takeo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.takeo.binding.User;
import com.takeo.service.impl.UserServiceImpl;

@Controller
public class UserController {
	@Autowired
	UserServiceImpl userService;

	@RequestMapping("/loadForm")
	public String loadForm(Model model) {
		User usr = new User();
		model.addAttribute("usr", usr);
		return "user";

	}

	@RequestMapping(value = "/usrInsert", method = RequestMethod.POST)
	public String handleForm(@ModelAttribute("usr") User usr, Model model) {
		boolean saveUser = userService.saveUser(usr);
		String check = "";
		String msg = "";
		if (saveUser) {
			msg = "User saved";
			check = "redirect:/viewUsers";
		} else {
			msg = "User not saved";
			check = "User";
		}
		model.addAttribute("msg", msg);
		return check;
	}

	@GetMapping("/viewUsers")
	public String viewAllUsers(Model model) {
		List<User> allUsers = userService.getAllUsers();
		model.addAttribute("users", allUsers);
		return "viewUsers";
	}

	@RequestMapping(value = "/edituser")
	public String edit(@RequestParam int id, Model m) {
		User usr = userService.getUserById(id);
		System.out.println(usr.getUno() + "\t" + usr.getUname() + "\t" + usr.getUemail() + "\t" + usr.getUpassword()
				+ "\t" + usr.getUaddress());
		m.addAttribute("product", usr);
		return "usereditform";

	}

	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public String editsave(@ModelAttribute("user") User usr, Model model) {
		System.out.println("updating:  " + usr.getUno() + "\t" + usr.getUname() + "\t" + usr.getUemail() + "\t"
				+ usr.getUpassword() + "\t" + usr.getUaddress());
		boolean isSaved = userService.updateUser(usr);
		String msg = "";
		System.out.println("Welcome to update" + isSaved);
		if (isSaved) {
			msg = "User updated Successfully";
		} else {
			msg = "Failed to update User";
		}

		model.addAttribute("msg", msg);
		return "redirect:/viewUsers";

	}

	@RequestMapping(value = "/deleteusr")
	public String delete(@RequestParam int id, Model model) {
		System.out.println("Welcome to deletion" + id);
		userService.deleteUser(id);

		return "redirect:/viewUsers";
	}

	@RequestMapping("/loginForm")
	public String loginForm(Model model) {
		User usrl = new User();
		model.addAttribute("usrl", usrl);
		return "loginForm";
	}

	@RequestMapping(value = "/usrLogin", method = RequestMethod.POST)
	public String handleloginForm(@ModelAttribute("usrl") User usrl, Model model) {

		String msg = "";
		String check = "loginForm";
		String e = usrl.getUemail();
		String p = usrl.getUpassword();
		boolean flag = userService.checkUserByEmailandPass(e, p);

		if (flag) {
			msg = "User logged in";
			model.addAttribute("msg", msg);
			check = "redirect:/viewUsers";

		} else {
			msg = "User not loggedIn";
			model.addAttribute("msg", msg);
			check = "loginForm";
		}
		return check;
	}

}
