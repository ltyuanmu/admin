package com.sugarfree.controller;

import com.sugarfree.invo.AuthInVo;
import com.sugarfree.outvo.AuthOutVo;
import com.sugarfree.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName: ${}
 * @Description:
 * @author: LT
 * @date: 2017/5/2
 */
@RestController
public class AuthController {

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private AuthService authService;

    @PostMapping(value = "auth" ,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> createAuthenticationToken(
            AuthInVo authInVo) throws AuthenticationException {
        final String token = authService.login(authInVo.getUsername(), authInVo.getPassword());
        // Return the token
        return ResponseEntity.ok(new AuthOutVo(token));
    }

    @PostMapping(value = "refresh",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> refreshAndGetAuthenticationToken(
            HttpServletRequest request) throws AuthenticationException{
        String token = request.getHeader(tokenHeader);
        String refreshedToken = authService.refresh(token);
        if(refreshedToken == null) {
            return ResponseEntity.badRequest().body(null);
        } else {
            return ResponseEntity.ok(new AuthOutVo(refreshedToken));
        }
    }

    //目前不需要
    /*@PostMapping(value = "auth/register")
    public User register(@RequestBody User addedUser) throws AuthenticationException{
        return authService.register(addedUser);
    }*/

}
