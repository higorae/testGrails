package test

import org.apache.commons.lang.builder.HashCodeBuilder

class PessoaBook implements Serializable {
	
	Book book
	Pessoa pessoa
	String descricao
	Boolean removido
	
    static constraints = {
		removido bindable: true
    }
	
	static transients = ['removido']
	
	static belongsTo = [ Book, Pessoa ]
	
	boolean equals(other) {
		if (!(other instanceof PessoaBook)) {
			return false
		}
	
		other.pessoa?.id == pessoa?.id &&
			other.book?.id == book?.id
	}
	
	int hashCode() {
		def builder = new HashCodeBuilder()
		if (book) builder.append(book.id)
		if (pessoa) builder.append(pessoa.id)
		builder.toHashCode()
	}
}
