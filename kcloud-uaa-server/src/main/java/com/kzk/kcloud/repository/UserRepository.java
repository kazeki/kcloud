package com.kzk.kcloud.repository;

import com.kzk.kcloud.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends org.springframework.data.repository.Repository<User, Long>{
    /**
     * 根据用户名查询用户信息
     * @param username 用户名
     * @return 用户信息
     */
    User findByUsername(String username);
}
