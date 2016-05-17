package nao.plsapi.service;

import nao.plsapi.business.UserManager;
import nao.plsapi.view.UserView;
import nao.plsapi.view.info.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserService {

    @Autowired
    private UserManager userManager;

    @RequestMapping(method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public List<UserView> findAll() {
        return userManager.findAll();
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public UserView find(@PathVariable String userId) {
        return userManager.find(userId);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserView save(@RequestBody UserInfo userInfo) {
        return userManager.save(userInfo);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String userId) {
        userManager.delete(userId);
    }

}
