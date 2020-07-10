package top.zwzx.service.ex;

/**
 * @author zx
 * @date 2020/7/10
 **/
public class UserNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 5309041156061861629L;

    public UserNotFoundException(){
        super();
    }
    public UserNotFoundException(String message){
        super(message);
    }
}
