package com.s2.travelmgt.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.s2.travelmgt.model.CompletedRide;
import com.s2.travelmgt.model.Driver;
import com.s2.travelmgt.model.TripDetails;
import com.s2.travelmgt.model.TripRequest;
import com.s2.travelmgt.model.TripResponse;
import com.s2.travelmgt.repository.DriverRepository;
import com.s2.travelmgt.repository.TripInfoRepo;

//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class TripController {
	
	@Autowired
    TripInfoRepo tripInfoRepo;
	
	
	@Autowired
	DriverRepository driverrepo;
	
	@RequestMapping(value="/hello", method = RequestMethod.GET)
	public String helloWorld() throws Exception{
		return "Hello World!!";
	}
	
	@GetMapping(path = "/getTripInfo")
	@ResponseBody
    public List<TripDetails> getEventInfo() {
		RestTemplate restTemplate = new RestTemplate();
		List<String> response = restTemplate.getForObject("http://localhost:8096/getUserDetails", List.class);
		String userStr = response.get(0);
		BigInteger username = new BigInteger(userStr);
		String role = response.get(1);
		String name = response.get(2);
		System.out.println(role);
		String result = "UserName = " + username + ", Role = " + role + ",Name = " + name ;
		
		if(role.substring(1,(role.length()-1)).equalsIgnoreCase("emp")) {
			Driver driver = new Driver();			
			driver.setEmp_mobile(username.toString());
			driver.setEmp_name(name);
			Long status = (long) 1;
			driver.setStatus(status);
			driverrepo.save(driver);
		}
		
		System.out.println(result);
		List<TripDetails> tripInfo = new ArrayList<>();;
		if(role.substring(1,(role.length()-1)).equalsIgnoreCase("admin")) {
			tripInfo = (List<TripDetails>) tripInfoRepo.findAll();
		}
		else {
			tripInfo = tripInfoRepo.findByUsername(username);
		}
        
        return tripInfo;
    }
	
	@GetMapping(path = "/getDrivers")
	@ResponseBody
    public Iterable<Driver> getDriverInfo() {
		Iterable<Driver> list = driverrepo.findAll();
		return list;
	}
	
	@RequestMapping(value="/bookride", method = RequestMethod.POST)
	public ResponseEntity<TripResponse> addTrip(@RequestBody TripRequest triprequest) {
		TripDetails tripEntity = new TripDetails();
		RestTemplate restTemplate = new RestTemplate();
		List<String> response = restTemplate.getForObject("http://localhost:8096/getUserDetails", List.class);
		String userStr = response.get(0);
		BigInteger username = new BigInteger(userStr);
		String roleArray = response.get(1);
		String role = roleArray.substring(1,(roleArray.length()-1));
		String name = response.get(2);
		
		Date date = Calendar.getInstance().getTime();  
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MINUTE, 39);
		Long id=(long) 0;
	
		List<Driver> dafs = (List<Driver>) driverrepo.findDriver();
	    Driver dr=dafs.get(0);
	    tripEntity.setSource(triprequest.getSource());
		tripEntity.setDestination(triprequest.getDestination());
	    tripEntity.setEmpName(dr.getEmp_name());
	    tripEntity.setEmpMobile(new BigInteger(dr.getEmp_mobile()));
	    tripEntity.setCustMobile(username);
	    tripEntity.setDropTime(calendar.getTime());
	    tripEntity.setPickupTime(date);
	    tripEntity.setCustName(name);
	    dr.setStatus(id);
	    driverrepo.save(dr);
	    tripInfoRepo.save(tripEntity); 
				
	    int tripId=tripEntity.getTripId();
		
	    TripResponse tripres=new TripResponse();
		tripres.setTripId(tripEntity.getTripId());
		tripres.setEmpName(tripEntity.getEmpName());
		tripres.setEmpMobile(tripEntity.getEmpMobile());
 
		return ResponseEntity.ok(tripres);
	}
	
	@RequestMapping(value="/rideCompleted", method = RequestMethod.GET)
	public String completedRide(CompletedRide cr) throws Exception{
		Driver d = new Driver();
		Long status=(long) 0;
		d.setEmp_mobile(cr.getUsername());
		d.setStatus(status);
		driverrepo.save(d);
		return "Ride Completed";
	}
}

