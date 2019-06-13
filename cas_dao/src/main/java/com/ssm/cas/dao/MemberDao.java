package com.ssm.cas.dao;

import com.ssm.cas.domain.Member;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author: 胖虎
 * @date: 2019/5/25 22:08
 **/
@Repository
public interface MemberDao {


    @Select("select * from member where id=#{memberId}")
    Member findById(String memberId) throws Exception;

}
