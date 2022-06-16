package com.stdio.esm.controller;


import com.stdio.esm.model.Account;
import com.stdio.esm.service.AccountService;
import com.stdio.esm.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/users")
public class UserController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private UserService userService;

    @GetMapping(path = "/list-users")
    @ApiOperation(value = "LIST USERS")
    public ResponseEntity<List<Account>> getUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
    }

    @GetMapping(path = "/list-users-pagination")
    @ApiOperation(value = "LIST USERS PAGINATION")
    public ResponseEntity<Page<Account>> getUsers(@RequestParam(defaultValue = "0") Integer pageNumber,
                                                  @RequestParam(defaultValue = "5") Integer pageSize
                                              ) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers(
                PageRequest.of(pageNumber, pageSize)
        ));
    }

    @GetMapping(path = "/find-by-id")
    @ApiOperation(value = "GET USER BY ID")
    public ResponseEntity<Account> getUserById(@RequestParam Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.findUserById(id));
    }

    @PostMapping(path = "/add-user")
    @ApiOperation(value = "ADD USER")
    public ResponseEntity<Account> addUser(@RequestBody Account account) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveOrUpdate(account));
    }

    @PutMapping(path = "/edit-user")
    @ApiOperation(value = "UPDATE USER")
    public ResponseEntity<Account> updateUser(@RequestBody Account account) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.saveOrUpdate(account));
    }

    @DeleteMapping(path = "/delete-user")
    @ApiOperation(value = "DELETE USER")
    public ResponseEntity<String> deleteUser(@RequestParam(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.deleteById(id));
    }

    @PostMapping("/change-password")
    @ApiOperation("CHANGE PASSWORD")
    public ResponseEntity<String> changePassword(@NotNull @RequestBody Map<String, String> request) {
        userService.changePassword(request);
        return ResponseEntity.status(HttpStatus.OK).body("Change password successfully!");
    }

    @PostMapping("/reset-password")
    @ApiOperation("RESET PASSWORD")
    public ResponseEntity<?> resetPassword(@RequestParam("username") String userName) {
        userService.resetPassword(userName);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
