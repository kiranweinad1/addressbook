package com.app.address;

import java.util.List;

import com.app.address.bean.AddressDO;


public interface AddressService {
	AddressDO saveAddress(AddressDO address);
	List<AddressDO> findAll();
	void deleteAddress(AddressDO address);
}
