package com.mettalica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mettalica.dao.CommodityDao;
import com.mettalica.dao.LocationDao;
import com.mettalica.dao.PartyDao;
import com.mettalica.model.entity.Commodity;
import com.mettalica.model.entity.Location;
import com.mettalica.model.entity.Party;
import com.mettalica.model.response.ApiResponse;
import com.mettalica.model.response.RefDataDTO;

@RestController
@RequestMapping("/refData")
public class RefController {

    @Autowired
    CommodityDao commodityDao;
    
    @Autowired
    LocationDao locationDao;
    
    @Autowired
    PartyDao partyDao;
    

    @GetMapping()
    public ResponseEntity<ApiResponse> getAllData(){

        RefDataDTO refData = new RefDataDTO();
        List<Commodity> commList = (List<Commodity>) commodityDao.findAll();
        refData.setCommodities(commList);
        List<Party> partyList = (List<Party>) partyDao.findAll();
        refData.setParties(partyList);
        List<Location> locationList = (List<Location>) locationDao.findAll();
        refData.setLocation(locationList);
        ApiResponse apiResponse=new ApiResponse();
        apiResponse.setMessage("Successfully Retrieved");
        apiResponse.setResponse(refData);
        apiResponse.setStatus("SUCCESS");
       
        return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.OK);
    }
}
