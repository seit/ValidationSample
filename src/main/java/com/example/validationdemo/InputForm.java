package com.example.validationdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;

public class InputForm {

    // text1が入力されていたらtext3のチェックを行う（入力されていなかったらチェックしない）

    @NotBlank(groups = {AlphaGroup.class, BetaGroup.class}, message = "text1を入力してください")
    String text1;

    String text2;

    @Valid
    @MailAddressFormat(groups = {BetaGroup.class})
    MailAddress mailAddress;

    // 相関チェック
    @AssertTrue(groups= {AlphaGroup.class},message = "text2を入力してください")
    public boolean isValid(){
        if(text1.isEmpty()) {
            // text1はNotBlankに任せる
           return true;
        }

        // text1が入力されている時はtext2もチェックする
        if(text2.isEmpty()){
            return false;
        }

        return true;
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }
//
//    public String getText3() {
//        return text3;
//    }
//
//    public void setText3(String text3) {
//        this.text3 = text3;
//    }

    public MailAddress getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(MailAddress mailAddress) {
        this.mailAddress = mailAddress;
    }
}
