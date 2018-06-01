package gmms.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2016/2/21.
 */
public class MyUserDetailService implements UserDetailsService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	// @Autowired
	// private UsersService usersService;

	@Transactional(rollbackFor = Exception.class)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// Users dbUser = usersService.findByUsername(username);
		// if (dbUser == null) {
		// logger.info("{} user not found in db", username);
		// throw new UsernameNotFoundException("");
		// }
		// Collection<GrantedAuthority> auths = new
		// ArrayList<GrantedAuthority>();
		// for (Role role : dbUser.getRoles()) {
		// SimpleGrantedAuthority simpleGrantedAuthority1 = new
		// SimpleGrantedAuthority(role.getName());
		// auths.add(simpleGrantedAuthority1);
		// }
		// User user = new User(dbUser.getUserName(), dbUser.getPassword(),
		// auths);
		return null;
	}
}
