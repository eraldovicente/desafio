<div class="modal fade" id="adicionarFuncionarioModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Adicionar Funcionario</h5> 
                <button class="close" data-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>
            
            <form action="${pageContext.request.contextPath}/ServletControlador?acao=inserir"
                  method="POST" class="was-validated">
                
                <div class="modal-body">
                    <div class="form-group">
                        <label for="nome">Nome</label>
                        <input type="text" class="form-control" name="nome" required>
                    </div>
                    <div class="form-group">
                        <label for="cpf">Cpf</label>
                        <input type="text" class="form-control" name="cpf" required>
                    </div>
                    <div class="form-group">
                        <label for="comida">Comida</label>
                        <input type="text" class="form-control" name="comida" required>
                    </div>                   
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">Salvar</button>
                </div>    
            </form>
        </div>
    </div>
</div>
    