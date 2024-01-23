package by.shershen.web.controller;

import by.shershen.service.api.IUserService;
import by.shershen.service.dto.PageDTO;
import by.shershen.service.dto.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<String> add(@RequestBody UserDTO userDTO
    ) {
        this.userService.save(userDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    @ResponseBody
    public Page<UserDTO> findAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                 @RequestParam(value = "size", defaultValue = "10") Integer size
    ) {
        PageDTO pageDTO = new PageDTO(page, size);
        return this.userService.findAll(pageDTO);
    }
}
