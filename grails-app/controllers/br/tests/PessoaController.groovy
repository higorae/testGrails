package br.tests

import grails.transaction.Transactional;
import test.Book
import test.Pessoa;
import test.PessoaBook;

@Transactional(readOnly = true)
class PessoaController {
	static scaffold = Pessoa	
	
	@Transactional
	def	save(Pessoa pessoa) {
		if(pessoa == null) {
			notFound()
			return
		}
		
		if(pessoa.hasErrors()) {
			respond pessoa.errors, view:'create'
			return
		}
		
		pessoa.save flush:true
		
		request.withFormat {
			form multipartForm {
				flash.message = message(code: 'default.created.message', args: [message(code: 'pessoa.book.label', default: 'PessoaController'), pessoa.id])
				redirect pessoa
			}
			'*' { respond pessoa, [status: CREATED] }
		}
	}
	
	def show(Pessoa pessoa) {
		pessoa.books = PessoaBook.findAllByPessoa(pessoa)
		respond pessoa
	}
	
	def edit(Pessoa pessoa) {
		pessoa.books = PessoaBook.findAllByPessoa(pessoa)
		respond pessoa
	}
	
	@Transactional
	def	update(Pessoa pessoa) {
		if(pessoa == null) {
			notFound()
			return
		}
		
		if(pessoa.hasErrors()) {
			respond pessoa.errors, view:'edit'
			return
		}
		
		def _paraRemover = pessoa?.books?.findAll { (it?.removido) || (it == null) }
		
		if(_paraRemover) {
			pessoa.books.removeAll(_paraRemover)
		}
		
		pessoa.save flush:true
		
		request.withFormat {
			form multipartForm {
				flash.message = message(code: 'default.updated.message', args: [message(code: 'pessoa.book.label', default: 'PessoaController'), pessoa.id])
				redirect pessoa
			}
			'*' { respond pessoa, [status: CREATED] }
		}
	}
}
