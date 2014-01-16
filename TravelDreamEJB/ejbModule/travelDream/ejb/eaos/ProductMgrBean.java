package travelDream.ejb.eaos;

import javax.ejb.Stateless;

import java.sql.Timestamp;
import javax.persistence.*;
import travelDream.ejb.model.*;



/**
 * Session Bean implementation class ProductMgrBean
 */
@Stateless
public class ProductMgrBean implements ProductMgr {

    /**
     * Default constructor. 
     */
    public ProductMgrBean() {
        // TODO Auto-generated constructor stub
    }

    @PersistenceContext
    private EntityManager em;
       
    @Override
    public void registerEscursione(ProductDTO product){
 	   Product newProduct = new Product(product);
 	   newProduct.setTipo(Tipologia.escursione);
 	  newProduct.setData_arrivo(Timestamp.valueOf(product.getData_arrivo()+" 00:00:00"));
 	   em.persist(newProduct);
 	   
    }
    
    @Override
    public void registerVolo(ProductDTO product){
 	   Product newProduct = new Product(product);
 	   newProduct.setTipo(Tipologia.volo);
 	   newProduct.setData_arrivo(Timestamp.valueOf(product.getData_arrivo()));
 	   newProduct.setData_partenza(Timestamp.valueOf(product.getData_partenza()));
 	   em.persist(newProduct);
 	   
    }
    
    @Override
    public void registerSoggiorno(ProductDTO product){
 	   Product newProduct = new Product(product);
 	   newProduct.setTipo(Tipologia.soggiorno);
 	   newProduct.setData_arrivo(Timestamp.valueOf(product.getData_arrivo()+" 00:00:00"));
 	   newProduct.setData_partenza(Timestamp.valueOf(product.getData_partenza()+" 00:00:00"));
 	   em.persist(newProduct);
 	   
    }
}
