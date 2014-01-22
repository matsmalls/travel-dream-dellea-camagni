package travelDream.web.beans;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import travelDream.ejb.eaos.*;
import javax.faces.context.FacesContext;
import javax.ejb.EJB;
import travelDream.ejb.model.*;

@ManagedBean(name="wishlistBean")
@RequestScoped
public class WishlistBean {

	@EJB
	private WishlistMgr wishlistMgr;
	
	@EJB
	private UsrMgr usrMgr;

	private WishlistDTO wishlist;
	
	private ProductDTO product;
	
	
	
	public WishlistBean(){
		wishlist = new WishlistDTO();
		wishlist.setIdProduct(new Long(1));
		wishlist.setUser("user");
		
	}
	
	protected ProductDTO productDTO() {
        ProductDTO productDTO;
        productDTO = (ProductDTO) FacesContext.getCurrentInstance().getExternalContext()
           .getRequestMap().get("productDTO");

        return (productDTO);
    }
	
	public String save(){
		// wishlist = new WishlistDTO(product, usrMgr.getUserDTO());
		wishlistMgr.save(wishlist);
		return "index";
	}

	public WishlistDTO getWishlist() {
		return wishlist;
	}

	public void setWishlist(WishlistDTO wishlist) {
		this.wishlist = wishlist;
	}

	public ProductDTO getProduct() {
		return product;
	}

	public void setProduct(ProductDTO product) {
		this.product = product;
	}
	
}
