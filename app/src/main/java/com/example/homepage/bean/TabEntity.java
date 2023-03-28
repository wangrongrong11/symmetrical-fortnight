package com.example.homepage.bean;

public class TabEntity {
    private String title;
    private int selectedIcon;
    private int unSelectIcon;

    public TabEntity(String title, int selectedIcon, int unSelectedIcon) {
        this.title = title;
        this.selectedIcon = selectedIcon;
        this.unSelectIcon = unSelectedIcon;
    }

    public String getTitle() {
        return title;
    }

    public int getSelectedIcon() {
        return selectedIcon;
    }

    public int getUnSelectIcon() {
        return unSelectIcon;
    }
}
