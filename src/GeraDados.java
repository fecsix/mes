import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.controle.mes.dao.JPAUtil;
import br.com.controle.mes.enumerate.SimNao;
import br.com.controle.mes.model.Funcionario;
import br.com.controle.mes.model.Menu;
import br.com.controle.mes.model.Perfil;
import br.com.controle.mes.model.Status;
import br.com.controle.mes.model.TipoApontamento;
import br.com.controle.mes.model.TipoCentroTrabalho;
import br.com.controle.mes.model.TipoStatus;
import br.com.controle.mes.model.Turno;
import br.com.controle.mes.model.Usuario;

public class GeraDados {

	public static void main(String[] args) {

		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();

		Menu m1 = new Menu();
		m1.setNome("Cadastros Basicos");
		m1.setAtivo(SimNao.SIM);
		m1.setIcone("");
		m1.setMenuPai(null);
		m1.setNivel(1);
		m1.setPosicao(10);
		m1.setURL("");
		em.persist(m1);

		Menu m2 = new Menu();
		m2.setNome("Manutencao");
		m2.setAtivo(SimNao.SIM);
		m2.setIcone("");
		m2.setMenuPai(null);
		m2.setNivel(1);
		m2.setPosicao(20);
		m2.setURL("");
		em.persist(m2);

		Menu m3 = new Menu();
		m3.setNome("MES");
		m3.setAtivo(SimNao.SIM);
		m3.setIcone("");
		m3.setMenuPai(null);
		m3.setNivel(1);
		m3.setPosicao(30);
		m3.setURL("");
		em.persist(m3);

		Menu m4 = new Menu();
		m4.setNome("Administracao");
		m4.setAtivo(SimNao.SIM);
		m4.setIcone("");
		m4.setMenuPai(null);
		m4.setNivel(1);
		m4.setPosicao(90);
		m4.setURL("");
		em.persist(m4);

		Menu m6 = new Menu();
		m6.setNome("Cliente");
		m6.setAtivo(SimNao.SIM);
		m6.setIcone("");
		m6.setMenuPai(m1);
		m6.setNivel(2);
		m6.setPosicao(10);
		m6.setURL("/listar/ListarCliente.xhtml");
		em.persist(m6);

		Menu m7 = new Menu();
		m7.setNome("Fornecedor");
		m7.setAtivo(SimNao.SIM);
		m7.setIcone("");
		m7.setMenuPai(m1);
		m7.setNivel(2);
		m7.setPosicao(20);
		m7.setURL("/listar/ListarFornecedor.xhtml");
		em.persist(m7);

		Menu m5 = new Menu();
		m5.setNome("Roteiro");
		m5.setAtivo(SimNao.SIM);
		m5.setIcone("");
		m5.setMenuPai(m1);
		m5.setNivel(2);
		m5.setPosicao(30);
		m5.setURL("");
		em.persist(m5);

		Menu m8 = new Menu();
		m8.setNome("Centro de Trabalho");
		m8.setAtivo(SimNao.SIM);
		m8.setIcone("");
		m8.setMenuPai(m5);
		m8.setNivel(3);
		m8.setPosicao(30);
		m8.setURL("/listar/ListarCentroTrabalho.xhtml");
		em.persist(m8);

		Menu m9 = new Menu();
		m9.setNome("Tarefa");
		m9.setAtivo(SimNao.SIM);
		m9.setIcone("");
		m9.setMenuPai(m5);
		m9.setNivel(3);
		m9.setPosicao(40);
		m9.setURL("/listar/ListarTarefa.xhtml");
		em.persist(m9);

		Menu m10 = new Menu();
		m10.setNome("Recurso");
		m10.setAtivo(SimNao.SIM);
		m10.setIcone("");
		m10.setMenuPai(m5);
		m10.setNivel(3);
		m10.setPosicao(50);
		m10.setURL("/listar/ListarRecurso.xhtml");
		em.persist(m10);

		Menu m11 = new Menu();
		m11.setNome("Roteiro");
		m11.setAtivo(SimNao.SIM);
		m11.setIcone("");
		m11.setMenuPai(m5);
		m11.setNivel(3);
		m11.setPosicao(60);
		m11.setURL("/listar/ListarRoteiro.xhtml");
		em.persist(m11);

		Menu m12 = new Menu();
		m12.setNome("Item");
		m12.setAtivo(SimNao.SIM);
		m12.setIcone("");
		m12.setMenuPai(m1);
		m12.setNivel(2);
		m12.setPosicao(40);
		m12.setURL("");
		em.persist(m12);

		Menu m13 = new Menu();
		m13.setNome("Unidade");
		m13.setAtivo(SimNao.SIM);
		m13.setIcone("");
		m13.setMenuPai(m12);
		m13.setNivel(3);
		m13.setPosicao(10);
		m13.setURL("/listar/ListarUnidade.xhtml");
		em.persist(m13);

		Menu m14 = new Menu();
		m14.setNome("Grupo de Item");
		m14.setAtivo(SimNao.SIM);
		m14.setIcone("");
		m14.setMenuPai(m12);
		m14.setNivel(3);
		m14.setPosicao(20);
		m14.setURL("/listar/ListarGrupoItem.xhtml");
		em.persist(m14);

		Menu m15 = new Menu();
		m15.setNome("Item");
		m15.setAtivo(SimNao.SIM);
		m15.setIcone("");
		m15.setMenuPai(m12);
		m15.setNivel(3);
		m15.setPosicao(30);
		m15.setURL("/listar/ListarItem.xhtml");
		em.persist(m15);

		Menu m16 = new Menu();
		m16.setNome("Turno");
		m16.setAtivo(SimNao.SIM);
		m16.setIcone("");
		m16.setMenuPai(m1);
		m16.setNivel(2);
		m16.setPosicao(50);
		m16.setURL("");
		em.persist(m16);

		Menu m17 = new Menu();
		m17.setNome("Faixa de Turno");
		m17.setAtivo(SimNao.SIM);
		m17.setIcone("");
		m17.setMenuPai(m16);
		m17.setNivel(3);
		m17.setPosicao(10);
		m17.setURL("/listar/ListarFaixaTurno.xhtml");
		em.persist(m17);

		Menu m18 = new Menu();
		m18.setNome("Turno");
		m18.setAtivo(SimNao.SIM);
		m18.setIcone("");
		m18.setMenuPai(m16);
		m18.setNivel(3);
		m18.setPosicao(20);
		m18.setURL("/listar/ListarTurno.xhtml");
		em.persist(m18);

		Menu m19 = new Menu();
		m19.setNome("Dispositivo");
		m19.setAtivo(SimNao.SIM);
		m19.setIcone("");
		m19.setMenuPai(m1);
		m19.setNivel(2);
		m19.setPosicao(60);
		m19.setURL("");
		em.persist(m19);

		Menu m20 = new Menu();
		m20.setNome("Tipo de Dispositivo");
		m20.setAtivo(SimNao.SIM);
		m20.setIcone("");
		m20.setMenuPai(m19);
		m20.setNivel(3);
		m20.setPosicao(10);
		m20.setURL("/listar/ListarTipoDispositivo.xhtml");
		em.persist(m20);

		Menu m21 = new Menu();
		m21.setNome("Dispositivo");
		m21.setAtivo(SimNao.SIM);
		m21.setIcone("");
		m21.setMenuPai(m19);
		m21.setNivel(3);
		m21.setPosicao(20);
		m21.setURL("/listar/ListarDispositivo.xhtml");
		em.persist(m21);

		Menu m22 = new Menu();
		m22.setNome("Configuração (Serial)");
		m22.setAtivo(SimNao.SIM);
		m22.setIcone("");
		m22.setMenuPai(m19);
		m22.setNivel(3);
		m22.setPosicao(30);
		m22.setURL("/listar/ListarConfiguracaoPorta.xhtml");
		em.persist(m22);

		Menu m23 = new Menu();
		m23.setNome("Dispositivo - Recurso");
		m23.setAtivo(SimNao.SIM);
		m23.setIcone("");
		m23.setMenuPai(m19);
		m23.setNivel(3);
		m23.setPosicao(40);
		m23.setURL("/listar/ListarDispositivoRecurso.xhtml");
		em.persist(m23);

		Menu m24 = new Menu();
		m24.setNome("Agendador");
		m24.setAtivo(SimNao.SIM);
		m24.setIcone("");
		m24.setMenuPai(m19);
		m24.setNivel(3);
		m24.setPosicao(50);
		m24.setURL("/listar/ListarAgendador.xhtml");
		em.persist(m24);

		Menu m25 = new Menu();
		m25.setNome("Ordem de Produção");
		m25.setAtivo(SimNao.SIM);
		m25.setIcone("");
		m25.setMenuPai(m2);
		m25.setNivel(2);
		m25.setPosicao(10);
		m25.setURL("");
		em.persist(m25);

		Menu m26 = new Menu();
		m26.setNome("Ordem de Produção");
		m26.setAtivo(SimNao.SIM);
		m26.setIcone("");
		m26.setMenuPai(m25);
		m26.setNivel(3);
		m26.setPosicao(10);
		m26.setURL("/listar/ListarOrdemProducao.xhtml");
		em.persist(m26);

		Menu m27 = new Menu();
		m27.setNome("Plano de Produção");
		m27.setAtivo(SimNao.SIM);
		m27.setIcone("");
		m27.setMenuPai(m25);
		m27.setNivel(3);
		m27.setPosicao(20);
		m27.setURL("/listar/ListarPlanoProducao.xhtml");
		em.persist(m27);

		Menu m28 = new Menu();
		m28.setNome("Leituras On-line");
		m28.setAtivo(SimNao.SIM);
		m28.setIcone("");
		m28.setMenuPai(m3);
		m28.setNivel(2);
		m28.setPosicao(10);
		m28.setURL("/listar/ListarLeiturasOnLine.xhtml");
		em.persist(m28);

		Menu m29 = new Menu();
		m29.setNome("OEE");
		m29.setAtivo(SimNao.SIM);
		m29.setIcone("");
		m29.setMenuPai(m3);
		m29.setNivel(2);
		m29.setPosicao(20);
		m29.setURL("/listar/ListarOEE.xhtml");
		em.persist(m29);

		Menu m30 = new Menu();
		m30.setNome("Painel");
		m30.setAtivo(SimNao.SIM);
		m30.setIcone("");
		m30.setMenuPai(m3);
		m30.setNivel(2);
		m30.setPosicao(30);
		m30.setURL("");
		em.persist(m30);

		Menu m31 = new Menu();
		m31.setNome("Produtividade");
		m31.setAtivo(SimNao.SIM);
		m31.setIcone("");
		m31.setMenuPai(m30);
		m31.setNivel(3);
		m31.setPosicao(10);
		m31.setURL("/listar/ListarProdutividade.xhtml");
		em.persist(m31);

		Menu m32 = new Menu();
		m32.setNome("Paradas");
		m32.setAtivo(SimNao.SIM);
		m32.setIcone("");
		m32.setMenuPai(m30);
		m32.setNivel(3);
		m32.setPosicao(20);
		m32.setURL("/listar/ListarParadas.xhtml");
		em.persist(m32);

		Menu m33 = new Menu();
		m33.setNome("Empresa");
		m33.setAtivo(SimNao.SIM);
		m33.setIcone("");
		m33.setMenuPai(m4);
		m33.setNivel(2);
		m33.setPosicao(10);
		m33.setURL("/listar/ListarEmpresa.xhtml");
		em.persist(m33);

		Menu m34 = new Menu();
		m34.setNome("Permissão");
		m34.setAtivo(SimNao.SIM);
		m34.setIcone("");
		m34.setMenuPai(m4);
		m34.setNivel(2);
		m34.setPosicao(20);
		m34.setURL("");
		em.persist(m34);

		Menu m35 = new Menu();
		m35.setNome("Perfil");
		m35.setAtivo(SimNao.SIM);
		m35.setIcone("");
		m35.setMenuPai(m34);
		m35.setNivel(3);
		m35.setPosicao(20);
		m35.setURL("/listar/ListarPerfil.xhtml");
		em.persist(m35);

		Menu m36 = new Menu();
		m36.setNome("Usuário");
		m36.setAtivo(SimNao.SIM);
		m36.setIcone("");
		m36.setMenuPai(m34);
		m36.setNivel(3);
		m36.setPosicao(30);
		m36.setURL("/listar/ListarUsuario.xhtml");
		em.persist(m36);

		Menu m37 = new Menu();
		m37.setNome("Menu");
		m37.setAtivo(SimNao.SIM);
		m37.setIcone("");
		m37.setMenuPai(m34);
		m37.setNivel(3);
		m37.setPosicao(10);
		m37.setURL("/listar/ListarMenu.xhtml");
		em.persist(m37);

		Perfil p1 = new Perfil();
		p1.setNome("Administrador");
		p1.setDescricao("Usuario Administrador");
		p1.setAtivo(SimNao.SIM);
		List<Menu> l1 = new ArrayList<Menu>();
		l1.add(m1);
		l1.add(m2);
		l1.add(m3);
		l1.add(m4);
		l1.add(m5);
		l1.add(m6);
		l1.add(m7);
		l1.add(m8);
		l1.add(m9);
		l1.add(m10);
		l1.add(m11);
		l1.add(m12);
		l1.add(m13);
		l1.add(m14);
		l1.add(m15);
		l1.add(m16);
		l1.add(m17);
		l1.add(m18);
		l1.add(m19);
		l1.add(m20);
		l1.add(m21);
		l1.add(m22);
		l1.add(m23);
		l1.add(m24);
		l1.add(m25);
		l1.add(m26);
		l1.add(m27);
		l1.add(m28);
		l1.add(m29);
		l1.add(m30);
		l1.add(m31);
		l1.add(m32);
		l1.add(m33);
		l1.add(m34);
		l1.add(m35);
		l1.add(m36);
		l1.add(m37);
		p1.setListaMenus(l1);
		em.persist(p1);

		Perfil p2 = new Perfil();
		p2.setNome("Comum");
		p2.setDescricao("Usuario Comum");
		p2.setAtivo(SimNao.SIM);
		List<Menu> l2 = new ArrayList<Menu>();
		l2.add(m1);
		l2.add(m2);
		l2.add(m3);
		l2.add(m5);
		l2.add(m6);
		l2.add(m7);
		l2.add(m8);
		l2.add(m9);
		l2.add(m10);
		l2.add(m11);
		l2.add(m12);
		l2.add(m13);
		l2.add(m14);
		l2.add(m15);
		l2.add(m16);
		l2.add(m17);
		l2.add(m18);
		l2.add(m19);
		l2.add(m20);
		l2.add(m21);
		l2.add(m22);
		l2.add(m23);
		l2.add(m24);
		l2.add(m25);
		l2.add(m26);
		l2.add(m27);
		l2.add(m28);
		l2.add(m29);
		l2.add(m30);
		l2.add(m31);
		l2.add(m32);
		p2.setListaMenus(l2);
		em.persist(p2);

		Usuario u1 = new Usuario();
		u1.setNome("Administrador");
		u1.setLogin("admin");
		u1.setSenha("123");
		u1.setPerfil(p1);
		u1.setAtivo(SimNao.SIM);
		em.persist(u1);

		Usuario u2 = new Usuario();
		u2.setNome("Wilson");
		u2.setLogin("wilson");
		u2.setSenha("123");
		u2.setPerfil(p2);
		u2.setAtivo(SimNao.SIM);
		em.persist(u2);

		TipoStatus ts1 = new TipoStatus();
		ts1.setId(1L);
		ts1.setDescricao("MESApontamento");
		em.persist(ts1);

		TipoStatus ts2 = new TipoStatus();
		ts2.setId(2L);
		ts2.setDescricao("MESOrdemProducao");
		em.persist(ts2);

		Status s1 = new Status();
		s1.setId(1L);
		s1.setDescricao("Aberto");
		s1.setTipoStatus(ts1);
		em.persist(s1);

		Status s2 = new Status();
		s2.setId(2L);
		s2.setDescricao("Encerrado");
		s2.setTipoStatus(ts1);
		em.persist(s2);

		Status s3 = new Status();
		s3.setId(3L);
		s3.setDescricao("Planejada");
		s3.setTipoStatus(ts2);
		em.persist(s3);

		TipoApontamento ta1 = new TipoApontamento();
		ta1.setId(0L);
		ta1.setCodigo("Produção");
		ta1.setDescricao("Produção");
		em.persist(ta1);

		TipoApontamento ta2 = new TipoApontamento();
		ta2.setId(1L);
		ta2.setCodigo("Setup");
		ta2.setDescricao("Setup");
		em.persist(ta2);

		TipoApontamento ta3 = new TipoApontamento();
		ta3.setId(2L);
		ta3.setCodigo("Hora Indireta");
		ta3.setDescricao("Hora Indireta");
		em.persist(ta3);

		TipoCentroTrabalho tct1 = new TipoCentroTrabalho();
		tct1.setId(0L);
		tct1.setCodigo("Direto");
		tct1.setDescricao("Direto");
		em.persist(tct1);

		TipoCentroTrabalho tct2 = new TipoCentroTrabalho();
		tct2.setId(1L);
		tct2.setCodigo("Indireto");
		tct2.setDescricao("Indireto");
		em.persist(tct2);

		TipoCentroTrabalho tct3 = new TipoCentroTrabalho();
		tct3.setId(2L);
		tct3.setCodigo("Subcontratado");
		tct3.setDescricao("Subcontratado");
		em.persist(tct3);

		Turno tu1 = new Turno();
		tu1.setCodigo("Comercial");
		tu1.setDescricao("Comercial");
		em.persist(tu1);

		Funcionario f1 = new Funcionario();
		f1.setCodigo("1");
		f1.setNome("Wilson");
		f1.setMail("wilsonbernache@pecsys.com");
		f1.setUsuario(u1);
		f1.setTurno(tu1);
		em.persist(f1);

		em.getTransaction().commit();
		em.close();

	}

}