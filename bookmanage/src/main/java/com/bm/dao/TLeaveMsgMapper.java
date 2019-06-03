package com.bm.dao;

import com.bm.model.TLeaveMsg;
import com.bm.model.TLeaveMsgId;

public interface TLeaveMsgMapper {
    int insertSelective(TLeaveMsgId record);
}
