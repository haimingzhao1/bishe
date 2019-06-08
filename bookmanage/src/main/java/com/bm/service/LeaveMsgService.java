package com.bm.service;

import com.bm.dao.TLeaveMsgMapper;
import com.bm.model.TLeaveMsg;
import com.bm.model.TLeaveMsgId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveMsgService {
    @Autowired
    TLeaveMsgMapper tLeaveMsgMapper;

    public int addLeaveMsg(TLeaveMsgId leaveMsg) {
        return tLeaveMsgMapper.insertSelective(leaveMsg);
    }

    public List<TLeaveMsg> findallMsgs() {
        List<TLeaveMsg> leaveMsgs = tLeaveMsgMapper.findallMsgs();
        for (TLeaveMsg leaveMsg : leaveMsgs) {
            if (leaveMsg.getContent().trim().length()>10){
                String submsg = leaveMsg.getContent().trim().substring(10) + "...";
                leaveMsg.setContent(submsg);
            }
        }
        return leaveMsgs;
    }

    public TLeaveMsg findMsgById(Integer id) {
        return tLeaveMsgMapper.findMsgById(id);
    }

    public int deleteLeaveMsgByid(Integer id) {
        return tLeaveMsgMapper.deleteLeaveMsgByid(id);
    }
}
