package com.qoantum.springmvc.app.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @author Muhammad Bello Muhammad (muhdgumi@gmail.com)
 * @since 25/05/2015
 */
@Entity
@Table(name = "game")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private Long id;

    @NotNull
    @Size(min = 3, max = 50)
    @Column(name = "GAME_NAME", unique = true, nullable = false)
    private String gameName;

    @NotNull
    @Size(min = 3, max = 50)
    @Column(name = "USERNAME", nullable = false)
    private String username;

    @NotNull
    @Size(min = 50, max = 255)
    @Column(name = "DESCRIPTION",  nullable = false)
    private String description;

    @NotNull
    @Column(name = "REGISTRATION_DATE", nullable = false)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private Date registrationDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public boolean equals(Object object) {
        return EqualsBuilder.reflectionEquals(this, object, "gameName", "username", "description", "creationDate");
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, "gameName", "username", "description", "creationDate");
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", gameName='" + gameName + '\'' +
                ", username='" + username + '\'' +
                ", description='" + description + '\'' +
                ", registrationDate=" + registrationDate +
                '}';
    }
}
