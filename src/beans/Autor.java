package beans;

import java.sql.Date;

public class Autor {

	private String best_seller;
	private int id_autor;
	private String nome;

    public Autor(String best_seller, int id_autor, String nome) {
        this.best_seller = best_seller;
        this.id_autor = id_autor;
        this.nome = nome;
    }

    public int getId_autor() {
        return id_autor;
    }

    public void setId_autor(int id_autor) {
        this.id_autor = id_autor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getBest_seller() {
		return best_seller;
	}

	public void setBest_seller(String best_seller) {
		this.best_seller = best_seller;
	}

}
