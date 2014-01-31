package travelDream.ejb.model;


public class ProductDTO {
	private Long id;
	
	private String nome;
	
	private String tipo;
	
	private int prezzo;
	
	private String descrizione;
	
	private String data_arrivo;
	
	
	private String data_partenza;
	
	private String aerop_andata;
	private String aerop_ritorno;
	private String luogo;
	private Long cod_volo;
	private Long cod_soggiorno;
	private Long cod_escursione;
	
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
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
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
	public String getData_arrivo() {
		return data_arrivo;
	}
	public void setData_arrivo(String data_arrivo) {
		this.data_arrivo = data_arrivo;
	}
	public String getData_partenza() {
		return data_partenza;
	}
	public void setData_partenza(String data_partenza) {
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
