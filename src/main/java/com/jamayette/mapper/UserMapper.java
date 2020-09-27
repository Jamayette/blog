package com.jamayette.mapper;

import com.jamayette.model.User;
import com.jamayette.util.BaseMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {

	@Select("select * from user where id = 1")
	User selectUser(int i);

}
