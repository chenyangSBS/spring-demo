package com.example.springdemo.vo;


import com.example.springdemo.entity.QuoteEntity;

import java.util.Objects;

public class QuoteVO {

    public String type;
    public QuoteEntity value;

    public QuoteVO(QuoteEntity value, String type) {

        this.value = value;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public QuoteEntity getValue() {
        return value;
    }

    public void setValue(QuoteEntity value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof QuoteVO))
            return false;
        QuoteVO that = (QuoteVO) o;
        return Objects.equals(type, that.type) && Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, value);
    }

    @Override
    public String toString() {
        return "QuoteResource{" + "type='" + type + '\'' + ", value=" + value + '}';
    }
}