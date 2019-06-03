package com.bm.service;

import com.bm.dao.TLeaveMsgMapper;
import com.bm.model.TLeaveMsg;
import com.bm.model.TLeaveMsgId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeaveMsgService {
    @Autowired
    TLeaveMsgMapper tLeaveMsgMapper;

    public int addLeaveMsg(TLeaveMsgId leaveMsg) {
        return tLeaveMsgMapper.insertSelective(leaveMsg);
    }
}
