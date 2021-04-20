package HwJavaForQA.HomeWork7;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import java.io.IOException;
import java.sql.*;
import java.sql.Connection;

public class WeatherYandexApi {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        OkHttpClient okHttpClient= new OkHttpClient();
        MediaType JSON = MediaType.parse("JSON");
        String APIKEY = "f3427000-9a2f-4762-89a9-6133c1a40baa";

        String weatherBodyString = "{" +
                ""+
                "}";
        System.out.println(weatherBodyString);

        RequestBody requestBody = RequestBody.create(weatherBodyString, JSON);

        Request requestWeather = new Request.Builder()
                .url("https://api.weather.yandex.ru/v2/forecast?")
                .addHeader("X-Yandex-API-Key",APIKEY)
                .addHeader("Content-Type", "application/json")
                .get()
                .build();
        Response response = okHttpClient.newCall(requestWeather).execute();
        String body = response.body().string();
        System.out.println("Response code - " + response.code());
        System.out.println(body);
        System.out.println("Place: " + objectMapper.readTree(body).at("/info/tzinfo/name"));
        System.out.println("Data: " + objectMapper.readTree(body).at("/now_dt"));
        System.out.println("Temperature: " + objectMapper.readTree(body).at("/fact/temp"));

        Weather weather = new Weather(String.valueOf(objectMapper.readTree(body).at("/info/tzinfo/name")),
                String.valueOf(objectMapper.readTree(body).at("/now_dt")),
                String.valueOf(objectMapper.readTree(body).at("/fact/temp")));

        System.out.println("Place: "+ weather.getPlace()+"Temperature: " + weather.getTemp()+"Data: "+weather.getData());

//        JsonNode  jPlace = objectMapper.readTree(body).at("/info/tzinfo/name");
//        JsonNode  jData = objectMapper.readTree(body).at("/now_dt");
//        JsonNode jTemp = objectMapper.readTree(body).at("/fact/temp");








        Connection connection = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:weather.db");
//            connection.setAutoCommit(true);
            preparedStatement = connection.prepareStatement("insert into temperature1 (place, data, temp) values (?,?,?)");
            preparedStatement.setString(1, weather.getPlace());
            preparedStatement.setString(2, weather.getData());
            preparedStatement.setString(3, weather.getTemp());
            preparedStatement.addBatch();


//            ResultSet resultSet = statement.executeQuery("select * from temperature1");
//            while (resultSet.next()) {
//               // System.out.print(resultSet.getInt("id"));
//                System.out.print(" ");
//                System.out.println(resultSet.getString("place"));
//                System.out.print("");
//                System.out.println(resultSet.getString("data"));
//                System.out.print("");
//                System.out.println(resultSet.getString("temp"));
//            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
//        finally {
//            connection.close();
//            statement.close();
//            preparedStatement.close();
//        }


//
//      // System.out.println("Data: " + data);
//       JsonNode jsonNode1 = objectMapper.readTree(body).at("/hours"); //Добрались до элемента Temperature, записали массив, который лежит в нем, в jsonNode
//        for (JsonNode node : jsonNode1) {                              // перебрать элементы этого массива
//           node.get(0).at("/hour").asText();
//            System.out.println(node.get(0).at("/hours/hour").asText());
//       }
    }
}
