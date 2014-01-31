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
		
		public static String id;
		
		public ProductInsertBean(){
			product = new ProductDTO();
		}
		
		public ProductDTO getProduct(){
			return this.product;
		}
		
		public Long getProductId(){
			return this.product.getId();
		}
		
		public void setProduct(ProductDTO product){
		this.product = product;
		}
		
		public String elimina(){
			productMgr.elimina(product);
			return "modificaProduct?deleted=true";
		}
		
		public String modificaVolo(){
			productMgr.modificaVolo(new Long(id), product);
			return "index";
		}
		
		public String modificaPacchetto(){
			productMgr.modificaPacchetto(new Long(id), product);
			return "index";
		}
		
		public String modificaEscursione(){
			productMgr.modificaEscursione(new Long(id), product);
			return "index";
		}
		
		public String modificaSoggiorno(){
			productMgr.modificaSoggiorno(new Long(id), product);
			return "index";
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
		
		public String registerPacchetto(){
			productMgr.registerPacchetto(product);
			return "home?faces-redirect-true";
		}
		
		public String redirect(){
			if (product.getTipo() == "escursione")
	 			   return "modificaEscursione";
	 	   if (product.getTipo() == "volo")
				   return "modificaVolo";
	 	   if (product.getTipo() == "soggiorno")
				   return "modificaSoggiorno";
	 	   return "modificaPacchetto";
		}

		public String getId() {
			return id;
		}

		public void setId(String idw) {
			id = idw;
		}

		
		
		
}