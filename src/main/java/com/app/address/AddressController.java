package com.app.address;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.address.bean.AddressDO;

@RestController
public class AddressController {
	@Autowired
	AddressService addressService;
	
	Logger log = Logger.getLogger(AddressController.class.getName());
	
	@RequestMapping(value = "/address/save", method = RequestMethod.POST, produces = "application/json")
	public AddressDO setAddress(@RequestBody AddressDO address){
		addressService.saveAddress(address);
		return address;
	}
	@RequestMapping(value = "/address/getAllAdreesses", method = RequestMethod.GET, produces = "application/json")
	public List<AddressDO> getName(){
		return addressService.findAll();
	}
	@RequestMapping(value = "/address/deleteAddress", method = RequestMethod.POST, produces = "application/json")
	public AddressDO deleteAddress(@RequestBody AddressDO address){
		try{
			addressService.deleteAddress(address);
			address.setStatusMessage("success");
			log.info("Record deleted successfully "+address.getName());
		}catch(Exception e){
			log.info(e.getMessage());
			address.setStatusMessage("error");
		}
		return address;
	}
	@RequestMapping(path = "/")
	public String start(){
		return "Welcome to the Sprng Boot application";
	}
	@RequestMapping(value = "/getName", method = RequestMethod.GET, produces = "application/json")
	public String getName(String name){
		return "Entered Name : "+name;
	}
	
	@RequestMapping(path = "/hello")
	public String hello(){
		return "hello";
	}	
}
