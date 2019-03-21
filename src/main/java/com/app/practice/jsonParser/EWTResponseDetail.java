
package com.app.practice.jsonParser;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.sun.istack.internal.NotNull;


/**
 * EWT Response Detail
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "aqt",
    "calls",
    "clc",
    "ewt",
    "hit",
    "pos",
    "time",
    "wcalls",
    "wpos",
    "wt"
})
public class EWTResponseDetail {

    /**
     * The Aqt Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("aqt")
    @NotNull
    private Double aqt;
    /**
     * The Calls Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("calls")
    @NotNull
    private Integer calls;
    /**
     * The Clc Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("clc")
    @NotNull
    private String clc;
    /**
     * The Ewt Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("ewt")
    @NotNull
    private Double ewt;
    /**
     * The Hit Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("hit")
    @NotNull
    private Integer hit;
    /**
     * The Pos Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("pos")
    @NotNull
    private Integer pos;
    /**
     * The Time Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("time")
    @NotNull
    private Integer time;
    /**
     * The Wcalls Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("wcalls")
    @NotNull
    private Integer wcalls;
    /**
     * The Wpos Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("wpos")
    @NotNull
    private Integer wpos;
    /**
     * The Wt Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("wt")
    @NotNull
    private Integer wt;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * The Aqt Schema
     * <p>
     * 
     * (Required)
     * 
     * @return
     *     The aqt
     */
    @JsonProperty("aqt")
    public Double getAqt() {
        return aqt;
    }

    /**
     * The Aqt Schema
     * <p>
     * 
     * (Required)
     * 
     * @param aqt
     *     The aqt
     */
    @JsonProperty("aqt")
    public void setAqt(Double aqt) {
        this.aqt = aqt;
    }

    /**
     * The Calls Schema
     * <p>
     * 
     * (Required)
     * 
     * @return
     *     The calls
     */
    @JsonProperty("calls")
    public Integer getCalls() {
        return calls;
    }

    /**
     * The Calls Schema
     * <p>
     * 
     * (Required)
     * 
     * @param calls
     *     The calls
     */
    @JsonProperty("calls")
    public void setCalls(Integer calls) {
        this.calls = calls;
    }

    /**
     * The Clc Schema
     * <p>
     * 
     * (Required)
     * 
     * @return
     *     The clc
     */
    @JsonProperty("clc")
    public String getClc() {
        return clc;
    }

    /**
     * The Clc Schema
     * <p>
     * 
     * (Required)
     * 
     * @param clc
     *     The clc
     */
    @JsonProperty("clc")
    public void setClc(String clc) {
        this.clc = clc;
    }

    /**
     * The Ewt Schema
     * <p>
     * 
     * (Required)
     * 
     * @return
     *     The ewt
     */
    @JsonProperty("ewt")
    public Double getEwt() {
        return ewt;
    }

    /**
     * The Ewt Schema
     * <p>
     * 
     * (Required)
     * 
     * @param ewt
     *     The ewt
     */
    @JsonProperty("ewt")
    public void setEwt(Double ewt) {
        this.ewt = ewt;
    }

    /**
     * The Hit Schema
     * <p>
     * 
     * (Required)
     * 
     * @return
     *     The hit
     */
    @JsonProperty("hit")
    public Integer getHit() {
        return hit;
    }

    /**
     * The Hit Schema
     * <p>
     * 
     * (Required)
     * 
     * @param hit
     *     The hit
     */
    @JsonProperty("hit")
    public void setHit(Integer hit) {
        this.hit = hit;
    }

    /**
     * The Pos Schema
     * <p>
     * 
     * (Required)
     * 
     * @return
     *     The pos
     */
    @JsonProperty("pos")
    public Integer getPos() {
        return pos;
    }

    /**
     * The Pos Schema
     * <p>
     * 
     * (Required)
     * 
     * @param pos
     *     The pos
     */
    @JsonProperty("pos")
    public void setPos(Integer pos) {
        this.pos = pos;
    }

    /**
     * The Time Schema
     * <p>
     * 
     * (Required)
     * 
     * @return
     *     The time
     */
    @JsonProperty("time")
    public Integer getTime() {
        return time;
    }

    /**
     * The Time Schema
     * <p>
     * 
     * (Required)
     * 
     * @param time
     *     The time
     */
    @JsonProperty("time")
    public void setTime(Integer time) {
        this.time = time;
    }

    /**
     * The Wcalls Schema
     * <p>
     * 
     * (Required)
     * 
     * @return
     *     The wcalls
     */
    @JsonProperty("wcalls")
    public Integer getWcalls() {
        return wcalls;
    }

    /**
     * The Wcalls Schema
     * <p>
     * 
     * (Required)
     * 
     * @param wcalls
     *     The wcalls
     */
    @JsonProperty("wcalls")
    public void setWcalls(Integer wcalls) {
        this.wcalls = wcalls;
    }

    /**
     * The Wpos Schema
     * <p>
     * 
     * (Required)
     * 
     * @return
     *     The wpos
     */
    @JsonProperty("wpos")
    public Integer getWpos() {
        return wpos;
    }

    /**
     * The Wpos Schema
     * <p>
     * 
     * (Required)
     * 
     * @param wpos
     *     The wpos
     */
    @JsonProperty("wpos")
    public void setWpos(Integer wpos) {
        this.wpos = wpos;
    }

    /**
     * The Wt Schema
     * <p>
     * 
     * (Required)
     * 
     * @return
     *     The wt
     */
    @JsonProperty("wt")
    public Integer getWt() {
        return wt;
    }

    /**
     * The Wt Schema
     * <p>
     * 
     * (Required)
     * 
     * @param wt
     *     The wt
     */
    @JsonProperty("wt")
    public void setWt(Integer wt) {
        this.wt = wt;
    }



    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }


}
