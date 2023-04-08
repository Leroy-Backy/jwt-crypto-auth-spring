package cc.elefteria.jwtcryptoauthspring.user;

import cc.elefteria.jwtcryptoauthspring.security.AuthRequest;
import cc.elefteria.jwtcryptoauthspring.security.AuthenticationResponse;
import cc.elefteria.jwtcryptoauthspring.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authManager;

  public AuthenticationResponse register(UserDto userDto) {
    User user = User.builder()
        .firstName(userDto.getFirstName())
        .lastName(userDto.getLastName())
        .username(userDto.getUsername())
        .password(passwordEncoder.encode(userDto.getPassword()))
        .role(Role.ROLE_USER)
        .build();

    userRepository.save(user);

    return new AuthenticationResponse(jwtService.generateToken(user.getUsername()));
  }

  public AuthenticationResponse authenticate(AuthRequest authRequest) {
    authManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            authRequest.getUsername(),
            authRequest.getPassword()
        )
    );
    // at this point use
    return new AuthenticationResponse(jwtService.generateToken(authRequest.getUsername()));
  }
}
