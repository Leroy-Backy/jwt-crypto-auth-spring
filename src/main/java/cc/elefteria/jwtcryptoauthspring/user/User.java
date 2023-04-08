package cc.elefteria.jwtcryptoauthspring.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "_user")
public class User implements UserDetails {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  
  private String firstName;
  private String lastName;
  private String username;
  @Column(unique = true)
  private String nickname;
  @Column(unique = true)
  private String publicAddress;
  private String nonce;
  @Enumerated(EnumType.STRING)
  private Role role;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return role.getAuthorities();
  }

  @Override
  public String getPassword() {
    return nonce;
  }

  @Override
  public String getUsername() {
    return publicAddress;
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
}
