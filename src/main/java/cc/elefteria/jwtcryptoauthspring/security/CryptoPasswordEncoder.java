package cc.elefteria.jwtcryptoauthspring.security;

import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.UUID;

public class CryptoPasswordEncoder implements PasswordEncoder {
  @Override
  public String encode(CharSequence rawPassword) {
    return SecurityConsts.NONCE_PREFIX + UUID.randomUUID();
  }

  @Override
  public boolean matches(CharSequence checkedPublicAddress, String publicAddress) {
//    String signature = signatureSeq.toString();
//    String r = signature.substring(0, 66);
//    String s = "0x" + signature.substring(66, 130);
//    String v = "0x" + signature.substring(130, 132);
//    BigInteger address = null;
//    
//    try {
//      address = Sign.signedPrefixedMessageToKey(nonce.getBytes(StandardCharsets.UTF_8),
//          new Sign.SignatureData(
//              Numeric.hexStringToByteArray(v)[0],
//              Numeric.hexStringToByteArray(r),
//              Numeric.hexStringToByteArray(s)));
//
//     return ("0x" + Keys.getAddress(address)).equalsIgnoreCase("0x" + Keys.getAddress(address));
//      
//    } catch (SignatureException e) {
//      throw new BadCredentialsException("Wrong signature!");
//    }
    
    return checkedPublicAddress.toString().equalsIgnoreCase(publicAddress);
  }
}
