package com.ivrlog.rest.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

public class IVRLogHistoryHttpClientTest {

	public static void main(String[] args) {

		try {

			// create HTTP Client
			HttpClient httpClient = HttpClientBuilder.create().build();

			// Create new getRequest with below mentioned URL
			HttpGet getRequest = new HttpGet(
					"http://54.165.108.226:8051/ivrDetailForAutomatedTesting/9108484277/20160516/IN");

			// Add additional header to getRequest which accepts application/xml
			// data
			getRequest.addHeader("accept", "application/json");

			// Execute your request and catch response
			HttpResponse response = httpClient.execute(getRequest);

			// Check for HTTP response code: 200 = success
			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatusLine().getStatusCode());
			}

			// Get-Capture Complete application/xml body response
			BufferedReader br = new BufferedReader(new InputStreamReader(
					(response.getEntity().getContent())));
			String output;
			System.out.println("============Output:============");

			// Simply iterate through XML response and show on console.
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}

		} catch (ClientProtocolException ex) {
			ex.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}