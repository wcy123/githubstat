package com.easemob.githubstat;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by wangchunye on 8/24/16.
 */
public class YourOrgTest {
    @Test
    public void ReadFromTxt() throws Exception {
        URL url = getClass().getClassLoader().getResource("your_orgs.txt");
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        List<YourOrg> orgs = mapper.readValue(url, new TypeReference<List<YourOrg>>() { });
        System.out.println(orgs);
    }
}