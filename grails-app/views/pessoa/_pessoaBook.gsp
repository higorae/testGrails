<%@page import="test.Book"%>
<div class="wrapper">
	<div id="doc${i}" <g:if test="${hidden}"> style="display:none" </g:if>>
		<div class="fieldcontain">
			<label for="books">
				<g:message code="pessoa.books.description.label" default="Descrição" /> ${i }
				
			</label>
			<g:select name="books[${i}].book.id" from="${Book.list()}" optionKey="id" optionValue="title" value="${pessoa?.book?.id}"/>
		
		</div>
		
		<div class="fieldcontain ${hasErrors(bean: pessoaInstance, field: 'books', 'error')} ">
			<label for="books">
				<g:message code="pessoa.description.label" default="Descrição" /> ${i }
				
			</label>
			<g:textArea name="books[${i}].descricao" value="${pessoa?.descricao}"/>
		
		</div>
		<g:if test="${pessoa?.id != null }">
			<g:hiddenField name="books[${i}].id" value="${pessoa?.id}"/>
		</g:if>
		<g:checkBox name="books[${i}].removido" />
		<input type="submit" value="remover" onclick="remover(${i});return false;"/>
	</div>
</div>