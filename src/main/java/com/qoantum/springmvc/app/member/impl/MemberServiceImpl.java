package com.qoantum.springmvc.app.member.impl;

import com.qoantum.springmvc.app.dao.service.MemberDaoService;
import com.qoantum.springmvc.app.member.service.MemberService;
import com.qoantum.springmvc.app.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Muhammad Bello Muhammad (muhdgumi@gmail.com)
 * @since 26/07/2015
 */
//@Service("memberServiceImpl")
@Service
@Transactional
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDaoService memberDaoService;

    public Member findById(Long id) {
        return memberDaoService.findById(id);
    }

    public void saveMember(Member member) {
        memberDaoService.saveMember(member);
    }

    public void deleteById(Long memberId) {
        memberDaoService.deleteById(memberId);
    }

    public void deleteByUsername(String username) {
        memberDaoService.deleteByUsername(username);
    }

    public Member findByUsername(String username) {
        return memberDaoService.findByUsername(username);
    }

    public List<Member> findAllMembers() {
        return memberDaoService.findAllMembers();
    }

    public void updateMember(Member member) {
        Member entity = memberDaoService.findById(member.getId());
        if (entity != null) {
            entity.setPassword(member.getPassword());
            entity.setEmail(member.getEmail());
            entity.setAddress(member.getAddress());
        }
    }

    public boolean isUsernameExists(String username) {
        return memberDaoService.findByUsername(username) == null;
    }
}
