package cc.elefteria.jwtcryptoauthspring.security;

import cc.elefteria.jwtcryptoauthspring.user.AuthService;
import cc.elefteria.jwtcryptoauthspring.user.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
  
  private final AuthService authService;
  
  @PostMapping("/register")
  public ResponseEntity<AuthenticationResponse> register(@RequestBody UserDto userDto) {
    return ResponseEntity.ok(authService.register(userDto));
  }

  @PostMapping("/authenticate")
  public ResponseEntity<AuthenticationResponse> auth(@RequestBody AuthRequest authRequest) {
    return ResponseEntity.ok(authService.authenticate(authRequest));
  }
}
