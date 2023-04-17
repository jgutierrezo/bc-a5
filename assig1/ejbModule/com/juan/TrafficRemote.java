package com.juan;

import java.util.List;

import com.juan.model.TrafficInfo;

import jakarta.ejb.Remote;

@Remote
public interface TrafficRemote {

	String calculateMortgage(Double amount, Double rate, int years);
	
	List<TrafficInfo> addTrafficInfo(List<TrafficInfo> til, TrafficInfo ti);

}
