import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author: 胖虎
 * @date: 2019/5/28 20:23
 **/
public class PasswordTest {

    @Test
    public static void test() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        System.out.println(bCryptPasswordEncoder.encode("hama"));
    }
}
