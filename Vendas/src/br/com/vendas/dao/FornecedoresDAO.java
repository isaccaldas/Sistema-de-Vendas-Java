package br.com.vendas.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.vendas.domain.Fornecedor;
import br.com.vendas.util.HibernateUtil;

public class FornecedoresDAO {

	// inclus�o de registros
	public void salvar(Fornecedor fornecedor) {

		Session sessao = HibernateUtil.getSessionFactory().openSession(); // iniciando
																			// e
																			// abrindo
																			// a
																			// sessao
																			// de
																			// conex�o

		Transaction transacao = null;

		try {

			transacao = sessao.beginTransaction(); // Iniciando a trasansa�ao
			sessao.save(fornecedor); // salva o objeto informado no parametro.
			transacao.commit(); // Confirmando a transac�o

		} catch (RuntimeException e) {

			if (transacao != null) {

				transacao.rollback(); // desfaz a transacao

			}

		} finally {
			sessao.close(); // fecha a sess�o
		}

	}// fim salvar

	@SuppressWarnings("unchecked")
	public List<Fornecedor> listar() {

		Session sessao = HibernateUtil.getSessionFactory().openSession(); // iniciando
		// e
		// abrindo
		// a
		// sessao
		// de
		// conex�o

		List<Fornecedor> fornecedores = null;

		try {

			Query consulta = sessao.getNamedQuery("Fornecedor.listar"); // faz o link com a query criada em @NamedQuery da classe domain. 
			fornecedores = consulta.list();
			
		} catch (RuntimeException e) {

			throw e;

		} finally {
			sessao.close(); // fecha a sess�o
		}

		return fornecedores;
		
	} // fim listar


	public Fornecedor buscarPorCodigo(Long codigo) {

		Session sessao = HibernateUtil.getSessionFactory().openSession(); // iniciando
		// e
		// abrindo
		// a
		// sessao
		// de
		// conex�o

		Fornecedor fornecedor = null;

		try {

			Query consulta = sessao.getNamedQuery("Fornecedor.buscarPorCodigo"); // faz o link com a query criada em @NamedQuery da classe domain. 
			consulta.setLong("codigoUnico", codigo);
			fornecedor = (Fornecedor) consulta.uniqueResult(); // quando se tem um �nico resultado
			
		} catch (RuntimeException e) {

			throw e;

		} finally {
			sessao.close(); // fecha a sess�o
		}

		return fornecedor;
		
	} // fim listar
	
	// exclus�o de registros
		public void excluir(Fornecedor fornecedor) {

			Session sessao = HibernateUtil.getSessionFactory().openSession(); // iniciando
																				// e
																				// abrindo
																				// a
																				// sessao
																				// de
																				// conex�o

			Transaction transacao = null;

			try {

				transacao = sessao.beginTransaction(); // Iniciando a trasansa�ao
				sessao.delete(fornecedor); // exclui o objeto informado no parametro.
				transacao.commit(); // Confirmando a transac�o

			} catch (RuntimeException e) {

				if (transacao != null) {

					transacao.rollback(); // desfaz a transacao

				}

			} finally {
				sessao.close(); // fecha a sess�o
			}

		}// fim excluir
		
		
		// exclus�o de registros
				public void excluir(Long codigo) {

					Session sessao = HibernateUtil.getSessionFactory().openSession(); // iniciando
																						// e
																						// abrindo
																						// a
																						// sessao
																						// de
																						// conex�o

					Transaction transacao = null;

					try {

						transacao = sessao.beginTransaction(); // Iniciando a trasansa�ao
						Fornecedor fornecedor = buscarPorCodigo(codigo);
						sessao.delete(fornecedor); // exclui o objeto informado no parametro.
						transacao.commit(); // Confirmando a transac�o

					} catch (RuntimeException e) {

						if (transacao != null) {

							transacao.rollback(); // desfaz a transacao

						}

					} finally {
						sessao.close(); // fecha a sess�o
					}

				}// fim excluir
		
				// altera��o de registros
				public void editar(Fornecedor fornecedor) {

					Session sessao = HibernateUtil.getSessionFactory().openSession(); // iniciando
																						// e
																						// abrindo
																						// a
																						// sessao
																						// de
																						// conex�o

					Transaction transacao = null;

					try {

						transacao = sessao.beginTransaction(); // Iniciando a trasansa�ao
						
						Fornecedor fornecedorEditar = buscarPorCodigo(fornecedor.getCodigo());
						fornecedorEditar.setDescricao(fornecedor.getDescricao());
						
						sessao.update(fornecedorEditar); // exclui o objeto informado no parametro.
						transacao.commit(); // Confirmando a transac�o

					} catch (RuntimeException e) {

						if (transacao != null) {

							transacao.rollback(); // desfaz a transacao

						}

					} finally {
						sessao.close(); // fecha a sess�o
					}

				}// fim excluir
				
}
