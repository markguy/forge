package com.wzm.github.util;

import java.io.File;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.XMLConfiguration;
import org.apache.commons.lang.StringUtils;

import com.wzm.github.log.MLWLogger;
import com.wzm.github.log.MLWLoggerFactory;

/**
 *  默认classpath下的conf/commons.properties, 不需要spring
 * 
 * @author huaiyu.du@opi-corp.com  
 * 2012-2-8 下午5:01:28
 */
public final class BaseConfig {

	private static final MLWLogger LOG = MLWLoggerFactory.getLogger(BaseConfig.class);
	private static String CONFIGS_WHERE = "conf"; 
	public enum FileName{
		commons
	}

	private static final Map<FileName,Configuration> CONF_MAP = new ConcurrentHashMap<FileName, Configuration>(4);

	static{
		init();
	}

	/**
	 * 指定配置路径从classpath下哪个目录开始 默认读conf里的commons.properties
	 * 
	 * @param dir
	 */
	public synchronized static void setConfigFrom(String dir){
		CONFIGS_WHERE = dir;
		init();
	}
	
	private static void init(){
		FileName[] values = FileName.values();
		CONF_MAP.clear();
		
		for(FileName fileName : values){

			try {
				LOG.debug("parse config file '"+fileName+".properties' in classpath.");
				String filePath = getPath(fileName+".properties");
				if(StringUtils.isBlank(filePath)){
					LOG.debug("file '"+fileName+".properties' not exists in classpath, then try to parse '"+fileName+".xml'");
					filePath = getPath(fileName+".xml");
					if(StringUtils.isBlank(filePath)){
						LOG.debug("No properties file or xml file named '"+fileName+"' exists in classpath or java.user.dir '" + System.getProperty("user.dir") + "'.");
						continue;
					}

					CONF_MAP.put(fileName, new XMLConfiguration(filePath));
					continue;
				}
				CONF_MAP.put(fileName, new PropertiesConfiguration(filePath));
			} catch (ConfigurationException e) {
				LOG.error(e, fileName+".properties file parsed error. msg("+e.getMessage()+")", "");
			}
		}
	}

	private static String getPath(String fileName){
		fileName = CONFIGS_WHERE + File.separator + fileName;
		
		String configDir = System.getProperty("project.config.dir");
		String filePath = configDir + File.separator + fileName;
		if(new File(filePath).exists()){
			LOG.debug("find property file for '"+fileName+"' with path '" + filePath +"'");
			return filePath;
		}
		
		String userDir = System.getProperty("user.dir");
		filePath = userDir + File.separator + fileName;
		if(new File(filePath).exists()){
			LOG.debug("find property file for '"+fileName+"' with path '" + filePath +"'");
			return filePath;
		}
		
		URL url = BaseConfig.class.getResource(File.separator+fileName);
		if(url == null){
			url = BaseConfig.class.getClassLoader().getResource(fileName);

			LOG.debug("find property file for '"+fileName+"' with path '" + url +"'");
			return url == null ? null : url.toString();
		}
		LOG.debug("find property file for '"+fileName+"' with path '" + url +"'");
		return url.toString();
	}

	/**
	 * 
	 * @param key *.properties文件中的key
	 * @return 在CONFIG_FILE_NAME_SET这个集合指定的所有配置文件中,挨个查找key的值,返回第一个找到的值. 如果一个都没找到，则返回null
	 */
	public static String getValue(String key){
		return getValue(key, null);
	}

	/**
	 * 
	 * @param key *.properties文件中的key
	 * @param defaultVal 在*.properties中找不到key所对应的值时，返回该值
	 * @return 在FileName这个枚举类指定的所有配置文件中,挨个查找key的值,返回第一个找到的值. 如果一个都没找到，则返回defaultVal
	 */
	public static String getValue(String key, String defaultVal){
		FileName[] fileNames = FileName.values();
		for(FileName fileName : fileNames){
			Configuration config = CONF_MAP.get(fileName);
			
			String value = null;
			
			String[] values = config.getStringArray(key);
			if (values != null && values.length > 1){
				value = StringUtils.join(values, ",");
			}else{
				value = config.getString(key);
			}
			if(!StringUtils.isBlank(value)){
				LOG.debug("find value for key("+key+") in config file '"+fileName+".properties'");
				return value;
			}
		}

		return defaultVal;
	}

}
