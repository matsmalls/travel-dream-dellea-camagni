package travelDream.ejb.eaos;


import javax.persistence.*;

import travelDream.ejb.model.ProductDTO;


import java.sql.Timestamp;


/**
 * The persistent class for the USERS database table.
 * 
 */

@Entity
@Table(name="PRODUCTS")
public class Product{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private String nome;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable=false)
	private Tipologia tipo;
	
	@Column(nullable=false)
	private int prezzo;
	
	private String descrizione;
	
	private Timestamp data_arrivo;
	
	
	private Timestamp data_partenza;
	
	private String aerop_andata;
	private String aerop_ritorno;
	private String luogo;
	private Long cod_volo;
	private Long cod_soggiorno;
	private Long cod_escursione;
	
	public Product(){
		super();
	}
	
	public static ProductDTO convertToDTO(Product product){
		ProductDTO local = new ProductDTO();
		local.setId(product.getId());
		local.setNome(product.getNome());
		local.setPrezzo(product.getPrezzo());
		local.setTipo(product.getTipo().name());
		local.setDescrizione(product.getDescrizione());
		local.setAerop_andata(product.getAerop_andata());
		local.setAerop_ritorno(product.getAerop_ritorno());
		local.setLuogo(product.getLuogo());
		local.setCod_volo(product.getCod_volo());
		local.setCod_soggiorno(product.getCod_soggiorno());
		local.setCod_escursione(product.getCod_escursione());
		return local;
	}
	
	public Product(ProductDTO product){
		this.nome = product.getNome();
		this.prezzo = product.getPrezzo();
		this.descrizione = product.getDescrizione();
		this.aerop_andata = product.getAerop_andata();
		this.aerop_ritorno = product.getAerop_ritorno();
		this.luogo = product.getLuogo();
		this.cod_volo = product.getCod_volo();
		this.cod_soggiorno = product.getCod_soggiorno();
		this.cod_escursione = product.getCod_escursione();
	}

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Tipologia getTipo() {
		return tipo;
	}
	public void setTipo(Tipologia tipo) {
		this.tipo = tipo;
	}
	public int getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(int prezzo) {
		this.prezzo = prezzo;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public Timestamp getData_arrivo() {
		return data_arrivo;
	}
	public void setData_arrivo(Timestamp data_arrivo) {
		this.data_arrivo = data_arrivo;
	}
	public Timestamp getData_partenza() {
		return data_partenza;
	}
	public void setData_partenza(Timestamp data_partenza) {
		this.data_partenza = data_partenza;
	}
	public String getAerop_andata() {
		return aerop_andata;
	}
	public void setAerop_andata(String aerop_andata) {
		this.aerop_andata = aerop_andata;
	}
	public String getAerop_ritorno() {
		return aerop_ritorno;
	}
	public void setAerop_ritorno(String aerop_ritorno) {
		this.aerop_ritorno = aerop_ritorno;
	}
	public String getLuogo() {
		return luogo;
	}
	public void setLuogo(String luogo) {
		this.luogo = luogo;
	}
	public Long getCod_volo() {
		return cod_volo;
	}
	public void setCod_volo(Long cod_volo) {
		this.cod_volo = cod_volo;
	}
	public Long getCod_soggiorno() {
		return cod_soggiorno;
	}
	public void setCod_soggiorno(Long cod_soggiorno) {
		this.cod_soggiorno = cod_soggiorno;
	}
	public Long getCod_escursione() {
		return cod_escursione;
	}
	public void setCod_escursione(Long cod_escursione) {
		this.cod_escursione = cod_escursione;
	}
	
	

}
