package com.axisrooms.masterdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.axisrooms.masterdata.model.Hotel;
import com.axisrooms.masterdata.service.HotelService;

@Controller
public class HotelController {

	private HotelService hotelService;
	
	@Autowired
	@Qualifier(value="hotelService")
	public void setHotelService(HotelService hs)
	{
		this.hotelService=hs;
	}
	
	@RequestMapping (value = "/hotels", method = RequestMethod.GET)
	public String listHotels(Model model){
		model.addAttribute("hotel", new Hotel());
		model.addAttribute("hotelList", this.hotelService.getHotelList());
		return "hotel";
	}
	
	@RequestMapping (value = "/hotel/add", method = RequestMethod.POST)
	public String addHotel(@ModelAttribute("hotel") Hotel hotel){
		if(hotel.getId() == 0){
			//new hotel, so add it
			this.hotelService.addHotel(hotel);
		}
		else{
			//existing hotel, so update it
			this.hotelService.updateHotel(hotel);
		}
		return "redirect:/hotels";
	}
	
	@RequestMapping("/remove/{id}")
    public String deleteHotel(@PathVariable("id") int id){
		
        this.hotelService.deleteHotel(id);
        return "redirect:/hotels";
	}
	
	@RequestMapping("/edit/{id}")
    public String editHotel(@PathVariable("id") int id, Model model){
        model.addAttribute("hotel", this.hotelService.getHotelById(id));
        model.addAttribute("hotelList", this.hotelService.getHotelList());
        return "hotel";
    }
}
