<%-- 
    Document   : index
    Created on : 22 de mar. de 2025, 18:10:32
    Author     : paulo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Adicionar Produto</title>
</head>
<body>
    <h1>Adicionar Produto</h1>
    <form action="adicionarProduto" method="POST">
        <label for="nome">Nome:</label>
        <input type="text" id="nome" name="nome" required><br>
        
        <label for="descricao">Descrição:</label>
        <input type="text" id="descricao" name="descricao"><br>
        
        <label for="preco_custo">Preço de Custo:</label>
        <input type="text" id="preco_custo" name="preco_custo"><br>
        
        <label for="preco_venda">Preço de Venda:</label>
        <input type="text" id="preco_venda" name="preco_venda"><br>
        
        <label for="codigo_barras">Código de Barras:</label>
        <input type="text" id="codigo_barras" name="codigo_barras" required><br>
        
        <label for="id_categoria">Categoria ID:</label>
        <input type="text" id="id_categoria" name="id_categoria" required><br>
        
        <label for="id_fornecedor">Fornecedor ID:</label>
        <input type="text" id="id_fornecedor" name="id_fornecedor" required><br>

        <input type="submit" value="Adicionar Produto">
    </form>
</body>
</html>
