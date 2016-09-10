package com.ivrlog.rest.client;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import org.json.JSONArray;
import org.json.JSONObject;

import com.dto.IvrCallLogData;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class IVRLogHistoryHttpClient {

	private static ResourceBundle bundle;
	private static String service = null;

	public IVRLogHistoryHttpClient() {
		bundle = ResourceBundle.getBundle("com.bundle.ResourceBundle");
		service = bundle.getString("url");
	}

	public IvrCallLogData getIvrResponse(String mobileNumber, String date) {

		JSONObject jsonObject = null;
		Client client = null;
		ClientResponse response = null;
		List<IvrCallLogData> ivrCallLogDataList = new LinkedList<IvrCallLogData>();
		ObjectMapper mapper = new ObjectMapper();
		IvrCallLogData ivrCallLogDataCurrObj = new IvrCallLogData();

		try {
			client = Client.create();
			String clientUrl = service + "/" + mobileNumber + "/" + date
					+ "/IN";
			// System.out.println(clientUrl);
			WebResource webResource = client.resource(clientUrl);
			response = webResource.accept("application/json").get(
					ClientResponse.class);
			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatus());
			}

			String jsonInString = response.getEntity(String.class);
			// System.out.println("\n============getIvrResponse============");
			// System.out.println(jsonInString);
			JSONArray jsonArray = new JSONArray(jsonInString);
			// System.out.println(jsonArray.length());
			for (int i = 0; i < jsonArray.length(); i++) {
				jsonObject = (JSONObject) jsonArray.get(i);
				if (jsonObject != null) {
					IvrCallLogData ivrCallLogData = mapper.readValue(
							jsonObject.toString(), IvrCallLogData.class);
					// System.out.println(ivrCallLogData);
					ivrCallLogDataList.add(ivrCallLogData);
				}
			}
			if (!(ivrCallLogDataList.isEmpty())) {
				Comparator<IvrCallLogData> comparator = Comparator
						.comparing(IvrCallLogData::getRequesttime);
				ivrCallLogDataList.sort(comparator.reversed());
				ivrCallLogDataCurrObj = ivrCallLogDataList.get(0);
				// System.out.println("Sorted According to Updated TimeStamp"+ivrCallLogDataCurrObj);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (response != null) {
				response.close();
			}
			if (client != null) {
				client.destroy();
			}
		}
		return ivrCallLogDataCurrObj;
	}

	/*
	 * public static void main(String[] args) { IVRLogHistoryHttpClient client
	 * =new IVRLogHistoryHttpClient();
	 * client.getIvrResponse("9108484277","20160516"); //
	 * client.getIvrResponse("8109558481", "20160503");
	 * 
	 * }
	 */

}
