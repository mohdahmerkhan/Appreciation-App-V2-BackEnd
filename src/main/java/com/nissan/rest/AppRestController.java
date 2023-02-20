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
import com.nissan.dto.CommentDTO;
import com.nissan.dto.FetchUserDTO;
import com.nissan.dto.LikeDTO;
import com.nissan.dto.UserDTO;
import com.nissan.model.Appreciation;
import com.nissan.model.Comment;
import com.nissan.model.Like;
import com.nissan.model.Role;
import com.nissan.model.Template;
import com.nissan.model.User;
import com.nissan.service.IAppreciationService;
import com.nissan.service.IRoleService;
import com.nissan.service.ITemplateService;
import com.nissan.service.IUserService;

@CrossOrigin // Helps to Avoid CORS Error
@RestController
@RequestMapping("api/")
public class AppRestController {
	// Field Injection
	@Autowired
	IUserService userService;

	@Autowired
	IRoleService roleService;

	@Autowired
	IAppreciationService appreciationService;

	@Autowired
	ITemplateService templateService;

	// List all Users
	@GetMapping("users")
	public List<User> findAllUser() {
		return userService.findAllUsers();
	}

	// List all Staffs
	@GetMapping("staffs")
	public List<FetchUserDTO> findAllStaffs() {
		return userService.findAllStaffs();
	}

	// List all Approvers
	@GetMapping("approvers")
	public List<FetchUserDTO> findAllApprovers() {
		return userService.findAllApprovers();
	}

	// Add User
	@PostMapping("user")
	public ResponseEntity<User> addUser(@RequestBody UserDTO userDTO) {
		System.out.println("Inserting a User Record");
		return new ResponseEntity<User>(userService.addUser(userDTO), HttpStatus.OK);
	}

	// Update User
	@PutMapping("users")
	public User updateUser(@RequestBody UserDTO userDTO) {
		System.out.println("Updating a User Record");
		User user = new User(userDTO);
		return userService.updateUser(user);
	}

	// Delete(Actually Disable) User
	@PutMapping("users/{userID}")
	public void deleteUser(@PathVariable int userID) {
		System.out.println("Disabling the record");
		userService.deleteUser(userID);
		// return userService.;
	}

	// List all Roles
	@GetMapping("roles")
	public List<Role> findAllRole() {
		return roleService.findAllRoles();
	}

	// Add Role
	@PostMapping("role")
	public Role addRole(@RequestBody Role role) {
		return roleService.addRole(role);
	}

	// List all Templates
	@GetMapping("templates")
	public List<Template> findAllTemplates() {
		return templateService.findAllTemplates();
	}

	// Add Templates
	@PostMapping("template")
	public Template addTemplate(@RequestBody Template template) {
		return templateService.addTemplate(template);
	}

	// Update Templates
	@PutMapping("template")
	public Template updateTemplate(@RequestBody Template template) {
		return templateService.updateTemplate(template);
	}

	// List all Appreciations
	@GetMapping("appreciations")
	public List<Appreciation> findAllAppreciations() {
		return appreciationService.findAllAppreciations();
	}

	// List all Appreciations filtered by roleID
	@GetMapping("appreciations/{email}&{roleID}")
	public List<Appreciation> findAllFilteredAppreciations(@PathVariable String email, @PathVariable int roleID) {
		return appreciationService.findAllFilteredAppreciations(email, roleID);
	}

	// List all Appreciations
	@GetMapping("appreciationsByApproval/{email}&{roleID}&{approved}")
	public List<Appreciation> findAllAppreciations(@PathVariable String email, @PathVariable int roleID,
			@PathVariable boolean approved) {
		return appreciationService.findAllAppreciationsByApproval(email, roleID, approved);
	}

	// Get Appreciation By ApprID
	@GetMapping("appreciation/{apprID}")
	public Optional<Appreciation> findAppreciationByApprID(@PathVariable int apprID) {
		return appreciationService.findAppreciationByApprID(apprID);
	}

	@GetMapping("userLogin/{email}&{password}")
	public User findUserByEmailAndPassword(@PathVariable String email, @PathVariable String password) {
		System.out.println("Inside Controller");
		return userService.findByEmailAndPassword(email, password);
	}

	// Add Appreciation
	@PostMapping("appreciation")
	public ResponseEntity<Appreciation> addAppreciation(@RequestBody AppreciationDTO appreciationDTO) {
		System.out.println("Inserting a Appreciation Record");
		return new ResponseEntity<Appreciation>(appreciationService.addAppreciation(appreciationDTO), HttpStatus.OK);
	}

	// Update Appreciation
	@PutMapping("appreciations/{apprID}")
	public void updateAppreciation(@PathVariable int apprID) {
		System.out.println("Approving an Appreciation Record");
		appreciationService.updateAppreciation(apprID);
	}

	// Disable Appreciation
	@DeleteMapping("appreciations/{apprID}")
	public void disableAppreciation(@PathVariable int apprID) {
		System.out.println("Disabling a Appreciation Record");
		appreciationService.disableAppreciation(apprID);
	}

	// List all Likes
	@GetMapping("likes")
	public List<Like> findAllLike() {
		return appreciationService.findAllLikes();
	}

	// Get Likes By LikeID
	@GetMapping("like/{likeID}")
	public Optional<Like> findLikeByLikeID(@PathVariable int likeID) {
		return appreciationService.findLikeByLikeID(likeID);
	}

	// List all Likes by ApprID
	@GetMapping("likes/appreciation/{apprID}")
	public List<Like> findAllLikeByApprID(@PathVariable int apprID) {
		return appreciationService.findAllLikeByApprID(apprID);
	}

	// Add Like
	@PostMapping("like")
	public Like addLike(@RequestBody LikeDTO likeDTO) {
		return appreciationService.addLike(likeDTO);
	}

	// Delete Like
	@DeleteMapping("like/{likeID}")
	public void deleteLike(@PathVariable int likeID) {
		appreciationService.deleteLike(likeID);
	}

	// List all Comments
	@GetMapping("comments")
	public List<Comment> findAllComments() {
		return appreciationService.findAllComments();
	}

	// List all Comments By ApprID
	@GetMapping("comments/appreciation/{apprID}")
	public List<Comment> findAllFirstCommentByApprID(@PathVariable int apprID) {
		return appreciationService.findAllFirstCommentByApprID(apprID);
	}

	// Get Comment By commentID
	@GetMapping("comment/{commentID}")
	public Optional<Comment> findCommentByCommentID(@PathVariable int commentID) {
		return appreciationService.findCommentByCommentID(commentID);
	}

	// Get All Comments By replyOnID
	@GetMapping("comments/reply/{replyOnID}")
	public List<Comment> findCommentByReplyOnID(@PathVariable int replyOnID) {
		return appreciationService.findCommentByReplyOnID(replyOnID);
	}

	// Add Comment
	@PostMapping("comment")
	public Comment addComment(@RequestBody CommentDTO commentDTO) {
		return appreciationService.addComment(commentDTO);
	}

	// Update Comment
	@PutMapping("comment")
	public Comment updateComment(@RequestBody CommentDTO commentDTO) {
		return appreciationService.updateComment(commentDTO);
	}

	// Delete Comment
	@DeleteMapping("comment/{commentID}")
	public void deletComment(@PathVariable int commentID) {
		appreciationService.deleteComment(commentID);
	}

}
