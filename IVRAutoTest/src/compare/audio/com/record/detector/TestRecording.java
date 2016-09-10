package com.record.detector;

public class TestRecording {
	
	public static void main(String[] args) {
		
		//RecorderThread recorderThread = new RecorderThread();
		RecorderThread  recorder = new RecorderThread();
		DetectorThread detectorThread = new DetectorThread(recorder);
		detectorThread.start();
		
	}

}
