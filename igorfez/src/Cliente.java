import java.util.Objects;

public class Cliente{
	
	private String senha;
	public String nomedocorrentista;
	int MAX = 50, NCP = 0, NCS = 0, NCE = 0, i = 0;
	Contapolpança[] CP = new Contapolpança[MAX];
	Contasimples[] CS = new Contasimples[MAX];
	Contaespecial[] CE = new Contaespecial[MAX];
	
	
/// GETTERS

	public String getnome()
	{
		return nomedocorrentista;
	}
	
	public int getNCP()
	{
		return NCP;
	}
	
	public int getNCS() {
		return NCS;
	}
	
	public int getNCE() 
	{
		return NCE;
	}
	

/// CRIAÇÃO DE CONTAS CLIENTE
	
	public void criacp(String novonome, int numero, String novasenha, double taxa)
	{
		CP[NCP] = new Contapolpança(novonome,numero,novasenha,taxa);
		NCP = NCP + 1;
	}
	
	public void criacs(String nome, int numero, String novasenha)
	{
		CS[NCS] = new Contasimples(nome,numero,novasenha);
		NCS = NCS + 1;
	}
	
	public void criace(String nome, int numero, String novasenha, float limiteconta)
	{
		CE[NCE] = new Contaespecial(nome,numero,novasenha,limiteconta);
		NCE = NCE + 1;
	}
	
/// GERENCIAMENTEO DE SENHA
	
	public void alterarSenha(String senhaAntiga,String senhaNova)
	{
		if(Objects.equals(senha,senhaAntiga)) {senha = senhaNova; System.out.print("\nSenha alterada com sucesso"); }
		else System.out.print("\nSenha incorreta, tente novamente.");
	}
	
	public int verificarSenha(String senhaInserida)
	{
		if (Objects.equals(senha, senhaInserida)) return 1;
		else {System.out.println("Senha incorreta, tente novamente"); return 0;}
	}
	
	
/// CONSTRUTOR
	
	public Cliente (String nome, String novasenha)
	{
		senha = novasenha;
		nomedocorrentista = nome;
	}


}
