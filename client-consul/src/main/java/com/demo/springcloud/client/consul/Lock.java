package com.demo.springcloud.client.consul;

import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.kv.model.PutParams;
import com.ecwid.consul.v1.session.model.NewSession;

import java.time.LocalDateTime;

public class Lock {

    private static final String prefix = "lock/";  // 同步锁参数前缀

    private ConsulClient consulClient;
    private String sessionName;
    private String sessionId = null;
    private String lockKey;

    /**
     *
     * @param consulClient
     * @param sessionName   同步锁的session名称
     * @param lockKey       同步锁在consul的KV存储中的Key路径，会自动增加prefix前缀，方便归类查询
     */
    public Lock(ConsulClient consulClient, String sessionName, String lockKey) {
        this.consulClient = consulClient;
        this.sessionName = sessionName;
        this.lockKey = prefix + lockKey;
    }

    /**
     * 获取同步锁
     *
     * @param block     是否阻塞，直到获取到锁为止
     * @return
     */
    public Boolean lock(boolean block) {
        if (sessionId != null) {
            throw new RuntimeException(sessionId + " - Already locked!");
        }
        sessionId = createSession(sessionName);
        while(true) {
            PutParams putParams = new PutParams();
            putParams.setAcquireSession(sessionId);
            String value = "lock:" + LocalDateTime.now();
            if(consulClient.setKVValue(lockKey, value, putParams).getValue()) {
                return true;
            } else if(block) {
                continue;
            } else {
                return false;
            }
        }
    }

    /**
     * 释放同步锁
     *
     * @return
     */
    public boolean unlock() {
        PutParams putParams = new PutParams();
        putParams.setReleaseSession(sessionId);
        String value = "unlock:" + LocalDateTime.now();
        boolean result = consulClient.setKVValue(lockKey, value, putParams).getValue();
        consulClient.sessionDestroy(sessionId, null);
        return result;
    }

    /**
     * 创建session
     * @param sessionName
     * @return
     */
    private String createSession(String sessionName) {
        NewSession newSession = new NewSession();
        newSession.setName(sessionName);
        return consulClient.sessionCreate(newSession, null).getValue();
    }

}