package comdamianangeloneinfitness.httpsgithub.infitness;

/**
 * Created by Damian on 2017-04-05.
 */

public class UserProfile {

    public String name;
    public String address;
    public String email;
    public String number;
    public String password;
    public String password2;

    public UserProfile(){

        name = "";
        number = "";
        email = "";
        address = "";
        password = "";
        password2 = "";
    }

    public UserProfile(String userName, String userNumber, String userEmail, String userAddress, String userPassword, String userPassword2){

        name = userName;
        number = userNumber;
        email = userEmail;
        address = userAddress;
        password = userPassword;
        password2 = userPassword2;
    }

}
