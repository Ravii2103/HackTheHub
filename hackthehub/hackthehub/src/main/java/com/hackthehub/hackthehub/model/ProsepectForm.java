package com.hackthehub.hackthehub.model;

import lombok.Value;

@Value
public class ProsepectForm {

    String contractType;
    String name;
    String gender;
    String address;
    Double amountPpm;

}
