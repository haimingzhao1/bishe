package com.bm.dao;

import com.bm.model.TLeaveMsg;
import com.bm.model.TLeaveMsgId;

import java.util.List;

public interface TLeaveMsgMapper {
    int insertSelective(TLeaveMsgId record);

    List<TLeaveMsg> findallMsgs();

    TLeaveMsg findMsgById(Integer id);

    int deleteLeaveMsgByid(Integer id);
}
