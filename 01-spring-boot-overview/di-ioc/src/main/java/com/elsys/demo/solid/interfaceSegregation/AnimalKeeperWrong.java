package com.elsys.demo.solid.interfaceSegregation;


//Violates Interface Segregation Principle
public interface AnimalKeeperWrong {
    void washTheAnimal();

    void feedTheAnimal();

    void petTheAnimal();

}
