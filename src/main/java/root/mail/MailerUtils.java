package root.mail;

import java.util.Map;

import javax.mail.MessagingException;

import org.karatachi.mail.Mailer;

public class MailerUtils {
    private static final Mailer INSTANCE;
    static {
        INSTANCE =
                new Mailer("localhost", "wicket@localhost.localdomain",
                        "wicket");
        INSTANCE.loadTemplate(MailerUtils.class.getResourceAsStream("template.txt"));
    }

    public static void sendmail(String to, String cc, String bcc,
            String subject, String text) throws MessagingException {
        INSTANCE.sendmail(to, cc, bcc, subject, text);
    }

    public static void sendmail(String to, String cc, String bcc, String key,
            Map<String, String> variables) throws MessagingException {
        INSTANCE.sendmail(to, cc, bcc, key, variables);
    }
}
