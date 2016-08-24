package com.easemob.githubstat;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created by wangchunye on 8/23/16.
 */
@Data
public class AccessToken {
    @JsonProperty("access_token")
    public String accessToken;
    public String scope;
    @JsonProperty("token_type")
    public String tokenType;
}
