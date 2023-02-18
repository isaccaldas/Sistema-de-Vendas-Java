package br.com.vendas.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.vendas.domain.Venda;
import br.com.vendas.util.HibernateUtil;

public class VendasDAO {
	
	
	// inclus�o de registros
				public void salvar(Venda venda) {

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
						sessao.save(venda); // salva o objeto informado no parametro.
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
				public List<Venda> listar() {

					Session sessao = HibernateUtil.getSessionFactory().openSession(); // iniciando
					// e
					// abrindo
					// a
					// sessao
					// de
					// conex�o

					List<Venda> vendas = null;

					try {

						Query consulta = sessao.getNamedQuery("Venda.listar"); // faz o link com a query criada em @NamedQuery da classe domain. 
						vendas = consulta.list();
						
					} catch (RuntimeException e) {

						throw e;

					} finally {
						sessao.close(); // fecha a sess�o
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
					// conex�o

					Venda venda = null;

					try {

						Query consulta = sessao.getNamedQuery("Venda.buscarPorCodigo"); // faz o link com a query criada em @NamedQuery da classe domain. 
						consulta.setLong("codigoUnico", codigo);
						venda = (Venda) consulta.uniqueResult(); // quando se tem um �nico resultado
						
					} catch (RuntimeException e) {

						throw e;

					} finally {
						sessao.close(); // fecha a sess�o
					}

					return venda;
					
				} // fim listar
				
				// exclus�o de registros
					public void excluir(Venda venda) {

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
							sessao.delete(venda); // exclui o objeto informado no parametro.
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
									Venda venda = buscarPorCodigo(codigo);
									sessao.delete(venda); // exclui o objeto informado no parametro.
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
							public void editar(Venda venda) {

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
									
									Venda vendaEditar = buscarPorCodigo(venda.getCodigo());
									
									
									vendaEditar.setHorario(venda.getHorario());
									vendaEditar.setFuncionario(venda.getFuncionario());
									vendaEditar.setValor_total(venda.getValor_total());
									
									sessao.update(vendaEditar); // exclui o objeto informado no parametro.
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
