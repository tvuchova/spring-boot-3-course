package com.elsys.demo.solid.openForExtention;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {

        Piano piano = new Piano("Grand Piano", "Yamaha", "Acoustic");
        CoolPiano coolPiano = new CoolPiano("Cool Grand Piano", "Yamaha", "Electric", true);

        log.info("Piano: " + piano.getName() + ", Brand: " + piano.getBrand());
        log.info("CoolPiano: " + coolPiano.getName() + ", Cool: " + coolPiano.isCool());
    }
}
