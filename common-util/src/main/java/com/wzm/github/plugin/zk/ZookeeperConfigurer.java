package com.wzm.github.plugin.zk;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang.ArrayUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.core.io.Resource;

import com.wzm.github.plugin.ZookeeperResource;

public class ZookeeperConfigurer extends PropertyPlaceholderConfigurer {

    private static Map<String, String> ctxPropsMap = new HashMap<String, String>();

    private ZookeeperResource zkLocation;
    private Resource[] localLocations = new Resource[0];

    @Override
    public void setLocation(Resource location) {
        zkLocation = (ZookeeperResource) location;
        super.setLocations((Resource[]) ArrayUtils.add(localLocations, zkLocation));
    }

    @Override
    public void setLocations(Resource[] locations) {
        this.localLocations = locations;
        super.setLocations((Resource[]) ArrayUtils.add(locations, zkLocation));
    }

    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props)
            throws BeansException {
        super.processProperties(beanFactoryToProcess, props);

        for (Object key : props.keySet()) {
            ctxPropsMap.put(key.toString(), props.get(key).toString());
        }
    }

    public static String getProperty(String key) {
        return ctxPropsMap.get(key);
    }

    public ZookeeperResource getZkResoucre() {
        return zkLocation;
    }
}
