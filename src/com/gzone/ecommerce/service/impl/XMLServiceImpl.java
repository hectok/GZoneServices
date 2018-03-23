/**
 * 
 */
package com.gzone.ecommerce.service.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.gzone.ecommerce.dao.util.XMLRequestManager;
import com.gzone.ecommerce.exceptions.DataException;
import com.gzone.ecommerce.exceptions.InstanceNotFoundException;
import com.gzone.ecommerce.service.XMLService;

/**
 * @author Hector
 *
 */
public class XMLServiceImpl implements XMLService{

		public List<String> XMLRequest()  
				throws InstanceNotFoundException, DataException, IOException{

			StringBuffer result = new StringBuffer();
			StringBuffer xml = new StringBuffer();
			List<String> elementosXml = new ArrayList<String>();

			FileReader fitxer = new FileReader(XMLRequestManager.getRuta_archivo());
			int i = 0;
			while ((i = fitxer.read()) != -1)
				xml.append((char) i);
			String xmlEncoded = URLEncoder.encode(xml.toString());


			URL url = new URL(XMLRequestManager.getUrl());
			URLConnection connection = url.openConnection();
			connection.setDoOutput(true);

			PrintWriter out2 = new PrintWriter(connection.getOutputStream());

			// Todos los parámetros van precedidos de un signo & excepto el primero.

			// Parámetros de identificacion
			out2.print(XMLRequestManager.getCodigo_afiliacion());
			out2.print(XMLRequestManager.getCodigo_seacc());
			out2.print(XMLRequestManager.getUsuario());
			out2.print(XMLRequestManager.getCodigo_usuario());
			out2.print(XMLRequestManager.getCodigo_clausula());

			// sistema datos xml: datos cargado en memoria previamente
			out2.print("&xml=" + xmlEncoded);

			// al acabar la secuencia de parámetros printar &\n
			out2.print("&\n");
			out2.close();

			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null)
				result.append(inputLine);
			in.close();

			out2.write((String) result.toString());

			//Guardamos el xml en un objecto
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder;
			Document document = null;

			try {
				builder = factory.newDocumentBuilder();
				document = builder.parse(new InputSource(new StringReader(result.toString())));
				
				//Accedemos a los resultados en base a su tag (Ver especificacion de requisitos de Hotusa)
				NodeList nombre_hotel = document.getElementsByTagName("nombre_h");
				NodeList descripcion_hotel = document.getElementsByTagName("desc_hotel");
				NodeList fotos = document.getElementsByTagName("foto");
				NodeList website = document.getElementsByTagName("web");
                
                elementosXml.add(nombre_hotel.item(0).getFirstChild().getNodeValue());
                elementosXml.add(descripcion_hotel.item(0).getFirstChild().getNodeValue());
                elementosXml.add(fotos.item(0).getFirstChild().getNodeValue());
                elementosXml.add(website.item(0).getFirstChild().getNodeValue());

			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return elementosXml;
		}

	}

