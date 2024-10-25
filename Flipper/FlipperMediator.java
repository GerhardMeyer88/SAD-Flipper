package SAD.Flipper;

import SAD.Flipper.FlipperElements.FlipperElement;
import java.util.ArrayList;
import java.util.List;

public class FlipperMediator {
    private List<FlipperElement> elements = new ArrayList<>();
    private List<Target> targets = new ArrayList<>();

    public void register(FlipperElement element) {
        elements.add(element);
    }

    public void notify(String message) {
        for (FlipperElement element : elements) {
            element.receiveMessage(message);
        }

        if (message.equals("Rampe getroffen")) {
            if (targets.stream().allMatch(Target::isGetHit)) {
                notify("Alle Targets getroffen");
                targets.forEach(Target::resetHit);
            }
        }
    }
}
