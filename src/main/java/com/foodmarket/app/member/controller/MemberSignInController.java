package com.foodmarket.app.member.controller;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.foodmarket.app.member.model.Member;
import com.foodmarket.app.member.service.MemberServiceInterface;
import com.foodmarket.app.member.util.JavaMail;
import com.foodmarket.app.member.util.Util;

@Controller
public class MemberSignInController {
	
	@Autowired
	private MemberServiceInterface memberService;
	
	Util util = new Util();
	
	JavaMail mail = new JavaMail();
	
	private static final Logger logger = LoggerFactory.getLogger(MemberSignInController.class);

	@PostMapping("/checkRecaptcha")
	public ResponseEntity<String> checkRecaptcha(@RequestBody String token) {
		
		String secret = "6Le9B3QgAAAAAACgXADsbBwEbHNOCdMHd0KPz0aS";
		
		if(util.isCaptchaValid(secret, token.replace("\"", ""))) {
			logger.info(" 人機驗證成功 ");
			return new ResponseEntity<String>("Y", HttpStatus.OK);
		}
		
		logger.info(" 人機驗證失敗 ");
		return new ResponseEntity<String>("N",HttpStatus.OK);	
		
	}
	
	@PostMapping("/checkMail")
	public ResponseEntity<String> checkMail(@RequestBody String mail) {
		if(memberService.findByMail(mail) != null) {
			logger.info(" 帳號已存在 ");
			return new ResponseEntity<String>("Y", HttpStatus.OK);
		}
		
		logger.info(" 帳號沒有重複 ");
		return new ResponseEntity<String>("N",HttpStatus.OK);	
		
	}
	
	//新增會員並發信
	@PostMapping("/insertCustomer")
	public String insertCustomer(@ModelAttribute("member")Member member, Model m, HttpSession session) {
		Member rsMember = memberService.insertCustomer(member);
		logger.info("註冊成功! 會員編號：" + rsMember.getCustomerId());		
		
		String token =  util.encryptString(rsMember.getCustomerId().toString());
				
		//信件標題及內容設定
		String title = "foodmarket會員驗證信";
		String text = "您好，請點擊下方連結啟動完整會員功能"+
					"<a href = 'http://localhost:8080/foodmarket/authMailCheck/("+token + ")'>"+
					"http://localhost:8080/foodmarket/authMailCheck/("+ token +")</a>";
		//轉為登入狀態
		session.setAttribute("loginUserId", rsMember.getCustomerId());
		session.setAttribute("loginUserName", rsMember.getCustomerName());
				
		//在db新增authToken及到期日
		rsMember.setAuthToken(token);
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, +3);
//		cal.add(Calendar.SECOND, +3);
		rsMember.setAuthLimit(cal.getTime());
		
		memberService.updateCustomer(rsMember);
		
		mail.SendMail(rsMember.getMail(), title, text);
		
		return "member/authMail";
	}

	@GetMapping("/authMailCheck/{token}")
	public String authMailCheck(@PathVariable String token, HttpSession session) {

		Member rsMember = memberService.findById(Long.parseLong(util.decryptString("KittySnoopyMicky", token)));
		
		if(rsMember.getAuthLimit().after(new Date())) {
			if(rsMember.getAuthToken().equals(token.substring(1, token.length()-1))) {
				logger.info("驗證成功! 會員編號：" + rsMember.getCustomerId());
				rsMember.setAuthCheck("true");
				rsMember.setAuthToken(null);
				rsMember.setAuthLimit(null);
				memberService.updateCustomer(rsMember);
				return "member/authMailCheck";
			}else {
				logger.info("錯誤驗證碼! 會員編號：" + rsMember.getCustomerId());
				return "member/authMailReSend";
			}
		}else {
			logger.info("過期驗證碼! 會員編號：" + rsMember.getCustomerId());
			return "member/authMailReSend";
		}	
	}

}