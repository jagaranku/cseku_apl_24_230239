/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProjectNo1;

import java.io.*;
public class Adress implements Serializable {
    private String street;
    private String postcode;
    private String district;

    public Adress(String st,String pc,String dist)
    {
        street=st;
        postcode=pc;
        district=dist;
    }
    public boolean equals(Adress ad)
    {
        return this.street.equals(ad.street) && this.postcode.equals((ad.postcode)) && this.district.equals(ad.district);
    }
    public  String getRoad()
    {
        return street;
    }
    public  String getPostcode()
    {
        return postcode;
    }
    public  String getDistrict()
    {
        return district;
    }
//    public String toString()
//    {
//        return "Adress : " + "\n" + "        Road : " + street + "\n" + "        Postcode : " + postcode + "\n" + "        District : " + district + "\n";
//    }
}
