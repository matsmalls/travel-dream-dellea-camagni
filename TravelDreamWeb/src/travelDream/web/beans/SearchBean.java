package travelDream.web.beans;

import travelDream.ejb.model.*;
import travelDream.ejb.eaos.*;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import travelDream.ejb.eaos.ProductMgr;


@ManagedBean(name="searchBean")
@SessionScoped
public class SearchBean {

	@EJB
	private ProductMgr productMgr;
	
	@EJB
	private WishlistMgr wishlistMgr;
	
	public static String ricerca;
	
	private ProductDTO prodotto;
	
	public String findNome(Long id){
		return wishlistMgr.nameProduct(id);
		
	}
	
	public void setRicerca(String search){
		ricerca = search;
	}
	
	public String getRicerca(){
		return ricerca;
	}
	
	public void setProdotto(ProductDTO prodotto){
		this.prodotto = prodotto;
	}
	
	public ProductDTO getProdotto(){
		return this.prodotto;
	}

	
	public String redirect(){
		return "showRicerca?logged=true";
	}
}
