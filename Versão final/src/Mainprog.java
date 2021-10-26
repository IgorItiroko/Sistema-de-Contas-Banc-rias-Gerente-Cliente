import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;
import java.util.Objects;
import java.util.Scanner;
import java.util.*;
import java.io.*;

//import javax.swing.JComboBox;
import javax.swing.JOptionPane;


public class Mainprog{
	
	/// Variáveis de coleta para comparação.
	public static String usuario;
	public static String senha;
	public static int escolhaUsuario;
	public static int usarioD;
	public static int senhaD;
	public static int escolhaContaCliente;
	public static int nEscolhaGC;
	public static int nEscolhaC;
	public static int nEscolhaG;
	public static int validaEntrada;
	public static int MAX = 500;
	
	/// Variável de interface.
	public static gui gui;
	
	///Variáveis de controle
	public static boolean key = false;
	public static boolean result;
	public static boolean continua = false;
	public static boolean continua1 = true;
	
	/// Variáveis de contagem
	public static int usuariosGerentes=1;
	public static int usuariosClientes=0;
	public static int i;
	public static int j;
	public static int NC=100;
	
	///Variáveis para a persistência de dados
	public static File arq;
	public static File dir;
	public static FileReader fileReader;
	public static BufferedReader bufferedReader;
	
	public static int NG = 1;
	public static Gerente[] Gerentes = new Gerente[MAX];
	
@SuppressWarnings({ "static-access", "unused", "resource", "deprecation" })
public static void main(String[] args)
	{
		
		int nEscolhaExt;
		int nCS;
		int nCP;
		int nCE;
		boolean valida = false;
		boolean validaC = false;
		Scanner input = new Scanner(System.in);
		Gerentes[0] = new Gerente("Admin","senha123");
		gui = new gui();
		dir = new File("C:\\ProjetoPPB");
		arq = new File(dir,"BancoDeDados.txt");
		///leitura();
		/// Menu
		do {
			gui.escolhaGC();
			nEscolhaGC=gui.listaGC.getSelectedIndex();
			switch(nEscolhaGC) {
			//Usuario escolheu Gerente
			 case 1:
				 	continua1 = true;
				 	continua = false;
				 	
				 do {
					 if(continua1 == false) {
						 break;
					 }
				 if(continua == false) {
					 /// Login do Gerente
						gui.login();
						char [] p = gui.password;
						String s = gui.username;
						for(i = 0;i < NG; i++) {
							if(Objects.equals(title(s),Gerentes[i].nome)) {
								validaEntrada=1;
								break;
							}
								
						}
						if(validaEntrada == 1) {
							result = Gerentes[i].verificarSenha(new String(p));
							if(result == true) {
								gui.escolhaGerente();
								nEscolhaG=gui.listaGerente.getSelectedIndex();
								}
							else break; 		
						}
						
				 }
				 if(continua == true) {
					 /// Opções que o gerente tem
					 	gui.escolhaGerente();
						nEscolhaG=gui.listaGerente.getSelectedIndex();				 
				 }
						switch(nEscolhaG){
						case 1:	/// Cadastrar novo usuário
							gui.cadastroNovoUsuario();
							escolhaUsuario=gui.listaCadastroUsuario.getSelectedIndex();
							continua=true;
							switch(escolhaUsuario) {
								case 1: /// Criar outro gerente 
									gui.getNomeSenha();
									char [] pEG = gui.senha;
									String uEG = gui.nome;
									Gerentes[NG] = new Gerente(title(uEG),(new String(pEG)));
									NG++;
									break;
								case 2:	/// Criar outro cliente
									gui.getNomeSenha();
									char [] pEC = gui.senha;
									String uEC = gui.nome;
									Gerentes[i].criacliente(title(uEC),(new String(pEC))); break;
								default:break;
								};break;
						case 2:	/// alterar senha
							continua=true;
							String senhaAntigaG=JOptionPane.showInputDialog("Digite senha Senha Antiga:");
							String senhaNovaG=JOptionPane.showInputDialog("Digite a nova Senha desejada:");
							Gerentes[i].alterarSenha(senhaAntigaG, senhaNovaG);
							break;
						case 3:	/// exibir lista de clientes
							continua=true;
							Gerentes[i].listaclientes();
							break;//verificarnome;
						case 4:	/// realizar uma aplicação
							continua=true;
							String quantia=JOptionPane.showInputDialog("Digite a quantia a aplicar");
							Gerentes[i].aplicação(Double.parseDouble(quantia));
							break;
						case 5:	/// realizar uma transferência
							continua=true;
							Gerentes[i].transferencia();
							break;
						case 6:	/// Retirar um valor acima de 110000 da conta de um cliente
							continua=true;
							gui.opcoes();
							int escG = gui.listaOpcoes.getSelectedIndex();
							Gerentes[i].retgerente(escG);
							break;//retirada
						case 7:	/// alterar limite de uma conta
							continua=true;
							Gerentes[i].limiteger();
							;break;//editarlimite
						case 8:
							continua=true;
							Gerentes[i].taxager();
							break;
						case 9:
							continua = true;
							Gerentes[i].verificainfo();
						default: continua1 = false; break;
					}
				 }while(continua = true);
				 break;
			 case 2:
				 //Usuario escolheu Cliente
				 	continua1 = true;
				 	continua = false;
				 	do {
				 		if(continua1 == false) {
				 			break;
				 		}
				 		
				 	if(continua == false) {
				 		gui.login();
						char [] pC = gui.password;
						String sC = gui.username;
						for(i = 0;i<NG;i++) {
							for(j=0;j <Gerentes[i].Nclientes ; j++ ) {
								if(Objects.equals(title(sC),Gerentes[i].GCliente[j].nomedocorrentista)) {
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
						
					}
				 	
				 	if(continua == true) {
						gui.escolhaCliente();
						nEscolhaC=gui.listaCliente.getSelectedIndex();	 		
				 	}
				 switch(nEscolhaC){
				 case 1:
					 continua=true;
					 gui.criaContaCliente();
					 escolhaContaCliente = gui.listaContaCliente.getSelectedIndex();
					 NC=NC+3;
					 switch(escolhaContaCliente) {
					 case 1:					 	
						 	Gerentes[i].GCliente[j].criacs(Gerentes[i].GCliente[j].getnome(),NC,Gerentes[i].GCliente[j].getSenha());
						 	JOptionPane.showMessageDialog(null,"Conta Criada com Sucesso" + "\nNúmero da conta: " + NC,"",JOptionPane.INFORMATION_MESSAGE);
						 	break;
					 case 2:
						 Gerentes[i].GCliente[j].criace(Gerentes[i].GCliente[j].getnome(),NC,Gerentes[i].GCliente[j].getSenha(),3000);
						 	JOptionPane.showMessageDialog(null,"Conta Criada com Sucesso" + "\nNúmero da conta: " + NC,"",JOptionPane.INFORMATION_MESSAGE); 	
						 break;
					 case 3:
						 Gerentes[i].GCliente[j].criacp(Gerentes[i].GCliente[j].getnome(),NC,Gerentes[i].GCliente[j].getSenha(),0.05);
						 	JOptionPane.showMessageDialog(null,"Conta Criada com Sucesso" + "\nNúmero da conta: " + NC,"",JOptionPane.INFORMATION_MESSAGE);
						 	
						 break;
					 }
					 break;
				 case 2:
					 continua=true;
					 	gui.aplicaCliente();
					 	int escolhaAplica = gui.listaAplica.getSelectedIndex();
					 	Gerentes[i].GCliente[j].cdeposito(escolhaAplica);			 	
					 break;
				 case 3:
					 continua=true;
					 gui.opcoes();
					 int escolhaOP = gui.listaOpcoes.getSelectedIndex();
					 Gerentes[i].GCliente[j].csaque(escolhaOP);
					 break;
				 case 4:
					 continua=true;
					 gui.opcoes();
					 int escolhaS = gui.listaOpcoes.getSelectedIndex();
					 Gerentes[i].GCliente[j].getSaldo(escolhaS);
					 break;
				 case 5:
					 continua=true;
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
					 			if(Gerentes[i].GCliente[j].CE[nCE].numerodaconta == ext2) {
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
					 	default:continua1 = false;break;					
					 }
					 break;
				 case 6:
					 	continua=true;
						String senhaAntigaC=JOptionPane.showInputDialog("Digite senha Senha Antiga:");
						String senhaNovaC=JOptionPane.showInputDialog("Digite a nova Senha desejada:");
						Gerentes[i].GCliente[j].alterarSenha(senhaAntigaC, senhaNovaC);
					 break;
				 default: continua1 = false; break;
				 }
				 }while(continua == true);
				 break;
				 	
			 default: key = true ; break;
			}	
			if(key == true) {
				break;
			}
			
		}while(key == false);
		///escrita(Gerentes,NG);
	
	}
private static double converter(String txt)
{
	return Double.parseDouble(txt);
}

private static int converter2(String txt)
{
	return Integer.parseInt(txt);
}

/// Escrita dos dados no txt
public static void escrita(Gerente Gwrite[], int NG)
{
	int i, j;

	try {
		arq.createNewFile();
		FileWriter fileWriter = new FileWriter(arq,false);
		PrintWriter printWriter = new PrintWriter(fileWriter);
		printWriter.println(NG);
		for(i = 1; i < NG; i++)
		{
			printWriter.println(Gwrite[i].getNome());
			printWriter.println(Gwrite[i].getSenha());
			/*printWriter.println(Gwrite[i].getNclientes());
			for(j = 0; j < Gwrite[i].Nclientes; j++)
			{
				printWriter.println(Gwrite[i].GCliente[j].getnome());
				printWriter.println(Gwrite[i].GCliente[j].getSenha());
			} */
		}
		printWriter.flush();
		printWriter.close();
	} catch(IOException e) {
		e.printStackTrace();
	}
	System.out.print("Dados salvos com sucesso");
}

/// Leitura de dados a partir do txt
public static void leitura()
{
	try {
		fileReader = new FileReader(arq);
	    bufferedReader = new BufferedReader(fileReader);
	    String line = "";
	    String line2 = "";
	    
	    if((line = bufferedReader.readLine())!= null)
	    {
	    	NG = converter2(line);
	    }
	    
	   for(int i = 1; i < NG; i++)
	    {
		   if((line = bufferedReader.readLine())!= null && (line2 = bufferedReader.readLine())!= null)
		    {
			   Gerentes[i] = new Gerente(line,line2);
		    }
		  /* if((line = bufferedReader.readLine())!= null)
		    {
			   Gerentes[i].setNclientes(converter2(line));
		    }
	    	
	    	for(int j = 0; j < Gerentes[i].Nclientes; j++)
	    	{
	    		if((line = bufferedReader.readLine())!= null && (line2 = bufferedReader.readLine())!= null)
			    {
		    		Gerentes[i].criacliente(line, line2);
			    }
	    	} */
/// Não conseguimos salvar os clientes, ao criar um cliente novo ele recria o vetor GCliente dentro dele, assim sempre
/// resetando os dados salvos. Isso causa um problema de NULLPOINTER.
	    }
	    
	}catch(IOException e) {
		e.printStackTrace();
	}
    
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
