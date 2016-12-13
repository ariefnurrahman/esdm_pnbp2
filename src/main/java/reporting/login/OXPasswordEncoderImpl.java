package reporting.login;

import java.io.Serializable;

import org.springframework.security.crypto.password.PasswordEncoder;

public class OXPasswordEncoderImpl implements PasswordEncoder, Serializable {

	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public OXPasswordEncoderImpl() {
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		if (encode(rawPassword).equals(encodedPassword)) {
			return true;
		} else
			return false;
	}

	@Override
	public String encode(CharSequence _rawPassword) {
		String encrypted = OXSHA1Utils.encrypt(_rawPassword);
		return encrypted;
	}
}
