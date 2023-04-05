//package generation.javongus.html.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import generation.javongus.html.model.UserAutentication;
//import generation.javongus.html.services.UserLogService;
//import jakarta.servlet.http.HttpSession;
//
//@RestController
//public class LoginController {
//	private UserLogService userService;
//	@Autowired
//	public LoginController(UserLogService userService) {
//		super();
//		this.userService = userService;
//	}
//	@GetMapping("/login")
//    public String login(Model model, String error, String logout) {
//        if (error != null) {
//            model.addAttribute("error", "Your username and password are invalid.");
//        }
//
//        if (logout != null) {
//            model.addAttribute("message", "You have been logged out successfully.");
//        }
//
//        return "login";
//    }
//
//    @PostMapping("/login")
//    public String login(Model model, @RequestParam String email, @RequestParam String password, HttpSession session) {
//        UserDetails userDetails = userService.loadUserByUsername(email);
//        if (userDetails != null && new BCryptPasswordEncoder().matches(password, userDetails.getPassword())) {
//        	UserAutentication authToken = new UserAutentication(userDetails.getUsername(), userDetails.getPassword(), userDetails.getAuthorities());
//            
//        	SecurityContextHolder.getContext().setAuthentication(authToken);
//            session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, SecurityContextHolder.getContext());
//            return "redirect:/home";
//        } else {
//            model.addAttribute("error", "Your username and password are invalid.");
//            return "login";
//        }
//    }
//	
//
//}
