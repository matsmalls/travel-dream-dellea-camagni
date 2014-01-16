package travelDream.ejb.eaos;

import javax.ejb.Local;

import travelDream.ejb.model.*;

@Local
public interface ProductMgr {
	
	public void registerEscursione(ProductDTO product);

	public void registerVolo(ProductDTO product);
	
	public void registerSoggiorno(ProductDTO product);
}
