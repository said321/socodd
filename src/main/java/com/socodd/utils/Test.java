package com.socodd.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.util.JSONPObject;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;

import com.socodd.entities.Zone;
import com.socodd.services.IZoneService;

public class Test {
	
	

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		// TODO Auto-generated method stub
		
		
		Zone z1 = new Zone("z1","zone1");
		z1.setId(1);
		
		Zone z2 = new Zone("z2","zone2");
		z2.setId(2);
		
		Zone z3 = new Zone("z3","zone3");
	
		z3.setId(3);
		
		List<Zone> zones = new ArrayList<Zone>();

		zones.add(z1);
		zones.add(z2);
		zones.add(z3);
		
		
		JSONPObject j = new JSONPObject("jj", zones);
		
//		System.out.println(
//				((Zone)((ArrayList<?>)j.getValue()).get(1)).getNom()
//				);
		

		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationConfig.Feature.INDENT_OUTPUT);
		String jsonString = mapper.writeValueAsString(zones);
		System.out.println(jsonString);
		
		
		TypeReference ref = new TypeReference<List<Zone>>() { };
		
		 List<Zone> zs =  mapper.readValue(jsonString, ref);
		 
		 Zone[] tab_zone = mapper.readValue(jsonString, Zone[].class);
		 
		 for (Zone zone : tab_zone) {
			 System.out.println("[ " + zone.getId() + ", " + zone.getCode() + ", " + ((Zone)zone).getNom() + " ]");
		}
		 
		 
		
		for (Zone zone : zs) {
			System.out.println("[ " + zone.getId() + ", " + zone.getCode() + ", " + ((Zone)zone).getNom() + " ]");
		}
		
		
		System.out.println(Zone.class);
		
		

	}
	

}











