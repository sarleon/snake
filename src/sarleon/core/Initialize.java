package sarleon.core;

import com.sun.xml.internal.fastinfoset.tools.XML_SAX_StAX_FI;

/**
 * Created by sarleon on 1/18/16.
 */
public class Initialize {
    private static final int MAX=20;

    public static int getMAX() {
        return MAX;
    }

    public static int randomnum(){
        int num=(int)(Math.random()*MAX);
        return num;
    }


}
