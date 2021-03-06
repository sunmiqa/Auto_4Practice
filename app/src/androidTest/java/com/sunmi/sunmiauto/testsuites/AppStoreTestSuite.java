package com.sunmi.sunmiauto.testsuites;

import android.os.RemoteException;

import org.junit.BeforeClass;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import java.io.IOException;

import com.sunmi.sunmiauto.testcases.SunmiAppStore_v3_3_15;
import com.sunmi.sunmiauto.testutils.TestUtils;
import com.sunmi.sunmiauto.testcategory.CategoryAppStoreTests_v3_3_15;

/**
 * Created by fengy on 2017/7/24.
 */

@RunWith(Categories.class)
@Suite.SuiteClasses(SunmiAppStore_v3_3_15.class)
@Categories.IncludeCategory(CategoryAppStoreTests_v3_3_15.class)
public final class AppStoreTestSuite {
    @BeforeClass
    public static void setUp() throws IOException, RemoteException {
        TestUtils.initLiza();
    }
}
