package travelDream.ejb.eaos;

import javax.ejb.Local;

import travelDream.ejb.model.*;

@Local
public interface UsrMgr {
	public void register(UserDTO user)throws Exception;
	public UserDTO getUserDTO();
	public void modifica(UserDTO user)throws Exception;
	public void registerAdmin(UserDTO user)throws Exception;
}
