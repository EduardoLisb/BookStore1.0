DELIMITER $$
CREATE TRIGGER tr_CalcIdade
AFTER INSERT ON pessoa
FOR EACH ROW
BEGIN
  set NEW.idade = (YEAR(CURDATE()) - YEAR(NEW.dt_nascimento) - (RIGHT(CURDATE(),5)) < RIGHT(NEW.dt_nascimento,5)) AS idade FROM pessoa);
END$$

DELIMITER $$
CREATE TRIGGER tr_CalcDataPedido
AFTER INSERT ON encomenda
FOR EACH ROW
BEGIN
  set NEW.dt_pedido = CURRENT_DATE();
END$$

# Atualiza o estoque quando a compra é feita
DELIMITER $$
CREATE TRIGGER tr_AttEstoque
AFTER INSERT ON compra
FOR EACH ROW
BEGIN
  UPDATE estoque
    set dt_ultima_compra = NEW.dt_compra;
  UPDATE item_estoque
    set qtd_atual = qtd_atual + (SELECT item_compra.qtd FROM item_compra where fk_cod_compra_item = NEW.cod_compra and cod_produto = (SELECT cod_produto from item_compra where cod_compra = NEW.cod_compra));

END$$

# Não permite adicionar item compra que já gerou Nota Fiscal
# Atualiza a qtd_atual quando é adicionado em item_compra
DELIMITER $$
CREATE TRIGGER tr_AttEstoque
BEFORE INSERT ON item_compra
FOR EACH ROW
BEGIN
  IF ( SELECT NOT EXISTS ( SELECT * FROM nota_fiscal
	WHERE nota_fiscal.cod_compra = (SELECT cod_compra FROM compra
    WHERE cod_compra = NEW.cod_compra ) ) )
    THEN
    SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Compra já concluída';
  END IF;
  UPDATE item_estoque SET qtd_atual = qtd_atual - NEW.qtd
  WHERE NEW.cod_produto = item_estoque.cod_produto;
END$$
# Lança erro ao atualizar quantidade com numero negativo
DELIMITER $$
USE bookstore $$
CREATE TRIGGER tr_AttItem_estoque
BEFORE UPDATE ON item_estoque
FOR EACH ROW
BEGIN
	IF NEW.qtd_atual < 0 THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Quantidade requisitada não disponível';
	END IF;
END$$
DELIMITER $$

# Atualiza o valor bruto de compra ao adicionar item_compra
DELIMITER $$
USE bookstore $$
CREATE TRIGGER tr_AddItem_compra
AFTER INSERT ON item_compra
FOR EACH ROW
BEGIN
	UPDATE compra SET bookstore.compra.vl_total_bruto = NEW.vl_unitario * NEW.qtd
    WHERE compra.cod_compra = NEW.cod_compra;
END$$
DELIMITER $$

DESC item_compra;