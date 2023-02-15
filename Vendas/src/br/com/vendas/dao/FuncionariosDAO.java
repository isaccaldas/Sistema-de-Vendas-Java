package br.com.vendas.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.vendas.domain.Funcionario;
import br.com.vendas.util.HibernateUtil;

public class FuncionariosDAO {

	// inclus�o de registros
		public void salvar(Funcionario funcionario) {

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
				sessao.save(funcionario); // salva o objeto informado no parametro.
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
		public List<Funcionario> listar() {

			Session sessao = HibernateUtil.getSessionFactory().openSession(); // iniciando
			// e
			// abrindo
			// a
			// sessao
			// de
			// conex�o

			List<Funcionario> funcionarios = null;

			try {

				Query consulta = sessao.getNamedQuery("Funcionario.listar"); // faz o link com a query criada em @NamedQuery da classe domain. 
				funcionarios = consulta.list();
				
			} catch (RuntimeException e) {

				throw e;

			} finally {
				sessao.close(); // fecha a sess�o
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
			// conex�o

			Funcionario funcionario = null;

			try {

				Query consulta = sessao.getNamedQuery("Funcionario.buscarPorCodigo"); // faz o link com a query criada em @NamedQuery da classe domain. 
				consulta.setLong("codigoUnico", codigo);
				funcionario = (Funcionario) consulta.uniqueResult(); // quando se tem um �nico resultado
				
			} catch (RuntimeException e) {

				throw e;

			} finally {
				sessao.close(); // fecha a sess�o
			}

			return funcionario;
			
		} // fim listar
		
		// exclus�o de registros
			public void excluir(Funcionario funcionario) {

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
					sessao.delete(funcionario); // exclui o objeto informado no parametro.
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
							Funcionario funcionario = buscarPorCodigo(codigo);
							sessao.delete(funcionario); // exclui o objeto informado no parametro.
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
					public void editar(Funcionario funcionario) {

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
							
							Funcionario funcionarioEditar = buscarPorCodigo(funcionario.getCodigo());
							funcionarioEditar.setCpf(funcionario.getCpf());
							funcionarioEditar.setSenha(funcionario.getSenha());
							funcionarioEditar.setFuncao(funcionario.getFuncao());
							funcionarioEditar.setNome(funcionario.getNome());
							
							
							sessao.update(funcionarioEditar); // exclui o objeto informado no parametro.
							transacao.commit(); // Confirmando a transac�o

						} catch (RuntimeException e) {

							if (transacao != null) {

								transacao.rollback(); // desfaz a transacao

							}

						} finally {
							sessao.close(); // fecha a sess�o
						}

					}// fim editar
	
	
}
