package com.easemob.githubstat;

import lombok.Data;

import javax.annotation.sql.DataSourceDefinition;

/**
 * Created by wangchunye on 8/23/16.
 */
@Data
public class Session {
    private String name;
    private String state;
    private String code;
    private String token;
}
