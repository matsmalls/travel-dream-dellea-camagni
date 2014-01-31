package travelDream.ejb.model;

public class WishlistDTO {
	
	private Long id;
	
	private Long idProduct;
	
	private String user;
	
	private String nameProduct;

	private ProductDTO product;
	
	public WishlistDTO(){
		super();
	}
	
	public WishlistDTO(ProductDTO product, UserDTO user){
		this.idProduct = product.getId();
		this.user = user.getUserId();
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

	public void setIdProduct(Long id) {
		this.idProduct = id;
	}
	
	public void setIdProduct(ProductDTO product) {
		this.idProduct = product.getId();
	}

	public String getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user.getUserId();
	}
	
	public void setUser(String user) {
		this.user = user;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public ProductDTO getProduct() {
		return product;
	}

	public void setProduct(ProductDTO product) {
		this.product = product;
	}
}
