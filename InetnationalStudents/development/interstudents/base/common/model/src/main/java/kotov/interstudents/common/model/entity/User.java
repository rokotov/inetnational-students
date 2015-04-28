package kotov.interstudents.common.model.entity;

import kotov.interstudents.common.model.AbstractEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by vkotov on 05.03.2015.
 */
@Entity
@Table(name = "user")
public class User extends AbstractEntity implements UserDetails {
    @Id
    @GeneratedValue()
    @Column(name = "user_id")
    private Integer id;

    @Column(name = "login")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    protected User()
    {
		/* Reflection instantiation */
    }

    public User(String name, String passwordHash)
    {
        this.name = name;
        this.password = passwordHash;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        Set<String> roles = new HashSet<String>();

        roles.add(this.getRole());
        if(this.getRole().equals("admin")){
            roles.add("user");
        }

        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }

        return authorities;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return this.name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
