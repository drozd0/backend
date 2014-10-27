package ru.qlogistic.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name="users")
public class User implements UserDetails {
    @Id
    @SequenceGenerator(name = "user_id", sequenceName = "user_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id")
    private Long id;

    private String name;
    private String second_name;
    private String surname;
    private String email;
    private String password;
    private String purseNumber;
    private Date createDate;
    private String firstPagePath;
    private String secondPagePath;
    private String avatarPath;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return second_name;
    }

    public void setSecondName(String second_name) {
        this.second_name = second_name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPurseNumber() {
        return purseNumber;
    }

    public void setPurseNumber(String purseNumber) {
        this.purseNumber = purseNumber;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getFirstPagePath() {
        return firstPagePath;
    }

    public void setFirstPagePath(String firstPagePath) {
        this.firstPagePath = firstPagePath;
    }

    public String getSecondPagePath() {
        return secondPagePath;
    }

    public void setSecondPagePath(String secondPagePath) {
        this.secondPagePath = secondPagePath;
    }

    public String getAvatarPath() {
        return avatarPath;
    }

    public void setAvatarPath(String avatarPath) {
        this.avatarPath = avatarPath;
    }

    public String getFullName(){
        return String.format("%s %s %s", name, second_name,surname );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isEnabled() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
