
import java.util.Objects;
import java.util.Scanner;

//import javax.swing.JComboBox;
import javax.swing.JOptionPane;


public class Mainprog{
	
	public static String usuario;
	public static String senha;
	public static gui gui;
	public static boolean key = false;
	public static boolean result;
	public static int test;
	public static int usuariosGerentes=1;
	public static int usuariosClientes=0;
	public static int escolhaUsuario;
	public static int usarioD;
	public static int senhaD;
	public static int escolhaContaCliente;
	public static int i;
	public static int j;
	public static int NC=100;
	
@SuppressWarnings({ "static-access", "unused", "resource", "deprecation" })
public static void main(String[] args)
	{
		int nEscolhaGC;
		int nEscolhaG;
		int nEscolhaC =0;
		int nEscolhaExt;
		int nCS;
		int nCP;
		int nCE;
		boolean valida = false;
		boolean validaC = false;
		//int numeroGerente;
		int MAX = 500, NG = 1;
		Scanner input = new Scanner(System.in);
		Gerente[] Gerentes = new Gerente[MAX];
		Gerentes[0] = new Gerente("Admin","senha123");
		gui = new gui();
		
		do {
			gui.escolhaGC();
			nEscolhaGC=gui.listaGC.getSelectedIndex();
			switch(nEscolhaGC) {
			 case 1:
					gui.login();
					char [] p = gui.password;
					String s = gui.username;
					for(i = 0;i<NG;i++) {
						if(Objects.equals(s,Gerentes[i].nome))
							break;
					}
					result = Gerentes[i].verificarSenha(new String(p));
					if(result == true) {
						gui.escolhaGerente();
						nEscolhaG=gui.listaGerente.getSelectedIndex();
					}
					else break;
						switch(nEscolhaG){
						case 1:
							gui.cadastroNovoUsuario();
							escolhaUsuario=gui.listaCadastroUsuario.getSelectedIndex();
							switch(escolhaUsuario) {
								case 1:
									gui.getNomeSenha();
									char [] pEG = gui.senha;
									String uEG = gui.nome;
									Gerentes[NG] = new Gerente(uEG,(new String(pEG)));
									NG++;
									break;
								case 2:
									gui.getNomeSenha();
									char [] pEC = gui.senha;
									String uEC = gui.nome;
									Gerentes[i].criacliente(uEC,(new String(pEC))); break;
								default:break;
								};break;
						case 2:
							String senhaAntigaG=JOptionPane.showInputDialog("Digite senha Senha Antiga:");
							String senhaNovaG=JOptionPane.showInputDialog("Digite a nova Senha desejada:");
							Gerentes[i].alterarSenha(senhaAntigaG, senhaNovaG);
							break;
						case 3:
							Gerentes[i].listaclientes();
							break;//verificarnome;
						case 4:
							String quantia=JOptionPane.showInputDialog("Digite a quantia a aplicar");
							Gerentes[i].aplicação(Double.parseDouble(quantia));
							break;
						case 5:
							Gerentes[i].transferencia();
							break;
						case 6:
							gui.opcoes();
							int escG = gui.listaOpcoes.getSelectedIndex();
							Gerentes[i].retgerente(escG);
							break;//retirada
						case 7:
							Gerentes[i].limiteger();
							;break;//editarlimite
						case 8:
							Gerentes[i].verificainfo();
							break;
						default:break;
					}
				 ;break;
			 case 2:
					gui.login();
					char [] pC = gui.password;
					String sC = gui.username;
					for(i = 0;i<NG;i++) {
						for(j=0;j <Gerentes[i].Nclientes ; j++ ) {
							if(Objects.equals(sC,Gerentes[i].GCliente[j].nomedocorrentista)) {
								validaC = true;
								break;
							}								
						}
						if(validaC == true)
							break;
					}
					if(validaC == true) {
						result = Gerentes[i].GCliente[j].verificarSenha((new String(pC)));
						if(result == true) {
							gui.escolhaCliente();
							nEscolhaC=gui.listaCliente.getSelectedIndex();
						}		
					}
				 switch(nEscolhaC){
				 case 1:
					 gui.criaContaCliente();
					 escolhaContaCliente = gui.listaContaCliente.getSelectedIndex();
					 NC=NC+3;
					 switch(escolhaContaCliente) {
					 case 1:
						 	gui.clienteContaSimples();
						 	char [] pCS = gui.senhaCS;
							String uCS = gui.nomeCS;
						 	Gerentes[i].GCliente[j].criacs(uCS,NC,(new String(pCS)));
						 	break;
					 case 2:
						 gui.clienteContaPoupanca();
						 char [] pCP = gui.senhaCP;
							String uCP = gui.nomeCP;
						 	Gerentes[i].GCliente[j].criacp(uCP,NC,(new String(pCP)),0.05);
						 break;
					 case 3:
						 gui.clienteContaEspecial();
						 char [] pCE = gui.senhaCE;
							String uCE = gui.nomeCE;
						 	Gerentes[i].GCliente[j].criace(uCE,NC,(new String(pCE)),3000);
						 break;
					 }
					 break;
				 case 2:
					 	gui.aplicaCliente();
					 	int escolhaAplica = gui.listaAplica.getSelectedIndex();
					 	Gerentes[i].GCliente[j].cdeposito(escolhaAplica);			 	
					 break;
				 case 3:
					 gui.opcoes();
					 int escolhaOP = gui.listaOpcoes.getSelectedIndex();
					 Gerentes[i].GCliente[j].csaque(escolhaOP);
					 break;
				 case 4:
					 gui.opcoes();
					 int escolhaS = gui.listaOpcoes.getSelectedIndex();
					 Gerentes[i].GCliente[j].getSaldo(escolhaS);
					 break;
				 case 5:
					 gui.verificaExtrato();
					 nEscolhaExt= gui.listaExtrato.getSelectedIndex();
					 switch(nEscolhaExt) {
					 	case 1:
					 		valida = false;
					 		int ext = Integer.parseInt(JOptionPane.showInputDialog("Numero da conta"));
					 		for(nCS = 0; nCS<Gerentes[i].GCliente[j].NCS ; nCS++)
					 		{
					 			if(Gerentes[i].GCliente[j].CS[nCS].numerodaconta == ext) {
					 				valida = true;
					 				break;
					 			}
					 				
					 		}
					 		if(valida == true)
					 			Gerentes[i].GCliente[j].CS[nCS].extratocompleto();
					 		break;
					 	case 2:
					 		valida = false;
					 		int ext2 = Integer.parseInt(JOptionPane.showInputDialog("Numero da conta"));
					 		for(nCE = 0; nCE<Gerentes[i].GCliente[j].NCE ; nCE++)
					 		{
					 			if(Gerentes[i].GCliente[j].CS[nCE].numerodaconta == ext2) {
					 				valida = true;
					 				break;
					 			}
					 				
					 		}
					 		if(valida == true)
					 		Gerentes[i].GCliente[j].CE[nCE].extratocompleto();
					 		break;
					 	case 3:
					 		valida = false;
					 		int ext3 = Integer.parseInt(JOptionPane.showInputDialog("Numero da conta"));
					 		for(nCP = 0; nCP<Gerentes[i].GCliente[j].NCP ; nCP++)
					 		{
					 			if(Gerentes[i].GCliente[j].CP[nCP].numerodaconta == ext3) {
					 				valida = true;
					 				break;
					 			}
					 				
					 		}
					 		if(valida == true)
					 		Gerentes[i].GCliente[j].CP[nCP].extratocompleto();
					 		break;
					 	default:break;
						
					 }
					 break;
				 case 6:
						String senhaAntigaC=JOptionPane.showInputDialog("Digite senha Senha Antiga:");
						String senhaNovaC=JOptionPane.showInputDialog("Digite a nova Senha desejada:");
						Gerentes[i].GCliente[j].alterarSenha(senhaAntigaC, senhaNovaC);
					 break;
				 default:break;
				 }
				 break;
			 case 0: key = true ; break;
			}	
			if(key == true) {
				break;
			}
			
		}while(key == false);
		
	/*	
		*/
				
				
	/*	Gerentes[0].criacliente("Denis", "batatinha");
		Gerentes[0].GCliente[0].criacs("Denis",134,"senha");
		Gerentes[0].criacliente("Jefferson","senha");
		Gerentes[0].GCliente[1].criace("Jefferson", 166, "batatinha", 1500);
		Gerentes[0].transferencia();
		//Gerentes[0].listaclientes();								
		//Gerentes[0].GCliente[0].CS[0].extratocompleto();
		
	*/		
	}

	
	/*public static String title(String text) {
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
	}*/
	
}
