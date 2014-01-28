package travelDream.ejb.eaos;

import javax.ejb.Stateless;
import java.util.List;
import java.util.ArrayList;
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
    public String modificaEscursione(ProductDTO product){
    	
       Product newProduct = em.createQuery("SELECT p FROM Product p WHERE p.id = :pId", Product.class).setParameter("pId", product.getId()).getSingleResult();
       newProduct.setNome(product.getNome());
       newProduct.setTipo(Tipologia.escursione);
  	   newProduct.setData_arrivo(Timestamp.valueOf(product.getData_arrivo()+" 00:00:00"));
  	   newProduct.setDescrizione(product.getDescrizione());
  	   newProduct.setPrezzo(product.getPrezzo());
  	   newProduct.setLuogo(product.getLuogo());
 	   em.merge(newProduct);
 	   return "index";
 	  
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
    public String modificaVolo(ProductDTO product){
       Product newProduct = em.createQuery("SELECT p FROM Product p WHERE p.id = :pId", Product.class).setParameter("pId", product.getId()).getSingleResult();       newProduct.setTipo(Tipologia.volo);
       newProduct.setNome(product.getNome());
       newProduct.setDescrizione(product.getDescrizione());
  	   newProduct.setPrezzo(product.getPrezzo());
  	   newProduct.setAerop_andata(product.getAerop_andata());
  	   newProduct.setAerop_ritorno(product.getAerop_ritorno());
 	   newProduct.setData_arrivo(Timestamp.valueOf(product.getData_arrivo()));
 	   newProduct.setData_partenza(Timestamp.valueOf(product.getData_partenza()));
 	   em.merge(newProduct);
 	   return "index";
 	  
    }
    
    @Override
    public int calcolaPrezzo(int volo, int soggiorno, int escursione){
    	return volo+soggiorno+escursione;
    }
    
    @Override
    public void registerSoggiorno(ProductDTO product){
 	   Product newProduct = new Product(product);
 	   newProduct.setTipo(Tipologia.soggiorno);
 	  newProduct.setId( product.getId());
 	   newProduct.setData_arrivo(Timestamp.valueOf(product.getData_arrivo()+" 00:00:00"));
 	   newProduct.setData_partenza(Timestamp.valueOf(product.getData_partenza()+" 00:00:00"));
 	   em.persist(newProduct);
 	   
    }
    
    @Override
    public String modificaSoggiorno(ProductDTO product){
       Product newProduct = em.createQuery("SELECT p FROM Product p WHERE p.id = :pId", Product.class).setParameter("pId", product.getId()).getSingleResult();       
       newProduct.setTipo(Tipologia.soggiorno);
       newProduct.setNome(product.getNome());
       newProduct.setDescrizione(product.getDescrizione());
  	   newProduct.setPrezzo(product.getPrezzo());
  	   newProduct.setLuogo(product.getLuogo());
 	   newProduct.setData_arrivo(Timestamp.valueOf(product.getData_arrivo()+" 00:00:00"));
 	   newProduct.setData_partenza(Timestamp.valueOf(product.getData_partenza()+" 00:00:00"));
 	   em.merge(newProduct);
 	   
 	   return "index";
    }
    
    @Override
    public void elimina(ProductDTO product){
    	Product newProduct = em.find(Product.class, product.getId());
    	em.remove(newProduct);
    }
    
    @Override
    public void registerPacchetto(ProductDTO product){
 	   Product newProduct = new Product(product);
 	   newProduct.setTipo(Tipologia.pacchetto);
 	   em.persist(newProduct);
 	   
    }
    
    @Override
    public String modificaPacchetto(ProductDTO product){
       Product newProduct = em.createQuery("SELECT p FROM Product p WHERE p.id = :pId", Product.class).setParameter("pId", product.getId()).getSingleResult();       newProduct.setTipo(Tipologia.pacchetto);
 	   newProduct.setNome(product.getNome());
 	   newProduct.setPrezzo(product.getPrezzo());
 	   newProduct.setCod_escursione(product.getCod_escursione());
 	   newProduct.setCod_soggiorno(product.getCod_soggiorno());
 	   newProduct.setCod_volo(product.getCod_volo());
       em.merge(newProduct);
 	   return "modificaPacchetto";
    }
    
    @Override
    public void registerUserP(ProductDTO product){
 	   Product newProduct = new Product(product);
 	   newProduct.setTipo(Tipologia.user);
 	   em.persist(newProduct);
 	   
    }
    
    @Override
    public List<ProductDTO> findByName(String name){
    	List<Product> tmp = em.createQuery(
    	        "SELECT p FROM Product p WHERE p.nome LIKE :prodName and p.tipo != :tipo", Product.class)
    	        .setParameter("prodName", name+"%").setParameter("tipo", Tipologia.user)
    	        .getResultList();
    	List<ProductDTO> local = new ArrayList<ProductDTO>();
    	for(int i = 0; i<tmp.size(); i++){
    		local.add(Product.convertToDTO(tmp.get(i)));
    	}
    	return local;
    	
    	
    }
    
    @Override
    public Long findUserPId(){
    	return em.createQuery(
    	        "SELECT MAX(p.id) FROM Product p", Long.class).getSingleResult()+1;
    }
    
    @Override
    public ProductDTO findUserP(Long cod){
    	Product tmp = em.createQuery(
    	        "SELECT p FROM Product p WHERE p.id = :id and p.tipo = :tipo", Product.class)
    	        .setParameter("id", cod).setParameter("tipo", Tipologia.user)
    	        .getResultList().get(0);
    	return Product.convertToDTO(tmp);
    	
    	
    }
    
    @Override
    public List<ProductDTO> findSoggiorni(){
    	List<Product> tmp = em.createQuery(
    	        "SELECT p FROM Product p WHERE p.tipo = :tipo", Product.class)
    	        .setParameter("tipo", Tipologia.soggiorno)
    	        .getResultList();
    	List<ProductDTO> local = new ArrayList<ProductDTO>();
    	for(int i = 0; i<tmp.size(); i++){
    		local.add(Product.convertToDTO(tmp.get(i)));
    	}
    	return local;
    	
    	
    }
    
    @Override
    public int findPrezzo(Long id){
    	return em.createQuery(
    	        "SELECT p.prezzo FROM Product p WHERE p.id = :id", int.class)
    	        .setParameter("id", id).getResultList().get(0);
    	        
    }
    
    @Override
    public List<ProductDTO> findVoli(){
    	List<Product> tmp = em.createQuery(
    	        "SELECT p FROM Product p WHERE p.tipo = :tipo", Product.class)
    	        .setParameter("tipo", Tipologia.volo)
    	        .getResultList();
    	List<ProductDTO> local = new ArrayList<ProductDTO>();
    	for(int i = 0; i<tmp.size(); i++){
    		local.add(Product.convertToDTO(tmp.get(i)));
    	}
    	return local;
    	
    	
    }
    
    @Override
    public List<ProductDTO> findEscursioni(){
    	List<Product> tmp = em.createQuery(
    	        "SELECT p FROM Product p WHERE p.tipo = :tipo", Product.class)
    	        .setParameter("tipo", Tipologia.escursione)
    	        .getResultList();
    	List<ProductDTO> local = new ArrayList<ProductDTO>();
    	for(int i = 0; i<tmp.size(); i++){
    		local.add(Product.convertToDTO(tmp.get(i)));
    	}
    	return local;
    	
    	
    }
    
    
    @Override
    public List<ProductDTO> findAll(){
    	List<Product> tmp = em.createQuery(
    	        "SELECT p FROM Product p", Product.class).getResultList();
    	List<ProductDTO> local = new ArrayList<ProductDTO>();
    	for(int i = 0; i<tmp.size(); i++){
    		local.add(Product.convertToDTO(tmp.get(i)));
    	}
    	return local;	
    }
    
  
    
}
