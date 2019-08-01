
package com.yaoyao.jsonschemapojo.javaFile;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


/**
 * empty object
 * <p>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "tebie_yao")
public class TebieYao {

    @XmlElement(name = "YaO_YAo")
    @SerializedName("YaO_YAo")
    @Expose
    @Valid
    private YaOYAo yaOYAo;
    /**
     * 
     * (Required)
     * 
     */
    @XmlElement(name = "Xml_json_DX")
    @SerializedName("Xml_json_DX")
    @Expose
    @NotNull
    private String xmlJsonDX;
    @SerializedName("copy")
    @Expose
    private String copy;
    /**
     * 
     * (Required)
     * 
     */
    @XmlElement(name = "class")
    @SerializedName("class")
    @Expose
    @NotNull
    private String _class;

    public YaOYAo getYaOYAo() {
        return yaOYAo;
    }

    public void setYaOYAo(YaOYAo yaOYAo) {
        this.yaOYAo = yaOYAo;
    }

    /**
     * 
     * (Required)
     * 
     */
    public String getXmlJsonDX() {
        return xmlJsonDX;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setXmlJsonDX(String xmlJsonDX) {
        this.xmlJsonDX = xmlJsonDX;
    }

    public String getCopy() {
        return copy;
    }

    public void setCopy(String copy) {
        this.copy = copy;
    }

    /**
     * 
     * (Required)
     * 
     */
    public String getClass_() {
        return _class;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setClass_(String _class) {
        this._class = _class;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TebieYao.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("yaOYAo");
        sb.append('=');
        sb.append(((this.yaOYAo == null)?"<null>":this.yaOYAo));
        sb.append(',');
        sb.append("xmlJsonDX");
        sb.append('=');
        sb.append(((this.xmlJsonDX == null)?"<null>":this.xmlJsonDX));
        sb.append(',');
        sb.append("copy");
        sb.append('=');
        sb.append(((this.copy == null)?"<null>":this.copy));
        sb.append(',');
        sb.append("_class");
        sb.append('=');
        sb.append(((this._class == null)?"<null>":this._class));
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
        result = ((result* 31)+((this.copy == null)? 0 :this.copy.hashCode()));
        result = ((result* 31)+((this._class == null)? 0 :this._class.hashCode()));
        result = ((result* 31)+((this.yaOYAo == null)? 0 :this.yaOYAo.hashCode()));
        result = ((result* 31)+((this.xmlJsonDX == null)? 0 :this.xmlJsonDX.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TebieYao) == false) {
            return false;
        }
        TebieYao rhs = ((TebieYao) other);
        return (((((this.copy == rhs.copy)||((this.copy!= null)&&this.copy.equals(rhs.copy)))&&((this._class == rhs._class)||((this._class!= null)&&this._class.equals(rhs._class))))&&((this.yaOYAo == rhs.yaOYAo)||((this.yaOYAo!= null)&&this.yaOYAo.equals(rhs.yaOYAo))))&&((this.xmlJsonDX == rhs.xmlJsonDX)||((this.xmlJsonDX!= null)&&this.xmlJsonDX.equals(rhs.xmlJsonDX))));
    }

}
