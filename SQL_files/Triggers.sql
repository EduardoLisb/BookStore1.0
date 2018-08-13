DELIMETER $$
CREATE TRIGGER tr_CalcIdade
AFTER INSERT ON pessoa
FOR EACH ROW
BEGIN
  set NEW.idade = (YEAR(CURDATE()) - YEAR(NEW.dt_nascimento) - (RIGHT(CURDATE(),5)) < RIGHT(NEW.dt_nascimento,5)) AS idade FROM pessoa);
END$$

DELIMETER $$
CREATE TRIGGER tr_CalcDataPedido
AFTER INSERT ON encomenda
FOR EACH ROW
BEGIN
  set NEW.dt_pedido = CURRENT_DATE();
END$$

DELIMETER $$
CREATE TRIGGER tr_AttEstoque
AFTER INSERT ON compra
FOR EACH ROW
BEGIN
  UPTADE estoque
    set dt_ultima_compra = NEW.dt_compra;
  UPDATE item_estoque
    set qtd_atual = qtd_atual + (SELECT item_compra.qtd FROM item_compra where fk_cod_compra_item = NEW.cod_compra and cod_produto = (SELECT cod_produto from item_compra where cod_compra = NEW.cod_compra));

END$$
