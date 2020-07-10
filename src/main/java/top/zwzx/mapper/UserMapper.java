package top.zwzx.mapper;

import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Component;
import top.zwzx.pojo.User;

/**
 * @author zx
 * @date 2020/7/9
 **/

public interface UserMapper {
    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    User selectUserByUsername(String username);
    int submitRegister(User user);
    void updateUser(User user);

    /**
     * 根据id查询用户信息
     * @param id 用户的id
     * @return
     */
    User selectById(Integer id);
}
