package Random;

import java.util.ArrayList;
import java.util.List;


public class sample {
    public static void main(String[] args) {
        String input = "mpn007,\"mpn008,1\"";

        List<String> values = getValues(input);
        System.out.println("input: " + input);
//        List<String> values =  splitByCommaOutsideQuotes(input);
        System.out.println(values.size() + " " + values);
        List<String> ans =  new ArrayList<>();
//        for(String val : values){
//            ans.add(val.trim().replaceAll("^\"|\"$",""));
//        }
//
//        System.out.println(ans.size() + " " + ans);
    }


    private static List<String> getValues(String val){

        List<String> values = new ArrayList<>();
        List<String> result = new ArrayList<>();
        boolean inQuotes = false;
        StringBuilder sb = new StringBuilder();

        for (char c : val.toCharArray()) {
            if (c == '\"') {
                inQuotes = !inQuotes;
            } else if (c == ',' && !inQuotes) {
                result.add(sb.toString().trim());
                sb.setLength(0); // Clear the StringBuilder
                continue;
            }
            sb.append(c);
        }
        result.add(sb.toString().trim());

        for(String v : result){
            values.add(v.trim().replaceAll("^\"|\"$",""));
        }
        if(!values.isEmpty()){
            return values;
        }
        values.add(val);
        return values;
    }

    private static List<String> splitByCommaOutsideQuotes(String input) {
        List<String> result = new ArrayList<>();
        boolean inQuotes = false;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c == '\"') {
                // Toggle the inQuotes flag when encountering a quote
                inQuotes = !inQuotes;
            }

            if (c == ',' && !inQuotes) {
                // If we encounter a comma outside of quotes, it's a split point
                result.add(sb.toString().trim());
                sb.setLength(0); // Clear the StringBuilder
            } else {
                sb.append(c); // Add the current character to the segment
            }
        }

        // Add the last segment to the result list
        result.add(sb.toString().trim());

        // Remove surrounding quotes from each element in the result list
        for (int i = 0; i < result.size(); i++) {
            result.set(i, result.get(i).replaceAll("^\"|\"$", ""));
        }
        return result;
    }

//    private static List<String> getValues(String val){
//
//
//        List<String> values = new ArrayList<>();
//        String[] tokens = val.split(",(?![^\\\"]*\\\")");
//
//        for (String token : tokens) {
//            // Remove any enclosing double quotes from each token
//            values.add(token.replaceAll("^\"|\"$", ""));
//        }
//
//        List<String> finalValues = new ArrayList<>();
//
//        for(String v : values) {
////            if (StringUtils.isNotBlank(val) && (val.contains("\"") || val.contains("'"))) {
//                String pattern = "\"(.*?)\"";
//
//                // Compile the pattern
//                Pattern p = Pattern.compile(pattern);
//
//                // Match the pattern against the input string
//                Matcher m = p.matcher(v);
//
//                // Find all matches and extract the contents between quotes
//                while (m.find()) {
//                    finalValues.add(m.group(1)); // Extract the content between quote
//                }
////            }
//        }
//        if (!values.isEmpty()) {
//            return values;
//        }
//        values.add(val);
//        return values;
//    }
}
