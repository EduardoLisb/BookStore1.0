package beans;

public class MaterialEscolar extends ProdutoRef {

	public String desc_material;

	public MaterialEscolar(String desc_material, int cod_produto, double preco, String desc_produto,
			double preco_fornecedor, int cod_barra, Fornecedor cnpj_fornecedor, String marca) {
		super(cod_produto, preco, desc_produto, preco_fornecedor, cod_barra, cnpj_fornecedor, marca);
		this.desc_material = desc_material;
	}

	public String getDesc_material() {
		return desc_material;
	}

	public void setDesc_material(String desc_material) {
		this.desc_material = desc_material;
	}
}
