
//import javax.swing.Box;
import javax.swing.JComboBox;
//import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


@SuppressWarnings({"rawtypes" , "unchecked"})
public class gui{

public static JComboBox listaOpcoes;
public static JComboBox listaGerente;
public static JComboBox listaExtrato;
public static JComboBox listaCliente;
public static JComboBox listaAplica;
public static JComboBox listaRetira;
public static JComboBox listaGC;
public static JComboBox listaCadastroUsuario;
public static JComboBox listaContaCliente;
public static JComboBox listaAlteracao;
public static JTextField usuario;
/*public static JPasswordField senha;
public static JTextField nome;
*/
public static JPasswordField senha2;
//public static JPasswordField senhaCS;
//public static JPasswordField senhaCP;
//public static JPasswordField senhaCE;
public static JTextField taxa;
public static JTextField limite;
public static JTextField numeroDaContaCS;
public static JTextField numeroDaContaCP;
public static JTextField numeroDaContaCE;
//public static JTextField nomeCS;
//public static JTextField nomeCP;
//public static JTextField nomeCE;

/*public static JPanel panel;
public static JLabel label;
public static JLabel label2;
public static JTextField txt;
public static JPasswordField pass;
*/
public static char[] password;
public static String username;

public static char[] senha;
public static String nome;

public static char[] senhaCS;
public static String nomeCS;

public static char[] senhaCP;
public static String nomeCP;

public static char[] senhaCE;
public static String nomeCE;

public static void escolhaGC() {
	 Object[] optionsGC = {"<Selecione a Opção Desejada>", "Gerente","Cliente"}																						;
	     listaGC = new JComboBox(optionsGC);
	     JOptionPane.showMessageDialog(null, listaGC, "Escolha",
	          JOptionPane.INFORMATION_MESSAGE);
}

public static void login() {
/*
	usuario = new JTextField(10);
    senha = new JPasswordField(10);
    JPanel myPanelLogin = new JPanel();
    myPanelLogin.add(new JLabel("Login:"));
    myPanelLogin.add(usuario);
    myPanelLogin.add(Box.createHorizontalStrut(15));
    myPanelLogin.add(new JLabel("Senha:"));
    myPanelLogin.add(senha);
		*/	
    JPanel panel = new JPanel();
	JLabel label = new JLabel("Login:");
	JLabel label2= new JLabel("Senha:");
	JTextField txt = new JTextField(10);
	JPasswordField pass = new JPasswordField(10);
	panel.add(label);
	panel.add(txt);
	panel.add(label2);
	panel.add(pass);
	
	String[] options = new String[]{"OK", "Cancel"};
	int option = JOptionPane.showOptionDialog(null, panel, "Login",
	                         JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE,
	                         null, options, options[1]);
	
	if(option == 0) // pressing OK button
	{
	    password = pass.getPassword();
	    username = txt.getText();
	}
}

public static void getNomeSenha() {
/*
	nome = new JTextField(10);
    senha2 = new JPasswordField(10);
    JPanel myPanelNS = new JPanel();
    myPanelNS.add(new JLabel("Nome:"));
    myPanelNS.add(nome);
    myPanelNS.add(Box.createHorizontalStrut(15));
    myPanelNS.add(new JLabel("Senha:"));
    myPanelNS.add(senha2);
		
	}
*/
	
	   	JPanel panel1 = new JPanel();
		JLabel label1 = new JLabel("Nome:");
		JLabel label3= new JLabel("Senha:");
		JTextField txt2 = new JTextField(10);
		JPasswordField pass2 = new JPasswordField(10);
		panel1.add(label1);
		panel1.add(txt2);
		panel1.add(label3);
		panel1.add(pass2);
		
		String[] options = new String[]{"OK", "Cancel"};
		int option = JOptionPane.showOptionDialog(null, panel1, "Dados",
		                         JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE,
		                         null, options, options[1]);
		
		if(option == 0) // pressing OK button
		{
		    senha = pass2.getPassword();
		    nome = txt2.getText();
		}

}
public static void clienteContaSimples() {

	/*nomeCS = new JTextField(10);
    senhaCS = new JPasswordField(10);
    numeroDaContaCS = new JTextField(10);
    JPanel myPanelCCS = new JPanel();
    myPanelCCS.add(new JLabel("Nome:"));
    myPanelCCS.add(nomeCS);
    myPanelCCS.add(Box.createHorizontalStrut(15));
    myPanelCCS.add(new JLabel("Senha:"));
    myPanelCCS.add(senhaCS);
    myPanelCCS.add(Box.createHorizontalStrut(15));
*/
	
   	JPanel panel2 = new JPanel();
	JLabel label2 = new JLabel("Nome:");
	JLabel label4= new JLabel("Senha:");
	JTextField txt3 = new JTextField(10);
	JPasswordField pass3 = new JPasswordField(10);
	panel2.add(label2);
	panel2.add(txt3);
	panel2.add(label4);
	panel2.add(pass3);
	
	String[] options = new String[]{"OK", "Cancel"};
	int option = JOptionPane.showOptionDialog(null, panel2, "Dados",
	                         JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE,
	                         null, options, options[1]);
	
	if(option == 0) // pressing OK button
	{
	    senhaCS = pass3.getPassword();
	    nomeCS = txt3.getText();
	
		
	}
}

public static void clienteContaPoupanca() {
/*	nomeCP = new JTextField(10);
    senhaCP = new JPasswordField(10);
    numeroDaContaCP = new JTextField(10);
    taxa = new JTextField(10);
    JPanel myPanelCCP = new JPanel();
    myPanelCCP.add(new JLabel("Nome:"));
    myPanelCCP.add(nomeCP);
    myPanelCCP.add(Box.createHorizontalStrut(15));
    myPanelCCP.add(new JLabel("Senha:"));
    myPanelCCP.add(senhaCP);
    myPanelCCP.add(Box.createHorizontalStrut(15));
    myPanelCCP.add(new JLabel("Taxa"));
    myPanelCCP.add(taxa);
    */
	
   	JPanel panel3 = new JPanel();
	JLabel label3 = new JLabel("Nome:");
	JLabel label5= new JLabel("Senha:");
	JTextField txt4 = new JTextField(10);
	JPasswordField pass4 = new JPasswordField(10);
	panel3.add(label3);
	panel3.add(txt4);
	panel3.add(label5);
	panel3.add(pass4);
	
	String[] options = new String[]{"OK", "Cancel"};
	int option = JOptionPane.showOptionDialog(null, panel3, "Dados",
	                         JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE,
	                         null, options, options[1]);
	
	if(option == 0) // pressing OK button
	{
	    senhaCP = pass4.getPassword();
	    nomeCP = txt4.getText();
	
		
	}
	
	
}

public static void clienteContaEspecial() {
	
/*	nomeCE= new JTextField(10);
    senhaCE = new JPasswordField(10);
    numeroDaContaCP = new JTextField(10);
    limite = new JTextField(10);
    JPanel myPanelCCE = new JPanel();
    myPanelCCE.add(new JLabel("Nome:"));
    myPanelCCE.add(nomeCE);
    myPanelCCE.add(Box.createHorizontalStrut(15));
    myPanelCCE.add(new JLabel("Senha:"));
    myPanelCCE.add(senhaCP);
    myPanelCCE.add(Box.createHorizontalStrut(15));
    myPanelCCE.add(new JLabel("Limite"));
    myPanelCCE.add(limite);
    */
	
   	JPanel panel4 = new JPanel();
	JLabel label4 = new JLabel("Nome:");
	JLabel label6= new JLabel("Senha:");
	JTextField txt5 = new JTextField(10);
	JPasswordField pass5 = new JPasswordField(10);
	panel4.add(label4);
	panel4.add(txt5);
	panel4.add(label6);
	panel4.add(pass5);
	
	String[] options = new String[]{"OK", "Cancel"};
	int option = JOptionPane.showOptionDialog(null, panel4, "Dados",
	                         JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE,
	                         null, options, options[1]);
	
	if(option == 0) // pressing OK button
	{
	    senhaCE = pass5.getPassword();
	    nomeCE = txt5.getText();
	
		
	}
}
//GERENTE
public static void opcoes() {
	 Object[] options = {"<Selecione a Opção Desejada>", "Conta Simples","Conta Especial","Conta Polpança"}																						;
	     listaOpcoes = new JComboBox(options);
	     JOptionPane.showMessageDialog(null, listaOpcoes, "Menu de Contas",
	          JOptionPane.INFORMATION_MESSAGE);
	 
}


//MainProg
public static void criaContaCliente() {
	 Object[] optionsContaCliente = {"<Selecione a Opção Desejada>", "Conta Simples","Conta Especial","Conta Polpança"}																						;
	     listaContaCliente = new JComboBox(optionsContaCliente);
	     JOptionPane.showMessageDialog(null, listaContaCliente, "Menu de Contas",
	          JOptionPane.INFORMATION_MESSAGE);
	 
}


public static void alteracaoGerente() {
	 Object[] optionsAlteracaoGerente = {"<Selecione a Opção Desejada>", "Conta Simples","Conta Especial","Conta Polpança"}																						;
	     listaAlteracao= new JComboBox(optionsAlteracaoGerente);
	     JOptionPane.showMessageDialog(null, listaAlteracao, "Menu de Contas",
	          JOptionPane.INFORMATION_MESSAGE);
	 
}

public static void escolhaCliente() {
	 Object[] optionsCliente = {"<Selecione a Opção Desejada>", "Abrir Conta","Aplicar","Retirar","Verificar Saldo","Verificar Extrato",
	     		"Retirada","Alterar Senha"}																						;
	     listaCliente = new JComboBox(optionsCliente);
	     JOptionPane.showMessageDialog(null, listaCliente, "Menu Cliente",
	          JOptionPane.INFORMATION_MESSAGE);

	 
}


public static void escolhaGerente() {
	 Object[] optionsGerente = {"<Selecione a Opção Desejada>", "Cadastrar Usuario","Alterar Senha","Verificar Nome","Aplicação","Transferencia",
     		"Retirada","Editar Limite","Verificar informações de cada conta","Voltar" };
     listaGerente = new JComboBox(optionsGerente);
     JOptionPane.showMessageDialog(null, listaGerente, "Menu Gerente",
          JOptionPane.INFORMATION_MESSAGE);
     
}

public static void cadastroNovoUsuario() {
	 Object[] optionsCadastro = {"<Selecione a Opção Desejada>", "Gerente","Cliente"}																						;
	     listaCadastroUsuario= new JComboBox(optionsCadastro);
	     JOptionPane.showMessageDialog(null, listaCadastroUsuario, "Cadastro de Usuário",
	          JOptionPane.INFORMATION_MESSAGE);
	 
}

public static void verificaExtrato() {
	 Object[] optionsVerificaExtrato = {"<Selecione a Opção Desejada>", "Conta Simples","Conta Especial","Conta Poupança","Voltar" };
	     listaExtrato = new JComboBox(optionsVerificaExtrato);
	     JOptionPane.showMessageDialog(null, listaExtrato, "Menu de Contas",
	          JOptionPane.INFORMATION_MESSAGE);

}

public static void aplicaCliente() {
	 Object[] optionsAplica = {"<Selecione a Opção Desejada>", "Conta Simples","Conta Especial","Conta Poupança","Voltar" };
	     listaAplica = new JComboBox(optionsAplica);
	     JOptionPane.showMessageDialog(null, listaAplica, "Menu de Contas",
	          JOptionPane.INFORMATION_MESSAGE);

}

}

		




