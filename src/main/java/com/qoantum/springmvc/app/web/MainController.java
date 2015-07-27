package com.qoantum.springmvc.app.web;

import com.qoantum.springmvc.app.member.service.MemberService;
import com.qoantum.springmvc.app.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * @author Muhammad Bello Muhammad (muhdgumi@gmail.com)
 * @since 25/05/2015
 */
@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    MemberService memberService;

    @Autowired
    MessageSource messageSource;

    /** Login handler that will return login view to the client. */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String loginView() {
        return "login";
    }

    /** process user  login form data and allow use access if authenticated. */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String processMemberLogin(@Valid Member member, Errors errors) {
        if (errors.hasErrors()) {
            return "login";
        }
        memberService.isUsernameExists(member.getUsername());
        return "redirect:/member/" + member.getUsername();
    }

    /** Show member access area to the system where a member can perform activities. */
    @RequestMapping(value = "/member/{username}", method = RequestMethod.GET)
    public String showMember(@PathVariable String username, Model model) {
        model.addAttribute(username);
        return "member";
    }


}
