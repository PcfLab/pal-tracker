package io.pivotal.pal.tracker;

import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTimeEntryRepository implements  TimeEntryRepository{

    Map<Long, TimeEntry> timeEntryMap = new HashMap<>();

    public Map<Long, TimeEntry> getTimeEntryMap() {
        return timeEntryMap;
    }

    public void setTimeEntryMap(Map<Long, TimeEntry> timeEntryMap) {
        this.timeEntryMap = timeEntryMap;
    }





    public TimeEntry find(long timeEntryId) {
        return this.getTimeEntryMap().get(timeEntryId);



    }


    public TimeEntry update(long id, TimeEntry timeEntry) {
        timeEntry.setId(id);


        this.getTimeEntryMap().put(id,
                timeEntry);
              return  timeEntry;
    }

    public TimeEntry create(TimeEntry timeEntry) {


        Integer id = 0;
        if (this.timeEntryMap.isEmpty()) {
           id = 1;
         }else {
            id = this.getTimeEntryMap().size() + 1;
         }
        timeEntry.setId(id.longValue());


        this.getTimeEntryMap().put(timeEntry.getId(),
                 timeEntry);
        return  timeEntry;
    }

   

    public void delete(long id) {
        this.getTimeEntryMap().remove(id);

    }

    public  List<TimeEntry> list() {

        List<TimeEntry> listTimeEntries = new ArrayList<>();

        this.getTimeEntryMap().forEach((id, timeEntry) -> {

           listTimeEntries.add(timeEntry);
                 });

return listTimeEntries;
    }
}