package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping(value = "/")
	public String showUserTable(ModelMap model) {
		model.addAttribute("users", userService.getUsersList());
		return "index";
	}

	@GetMapping(value = "/addUserForm")
	public String showAddUserForm(ModelMap model) {
		model.addAttribute("user", new User());
		return "addUser";
	}

	@DeleteMapping(value = "/deleteUser")
	public String deleteUser(@ModelAttribute("user") User user) {
		userService.deleteUser(user);
		return "redirect:/";
	}

	@GetMapping(value = "/editUserForm")
	public String showEditPage(ModelMap model, @RequestParam long id) {
		model.addAttribute("user", userService.getUser(id));
		return "editUser";
	}

	@PostMapping(value = "/addUser")
	public String saveUser(@ModelAttribute("user") User user) {
		userService.saveUser(user);
		return "redirect:/";
	}

	@PutMapping(value = "/editUser")
	public String editUser(@ModelAttribute("user") User user) {
		userService.saveUser(user);
		return "redirect:/";
	}
}