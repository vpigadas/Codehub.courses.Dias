package com.dias.course.list;

import java.util.Objects;

public class UiModel {

    private String name;
    private String desc;

    public UiModel() {
        name = "";
        desc = "";
    }

    public UiModel(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UiModel uiModel = (UiModel) o;
        return Objects.equals(name, uiModel.name) && Objects.equals(desc, uiModel.desc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, desc);
    }

    @Override
    public String toString() {
        return "UiModel{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
