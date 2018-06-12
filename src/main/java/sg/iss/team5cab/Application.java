package sg.iss.team5cab;

import java.util.ArrayList;
import java.util.Date;

import sg.iss.team5cab.services.BookingService;
import sg.iss.team5cab.services.BookingServicesImpl;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int fid = 12;
		BookingService bServicesImpl = new BookingServicesImpl();
		/*
		ArrayList<Date> testlist = bServicesImpl.findAvailableDates(fid);
		for(Date d : testlist) {
			System.out.println(d.toString());
		}*/

	}

}
