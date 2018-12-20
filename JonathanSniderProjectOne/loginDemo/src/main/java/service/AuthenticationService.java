package service;

import beans.Credentials;
import beans.User;

public class AuthenticationService {
	public AuthenticationService()
	{
		
	}
	
	public User isValidUser(Credentials credentials)
	{
		User u=null;
		String username=credentials.getUsername();
		String password=credentials.getPassword();		
		//this is Authentication (does user exist), not Autherization (what can user do)
		//take in credentials and return User to which they belong (if it exists)
		if(credentials.getUsername() !=null && credentials.getPassword() !=null)
		{
			//insert SQL inquiries here to check against employee username/password columns
			//what is in here is fake
			if(username.equals("Merlin") && password.equals("Wizard"))
			{
				u =new User(5,username,"Merlin","Cat","wizzcat@cheeseburger.com");
			}
		}
		return u;
	}
}
