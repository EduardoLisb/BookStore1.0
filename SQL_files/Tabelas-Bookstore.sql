CREATE SCHEMA IF NOT EXISTS bookstore;
ALTER DATABASE bookstore CHARSET = Latin1 COLLATE = latin1_swedish_ci;
USE bookstore;
SET FOREIGN_KEY_CHECKS=0;
CREATE TABLE IF NOT EXISTS bookstore_filial (
	cnpj_filial        bigint(14) not null,
	nome_fantasia      varchar(20) not null,
	razao_social       varchar(30), 
	endereco_cep integer(8) unique,
    endereco_num integer(4),
    cnpj_matriz bigint(14) not null,
	primary key (cnpj_filial),
	key (nome_fantasia),
    constraint fk_cnpj_matriz foreign key(cnpj_matriz) references MATRIZ(cnpj_matriz) on update cascade on delete restrict,
	constraint fk_endereco_filial foreign key(endereco_cep) references endereco(cep) on update cascade on delete restrict
);

CREATE TABLE IF NOT EXISTS matriz (
	cnpj_matriz bigint(14),
    nome_fantasia varchar(20),
    primary key(cnpj_matriz)
);

CREATE TABLE IF NOT EXISTS evento (
	cod_evento integer(5) not null,
    desc_evento varchar(20) not null,
    requer_inscricao boolean not null,
    dt_inicio_divul date,
    cpf_palestrante bigint(11) unique,
    dt_realizacao date not null,
    cnpj_filial bigint(14) not null unique,
    cod_tipo integer(5) unique,
    primary key(cod_evento),
    constraint fk_palestrante foreign key(cpf_palestrante) references PALESTRANTE(cpf) on update cascade on delete set null,
    constraint fk_filial foreign key(cnpj_filial) references BOOKSTORE_FILIAL(cnpj_filial) on update cascade on delete cascade,
    constraint fk_tipo_evento foreign key(cod_tipo) references TIPO_EVENTO(cod_tipo) on update cascade on delete set null
);

CREATE TABLE IF NOT EXISTS tipo_evento (
	cod_tipo integer(5) not null,
    desc_tipo varchar(20) not null,
    categoria	varchar(20),
    primary key(cod_tipo)
);

CREATE TABLE IF NOT EXISTS pessoa (
	cpf bigint(11) not null,
    nome varchar(20) not null,
    sexo enum('masculino', 'feminino') not null,
    dt_nascimento date,
    idade integer(2),
    endereco_cep integer(8),
    endereco_num integer(4),
    primary key(cpf),
    key(nome),
    constraint fk_endereco_pessoa foreign key(endereco_cep) references ENDERECO(cep) on update cascade on delete restrict
);

CREATE TABLE IF NOT EXISTS cliente (
	cpf bigint(11) not null,
    eh_professor boolean,
    status char(10),
    dt_fim_adesao date,
    dt_adesao date,
    cod_plano int(10),
    pontosFidelidade integer (4),
    cnpj_filial bigint(14),
    primary key(cpf),
    constraint fk_cpf_pessoa foreign key(cpf) references PESSOA(cpf) on update cascade on delete restrict,
    constraint fk_cod_plano foreign key(cod_plano) references PLANO_FIDELIDADE(cod_plano) on update cascade on delete set null,
    constraint fk_cnpj_filial_cliente foreign key(cnpj_filial) references BOOKSTORE_FILIAL(cnpj_filial) on update cascade on delete set null
);

CREATE TABLE IF NOT EXISTS palestrante (
	cpf bigint(11) not null,
    dt_ultima_palestra date,
    status char(10),
    area char(10),
    dt_inicio date,
    primary key(cpf),
    constraint fk_cpf_palestrante foreign key(cpf) references PESSOA(cpf) on update cascade on delete restrict
);

CREATE TABLE IF NOT EXISTS autor (
	id_autor int(11) not null,
    nome varchar(20) not null,
    best_seller varchar(20),
    primary key(id_autor)
);

DROP TABLE funcionario;
CREATE TABLE IF NOT EXISTS funcionario (
	cpf bigint(11) not null,
    dt_ferias date,
    salario_base double,
    ramal integer(5),
    cpf_gerente bigint(11),
    cnpj_filial bigint(14) not null,
    primary key(cpf),
    constraint fk_cpf_funcionario foreign key(cpf) references PESSOA(cpf) on update cascade on delete restrict,
    constraint fk_cpf_gerente foreign key(cpf_gerente) references GERENTE(cpf) on update cascade on delete set null,
    constraint fk_cnpj_filial_funcionario foreign key(cnpj_filial) references BOOKSTORE_FILIAL(cnpj_filial) on update cascade on delete cascade
);

CREATE TABLE IF NOT EXISTS vendedor (
	cpf bigint(11) not null,
	primary key(cpf),
    constraint fk_cpf_vendedor foreign key(cpf) references FUNCIONARIO(cpf) on update cascade on delete cascade
);

CREATE TABLE IF NOT EXISTS caixa (
	cpf bigint(11) not null,
    cod_pdv integer(5) unique,
    dt_inicio date,
    dt_fim date,
    primary key(cpf),
    constraint fk_cpf_caixa foreign key(cpf) references FUNCIONARIO(cpf) on update cascade on delete cascade,
    constraint fk_pdv_caixa foreign key(cod_pdv) references PDV(cod_pdv) on update cascade on delete set null
);

CREATE TABLE IF NOT EXISTS gerente (
	cpf bigint(11) not null,
    dt_inicio date,
    dt_fim date,
    primary key(cpf),
    constraint fk_cpf_gerente1 foreign key(cpf) references FUNCIONARIO(cpf) on update cascade on delete cascade
);

CREATE TABLE IF NOT EXISTS auxiliar (
	cpf bigint(11) not null,
	primary key(cpf),
    constraint fk_auxiliar foreign key(cpf) references FUNCIONARIO(cpf) on update cascade on delete cascade
);

CREATE TABLE IF NOT EXISTS endereco (
	cep integer(8) not null,
    complemento varchar(20),
    predio char(10),
    logradouro char(10) not null,
    primary key(cep)
);

CREATE TABLE IF NOT EXISTS promocao(
	id_promocao integer(10),
    dt_inicio date not null,
    tipo char(10),
    porcentagem double not null,
    dt_fim date not null,
    desc_prom char(10) not null,
    cod_plano int(10) unique,
    primary key (id_promocao),
    constraint fk_cod_plano1 foreign key(cod_plano) references PLANO_FIDELIDADE(cod_plano) on update cascade on delete cascade
);

CREATE TABLE IF NOT EXISTS plano_fidelidade (
	cod_plano int(10) not null,
    tipo char(10),
    dt_inicio date not null,
    dt_fim date,
    primary key (cod_plano)
);

CREATE TABLE IF NOT EXISTS pdv (
	cod_pdv integer(5) not null,
    dt_ult_manuntencao date,
    desc_pdv char(10),
    primary key(cod_pdv)
);

CREATE TABLE IF NOT EXISTS comissao (
	id_comissao integer(5) not null,
    percentual double not null,
    dt_inicio date,
    dt_fim date,
    status_comissao char(10) not null,
    tipo char(10) not null,
    primary key (id_comissao)
);

CREATE TABLE IF NOT EXISTS encomenda (
	id_encomenda integer(10) not null,
    dt_pedido date,
    status_encomenda char(10) not null,
    dt_prevista date,
    cpf_cliente bigint(11),
    primary key(id_encomenda),
    constraint fk_cpf_cliente foreign key (cpf_cliente) references CLIENTE(cpf) on update cascade on delete cascade
);

CREATE TABLE IF NOT EXISTS produto_ref (
	cod_produto integer(10) not null,
    preco double not null,
    desc_produto char(20) not null,
    preco_fornecedor double,
    cod_barra bigint(15) unique,
    cnpj_fornecedor bigint(14) unique,
    marca char(10),
    primary key(cod_produto),
    constraint fk_cnpj_fornecedor foreign key(cnpj_fornecedor) references FORNECEDOR(cnpj_fornecedor) on update cascade on delete set null
    
);

CREATE TABLE IF NOT EXISTS livro (
	cod_produto integer(10) not null,
    isbn integer(10) not null,
    titulo varchar(100) not null,
    dt_ultima_edicao date,
    ano_publicacao integer(4),
    num_edicao integer(5),
    tipo enum('digital', 'fisico'),
    primary key(cod_produto),
    key(isbn),
    constraint fk_cod_prod foreign key(cod_produto) references PRODUTO_REF(cod_produto) on update cascade on delete cascade
);

CREATE TABLE IF NOT EXISTS genero (
	cod_genero integer(5) not null,
    desc_genero char(10) not null,
    primary key(cod_genero)
);

CREATE TABLE IF NOT EXISTS multimidia (
	cod_produto integer(10) not null,
	titulo varchar(100) not null,
    duracao integer(5),
    tipo enum('cd', 'dvd'),
    primary key(cod_produto),
    constraint fk_cod_prod_multi foreign key(cod_produto) references PRODUTO_REF(cod_produto) on update cascade on delete cascade
);

CREATE TABLE IF NOT EXISTS material_escolar (
	cod_produto integer(10) not null,
    desc_material char(10) not null,
    primary key(cod_produto),
    constraint fk_cod_prod_material foreign key(cod_produto) references PRODUTO_REF(cod_produto) on update cascade on delete cascade
);

CREATE TABLE IF NOT EXISTS item_estoque (
	cod_produto integer(10) not null,
    seq_SK integer(10) not null,
    em_prateleira boolean,
    preco_venda double not null,
    qtd_minima integer(5),
    dt_entrada date,
    qtd_atual integer(5),
    id_estoque integer(5) unique,
    serial_prateleira integer(5) unique,
    primary key(cod_produto, seq_SK),
    constraint fk_cod_prod_item foreign key(cod_produto) references PRODUTO_REF(cod_produto) on update cascade on delete cascade,
    constraint fk_id_estoque_item foreign key(id_estoque) references ESTOQUE(id_estoque) on update cascade on delete restrict,
    constraint fk_item_serial_prateleira foreign key(serial_prateleira) references PRATELEIRA(serial_prateleira) on update cascade on delete set null
);

CREATE TABLE IF NOT EXISTS item_compra(
	cod_produto integer(10) not null,
    qtd integer(2),
    vl_unitario double,
    cod_compra integer(10),
    primary key(cod_produto, cod_compra),
    constraint fk_cod_prod_item_compra foreign key(cod_produto) references PRODUTO_REF(cod_produto) on update cascade on delete cascade,
    constraint fk_cod_compra_item foreign key(cod_compra) references COMPRA(cod_compra)
);

CREATE TABLE IF NOT EXISTS item_encomenda(
	id_encomenda integer(10) not null,
    cod_produto integer(10) not null,
    qtd integer(2),
    primary key(id_encomenda),
    constraint fk_cod_prod_item_encomenda foreign key(cod_produto) references PRODUTO_REF(cod_produto) on update cascade on delete cascade,
    constraint fk_id_encomenda foreign key(id_encomenda) references ENCOMENDA(id_encomenda) on update cascade on delete cascade
);

CREATE TABLE IF NOT EXISTS prateleira (
	serial_prateleira integer(10) not null,
    num_nivel integer(5) not null,
    serial_estante integer(5) not null,
    primary key(serial_prateleira),
    constraint fk_serial_estante foreign key(serial_estante) references ESTANTE(serial_estante) on update cascade on delete cascade
);

CREATE TABLE IF NOT EXISTS estante (
	serial_estante integer(5) not null,
    desc_estante char(10),
    primary key(serial_estante)
);

CREATE TABLE IF NOT EXISTS nota_fiscal (
	codigoNF integer(10) not null,
    dt_emissao date not null,
    serie integer(10),
    vl_total double not null,
    cod_compra integer(10) not null unique,
    primary key(codigoNF),
    constraint fk_cod_compra foreign key (cod_compra) references COMPRA(cod_compra) on update restrict on delete cascade
);

CREATE TABLE IF NOT EXISTS pagamento (
	cod_pag integer(10) not null,
    vl_pago double not null,
    codigoNF integer(10) unique,
    primary key(cod_pag),
    constraint fk_codigoNF foreign key (codigoNF) references NOTA_FISCAL(codigoNF) on update restrict on delete cascade
);
CREATE TABLE IF NOT EXISTS compra (
	cod_compra integer(10) not null,
    vl_desconto double,
    vl_imposto double,
    dt_compra date not null,
    vl_comissao double,
    vl_total_bruto double not null,
    vl_total_a_pagar double not null,
    cod_pdv integer(10) unique,
    cpf_vendedor bigint(11) unique,
    cpf_cliente bigint(11) not null unique,
    primary key(cod_compra),
    constraint fk_cod_pdv_compra foreign key (cod_pdv) references PDV(cod_pdv) on update cascade on delete set null,
    constraint fk_cpf_vendedor_compra foreign key (cpf_vendedor) references VENDEDOR(cpf) on update cascade on delete set null,
    constraint fk_cpf_cliente_compra foreign key (cpf_cliente) references CLIENTE(cpf) on update cascade on delete cascade
);

CREATE TABLE IF NOT EXISTS cartao (
	cod_pag integer(10) not null,
    numero bigint(16) not null,
    qntParcela integer(2),
    bandeira char(10) not null,
    banco char(10),
    primary key(cod_pag),
    constraint fk_cod_pagamento foreign key(cod_pag) references PAGAMENTO(cod_pag) on update restrict on delete cascade
);

CREATE TABLE IF NOT EXISTS dinheiro (
	cod_pag integer(10) not null,
    primary key(cod_pag),
    constraint fk_cod_pagamento_dinheiro foreign key(cod_pag) references PAGAMENTO(cod_pag) on update restrict on delete cascade
);

CREATE TABLE IF NOT EXISTS estoque (
	id_estoque integer(10) not null,
    dt_ultima_compra date,
    desc_estoque varchar(20) not null,
    cnpj_filial bigint(14) unique,
    primary key(id_estoque),
    constraint fk_cnpj_filial_estoque foreign key(cnpj_filial) references BOOKSTORE_FILIAL(cnpj_filial) on update cascade on delete cascade
);

CREATE TABLE IF NOT EXISTS genero_livro (
	cod_livro integer(10) not null unique,
    cod_genero integer(5) not null unique,
    key(cod_livro, cod_genero),
    constraint fk_cod_livro foreign key(cod_livro) references LIVRO(isbn) on update cascade on delete cascade,
    constraint fk_cod_genero foreign key(cod_genero) references GENERO(cod_genero) on update cascade on delete cascade
);

CREATE TABLE IF NOT EXISTS organiza (
	cpf_auxiliar bigint(11) not null,
    serial_prateleira integer(10) not null unique,
    dt_inicio date,
    dt_fim date,
    dt_ultima_reposicao date,
    key(cpf_auxiliar, serial_prateleira),
    constraint fk_cpf_auxiliar foreign key (cpf_auxiliar) references AUXILIAR(cpf) on update cascade on delete cascade,
    constraint fk_organiza_serial_prateleira foreign key (serial_prateleira) references PRATELEIRA(serial_prateleira) on update cascade on delete cascade
);

CREATE TABLE IF NOT EXISTS inscricao (
	cod_evento integer(5) not null,
    cpf_cliente bigint(11) not null unique,
    dt_inscricao date,
    compareceu boolean,
	key(cod_evento, cpf_cliente),
    constraint fk_cod_evento foreign key (cod_evento) references EVENTO(cod_evento) on update cascade on delete cascade,
    constraint cpf_cliente foreign key (cpf_cliente) references CLIENTE(cpf) on update cascade on delete cascade
);

CREATE TABLE IF NOT EXISTS comissao_funcionario (
	id_comissao integer(5) not null,
    cpf_vendedor bigint(11) not null unique,
    primary key(id_comissao),
    constraint fk_id_comissao foreign key (id_comissao) references COMISSAO(id_comissao)  on update cascade on delete cascade,
    constraint fk_cpf_vendedor_comissao foreign key (cpf_vendedor) references VENDEDOR(cpf) on update cascade on delete cascade
);

CREATE TABLE IF NOT EXISTS autoria (
	cod_produto integer(10) not null,
    id_autor int(11) not null,
    key(id_autor, cod_produto),
    constraint fk_id_autoria foreign key(id_autor) references AUTOR(id_autor) on update cascade on delete cascade,
    constraint fk_cod_produto_autoria foreign key(cod_produto) references LIVRO(cod_produto) on update cascade on delete cascade
);

CREATE TABLE IF NOT EXISTS cep_Estado (
	cepInicio integer(7) not null,
    cepFim integer(7) not null,
    estado varchar(10),
    primary key(cepInicio)
);

CREATE TABLE IF NOT EXISTS fornecedor (
	cnpj_fornecedor bigint(14) not null,
    nome_fantasia varchar(20) not null,
    dt_inicio date,
    dt_fim date,
    tipo varchar(10),
    primary key(cnpj_fornecedor)
);
