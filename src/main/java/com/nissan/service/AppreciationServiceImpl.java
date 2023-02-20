package com.nissan.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nissan.dto.AppreciationDTO;
import com.nissan.dto.CommentDTO;
import com.nissan.dto.LikeDTO;
import com.nissan.dto.Mail;
import com.nissan.model.Appreciation;
import com.nissan.model.Comment;
import com.nissan.model.Like;
import com.nissan.model.User;
import com.nissan.repo.IAppreciationRepo;
import com.nissan.repo.ICommentRepo;
import com.nissan.repo.ILikeRepo;
import com.nissan.repo.ITemplateRepo;
import com.nissan.repo.IUserRepo;
import com.sun.xml.messaging.saaj.packaging.mime.MessagingException;

@Service
public class AppreciationServiceImpl implements IAppreciationService {
	// Field Injection
	@Autowired
	IAppreciationRepo appreciationRepo;

	@Autowired
	IUserRepo userRepo;

	@Autowired
	ITemplateRepo templateRepo;

	@Autowired
	IMailService mailService;

	@Autowired
	ILikeRepo likesRepo;

	@Autowired
	ICommentRepo commentRepo;

	@Override
	public List<Appreciation> findAllAppreciations() {

		return appreciationRepo.findAll(Sort.by("createdDate").descending());
	}

	@Override
	public List<Appreciation> findAllFilteredAppreciations(String email, int roleID) {
		// Check Role
		User user = userRepo.findUserByEmail(email);

		// Check for null
		if (user == null) {
			return null;
		}

		int userID = user.getUserID();

		// Check role with Database
		if (user.getRole().getRoleID() == roleID) {
			if (roleID == 1) {
				return appreciationRepo.findAll();
			} else if (roleID == 2) {
				return appreciationRepo.findAppreciationsOfStaff(userID);
			} else if (roleID == 3) {
				return appreciationRepo.findAppreciationsRecommendBy(userID);
			} else if (roleID == 4) {
				return appreciationRepo.findAppreciationsApprovedBy(userID);
			}
		}

		return null;
	}

	@Override
	public List<Appreciation> findAllAppreciationsByApproval(String email, int roleID, boolean approved) {
		// Check Role
		User user = userRepo.findUserByEmail(email);

		// Check for null
		if (user == null) {
			return null;
		}

		int userID = user.getUserID();

		// Check role with Database
		if (user.getRole().getRoleID() == roleID) {
			// Only For Approver
			// 4 - Denotes Approver
			if (roleID == 4) {
				if (approved) {
					return appreciationRepo.findAppreciationsApprovedBy(userID);
				} else {
					return appreciationRepo.findAppreciationsAssignedTo(userID);
				}

			}
		}

		return null;
	}

	// Find Appreciation By ApprID
	@Override
	public Optional<Appreciation> findAppreciationByApprID(int apprID) {
		return appreciationRepo.findById(apprID);
	}

	// Add Appreciation
	@Transactional
	@Override
	public Appreciation addAppreciation(AppreciationDTO appreciationDTO) {
		// Appreciation Object to Save in Database
		Appreciation appreciation = new Appreciation(appreciationDTO,
				userRepo.findByUserID(appreciationDTO.getRecommendByID()),
				userRepo.findByUserID(appreciationDTO.getAssignedToID()),
				userRepo.findByUserID(appreciationDTO.getUserID()),
				templateRepo.findByTemplateID(appreciationDTO.getTemplateID()));

		appreciation.setActive(true);

		// Setting Creation Date
		appreciation.setCreatedDate(LocalDateTime.now());

		// Updating Score By +10
		appreciation.getUser().setScore(appreciation.getUser().getScore() + 10);

		// Saving Object in Database
		appreciation = appreciationRepo.save(appreciation);

		// Mapping UserID to its Email
		int[] ccToID = appreciationDTO.getCcTo();

		// ccTo including the Recommender as well as its sending via a common mail
		String[] ccTo = new String[ccToID.length + 1];

		for (int i = 0; i < ccTo.length - 1; i++) {
			ccTo[i] = userRepo.findEmailByUserID(ccToID[i]);
		}

		// Including the cc To for Recommender
		ccTo[ccToID.length] = userRepo.findEmailByUserID(appreciationDTO.getRecommendByID());

		Mail mail = new Mail(userRepo.findEmailByUserID(appreciationDTO.getUserID()),
				userRepo.findEmailByUserID(appreciationDTO.getRecommendByID()),
				"Appreciation for - " + userRepo.findNameByUserID(appreciationDTO.getUserID()), ccTo, "");

		try {
			mailService.sendEmailWithAttachments(mail, appreciationDTO.getTemplateID(), appreciationDTO.getTags());
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (javax.mail.MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return appreciation;
	}

	// Update User
	@Transactional
	@Override
	public Appreciation updateAppreciation(Appreciation appreciation) {
		return appreciationRepo.save(appreciation);
	}

	// Approve Appreciation
	@Transactional
	@Override
	public void updateAppreciation(int apprID) {

		Appreciation appreciation = appreciationRepo.findAppreciationsByApprID(apprID);

		// Update Required Values;
		appreciation.setApproved(true);
		appreciation.setApprovedBy(appreciation.getAssignedTo());
		appreciation.setDate(LocalDateTime.now());

		// Save changes
		appreciationRepo.save(appreciation);
	}

	// Disable Appreciation
	@Transactional
	@Override
	public void disableAppreciation(int apprID) {
		Appreciation appreciation = appreciationRepo.findAppreciationsByApprID(apprID);

		// Disable Appreciation
		// Update Required Values;
		appreciation.setApproved(true);
		appreciation.setApprovedBy(appreciation.getAssignedTo());
		appreciation.setDate(LocalDateTime.now());
		appreciation.setActive(false);

		// Save changes
		appreciationRepo.save(appreciation);
	}

	@Override
	public List<Like> findAllLikes() {
		return likesRepo.findAll();
	}
	
	@Override
	public List<Like> findAllLikeByApprID(int apprID) {
		return likesRepo.findAllLikeByApprID(apprID);
	}

	@Override
	public Optional<Like> findLikeByLikeID(int likeID) {
		return likesRepo.findById(likeID);
	}

	@Transactional
	@Override
	public Like addLike(LikeDTO likeDTO) {
		Like like = new Like(likeDTO, userRepo.findByUserID(likeDTO.getUserID()),
				appreciationRepo.findAppreciationsByApprID(likeDTO.getApprID()));
		
		return likesRepo.save(like);
	}

	@Transactional
	@Override
	public void deleteLike(int likeID) {
		likesRepo.deleteById(likeID);
	}

	@Override
	public List<Comment> findAllComments() {
		return commentRepo.findAll();
	}
	
	@Override
	public List<Comment> findAllFirstCommentByApprID(int apprID) {
		return commentRepo.findAllFirstCommentByApprID(apprID);
	}
	
	@Override
	public List<Comment> findCommentByReplyOnID(int replyOnID) {
		return commentRepo.findAllCommentWithReplyOn(replyOnID);
	}

	@Override
	public Optional<Comment> findCommentByCommentID(int commentID) {
		return commentRepo.findById(commentID);
	}

	@Transactional
	@Override
	public Comment addComment(CommentDTO commentDTO) {
		Comment comment = new Comment(commentDTO, userRepo.findUserByUserID(commentDTO.getUserID()),
				appreciationRepo.findAppreciationsByApprID(commentDTO.getApprID()),
				commentRepo.findCommentByCommentID(commentDTO.getReplyOnID()));
		return commentRepo.save(comment);
	}

	@Transactional
	@Override
	public Comment updateComment(CommentDTO commentDTO) {
		Comment comment = commentRepo.findCommentByCommentID(commentDTO.getCommentID());
		comment.setEdited(true);
		comment.setCommentMessage(commentDTO.getCommentMessage());
		return commentRepo.save(comment);
	}

	@Transactional
	@Override
	public void deleteComment(int commentID) {
		// Delete all child having reply On
		List<Comment> commentHavingReplyON = commentRepo.findAllCommentWithReplyOn(commentID);
		if(commentHavingReplyON.size() == 0)
		{
			commentRepo.deleteById(commentID);
			return;
		}
		for(Comment comment:commentHavingReplyON)
		{
			deleteComment(comment.getCommentID());
		}
		commentRepo.deleteById(commentID);
		return;
	}
}
