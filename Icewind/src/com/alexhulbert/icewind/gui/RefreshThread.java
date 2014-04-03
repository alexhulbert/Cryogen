package com.alexhulbert.icewind.gui;

import static com.alexhulbert.icewind.gui.StaticStage.devices;
import static com.alexhulbert.icewind.gui.Utils.fadeIn;
import static com.alexhulbert.icewind.gui.Utils.fadeOut;
import com.alexhulbert.jmobiledevice.Lockdown;
import com.alexhulbert.jmobiledevice.diagnostics.Diagnostics;
import com.alexhulbert.jmobiledevice.diagnostics.Info;
import com.alexhulbert.jmobiledevice.diagnostics.Keys;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class RefreshThread implements Runnable {
    
    public String devicePic(String model, String family, boolean isDFU) {
        return String.format(
                "https://statici.icloud.com/fmipmobile/deviceImages-2.0/%s/%s/%sline-nolocation_ipad.png",
                family,
                family + model,
                isDFU ? "off" : "on"
        );
    }
    
    private final ImageView ImgA;
    private final ImageView ImgB;
    private final ImageView ImgC;
    private final Label NameA;
    private final Label NameB;
    private final Label NameC;
    private final ProgressIndicator ProgA;
    private final ProgressIndicator ProgB;
    private final ProgressIndicator ProgC;

    public RefreshThread(
            ImageView ImgA, ImageView ImgB, ImageView ImgC, 
            Label NameA, Label NameB, Label NameC, 
            ProgressIndicator ProgA, ProgressIndicator ProgB, ProgressIndicator ProgC
    ) {
        this.ImgA = ImgA;
        this.ImgB = ImgB;
        this.ImgC = ImgC;
        this.NameA = NameA;
        this.NameB = NameB;
        this.NameC = NameC;
        this.ProgA = ProgA;
        this.ProgB = ProgB;
        this.ProgC = ProgC;
    }

    @Override
    public void run() {
        //Disable button
        devices.clear();
        
        fadeOut(ImgA, 250);
        fadeIn(ProgA, 250);
        fadeOut(ImgB, 250);
        fadeIn(ProgB, 250);
        fadeOut(ImgC, 250);
        fadeIn(ProgC, 250);
        
        String[] devUdids = Lockdown.listDevices();
        for (int i = 0; i < Math.min(3, devUdids.length); i++) {
            try {
                Lockdown ld = new Lockdown(devUdids[i].toCharArray());
                devices.add(ld);
            } catch (Exception e) {
                break;
            }
        }
        
        if (devices.size() > 0) {
            LoadA();
            if (devices.size() > 1) {
                LoadB();
                if (devices.size() > 2) {
                    LoadC();
                } else {
                    fadeOut(ProgC, 250);
                    ImgC.setImage(null);
                    Platform.runLater(new Runnable() {
                        @Override public void run() {
                            NameC.setText("");
                        }
                    });
                }
            } else {
                fadeOut(ProgB, 250);
                ImgB.setImage(null);
                fadeOut(ProgC, 250);
                ImgC.setImage(null);
                Platform.runLater(new Runnable() {
                    @Override public void run() {
                        NameB.setText("");
                        NameC.setText("");
                    }
                });
            }
        } else {
            fadeOut(ProgA, 250);
            ImgA.setImage(null);
            fadeOut(ProgB, 250);
            ImgB.setImage(null);
            fadeOut(ProgC, 250);
            ImgC.setImage(null);
            Platform.runLater(new Runnable() {
                @Override public void run() {
                    NameA.setText("");
                    NameB.setText("");
                    NameC.setText("");
                }
            });
        }
    }
    
    public void LoadA() {
        Platform.runLater(new Runnable() {
            @Override public void run() {
                NameA.setText("Loading...");
            }
        });
        Diagnostics diagA = new Diagnostics(devices.get(0));
        final Info infoA = diagA.query(
                Keys.ProductType.value +    //iPod51
                Keys.ProductVersion.value + //7.0.6
                Keys.DeviceColor.value +    //black
                Keys.DeviceClass.value +    //iPod
                Keys.UserAssignedDeviceName.value 
        );
        String realClass = infoA.getString(Keys.DeviceClass.value);
        char[] realTypeClass = infoA.getString(Keys.ProductType.value).substring(realClass.length()).toCharArray();
        String imgUrl = devicePic(realTypeClass[0] + "," + realTypeClass[1], realClass, false); //Always 2 1-digit numbers?
        fadeOut(ProgA, 175);
        ImgA.setImage(new Image(imgUrl));
        Platform.runLater(new Runnable() {
            @Override public void run() {
                NameA.setText(infoA.getString(Keys.UserAssignedDeviceName.value));
            }
        });
        fadeIn(ImgA, 250);
    }
    
    public void LoadB() {
        Platform.runLater(new Runnable() {
            @Override public void run() {
                NameB.setText("Loading...");
            }
        });
        Diagnostics diagB = new Diagnostics(devices.get(1));
        final Info infoB = diagB.query(
                Keys.ProductType.value +    //iPod51
                Keys.ProductVersion.value + //7.0.6
                Keys.DeviceColor.value +    //black
                Keys.DeviceClass.value +    //iPod
                Keys.UserAssignedDeviceName.value 
        );
        String realClass = infoB.getString(Keys.DeviceClass.value);
        char[] realTypeClass = infoB.getString(Keys.ProductType.value).substring(realClass.length()).toCharArray();
        String imgUrl = devicePic(realTypeClass[0] + "," + realTypeClass[1], realClass, false); //Always 2 1-digit numbers?
        fadeOut(ProgB, 175);
        ImgB.setImage(new Image(imgUrl));
        Platform.runLater(new Runnable() {
            @Override public void run() {
                NameB.setText(infoB.getString(Keys.UserAssignedDeviceName.value));
            }
        });
        fadeIn(ImgB, 250);
    }
    
    public void LoadC() {
        Platform.runLater(new Runnable() {
            @Override public void run() {
                NameC.setText("Loading...");
            }
        });
        Diagnostics diagC = new Diagnostics(devices.get(2));
        final Info infoC = diagC.query(
                Keys.ProductType.value +    //iPod51
                Keys.ProductVersion.value + //7.0.6
                Keys.DeviceColor.value +    //black
                Keys.DeviceClass.value +    //iPod
                Keys.UserAssignedDeviceName.value 
        );
        String realClass = infoC.getString(Keys.DeviceClass.value);
        char[] realTypeClass = infoC.getString(Keys.ProductType.value).substring(realClass.length()).toCharArray();
        String imgUrl = devicePic(realTypeClass[0] + "," + realTypeClass[1], realClass, false); //Always 2 1-digit numbers?
        fadeOut(ProgC, 175);
        ImgB.setImage(new Image(imgUrl));
        Platform.runLater(new Runnable() {
            @Override public void run() {
                NameB.setText(infoC.getString(Keys.UserAssignedDeviceName.value));
            }
        });
        fadeIn(ImgC, 250);
    }
}
