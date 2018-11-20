import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class csvParser {

    public static ArrayList<Person> personList = new ArrayList<>();
    public static ArrayList<HashMap> mapLists = new ArrayList<>();
    public static ArrayList<Integer> ageList = new ArrayList<>();

    public static void csvParse() {

        String[] dataRows = RawData.fullData.split("\n");             //separate string by line

        for (int i = 0; i < dataRows.length; i++) {                   //loop through each row
            String[] splitDataRow = dataRows[i].split(",");       //splits each row at commas

            if (i == 0) {
                for (int j = 0; j < splitDataRow.length; j++) {
                    mapLists.add(PersonMethods.createMap());
                }
            }

            if (i > 0) {
                Person person = new Person();

                String name = splitDataRow[0];
                person.setName(name);
                PersonMethods.addToMap(mapLists.get(0), name);

                String age = splitDataRow[1];
                person.setAge(age);
                PersonMethods.addToMap(mapLists.get(1), age);
                ageList.add(Integer.parseInt(age));


                String city = splitDataRow[2];
                person.setCity(city);
                PersonMethods.addToMap(mapLists.get(2), city);

                String state = splitDataRow[3];
                person.setState(state);
                PersonMethods.addToMap(mapLists.get(3), state);

                String zipCode = splitDataRow[4];
                person.setZipCode(zipCode);
                PersonMethods.addToMap(mapLists.get(4), zipCode);

                if (splitDataRow.length > 5) {
                    String industry = splitDataRow[5];
                    person.setIndustry(industry);
                    PersonMethods.addToMap(mapLists.get(5), person.getIndustry());

                    if (splitDataRow.length > 6) {
                        String searching = splitDataRow[6];
                        person.setSearching(searching);
                        PersonMethods.addToMap(mapLists.get(6), String.valueOf(person.getSearching()));
                    }
                }

                personList.add(person);
            }
        }

    }
}
