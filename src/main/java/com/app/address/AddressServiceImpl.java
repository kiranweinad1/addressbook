package com.app.address;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.address.bean.AddressDO;

@Service
public class AddressServiceImpl implements AddressService{
	
	@Autowired
	AddressRepository addressRepository;
	
	@Override
	public AddressDO saveAddress(AddressDO address){
		addressRepository.save(address);
		return address;
	}
	
	public List<AddressDO> findAll(){		
		return (List<AddressDO>) addressRepository.findAll();
	}
	
	public void deleteAddress(AddressDO address){
		addressRepository.delete(address);
	}
}
