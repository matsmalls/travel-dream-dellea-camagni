package travelDream.web.beans;

import travelDream.ejb.model.*;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import travelDream.ejb.eaos.ProductMgr;
import travelDream.ejb.eaos.UsrMgr;
import travelDream.ejb.eaos.WishlistMgr;


@ManagedBean(name="tableBean")
@ViewScoped
public class TableBean {
	
	@EJB
	private ProductMgr productMgr;
	
	@EJB
	private WishlistMgr wishlistMgr;
	
	@EJB
	private UsrMgr usrMgr;
	
	
	public List<ProductDTO> getProductsDTO(){
		return productMgr.findByName(SearchBean.ricerca);
		
	}
	
	public List<ProductDTO> getAllProductsDTO(){
		return productMgr.findAll();
	}
	
	public List<WishlistDTO> getWishlistDTO(){
		return wishlistMgr.findWishlist(usrMgr.getUserDTO().getUserId());
	}
	
	public ProductDTO getUserP(){
		return productMgr.findUserP(new Long(SearchBean.ricerca));
		
	}
	
	public List<SelectItem> getSoggiorno(){

		   List<SelectItem> items = new ArrayList<SelectItem>();
		   List<ProductDTO> soggiorniList = productMgr.findSoggiorni();
		    for(ProductDTO product: soggiorniList){
		       items.add(new SelectItem(product.getId(), product.getNome()));
		   }
		   return items;
		}
	
	public List<SelectItem> getVolo(){

		   List<SelectItem> items = new ArrayList<SelectItem>();
		   List<ProductDTO> voliList = productMgr.findVoli();
		    for(ProductDTO product: voliList){
		       items.add(new SelectItem(product.getId(), product.getNome()));
		   }
		   return items;
		}
	
	public List<SelectItem> getEscursione(){

		   List<SelectItem> items = new ArrayList<SelectItem>();
		   List<ProductDTO> escursioniList = productMgr.findEscursioni();
		    for(ProductDTO product: escursioniList){
		       items.add(new SelectItem(product.getId(), product.getNome()));
		   }
		   return items;
		}
}
