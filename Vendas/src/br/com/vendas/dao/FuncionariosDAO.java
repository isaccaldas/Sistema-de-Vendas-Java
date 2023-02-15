package br.com.vendas.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.vendas.domain.Funcionario;
import br.com.vendas.util.HibernateUtil;

public class FuncionariosDAO {

	// inclusão de registros
		public void salvar(Funcionario funcionario) {

			Session sessao = HibernateUtil.getSessionFactory().openSession(); // iniciando
																				// e
																				// abrindo
																				// a
																				// sessao
																				// de
																				// conexão

			Transaction transacao = null;

			try {

				transacao = sessao.beginTransaction(); // Iniciando a trasansaçao
				sessao.save(funcionario); // salva o objeto informado no parametro.
				transacao.commit(); // Confirmando a transacão

			} catch (RuntimeException e) {

				if (transacao != null) {

					transacao.rollback(); // desfaz a transacao

				}

			} finally {
				sessao.close(); // fecha a sessão
			}

		}// fim salvar

		@SuppressWarnings("unchecked")
		public List<Funcionario> listar() {

			Session sessao = HibernateUtil.getSessionFactory().openSession(); // iniciando
			// e
			// abrindo
			// a
			// sessao
			// de
			// conexão

			List<Funcionario> funcionarios = null;

			try {

				Query consulta = sessao.getNamedQuery("Funcionario.listar"); // faz o link com a query criada em @NamedQuery da classe domain. 
				funcionarios = consulta.list();
				
			} catch (RuntimeException e) {

				throw e;

			} finally {
				sessao.close(); // fecha a sessão
			}

			return funcionarios;
			
		} // fim listar


		public Funcionario buscarPorCodigo(Long codigo) {

			Session sessao = HibernateUtil.getSessionFactory().openSession(); // iniciando
			// e
			// abrindo
			// a
			// sessao
			// de
			// conexão

			Funcionario funcionario = null;

			try {

				Query consulta = sessao.getNamedQuery("Funcionario.buscarPorCodigo"); // faz o link com a query criada em @NamedQuery da classe domain. 
				consulta.setLong("codigoUnico", codigo);
				funcionario = (Funcionario) consulta.uniqueResult(); // quando se tem um único resultado
				
			} catch (RuntimeException e) {

				throw e;

			} finally {
				sessao.close(); // fecha a sessão
			}

			return funcionario;
			
		} // fim listar
		
		// exclusão de registros
			public void excluir(Funcionario funcionario) {

				Session sessao = HibernateUtil.getSessionFactory().openSession(); // iniciando
																					// e
																					// abrindo
																					// a
																					// sessao
																					// de
																					// conexão

				Transaction transacao = null;

				try {

					transacao = sessao.beginTransaction(); // Iniciando a trasansaçao
					sessao.delete(funcionario); // exclui o objeto informado no parametro.
					transacao.commit(); // Confirmando a transacão

				} catch (RuntimeException e) {

					if (transacao != null) {

						transacao.rollback(); // desfaz a transacao

					}

				} finally {
					sessao.close(); // fecha a sessão
				}

			}// fim excluir
			
			
			// exclusão de registros
					public void excluir(Long codigo) {

						Session sessao = HibernateUtil.getSessionFactory().openSession(); // iniciando
																							// e
																							// abrindo
																							// a
																							// sessao
																							// de
																							// conexão

						Transaction transacao = null;

						try {

							transacao = sessao.beginTransaction(); // Iniciando a trasansaçao
							Funcionario funcionario = buscarPorCodigo(codigo);
							sessao.delete(funcionario); // exclui o objeto informado no parametro.
							transacao.commit(); // Confirmando a transacão

						} catch (RuntimeException e) {

							if (transacao != null) {

								transacao.rollback(); // desfaz a transacao

							}

						} finally {
							sessao.close(); // fecha a sessão
						}

					}// fim excluir
			
					// alteração de registros
					public void editar(Funcionario funcionario) {

						Session sessao = HibernateUtil.getSessionFactory().openSession(); // iniciando
																							// e
																							// abrindo
																							// a
																							// sessao
																							// de
																							// conexão

						Transaction transacao = null;

						try {

							transacao = sessao.beginTransaction(); // Iniciando a trasansaçao
							
							Funcionario funcionarioEditar = buscarPorCodigo(funcionario.getCodigo());
							funcionarioEditar.setCpf(funcionario.getCpf());
							funcionarioEditar.setSenha(funcionario.getSenha());
							funcionarioEditar.setFuncao(funcionario.getFuncao());
							funcionarioEditar.setNome(funcionario.getNome());
							
							
							sessao.update(funcionarioEditar); // exclui o objeto informado no parametro.
							transacao.commit(); // Confirmando a transacão

						} catch (RuntimeException e) {

							if (transacao != null) {

								transacao.rollback(); // desfaz a transacao

							}

						} finally {
							sessao.close(); // fecha a sessão
						}

					}// fim editar
	
	
}
