package com.qoantum.springmvc.web;

import com.qoantum.springmvc.app.member.service.MemberService;
import com.qoantum.springmvc.app.model.Member;
import com.qoantum.springmvc.app.web.MainController;
import org.mockito.*;
import org.springframework.context.MessageSource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.mockito.Mockito.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Muhammad Bello Muhammad (muhdgumi@gmail.com)
 * @since 26/07/2015
 */
public class MainControllerTest {

    @Mock
    MemberService memberService;

    @Mock
    MessageSource messageSource;

    @InjectMocks
    MainController mainController;

    @Spy
    List<Member> members = new ArrayList<>();

    @Spy
    ModelMap model;

    @Mock
    BindingResult result;

    @BeforeClass
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        members = getMembers();
    }

    @Test
    public void loginView() throws Exception {
        MockMvc mockMvc = standaloneSetup(mainController).build();
        mockMvc.perform(get("/")).andExpect(view().name("login"));
        Assert.assertEquals("login", mainController.loginView());
    }

    @Test
    public void processMemberLogin() throws Exception {
        Member unsaved = members.get(0);

        when(memberService.findByUsername(unsaved.getUsername())).thenReturn(unsaved);

        MockMvc mockMvc = standaloneSetup(mainController).build();
        mockMvc.perform(post("/login")
                .param("firstName", "Bello")
                .param("lastName", "Muhammad")
                .param("username", "gumi")
                .param("password", "you_and_me")
                .param("email", "me@you.com")
                .param("address", "The value of the annotated element must be a date in the future.")
                .param("dateOfBirth", "01/05/2005")
                .param("registrationDate", "20/04/2014"))
                .andExpect(redirectedUrl("/member/gumi"));
        verify(memberService, atLeastOnce()).isUsernameExists(unsaved.getUsername());
    }

    public List<Member> getMembers() {

        List<Member> members = new ArrayList<>();

        Member member1 = new Member();
        member1.setId(1L);
        member1.setFirstName("Bello");
        member1.setLastName("Muhammad");
        member1.setUsername("gumi");
        member1.setPassword("you_and_me");
        member1.setEmail("me@you.com");
        member1.setAddress("The value of the annotated element must be a date in the future.");
        member1.setDateOfBirth(new Date("01/05/2005"));
        member1.setRegistrationDate(new Date("20/04/2014"));
        members.add(member1);

        Member member2 = new Member();
        member2.setId(2L);
        member2.setFirstName("Nasiru");
        member2.setLastName("Nkifi");
        member2.setUsername("nasir");
        member2.setPassword("you_and_me");
        member2.setEmail("you@you.com");
        member2.setAddress("The value of the annotated element must be a date in the future.");
        member2.setDateOfBirth(new Date("01/05/2005"));
        member2.setRegistrationDate(new Date("20/04/2014"));
        members.add(member2);

        return members;
    }
}
