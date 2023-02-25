import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import java.io.File;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.selector.ByText;
import static com.codeborne.selenide.conditions.Text.text;
import static com.codeborne.selenide.Selenide.*;


public class DemoQAForm {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1000x700";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
        Configuration.browserPosition = "0x0";
                    }

    @Test
    void fillFormTest() {
        File jpg = new File("src/test/resources/neon_lights.jpg");
        open("/automation-practice-form");
        executeJavaScript("const footer = document.querySelector('footer'); footer.setAttribute('hidden', '');");
        $("#firstName").setValue("Vasiliy");
        $("#lastName").setValue("Starnov");
        $("#userEmail").setValue("vasiliy.starnov@mail.com");
        $("label[for=gender-radio-1]").click();
        $("input#userNumber").clear();
        $("input#userNumber").setValue("88005553535");
        $("#dateOfBirthInput").setValue("12.12.1991").pressEnter();
        $("input#subjectsInput").setValue("Compute").pressEnter();
        $("label[for=hobbies-checkbox-2]").click();
        $("input#uploadPicture").uploadFile(jpg);
        $("textarea#currentAddress").setValue("sdfsdfsdf");
        $("div#state").click();
        $(new ByText("NCR")).click();
        $("div#city").click();
        $(new ByText("Noida")).click();
        $("div#city").click();
        $("button#submit").pressEnter();
    }
    @Test
    void validateFormFill() {
        $("table.table").shouldHave(text("Vasiliy Starnov"));
        $("table.table").shouldHave(text("vasiliy.starnov@mail.com"));
        $("table.table").shouldHave(text("Male"));
        $("table.table").shouldHave(text("8800555353"));
        $("table.table").shouldHave(text("25 February,202312"));
        $("table.table").shouldHave(text("Computer Science"));
        $("table.table").shouldHave(text("Reading"));
        $("table.table").shouldHave(text("neon_lights.jpg"));
        $("table.table").shouldHave(text("sdfsdfsdf"));
        $("table.table").shouldHave(text("NCR Noida"));

    }
}
