package com.rehman.timeline.helper;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import javax.persistence.Query;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EntityHelper {

    private static final Logger LOGGER = LoggerFactory.getLogger(EntityHelper.class);
    private static final String ERR_INVALID_ENTITY_ID = "invalid entity id: %d";
    private static final String NOT_AVAILABLE = "N/A";
    public static final String COMMA = ",";
    public static final String UNDERSCORE = "_";

    public static int getCountInBusinessEntity(Query countQuery) {
        Long o = (Long) countQuery.getSingleResult();
        if (o > Integer.MAX_VALUE) {
            throw new ArithmeticException("Value cannot fit in an int: " + o);
        }
        return o.intValue();
    }

    public static String generateRandomString (int length) {
        byte[] bytes = new byte[length];
        new Random().nextBytes(bytes);
        return Base64.getEncoder().encodeToString(bytes);
    }

    public static String generateRandomAlphaString(int length) {
        if (length < 0 )
            return "";

        String alphabeticalCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder builder = new StringBuilder();
        while (length-- != 0) {
            int character = (int)(Math.random()*alphabeticalCharacters.length());
            builder.append(alphabeticalCharacters.charAt(character));
        }
        return builder.toString();
    }

    public static boolean isFirstLongInStringGreater(String first, String second){
        Long firstLong = Long.parseLong(first);
        Long secondLong = Long.parseLong(second);
        return firstLong > secondLong;
    }

    public static boolean isFirstIntInStringGreater(String first, String second){
        Integer firstInt = Integer.parseInt(first);
        Integer secondInt = Integer.parseInt(second);
        return firstInt > secondInt;
    }

    public static <T> List<T> makeNotNull(List<T> list) {
        return list != null ? list : new ArrayList<T>();
    }

    public static void validateEntityId(int entityId) {
        if (entityId <= 0) {
            throw new IllegalArgumentException(String.format(ERR_INVALID_ENTITY_ID, entityId));
        }
    }

    public static boolean notNull(Object o) {
        return o != null;
    }

    public static boolean allNotNull(Object... o) {
        if (o == null) {
            return false;
        }
        for (Object o1 : o) {
            if (o1 == null) {
                return false;
            }
        }

        return true;
    }

    public static boolean anyNotNull(Object... o) {
        if (o == null) {
            return false;
        }
        for (Object o1 : o) {
            if (o1 != null) {
                return true;
            }
        }

        return false;
    }

    public static void validateEntityId(String entityId) {
        if ("".equals(entityId)) {
            throw new IllegalArgumentException(String.format(ERR_INVALID_ENTITY_ID, entityId));
        }
    }

    public static boolean notNullAndMoreZero(Integer value) {
        return (value != null) && (value > 0);
    }

    public static boolean isStringSet(String str) {
        return (str != null) && !str.isEmpty();
    }

    public static boolean isStringNotSet(String str) {
        return !isStringSet(str);
    }

    public static boolean doesStringContainOnlySpaces(String str){
        String nonSpaceString = str.replaceAll(" ", "");
        return nonSpaceString.length() == 0;
    }

    public static boolean isAnyNotSet(String... strs) {
        if (isNull(strs)) {
            return true;
        }
        for (String str : strs) {
            if (isStringNotSet(str)) {
                return true;
            }
        }
        return false;
    }

    public static String setDefaultStringIfEmptyOrNull(String str) {
        if ((str != null) && !str.isEmpty()) {
            return str;
        }
        return NOT_AVAILABLE;
    }

    public static Integer setDefaultIntegerIfEmptyOrNull(Integer val) {
        if (isIdSet(val)) {
            return val;
        }
        return -1;
    }

    public static boolean isIdSet(Integer... ids) {
        if (ids == null) {
            return false;
        }
        for (Integer id : ids) {
            if (!((id != null) && (id > 0))) {
                return false;
            }
        }

        return true;
    }

    public static String base64Encode(byte[] data) {
        return Base64.getEncoder().encodeToString(data);
    }

    public static String base64Decode(byte[] data) {
        return new String(Base64.getDecoder().decode(data));
    }

    public static boolean idIsSet(Integer... ids) {
        if (ids == null) {
            return false;
        }
        for (Integer id : ids) {
            if (!((id != null) && (id > 0))) {
                return false;
            }
        }

        return true;
    }

//    public static boolean isJsonNull(JsonElement jsonElement) {
//        return jsonElement.isJsonNull();
//    }

    public static boolean idIsNotSet(Integer... ids) {
        if (ids == null) {
            return false;
        }
        for (Integer id : ids) {
            if (isIdSet(id)) {
                return false;
            }
        }
        return true;
    }

    public static String getIdOrHyphen(Integer id) {
        return isIdSet(id) ? id.toString() : "-";
    }

    public static boolean isIdSet(String id) {
        return isStringSet(id);
    }

    public static boolean isSet(Boolean b) {
        return b != null && b.equals(Boolean.TRUE);
    }

    public static boolean isSet(String s) {
        return isIdSet(s);
    }

    public static boolean isSet(Integer i) {
        return isIdSet(i);
    }

    public static boolean isNull(Object o) {
        return o == null;
    }

    public static boolean isNotNull(Object o) {
        return !isNull(o);
    }

    public static boolean isNotNull(Object... o) {
        if (isNull(o))
            return false;
        for (Object o1 : o) {
            if (o1 == null) {
                return false;
            }
        }
        return true;
    }

    public static boolean anyNull(Object... os) {
        for (Object o : os) {
            if (o == null) {
                return true;
            }
        }
        return false;
    }

    public static boolean allNull(Object... os) {
        for (Object o : os) {
            if (o != null) {
                return false;
            }
        }
        return true;
    }

    public static <T> Set<T> toSet(List<T> list) {
        return list != null ? new LinkedHashSet<T>(list) : new LinkedHashSet<T>();
    }

    public static <T> List<T> toList(Collection<T> set) {
        return set != null ? new ArrayList<T>(set) : new ArrayList<T>();
    }

    public static <T> List<T> safeList(List<T> list) {
        return list == null ? Arrays.<T>asList() : list;
    }

    public static <T> Integer indexOf(Set<T> set, T o) {
        Integer i = 0;
        for (T t : set) {
            if (t.equals(o)) {
                return i;
            }
            i++;
        }
        return 0;
    }

    public static <T> void setOnHashSet(Set<T> set, T o, Integer position) {
        List<T> ts = new ArrayList<T>(set);
        ts.set(position, o);
        set = new HashSet<T>(ts);
    }

    public static boolean isSingleElementCollection(List<String> tails) {
        if (tails == null) {
            return false;
        }
        return tails.size() == 1;
    }

    public static Boolean isListPopulated(List<?> list) {
        return list != null && !list.isEmpty();
    }

    public static Boolean isSetPopulated(Set<?> set) {
        return set != null && !set.isEmpty();
    }

    public static boolean isMapPopulated(Map<?, ?> map) {
        return map != null && !map.isEmpty();
    }

    public static Boolean isListPopulatedNotNull(List<?> list) {
        if (list == null) {
            return Boolean.FALSE;
        }
        list.removeAll(Collections.singleton(null));
        return !list.isEmpty();
    }

    /*
	 * Remove duplicate objects from the supplied list maintaining the order of
	 * the elements
     */
    public static <T> List<T> removeDuplicates(List<T> list) {
        if (!CollectionUtils.isEmpty(list)) {
            Set<T> set = new LinkedHashSet<T>();
            set.addAll(list);
            list.clear();
            list.addAll(set);
        }
        return list;
    }

    public static Boolean isPageNumAndPageSizeSet(Integer pageNum, Integer pageSize) {
        return pageNum != null && pageNum >= 0 && pageSize != null && pageSize > 0;
    }

    /*
	 * Returns the full name in the format: firstName + middleName + lastName
     */
    public static String getPersonName(String firstName, String middleName, String lastName) {
        StringBuilder name = new StringBuilder();
        name.append(firstName);
        if (isSet(middleName)) {
            name.append(" ").append(middleName);
        }
        if (isSet(lastName)) {
            name.append(" ").append(lastName);
        }
        return name.toString();
    }

    /*
	 * Returns the rounded double to the specified number of decimal places
     */
    public static double round(double value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public static String getDateOfMonthSuffix(final int day) {
        if (day < 1 || day > 31) {
            throw new IllegalArgumentException(String.format("Illegal day of month %d.", day));
        }

        if (day >= 11 && day <= 13) {
            return "th";
        }
        switch (day) {
            case 1:
                return "st";
            case 2:
                return "nd";
            case 3:
                return "rd";
            default:
                return "th";
        }
    }

    public static Integer toInteger(Object obj) {
        if (obj != null) {
            if (obj instanceof BigDecimal) {
                return BigDecimal.class.cast(obj).intValue();
            }
        }
        return null;
    }


    public static List<String> allStringsToLower(List<String> list) {
        if (isNull(list)) {
            return safeList(null);
        }

        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i).toLowerCase());
        }

        return list;
    }

    public static List<String> allStringsTrim(List<String> list) {
        if (isNull(list)) {
            return safeList(null);
        }

        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i).trim());
        }

        return list;
    }



    public static boolean isBitOn(Object object) {
        return (isNotNull(object) && object.equals(1));
    }

    public static <T> String convertModelToJSONString(T tModelClass) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(tModelClass);
        } catch (Exception ex) {
            LOGGER.error("Unable to parse Model to JSON", ex);
        }
        return null;
    }

    public static <T> T convertJSONStringToModel(String jsonInString, Class<T> tClass) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(jsonInString, tClass);
        } catch (Exception ex) {
            LOGGER.error("Unable to parse JSON to Model", ex);
        }
        return null;
    }

    public static String getDurationInHours(Integer duration) {
        return Integer.toString(convertMinutesToHours(duration)) + " hours";
    }

    public static Integer convertMinutesToHours(Integer mins) {
        if (isNotNull(mins) && mins != 0) {
            return mins /= 60;
        }
        return 0;
    }

    /**
     * Supports till 20. Add more if needed
     *
     * @param number
     * @return
     */
    public static String numberToOrdinalWord(Integer number) {
        String[] ordinals = {"", "first", "second", "third", "fourth", "fifth", "sixth", "seventh", "eighth", "ninth",
                "tenth", "eleventh", "twelfth", "Thirteenth", "Fourteenth", "Fifteenth", "Sixteenth", "Seventeenth",
                "Eighteenth", "Nineteenth", "Twentieth",};

        return (number <= ordinals.length - 1) ? ordinals[number] : "";
    }

    public static List<String> convertMapToList(Map<String, String> map) {
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            list.add(entry.getKey());
            list.add(entry.getValue());
        }
        return list;
    }

    public static boolean isValueExistInToken(String tokenValue, String checkValue) {
        StringTokenizer stringTokenizer = new StringTokenizer(tokenValue, ",");
        boolean flag = false;
        while (stringTokenizer.hasMoreElements()) {
            if (checkValue.equals(stringTokenizer.nextElement())) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public static List<Integer> splitCommaSeparatedStringToListOfInteger(String s) {
        List<Integer> ints = new ArrayList<>();
        if (isNull(s)) {
            return ints;
        }
        String[] split = s.split(COMMA);
        for (String st : split) {
            ints.add(Integer.valueOf(st));
        }
        return ints;
    }

    public static <T> T getNonNullValue(T... ts) {
        for (T t : ts) {
            if (null != t) {
                return t;
            }
        }
        return null;
    }

    public static boolean anyNotSet(String... s) {
        if (s == null) {
            return true;
        }
        for (String s1 : s) {
            if (isStringNotSet(s1)) {
                return true;
            }
        }

        return false;
    }

    public static boolean isNotSet(String s) {
        return isStringNotSet(s);
    }


    public static <T>  List<T> splitCommaSeparatedStringToList(String s, Class<T> targetType) {
        List<T> list = new ArrayList<>();
        if (isNull(s)) {
            return list;
        }
        String[] splitArray = s.split(COMMA);
        for (String strValue : splitArray) {
            if(targetType.isAssignableFrom(String.class)){
                list.add((T) String.valueOf(strValue));
            }else if(targetType.isAssignableFrom(Integer.class)){
                list.add((T) Integer.valueOf(strValue));
            }
        }
        return list;
    }

    public static boolean isTrue(Boolean value) {
        if (EntityHelper.isNotNull(value)) {
            return value;
        }
        return false;
    }

    /**
     * This method will join a list of strings into a sentence format.
     * E.g [apple, banana, mango] will return "apple, banana and mango"
     * @param st list of string input
     * @return sentence format string
     */
    public static String joinWithCommaAndAnd(List<String> st) {
        String toReturn = "";
        int count = 1;
        for (String s: st) {
            toReturn += s;
            if (st.size() != count) {
                toReturn += (count == (st.size() - 1)) ? " and " : ", ";
            }
            count ++;
        }

        return toReturn;
    }

    public static String joingString(String... val) {
        StringBuilder builder = new StringBuilder("");
        if (val != null && val.length > 0) {
            for (int i = 0; i < val.length; i++) {
                if (EntityHelper.isStringSet(val[i]))
                    builder.append(val[i]);
            }
        }
        return builder.toString();
    }
    /**
     * selects random elements from collection
     * @param lst collection to select items from
     * @param n number of items to select
     * @return list of randomly selected n elements
     */
    public static <T> List<T> pickNRandom(Collection<T> lst, int n) {
        List<T> copy = new ArrayList<>(lst);
        if (lst.size() <= n)
            return copy;
        Collections.shuffle(copy);
        return copy.subList(0, n);
    }

    public static boolean isValidEmailAddress(String email) {

        Pattern emailAddressRegex = Pattern.compile("[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}\\@[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}(\\.[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25})+");
//        Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = emailAddressRegex.matcher(email);
        return matcher.find();
    }

    public static boolean isDoubleSetAndNonZero(Double d) {
        return isNotNull(d) && !d.equals(0d);
    }

    public static boolean isNumberSetAndNonZero(Number d) {
        return isNotNull(d) && !d.equals(0d);
    }

    public static boolean isValidLong (String num) {
        try {
            Long.parseLong(num);
        } catch (NumberFormatException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }
        return true;
    }

    public static byte[] toByteArray(InputStream is) throws IOException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        try {
            byte[] b = new byte[4096];
            boolean var3 = false;

            int n;
            while((n = is.read(b)) != -1) {
                output.write(b, 0, n);
            }

            byte[] var4 = output.toByteArray();
            return var4;
        } finally {
            output.close();
        }
    }

}
