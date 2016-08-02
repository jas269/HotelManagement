package com.axisrooms.masterdata.hotelDao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.axisrooms.masterdata.model.Hotel;

@Repository
public class HotelDAOImpl implements HotelDAO
{

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf)
	{
		this.sessionFactory = sf;
	}
	
	
	public void addHotel(Hotel hotel) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(hotel);
	}

	
	public void updateHotel(Hotel hotel) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(hotel);
	}

	@SuppressWarnings("unchecked")
	public List<Hotel> getHotelList() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Hotel> hotelList = session.createQuery("from hotel").list();
		return hotelList;
	}

	public Hotel getHotelById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Hotel hotel = (Hotel) session.load(Hotel.class, new Integer(id));
		return hotel;
	}

	public void deleteHotel(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Hotel hotel = (Hotel) session.load(Hotel.class,  new Integer(id));
		
		if(hotel != null)
		{
			session.delete(hotel);
		}
	}

	
}