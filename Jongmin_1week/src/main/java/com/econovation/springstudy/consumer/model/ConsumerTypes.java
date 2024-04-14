package com.econovation.springstudy.consumer.model;

public enum ConsumerTypes {

    OFFICIAL("official"),
    NON_OFFICIAL("non-official");

    private String consumerType;
    ConsumerTypes(String consumerType){this.consumerType = consumerType;}

    public String getConsumerType(){return consumerType;}
}
