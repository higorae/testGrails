import test.Book
import test.Pessoa
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_test_pessoa_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/pessoa/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
expressionOut.print(hasErrors(bean: pessoaInstance, field: 'books', 'error'))
printHtmlPart(2)
invokeTag('message','g',7,['code':("pessoa.books.description.label"),'default':("Descrição")],-1)
printHtmlPart(3)
invokeTag('select','g',10,['name':("books[2].book.id"),'from':(Book.list()),'optionKey':("id"),'optionValue':("title")],-1)
printHtmlPart(4)
for( _it2112036973 in (pessoaInstance.books) ) {
changeItVariable(_it2112036973)
printHtmlPart(5)
expressionOut.print(hasErrors(bean: pessoaInstance, field: 'books', 'error'))
printHtmlPart(6)
invokeTag('message','g',16,['code':("pessoa.books.description.label"),'default':("Descrição")],-1)
printHtmlPart(7)
invokeTag('select','g',19,['name':("books[1].book.id"),'from':(Book.list()),'optionKey':("id"),'optionValue':("title"),'value':(book.id)],-1)
printHtmlPart(8)
}
printHtmlPart(9)
expressionOut.print(hasErrors(bean: pessoaInstance, field: 'idade', 'error'))
printHtmlPart(10)
invokeTag('message','g',25,['code':("pessoa.idade.label"),'default':("Idade")],-1)
printHtmlPart(11)
invokeTag('textField','g',28,['name':("idade"),'required':(""),'value':(pessoaInstance?.idade)],-1)
printHtmlPart(12)
expressionOut.print(hasErrors(bean: pessoaInstance, field: 'nome', 'error'))
printHtmlPart(13)
invokeTag('message','g',34,['code':("pessoa.nome.label"),'default':("Nome")],-1)
printHtmlPart(11)
invokeTag('textField','g',37,['name':("nome"),'required':(""),'value':(pessoaInstance?.nome)],-1)
printHtmlPart(14)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1446316175000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
