package com.ab.cache.rest;

/*import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;*/
import com.ab.cache.entity.User;
import com.ab.cache.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("rest/foo")
@RestController
//@Api(value = "Foo Controller", description = "Operations on Foo")
public class FooController {

    @Autowired
    UserService userService;

    @GetMapping("/")
  /*  @ApiOperation(value = "print time stamp with greetings")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "success")
    })*/
    public String hello() {
        return "Hello World!"+System.currentTimeMillis();
    }

    @GetMapping("/{natId}")
    public User getUser(@PathVariable long natId) {
        return userService.getUser(natId);
    }

    @GetMapping("/refresh/{natId}")
    public User getRefreshUser(@PathVariable long natId) {
        return userService.getRefreshUser(natId);
    }

    @GetMapping("/delete/{natId}")
    public User deleteUser(@PathVariable long natId) {
        return userService.deleteUser(natId);
    }
}
