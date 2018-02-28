import com.example.mapwithmarker.MainActivity;
import com.example.mapwithmarker.RegisterActivity;
import com.example.mapwithmarker.UserLoginInfo;

import junit.framework.TestCase;

import static com.example.mapwithmarker.MainActivity.getMyPassword;
import static com.example.mapwithmarker.RegisterActivity.setUsernamePassword;

/**
 * Created by operam on 12/16/2017.
 */

public class LoginTest extends TestCase{
    RegisterActivity a;
    MainActivity b;

    @Override
    public void setUp()throws Exception{
        super.setUp();
        a = new RegisterActivity();
        b =  new MainActivity();
    }
    //makes sure user info is correct inputted
    public void testUserInfo() {
        setUsernamePassword(a.getApplicationContext(),"Derp","Stack");
        String password = getMyPassword(b.getApplicationContext(), "Derp");
        assertTrue(password.equals("Stack"));

    }

    @Override
    public void tearDown() throws Exception{
        super.tearDown();
    }

}
