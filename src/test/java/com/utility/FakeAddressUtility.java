package com.utility;

import java.util.Locale;

import com.github.javafaker.Faker;
import com.ui.pojo.AddressPojo;

public class FakeAddressUtility {
	
	public static AddressPojo generateFakeAddress() {
		
		Faker faker = new Faker(Locale.US);
		
		AddressPojo addressPojo = new AddressPojo(faker.company().name(),
				faker.address().buildingNumber(),
				faker.address().streetAddress(),
				faker.address().city(),
				"77887",
				faker.phoneNumber().cellPhone(),
				faker.phoneNumber().cellPhone(),
				"",
				faker.address().state());
		return addressPojo;
		
}
}