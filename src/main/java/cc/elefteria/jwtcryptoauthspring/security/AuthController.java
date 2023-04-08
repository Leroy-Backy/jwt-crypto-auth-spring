package cc.elefteria.jwtcryptoauthspring.security;

import cc.elefteria.jwtcryptoauthspring.user.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
  
  private final AuthService authService;
  
//  @PostMapping("/register")
//  public ResponseEntity<AuthenticationResponse> register(@RequestBody UserDto userDto) {
//    return ResponseEntity.ok(authService.register(userDto));
//  }

  @GetMapping("/nonce/{publicAddress}")
  public ResponseEntity<String> getUserNonce(@PathVariable String publicAddress) {
    return ResponseEntity.ok(authService.getUserNonce(publicAddress));
  }
  
  @PostMapping("/authenticate")
  public ResponseEntity<AuthenticationResponse> auth(@RequestBody AuthRequest authRequest) {
    return ResponseEntity.ok(authService.authenticate(authRequest));
  }
}
