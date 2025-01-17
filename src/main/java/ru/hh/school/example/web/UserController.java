package ru.hh.school.example.web;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ru.hh.school.example.EmailAlreadyBoundException;
import ru.hh.school.example.EmailNotValidException;
import ru.hh.school.example.NoSuchEmailException;
import ru.hh.school.example.PasswordNotCorrectException;

@Controller
@RequestMapping(value = "/users")
public class UserController {

  private final UserFacade userFacade;

  @Autowired
  public UserController(UserFacade userFacade) {
    this.userFacade = userFacade;
  }

  @RequestMapping(value = "about")
  public String about() {
    return "about";
  }

  @RequestMapping(value = "menu")
  public String menu(Model model) {
    try {
      Long userId = UserSecurity.getCurrentUserId();
      model.addAttribute("userName", userFacade.userNameById(userId));
    } catch (NoSuchElementException e) {
        model.addAttribute("userName", null);
	}
    return "menu";
  }

  @RequestMapping(value = "listUsers", method = RequestMethod.GET)
  public String list(Model model) {
    model.addAttribute("users", userFacade.listUsers());
    return "listUsers";
  }

  @RequestMapping(value = "userPage", method = RequestMethod.GET)
  public String userPage(@RequestParam("userId") Long userId, Model model) {
	  model.addAttribute("resumeForm", userFacade.getResumeForm(userId));
	  model.addAttribute("userName", userFacade.userNameById(userId));
    model.addAttribute("recommendationsToMe", userFacade.allRecommendRequestsToUser(userId));
    model.addAttribute("myRecommendations", userFacade.allRecommendRequestsOfUser(userId));
	  return "userPage";
  }
  
  @RequestMapping(value = "register", method = RequestMethod.GET)
  public String createRegForm(Model model) {
    model.addAttribute("userForm", new UserForm());
    return "register";
  }

  @RequestMapping(value = "register", method = RequestMethod.POST)
  public String doCreateRegForm(Model model, @ModelAttribute("userForm") UserForm userForm) {
    try {
      Long userId = userFacade.registerUser(userForm.getEmail(), userForm.getPassword(), userForm.getFullName());
      UserSecurity.setCurrentUserId(userId);
    } catch (EmailAlreadyBoundException e) {
      model.addAttribute("error", "Email already bound: " + e.getEmail());
      return "error";
    } catch (EmailNotValidException e) {
        model.addAttribute("error", "Email is not correct: " + e.getEmail());
        return "error";
    }
    return "redirect:/users/about";
  }

  @RequestMapping(value = "leave")
  public String logOut() {
    UserSecurity.removeCurrentUserId();
    return "redirect:/";
  }

  @RequestMapping(value = "login", method = RequestMethod.GET)
  public String createLogForm(Model model) {
    model.addAttribute("logForm", new LogForm());
    return "login";
  }

  @RequestMapping(value = "login", method = RequestMethod.POST)
  public String doCreateLogForm(Model model, @ModelAttribute("logForm") LogForm logForm) {
    try {
      Long userId = userFacade.findUser(logForm.getEmail(), logForm.getPassword());
      UserSecurity.setCurrentUserId(userId);
    } catch (NoSuchEmailException e) {
      model.addAttribute("error", "We don't have user with such email" + e.getEmail());
      return "error";
    } catch (PasswordNotCorrectException e) {
        model.addAttribute("error", "Password is not correct" + e.getPassword());
        return "error";
    }
    return "redirect:/users";
  }

  @RequestMapping(value = "resume", method = RequestMethod.GET)
  public String createResumeForm(Model model) {
    try {
      Long userId = UserSecurity.getCurrentUserId();
      ResumeForm resumeForm = userFacade.getResumeForm(userId);
      model.addAttribute("resumeForm", resumeForm);
    } catch (NoSuchElementException e) {
        model.addAttribute("error", "You need to be logged to do this action");
        return "error";
    }
    return "resume";
  }

  @RequestMapping(value = "resume", method = RequestMethod.POST)
  public String doCreateResumeForm(Model model, @ModelAttribute("resumeForm") ResumeForm resumeForm) {
    try {
      Long userId = UserSecurity.getCurrentUserId();
      userFacade.addResume(userId, resumeForm.getWork(), resumeForm.getSalary(),
        resumeForm.getStanding(), resumeForm.getText());
    } catch (NoSuchElementException e) {
        model.addAttribute("error", "You need to be logged to do this action");
        return "error";
    }
    return "redirect:/users";
  }

  @RequestMapping(value = "main", method = RequestMethod.GET)
  public String cabinet(Model model) {
    try {
      Long userId = UserSecurity.getCurrentUserId();
      model.addAttribute("users", userFacade.listUsers());
      model.addAttribute("recommendationsToMe", userFacade.allRecommendRequestsToUser(userId));
      model.addAttribute("myRecommendations", userFacade.allRecommendRequestsOfUser(userId));
    } catch (NoSuchElementException e) {
    model.addAttribute("error", "You need to be logged to do this action");
    return "error";
    }
    return "main";
  }

  @RequestMapping(value = "main", method = RequestMethod.POST)
  public String cabinetReDraw(@RequestParam("recommendatorId") Long recommendatorId,
                 Model model) {
    try {
      Long userId = UserSecurity.getCurrentUserId();
      userFacade.setRecommendationRequest(userId, recommendatorId);
    } catch (NoSuchElementException e) {
    model.addAttribute("error", "You need to be logged to do this action");
    return "error";
    }
    return "redirect:/users/main";
  }

  @RequestMapping(value = "giverecommendation", method = RequestMethod.GET)
  public String giveRecomendation(@RequestParam("recommendationId") Long recommendationId,
                 Model model) {
    try {
      Long userId = UserSecurity.getCurrentUserId();
      model.addAttribute("recommendation", userFacade.getRecommendationForm(userId, recommendationId));
      model.addAttribute("isWrittable", true);
    } catch (NoSuchElementException e) {
    model.addAttribute("error", "You need to be logged to do this action");
    return "error";
    }
    return "recomendation";
  }

  @RequestMapping(value = "giverecommendation", method = RequestMethod.POST)
  public String getRecomendation(Model model, @ModelAttribute("recommendation") RecommendationForm recommendation) {
    userFacade.setRecommendation(recommendation);
    return "redirect:/users/main";
  }

  @RequestMapping(value = "recommendation", method = RequestMethod.GET)
  public String vewRecomendation(@RequestParam("recommendationId") Long recommendatorId,
                 Model model) {
    model.addAttribute("recommendation", userFacade.getRecommendationInfo(recommendatorId));
    return "recomendation";
  }

  @RequestMapping(method = RequestMethod.GET)
  public String mainPage(Model model) {
    return "main";
  }
}
