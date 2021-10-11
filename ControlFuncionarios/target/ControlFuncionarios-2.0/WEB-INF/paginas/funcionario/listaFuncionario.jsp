<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section id="clientes">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <div class="card">
                    <div class="card-header">
                        <h4>Lista de Funcionarios</h4>
                    </div>
                    <table class="table table-striped">
                        <thead class="thead-dark">
                            <tr>
                                <th>#</th>
                                <th>Nome</th>
                                <th>Cpf</th>
                                <th>Comida</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="funcionario" items="${funcionarios}" varStatus="status" >
                                <tr>
                                    <td>${status.count}</td>
                                    <td>${funcionario.nome}</td>
                                    <td>${funcionario.cpf}</td>
                                    <td>${funcionario.comida}</td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/ServletControlador?acao=editar&idFuncionario=${funcionario.idFuncionario}"
                                           class="btn btn-secondary">
                                            <i class="fas fa-angle-double-right"></i> Editar
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>

 
        </div>
    </div>
</section>

<jsp:include page="/WEB-INF/paginas/funcionario/adicionarFuncionario.jsp"/>
                        