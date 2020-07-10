package top.zwzx.service.ex;

/**
 * @author zx
 * @date 2020/7/10
 **/
public class PasswordNotMatchException extends RuntimeException {

    private static final long serialVersionUID = -6424398449118680972L;

    public PasswordNotMatchException(){

    }

    public PasswordNotMatchException(String message){
        super(message);
    }
}
