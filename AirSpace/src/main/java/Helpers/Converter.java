package Helpers;

import java.util.List;
import java.util.stream.Collectors;

import com.smv.AirSpace.dto.AirlineFrontDTO;
import com.smv.AirSpace.dto.HotelFrontDTO;
import com.smv.AirSpace.dto.RentacarFrontDTO;
import com.smv.AirSpace.dto.RoomDTO;
import com.smv.AirSpace.model.Airline;
import com.smv.AirSpace.model.Hotel;
import com.smv.AirSpace.model.Rentacar;
import com.smv.AirSpace.model.Room;

public class Converter {
	
	public static List<HotelFrontDTO> ConvertHotelToHotelDTOs(List<Hotel> hotels) {
		return hotels.stream().map(hotel -> new HotelFrontDTO(hotel)).collect(Collectors.toList());
	}
	public static List<AirlineFrontDTO> convertAirlineToAirlineFrontDTOs(List<Airline> airlines) {
		return airlines.stream().map(airline -> new AirlineFrontDTO(airline)).collect(Collectors.toList());
	}
	public static List<RentacarFrontDTO> convertRentacarToRentacarFrontDTOs(List<Rentacar> rentacars) {
		return rentacars.stream().map(rentacar -> new RentacarFrontDTO(rentacar)).collect(Collectors.toList());
	}
	public static List<RoomDTO> convertRoomToRoomDTO(List<Room> rooms) {
		return rooms.stream().map(room -> new RoomDTO(room)).collect(Collectors.toList());
	}
	

}
