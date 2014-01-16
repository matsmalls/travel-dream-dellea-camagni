package travelDream.ejb.eaos;

import javax.ejb.Stateless;
import javax.persistence.*;
import travelDream.ejb.model.*;
import java.util.*;
import javax.annotation.Resource;
import javax.ejb.EJBContext;

/**
 * Session Bean implementation class UsrMgrBean
 */
@Stateless
public class UsrMgrBean implements UsrMgr {

    /**
     * Default constructor. 
     */
    public UsrMgrBean() {
        // TODO Auto-generated constructor stub
    }

    
   @PersistenceContext
   private EntityManager em;
   
   @Resource 
   private EJBContext context;
   
   @Override
   public void register(UserDTO user){
	   User newUser = new User(user);
	   List<Group> groups = new ArrayList<Group>();
	   groups.add(Group.user);
	   newUser.setGroups(groups);
	   em.persist(newUser);
	   
   }
   
   @Override
   public UserDTO getUserDTO(){
	   UserDTO userDTO = convertToDTO(find(getPrincipalUser()));
	   return userDTO;
   }
   
   public String getPrincipalUser(){
	   return context.getCallerPrincipal().getName();
   }
   
   public User find(String userId){
	   return em.find(User.class, userId);
   }
   
   public UserDTO convertToDTO(User user){
	UserDTO userDTO = new UserDTO();
	userDTO.setCognome(user.getCognome());
	userDTO.setEmail(user.getEmail());
	userDTO.setNome(user.getNome());
	userDTO.setPassword(user.getPassword());
	userDTO.setUserId(user.getUserId());
	return userDTO;
   }
}
