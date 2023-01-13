package com.nissan.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nissan.dto.AppreciationDTO;
import com.nissan.dto.FetchUserDTO;
import com.nissan.dto.UserDTO;
import com.nissan.model.Appreciation;
import com.nissan.model.Role;
import com.nissan.model.Template;
import com.nissan.model.User;
import com.nissan.service.IAppreciationService;
import com.nissan.service.IRoleService;
import com.nissan.service.ITemplateService;
import com.nissan.service.IUserService;


@CrossOrigin		//Helps to Avoid CORS Error
@RestController
@RequestMapping("api/")
public class AppRestController
{
	//Field Injection
	@Autowired
	IUserService userService;
	
	@Autowired
	IRoleService roleService;
	
	@Autowired
	IAppreciationService appreciationService;
	
	@Autowired
	ITemplateService templateService;
	
	//List all Users
	@GetMapping("users")
	public List<User> findAllUser()
	{
		return userService.findAllUsers();
	}
	
	//List all Staffs
	@GetMapping("staffs")
	public List<FetchUserDTO> findAllStaffs()
	{
		return userService.findAllStaffs();
	}
	
	//List all Approvers
	@GetMapping("approvers")
	public List<FetchUserDTO> findAllApprovers()
	{
		return userService.findAllApprovers();
	}
	
	//Add User
	@PostMapping("user")
	public ResponseEntity<User> addUser(@RequestBody UserDTO userDTO)
	{
		System.out.println("Inserting a User Record");
		return new ResponseEntity<User>(userService.addUser(userDTO),HttpStatus.OK);
	}
	
	//Update User
	@PutMapping("users")
	public User updateUser(@RequestBody UserDTO userDTO)
	{
		System.out.println("Updating a User Record");
		User user = new User(userDTO);
		return userService.updateUser(user);
	}
	
	
	//Delete(Actually Disable) User
	@PutMapping("users/{userID}")
	public void deleteUser(@PathVariable int userID)
	{
		System.out.println("Disabling the record");
		userService.deleteUser(userID);
		//return userService.;
	}
	
	
	
	//List all Roles
	@GetMapping("roles")
	public List<Role> findAllRole()
	{
		return roleService.findAllRoles();
	}
	
	//Add Role
	@PostMapping("role")
	public Role addRole(@RequestBody Role role)
	{
		return roleService.addRole(role);
	}
	
	//List all Templates
	@GetMapping("templates")
	public List<Template> findAllTemplates()
	{
		return templateService.findAllTemplates();
	}
	
	//Add Templates
	@PostMapping("template")
	public Template addTemplate(@RequestBody Template template)
	{
		return templateService.addTemplate(template);
	}
	
	//Update Templates
	@PutMapping("template")
	public Template updateTemplate(@RequestBody Template template)
	{
		return templateService.updateTemplate(template);
	}
	
	//List all Appreciations
	@GetMapping("appreciations")
	public List<Appreciation> findAllAppreciations()
	{
		return appreciationService.findAllAppreciations();
	}

	//List all Appreciations filtered by roleID
	@GetMapping("appreciations/{email}&{roleID}")
	public List<Appreciation> findAllFilteredAppreciations(@PathVariable String email, @PathVariable int roleID)
	{
		return appreciationService.findAllFilteredAppreciations(email, roleID);
	}
	
	//List all Appreciations
	@GetMapping("appreciationsByApproval/{email}&{roleID}&{approved}")
	public List<Appreciation> findAllAppreciations(@PathVariable String email, @PathVariable int roleID, @PathVariable boolean approved)
	{
		return appreciationService.findAllAppreciationsByApproval(email, roleID, approved);
	}
	
	//Get Appreciation By ApprID
	@GetMapping("appreciation/{apprID}")
	public Optional<Appreciation> findAppreciationByApprID(@PathVariable int apprID)
	{
		return appreciationService.findAppreciationByApprID(apprID);
	}

	
	@GetMapping("userLogin/{email}&{password}")
	public User findUserByEmailAndPassword(@PathVariable String email, @PathVariable String password)
	{
		System.out.println("Inside Controller");
		return userService.findByEmailAndPassword(email, password);
	}
	
	
	
	//Add Appreciation
	@PostMapping("appreciation")
	public ResponseEntity<Appreciation> addAppreciation(@RequestBody AppreciationDTO appreciationDTO)
	{
		System.out.println("Inserting a Appreciation Record");
		return new ResponseEntity<Appreciation>(appreciationService.addAppreciation(appreciationDTO),HttpStatus.OK);
	}
	
	//Update Appreciation
	@PutMapping("appreciations/{apprID}")
	public void updateAppreciation(@PathVariable int apprID)
	{
		System.out.println("Approving an Appreciation Record");
		appreciationService.updateAppreciation(apprID);
	}
	
	//Disable Appreciation
	@DeleteMapping("appreciations/{apprID}")
	public void disableAppreciation(@PathVariable int apprID)
	{
		System.out.println("Disabling a Appreciation Record");
		appreciationService.disableAppreciation(apprID);
	}
}


