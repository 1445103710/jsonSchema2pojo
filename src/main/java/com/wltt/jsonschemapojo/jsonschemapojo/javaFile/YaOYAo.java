
package com.wltt.jsonschemapojo.jsonschemapojo.javaFile;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "YaO_YAo")
public class YaOYAo {

    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("name")
    @Expose
    @Size(min = 2, max = 10)
    @NotNull
    private String name;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("age")
    @Expose
    @NotNull
    private String age;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("love")
    @Expose
    @NotNull
    private String love;

    /**
     * 
     * (Required)
     * 
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * (Required)
     * 
     */
    public String getAge() {
        return age;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setAge(String age) {
        this.age = age;
    }

    /**
     * 
     * (Required)
     * 
     */
    public String getLove() {
        return love;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setLove(String love) {
        this.love = love;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(YaOYAo.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("age");
        sb.append('=');
        sb.append(((this.age == null)?"<null>":this.age));
        sb.append(',');
        sb.append("love");
        sb.append('=');
        sb.append(((this.love == null)?"<null>":this.love));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.name == null)? 0 :this.name.hashCode()));
        result = ((result* 31)+((this.love == null)? 0 :this.love.hashCode()));
        result = ((result* 31)+((this.age == null)? 0 :this.age.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof YaOYAo) == false) {
            return false;
        }
        YaOYAo rhs = ((YaOYAo) other);
        return ((((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name)))&&((this.love == rhs.love)||((this.love!= null)&&this.love.equals(rhs.love))))&&((this.age == rhs.age)||((this.age!= null)&&this.age.equals(rhs.age))));
    }

}
