package reporting.login;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class myUserDetailsService implements UserDetailsService, Serializable{

	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		// TODO Auto-generated method stub

		// Map<String, Object> userMap = userService.getUserByUsername(arg0);

		// check if this user with this username exist, if not, throw an
		// exception
		// and stop the login process

		// Dummy userMap
		
		User user =  null;
		System.out.println("Login : " + arg0);
		try {
			Map<String, String> userMap = new HashMap<>();
			userMap.put("username", "admin");
			userMap.put("password", "admin123");
			userMap.put("role", "admin");
			
			if (userMap == null) {
				throw new UsernameNotFoundException("User details not found with this username: " + arg0);
			}
	
			String username = (String) userMap.get("username");
			String password = (String) userMap.get("password");
			String role = (String) userMap.get("role");
	
			List<SimpleGrantedAuthority> authList = getAuthorities(role);
	
			// get the encoded password
			//String encodedPassword = passwordEncoder.encode(password);
	
			//User user = new User(username, encodedPassword, authList);
			user = new User(username, password, authList);
		} catch (final NumberFormatException e) {
			throw new DataRetrievalFailureException("Cannot loadUserByUsername userId:" + arg0 + " Exception:" + e.getMessage(), e);
		}
		
		return user;
	}
	
	private List<SimpleGrantedAuthority> getAuthorities(String role) {
        List<SimpleGrantedAuthority> authList = new ArrayList<>();
        authList.add(new SimpleGrantedAuthority("ROLE_USER"));
 
        //you can also add different roles here
        //for example, the user is also an admin of the site, then you can add ROLE_ADMIN
        //so that he can view pages that are ROLE_ADMIN specific
        if (role != null && role.trim().length() > 0) {
            if (role.equals("admin")) {
                authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            }
        }
 
        return authList;
    }

}
