package com.easemob.githubstat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Created by wangchunye on 8/23/16.
 */
@Controller
@RequestMapping("/")
@SessionAttributes("mySession")
public class Home {
    private static final Logger logger = LoggerFactory.getLogger(Home.class);
    private SecureRandom random = new SecureRandom();

    private GitHubApi gitHubApi;

    @Autowired
    public void setGitHubApi(GitHubApi gitHubApi)
    {
        this.gitHubApi = gitHubApi;
    }
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(@SessionAttribute Session mysession ){
        return "home";
    }
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(Model model){
        String state = new BigInteger(130, random).toString(32);
        UriComponentsBuilder builder = UriComponentsBuilder.newInstance();
        String redirectUrl =
                builder.scheme("https")
                .host("github.com")
                .path("/login/oauth/authorize")
                .queryParam("client_id", clientId())
                .queryParam("state", state)
                .build()
                .toString();
        Session session = new Session();
        session.setState(state);
        model.addAttribute("mySession", session);
        return "redirect:" + redirectUrl;
    }
    @RequestMapping(value = "callback", method = RequestMethod.GET)
    public String callback(@RequestParam("code") String code,
                           @RequestParam("state") String state,
                           @SessionAttribute Session mySession) {
        // TODO: verify state
        if(!state.equals(mySession.getState())) {
            //return "error:not_valid";
        }
        String redirectUrl = "not used yegt";
        mySession.setCode(code);
        mySession.setState(null);
        AccessToken acccessToken = gitHubApi.accessToken(clientId(),clientSecret(), code, state);
        logger.info("now I get retrun :" + acccessToken);
        mySession.setToken(acccessToken.getAccessToken());
        if(!StringUtils.hasText(mySession.getToken())) {
            return "home";
        }
        return "redirect:/list_week";
    }

    @RequestMapping(value = "list_week", method = RequestMethod.GET)
    public String list_week(@RequestParam("code") String code,
                           @RequestParam("state") String state,
                           @SessionAttribute Session mySession) {
        // TODO: verify state
        if(!state.equals(mySession.getState())) {
            //return "error:not_valid";
        }
        String redirectUrl = "not used yegt";
        mySession.setCode(code);
        mySession.setState(null);
        AccessToken acccessToken = gitHubApi.accessToken(clientId(),clientSecret(), code, state);
        logger.info("now I get retrun :" + acccessToken);
        mySession.setToken(acccessToken.getAccessToken());
        if(!StringUtils.hasText(mySession.getToken())) {
            return "home";
        }
        return "list_week";
    }

    static String clientId() {
        return "c189a0c234bd3efdc65c";
    }
    static String clientSecret() {
        return "cbce765b2bc74942fc97db408e346e390105bef0";
    }
}
