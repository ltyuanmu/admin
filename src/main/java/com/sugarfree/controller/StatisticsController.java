package com.sugarfree.controller;

import com.google.gson.Gson;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @ClassName: ${}
 * @Description:
 * @author: LT
 * @date: 2017/5/10
 */
@RestController
@RequestMapping("/stat/")
@PreAuthorize("hasRole('ADMIN')")
public class StatisticsController {

    @GetMapping(value = "/push", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity pushStat(String username){
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        return ResponseEntity.ok().body(new Gson().toJson(principal));
    }
}
