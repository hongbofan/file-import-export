package com.flyread.file.imp0rt.model;

import java.util.Map;
import java.util.jar.Pack200;

/**
 * @author by hongbf on 2018/3/30.
 */
public abstract class BaseImportRow {
    private Map<String,Object> map;


    public abstract Object get(int idx);
    public Object get(String key) {
        if (headerMatch(key)) {
            return map.get(key);
        }
        return null;
    }
    public void set(String key,Object val) {
        if (headerMatch(key)) {
            map.put(key,val);
        }
    }
    public abstract Object[] asArray();
    public abstract int size();

    public boolean headerMatch(String key) {

        return map != null && !map.isEmpty() && map.containsKey(key);
    }
    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }
}
