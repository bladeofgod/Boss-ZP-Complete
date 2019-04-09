package com.bedrock.boss_zp.factory;

public class ThreadPoolProxyFactory {

    static ThreadPoolProxy normalThreadPoolProxy;
    static ThreadCachePoolProxy cachePoolProxy;


    public static ThreadPoolProxy getNormalThreadPoolProxy(){
        if (normalThreadPoolProxy == null){
            synchronized (ThreadPoolProxyFactory.class){
                if (normalThreadPoolProxy == null){
                    normalThreadPoolProxy = new ThreadPoolProxy(3,5);
                }
            }
        }

        return normalThreadPoolProxy;
    }

    public static ThreadCachePoolProxy getCacheThreadPoolProxy(){
        if (cachePoolProxy == null){
            synchronized (ThreadPoolProxyFactory.class){
                if (cachePoolProxy == null){
                    cachePoolProxy = new ThreadCachePoolProxy(0,Integer.MAX_VALUE);
                }
            }
        }
        return cachePoolProxy;
    }



}
