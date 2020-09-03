package org.transport.TP.metier;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.transport.TP.Transport.Cargaison;
import org.transport.TP.Transport.CargaisonAerienne;
import org.transport.TP.Transport.InterfaceTransport;

public class ServletTransport extends HttpServlet{
	private InterfaceMetier IT;
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		IT= new MetierTransport();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ref_carg=req.getParameter("ref");
		Date date = null;
		try {
			 date=(Date) new SimpleDateFormat("dd/MM/yyyy").parse(req.getParameter("date"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		double distance= Double.parseDouble(req.getParameter("distance"));
		String Type_carg=req.getParameter("type_carg");
		double poid= Double.parseDouble(req.getParameter("poid"));
		
		if(Type_carg.equals("Aerienne")) {
			Cargaison C=new CargaisonAerienne(ref_carg,distance,date,poid);
			IT.ajouterCargaison(C);
		}
		req.getRequestDispatcher("Vue.jsp").forward(req, resp);	

	}
	
}
