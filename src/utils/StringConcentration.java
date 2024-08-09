/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

/**
 *
 * @author kongh
 */
public class StringConcentration {
    public static String getConcentrateStringForSQL(String[] string){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < string.length; i++) {
            result.append(string[i]);
            if (i < string.length - 1) {
                result.append(",");
            }
        }
        return new String(result);
    }
}
