package travelDream.ejb.eaos;

import javax.persistence.*;

import travelDream.ejb.model.*;

@Entity
@Table(name="WISHLIST")
public class Wishlist {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private Long idProduct;
	
	@Column(nullable = false)
	private String user;

	public Wishlist(){
		super();
	}
	
	public static Long findId(Wishlist wishlist){
		return wishlist.getIdProduct();
	}
	
	public static WishlistDTO convertToDTO(Wishlist wishlist, String nameProduct){
		WishlistDTO local = new WishlistDTO();
		local.setId(wishlist.getId());
		local.setUser(wishlist.getUser());
		local.setIdProduct(wishlist.getIdProduct());
		local.setNameProduct(nameProduct);
		return local;
	}
	
	public Wishlist(WishlistDTO wishlist){
		this.idProduct = wishlist.getIdProduct();
		this.user = wishlist.getUser();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

}
