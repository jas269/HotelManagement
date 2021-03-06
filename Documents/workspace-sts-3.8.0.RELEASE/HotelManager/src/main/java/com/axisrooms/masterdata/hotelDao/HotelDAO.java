package com.axisrooms.masterdata.hotelDao;

import java.util.List;

import com.axisrooms.masterdata.model.Hotel;

public interface HotelDAO {
	
	public void addHotel(Hotel hotel);
	public void updateHotel(Hotel hotel);
	public List<Hotel> getHotelList();
	public Hotel getHotelById(int id);
	public void deleteHotel(int id);

}