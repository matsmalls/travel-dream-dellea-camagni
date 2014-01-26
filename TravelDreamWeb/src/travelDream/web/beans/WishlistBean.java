package travelDream.web.beans;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import travelDream.ejb.eaos.*;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.ejb.EJB;
import travelDream.ejb.model.*;

@ManagedBean(name="wishlistBean")
@SessionScoped
public class WishlistBean {

	@EJB
	private WishlistMgr wishlistMgr;
	
	@EJB
	private UsrMgr usrMgr;
	
	@EJB
	private ProductMgr productMgr;
	
	private ProductDTO productDTO;
	
	private WishlistDTO wishlist;
	
	private int prezzo;
	
	private Long id;
	
	private String tipo;
	
	protected ProductDTO productDTO() {
        ProductDTO productDTO;
        productDTO = (ProductDTO) FacesContext.getCurrentInstance().getExternalContext()
           .getRequestMap().get("productDTO");

        return (productDTO);
    }
	
	public WishlistBean(){
		productDTO = new ProductDTO();
		wishlist = new WishlistDTO();
	}
	
	public String save(){
		wishlist.setIdProduct(id);
		wishlist.setUser(usrMgr.getUserDTO().getUserId());
		wishlistMgr.save(wishlist);
		return "confermaPacchetto";
	}
	
	

	public ProductDTO getProduct() {
		return productDTO;
	}

	public void setProduct(ProductDTO productDTO) {
		this.productDTO = productDTO;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String modifica(){
		return "modificaPacchetto";
	}
	
	public Integer prezzo(){
		Integer value = productMgr.calcolaPrezzo(productMgr.findPrezzo(productDTO.getCod_escursione()), productMgr.findPrezzo(productDTO.getCod_volo()), productMgr.findPrezzo(productDTO.getCod_soggiorno()));
		String valore = value.toString();
		return value;
	}
	
	public Long getUserPId(){
		return productMgr.findUserPId();
	}
	
	public String redirect(){
		if(tipo == "volo")
			return "prodottoVolo";
		if(tipo == "soggiorno")
			return "prodottoSoggiorno";
		if(tipo == "escursione")
			return "prodottoEscursione";
		if(tipo == "pacchetto")
			return "prodottoPacchetto";
		return "prodotto";
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public void foo(AjaxBehaviorEvent event) { 
	
	    }

	public int getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(int result) {
		this.prezzo = result;
	}
	
	public String modificaPacchetto(){
		wishlist.setIdProduct(id);
		wishlist.setUser(usrMgr.getUserDTO().getUserId());
		wishlistMgr.save(wishlist);
		productMgr.registerUserP(productDTO);
		return "confermaPacchetto";
	}
	
	
}
