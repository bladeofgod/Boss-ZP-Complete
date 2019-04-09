package com.bedrock.boss_zp.factory;

import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadCachePoolProxy {

    ThreadPoolExecutor mExecutor;
    private int mCorePoolSize;
    private int mMaximumPoolSize;

    public ThreadCachePoolProxy(int mCorePoolSize, int mMaximumPoolSize) {
        this.mCorePoolSize = mCorePoolSize;
        this.mMaximumPoolSize = mMaximumPoolSize;
    }

    private void initThreadPoolExecutor(){
        if (mExecutor == null || mExecutor.isShutdown() || mExecutor.isTerminated()){
            synchronized (ThreadCachePoolProxy.class){
                if (mExecutor == null || mExecutor.isShutdown() || mExecutor.isTerminated()){
                    long keepAlive = 60L;
                    TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                    mExecutor = new ThreadPoolExecutor(0,
                            Integer.MAX_VALUE,
                            keepAlive,
                            timeUnit,
                            new SynchronousQueue<Runnable>());
                }
            }
        }
    }


    public void execute(Runnable task){
        initThreadPoolExecutor();
        mExecutor.execute(task);
    }

    public Future submit(Runnable task){
        initThreadPoolExecutor();
        return mExecutor.submit(task);
    }
    public void remove(Runnable task){
        initThreadPoolExecutor();
        mExecutor.remove(task);
    }
}
