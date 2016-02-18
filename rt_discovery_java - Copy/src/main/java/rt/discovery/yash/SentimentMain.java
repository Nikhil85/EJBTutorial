package rt.discovery.yash;

import java.io.IOException;

public class SentimentMain {
	public static void main(String[] args) {
		TwitterManager twitterManager = new TwitterManager();
		try {
			twitterManager.performQuery("AapSeNaHoPayega");
		} catch (InterruptedException e) {
			System.out.println("Stream Interrupted");
		} catch (IOException e) {
			System.out.println("IOException");
		}
	}

}
