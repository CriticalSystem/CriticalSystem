/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

/**
 *
 * @author s20163039
 */
@ManagedBean
public class RegisterItemBean {
    // 生年のMap
    private static Map<Integer, Integer> yearItems;

    static {
        yearItems = new LinkedHashMap<>();
        for (int i = 1900; i < 2018; i++) {
            yearItems.put(i, i);
        }
    }
    
    private static Map<Integer, Integer> monthItems;

    static {
        monthItems = new LinkedHashMap<>();
        for (int i = 1; i < 12; i++) {
            monthItems.put(i, i);
        }
    }
    
    private static Map<Integer, Integer> dayItems;

    static {
        dayItems = new LinkedHashMap<>();
        for (int i = 1; i < 31; i++) {
            dayItems.put(i, i);
        }
    }

    public static Map<Integer, Integer> getYearItems() {
        return yearItems;
    }

    public static void setYearItems(Map<Integer, Integer> yearItems) {
        RegisterItemBean.yearItems = yearItems;
    }

    public static Map<Integer, Integer> getMonthItems() {
        return monthItems;
    }

    public static void setMonthItems(Map<Integer, Integer> monthItems) {
        RegisterItemBean.monthItems = monthItems;
    }

    public static Map<Integer, Integer> getDayItems() {
        return dayItems;
    }

    public static void setDayItems(Map<Integer, Integer> dayItems) {
        RegisterItemBean.dayItems = dayItems;
    }
    
}
