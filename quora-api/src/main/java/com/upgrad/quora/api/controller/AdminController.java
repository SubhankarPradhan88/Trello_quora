package com.upgrad.quora.api.controller;

import com.upgrad.quora.api.model.UserDeleteResponse;
import com.upgrad.quora.service.business.AdminService;
import com.upgrad.quora.service.entity.UserEntity;
import com.upgrad.quora.service.exception.AuthorizationFailedException;
import com.upgrad.quora.service.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class AdminController {

    @Autowired
    private AdminService adminService;

    /**
     * Get the user detail by user id.
     *
     * @param userId      : uuid / user id of the user
     * @param accessToken : access-token of the authenticated user
     * @return UserDeleteResponse
     * @throws AuthorizationFailedException : user authentication exception
     * @throws UserNotFoundException        : will through a user not found exception
     */
    @RequestMapping(method = RequestMethod.DELETE, path = "/admin/user/{userId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<UserDeleteResponse> deleteUser(@RequestHeader("authorization") final String accessToken,
                                                         @PathVariable("userId") final String userId) throws AuthorizationFailedException, UserNotFoundException {
        final UserEntity userEntity = adminService.deleteUser(userId, accessToken);
        final UserDeleteResponse userDeleteResponse = new UserDeleteResponse().id(userEntity.getUuid()).status("USER SUCCESSFULLY DELETED");
        return new ResponseEntity<>(userDeleteResponse, HttpStatus.OK);
    }
}