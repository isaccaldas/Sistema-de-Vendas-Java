package br.com.vendas.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.vendas.domain.Venda;
import br.com.vendas.util.HibernateUtil;

public class VendasDAO {
	
	
	// inclusão de registros
				public void salvar(Venda venda) {

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
						sessao.save(venda); // salva o objeto informado no parametro.
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
				public List<Venda> listar() {

					Session sessao = HibernateUtil.getSessionFactory().openSession(); // iniciando
					// e
					// abrindo
					// a
					// sessao
					// de
					// conexão

					List<Venda> vendas = null;

					try {

						Query consulta = sessao.getNamedQuery("Venda.listar"); // faz o link com a query criada em @NamedQuery da classe domain. 
						vendas = consulta.list();
						
					} catch (RuntimeException e) {

						throw e;

					} finally {
						sessao.close(); // fecha a sessão
					}

					return vendas;
					
				} // fim listar


				public Venda buscarPorCodigo(Long codigo) {

					Session sessao = HibernateUtil.getSessionFactory().openSession(); // iniciando
					// e
					// abrindo
					// a
					// sessao
					// de
					// conexão

					Venda venda = null;

					try {

						Query consulta = sessao.getNamedQuery("Venda.buscarPorCodigo"); // faz o link com a query criada em @NamedQuery da classe domain. 
						consulta.setLong("codigoUnico", codigo);
						venda = (Venda) consulta.uniqueResult(); // quando se tem um único resultado
						
					} catch (RuntimeException e) {

						throw e;

					} finally {
						sessao.close(); // fecha a sessão
					}

					return venda;
					
				} // fim listar
				
				// exclusão de registros
					public void excluir(Venda venda) {

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
							sessao.delete(venda); // exclui o objeto informado no parametro.
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
									Venda venda = buscarPorCodigo(codigo);
									sessao.delete(venda); // exclui o objeto informado no parametro.
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
							public void editar(Venda venda) {

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
									
									Venda vendaEditar = buscarPorCodigo(venda.getCodigo());
									
									
									vendaEditar.setHorario(venda.getHorario());
									vendaEditar.setFuncionario(venda.getFuncionario());
									vendaEditar.setValor_total(venda.getValor_total());
									
									sessao.update(vendaEditar); // exclui o objeto informado no parametro.
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
