package travelDream.web.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import travelDream.ejb.eaos.*;
import javax.ejb.EJB;


@ManagedBean
@RequestScoped
public class UserBean {

		@EJB
		private UsrMgr usrMgr;
		
		public String getNome(){
			return usrMgr.getUserDTO().getNome();
		}
}
