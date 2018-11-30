package com.jd.web.framework.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class CacheManager {   
    private static HashMap cacheMap = new HashMap();   
  
    //单实例构造方法   
    private CacheManager() {   
        super();   
    }   
    //得到缓存。同步静态方法   
    private synchronized static Cache getCache(String key) { 
    	return (Cache) cacheMap.get(key);   
    }   
    
  //载入缓存   
    public synchronized static void putCache(String key, Cache obj) {   
        cacheMap.put(key, obj);   
    }   
  
    //获取缓存信息   
    public static Object getCacheInfo(String key) {   
        if (cacheExpired(key)) {   
            return getCache(key).getValue();   
        }else  
            return null;   
    }   
  
    //重写载入缓存信息方法   
    public synchronized static void putCacheInfo(String key,Object value,long...dt){   
    	long timeLong=dt.length>0?dt[0]:10*60*6000+System.currentTimeMillis();
        Cache cache = new Cache(key,value,timeLong);   
        cacheMap.put(key,cache);   
    }   
  
    //判断缓存是否终止   
    public synchronized static boolean cacheExpired(String key) {   
    	Cache cache=getCache(key);
        if (null == cache) { //传入的缓存不存在   
            return false;   
        }   
        long nowDt = System.currentTimeMillis(); //系统当前的毫秒数   
        long cacheDt = cache.getTimeOut(); //缓存内的过期毫秒数   
        if (cacheDt <= 0||cacheDt>nowDt) { //过期时间小于等于零时,或者过期时间大于当前时间时，则为FALSE   
            return true;   
        } else { //大于过期时间 即过期   
            return false;   
        }   
    }   
    
    //获取布尔值的缓存   
    public static boolean getSimpleFlag(String key){   
        try{   
            return (Boolean) cacheMap.get(key);   
        }catch(NullPointerException e){   
            return false;   
        }   
    }   
    
    public static long getServerStartdt(String key){   
        try {   
            return (Long)cacheMap.get(key);   
        } catch (Exception ex) {   
            return 0;   
        }   
    }   
    //设置布尔值的缓存   
    public synchronized static boolean setSimpleFlag(String key,boolean flag){   
        if (flag && getSimpleFlag(key)) {//假如为真不允许被覆盖   
            return false;   
        }else{   
            cacheMap.put(key, flag);   
            return true;   
        }   
    }   
    public synchronized static boolean setSimpleFlag(String key,long serverbegrundt){   
        if (cacheMap.get(key) == null) {   
            cacheMap.put(key,serverbegrundt);   
            return true;   
        }else{   
            return false;   
        }   
    }   
  
  
  
    //清除所有缓存   
    public synchronized static void clearAll() {   
        cacheMap.clear();   
    }   
  
    //清除某一类特定缓存,通过遍历HASHMAP下的所有对象，来判断它的KEY与传入的TYPE是否匹配   
    public synchronized static void clearAll(String type) {   
        Iterator i = cacheMap.entrySet().iterator();   
        String key;   
        ArrayList<String> arr = new ArrayList<String>();   
        try {   
            while (i.hasNext()) {   
                java.util.Map.Entry entry = (java.util.Map.Entry) i.next();   
                key = (String) entry.getKey();   
                if (key.startsWith(type)) { //如果匹配则删除掉   
                    arr.add(key);   
                }   
            }   
            for (int k = 0; k < arr.size(); k++) {   
                clearOnly(arr.get(k));   
            }   
        } catch (Exception ex) {   
            ex.printStackTrace();   
        }   
    }   
  
    //清除指定的缓存   
    public synchronized static void clearOnly(String key) {   
        cacheMap.remove(key);   
    }   
  
  
    //获取缓存对象中的所有键值名称   
    public static ArrayList<String> getCacheAllkey() {   
        ArrayList a = new ArrayList();   
        try {   
            Iterator i = cacheMap.entrySet().iterator();   
            while (i.hasNext()) {   
                java.util.Map.Entry entry = (java.util.Map.Entry) i.next();   
                a.add((String) entry.getKey());   
            }   
        } catch (Exception ex) {} finally {   
            return a;   
        }   
    }   
  
    //获取缓存对象中指定类型 的键值名称   
    public static ArrayList<String> getCacheListkey(String type) {   
        ArrayList a = new ArrayList();   
        String key;   
        try {   
            Iterator i = cacheMap.entrySet().iterator();   
            while (i.hasNext()) {   
                java.util.Map.Entry entry = (java.util.Map.Entry) i.next();   
                key = (String) entry.getKey();   
                if (key.indexOf(type) != -1) {   
                    a.add(key);   
                }   
            }   
        } catch (Exception ex) {} finally {   
            return a;   
        }   
    }   
  
}   
  