package com.test;

import java.io.IOException;

import javax.naming.Context;
import javax.naming.NamingException;

import com.juan.Mortgage;
import com.juan.MortgageRemote;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/mortgageForm")
public class Client extends HttpServlet {
	public static void main(String[] args) {
		MortgageRemote bean = doLookup();
		// System.out.println(bean.helloWorld());
	}

	public Client() {
		super();
	}

	private static MortgageRemote doLookup() {
		Context context = null;
		MortgageRemote bean = null;
		try {
			context = ClientUtility.getInitialContext();
			String lookupName = getLookupName();
			bean = (MortgageRemote) context.lookup(lookupName);
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return bean;
	}

	private static String getLookupName() {
		String appName = "";
		String moduleName = "assig1";
		String distinctName = "";
		String beanName = Mortgage.class.getSimpleName();
		final String interfaceName = MortgageRemote.class.getName() + "?stateful";
		String name = "ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + interfaceName;
		return name;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/form.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MortgageRemote bean = doLookup();
		String result = bean.calculateMortgage(Double.valueOf(request.getParameter("amount")),
				Double.valueOf(request.getParameter("rate")), Integer.valueOf(request.getParameter("year")));
		
		System.out.println("result: "+result);
		
		request.setAttribute("result", result);
		request.getRequestDispatcher("/result.jsp").forward(request, response);
	}

}