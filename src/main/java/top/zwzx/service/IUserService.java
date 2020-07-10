package top.zwzx.service;

import top.zwzx.pojo.User;

/**
 * @author zx
 * @date 2020/7/9
 **/
public interface IUserService {
    boolean checkUserName(String name);
    int submitRegister(User user);
    User login(String username,String password);

    /**
     *
     * @param id    用户id
     * @param oldPassword   老密码
     * @param newPassword   新密码
     */
    void changePassword(Integer id,String oldPassword,String newPassword);
}
