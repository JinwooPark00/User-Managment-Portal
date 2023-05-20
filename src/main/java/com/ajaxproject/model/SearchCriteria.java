package com.ajaxproject.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class SearchCriteria {

    @NotBlank(message = "username cannot be empty")
    String username;

}
