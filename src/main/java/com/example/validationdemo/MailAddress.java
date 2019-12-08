package com.example.validationdemo;


import javax.validation.constraints.NotBlank;

public class MailAddress {

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @NotBlank(groups = {AlphaGroup.class}, message = "メールアドレスは必須です。")
    String text;

}
