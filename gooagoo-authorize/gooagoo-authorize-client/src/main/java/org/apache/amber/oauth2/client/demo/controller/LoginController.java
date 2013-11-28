package org.apache.amber.oauth2.client.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/login")
public class LoginController
{
    @RequestMapping(params = "method=test", method = RequestMethod.GET)
    public String authorize(HttpServletRequest request, HttpServletResponse response) throws Exception
    {

        return "test";

    }
}
