package travelDream.ejb.eaos;

import java.util.List;

import javax.ejb.Local;

import travelDream.ejb.model.WishlistDTO;

@Local
public interface WishlistMgr {
	public void save(WishlistDTO wishlist);
	public List<WishlistDTO> findWishlist(String user);
}
