use bookstore;

CREATE USER gerente@localhost IDENTIFIED BY '0101';
CREATE USER auxiliar@localhost IDENTIFIED BY '0102';
CREATE USER vendedor@localhost IDENTIFIED BY '0103';
CREATE USER caixa@localhost IDENTIFIED BY '0104';
CREATE USER cliente@localhost IDENTIFIED BY '0104';

GRANT INSERT, UPDATE, SELECT, DELETE ON evento TO gerente@localhost;
GRANT SELECT ON evento to vendedor@localhost, caixa@localhost, auxiliar@localhost, cliente@localhost;

GRANT INSERT, UPDATE, SELECT, DELETE ON cliente TO gerente@localhost, vendedor@localhost;
GRANT SELECT ON cliente TO caixa@localhost, cliente@localhost, auxiliar@localhost;

GRANT INSERT, UPDATE, SELECT, DELETE ON palestrante TO gerente@localhost;
GRANT UPDATE, SELECT ON palestrante TO caixa@localhost, vendedor@localhost, auxiliar@localhost;

GRANT INSERT, UPDATE, SELECT, DELETE ON autor TO gerente@localhost, auxiliar@localhost, caixa@localhost, vendedor@localhost;

GRANT INSERT, UPDATE, SELECT, DELETE ON funcionario TO gerente@localhost;
GRANT SELECT ON funcionario TO auxiliar@localhost, vendedor@localhost, caixa@localhost;

GRANT INSERT, UPDATE, SELECT, DELETE ON caixa TO gerente@localhost;
GRANT SELECT ON caixa TO auxiliar@localhost, caixa@localhost, vendedor@localhost;

GRANT INSERT, UPDATE, SELECT, DELETE ON gerente TO gerente@localhost;
GRANT SELECT ON gerente TO auxiliar@localhost, caixa@localhost, vendedor@localhost;

GRANT INSERT, UPDATE, SELECT, DELETE ON auxiliar TO gerente@localhost;
GRANT SELECT ON auxiliar TO auxiliar@localhost, caixa@localhost, vendedor@localhost;

GRANT INSERT, UPDATE, SELECT, DELETE ON vendedor TO gerente@localhost;
GRANT SELECT ON vendedor TO auxiliar@localhost, caixa@localhost, vendedor@localhost;

GRANT INSERT, UPDATE, SELECT, DELETE ON endereco TO gerente@localhost, caixa@localhost, auxiliar@localhost, vendedor@localhost;
GRANT SELECT ON endereco TO cliente@localhost;

GRANT INSERT, UPDATE, SELECT, DELETE ON promocao TO gerente@localhost;
GRANT SELECT, UPDATE, DELETE ON promocao TO caixa@localhost, auxiliar@localhost, vendedor@localhost;
GRANT SELECT ON promocao TO cliente@localhost;

GRANT INSERT, UPDATE, SELECT, DELETE ON plano_fidelidade TO gerente@localhost;
GRANT UPDATE, SELECT ON plano_fidelidade TO vendedor@localhost;
GRANT SELECT ON plano_fidelidade TO auxiliar@localhost, caixa@localhost, cliente@localhost;

GRANT INSERT, UPDATE, SELECT, DELETE ON pdv TO gerente@localhost;
GRANT SELECT ON pdv TO auxiliar@localhost, caixa@localhost, vendedor@localhost;

GRANT INSERT, UPDATE, SELECT, DELETE ON comissao TO gerente@localhost;
GRANT SELECT ON comissao TO auxiliar@localhost, caixa@localhost, vendedor@localhost;

GRANT INSERT, UPDATE, SELECT, DELETE ON encomenda TO gerente@localhost, auxiliar@localhost, caixa@localhost, vendedor@localhost;
GRANT INSERT, UPDATE, SELECT ON encomenda TO cliente@localhost;

GRANT INSERT, UPDATE, SELECT, DELETE ON fornecedor TO gerente@localhost;
GRANT SELECT ON fornecedor TO auxiliar@localhost, caixa@localhost, vendedor@localhost;

GRANT INSERT, UPDATE, SELECT, DELETE ON produto_ref TO gerente@localhost, vendedor@localhost, auxiliar@localhost;
GRANT SELECT ON produto_ref TO caixa@localhost, cliente@localhost;

GRANT INSERT, UPDATE, SELECT, DELETE ON item_estoque TO gerente@localhost, auxiliar@localhost, vendedor@localhost;
GRANT SELECT ON item_estoque TO caixa@localhost, cliente@localhost;

GRANT INSERT, UPDATE, SELECT, DELETE ON item_compra TO gerente@localhost, vendedor@localhost, caixa@localhost;
GRANT SELECT ON item_compra TO auxiliar@localhost, cliente@localhost;

GRANT INSERT, UPDATE, SELECT, DELETE ON item_encomenda TO gerente@localhost, vendedor@localhost, caixa@localhost, auxiliar@localhost;
GRANT SELECT ON item_encomenda TO cliente@localhost;

GRANT INSERT, UPDATE, SELECT, DELETE ON prateleira TO gerente@localhost, auxiliar@localhost;
GRANT SELECT ON prateleira TO cliente@localhost, vendedor@localhost, caixa@localhost;

GRANT INSERT, UPDATE, SELECT, DELETE ON estante TO gerente@localhost, auxiliar@localhost;
GRANT SELECT ON prateleira TO cliente@localhost, vendedor@localhost, caixa@localhost;

GRANT INSERT, UPDATE, SELECT, DELETE ON nota_fiscal TO caixa@localhost;
GRANT UPDATE, SELECT, DELETE ON nota_fiscal TO gerente@localhost;
GRANT SELECT ON nota_fiscal TO vendedor@localhost, cliente@localhost;

GRANT INSERT, SELECT ON pagamento TO caixa@localhost;
GRANT UPDATE, SELECT, DELETE ON pagamento TO gerente@localhost;
GRANT SELECT ON pagamento TO vendedor@localhost, cliente@localhost;

GRANT INSERT, UPDATE, SELECT, DELETE ON cartao TO cliente@localhost;

GRANT INSERT, SELECT ON compra TO caixa@localhost;
GRANT UPDATE, SELECT, DELETE ON compra TO gerente@localhost;
GRANT SELECT ON compra TO vendedor@localhost, cliente@localhost;

GRANT INSERT, UPDATE, SELECT, DELETE ON estoque TO gerente@localhost, auxiliar@localhost;
GRANT SELECT ON estoque TO caixa@localhost, vendedor@localhost;

GRANT INSERT, UPDATE, SELECT, DELETE ON organiza TO gerente@localhost, auxiliar@localhost;

GRANT INSERT, UPDATE, SELECT, DELETE ON inscricao TO gerente@localhost, cliente@localhost, auxiliar@localhost, vendedor@localhost, caixa@localhost;

