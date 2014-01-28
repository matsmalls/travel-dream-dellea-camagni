package travelDream.web.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import travelDream.ejb.eaos.*;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;

import travelDream.ejb.model.*;

@ManagedBean(name="registerBean")
@RequestScoped
public class RegisterBean {
	
	@EJB
	private UsrMgr usrMgr;
	
	private UserDTO user;
	
	public RegisterBean(){
		user = new UserDTO();
	}
	
	public UserDTO getUser(){
		return this.user;
	}
	
	public void setUser(UserDTO user){
	this.user = user;
	}
	
	public String register()throws Exception{
		usrMgr.register(user);
		return "index";
	}
	
	public String modifica()throws Exception{
		usrMgr.modifica(user);
		return "index";
	}
	
	public UserDTO findUser(){
		return usrMgr.getUserDTO();
	}
	
	public String registerAdmin()throws Exception{
		usrMgr.registerAdmin(user);
		return "index";
	}
	
	
	

}
