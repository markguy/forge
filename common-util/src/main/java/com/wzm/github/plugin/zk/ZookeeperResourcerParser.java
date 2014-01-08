package com.wzm.github.plugin.zk;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSimpleBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

import com.wzm.github.plugin.ZookeeperResource;
import com.wzm.github.plugin.ZookeeperResource.OnConnectionFailed;
import com.wzm.github.plugin.ZookeeperResource.PingCmd;
import com.wzm.github.plugin.ZookeeperResource.ReloadContext;

public class ZookeeperResourcerParser extends AbstractSimpleBeanDefinitionParser {

    private static enum InitializeBy {
        CONSTRUCTOR_ARGS, LOCAL_FILE
    };

    @Override
    protected void doParse(Element element, ParserContext parserContext, BeanDefinitionBuilder builder) {
        InitializeBy initializeBy = InitializeBy.valueOf(element.getAttribute("initializeBy"));
        switch (initializeBy) {
        case CONSTRUCTOR_ARGS:
            builder.addConstructorArgValue(element.getAttribute("server"))
                    .addConstructorArgValue(element.getAttribute("znodes"))
                    .addConstructorArgValue(PingCmd.valueOf(element.getAttribute("pingCmd")))
                    .addConstructorArgValue(Boolean.valueOf(element.getAttribute("regression")))
                    .addConstructorArgValue(OnConnectionFailed.valueOf(element.getAttribute("onConnectionFailed")))
                    .addConstructorArgValue(ReloadContext.valueOf(element.getAttribute("reloadContext")));
            break;
        case LOCAL_FILE:
            break;
        }
    }

    @Override
    protected Class<ZookeeperResource> getBeanClass(Element element) {
        return ZookeeperResource.class;
    }

}
