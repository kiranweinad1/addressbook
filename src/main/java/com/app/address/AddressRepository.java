package com.app.address;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.address.bean.AddressDO;

@Repository
public interface AddressRepository extends CrudRepository<AddressDO,Long>{

}
