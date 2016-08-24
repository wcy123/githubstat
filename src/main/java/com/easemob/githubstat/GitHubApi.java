package com.easemob.githubstat;

import feign.Headers;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by wangchunye on 8/23/16.
 */
@FeignClient(name = "gitHubApi", url = "https://github.com")
public interface GitHubApi {
    @RequestMapping(value = "/login/oauth/access_token",
                    method = RequestMethod.POST,
                    headers = "Accept=application/json"
    )
    AccessToken accessToken(@RequestParam(value = "client_id") String clientId,
                @RequestParam(value = "client_secret") String clientSecret,
                @RequestParam(value = "code") String code,
                //@RequestParam(value = "redirect_uri") String redirectUri,
                @RequestParam(value = "state") String State);
}
