package travelDream.web.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean(name="selectionBean")
@RequestScoped
public class SelectionBean {
	
	public String string;
	
	public SelectionBean(){
		string = new String();
	}
	
	public void setString(String string){
		this.string = string;
	}
	
	public String getString(){
		return string;
	}
	
	public String redirect(){
		return string;
	}
	
	
}
