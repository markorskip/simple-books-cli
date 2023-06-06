package io.efficientsoftware.simplebookscli;

import io.efficientsoftware.simplebookscli.model.Event;
import io.efficientsoftware.simplebookscli.model.MileageEvent;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class MockDataCreator {

    public static Set<Event> getSampleSet() {
        Set<Event> result = new HashSet<>();
        EasyRandom generator = new EasyRandom();
        generator.objects(MileageEvent.class, 10).forEach(
                e->result.add(e)
        );
        return result;
    }

    public static MileageEvent getMileageEvent() {
        EasyRandomParameters parameters = new EasyRandomParameters();
        parameters.seed(LocalDateTime.now().hashCode());
        EasyRandom generator = new EasyRandom(parameters);
        return generator.nextObject(MileageEvent.class);
    }


    public Set<Event> completeSetOfEvents() {
        Set<Event> result = new HashSet<>();
        result.add(getMileageEvent());
        result.add(getMileageEvent());



        return result;

    }



}
