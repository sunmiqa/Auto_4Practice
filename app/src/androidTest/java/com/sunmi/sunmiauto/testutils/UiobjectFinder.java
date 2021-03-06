package com.sunmi.sunmiauto.testutils;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;
import android.support.test.uiautomator.UiObject2;

import org.junit.Assert;

import java.util.List;

import static com.sunmi.sunmiauto.testutils.TestUtils.device;
import static com.sunmi.sunmiauto.testutils.TestUtils.screenshotCap;
import static com.sunmi.sunmiauto.testutils.TestUtils.sleep;

/**
 * Created by fengy on 2017/8/23.
 */

public class UiobjectFinder {

    private static BySelector selector = null;

    public static UiObject2 findById(String id) {
        return findById(id, 0);
    }

    public static UiObject2 findById(String id, int number) {
        selector = By.res(id);
        return findBySelector(selector, number);
    }

    public static UiObject2 findById(String id, int number, int counts) {
        selector = By.res(id);
        return findBySelector(selector, number, counts);
    }

    public static UiObject2 findByText(String text) {
        return findByText(text, 0);
    }

    public static UiObject2 findByText(String text, int number) {
        selector = By.text(text);
        return findBySelector(selector, number);
    }

    public static UiObject2 findByText(String text, int number, int counts) {
        selector = By.text(text);
        return findBySelector(selector, number, counts);
    }

    public static UiObject2 findByClazz(String clazz) {
        return findByClazz(clazz, 0);
    }

    public static UiObject2 findByClazz(String clazz, int number) {
        selector = By.clazz(clazz);
        return findBySelector(selector, number);
    }

    public static UiObject2 findByClazz(String clazz, int number,int counts) {
        selector = By.clazz(clazz);
        return findBySelector(selector, number,counts);
    }

    public static UiObject2 findByDesc(String desc) {
        return findByDesc(desc, 0);
    }

    public static UiObject2 findByDesc(String desc, int number) {
        selector = By.desc(desc);
        return findBySelector(selector, number);
    }

    public static UiObject2 findByDesc(String desc, int number,int counts) {
        selector = By.desc(desc);
        return findBySelector(selector, number,counts);
    }

    public static UiObject2 findByFocused(boolean focused) {
        selector = By.focused(focused);
        return findBySelector(selector, 0);
    }

    public static UiObject2 findBySelected(boolean selected) {
        selector = By.selected(selected);
        return findBySelector(selector, 0);
    }

    public static UiObject2 findBySelector(BySelector by) {
        return findBySelector(by, 0);
    }

    public static UiObject2 findBySelector(BySelector by, int number) {
        return findBySelector(by, number, 20);
    }

    public static UiObject2 findBySelector(BySelector by, int number, int counts) {
        UiObject2 uiObject2 = null;
        int i = 0;
        do {
            i++;
            sleep(500);
            if (number == 0) {
                uiObject2 = device.findObject(by);
            } else {
                List<UiObject2> list = device.findObjects(by);
                if (list.size() < number - 1) {
                    uiObject2 = null;
                } else {
                    uiObject2 = list.get(number - 1);
                }
            }
            if (i == counts && uiObject2 == null) {
                screenshotCap("wrong UI");
                return null;
            }
        } while (uiObject2 == null && i < counts);
        sleep(500);
        return uiObject2;
    }

//    public static UiObject2 findByInfo(BySelector selector,int number){
//        sleep(500);
//        UiObject2 uiObject2 = null;
//        List<UiObject2> list = device.findObjects(selector);
//        if(list.isEmpty()){
//            uiObject2 = null;
//        }else{
//            uiObject2 = list.get(number-1);
//        }
//        int i = 0;
//        while(uiObject2 == null && i < 20){
//            //解决一些可能出现的问题
//            //等待500ms，最多等待20次
//            i++;
//            sleep(500);
//            List<UiObject2> list1 = device.findObjects(selector);
//            if(list1.isEmpty()){
//                uiObject2 = null;
//            }else{
//                uiObject2 = list1.get(number-1);
//                return uiObject2;
//            }
//            if(i == 20 && uiObject2 == null){
//                screenshotCap("wrong UI");
//                Assert.fail("未找到想要找的属性为"+selector.toString()+"控件");
//            }
//        }
//        sleep(500);
//        return uiObject2;
//    }
}
