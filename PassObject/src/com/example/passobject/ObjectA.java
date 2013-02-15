package com.example.passobject;

import android.os.Parcel;
import android.os.Parcelable;
 
/**
 * @author Shriram Shri Shrikumar
 *
 * A basic object that can be parcelled to
 * transfer between objects
 *
 */
public class ObjectA implements Parcelable {
 
	private String strValue;
	private int intValue;
 
	/**
	 * Standard basic constructor for non-parcel
	 * object creation
	 */
	public ObjectA() { ; };
 
	/**
	 *
	 * Constructor to use when re-constructing object
	 * from a parcel
	 *
	 * @param in a parcel from which to read this object
	 */
	public ObjectA(Parcel in) {
		readFromParcel(in);
	}
 
	/**
	 * standard getter
	 *
	 * @return strValue
	 */
	public String getStrValue() {
		return this.strValue;
	}
 
	/**
	 * Standard setter
	 *
	 * @param strValue
	 */
	public void setStrValue(String strValue) {
		this.strValue = strValue;
	}
 
	/**
	 * standard getter
	 *
	 * @return
	 */
	public int getIntValue() {
		return this.intValue;
	}
 
	/**
	 * Standard setter
	 *
	 * @param intValue
	 */
	public void setIntValue(int intValue) {
		this.intValue = intValue;
	}
 
	@Override
	public int describeContents() {
		return 0;
	}
 
	@Override
	public void writeToParcel(Parcel dest, int flags) {
 
		// We just need to write each field into the
		// parcel. When we read from parcel, they
		// will come back in the same order
		dest.writeString(this.strValue);
		dest.writeInt(this.intValue);
	}
 
	/**
	 *
	 * Called from the constructor to create this
	 * object from a parcel.
	 *
	 * @param in parcel from which to re-create object
	 */
	public void readFromParcel(Parcel in) {
 
		// We just need to read back each
		// field in the order that it was
		// written to the parcel
		this.strValue = in.readString();
		this.intValue = in.readInt();
	}
 
    /**
     *
     * This field is needed for Android to be able to
     * create new objects, individually or as arrays.
     *
     * This also means that you can use use the default
     * constructor to create the object and use another
     * method to hyrdate it as necessary.
     *
     * I just find it easier to use the constructor.
     * It makes sense for the way my brain thinks ;-)
     *
     */
    @SuppressWarnings("rawtypes")
	public static final Parcelable.Creator CREATOR =
    	new Parcelable.Creator() {
            public ObjectA createFromParcel(Parcel in) {
                return new ObjectA(in);
            }
 
            public ObjectA[] newArray(int size) {
                return new ObjectA[size];
            }
        };
 
}
