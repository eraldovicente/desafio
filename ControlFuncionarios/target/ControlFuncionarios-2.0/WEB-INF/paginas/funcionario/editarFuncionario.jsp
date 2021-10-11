<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/f90d3bf50d.js" crossorigin="anonymous"></script>

        <title>Editar Funcionario</title>
    </head>
    <body>
        <jsp:include page="/WEB-INF/paginas/comuns/cabecalho.jsp"/>

        <form action="${pageContext.request.contextPath}/ServletControlador?acao=modificar&idFuncionario=${funcionario.idFuncionario}"
              method="POST" class="was-validated">

            <!--Botones de Navegacion -->
            <jsp:include page="/WEB-INF/paginas/comuns/botoesNavegacaoEditar.jsp"/>

            <section id="details">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="card">
                                <div class="card-header">
                                    <h4>Editar Funcionario</h4>
                                </div>
                                <div class="card-body">
                                    <div class="form-group">
                                        <label for="nome">Nome</label>
                                        <input type="text" class="form-control" name="nome" required value="${funcionario.nome}">
                                    </div>
                                    <div class="form-group">
                                        <label for="cpf">Cpf</label>
                                        <input type="text" class="form-control" name="cpf" required value="${funcionario.cpf}">
                                    </div>
                                    <div class="form-group">
                                        <label for="comida">Comida</label>
                                        <input type="text" class="form-control" name="comida" required value="${funcionario.comida}">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>

        </form>

        <jsp:include page="/WEB-INF/paginas/comuns/rodape.jsp"/>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

    </body>
</html>
