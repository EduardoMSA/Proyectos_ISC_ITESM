/*
 * Eduardo Méndez A01632947
 * EvaliacionExpresiones
 * 28/02/2018
 */


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import javax.swing.JOptionPane;

public class EvaliacionExpresiones {

	public static double evalua(String expresion) {
		String expresionEspaciada = prepararString(expresion);
		String[] expresionInfija = expresionEspaciada.split(" ");
		return evaluaPostfijo(InfijoAPostfijo(expresionInfija));
	}

	private static String[] InfijoAPostfijo(String[] expresionInfija) {
		Stack<String> infijo = new Stack<>();
		Stack<String> operadores = new Stack<>();
		Queue<String> postfijo = new LinkedList<>();

		for (int i = expresionInfija.length - 1; i >= 0; i--) {
			infijo.push(expresionInfija[i]);
		}

		while (!infijo.isEmpty()) {
			switch (preferencia(infijo.peek())) {
			case 1:
				operadores.push(infijo.pop());
				break;
			case 2:
				while (!operadores.peek().equals("(")) {
					postfijo.add(operadores.pop());
				}
				infijo.pop(); // Eliminiar el )
				operadores.pop(); // Eliminar el (
				break;
			case 3:
			case 4:
				while (preferencia(operadores.peek()) >= preferencia(infijo.peek())) {
					postfijo.add(operadores.pop());
				}
				operadores.push(infijo.pop());
				break;
			default:
				postfijo.add(infijo.pop());
			}
		}

		String[] tmp = new String[postfijo.size()];
		return postfijo.toArray(tmp);

	}

	private static double evaluaPostfijo(String[] entrada) {
		try {
			String operadores = "+-*/%^";
			Stack<String> expresion = new Stack<String>();
			Stack<String> operandos = new Stack<String>();
			for (int i = entrada.length - 1; i >= 0; i--) {
				expresion.push(entrada[i]);
			}
			while (!expresion.isEmpty()) {
				if (operadores.contains(expresion.peek())) {
					operandos.push(resolver(operandos.pop(), operandos.pop(), expresion.pop()));
				} else {
					operandos.push(expresion.pop());
				}
			}

			return Double.parseDouble(operandos.peek());
		} catch (Exception ex) {
			throw new NumberFormatException("Ingresaste una expresión Invalida");
		}
	}

	private static String resolver(String op2, String op1, String operacion) {
		double resultado = 0, operando1 = Double.parseDouble(op1), operando2 = Double.parseDouble(op2);
		switch (operacion) {
		case "+":
			resultado = operando1 + operando2;
			break;
		case "-":
			resultado = operando1 - operando2;
			break;
		case "*":
			resultado = operando1 * operando2;
			break;
		case "/":
			resultado = (double) operando1 / (double) operando2;
			break;
		case "%":
			resultado = operando1 % operando2;
			break;
		case "^":
			resultado = Math.pow(operando1, operando2);
			break;
		}
		return resultado + "";
	}

	private static int preferencia(String simbolo) {
		int pref;
		switch (simbolo) {
		case "*":
		case "/":
		case "%":
			pref = 4;
			break;
		case "+":
		case "-":
			pref = 3;
			break;
		case ")":
			pref = 2;
			break;
		case "(":
		case "^":
			pref = 1;
			break;
		default:
			pref = 0;
		}
		return pref;
	}

	public static String prepararString(String expresion) {
		String[] tmp = expresion.trim().split(" ");
		String sinEspacios = "(", operadores = "+-*/%^()", espaciado = "";
		for (String i : tmp) {
			sinEspacios += i;
		}
		sinEspacios += ")";
		for (int i = 0; i < sinEspacios.length(); i++) {
			if (operadores.contains(sinEspacios.charAt(i) + "")) {
				espaciado += " " + sinEspacios.charAt(i) + " ";
			} else {
				espaciado += sinEspacios.charAt(i);
			}
		}
		espaciado = espaciado.trim().replace("  ", " ");
		return espaciado;
	}

	public static void main(String[] args) {
		String memo = JOptionPane.showInputDialog("Escribe una equación");
		Double resultado = evalua(memo);
		JOptionPane.showMessageDialog(null, resultado);
	}
}


