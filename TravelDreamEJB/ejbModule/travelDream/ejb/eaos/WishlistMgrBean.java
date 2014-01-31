package travelDream.ejb.eaos;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.*;

import travelDream.ejb.model.*;

import javax.annotation.Resource;
import javax.ejb.EJBContext;

/**
 * Session Bean implementation class WishlistMgrBean
 */
@Stateless
public class WishlistMgrBean implements WishlistMgr {

    /**
     * Default constructor. 
     */
    public WishlistMgrBean() {
        // TODO Auto-generated constructor stub
    }

    @PersistenceContext
    private EntityManager em;
    
    @Resource 
    private EJBContext context;
    
    @Override
    public void save(WishlistDTO wishlist){
 	   Wishlist newWishlist = new Wishlist(wishlist);
 	   em.persist(newWishlist);
    }
    
    @Override
    public String nameProduct(Long id){
    	return em.createQuery(
    	        "SELECT p.nome FROM Product p WHERE p.id = :id", String.class)
    	        .setParameter("id", id).getResultList().get(0);
    	        
    }
    
    @Override
    public void elimina(WishlistDTO wishlist){
    	Wishlist newWishlist = em.find(Wishlist.class, wishlist.getId());
    	em.remove(newWishlist);
    }
    
    @Override
    public List<WishlistDTO> findWishlist(String user){
    	List<Wishlist> tmp = em.createQuery(
    	        "SELECT w FROM Wishlist w WHERE w.user = :user", Wishlist.class)
    	        .setParameter("user", user)
    	        .getResultList();
    	List<Long> tmpId = em.createQuery(
    	        "SELECT w.idProduct FROM Wishlist w WHERE w.user = :user", Long.class)
    	        .setParameter("user", user)
    	        .getResultList();
    	List<WishlistDTO> local = new ArrayList<WishlistDTO>();
    	for(int i = 0; i<tmp.size(); i++){
    		local.add(Wishlist.convertToDTO(tmp.get(i), nameProduct(tmpId.get(i))));
    	}
    	return local;
    }
}
