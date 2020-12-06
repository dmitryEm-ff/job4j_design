package ru.job4j.serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import netscape.javascript.JSObject;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Arrays;

public class CarJson {
    private boolean gas;
    private int yearOfManufacture;
    private CarParam carParam;
    private String[] carOwner;

    public CarJson() {
    }

    public CarJson(boolean gas, int yearOfManufacture, CarParam carParam, String... carOwner) {
        this.gas = gas;
        this.yearOfManufacture = yearOfManufacture;
        this.carParam = carParam;
        this.carOwner = carOwner;
    }

    public boolean getGas() {
        return gas;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public CarParam getCarParam() {
        return carParam;
    }

    public String[] getCarOwner() {
        return carOwner;
    }

    @Override
    public String toString() {
        return "CarJson{" + "gas=" + gas + ", yearOfManufacture=" + yearOfManufacture
                + ", carParam=" + carParam + ", carOwner=" + Arrays.toString(carOwner) + '}';
    }

    public static void main(String[] args) {
        CarJson carJson = new CarJson(true, 2012,
                new CarParam("Lada", "white"), "Igor", "Denis", "Vitaly");

        JSONArray jsonArray = new JSONArray(carJson.getCarOwner());
        JSONObject carBrandNColor = new JSONObject("{\"brand\":\"Lada\"}, {\"color\":\"white\"}");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("gas", carJson.getGas());
        jsonObject.put("yearOfManufacture", carJson.getYearOfManufacture());
        jsonObject.put("carParam", carJson.getCarParam());
        jsonObject.put("carOwner", carJson.getCarOwner());

        System.out.println(jsonObject.toString());

        System.out.println(new JSONObject(carJson).toString());
//        final Gson gson = new GsonBuilder().create();
//        System.out.println(gson.toJson(carJson));
//
//        final String carJsonMod = "{"
//                + "\"gas\":false,"
//                + "\"yearOfManufacture\":2016,"
//                + "\"carParam\":"
//                + "{"
//                + "\"brand\":\"Niva\","
//                + "\"color\":\"black\""
//                + "},"
//                + "\"carOwner\":"
//                + "[\"Vanya\",\"Olya\",\"Masha\"]"
//                + "}";
//
//        final CarJson carJsonChanged = gson.fromJson(carJsonMod, CarJson.class);
//        System.out.println(carJsonChanged);
    }
}