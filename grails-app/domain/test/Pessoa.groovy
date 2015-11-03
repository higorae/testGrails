package test

class Pessoa {
	
	String nome
	
	String idade
	
	List<PessoaBook> books
	
	static hasMany = [books: PessoaBook]
	
	
	static mapping = {
		books cascade:"all-delete-orphan"
	}
	
    static constraints = {
		
    }
}
