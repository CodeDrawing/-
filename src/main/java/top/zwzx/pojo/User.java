package top.zwzx.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * @author zx
 * @date 2020/7/9
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {


    private Integer id;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String image;
    private Integer gender;
    private String created_user;
    private Date created_time;
    private String modified_user;
    private Date modified_time;


}
