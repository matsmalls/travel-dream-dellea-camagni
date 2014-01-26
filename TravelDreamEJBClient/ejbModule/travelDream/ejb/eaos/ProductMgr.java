package travelDream.ejb.eaos;

import javax.ejb.Local;
import java.util.List;
import travelDream.ejb.model.*;

@Local
public interface ProductMgr {
	
	public void registerEscursione(ProductDTO product);

	public void registerVolo(ProductDTO product);
	
	public void registerSoggiorno(ProductDTO product);
	
	public void registerPacchetto(ProductDTO product);
	
	public void registerUserP(ProductDTO product);
	
	public List<ProductDTO> findByName(String name);
	
	public List<ProductDTO> findAll();
	
	public List<ProductDTO> findEscursioni();
	
	public List<ProductDTO> findSoggiorni();
	
	public List<ProductDTO> findVoli();
	
	public ProductDTO findUserP(Long cod);
	
	public Long findUserPId();
	
	public int findPrezzo(Long id);
	
	public int calcolaPrezzo(int volo, int soggiorno, int escursione);

	public void elimina(ProductDTO product);
}
