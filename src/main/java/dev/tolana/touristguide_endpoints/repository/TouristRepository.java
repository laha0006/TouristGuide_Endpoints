package dev.tolana.touristguide_endpoints.repository;

import dev.tolana.touristguide_endpoints.model.TouristAttraction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TouristRepository {
    private List<TouristAttraction> attractionList;

    public TouristRepository() {
        attractionList = new ArrayList<>();
        attractionList.add(new TouristAttraction("DenLilleFede",
                "Fine dining når det er bedst."));
        attractionList.add(new TouristAttraction("McD","Best coffee after Wine Course"));

    }

    public List<TouristAttraction> getAll() {
        return attractionList;
    }

    public TouristAttraction getAttraction(String name) {
        for(TouristAttraction ta : attractionList) {
            if (ta.getName().equalsIgnoreCase(name)) {
                return ta;
            }
        }
        return null;
    }
}
