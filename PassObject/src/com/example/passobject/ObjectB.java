package com.example.passobject;

import android.os.Parcel;
import android.os.Parcelable;
 
public class ObjectB implements Parcelable {
 
	private ObjectA obj;
	private Long longVal;
 
	public ObjectB() { ; }
 
	public ObjectA getObj() {
		return obj;
	}
 
	/**
	 *
	 * Constructor to use when re-constructing object
	 * from a parcel
	 *
	 * @param in a parcel from which to read this object
	 */
	public ObjectB(Parcel in) {
		readFromParcel(in);
	}
 
	public void setObj(ObjectA obj) {
		this.obj = obj;
	}
 
	public Long getLongVal() {
		return longVal;
	}
 
	public void setLongVal(Long longVal) {
		this.longVal = longVal;
	}
 
	@Override
	public int describeContents() {
		return 0;
	}
 
	@Override
	public void writeToParcel(Parcel dest, int flags) {
 
		// The writeParcel method needs the flag
		// as well - but thats easy.
		dest.writeParcelable(obj, flags);
 
		// Same as in ObjectA
		dest.writeLong(longVal);
	}
 
	/**
	 *
	 * Called from the constructor to create this
	 * object from a parcel.
	 *
	 * @param in parcel from which to re-create object
	 */
	private void readFromParcel(Parcel in) {
 
		// readParcelable needs the ClassLoader
		// but that can be picked up from the class
		// This will solve the BadParcelableException
		// because of ClassNotFoundException
		obj = in.readParcelable(ObjectA.class.getClassLoader());
 
		// The rest is the same as in ObjectA
		longVal = in.readLong();
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
    public static final Parcelable.Creator CREATOR =
    	new Parcelable.Creator() {
            public ObjectB createFromParcel(Parcel in) {
                return new ObjectB(in);
            }
 
            public ObjectB[] newArray(int size) {
                return new ObjectB[size];
            }
        };
}
