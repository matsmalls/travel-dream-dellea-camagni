package travelDream.web.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import travelDream.ejb.eaos.*;
import travelDream.ejb.model.ProductDTO;

import javax.ejb.EJB;


@ManagedBean(name="productInsertBean")
@RequestScoped
public class ProductInsertBean {

		@EJB
		private ProductMgr productMgr;
		
		private ProductDTO product;
		
		public ProductInsertBean(){
			product = new ProductDTO();
		}
		
		public ProductDTO getProduct(){
			return this.product;
		}
		
		public void setProduct(ProductDTO product){
		this.product = product;
		}
		
		public String registerVolo(){
			productMgr.registerVolo(product);
			return "home?faces-redirect-true";
		}
		
		public String registerEscursione(){
			productMgr.registerEscursione(product);
			return "home?faces-redirect-true";
		}
		
		public String registerSoggiorno(){
			productMgr.registerSoggiorno(product);
			return "home?faces-redirect-true";
		}
		
		
}