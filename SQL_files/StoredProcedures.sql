USE `bookstore`;
DROP procedure IF EXISTS `SP_gerarPontosFidelidade`;

DELIMITER $$
USE `bookstore`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `gerar_PontosFidelidade`(pk bigint(11))
BEGIN
	declare pontos int(4);
    set pontos = (select count(*) from compras where compra.cpf_cliente = pk);
	UPDATE cliente
SET
    pontosFidelidade = pontos
WHERE
    cliente.cpf = pk;
END$$

DELIMITER ;

DROP procedure IF EXISTS `SP_get_ValorDesconto`

DELIMETER $$
USE `bookstore`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_get_ValorDesconto`(pk bigint(11), OUT desconto float)
BEGIN
	declare min, max, pontos int; /*percentuais minimo e maximo de descontos*/
    set pontos = (SELECT cliente.pontosFidelidade from cliente where cliente.cpf = pk);
    set min = 2;
    set max = 5;
    IF pontos < min THEN
		set desconto = min/100;
	ELSEIF pontos > max THEN
		set desconto = max/100;
	ELSE
		set desconto = pontos/100;
	END IF;
END$$

DELIMETER $$
USE `bookstore`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_SelectEnvolvidos`(datadeultimareposicao date)
BEGIN
  SELECT AS `Pessoas e prateleiras Envolvidos`
    pessoinha.cpf,
    pessoinha.nome,
    prateleirinha.serial_prateleira,
    prateleirinha.desc_prateleira
  FROM
    pessoa pessoinha
  RIGHT JOIN prateleira prateleirinha ON prateleirinha.serial_prateleira = pessoinha.cpf
  AND
    prateleirinha.serial_prateleira = (SELECT serial_prateleira FROM organiza where dt_ultima_reposicao = datadeultimareposicao)
  where
    pessoinha.cpf = (SELECT cpf_auxiliar FROM organiza where dt_ultima_reposicao=datadeultimareposicao);

END$$

DELIMETER $$
USE `bookstore`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `SP_Get_CepEstado`(cpfCliente bigint, OUT estado varchar(20)) CHARSET latin1
BEGIN
	declare estado varchar(20);
	SELECT cE.estado INTO estado
    FROM pessoa P, cliente C, cep_Estado cE
    WHERE C.cpf = cpfCliente AND
    C.cpf = P.cpf AND
    P.endereco_cep >= cE.cepInicio AND P.endereco_cep <= cE.cepFim;
    return estado;
END$$
