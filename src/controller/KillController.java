
package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KillController 
{
	public KillController()
	{
		super();
	}
	
	public String Os()
	{
		String os = System.getProperty("os.name");
		return os;
	}
	
	public void listaProcessos(String os)
	{
		String processo;
		if (os.contains("Linux"))
		{
			processo = "ps -ef";
		}
		else
		{
			processo = "TASKLIST /FO TABLE";
		}
		try {
			Process p =	Runtime.getRuntime().exec(processo);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while (linha != null)
			{
				System.out.println(linha);
				linha = buffer.readLine();
			}
		} catch (IOException e) {

			String MsgErro = e.getMessage();
			if(MsgErro.contains("740"))
			{
				StringBuffer buffer = new StringBuffer();
				buffer.append("cmd /c ");
				buffer.append(processo);
			}
		}
	}
}
