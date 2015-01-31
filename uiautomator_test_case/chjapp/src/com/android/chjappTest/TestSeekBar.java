package com.android.chjappTest;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

import java.lang.InterruptedException;
import java.lang.System;

public class TestSeekBar extends UiAutomatorTestCase {

    public void testChjApp() throws UiObjectNotFoundException{

        getUiDevice().pressHome();

        UiObject chjApp = new UiObject(new UiSelector().text("chjapp"));
        chjApp.click();

        try{
            Thread.sleep(3000);
        } catch (InterruptedException e1){
            e1.printStackTrace();
        }

        UiObject seekBarWedget = new UiObject(new UiSelector().description("seekBar_def"));
        UiObject seekBarText = new UiObject(new UiSelector().description("text_def"));
        // TODO: Figure out why assert won't make this case failed
        assertEquals(seekBarText, "seekBar progress : 69");
        // TODO: Figure out why texts below won't be printed
        System.out.println("SeekBar Bounds:");
        System.out.println(seekBarWedget.getBounds());
        //seekBarWedget.dragTo;

    }
}