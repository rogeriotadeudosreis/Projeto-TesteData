/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.teste.data;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

/**
 *
 * @author roger
 */
public class ProjetoTesteData {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Random rd = new Random();
        int desc;
        for (int i = 0; i < 1; i++) {
            desc = rd.nextInt(60) + 1;
            System.out.println(desc);
        }

        System.out.println(LocalDate.now());
        System.out.println(LocalDate.MAX);
        System.out.println(LocalDate.MIN);
        
//        System.out.println("Testando a classe BigDecimal com seus métodos");
//        System.out.println("Compara");
//        System.out.println(new BigDecimal("2.00").compareTo(BigDecimal.ZERO));
//        if (new BigDecimal("2.00").compareTo(BigDecimal.ZERO) == 1) {
//            System.out.println("Valor maior que zero!");
//        }
//        System.out.println("Compara");
//        System.out.println(new BigDecimal("2.00").compareTo(new BigDecimal("2.0")));
//        if (new BigDecimal("2.00").compareTo(new BigDecimal("2.0")) == 0) {
//            System.out.println("Valor igual a zero!");
//        }
//        System.out.println("Compara");
//        System.out.println(new BigDecimal("2.00").compareTo(new BigDecimal("2.1")));
//        if (new BigDecimal("2.00").compareTo(new BigDecimal("2.1")) == -1) {
//            System.out.println("Valor menor que zero!");
//        }
//        System.out.println("---------------------------------------------");
//        System.out.println("Testando a classe BigDecimal com seus métodos");
//        System.out.println("Máximo");
//        System.out.println(new BigDecimal("15.00").max(new BigDecimal("1.5")));
//        System.out.println("---------------------------------------------");
//        System.out.println("Testando a classe BigDecimal com seus métodos");
//        System.out.println("Mínimo");
//        System.out.println(new BigDecimal("2.00").min(new BigDecimal("1.6")));
//        System.out.println("---------------------------------------------");
//
//        ProjetoTesteData projeto = new ProjetoTesteData();
//        String cpf = "09888086848";
//
//        System.out.println(projeto.validaCPF(cpf));
//
//        System.out.println(new Date().getTime());
//
//        Calendar c = Calendar.getInstance();
//
//        System.out.println("Data/Hora atual: " + c.getTime());
//        if (2020 > c.get(Calendar.YEAR)) {
//            System.out.println("Ano inválido");
//        } else {
//            System.out.println("Ano válido, ok");
//
//        }
//        System.out.println("Ano: " + c.get(Calendar.YEAR));
//        System.out.println("Mês: " + c.get(Calendar.MONTH));
//        System.out.println("Dia do Mês: " + c.get(Calendar.DAY_OF_MONTH));
//
//        System.out.println("Data e hora atual > " + c.getTime());
//        System.out.println(convertDate(new Date()));
//        System.out.println(createNewDate("28/10/2020"));
//
//        if (createNewDate("30/10/2020").after(new Date())) {
//            System.out.println("Data inválida!");
//        }

    }

    public static String convertDate(Date dtConsulta) {
        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy", new Locale("pt", "BR"));
            return formato.format(dtConsulta);
        } catch (Exception erro) {
            erro.printStackTrace();
            return null;
        }
    }

    private static Date createNewDate(String data) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return formato.parse(data);
        } catch (Exception erro) {
            erro.printStackTrace();
            return null;
        }
    }

    public boolean validaCPF(String CPF) {
        // considera-se erro CPF's formados por uma sequencia de numeros iguais
        if (CPF.equals("00000000000")
                || CPF.equals("11111111111")
                || CPF.equals("22222222222") || CPF.equals("33333333333")
                || CPF.equals("44444444444") || CPF.equals("55555555555")
                || CPF.equals("66666666666") || CPF.equals("77777777777")
                || CPF.equals("88888888888") || CPF.equals("99999999999")
                || (CPF.length() != 11)) {
            return (false);
        }

        char dig10, dig11;
        int sm, i, r, num, peso;

        try {

            // Calculando o primeiro digito
            sm = 0;
            peso = 10;

            for (i = 0; i < 9; i++) {
                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;

            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig10 = '0';
            } else {
                dig10 = (char) (r + 48);
            }

            //Calculando o segundo digito
            sm = 0;
            peso = 11;

            for (i = 0; i < 10; i++) {
                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;

            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig11 = '0';
            } else {
                dig11 = (char) (r + 48);
            }

            //Verificando se os dígitos calculados são iguais os fornecidos pelo usuário
            if ((dig10 == CPF.charAt(9)) && dig11 == CPF.charAt(10)) {
                return (true);
            } else {
                return (false);
            }
        } catch (Exception erro) {
            return (false);
        }

    }

}
