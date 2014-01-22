package travelDream.web.beans;

import travelDream.ejb.model.*;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import travelDream.ejb.eaos.ProductMgr;


@ManagedBean(name="searchBean")
@RequestScoped
public class SearchBean {

	@EJB
	private ProductMgr productMgr;
	
	private String ricerca;
	
	private ProductDTO prodotto;
	
	public void setRicerca(String ricerca){
		this.ricerca = ricerca;
	}
	
	public String getRicerca(){
		return this.ricerca;
	}
	
	public void setProdotto(ProductDTO prodotto){
		this.prodotto = prodotto;
	}
	
	public ProductDTO getProdotto(){
		return this.prodotto;
	}
	
	public List<ProductDTO> getProductsDTO(){
		return productMgr.findByName(ricerca);
		
	}
	
	public String redirect(){
		return "showRicerca";
	}
}
