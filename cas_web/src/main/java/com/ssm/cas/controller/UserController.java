package com.ssm.cas.controller;

import com.github.pagehelper.PageInfo;
import com.ssm.cas.domain.Role;
import com.ssm.cas.domain.UserInfo;
import com.ssm.cas.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author: 胖虎
 * @date: 2019/5/28 16:25
 **/
@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView findAll(@RequestParam(name = "page", defaultValue = "1") Integer page,
                                @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user-list");
        List<UserInfo> userInfos = userService.findAll(page, pageSize);
        PageInfo pageInfo = new PageInfo(userInfos);
        modelAndView.addObject("pageInfo", pageInfo);
        return modelAndView;
    }

    @RequestMapping(value = "/new" , method = RequestMethod.GET)
    public String jumpToSave(){
        return "user-add";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String save(UserInfo userInfo){
        userService.save(userInfo);
        return "redirect:/user";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView findById(@PathVariable String id) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        UserInfo userInfo = userService.findById(id);

        modelAndView.addObject("user", userInfo);
        modelAndView.setViewName("user-show");
        return modelAndView;
    }

    @RequestMapping(value = "/{id}/available", method = RequestMethod.GET)
    public ModelAndView findUserByIdAndAllRole(@PathVariable(name = "id") String userId) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        UserInfo userInfo = userService.findById(userId);
        List<Role> roles = userService.findOthersRoles(userId);

        modelAndView.addObject("user", userInfo);
        modelAndView.addObject("roleList", roles);
        modelAndView.setViewName("user-role-add");
        return modelAndView;
    }

    @RequestMapping(value = "/{id}/available", method = RequestMethod.POST)
    public ModelAndView addRoleToUser(@PathVariable(name = "id") String userId, @RequestParam(name = "ids") String[] roleIds){
        userService.addRoleToUser(userId, roleIds);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/user");
        return modelAndView;
    }
}
