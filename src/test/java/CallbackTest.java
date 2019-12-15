import com.codeborne.selenide.*;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class CallbackTest {
    @Test
    void shouldSubmitRequest() throws InterruptedException {
        open("http://localhost:9999");
        SelenideElement form = $("[class='form form_size_m form_theme_alfa-on-white']");
        form.$("[data-test-id=name] input").setValue("Василий");
        form.$("[data-test-id=phone] input").setValue("+79270000000");
        form.$("[data-test-id=agreement]").click();
        form.$("[class='button button_view_extra button_size_m button_theme_alfa-on-white']").click();
        $("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

}
