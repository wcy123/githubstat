package com.easemob.githubstat;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by wangchunye on 8/23/16.
 */

public class Stat extends AbstractAnnotationConfigDispatcherServletInitializer
{
    @Override
    protected String[] getServletMappings() {
        return new String[]{ "/"};
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{ RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{
           WebConfig.class
        };
    }


}
