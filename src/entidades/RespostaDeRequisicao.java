package entidades;

import java.io.IOException;
import java.io.Serializable;
import java.io.StringBufferInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import aifone.hitwitter.rn.Tweet;

@SuppressWarnings("serial")
public class RespostaDeRequisicao implements Serializable {
	String mensagemDeErro = "";
	int codigoDeStatus = 300;
	String conteudo = "";

	public RespostaDeRequisicao() {
		super();
	}
	
	public RespostaDeRequisicao(String mensagemDeErro, int codigoDeStatus, String conteudo) {
		super();
		this.mensagemDeErro = mensagemDeErro;
		this.codigoDeStatus = codigoDeStatus;
		this.conteudo = conteudo;
	}

	@SuppressWarnings("deprecation")
	public List<Tweet> toTweets(){
		List<Tweet> tweets = new ArrayList<Tweet>();

		try {
			System.out.println(conteudo);
			Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new StringBufferInputStream(conteudo));
			NodeList nodes = doc.getElementsByTagName("status");
			
			for(int i=0; i<nodes.getLength(); i++){
				String autor = "Desconhecido";
				String conteudo = "Em branco";
				Node status = nodes.item(i);
				NodeList nl = status.getChildNodes();
				for (int k=0; k<nl.getLength(); k++) {
					Node n = nl.item(k);
					if ((n.getNodeType() == Node.ELEMENT_NODE) && (((Element)n).getTagName().equals("text"))) {
						conteudo = n.getTextContent();
					}else if((n.getNodeType() == Node.ELEMENT_NODE) && (((Element)n).getTagName().equals("user"))){
						NodeList user_info = n.getChildNodes();
						for(int j=0; j < user_info.getLength(); j++){
							Node info = user_info.item(j);
							if ((info.getNodeType() == Node.ELEMENT_NODE) && (((Element)info).getTagName().equals("name"))){
								autor = info.getTextContent();
							}
						}
					}
				}
				tweets.add(new Tweet(autor, conteudo));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tweets;
	}
	
	public String getMensagemDeErro() {
		return mensagemDeErro;
	}

	public void setMensagemDeErro(String mensagemDeErro) {
		this.mensagemDeErro = mensagemDeErro;
	}

	public int getCodigoDeStatus() {
		return codigoDeStatus;
	}

	public void setCodigoDeStatus(int codigoDeStatus) {
		this.codigoDeStatus = codigoDeStatus;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
}