CREATE DEFINER=`root`@`localhost` PROCEDURE `gerar_PontosFidelidade`(pk bigint(11))
BEGIN
	declare pontos int(4);
    set pontos = (select count(*) from compras where compra.cpf_cliente = pk);
    
	UPDATE cliente
    SET pontosFidelidade = pontos
    where cliente.cpf = pk ;
END