import java.util.Scanner;

public class Mainprog {
	public static void main(String args[])
	{
		int MAX = 500, NG = 1;
		Scanner input = new Scanner(System.in);
		Gerente[] Gerentes = new Gerente[MAX];
		Gerentes[0] = new Gerente("Admin","senha123");
		
		Gerentes[NG] = new Gerente("Adnilson","12345"); /// Formato de criação de novos gerentes
		NG = NG + 1;
		
		Gerentes[0].criacliente("Denis", "batatinha");
		Gerentes[0].GCliente[0].criacs("Denis",134,"senha");
		Gerentes[0].criacliente("Jefferson","senha");
		Gerentes[0].GCliente[1].criace("Jefferson", 166, "batatinha", 1500);
		Gerentes[0].listaclientes();
		
		Gerentes[0].transferencia();
				
				
		Gerentes[0].GCliente[0].CS[0].extratocompleto();
		
	
		
		


		
		
		
	}
	
	
	public static String title(String text) {
	    if (text == null || text.isEmpty()) {
	        return text;
	    }

	    StringBuilder converted = new StringBuilder();

	    boolean convertNext = true;
	    for (char ch : text.toCharArray()) {
	        if (Character.isSpaceChar(ch)) {
	            convertNext = true;
	        } else if (convertNext) {
	            ch = Character.toTitleCase(ch);
	            convertNext = false;
	        } else {
	            ch = Character.toLowerCase(ch);
	        }
	        converted.append(ch);
	    }

	    return converted.toString();
	}
}
