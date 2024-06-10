package com.healthgard.server.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.healthgard.server.config.auth.domain.SessionUser;
import com.healthgard.server.web.dto.TrainerListResponseDto;
import com.healthgard.server.web.service.TrainerService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class IndexController {
	
	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	
    private final HttpSession httpSession;
    
    private final TrainerService trainerService;
	
	@RequestMapping("/")
	public String index(Model model) {
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if(user != null){
            model.addAttribute("userName", user.getName());
        }
        
        List<TrainerListResponseDto> trainer = trainerService.findAllDesc();
        model.addAttribute("trainers", trainer);
        
        logger.debug(":: trainer List=" + trainer.toString());
        
		return "index";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/join")
	public String join() {
		return "join";
	}
	@RequestMapping("/registTrainer")
	public String registTrainer() {
		return "trainer/registTrainerPage";
	}


}
