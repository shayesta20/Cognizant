interface Notifier {
    void send(String message);
}

class EmailNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Email sent: " + message);
    }
}

abstract class NotifierDecorator implements Notifier {
    protected final Notifier wrappedNotifier;

    protected NotifierDecorator(Notifier notifier) {
        this.wrappedNotifier = notifier;
    }
}

class SMSNotifierDecorator extends NotifierDecorator {
    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        wrappedNotifier.send(message);
        System.out.println("SMS sent: " + message);
    }
}

class SlackNotifierDecorator extends NotifierDecorator {
    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        wrappedNotifier.send(message);
        System.out.println("Slack message sent: " + message);
    }
}

public class DecoratorTest {
    public static void main(String[] args) {
        Notifier notifier = new EmailNotifier();
        notifier = new SMSNotifierDecorator(notifier);
        notifier = new SlackNotifierDecorator(notifier);

        notifier.send("Your invoice is ready.");
    }
}
