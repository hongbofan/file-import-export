/*
package com.flyread.file.config.builder;

import com.flyread.file.config.parsing.XNode;
import com.flyread.file.config.parsing.XPathParser;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

*/
/**
 * @author by hongbf on 2018/5/3.
 *//*

public class XMLConfigBuilder {

    private XPathParser parser;
    private Configuration configuration;


    public XMLConfigBuilder(InputStream inputStream) {
        this(new XPathParser(inputStream));
    }

    public XMLConfigBuilder(XPathParser parser) {
        this.parser = parser;
    }

    public Configuration parse() {
        parseConfiguration(parser.evalNode("/configuration"));
        return configuration;
    }
    private void parseConfiguration(XNode root) {
        try {
            if (this.configuration == null) {
                this.configuration = new Configuration();
            }
            Properties settings = root.evalNode("settings").getChildrenAsProperties();
            List<XNode> mapper = root.evalNode("mapper").getChildren();
            List<XNode> handlers = root.evalNode("handlers").getChildren();
            settingsElement(settings);
            headerMapElement(mapper);
            handlersElement(handlers);
        } catch (Exception e) {
            throw new RuntimeException("Error parsing Configuration. Cause: " + e, e);
        }
    }
    private void settingsElement(Properties props) throws Exception {
        this.configuration.setImportFileCharset(props.getProperty("importFileCharset","UTF-8"));
        String clazzName = props.getProperty("clazzName");
        if (clazzName == null || "".endsWith(clazzName)) {
            throw new RuntimeException("class name is empty");
        }
        this.configuration.setClazzName(clazzName);
        this.configuration.setSeparator(props.getProperty("separator"," "));
    }
    private void headerMapElement(List<XNode> nodes) throws Exception {
        Map<String,String> map = new HashMap<>();
        nodes.stream().forEach(n -> {
            String key = n.getStringAttribute("key");
            String value = n.getStringAttribute("value");
            map.put(key,value);
        });
        this.configuration.setHeaderMap(map);
    }
    private void handlersElement(List<XNode> nodes) throws Exception {
        nodes.stream().forEach(n -> {
            String name = n.getStringAttribute("name");
            Integer index = n.getIntAttribute("index");
        });

    }
}
*/
