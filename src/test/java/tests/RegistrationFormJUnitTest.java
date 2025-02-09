package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;
import utils.RandomUtils;

@Tag("demoqa")
public class RegistrationFormJUnitTest extends TestBase {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    RandomUtils randomUtils = new RandomUtils();

    @Test
    void successfulRegistrationFormJUnitTest() {
        registrationFormPage.openPage()
                .removeBanner()
                .setFirstName(randomUtils.firstName)
                .setLastName(randomUtils.lastName)
                .setUserEmail(randomUtils.useremail)
                .setGender(randomUtils.gender)
                .setUserNumber(randomUtils.usernumber)
                .setDateOfBirth(randomUtils.day, randomUtils.month, randomUtils.year)
                .setHobbies(randomUtils.hobbie)
                .setSubject(randomUtils.subject)
                .uploadPicture(randomUtils.picture)
                .setCurrentAddress(randomUtils.userAddress)
                .setState(randomUtils.state)
                .setCity(randomUtils.city)
                .submitForm()
                .checkResults("Student Name", randomUtils.firstName + " " + randomUtils.lastName)
                .checkResults("Student Email", randomUtils.useremail)
                .checkResults("Gender", randomUtils.gender)
                .checkResults("Mobile", randomUtils.usernumber)
                .checkResults("Date of Birth", randomUtils.day + " " + randomUtils.month + "," + randomUtils.year)
                .checkResults("Subjects", randomUtils.subject)
                .checkResults("Hobbies", randomUtils.hobbie)
                .checkResults("Picture", randomUtils.picture)
                .checkResults("Address", randomUtils.userAddress)
                .checkResults("State and City", randomUtils.city);
    }

    @Test
    void minimumAmountOfInformationForRegistrationJUnitTest() {
        registrationFormPage.openPage()
                .removeBanner()
                .setFirstName(randomUtils.firstName)
                .setLastName(randomUtils.lastName)
                .setGender(randomUtils.gender)
                .setUserNumber(randomUtils.usernumber)
                .submitForm()
                .checkResults("Student Name", randomUtils.firstName + " " + randomUtils.lastName)
                .checkResults("Gender", randomUtils.gender)
                .checkResults("Mobile", randomUtils.usernumber);
    }

    @Test
    void negativeCheckJUnitTest() {
        registrationFormPage.openPage()
                .removeBanner()
                .setFirstName(randomUtils.firstName)
                .setLastName(randomUtils.lastName)
                .setGender(randomUtils.gender)
                .setUserNumber(randomUtils.wrongusernumber)
                .submitForm()
                .responseTable()
                .setUserNumber(randomUtils.usernumber)
                .submitForm()
                .checkResults("Student Name", randomUtils.firstName + " " + randomUtils.lastName)
                .checkResults("Gender", randomUtils.gender)
                .checkResults("Mobile", randomUtils.usernumber);

    }
}