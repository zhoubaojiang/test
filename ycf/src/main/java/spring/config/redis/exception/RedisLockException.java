package spring.config.redis.exception;

public class RedisLockException extends RuntimeException{
  
  private static final long serialVersionUID = 3961222743813109135L;

  public RedisLockException(String message) {
    super(message);
  }

  public RedisLockException(Throwable e) {
    super(e);
  }

  public RedisLockException(String message, Throwable cause) {
    super(message, cause);
  }

  public static void main(String[] args) {
    byte b = 00000000000000000000000000000001;
    System.out.println(b);
    System.out.println(b <<3);
  }
}
