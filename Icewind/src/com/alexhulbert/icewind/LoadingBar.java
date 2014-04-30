package com.alexhulbert.icewind;

public interface LoadingBar {
    void progress(double percentage);
    double getPercentage();
    
    void status(String text);
    String getText();
    
    void activate(Boolean onOff);
    Boolean getEnabled();
    
    void intermediate();
    void percentage();
    Boolean isIntermediating();
}
