package com.alexhulbert.jmobiledevice;

import static com.alexhulbert.jmobiledevice.Pymobiledevice.pi;

/**
 *
 * @author Taconut
 */
public class AFC extends Wrapper {
     public AFC() {
         Pymobiledevice.use("pymobiledevice", "afc");
         pi.exec(id + "=afc.AFCClient()");
     }
     
     public AFC(Lockdown lockdown) {
         Pymobiledevice.use("pymobiledevice", "afc");
         pi.exec(id + "=afc.AFCClient('" + lockdown.id + "')");
     }
     
     public AFC(String ID) {
         Pymobiledevice.use("pymobiledevice", "afc");
         id = ID;
     }
}
