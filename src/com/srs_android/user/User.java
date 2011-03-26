package com.srs_android.user;

// Holds information about the user using the device
public class User {

	private int id;
	private String userName;
	private String userFirstName;
	private String userLastName;
	private String primaryDevice;
	private String secondaryDevice;
	private String userRole;
	private String userClass;
	private String userPassword;
	private boolean questionAvailable;
	
	public String userName() {
		return userName;
	}
	public void userName(String userName) {
		this.userName = userName;
	}
	
	public String userPassword() {
		return userPassword;
	}
	public void userPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String userFirstName() {
		return userFirstName;
	}
	public void userFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}
	public String userLastName() {
		return userLastName;
	}
	public void userLastName(String userLastName) {
		this.userLastName = userLastName;
	}
	public String primaryDevice() {
		return primaryDevice;
	}
	public void primaryDevice(String primaryDevice) {
		this.primaryDevice = primaryDevice;
	}
	public String secondaryDevice() {
		return secondaryDevice;
	}
	public void secondaryDevice(String secondaryDevice) {
		this.secondaryDevice = secondaryDevice;
	}
	public String userRole() {
		return userRole;
	}
	public void userRole(String userRole) {
		this.userRole = userRole;
	}
	public String userClass() {
		return userClass;
	}
	public void userClass(String userClass) {
		this.userClass = userClass;
	}
	public int id() {
		return id;
	}
	public void id(int id) {
		this.id = id;
	}
	public boolean questionAvailable() {
		return questionAvailable;
	}
	public void questionAvailable(boolean questionAvailable) {
		this.questionAvailable = questionAvailable;
	}
	
}
