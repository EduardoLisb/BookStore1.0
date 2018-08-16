USE BOOKSTORE;

DELIMITER //
CREATE DEFINER=`root`@`localhost` FUNCTION `calcularDesconto`(cpfCliente bigint) RETURNS double
begin	DECLARE desconto double;
		SELECT porcentagem INTO desconto
        FROM cliente C, plano_fidelidade PF, promocao P
        WHERE C.cod_plano = PF.cod_plano AND
        PF.cod_plano = P.cod_plano;
        SET desconto = desconto/100;
		return desconto;
END//

CREATE DEFINER=`root`@`localhost` FUNCTION `cepEstado`(cpfCliente bigint) RETURNS varchar(20) CHARSET latin1
BEGIN
	declare estado varchar(20);
	SELECT cE.estado INTO estado
    FROM pessoa P, cliente C, cep_Estado cE  
    WHERE C.cpf = cpfCliente AND
    C.cpf = P.cpf AND
    P.endereco_cep >= cE.cepInicio AND P.endereco_cep <= cE.cepFim;
    return estado;
END//

CREATE DEFINER=`root`@`localhost` FUNCTION `tipoEvento`(cpfCliente bigint) RETURNS int(5)
BEGIN
	declare tipo integer(5);
    SELECT count(*) AS total, T.cod_tipo INTO tipo
    FROM cliente C, inscricao I, evento E, tipo_evento T 
    WHERE cpfCliente = C.cpf AND
    C.cpf = I.cpf AND
    E.cod_evento = I.cod_evento AND
    T.cod_tipo = E.cod_tipo
    GROUP BY T.cod_tipo
    ORDER BY count(*)
    LIMIT 0,1;
    return tipo;
END//