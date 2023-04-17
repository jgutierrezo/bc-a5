package com.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.NamingException;

import com.juan.Traffic;
import com.juan.TrafficRemote;
import com.juan.model.TrafficInfo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/TrafficForm")
public class Client extends HttpServlet {

	List<TrafficInfo> til;

	public static void main(String[] args) {
		TrafficRemote bean = doLookup();
	}

	public Client() {
		super();
		til = new ArrayList<>();
	}

	private static TrafficRemote doLookup() {
		Context context = null;
		TrafficRemote bean = null;
		try {
			context = ClientUtility.getInitialContext();
			String lookupName = getLookupName();
			bean = (TrafficRemote) context.lookup(lookupName);
		} catch (NamingException e) {
			System.out.println("Error while looking up the EJB: " + e.getMessage());

			e.printStackTrace();
		}
		return bean;
	}

	private static String getLookupName() {
		String appName = "";
		String moduleName = "assig1";
		String distinctName = "";
		String beanName = Traffic.class.getSimpleName();
		final String interfaceName = TrafficRemote.class.getName() + "?stateful";
		String name = "ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + interfaceName;
		return name;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<String> torontoNeighborhoods = new ArrayList<>();

		torontoNeighborhoods.add("The Annex");
		torontoNeighborhoods.add("The Beaches");
		torontoNeighborhoods.add("Cabbagetown");
		torontoNeighborhoods.add("Chinatown");
		torontoNeighborhoods.add("Distillery District");
		torontoNeighborhoods.add("Downtown");
		torontoNeighborhoods.add("Entertainment District");
		torontoNeighborhoods.add("Financial District");
		torontoNeighborhoods.add("Harbourfront");
		torontoNeighborhoods.add("High Park");
		torontoNeighborhoods.add("Kensington Market");
		torontoNeighborhoods.add("Leaside");
		torontoNeighborhoods.add("Leslieville");
		torontoNeighborhoods.add("Little Italy");
		torontoNeighborhoods.add("Parkdale");
		torontoNeighborhoods.add("Queen West");
		torontoNeighborhoods.add("Riverdale");
		torontoNeighborhoods.add("Roncesvalles");
		torontoNeighborhoods.add("Rosedale");
		torontoNeighborhoods.add("St. Lawrence Market");
		torontoNeighborhoods.add("Trinity-Bellwoods");
		torontoNeighborhoods.add("Yorkville");

		request.setAttribute("torontoNeighborhoods", torontoNeighborhoods);
		request.getRequestDispatcher("/add_traffic_info.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    TrafficRemote bean = doLookup();

	    String neighborhood = request.getParameter("neighborhood_id");
	    String trafficCars = request.getParameter("traffic_cars");
	    String pedestrians = request.getParameter("pedestrians");
	    String date = request.getParameter("date");

	    TrafficInfo ti = new TrafficInfo();

	    ti.setNeighborhood(neighborhood);
	    ti.setCars(trafficCars);
	    ti.setPedestrians(pedestrians);
	    ti.setDate(date);

	    // Get the traffic info list from HttpSession, or create a new one if it doesn't exist
	    HttpSession session = request.getSession();
	    List<TrafficInfo> trafficInfoList = (List<TrafficInfo>) session.getAttribute("trafficInfoList");
	    if (trafficInfoList == null) {
	        trafficInfoList = new ArrayList<>();
	    }

	    List<TrafficInfo> newTil = bean.addTrafficInfo(trafficInfoList, ti);
	    session.setAttribute("trafficInfoList", newTil); // Save the updated list in HttpSession

	    System.out.println("size: " + newTil.size());

	    request.setAttribute("trafficRecords", newTil);
	    request.getRequestDispatcher("/dashboard.jsp").forward(request, response);
	}

}