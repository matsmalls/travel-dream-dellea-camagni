package travelDream.ejb.eaos;

import javax.ejb.Local;

import travelDream.ejb.model.*;

@Local
public interface UsrMgr {
	public void register(UserDTO user);
	public UserDTO getUserDTO();
	
}
