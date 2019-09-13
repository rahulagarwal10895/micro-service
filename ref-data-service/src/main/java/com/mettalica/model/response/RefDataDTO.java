package com.mettalica.model.response;

import com.mettalica.model.entity.Commodity;
import com.mettalica.model.entity.Location;
import com.mettalica.model.entity.Party;

import lombok.Data;

import java.util.List;

@Data
public class RefDataDTO extends BaseResponse {

	
	private List<Commodity> commodities;
	private List<Party> parties;
	private List<Location> location;
	
	public List<Commodity> getCommodities() {
		return commodities;
	}

	public void setCommodities(List<Commodity> commodities) {
		this.commodities = commodities;
	}

	public List<Party> getParties() {
		return parties;
	}

	public void setParties(List<Party> parties) {
		this.parties = parties;
	}

	public List<Location> getLocation() {
		return location;
	}

	public void setLocation(List<Location> location) {
		this.location = location;
	}

	

}
