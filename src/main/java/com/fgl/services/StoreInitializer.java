package com.fgl.services;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;

import com.fgl.model.Store;
import com.fgl.repository.StoreRepository;

public class StoreInitializer {
	@Autowired
	public StoreInitializer(StoreRepository repository) throws Exception {

		if (repository.count() != 0) {
			return;
		}

		List<Store> stores = readStores();
		System.out.println("######## Importing ${stores.size()} stores into DB #########");
		repository.save(stores);

	}

	private List<Store> readStores() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		JSONObject object = (JSONObject) parser.parse(new FileReader("/fgl_stores.json"));
		JSONArray storeList = (JSONArray) object.get("storeNumber");
		List<Store> storesList = new ArrayList<>();
		Iterator<Store> stores = storeList.iterator();
		while (stores.hasNext()) {
		Point point = null ;
			if ((stores.next().getLatitude() != null) && (stores.next().getLongitude() != null)) {
				 point = new Point(new Double(stores.next().getLongitude()),
						new Double(stores.next().getLatitude()));

			}
			Store store = new Store(stores.next().getStoreNumber(), stores.next().getName(), stores.next().getAddress(),
					stores.next().getCity(), stores.next().getProvince(), stores.next().getLongitude(),
					stores.next().getLatitude());
			storesList.add(store);
		}

		return storesList;
	}

	
}
