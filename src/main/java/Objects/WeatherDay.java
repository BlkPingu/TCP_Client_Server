package Objects;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

public class WeatherDay {
    private SimpleDateFormat date;
    private List<Integer> temps;

    public WeatherDay(SimpleDateFormat date, List<Integer> temps) {
        this.temps = temps;
        this.date = date;
    }

    public Integer getMaxTemp() {
        return Collections.max(this.temps);
    }

    public Integer getMinTemp() {
        return temps.indexOf(Collections.min(temps));
    }

    private Double getAvgTemp() {
        return (double) temps.stream().mapToInt(Integer::intValue).sum()  /24;
    }

    @Override
    public String toString() {
        return "WeatherDay{" +
                "date=" + date +
                ", temps=" + temps +
                ", max=" + getMaxTemp() +
                ", min=" + getMinTemp() +
                ", avg=" + getAvgTemp() +
                '}';
    }
}