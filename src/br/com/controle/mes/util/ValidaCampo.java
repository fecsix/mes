package br.com.controle.mes.util;

import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class ValidaCampo {

	public boolean soTemNumerosInteiros(String s) {
		return (Pattern.matches("[E0123456789-]+", s));
	}

	public boolean soTemNumerosInteirosOuDecimais(String s) {
		return (Pattern.matches("[E0123456789.,-]+", s));
	}

	public boolean isHoraValida(String h) {
		if (soTemNumerosInteiros(h)) {
			long hora = new Long(h);
			if (hora >= 0 && hora <= 23) {
				return true;
			}
		}
		return false;
	}

	public boolean isHoraValida(String h, String s) {
		int i = 1;

		if (h.trim().length() == 0)
			return false;

		StringTokenizer stk = new StringTokenizer(h.trim(), s);

		while (stk.hasMoreTokens()) {
			if (i == 1) {
				if (!isHoraValida(stk.nextToken())) {
					return false;
				}
			} else {
				if (!isMinutoValido(stk.nextToken())) {
					return false;
				}
			}
			++i;
		}
		return true;
	}

	public boolean isMinutoValido(String m) {
		if (soTemNumerosInteiros(m)) {
			long min = new Long(m);
			if (min >= 0 && min <= 59) {
				return true;
			}
		}
		return false;
	}

	public boolean isBooleanValido(String b) {
		if (b != null) {
			if (isBooleanTrue(b) || isBooleanFalse(b)) {
				return true;
			}
		}
		return false;
	}

	public boolean isBooleanTrue(String b) {
		if (b != null) {
			if (b.equals("1") || b.toLowerCase().equals("true")
					|| b.toLowerCase().equals("sim")) {
				return true;
			}
		}
		return false;
	}

	public boolean isBooleanFalse(String b) {
		if (b != null) {
			if (b.equals("0") || b.toLowerCase().equals("false")
					|| b.toLowerCase().equals("nao")
					|| b.toLowerCase().equals("não")) {
				return true;
			}
		}
		return false;
	}

	public boolean isDataValida(String d) {
		if (d != null) {
			StringTokenizer stk = new StringTokenizer(d.trim(), "/");
			if (stk.countTokens() != 3) {
				return false;
			}
			String sDia = stk.nextToken();
			if (!soTemNumerosInteiros(sDia)) {
				return false;
			}
			String sMes = stk.nextToken();
			if (!soTemNumerosInteiros(sMes)) {
				return false;
			}
			String sAno = stk.nextToken();
			if (!soTemNumerosInteiros(sAno)) {
				return false;
			}
			int ano = Integer.parseInt(sAno);
			if (sAno.length() != 4) {
				if (sAno.length() != 2) {
					return false;
				} else {
					ano = 2000 + ano;
				}
			}
			int mes = Integer.parseInt(sMes);
			if (mes < 1 || mes > 12) {
				return false;
			}
			int dia = Integer.parseInt(sDia);
			if (dia < 1 || dia > 31) {
				return false;
			}
			if (dia > 30) {
				if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
					return false;
				}
			}
			if (mes == 2) {
				if (ano % 400 == 0 || (ano % 100 != 0 && ano % 4 == 0)) {
					if (dia > 29) {
						return false;
					}
				} else {
					if (dia > 28) {
						return false;
					}
				}
			}
			return true;
		}
		return false;
	}

	public boolean isTipoValido(String tipo, String expressao) {
		if (tipo.equals("long") || tipo.equals("Long") || tipo.equals("byte")
				|| tipo.equals("Byte") || tipo.equals("short")
				|| tipo.equals("Short") || tipo.equals("int")
				|| tipo.equals("Integer")) {
			if (soTemNumerosInteiros(expressao)) {
				return true;
			}
		} else if (tipo.equals("float") || tipo.equals("Float")
				|| tipo.equals("double") || tipo.equals("Double")) {
			if (soTemNumerosInteirosOuDecimais(expressao)) {
				return true;
			}
		} else if (tipo.equals("boolean") || tipo.equals("Boolean")) {
			if (isBooleanValido(expressao)) {
				return true;
			}
		} else if (tipo.equals("char") || tipo.equals("Char")
				|| tipo.equals("String")) {
			return true;
		} else if (tipo.equals("Date") || tipo.equals("Calendar")
				|| tipo.equals("GregorianCalendar")) {
			if (isDataValida(expressao)) {
				return true;
			}
		}
		return false;
	}

	@SuppressWarnings("rawtypes")
	public boolean isEnumValido(Class classe, String expressao) {
		if (classe != null && classe.isEnum()) {
			for (Object objeto : classe.getEnumConstants()) {
				if (expressao.equals(objeto.toString())) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean isCpfValido(String cpf) {

		cpf = cpf.replace(".", "");
		cpf = cpf.replace("-", "");

		if (cpf.length() != 11)
			return false;

		return calcDigVerif(cpf.substring(0, 9)).equals(cpf.substring(9, 11));
	}

	private String calcDigVerif(String num) {
		Integer primDig, segDig;
		int soma = 0, peso = 10;
		for (int i = 0; i < num.length(); i++)
			soma += Integer.parseInt(num.substring(i, i + 1)) * peso--;

		if (soma % 11 == 0 | soma % 11 == 1)
			primDig = new Integer(0);
		else
			primDig = new Integer(11 - (soma % 11));

		soma = 0;
		peso = 11;
		for (int i = 0; i < num.length(); i++)
			soma += Integer.parseInt(num.substring(i, i + 1)) * peso--;

		soma += primDig.intValue() * 2;
		if (soma % 11 == 0 | soma % 11 == 1)
			segDig = new Integer(0);
		else
			segDig = new Integer(11 - (soma % 11));

		return primDig.toString() + segDig.toString();
	}

	public boolean isCnpjValido(String cnpj) {
		cnpj = cnpj.replace(".", "");
		cnpj = cnpj.replace("/", "");
		cnpj = cnpj.replace("-", "");

		if (cnpj.length() != 14)
			return false;

		int soma = 0, dig;
		String cnpj_calc = cnpj.substring(0, 12);
		char[] chr_cnpj = cnpj.toCharArray();

		// --------- Primeira parte
		for (int i = 0; i < 4; i++)
			if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9)
				soma += (chr_cnpj[i] - 48) * (6 - (i + 1));
		for (int i = 0; i < 8; i++)
			if (chr_cnpj[i + 4] - 48 >= 0 && chr_cnpj[i + 4] - 48 <= 9)
				soma += (chr_cnpj[i + 4] - 48) * (10 - (i + 1));
		dig = 11 - (soma % 11);
		cnpj_calc += (dig == 10 || dig == 11) ? "0" : Integer.toString(dig);

		// --------- Segunda parte
		soma = 0;
		for (int i = 0; i < 5; i++)
			if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9)
				soma += (chr_cnpj[i] - 48) * (7 - (i + 1));
		for (int i = 0; i < 8; i++)
			if (chr_cnpj[i + 5] - 48 >= 0 && chr_cnpj[i + 5] - 48 <= 9)
				soma += (chr_cnpj[i + 5] - 48) * (10 - (i + 1));
		dig = 11 - (soma % 11);
		cnpj_calc += (dig == 10 || dig == 11) ? "0" : Integer.toString(dig);

		return cnpj.equals(cnpj_calc);
	}

}
