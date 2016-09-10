package com.test;

import java.io.File;

import org.apache.commons.codec.binary.Hex;

import com.musicg.fingerprint.FingerprintSimilarity;
import com.musicg.fingerprint.FingerprintSimilarityComputer;
import com.musicg.wave.Wave;

public class TestAudio {
	
	public static void main(String[] args) throws Exception {
		
	
	
	
      // File file1 = new File("C:\\Users\\nikhil.sanghvi\\Desktop\\audio_folder\\Welcome_KA.wav");
      // File file2 = new File("C:\\Users\\nikhil.sanghvi\\Desktop\\audio_folder\\Welcome_KA.wav");
        
        File file1 = new File("C:\\Program Files (x86)\\Audio DiffMaker\\IVRCall2.wav");
       File file2 = new File("C:\\Program Files (x86)\\Audio DiffMaker\\IVRCall.wav");
      
        Wave w1 = new Wave(file1.getPath());
        
        byte[] bw1 = w1.getFingerprint();
        
       /* for(int i=0;i<bw1.length;i++){
        	System.out.print(bw1[i]+",");
        }
        */
        String sw1 =    Hex.encodeHexString(bw1);
        
        System.out.println(sw1);
        
       
     
        Wave w2 = new Wave(file2.getPath());
        
        byte[] bw2 = w2.getFingerprint();
        
       /* for(int j=0;j<bw1.length;j++){
        	System.out.print(bw2[j]+",");
        }*/
      
        String sw2 =    Hex.encodeHexString(bw2);
        System.out.println(sw2);
       
   
//      System.out.println(w1.getSpectrogram());
//      System.out.println(w2.getSpectrogram());
   
        FingerprintSimilarity fps = w1.getFingerprintSimilarity(w2);
        FingerprintSimilarityComputer compute = new FingerprintSimilarityComputer(w1.getFingerprint(), w2.getFingerprint());
        FingerprintSimilarity similarity =  compute.getFingerprintsSimilarity();
        
        System.out.println("Sim-----"+similarity.getScore()+"----Score-----------"+similarity.getScore()+"-----------similare time Position---"+similarity.getsetMostSimilarTimePosition()+"Similar Frame--"+similarity.getMostSimilarFramePosition());
        float score = fps.getScore();
        float sim = fps.getSimilarity();
        float sfp = fps.getsetMostSimilarTimePosition();
        System.out.println("Sim-----"+sim+"-------- score--"+score+"------------similar time position--"+sfp+"---------similar frame--"+fps.getMostSimilarFramePosition());;
       
       

	}

}
