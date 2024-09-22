/*
  This class represents an Address which implements Serializable.
  It includes fields for street, postcode, and district, along with
  methods to access and compare these fields.
 */

package ProjectNo1;
import java.io.Serializable;

public class Address implements Serializable { 

    private String postcode;
    private String district;
    private String street;

    
     // Constructor to initialize the Address object.

    public Address(String street, String postcode, String district) {
        this.street = street;
        this.postcode = postcode;
        this.district = district;
    }

    
    // Compares this Address object with another Address object to check equality.
    
    public boolean equals(Address otherAddress) {
        return this.street.equals(otherAddress.street) &&
               this.postcode.equals(otherAddress.postcode) &&
               this.district.equals(otherAddress.district);
    }

    
    //Gets the street name of the Address.
    
    public String getStreet() {  
        return street;
    }


    //Gets the postcode of the Address.
     
    public String getPostcode() {
        return postcode;
    }


    // Gets the district name of the Address.
    
    public String getDistrict() {
        return district;
    }


    // Provides a string representation of the Address.
     
    // public String toString() {
    //     return "Address: " + "\n" + 
    //            "  Street: " + street + "\n" + 
    //            "  Postcode: " + postcode + "\n" + 
    //            "  District: " + district + "\n";
    // }
}
