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
		
		public String elimina(){
			productMgr.elimina(product);
			return "modificaProduct?deleted=true";
		}
		
		public String modificaVolo(){
			productMgr.modificaVolo(product);
			return "index";
		}
		
		public String modificaPacchetto(){
			productMgr.modificaPacchetto(product);
			return "index";
		}
		
		public String modificaEscursione(){
			productMgr.modificaEscursione(product);
			return "index";
		}
		
		public String modificaSoggiorno(){
			productMgr.modificaSoggiorno(product);
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

		
		
		
}