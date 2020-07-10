package top.zwzx.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author zx
 * @date 2020/7/9
 **/

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResponseResult<T> implements Serializable {
    private static final long serialVersionUID = -2159275073745569709L;
    private Integer state;
    private String message;
    private T data;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
