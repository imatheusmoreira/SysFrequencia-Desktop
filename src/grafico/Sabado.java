package grafico;

import java.util.Calendar;

class Sabado {
    public static void main(String[] args) {
         Calendar cal = Calendar.getInstance();
         // Em que dia D. Pedro declarou a Independência?
         int dia = 7;
         int mes = 9;
         int ano = 1822;
         cal.set (ano, mes - 1, dia); // note que você precisa subtrair 1 do mês !!!!
         // Note que para os dias da semana, 1 = domingo, 2 = segunda, ... 7 = sábado
         // O correto é usar: Calendar.SATURDAY em vez de bitolar que 7 = sábado.
         System.out.println (cal.get(Calendar.DAY_OF_WEEK));
    }
}