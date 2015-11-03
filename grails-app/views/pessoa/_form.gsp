<%@ page import="test.Pessoa" %>

<div class="fieldcontain ${hasErrors(bean: pessoaInstance, field: 'idade', 'error')} required">
	<label for="idade">
		<g:message code="pessoa.idade.label" default="Idade" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="idade" required="" value="${pessoaInstance?.idade}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: pessoaInstance, field: 'nome', 'error')} required">
	<label for="nome">
		<g:message code="pessoa.nome.label" default="Nome" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nome" required="" value="${pessoaInstance?.nome}"/>

</div>
<div id="list">
	<g:each in="${pessoaInstance.books}" var="pessoa" status="i">
		<g:render template="pessoaBook" model="['pessoa':pessoa,'i':i,'hidden':false]"/>
	</g:each>
</div>

<div>
	<input type="submit" value="adicionar novo" id="adicionarNovo"/>
</div>

<script type="text/javascript">
	$(document).ready(function() {
		$("#adicionarNovo").click(function() {
			id = count_total();
			item = $("#doc_clone").parent().html();
			novo = item.replace(/_clone/g, id);
			$("#list").append(novo);
			$("#doc"+id).show();
			return false;
		});
	})
	var total = 0;
	
	function count_total() {
		return $("div[id*=doc]:visible").size();
	}
	


	function remover(item) {
		$("input[name=books\\["+item+"\\]\\.removido]").attr("checked", true);
		$("#doc"+item).hide();
	}
</script>