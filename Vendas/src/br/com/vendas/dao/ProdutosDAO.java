package br.com.vendas.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.vendas.domain.Produto;
import br.com.vendas.util.HibernateUtil;

public class ProdutosDAO {
	// inclusão de registros
			public void salvar(Produto produto) {

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
					sessao.save(produto); // salva o objeto informado no parametro.
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
			public List<Produto> listar() {

				Session sessao = HibernateUtil.getSessionFactory().openSession(); // iniciando
				// e
				// abrindo
				// a
				// sessao
				// de
				// conexão

				List<Produto> produtos = null;

				try {

					Query consulta = sessao.getNamedQuery("Produto.listar"); // faz o link com a query criada em @NamedQuery da classe domain. 
					produtos = consulta.list();
					
				} catch (RuntimeException e) {

					throw e;

				} finally {
					sessao.close(); // fecha a sessão
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
				// conexão

				Produto produto = null;

				try {

					Query consulta = sessao.getNamedQuery("Produto.buscarPorCodigo"); // faz o link com a query criada em @NamedQuery da classe domain. 
					consulta.setLong("codigoUnico", codigo);
					produto = (Produto) consulta.uniqueResult(); // quando se tem um único resultado
					
				} catch (RuntimeException e) {

					throw e;

				} finally {
					sessao.close(); // fecha a sessão
				}

				return produto;
				
			} // fim listar
			
			// exclusão de registros
				public void excluir(Produto produto) {

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
						sessao.delete(produto); // exclui o objeto informado no parametro.
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
								Produto produto = buscarPorCodigo(codigo);
								sessao.delete(produto); // exclui o objeto informado no parametro.
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
						public void editar(Produto produto) {

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
								
								Produto produtoEditar = buscarPorCodigo(produto.getCodigo());
								produtoEditar.setDescricao(produto.getDescricao());
								produtoEditar.setPreco(produto.getPreco());
								produtoEditar.setQuantidade(produto.getQuantidade());
								
								
								sessao.update(produtoEditar); // exclui o objeto informado no parametro.
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
