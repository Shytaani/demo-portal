package com.shytaani.demoportal.login.entity;

import java.util.List;

public record LoginUser(String name, String password, List<String> roles) {}
