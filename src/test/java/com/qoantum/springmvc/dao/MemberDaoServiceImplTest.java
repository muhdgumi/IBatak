package com.qoantum.springmvc.dao;

import com.qoantum.springmvc.app.dao.service.MemberDaoService;
import com.qoantum.springmvc.app.model.Member;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Date;

/**
 * @author Muhammad Bello Muhammad (muhdgumi@gmail.com)
 * @since 26/05/2015
 */
public class MemberDaoServiceImplTest extends TestDaoImpl {

    @Autowired
    MemberDaoService memberDaoService;

    @Override
    protected IDataSet getDataSet() throws Exception {
        IDataSet dataSet = new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("Member.xml"));
        return dataSet;
    }

    @Test
    public void findById() throws Exception {
        Assert.assertNotNull(memberDaoService.findById(1L));
        Assert.assertNull(memberDaoService.findById(15L));
    }

    @Test
    public void saveMember() {
        Member member = createMember();
        memberDaoService.saveMember(member);
        Assert.assertTrue(memberDaoService.findById(member.getId()) != null);
    }

    @Test
    public void deleteById() {
        memberDaoService.deleteById(1L);
        Assert.assertTrue(memberDaoService.findById(1L) == null);
    }

    @Test
    public void deleteByUsername() {
        memberDaoService.deleteByUsername("gumi");
        Assert.assertNull(memberDaoService.findByUsername("gumi"));
    }

    @Test
    public void findByUsername() {
        Assert.assertNotNull(memberDaoService.findByUsername("gumi"));
    }

    @Test
    public void findAllMembers() {
        Assert.assertTrue(memberDaoService.findAllMembers().size() > 1);
    }

    public Member createMember() {
        Member member = new Member();
        member.setId(1L);
        member.setFirstName("Bello");
        member.setLastName("Muhammad");
        member.setUsername("gumi");
        member.setPassword("you_and_me");
        member.setEmail("me@you.com");
        member.setAddress("The value of the annotated element must be a date in the future.");
        member.setDateOfBirth(new Date("01/05/2005"));
        member.setRegistrationDate(new Date("20/04/2014"));
        return member;
    }
}
