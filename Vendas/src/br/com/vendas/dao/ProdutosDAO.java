package br.com.vendas.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.vendas.domain.Produto;
import br.com.vendas.util.HibernateUtil;

public class ProdutosDAO {
	// inclus�o de registros
			public void salvar(Produto produto) {

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
					sessao.save(produto); // salva o objeto informado no parametro.
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
			public List<Produto> listar() {

				Session sessao = HibernateUtil.getSessionFactory().openSession(); // iniciando
				// e
				// abrindo
				// a
				// sessao
				// de
				// conex�o

				List<Produto> produtos = null;

				try {

					Query consulta = sessao.getNamedQuery("Produto.listar"); // faz o link com a query criada em @NamedQuery da classe domain. 
					produtos = consulta.list();
					
				} catch (RuntimeException e) {

					throw e;

				} finally {
					sessao.close(); // fecha a sess�o
				}

				return produtos;
				
			} // fim listar


			public Produto buscarPorCodigo(Long codigo) {

				Session sessao = HibernateUtil.getSessionFactory().openSession(); // iniciando
				// e
				// abrindo
				// a
				// sessao
				// de
				// conex�o

				Produto produto = null;

				try {

					Query consulta = sessao.getNamedQuery("Produto.buscarPorCodigo"); // faz o link com a query criada em @NamedQuery da classe domain. 
					consulta.setLong("codigoUnico", codigo);
					produto = (Produto) consulta.uniqueResult(); // quando se tem um �nico resultado
					
				} catch (RuntimeException e) {

					throw e;

				} finally {
					sessao.close(); // fecha a sess�o
				}

				return produto;
				
			} // fim listar
			
			// exclus�o de registros
				public void excluir(Produto produto) {

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
						sessao.delete(produto); // exclui o objeto informado no parametro.
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
								Produto produto = buscarPorCodigo(codigo);
								sessao.delete(produto); // exclui o objeto informado no parametro.
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
						public void editar(Produto produto) {

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
								
								Produto produtoEditar = buscarPorCodigo(produto.getCodigo());
								produtoEditar.setDescricao(produto.getDescricao());
								produtoEditar.setPreco(produto.getPreco());
								produtoEditar.setQuantidade(produto.getQuantidade());
								
								
								sessao.update(produtoEditar); // exclui o objeto informado no parametro.
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
