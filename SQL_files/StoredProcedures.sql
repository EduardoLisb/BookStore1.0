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

DELIMITER $$
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

DELIMITER $$
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

DELIMETER $$
USE `bookstore`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `SP_Get_ItensAbaixoDoMinimo`(CHAR nome(3)) CHARSET latin1
BEGIN
	SELECT produto.* from multimidia where (produto.cod_produto = 
END$$

DROP procedure IF EXISTS `SP_iniciar_compra`;
DELIMITER $$
USE `bookstore` $$
	CREATE DEFINER=`root`@`localhost`
    PROCEDURE `SP_iniciar_compra` (cod_pdv int(5), cpf_vendedor bigint(11), cpf_cliente bigint(11),
									OUT cod_compra int(10))
	BEGIN
		INSERT INTO compra(cod_compra,vl_desconto,vl_imposto,dt_compra,vl_comissao,vl_total_bruto,
        vl_total_a_pagar,cod_pdv,cpf_vendedor,cpf_cliente) VALUES
        (0,0.0,0.0,now(),0.0,0.0,0.0,cod_pdv,cpf_vendedor,cpf_cliente);
        SET cod_compra = last_insert_id();
    END$$
DELIMITER $$

DROP procedure IF EXISTS `SP_calcular_valores_compra`;
DELIMITER $$
USE `bookstore` $$
	CREATE DEFINER=`root`@`localhost`
	PROCEDURE `SP_calcular_valores_compra` (cod_compra int(10))
    BEGIN
		DECLARE vl_desconto float;
        call SP_get_ValorDesconto(cpf_cliente, vl_desconto);
		# FALTAM: VALOR COMISSÃO, VALOR IMPOSTO
		UPDATE compra SET compra.vl_desconto = vl_desconto,
        compra.vl_total_a_pagar = compra.vl_total_bruto * (1.0 - vl_desconto)
        WHERE compra.cod_compra = cod_compra;
    END$$
DELIMITER $$


DROP procedure IF EXISTS `SP_calcular_comissao`;
DELIMITER $$
USE `bookstore` $$
	CREATE DEFINER=`root`@`localhost`
	PROCEDURE `SP_calcular_comissao`(cod_compra int(10))
	BEGIN
		
    END$$
DELIMITER $$

DROP procedure IF EXISTS `SP_gerar_NF`;
DELIMITER $$
USE `bookstore` $$
	CREATE DEFINER=`root`@`localhost`
	PROCEDURE `SP_gerar_NF`(cod_compra int(10))
	BEGIN
		SET @valor = (SELECT vl_total_a_pagar FROM compra
        WHERE compra.cod_compra = cod_compra);
		INSERT INTO nota_fiscal(codigoNF,dt_emissao,serie,vl_total,cod_compra)
        VALUES (null, now(), null, @valor, cod_compra);
    END$$
DELIMITER $$


DROP procedure IF EXISTS `SP_finalizar_compra`;
DELIMITER $$
USE `bookstore` $$
	CREATE DEFINER=`root`@`localhost`
	PROCEDURE `SP_finalizar_compra`(cod_compra int(10))
    BEGIN
		CALL SP_calcular_valores_compra(cod_compra);
#        CALL SP_calcular_comissao(cod_compra);
#        CALL SP_calcular_imposto(cod_compra);
        CALL SP_gerar_NF(cod_compra);
    END$$
DELIMITER $$
