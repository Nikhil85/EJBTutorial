package rt.discovery.yash;

import java.io.File;
import java.io.IOException;

import com.aliasi.classify.ConditionalClassification;
import com.aliasi.classify.LMClassifier;
import com.aliasi.util.AbstractExternalizable;

public class SentimentClassifier {  
    String[] categories;  
    LMClassifier classify;  
    public SentimentClassifier() {  
    try {  
       classify= (LMClassifier) AbstractExternalizable.readObject(new File("resources/classifier.txt"));  
       categories = classify.categories();  
    }  
    catch (ClassNotFoundException e) {  
       e.printStackTrace();  
    }  
    catch (IOException e) {  
       e.printStackTrace();  
    }  
    }  
    public String classify(String text) {  
    ConditionalClassification classification = classify.classify(text);  
    return classification.bestCategory();  
    }  
 }  