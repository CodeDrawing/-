package top.zwzx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zwzx.mapper.UserMapper;
import top.zwzx.pojo.User;
import top.zwzx.service.ex.PasswordNotMatchException;
import top.zwzx.service.ex.UserNameAlreadyExistException;
import top.zwzx.service.ex.UserNotFoundException;

/**
 * @author zx
 * @date 2020/7/9
 **/
@Service
public class UserServiceImpl implements IUserService {
@Autowired
    public UserMapper userMapper;
    public void setUserMapper(UserMapper userMapper) {
    }

    @Override
    public boolean checkUserName(String name) {

        return userMapper.selectUserByUsername(name)!=null;

    }

    @Override
    public int submitRegister(User user) {
//        判断用户存不存在
        if(userMapper.selectUserByUsername(user.getUsername())==null){
            int i = userMapper.submitRegister(user);
            return i;
        }else{
            throw new UserNameAlreadyExistException("用户名已经存在");
        }
    }

    @Override
    public User login(String username, String password) {
        User user=userMapper.selectUserByUsername(username);
        if(user==null){
            throw new UserNotFoundException("用户名不存在");
        }else {
            if(user.getPassword().equals(password)){
                return user;
            }else{
                throw new PasswordNotMatchException("密码不匹配");
            }
        }
    }

    @Override
    public void changePassword(Integer id, String oldPassword, String newPassword) {
        //根据id查询
        User user = userMapper.selectById(id);
        if(user==null){//查不到
            throw new UserNotFoundException("用户不存在");
        }else {//查懂啊
            if(user.getPassword().equals(oldPassword)){//密码相同
                User user1 = new User();
                user1.setId(id);
                user1.setPassword(newPassword);
                userMapper.updateUser(user1);
            }else{//密码不相同

            }
        }
    }


}
