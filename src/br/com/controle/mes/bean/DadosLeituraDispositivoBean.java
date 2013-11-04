package br.com.controle.mes.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.controle.mes.dao.Auditavel;
import br.com.controle.mes.dao.DAO;
import br.com.controle.mes.dao.DadosLeituraDispositivoDAO;
import br.com.controle.mes.dao.DispositivoDAO;
import br.com.controle.mes.dao.Transactional;
import br.com.controle.mes.enumerate.SimNao;
import br.com.controle.mes.enumerate.StatusDadosLeitura;
import br.com.controle.mes.model.Agendador;
import br.com.controle.mes.model.DadosLeituraDispositivo;
import br.com.controle.mes.model.Dispositivo;

import com.serotonin.io.serial.SerialParameters;
import com.serotonin.modbus4j.ModbusFactory;
import com.serotonin.modbus4j.ModbusMaster;
import com.serotonin.modbus4j.code.DataType;
import com.serotonin.modbus4j.code.RegisterRange;
import com.serotonin.modbus4j.exception.ErrorResponseException;
import com.serotonin.modbus4j.exception.ModbusInitException;
import com.serotonin.modbus4j.exception.ModbusTransportException;

@RequestScoped
@Named
public class DadosLeituraDispositivoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private DadosLeituraDispositivo dadosLeituraDispositivo = new DadosLeituraDispositivo();

	private List<DadosLeituraDispositivo> dadosLeituraDispositivos;

	private Long dadosLeituraDispositivoId;

	@Inject
	private DAO<DadosLeituraDispositivo> dao;
	
	@Inject
	private DadosLeituraDispositivoDAO dadosLeituraDAO;

	@Inject
	private DAO<Agendador> agendadaorDao;

	@Inject
	private DispositivoDAO dispositivoDao;

	private String valorContador;

	public DadosLeituraDispositivo getDadosLeituraDispositivo() {
		return dadosLeituraDispositivo;
	}

	public void setDadosLeituraDispositivo(
			DadosLeituraDispositivo dadosLeituraDispositivo) {
		this.dadosLeituraDispositivo = dadosLeituraDispositivo;
	}

	public Long getDadosLeituraDispositivoId() {
		return dadosLeituraDispositivoId;
	}

	public void setDadosLeituraDispositivoId(Long dadosLeituraDispositivoId) {
		this.dadosLeituraDispositivoId = dadosLeituraDispositivoId;
	}

	@Transactional
	@Auditavel
	public String gravar() {
		if (dadosLeituraDispositivo.getId() != null)
			dao.atualiza(dadosLeituraDispositivo);
		else
			dao.adiciona(dadosLeituraDispositivo);
		this.dadosLeituraDispositivo = new DadosLeituraDispositivo();
		this.dadosLeituraDispositivos = dao.listaTodos();
		return "/listar/ListarDadosLeituraDispositivo";
	}

	public List<DadosLeituraDispositivo> getDispositivos() {
		if (dadosLeituraDispositivos == null)
			dadosLeituraDispositivos = dao.listaTodos();

		return dadosLeituraDispositivos;
	}

	@Transactional
	public void remove(DadosLeituraDispositivo dispositivo) {
		dao.remove(dadosLeituraDispositivo);
		this.dadosLeituraDispositivos = dao.listaTodos();
	}

	public void carregadadosLeituraDispositivo() {
		if (dadosLeituraDispositivoId != null && dadosLeituraDispositivoId != 0)
			dadosLeituraDispositivo = dao.buscaPorId(dadosLeituraDispositivoId);
	}

	@Transactional
	@Auditavel
	public void rodarAgendador() {

		for (Agendador ag : agendadaorDao.listaTodos()) {
			if (ag.getAtivo().equals(SimNao.SIM))
				carregaDispositivos(ag);
		}
	}

	public void carregaDispositivos(Agendador agendador) {
		List<Dispositivo> dispositivos = new ArrayList<Dispositivo>();
		dispositivos = dispositivoDao.listarDispositivoAgendador(agendador);
		for (Dispositivo dispositivo : dispositivos) {
			lerDispositivos(agendador, dispositivo);
		}
	}

	public void gravarLeituraAgendador(Dispositivo dispositivo, Long valor) {
		Calendar data  = new GregorianCalendar();
		dadosLeituraDispositivo.setDataLeitura(data); 
		dadosLeituraDispositivo.setDispositivo(dispositivo);
		dadosLeituraDispositivo.setValor(valor);
		dadosLeituraDispositivo.setHora(0L);
		dadosLeituraDispositivo.setStatus(StatusDadosLeitura.LIDA);
		if (dadosLeituraDispositivo.getId() != null)
			dao.atualiza(dadosLeituraDispositivo);
		else {
			System.out.println("entrou");
			dao.adiciona(dadosLeituraDispositivo);
			System.out.println("saiu");
		}

		this.dadosLeituraDispositivo = new DadosLeituraDispositivo();
	}

	public void lerDispositivos(Agendador agendador, Dispositivo dispositivo) {
		ModbusFactory factory = new ModbusFactory();
		SerialParameters params = new SerialParameters();
		params.setCommPortId(agendador.getConfiguracaoPorta().getCodigo());
		params.setBaudRate(Integer.parseInt(agendador.getConfiguracaoPorta()
				.getBaudRate().toString()));
		params.setDataBits(Integer.parseInt(agendador.getConfiguracaoPorta()
				.getDataBits().toString()));
		params.setStopBits(Integer.parseInt(agendador.getConfiguracaoPorta()
				.getStopBits().toString()));
		params.setParity(Integer.parseInt(agendador.getConfiguracaoPorta()
				.getParity().toString()));
		ModbusMaster master = factory.createRtuMaster(params);
		// master.setRetries(4);
		master.setTimeout(300);
		master.setRetries(2);
		long start = System.currentTimeMillis();
		Float valor = 0F;
		// Don't start if the RTU master can't be initialized.
		try {
			master.init();
		} catch (ModbusInitException e) {
			System.out.println("Modbus Master Init Error: " + e.getMessage());
			return;
		}

		try {
			valor = (Float) master.getValue(Integer.parseInt(dispositivo
					.getEnderecoEscravo().toString()),
					RegisterRange.HOLDING_REGISTER, Integer
							.parseInt(dispositivo.getTipoDispositivo()
									.getRegistradorContador()),
					DataType.FOUR_BYTE_FLOAT);

			/*
			 * System.out.println("Reg. 4 Value:" + master.getValue(3,
			 * RegisterRange.HOLDING_REGISTER, 4, DataType.FOUR_BYTE_FLOAT));
			 */
			// more like the above until all required register values are read.
			// ..
		} catch (ModbusTransportException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ErrorResponseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			master.destroy();
		}
		setValorContador(valor.toString());
		System.out.println("Time elapsed: "
				+ (System.currentTimeMillis() - start) + "ms");
		Integer vl = valor.intValue();
		Long vfinal = Long.parseLong(vl.toString());
		// if (vfinal > 0L)
		// gravarLeituraAgendador(dispositivo, vfinal); //
	}

	public String getValorContador() {
		return valorContador;
	}

	public void setValorContador(String valorContador) {
		this.valorContador = valorContador;
	}

}