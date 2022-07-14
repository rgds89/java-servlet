package br.com.alura.gerenciador.domain;

public class User {
	private String login;
	private String password;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEquals(String login, String password) {

		return login.equals(login) ? password.equals(password) ? true : false : false;

//        if(!this.login.equals(login)) {
//            return false;
//        }
//
//        if(!this.password.equals(password)) {
//            return false;
//        }
//
//        return true;
	}

}
