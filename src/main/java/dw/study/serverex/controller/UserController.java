package dw.study.serverex.controller;

import dw.study.serverex.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<?> initial(){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/{username}")
    public ResponseEntity<?> signUp(@PathVariable("username") String username){
        return new ResponseEntity<>(
                userService.join(userService.checkDuplicateUser(username)),
//                userService.checkDuplicateUser(username),
                HttpStatus.OK);
    }

    @GetMapping("/{username}")
    public ResponseEntity<?> findUser(@PathVariable("username") String username){
        return new ResponseEntity<>(
                userService.getUser(username),
                HttpStatus.OK
        );
    }
}
