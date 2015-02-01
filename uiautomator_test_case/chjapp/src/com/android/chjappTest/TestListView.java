package com.android.chjappTest;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

import java.lang.InterruptedException;
import java.lang.System;

public class TestListView extends UiAutomatorTestCase {

    public void testChjApp() throws UiObjectNotFoundException{

        getUiDevice().pressHome();

        UiObject chjApp = new UiObject(new UiSelector().text("chjapp"));
        chjApp.click();

        try{
            Thread.sleep(3000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        UiScrollable listView = new UiScrollable(new UiSelector().description("lv_def"));

        UiObject test_data_15 = listView.getChildByText(
                new UiSelector().className(android.widget.TextView. class .getName()), "test view15"
        );
        test_data_15.click();

    }
}