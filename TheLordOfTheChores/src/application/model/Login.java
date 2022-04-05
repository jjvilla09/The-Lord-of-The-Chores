package application.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Login {
	private String username=null;
	private String password=null;
	public ArrayList<Login> login =new ArrayList<Login>();
	
	public Login(String username, String password) {
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
	public void loadLogins() throws IOException {
		//get file
		File file = new File("data/users.csv");
		//create buffer reader to read file
		BufferedReader br = new BufferedReader(new FileReader(file));
		//read first line of file
		String line = br.readLine();
		//read through file till null
		while(line != null) {		
			//separate text by each comma
			String separate[] = line.split(",");
			//set text to upper case
			//store text into crossword variables
			Login cross = new Login(separate[0], separate[1]);
			//add information to array list
			login.add(cross);
			// read next line
			line = br.readLine();
		}
		//closer buffer reader
		br.close();
	}
		
	
}
