package Controller.Protection.auth.Service;

import Controller.Protection.Entities.User;
import Controller.Protection.Repository.UserRepository;
import Controller.Protection.auth.Entities.LoginDTO;
import Controller.Protection.auth.Entities.LoginRTO;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
public class LoginService {

    public static final String JWT_SECRET = "b45f8afd-2e3b-423e-bc46-7887b3923643";
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    public LoginRTO login(LoginDTO loginDTO) throws Exception{
        if(loginDTO == null) return null;
        User user = userRepository.findByEmail(loginDTO.getEmail());
        if(user == null || !user.isActive()) return null;
        boolean canLogin = this.canUserLogin(user, loginDTO.getPassword());
        if(!canLogin) return null;
        String JWT = generateJWT(user);
        user.setPassword(null);
        LoginRTO out = new LoginRTO();
        out.setJwt(JWT);
        out.setUser(user);
        return out;
    }

    public boolean canUserLogin(User user, String password){
        return passwordEncoder.matches(password,user.getPassword());
    }

    public String generateJWT(User user){
        String JWT = getJWT(user);
        user.setJwtCreatedOn(LocalDateTime.now());
        userRepository.save(user);
        return JWT;
    }

    public static Date convertToDateViaInstant(LocalDateTime dateTime){
        return Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static String getJWT(User user) {
        Date expire = convertToDateViaInstant(LocalDateTime.now().plusDays(15));
        return JWT.create().withIssuer("develhope-demo").withIssuedAt(new Date()).withExpiresAt(expire)
                .withClaim("id", user.getId()).sign(Algorithm.HMAC512(JWT_SECRET));
    }
}
