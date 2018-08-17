use bookstore;

CREATE VIEW compraCliente AS
SELECT CP.cod_compra, CP.dt_compra, CP.total_a_pagar, P1.nome, P2.nome, PDV.cod_pdv, PDV.desc_pdv
FROM compra CP, pessoa P1, pessoa P2, PDV
WHERE 
	CP.cpf_cliente = P1.cpf AND
	CP.cpf_vendedor = P2.cpf AND
    CP.cod_pdv = PDV.cod_pdv AND
    CP.dt_compra > `data1` AND
    CP.dt_compra < `data2`;

CREATE VIEW produtoEstoque AS
SELECT P.desc_produto, I.qtd_atual, E.id_estoque, E.desc_estoque, F.nome_fantasia
FROM produto_ref P, item_estoque I, estoque E, fornecedor F
WHERE
	P.cod_produto = I.cod_produto AND
    I.id_estoque = E._id_estoque AND
    P.cnpj_fornecedor = F.cnpj_fornecedor;
    
CREATE VIEW comprasGeral AS
SELECT CP.cod_compra, CP.dt_compra, CP.total_a_pagar, NF.codigoNF, P.cod_pag, P.vl_pago, PDV.cod_pdv, PDV.desc_pdv, PF.nome
FROM compra CP, nota_fiscal NF, pagamento P, PDV, pessoa PF
WHERE 
	CP.cod_compra = NF.cod_compra AND
	NF.codigoNF = P.codigoNF AND
    CP.cod_pdv = PDV.cod_pdv AND
    CP.cpf_vendedor = PF.cpf_vendedor AND
    CP.dt_compra > `data1` AND
    CP.dt_compra < `data2`;
    
delimiter //
CREATE PROCEDURE compraCliente (IN `data1` date, IN `data2` date)
BEGIN
SELECT CP.cod_compra, CP.dt_compra, CP.total_a_pagar, P1.nome, P2.nome, PDV.cod_pdv, PDV.desc_pdv
FROM compra CP, pessoa P1, pessoa P2, PDV
WHERE 
	CP.cpf_cliente = P1.cpf AND
	CP.cpf_vendedor = P2.cpf AND
    CP.cod_pdv = PDV.cod_pdv AND
    CP.dt_compra > `data1` AND
    CP.dt_compra < `data2`;
END //

CREATE PROCEDURE compraGeral (IN `data1` date, IN `data2` date)
BEGIN
SELECT CP.cod_compra, CP.dt_compra, CP.total_a_pagar, NF.codigoNF, P.cod_pag, P.vl_pago, PDV.cod_pdv, PDV.desc_pdv, PF.nome
FROM compra CP, nota_fiscal NF, pagamento P, PDV, pessoa PF
WHERE 
	CP.cod_compra = NF.cod_compra AND
	NF.codigoNF = P.codigoNF AND
    CP.cod_pdv = PDV.cod_pdv AND
    CP.cpf_vendedor = PF.cpf_vendedor AND
    CP.dt_compra > `data1` AND
    CP.dt_compra < `data2`;
END //
