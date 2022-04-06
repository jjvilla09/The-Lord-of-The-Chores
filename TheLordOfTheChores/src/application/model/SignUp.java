package application.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class SignUp {
	private String username=null;
	private String password=null;
	//private static HashMap<String, String> store =new HashMap<String,String>();
	
	public SignUp(String username, String password) {
		this.username = username;
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public void storePassword() throws IOException {
		//store.put(this.username,this.password);
		String acc = this.username + "," + this.password + "\n";
		File file = new File("data/users.txt");
		FileWriter wFile = new FileWriter(file,true);
		System.out.println(acc);
		wFile.write(acc);
		wFile.close();
	}
}
