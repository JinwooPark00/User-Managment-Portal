package com.ajaxproject.controller;

import com.ajaxproject.model.AjaxResponseBody;
import com.ajaxproject.model.SearchCriteria;
import com.ajaxproject.model.User;
import com.ajaxproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/*
    Accept a Search Criteria and returns a ResponseEntity
 */
@RestController
public class SearchController {

    @Autowired
    UserService userService;

    @PostMapping("/api/search")
    public ResponseEntity<?> getSearchResult(@Valid @RequestBody SearchCriteria search, Errors errors){

        AjaxResponseBody result = new AjaxResponseBody();

        if(errors.hasErrors()){
            result.setMsg(errors.getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(",")));

            return ResponseEntity.badRequest().body(result);
        }

        List<User> users = userService.findByUsernameOrEmail(search.getUsername());
        if(users.isEmpty()){
            result.setMsg("no user found");
        } else {
            result.setMsg("success");
        }
        result.setResult(users);

        return ResponseEntity.ok(result);
    }
}
