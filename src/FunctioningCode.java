import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FunctioningCode {
    public static void main(String[] args) {
        csvParser.csvParse();

        HashMap<String, Integer> stateMap = csvParser.mapLists.get(3);
            System.out.println("The counts for each state are: " + csvParser.mapLists.get(3));

        String maxState = PersonMethods.maxFreqMap(stateMap).keySet().toArray()[0].toString();
        String minState = PersonMethods.minFreqMap(stateMap).keySet().toArray()[0].toString();
            System.out.println("The highest populated state is: " + maxState);
            System.out.println("The least populated state is: " + minState);

        ArrayList maxStatePop = PersonMethods.transform(PersonMethods.filter(csvParser.personList, PersonMethods.Attribute.STATE, maxState), PersonMethods.Attribute.NAME);
            System.out.println("The following people live in " + maxState + ": " + maxStatePop);



        HashMap<String, Integer> zipMap = csvParser.mapLists.get(4);
            System.out.println("The following frequencies of zip codes are represented: " + zipMap);

        HashMap<String, Integer> cityList = csvParser.mapLists.get(2);
            System.out.println("The following cities are represented: " + cityList.keySet());

        Person youngestPerson = PersonMethods.getMinAge(csvParser.personList);
        Person oldestPerson = PersonMethods.getMaxAge(csvParser.personList);
            System.out.println("The youngest person is: " + youngestPerson.getName() + ", at " + youngestPerson.getAge() + ".");
            System.out.println("The oldest person is: " + oldestPerson.getName() + ", at " + oldestPerson.getAge() + ".");

        HashMap<String, Integer> industryMap = csvParser.mapLists.get(5);
            System.out.println("The number of people in each industry: " + industryMap);

        PersonMethods.getPopulation(csvParser.personList);
    }
}
