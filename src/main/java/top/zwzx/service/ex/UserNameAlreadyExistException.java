package top.zwzx.service.ex;

/**
 * @author zx
 * @date 2020/7/10
 **/
public class UserNameAlreadyExistException extends RuntimeException {


    private static final long serialVersionUID = -244471910409940114L;
    public UserNameAlreadyExistException(){

    }
    public UserNameAlreadyExistException(String message){
        super(message);
    }
}
