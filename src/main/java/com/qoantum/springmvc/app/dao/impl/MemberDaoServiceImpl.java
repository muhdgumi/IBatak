package com.qoantum.springmvc.app.dao.impl;

import com.qoantum.springmvc.app.dao.service.MemberDaoService;
import com.qoantum.springmvc.app.model.Member;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Muhammad Bello Muhammad (muhdgumi@gmail.com)
 * @since 26/05/2015
 */
//@Repository("memberDaoService")
@Repository
public class MemberDaoServiceImpl extends AbstractDaoServiceImpl<Integer, Member> implements MemberDaoService {

    public Member findById(Long id) {
        return getByKey(id);
    }

    public void saveMember(Member member) {
        persist(member);
    }

    public void deleteById(Long memberId) {
        Query query = getSession().createSQLQuery("DELETE FROM Member WHERE id = :memberId");
        query.setLong("id", memberId);
        query.executeUpdate();
    }

    public void deleteByUsername(String username) {
        Query query = getSession().createSQLQuery("DELETE FROM Member WHERE username = :username");
        query.setString("username", username);
        query.executeUpdate();
    }

    public Member findByUsername(String username) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("username", username));
        return (Member) criteria.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public List<Member> findAllMembers() {
        Criteria criteria = createEntityCriteria();
        return (List<Member>) criteria.list();
    }
}
