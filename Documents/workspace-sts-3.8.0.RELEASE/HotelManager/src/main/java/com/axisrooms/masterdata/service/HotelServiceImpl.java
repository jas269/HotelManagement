package com.axisrooms.masterdata.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.axisrooms.masterdata.hotelDao.HotelDAO;
import com.axisrooms.masterdata.model.Hotel;

@Service
public class HotelServiceImpl implements HotelService{

	private HotelDAO hotelDAO;

	public void setHotelDAO(HotelDAO hotelDAO) {
		this.hotelDAO = hotelDAO;
	}
	
	
	@Transactional

	public void addHotel(Hotel hotel) {
		this.hotelDAO.addHotel(hotel);
		
	}

	
	@Transactional
	public void updateHotel(Hotel hotel) {
		this.hotelDAO.updateHotel(hotel);
	}

	
	@Transactional
	public List<Hotel> getHotelList() {
		
		return this.hotelDAO.getHotelList();
	}

	
	@Transactional
	public Hotel getHotelById(int id) {
		
		return this.hotelDAO.getHotelById(id);
	}

	
	@Transactional
	public void deleteHotel(int id) {
		this.hotelDAO.deleteHotel(id);
		
	}


	
	
	

}
