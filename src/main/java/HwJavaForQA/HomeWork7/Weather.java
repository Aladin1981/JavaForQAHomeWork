package HwJavaForQA.HomeWork7;

public class Weather {
    private String place;
    private String data;
    private String temp;

    public Weather(String place, String data, String temp) {
        this.place = place;
        this.data = data;
        this.temp = temp;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }
}
