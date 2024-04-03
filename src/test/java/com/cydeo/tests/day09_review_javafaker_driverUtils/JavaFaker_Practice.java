package com.cydeo.tests.day09_review_javafaker_driverUtils;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class JavaFaker_Practice {

    @Test
    public void test1(){

        //create Java Faker object
        Faker faker = new Faker();

        //Print out random first name using Faker object
        System.out.println("faker.name().firstName() = " + faker.name().firstName());

        //Print out a random last name using Faker object
        System.out.println("faker.name().lastName() = " + faker.name().lastName());

        System.out.println("faker.name().fullName() = " + faker.name().fullName());

        System.out.println("faker.address().city() = " + faker.address().city());

        System.out.println("faker.address().zipCode() = " + faker.address().zipCode());

        //numerify() method is used to generate digits with specific formatting
        System.out.println("faker.numerify(\"###-###-####\") = " + faker.numerify("###-###-####"));

        System.out.println("faker.numerify(\"732-###-####\") = " + faker.numerify("732-###-####"));

        //leterify() method is used to generate RANDOM letters with specific formatting
        System.out.println("faker.letterify(\"????-????-????\") = " + faker.letterify("????-????-????"));

        System.out.println("faker.bothify(\"?##?--##??__?#?#\") = " + faker.bothify("?##?--##??__?#?#"));

        //chuckNorris() method is used to create chuckNorris facts
        System.out.println("faker.chuckNorris().fact() = " + faker.chuckNorris().fact());

    }
}
