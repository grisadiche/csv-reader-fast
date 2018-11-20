import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PersonMethods {
    public enum Attribute {
        NAME("Name"),
        AGE("Age"),
        CITY("City"),
        STATE("State"),
        ZIPCODE("ZipCode"),
        INDUSTRY("Industry"),
        SEARCHING("Searching"),
        ALL("All");

        private String attribute;

        Attribute(String attString) {
            this.attribute = attString;
        }
    }

    public static List<String> attributeList = Stream.of(Attribute.values())
            .map(Attribute::name)
            .collect(Collectors.toList());


    public static HashMap<String, Integer> createMap() {
        HashMap<String, Integer> categoryMap = new HashMap<>();
        return categoryMap;
    }

    public static void addToMap(HashMap<String, Integer> mapCount, String string) {
        if (!mapCount.containsKey(string)) {
            mapCount.put(string, 1);
        } else {
            mapCount.put(string, mapCount.get(string) + 1);
        }
    }

    public static HashMap maxFreqMap(HashMap<String, Integer> mapList) {
        HashMap<String, Integer> maxMap = new HashMap<>();
        if (mapList.isEmpty()) {
            System.out.println("mapList is empty!");
            maxMap.put("error", 0);
        } else {
            int maxValueHash = Collections.max(mapList.values());

            for (Map.Entry<String, Integer> entry : mapList.entrySet()) {
                if (entry.getValue() == maxValueHash) {
                    maxMap.put(entry.getKey(), maxValueHash);
                }
            }
        }
        return maxMap;
    }

    public static HashMap minFreqMap(HashMap<String, Integer> mapList) {
        HashMap<String, Integer> minMap = new HashMap<>();
        if (mapList.isEmpty()) {
            System.out.println("mapList is empty!");
            minMap.put("error", 0);
        } else {
            int minValueHash = Collections.min(mapList.values());

            for (Map.Entry<String, Integer> entry : mapList.entrySet()) {
                if (entry.getValue() == minValueHash) {
                    minMap.put(entry.getKey(), minValueHash);
                }
            }
        }
        return minMap;
    }

    public static Person getMaxAge(ArrayList<Person> personList) {
        if (personList.size() > 0) {
                    int ageMax = Collections.max(csvParser.ageList);
                    int maxIndex = 0;
                    maxIndex = csvParser.ageList.indexOf(ageMax);
                    return personList.get(maxIndex);

        } else {
            System.out.println("***The arraylist of persons is empty, check that CsvParse is run***");
            Person errorPerson = new Person();
            return errorPerson;
        }
    }

    public static Person getMinAge(ArrayList<Person> personList) {
        if (personList.size() > 0) {
                    int ageMin = Collections.min(csvParser.ageList);
                    int minIndex = 0;
                    minIndex = csvParser.ageList.indexOf(ageMin);
                    return personList.get(minIndex);
            } else {
            System.out.println("***The arraylist of persons is empty, check that CsvParse is run***");
            Person errorPerson = new Person();
            return errorPerson;
        }
    }

    public static ArrayList<Person> filter(ArrayList<Person> personList, Attribute filterKey, String searchString) { //method to create filtered arraylist
        ArrayList<Person> returnArray = new ArrayList<>(personList);
        Predicate<Person> valueFilter = new Predicate<Person>() {
            @Override
            public boolean test(Person person) {
                return false;
            }
        };
        switch (filterKey) {
            case NAME:
                valueFilter = person -> !person.getName().equalsIgnoreCase(searchString);
                break;
            case AGE:
                valueFilter = person -> !Integer.toString(person.getAge()).equalsIgnoreCase(searchString);
                break;
            case CITY:
                valueFilter = person -> !person.getCity().equalsIgnoreCase(searchString);
                break;
            case STATE:
                valueFilter = person -> !person.getState().equalsIgnoreCase(searchString);
                break;
            case ZIPCODE:
                valueFilter = person -> !Integer.toString(person.getZipCode()).equalsIgnoreCase(searchString);
                break;
            case INDUSTRY:
                valueFilter = person -> !person.getIndustry().equalsIgnoreCase(searchString);
                break;
            case SEARCHING:
                valueFilter = person -> !String.valueOf(person.getSearching()).equalsIgnoreCase(searchString);
                break;
            default:
                System.out.println("Please choose one of the categories: name, age, city, state, zipcode, industry, or searching");
                break;

        }

        returnArray.removeIf(valueFilter);
        return returnArray;
    }

    public static ArrayList<Object> transform(ArrayList<Person> personList, Attribute transformKey) { //transforms an arraylist of people into just their values
        ArrayList<Object> returnArray = new ArrayList<>();
        for (int i = 0; i < personList.size(); i++) {
            switch (transformKey) {
                case NAME:
                    returnArray.add(personList.get(i).getName());
                    break;
                case AGE:
                    returnArray.add(Integer.toString(personList.get(i).getAge()));
                    break;
                case CITY:
                    returnArray.add(personList.get(i).getCity());
                    break;
                case STATE:
                    returnArray.add(personList.get(i).getState());
                    break;
                case ZIPCODE:
                    returnArray.add(Integer.toString(personList.get(i).getZipCode()));
                    break;
                case INDUSTRY:
                    returnArray.add(personList.get(i).getName());
                    break;
                case SEARCHING:
                    returnArray.add(String.valueOf(personList.get(i).getName()));
                    break;
                case ALL:
                    returnArray.add(personList.get(i));
                    break;
                default:
                    System.out.println("Please enter a valid attribute to list by, or choose all.");
                    break;

            }
        }
        return returnArray;
    }

    private static HashMap chooseMap(Attribute attribute) {
        HashMap <String, Integer> returnMap = new HashMap();
        switch (attribute) {
            case NAME:
                returnMap = csvParser.mapLists.get(0);
            break;
            case AGE:
                returnMap = csvParser.mapLists.get(1);
                break;
            case CITY:
                returnMap = csvParser.mapLists.get(2);
                break;
            case STATE:
                returnMap = csvParser.mapLists.get(3);
                break;
            case ZIPCODE:
                returnMap = csvParser.mapLists.get(4);
            break;
            case INDUSTRY:
                returnMap = csvParser.mapLists.get(5);
            break;
            case SEARCHING:
                returnMap = csvParser.mapLists.get(6);
            break;
        }
        return returnMap;
    }

        public static void getPopulation (ArrayList < Person > personList) {


            Scanner reader = new Scanner(System.in);

            System.out.println("Which attribute would you like to sort by? (name, age, city, state, zipcode, industry, searching)");
            String listValue = reader.nextLine();
            if (!attributeList.contains(listValue.toUpperCase())) {
                System.out.println("\n\n***Please enter an attribute to sort by. Restart Program \n\n");
                getPopulation(personList);
                return;
            }
            Attribute listAttribute = Attribute.valueOf(listValue.toUpperCase());
            System.out.println(chooseMap(listAttribute));

            System.out.println("Which value would you like to sort by? Choose a specific value from the list above");
            String categoryValue = reader.nextLine();
            if (categoryValue.length() == 0 || !chooseMap(listAttribute).keySet().toString().toUpperCase().contains(categoryValue.toUpperCase())) {
                System.out.println("\n\n***Please enter a value to sort by. Restart program.\n\n");
                getPopulation(personList);
                return;
            }

            System.out.println("Choose what attributes to list. (name, age, etc... or all)");
            String displayList = reader.nextLine();
            if (!attributeList.contains(displayList.toUpperCase())) {
                System.out.println("\n\n***Please enter an attribute to list. Restart Program. \n\n");
                getPopulation(personList);
                return;
            }
            Attribute displayAttribute = Attribute.valueOf(displayList.toUpperCase());

            System.out.println(transform(filter(personList, listAttribute, categoryValue), displayAttribute));            //uses transform and filter methods

            System.out.println("\n\nWould you like to search again? (Yes or No?)");
            String wantRestart = reader.nextLine();
            if (wantRestart.equalsIgnoreCase("yes")) {
                getPopulation(personList);
            }

            reader.close();

        }
    }

