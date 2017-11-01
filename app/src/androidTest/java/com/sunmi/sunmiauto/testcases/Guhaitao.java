package com.sunmi.sunmiauto.testcases;

import android.graphics.Point;
import android.os.RemoteException;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiObject2;

import com.sunmi.sunmiauto.testutils.CommonAction;
import com.sunmi.sunmiauto.testutils.TestUtils;
import com.sunmi.sunmiauto.testutils.UiobjectFinder;

import org.junit.Assert;
import org.junit.Test;

import static com.sunmi.sunmiauto.testutils.TestUtils.device;
import static com.sunmi.sunmiauto.testutils.TestUtils.sleep;

/**
 * Created by Administrator on 2017/10/25.
 */

public class Guhaitao {
    @Test
    public void test001WelcomePage1(){
        CommonAction.clickById("woyou.welcome:id/tv_button_text");
        CommonAction.clickByText("SUNMI");
        CommonAction.clickByText("继续");
        CommonAction.clickByText("拼音");
        CommonAction.clickByText("确定");
        CommonAction.setText("sunmi388");
        CommonAction.clickByText("连接");

        CommonAction.clickByText("下一步");
    }

    @Test
    public void test001apktegother() throws RemoteException {
        TestUtils.checkScreenStatus();   //亮屏，保证可用
        TestUtils.clearAllRecentApps();  //杀掉已启动应用
        int k = UiobjectFinder.findByText("设置").getVisibleBounds().centerX(); //定位“设置”横坐标
        int g = UiobjectFinder.findByText("设置").getVisibleBounds().centerY(); //定位“设置”纵坐标
        Point kgs = new Point(k,g);
        UiobjectFinder.findByText("应用市场").drag(kgs,500);  //以500速度将“应用市场”拖动到“设置”所在坐标
        // UiObject2 Object = device.findObject(By.);
        int x = 100;
        int y = 100;   //百分比
        device.drag(k,g,x,y,100);  //以100步到达的速度将“设置”的坐标点移动到指定的坐标
        sleep(1000);
        device.findObjects(By.text("文件夹")).get(0).getParent().click(); //找到名称为“文件夹”的第一个对象，并点击
        int xx = device.getDisplayWidth()/2;
        int yy = 10;
        Point p = new Point(xx,yy);
        UiobjectFinder.findByText("应用市场").drag(p,500);  //将“应用市场”拖动到指定坐标点
        sleep(1000);
        UiobjectFinder.findByText("设置").drag(kgs,400);  //将“设置”拖动到指定坐标点

    }


    @Test
    public void test003apkdelete(){
        int x = device.getDisplayWidth()/2;
        int y = 10;
        Point p = new Point(x,y);
        UiobjectFinder.findByText("Opera Mini").drag(p,500);  //将应用拖动到指定坐标点
        CommonAction.clickByText("删除");   // 点击删除
        UiObject2 uiObject2 = UiobjectFinder.findByText("Opera Mini");  //返回对象
        Assert.assertNull("应用未删除",uiObject2);  //判断是否删除
    }
}
