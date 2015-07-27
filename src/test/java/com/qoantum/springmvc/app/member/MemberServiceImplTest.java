package com.qoantum.springmvc.app.member;

import com.qoantum.springmvc.app.dao.service.MemberDaoService;
import com.qoantum.springmvc.app.member.impl.MemberServiceImpl;
import com.qoantum.springmvc.app.model.Member;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Muhammad Bello Muhammad (muhdgumi@gmail.com)
 * @since 26/05/2015.
 */
public class MemberServiceImplTest {

    @Mock
    MemberDaoService dao;

    @InjectMocks
    MemberServiceImpl service;

    @Spy
    List<Member> members = new ArrayList<>();

    @BeforeClass
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        members = getMembers();
    }

    @Test
    public void findById() {
        Member member = members.get(0);
        when(dao.findById(1L)).thenReturn(member);
        Assert.assertEquals(service.findById(1L), member);
    }

    @Test
    public void saveMember() {
        doNothing().when(dao).saveMember(any(Member.class));
        service.saveMember(any(Member.class));
        verify(dao, atLeastOnce()).saveMember(any(Member.class));
    }

    @Test
    public void deleteById() {
        doNothing().when(dao).deleteById(anyLong());
        service.deleteById(anyLong());
        verify(dao, atLeastOnce()).deleteById(anyLong());
    }

    @Test
    public void deleteByUsername() {
        doNothing().when(dao).deleteByUsername(anyString());
        service.deleteByUsername(anyString());
        verify(dao, atLeastOnce()).deleteByUsername(anyString());
    }

    @Test
    public void findByUsername() {
        Member member = members.get(0);
        when(dao.findByUsername(anyString())).thenReturn(member);
        Assert.assertEquals(service.findByUsername(anyString()), member);
    }

    @Test
    public void findAllMembers() {
        when(dao.findAllMembers()).thenReturn(members);
        Assert.assertTrue(dao.findAllMembers().size() > 1);
    }

    @Test
    public void updateMembers() {
        Member member = members.get(0);
        when(dao.findById(anyLong())).thenReturn(member);
        service.updateMember(member);
        verify(dao, atLeastOnce()).findById(anyLong());
    }

    @Test
    public void isUsernameExists() {
        Member member = members.get(0);
        when(dao.findByUsername(anyString())).thenReturn(member);
        Assert.assertEquals(service.isUsernameExists(anyString()), false);
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
