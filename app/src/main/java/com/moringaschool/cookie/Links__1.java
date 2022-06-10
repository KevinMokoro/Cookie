
package com.moringaschool.cookie;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Links__1 {

    @SerializedName("self")
    @Expose
    private Self__1 self;
    @SerializedName("next")
    @Expose
    private Next__1 next;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Links__1() {
    }

    /**
     * 
     * @param next
     * @param self
     */
    public Links__1(Self__1 self, Next__1 next) {
        super();
        this.self = self;
        this.next = next;
    }

    public Self__1 getSelf() {
        return self;
    }

    public void setSelf(Self__1 self) {
        this.self = self;
    }

    public Next__1 getNext() {
        return next;
    }

    public void setNext(Next__1 next) {
        this.next = next;
    }

}
