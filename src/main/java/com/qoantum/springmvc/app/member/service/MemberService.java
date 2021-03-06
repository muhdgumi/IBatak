package com.qoantum.springmvc.app.member.service;

import com.qoantum.springmvc.app.model.Member;

import java.util.List;

/**
 * Member service that provide members operation through spring controller in the application.
 *
 * @author Muhammad Bello Muhammad (muhdgumi@gmail.com)
 * @since 26/07/2015
 */
public interface MemberService {

    /**
     * Accept a member id and find the member object in the current session.
     *
     * @param id of a registered member.
     * @return entity of the registered member
     */
    Member findById(Long id);

    /**
     * Persist a member to the current session by taking the user provided member object and persisting it.
     *
     * @param member entity of the current member in the session.
     */
    void saveMember(Member member);

    /**
     * Delete a member object from the current session using the provided member id.
     *
     * @param memberId registered member id.
     */
    void deleteById(Long memberId);

    /**
     * Delete a member object from the current session using the provided member username.
     *
     * @param username member registered login name
     */
    void deleteByUsername(String username);

    /**
     * Take a member username and return the member from the current session
     *
     * @param username login username
     * @return entity of the current member in current session
     */
    Member findByUsername(String username);

    /**
     * Find all registered member and return a list containing all the members.
     *
     * @return list of all registered entities.
     */
    List<Member> findAllMembers();

    /**
     * Update the already registered member in the system with current object to reflect the member changes
     * in the persisted object.
     * @param member object.
     */
    void updateMember(Member member);

    /**
     * To verify is a username exists or not before registering new username is necessary.
     * The method take a username and verify is the username doesn't exists then the member
     * can register otherwise username has to be changed.
     *
     * @param username the unique username selected by user.
     * @return the status of the name in the system exists or not.
     */
    boolean isUsernameExists(String username);
}
