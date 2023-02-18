package br.com.vendas.dao;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.vendas.domain.Item;
import br.com.vendas.util.HibernateUtil;

public class ItemDAO {
	

	
	// inclusão de registros
				public void salvar(Item item) {

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
						sessao.save(item); // salva o objeto informado no parametro.
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
				public List<Item> listar() {

					Session sessao = HibernateUtil.getSessionFactory().openSession(); // iniciando
					// e
					// abrindo
					// a
					// sessao
					// de
					// conexão

					List<Item> itens = null;

					try {

						Query consulta = sessao.getNamedQuery("Item.listar"); // faz o link com a query criada em @NamedQuery da classe domain. 
						itens = consulta.list();
						
					} catch (RuntimeException e) {

						throw e;

					} finally {
						sessao.close(); // fecha a sessão
					}

					return itens;
					
				} // fim listar


				public Item buscarPorCodigo(Long codigo) {

					Session sessao = HibernateUtil.getSessionFactory().openSession(); // iniciando
					// e
					// abrindo
					// a
					// sessao
					// de
					// conexão

					Item item = null;

					try {

						Query consulta = sessao.getNamedQuery("Item.buscarPorCodigo"); // faz o link com a query criada em @NamedQuery da classe domain. 
						consulta.setLong("codigoUnico", codigo);
						item = (Item) consulta.uniqueResult(); // quando se tem um único resultado
						
					} catch (RuntimeException e) {

						throw e;

					} finally {
						sessao.close(); // fecha a sessão
					}

					return item;
					
				} // fim listar
				
				// exclusão de registros
					public void excluir(Item item) {

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
							sessao.delete(item); // exclui o objeto informado no parametro.
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
									Item item = buscarPorCodigo(codigo);
									sessao.delete(item); // exclui o objeto informado no parametro.
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
							public void editar(Item item) {

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
									
									Item itemEditar = buscarPorCodigo(item.getCodigo());
									
									itemEditar.setProduto(item.getProduto());
									itemEditar.setVenda(item.getVenda());
									itemEditar.setQuantidade(item.getQuantidade());
									itemEditar.setValor_parcial(item.getValor_parcial());
																									
									sessao.update(itemEditar); // exclui o objeto informado no parametro.
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
